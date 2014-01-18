using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;

using Microsoft.Kinect;

using Coding4Fun.Kinect.Wpf;

namespace SkeletonAndRGBTest
{
    public partial class MainWindow : Window
    {
        private KinectSensor kinect;

        private WriteableBitmap colorBitmap;
        private byte[] colorPixels;

        private Skeleton[] skeletonData;

        public MainWindow()
        {
            InitializeComponent();
        }

        private void Window_Loaded(object sender, RoutedEventArgs e)
        {
            SetupKinect();
        }

        private void SetupKinect()
        {
            foreach (var potentialSensor in KinectSensor.KinectSensors)
            {
                if (potentialSensor.Status == KinectStatus.Connected)
                {
                    this.kinect = potentialSensor;
                    break;
                }
            }

            if (kinect != null)
            {
                kinect.ColorStream.Enable();
                colorPixels = new byte[kinect.ColorStream.FramePixelDataLength];
                colorBitmap = new WriteableBitmap(kinect.ColorStream.FrameWidth, kinect.ColorStream.FrameHeight, 96.0f, 96.0f, PixelFormats.Bgr32, null);
                Image.Source = colorBitmap;
                kinect.ColorFrameReady += kinect_ColorFrameReady;

                kinect.SkeletonStream.Enable();

                skeletonData = new Skeleton[kinect.SkeletonStream.FrameSkeletonArrayLength];

                kinect.SkeletonFrameReady += new EventHandler<SkeletonFrameReadyEventArgs>(kinect_SkeletonFrameReady);

                kinect.Start();
            }
        }

        private void kinect_ColorFrameReady(object sender, ColorImageFrameReadyEventArgs e)
        {
            ColorImageFrame colorFrame = e.OpenColorImageFrame();

            if (colorFrame != null)
            {
                colorFrame.CopyPixelDataTo(this.colorPixels);

                colorBitmap.WritePixels(new Int32Rect(0, 0, colorBitmap.PixelWidth, colorBitmap.PixelHeight),
                    colorPixels, colorBitmap.PixelWidth * sizeof(int), 0);
            }
        }

        private void kinect_SkeletonFrameReady(object sender, SkeletonFrameReadyEventArgs e)
        {
            SkeletonFrame skeletonFrame = e.OpenSkeletonFrame();
            List<Skeleton> activeSkeletons = new List<Skeleton>();

            if (skeletonFrame != null && skeletonData != null)
            {
                skeletonFrame.CopySkeletonDataTo(skeletonData);
            }

            foreach (Skeleton skel in skeletonData)
            {
                if (skel.TrackingState == SkeletonTrackingState.Tracked)
                {
                    activeSkeletons.Add(skel);
                }
            }

            for (int i = 0; i < activeSkeletons.Count; i++)
            {
                if (i == 0)
                {
                    SetEllipsePosition(leftEllipse, activeSkeletons[i].Joints[JointType.HandLeft]);
                    SetEllipsePosition(rightEllipse, activeSkeletons[i].Joints[JointType.HandRight]);
                    SetEllipsePosition(footEllipse, activeSkeletons[i].Joints[JointType.HipCenter]);
                }
                if (i == 1)
                {
                    SetEllipsePosition(leftEllipse2, activeSkeletons[i].Joints[JointType.HandLeft]);
                    SetEllipsePosition(rightEllipse2, activeSkeletons[i].Joints[JointType.HandRight]);
                    SetEllipsePosition(footEllipse2, activeSkeletons[i].Joints[JointType.HipCenter]);
                }
            }
        }

        private void SetEllipsePosition(FrameworkElement ellipse, Joint joint)
        {
            var scaledJoint = joint.ScaleTo(640, 480, 1.0f, 1.0f);

            Canvas.SetLeft(ellipse, scaledJoint.Position.X);
            Canvas.SetTop(ellipse, scaledJoint.Position.Y);
            ellipse.Width = Math.Abs(3 - scaledJoint.Position.Z) * 50;
            ellipse.Height = Math.Abs(3 - scaledJoint.Position.Z) * 50;
        }

        private void Window_Closing(object sender, System.ComponentModel.CancelEventArgs e)
        {
            if (kinect != null)
            {
                kinect.Stop();
            }
        }    
    }
}

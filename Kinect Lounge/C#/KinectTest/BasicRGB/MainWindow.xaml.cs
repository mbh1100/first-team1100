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

namespace BasicRGB
{
    public partial class MainWindow : Window
    {
        private KinectSensor kinect;

        private WriteableBitmap colorBitmap;

        private byte[] colorPixels;

        public MainWindow()
        {
            InitializeComponent();
        }

        private void Window_Loaded(object sender, RoutedEventArgs e)
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

        private void Window_Closing(object sender, System.ComponentModel.CancelEventArgs e)
        {
            if (kinect != null)
            {
                kinect.Stop();
            }
        }
    }
}

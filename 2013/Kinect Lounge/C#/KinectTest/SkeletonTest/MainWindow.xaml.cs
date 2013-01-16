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
using SwipeGestureTest;
using System.Diagnostics;

namespace SkeletonTest
{
    public partial class MainWindow : Window
    {
        private const float RenderWidth = 640.0f;
        private const float RenderHeight = 480.0f;

        private const double JointThickness = 4.0;

        private const double BodyCenterThickness = 10;
        private const double ClipBoundsThickness = 10;

        private Brush centerPointBrush = Brushes.Blue;

        private Brush trackedJointBrush = Brushes.Green;

        private Brush inferredJointBrush = Brushes.Yellow;

        private Pen trackedBonePen = new Pen(Brushes.Purple, 6);

        private Pen inferredBonePen = new Pen(Brushes.LightSalmon, 1);

        private KinectSensor kinect;

        private DrawingGroup drawingGroup;

        private DrawingImage imageSource;

        private GestureController gestureController;

        private Skeleton DebugSkel;

        public MainWindow()
        {
            InitializeComponent();
        }

        private static void RenderClippedEdges(Skeleton skeleton, DrawingContext drawingContext)
        {
            if (skeleton.ClippedEdges.HasFlag(FrameEdges.Bottom))
            {
                drawingContext.DrawRectangle(Brushes.Red, null,
                    new Rect(0, RenderHeight - ClipBoundsThickness, RenderWidth, ClipBoundsThickness));
            }

            if (skeleton.ClippedEdges.HasFlag(FrameEdges.Top))
            {
                drawingContext.DrawRectangle(Brushes.Red, null,
                    new Rect(0, 0, RenderWidth, ClipBoundsThickness));
            }

            if (skeleton.ClippedEdges.HasFlag(FrameEdges.Right))
            {
                drawingContext.DrawRectangle(Brushes.Red, null,
                    new Rect(RenderWidth - ClipBoundsThickness, 0, ClipBoundsThickness, RenderHeight));
            }

            if (skeleton.ClippedEdges.HasFlag(FrameEdges.Left))
            {
                drawingContext.DrawRectangle(Brushes.Red, null,
                    new Rect(0, 0, ClipBoundsThickness, RenderHeight));
            }
        }

        private void Window_Loaded(object sender, RoutedEventArgs e)
        {
            drawingGroup = new DrawingGroup();

            imageSource = new DrawingImage(drawingGroup);

            Image.Source = imageSource;

            SetupKinect();
        }

        private void SetupKinect()
        {
            foreach (var potentialKinect in KinectSensor.KinectSensors)
            {
                if (potentialKinect.Status == KinectStatus.Connected)
                {
                    kinect = potentialKinect;
                    break;
                }
            }

            if (kinect != null)
            {
                kinect.SkeletonStream.Enable();

                kinect.SkeletonFrameReady += kinect_SkeletonFrameReady;

                gestureController = new GestureController();
                gestureController.GestureRecognized += gestureController_GestureRecognized;
                gestureController.AddGesture(new SwipeGestureTest.Segments.DoubleSwipeDown());
                gestureController.AddGesture(new SwipeGestureTest.Segments.DoubleSwipeUp());
                //gestureController.AddGesture(new SwipeGestureTest.Segments.SwipeLeftDefinition());
                //gestureController.AddGesture(new SwipeGestureTest.Segments.SwipeRightDefinition());

                kinect.Start();
                kinect.ElevationAngle = 5;
            }
        }

        void gestureController_GestureRecognized(object sender, GestureEventArgs e)
        {
            Title = e.gestureType.ToString();

            switch (e.gestureType)
            {
                case GestureType.DoubleSwipeDown:
                    kinect.ElevationAngle -= 4;
                    if (kinect.ElevationAngle < kinect.MinElevationAngle) { kinect.ElevationAngle = kinect.MinElevationAngle; }
                    trackedBonePen.Brush = Brushes.Red;
                    break;
                case GestureType.DoubleSwipeUp:
                    kinect.ElevationAngle += 4;
                    if (kinect.ElevationAngle > kinect.MaxElevationAngle) { kinect.ElevationAngle = kinect.MaxElevationAngle; }
                    trackedBonePen.Brush = Brushes.Blue;
                    break;
                case GestureType.SwipeLeft:
                    trackedBonePen.Brush = Brushes.Pink;
                    break;
                case GestureType.SwipeRight:
                    trackedBonePen.Brush = Brushes.Orange;
                    break;
            }
        }

        void kinect_SkeletonFrameReady(object sender, SkeletonFrameReadyEventArgs e)
        {
            SkeletonFrame skeletonFrame = e.OpenSkeletonFrame();

            Skeleton[] skeletonData = new Skeleton[0];

            if(skeletonFrame != null)
            {
                skeletonData = new Skeleton[skeletonFrame.SkeletonArrayLength];
                skeletonFrame.CopySkeletonDataTo(skeletonData);
                skeletonFrame.Dispose();
            }

            using (DrawingContext dc = this.drawingGroup.Open())
            {
                if (dc != null)
                {
                    dc.DrawRectangle(Brushes.Black, null, new Rect(0.0, 0.0, RenderWidth, RenderHeight));

                    if (skeletonData.Length > 0)
                    {
                        foreach (Skeleton skel in skeletonData)
                        {
                            RenderClippedEdges(skel, dc);

                            if (skel.TrackingState == SkeletonTrackingState.Tracked)
                            {
                                gestureController.UpdateAllGestures(skel);
                                DrawBonesAndJoints(skel, dc);
                                DebugSkel = skel;
                            }
                            else if (skel.TrackingState == SkeletonTrackingState.PositionOnly)
                            {
                                dc.DrawEllipse(
                                    centerPointBrush,
                                    null,
                                    SkeletonPointToScreen(skel.Position),
                                    BodyCenterThickness,
                                    BodyCenterThickness);
                            }
                        }
                    }

                    drawingGroup.ClipGeometry = new RectangleGeometry(new Rect(0.0, 0.0, RenderWidth, RenderHeight));
                }
            }
        }

        private void DrawBonesAndJoints(Skeleton skel, DrawingContext dc)
        {

            DrawBone(skel, dc, JointType.Head, JointType.ShoulderCenter);
            DrawBone(skel, dc, JointType.ShoulderCenter, JointType.ShoulderLeft);
            DrawBone(skel, dc, JointType.ShoulderCenter, JointType.ShoulderRight);
            DrawBone(skel, dc, JointType.ShoulderCenter, JointType.Spine);
            DrawBone(skel, dc, JointType.Spine, JointType.HipCenter);
            DrawBone(skel, dc, JointType.HipCenter, JointType.HipLeft);
            DrawBone(skel, dc, JointType.HipCenter, JointType.HipRight);

            DrawBone(skel, dc, JointType.ShoulderLeft, JointType.ElbowLeft);
            DrawBone(skel, dc, JointType.ElbowLeft, JointType.WristLeft);
            DrawBone(skel, dc, JointType.WristLeft, JointType.HandLeft);

            DrawBone(skel, dc, JointType.ShoulderRight, JointType.ElbowRight);
            DrawBone(skel, dc, JointType.ElbowRight, JointType.WristRight);
            DrawBone(skel, dc, JointType.WristRight, JointType.HandRight);

            DrawBone(skel, dc, JointType.HipLeft, JointType.KneeLeft);
            DrawBone(skel, dc, JointType.KneeLeft, JointType.AnkleLeft);
            DrawBone(skel, dc, JointType.AnkleLeft, JointType.FootLeft);

            DrawBone(skel, dc, JointType.HipRight, JointType.KneeRight);
            DrawBone(skel, dc, JointType.KneeRight, JointType.AnkleRight);
            DrawBone(skel, dc, JointType.AnkleRight, JointType.FootRight);

            foreach (Joint joint in skel.Joints)
            {
                Brush drawBrush = null;

                if (joint.TrackingState == JointTrackingState.Tracked)
                {
                    drawBrush = trackedJointBrush;
                }

                if (joint.TrackingState == JointTrackingState.Inferred)
                {
                    drawBrush = inferredJointBrush;
                }

                if (drawBrush != null)
                {
                    dc.DrawEllipse(drawBrush, null, SkeletonPointToScreen(joint.Position), JointThickness, JointThickness);
                }
            }
        }

        private void DrawBone(Skeleton skel, DrawingContext dc, JointType jointType0, JointType jointType1)
        {
            Joint joint0 = skel.Joints[jointType0];
            Joint joint1 = skel.Joints[jointType1];

            if (joint0.TrackingState == JointTrackingState.NotTracked || joint1.TrackingState == JointTrackingState.NotTracked)
            {
                return;
            }

            Pen drawPen = inferredBonePen;
            if (joint0.TrackingState == JointTrackingState.Tracked && joint1.TrackingState == JointTrackingState.Tracked)
            {
                drawPen = trackedBonePen;
            }

            dc.DrawLine(drawPen, SkeletonPointToScreen(joint0.Position), SkeletonPointToScreen(joint1.Position));
        }

        private Point SkeletonPointToScreen(SkeletonPoint skelPoint)
        {
            DepthImagePoint depthPoint = kinect.CoordinateMapper.MapSkeletonPointToDepthPoint(skelPoint, DepthImageFormat.Resolution640x480Fps30);
            return new Point(depthPoint.X, depthPoint.Y);
        }

        private void Window_Closing(object sender, System.ComponentModel.CancelEventArgs e)
        {
            if (kinect != null)
            {
                kinect.Stop();
            }
        }
        private void ButtonScreenshotClick(object sender, RoutedEventArgs e)
        {
            if (DebugSkel != null)
            {
                SkeletonPoint point1 = DebugSkel.Joints[JointType.HandRight].Position;
                SkeletonPoint point2 = DebugSkel.Joints[JointType.ShoulderRight].Position;
                Debug.WriteLine(Math.Abs(point1.X - point2.X));
                Debug.WriteLine("Hand: " + point1.X + "," + point1.Y + "," + point1.Z + "   Shoulder: " + point2.X + ", " + point2.Y + ", " + point2.Z);
            }
        }
    }
}

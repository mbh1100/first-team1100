using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using Microsoft.Kinect;

namespace GestureService2.Segments
{
    public class DoubleSwipeUp : GestureDefinition
    {
        public DoubleSwipeUp()
        {
            gestureParts = new IRelativeGestureSegment[3];
            gestureParts[0] = new DoubleSwipeUpSegment1();
            gestureParts[1] = new DoubleSwipeUpSegment2();
            gestureParts[2] = new DoubleSwipeUpSegment3();

            gestureType = GestureType.DoubleSwipeUp;
        }
    }

    class DoubleSwipeUpSegment1 : IRelativeGestureSegment
    {
        public GesturePieceResult CheckGesture(Skeleton skel)
        {
            if (Math.Abs(skel.Joints[JointType.HandRight].Position.X - skel.Joints[JointType.ShoulderRight].Position.X) < 0.2 &&
                Math.Abs(skel.Joints[JointType.HandLeft].Position.X - skel.Joints[JointType.ShoulderLeft].Position.X) < 0.2 &&
                skel.Joints[JointType.HandRight].Position.X > skel.Joints[JointType.ShoulderCenter].Position.X &&
                skel.Joints[JointType.HandLeft].Position.X < skel.Joints[JointType.ShoulderCenter].Position.X &&
                skel.Joints[JointType.HandRight].Position.Y < skel.Joints[JointType.ShoulderRight].Position.Y &&
                skel.Joints[JointType.HandLeft].Position.Y < skel.Joints[JointType.ShoulderLeft].Position.Y)
            {
                if (skel.Joints[JointType.HandRight].Position.Y > skel.Joints[JointType.HipCenter].Position.Y &&
                    skel.Joints[JointType.HandLeft].Position.Y > skel.Joints[JointType.HipCenter].Position.Y)
                {
                    return GesturePieceResult.Succeed;
                }
                return GesturePieceResult.Pending;
            }
            return GesturePieceResult.Fail;
        }
    }

    class DoubleSwipeUpSegment2 : IRelativeGestureSegment
    {
        public GesturePieceResult CheckGesture(Skeleton skel)
        {
            if (Math.Abs(skel.Joints[JointType.HandRight].Position.X - skel.Joints[JointType.ShoulderRight].Position.X) < 0.2 &&
                Math.Abs(skel.Joints[JointType.HandLeft].Position.X - skel.Joints[JointType.ShoulderLeft].Position.X) < 0.2 &&
                skel.Joints[JointType.HandRight].Position.X > skel.Joints[JointType.ShoulderCenter].Position.X &&
                skel.Joints[JointType.HandLeft].Position.X < skel.Joints[JointType.ShoulderCenter].Position.X)
            {
                if (skel.Joints[JointType.HandRight].Position.Y < skel.Joints[JointType.HipRight].Position.Y &&
                    skel.Joints[JointType.HandLeft].Position.Y < skel.Joints[JointType.HipLeft].Position.Y)
                {
                    return GesturePieceResult.Succeed;
                }
                return GesturePieceResult.Pending;
            }
            return GesturePieceResult.Fail;
        }
    }

    class DoubleSwipeUpSegment3 : IRelativeGestureSegment
    {
        public GesturePieceResult CheckGesture(Skeleton skel)
        {
            if (Math.Abs(skel.Joints[JointType.HandRight].Position.X - skel.Joints[JointType.ShoulderRight].Position.X) < 0.2 &&
                Math.Abs(skel.Joints[JointType.HandLeft].Position.X - skel.Joints[JointType.ShoulderLeft].Position.X) < 0.2 &&
                skel.Joints[JointType.HandRight].Position.X > skel.Joints[JointType.ShoulderCenter].Position.X &&
                skel.Joints[JointType.HandLeft].Position.X < skel.Joints[JointType.ShoulderCenter].Position.X)
            {
                if (skel.Joints[JointType.HandRight].Position.Y > skel.Joints[JointType.Head].Position.Y &&
                    skel.Joints[JointType.HandLeft].Position.Y > skel.Joints[JointType.Head].Position.Y)
                {
                    return GesturePieceResult.Succeed;
                }
                return GesturePieceResult.Pending;
            }
            return GesturePieceResult.Fail;
        }
    }
}

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Microsoft.Kinect;

namespace GestureService.GestureDefinitions
{
    public class SwipeLeftDefinition : GestureDefinition
    {
        public SwipeLeftDefinition()
        {
            gestureParts = new IRelativeGestureSegment[2];
            gestureParts[0] = new SwipeLeftSegment1();
            gestureParts[1] = new SwipeLeftSegment2();

            gestureType = GestureType.SwipeLeft;
        }
    }

    class SwipeLeftSegment1 : IRelativeGestureSegment
    {
        public GesturePieceResult CheckGesture(Skeleton skel)
        {
            if (skel.Joints[JointType.HandRight].Position.Z < skel.Joints[JointType.ShoulderRight].Position.Z)
            {
                if (skel.Joints[JointType.HandRight].Position.X > skel.Joints[JointType.ShoulderCenter].Position.X)
                {
                    return GesturePieceResult.Succeed;
                }
                return GesturePieceResult.Pending;
            }
            return GesturePieceResult.Fail;
        }
    }

    class SwipeLeftSegment2 : IRelativeGestureSegment
    {
        public GesturePieceResult CheckGesture(Skeleton skel)
        {
            if (skel.Joints[JointType.HandRight].Position.Z < skel.Joints[JointType.ShoulderRight].Position.Z)
            {
                if (skel.Joints[JointType.HandRight].Position.X < skel.Joints[JointType.ShoulderCenter].Position.X)
                {
                    return GesturePieceResult.Succeed;
                }
                return GesturePieceResult.Pending;
            }
            return GesturePieceResult.Fail;
        }
    }
}

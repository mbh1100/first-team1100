using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using Microsoft.Kinect;

namespace GestureService.GestureDefinitions
{
    public class SwipeRightDefinition : GestureDefinition
    {
        public SwipeRightDefinition()
        {
            gestureParts = new IRelativeGestureSegment[2];
            gestureParts[0] = new SwipeRightSegment1();
            gestureParts[1] = new SwipeRightSegment2();

            gestureType = GestureType.SwipeRight;
        }
    }

    class SwipeRightSegment1 : IRelativeGestureSegment
    {
        public GesturePieceResult CheckGesture(Skeleton skel)
        {
            if (skel.Joints[JointType.HandLeft].Position.Z < skel.Joints[JointType.ShoulderLeft].Position.Z)
            {
                if (skel.Joints[JointType.HandLeft].Position.X < skel.Joints[JointType.ShoulderCenter].Position.X)
                {
                    return GesturePieceResult.Succeed;
                }
                return GesturePieceResult.Pending;
            }
            return GesturePieceResult.Fail;
        }
    }

    class SwipeRightSegment2 : IRelativeGestureSegment
    {
        public GesturePieceResult CheckGesture(Skeleton skel)
        {
            if (skel.Joints[JointType.HandLeft].Position.Z < skel.Joints[JointType.ShoulderLeft].Position.Z)
            {
                if (skel.Joints[JointType.HandLeft].Position.X > skel.Joints[JointType.ShoulderCenter].Position.X)
                {
                    return GesturePieceResult.Succeed;
                }
                return GesturePieceResult.Pending;
            }
            return GesturePieceResult.Fail;
        }
    }
}

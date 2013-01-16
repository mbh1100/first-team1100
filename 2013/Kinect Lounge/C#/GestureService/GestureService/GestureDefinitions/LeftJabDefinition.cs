using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using Microsoft.Kinect;

namespace GestureService.GestureDefinitions
{
    public class LeftJabDefinition : GestureDefinition_TimeDependent
    {
        public LeftJabDefinition()
        {
            gestureParts = new IRelativeGestureSegment[2];
            gestureParts[0] = new SwipeLeftSegment1();
            gestureParts[1] = new SwipeLeftSegment2();

            gestureType = GestureType.SwipeLeft;
        }
    }

    class LeftJabSegment1 : IRelativeGestureSegment
    {
        public GesturePieceResult CheckGesture(Skeleton skel)
        {
            if (skel.Joints[JointType.HandLeft].Position.Z < skel.Joints[JointType.ShoulderLeft].Position.Z && 
                skel.Joints[JointType.HandLeft].Position.X > skel.Joints[JointType.ElbowLeft].Position.X)
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

    class LeftJabSegment2 : IRelativeGestureSegment
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
}

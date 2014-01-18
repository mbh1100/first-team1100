using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Microsoft.Kinect;
using System.Diagnostics;

namespace GestureService2.Segments
{
    public class RoundToHeadDefinition : GestureDefinition
    {
        public RoundToHeadDefinition()
        {
            gestureParts = new IRelativeGestureSegment[3];
            gestureParts[0] = new RoundToHeadSegment1();
            gestureParts[1] = new RoundToHeadSegment2();
            gestureParts[2] = new RoundToHeadSegment3();
            gestureType = GestureType.RoundToHead;
        }
    }

    class RoundToHeadSegment1 : IRelativeGestureSegment
    {
        public GesturePieceResult CheckGesture(Skeleton skel)
        {
            if (skel.Joints[JointType.HandRight].Position.X > skel.Joints[JointType.ShoulderCenter].Position.X)
            {
                if (Math.Abs(skel.Joints[JointType.HandRight].Position.X - skel.Joints[JointType.ShoulderRight].Position.X) > 0.45 && 
                    skel.Joints[JointType.HandRight].Position.X > skel.Joints[JointType.ElbowRight].Position.X &&
                    skel.Joints[JointType.HandRight].Position.X > skel.Joints[JointType.ShoulderRight].Position.X)
                {
                    return GesturePieceResult.Succeed;
                }
                return GesturePieceResult.Pending;
            }
            return GesturePieceResult.Fail;
        }
    }

    class RoundToHeadSegment2 : IRelativeGestureSegment
    {
        public GesturePieceResult CheckGesture(Skeleton skel)
        {
            if (skel.Joints[JointType.ElbowRight].Position.Y > skel.Joints[JointType.ShoulderRight].Position.Y - 0.1 )
            {
                if (skel.Joints[JointType.HandRight].Position.Y > skel.Joints[JointType.Head].Position.Y)
                {
                    return GesturePieceResult.Succeed;
                }
                return GesturePieceResult.Pending;
            }
            return GesturePieceResult.Fail;
        }
    }

    class RoundToHeadSegment3 : IRelativeGestureSegment
    {
        public GesturePieceResult CheckGesture(Skeleton skel)
        {
            if (skel.Joints[JointType.ElbowRight].Position.X > skel.Joints[JointType.ShoulderRight].Position.X)
            {
               if (GestureMath.GetDistanceBetweenPoints(skel.Joints[JointType.HandRight].Position.X, skel.Joints[JointType.HandRight].Position.Y, skel.Joints[JointType.HandRight].Position.Z,
                    skel.Joints[JointType.Head].Position.X, skel.Joints[JointType.Head].Position.Y, skel.Joints[JointType.Head].Position.Z) < 0.2)
                {
                    return GesturePieceResult.Succeed;
                }
                return GesturePieceResult.Pending;
            }
            return GesturePieceResult.Fail;
        }
    }
}

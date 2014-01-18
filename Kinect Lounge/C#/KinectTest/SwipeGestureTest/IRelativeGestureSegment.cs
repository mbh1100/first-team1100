using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using Microsoft.Kinect;

namespace GestureService2
{
    public interface IRelativeGestureSegment
    {
        GesturePieceResult CheckGesture(Skeleton skeleton);
    }
}

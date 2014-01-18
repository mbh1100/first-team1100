using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace GestureService2
{
    public enum GesturePieceResult
    {
        Fail,
        Succeed,
        Pending
    }

    public enum GestureType
    {
        None,
        SwipeLeft,
        SwipeRight,
        RoundToHead,
        DoubleSwipeUp,
        DoubleSwipeDown
    }
}
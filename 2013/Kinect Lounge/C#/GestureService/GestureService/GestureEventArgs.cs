using System;

namespace GestureService
{
    public class GestureEventArgs : EventArgs
    {
        public GestureType gestureType
        {
            get;
            set;
        }

        public int trackingId
        {
            get;
            set;
        }

        public GestureEventArgs(GestureType gestureType, int trackingId)
        {
            this.gestureType = gestureType;
            this.trackingId = trackingId;
        }
    }
}

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace GestureService
{
    public abstract class GestureDefinition
    {
        protected GestureType gestureType;

        protected IRelativeGestureSegment[] gestureParts;

        public GestureType GetGestureType()
        {
            return gestureType;
        }

        public IRelativeGestureSegment[] GetGestureParts()
        {
            return gestureParts;
        }
    }
}

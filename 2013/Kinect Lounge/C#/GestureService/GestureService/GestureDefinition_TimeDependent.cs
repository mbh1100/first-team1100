using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace GestureService
{
    public abstract class GestureDefinition_TimeDependent : GestureDefinition
    {
        protected double[] gestureFrameTimes;

        public Double GetGesturePower()
        {
            return 0.0;
        }

        public void GesturePartCompleted(double frameTime, int frameIndex)
        {
            if (gestureFrameTimes.Length > frameIndex)
            {
                gestureFrameTimes[frameIndex] = frameTime;
            }
        }
    }
}

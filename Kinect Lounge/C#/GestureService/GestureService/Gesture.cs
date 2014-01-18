using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using Microsoft.Kinect;
using System.Diagnostics;

namespace GestureService
{
    public class Gesture
    {
        private int currentGesturePart = 0;

        private int pausedFrameCount = 10;

        private int frameCount = 0;

        private double frameStartTime = 0;

        private bool paused = false;

        private GestureDefinition gestureDeffinition;

        public Gesture(GestureDefinition gestureDeffinition)
        {
            this.gestureDeffinition = gestureDeffinition;
        }

        public GestureType GetGestureType()
        {
            return gestureDeffinition.GetGestureType();
        }

        public event EventHandler<GestureEventArgs> GestureRecognized;

        public void UpdateGesture(Skeleton data)
        {
            if (paused)
            {
                if (frameCount == pausedFrameCount)
                {
                    paused = false;
                }

                frameCount++;
            }
            
            GesturePieceResult result = gestureDeffinition.GetGestureParts()[currentGesturePart].CheckGesture(data);
            if (result == GesturePieceResult.Succeed)
            {
                if (((GestureDefinition_TimeDependent)gestureDeffinition) != null)
                {
                    ((GestureDefinition_TimeDependent)gestureDeffinition).GesturePartCompleted(Stopwatch.GetTimestamp() - frameStartTime, currentGesturePart);
                }

                frameStartTime = Stopwatch.GetTimestamp();

                if (currentGesturePart + 1 < gestureDeffinition.GetGestureParts().Length)
                {
                    currentGesturePart++;
                    frameCount = 0;
                    pausedFrameCount = 10;
                    paused = true;
                }
                else
                {
                    if (GestureRecognized != null)
                    {
                        GestureRecognized(this, new GestureEventArgs(gestureDeffinition.GetGestureType(), data.TrackingId));
                        Reset();
                    }
                }
            }
            else if (result == GesturePieceResult.Fail || frameCount == 50)
            {
                currentGesturePart = 0;
                frameCount = 0;
                pausedFrameCount = 5;
                paused = true;
            }
            else
            {
                frameCount++;
                pausedFrameCount = 5;
                paused = true;
            }
        }

        public void Reset()
        {
            currentGesturePart = 0;
            frameCount = 0;
            frameStartTime = 0;
            pausedFrameCount = 5;
            paused = true;
        }
    }
}

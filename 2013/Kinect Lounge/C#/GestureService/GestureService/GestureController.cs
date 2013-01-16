using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Microsoft.Kinect;
using GestureService.GestureDefinitions;

namespace GestureService
{
    public class GestureController
    {
        private List<Gesture> activeGestures = new List<Gesture>();

        public event EventHandler<GestureEventArgs> GestureRecognized;

        public void UpdateAllGestures(Skeleton data)
        {
            foreach (Gesture gesture in activeGestures)
            {
                gesture.UpdateGesture(data);
            }
        }

        public void AddGesture(GestureDefinition gestureDef)
        {
            bool bContains = false;

            foreach (Gesture gesture in activeGestures)
            {
                if (gesture.GetGestureType() == gestureDef.GetGestureType())
                {
                    bContains = true;
                }
            }

            if (!bContains)
            {
                Gesture gesture = new Gesture(gestureDef);
                gesture.GestureRecognized += OnGestureRecognized;
                activeGestures.Add(gesture);
            }
        }

        private void OnGestureRecognized(object sender, GestureEventArgs e)
        {
            if (GestureRecognized != null)
            {
                GestureRecognized(this, e);
            }

            foreach (Gesture gesture in activeGestures)
            {
                gesture.Reset();
            }
        }
    }
}

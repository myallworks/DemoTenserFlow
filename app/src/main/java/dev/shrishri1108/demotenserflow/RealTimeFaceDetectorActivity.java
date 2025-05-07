package dev.shrishri1108.demotenserflow;

import android.os.Bundle;
import dev.shrishri1108.demotenserflow.helpers.VideoHelperActivity;
import dev.shrishri1108.demotenserflow.helpers.vision.VisionBaseProcessor;
import dev.shrishri1108.demotenserflow.helpers.vision.drowsiness.FaceDrowsinessDetectorProcessor;

        public class RealTimeFaceDetectorActivity extends VideoHelperActivity {

            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);

            }

            @Override
            protected VisionBaseProcessor setProcessor() {
                return new FaceDrowsinessDetectorProcessor(graphicOverlay);
            }
        }

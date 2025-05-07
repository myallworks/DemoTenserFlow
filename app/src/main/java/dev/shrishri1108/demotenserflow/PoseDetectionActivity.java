package dev.shrishri1108.demotenserflow;

import android.os.Bundle;

import dev.shrishri1108.demotenserflow.helpers.vision.VisionBaseProcessor;
import dev.shrishri1108.demotenserflow.helpers.vision.posedetector.PoseDetectorProcessor;
import com.google.mlkit.vision.pose.accurate.AccuratePoseDetectorOptions;

import dev.shrishri1108.demotenserflow.helpers.VideoHelperActivity;

public class PoseDetectionActivity extends VideoHelperActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected VisionBaseProcessor setProcessor() {
        AccuratePoseDetectorOptions options = new AccuratePoseDetectorOptions.Builder()
                .setDetectorMode(AccuratePoseDetectorOptions.STREAM_MODE)
                .build();
        return new PoseDetectorProcessor(
                options,
                true,
                false,
                false,
                false,
                true,
                this,
                graphicOverlay,
                previewView
        );
    }
}


package dev.shrishri1108.demotenserflow;

import androidx.camera.core.CameraSelector;
import dev.shrishri1108.demotenserflow.helpers.VideoHelperActivity;
import dev.shrishri1108.demotenserflow.helpers.vision.VisionBaseProcessor;
import dev.shrishri1108.demotenserflow.helpers.vision.obscure.ObscureFaceProcessor;
import dev.shrishri1108.demotenserflow.helpers.vision.obscure.ObscureType;

public class ObscureFaceActivity extends VideoHelperActivity {

    private ObscureFaceProcessor obscureFaceProcessor;

    @Override
    protected VisionBaseProcessor setProcessor() {
        obscureFaceProcessor = new ObscureFaceProcessor(graphicOverlay);
        obscureFaceProcessor.setObscureType(ObscureType.TRANSLUCENT);
        return obscureFaceProcessor;
    }

    @Override
    protected int getLensFacing() {
        return CameraSelector.LENS_FACING_FRONT;
    }
}


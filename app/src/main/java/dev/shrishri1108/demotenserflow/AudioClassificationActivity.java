package dev.shrishri1108.demotenserflow;

import android.media.AudioRecord;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import org.tensorflow.lite.support.audio.TensorAudio;
import org.tensorflow.lite.support.label.Category;
import org.tensorflow.lite.task.audio.classifier.AudioClassifier;
import org.tensorflow.lite.task.audio.classifier.Classifications;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import dev.shrishri1108.demotenserflow.helpers.AudioHelperActivity;

public class AudioClassificationActivity extends AudioHelperActivity {

    private String model = "yamnet_classification.tflite";
    private AudioClassifier audioClassifier;
    private TensorAudio tensorAudio;
    private TimerTask timeTask;
    private AudioRecord audioRecord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            audioClassifier = AudioClassifier.createFromFile(this, model);
        } catch (Exception ex) {
            ex.printStackTrace();

            Log.e(Constant.TAG, "onCreate: ", ex);
        }
        tensorAudio = audioClassifier.createInputTensorAudio();
    }

    @Override
    public void startRec(View view) {
        super.startRec(view);

// showing the audio recorder specification
        TensorAudio.TensorAudioFormat format = audioClassifier.getRequiredTensorAudioFormat();
        String specs = "Number of channels: " + format.getChannels() + "\n"
                + "Sample Rate :" + format.getSampleRate() + "";
        getMtvSpec().setText(specs);

        audioRecord = audioClassifier.createAudioRecord();

        audioRecord.startRecording();

        timeTask = new TimerTask() {
            @Override
            public void run() {
                List<Classifications> outputLst = audioClassifier.classify(tensorAudio);

                // filtering out classifications with low probability
                List<Category> finalOutput = new ArrayList<>();
                for (Classifications classifications : outputLst) {
                    for (Category category : classifications.getCategories()) {
                        if (category.getScore() > 0.3f) {
                            finalOutput.add(category);
                        }
                    }
                }

                if (finalOutput.isEmpty())
                    return;
                // Creating a multiine string with the filtered results
                StringBuilder opStr = new StringBuilder();
                for (Category categor : finalOutput) {
                    opStr.append(categor.getLabel())
                            .append(" : ")
                            .append(categor.getScore())
                            .append("\n");
                }

                Log.d(Constant.TAG, "Audios Classifications :  " + opStr);
                runOnUiThread(() -> {
                    getMtvOpAudio().setText(opStr);
                });
            }
        };

        new Timer().scheduleAtFixedRate(timeTask, 1, 500);
    }

    @Override
    public void stopRec(View view) {
        super.stopRec(view);

        timeTask.cancel();
        audioRecord.stop();
    }
}
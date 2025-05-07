package dev.shrishri1108.demotenserflow;

import android.os.Bundle;
import android.util.Log;

import org.tensorflow.lite.support.label.Category;
import org.tensorflow.lite.task.text.nlclassifier.NLClassifier;

import java.util.List;

import dev.shrishri1108.demotenserflow.helpers.TextHelperActivity;

public class SpamDetectionActivity extends TextHelperActivity {

    private static final String MODEL_PATH = "model_spam.tflite";
    private NLClassifier nlClassifier;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            nlClassifier = NLClassifier.createFromFile(this, MODEL_PATH);
        } catch (Exception ex) {
            Log.e(Constant.TAG, "onCreate: ", ex);
            ex.printStackTrace();
        }
    }

    @Override
    protected void runClassification(String comment) {
        super.runClassification(comment);
        List<Category> apiResults = nlClassifier.classify(comment);
        float score = apiResults.get(1).getScore();

        if (score < 0.8f) {
            gettvSpms().setText(new StringBuilder().append("Detected as Spam -> \nSpam Score:  ").append(score).toString());
        } else {
            gettvSpms().setText("not detected as Spam -> \nSpam Score:  " + score);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        nlClassifier.close();
    }
}
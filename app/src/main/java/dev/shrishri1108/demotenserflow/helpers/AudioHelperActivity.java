package dev.shrishri1108.demotenserflow.helpers;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textview.MaterialTextView;

import dev.shrishri1108.demotenserflow.AudioClassificationActivity;
import dev.shrishri1108.demotenserflow.R;
import dev.shrishri1108.demotenserflow.databinding.ActivityAudioHelperBinding;

public class AudioHelperActivity extends AppCompatActivity {

    private dev.shrishri1108.demotenserflow.databinding.ActivityAudioHelperBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
        binding = ActivityAudioHelperBinding.inflate(LayoutInflater.from(this));
        setContentView(binding.getRoot());

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{Manifest.permission.RECORD_AUDIO}, 0);
            }
        }
    }

    public void startRec(View view) {
        binding.btnStartRec.setEnabled(false);

        binding.btnStopRec.setEnabled(true);
    }

    public void stopRec(View view) {
        binding.btnStartRec.setEnabled(true);

        binding.btnStopRec.setEnabled(false);
    }

    protected MaterialTextView getMtvOpAudio () {
        return binding.mtvOpAudio ;
    }
    protected MaterialTextView getMtvSpec () {
        return binding.mtvSpecAudio ;
    }
}
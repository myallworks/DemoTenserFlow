package dev.shrishri1108.demotenserflow;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import com.google.mlkit.vision.objects.ObjectDetection;

import java.io.IOException;

import dev.shrishri1108.demotenserflow.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding  = ActivityMainBinding.inflate(LayoutInflater.from(this));
        setContentView(binding.getRoot());

        binding.imgClassificationLays.setOnClickListener(v -> {
            Intent intents = new Intent(MainActivity.this, ImageClassificationActivity.class);
            startActivity(intents);
        });

        binding.imgPicturesLays.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intents = new Intent(MainActivity.this, FlowerIdentificationActivity.class);
                startActivity(intents);
            }
        });

        binding.imgFaceDetectionLays.setOnClickListener(v -> {
            Intent intents = new Intent(MainActivity.this, FaceDetectionActivity.class);
            startActivity(intents);
        });

        binding.imgOBjDLays.setOnClickListener(viws -> {
            Intent intents = new Intent(MainActivity.this, ObjectDetectionActivity.class);
            startActivity(intents);
        });

        binding.imgAClassificationLays.setOnClickListener(v -> {
            Intent intents = new Intent(MainActivity.this, AudioClassificationActivity.class);
            startActivity(intents);
        });

        binding.imgBirdSoundIdentifierLays.setOnClickListener(v -> {
            Intent intents = new Intent(MainActivity.this, BirdAudioClassificationActivity.class);
            startActivity(intents);
        });

        binding.imgSTDetectorLays.setOnClickListener(v -> {
            Intent intents = new Intent(MainActivity.this, SpamDetectionActivity.class);
            startActivity(intents);
        });

        binding.RealtimeDDdLays.setOnClickListener(v -> {
            Intent intents = new Intent(MainActivity.this, RealTimeFaceDetectorActivity.class);
            startActivity(intents);
        });

        binding.btPDetectorLays.setOnClickListener(v -> {
            Intent intents = new Intent(MainActivity.this, PoseDetectionActivity.class);
            startActivity(intents);
        });

        binding.VisitorDLays.setOnClickListener(v -> {
            Intent intents = new Intent(MainActivity.this, VisitorAnalysisActivity.class);
            startActivity(intents);
        });
        binding.ObsDetectorLays.setOnClickListener(v -> {
            Intent intents = new Intent(MainActivity.this, ObscureFaceActivity.class);
            startActivity(intents);
        });
    }



}
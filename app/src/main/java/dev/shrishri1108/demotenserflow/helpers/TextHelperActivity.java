package dev.shrishri1108.demotenserflow.helpers;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textview.MaterialTextView;

import dev.shrishri1108.demotenserflow.databinding.ActivityTextHelperBinding;

public class TextHelperActivity extends AppCompatActivity {

    private ActivityTextHelperBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTextHelperBinding.inflate(LayoutInflater.from(this));
        setContentView(binding.getRoot());

    }

    public void postComment(View view) {
        runClassification( binding.etInputText.getText().toString());
    }

    protected void runClassification(String comment) {

    }
    protected EditText getEtComments() {
     return binding.etInputText ;
    }
    protected MaterialTextView gettvSpms()  {
     return binding.tvOpTextlabel ;
    }
}
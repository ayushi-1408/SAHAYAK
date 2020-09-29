package com.example.sahayak;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import org.tensorflow.lite.Interpreter;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class MainActivity extends AppCompatActivity {

    Interpreter tflite;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button start = (Button) findViewById(R.id.button1);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Questions();
            }
        });
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                About();
            }
        });


        try{
            tflite = new Interpreter(loadModelFile());
        } catch(Exception ex){
            ex.printStackTrace();
        }


    }
    public float doInference(String inputString){
        float[] inputVal = new float[1];
        inputVal[0] = Float.valueOf(inputString);

        float[][] outputval = new float[1][1];
        tflite.run(inputVal, outputval);

        float inferredValue = outputval[0][0];
        return inferredValue;
    }

    private MappedByteBuffer loadModelFile() throws IOException {
        AssetFileDescriptor fileDescriptor = this.getAssets().openFd("converted_model.tflite");
        FileInputStream inputStream = new FileInputStream(fileDescriptor.getFileDescriptor());
        FileChannel fileChannel = inputStream.getChannel();
        long startOffset = fileDescriptor.getStartOffset();
        long declaredLength = fileDescriptor.getDeclaredLength();
        return fileChannel.map(FileChannel.MapMode.READ_ONLY, startOffset, declaredLength);
    }

    public void Questions() {
        Intent intent1 = new Intent(this, Questions.class);
        startActivity(intent1);
    }
    public void About() {
        Intent intent = new Intent(this, About.class);
        startActivity(intent);
    }

}
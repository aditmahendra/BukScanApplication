package com.example.bukscan;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.SparseArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.text.TextBlock;
import com.google.android.gms.vision.text.TextRecognizer;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import java.io.IOException;

public class activity_scanBookCover extends AppCompatActivity {
    private ImageView backButton;
    Button btn_scan, btn_copy;
    TextView txt_res;
    Bitmap bitmap;

    private static final int REQUEST_CAMERA_CODE = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_book_cover);

        backButton = (ImageView) findViewById(R.id.backBtn);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btn_scan = findViewById(R.id.scanBtn);
        btn_copy = findViewById(R.id.copyBtn);
        txt_res = findViewById(R.id.txt_result);

        if(ContextCompat.checkSelfPermission(activity_scanBookCover.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){

            ActivityCompat.requestPermissions(activity_scanBookCover.this, new String[]{
                    Manifest.permission.CAMERA
            }, REQUEST_CAMERA_CODE);
        }

        btn_scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CropImage.activity().setGuidelines(CropImageView.Guidelines.ON).start(activity_scanBookCover.this);
            }
        });

        btn_copy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String scannedText = txt_res.getText().toString();
                 copyText(scannedText);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE){
            CropImage.ActivityResult res = CropImage.getActivityResult(data);
            if(resultCode == RESULT_OK){
                Uri resultUri = res.getUri();
                try {
                    bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), resultUri);

                    //start the OCR
                    getTxtFromImage(bitmap);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void getTxtFromImage(Bitmap bitmap){
        TextRecognizer recognizer = new TextRecognizer.Builder(this).build();
        if (!recognizer.isOperational()){
            Toast.makeText(activity_scanBookCover.this, "Error", Toast.LENGTH_SHORT).show();
        }
        else{
            Frame frame = new Frame.Builder().setBitmap(bitmap).build();
            SparseArray<TextBlock> textBlockSparseArray = recognizer.detect(frame);
            StringBuilder stringBuilder = new StringBuilder();
            for (int i=0; i<textBlockSparseArray.size(); i++){
                TextBlock textBlock = textBlockSparseArray.valueAt(i);
                stringBuilder.append(textBlock.getValue());
                stringBuilder.append("\n");
            }
            txt_res.setText(stringBuilder.toString());
            btn_scan.setText("Rescan");
        }
    }

    private void copyText(String txt){
        ClipboardManager clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clippedData = ClipData.newPlainText("Copied data", txt);
        clipboardManager.setPrimaryClip(clippedData);
        Toast.makeText(activity_scanBookCover.this, "text copied", Toast.LENGTH_SHORT);
    }
}
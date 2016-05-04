package com.zhibiao.lin.systemphotocropper;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private SysPhotoCropper sysPhotoCropper;
    private ImageView ivResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ivResult = (ImageView) findViewById(R.id.ivResult);

        sysPhotoCropper = new SysPhotoCropper(this, new PhotoCropCallBack() {
            @Override
            public void onFailed(String message) {
                Toast.makeText(MainActivity.this,message, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onPhotoCropped(Uri uri) {
                ivResult.setImageURI(null);
                ivResult.setImageURI(uri);
            }
        });
        setListener();
    }

    private void setListener() {
        findViewById(R.id.btnCamera).setOnClickListener(this);
        findViewById(R.id.btnGallery).setOnClickListener(this);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        sysPhotoCropper.handlerOnActivtyResult(requestCode, resultCode, data);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnCamera:
                sysPhotoCropper.cropForCamera();
                break;
            case R.id.btnGallery:
                sysPhotoCropper.cropForGallery();
                break;
        }
    }
}

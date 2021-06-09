package com.max.hybrid;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import io.flutter.plugin.common.BasicMessageChannel;

public class MainActivity extends AppCompatActivity {
    private Map<String, Object> params = new HashMap<>();
    private final int OPEN_CAMERA = 1011;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FlutterEngineAndChannel.init(this, new MessageHandle() {
            @Override
            public void handleMessage(@Nullable  Object message, @NonNull  BasicMessageChannel.Reply reply) {
                String type = (String) ((Map<?, ?>) message).get("type");
                System.out.println("flutter params：" + type);
                switch (type) {
                    case "camera":
                        // todo camera
                        openCamera();

                        break;

                    default:
                        break;
                }

            }
        });



        findViewById(R.id.bt_1).setOnClickListener(v -> {
            params.clear();
            params.put("page", "page1");
            FlutterEngineAndChannel.startFlutter(this, params);


        });

        findViewById(R.id.bt_2).setOnClickListener(v -> {
            params.clear();
            params.put("page", "page2");
            FlutterEngineAndChannel.startFlutter(this, params);


        });

        findViewById(R.id.bt_3).setOnClickListener(v -> {
            params.clear();
            params.put("page", "page3");
            FlutterEngineAndChannel.startFlutter(this, params);

        });

        findViewById(R.id.bt_4).setOnClickListener(v -> {
            Toast.makeText(this, getString(R.string.android_tip), Toast.LENGTH_SHORT).show();
        });

    }


    public  void openCamera() {
        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (cameraIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(cameraIntent, OPEN_CAMERA);
        }
    }




    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
//            FlutterEngineAndChannel.mReplay.reply(result);

    }



    @Override
    public boolean isDestroyed() {
        FlutterEngineAndChannel.destroyEngine();
        return super.isDestroyed();
    }
}
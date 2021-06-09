package com.max.hybrid;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;

import io.flutter.embedding.android.FlutterActivity;

/**
 * @description:
 */
public class Hybrid extends FlutterActivity {

    public final static String PARAMS = "params";
    private String params;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        params = getIntent().getStringExtra(PARAMS);
    }

    @NonNull
    @Override
    public String getInitialRoute() {
        return params == null ? super.getInitialRoute() : params;
    }

    public static void to(Context context, String initParams) {
        Intent intent = new Intent(context, Hybrid.class);
        intent.putExtra(PARAMS, initParams);
        context.startActivity(intent);
    }

} 
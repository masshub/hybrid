package com.max.hybrid;

import android.content.Context;
import android.content.Intent;
import android.provider.MediaStore;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.HashMap;
import java.util.Map;

import io.flutter.embedding.android.FlutterActivity;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.FlutterEngineCache;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.StandardMessageCodec;

/**
 * @description:
 */
public class FlutterEngineAndChannel {
    private static FlutterEngine flutterEngine;
    private static BasicMessageChannel basicMessageChannel;
    private static String channelName = "com.hybrid.message.channel";
    public static final String ENGINE_ID = "default_engine_id";
    private static Context mContext;
    public static BasicMessageChannel.Reply mReplay;


    public static void init(Context context,MessageHandle messageHandle) {
        Log.d("FlutterEngineAndChannel", "init: flutterEngine");
        mContext = context;
        if (flutterEngine == null) {
            flutterEngine = new FlutterEngine(context);
//            flutterEngine.getNavigationChannel().setInitialRoute(initialRoute);
            flutterEngine.getDartExecutor().executeDartEntrypoint(DartExecutor.DartEntrypoint.createDefault());
            FlutterEngineCache.getInstance().put(ENGINE_ID, flutterEngine);

        }

        if (basicMessageChannel == null) {
            if (flutterEngine != null) {
                basicMessageChannel = new BasicMessageChannel<Object>(flutterEngine.getDartExecutor(), channelName, StandardMessageCodec.INSTANCE);
                basicMessageChannel.setMessageHandler(new BasicMessageChannel.MessageHandler() {
                    @Override
                    public void onMessage(@Nullable Object message, @NonNull BasicMessageChannel.Reply reply) {
                        mReplay = reply;
                        messageHandle.handleMessage(message, reply);
                        // 接收消息并处理
//                        handleMessage(message, reply);


                    }
                });
            }
        }
    }

    // 处理消息
    private static void handleMessage(Object message, BasicMessageChannel.Reply reply) {


    }


    public static void startFlutter(Context context, Map<String, Object> params) {
        sendMessage(params);
        context.startActivity(FlutterActivity.withCachedEngine(ENGINE_ID).build(context));
    }


    public static void sendMessage(Map<String, Object> params) {
        Log.e("basicMessageChannel", basicMessageChannel.toString());
        Log.e("flutterEngine", flutterEngine.toString());
        if (basicMessageChannel != null) {
            basicMessageChannel.send(params, new BasicMessageChannel.Reply() {
                @Override
                public void reply(@Nullable Object reply) {
                    // 发送回调

                }
            });
        }
    }


    public static void destroyEngine() {
        if (flutterEngine != null) {
            flutterEngine.destroy();
        }
    }


}
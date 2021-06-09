package com.max.hybrid;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import io.flutter.plugin.common.BasicMessageChannel;

/**
 * @author: maker
 * @date: 2021/6/9 14:58
 * @description:
 */
interface MessageHandle {
    void handleMessage(@Nullable Object message, @NonNull BasicMessageChannel.Reply reply);
}

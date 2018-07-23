package com.nexmo.stitch.stitchqs_java;

import android.content.Context;

import com.nexmo.sdk.conversation.client.ConversationClient;

public class StitchHelper {
    private static ConversationClient stitchClient;

    static ConversationClient getStitchClient(Context context) {
        if (stitchClient == null) {
            stitchClient = new ConversationClient.ConversationClientBuilder().context(context.getApplicationContext()).build();
        }

        return stitchClient;
    }

}

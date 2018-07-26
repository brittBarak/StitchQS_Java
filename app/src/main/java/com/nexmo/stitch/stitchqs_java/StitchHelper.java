package com.nexmo.stitch.stitchqs_java;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.nexmo.sdk.conversation.client.ConversationClient;
import com.nexmo.sdk.conversation.client.User;
import com.nexmo.sdk.conversation.client.event.NexmoAPIError;

public class StitchHelper {
    public static String TAG = "Stitch";
    public static String JWT_JAMIE = "REPLACE WITH YOUR OWN GENERATED JWT";
    public static  User USER;

    private static ConversationClient stitchClient;

    static ConversationClient getStitchClient(Context context) {
        if (stitchClient == null) {
            stitchClient = new ConversationClient.ConversationClientBuilder().context(context.getApplicationContext()).build();
        }

        return stitchClient;
    }

    public static void logError(Context context, NexmoAPIError apiError) {
        String msg = "error: " + apiError.getMessage();
        Log.e(TAG, msg);
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show();

    }

    public static void logMessage(Context context, String msg) {
        Log.d(TAG, msg);
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
    }
}

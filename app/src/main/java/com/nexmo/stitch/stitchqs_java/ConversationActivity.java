package com.nexmo.stitch.stitchqs_java;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.nexmo.sdk.conversation.client.Conversation;
import com.nexmo.sdk.conversation.client.event.NexmoAPIError;
import com.nexmo.sdk.conversation.client.event.RequestHandler;

public class ConversationActivity extends AppCompatActivity {
    private static final String CONV_NAME = "CONV_NAME";

    Conversation conversation;

    public static void startNewConversation(Context context, String name) {
        Intent intent = new Intent(context, ConversationActivity.class)
                .putExtra(CONV_NAME, name);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversation);

        String conversationName = getIntent().getStringExtra(CONV_NAME);
        StitchHelper.getStitchClient(this).newConversation(true, conversationName, new RequestHandler<Conversation>() {

            @Override
            public void onSuccess(Conversation newConversation) {
                conversation = newConversation;
            }

            @Override
            public void onError(NexmoAPIError apiError) {
                StitchHelper.logError(getApplicationContext(), apiError);
            }
        });

    }

    public void onSendMessage(View view) {
        //TODO implement
    }

}


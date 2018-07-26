package com.nexmo.stitch.stitchqs_java;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

public class ConversationListActivity extends AppCompatActivity {

    public static void start(Context context) {
        context.startActivity(new Intent(context, ConversationListActivity.class));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversation_list);
    }

    public void onNewConversationClick(View view) {
        EditText nameET = findViewById(R.id.nameET);
        String name = nameET.getText().toString();
        if (! TextUtils.isEmpty(name)) {
            ConversationActivity.startNewConversation(this, name);
        }
    }

}

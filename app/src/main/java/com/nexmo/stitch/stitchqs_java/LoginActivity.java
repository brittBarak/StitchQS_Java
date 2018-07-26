package com.nexmo.stitch.stitchqs_java;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.nexmo.sdk.conversation.client.User;
import com.nexmo.sdk.conversation.client.event.NexmoAPIError;
import com.nexmo.sdk.conversation.client.event.RequestHandler;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void onLoginClick(View view) {
        StitchHelper.getStitchClient(this)
                .login(getJwt(view), new RequestHandler<User>() {

                    @Override
                    public void onSuccess(final User user) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                onLoggedIn(user);
                            }
                        });
                    }

                    @Override
                    public void onError(final NexmoAPIError apiError) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                StitchHelper.logError(getApplicationContext(), apiError);

                            }
                        });
                    }

                });
    }

    private String getJwt(View view) {
        return StitchHelper.JWT_JAMIE;
    }

    private void onLoggedIn(User user) {
        StitchHelper.USER = user;
        StitchHelper.logMessage(this, String.format("Hello %s !", user.getName()));
        ConversationListActivity.start(this);

    }
}

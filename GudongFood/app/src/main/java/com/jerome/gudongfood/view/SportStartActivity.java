package com.jerome.gudongfood.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.R;

import com.lrving.gudongfood.view.ProfileActivity;

import java.io.File;
import java.io.IOException;

/**
 * 运动开始按钮的页面
 *
 * @author Jerome
 */
public class SportStartActivity extends AppCompatActivity {

    private View wholeView;

    private boolean clickedButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sport_start);

        clickedButton = false;

        wholeView = findViewById(R.id.StartPage);

        wholeView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!clickedButton)
                    switchToResult();
            }
        });

        View loginButton = findViewById(R.id.busiLoginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickedButton = true;
                switchToLogin();
            }
        });

        View userProfileButton = findViewById(R.id.userProfileButton);
        userProfileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SportStartActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });
    }

    private void switchToLogin() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

    private void switchToResult() {
        Intent intent = new Intent(this, UploadResultActivity.class);
        startActivity(intent);
        finish();
    }

}

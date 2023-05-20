package com.example.cookingcalendar.ui.cooking_photo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import com.example.cookingcalendar.R;

public class CookingPhotoActivity extends AppCompatActivity {

    private FrameLayout backButtonLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cookingphoto);

        backButtonLayout = findViewById(R.id.back_button);

        backButtonLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        }

        );
    }
}
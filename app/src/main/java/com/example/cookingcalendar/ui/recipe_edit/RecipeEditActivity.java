package com.example.cookingcalendar.ui.recipe_edit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import com.example.cookingcalendar.R;

public class RecipeEditActivity extends AppCompatActivity {

    private FrameLayout backButtonLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_edit);

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
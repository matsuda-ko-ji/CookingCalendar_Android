package com.example.cookingcalendar.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import com.example.cookingcalendar.R;
import com.example.cookingcalendar.ui.PagerAdapter;
import com.example.cookingcalendar.ui.cooking_photo.CookingPhotoActivity;
import com.example.cookingcalendar.ui.recipe_edit.RecipeEditActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private FrameLayout favoriteLayout;
    private AppCompatImageView favoriteImage;
    private boolean isFavorite=false;
    private ViewPager2 viewPager;
    private LinearLayoutCompat cookImageLayout;
    private FloatingActionButton addMemoButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.Theme_CookingCalendar);
        setContentView(R.layout.activity_main);

        //ViewModelのインスタンスを取得
        MainViewModel viewModel=new ViewModelProvider(this).get(MainViewModel.class);
        // ViewPager
        viewPager = findViewById(R.id.pager);

        //Toolbar設定
        favoriteLayout=findViewById(R.id.favorite_button);
        favoriteImage=findViewById(R.id.favorite_image);
        favoriteLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //お気に入りボタンタップ処理
                if(isFavorite){
                    //タップした画像がOFFの場合はONに変える
                    favoriteImage.setImageResource(R.drawable.ic_baseline_star_on);
                }else{
                    //OFFに変える
                    favoriteImage.setImageResource(R.drawable.ic_baseline_star_off);
                }
            }
        });
        cookImageLayout = findViewById(R.id.cook_image_layout);
        cookImageLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CookingPhotoActivity.class);
                startActivity(intent);

            }
        });
        addMemoButton = findViewById(R.id.add_memo_button);
        addMemoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RecipeEditActivity.class);
                startActivity(intent);

            }
        });

        List list = viewModel.createListDayData();

        // viewPagerの設定
        viewPager.setAdapter(new PagerAdapter(this));

    }
}

package com.example.cookingcalendar.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import com.example.cookingcalendar.R;

public class MainActivity extends AppCompatActivity {

    private FrameLayout favoriteLayout;
    private AppCompatImageView favoriteImage;
    private boolean isFavorite=false;
    private ViewPager2 viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.Theme_CookingCalendar);
        setContentView(R.layout.activity_main);
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

        // viewPagerの設定
        viewPager.setAdapter(new PagerAdapter(this));
    }
}

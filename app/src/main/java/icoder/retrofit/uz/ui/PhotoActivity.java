package icoder.retrofit.uz.ui;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.List;

import icoder.retrofit.uz.R;
import icoder.retrofit.uz.api.model.Restaurant;

public class PhotoActivity extends AppCompatActivity {
    public static List<Restaurant.Photo> photos;
    private SectionPagerAdapter sectionPagerAdapter;
    private ViewPager mViewPager;
    private TabLayout tabs;
    private ProgressBar progress;
    private ImageView close;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);

        mViewPager = findViewById(R.id.container);
        tabs = findViewById(R.id.tabs);
        sectionPagerAdapter = new SectionPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(sectionPagerAdapter);
        tabs.setupWithViewPager(mViewPager);
        mViewPager.setCurrentItem(getIntent().getIntExtra("position", 0));

        progress = findViewById(R.id.progress);
        close = findViewById(R.id.close);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private class SectionPagerAdapter extends FragmentPagerAdapter {
        public SectionPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            if (position >= 0) {
                Bundle bundle = new Bundle();
                bundle.putString("url", photos.get(position).getPhoto().getUrl());
                bundle.putString("user_image", photos.get(position).getPhoto().getUser().getProfile_image());
                bundle.putString("user_name", photos.get(position).getPhoto().getUser().getName());
                bundle.putString("time", photos.get(position).getPhoto().getFriendly_time());
                bundle.putString("caption", photos.get(position).getPhoto().getCaption());
                PhotoFragment fragment = new PhotoFragment();
                fragment.setArguments(bundle);
                return fragment;
            } else
                return null;
        }

        @Override
        public int getCount() {
            return photos.size();
        }
    }

}

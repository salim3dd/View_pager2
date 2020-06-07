package com.qays3dd.view_pager2;

import android.content.Context;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ViewPager viewPager;
    private int[] birds = {R.drawable.bird_1, R.drawable.bird_2, R.drawable.bird_3, R.drawable.bird_4, R.drawable.bird_5};
    ArrayList<Liste_itme> list_birds = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.view_pager);

        for (int i = 0; i < birds.length; i++) {
            list_birds.add(new Liste_itme("Bird :" + i, birds[i]));
        }

        Swipe_page swipe = new Swipe_page(this, list_birds);
        viewPager.setAdapter(swipe);
        viewPager.setCurrentItem(list_birds.size());

    }


    class Swipe_page extends PagerAdapter {
        LayoutInflater layoutInflater;
        private Context context;
        ArrayList<Liste_itme> liste_itme = new ArrayList<>();

        public Swipe_page(Context context, ArrayList<Liste_itme> liste_itme) {
            this.context = context;
            this.liste_itme = liste_itme;
        }

        @Override
        public int getCount() {
            return liste_itme.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return (view == object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view = layoutInflater.inflate(R.layout.row_itme, container, false);
            ImageView img = view.findViewById(R.id.imageView);
            TextView txt_name = view.findViewById(R.id.textView);

            img.setImageResource(liste_itme.get(position).getBird_id());
            txt_name.setText(liste_itme.get(position).getName());
            container.addView(view);
            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((LinearLayout) object);
        }
    }
}

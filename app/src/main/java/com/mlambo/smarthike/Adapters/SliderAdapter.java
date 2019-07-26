package com.mlambo.smarthike.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.mlambo.smarthike.R;


public class SliderAdapter extends PagerAdapter
{
    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context)
    {
        this.context = context;
    }

    public int[] slider_images = {

            /*R.drawable.group_11,
            R.drawable.group_10,
            R.drawable.group_12*/
    };

    public String[] slider_headings = {
            "WE SUPPLY",
            "YOU BUY",
            "WE DELIVERED"
    };

    public String[] slider_details = {

            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec vehicula sem a " +
                    "malesuada rhoncus. Pellentesque ut dolor a dui porttitor porta lacinia non libero.",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec vehicula sem a" +
                    " malesuada rhoncus. Pellentesque ut dolor a dui porttitor porta lacinia non libero.",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec vehicula sem " +
                    "a malesuada rhoncus. Pellentesque ut dolor a dui porttitor porta lacinia non libero."

    };

    @Override
    public int getCount() {
        return slider_headings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (RelativeLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout, container, false);

        ImageView slideImageView = (ImageView) view.findViewById(R.id.slide_image);
        TextView slideHeading = (TextView) view.findViewById(R.id.slide_heading);
        TextView slideDescription = (TextView) view.findViewById(R.id.slide_description);

        slideImageView.setImageResource(slider_images[position]);
        slideHeading.setText(slider_headings[position]);
        slideDescription.setText(slider_details[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        container.removeView((RelativeLayout)object);
    }
}

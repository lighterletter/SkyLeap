package lighterletter.c4q.nyc.skyleap.features.features.weather;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import lighterletter.c4q.nyc.skyleap.R;

/**
 * Created by c4q-john on 7/1/15.
 */
public class WeatherFrag extends Fragment{
    //add your layout elements here.
    private TextView weather;

    public  WeatherFrag getInstance(int position) {
        WeatherFrag myFragment = new WeatherFrag();

        Bundle args = new Bundle();
        args.putInt("postion",position);
        myFragment.setArguments(args);

        return myFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View layout = inflater.inflate(R.layout.fragment_layout_weather_card, container,false);
        weather =  (TextView) layout.findViewById(R.id.my_Weather_textview);
        Bundle bundle = getArguments();

        if (bundle != null){
            weather.setText(" this stuff is a weather string"+bundle.getInt("position"));
        }
        return layout;

    }
}


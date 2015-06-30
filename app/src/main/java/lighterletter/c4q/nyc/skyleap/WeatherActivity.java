package lighterletter.c4q.nyc.skyleap;

//import android.support.v7.app.ActionBarActivity;
//import android.os.Bundle;
//import android.view.Menu;
//import android.view.MenuItem;



import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class WeatherActivity extends Fragment {

    public RecyclerView recyclerView;
    private WeatherVHRVAdapter weatherAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View layout =inflater.inflate(R.layout.activity_recyclerview_weather,container,false);
        recyclerView = (RecyclerView) layout.findViewById(R.id.weatherRecyclerView);

        weatherAdapter = new WeatherVHRVAdapter(getActivity(),getData());
        recyclerView.setAdapter(weatherAdapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return layout;

    }
    public static List<WeatherInformation> getData(){
        List<WeatherInformation> data = new ArrayList<>();
        int[] imgIcons = {R.drawable.apodimgtest, R.drawable.apodimgtest};//TODO: change drawables to the weather images
        String[] imgText = { "text relevant to image1","text 2"};
        for(int i =0; i < imgText.length && i < imgIcons.length; i ++){
            WeatherInformation current = new WeatherInformation();
            current.weatherCurrImg = imgIcons[i];
            current.weatherCurrText = imgText[i];
            data.add(current);
        }

        return data;
    }
//
//    public RecyclerView recyclerView;
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        View rootView = inflater.inflate(R.layout.activity_recyclerview_weather, container, false);
//        recyclerView = (RecyclerView)rootView.findViewById(R.id.WeatherListRV);
//        getLayoutInflater(savedInstanceState).inflate(R.layout.activity_recyclerview_weather, container, false);
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
//        recyclerView.setLayoutManager(layoutManager);
//
//        return rootView;
//    }
}

//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        View rootView = inflater.inflate(R.layout.fragment_catalog_viewer, container, false);
//        recyclerView = (RecyclerView)rootView.findViewById(R.id.my_recycler_view);
//        getLayoutInflater(savedInstanceState).inflate(R.layout.catalog_child, container);
//        return rootView;
//    }


//public class WeatherActivity extends ActionBarActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_recyclerview_weather);
//    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_weather, menu);
//        return true;
//    }
//
//
//}

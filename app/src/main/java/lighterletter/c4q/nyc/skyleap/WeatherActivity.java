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



public class WeatherActivity extends Fragment {

//    @Override
//    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        View v =inflater.inflate(R.layout.activity_weather,container,false);
//        return v;
//
//    }

    public RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_weather, container, false);
        recyclerView = (RecyclerView)rootView.findViewById(R.id.WeatherListRV);
        getLayoutInflater(savedInstanceState).inflate(R.layout.activity_weather, container, false);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        return rootView;
    }
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
//        setContentView(R.layout.activity_weather);
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

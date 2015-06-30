package lighterletter.c4q.nyc.skyleap;

//import android.support.v7.app.ActionBarActivity;
//import android.os.Bundle;
//import android.view.Menu;
//import android.view.MenuItem;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hp1 on 21-01-2015.
 */
public class ApodActivity extends Fragment {


    public RecyclerView recyclerView;
    public ApodVHRVAdapter apodAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View layout =inflater.inflate(R.layout.activity_recyclerview_apod,container,false);
        recyclerView = (RecyclerView) layout.findViewById(R.id.apodRecyclerView);

        apodAdapter = new ApodVHRVAdapter(getActivity(),getData());
        recyclerView.setAdapter(apodAdapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return layout;
    }

    public static List<ApodInformation> getData(){
        List<ApodInformation> data = new ArrayList<>();
        int[] imgIcons = {R.drawable.apodimgtest, R.drawable.apodimgtest};
        String[] imgText = { "text relevant to image1","text 2"};
        for(int i =0; i < imgText.length && i < imgIcons.length; i ++){
            ApodInformation current = new ApodInformation();
            current.apodCurrImg = imgIcons[i];
            current.apodCurrText = imgText[i];
            data.add(current);
        }

        return data;
    }
}


//public class ApodActivity extends ActionBarActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_recyclerview_apod);
//    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_apod, menu);
//        return true;
//    }
//
//
//}

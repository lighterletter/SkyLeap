package lighterletter.c4q.nyc.skyleap.features.features.todo;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import lighterletter.c4q.nyc.skyleap.R;


public class ToDo extends Fragment {

    private TextView space;

    public  ToDo getInstance(int position) {
        ToDo myFragment = new ToDo();

        Bundle args = new Bundle();
        args.putInt("position",position);
        myFragment.setArguments(args);

        return myFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View layout = inflater.inflate(R.layout.activity_to_do, container, false);
        space =  (TextView) layout.findViewById(R.id.todo);
        Bundle bundle = getArguments();


        if (bundle != null){
            Log.v("OnCrateViewSapace", " 00");
            space.setText(" this stuff is a weather string"+bundle.getInt("position"));
        }
        return layout;

    }
}

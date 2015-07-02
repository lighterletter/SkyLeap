package lighterletter.c4q.nyc.skyleap.features.features.space;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import lighterletter.c4q.nyc.skyleap.R;

/**
 * Created by c4q-john on 7/1/15.
 */
public class SpaceFrag extends Fragment {

    private TextView space;

    public  SpaceFrag getInstance(int position) {
        SpaceFrag myFragment = new SpaceFrag();

        Bundle args = new Bundle();
        args.putInt("position",position);
        myFragment.setArguments(args);

        return myFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View layout = inflater.inflate(R.layout.fragment_layout_apod_card, container, false);
        space =  (TextView) layout.findViewById(R.id.apo_test_textview);
        Bundle bundle = getArguments();


        if (bundle != null){
            Log.v("OnCrateViewSapace"," 00");
            space.setText(" this stuff is a weather string"+bundle.getInt("position"));
        }
        return layout;

    }
}

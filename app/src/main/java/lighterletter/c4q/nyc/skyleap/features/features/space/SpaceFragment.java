package lighterletter.c4q.nyc.skyleap.features.features.space;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import lighterletter.c4q.nyc.skyleap.R;

/**
 * Created by c4q-john on 7/1/15.
 */
public class SpaceFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private ListFragmentAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;



    static final String API_ADDRESS = "https://api.nasa.gov/planetary/apod?concept_tags=True&api_key=JZlUTUQTFxv6gSpRDXJw8DcXgoUWvGgo8UBbDnpK&date=";


    public SpaceFragment getInstance(int position) {
        SpaceFragment myFragment = new SpaceFragment();
        Bundle args = new Bundle();
        args.putInt("position",position);
        myFragment.setArguments(args);
        return myFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_layout_apod_card, container, false);
        return layout;

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.my_recycler_view);
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);
        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new ListFragmentAdapter();
        mRecyclerView.setAdapter(mAdapter);


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        new AsyncT().execute(10);
    }







    class AsyncT extends AsyncTask<Integer, Wrapper, List>{
        @Override
        protected void onProgressUpdate(Wrapper... values) {
            super.onProgressUpdate(values);

            Log.d("progress", values[0].toString());
            Wrapper wrapper = values[0];
            mAdapter.addItem(wrapper);
            //mAdapter.add(wrapper);
        }
        @Override
        protected List doInBackground(Integer... ints) {


            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.US);

            int days = ints[0];
            Calendar calendar = Calendar.getInstance();
            for (int i = 0; i < days; i++){
                calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH) - 1);
                Date date = calendar.getTime();
                String url = API_ADDRESS +sdf.format(date);

                String result = downloadJson(url);

                if (result != null) {
                    try {
                        JSONObject object = new JSONObject(result);

                        Wrapper wrapper = new Wrapper();
                        wrapper.url= object.getString("url");
                        wrapper.mediaType = object.getString("media_type");
                        wrapper.explanation = object.getString("explanation");
                        //publishProgress(wrapper);
                        publishProgress(wrapper);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
                Log.d("result", result);
            }
            return null;
        }

        @Override
        protected void onPostExecute(List list) {
            super.onPostExecute(list);
        }

        String downloadJson(String url){

            InputStream inputStream = null;
            String result = "";

            try {
                // Set up HTTP post

                // HttpClient is more then less deprecated. Need to change to URLConnection
                HttpClient httpClient = new DefaultHttpClient();

                HttpGet httpPost = new HttpGet(url);
                HttpResponse httpResponse = httpClient.execute(httpPost);
                HttpEntity httpEntity = httpResponse.getEntity();

                // Read content & Log
                inputStream = httpEntity.getContent();
            } catch (UnsupportedEncodingException e1) {
                Log.e("UnsupEncodingException", e1.toString());
                e1.printStackTrace();
            } catch (ClientProtocolException e2) {
                Log.e("ClientProtocolException", e2.toString());
                e2.printStackTrace();
            } catch (IllegalStateException e3) {
                Log.e("IllegalStateException", e3.toString());
                e3.printStackTrace();
            } catch (IOException e4) {
                Log.e("IOException", e4.toString());
                e4.printStackTrace();
            }
            // Convert response to string using String Builder
            try {
                BufferedReader bReader = new BufferedReader(new InputStreamReader(inputStream, "utf-8"), 8);
                StringBuilder sBuilder = new StringBuilder();

                String line = null;
                while ((line = bReader.readLine()) != null) {
                    sBuilder.append(line + "\n");
                }

                inputStream.close();
                result = sBuilder.toString();

            } catch (Exception e) {
                Log.e("StringBuBufferedReader", "Error converting result " + e.toString());
            }
        // protected Void doInBackground(String... params)
            return result;
        }

    }
    public static class Wrapper{
        String url;
        String explanation;
        String mediaType;

        @Override
        public String toString() {
            return url;
        }
    }

}


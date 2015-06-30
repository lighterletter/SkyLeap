package lighterletter.c4q.nyc.skyleap;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

/**
 * Created by c4q-john on 6/29/15.
 */
public class WeatherVHRVAdapter extends RecyclerView.Adapter<WeatherVHRVAdapter.MyViewHolder>{

    private LayoutInflater inflater;
    List<WeatherInformation> data = Collections.emptyList();

    public WeatherVHRVAdapter(Context context, List<WeatherInformation> data){
        inflater = LayoutInflater.from(context);
        this.data = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.fragment_layout_weather_card, parent,false);
        MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        WeatherInformation current = data.get(position);
        //holder.weatherImageView.setImageURI();

        holder.weatherTextContent.setText(current.weatherCurrText);
        holder.weatherImgId.setImageResource(current.weatherCurrImg);
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView weatherImgId; //images use the int.
        TextView weatherTextContent;

        public MyViewHolder(View itemView){

            super(itemView);
            weatherImgId = (ImageView)itemView.findViewById(R.id.weatherImageView);
            weatherTextContent = (TextView) itemView.findViewById(R.id.my_Weather_textview);


        }

    }
}


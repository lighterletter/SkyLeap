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
 * Created by c4q-john on 6/30/15.
 */
public class ApodVHRVAdapter extends RecyclerView.Adapter<ApodVHRVAdapter.MyApodViewHolder>{

    private LayoutInflater inflater;
    List<ApodInformation> data = Collections.emptyList();

    public ApodVHRVAdapter(Context context, List<ApodInformation> data){
        inflater = LayoutInflater.from(context);
        this.data = data;
    }

    @Override
    public MyApodViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.fragment_layout_apod_card, parent,false);
        MyApodViewHolder holder = new MyApodViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(MyApodViewHolder holder, int position) {
        ApodInformation current = data.get(position);
        //holder.weatherImageView.setImageURI();

        holder.apodTextContent.setText(current.apodCurrText);
        holder.apodImgId.setImageResource(current.apodCurrImg);
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class MyApodViewHolder extends RecyclerView.ViewHolder {

        ImageView apodImgId; //images use the int.
        TextView apodTextContent;

        public MyApodViewHolder(View itemView){

            super(itemView);
            apodImgId = (ImageView)itemView.findViewById(R.id.weatherImageView);
            apodTextContent = (TextView) itemView.findViewById(R.id.my_Weather_textview);


        }

    }
}

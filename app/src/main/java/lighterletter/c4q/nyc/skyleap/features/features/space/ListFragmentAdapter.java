package lighterletter.c4q.nyc.skyleap.features.features.space;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import lighterletter.c4q.nyc.skyleap.R;

/**
 * Created by c4q-john on 7/23/15.
 */
public class ListFragmentAdapter extends RecyclerView.Adapter{


    final List<SpaceFragment.Wrapper> list;
    static final String TAG = "ListFragmentAdapter";

    public ListFragmentAdapter() {
        this.list = new ArrayList<>();
    }

    public void addItem(SpaceFragment.Wrapper wrapper){
        list.add(wrapper);
        notifyItemInserted(list.size()-1);
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.space_layout,parent, false);

        SpaceDataHolder holder = new SpaceDataHolder(view);
        Log.v(TAG, "oncreate view holder");



        return holder;
    }


    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
       final  int height = holder.itemView.getContext().getResources().getDimensionPixelSize(R.dimen.image_height);
        int width = holder.itemView.getWidth();
        Log.d(TAG, "width: " + width);

        if(width <= 0){
            holder.itemView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                @Override
                public void onGlobalLayout() {
                    int width = holder.itemView.getWidth();

                    holder.itemView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    loadImage(holder.itemView.getContext(),
                            (SpaceDataHolder) holder,list.get(position).url,width,height);
                }
            });
        } else {
            loadImage(holder.itemView.getContext(),
                    (SpaceDataHolder) holder,list.get(position).url,width,height);
        }

        ((SpaceDataHolder) holder).mTextViewExplanation.setText(list.get(position).explanation);

        Log.v(TAG, "on bind view holder");


    }

    private void loadImage(Context context, final SpaceDataHolder holder, String url, int width, int height) {
        holder.imgLoader.setVisibility(View.VISIBLE);
        Picasso.with(context)
                .load(url)
                .resize(width, height+50)
                .centerCrop()
                .into(holder.getmImageView(), new Callback() {
                    @Override
                    public void onSuccess() {
                        holder.imgLoader.setVisibility(View.INVISIBLE);
                    }

                    @Override
                    public void onError() {
                        holder.imgLoader.setVisibility(View.INVISIBLE);

                    }
                });
    }


    @Override
    public int getItemCount() {
        return list.size();
    }


    private class SpaceDataHolder extends RecyclerView.ViewHolder {

        ImageView mImageView;
        TextView mTextViewExplanation;
        ProgressBar imgLoader;



        public SpaceDataHolder(View itemView) {
            super(itemView);
            mImageView = (ImageView) itemView.findViewById(R.id.imageView_space);
            mTextViewExplanation = (TextView) itemView.findViewById(R.id.textView_space);
            imgLoader = (ProgressBar) itemView.findViewById(R.id.img_loader);

        }


        public ImageView getmImageView() {
            return mImageView;
        }

        public void setmImageView(ImageView mImageView) {
            this.mImageView = mImageView;
        }

        public TextView getmTextViewExplanation() {
            return mTextViewExplanation;
        }

        public void setmTextViewExplanation(TextView mTextViewExplanation) {
            this.mTextViewExplanation = mTextViewExplanation;
        }
    }
}

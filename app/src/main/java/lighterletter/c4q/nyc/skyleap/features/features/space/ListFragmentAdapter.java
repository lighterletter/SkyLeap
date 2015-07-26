package lighterletter.c4q.nyc.skyleap.features.features.space;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import lighterletter.c4q.nyc.skyleap.R;

/**
 * Created by c4q-john on 7/23/15.
 */
public class ListFragmentAdapter extends RecyclerView.Adapter{


    final List<SpaceFragment.Wrapper> list;

    public ListFragmentAdapter() {
        this.list = new ArrayList<>();
    }

    public void setList(List<SpaceFragment.Wrapper> listWrapper){
        list.addAll(listWrapper);
        notifyDataSetChanged();
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.space_layout,parent, false);

        SpaceDataHolder holder = new SpaceDataHolder(view);



        return holder;
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        Picasso.with(((SpaceDataHolder)holder).getmImageView().getContext()).load(list.get(position).url).into(((SpaceDataHolder) holder).getmImageView());


    }


    @Override
    public int getItemCount() {
        return list.size();
    }


    private class SpaceDataHolder extends RecyclerView.ViewHolder {

        ImageView mImageView;
        TextView mTextViewExplanation;



        public SpaceDataHolder(View itemView) {
            super(itemView);
            mImageView = (ImageView) itemView.findViewById(R.id.imageView_space);
            mTextViewExplanation = (TextView) itemView.findViewById(R.id.textView_space);

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

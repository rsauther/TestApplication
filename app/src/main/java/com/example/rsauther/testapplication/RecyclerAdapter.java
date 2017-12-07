package com.example.rsauther.testapplication;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by rsauther on 11/12/17.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    //private List<Advertisement> mItems = new ArrayList<>();
    private List<Object> mItems = new ArrayList<>();
    private Context mContext;
    private TextView adColorText;

    public RecyclerAdapter(Context context) {
        //this.mList = list;
        this.mContext = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View v;
//        v = inflater.inflate(R.layout.relative, parent, false);
//        AdViewHolder holder = new AdViewHolder(v);
        v = inflater.inflate(R.layout.viewholder_card, parent, false);
//        v = inflater.inflate(R.layout.viewholder_contact, parent, false);
        ContactViewHolder holder = new ContactViewHolder(v);
        return holder;
    }



    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position){
//        ((AdViewHolder)holder).bind((Advertisement)mItems.get(position));
        ((ContactViewHolder)holder).bind((Contact)mItems.get(position));

    }
    //, new View.OnClickListener() }

      //  {
      //      @Override
      //      public void onClick(View view) {
      //          mListener.onListener(mItems.get(position));
      //      }
   // });

    @Override
    public int getItemCount() {
        return mItems.size();

    }

//    public void addItem(Advertisement a){
//        mItems.add(a);
//    }
public void addItem(Object o){
    mItems.add(o);
}

}

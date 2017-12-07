package com.example.rsauther.testapplication;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by rsauther on 10/19/17.
 */

public class AdViewHolder extends RecyclerView.ViewHolder {

    private Context mContext;
    private TextView adColorText;
    private TextView adColorText2;
    private TextView adColorText3;

    public AdViewHolder(View itemView) {

        super(itemView);
        mContext = itemView.getContext();
//        adColorText = (TextView) itemView.findViewById(R.id.ad_view);
        adColorText = (TextView) itemView.findViewById(R.id.text1);
        adColorText2 = (TextView) itemView.findViewById(R.id.text2);
        adColorText3 = (TextView) itemView.findViewById(R.id.button1);

    }


//    public void bind(Advertisement advertisement, View.OnClickListener adListener) {
//
//        adColorText.setBackgroundColor(advertisement.getBackgroundColor());
//        adColorText.setText(advertisement.getAdColorText());
//        adColorText.setOnClickListener(adListener);
//
//    }

    public void bind(Advertisement advertisement) {

        adColorText.setBackgroundColor(advertisement.getBackgroundColor());
        adColorText.setText(advertisement.getAdColorText());
        adColorText2.setBackgroundColor(advertisement.getBackgroundColor());
        adColorText2.setText(advertisement.getAdColorText());
        adColorText3.setBackgroundColor(advertisement.getBackgroundColor());
       // adColorText.setOnClickListener(adListener);

    }

}

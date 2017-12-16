package com.example.android.lenguajesenextinsion.adapter;

import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.android.lenguajesenextinsion.R;
import com.example.android.lenguajesenextinsion.model.Palabra;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Palabra> {

    private int mColorResourceID;

    public WordAdapter(Activity context, ArrayList<Palabra> numbersSpanish, int colorResourceID) {
        super(context, 0, numbersSpanish);
        mColorResourceID = colorResourceID;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        Palabra currenWord = getItem(position);

        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        miwokTextView.setText(currenWord.getMiwokTraslation());

        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        defaultTextView.setText(currenWord.getDefaultTraslation());

        ImageView imageResource = (ImageView) listItemView.findViewById(R.id.image_language);

        if(currenWord.hasImage()) {
            imageResource.setImageResource(currenWord.getImageResourceID());
            imageResource.setVisibility(View.VISIBLE);
        } else {
            imageResource.setVisibility(View.GONE);
        }

        LinearLayout textContainer = (LinearLayout) listItemView.findViewById(R.id.text_container);
        //int color = ContextCompat.getColor(getContext(), mColorResourceID);
        textContainer.setBackgroundResource(mColorResourceID);

        return listItemView;
    }
}
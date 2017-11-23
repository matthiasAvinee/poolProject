package com.example.hippolyte.pools;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by thomas on 16/11/2017.
 */

public class PoolAdaptater extends ArrayAdapter<HashMap<String,String>>{

    public PoolAdaptater(Activity context, ArrayList mapArrayList) {
        super(context, 0, mapArrayList);
    }
    @Override
    public View getView(int position,  View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_pool,parent, false);
        }

        PoolViewHolder viewHolder = (PoolViewHolder) convertView.getTag();
        if(viewHolder == null){
            viewHolder = new PoolViewHolder();
            viewHolder.nom = (TextView) convertView.findViewById(R.id.nom);
            viewHolder.ville = (TextView) convertView.findViewById(R.id.ville);
            viewHolder.image = (ImageView) convertView.findViewById(R.id.image);
            convertView.setTag(viewHolder);
        }
        HashMap<String,String> pool = getItem(position);

        viewHolder.nom.setText(pool.get("libelle"));
        viewHolder.ville.setText(pool.get("ville"));
        if (pool.get("municipale").equals("true")){
            viewHolder.image.setImageDrawable(new ColorDrawable(Color.GREEN));
        }else{
            viewHolder.image.setImageDrawable(new ColorDrawable(Color.RED));
        }

        return convertView;
    }

    private class PoolViewHolder{
        public TextView nom ;
        public TextView ville;
        public ImageView image;
    }
}
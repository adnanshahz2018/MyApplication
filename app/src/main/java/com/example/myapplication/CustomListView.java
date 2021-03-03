package com.example.myapplication;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CustomListView extends ArrayAdapter<String> {
    private String [] names ;
    private String [] emails;
    private Integer [] imgid;
    private Activity context;

    public CustomListView(Activity context, String [] names, String [] emails, Integer [] imgid ) {
        super(context, R.layout.listview_layout, names);
        this.context = context;
        this.emails = emails;
         this.names = names;
        this.imgid = imgid;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View r = convertView;
        ViewHolder viewHolder = null;

        if(r==null){
            LayoutInflater li = context.getLayoutInflater();
            r = li.inflate(R.layout.listview_layout,null,true);
            viewHolder = new ViewHolder(r);
            r.setTag(viewHolder);
        }
        else{
            viewHolder = (ViewHolder) r.getTag();
        }

        viewHolder.img.setImageResource(imgid[position]);
        viewHolder.name.setText(names[position]);
        viewHolder.email.setText(emails[position]);

        return r;
    }

    class ViewHolder {
        TextView name;
        TextView email;
        ImageView img;
        ViewHolder(View v)
        {
            name    = (TextView) v.findViewById(R.id.name);
            email   = (TextView) v.findViewById(R.id.email);
            img     = (ImageView) v.findViewById(R.id.imageView);
        }

    }
}

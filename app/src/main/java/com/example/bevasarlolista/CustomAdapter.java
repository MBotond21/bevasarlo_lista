package com.example.bevasarlolista;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class CustomAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater inflater;
    private List<String> items;
    private List<String> quantitys;

    public CustomAdapter(Context context, List<String> items, List<String> quantitys) {
        this.inflater = LayoutInflater.from(context);
        this.items = items;
        this.quantitys = quantitys;
    }

    @Override
    public int getCount() { return this.items.size(); }

    @Override
    public Object getItem(int position) { return this.items.get(position); }

    @Override
    public long getItemId(int position) { return position; }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        convertView = inflater.inflate(R.layout.row_item, parent, false);

        TextView item_name = convertView.findViewById(R.id.item_name);
        TextView quantity = convertView.findViewById(R.id.item_quantity);

        item_name.setText(items.get(position));
        quantity.setText(quantitys.get(position));

        return convertView;

    }
}

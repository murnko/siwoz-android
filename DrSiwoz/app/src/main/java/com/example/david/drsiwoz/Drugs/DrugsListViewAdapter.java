package com.example.david.drsiwoz.Drugs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.david.drsiwoz.Models.Drug;
import com.example.david.drsiwoz.R;

import java.util.List;

/**
 * Created by jacek on 26.05.16.
 */
public class DrugsListViewAdapter extends ArrayAdapter<Drug> {
    private final Context context;
    private final List<Drug> values;

    public DrugsListViewAdapter(Context context, List<Drug> values) {
        super(context, R.layout.drug_list_item, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.drug_list_item, parent, false);
        TextView drugNameTextView = (TextView) rowView.findViewById(R.id.drugNameTextView);
        TextView drugDosageTextView = (TextView) rowView.findViewById(R.id.drugDosageTextView);
        TextView drugUnitTextView = (TextView) rowView.findViewById(R.id.drugUnitTextView);
        drugNameTextView.setText(values.get(position).getName());
        drugDosageTextView.setText(String.valueOf(values.get(position).getDosage()));
        drugUnitTextView.setText(values.get(position).getUnit());

        return rowView;
    }
}

package com.example.david.drsiwoz.Drugs;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.david.drsiwoz.MainActivity;
import com.example.david.drsiwoz.Models.Drug;
import com.example.david.drsiwoz.Models.Serving;
import com.example.david.drsiwoz.R;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by jacek on 26.05.16.
 */
public class DrugsListViewAdapter extends ArrayAdapter<Serving> {
    private final Context context;
    private final List<Serving> values;
    private List<String> checkedServingsId;
    final Integer appliedColor = getContext().getResources().getColor(android.R.color.holo_green_light);
    final Integer canceledColor = getContext().getResources().getColor(android.R.color.holo_red_light);
    final Integer acceptedColor = getContext().getResources().getColor(android.R.color.holo_blue_bright);
    final Integer suspendedColor = getContext().getResources().getColor(android.R.color.holo_orange_dark);

    public DrugsListViewAdapter(Context context, List<Serving> values) {
        super(context, R.layout.drug_list_item, values);
        this.context = context;
        this.values = values;
        this.checkedServingsId = new ArrayList<>(values.size());

    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.drug_list_item, parent, false);


        TextView drugNameTextView = (TextView) rowView.findViewById(R.id.drugNameTextView);
        TextView drugDosageTextView = (TextView) rowView.findViewById(R.id.drugDosageTextView);
        TextView drugUnitTextView = (TextView) rowView.findViewById(R.id.drugUnitTextView);
        final CheckBox checkBox = (CheckBox) rowView.findViewById(R.id.drugCheckBox);
        final Serving serving = values.get(position);
        drugNameTextView.setText(serving.getName());
        drugDosageTextView.setText(String.valueOf(serving.getDosage()));
        drugUnitTextView.setText(serving.getUnit());

        checkBox.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (checkBox.isChecked()){
                    checkedServingsId.add(serving.getId());
                }
                else{ checkedServingsId.remove(serving.getId());
                }
            }
        });

//        else{
//            checkedServingsId.add(position, null);
//
//        }


        if (serving.isApplied().booleanValue()){
            drugNameTextView.setBackgroundColor(appliedColor);
            drugDosageTextView.setBackgroundColor(appliedColor);
            drugUnitTextView.setBackgroundColor(appliedColor);
        }

        if (serving.isCancelled().booleanValue()){
            drugNameTextView.setBackgroundColor(canceledColor);
            drugDosageTextView.setBackgroundColor(canceledColor);
            drugUnitTextView.setBackgroundColor(canceledColor);
        }

        if (serving.isAccepted().booleanValue()){
            drugNameTextView.setBackgroundColor(acceptedColor);
            drugDosageTextView.setBackgroundColor(acceptedColor);
            drugUnitTextView.setBackgroundColor(acceptedColor);
        }

        if (serving.isSuspended().booleanValue()){
            drugNameTextView.setBackgroundColor(suspendedColor);
            drugDosageTextView.setBackgroundColor(suspendedColor);
            drugUnitTextView.setBackgroundColor(suspendedColor);
        }

        return rowView;
    }

    public List<String> getCheckedServingsId(){
        return checkedServingsId;
    }
}

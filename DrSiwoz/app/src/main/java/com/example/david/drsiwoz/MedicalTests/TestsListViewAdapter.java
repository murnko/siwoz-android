package com.example.david.drsiwoz.MedicalTests;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.david.drsiwoz.Models.MedicalTest;
import com.example.david.drsiwoz.R;

import java.util.List;

/**
 * Created by david on 2016-06-05.
 */
public class TestsListViewAdapter extends ArrayAdapter{
    private final Context context;
    private final List<MedicalTest> values;
    final Integer doneColor = getContext().getResources().getColor(android.R.color.holo_green_light);
    final Integer progressColor = getContext().getResources().getColor(android.R.color.holo_red_light);


    public TestsListViewAdapter(Context context, List<MedicalTest> values) {
        super(context, R.layout.medTest_list_item, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.medTest_list_item, parent, false);


        TextView descTextView = (TextView) rowView.findViewById(R.id.doctorNameTextView);
        TextView docNameTextView = (TextView) rowView.findViewById(R.id.examinationDescriptionTextView);
        TextView createdTextView = (TextView) rowView.findViewById(R.id.examinationDateTextView);
        TextView statusTextView = (TextView) rowView.findViewById(R.id.examinationStatusTextView);
        MedicalTest test = values.get(position);




        if (test.getStatus() == "Done"){
            statusTextView.setBackgroundColor(doneColor);
        }
        if (test.getStatus() == "InProgress"){
            statusTextView.setBackgroundColor(progressColor);
        }




        return rowView;
    }
}

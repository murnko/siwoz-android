package com.example.david.drsiwoz.MedicalTests;

import android.content.Context;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.example.david.drsiwoz.Models.MedicalTest;
import com.example.david.drsiwoz.R;

import java.util.List;

/**
 * Created by david on 2016-06-05.
 */
public class TestsListViewAdapter extends BaseExpandableListAdapter {
    private final Context context;
    private final List<MedicalTest> values;

    public TestsListViewAdapter(Context context, List<MedicalTest> values) {
        this.context = context;
        this.values = values;
    }

    @Override
    public int getGroupCount() {
        return values.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return values.get(groupPosition).getmResults().size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return values.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        MedicalTest test = (MedicalTest) getGroup(groupPosition);
        return test.getmResults().get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.medtest_list_item, null);
        }
        TextView testNameTextView = (TextView) convertView.findViewById(R.id.testNameTextView);
        TextView testStatusTextView = (TextView) convertView.findViewById(R.id.testStatusTextView);
        TextView testCreatedTextView = (TextView) convertView.findViewById(R.id.testCreatedTestView);

        MedicalTest test = (MedicalTest) getGroup(groupPosition);

        testCreatedTextView.setText(test.getCreated());
        testStatusTextView.setText(test.getStatus());
        testNameTextView.setText(test.getDoctorName());

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.medtest_list_item_row, null);
        }
        TextView testParamTextView = (TextView) convertView.findViewById(R.id.testParameterTextView);
        TextView testValueTextView = (TextView) convertView.findViewById(R.id.testValueTextView);

        Pair<String, String> item = (Pair<String, String>) getChild(groupPosition, childPosition);
        testParamTextView.setText(item.first);
        testValueTextView.setText(item.second);

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}

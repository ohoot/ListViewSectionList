package com.example.joo.listviewselectionlist;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.TextView;

/**
 * Created by Joo on 2016-01-22.
 */
public class GroupView extends FrameLayout {
    public GroupView(Context context) {
        super(context);
        init();
    }

    TextView textHeader;

    private void init() {
        inflate(getContext(), R.layout.view_header, this);
        textHeader = (TextView) findViewById(R.id.textHeader);
    }

    public void setViewData(GroupItem groupItem) {
        textHeader.setText(groupItem.groupName.toString());
    }
}

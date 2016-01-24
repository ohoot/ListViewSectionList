package com.example.joo.listviewselectionlist;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.TextView;

/**
 * Created by Joo on 2016-01-22.
 */
public class ChildView extends FrameLayout {
    public ChildView(Context context) {
        super(context);
        init();
    }

    TextView textItem;

    private void init() {
        inflate(getContext(), R.layout.view_item, this);
        textItem = (TextView) findViewById(R.id.textItem);
    }

    public void setViewData(GroupItem groupItem, int childIndex) {
        textItem.setText(groupItem.children.get(childIndex).childName);
    }
}

package com.example.joo.listviewselectionlist;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Joo on 2016-01-22.
 */
public class SectionAdapter extends BaseAdapter {
    public static final int VALUE_ZERO = 0;
    public static final int VALUE_ONE = 1;

    List<GroupItem> items = new ArrayList<GroupItem>();

    @Override
    public int getCount() {
        int childSize = VALUE_ZERO;
        for (GroupItem g : items) {
            childSize += g.children.size();
        }
        return items.size() + childSize;
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        for (int i = VALUE_ZERO; i < items.size(); i++) {
            GroupItem group = items.get(i);
            if (position < VALUE_ONE) return VALUE_ZERO;
            position--;
            int childCount = group.children.size();
            if (position < childCount) return VALUE_ONE;
            position-=childCount;
        }
        return super.getItemViewType(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        int type = getItemViewType(position);

        if (type == VALUE_ZERO) {
            GroupView view;
            if (convertView != null && convertView instanceof GroupView) {
                view = (GroupView) convertView;
            } else {
               view = new GroupView(parent.getContext());
            }
            int groupIndex = getGroupIndex(position);
            view.setViewData(items.get(groupIndex));
            return view;
        } else {
            ChildView view;
            if (convertView != null && convertView instanceof ChildView) {
                view = (ChildView) convertView;
            } else {
               view = new ChildView(parent.getContext());
            }
            int[] childInfo = getChildIndex(position);
            view.setViewData(items.get(childInfo[VALUE_ZERO]), childInfo[VALUE_ONE]);
            return view;
        }
    }

    private int getGroupIndex(int position) {
        int groupIndex = VALUE_ZERO;
        int childCount = VALUE_ZERO;
        int firstGroupSize = items.get(VALUE_ZERO).children.size();

        for (GroupItem g : items) {
            childCount += g.children.size();
            if (position > firstGroupSize) {
                groupIndex++;
            }
            if (position == VALUE_ZERO || position == groupIndex + childCount) {
                break;
            }
        }
        return groupIndex;
    }

    private int[] getChildIndex(int position) {
        int groupIndex;
        int childIndex;
        int itemsCount = VALUE_ZERO;

        for (groupIndex = VALUE_ZERO; groupIndex < items.size(); groupIndex++) {
            itemsCount += (items.get(groupIndex).children.size() + VALUE_ONE);
            if (itemsCount > position) break;
        }

        if (groupIndex == VALUE_ZERO) {
            childIndex = position - VALUE_ONE;
        } else {
            childIndex = position - (itemsCount - items.get(groupIndex).children.size());
        }
        return new int[]{groupIndex, childIndex};
    }

    public void putData(String groupName, String itemName) {
        GroupItem group = null;
        for (GroupItem g : items) {
            if (g.groupName.equals(groupName)) {
                group = g;
                break;
            }
        }

        if (group == null) {
            group = new GroupItem();
            group.groupName = groupName;
            items.add(group);
        }

        if (!TextUtils.isEmpty(itemName)) {
            group.children.add(new ChildItem(itemName));
        }
        notifyDataSetChanged();
    }
}

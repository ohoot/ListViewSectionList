package com.example.joo.listviewselectionlist;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Joo on 2016-01-22.
 */
public class GroupItem {
    String groupName;

    List<ChildItem> children = new ArrayList<ChildItem>();

    public GroupItem(){}

    public GroupItem (String content) {
        this.groupName = content;
    }
}

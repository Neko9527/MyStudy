package com.xcw.practice;

import java.util.*;

/**
 * @author wangxuechao
 * @date 2021-07-06
 */
public class LC1418 {


    public static void main(String[] args) {
        List<List<String>> ret = new ArrayList<>();
        List<String> list = new ArrayList<>();
        list.add("David");
        list.add("3");
        list.add("Ceviche");
        ret.add(list);
        List<String> list1 = new ArrayList<>();
        list1.add("David");
        list1.add("3");
        list1.add("Fried Chicken");
        ret.add(list1);
        List<String> list2 = new ArrayList<>();
        list2.add("Corina");
        list2.add("10");
        list2.add("Beef Burrito");
        ret.add(list2);
        displayTable(ret);
    }

    public static List<List<String>> displayTable(List<List<String>> orders) {

        List<List<String>> ret = new ArrayList<>();
        Map<String,Integer> menu = new TreeMap<>();
        Map<Integer,Map> table = new TreeMap<>();
        //有序的保存所有的菜名
        for (int i = 0; i < orders.size(); i++) {
            String menuKey = orders.get(i).get(2);
            if(!menu.containsKey(menuKey)) {
                menu.put(menuKey,0);
            }
        }
        //计算每桌点的菜数量
        for (int i = 0; i < orders.size(); i++) {
            String menuKey = orders.get(i).get(2);
            Integer tableKey = Integer.valueOf(orders.get(i).get(1));
            if(!table.containsKey(tableKey)) {
                Map<String,Integer> tmp = new TreeMap<>();
                tmp.putAll(menu);
                table.put(tableKey,tmp);
            }
            Map<String,Integer> map = table.get(tableKey);
            map.put(menuKey,map.get(menuKey) != null ?  map.get(menuKey) + 1 : 1);
        }

        // first row title
        List<String> titleList = new ArrayList<>();
        titleList.add("Table");
        menu.forEach((key,i) -> {
            titleList.add(key);
        });
        ret.add(titleList);


        table.forEach((key, map) -> {
            List<String> list = new ArrayList<>();
            list.add(key.toString());
            map.forEach((mk,num)->{
                list.add(num.toString());
            });
            ret.add(list);
        });
        return ret;
    }
}

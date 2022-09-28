package org.concept.collections.map.ex10;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DataSetContainer {
    public static void main(String[] arrays) {
        executeEx101();
        executeEx102();
    }

    public static void executeEx101() {
        Set<UserData> userDataSet = new HashSet<UserData>();
        userDataSet.add(new UserData(101, "ONE", true));
        userDataSet.add(new UserData(102, "TWO", true));
        userDataSet.add(new UserData(101, "ONE", true));
        System.out.println(userDataSet.size());
        System.out.println(userDataSet);
    }

    public static void executeEx102() {
        Map<UserData, String> userDataMap = new HashMap<UserData, String>();
        userDataMap.put(new UserData(101, "ONE", true), "101-ONE");
        userDataMap.put(new UserData(102, "TWO", true), "102-TWO");
        userDataMap.put(new UserData(101, "ONE", true), "101-ONE");
        System.out.println(userDataMap.size() + " => " + userDataMap);
        UserData findData = new UserData(101, "ONE", true);
        System.out.println(userDataMap.get(findData));
    }
}

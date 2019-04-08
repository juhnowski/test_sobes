package com.juhnowski;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    static String[] data={"abc", "bac", "abc", "d","et","d","et","zzz"};

    public static void main(String[] args) {


        List<String> list = Arrays.asList(data);
        list.replaceAll(x->sortString(x));

        HashMap<String,ArrayList<Integer>> result = new HashMap<>();

        for ( int i=0; i< list.size(); i++){
            String s = list.get(i);
            if (result.get(s) == null){
                ArrayList<Integer> arr = new ArrayList<>();
                arr.add(i);
                result.put(s, arr);
            } else {
                result.get(s).add(i);
            }
        }

        result.forEach((k,v)->{
            StringBuilder sb = new StringBuilder();
            if (v.size()>1){
                sb.append(k).append(" ");
                for (Integer s:v){
                    sb.append(s);
                    sb.append(",");
                }
                System.out.println(sb.toString());
            }

        });

    }

    public static String sortString(String inputString)
    {
        char tempArray[] = inputString.toCharArray();
        Arrays.sort(tempArray);
        return new String(tempArray);
    }
}

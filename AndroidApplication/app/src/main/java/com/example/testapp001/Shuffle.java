package com.example.testapp001;

import android.content.res.TypedArray;

import java.util.ArrayList;
import java.util.Collections;

public class Shuffle {
    private static ArrayList<Integer> list = new ArrayList<Integer>();
    Shuffle(TypedArray typedArray){
        for (int i=0; i< typedArray.length(); i++){
            list.add(i);
        }
        Collections.shuffle(list);
    }
    public ArrayList<Integer> getList(){
        return list;
    }
}

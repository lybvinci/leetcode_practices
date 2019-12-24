package com.monster.learn;

import java.util.ArrayList;
import java.util.List;

//40.43%
public class MagicalString {
  public int magicalString(int n) {
    int retData = 1;
    List<Integer> dataList = new ArrayList<>();
    dataList.add(1);
    dataList.add(2);
    dataList.add(2);
    if(n<=3){
        if(n <= 0){
            return 0;
        }
        return retData;
    }
    int currentPosition = 2;
    while (dataList.size() < n){
        int needData = dataList.get(currentPosition);
        int lastData = dataList.get(dataList.size() - 1);
        if(lastData == 1){
            for(int i= 0; i<needData; i++){
                dataList.add(2);
            }
        } else {
            for(int i= 0; i<needData; i++){
                dataList.add(1);
                retData++;
            }
        }
        currentPosition++;
    }
    if(dataList.size() > n && dataList.get(dataList.size()-1) == 1){
        retData--;
    }
    return retData;
  }
}
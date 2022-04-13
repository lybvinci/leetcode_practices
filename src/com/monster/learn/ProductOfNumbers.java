package com.monster.learn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

//55.22%
public class ProductOfNumbers {
  private List<Integer> products;

  public ProductOfNumbers() {
    products = new ArrayList<>();
    products.add(1);
  }

  public void add(int num) {
    if(num == 0){
      products = new ArrayList<>();
      products.add(1);
    } else {
      products.add(products.get(products.size() - 1) * num);
    }
  }

  public int getProduct(int k) {
    if(products.size() <= k ){
      return 0;
    }
    return products.get(products.size() - 1) / products.get(products.size() - 1- k);
  }

}

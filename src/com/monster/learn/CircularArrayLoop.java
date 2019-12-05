package com.monster.learn;

//31.84%
public class CircularArrayLoop {
  public boolean circularArrayLoop(int[] nums) {
    if (nums.length < 2) {
      return false;
    }
    boolean retBoolean = false;
    for(int i=0; i<nums.length; i++){
        int j = i,k=getNextIndex(nums,i);
        while (nums[i] * nums[j] > 0 && nums[i]*nums[k] > 0 && nums[i] * nums[getNextIndex(nums,k)]>0){
            if(j==k){
                if(j==getNextIndex(nums,j)){
                    break;
                }
                return true;
            }
            j = getNextIndex(nums,j);
            k = getNextIndex(nums,getNextIndex(nums,k));
        }
    }
    return retBoolean;
  }

  private int getNextIndex(int[] nums, int i){
    int length = nums.length;
    int nextPosition = i + nums[i];
    return nextPosition >= 0 ? nextPosition%length:length + (nextPosition%length);
  }
}
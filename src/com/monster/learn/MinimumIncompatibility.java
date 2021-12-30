package com.monster.learn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

//9.38%
public class MinimumIncompatibility {

    public int minimumIncompatibility(int[] nums, int k) {
        k=nums.length/k;    //每份有len/k 个数（转换k的含义）
        int n = nums.length;
        int[] dp = new int[1<<n];
        Arrays.fill(dp,Integer.MAX_VALUE/2);
        dp[0]=0;
        for (int status = 1; status < (1<<n); status++) {
            int curBitCount = Integer.bitCount(status);
            if (curBitCount%k!=0) continue;
            for (int pre = status; pre >=0 ; pre = (pre-1)& status) {   //子集
                int preBitCount = Integer.bitCount(pre);
                if (preBitCount%k!=0) continue;
                int dif = curBitCount-preBitCount;
                if (dif==k){
                    if (check(status,pre,nums,dp)){ //判断子集是否合法， 即能否从dp[pre]转移到dp[cur]中
                        dp[status] =Math.min(dp[status],dp[pre]+dv);    //条件成立，进行转移
                    }
                }

                if (pre == 0) break;    //这个是子集生成中，跳出的死循环的
            }
        }
        return dp[dp.length-1]==Integer.MAX_VALUE/2?-1:dp[dp.length-1];
    }

    int dv;//各子集的最小兼容性
    //判断是否可以从dp[pre]转移到dp[cur]中
    private boolean check(int cur,int pre,int[] nums,int []dp){
        if (dp[pre] == Integer.MAX_VALUE/2) return false;   //pre状态不合法,所以不可能转移到cur了
        int xor = cur^pre;  //得出pre状态 和 cur状态 的不同
        int[] map = new int[17];    //用于一个子集中 元素 出现次数
        int idx= 0 ;
        //pre->转移到cur中，其中 子集元素出现次数 dp[cur]<-dp[pre]+ dif  (dif这个 子集的元素 )
        while (xor!=0){
            if ((xor&1)==1){
                map[nums[idx]]++;
            }
            idx++;
            xor>>=1;
        }


        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        dv=0;   //子集的 不兼容性
        for (int i = 0; i < map.length; i++) {
            if (map[i]==1){
                max =Math.max(max,i);
                min = Math.min(min,i);
            }
            if (map[i]>1) return false;  //同一 元素 出现了 多次
        }
        dv = max-min;
        return true;
    }


}

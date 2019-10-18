package com.monster.learn;

import java.util.Arrays;
import java.util.Comparator;

//40.17%
public class ReconstructQueue {
    public int[][] reconstructQueue(int[][] people) {
        int m = people.length, i, j, k, min = Integer.MAX_VALUE, minIndex = 0;
		int[][] temps = new int[m][2]; //由people数组复制得来，对这个数组进行操作
		int[] index = new int[m]; //记录最后的结果顺序
		boolean[] visited = new boolean[m]; //记录哪些元素已经被确定了位置
		for (i = 0; i < m; i++) {
			visited[i] = false;
			temps[i][0] = people[i][0];
			temps[i][1] = people[i][1];
		}
		for (i = 0; i < m; i++, min = Integer.MAX_VALUE) {
			for (j = 0; j < m; j++) {
				//寻找当前队列所有(h，k)中k=0，h最小的元素
				if (visited[j] == false && temps[j][1] == 0) {
					if (people[j][0] < min) {
						min = people[j][0];
						minIndex = j; //记录位置
					}
				}
			}
			visited[minIndex] = true;
			index[i] = minIndex;
			for (k = 0; k < m; k++) {
				if (visited[k] == false && temps[k][0] <= min) {
					temps[k][1]--;
				}
			}
		}
		for (i = 0; i < m; i++) {
			temps[i][0] = people[index[i]][0];
			temps[i][1] = people[index[i]][1];
		}
		return temps;
    }
}
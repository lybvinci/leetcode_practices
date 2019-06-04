package com.monster.learn;

public class CompareVersion165 {
    //8.27%
    public static int compareVersion(String version1, String version2) {
        if (null == version1 && version2 == null) {
            return 0;
        } else if (null == version1 && version2 != null) {
            return -1;
        } else if (null != version1 && version2 == null) {
            return 1;
        } else {
            if (version1.equals(version2)) {
                return 0;
            }
            String[] v1 = version1.split("\\.");
            String[] v2 = version2.split("\\.");
            int minLength = v1.length < v2.length ? v1.length : v2.length;
            int index = 0;
            for (; index < minLength; index++) {
                int i1 = Integer.parseInt(v1[index]);
                int i2 = Integer.parseInt(v2[index]);
                if (i1 == i2) {
                    continue;
                } else if (i1 > i2) {
                    return 1;
                } else {
                    return -1;
                }
            }
            if (index < v1.length) {
                for (; index < v1.length; index++) {
                    int i1 = Integer.parseInt(v1[index]);
                    if (i1 == 0) {
                        continue;
                    } else {
                        return 1;
                    }
                }
            }
            if (index < v2.length) {
                for (; index < v2.length; index++) {
                    int i2 = Integer.parseInt(v2[index]);
                    if (i2 == 0) {
                        continue;
                    } else {
                        return -1;
                    }
                }
            }
            return 0;
        }
    }

    public static void main(String[] args) {
        int i = Integer.parseInt("01");
        i = CompareVersion165.compareVersion("0.1", "1.1");
        System.out.println("is:" + i);
    }
}
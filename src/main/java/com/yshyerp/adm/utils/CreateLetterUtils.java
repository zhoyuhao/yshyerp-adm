package com.yshyerp.adm.utils;

import java.util.ArrayList;
import java.util.List;

public class CreateLetterUtils {

    /**
     * 生成两位的大写字母
     *
     * @return
     */
    public static  String createLetter(String code) throws IndexOutOfBoundsException {
        String az = "ABCDEFGHIJKLMNPQRSTUVWXYZ";
        List<String> al = new ArrayList<String>();
        //先写入26个大写字母
        for (int j = 0; j < az.length(); j++) {
            al.add(az.substring(j, j + 1));
        }
        //组合26个字母
        for (int i = 0; i < az.length(); i++) {
            for (int j = 0; j < az.length(); j++)
                al.add(az.substring(i, i + 1) + az.substring(j, j + 1));
        }
        //删除前面26个单字母
        for (int i = 0; i < 25; i++) {
            al.remove(0);
        }
        //遍历比较 往后移1位
        for (int i = 0; i < al.size(); i++) {
            if (al.get(i).equals(code)) {
                az = al.get(1 + i);
            }
        }
        return az;
    }
}

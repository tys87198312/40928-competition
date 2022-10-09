package com.dragee.utils;

import net.sourceforge.pinyin4j.PinyinHelper;

import java.io.IOException;

/** 汉字转拼音
 * @author tys on 11/26/20
 */
public class PinYinUtil {

    /** 中文转拼音首字母
     * @param text
     * @return
     */
    public static String getPinyinInitials(String text) {
                 StringBuilder sb = new StringBuilder();
                 for (int i = 0; i < text.length(); i++) {
                         char ch = text.charAt(i);
                         String[] s = PinyinHelper.toHanyuPinyinStringArray(ch);
                         if (s != null) {
                                 sb.append(s[0].charAt(0));
                             } else {
                                 sb.append(ch);
                             }
                     }
                 return sb.toString();
     }


    public static void main(String[] args) throws IOException {

    }
}

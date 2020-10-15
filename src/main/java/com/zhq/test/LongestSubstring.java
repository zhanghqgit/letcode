package com.zhq.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author zhanghengqiang
 * @date 2020/10/15
 * @time 10:04 上午
 * @email zhanghengqiang@jd.com
 */

public class LongestSubstring {

    /**
     * 遍历字符串,每遍历一个将字符加入缓存索引;
     * 若缓存索引中包含该字符,则更新起始位置至重复字符的下一个位置,并将缓存索引中该位置之前的字符删除掉
     * 继续遍历
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        Map<String, Integer> index = new HashMap<>();
        int longest = 1;
        List<String> subStr = new ArrayList<>();
        int startPosition = 0;
        int endPosition = 0;
        for (String c : s.split("")) {
            if (index.containsKey(c)) {
                subStr.add(s.substring(startPosition, endPosition));
                if (endPosition - startPosition > longest) {
                    longest = endPosition - startPosition;
                }
                startPosition = index.get(c) + 1;
                Map<String, Integer> temp = new HashMap<>();
                for (Map.Entry<String, Integer> entry : index.entrySet()) {
                    if (entry.getValue() >= startPosition) {
                        temp.put(entry.getKey(), entry.getValue());
                    }
                }
                index = temp;
            }
            index.put(c, endPosition);
            endPosition++;
        }
        System.out.println(subStr);
        return longest;
    }


    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
}

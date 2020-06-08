package com.danchel.sample;

import com.danchel.entity.User;
import com.danchel.util.CommonUtil;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: Dc Lee
 * @Description:
 * @Date: 11:28 2020/6/8
 */
public class FilterSample {

    private static List<User> userList = CommonUtil.getUserList();

    /**
     * 过滤筛选处所有学校是清华大学的user
     */
    public static void testFilter() {
        //1.过滤筛选处所有学校是清华大学的user
        System.out.println("学校是清华大学的user");
        List<User> userList1 = userList.stream().filter(user -> "清华大学".equals(user.getSchool())).collect(Collectors.toList());
        userList1.forEach(user -> System.out.print(user.getName() + '、'));
    }

    /**
     * 去重，我们希望获取所有user的年龄（年龄不重复）
     */
    public static void testDistinct() {
        System.out.println("所有user的年龄集合");
        List<Integer> userAgeList = userList.stream().map(User::getAge).distinct().collect(Collectors.toList());
        System.out.println("userAgeList = " + userAgeList);
    }

    /**
     * 返回前n个元素的流，当集合的长度小于n时，则返回所有集合。
     *
     * 如获取年龄是偶数的前2名user：
     */
    public static void testLimit() {
        System.out.println("年龄是偶数的前两位user");
        List<User> userList3 = userList.stream().filter(user -> user.getAge() % 2 == 0).limit(2).collect(Collectors.toList());
        userList3.forEach(user -> System.out.print(user.getName() + '、'));
    }

    /**
     * 排序，如现在我想将所有user按照age从大到小排序：
     */
    public static void testSorted() {
        System.out.println("按年龄从大到小排序");
        List<User> userList4 = userList.stream().sorted((s1,s2) -> s2.getAge() - s1.getAge()).collect(Collectors.toList());
        userList4.forEach(user -> System.out.print(user.getName() + '、'));
    }

    /**
     * 跳过n个元素后再输出
     *
     * 如输出list集合跳过前两个元素后的list
     */
    public static void testSkip() {
        System.out.println("跳过前面两个user的其他所有user");
        List<User> userList5 = userList.stream().skip(2).collect(Collectors.toList());
        userList5.forEach(user -> System.out.print(user.getName() + '、'));
    }

    public static void main(String[] args) {
        testFilter();
    }
}

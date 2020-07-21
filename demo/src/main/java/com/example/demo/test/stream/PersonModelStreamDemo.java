package com.example.demo.test.stream;

import com.example.demo.test.entity.Data;
import com.example.demo.test.entity.PersonModel;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * stream练习
 *
 * @author ZhaoXin
 * @date 2020/7/20 15:59
 */
public class PersonModelStreamDemo {

    /**
     * 过滤掉所有的男性
     */
    public static void filterSex() {
        List<PersonModel> list = Data.getData();

        // old
        List<PersonModel> temp = new ArrayList<>();
        for (PersonModel person : list) {
            if ("男".equals(person.getGender())) {
                temp.add(person);
            }
        }
        System.out.println(temp);

        System.out.println("---------------------");

        // new
        List<PersonModel> connect = list.stream().filter(person -> "男".equals(person.getGender())).peek(person -> System.out.println(person))
                .collect(Collectors.toList());

    }

    /**
     * 过滤所有男性，并小于二十岁
     */
    public static void filterSexAndAge() {
        List<PersonModel> list = Data.getData();

        // old
        List<PersonModel> temp = new ArrayList<>();
        for (PersonModel person : list
        ) {
            if ("男".equals(person.getGender()) && person.getAge() < 20) {
                temp.add(person);
            }
        }
        System.out.println(temp);
        System.out.println("--------------------");

        // new
        List<PersonModel> collect = list
                .stream()
                .filter(person -> {
                            if ("男".equals(person.getGender()) && person.getAge() < 20) {
                                return true;
                            }
                            return false;
                        }
                ).collect(Collectors.toList());
        System.out.println(collect);
        System.out.println("--------------------");

        // 3
        List<PersonModel> collect2 = list.stream()
                .filter(person -> "男".equals(person.getGender()) && person.getAge() < 20)
                .collect(Collectors.toList());
        System.out.println(collect2);
    }

    /**
     * 取出所有用户的名字
     */
    public static void mapGetUserNameList() {
        List<PersonModel> list = Data.getData();

        // 1
        List<String> nameList = new ArrayList<>();
        for (PersonModel person : list) {
            nameList.add(person.getName());
        }
        System.out.println(nameList);

        // 2
        List<String> collect = list.stream().map(person -> person.getName()).peek(person -> System.out.println(person)).collect(Collectors.toList());

        // 3
        List<String> collect3 = list.stream().map(PersonModel::getName).peek(System.out::println).collect(Collectors.toList());

        System.out.println();
        // 4
        List<String> collect4 = list.stream().map(person -> {
            System.out.println(person.getName());
            return person.getName();
        }).collect(Collectors.toList());
    }

    public static void flatMapString() {
        List<PersonModel> list = Data.getData();
        // 返回值类型不一样
        List<String> collect = list.stream()
                .flatMap(person -> Arrays.stream(person.getName().split(" "))).collect(Collectors.toList());
        System.out.println(collect);

        List<Stream<String>> collect1 = list.stream()
                .map(person -> Arrays.stream(person.getName().split(" "))).collect(Collectors.toList());

        //用map实现
        List<String> collect2 = list.stream()
                .map(person -> person.getName().split(" "))
                .flatMap(Arrays::stream).collect(Collectors.toList());
        //另一种方式
        List<String> collect3 = list.stream()
                .map(person -> person.getName().split(" "))
                .flatMap(str -> Arrays.asList(str).stream()).collect(Collectors.toList());
    }

    /**
     * 数字，字符串的累加
     */
    public static void reduceDemo() {
        // 累加， 初始化值是10
        //累加，初始化值是 10
        Integer reduce = Stream.of(1, 2, 3, 4)
                .reduce(10, (count, item) -> {
                    System.out.println("count:" + count);
                    System.out.println("item:" + item);
                    return count + item;
                });

        Integer reduce1 = Stream.of(1, 2, 3, 4)
                .reduce(0, (x, y) -> x + y);
        System.out.println(reduce1);

        String reduce2 = Stream.of("1", "2", "3")
                .reduce("0", (x, y) -> (x + "," + y));
        System.out.println(reduce2);
    }

    /**
     * collect在流中生成列表，map，等常用的数据结构
     * toList()
     * toSet()
     * toMap()
     * 自定义
     */
    public static void collectDemo() {
        List<PersonModel> list = Data.getData();
        // toList
        List<String> collect = list.stream()
                .map(PersonModel::getName)
                .peek(person -> System.out.println(person))
                .collect(Collectors.toList());

        // toMap
        Map<String, Integer> collect1 = list.stream()
                .collect(Collectors.toMap(PersonModel::getName, PersonModel::getAge));
        System.out.println(collect1);

        // toSet
        Set<String> collect2 = list.stream()
                .map(PersonModel::getName).collect(Collectors.toSet());

        Map<String, String> collect3 = list.stream().collect(Collectors.toMap(person -> person.getName(), value -> {
            return value + "1";
        }));
        System.out.println("collect3" + collect3);

        // 指定类型
        TreeSet<PersonModel> collect4 = list.stream()
                .collect(Collectors.toCollection(TreeSet::new));

        // 分组
        Map<Boolean, List<PersonModel>> collect5 = list.stream()
                .collect(Collectors.groupingBy(person -> "男".equals(person.getGender())));
        System.out.println("collect5" + collect5);

        // 分隔
        String collect6 = list.stream()
                .map(person -> person.getName())
                .collect(Collectors.joining(",", "{", "}"));
        System.out.println("collect6" + collect6);

        // 自定义
        List<String> collect7 = Stream.of("1", "2", "3").collect(
                Collectors.reducing(new ArrayList<String>(), x -> Arrays.asList(x), (y, z) -> {
                    y.addAll(z);
                    return y;
                }));
        System.out.println("collect7" + collect7);
    }

    public static void main(String[] args) {
        collectDemo();
    }
}

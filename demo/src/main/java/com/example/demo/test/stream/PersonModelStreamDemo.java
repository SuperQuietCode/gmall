package com.example.demo.test.stream;

import com.example.demo.test.entity.Data;
import com.example.demo.test.entity.PersonModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
        List<String> collect4 = list.stream().map(person->{
            System.out.println(person.getName());
            return person.getName();
        }).collect(Collectors.toList());
    }

    public static void flatMapString(){
        List<PersonModel> list = Data.getData();
        // 返回值类型不一样
        List<String> collect = list.stream()
                .flatMap(person-> Arrays.stream(person.getName().split(" "))).collect(Collectors.toList());
        System.out.println(collect);
    }

    public static void main(String[] args) {
        flatMapString();
    }
}

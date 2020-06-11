package com.example.demo.test.stream;

import com.example.demo.test.entity.Student;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * https://blog.csdn.net/y_k_y/article/details/84633001
 * 没啥太大的意义单纯熟悉一下
 * 2020提交
 *
 * @author ZhaoXin
 * @date 2020/6/11 13:33
 */
public class CollectionStreamDemo {
    public static void main(String[] args) throws FileNotFoundException {

        // 使用Collection下的stream()和parallelStream()方法
        List<String> list = new ArrayList<>();
        list.add("第一个");
        list.add("第二个");
        // 获取一个串行流
        System.out.println("---我是一个顺序流---");
        Stream<String> stringStream = list.stream();
        stringStream.forEach(System.out::println);
        // 获取一个并行流
        System.out.println("---我是一个并行流---");
        Stream<String> paralleStream = list.parallelStream();
        paralleStream.forEach(System.out::println);

        // 使用Arrays中得stream()方法，将数组转化成流
        Integer[] nums = new Integer[10];
        Stream<Integer> streamInteger = Arrays.stream(nums);

        // 使用Stream中的静态方法：of()、iterate()、generate()
        System.out.println("---of方法得使用---");
        // 转换成一个流
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5, 6);
        integerStream.forEach(System.out::println);

        // iterate()方法得使用   返回有序无限连续的流
        System.out.println("---iterate得使用---");
        Stream<Integer> stream2 = Stream.iterate(0, (x) -> x + 2).limit(10);
        stream2.forEach(System.out::println);

        // generate方法的使用   返回无序的流
        System.out.println("---generate方法的使用---");
        Stream<Double> stream3 = Stream.generate(Math::random).limit(3);
        stream3.forEach(System.out::println);

        // 使用BufferedReader.lines()方法，将每行内容转成流
        // BufferedReader reader = new BufferedReader(new FileReader("D://test.txt"));
        // Stream<String> lineStream = reader.lines();
        // lineStream.forEach(System.out::println);

        // filter:过滤流中得某些元素
        // limit(n)获取n个元素
        // skip(n)跳过n元素，配合limit(n)可实现分页
        // distinct去重
        System.out.println("---筛选与切片---");
        Stream<Integer> stream4 = Stream.of(6, 4, 6, 7, 3, 9, 8, 10, 12, 14, 14);
        stream4.filter(s -> s > 5) //6 6 7 9 8 10 12 14 14
                .distinct() //6 7 9 8 10 12 14
                .skip(2) // 9 8 10 12 14 跳过前两个
                .limit(2) // 9 8 只要前两个
                .forEach(System.out::println);

        // 映射
        // map：接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素。
        // flatMap：接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流。
        System.out.println("---map得用法---");
        List<String> list1 = Arrays.asList("a,b,c", "1,2,3");
        // 将每一个元素转换成一个新的并且不带逗号得元素
        list1.stream().map(s -> s.replaceAll(",", "")).forEach(System.out::println);

        // 将每一个元素都转换成一个stream
        System.out.println("---flatMap得用法---");
        list1.stream().flatMap(s -> {
            String[] split = s.split(",");
            Stream<String> s2 = Arrays.stream(split);
            return s2;
        }).forEach(System.out::println);

        // 排序
        // sorted():自然排序，流中元素须实现Comparable
        List<String> list3 = Arrays.asList("aa", "ff", "dd");
        // String类自身以实现Compareable接口
        System.out.println("---sorted的用法---");
        list3.stream().sorted().forEach(System.out::println);

        Student s1 = new Student("aa", 10);
        Student s2 = new Student("bb", 20);
        Student s3 = new Student("aa", 30);
        Student s4 = new Student("dd", 40);
        List<Student> studentList = Arrays.asList(s1, s2, s3, s4);

        // 自定义排序：先按姓名升序，姓名相同则按年龄升序
        // compareTo按字典顺序比较两个字符
        System.out.println("---排序---");
        studentList.stream().sorted(
                (o1, o2) -> {
                    if (o1.getName().equals(o2.getName())) {
                        return o1.getAge() - o2.getAge();
                    } else {
                        return o1.getName().compareTo(o2.getName());
                    }
                }
        ).forEach(System.out::println);

        // 消费 peek等同于map，能都到流中的每一个表达式，但是map接受的是一个Function表达式
        // 有返回值，而peek接受的时Consumer表达式，没有返回值
        System.out.println("---peek的用法---");
        Student s5 = new Student("aa", 10);
        Student s6 = new Student("bb", 20);
        List<Student> studentList2 = Arrays.asList(s5, s6);
        studentList2.stream().peek(o -> o.setAge(100)).forEach(System.out::println);

        // 流的终止操作
        System.out.println("---流的终止操作---");
        // 匹配聚合操作
        System.out.println("---匹配聚合操作---");
        // allMatch：接收一个 Predicate(谓语) 函数，当流中每个元素都符合该断言时才返回true，否则返回false
        System.out.println("---allMatch的用法---");

        List<Integer> list2 = Arrays.asList(1, 2, 3, 4, 5);
        boolean allMatch = list2.stream().allMatch(e -> (e > 10)); // false
        System.out.println(allMatch);

        // noneMatch：接收一个 Predicate 函数，当流中每个元素都不符合该断言时才返回true，否则返回false
        System.out.println("---noneMatch的用法---");
        boolean noneMatch = list2.stream().noneMatch(e -> e > 10); // true
        System.out.println(noneMatch);

        // anyMatch：接收一个 Predicate 函数，只要流中有一个元素满足该断言则返回true，否则返回false
        System.out.println("---anyMatch的用法---");
        boolean anyMatch = list2.stream().anyMatch(e -> e > 4);
        System.out.println(anyMatch);

        // findFirst：返回流中第一个元素
        System.out.println("---findFirst的用法---");
        Integer findFirst = list2.stream().findFirst().get(); // 1
        System.out.println(findFirst);

        // findAny：返回流中的任意元素
        System.out.println("---findAny的用法---");
        Integer findAny = list2.stream().findAny().get(); // 1
        System.out.println(findAny);

        // count：返回流中元素的总个数
        System.out.println("---count的用法---");
        long count = list2.stream().count();
        System.out.println(count);

        //  max：返回流中元素最大值
        System.out.println("---max的用法---");
        Integer max = list2.stream().max(Integer::compareTo).get();
        System.out.println(max);

        // min：返回流中元素最小值
        System.out.println("---min的用法---");
        Integer min = list2.stream().min(Integer::compareTo).get();
        System.out.println(min);
    }
}

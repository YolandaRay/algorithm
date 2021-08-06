package org.test;

import java.util.*;
import java.lang.reflect.Field;

public class Test {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException {
       //https://www.cnblogs.com/Narule/p/12852317.html
        String[] noP = {"Baby", "apple", "car", "A", "family", "B", "b", "Sky", "application", "app", "baby", "back", "background",
            "bad", "bbbbb", "bee", "cafe", "cake", "care"};

        String[] nopTop = sortByWeights(noP);
        for (String string : nopTop) {
            System.out.print(string + ",");
        }
        System.out.println();
        System.out.println("----------------------");
        for (String string : nopTop) {
            System.out.println("weights:\t" + getStrWeights(string, 0) + "\t" + string);
        }

        /*
        List sortElement = new ArrayList<>();
        sortElement.add("A");
        sortElement.add("a");
        sortElement.add("D");
        sortElement.add("B");
        sortElement.add("R");
        sortElement.add("C");
        sortElement.add("b");
        sortElement.add("T");
        sortElement.add("F");
        sortElement.add("c");
        sortElement.add("E");
        sortElement.add("d");
        System.out.println("未排序之前的List：" +sortElement);
        Collections.sort(sortElement);
        System.out.println("排序之后的List：" +sortElement);
        */
        /*
        String str="abcdef";
        String str2="abcdef";
        String refStr = str.getClass().newInstance();
        System.out.println(refStr);
        System.out.println("-------------");
        Field[] fields = String.class.getClass().getFields();
        Field[] declaredFields = Class.forName("java.lang.String").getDeclaredFields();
        for (Field f:fields) {
            System.out.println(f.toString());
        }
        System.out.println("-------------");
        for (Field f:declaredFields) {
            System.out.println(f.toString());
        }
        System.out.println("-------------");
        System.out.println("-------before------"+str);
        System.out.println("-------before---str2---"+str2);
        Field valueField = Class.forName("java.lang.String").getDeclaredField("value");
        valueField.setAccessible(true);
        char[] chars = (char[]) valueField.get(str);
        chars[0]='A';
        System.out.println("-------after------"+str);
        System.out.println("-------after---str2---"+str2);


         Java的反射（reflection）机制是指在程序的运行状态中，可以构造任意一个类的对象，可以了解任意一个对象所属的类，可以了解任意一个类的成员变量和方法，
         可以调用任意一个对象的属性和方法。这种动态获取程序信息以及动态调用对象的功能称为Java语言的反射机制。反射被视为动态语言的关键
         反射可以破坏String对不可变性，可以破坏单例模式。
         */

//        System.out.println("-------------");
//        HashMap hashMap = new HashMap<String,String>(16);

        /*
        int[] arrayA = new int[]{1, 1, 2, 3, 4, 4, 5, 1, 1};
        int[] arrayB = new int[]{11, 1, 22, 3, 43, 4, 5, 11, 1, 22};

        int sizeArrayA=arrayA.length;
        int sizeArrayB=arrayB.length;
        Integer[] arrayA2=new Integer[sizeArrayA];
        Integer[] arrayB2=new Integer[sizeArrayB];
        for(int i=0;i<sizeArrayA;i++){
            arrayA2[i]=new Integer(arrayA[i]);
        }
        for(int i=0;i<sizeArrayB;i++){
            arrayB2[i]=new Integer(arrayB[i]);
        }
        Set<Integer> intersectionSet = new HashSet<Integer>();

        intersectionSet.addAll(Arrays.asList(arrayA2));
        intersectionSet.retainAll(Arrays.asList(arrayB2));
        for (Integer i: intersectionSet) {
            System.out.println(i);
        }
         */
    }

    /**
     * for 权重排序
     */
    public static String[] sortByWeights(String[] disorder) {

        double[] weightsArr = new double[disorder.length];
        HashMap<Double, Integer> recordMap = new HashMap<>();

        // 计算每个字符串的权重值
        for (int i = 0; i < disorder.length; i++) {
            weightsArr[i] = getStrWeights(disorder[i], 0);
            recordMap.put(weightsArr[i], i);//保存权重值对应的字符串所在数组位置
        }

        // 将获取的权重值排序
        Arrays.sort(weightsArr);

        String[] sorderStr = new String[disorder.length];
        int orderIndex = 0;
        for (int i = 0; i < sorderStr.length; i++) {
            // 拿出排好序的索引
            orderIndex = recordMap.get(weightsArr[i]);
            sorderStr[i] = disorder[orderIndex];
        }
        return sorderStr;
    }

    // 权重数值
    private final static double weightsNum = 53;

    /**
     * for 计算字符串的权重值算法
     *
     * @param deep
     * @param str
     * @return weights
     */
    public static double getStrWeights(String str, int deep) {
        int c = str.charAt(deep);

        boolean isUppercase = true;
        if (c >= 97) {
            c = c - 32;
            isUppercase = false;
        }
        c = c - 64; // A,a -> 1; B,b -> 2

        int molecular = c * 2;
        if (isUppercase) molecular--; //if(B) -> 3;if(b) -> 4; for end [Baby,baby]

        // 这里考虑了大小写 如果字母是B 权重=3/53 小写b 权重=4/53  使小大小写也能排序

        double weights = molecular / (Math.pow(weightsNum, deep));


        return ++deep >= str.length() ? weights : weights + getStrWeights(str, deep); //递归到字符串末尾
    }

    /**
     * 1.put
     * index = hashcode(key) & (length-1)
     * 头插法
     * <p>
     * 2.get
     * 获取index
     * 遍历
     * <p>
     * 3.resize
     * HashMap.size() >= Capacity*LoadFactor
     * default 16*0.75f=12
     */
    public void put() {

    }
}

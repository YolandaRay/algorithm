package org.test;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.read.metadata.ReadSheet;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class MilkMain {

    static Properties props = new Properties();

    static {
        try {
            props.load(Milk.class.getClassLoader().getResourceAsStream("milk.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String get(String key) {
        if (props == null) return null;
        return props.getProperty(key, "");
    }

    static String suffix = ".xlsx";
    static String prefix = MilkMain.get("prefix");
    static String path = MilkMain.get("path");

    /*
    client
    1、spring定时任务，每天扫描一次目录文件，解析目录文件，获取日期list
    2、请求服务端，获取缺失产奶数据日期
    3、求差集，解析Excel数据，上报服务端
    4、发邮件功能，把Excel文件发邮件给相关人，通知是否成功。
     */
    public static void main(String[] args) {
        List<String> toUploadList = scanner(path);
        Map<String, List<Milk>> result = getMilkData(toUploadList);
        result.forEach((k, v) -> System.out.println("key: " + k + " value:" + v.size()));


    }

    private static Map<String, List<Milk>> getMilkData(List<String> toUploadList) {
        Map<String, List<Milk>> result = new HashMap<>(toUploadList.size());
        for (String path : toUploadList) {
            List<Milk> list = getExcelData(path);
            String key = path.replace(prefix, "").trim().substring(0, 11);
            result.put(key, list);
        }
        return result;
    }

    public static List<String> scanner(String path) {
        List<String> lossList = getLossDate();
        List<String> pathList = new ArrayList<>();
        File file = new File(path);
        File[] files = file.listFiles();
        for (File f : files) {
            String abPath = f.getAbsolutePath();
            for (String date : lossList) {
                if (abPath.contains(date)) {
                    pathList.add(abPath);
                }
            }
        }
        return pathList;
    }

    public static List<String> getLossDate() {
        List<String> lossList = new ArrayList<>();
        lossList.add("2021-08-07");
        lossList.add("2021-08-06");
        lossList.add("2021-09-01");
        lossList.add("2021-09-06");
        return lossList;
    }

    public static List<Milk> getExcelData(String fileName) {
        List<Milk> list = new LinkedList<Milk>();
        ExcelReader excelReader = EasyExcel.read(fileName, Milk.class, new AnalysisEventListener() {
            /**
             * 这个每一条数据解析都会来调用
             * @param milk
             * @param analysisContext
             */
            public void invoke(Object milk, AnalysisContext analysisContext) {
//                System.out.println("读取到一条数据 " + JSON.toJSONString(milk));
                list.add((Milk) milk);
            }

            /**
             * 所有数据读取完了调用
             * @param analysisContext
             */
            public void doAfterAllAnalysed(AnalysisContext analysisContext) {
//                System.out.println("读取完毕 所有数据  " + JSON.toJSONString(list));
            }
        }).build();
        ReadSheet readSheet = EasyExcel.readSheet(0).build();
        excelReader.read(readSheet);
        // 这里千万别忘记关闭，读的时候会创建临时文件，到时磁盘会崩的
        excelReader.finish();
        return list;
    }
}

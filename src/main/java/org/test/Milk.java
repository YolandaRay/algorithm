package org.test;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class Milk {
    @ExcelProperty("牛号")
    String cownum;

    @ExcelProperty("日期")
    String milkingdate;

    @ExcelProperty("班次")
    String flight;

    @ExcelProperty("班次产量")
    String yield;

    String milkone;
    String milktwo;
    String milkthree;
    String milkfour;
}
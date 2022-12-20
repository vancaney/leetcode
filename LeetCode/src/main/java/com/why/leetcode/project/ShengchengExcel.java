package com.why.leetcode.project;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;

import javax.swing.text.Style;

public class ShengchengExcel {
    //创建表头
    public static void createTitle(HSSFWorkbook workbook, HSSFSheet sheet) {
        HSSFRow row = sheet.createRow(0);
        //列宽，第一个参数为第几列，第二个参数是宽度，基本单位为1/256个字符宽度
        //要想得到准确的值，按下面方式直接写就可以
        sheet.setColumnWidth(0, (int) (20 + 0.72) * 256);//实际宽度为20
        //sheet.setColumnWidth(1, (int) (30 + 0.72) * 256);//实际宽度为30

        //设置表头格式
        HSSFCellStyle style = workbook.createCellStyle();
        HSSFFont font = workbook.createFont();
        font.setBold(true);//加粗
        style.setAlignment(CellStyle.ALIGN_CENTER);//居中
        style.setFont(font);

        //设置表头
        HSSFCell cell;
        cell = row.createCell(0);//标明第几列
        cell.setCellValue("字名");//表头
        cell.setCellStyle(style);

//        cell = row.createCell(1);
//        cell.setCellValue("书法家");
//        cell.setCellStyle(style);
//
//        cell = row.createCell(2);
//        cell.setCellValue("书体");
//        cell.setCellStyle(style);
//
//        cell = row.createCell(3);
//        cell.setCellValue("朝代");
//        cell.setCellStyle(style);
//
//        cell = row.createCell(4);
//        cell.setCellValue("来源");
//        cell.setCellStyle(style);
//
//        cell = row.createCell(5);
//        cell.setCellValue("文件格式");
//        cell.setCellStyle(style);
    }

    //生成Excel文件
    public static void buildExcelFile(String filename, HSSFWorkbook workbook) throws Exception {
        FileOutputStream fos = new FileOutputStream(filename);
        workbook.write(fos);
        workbook.close();

    }

    //把想要的数据放到Excel表格中
    public static void main(String[] args) throws Exception {
        String path = "/Users/why/Downloads/对账";
        File file = new File(path);
        //list()方法是返回某个目录下的所有文件和目录的文件名，返回的是String数组
        //listFiles()方法是返回某个目录下所有文件和目录的绝对路径，返回的是File数组
        String[] fs = file.list();
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("字库表");
        createTitle(workbook, sheet);
        int rowNum = 1;
        for (int i = 0; i < fs.length; i++) {
            HSSFRow row = sheet.createRow(rowNum++);
            System.out.println(fs[i]);
            row.createCell(0).setCellValue(fs[i]);
        }
        String fileName = "/Users/why/Downloads/《08_项目环境搭建》.xls";
        //生成Excel文件
        buildExcelFile(fileName, workbook);
        System.out.println("生成完成");
    }
}


package com.example.springboot.utils;

import com.example.springboot.dto.ExcelInfo;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenpei on 2018-08-15.
 */
public class ExcelUtils {
    public String[] getExcelRowsContent(MultipartFile file)  {
        Workbook wb = null;
        try {
            wb = Workbook.getWorkbook(file.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }
        Sheet sheet = wb.getSheet(0);
        int rows = sheet.getRows();
        int columns = sheet.getColumns();
        String[] contents = new String[columns];
        for (int i = 1; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                contents[j] = sheet.getCell(j, i).getContents();
            }
            boolean allEmpty = true;
            //如果所有数据均为空，则认为到了最后一行
            for (int j = 0; j < columns; j++) {
                if (!StringUtils.isEmpty(contents[i])) {
                    allEmpty = false;
                    break;
                }
            }
            if (allEmpty) {
                break;
            }
        }
        return contents;
    }


    public static List<ExcelInfo> getlocalContent(File file)  {
        Workbook wb = null;
        InputStream is = null;
        List<ExcelInfo> excelInfos = new ArrayList<>();
        try {
            is = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            wb = Workbook.getWorkbook(is);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }
        Sheet sheet = wb.getSheet(0);
        int rows = sheet.getRows();
        int columns = sheet.getColumns();
        String[] contents = new String[columns];
        for (int i = 1; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                contents[j] = sheet.getCell(j, i).getContents();
            }
            boolean allEmpty = true;
            //如果所有数据均为空，则认为到了最后一行
            for (int j = 0; j < columns; j++) {
                if (!StringUtils.isEmpty(contents[i])) {
                    allEmpty = false;
                    break;
                }
            }
            if (allEmpty) {
                break;
            }
            String url = contents[0];
            String param = contents[1];
            String value = contents[2];
            String caseDesc = contents[3];
            String caseExcept = contents[4];
            String code = contents[5];
            excelInfos.add(ExcelInfo.build(url,param,value,caseDesc,caseExcept,code));
        }
        return excelInfos;
    }

    public static void main(String[] args) {
        File file = new File("src/main/resources/cs_screen_broken.xls");
        List<ExcelInfo> excelInfos = getlocalContent(file);
        System.out.println(excelInfos.get(0));
    }
}

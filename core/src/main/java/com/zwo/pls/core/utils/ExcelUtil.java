package com.zwo.pls.core.utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;

import javax.validation.ValidationException;
import java.time.LocalDate;

/**
 * Create by Yuanquan.Liu on 2018/6
 */
public class ExcelUtil {
    public static boolean isExcel2003(String filePath) {
        return filePath.endsWith(".xls");
    }

    public static boolean isExcel2007(String filePath) {
        return filePath.endsWith(".xlsx");
    }

    public static boolean isNotEmptyForRow(Row row) {
        if (row != null) {
            for (Cell cell : row) {
                if (isNotEmptyForCell(cell)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isEmptyForCell(Cell cell) {
        return (cell == null || CellType.BLANK.equals(cell.getCellTypeEnum()));
    }

    public static boolean isNotEmptyForCell(Cell cell) {
        return !isEmptyForCell(cell);
    }

    public static String getCellValue(Cell cell) {
        String value = null;
        if (cell != null) {
            switch (cell.getCellTypeEnum()) {
                case STRING:
                    value = cell.getStringCellValue();
                    break;
                case NUMERIC:
//                    if (DateUtil.isCellDateFormatted(cell)) {
//                        value = com.pt.award.core.util.DateUtil.parseLocalDate(cell.getDateCellValue()).toString();
//                    } else {
//                        value = String.valueOf(cell.getNumericCellValue());
//                    }
                    value = String.valueOf(cell.getNumericCellValue());
                    break;
                case BOOLEAN:
                    value = String.valueOf(cell.getBooleanCellValue());
                    break;
                case FORMULA:
                    value = cell.getRichStringCellValue().getString();
                    break;
                case BLANK:
                    value = null;
                    break;
                case ERROR:
                    value = "非法字符";
                    break;
                default:
                    value = null;
                    break;
            }
        }
        return value;
    }

    public static LocalDate parseLocalDateOfCell(Cell cell) {
        if (isNotEmptyForCell(cell)) {
            if (cell.getCellTypeEnum() == CellType.NUMERIC) {
                return LocalDate.parse(String.valueOf(cell.getNumericCellValue()));
            } else if (cell.getCellTypeEnum() == CellType.STRING) {
                String stringCellValue = cell.getStringCellValue();
                LocalDate localDate;
                String[] split = stringCellValue.split("-");
                if (split.length == 3) {
                    localDate = LocalDate.of(
                            Integer.parseInt(split[0]),
                            Integer.parseInt(split[1]),
                            Integer.parseInt(split[2]));
                } else {
                    localDate = LocalDate.parse(stringCellValue);
                }
                return localDate;
            } else {
                throw new ValidationException("日期/时间单元格类型错误，支持Excel日期格式，或文本格式：yyyy-MM-dd");
            }
        }
        return null;
    }
}

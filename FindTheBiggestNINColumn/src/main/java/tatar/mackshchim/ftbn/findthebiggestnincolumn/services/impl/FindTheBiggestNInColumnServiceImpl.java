package tatar.mackshchim.ftbn.findthebiggestnincolumn.services.impl;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import tatar.mackshchim.ftbn.findthebiggestnincolumn.services.FindTheBiggestNInColumnService;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.PriorityQueue;
import java.util.Scanner;

@Service
public class FindTheBiggestNInColumnServiceImpl implements FindTheBiggestNInColumnService {

    private static final String XLSX_FORMAT_SUFFIX = ".xlsx";
    private static final String SEPARATOR = ",";

    @Override
    public double findTheBiggestNInColumnOfTheFile(String xlsxFilepath, int N) {
        try {
            System.out.println(xlsxFilepath);
            System.out.println(N);
            if (!xlsxFilepath.endsWith(XLSX_FORMAT_SUFFIX)) {
                throw new RuntimeException("Wrong format, expected " + XLSX_FORMAT_SUFFIX);
            }
            if (N<=0) {
                throw new RuntimeException("N must be positive");
            }
            File xlsxFile = new File(xlsxFilepath);
            if (!xlsxFile.exists()) {
                throw new RuntimeException("File does not exist");
            }
            PriorityQueue<Double> minHeap = new PriorityQueue<>(N);

            FileInputStream inputStream = new FileInputStream(xlsxFile);
            Workbook workbook = new XSSFWorkbook(inputStream);
            Sheet sheet = workbook.getSheetAt(0);
            Cell cell;
            for (Row row : sheet) {
                cell = row.getCell(0);
                if (!cell.getCellType().equals(CellType.NUMERIC)) {
                    throw new RuntimeException("Wrong format, expected " + CellType.NUMERIC);
                }
                double num = cell.getNumericCellValue();
                if (minHeap.size() < N) {
                    minHeap.add(num);
                } else if (num > minHeap.peek()) {
                    minHeap.poll();
                    minHeap.add(num);
                }
            }



            if (minHeap.size() < N) {
                throw new RuntimeException("Not enough elements");
            }
            return minHeap.peek();
        } catch (RuntimeException | IOException e) {
            throw new RuntimeException("Cannot find Biggest N, because: " + e.getMessage(), e);
        }

    }

}

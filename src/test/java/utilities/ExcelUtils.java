package utilities;

import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;

public class ExcelUtils {
	
	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;


	    // Get row count
	    public int getRowCount(String xfile, String xsheet) throws IOException {
	    	fi = new FileInputStream(xfile);
	        wb = new XSSFWorkbook(fi);
	        ws = wb.getSheet(xsheet);
	    	int rowcount = ws.getLastRowNum() + 1;
	    	wb.close();
	    	fi.close();
			return rowcount;
	    }

	    // Get cell count in a specific row
	    public int getCellCount(String xfile, String xsheet,int rowNum) throws IOException {
	    	fi = new FileInputStream(xfile);
	        wb = new XSSFWorkbook(fi);
	        ws = wb.getSheet(xsheet);
	        row = ws.getRow(rowNum);
	        int cellcount = row.getLastCellNum();
	    	wb.close();
	    	fi.close();
			return cellcount; 
	    }

	    // Get cell data
	    public String getCellData(String xfile, String xsheet, int rowNum, int colNum) throws IOException {
	        fi = new FileInputStream(xfile);
	        wb = new XSSFWorkbook(fi);
	        ws = wb.getSheet(xsheet);
	        row = ws.getRow(rowNum);
	        
	        String celldata;

	        try {
	            Cell cell = row.getCell(colNum); 
	            DataFormatter formatter = new DataFormatter();  
	            celldata = formatter.formatCellValue(cell);
	        } catch (Exception e) {
	            celldata = "";
	        }

	        wb.close();
	        fi.close();
	        return celldata;
	    }

	    // Set cell data
	    public void setCellData(String xfile, String xsheet,int rowNum, int colNum, String data) throws IOException {
	    	fi = new FileInputStream(xfile);
	        wb = new XSSFWorkbook(fi);
	        ws = wb.getSheet(xsheet);
	    	row = ws.getRow(rowNum);
	    	cell = row.createCell(colNum);
	    	cell.setCellValue(data);
	    	fo = new FileOutputStream(xfile);
	    	wb.write(fo);
	    	wb.close();
	    	fi.close();
	    	fo.close();
	    }

	   
	}

	
package com.company.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;

public class Excel {
		private FileInputStream file;
		private HSSFWorkbook workbook;
		private HSSFSheet sheet;
		private HSSFCell cell;
		private DataFormatter formatter;
		private FileOutputStream outfile;
		public void setExcel(String path,String sheetname) throws IOException
		{
			file=new FileInputStream(path);
			workbook=new HSSFWorkbook(file);
			sheet=workbook.getSheet(sheetname);
			//or
			//sheet=workbook.getSheetAt(sheetindex(ie- 0,1,2));
			//sheet=workbook.getSheetAt(0);
		}
		//public void writeExcel(String path,){
			//outfile=new FileOutputStream(path);
			//workbook=new HSSFWorkbook(outfile);
			
			
		//}
		public String getCellValue(int row,int col){
			cell=sheet.getRow(row).getCell(col);
					formatter=new DataFormatter();
			return formatter.formatCellValue(cell);
			}
		
		public int getRowCount(){
			return sheet.getLastRowNum();
		}
		public int rowInitialIndex(){
			return sheet.getFirstRowNum();
		}
		}

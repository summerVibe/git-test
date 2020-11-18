package my.excel;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

/**
 * https://www.cnblogs.com/wangyang108/p/6030420.html
 * @author  J
 * @date 创建时间：Jan 5, 2018 - 10:50:08 AM
 * @version 1.0 
 */
public class JXL_ {
	
//	@Test
	public void xlsWrite() {
		File xlsfile = new File("jxl.xls");
		WritableWorkbook workBook = null;
		try {
			// 创建工作薄
			workBook = Workbook.createWorkbook(xlsfile);
			// 创建工作表
			WritableSheet sheet = workBook.createSheet("sheet1", 0);
			for(int row = 0;row < 10 ;row++){
				for(int col = 0;col < 10 ;col++){
					sheet.addCell(new Label(row, col, "data:"+row+"&"+col));
				}
			}
			workBook.write();
			workBook.close();
		} catch (IOException | WriteException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void readXls(){
		File xlsFile = new File("jxl.xls");
		try {
			// 获取工作薄对象
			Workbook workbook = Workbook.getWorkbook(xlsFile);
			// 获取所有工作表
			Sheet[] sheets = workbook.getSheets();
			// 遍历工作表
			if(sheets != null){
				for(Sheet sheet : sheets){
					// 获取行数
					int rows = sheet.getRows();
					// 获取列数
					int columns = sheet.getColumns();
					// 读取数据
					for(int row = 0;row < rows;row++){
						for(int col = 0;col < columns;col++){
							System.out.printf("%10s",sheet.getCell(col, row).getContents());
						}	
						System.out.println();
					}
					
				}
			}
			
			workbook.close();
			
		} catch (BiffException | IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
}

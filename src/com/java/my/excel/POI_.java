package my.excel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.WorkbookUtil;
import org.junit.Test;

/** 
 * https://www.cnblogs.com/wangyang108/p/6030420.html
 * @author  J
 * @date 创建时间：Jan 5, 2018 - 2:53:01 PM
 * @version 1.0 
 */
public class POI_ {
//	@Test
	public void poiWrite(){
		// 创建工作薄
		HSSFWorkbook workbook = new HSSFWorkbook();
		// 创建工作表
		HSSFSheet sheet = workbook.createSheet("sheet1");
		for(int row = 0;row < 10;row++){
			HSSFRow rows = sheet.createRow(row);
			for(int col = 0;col < 10;col++){
				// 向工作表中添加数据
				rows.createCell(col).setCellValue("data"+row+col);
			}
		}
		File xlsFile = new File("poi.xls");
		try {
			FileOutputStream xlsStream = new FileOutputStream(xlsFile);
			workbook.write(xlsStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void poiRead(){
		File xlsFile = new File("poi.xls");
		try {
			// 获得工作薄
			Workbook workbook = WorkbookFactory.create(xlsFile);
			// 获取工作表个数
			int sheets = workbook.getNumberOfSheets();
			// 遍历工作表
			for(int i = 0;i < sheets;i++){
				Sheet sheet = workbook.getSheetAt(i);
				// 获取行数
				int rows = sheet.getLastRowNum() + 1;
				// 获得列数。先获取一行，再得到该行列数
				Row row = sheet.getRow(0);
				if(row == null)continue;
				int cols = row.getPhysicalNumberOfCells();
				// 读取数据
				for(int r = 0;r < rows;r++){
					Row row2 = sheet.getRow(r);
					for(int c = 0;c < cols ;c++){
						System.out.printf("%10s",row2.getCell(c).getStringCellValue());
					}
					System.out.println();
				}
			}
		} catch (EncryptedDocumentException | InvalidFormatException
				| IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
}

package model.excel;

import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import model.employee.EmployeeVO;

public class ExcelDown {
	public void ExcleDownload(EmployeeVO vo) throws Exception {
		// .xls Ȯ���� ����
		// HSSFWorkbook hssWb = null;
		// HSSFSheet hssSheet = null;
		// Row hssRow = null;
		// Cell hssCell = null;

		// .xlsx Ȯ���� ���� 
		XSSFWorkbook xssfWb = null;
		XSSFSheet xssfSheet = null;
		XSSFRow xssfRow = null;
		XSSFCell xssfCell = null;
		try {
			int rowNo = 0;
			// ���� ����
			xssfWb = new XSSFWorkbook();
			// XSSFWorkbook ��ü ����
			xssfSheet = xssfWb.createSheet("");
			// ��ũ��Ʈ �̸� ����
			// ��Ʈ ��Ÿ��
			XSSFFont font = xssfWb.createFont();
			font.setFontName(HSSFFont.FONT_ARIAL);
			// ��Ʈ ��Ÿ��
			font.setFontHeightInPoints((short) 20);
			// ��Ʈ ũ��
			font.setBold(true);
			// Bold ����
			font.setColor(new XSSFColor(Color.decode("#457ba2")));
			// ��Ʈ �� ����
			// ���̺� �� ��Ÿ��
			CellStyle cellStyle = xssfWb.createCellStyle();
			xssfSheet.setColumnWidth(0, (xssfSheet.getColumnWidth(0)) + (short) 2048);
			// 0��° �÷� ���� ����
			cellStyle.setFont(font);
			// cellStyle�� font�� ����
			cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			// ����
			// ������
			xssfSheet.addMergedRegion(new CellRangeAddress(0, 1, 0, 4));
			// ù��, ��������, ù��, �������� ����
			// Ÿ��Ʋ ����
			xssfRow = xssfSheet.createRow(rowNo++);
			// �� ��ü �߰�
			xssfCell = xssfRow.createCell((short) 0);
			// �߰��� �࿡ �� ��ü �߰�
			xssfCell.setCellStyle(cellStyle);
			// ���� ��Ÿ�� ����
			xssfCell.setCellValue("Ÿ��Ʋ �Դϴ�");
			// ������ �Է�
			xssfSheet.createRow(rowNo++);
			xssfRow = xssfSheet.createRow(rowNo++);
			// ���� �߰�
			// ���̺� ��Ÿ�� ����
			CellStyle tableCellStyle = xssfWb.createCellStyle();
			tableCellStyle.setBorderTop((short) 5);
			// �׵θ� ����
			tableCellStyle.setBorderBottom((short) 5);
			// �׵θ� �Ʒ���
			tableCellStyle.setBorderLeft((short) 5);
			// �׵θ� ����
			tableCellStyle.setBorderRight((short) 5);
			// �׵θ� ������
			xssfRow = xssfSheet.createRow(rowNo++);
			
			for(int i=0;i<10;i++) {
				xssfCell = xssfRow.createCell((short) i);
				xssfCell.setCellStyle(tableCellStyle);
				xssfCell.setCellValue("");
			}
			
			String localFile = "/Users/hihi/" + "excelDownTest" + ".xlsx";
			File file = new File(localFile);
			FileOutputStream fos = null;
			fos = new FileOutputStream(file);
			xssfWb.write(fos);
			if (fos != null)
				fos.close();
		} catch (Exception e) {

		}
	}
}

package Read.Json.files;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.gson.JsonObject;

public class JbayLocalization {

	public static String identifier = null;
	public static String filePath = "D:/LAUNCH_StringFile_Latest_JBay_07.xls";
	public static Object object;

	public static ArrayList<LanguagePojo> arrayListEnglish = new ArrayList<LanguagePojo>();
	public static ArrayList<LanguagePojo> arrayListPTBR = new ArrayList<LanguagePojo>();
	public static ArrayList<LanguagePojo> arrayListCN = new ArrayList<LanguagePojo>();
	public static ArrayList<LanguagePojo> arrayListDE = new ArrayList<LanguagePojo>();
	public static ArrayList<LanguagePojo> arrayListES = new ArrayList<LanguagePojo>();
	public static ArrayList<LanguagePojo> arrayListFR = new ArrayList<LanguagePojo>();
	public static ArrayList<LanguagePojo> arrayListIT = new ArrayList<LanguagePojo>();
	public static ArrayList<LanguagePojo> arrayListJP = new ArrayList<LanguagePojo>();
	public static ArrayList<LanguagePojo> arrayListKR = new ArrayList<LanguagePojo>();
	public static ArrayList<LanguagePojo> arrayListRU = new ArrayList<LanguagePojo>();
	public static ArrayList<LanguagePojo> arrayListSE = new ArrayList<LanguagePojo>();
	public static ArrayList<LanguagePojo> arrayListTW = new ArrayList<LanguagePojo>();

	public static int columnCount = 0;
	public static int headerCount = 0;

	public static HSSFWorkbook workbook;
	public static HSSFSheet sheet;
	public static FileOutputStream fileOut;
	public static JSONParser jsonParser;

	public static void main(String[] args) {

		init();
		Detect obj1 = new Detect();
		obj1.findTruncation();
	}

	private static void init() {

		try {

			workbook = new HSSFWorkbook();
			sheet = workbook.createSheet("StringSheet");
			jsonParser = new JSONParser();

			arrayListEnglish = Utils.getlanguages(workbook, sheet, jsonParser, "COCO_RD_Copy_10232019.json");
			arrayListPTBR = Utils.getlanguages(workbook, sheet, jsonParser, "COCO_RD_Copy_BR.json");
			arrayListCN = Utils.getlanguages(workbook, sheet, jsonParser, "COCO_RD_Copy_CN.json");
			arrayListDE = Utils.getlanguages(workbook, sheet, jsonParser, "COCO_RD_Copy_DE.json");
			arrayListES = Utils.getlanguages(workbook, sheet, jsonParser, "COCO_RD_Copy_ES.json");
			arrayListFR = Utils.getlanguages(workbook, sheet, jsonParser, "COCO_RD_Copy_FR.json");
			arrayListIT = Utils.getlanguages(workbook, sheet, jsonParser, "COCO_RD_Copy_IT.json");
			arrayListJP = Utils.getlanguages(workbook, sheet, jsonParser, "COCO_RD_Copy_JP.json");
			arrayListKR = Utils.getlanguages(workbook, sheet, jsonParser, "COCO_RD_Copy_KR.json");
			arrayListRU = Utils.getlanguages(workbook, sheet, jsonParser, "COCO_RD_Copy_RU.json");
			arrayListSE = Utils.getlanguages(workbook, sheet, jsonParser, "COCO_RD_Copy_SE.json");
			arrayListTW = Utils.getlanguages(workbook, sheet, jsonParser, "COCO_RD_Copy_TW.json");

			create(filePath, workbook, sheet);

			fileOut = new FileOutputStream(filePath);
			workbook.write(fileOut);
			fileOut.close();
			workbook.close();

		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();

			try {
				fileOut = new FileOutputStream(filePath);
				workbook.write(fileOut);
				fileOut.close();
				workbook.close();

			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}

	public static void create(String filename, HSSFWorkbook workbook, HSSFSheet sheet) {

		try {
			for (int i = 0; i < arrayListEnglish.size(); i++) {
				if (i == 0) {

					HSSFRow rowhead = sheet.createRow((short) 0);
					// English
					rowhead.createCell(headerCount).setCellValue("Identifier");
					headerCount++;
					rowhead.createCell(headerCount).setCellValue("Default");
					details(rowhead);

					// Portuguese -> BR
					rowhead.createCell(headerCount).setCellValue("Identifier");
					headerCount++;
					rowhead.createCell(headerCount).setCellValue("Portuguese");
					details(rowhead);

					// Simplified Chinese -> CN
					rowhead.createCell(headerCount).setCellValue("Identifier");
					headerCount++;
					rowhead.createCell(headerCount).setCellValue("Chinese");
					details(rowhead);

					// German -> DE
					rowhead.createCell(headerCount).setCellValue("Identifier");
					headerCount++;
					rowhead.createCell(headerCount).setCellValue("German");
					details(rowhead);

					// Spanish -> ES
					rowhead.createCell(headerCount).setCellValue("Identifier");
					headerCount++;
					rowhead.createCell(headerCount).setCellValue("Spanish");
					details(rowhead);

					// French -> FR
					rowhead.createCell(headerCount).setCellValue("Identifier");
					headerCount++;
					rowhead.createCell(headerCount).setCellValue("French");
					details(rowhead);

					// Italian -> IT
					rowhead.createCell(headerCount).setCellValue("Identifier");
					headerCount++;
					rowhead.createCell(headerCount).setCellValue("Italian");
					details(rowhead);

					// Japanese -> JP
					rowhead.createCell(headerCount).setCellValue("Identifier");
					headerCount++;
					rowhead.createCell(headerCount).setCellValue("Japanese");
					details(rowhead);

					// Korean -> KR
					rowhead.createCell(headerCount).setCellValue("Identifier");
					headerCount++;
					rowhead.createCell(headerCount).setCellValue("Korean");
					details(rowhead);

					// Russian -> RU
					rowhead.createCell(headerCount).setCellValue("Identifier");
					headerCount++;
					rowhead.createCell(headerCount).setCellValue("Russian");
					details(rowhead);

					// Swedish -> SE
					rowhead.createCell(headerCount).setCellValue("Identifier");
					headerCount++;
					rowhead.createCell(headerCount).setCellValue("Swedish");
					details(rowhead);

					// TChinese -> TW
					rowhead.createCell(headerCount).setCellValue("Identifier");
					headerCount++;
					rowhead.createCell(headerCount).setCellValue("TChinese");
					details(rowhead);

					// TChinese -> TW
					rowhead.createCell(headerCount).setCellValue("Identifier");
					headerCount++;
					rowhead.createCell(headerCount).setCellValue("TChinese");
					details(rowhead);

				} else {

					HSSFRow row = sheet.createRow((short) i);
					setCellValues(row, i);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
		}

		System.out.println("File has been generated...");
	}

	private static void details(HSSFRow rowhead) {
		headerCount++;
		rowhead.createCell(headerCount).setCellValue("fontName");
		headerCount++;
		rowhead.createCell(headerCount).setCellValue("fontSize");
		headerCount++;
		rowhead.createCell(headerCount).setCellValue("textAlignment");
		headerCount++;
		rowhead.createCell(headerCount).setCellValue("maxChar");
		headerCount++;
		rowhead.createCell(headerCount).setCellValue("maxLine");
		headerCount++;
		rowhead.createCell(headerCount).setCellValue("Width");
		headerCount++;
		rowhead.createCell(headerCount).setCellValue("Height");
		headerCount++;
	}

	private static void setCellValues(HSSFRow row, int i) {

		valueRowByrow(row, i, arrayListEnglish);
		valueRowByrow(row, i, arrayListPTBR);
		valueRowByrow(row, i, arrayListCN);
		valueRowByrow(row, i, arrayListDE);
		valueRowByrow(row, i, arrayListES);
		valueRowByrow(row, i, arrayListFR);
		valueRowByrow(row, i, arrayListIT);
		valueRowByrow(row, i, arrayListJP);
		valueRowByrow(row, i, arrayListKR);
		valueRowByrow(row, i, arrayListRU);
		valueRowByrow(row, i, arrayListSE);
		valueRowByrow(row, i, arrayListTW);
		valueRowByrow(row, i, arrayListTW);

		columnCount = 0;
	}

	private static void valueRowByrow(HSSFRow row, int i, ArrayList<LanguagePojo> arrayList) {
		row.createCell(columnCount).setCellValue(arrayList.get(i).getIdentifier());
		columnCount++;
		row.createCell(columnCount).setCellValue(arrayList.get(i).getLanguage());
		columnCount++;
		row.createCell(columnCount).setCellValue(arrayList.get(i).getFontName());
		columnCount++;
		row.createCell(columnCount).setCellValue(arrayList.get(i).getFontSize());
		columnCount++;
		row.createCell(columnCount).setCellValue(arrayList.get(i).getTextAlignment());
		columnCount++;
		row.createCell(columnCount).setCellValue(arrayList.get(i).getMaxChar());
		columnCount++;
		row.createCell(columnCount).setCellValue(arrayList.get(i).getMaxLine());
		columnCount++;
		row.createCell(columnCount).setCellValue(arrayList.get(i).getWidth());
		columnCount++;
		row.createCell(columnCount).setCellValue(arrayList.get(i).getHeight());
		columnCount++;
	}

}

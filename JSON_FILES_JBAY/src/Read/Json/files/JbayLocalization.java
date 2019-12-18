package Read.Json.files;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.json.simple.parser.JSONParser;

public class JbayLocalization {

	public static String identifier = null;
	public static String filePath = "D:/LAUNCH_StringFile_Latest_JBay_07.xls";
	public static Object object;
	public static int aa;
	private static File fontFile;
	private static Set<String> tempUniCodes = new HashSet<String>();
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
	private static FileWriter fileWriter;
	private static Scanner scanner;

	public static void main(String[] args) throws IOException {

		init();
		storeFontsInSet();
		System.out.println("Total Id: -------->" + aa);
		System.out.println("Size of temp code is: " + tempUniCodes.size());
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
					aa++;
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

	private static void setCellValues(HSSFRow row, int i) throws IOException {

		fontFile = new File("./Default.txt");
		valueRowByrow(row, i, arrayListEnglish, fontFile);
		fontFile = new File("./Portuguese.txt");
		valueRowByrow(row, i, arrayListPTBR, fontFile);
		fontFile = new File("./Chinese.txt");
		valueRowByrow(row, i, arrayListCN, fontFile);
		fontFile = new File("./Portuguese.txt");
		valueRowByrow(row, i, arrayListDE, fontFile);
		fontFile = new File("./German.txt");
		valueRowByrow(row, i, arrayListES, fontFile);
		fontFile = new File("./Spanish.txt");
		valueRowByrow(row, i, arrayListFR, fontFile);
		fontFile = new File("./French.txt");
		valueRowByrow(row, i, arrayListIT, fontFile);
		fontFile = new File("./Italian.txt");
		valueRowByrow(row, i, arrayListJP, fontFile);
		fontFile = new File("./Japanese.txt");
		valueRowByrow(row, i, arrayListKR, fontFile);
		fontFile = new File("./Korean.txt");
		valueRowByrow(row, i, arrayListRU, fontFile);
		fontFile = new File("./Russian.txt");
		valueRowByrow(row, i, arrayListSE, fontFile);
		fontFile = new File("./Swedish.txt");
		valueRowByrow(row, i, arrayListTW, fontFile);
		fontFile = new File("./Tchinese.txt");
		valueRowByrow(row, i, arrayListTW, fontFile);

		columnCount = 0;

	}

	private static void valueRowByrow(HSSFRow row, int i, ArrayList<LanguagePojo> arrayList, File fontFile)
			throws IOException {
		row.createCell(columnCount).setCellValue(arrayList.get(i).getIdentifier());
		columnCount++;
		row.createCell(columnCount).setCellValue(arrayList.get(i).getLanguage());
		generateFontHexString(arrayList.get(i).getLanguage(), fontFile);
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

	private static void storeFontsInSet() {
		File filename;
		int index;
		String unicode_value;
		try {
			for (index = 0; index < 12; index++) {
				filename = map_index_with_fontFile(index);
				scanner = new Scanner(filename).useDelimiter(",");
				while (scanner.hasNext()) {
					unicode_value = scanner.next();
					System.out.println(unicode_value.toString());
					tempUniCodes.add(unicode_value);
				}
				FileWriter fw = new FileWriter(filename);
				PrintWriter pw = new PrintWriter(fw);
				pw.write("");
				for (String s : tempUniCodes)
					fw.write(s + ",");
				fw.close();
				pw.close();
				scanner.close();
			}

		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	private static void generateFontHexString(String language, File fontFile) {

		try {
			fileWriter = new FileWriter(fontFile, true);
			for (int j = 0; j < language.length(); j++) {
				fileWriter.write("0x" + Integer.toHexString(language.charAt(j)) + ",");
			}

			fileWriter.flush();
			fileWriter.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// This method will return different font file depending on the index passed.
	private static File map_index_with_fontFile(int index) {
		File return_file;
		switch (index) {
		case 0:
			return_file = new File("Default.txt");
			break;
		case 1:
			return_file = new File("Portuguese.txt");
			break;
		case 2:
			return_file = new File("French.txt");
			break;
		case 3:
			return_file = new File("Italian.txt");
			break;
		case 4:
			return_file = new File("German.txt");
			break;
		case 5:
			return_file = new File("Russian.txt");
			break;
		case 6:
			return_file = new File("Spanish.txt");
			break;
		case 7:
			return_file = new File("Swedish.txt");
			break;
		case 8:
			return_file = new File("chinese.txt");
			break;
		case 9:
			return_file = new File("Tchinese.txt");
			break;
		case 10:
			return_file = new File("Korean.txt");
			break;
		case 11:
			return_file = new File("Japanese.txt");
			break;
		default: {
			System.out.println("No File Found");
			return_file = null;
		}
			break;
		}
		return return_file;
	}

}

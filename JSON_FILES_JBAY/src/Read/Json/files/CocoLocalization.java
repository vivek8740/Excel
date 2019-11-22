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

public class CocoLocalization {

	static String identifier = null;

	static String filename = "D:/StringFile_COCO_RD_Copy_09232019.xls";
	static List<String> str_id = new ArrayList<>();
	static List<String> str_value_English = new ArrayList<>();
	static List<String> str_value_Chinese = new ArrayList<>();
	static List<String> str_value_German = new ArrayList<>();
	static List<String> str_value_French = new ArrayList<>();
	static List<String> str_value_Italian = new ArrayList<>();
	static List<String> str_value_Japanese = new ArrayList<>();
	static List<String> str_value_Korean = new ArrayList<>();
	static List<String> str_value_Portuguese = new ArrayList<>();
	static List<String> str_value_Russian = new ArrayList<>();
	static List<String> str_value_TChinese = new ArrayList<>();
	static List<String> str_value_Swedish = new ArrayList<>();
	static List<String> str_value_Spanish = new ArrayList<>();
	
	static int count_Chinese = 0, count_German = 0, count_Portuguese = 0, count_Spanish = 0, count_French = 0,
			count_Italian = 0, count_Japanese = 0, count_Korean = 0, count_Russian = 0, count_Swedish = 0,
			count_TChinese = 0;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException, ParseException {
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("sheet");

		JSONParser jsonParser = new JSONParser();

		// English
		FileReader reader1 = new FileReader("COCO_RD_Copy_10232019.json");
		Object object1 = jsonParser.parse(reader1);
		JSONArray jsonObject1 = (JSONArray) object1;
		jsonObject1.forEach(o1 -> {
			try {
				COCO_RD_Copy_nonlocalized((JSONObject) o1);

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});

		// Simplified Chinese
		FileReader reader2 = new FileReader("COCO_RD_Copy_CN.json");
		Object object2 = jsonParser.parse(reader2);
		JSONArray jsonObject2 = (JSONArray) object2;
		jsonObject2.forEach(o2 -> {
			try {
				COCO_RD_Copy_CN((JSONObject) o2);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});

		// German
		FileReader reader3 = new FileReader("COCO_RD_Copy_DE.json");
		Object object3 = jsonParser.parse(reader3);
		JSONArray jsonObject3 = (JSONArray) object3;
		jsonObject3.forEach(o3 -> {
			try {
				COCO_RD_Copy_DE((JSONObject) o3);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});

		// Portuguese
		FileReader reader4 = new FileReader("COCO_RD_Copy_BR.json");
		Object object4 = jsonParser.parse(reader4);
		JSONArray jsonObject4 = (JSONArray) object4;
		jsonObject4.forEach(o4 -> {
			try {
				COCO_RD_Copy_BR((JSONObject) o4);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});

		// Spanish
		FileReader reader5 = new FileReader("COCO_RD_Copy_ES.json");
		Object object5 = jsonParser.parse(reader5);
		JSONArray jsonObject5 = (JSONArray) object5;
		jsonObject5.forEach(o5 -> {
			try {
				COCO_RD_Copy_ES((JSONObject) o5);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});

		// French
		FileReader reader6 = new FileReader("COCO_RD_Copy_FR.json");
		Object object6 = jsonParser.parse(reader6);
		JSONArray jsonObject6 = (JSONArray) object6;
		jsonObject6.forEach(o6 -> {
			try {
				COCO_RD_Copy_FR((JSONObject) o6);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});

		// Italian
		FileReader reader7 = new FileReader("COCO_RD_Copy_IT.json");
		Object object7 = jsonParser.parse(reader7);
		JSONArray jsonObject7 = (JSONArray) object7;
		jsonObject7.forEach(o7 -> {
			try {
				COCO_RD_Copy_IT((JSONObject) o7);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});

		// Japanese
		FileReader reader8 = new FileReader("COCO_RD_Copy_JP.json");
		Object object8 = jsonParser.parse(reader8);
		JSONArray jsonObject8 = (JSONArray) object8;
		jsonObject8.forEach(o8 -> {
			try {
				COCO_RD_Copy_JP((JSONObject) o8);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});

		// Korean
		FileReader reader9 = new FileReader("COCO_RD_Copy_KR.json");
		Object object9 = jsonParser.parse(reader9);
		JSONArray jsonObject9 = (JSONArray) object9;
		jsonObject9.forEach(o9 -> {
			try {
				COCO_RD_Copy_KR((JSONObject) o9);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});

		// Russian
		FileReader reader10 = new FileReader("COCO_RD_Copy_RU.json");
		Object object10 = jsonParser.parse(reader10);
		JSONArray jsonObject10 = (JSONArray) object10;
		jsonObject10.forEach(o10 -> {
			try {
				COCO_RD_Copy_RU((JSONObject) o10);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});

		// Swedish
		FileReader reader11 = new FileReader("COCO_RD_Copy_SE.json");
		Object object11 = jsonParser.parse(reader11);
		JSONArray jsonObject11 = (JSONArray) object11;
		jsonObject11.forEach(o11 -> {
			try {
				COCO_RD_Copy_SE((JSONObject) o11);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});

		// TChinese
		FileReader reader12 = new FileReader("COCO_RD_Copy_TW.json");
		Object object12 = jsonParser.parse(reader12);
		JSONArray jsonObject12 = (JSONArray) object12;
		jsonObject12.forEach(o12 -> {
			try {
				COCO_RD_Copy_TW((JSONObject) o12);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});

		create(filename, workbook, sheet);
	}

	@SuppressWarnings("unchecked")
	private static void COCO_RD_Copy_TW(JSONObject o1) throws IOException {
		identifier = (String) o1.get("identifier");
		if (identifier.equals(str_id.get(count_TChinese))) {
			String value = (String) o1.get("zhTW");
			str_value_TChinese.add(value);
			count_TChinese++;
		}
	}

	@SuppressWarnings("unchecked")
	private static void COCO_RD_Copy_SE(JSONObject o1) throws IOException {
		identifier = (String) o1.get("identifier");
		if (identifier.equals(str_id.get(count_Swedish))) {
			String value = (String) o1.get("svSE");
			str_value_Swedish.add(value);
			count_Swedish++;
		}
	}

	@SuppressWarnings("unchecked")
	private static void COCO_RD_Copy_RU(JSONObject o1) throws IOException {
		identifier = (String) o1.get("identifier");
		if (identifier.equals(str_id.get(count_Russian))) {
			String value = (String) o1.get("ruRU");
			str_value_Russian.add(value);
			count_Russian++;
		}
	}

	@SuppressWarnings("unchecked")
	private static void COCO_RD_Copy_KR(JSONObject o1) throws IOException {
		identifier = (String) o1.get("identifier");
		if (identifier.equals(str_id.get(count_Korean))) {
			String value = (String) o1.get("koKR");
			str_value_Korean.add(value);
			count_Korean++;
		}
	}

	@SuppressWarnings("unchecked")
	private static void COCO_RD_Copy_JP(JSONObject o1) throws IOException {
		identifier = (String) o1.get("identifier");
		if (identifier.equals(str_id.get(count_Japanese))) {
			String value = (String) o1.get("jaJP");
			str_value_Japanese.add(value);
			count_Japanese++;
		}
	}

	@SuppressWarnings("unchecked")
	private static void COCO_RD_Copy_IT(JSONObject o1) throws IOException {
		identifier = (String) o1.get("identifier");
		if (identifier.equals(str_id.get(count_Italian))) {
			String value = (String) o1.get("itIT");
			str_value_Italian.add(value);
			count_Italian++;
		}
	}

	@SuppressWarnings("unchecked")
	private static void COCO_RD_Copy_FR(JSONObject o1) throws IOException {
		identifier = (String) o1.get("identifier");
		if (identifier.equals(str_id.get(count_French))) {
			String value = (String) o1.get("frFR");
			str_value_French.add(value);
			count_French++;
		}
	}

	@SuppressWarnings("unchecked")
	private static void COCO_RD_Copy_ES(JSONObject o1) throws IOException {
		identifier = (String) o1.get("identifier");
		if (identifier.equals(str_id.get(count_Spanish))) {
			String value = (String) o1.get("esES");
			str_value_Spanish.add(value);
			count_Spanish++;
		}
	}

	@SuppressWarnings("unchecked")
	private static void COCO_RD_Copy_BR(JSONObject o1) throws IOException {
		identifier = (String) o1.get("identifier");
		if (identifier.equals(str_id.get(count_Portuguese))) {
			String value = (String) o1.get("ptBR");
			str_value_Portuguese.add(value);
			count_Portuguese++;
		}
	}

	@SuppressWarnings("unchecked")
	private static void COCO_RD_Copy_CN(JSONObject o1) throws IOException {
		identifier = (String) o1.get("identifier");
		if (identifier.equals(str_id.get(count_Chinese))) {
			String value = (String) o1.get("zhCN");
			str_value_Chinese.add(value);
			count_Chinese++;
		}
	}

	@SuppressWarnings("unchecked")
	private static void COCO_RD_Copy_DE(JSONObject o1) throws IOException {
		identifier = (String) o1.get("identifier");
		if (identifier.equals(str_id.get(count_German))) {
			String value = (String) o1.get("deDE");
			str_value_German.add(value);
			count_German++;
		}
	}

	@SuppressWarnings("unchecked")
	private static void COCO_RD_Copy_nonlocalized(JSONObject o1) throws IOException {
		identifier = (String) o1.get("identifier");
		str_id.add(identifier);
		String value = (String) o1.get("english");
		str_value_English.add(value);
	}

	public static void create(String filename, HSSFWorkbook workbook, HSSFSheet sheet) throws IOException {
		for (int i = 0; i < str_id.size(); i++) {
			if (i == 0) {
				HSSFRow rowhead = sheet.createRow((short) 0);
				rowhead.createCell(0).setCellValue("Identifier");
				rowhead.createCell(1).setCellValue("Default");
				rowhead.createCell(2).setCellValue("Chinese");
				rowhead.createCell(3).setCellValue("TChinese");
				rowhead.createCell(4).setCellValue("Japanese");
				rowhead.createCell(5).setCellValue("German");
				rowhead.createCell(6).setCellValue("French");
				rowhead.createCell(7).setCellValue("Italian");
				rowhead.createCell(8).setCellValue("Spanish");
				rowhead.createCell(9).setCellValue("Korean");
				rowhead.createCell(10).setCellValue("Portuguese");
				rowhead.createCell(11).setCellValue("Russian");
				rowhead.createCell(12).setCellValue("Swedish");

			} else {
				HSSFRow row = sheet.createRow((short) i);
				row.createCell(0).setCellValue(str_id.get(i).toString());
				row.createCell(1).setCellValue(str_value_English.get(i).toString());
				row.createCell(2).setCellValue(str_value_Chinese.get(i).toString());
				row.createCell(3).setCellValue(str_value_TChinese.get(i).toString());
				row.createCell(4).setCellValue(str_value_Japanese.get(i).toString());
				row.createCell(5).setCellValue(str_value_German.get(i).toString());
				row.createCell(6).setCellValue(str_value_French.get(i).toString());
				row.createCell(7).setCellValue(str_value_Italian.get(i).toString());
				row.createCell(8).setCellValue(str_value_Spanish.get(i).toString());
				row.createCell(9).setCellValue(str_value_Korean.get(i).toString());
				row.createCell(10).setCellValue(str_value_Portuguese.get(i).toString());
				row.createCell(11).setCellValue(str_value_Russian.get(i).toString());
				row.createCell(12).setCellValue(str_value_Swedish.get(i).toString());
			}
		}
		FileOutputStream fileOut = new FileOutputStream(filename);
		workbook.write(fileOut);
		fileOut.close();
		workbook.close();
	}
}



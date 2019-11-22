package Read.Json.files;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Utils {

	public static Object object;
	public static ArrayList<LanguagePojo> arrayList = new ArrayList<>();
	public static String filePath = "D:/Test_LAUNCH_StringFile_Latest_JBay_07.xls";

	public static ArrayList<LanguagePojo> getlanguages(HSSFWorkbook workbook, HSSFSheet sheet, JSONParser jsonParser,
			String JsonFile) {

		try {
			FileReader reader = new FileReader(JsonFile);
			object = jsonParser.parse(reader);
			
			JSONArray jsonArray = (JSONArray) object;
			String language = null;

			for (int i = 0; i < jsonArray.size(); i++) {
				JSONObject jsonObject = (JSONObject) jsonArray.get(i);

				String identifier = (String) jsonObject.get("identifier");
				if (jsonObject.containsKey("english")) {
					language = (String) jsonObject.get("english");
				}
				if (jsonObject.containsKey("ptBR")) {
					language = (String) jsonObject.get("ptBR");
				}
				if (jsonObject.containsKey("zhCN")) {
					language = (String) jsonObject.get("zhCN");
				}
				if (jsonObject.containsKey("deDE")) {
					language = (String) jsonObject.get("deDE");
				}
				if (jsonObject.containsKey("esES")) {
					language = (String) jsonObject.get("esES");
				}
				if (jsonObject.containsKey("frFR")) {
					language = (String) jsonObject.get("frFR");
				}
				if (jsonObject.containsKey("itIT")) {
					language = (String) jsonObject.get("itIT");
				}
				if (jsonObject.containsKey("jaJP")) {
					language = (String) jsonObject.get("jaJP");
				}
				if (jsonObject.containsKey("koKR")) {
					language = (String) jsonObject.get("koKR");
				}
				if (jsonObject.containsKey("ruRU")) {
					language = (String) jsonObject.get("ruRU");
				}
				if (jsonObject.containsKey("svSE")) {
					language = (String) jsonObject.get("svSE");
				}
				if (jsonObject.containsKey("zhTW")) {
					language = (String) jsonObject.get("zhTW");
				}

				JSONObject jsonObjectNote = (JSONObject) jsonObject.get("note");
				Long fontSize = (Long) jsonObjectNote.get("fontSize");
				Long textAlignment = (Long) jsonObjectNote.get("textAlignment");
				String fontName = (String) jsonObjectNote.get("fontName");
				Long maxChar = (Long) jsonObjectNote.get("maxChar");
				Long maxLine = (Long) jsonObjectNote.get("maxLine");

				JSONObject jsonObjectSize = (JSONObject) jsonObjectNote.get("size");
				Object width = (Object) jsonObjectSize.get("width");
				Object height = (Object) jsonObjectSize.get("height");

				arrayList.add(new LanguagePojo(identifier, language, fontSize, textAlignment, fontName, maxChar,
						maxLine, width, height));
			}

		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arrayList;
	}
}
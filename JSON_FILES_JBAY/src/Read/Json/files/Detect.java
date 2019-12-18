package Read.Json.files;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Detect {
	private static Set<String> allLangUniCodes = new HashSet<String>();
	private static FileReader readFile;
	private static FileWriter writeFile;
	private static String unicode_value;
	private static Scanner scanner;
	static int index1,languageFileCount = 0;
	static int index2;
	private int min_Range,max_Range;
	private static ArrayList<String> lines;
	public static void main(String[] args)
	{
		try
		{
			File folder = new File("./");
			File[] listOfFiles = folder.listFiles();
			for (File file : listOfFiles) {
				if (file.isFile() && file.getName().endsWith(".txt")) {	
					readFile = new FileReader(file);
						scanner = new Scanner(readFile).useDelimiter(",");
						while (scanner.hasNext()) {
							unicode_value = scanner.next();
							allLangUniCodes.add(unicode_value);
						}
						//System.out.println("File: "+languageFileCount+ "unicodes added.");
						languageFileCount++;
				}
			}
			final_font_sheet();
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
	}
	private static void final_font_sheet()
	{
		try
		{
			languageFileCount = 0;
			int index = 0;
			boolean flag = false;
			File folder = new File("./");
			File[] listOfFiles = folder.listFiles();
			for (File file : listOfFiles) {
				if (file.isFile() && file.getName().endsWith(".txt")) {
					lines = new ArrayList<String>();	
					readFile = new FileReader(file);
						scanner = new Scanner(readFile).useDelimiter(",");
						String unicodeValue1,unicodeValue2;
						while (scanner.hasNext()) 
						{
							unicodeValue1 = scanner.next();
							Iterator<String> itr = allLangUniCodes.iterator();
							System.out.println(allLangUniCodes.size());
							while (itr.hasNext()) 
							{
								unicodeValue2 = itr.next();
								if (unicodeValue1.endsWith(unicodeValue2))
								{
									flag = removeStringValue(unicodeValue1,file);;
									if(flag == true)
									{
										itr.remove();
										flag = false;
									}
								}
							}
						} 
						writeFile = new FileWriter(file);
						PrintWriter pw = new PrintWriter(writeFile);
						pw.write("");
						for (String s : lines)
							writeFile.write(s + ",");
						writeFile.close();
						pw.close();
						scanner.close();
						//System.out.println("Same unicodes from multiple files are deleted.");
				}
			}
			//System.out.println(index);
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
			
	}
	private static boolean removeStringValue(String value,File fname)
	{
		
		String tempUnicode;
		Detect detect = new Detect();
		detect.calculate_min_max_range(detect,fname);
		tempUnicode = value.substring(2, value.length());
		if(Integer.parseInt(tempUnicode,16)> detect.min_Range && Integer.parseInt(tempUnicode,16)< detect.max_Range)
		{
			lines.add(value);
			return true;
		}
		else
			return false;
	}
	
	private Detect calculate_min_max_range(Detect detect,File fname)
	{
		String temp = fname.getName();
		switch (temp) {
		case "Default.txt":
			{
				detect.min_Range = 32;
				detect.max_Range = 8447;
				break;
			}
		case "Portuguese.txt":
		{
			detect.min_Range = 32;
			detect.max_Range = 8447;
			break;
		}
		case "Chinese.txt":
		{
			detect.min_Range = 12288;
			detect.max_Range = 65519;
			break;
		}
		case "Tchinese.txt":
		{
			detect.min_Range = 12288;
			detect.max_Range = 65519;
			break;
		}
		case "Korean.txt":
		{
			detect.min_Range = 44032;
			detect.max_Range = 55215;
			break;
		}
		case "Russian.txt":
		{
			detect.min_Range = 1024;
			detect.max_Range = 1279;
			break;
		}
		case "Japanese.txt":
		{
			detect.min_Range = 12288;
			detect.max_Range = 65519;
			break;
		}
		case "Spanish.txt":
		{
			detect.min_Range = 32;
			detect.max_Range = 8447;
			break;
		}
		case "German.txt":
		{
			detect.min_Range = 32;
			detect.max_Range = 8447;
			break;
		}
		case "Swedish.txt":
		{
			detect.min_Range = 32;
			detect.max_Range = 8447;
			break;
		}
		default:
			break;
		}
		
		return detect;
	}
		
	
}
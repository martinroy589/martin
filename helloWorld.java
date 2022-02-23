package Test.com;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;

public class helloWorld {

    /**
     * @param args
     */
private static final String CSVFILEPATH = "src/csvfolder/ClassName_Table.csv";
private static final String CSVFILEPATHS = "src/csvfolder/StaffName_Table.csv";
private static final String CSVFILEPATHSSS = "src/csvfolder/Student_Data.csv";

	public static void main(String[] args) throws Exception {
		loadDataFromCsv();
	}
	
	private static void loadDataFromCsv() throws Exception {

		File file = new File(CSVFILEPATH);
		
		File files = new File(CSVFILEPATHS);
		
		File filess = new File(CSVFILEPATHSSS);
		
		byte[] bytes = FileUtils.readFileToByteArray(file);
		byte[] bytess = FileUtils.readFileToByteArray(files);
		byte[] bytesss = FileUtils.readFileToByteArray(filess);
		
		
		String data = new String(bytes);
		String datas = new String(bytess);
		String datass = new String(bytesss);
		
		String[] dataArray = data.split("\n");
		String[] dataArrays = datas.split("\n");
		String[] dataArrayss = datass.split("\n");
		
		String keys = dataArray[0];
		String keyss = dataArrays[0];
		String keysss = dataArrayss[0];
		
		Map<String, Map<String, String>> outerMap = new HashMap<>();
		List<String> keysFromFile = new ArrayList<>();
		
		String[] keyArr = keys.split(",");
		String[] keyArrs = keyss.split(",");
		String[] keyArrss = keysss.split(",");
		
		keysFromFile.addAll(Arrays.asList(keyArr));
		keysFromFile.addAll(Arrays.asList(keyArrs));
	//    keysFromFile.addAll(Arrays.asList(keyArrss));
		
		keysFromFile.remove(0);
		
		for(int d = 0; d < dataArray.length; d++) {
			Map<String, String> mp = new HashMap<>();
			List<String> row = new ArrayList<>();
			
			String[] rowArr = dataArray[d].split(",");
			row.addAll(Arrays.asList(rowArr));
			String keyForTestCase = row.get(0);
			row.remove(0);
		
		for( int i = 1; i < keysFromFile.size(); i++) {
			mp.put(keysFromFile.get(i).trim(), row.get(i).trim());
		}
		outerMap.put(keyForTestCase, mp);
		}
		
		
		for(int d = 1; d < dataArrays.length; d++) {
			Map<String, String> mp = new HashMap<>();
			List<String> row = new ArrayList<>();
			
			String[] rowArr = dataArrays[d].split(",");
			row.addAll(Arrays.asList(rowArr));
			String keyForTestCase = row.get(0);
			row.remove(0);
		
		for( int i = 0; i < keysFromFile.size(); i++) {
			mp.put(keysFromFile.get(i).trim(), row.get(i).trim());
		}
		outerMap.put(keyForTestCase, mp);
		}
		
		for(int d = 1; d < dataArrayss.length; d++) {
			Map<String, String> mp = new HashMap<>();
			List<String> row = new ArrayList<>();
			
			String[] rowArr = dataArrayss[d].split(",");
			row.addAll(Arrays.asList(rowArr));
			String keyForTestCase = row.get(0);
			row.remove(0);
		
		for( int i = 0; i < keysFromFile.size(); i++) {
			mp.put(keysFromFile.get(i).trim(), row.get(i).trim());
		}
		outerMap.put(keyForTestCase, mp);
		}
		
		Map<String, String> rowMap = outerMap.get("A_001");
		JSONObject jsonData = new JSONObject(outerMap);
		System.out.println(jsonData);
	}

}

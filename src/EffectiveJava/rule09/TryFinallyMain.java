package EffectiveJava.rule09;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TryFinallyMain {
	
	public static void main(String[] args) throws IOException {
		TryFinallyMain.readFile("C:\\Users\\88691\\Desktop\\file.txt");	
	}
	
	/**
	 * 字元組 讀檔 Reader
	 * BufferedReader 為 Reader 的擴充
	 */
	public static void readFile(String filePath) {
			
		FileReader fileReader = null;
		BufferedReader br = null;
		
		try {
			
			fileReader = new FileReader(filePath);
			br = new BufferedReader(fileReader);
			
			String line;
			
			// readline() 會刪除每行結尾的換行然後回傳
			while( (line = br.readLine()) != null) {
				System.out.println(line);
			}
			
		} catch (FileNotFoundException e) {
			// 無法找到檔案
			e.printStackTrace();
		} catch (IOException e) {
			// 讀檔異常
			e.printStackTrace();
		} finally {
	
			if ( br != null) {
				try {
					br.close();
				} catch (IOException e) {
					// 關閉 bufferedReader 異常
					e.printStackTrace();
				}
			}
	
			if ( fileReader != null) {
				try {
					fileReader.close();
				} catch (IOException e) {
					// 關閉 fileReader 異常
					e.printStackTrace();
				}
			}
		}		
	}
}

package EffectiveJava.rule09;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class TryResourcesMain {
	
	public static void main(String[] args) {
		TryResourcesMain.readFile("C:\\Users\\88691\\Desktop\\file.txt");
	}
	
	/**
	 * 字元組 讀檔 Reader
	 * BufferedReader 為 Reader 的擴充
	 */
	public static void readFile(String filePath) {
		
		// try-with-resources
		try(
			Reader reader = new FileReader(filePath);
			BufferedReader br =  new BufferedReader(reader)
			) {
									
			String line;
			
			// readline() 會刪除每行結尾的換行然後回傳
			while( (line = br.readLine()) != null) {
				System.out.println(line);
			}
			
		} catch (FileNotFoundException e) {
			// 找不到檔案處理
			e.printStackTrace();
		} catch (IOException e) {
			// 讀檔錯誤處理
			e.printStackTrace();
		}	
	}
}

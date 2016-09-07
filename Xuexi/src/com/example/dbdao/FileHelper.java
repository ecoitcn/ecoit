package com.example.dbdao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileHelper {
//	public String load() {
//		FileInputStream in = null;
//		BufferedReader reader = null;
//		StringBuilder content = new StringBuilder();
//		try {
//			in = openFileInput("data");
//			reader = new BufferedReader(new InputStreamReader(in));
//			String line = "";
//			while ((line = reader.readLine()) != null) {
//				content.append(line);
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		} finally {
//			if (reader != null) {
//				try {
//					reader.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//		return content.toString();
//	}
//
//	public void save(String inputText) {
//		FileOutputStream out = null;
//		BufferedWriter writer = null;
//		try {
//			out = openFileOutput("data", Context.MODE_PRIVATE);
//			writer = new BufferedWriter(new OutputStreamWriter(out));
//			writer.write(inputText);
//		} catch (IOException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if (writer != null) {
//					writer.close();
//				}
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//	}
}

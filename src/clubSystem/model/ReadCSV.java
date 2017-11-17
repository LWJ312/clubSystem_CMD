package clubSystem.model;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class ReadCSV {
    public ReadCSV() {
		// TODO Auto-generated constructor stub
	}
    
    public ArrayList<String[]> getDataFromCSV(String file_url) {
    	ArrayList<String[]> data=new ArrayList<>();
  	  
  	  try {
  		  FileInputStream fis=new FileInputStream(file_url);
  		  InputStreamReader isr=new InputStreamReader(fis,"gb2312");
  		  BufferedReader br=new BufferedReader(isr);
  		  
  		  String str=null;
  		  str=br.readLine();
		  str=br.readLine();
			
  		  while((str=br.readLine())!=null) {
  			data.add(str.split(","));
  			  
  		  }
  		  br.close();
  		  isr.close();
  		  fis.close();
  		 
  	} catch (Exception e) {
  		// TODO: handle exception
  		System.out.println(e);
  		e.printStackTrace();
  		
  	}
	return data;
	}  
}

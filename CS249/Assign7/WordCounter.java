//Author: Gerald Wolff
 
import java.util.*;
import java.io.*;
import java.net.URL;
public class WordCounter {

	public static WordCountData count(String path) throws Exception{
		int charCnt = 0;
		int lineCnt = 0;
		int wordCnt = 0;
		if(path.contains("http")) 
		{
		URL url = new URL(path);
		Scanner pageInput = new Scanner(url.openStream());
		while(pageInput.hasNext())
		{
			String line = pageInput.nextLine();
			for(int i = 0;i<line.length();i++){
				if(line.charAt(i)==' '){
					wordCnt++;
				}
		}
			lineCnt ++; 
			charCnt += line.length();	
		}
		pageInput.close();
}
		else 	
		{
			
			File file = new File(path);
			Scanner fileInput = new Scanner(new File(path));
			if(file.exists())
			{
				while(fileInput.hasNext())
				{
					String line = fileInput.nextLine();
					for(int i = 0;i<line.length();i++){
						if(line.charAt(i)==' '){
							wordCnt++;
						}
						lineCnt++;
						charCnt +=line.length();
					
				}
			}
			fileInput.close();
		}
		
	}
		WordCountData info = new WordCountData(charCnt, wordCnt, lineCnt);
		return info;
}
}



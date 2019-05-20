//Author: Gerald Wolff
 
public class WordCountData {
	private int charCnt = 0;
	private int wordCnt = 0;
	private int lineCnt = 0;
	
	public WordCountData(int newCharCnt, int newWordCnt, int newLineCnt)
	{
		charCnt = newCharCnt;
		wordCnt = newWordCnt;
		lineCnt = newLineCnt;
	}
	
	public int getCharCnt()
	{
		return charCnt;
	}
	
	public int getWordCnt()
	{
		return wordCnt;
	}
	
	public int getLineCnt()
	{
		return lineCnt;
	}
}

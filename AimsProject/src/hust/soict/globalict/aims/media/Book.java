package hust.soict.globalict.aims.media;

import java.util.*;

public class Book extends Media {
	private List<String> authors = new ArrayList<String>();
	private String content;
	private List<String> contentTokens=new ArrayList<String>();
	private TreeMap<String,Integer> wordFrequency=new TreeMap<String,Integer>();
	
	public List<String> getAuthors() {
		return authors;
	}
	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public void addAuthor(String Authorname) {
		if(authors.contains(Authorname)==false)
			authors.add(Authorname);
	}

	public void removeAuthor(String Authorname) {
		if(authors.contains(Authorname)==true)
			authors.remove(Authorname);
	}
	public Book(String title) {
		super(title);
	}
	public Book(String title,String category) {
		super(title,category);
	}
	public Book(int id,String title,String category,float cost) {
		super(id,title,category,cost);
	}
	public Book(int id,String title,String category,float cost,List<String> authors) {
		super(id,title,category,cost);
		this.authors=authors;
	}
	
	public void processContent() {
		String[]st=content.split("[\\p{Punct}\\s]+");
		Arrays.sort(st);
		for(String array:st) {
			if(!contentTokens.contains(array))
				contentTokens.add(array);
		}
		for(String array:st) {
			int pre=0;
			if(wordFrequency.get(array)!=null) {
				pre=wordFrequency.get(array);
			}
			wordFrequency.put(array,pre+1);
		}
	}
	
	public String toString() {
		return getId()+" - "+getTitle()+" - "+getCategory()+" - "+getCost()+" - "+authors+" - "+contentTokens.size()+"\n"+contentTokens+"\n"+wordFrequency;
	}



}

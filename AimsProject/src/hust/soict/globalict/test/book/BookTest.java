package hust.soict.globalict.test.book;

import hust.soict.globalict.aims.media.Book;

public class BookTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Book b1=new Book("ABC");
		b1.setId(123);
		b1.setCategory("Science");
		b1.setCost(30.05f);
		b1.addAuthor("Vu Tung Lam");
		b1.addAuthor("Nguyen Dung");
		b1.setContent("i wake up in the morning, study online, play piano during the afternoon and play online game in the evening");
		b1.processContent();
		System.out.println(b1);

	}

}

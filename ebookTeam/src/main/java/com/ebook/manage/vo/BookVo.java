package com.ebook.manage.vo;

public class BookVo {
    
    private int    bookkey;       
    private String title;
    private String description;
    private String link;
    private String isbn;
    private String author;
    private String publisher;
    private String image;
    
    //생성자
    public BookVo() {}
	public BookVo(int bookkey, String title, String description, String link, String isbn, String author,
			String publisher, String image) {
		super();
		this.bookkey = bookkey;
		this.title = title;
		this.description = description;
		this.link = link;
		this.isbn = isbn;
		this.author = author;
		this.publisher = publisher;
		this.image = image;
	}
	public int getBookkey() {
		return bookkey;
	}
	public void setBookkey(int bookkey) {
		this.bookkey = bookkey;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	
	
	
	
	
	@Override
	public String toString() {
		return "BookVo [bookkey=" + bookkey + ", title=" + title + ", description=" + description + ", link=" + link
				+ ", isbn=" + isbn + ", author=" + author + ", publisher=" + publisher + ", image=" + image + "]";
	}
    
    
	
}
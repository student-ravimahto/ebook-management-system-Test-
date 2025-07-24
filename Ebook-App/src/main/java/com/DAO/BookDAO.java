package com.DAO;

import java.util.List;



import com.entity.BookDtse;


public interface BookDAO {
	
	public boolean addBooks(BookDtse b);
	
	public List<BookDtse> getAllBooks();
	
	public BookDtse getBookById(int id);
	
	public boolean updateEditBooks(BookDtse b);
	
	public boolean deleteBooks(int id);
	
	public List<BookDtse> getNewBook();
	
	public List<BookDtse> getRecentBooks();
	
	public List<BookDtse> getOldBooks();
	
	public List<BookDtse> getAllRecentBook();
	
	public List<BookDtse> getAllNewBook();
	
	public List<BookDtse> getAllOldBook();
	
	public List<BookDtse> getBookByOld(String email,String cate);
	
	public boolean oldBookDelete(String email,String cate,int id);
	
	public List<BookDtse> getBookBySerch(String ch);
}

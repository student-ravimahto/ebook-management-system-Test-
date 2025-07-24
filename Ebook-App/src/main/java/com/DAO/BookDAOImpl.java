package com.DAO;

import java.sql.Connection;



import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.BookDtse;

public class BookDAOImpl implements BookDAO {
	
	private Connection conn;
	

	public BookDAOImpl(Connection conn) {
		super();
		this.conn = conn;
	}


	@Override
	public boolean addBooks(BookDtse b) {
		boolean f = false;
		try {
			String sql = "insert into book_dts(bookname,author,price,bookCategory,status,photo,email) values(?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, b.getBookName());
			ps.setString(2, b.getAuthor());
			ps.setString(3, b.getPrice());
			ps.setString(4, b.getBookCategory());
			ps.setString(5, b.getStatus());
			ps.setString(6, b.getPhotoName());
			ps.setString(7, b.getEamil());
			
			int i = ps.executeUpdate();
			
			if(i==1) {
				f = true;
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return f;
	}


	@Override
	public List<BookDtse> getAllBooks() {
		
		List<BookDtse> list = new ArrayList<BookDtse>();
		BookDtse b = null;
		try {
			String sql = "select * from book_dts";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				b = new BookDtse();
				b.setBookId(rs.getInt(1));
				b.setBookName(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setPrice(rs.getString(4));
				b.setBookCategory(rs.getString(5));
				b.setStatus(rs.getString(6));
				b.setPhotoName(rs.getString(7));
				b.setEamil(rs.getString(8));
				list.add(b);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}


	@Override
	public BookDtse getBookById(int id) {
		
		BookDtse b = null;
		
		try {
			String sql = "select * from book_dts where bookId=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				
				b = new BookDtse();
				b.setBookId(rs.getInt(1));
				b.setBookName(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setPrice(rs.getString(4));
				b.setBookCategory(rs.getString(5));
				b.setStatus(rs.getString(6));
				b.setPhotoName(rs.getString(7));
				b.setEamil(rs.getString(8));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}


	@Override
	public boolean updateEditBooks(BookDtse b) {
		
		boolean f = false;
		
		try {
		
			String sql = "update  book_dts set bookname=?, author=?, price=?, status=? where bookId=?";

		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setString(1, b.getBookName());
		ps.setString(2, b.getAuthor());
		ps.setString(3, b.getPrice());
		ps.setString(4, b.getStatus());
		ps.setInt(5, b.getBookId());
		
		int i = ps.executeUpdate();
		if(i==1) {
			f=true;
		}
		
    
	}catch (Exception e) {
		e.printStackTrace();
	}
		return f;
	}


	@Override
	public boolean deleteBooks(int id) {
	boolean f = false;
	
	try {
		String sql = "delete from  book_dts where bookId=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1,id);
		int i = ps.executeUpdate();
		if(i==1) {
			f=true;
		}
		
	}catch (Exception e) {
		e.printStackTrace();
	}
		return f;
	}


	@Override
	public List<BookDtse> getNewBook() {
		List<BookDtse> list=new ArrayList<BookDtse>();
		BookDtse b= null;
		
		try {
			String sql = "select * from  book_dts  where bookCategory=? and status=? order by bookId DESC" ;
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,"New");
			ps.setString(2,"Active");
			ResultSet rs = ps.executeQuery();
			int i=1;
			while(rs.next() && i<=4) {
				
				b = new BookDtse();
				b.setBookId(rs.getInt(1));
				b.setBookName(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setPrice(rs.getString(4));
				b.setBookCategory(rs.getString(5));
				b.setStatus(rs.getString(6));
				b.setPhotoName(rs.getString(7));
				b.setEamil(rs.getString(8));
				list.add(b);
				i++;
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;	
		}


	@Override
	public List<BookDtse> getRecentBooks() {
		
		List<BookDtse> list=new ArrayList<BookDtse>();
		BookDtse b= null;
		
		try {
			String sql = "select * from  book_dts  where status=? order by bookId DESC";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,"Active");
			ResultSet rs = ps.executeQuery();
			int i=1;
			while(rs.next() && i<=4) {
				
				b = new BookDtse();
				b.setBookId(rs.getInt(1));
				b.setBookName(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setPrice(rs.getString(4));
				b.setBookCategory(rs.getString(5));
				b.setStatus(rs.getString(6));
				b.setPhotoName(rs.getString(7));
				b.setEamil(rs.getString(8));
				list.add(b);
				i++;
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}


	@Override
	public List<BookDtse> getOldBooks() {
		
		
		List<BookDtse> list=new ArrayList<BookDtse>();
		BookDtse b= null;
		
		try {
			String sql = "select * from  book_dts  where bookCategory=? and status=? order by bookId DESC" ;
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,"Old");
			ps.setString(2,"Active");
			ResultSet rs = ps.executeQuery();
			int i=1;
			while(rs.next() && i<=4) {
				
				b = new BookDtse();
				b.setBookId(rs.getInt(1));
				b.setBookName(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setPrice(rs.getString(4));
				b.setBookCategory(rs.getString(5));
				b.setStatus(rs.getString(6));
				b.setPhotoName(rs.getString(7));
				b.setEamil(rs.getString(8));
				list.add(b);
				i++;
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;

	}


	@Override
	public List<BookDtse> getAllRecentBook() {
		List<BookDtse> list=new ArrayList<BookDtse>();
		BookDtse b= null;
		
		try {
			String sql = "select * from  book_dts  where status=? order by bookId DESC";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,"Active");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				b = new BookDtse();
				b.setBookId(rs.getInt(1));
				b.setBookName(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setPrice(rs.getString(4));
				b.setBookCategory(rs.getString(5));
				b.setStatus(rs.getString(6));
				b.setPhotoName(rs.getString(7));
				b.setEamil(rs.getString(8));
				list.add(b);
			
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}


	@Override
	public List<BookDtse> getAllNewBook() {
		List<BookDtse> list=new ArrayList<BookDtse>();
		BookDtse b= null;
		
		try {
			String sql = "select * from  book_dts  where bookCategory=? and status=? order by bookId DESC" ;
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,"New");
			ps.setString(2,"Active");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				b = new BookDtse();
				b.setBookId(rs.getInt(1));
				b.setBookName(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setPrice(rs.getString(4));
				b.setBookCategory(rs.getString(5));
				b.setStatus(rs.getString(6));
				b.setPhotoName(rs.getString(7));
				b.setEamil(rs.getString(8));
				list.add(b);
				
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}


	@Override
	public List<BookDtse> getAllOldBook() {
		List<BookDtse> list=new ArrayList<BookDtse>();
		BookDtse b= null;
		
		try {
			String sql = "select * from  book_dts  where bookCategory=? and status=? order by bookId DESC" ;
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,"Old");
			ps.setString(2,"Active");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				b = new BookDtse();
				b.setBookId(rs.getInt(1));
				b.setBookName(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setPrice(rs.getString(4));
				b.setBookCategory(rs.getString(5));
				b.setStatus(rs.getString(6));
				b.setPhotoName(rs.getString(7));
				b.setEamil(rs.getString(8));
				list.add(b);
			
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}


	@Override
	public List<BookDtse> getBookByOld(String email,String cate) {

		List<BookDtse> list=new ArrayList<BookDtse>();
		BookDtse b= null;
		
		try {
			
			String sql = "select * from  book_dts  where bookCategory=? and email=?" ;
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, cate);
			ps.setString(2, email);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				b = new BookDtse();
				b.setBookId(rs.getInt(1));
				b.setBookName(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setPrice(rs.getString(4));
				b.setBookCategory(rs.getString(5));
				b.setStatus(rs.getString(6));
				b.setPhotoName(rs.getString(7));
				b.setEamil(rs.getString(8));
				list.add(b);
				
			}	
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}


	@Override
	public boolean oldBookDelete(String email, String cate, int id) {
		boolean f=false;
		try {
			String sql = "delete from book_dts where bookCategory=? and email=? and bookId=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, cate);
			ps.setString(2, email);
			ps.setInt(3, id);
			
			int i = ps.executeUpdate();
			
			if(i==1) {
				f = true;
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return f;
	}


	@Override
	public List<BookDtse> getBookBySerch(String ch) {
		
		List<BookDtse> list=new ArrayList<BookDtse>();
		BookDtse b= null;
		
		try {
			
			String sql = "select * from  book_dts  where bookname like ? or author like ? or bookCategory like ? and status=?" ;
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "%"+ch+"%");
			ps.setString(2, "%"+ch+"%");
			ps.setString(3, "%"+ch+"%");
			ps.setString(4, "Active");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				b = new BookDtse();
				b.setBookId(rs.getInt(1));
				b.setBookName(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setPrice(rs.getString(4));
				b.setBookCategory(rs.getString(5));
				b.setStatus(rs.getString(6));
				b.setPhotoName(rs.getString(7));
				b.setEamil(rs.getString(8));
				list.add(b);
				
			}	
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	
	

}
	
	

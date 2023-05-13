package database;

import java.util.ArrayList;

public interface DAOInterface<T> { // ki thuat Generic
	
	// lay ra tat ca
	public ArrayList<T> selectAll();
	
	// lay ra 1 doi tuong
	public T selectById(T t);
	
	// them 1 doi tuong
	public int insert(T t);
	
	// them nhieu doi tuong
	public int insertAll(ArrayList<T> arr);
	
	// xoa 1 doi tuong
	public int delete(T t);
	
	// xoa nhieu doi tuong
	public int deleteAll(ArrayList<T> arr);
	
	// update doi tuong
	public int update(T t); 
}

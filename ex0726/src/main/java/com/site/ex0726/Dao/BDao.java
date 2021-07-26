package com.site.ex0726.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.site.ex0726.Vo.BVo;

	public class BDao {
		DataSource ds = null;
		Connection conn= null;
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		BVo bVo = null;
		
		String btitle,bcontent,bname,bupload;
		int bid,bgroup,bstep,bindent,bhit;
		Timestamp bdate;
		
	//리스트
	public ArrayList<BVo> BAllSelect(){
		ArrayList<BVo> list = new ArrayList<BVo>();
		
		try {
			conn = getConnection();
			String sql = "select * from board order by bid desc";
			pstmt = conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				bid = rs.getInt("bid");
				btitle = rs.getString("btitle");
				bcontent = rs.getString("bcontent");
				bname = rs.getString("bname");
				bgroup = rs.getInt("bgroup");
				bstep = rs.getInt("bstep");
				bindent = rs.getInt("bindent");
				bdate = rs.getTimestamp("bdate");
				bupload = rs.getString("bupload");
				bhit = rs.getInt("bhit");
				bVo = new BVo(bid,btitle,bcontent,bname,bgroup,bstep,bindent,bdate,bupload,bhit);
				list.add(bVo);
	
				
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		
		
		
		
		
		return list;
	}
	
	
	
	
	
	
	
	
	
	

	public Connection getConnection() throws Exception {
		Context context = new InitialContext();
		ds = (DataSource) context.lookup("java:comp/env/jdbc/Oracle11g");
		return ds.getConnection();
	}
	
	
}//class


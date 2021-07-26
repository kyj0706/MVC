package com.site.ex0721;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;



public class BoardDao {

	DataSource ds = null;
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	BoardVo boardVo =null;
	
	String btitle,bcontent,bname, bupload;
	int bid,bgroup,bstep,bindent,bhit;
	Timestamp bdate;
	
	//board 전체 게시물 가지고오기
	public ArrayList<BoardVo> boardAllSelect(){
		ArrayList<BoardVo> list = new ArrayList<BoardVo>();
		
		try {
			conn= getConnection();
			String sql="select * from board";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				bid = rs.getInt("bid");
				btitle =rs.getString("btitle");
				bcontent =rs.getString("bcontent");
				bname =rs.getString("bname");
				bgroup = rs.getInt("bgroup");
				bstep = rs.getInt("bstep");
				bindent = rs.getInt("bindent");
				bdate = rs.getTimestamp("BDATE");
				bupload =rs.getString("bupload");
				bhit = rs.getInt("bhit");
				boardVo = new BoardVo(bid,btitle,bcontent,bname,bgroup,bstep,bindent,bdate,bupload,bhit);
				list.add(boardVo);
				//System.out.println(bname);
			}
			
	    } catch (Exception e) {
	         e.printStackTrace();
	      }finally {
	         try {
	            if(rs != null) rs.close();
	            if(pstmt != null) pstmt.close();
	            if(conn != null) conn.close();
	            
	         } catch (Exception e2) {
	            e2.printStackTrace();   // TODO: handle exception
	         }
	      }
		
		
		return list;
		
	}
	//content_view단
	
	public BoardVo boardOneSelect(int bid) {
		try {
			conn= getConnection();
			String sql="select * from board where bid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bid);
			rs = pstmt.executeQuery();
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
		return boardVo;
	}
	
	
	
	
	//context 접금해서 DataSourece Connection 객체 1개 가져옴
	public Connection getConnection() throws Exception{
		Context context = new InitialContext(); 
		ds = (DataSource) context.lookup("java:comp/env/jdbc/Oracle11g");
		return ds.getConnection();
	}
	
}

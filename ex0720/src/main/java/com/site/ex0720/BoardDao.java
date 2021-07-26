package com.site.ex0720;

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
   BoardVo boardVo=null;
   
   public Connection getConnection() throws Exception{
      Context context = new InitialContext();
      
      ds = (DataSource)context.lookup("java:comp/env/jdbc/Oracle11g");
      
      return ds.getConnection();
   }
   
   
   
   int bid,bgroup,bstep,bindent,bhit;
   String btitle,bcontent,bname,bupload;
   Timestamp bdate;
   
   public int boardInsert(BoardVo boardVo) {
	   int result=0;
	   try {
	         conn = getConnection();
	         String sql = "insert into board values (board_seq.nextval,?,?,?,board_seq.currval,0,0,sysdate,?,0)";
	         pstmt = conn.prepareStatement(sql);
	         
	         pstmt.setString(1, boardVo.getBtitle());
	         pstmt.setString(2, boardVo.getBcontent());
	         pstmt.setString(3, boardVo.getBname());
	         pstmt.setString(4, boardVo.getBupload());
	         result =pstmt.executeUpdate();
	         
	         
	   } catch (Exception e) {
	         e.printStackTrace();
	      }finally {
	         try {
	            if(pstmt != null) pstmt.close();
	            if(conn != null) conn.close();
	            
	         } catch (Exception e2) {
	            e2.printStackTrace();   // TODO: handle exception
	         }
	      }
	      
	      
	      return result;
	   
   }
   
   
   
   
   public ArrayList<BoardVo> boardAllSelect(){
      
      ArrayList<BoardVo> list = new ArrayList<BoardVo>();
      
      try {
         conn = getConnection();
         String sql = "select * from board";
         pstmt = conn.prepareStatement(sql);
         rs = pstmt.executeQuery();
         
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
            //Board board = new Board();
            boardVo = new BoardVo(bid,btitle,bcontent,bname,bgroup,bstep,bindent,bdate,bupload,bhit);
            list.add(boardVo);
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
   
   
   //게시판 1개의 정보를 가져옴
   public BoardVo boardOneSelect(int bid) {
      
      try {
         conn = getConnection();
         String sql = "select * from board where bid=?";
         pstmt = conn.prepareStatement(sql);
         pstmt.setInt(1, bid);
         rs = pstmt.executeQuery();
         
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
            //Board board = new Board();
            boardVo = new BoardVo(bid,btitle,bcontent,bname,bgroup,bstep,bindent,bdate,bupload,bhit);
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
      return boardVo;
   }
   
   public BoardDao() {}
   
   
   
   
}
package com.site.ex0720;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class MemberDao {

	DataSource ds = null;
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	MemberVo memeberVo=null;
	
	
	 public Connection getConnection() throws Exception{
		 Context context = new InitialContext();
	      
		 ds = (DataSource)context.lookup("java:comp/env/jdbc/Oracle11g");
	      
		 return ds.getConnection();
	   }
	   
	     String id,pw,name,nickName,gender,tel,address1,address2,hobby;
		 
	     
	     
	     //게시판1개를 가지고옴
	 	public MemberVo memberOneSelect(String userId) {
			MemberVo memberVo= new MemberVo();
			
			try {
				conn = getConnection();//Connection메소드 호출
				String sql="select * from member2 where id=? ";
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, userId);
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					memberVo.setId(rs.getString("id"));
					memberVo.setPw(rs.getString("pw"));
					memberVo.setName(rs.getString("name"));
					memberVo.setNickName(rs.getString("nickName"));
					memberVo.setGender(rs.getString("gender"));
					memberVo.setTel(rs.getString("tel"));
					memberVo.setAddress1(rs.getString("address1"));
					memberVo.setAddress2(rs.getString("address2"));
					memberVo.setHobby(rs.getString("hobby"));	
				}
				
			}catch(Exception e){
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
			
			
			
			return memberVo;
		}
		
	     
	  
}

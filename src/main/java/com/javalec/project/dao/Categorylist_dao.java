package com.javalec.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.javalec.project.dto.BDto;

public class Categorylist_dao {
	DataSource dataSource;
	
	public Categorylist_dao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/OneLine"); //java:comp/env는 BListCommand다!
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	// ------------------------------------ 검색 부분 시작 --------------------------------------------
	// 전체 검색 (dao는 DB에서 가져오는 거고 jsp에 보내줘야되기때문에 dto를 만들러 가야됨)
		public ArrayList<BDto> list() {
			ArrayList<BDto> dtos = new ArrayList<BDto>();
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;
			
			try {
				connection = dataSource.getConnection();
				String query = "select bId, bName, bTitle, bDate from oneline_board"; 
				preparedStatement = connection.prepareStatement(query);
				resultSet = preparedStatement.executeQuery();
				
				while(resultSet.next()) {
					int bId = resultSet.getInt("bId");
					String bName = resultSet.getString("bName");
					String bTitle = resultSet.getString("bTitle");
					Timestamp bDate = resultSet.getTimestamp("bDate");//timestamp는 ctrl+space눌러줘!
					
					BDto dto = new BDto(bId, bName, bTitle, bDate); // dto에 다 넣은것
					dtos.add(dto); // ArrayList dtos에 dto한줄씩 쌓는다.
				}
				
			}catch (Exception e) {
				e.printStackTrace();
			}finally { // finally는 위에 try/catch문이 이상이 있든 없거나 무조건 온다
				try {
					if(resultSet != null) resultSet.close(); // resultSet에 데이터가 있으면 닫아줘
					if(preparedStatement != null) preparedStatement.close(); // resultSet에 데이터가 있으면 닫아줘
					if(connection != null) connection.close(); // resultSet에 데이터가 있으면 닫아줘
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			return dtos;
		} // list

} //Categorylist_dao class

package model.mem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import model.common.JDBC;

// @Component를 상속받는 @Repository
@Repository("memDAO")
public class MemDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private final String insertSQL="INSERT INTO MEM (ID,PASSWORD,NAME,ROLE) VALUES (?,?,?,?)";
	private final String updateSQL="UPDATE MEM SET NAME=?, PASSWORD=? where ID=?";
	private final String deleteSQL="DELETE MEM WHERE ID=?";
	private final String getMemSQL="SELECT * FROM MEM WHERE ID=? AND PASSWORD=?";
	private final String getMemListSQL="SELECT * FROM MEM";

	public void insertMem(MemVO vo) {
		System.out.println("dao로 insert");
		//insertSQL="INSERT INTO MEM (ID,PASSWORD,NAME,ROLE) VALUES (?,?,?,?)";
		try {
			conn=JDBC.getConnection();
			pstmt=conn.prepareStatement(insertSQL);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPassword());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getRole());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			JDBC.close(conn, pstmt);
		}
	}
	public void updateMem(MemVO vo) {
		System.out.println("dao로 update");
		//updateSQL="UPDATE MEM SET NAME=?, PASSWORD=? where ID=?";
		try {
			conn=JDBC.getConnection();
			pstmt=conn.prepareStatement(updateSQL);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getPassword());
			pstmt.setString(3, vo.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			JDBC.close(conn, pstmt);
		}
	}
	public void deleteMem(MemVO vo) {
		System.out.println("dao로 delete");
		//deleteSQL="DELETE MEM WHERE ID=?";
		try {
			conn=JDBC.getConnection();
			pstmt=conn.prepareStatement(deleteSQL);
			pstmt.setString(1, vo.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			JDBC.close(conn, pstmt);
		}
	}
	public List<MemVO> getMemList(MemVO vo) {
		System.out.println("dao로 getList");
		// getBoardListSQL="SELECT * FROM MEM";
		List<MemVO> datas=new ArrayList<MemVO>();
		try {
			conn=JDBC.getConnection();
			pstmt=conn.prepareStatement(getMemListSQL);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				MemVO data=new MemVO();
				data.setId(rs.getString("id"));
				data.setPassword(rs.getString("password"));
				data.setName(rs.getString("name"));
				data.setRole(rs.getString("role"));
				datas.add(data);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			JDBC.close(conn, pstmt,rs);
		}
		return datas;
	}
	public MemVO getMem(MemVO vo) {
		System.out.println("dao로 get");
		// 로그인에 성공한다면, MemVO객체가 리턴(반환)
		// 실패한다면 리턴이 null 
		// getMemSQL="SELECT * FROM MEM WHERE ID=? AND PASSWORD=?";
		MemVO data=null;
		try {
			conn=JDBC.getConnection();
			pstmt=conn.prepareStatement(getMemSQL);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPassword());
			rs=pstmt.executeQuery();
			if(rs.next()) {
				data=new MemVO();
				data.setId(rs.getString("id"));
				data.setPassword(rs.getString("password"));
				data.setName(rs.getString("name"));
				data.setRole(rs.getString("role"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			JDBC.close(conn, pstmt, rs);
		}
		return data;
	}
}

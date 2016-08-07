package model2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model2.vo.Customer;
import model2.vo.PersonInfo;
import model2.vo.SearchCondition;
import model2.vo.TargetList;

public class Dao {

	private Connection con;
	private PreparedStatement pstmt;
	private String sql;

	public int insertCus(Customer cus) {
		int result = 0;
		try {
			con = ConnectionManager.getConnection();
			String sql = "insert into customer values(?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, cus.getId());
			pstmt.setString(2, cus.getPw());
			pstmt.setString(3, cus.getMail());
			pstmt.setString(4, cus.getType());
			pstmt.setString(5, cus.getName());
			pstmt.setString(6, cus.getCode());
			pstmt.setString(7, cus.getAddr());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}

		return result;
	}

	public int checkCus(String id) {
		int result = 0;
		try {
			con = ConnectionManager.getConnection();
			String sql = "select * from customer where custid = ?";
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, id);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}

		return result;
	}

	public Customer loginCus(String id, String pw) {
		Customer result = null;
		try {
			con = ConnectionManager.getConnection();
			String sql = "select * from customer where custid = ? AND password= ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);

			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				String cid = rs.getString(1);
				String psw = rs.getString(2);
				String mail = rs.getString(3);
				String type = rs.getString(4);
				String name = rs.getString(5);
				String code = rs.getString(6);
				String addr = rs.getString(7);
				result = new Customer(cid, psw, mail, type, name, code, addr);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}

		return result;
	}

	public ArrayList<TargetList> PersonalList(SearchCondition search) {
		System.out.println("검색조건 :" + search);

		ArrayList<TargetList> c_list = new ArrayList<TargetList>();
		String key = search.getKey();
		String text = search.getText();
		String gender = search.getGender();// null이면 전체선택
		String type = search.getType();// null이면 전체선택

		try {
			con = ConnectionManager.getConnection();

			String sql1 = "  PI_SEX LIKE ";
			String sql2 = " PI_PUBLICFLAG LIKE ";
			String and = " AND ";
			String where = " WHERE ";

			System.out.println(text + "[text]");

			if (!text.equals("")) {
				sql = "SELECT * FROM PERSONAL_INFORMATION WEHRE" + key + "like %" + text + "%";
				if (!gender.equals("") && type.equals("")) {
					sql += and + sql1 + gender;
				}
				if (gender.equals("") && !type.equals("")) {
					sql += and + sql2 + type;
				}
				if (!gender.equals("") && !type.equals("")) {
					sql += and + sql1 + gender + and + sql2 + type;
				}
				// 마지막 경우의 수, 모두 전체범위인경우는 로컬 쿼리 그대로
			}

			if (text.equals("")) {
				System.out.println("2");

				sql = "SELECT * FROM PERSONAL_INFORMATION ";
				if (!gender.equals("") && type.equals("")) {
					sql += where + sql1 + gender;
				}
				if (gender.equals("") && !type.equals("")) {
					sql += where + sql2 + type;
				}
				if (!gender.equals("") && !type.equals("")) {
					sql += where + sql1 + gender + and + sql2 + type;
				}
				// 마지막 경우의 수, 모두 전체범위인경우는 로컬 쿼리 그대로

			}
			System.out.println(sql);

			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			int num = 1;
			while (rs.next()) {
				String name1 = rs.getString(2);
				String name2 = rs.getString(3);
				String name = name1 + name2;
				int age = rs.getInt(5);
				int gender_01 = rs.getInt(4);
				String major = rs.getString(14);
				String job = rs.getString(6);
				int type_01 = rs.getInt("PI_PUBLICFLAG");

				System.out.println(
						num + "/" + name + "/" + age + "/" + gender_01 + "/" + major + "/" + job + "/" + type_01);

				TargetList list = new TargetList(num, name, age, gender_01, major, job, type_01, rs.getInt(1));
				c_list.add(list);// 담는다.
				num++;
			}
			System.out.println("db : " + c_list);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return c_list;

	}

	public int insertInfo(PersonInfo info) {
		int result = 0;
		try {
			con = ConnectionManager.getConnection();
			String sql = "insert into personal_information values(pi_seq.nextval,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, info.getFirst_name());
			pstmt.setString(2, info.getLast_name());
			pstmt.setString(3, info.getSex());
			// pstmt.setString(4, info.getAge());
			pstmt.setInt(4, 0);
			pstmt.setString(5, info.getJob());
			pstmt.setString(6, info.getField());
			pstmt.setString(7, info.getSchool());
			pstmt.setString(8, info.getFamily());
			pstmt.setString(9, info.getDept());
			pstmt.setString(10, info.getPosition());
			pstmt.setString(11, info.getHobby());
			pstmt.setString(12, info.getBirthday());
			pstmt.setString(13, info.getMajor());
			// pstmt.setString(14, info.getSalary());
			pstmt.setInt(14, 0);
			pstmt.setString(15, info.getHiredate());
			pstmt.setString(16, info.getCareer_1());
			pstmt.setString(17, info.getCareer_2());
			pstmt.setString(18, info.getCareer_3());
			pstmt.setString(19, info.getLicense_1());
			pstmt.setString(20, info.getLicense_2());
			pstmt.setString(21, info.getLicense_3());
			pstmt.setString(22, info.getCompany_phone());
			pstmt.setString(23, info.getPhone_1());
			pstmt.setString(24, info.getPhone_2());
			pstmt.setString(25, info.getZipcode());
			pstmt.setString(26, info.getAddr());
			pstmt.setString(27, info.getAddr_detail());
			pstmt.setString(28, info.getEmail());
			pstmt.setString(29, info.getFax());
			pstmt.setString(30, info.getHp());
			pstmt.setInt(31, 0);
			pstmt.setString(32, "0");
			pstmt.setString(33, info.getType());
			pstmt.setString(34, "0");
			pstmt.setString(35, null);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	public PersonInfo showInfo(String seq) {
		PersonInfo result = null;
		try {
			con = ConnectionManager.getConnection();
			String sql = "SELECT * FROM PERSONAL_INFORMATION WHERE PI_SEQ=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, seq);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
			
				ArrayList<String> data = new ArrayList<String>(); 
				for(int i=0;i<=35;i++){
					data.add(i, rs.getString(i+1));//첫번째 컬럼값은 안쓴다.  
				}
				result = new PersonInfo(data.get(0), data.get(1), data.get(2), data.get(3), data.get(4), data.get(5),
						data.get(6), data.get(7), data.get(8), data.get(9), data.get(10), data.get(11), data.get(12),
						data.get(13), data.get(14), data.get(15), data.get(16), data.get(17), data.get(18),
						data.get(19), data.get(20), data.get(21), data.get(22), data.get(23), data.get(24), data.get(25), data.get(26), data.get(27), data.get(28), data.get(29), data.get(30), data.get(31), data.get(32), data.get(33), data.get(34), data.get(35));
				
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;

	}

}

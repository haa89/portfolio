package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import VO.VO;

public class DAO {
	VO vo = new VO();
	int totalCount;
	int answerCount;
	double answerRate;
	private String userId, userPw, userName, userEmail;
	private int userNo;
	int userScore;
	String type, word, kor;
	boolean result;
	
	
	
	private int wordNo;

	private Connection con;
	private Statement st;
	private PreparedStatement pst;
	private ResultSet rs;
	String msg;

	public DAO() {
		this.dbConnect();
	}

	public Connection dbConnect() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			con = DriverManager.getConnection(url, "xchhh", "xchhh");
			st = con.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	public void close(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void close(PreparedStatement pst) {
		if (pst != null) {
			try {
				pst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void close(Connection con) {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void select(String userID) throws Exception {
		con = dbConnect();
		msg = "select * from userinfo where userid = '" + userId + "'";
		rs = st.executeQuery(msg);
		while (rs.next()) {

			vo.getUserNo();
			vo.getUserEmail();
			vo.getUserEmail();
			vo.getUserScore();
			vo.getTotalCount();
			vo.getAnswerCount();
			vo.getAnswerRate();
		}
	}
	public ArrayList<VO> questionSelect(String type2){
        ArrayList<VO> list = new ArrayList<VO>();
        try {

        	con = dbConnect();
           String sql = "SELECT *FROM(SELECT * FROM voca where type like ? ORDER BY dbms_random.value)";
           
//           String sql = "SELECT *FROM(SELECT * FROM voca where type like ? ORDER BY dbms_random.value)WHERE rownum <= 10";
           pst = con.prepareStatement(sql);
           pst.setString(1, type2);

           rs = null;
           rs = pst.executeQuery();
           while (rs.next()) {
              wordNo = rs.getInt("wordno");
              type = rs.getString("type");
              word = rs.getString("word");
              kor = rs.getString("kor");
              vo = new VO(wordNo, type, word, kor);  
              list.add(vo);
           }
        }catch(Exception e) {
           e.printStackTrace();
        }finally {
           close(pst);
           close(con);
        }
        return list;
     
	}
	public boolean insertStd(int userNo, String w_Word,String w_Kor) 
	{
		dbConnect();

		// 3. SQL작성
		String sql = "insert into note(userno, w_Word,w_Kor) values(?, ?, ?)";// ? : 바인드 변수로 들어감

		// 4. 바인드 변수 채우기 / 여기 인덱스는 1부터 시작함
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, userNo);
			pst.setString(2, w_Word);
			pst.setString(3, w_Kor);
			
			
			int cnt = pst.executeUpdate();
			if (cnt > 0) {
				result = true;
			} else {
				result = false;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			// 아래부터 닫아준다.
			close(pst);
			close(con);
		}
		
		
		
		return result;
		
	}
	//rankview DAO
	public ArrayList<VO> rankSelect(){
        ArrayList<VO> list = new ArrayList<VO>();
        try {

        	con = dbConnect();
           String sql = "SELECT USERID,USERSCORE FROM USERINFO WHERE rownum <= 10 order by USERSCORE desc";
           
           pst = con.prepareStatement(sql);
           

           rs = null;
           rs = pst.executeQuery();
           while (rs.next()) {
        	   userId = rs.getString("USERID");
        	    userScore = rs.getInt("USERSCORE");
        	    
        	    vo = new VO(userId,userScore);  
              list.add(vo);
           }
        }catch(Exception e) {
           e.printStackTrace();
        }finally {
           close(pst);
           close(con);
        }
        return list;
     
	}

}
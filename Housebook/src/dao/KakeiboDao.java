package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.Kakeibo;


public class KakeiboDao {
	public static ArrayList<Kakeibo> disp_Kakeibo(){
		ArrayList<Kakeibo> resultList = new  ArrayList<Kakeibo>();
		Connection con =null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			//jdbcロード
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/housebook?useSSL=false",
					"user2",
					"pass2");
			String sql = "SELECT * from book";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while(rs.next()){
				int id = rs.getInt("id");
				int month = rs.getInt("month");
				int day = rs.getInt("day");
				int money = rs.getInt("money");
				String content = rs.getString("content");

				resultList.add(new Kakeibo(id,month,day,money,content));
			}
		} catch (SQLException e){
			System.out.println("DBアクセスに失敗しました。");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if( rs != null){
					rs.close();
				}
			} catch(SQLException e){
				System.out.println("DB切断時にエラーが発生しました。");
				e.printStackTrace();
			}
			try {
				if( pstmt != null){
					pstmt.close();
				}
			} catch(SQLException e){
				System.out.println("DB切断時にエラーが発生しました。");
				e.printStackTrace();
			}
			try {
				if( con != null){
					con.close();
				}
			} catch (SQLException e){
				System.out.println("DB切断時にエラーが発生しました。");
				e.printStackTrace();
			}
		}

		return resultList;

	}

	public static Kakeibo insertDao(int id,int month,int day,int money,String content){

		Kakeibo result =null;
		Connection con =null;
		PreparedStatement pstmt = null;

		try{
			//jdbcロード
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/housebook?useSSL=false",
					"user2",
					"pass2");
			// ④SQL文を作成する
			String sql = "INSERT INTO book VALUES(?,?,?,?,?);";
			// ⑤SQL文を実行するための準備を行う
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.setInt(2,month);
			pstmt.setInt(3, day);
			pstmt.setInt(4,money );
			pstmt.setString(5, content);
			// ⑥SQL文を実行してDBMSから結果を受信する
						pstmt.executeUpdate();
						System.out.println("正常");

					} catch (ClassNotFoundException e) {
						System.out.println("JDBCドライバが見つかりません。");
						e.printStackTrace();
					} catch (SQLException e) {
						System.out.println("DBアクセス時にエラーが発生しました。");
						e.printStackTrace();
					} finally {
						// ⑧DBMSから切断する

						try {
							if (pstmt != null) {
								pstmt.close();
							}
						} catch (SQLException e) {
							System.out.println("DBアクセス時にエラーが発生しました。");
							e.printStackTrace();
						}
						try {
							if (con != null) {
								con.close();
							}
						} catch (SQLException e) {
							System.out.println("DBアクセス時にエラーが発生しました。");
							e.printStackTrace();
						}
					}
					return result;
				}
}
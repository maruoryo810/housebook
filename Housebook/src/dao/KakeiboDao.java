package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dto.Kakeibo;


public class KakeiboDao {

	public static Kakeibo insertDao(int id,int month,int day,int money,int income,int spending,String content){
		Kakeibo result =null;
		Connection con =null;
		PreparedStatement pstmt = null;

		try{
			//jdbcロード
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/housebook?useSSL=false",
					"user1",
					"pass1");
			// ④SQL文を作成する
			String sql = "INSERT INTO book VALUES(?,?,?,?,?,?,?);";
			// ⑤SQL文を実行するための準備を行う
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.setInt(2,month);
			pstmt.setInt(3, day);
			pstmt.setInt(4,money );
			pstmt.setInt(5,income);
			pstmt.setInt(6, spending);
			pstmt.setString(7, content);
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
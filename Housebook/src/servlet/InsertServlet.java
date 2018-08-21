package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.KakeiboDao;
import dto.Kakeibo;

/**
 * Servlet implementation class show
 */
@WebServlet("/InsertServlet")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");


		try{
			int id = Integer.parseInt(request.getParameter("Bookid"));
			int month = Integer.parseInt(request.getParameter("Bookmonth"));
			int day = Integer.parseInt(request.getParameter("Bookday"));
			int money = Integer.parseInt(request.getParameter("Bookmoney"));
			String content = request.getParameter("Bookcontent");

			Kakeibo result = KakeiboDao.insertDao(id, month, day, money,content);
			request.setAttribute("Insert", result);
			String view = "/WEB-INF/view/Insert.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			dispatcher.forward(request, response);
			}catch(NumberFormatException e){
				System.out.println("エラーが起きました");
			}catch(Exception e ){
				System.out.println("エラーが発生しました");
			}finally{
				System.out.println("正常に動きました");
			}

		}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

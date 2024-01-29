package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.TaskRegisterDAO;

/**
 * Servlet implementation class TaskRegisterFromServlet
 */
@WebServlet("/TaskRegisterServlet")
public class TaskRegisterServlet extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//リクエストのエンコーディング方式を指定
		request.setCharacterEncoding("UTF-8");

		//DAOオブジェクトの取得
		TaskRegisterDAO dao = new TaskRegisterDAO();
		
		//転送先のURL用変数
		String url = "";

		
		//リクエストの転送
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}

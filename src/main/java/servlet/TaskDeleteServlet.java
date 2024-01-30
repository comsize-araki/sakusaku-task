package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.TaskDeleteDAO;

/**
 * Servlet implementation class TaskDeleteServlet
 */
@WebServlet("/TaskDeleteServlet")
public class TaskDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//文字コード設定
		request.setCharacterEncoding("UTF-8");
		//コメントテーブルから削除できたか確認するための変数
		int success = 0;
		//タスクテーブルから削除できたか確認するための変数
		int count = 0;
		int taskid = Integer.parseInt(request.getParameter("taskid"));
		TaskDeleteDAO taskDeleteDAO = new TaskDeleteDAO();
		
		//削除実行回数をカウントする
		try {
			//コメントテーブルから削除
			success = taskDeleteDAO.DeleteSuccess(taskid);
				count = taskDeleteDAO.TaskDelete(taskid);
			if(count > 0) {
				RequestDispatcher rd = request.getRequestDispatcher("task-delete-success.jsp");
		    rd.forward(request, response);
			}else {
				RequestDispatcher rd = request.getRequestDispatcher("task-delete-failure.jsp");
			    rd.forward(request, response);
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}

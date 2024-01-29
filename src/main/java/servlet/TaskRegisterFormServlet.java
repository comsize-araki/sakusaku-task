package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.TaskRegisterDAO;
import model.entity.CategoryBean;
import model.entity.StatusBean;

/**
 * Servlet implementation class TaskRegisterFromServlet
 */
@WebServlet("/TaskRegisterFormServlet")
public class TaskRegisterFormServlet extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//リクエストのエンコーディング方式を指定
		request.setCharacterEncoding("UTF-8");

		//DAOオブジェクトの取得
		TaskRegisterDAO dao = new TaskRegisterDAO();

		try {

			//ステータス、カテゴリーのリスト取得
			List<CategoryBean> catList = dao.category();
			List<StatusBean> statusList = dao.status();

			//リクエストスコープの挿入
			HttpSession session = request.getSession();
			session.setAttribute("category_list", catList);
			session.setAttribute("status_list", statusList);

		} catch (SQLException | ClassNotFoundException e) {

			e.printStackTrace();

		}
		
		//リクエストの転送
		RequestDispatcher rd = request.getRequestDispatcher("task-register-form.jsp");
		rd.forward(request, response);
	}

}

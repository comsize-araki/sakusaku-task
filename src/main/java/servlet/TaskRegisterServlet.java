package servlet;

import java.io.IOException;
import java.sql.Date;
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
import model.entity.TaskBean;

/**
 * Servlet implementation class TaskRegisterFromServlet
 */
@WebServlet("/TaskRegisterServlet")
public class TaskRegisterServlet extends HttpServlet {

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//リクエストのエンコーディング方式を指定
		request.setCharacterEncoding("UTF-8");

		//DAOオブジェクトの取得
		TaskRegisterDAO dao = new TaskRegisterDAO();

		//転送先のURL用変数
		String url = "";

		//Beanオブジェクトの生成
		TaskBean task = new TaskBean();

		//リクエストパラメータの取得
		task.setTaskName(request.getParameter("task_name"));
		task.setCategoryId(Integer.parseInt(request.getParameter("category_id")));
		String date = request.getParameter("limit_date");
		if (date == "") {

			task.setLimitDate(null);

		} else {
			
			task.setLimitDate(Date.valueOf(date).toLocalDate());

		}
		task.setUserName(request.getParameter("user_name"));
		task.setStatusCode(request.getParameter("status_code"));
		task.setMemo(request.getParameter("memo"));

		try {

			//ユーザ名の取得
			String userId = dao.getUserId(task.getUserName());

			if (userId == null) {

				url = "task-register-failure.jsp";

			} else {

				//ユーザIDをフィールドに代入
				task.setUserId(userId);

				//登録実行
				int num = dao.register(task);

				if (num == 0) {

					url = "task-register-failure.jsp";

				} else {

					//セッションの取得
					HttpSession session = request.getSession();

					//カテゴリー・ステータスのリストを取得
					List<CategoryBean> catList = (List<CategoryBean>) session.getAttribute("category_list");
					List<StatusBean> statusList = (List<StatusBean>) session.getAttribute("status_list");

					//カテゴリーIDからカテゴリー名を取得
					for (CategoryBean cat : catList) {

						if (cat.getCategoryId() == task.getCategoryId()) {

							task.setCategoryName(cat.getCategoryName());

						}

					}

					//ステータスコードからステータス名を取得
					for (StatusBean status : statusList) {

						if (status.getStatusCode().equals(task.getStatusCode())) {

							task.setStatusName(status.getStatusName());

						}

					}

					//Beanをリクエストスコープに設定
					request.setAttribute("task", task);

					//転送先の設定
					url = "task-register-success.jsp";

				}
			}

		} catch (SQLException | ClassNotFoundException e) {

			e.printStackTrace();

		}

		//リクエストの転送
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}

package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.TaskListDAO;
import model.entity.TaskBean;

/**
 * Servlet implementation class TaskEditServlet
 */
@WebServlet("/TaskEditServlet")
public class TaskEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TaskEditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストのエンコーディング方式を指定
		request.setCharacterEncoding("UTF-8");
		
		// 返すリスト作成
		List<TaskBean> list = new ArrayList<>();

// daoのインスタンス化
		TaskListDAO dao = new TaskListDAO();
		try {
			list = dao.ListView();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
		
// 値のセット
		String select = request.getParameter("select");
		String message = "";
		
		if (select.equals("edit")) {
			message = "編集するタスクを選択してください。";
		}else {
			message = "削除するタスクを選択してください。";
		}
		 
		
		
// リクエストスコープにbeanの情報を設定
				request.setAttribute("select", select);
				request.setAttribute("message", message);
				request.setAttribute("list", list);
				// 変更情報確認画面に遷移
				RequestDispatcher rd = request.getRequestDispatcher("task-view.jsp");
				rd.forward(request, response);
		
 
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}

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
import javax.servlet.http.HttpSession;

import model.dao.LoginDAO;
import model.entity.CategoryBean;
import model.entity.StatusBean;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// DAOの生成
		LoginDAO dao = new LoginDAO();
		
		// カテゴリーBeanのリスト
		List<CategoryBean> category = new ArrayList<>();
		// ステータスBeanのリスト
		List<StatusBean> status = new ArrayList<>();
		
		// セッションオブジェクトの生成
		HttpSession session = request.getSession();
		
		// ユーザーID、パスワードの取得
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		
		boolean isUserExists = false;
		String userName = ""; // ユーザー名
		try {
			// ログイン承認の確認
			isUserExists = dao.existsUser(userId, password);
			
			// ユーザー名の取得
			userName = dao.getUserName(userId, password);
			
			// カテゴリーリストの取得
			category = dao.category();
			// ステータスリストの取得
			status = dao.status();
		}catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		// 転送先
		String url = "";
		if (isUserExists) {
			// セッションスコープへの属性の設定
			session.setAttribute("userName", userName);
			session.setAttribute("category_list", category);
			session.setAttribute("status_list", status);
			// URLの設定
			url = "menu.jsp";
		}else {
			url = "login.jsp";
		}
		
		// リクエストの転送
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}

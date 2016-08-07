package model2.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model2.dao.Dao;
import model2.vo.Customer;
import model2.vo.PersonInfo;
import model2.vo.SearchCondition;
import model2.vo.TargetList;

/**
 * Servlet implementation class ActionServlet
 */
@WebServlet("/ActionServlet")
public class ActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		PrintWriter out = response.getWriter();
		String key = request.getParameter("action");
		System.out.println("들어온 액션 : " + key);

		// 로컬변수
		Dao db = new Dao();
		HttpSession Mysession = request.getSession();

		switch (key) {
		case "JOIN":
		/*
		 * initalization block to slove local variable duplicate problem > 스위치문
		 * 변수중복문제 해결위함
		 */
		{
			RequestDispatcher rdis = request.getRequestDispatcher("joinForm.html");
			rdis.forward(request, response);
		}
			break;
		case "JOIN_RESULT": {
			String id = (String) request.getParameter("id");
			String pw = (String) request.getParameter("pw");
			String name = (String) request.getParameter("name");
			String mail = (String) request.getParameter("mail");
			String type = (String) request.getParameter("type");
			String code = (String) request.getParameter("code");
			String addr = (String) request.getParameter("addr");

			Customer c = new Customer(id, pw, name, mail, type, code, addr);

			int result = db.insertCus(c);
			if (result == 1) {
				// 성공
				response.sendRedirect("./");// 가입 완료 후 인덱스로 보내기
			} else {
				// 실패
				out.println("<script>alert('제약조건 위반');history.go(-1)</script>");
			}
		}
			break;
		case "ID_CHECK": {
			String id = request.getParameter("id");
			// forward로 호출하니까 굳이 따로 안담아도 된다.
			// request.setAttribute("ID", id);//새창에 넣어주기 위해 저장
			System.out.println(id + "폼에서 체크페이지로 넘기려고 하는 아이디값");

			/* 바로 체크하려면 ***********************/
			if (id.isEmpty() == false) {
				int result = db.checkCus(id);

				if (result == 1) {
					System.out.println("ID중복");
					// FIXME 불리언이 스트링으로 넣어지는 것 같은데??
					// 체크페이지의 c:when 에서 ${RESULT} 바로 넣으면 인식x
					request.setAttribute("RESULT", false);

				} else {
					System.out.println("ID사용가능");
					request.setAttribute("RESULT", true);
				}
			}
			/* end ***********************************/

			RequestDispatcher rdis = request.getRequestDispatcher("checkPage.jsp");
			rdis.forward(request, response);

		}
			break;
		case "ID_CHECK_RESULT": {

			String id = request.getParameter("id");
			if (id.isEmpty() == false) {

				int result = db.checkCus(id);

				if (result == 1) {
					System.out.println("ID중복");
					request.setAttribute("RESULT", false);

				} else {
					System.out.println("ID사용가능");
					request.setAttribute("RESULT", true);
				}
			}
			RequestDispatcher rdis = request.getRequestDispatcher("checkPage.jsp");
			rdis.forward(request, response);

		}
			break;

		case "LOGIN": {
			// response.sendRedirect("loginForm.html");//가입 완료 후 인덱스로 보내기

			RequestDispatcher rdis = request.getRequestDispatcher("loginForm.html");
			rdis.forward(request, response);

		}
			break;
		case "LOGIN_RESULT": {

			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			Customer result = db.loginCus(id, pw);

			if (result == null) {
				out.println("<script>alert('아이디 또는 비밀번호가 틀렸습니다.');history.go(-1)</script>");
			} else {

				Mysession.setAttribute("ID", id);
				response.sendRedirect("./");
			}
		}
			break;
		case "ENROLL": {

			RequestDispatcher rdis = request.getRequestDispatcher("index.jsp");
			rdis.forward(request, response);
		}
			break;
		case "ENROLL_RESULT": {

			String[] arr = request.getParameterValues("param");

			String type = request.getParameter("param2");// 공개라디오버튼

			System.out.println("[배열] " + arr);

			ArrayList<String> sarr = new ArrayList<String>();
			Collections.addAll(sarr, arr);
			sarr.add(3, type);

			System.out.println("[콜렉션] " + sarr);

			// String[] arr2 = request.getParameterValues("param");
			// ArrayList<String> sarr2 = new ArrayList<String>();
			// Collections.addAll(sarr, arr);

			String temp = request.getParameter("temp");// 경력3

			PersonInfo info = new PersonInfo(null, sarr.get(0), sarr.get(1), sarr.get(2), sarr.get(5), sarr.get(13),
					sarr.get(14), sarr.get(11), sarr.get(4), sarr.get(15), sarr.get(16), sarr.get(6), sarr.get(8),
					sarr.get(12), sarr.get(17), sarr.get(18), sarr.get(28), sarr.get(29), temp, sarr.get(25),
					sarr.get(26), sarr.get(27), sarr.get(22), sarr.get(23), sarr.get(24), sarr.get(7), sarr.get(9),
					sarr.get(10), sarr.get(19), sarr.get(20), sarr.get(21), null, null, sarr.get(3), null, null);
			db.insertInfo(info);

			System.out.println("[객체] " + info);

			response.sendRedirect("./");
		}
			break;
		case "SEARCH": {
			RequestDispatcher rdis = request.getRequestDispatcher("index.jsp");
			rdis.forward(request, response);
		}
			break;
		case "SEARCH_RESULT": {
			if (Mysession.getAttribute("ID") != null) {

				String con_key = request.getParameter("con_key"); // 성
																	// PI_FRIST_NAME
																	// 이름 나이
																	// (num)
																	// 직업 전공
				String con_gender = request.getParameter("con_gender");// 성별PI_SEX
																		// 남자는 0
																		// ,여자는
																		// 1
				String con_type = request.getParameter("con_type");// PI_PUBLICFLAG
																	// 미공개 0 공개1
				String con_text = request.getParameter("text");

				SearchCondition condition = new SearchCondition(con_key, con_gender, con_type, con_text);

				ArrayList<TargetList> target_list = db.PersonalList(condition);

				request.setAttribute("LIST", target_list);
				RequestDispatcher rdis = request.getRequestDispatcher("index.jsp");
				rdis.forward(request, response);
			} else
				response.sendRedirect("./");
		}
			break;
		case "INFO": {
			if (Mysession.getAttribute("ID") != null) {
				// seq로 검색
				String seq = request.getParameter("seq");
				// 개인정보 하나 리턴
				PersonInfo info = db.showInfo(seq);
				
				if(!info.getType().equals("0")){
					//공개한 사람만 보여주기 
				System.out.println(info + "[INFO]");
				// 리턴값을 객체로 전달 (request에 담아서)
				request.setAttribute("INFO", info);

				RequestDispatcher rdis = request.getRequestDispatcher("personPage.jsp");
				rdis.forward(request, response);
				}else out.println("<script>alert('비공개 인물입니다.');history.go(-1);</script>");
			}else response.sendRedirect("./");
		}
		default:
			Mysession.invalidate();
			response.sendRedirect("./");
			break;
			
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

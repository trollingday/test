package spring.mvc.kyj.common;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import spring.mvc.kyj.dto.CartDTO;
import spring.mvc.kyj.dto.UserVO;

// 로그인 성공시 작동 
public class UserLoginSuccessHandler implements AuthenticationSuccessHandler {
   
   SqlSessionTemplate sqlSession;
   
   // security-context.xml에서 매개변수 생성자 sqlSession을 생성후 그 주소값을 매개변수로 전달
   public UserLoginSuccessHandler(SqlSessionTemplate sqlSession) {
      this.sqlSession = sqlSession;
   }
   
   @Override
   public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
         Authentication authentication) throws IOException, ServletException {
      System.out.println("<<< UserLoginSuccessHandler - onAuthenticationSuccess 진입 >>>");
      
      UserVO vo = (UserVO) authentication.getPrincipal();
      System.out.println("UserVO : " + vo.getUsername());
      
      String msg = authentication.getName() + "님 환영합니다.";
      
      String authority = sqlSession.selectOne("spring.mvc.kyj.dao.CustomerDAO.authorityCheck", authentication.getName());
      
      request.setAttribute("msg", msg);
      request.getSession().setAttribute("customerID", authentication.getName());  // 세션추가
      request.getSession().setAttribute("authority", authority);
      
      //--------------장바구니 생성 -------------------//
	  List<CartDTO> cartbox=new ArrayList<CartDTO>();
	  request.getSession().setAttribute("cartbox", cartbox);
      //--------------장바구니 생성 -------------------//
      
      int grade;
      if(authority.equals("ROLE_USER")) {
         grade = 1;
         RequestDispatcher dispatcher = request.getRequestDispatcher("/main.do");
         dispatcher.forward(request, response);
      } else {
         grade = 0;
         RequestDispatcher dispatcher = request.getRequestDispatcher("/adminMain.st");
         dispatcher.forward(request, response);
      }
      
   }

}
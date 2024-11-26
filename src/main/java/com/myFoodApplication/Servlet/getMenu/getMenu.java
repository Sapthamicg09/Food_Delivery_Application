package com.myFoodApplication.Servlet.getMenu;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.myFoodApplication.menu.Menu;
import com.myFoodApplication.menuDAO.MenuDAO;
import com.myFoodApplication.menuDAOImpl.MenuDAOImpl;

public class getMenu extends HttpServlet {

    private List<Menu> menuList;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        int id = Integer.parseInt(req.getParameter("restaurantId"));
        
        MenuDAO mdao = new MenuDAOImpl();
        menuList = mdao.getMenusByRestaurantId(id);
        HttpSession session = req.getSession();
        session.setAttribute("menuList", menuList);
        
        resp.sendRedirect("getMenu.jsp");
    }
}

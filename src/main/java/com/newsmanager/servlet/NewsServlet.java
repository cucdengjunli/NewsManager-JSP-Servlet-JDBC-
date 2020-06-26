package com.newsmanager.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newsmanager.dao.NewsDao;
import com.newsmanager.entity2.News2;

public class NewsServlet extends HttpServlet {

	private NewsDao newsDao;
	public void init() throws ServletException {
		newsDao = new NewsDao();	
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
				doPost(request,response);
			}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String oprate= request.getParameter("oprate");
		//如果该次请求是AaddNews，则是添加新闻请求
		if("addnews".equals(oprate)) {
			String newstitle = request.getParameter("newstitle");
			String newstype = request.getParameter("newstype");
			String newscontent = request.getParameter("newscontent");
			
			int row = newsDao.addNews(newstitle, newstype, newscontent);
			//重定向到主页
			response.sendRedirect("NewsServlet");
			
		}else if("delete".equals(oprate)) {
			Integer id = Integer.valueOf(request.getParameter("id"));
			int row=newsDao.deleteNewsById(id);
			response.sendRedirect("NewsServlet");	
			
		}else if("pishan".equals(oprate)) {
			String[] deleteId=request.getParameterValues("deleteId");
			for(String string:deleteId) {
				Integer did = Integer.valueOf(string);
				newsDao.deleteNewsById(did);
			}
			response.sendRedirect("NewsServlet");
			
		}else if("pishenhe".equals(oprate)) {
			String[] deleteId=request.getParameterValues("deleteId");
			for(String string:deleteId) {
				Integer did = Integer.valueOf(string);
				newsDao.AuditNews(did);
			}
			response.sendRedirect("NewsServlet");
			
		}else if("toupdate".equals(oprate)) {
			Integer id= Integer.valueOf(request.getParameter("id"));
			News2 news = newsDao.getNews(id);
			request.setAttribute("news", news);
			request.getRequestDispatcher("newsupdate.jsp").forward(request, response);	
		
		}else if("updatenews".equals(oprate)) {
			Integer id= Integer.valueOf(request.getParameter("id"));
			String newsTitle = request.getParameter("newstitle");
			String newsType = request.getParameter("newstype");
			String newsContent = request.getParameter("newscontent");
			int row=newsDao.updateNews(id, newsTitle, newsType, newsContent);
			response.sendRedirect("NewsServlet");
		}
		else {
			Integer pageNumber = 1;
			String pn = request.getParameter("pageNumber");
			if(pn!=null) {
				pageNumber = Integer.valueOf(pn);
			}
			if(pageNumber<=1){
				pageNumber = 1;
			}
			
			int count = newsDao.getCount();	
			Integer pageSize = 10;
			int pageCount = count%pageSize==0?count/pageSize:count/pageSize+1;
			if(pageNumber>pageCount) {
				pageNumber = pageCount;
			}
			
			List<News2> newsList = newsDao.getNewsList( pageNumber , pageSize );
			//调用查询新闻集合的方法，添加到request的作用域中，转发到jsp页面进行展示
			request.setAttribute("newsList", newsList);
			request.setAttribute("pageNumber", pageNumber);
			request.setAttribute("pageCount", pageCount);
			
			request.getRequestDispatcher("newsList.jsp").forward(request, response);	
		}

	}


}

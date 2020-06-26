package com.newsmanager.dao;

import java.sql.*;
import java.util.*;
import java.util.Date;
import com.newsmanager.entity2.*;

public class NewsDao {

	
	/**
	 * 方法描述： 修改新闻
	 * @param id 新闻主键id
	 * @param newstitle  新闻标题
	 * @return row 数据库受影响的行数
	 */
	
	public int updateNews(Integer ID,String newsTitle,String newsType,String newsContent) {
		Integer row = 0;
		Connection connection = null;
		PreparedStatement statement =null;
		ResultSet resultSet =null;		
		try {
			//1.加载驱动
			Class.forName("com.mysql.cj.jdbc.Driver");
			//2..驱动管理器获取数据库链接
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jt15005?characterEncoding=utf8&useSSL=false&serverTimezone=UTC","root","dengjunli");
			//3.获取statement， 执行sql
			//String sql = "insert into news(newstitle,newscontent,newsstatus,newstype,createtime) value(?,?,?,?,?)";
			String sql = "update news set newstitle=?,newsType=?,newsContent=? where newsid=?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, newsTitle);
			statement.setString(2, newsType);
			statement.setString(3, newsContent);
			statement.setObject(4, ID);
			row=statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(resultSet!=null) {
					resultSet.close();
				}
				if(statement!=null) {
					statement.close();
				}
				if(connection!=null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return row;
	}
	
		
	
	
	
	
	
	/**
	 * 方法描述： 根据新闻主键查询新闻对象
	 * @return 新闻对象
	 */	
	
	public News2 getNews(Integer id){
		News2 news = null;
		Connection connection = null;
		PreparedStatement statement =null;
		ResultSet resultSet =null;
		try {
			//1.加载驱动
			Class.forName("com.mysql.cj.jdbc.Driver");
			//2..驱动管理器获取数据库链接
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jt15005?characterEncoding=utf8&useSSL=false&serverTimezone=UTC","root","dengjunli");
			//3.获取statement， 执行sql
			String sql="select * from news where newsid=?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			//4.执行sql返回结果集并解析
			resultSet= statement.executeQuery();
			if(resultSet.next()) {
				int newsID = resultSet.getInt("newsid");
				String newsTitle = resultSet.getString("newstitle");
				String newsContent = resultSet.getString("newscontent");
				String newsStatus = resultSet.getString("newsStatus");
				String newsType = resultSet.getString("newsType");
				Date createTime = resultSet.getDate("createTime");
				news= new News2(newsID,newsTitle,newsContent,newsStatus,newsType,createTime);		
			}
		} catch(Exception e) {
			e.printStackTrace();		
		} finally {
			try {
				if(resultSet!=null) {
					resultSet.close();
				}
				if(statement!=null) {
					statement.close();
				}
				if(connection!=null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return news;
	}
	
	
	
	
	/**
	 * 方法描述： 审核新闻
	 * id 根据id审核新闻
	 * @return row 被审核的新闻是第几行
	 */
	
	public int AuditNews(Integer ID) {
		Integer row = null;
		Connection connection = null;
		PreparedStatement statement =null;
		ResultSet resultSet =null;		
		try {
			//1.加载驱动
			Class.forName("com.mysql.cj.jdbc.Driver");
			//2..驱动管理器获取数据库链接
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jt15005?characterEncoding=utf8&useSSL=false&serverTimezone=UTC","root","dengjunli");
			//3.获取statement， 执行sql
			//String sql = "insert into news(newstitle,newscontent,newsstatus,newstype,createtime) value(?,?,?,?,?)";
			String sql = "update news set newsStatus='已审核' where newsid=?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, ID);
			row=statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(resultSet!=null) {
					resultSet.close();
				}
				if(statement!=null) {
					statement.close();
				}
				if(connection!=null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return row;
	}
	
	
	
	
	/**
	 * 方法描述： 删除新闻
	 * id 根据id删除新闻
	 * @return row 被删除的新闻是第几行
	 */
	
	public int deleteNewsById(Integer ID) {
		Integer row = null;
		Connection connection = null;
		PreparedStatement statement =null;
		ResultSet resultSet =null;		
		try {
			//1.加载驱动
			Class.forName("com.mysql.cj.jdbc.Driver");
			//2..驱动管理器获取数据库链接
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jt15005?characterEncoding=utf8&useSSL=false&serverTimezone=UTC","root","dengjunli");
			//3.获取statement， 执行sql
			//String sql = "insert into news(newstitle,newscontent,newsstatus,newstype,createtime) value(?,?,?,?,?)";
			String sql = "delete from news where newsid =?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, ID);
			row=statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(resultSet!=null) {
					resultSet.close();
				}
				if(statement!=null) {
					statement.close();
				}
				if(connection!=null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return row;
	}
	
//	方法描述： 添加新闻的方法
//	newstitle 新闻标题
//	newstype 新闻栏目
//	content 新闻正文
//	return 数据库受影响的行数
		
	
	public int addNews(String newstitle,String newstype,String content) {
		int row = 0;
		Connection connection = null;
		PreparedStatement statement =null;
		ResultSet resultSet =null;
		//Date date = new Date(new java.util.Date().getTime());			
		//Date date = null;
		//date.getDate();
		try {
			//1.加载驱动
			Class.forName("com.mysql.cj.jdbc.Driver");
			//2..驱动管理器获取数据库链接
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jt15005?characterEncoding=utf8&useSSL=false&serverTimezone=UTC","root","dengjunli");
			//3.获取statement， 执行sql
			String sql = "insert into news(newstitle,newscontent,newsstatus,newstype,createtime) value(?,?,?,?,?)";
			statement = connection.prepareStatement(sql);
			statement.setString(1, newstitle);
			statement.setString(2, content);
			statement.setString(3, "未审核");
			statement.setString(4, newstype);
			statement.setDate(5,new java.sql.Date(2016, 3, 12));
			//statement.setDate(5,date);
			row=statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(resultSet!=null) {
					resultSet.close();
				}
				if(statement!=null) {
					statement.close();
				}
				if(connection!=null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return row;
	}
	
	
	/**
	 * 方法描述 查询所有新闻集合
	 * @return 新闻集合
	 */
	public List<News2> getNewsList(Integer pageNumber, Integer pageSize){
		List<News2> newsList = new ArrayList<News2>();
		Connection connection = null;
		Statement statement =null;
		ResultSet resultSet =null;
		try {
			//1.加载驱动
			Class.forName("com.mysql.cj.jdbc.Driver");
			//2..驱动管理器获取数据库链接
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jt15005?characterEncoding=utf8&useSSL=false&serverTimezone=UTC","root","dengjunli");
			//3.获取statement， 执行sql
			statement = connection.createStatement();
			//4.执行sql返回结果集并解析
			int startSize =(pageNumber-1)*pageSize;
					
			resultSet= statement.executeQuery("select * from news limit "+startSize+","+pageSize);
				
			while(resultSet.next()) {
				int newsID = resultSet.getInt("newsid");
				String newsTitle = resultSet.getString("newstitle");
				String newsContent = resultSet.getString("newscontent");
				String newsStatus = resultSet.getString("newsStatus");
				String newsType = resultSet.getString("newsType");
				Date createTime = resultSet.getDate("createTime");
				News2 news= new News2(newsID,newsTitle,newsContent,newsStatus,newsType,createTime);
				newsList.add(news);
				
			}
		} catch(Exception e) {
			e.printStackTrace();		
		} finally {
			try {
				if(resultSet!=null) {
					resultSet.close();
				}
				if(statement!=null) {
					statement.close();
				}
				if(connection!=null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return newsList;
	}

	//
	public int getCount() {
		int count=0;
		Connection connection = null;
		Statement statement =null;
		ResultSet resultSet =null;
		try {
			//1.加载驱动
			Class.forName("com.mysql.cj.jdbc.Driver");
			//2..驱动管理器获取数据库链接
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jt15005?characterEncoding=utf8&useSSL=false&serverTimezone=UTC","root","dengjunli");
			//3.获取statement， 执行sql
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select count(*) from news");
			if(resultSet.next()) {
				count = resultSet.getInt(1);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(resultSet!=null) {
					resultSet.close();
				}
				if(statement!=null) {
					statement.close();
				}
				if(connection!=null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return count;
	}
}

package main;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import model.Blog;
import model.Comm;
import model.CommSearcher;

public class BlogMain {
	
	public static void main(String[] args) {
		
		String sqMapConfig= "conf/sqlMapConfig.xml";
		Reader reader = null;
		SqlSession session = null;
		
		try {
			reader = Resources.getResourceAsReader(sqMapConfig);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			session = sqlSessionFactory.openSession();
			
			//selectBlog
//			List<Blog> blogs = session.selectList("blog.selectBlog");
//			for(Blog blog : blogs) {
//				System.out.println("blog id : " + blog.getBlogId());
//				System.out.println("blog author : " + blog.getAuthor());
//				List<Comm> comms = blog.getComms();
//				for(Comm comm:comms) {
//					System.out.println(comm);
//				}
//			}
			
			//블로그아이디로 검색
//			CommSearcher commSearcher 
//				= new CommSearcher(2, "블로그명", "블로그제목");
//			List<Comm> comms = session.selectList("blog.selectCommsByBlogId", commSearcher);
//			for(Comm comm : comms) {
//				System.out.println(comm);
//			}
			
			//게시물 수정
//			Comm comm = new Comm(1, "수정된게시물제목", "수정된게시물내용", 1);
//			int result = session.update("blog.updateComm", comm);
//			if (result > 0) {
//				System.out.println("수정성공!");
//			}
			
			//블로그아이디와 게시물아이디
			List<Integer> commIdList = new ArrayList<Integer>();
			commIdList.add(1); //blogId
			commIdList.add(1); //commId
			commIdList.add(2); //commId
			commIdList.add(3); //commId
			List<Comm> commList = session.selectList("blog.selectCommsByCommIds", commIdList);
			for (Comm comm : commList) {
				System.out.println(comm);
			}
			
			
			
			session.commit();
			
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			if(session!=null) {
				session.close();
			}
		}
		
	}

}

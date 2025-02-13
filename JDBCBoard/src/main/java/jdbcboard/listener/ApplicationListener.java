package jdbcboard.listener;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

public class ApplicationListener implements ServletContextListener{
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		String databaseProp = sce.getServletContext().getInitParameter("databaseProp");
		String sqlProp = sce.getServletContext().getInitParameter("sqlProp");
		String commandProp = sce.getServletContext().getInitParameter("commandProp");
		
		//System.out.println(databaseProp);//서버콘솔창에 띄워서 context초기화가 잘 실행되었는지 체크용
		//System.out.println(sce.getServletContext().getRealPath(databaseProp)); //실제경로
		
		Properties databaseProperties = new Properties();
		Properties sqlProperties = new Properties();
		Properties commandProperties = new Properties();
		
		try {
			databaseProperties.load(new FileReader(sce.getServletContext().getRealPath(databaseProp)));
			sqlProperties.load(new FileReader(sce.getServletContext().getRealPath(sqlProp)));
			commandProperties.load(new FileReader(sce.getServletContext().getRealPath(commandProp)));
			
			//점심먹고실습.. 
			//3개의 Properties를 appProperties이라는 Properties로 합쳐서
			//서블릿컨텍스트에 appProp속성변수에 저장하기
			Properties appProperties = new Properties();
			appProperties.putAll(databaseProperties); //properties는 <String, String>인 맵의 하위임
			appProperties.putAll(sqlProperties);
			appProperties.putAll(commandProperties);
			sce.getServletContext().setAttribute("appProp", appProperties);
			
//			sce.getServletContext().setAttribute("databaseProperties", databaseProperties); //application내내 사용할거라 jsp영역 중 application에 담기
//			sce.getServletContext().setAttribute("sqlProperties", sqlProperties);
//			sce.getServletContext().setAttribute("commandProperties", commandProperties);
		} catch(IOException ioe) {
			ioe.printStackTrace();
		}
	
	}//contextIni~
	
	
}

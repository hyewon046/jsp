package user;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class UserTest {
	
	public static void main(String[] args) {
		
		//MyBatis 설정파일의 패키지 경로
		String resource = "conf/configuration.xml";
		Reader reader = null;
		SqlSession session = null;
		
		try {
			//설정 XML파일의 문자들을 읽어들일 문자입력스트림
			reader = Resources.getResourceAsReader(resource);
			
			//SqlSessionFactoryBuilder를 통해 SqlSessionFactory 생성
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			
			//SqlSessionFactory를 통해 SqlSession 생성
			session = sqlSessionFactory.openSession();
			
			//insert
//			User user = new User(0, "비밀번호", "홍길동", "hongz@hong.com" );
//			int result = session.insert("User.insertUser", user);
//			if (result >0) {
//				System.out.println("등록성공!");
//			}
			
			//select
//			List<User> userList = session.selectList("User.selectUser");
//			for (User eachuser : userList) {
//				System.out.println(eachuser);
//			}
//			
			//get
//			User oneUser = session.selectOne("User.getUser", 3);
//			System.out.println(oneUser);
			
			//update
			User updateUser = new User(2, null, "홍홍홍", "hongs@hong.com");
			session.update("User.updateUser", updateUser);
			User updatedUser = session.selectOne("User.getUser", 2);
			System.out.println(updatedUser);
			
			//delete
			session.delete("User.deleteUser", 3);
			
			session.commit(); //커밋
			
		}catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			if (session!=null) session.close();
		}
		
	}

}

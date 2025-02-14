package jdbcboard.test;

import java.util.List;

import jdbcboard.model.Article;
import jdbcboard.service.ArticleService;
import jdbcboard.service.impl.ArticleServiceImpl;

public class ArticleServiceTest {
	
	public static void main(String[] args) {
		
		ArticleService articleService = new ArticleServiceImpl();
		
		//insert
//		Article article = new Article(0, "제목3", "내용3", 0, null, "N", 0, 0, 1, "hong");
//		int result = articleService.insertArticle(article);
//		if (result >0) {
//			System.out.println("등록 성공!");
//		}
		
		//update
//		Article article = new Article(3, "수정제목3", "수정내용3", 0, null, "N", 0, 0, 1, "hong");
//		int result = articleService.updateArticle(article);
//		if (result >0) {
//			System.out.println("수정 성공!");
//		}
		
		//delete
//		int result = articleService.deleteArticle(3);
//		if (result >0) {
//			System.out.println("삭제 성공!");
//		}
		
		//select
//		List<Article> list = articleService.selectArticle();
//		for (Article article: list) {
//			System.out.println(article);
//		}
		
		//get
		Article article = articleService.getArticle(2);
		System.out.println(article);
		
	}

}

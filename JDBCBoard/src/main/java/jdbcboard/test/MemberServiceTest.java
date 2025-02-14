package jdbcboard.test;

import java.util.List;

import jdbcboard.model.Member;
import jdbcboard.service.MemberService;
import jdbcboard.service.impl.MemberServiceImpl;

public class MemberServiceTest {
	
	public static void main(String[] args) {
		Member member = null;
		int result = 0;
		//insert test
		MemberService memberService = new MemberServiceImpl();
//		Member member = new Member("hong3", "홍길동", "홍장군", "1234", "hongZ@hong.com", "010-1234-5678", "N");
//		int result = memberService.insertMember(member);
//		if (result >0) {
//			System.out.println("입력성공!");
//		}
		
		//select test
//		System.out.println(memberService.selectMember());
		
		
		//get test
		System.out.println(memberService.getMember("hong"));
//		
//		//update test
//		member = new Member("hong3", "홍동길", "홍군장", "1234", "hongS@hong.com", "010-1234-5678", "N");
//		result = memberService.updateMember(member);
//		if (result >0) {
//			System.out.println("업뎃성공!");
//		}
//		
//		//delete test
//		result = memberService.deleteMember("hong3");
//		if (result >0) {
//			System.out.println("삭제성공!");
//		}
//		
		
	}

}

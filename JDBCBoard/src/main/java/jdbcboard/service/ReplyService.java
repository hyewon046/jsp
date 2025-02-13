package jdbcboard.service;

import java.util.List;

import jdbcboard.model.Reply;

public interface ReplyService {
	
	default List<Reply> selectReply() { return null; }
	
	default Reply getReply(int rid) { return null; }
	
	default int insertReply(Reply Reply) {return 0;}
	
	default int updateReply(Reply Reply) {return 0;}
	
	default int deleteReply(int rid) {return 0;}

}

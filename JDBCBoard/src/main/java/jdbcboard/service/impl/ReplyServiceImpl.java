package jdbcboard.service.impl;

import java.util.List;

import jdbcboard.dao.impl.ReplyDAOImpl;
import jdbcboard.model.Reply;
import jdbcboard.service.ReplyService;

public class ReplyServiceImpl implements ReplyService {
	
	private static ReplyServiceImpl replyServiceImpl = new ReplyServiceImpl();
	private ReplyDAOImpl replyDAOImpl;
	
	private ReplyServiceImpl() {
		replyDAOImpl = ReplyDAOImpl.getReplyDAOImpl();
	}
	
	public static ReplyServiceImpl getReplyServiceImpl() {
		return replyServiceImpl;
	}
	
	@Override
	public List<Reply> selectReply() {
		return replyDAOImpl.selectReply();
	}
	
	@Override
	public Reply getReply(int rid) {
		return replyDAOImpl.getReply(rid);
	}
	
	@Override
	public int insertReply(Reply Reply) {
		return replyDAOImpl.insertReply(Reply);
	}
	
	@Override
	public int updateReply(Reply Reply) {
		return replyDAOImpl.updateReply(Reply);
	}
	
	@Override
	public int deleteReply(int rid) {
		return replyDAOImpl.deleteReply(rid);
	}

}

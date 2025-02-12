package jspmvc.service.impl;

import jspmvc.dao.impl.MVCDeleteDAO;
import jspmvc.service.MVCAbstractService;

public class MVCDeleteService extends MVCAbstractService{

	@Override
	public int delete(int sid) {
		return new MVCDeleteDAO().delete(sid);
	}


}

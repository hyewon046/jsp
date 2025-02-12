package jspmvc.dao;

import java.util.List;

import jspmvc.model.MVCDTO;

public abstract class MVCAbstractDAO implements MVCDAO {

	@Override
	public int insert(MVCDTO dto) {
		return 0;
	}

	@Override
	public List<MVCDTO> select() {
		return null;
	}
	
	@Override
	public MVCDTO get(int sid) {
		return null;
	}
	
	@Override
	public int delete(int sid) {
		return 0;
	}
	
	@Override
	public int update(MVCDTO dto) {
		return 0;
	}

}

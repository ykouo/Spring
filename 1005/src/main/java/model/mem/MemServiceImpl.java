package model.mem;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("memService")
public class MemServiceImpl implements MemService{
	@Autowired
	private MemDAO memDAO;
	
	@Override
	public void insertMem(MemVO vo) {
		memDAO.insertMem(vo);
	}

	@Override
	public void updateMem(MemVO vo) {
		memDAO.updateMem(vo);
	}

	@Override
	public void deleteMem(MemVO vo) {
		memDAO.deleteMem(vo);
	}

	@Override
	public List<MemVO> getMemList(MemVO vo) {
		return memDAO.getMemList(vo);
	}

	@Override
	public MemVO getMem(MemVO vo) {
		return memDAO.getMem(vo);
	}

}

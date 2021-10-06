package model.mem;

import java.util.List;

public interface MemService {
	void insertMem(MemVO vo);
	void updateMem(MemVO vo);
	void deleteMem(MemVO vo);
	List<MemVO> getMemList(MemVO vo);
	MemVO getMem(MemVO vo);
}

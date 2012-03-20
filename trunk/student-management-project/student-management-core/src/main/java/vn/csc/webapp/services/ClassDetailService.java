package vn.csc.webapp.services;

import java.util.List;

import vn.csc.finalproject.dto.ClazzDetailDTO;
import vn.csc.finalproject.dto.StudentDTO;
import vn.csc.finalproject.ejb.entity.ClazzDetail;

public interface ClassDetailService {
	public ClazzDetailDTO persistClazzDetail(ClazzDetail clazzDetail);

	public ClazzDetailDTO mergeClazzDetail(ClazzDetail clazzDetail);

	public void removeClazzDetail(int clazzDetailId);

	public List<StudentDTO> GetStudentByClass(int clazzID);
	
	public ClazzDetailDTO addClazzDetail(int classID, int studentID);
}

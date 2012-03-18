package vn.csc.webapp.services;

import java.util.List;

import vn.csc.finalproject.ejb.entity.ClazzDetail;
import vn.csc.finalproject.ejb.entity.Student;

public interface ClassDetailService {
	public ClazzDetail persistClazzDetail(ClazzDetail clazzDetail);

	public ClazzDetail mergeClazzDetail(ClazzDetail clazzDetail);

	public void removeClazzDetail(ClazzDetail clazzDetail);

	public List<Student> GetStudentByClass(int ClazzID);
}

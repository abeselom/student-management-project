package vn.csc.webapp.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import vn.csc.finalproject.dto.ClazzDetailDTO;
import vn.csc.finalproject.dto.StudentDTO;
import vn.csc.finalproject.ejb.entity.ClazzDetail;
import vn.csc.finalproject.ejb.entity.Student;
import vn.csc.finalproject.ejb.entity.clazzdetail.ClazzDetailBeanRemote;
import vn.csc.utils.ContextUtil;
import vn.csc.utils.DTOUtils;
import vn.csc.webapp.services.ClassDetailService;

public class ClassDetailServiceImpl implements ClassDetailService {
	private ClazzDetailBeanRemote classDetailBeanRemote;
	protected DTOUtils convertService = new DTOUtils();

	public ClassDetailServiceImpl() {
		try {
			ContextUtil contextUtil = new ContextUtil();
			this.classDetailBeanRemote = (ClazzDetailBeanRemote) contextUtil
					.getInitialContext()
					.lookup("clazzDetail#vn.csc.finalproject.ejb.entity.clazzdetail.ClazzDetailBeanRemote");
		} catch (NamingException e) {
			this.classDetailBeanRemote = null;
			System.err.println(e.getMessage().toString());
		}
	}

	@Override
	public ClazzDetailDTO persistClazzDetail(ClazzDetail clazzDetail) {
		classDetailBeanRemote.persistClazzDetail(clazzDetail);
		return convertService.convertClazzDetailToClazzDetailDTO(clazzDetail);
	}

	@Override
	public ClazzDetailDTO mergeClazzDetail(ClazzDetail clazzDetail) {
		return convertService.convertClazzDetailToClazzDetailDTO(classDetailBeanRemote.mergeClazzDetail(clazzDetail));
	}

	@Override
	public void removeClazzDetail(ClazzDetail clazzDetail) {
		classDetailBeanRemote.removeClazzDetail(clazzDetail);
	}

	@Override
	public List<StudentDTO> GetStudentByClass(int clazzID) {
		List<Student> studentList = new ArrayList<Student>();
		studentList = classDetailBeanRemote.GetStudentByClass(clazzID);
		List<StudentDTO> studentDTOList = new ArrayList<StudentDTO>();
		for (Student student : studentList) {
			studentDTOList.add(convertService.convertStudentToStudentDTO(student));
		}
		return studentDTOList;
	}

	@Override
	public ClazzDetailDTO addClazzDetail(int classID, int studentID) {
		ClazzDetail classDetail = classDetailBeanRemote.addClazzDetail(classID, studentID);
		ClazzDetailDTO classDetailDTO = convertService.convertClazzDetailToClazzDetailDTO(classDetail);
		return classDetailDTO;
	}
}

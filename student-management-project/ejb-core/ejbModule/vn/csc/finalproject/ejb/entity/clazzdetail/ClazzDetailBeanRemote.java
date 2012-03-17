package vn.csc.finalproject.ejb.entity.clazzdetail;

import java.util.List;

import javax.ejb.Remote;
import vn.csc.finalproject.ejb.entity.ClazzDetail;
import vn.csc.finalproject.ejb.entity.Student;

@Remote
public interface ClazzDetailBeanRemote {

	Object queryByRange(String jpqlStmt, int firstResult, int maxResults);

	public ClazzDetail persistClazzDetail(ClazzDetail clazzDetail);

	public ClazzDetail mergeClazzDetail(ClazzDetail clazzDetail);

	public void removeClazzDetail(ClazzDetail clazzDetail);

	public List<Student> GetStudentByClass(int ClazzID);
}

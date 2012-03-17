package vn.csc.finalproject.ejb.entity.clazzdetail;

import javax.ejb.Local;
import vn.csc.finalproject.ejb.entity.ClazzDetail;

@Local
public interface ClazzDetailBeanLocal {

	Object queryByRange(String jpqlStmt, int firstResult, int maxResults);

	public ClazzDetail persistClazzDetail(ClazzDetail clazzDetail);

	public ClazzDetail mergeClazzDetail(ClazzDetail clazzDetail);

	public void removeClazzDetail(ClazzDetail clazzDetail);
}

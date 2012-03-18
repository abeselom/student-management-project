package vn.csc.finalproject.ejb.entity.clazz;

import javax.ejb.Remote;
import vn.csc.finalproject.ejb.entity.Clazz;

@Remote
public interface ClassBeanRemote {

	Object queryByRange(String jpqlStmt, int firstResult, int maxResults);

	public Clazz persistClazz(Clazz clazz);

	public Clazz mergeClazz(Clazz clazz);

	public void removeClazz(Clazz clazz);
}

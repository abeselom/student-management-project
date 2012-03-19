package vn.csc.finalproject.ejb.entity.clazz;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import vn.csc.finalproject.ejb.entity.Clazz;

@Remote
public interface ClassBeanRemote {

	Object queryByRange(String jpqlStmt, int firstResult, int maxResults);

	public Clazz persistClazz(Clazz clazz);

	public void updateClazz(int clazzId, Date dateTime, String subject);

	public void removeClazz(int clazzId);
	
	public List<Clazz> getClazzList();
	
	public Clazz getClazzById(int clazzId);
}

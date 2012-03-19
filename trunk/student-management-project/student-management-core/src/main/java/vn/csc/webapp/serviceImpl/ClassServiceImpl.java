package vn.csc.webapp.serviceImpl;

import java.util.Date;

import javax.naming.NamingException;

import vn.csc.finalproject.dto.ClazzDTO;
import vn.csc.finalproject.ejb.entity.Clazz;
import vn.csc.finalproject.ejb.entity.clazz.ClassBeanRemote;
import vn.csc.utils.ContextUtil;
import vn.csc.utils.DTOUtils;
import vn.csc.webapp.services.ClassService;

public class ClassServiceImpl implements ClassService {
	private ClassBeanRemote classBeanRemote;
	protected DTOUtils convertService = new DTOUtils();

	public ClassServiceImpl() {
		try {
			ContextUtil contextUtil = new ContextUtil();
			this.classBeanRemote = (ClassBeanRemote) contextUtil
					.getInitialContext()
					.lookup("clazz#vn.csc.finalproject.ejb.entity.clazz.ClassBeanRemote");
		} catch (NamingException e) {
			this.classBeanRemote = null;
			System.err.println(e.getMessage().toString());
		}
	}

	@Override
	public ClazzDTO persistClazz(Date dayTime, String subject) {
		Clazz clazz = new Clazz();
		clazz.setDaytime(dayTime);
		clazz.setSubject(subject);
		classBeanRemote.persistClazz(clazz);
		return convertService.convertClazzToClazzDTO(clazz);
	}

	@Override
	public void updateClazz(int clazzId, Date dateTime, String subject) {
		classBeanRemote.updateClazz(clazzId, dateTime, subject);
	}

	@Override
	public void removeClazz(int clazzId) {
		classBeanRemote.removeClazz(clazzId);
	}

}

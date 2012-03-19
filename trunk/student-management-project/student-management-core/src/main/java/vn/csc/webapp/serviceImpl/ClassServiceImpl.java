package vn.csc.webapp.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

	@Override
	public List<ClazzDTO> getClazzList() {
		List<Clazz> classList = new ArrayList<Clazz>();
		classList = classBeanRemote.getClazzList();
		List<ClazzDTO> classDTOList = new ArrayList<ClazzDTO>();
		for (Clazz clazz : classList) {
			ClazzDTO clazzDTO = new ClazzDTO();
			clazzDTO = convertService.convertClazzToClazzDTO(clazz);
			classDTOList.add(clazzDTO);
		}
		return classDTOList;
	}
	
	public static void main(String[] args) {
		ClassServiceImpl ssi = new ClassServiceImpl();
		System.out.println(ssi.getClazzList().get(0).getSubject());
	}

	@Override
	public ClazzDTO getClazzById(int clazzId) {
		return convertService.convertClazzToClazzDTO(classBeanRemote.getClazzById(clazzId));
	}

}

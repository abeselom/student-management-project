package vn.csc.webapp.services;

import java.util.Date;

import vn.csc.finalproject.dto.ClazzDTO;

public interface ClassService {

	public ClazzDTO persistClazz(Date dayTime, String subject);

	public void updateClazz(int clazzId, Date dayTime, String subject);

	public void removeClazz(int clazzId);
}

package vn.csc.finalproject.dto;

public class ClazzDetailDTO {
	private int clazz_DETAIL_ID;
	private int clazzDTOId;
	private int studentDTOId;
	
	public ClazzDetailDTO() {
	}

	public ClazzDetailDTO(int clazz_DETAIL_ID, int clazzDTOId, int studentDTOId) {
		super();
		this.clazz_DETAIL_ID = clazz_DETAIL_ID;
		this.clazzDTOId = clazzDTOId;
		this.studentDTOId = studentDTOId;
	}

	public int getClazz_DETAIL_ID() {
		return clazz_DETAIL_ID;
	}

	public void setClazz_DETAIL_ID(int clazz_DETAIL_ID) {
		this.clazz_DETAIL_ID = clazz_DETAIL_ID;
	}

	public int getClazzDTOId() {
		return clazzDTOId;
	}

	public void setClazzDTOId(int clazzDTOId) {
		this.clazzDTOId = clazzDTOId;
	}

	public int getStudentDTOId() {
		return studentDTOId;
	}

	public void setStudentDTOId(int studentDTOId) {
		this.studentDTOId = studentDTOId;
	}
}

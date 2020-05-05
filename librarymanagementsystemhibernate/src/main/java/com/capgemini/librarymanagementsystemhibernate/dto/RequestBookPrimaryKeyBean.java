package com.capgemini.librarymanagementsystemhibernate.dto;

import java.io.Serializable;

import javax.persistence.Embeddable;

@SuppressWarnings("serial")
@Embeddable
public class RequestBookPrimaryKeyBean implements Serializable {

	private int bId;
	private int uId;

	public int getbId() {
		return bId;
	}

	public void setbId(int bId) {
		this.bId = bId;
	}

	public int getuId() {
		return uId;
	}

	public void setuId(int uId) {
		this.uId = uId;
	}

	@Override
	public String toString() {
		return "RequestBookPK [bid=" + bId + ", uId=" + uId + "]";
	}

}

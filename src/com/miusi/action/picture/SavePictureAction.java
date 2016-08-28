package com.miusi.action.picture;

import com.miusi.entity.Picture;
import com.miusi.service.PictureService;
import com.opensymphony.xwork2.ActionSupport;

public class SavePictureAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private Picture picture;
	private PictureService pictureService; 

	public Picture getPicture() {
		return picture;
	}

	public void setPicture(Picture picture) {
		this.picture = picture;
	}

	public PictureService getPictureService() {
		return pictureService;
	}

	public void setPictureService(PictureService pictureService) {
		this.pictureService = pictureService;
	} 
 
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub  
		this.pictureService.savePicture(this.picture);  
		return SUCCESS;
	}

}

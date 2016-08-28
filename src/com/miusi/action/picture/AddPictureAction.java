package com.miusi.action.picture;

import java.util.Map;

import com.miusi.service.PictureService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AddPictureAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private PictureService pictureService;

	public PictureService getPictureService() {
		return pictureService;
	}

	public void setPictureService(PictureService pictureService) {
		this.pictureService = pictureService;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("list", this.pictureService.findAllPicture());
		return SUCCESS;
	}
}

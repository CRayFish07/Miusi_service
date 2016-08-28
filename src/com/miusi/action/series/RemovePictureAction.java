package com.miusi.action.series;

import java.util.Map;

import com.miusi.entity.Picture;
import com.miusi.service.PictureService;
import com.miusi.service.SeriesService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class RemovePictureAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private Picture picture;

	public Picture getPicture() {
		return picture;
	}

	public void setPicture(Picture picture) {
		this.picture = picture;
	}

	private SeriesService seriesService;
	private PictureService pictureService;

	public PictureService getPictureService() {
		return pictureService;
	}

	public void setPictureService(PictureService pictureService) {
		this.pictureService = pictureService;
	}

	public SeriesService getSeriesService() {
		return seriesService;
	}

	public void setSeriesService(SeriesService seriesService) {
		this.seriesService = seriesService;
	}

	@Override
	public String execute() throws Exception {
		this.pictureService.removePicture(picture);
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("list",
				this.pictureService.findBySeriesId(picture.getSeries_id()));
		return SUCCESS;
	}
}
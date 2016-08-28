package com.miusi.action.series;

import java.util.Map;

import com.miusi.entity.Series;
import com.miusi.service.PictureService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class ShowSeriesAction extends ActionSupport {
	private Series series;

	public Series getSeries() {
		return series;
	}

	public void setSeries(Series series) {
		this.series = series;
	}

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
		request.put("list", this.pictureService.findBySeriesId(series.getId()));
		return SUCCESS;
	}
}

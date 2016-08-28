package com.miusi.action.series;

import java.util.Map;

import com.miusi.entity.Series;
import com.miusi.service.PictureService;
import com.miusi.service.SeriesService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class RemoveSeriesAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private Series series;
	private SeriesService seriesService;
	private PictureService pictureService;

	public PictureService getPictureService() {
		return pictureService;
	}

	public void setPictureService(PictureService pictureService) {
		this.pictureService = pictureService;
	}

	public Series getSeries() {
		return series;
	}

	public void setSeries(Series series) {
		this.series = series;
	}

	public SeriesService getSeriesService() {
		return seriesService;
	}

	public void setSeriesService(SeriesService seriesService) {
		this.seriesService = seriesService;
	}

	@Override
	public String execute() throws Exception {
		this.pictureService.removeSeriesPicture(series.getId());
		this.seriesService.removeSeries(series);
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("list", this.seriesService.findAllSeries());
		return SUCCESS;
	}
}
package com.miusi.action.series;

import java.util.Map;

import com.miusi.entity.Series;
import com.miusi.service.SeriesService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class SaveSeriesAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private Series series;
	private SeriesService seriesService;
 
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
		// TODO Auto-generated method stub
		this.seriesService.saveSeries(this.series);
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("list", this.seriesService.findAllSeries());
		return SUCCESS;
	}
}

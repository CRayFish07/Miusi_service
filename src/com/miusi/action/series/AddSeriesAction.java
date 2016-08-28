package com.miusi.action.series;

import java.util.Map;

import com.miusi.service.SeriesService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AddSeriesAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private SeriesService seriesSerivice;

	public SeriesService getSeriesService() {
		return seriesSerivice;
	}

	public void setSeriesService(SeriesService seriesSerivice) {
		this.seriesSerivice = seriesSerivice;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("list", this.seriesSerivice);
		return SUCCESS;
	}
}

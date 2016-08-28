package com.miusi.action.series;

import java.util.Map;

import com.miusi.service.SeriesService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class QuerySeriesAction extends ActionSupport {
	private SeriesService seriesService;

	public SeriesService getSeriesService() {
		return seriesService;
	}

	public void setSeriesService(SeriesService seriesService) {
		this.seriesService = seriesService;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub 
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("list", this.seriesService.findLast20Series());
		return SUCCESS;
	}
}

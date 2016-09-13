package com.miusi.action.series;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.miusi.entity.Picture;
import com.miusi.entity.QueryInfo;
import com.miusi.entity.Series;
import com.miusi.service.PictureService;
import com.miusi.service.SeriesService;
import com.miusi.util.JSONUtils;
import com.miusi.util.JsonUtil;
import com.opensymphony.xwork2.ActionSupport;

public class AppQueryAction extends ActionSupport {
	private PictureService pictureService;
	private SeriesService seriesService;

	public SeriesService getSeriesService() {
		return seriesService;
	}

	public void setSeriesService(SeriesService seriesService) {
		this.seriesService = seriesService;
	}

	public PictureService getPictureService() {
		return pictureService;
	}

	public void setPictureService(PictureService pictureService) {
		this.pictureService = pictureService;
	}

	@Override
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		BufferedReader bufferedReader = new BufferedReader(request.getReader());
		StringBuffer sbf = new StringBuffer();
		while ((bufferedReader.read()) != -1) {
			sbf.append(bufferedReader.readLine());
		}
		String s = "{" + sbf.toString();
		System.out.println(s);
		QueryInfo info = new QueryInfo();
		if (!s.equals("{")) {
			info = JsonUtil.fromJson(s, QueryInfo.class);
		}
		switch (info.bizType) {
		case 1:
			action1_QueryRecommend();
			break;
		case 2:
			action2_QuerySeries(info);
			break;
		case 3:
			action3_QuerySeriesPicture(info);
			break;
		}

		return null;
	}

	private void action1_QueryRecommend() {
		Map<String, Object> map = new HashMap<String, Object>();
		String status = null;
		try {
			List<Picture> list = this.pictureService.findRecommend();
			System.out.println(list.size());
			if (list.size() > 0) {
				status = "1";
				map.put("data", list);
			} else {
				status = "0";
			}
			map.put("status", status);
			JSONUtils.toJson(ServletActionContext.getResponse(), map);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void action2_QuerySeries(QueryInfo info) {
		Map<String, Object> map = new HashMap<String, Object>();
		String status = null;
		try {
			List<Series> list = this.seriesService.appQuerySeries(info.id,
					info.pageSize);
			System.out.println(list.size());
			if (list.size() > 0) {
				status = "1";
				map.put("data", list);
			} else {
				status = "0";
			}
			map.put("status", status);
			JSONUtils.toJson(ServletActionContext.getResponse(), map);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void action3_QuerySeriesPicture(QueryInfo info) {
		Map<String, Object> map = new HashMap<String, Object>();
		String status = null;
		try {
			List<Picture> list = this.pictureService.appQueryPicture(1000,
					info.id, 1000);
			System.out.println(list.size());
			if (list.size() > 0) {
				status = "1";
				map.put("data", list);
			} else {
				status = "0";
			}
			map.put("status", status);
			JSONUtils.toJson(ServletActionContext.getResponse(), map);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

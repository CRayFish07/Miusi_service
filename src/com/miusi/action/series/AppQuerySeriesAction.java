package com.miusi.action.series;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.miusi.entity.QueryInfo;
import com.miusi.entity.Series;
import com.miusi.service.SeriesService;
import com.miusi.util.JSONUtils;
import com.miusi.util.JsonUtil;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class AppQuerySeriesAction extends ActionSupport {
	private SeriesService seriesService;

	public SeriesService getSeriesService() {
		return seriesService;
	}

	public void setSeriesService(SeriesService seriesService) {
		this.seriesService = seriesService;
	}

	@Override
	public String execute() throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		String status = null;
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			BufferedReader bufferedReader = new BufferedReader(
					request.getReader());
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
			List<Series> list = this.seriesService.appQuerySeries(20,
					1);
			System.out.println(list.size());
			if (list.size() > 0) {
				status = "1";
				map.put("series", list);
			} else {
				status = "null";
			}
			map.put("status", status);
			JSONUtils.toJson(ServletActionContext.getResponse(), map);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}

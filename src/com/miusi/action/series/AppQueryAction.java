package com.miusi.action.series;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.miusi.entity.Market;
import com.miusi.entity.Picture;
import com.miusi.entity.QueryInfo;
import com.miusi.entity.Series;
import com.miusi.entity.User;
import com.miusi.service.MarketService;
import com.miusi.service.PictureService;
import com.miusi.service.SeriesService;
import com.miusi.service.UserService;
import com.miusi.util.GeneralUtil;
import com.miusi.util.JSONUtils;
import com.miusi.util.JsonUtil;
import com.opensymphony.xwork2.ActionSupport;

public class AppQueryAction extends ActionSupport {
	private PictureService pictureService;
	private SeriesService seriesService;
	private UserService userService;
	private MarketService marketService; 

	public MarketService getMarketService() {
		return marketService;
	}

	public void setMarketService(MarketService marketService) {
		this.marketService = marketService;
	}

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

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
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
		case 4:
			action4_QueryMode();
			break;
		case 5:
			action5_QueryUser(info); 
			break;
		case 6:
			action6_addUser(info);
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

	private void action4_QueryMode() {
		Map<String, Object> map = new HashMap<String, Object>();
		String status = null;
		try {
			System.out.println("action4_QueryMode");
			Market show = this.marketService.findMarket();
			System.out.println(GeneralUtil.isEmpty(show));
			if (!GeneralUtil.isEmpty(show)) {
				status = "1";
				map.put("data", show);
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

	private void action5_QueryUser(QueryInfo info) {
		String imei = info.imei;
		Map<String, Object> map = new HashMap<String, Object>();
		String status = null;
		try {
			User user = this.userService.appQueryUser(imei);
			System.out.println(GeneralUtil.isEmpty(user));
			if (!GeneralUtil.isEmpty(user)) {
				status = "1";
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

	private void action6_addUser(QueryInfo info) {
		User user = new User();
		user.setDevice_id(info.imei);
		Map<String, Object> map = new HashMap<String, Object>();
		String status = null;
		try {
			this.userService.saveUser(user);
			status = "1";
			map.put("status", status);
			JSONUtils.toJson(ServletActionContext.getResponse(), map);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

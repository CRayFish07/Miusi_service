package com.miusi.action.series;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.miusi.entity.Picture;
import com.miusi.service.PictureService;
import com.miusi.util.JSONUtils;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class AppQueryRecommendAction extends ActionSupport {
	private PictureService pictureService;

	public PictureService getPictureService() {
		return pictureService;
	}

	public void setPictureService(PictureService pictureService) {
		this.pictureService = pictureService;
	}

	@Override
	public String execute() throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		String status = null;
		try {
			List<Picture> list = this.pictureService.findRecommend();
			System.out.println(list.size());
			if (list.size() > 0) {
				status = "1";
				map.put("pictures", list);
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

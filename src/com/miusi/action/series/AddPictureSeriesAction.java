package com.miusi.action.series;

import java.util.List;
import java.util.Map;

import com.miusi.entity.Series;
import com.miusi.entity.Picture;
import com.miusi.service.SeriesService;
import com.miusi.service.PictureService;
import com.miusi.util.GeneralUtil;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AddPictureSeriesAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private List<Picture> pictureList;

	public List<Picture> getPictureList() {
		return pictureList;
	}

	public void setPictureList(List<Picture> pictureList) {
		this.pictureList = pictureList;
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
		// TODO Auto-generated method stub
		if ((!GeneralUtil.isEmpty(pictureList.get(0)))
				&& (!GeneralUtil.isEmpty(pictureList.get(0).getUrl()))) {
			System.out.print(pictureList.get(0).getUrl());
			String s[] = pictureList.get(0).getUrl().split("###");
			int l = Integer.parseInt(s[1]);
			for (int i = 0; i < l; i++) {
				pictureList.get(i).setUrl(s[0] + (i + 1) + ".jpg");
			}
		}
		for (int i = 0; i < pictureList.size(); i++) {
			if ((!GeneralUtil.isEmpty(pictureList.get(i)))
					&& (!GeneralUtil.isEmpty(pictureList.get(i).getUrl()))) {
				Series series = new Series();
				series.setUrl(pictureList.get(i).getUrl());
				this.seriesService.saveSeries(series);
				savePictures();
				break;
			}
		}

		Map request = (Map) ActionContext.getContext().get("request");
		request.put("list", this.seriesService.findAllSeries());
		return SUCCESS;
	}

	private void savePictures() {
		int seriesId = this.seriesService.findMaxId();
		for (int i = 0; i < pictureList.size(); i++) {
			if (!GeneralUtil.isEmpty(pictureList.get(i))
					&& (!GeneralUtil.isEmpty(pictureList.get(i).getUrl()))) {
				pictureList.get(i).setSeries_id(seriesId);
				this.pictureService.savePicture(pictureList.get(i));
			}
		}
	}
}

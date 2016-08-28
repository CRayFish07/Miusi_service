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

public class AddMorePictureAction2 extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private List<Picture> pictureList;
	private Integer series_id;

	public Integer getSeries_id() {
		return series_id;
	}

	public void setSeries_id(Integer series_id) {
		this.series_id = series_id;
	}

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
		System.out.println("series_id " + series_id);
		savePictures();
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("list", this.pictureService.findBySeriesId(series_id));
		return SUCCESS;
	}

	private void savePictures() {
		for (int i = 0; i < pictureList.size(); i++) {
			if (!GeneralUtil.isEmpty(pictureList.get(i))
					&& (!GeneralUtil.isEmpty(pictureList.get(i).getUrl()))) {
				pictureList.get(i).setSeries_id(series_id);
				this.pictureService.savePicture(pictureList.get(i));
			}
		}
	}
}

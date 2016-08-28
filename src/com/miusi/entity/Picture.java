package com.miusi.entity;

public class Picture {
	private Integer id;
	private String url;
	private Integer need_vip;
	private Integer series_id;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Integer getNeed_vip() {
		return need_vip;
	}
	public void setNeed_vip(Integer need_vip) {
		this.need_vip = need_vip;
	}
	public Integer getSeries_id() {
		return series_id;
	}

	public void setSeries_id(Integer series_id) {
		this.series_id = series_id;
	}
	 
}

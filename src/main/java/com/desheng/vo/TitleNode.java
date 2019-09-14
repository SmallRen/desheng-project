package com.desheng.vo;

import java.util.List;

/**
 * 导航栏vo
 */
public class TitleNode {
	private Integer id;
	private String name;
	private String icon;
	private String url;
	private Boolean status;
	private List<?> titleNode;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public List<?> getTitleNode() {
		return titleNode;
	}

	public void setTitleNode(List<?> titleNode) {
		this.titleNode = titleNode;
	}

	@Override
	public String toString() {
		return "TitleNode [id=" + id + ", name=" + name + ", icon=" + icon + ", url=" + url + ", status=" + status
				+ ", titleNode=" + titleNode + "]";
	}

}

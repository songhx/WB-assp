package com.assp.modules.sys.entity;

import java.io.Serializable;

public class Ztree implements Serializable{

	/**
	 * 描述：
	 * 创建人： 魏泽超
	 * 创建时间: 2016年7月28日 上午10:07:36
	 * @version
	 */
	private static final long serialVersionUID = 1L;
	
	private String id; //节点id
	
	private String pid; //节点父id
	
	private String name; //节点名称
	
	private boolean nocheck;//是否可选
	
	private boolean checked;//是否勾选
	
	private boolean open; //是否打开节点展示

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isNocheck() {
		return nocheck;
	}

	public void setNocheck(boolean nocheck) {
		this.nocheck = nocheck;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}
	
	
	
	
}

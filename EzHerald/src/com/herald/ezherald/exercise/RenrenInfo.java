package com.herald.ezherald.exercise;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
/**
 * @author xie
 * ����ϵ���˵���Ϣ
 */
public class RenrenInfo{
	private String info;
	private String date;
	private SharedPreferences pref;
	public Activity activity;
	
	public RenrenInfo(Activity activity){
		this.activity = activity;
		pref = activity.getApplication().getSharedPreferences("Renren", 0);
		setInfo(pref.getString("info", null));
		setDate(pref.getString("date", null));
	}
	/**
	 * ��������
	 */
	public void update(){
		//TODO update the information
	}
	/**
	 * �������ݵ�sharedPreference;
	 */
	public void save(){
		Editor editor = pref.edit();
		editor.putString("info", getInfo());
		editor.putString("date", getDate());
		editor.commit();
	}
	
	/**
	 * @return boolean
	 * �����Ƿ�Ϊ��
	 */
	public boolean isSet(){
		if(info == null || date == null)
			return false;
		return true;
	}
	
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
}
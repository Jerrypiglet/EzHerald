package com.herald.ezherald.exercise;


import java.util.Calendar;

import android.util.Log;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.widget.Toast;

/**
 * @author xie
 * �ܲٴ�������Ϣ
 */
public class RunTimes {
	private int    times; //�鵽���ܲٴ���
	private int    adjustTimes;//�����Ĵ���
	private float  rate;//��������
	private int    remainDays;//��ѧ��ʣ������
	private String    startDate;//��ѧ�ڿ�ʼ������
	private String averageRunTime;//ƽ����ʱ��
	private int    adviceTime;//�Ƽ�ÿ���ܲ�����
	private String updateTime;//����ʱ��
	
	public static final int    DEFAULT_TIMES = -1;
	public static final int    DEFAULT_ADJUST_TIMES = 0;
	public static final float  DEFAULT_RATE = -1;
	public static final int    DEFAULT_REMAIN_DAYS = -1;  
	public static final String DEFAULT_START_DATE = null;
	public static final String DEFAULT_AVERAGE_RUN_TIME=null;
	public static final int    DEFAULT_ADVICE_TIME=-1;
	public static final String DEFAULT_UPDATE_TIME = null;
	
	private SharedPreferences pref;
	private Editor editor;
	private Activity activity;
	public int getTimes() {
		return times;
	}
	public float getRate() {
		return rate;
	}
	public void setRate(float rate) {
		this.rate = rate;
	}
	public int getRemainDays() {
		return remainDays;
	}
	public void setRemainDays(int RemainDays) {
		this.remainDays = RemainDays;
	}
	public void setTimes(int times) {
		this.times = times;
	}
	public int getAdjustTimes() {
		return adjustTimes;
	}
	public void setAdjustTimes(int adjustTimes) {
		if (adjustTimes<100) {
			this.adjustTimes = adjustTimes;
		}
	}
	public String getAverageRunTime() {
		return averageRunTime;
	}
	public void setAverageRunTime(String averageRunTime) {
		this.averageRunTime = averageRunTime;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public int getAdviceTime() {
		return adviceTime;
	}
	public void setAdviceTime(int adviceTime) {
		this.adviceTime = adviceTime;
	}
	
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * @param activity �����ߵ�Activity
	 * ����ʱ�᳢�Դ�sharedPreference��ȡ����
	 */
	public RunTimes(Activity activity){
		this.activity = activity; 
		pref = activity.getApplication().getSharedPreferences("RunTimes", 0);
		
		setTimes(pref.getInt("Times", DEFAULT_TIMES));
		setAdjustTimes(pref.getInt("AdjustTimes",DEFAULT_ADJUST_TIMES));
		setRate(pref.getFloat("Rate", DEFAULT_RATE));
		setStartDate(pref.getString("StartDate", DEFAULT_START_DATE));
		setAverageRunTime(pref.getString("AverageRunTime", DEFAULT_AVERAGE_RUN_TIME));
		setUpdateTime(pref.getString("UpdateTime",DEFAULT_UPDATE_TIME));
		setRemainDays(calcRemainDays());
		setAdviceTime(calcAdviceTime());
	}
	/**
	 * @return Boolean �Ƿ��Ѿ�������
	 */
	public boolean isSet(){
		return times != DEFAULT_TIMES && rate  !=DEFAULT_RATE 
			&& startDate != DEFAULT_START_DATE && averageRunTime!=DEFAULT_AVERAGE_RUN_TIME 
			&& updateTime!= DEFAULT_UPDATE_TIME ;
	}															  
	/**
	 * ��������
	 */
	public void update(){
		try {
//			setAdjustTimes(pref.getInt("AdjustTimes",0));
//			ObjectFactory factory = new ObjectFactory();
//			RunTimesData runTimesData = factory.createRunTimesData();
//			setTimes(runTimesData.getTimes().intValue());
//TODO ����������Ϣ
			throw new Exception();
		} catch (Exception e) {
			// TODO: handle exception
			Toast.makeText(activity, "����ʧ��", Toast.LENGTH_SHORT).show();
		}
	}
	/**
	 * �������ݵ�sharedPreference
	 */
	public void save(){
		editor = pref.edit();
		editor.putInt("Times", getTimes());
		editor.putInt("AdjustTimes", getAdjustTimes());
		editor.putFloat("Rate", getRate());
		editor.putString("StartDate",getStartDate());
		editor.putString("AverageRunTime", getAverageRunTime());
		editor.commit();
	}
	/**
	 * @return ��ѧ��ʣ�������
	 * ���ݱ�ѧ�ڿ�ʼ���ں͵�ǰ���ڷ���ʣ������
	 */
	private int calcRemainDays(){
		final int TOTAL_DAYS = 16*7;
		Calendar today = Calendar.getInstance();
		Calendar start = Calendar.getInstance();
		//TODO set the start to start time start.set(int,int,int)
		int diffDays = 0;
		if(today.get(Calendar.YEAR)== start.get(Calendar.YEAR)){//ͬһ��
			diffDays = today.get(Calendar.DAY_OF_YEAR)-start.get(Calendar.DAY_OF_YEAR);
		}else{
			Calendar endOfYear =  Calendar.getInstance();
			endOfYear.set(Calendar.YEAR,start.get(Calendar.YEAR));
			endOfYear.set(Calendar.MONTH,Calendar.DECEMBER);
			endOfYear.set(Calendar.DATE,31);
			diffDays = endOfYear.get(Calendar.DAY_OF_YEAR)-start.get(Calendar.DAY_OF_YEAR)+today.get(Calendar.DAY_OF_YEAR);
			Log.w("endOfYear",""+endOfYear.get(Calendar.DAY_OF_YEAR));
		}
		return TOTAL_DAYS-diffDays;//��������ȥ�Ѿ���ȥ������
	}

	/**
	 * @return ����ÿ���ܲ�ʱ��
	 */
	private int calcAdviceTime(){
		//TODO calculate the advise time
		return 0;
	}
}

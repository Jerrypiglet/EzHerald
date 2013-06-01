package com.herald.ezherald.gpa;

/**
 * @author xie
 */
public class GpaPoliticsModel {
	private static double userGpa = -1;//�û���gpa��δ��½ʱΪ-1
	public static double getUserGpa() {
		return userGpa;
	}
	public static void setUserGpa(double userGpa) {
		GpaPoliticsModel.userGpa = userGpa;
	}
	public String[] title = new String[] {"Title"};
	public String[] content = new String[]{"content"};
	private double[] requiredGpa = new double[]{3.0};//���������gpa
	private String[] relation = new String[]{">="};//��������Ĺ�ϵ
	public String[] getRelation() {
		return relation;
	}
	public double[] getRequiredGpa() {
		return requiredGpa;
	}
	/**
	 * @param n ���жϵ�����
	 * @return Boolean
	 */
	public Boolean judge(int n){
		if(userGpa == -1 || n>relation.length){
			return false;
		}else{
			//�ж��û��ļ����Ƿ�����Ҫ��
			if(relation[n] == ">" && userGpa >requiredGpa[n])
				return true;
			if(relation[n] == "<" && userGpa<requiredGpa[n])
				return true;
			if(relation[n] == ">=" && userGpa>=requiredGpa[n])
				return true;
			if(relation[n] == "<=" && userGpa<=requiredGpa[n])
				return true;
			return false;
		}
	}
}

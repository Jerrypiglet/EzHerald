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
	public final String[] title = new String[] {"Title1","Title2"};
	public final String[][] content = 
			new String[][]{
				{"content1"},
				{"Content2Content2Content2Content2Content2Content2Content2Content2Content2Content2Content2Content2"},
			};
	private final double[] requiredGpa = new double[]{3.0,3.0};//���������gpa
	private final String[] relation = new String[]{">=",">="};//��������Ĺ�ϵ
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

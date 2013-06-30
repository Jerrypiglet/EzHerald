package com.herald.ezherald.mainframe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockFragment;
import com.herald.ezherald.R;

/*
 * @author �β�ΰ
 * @since 20130514
 * @updated 20130630
 * 
 * ������������ݵ�Fragement
 * ������ģ��ɲ��ձ�Fragement�Ķ����������
 */
public class MainContentFragment extends SherlockFragment {
	private String text = null;
	private GridView mGridView;  //GridView
	private List<Map<String, Object>> mGridItems;
	
	//////////////Temporarily used local variables///////////////////
	String mContentTitles[] = {"test", "test2", "test3"};
	String mContentCont1 [] = {"AAA", "BBB", "CCC"};
	String mContentCont2 [] = {"XXX", "YYY", "ZZZ"};
	///////Should be removed after we have a SharedPreference////////

	public MainContentFragment() {
		text = "Default";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.support.v4.app.Fragment#setArguments(android.os.Bundle)
	 */
	@Override
	public void setArguments(Bundle args) {
		// TODO Auto-generated method stub
		super.setArguments(args);
		text = args.getString("text");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.support.v4.app.Fragment#onCreate(android.os.Bundle)
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setRetainInstance(true);

	}

	/*
	 * 	 * 
	 * @see
	 * android.support.v4.app.Fragment#onCreateView(android.view.LayoutInflater,
	 * android.view.ViewGroup, android.os.Bundle)
	 */
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		//��ͼ
		View v = inflater.inflate(R.layout.main_frame_content, null);
				
		return v;
	}
	
	
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		mGridView = (GridView)getActivity().findViewById(R.id.main_frame_content_gridView);
		mGridItems = getGridItems();
		mGridView.setAdapter(new MainContentGridItemAdapter(getActivity(), mGridItems));
		mGridView.setOnItemClickListener(new MyOnItemClickListener());
	}



	private class MyOnItemClickListener implements AdapterView.OnItemClickListener{

		@Override
		public void onItemClick(AdapterView<?> parent, View v, int position,
				long id) {
			//TODO: ��Ŀ�������Ӧ���������ģ�飩
			Toast.makeText(getActivity(), "" + position, Toast.LENGTH_SHORT).show();
		}
		
	}
	
	/**
	 * ��ʼ���˵�����Ϣ
	 */
	private List<Map<String, Object>> getGridItems(){
		List<Map<String, Object>> gridItems = new ArrayList<Map<String, Object>>();
		for(int i=0; i<mContentTitles.length; i++){
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("title", mContentTitles[i]);
			map.put("content1", mContentCont1[i]);
			map.put("content2", mContentCont2[i]);
			gridItems.add(map);
		}
		return gridItems;
	}
}

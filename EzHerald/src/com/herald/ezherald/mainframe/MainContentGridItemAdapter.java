package com.herald.ezherald.mainframe;

import java.util.List;
import java.util.Map;

import com.herald.ezherald.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
/**
 * ������ģ����GridView��Ŀ���ݵ�Adapter
 * @author BorisHe
 * @since 20130630
 * @updated 20130630
 */
public class MainContentGridItemAdapter extends BaseAdapter {

	private final String TAG = "Ez:MainContentGridItemAdapter";
	
	private Context mContext;
	private List< Map<String, Object> > mGridItemList; // Grid����Ϣ
	private LayoutInflater mGridContainer; //��ͼ����
	
	/**
	 * Grid��Ŀ���Զ���ؼ���
	 * @author BorisHe
	 *
	 */
	public final class GridItemView{
		public TextView title;		//ģ������
		public TextView content1;	//����1
		public TextView content2;	//����2
	}
	
	public MainContentGridItemAdapter(Context c, List<Map<String, Object>> gridItems){
		mContext = c;
		mGridContainer = LayoutInflater.from(mContext);
		mGridItemList = gridItems;
	}
	
	@Override
	public int getCount() {
		return mGridItemList.size();
	}

	@Override
	public Object getItem(int position) {
		return mGridItemList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// �����ͼ
		GridItemView gridItemView;
		if(convertView == null){// if it's not recycled, initialize some attributes
			gridItemView = new GridItemView();
			// ��ȡ�˵�����ļ�����ͼ
			convertView = mGridContainer.inflate(R.layout.main_frame_content_grid_item, null);
			// ��ȡ�ؼ�����
			gridItemView.title = (TextView)convertView
					.findViewById(R.id.main_frame_content_griditem_title);
			gridItemView.content1 = (TextView)convertView
					.findViewById(R.id.main_frame_content_griditem_content1);
			gridItemView.content2 = (TextView)convertView
					.findViewById(R.id.main_frame_content_griditem_content2);
			// ���ÿؼ�����convertView
			convertView.setTag(gridItemView);
		}	else{
			gridItemView = (GridItemView)convertView.getTag();
		}
		
		// ����title��contents
		gridItemView.title.setText(
				(CharSequence) mGridItemList.get(position).get("title"));
		gridItemView.content1.setText(
				(CharSequence) mGridItemList.get(position).get("content1"));
		gridItemView.content2.setText(
				(CharSequence) mGridItemList.get(position).get("content2"));
		
		return convertView;
	}

}

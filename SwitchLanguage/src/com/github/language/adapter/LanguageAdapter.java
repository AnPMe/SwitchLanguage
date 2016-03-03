/** 
 * @Title:  LanguageAdapter.java 
 * @author:  Xiho
 * @data:  2016年3月1日 下午4:56:52 <创建时间>
 * 
 * @history：<以下是历史记录>
 *
 * @modifier: <修改人>
 * @modify date: 2016年3月1日 下午4:56:52 <修改时间>
 * @log: <修改内容>
 *
 * @modifier: <修改人>
 * @modify date: 2016年3月1日 下午4:56:52 <修改时间>
 * @log: <修改内容>
 */
package com.github.language.adapter;

import java.util.List;






import com.example.switchlanguage.R;
import com.github.changelanguage.LanguageInfo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * TODO<请描述这个类是干什么的>
 * 
 * @author Xiho
 * @versionCode 1 <每次修改提交前+1>
 */
public class LanguageAdapter extends BaseAdapter {

	private Context mContext;
	
	private List<LanguageInfo> mListLanguageInfo;

	private int selectItem=-1;  
	/**
	 * @param mContext
	 * @param mListLanguageInfo
	 */
	public LanguageAdapter(Context mContext,
			List<LanguageInfo> mListLanguageInfo) {
		super();
		this.mContext = mContext;
		this.mListLanguageInfo = mListLanguageInfo;
	}

	public  void setSelectItem(int selectItem) {  
         this.selectItem = selectItem;  
    }  
	@Override
	public int getCount() {
		return mListLanguageInfo.size();
	}

	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}
	
	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		final LanguageInfo mLanguageInfo = mListLanguageInfo.get(position);
		ViewHolder viewHolder=null;	
		if (convertView == null) {
			viewHolder = new ViewHolder();
			convertView = LayoutInflater.from(mContext).inflate(
					R.layout.language_item, null);
			viewHolder.mImageView = (ImageView) convertView
					.findViewById(R.id.img_label);
			viewHolder.mLanguage = (TextView) convertView
					.findViewById(R.id.txt_language);
			viewHolder.mView = (RelativeLayout) convertView.findViewById(R.id.item_lv);
			viewHolder.mView.setTag(viewHolder);
			convertView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}
		viewHolder.mLanguage.setText(mLanguageInfo.getLanguage());
		//当前选中项
		if (position == selectItem) {  
			viewHolder.mImageView.setVisibility(View.VISIBLE);
			viewHolder.mLanguage.setTextColor(mContext.getResources().getColor(
					R.color.font_orange)); 
        } else {  
        	viewHolder.mImageView.setVisibility(View.INVISIBLE);
			viewHolder.mLanguage.setTextColor(mContext.getResources().getColor(
					R.color.black));
        }   
		return convertView;
	}

	class ViewHolder {
		ImageView mImageView;
		TextView mLanguage;
		RelativeLayout mView;
	}

}

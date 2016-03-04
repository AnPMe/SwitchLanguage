/** 
 * @Title:  LanguageActivity.java 
 * @author:  Xiho
 * @data:  2016年2月29日 上午11:17:17 <创建时间>
 * 
 * @history：<以下是历史记录>
 *
 * @modifier: <修改人>
 * @modify date: 2016年2月29日 上午11:17:17 <修改时间>
 * @log: <修改内容>
 *
 * @modifier: <修改人>
 * @modify date: 2016年2月29日 上午11:17:17 <修改时间>
 * @log: <修改内容>
 */
package com.github.changelanguage;

import java.util.List;
import java.util.Locale;

import com.example.switchlanguage.R;
import com.github.language.adapter.LanguageAdapter;
import com.github.language.controller.LanguageController;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;

/** 
 * TODO 选择多国语言
 * @author Xiho 
 * @versionCode 1 <每次修改提交前+1>
 */
public class LanguageActivity extends Activity {
	private ListView mListView;
	private Button mNextStep;
	private LanguageAdapter mLanguageAdapter;
	private List<LanguageInfo> mListLanguageInfo;
	private LanguageController mLanguageController;
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.language);
		mLanguageController = LanguageController.getInstance(getApplicationContext());
		//初始化列表数据
		mListLanguageInfo = mLanguageController.getListData();
		
	}
	
	/**
	 * 初始化View
	 */
	private void initView() {
		mListView = (ListView) findViewById(R.id.language_listview);
		mNextStep = (Button) findViewById(R.id.next);
		mNextStep.setText(getResources().getString(R.string.button_next_step));
		mLanguageAdapter = new LanguageAdapter(getApplicationContext(), mListLanguageInfo);
//		mListView.setLayoutAnimation(ListViewUtils.setListAnim());
		mListView.setAdapter(mLanguageAdapter);
		mListView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					final int position, long id) {
				
					LanguageInfo mInfo = mListLanguageInfo.get(position);
					//更改系统语言
					mLanguageController.updateLanguage(mInfo);
			}
		});
		
		mNextStep.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
			}
		});
	}
	
	/**
	 * 初始化本地语言
	 */
	private void initLanguage() {
		Locale currentLocale = mLanguageController.getCurrentLocale(getApplicationContext());
		for (int i = 0; i < mListLanguageInfo.size(); i++) {
			Locale temp = mListLanguageInfo.get(i).getLocale();
			if(temp.equals(currentLocale)){
				//标记当前item
				mLanguageAdapter.setSelectItem(i);
			}
		}
	}
	
	@Override
	public void onResume() {
		super.onResume();
		//初始化View
		initView();
		//初始化本地语言
		initLanguage();
	}
}

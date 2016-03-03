/** 
 * @Title:  UpdateLanguageUtils.java 
 * @author:  Xiho
 * @data:  2016年3月1日 下午7:09:45 <创建时间>
 * 
 * @history：<以下是历史记录>
 *
 * @modifier: <修改人>
 * @modify date: 2016年3月1日 下午7:09:45 <修改时间>
 * @log: <修改内容>
 *
 * @modifier: <修改人>
 * @modify date: 2016年3月1日 下午7:09:45 <修改时间>
 * @log: <修改内容>
 */
package com.github.language.controller;

import java.lang.reflect.Method;
import java.util.Locale;

import android.app.backup.BackupManager;
import android.content.res.Configuration;

/**
 * TODO<请描述这个类是干什么的>
 * 
 * @author Xiho
 * @versionCode 1 <每次修改提交前+1>
 */
@SuppressWarnings("unchecked")
public class UpdateLanguageUtils {
	
	
	public static void updateLanguage(Locale locale) {
		try {
			Object objIActMag, objActMagNative;

			Class clzIActMag = Class.forName("android.app.IActivityManager");

			Class clzActMagNative = Class
					.forName("android.app.ActivityManagerNative");

			Method mtdActMagNative$getDefault = clzActMagNative
					.getDeclaredMethod("getDefault");

			objIActMag = mtdActMagNative$getDefault.invoke(clzActMagNative);

			Method mtdIActMag$getConfiguration = clzIActMag
					.getDeclaredMethod("getConfiguration");

			Configuration config = (Configuration) mtdIActMag$getConfiguration
					.invoke(objIActMag);

			config.locale = locale;

			Class clzConfig = Class
					.forName("android.content.res.Configuration");
			java.lang.reflect.Field userSetLocale = clzConfig
					.getField("userSetLocale");
			userSetLocale.set(config, true);

			// 此处需要声明权限:android.permission.CHANGE_CONFIGURATION
			// 会重新调用 onCreate();
			Class[] clzParams = { Configuration.class };

			Method mtdIActMag$updateConfiguration = clzIActMag
					.getDeclaredMethod("updateConfiguration", clzParams);

			mtdIActMag$updateConfiguration.invoke(objIActMag, config);

			BackupManager.dataChanged("com.android.providers.settings");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

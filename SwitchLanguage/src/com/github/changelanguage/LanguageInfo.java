package com.github.changelanguage;

import java.io.Serializable;
import java.util.Locale;

/**
 * Created by Xiho on 2016/2/17.
 */
public class LanguageInfo implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -4295651469724630055L;
	private String language; //語言類型
    private Locale locale; // 语言
	/**
	 * @return the language
	 */
	public String getLanguage() {
		return language;
	}
	/**
	 * @param language the language to set
	 */
	public void setLanguage(String language) {
		this.language = language;
	}
	/**
	 * @return the locale
	 */
	public Locale getLocale() {
		return locale;
	}
	/**
	 * @param locale the locale to set
	 */
	public void setLocale(Locale locale) {
		this.locale = locale;
	}

    
}

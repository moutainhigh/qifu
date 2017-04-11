/* 
 * Copyright 2012-2017 qifu of copyright Chen Xin Nien
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 * -----------------------------------------------------------------------
 * 
 * author: 	Chen Xin Nien
 * contact: chen.xin.nien@gmail.com
 * 
 */
package org.qifu.base.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.qifu.base.Constants;
import org.qifu.util.SimpleUtils;

public abstract class BaseController {
	protected static final String PAGE_SYS_LOGIN = "system/login";
	protected static final String PAGE_SYS_SEARCH_NO_DATA = "system/searchNoData";
	protected static final String PAGE_SYS_LOGIN_AGAIN = "system/login_again";
	protected static final String PAGE_SYS_NO_AUTH = "system/auth1";
	
	protected static final String REDIRECT_INDEX = "redirect:/index.do";
	
	public String getErrorContact() {
		return String.valueOf( Constants.getSettingsMap().get("basePage.errorContact") );
	}
	
	public String getVerMsg() {
		return String.valueOf( Constants.getSettingsMap().get("basePage.verMsg") );
	}
	
	public String getJsVerBuild() {
		return String.valueOf( Constants.getSettingsMap().get("basePage.jsVerBuild") );
	}
	
	public String getLoginCaptchaCodeEnable() {
		return Constants.getLoginCaptchaCodeEnable();
	}
	
	public String getGoogleMapEnable() {
		return String.valueOf( Constants.getSettingsMap().get("googleMap.enable") );
	}	
	
	public String getGoogleMapUrl() {
		return String.valueOf( Constants.getSettingsMap().get("googleMap.url") );
	}
	
	public String getGoogleMapKey() {
		return String.valueOf( Constants.getSettingsMap().get("googleMap.key") );
	}	
	
	public String getGoogleMapDefaultLat() {
		return String.valueOf( Constants.getSettingsMap().get("googleMap.defaultLat") );
	}	
	
	public String getGoogleMapDefaultLng() {
		return String.valueOf( Constants.getSettingsMap().get("googleMap.defaultLng") );
	}		
	
	public String getGoogleMapLanguage() {
		return String.valueOf( Constants.getSettingsMap().get("googleMap.language") );
	}	
	
	public String getGoogleMapClientLocationEnable() {
		return String.valueOf( Constants.getSettingsMap().get("googleMap.clientLocationEnable") );
	}
	
	public String getTwitterEnable() {
		return String.valueOf( Constants.getSettingsMap().get("twitter.enable") );
	}
	
	public boolean isSuperRole() {
		Subject subject = SecurityUtils.getSubject();
		if (subject.hasRole(Constants.SUPER_ROLE_ADMIN) || subject.hasRole(Constants.SUPER_ROLE_ALL)) {
			return true;
		}
		return false;
	}
	
	public String getAccountId() {		
		Subject subject = SecurityUtils.getSubject();		
		return this.defaultString((String)subject.getPrincipal());		
	}	
	
	public String generateOid() {
		return SimpleUtils.getUUIDStr();
	}	
	
	protected String defaultString(String str) {
		return StringUtils.defaultString(str);
	}
	
	protected void setPageMessage(HttpServletRequest request, String pageMessage) {
		if (null!=pageMessage && pageMessage.length()>=500) {
			pageMessage=pageMessage.substring(0, 500);
		}
		request.setAttribute(Constants.PAGE_MESSAGE, pageMessage);
	}	
	
	protected String getNowDate() {
		return SimpleUtils.getStrYMD("/");
	}
	
	protected String getNowDate2() {
		return SimpleUtils.getStrYMD("-");
	}		
	
}
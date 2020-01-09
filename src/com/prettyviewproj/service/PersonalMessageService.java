/**
 *
 */
package com.prettyviewproj.service;

import java.util.ArrayList;

import com.prettyviewproj.Idao.IPersonalMessageDao;
import com.prettyviewproj.Iservice.IPersonalMessageService;
import com.prettyviewproj.dao.PersonalMessageDao;
import com.prettyviewproj.entity.PersonalMessageInfo;

/**
*@author:黄羽伦
*@description:
*@date:2018年12月21日
*/
public class PersonalMessageService implements IPersonalMessageService {

	private IPersonalMessageDao personalMessageDao;
	
	public PersonalMessageService() {
		
		personalMessageDao = new PersonalMessageDao();
	}
	
	@Override
	public boolean savePersonalMessageInfo(PersonalMessageInfo personalMessageInfo) {
		if(personalMessageInfo!=null) {
			boolean isSave = personalMessageDao.insertPersonalMessageInfo(personalMessageInfo);
			return isSave;
		}
		return false;
	}
	@Override
	public ArrayList<PersonalMessageInfo> searchPersonalMessageInfoByUserID(String userID) {
		if(userID!=null) {
			ArrayList<PersonalMessageInfo> arrayPersonalMessageInfo =  personalMessageDao.selectPersonalMessageInfoByUserID(userID);
			return arrayPersonalMessageInfo;
		}
		return null;
	}
}

/**
 *
 */
package com.prettyviewproj.Iservice;

import java.util.ArrayList;

import com.prettyviewproj.entity.PersonalMessageInfo;

/**
*@author:黄羽伦
*@description:
*@date:2018年12月21日
*/
public interface IPersonalMessageService {
	boolean savePersonalMessageInfo(PersonalMessageInfo personalMessageInfo);

	ArrayList<PersonalMessageInfo> searchPersonalMessageInfoByUserID(String userID);
}

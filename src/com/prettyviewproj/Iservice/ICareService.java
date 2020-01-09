/**
 *
 */
package com.prettyviewproj.Iservice;

import java.util.ArrayList;

import com.prettyviewproj.entity.CareInfo;
import com.prettyviewproj.entity.UserInfo;

/**
*@author:黄羽伦
*@description:
*@date:2018年12月21日
*/

public interface ICareService {

	boolean saveCareInfoByUserIDAndCaredID(String userID, String caredID);


	boolean removeCareInfoByUserIDAndCaredID(String userID, String caredID);

	ArrayList<UserInfo> searchCareInfoByUserID(String userID);

	CareInfo findCareInfoIsExist(String userID, String caredID);
}

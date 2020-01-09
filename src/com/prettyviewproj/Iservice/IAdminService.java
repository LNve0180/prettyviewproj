/**
 *
 */
package com.prettyviewproj.Iservice;

import java.util.HashMap;

import com.prettyviewproj.entity.AdminInfo;

/**
*@author:黄羽伦
*@description:
*@date:2018年12月21日
*/
public interface IAdminService {

	HashMap<String, String> searchWorksData();

	HashMap<String, String> searchCountData();

	boolean findAdminInfoIsExist(String adminID);

	AdminInfo judgeUserPassword(String adminID, String adminPassword);

	boolean saveAdminInfoByAdminInfo(AdminInfo adminInfo);

}

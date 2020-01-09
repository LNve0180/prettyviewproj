/**
 *
 */
package com.prettyviewproj.Iservice;

import java.util.ArrayList;

import com.prettyviewproj.entity.CollectShowInfo;

/**
*@author:黄羽伦
*@description:
*@date:2018年12月21日
*/
public interface ICollectService {
 boolean saveCollectInfoByCollectInfo(String userID,String worksID,String collectTime);
 boolean removeCollectInfoByUserIDWorksID(String userID,String worksID);
 ArrayList<CollectShowInfo> searchCollectInfoByUserID(String userID);
 boolean findCollectInfoIsExist(String userID,String worksID);
}

/**
 *
 */
package com.prettyviewproj.Iservice;

import java.util.ArrayList;

import com.prettyviewproj.entity.HistoryInfo;
/**
*@author:黄羽伦
*@description:
*@date:2018年12月21日
*/
public interface IHistoryService {
	ArrayList<HistoryInfo> searchAllHistoryByUserID(String userID);


	boolean removeHistoryByHistoryInfo(HistoryInfo historyInfo);


	boolean saveHistoryInfo(HistoryInfo historyInfo);

}

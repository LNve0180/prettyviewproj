/**
 *
 */
package com.prettyviewproj.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.prettyviewproj.Idao.IAdminDao;
import com.prettyviewproj.Iservice.IAdminService;
import com.prettyviewproj.dao.AdminDao;
import com.prettyviewproj.entity.AdminInfo;
import com.prettyviewproj.entity.WorksLastMonthData;
import com.prettyviewproj.tools.TimeTool;

/**
*@author:黄羽伦
*@description:
*@date:2018年12月21日
*/
public class AdminService implements IAdminService {

	private IAdminDao adminDao;
	public AdminService() {
		adminDao = new AdminDao();
	}
	
	@Override
	public HashMap<String, String> searchWorksData() {
		//获取上月开始，结束，总天数
		HashMap<String,String> timeMap = TimeTool.getLastMonthBeginAndEnd();
		String timeBegin = timeMap.get("timeBegin");
		String timeEnd = timeMap.get("timeEnd");
		String maxDay = timeMap.get("maxDay");
		String series="";//图表数据
		//调用dao获取上月时间段数据
		ArrayList<WorksLastMonthData> arrayData = adminDao.selectLastMonthWorksData(timeBegin, timeEnd);
		//处理数据
		HashMap<String,String> dataMap = new HashMap<String,String>();
		if(arrayData!=null) {
			int intMasDay = Integer.parseInt(maxDay);
			for(int i = 1; i <= intMasDay; i++) {
				if(arrayData.size() <= 0) {
					series += "0,";
				}
				for(int j = 0; j < arrayData.size(); j++) {
					//获取时间后两位
					String day = arrayData.get(j).getWorksDate();
					String dayTemp = day.substring(day.length() - 2, day.length());
					int intDay = Integer.parseInt(dayTemp);
					if(i == intDay) {
						series += arrayData.get(j).getWorksNum()+",";
						break;
					}
					if(j == arrayData.size()-1) {
						series += "0,";
					}
				}
				

			}
			series = series.substring(0,series.length() - 1);//去,号
			System.out.println(series);
			
			dataMap.put("series",series);
			dataMap.put("maxDay",maxDay);
			dataMap.put("timeBegin",timeBegin);
			dataMap.put("timeEnd",timeEnd);
			return dataMap;
		}else {
			System.out.println("searchWorksData:数据为空");
			return null;
		}
		
	}
	
	@Override
	public HashMap<String, String> searchCountData() {
		String userNum = adminDao.selectUserNum();
		String creatorNum = adminDao.selectCreatorNum();
		String worksNum = adminDao.selectWorksNum();
		HashMap<String,String> dataMap = new HashMap<String,String>();
		dataMap.put("userNum", userNum);
		dataMap.put("creatorNum", creatorNum);
		dataMap.put("worksNum",worksNum);
		return dataMap;
	}

	@Override
	public boolean findAdminInfoIsExist(String adminID) {
		// TODO Auto-generated method stub
		if(adminID.equals("")) {
			return false;
		}
		else {
			return adminDao.selectAdminInfoIsExist(adminID);
		}
	}
	
	@Override
	public AdminInfo judgeUserPassword(String adminID, String adminPassword) {
		// TODO Auto-generated method stub
		if(adminID.equals("")||adminPassword.equals("")) {
			return null;
		}else {
			return adminDao.inspectAdminPassword(adminID, adminPassword);
		}
		
	}

	@Override
	public boolean saveAdminInfoByAdminInfo(AdminInfo adminInfo) {
		// TODO Auto-generated method stub
		if(adminInfo.equals("")) {
			return false;
		}else {
			return adminDao.insertAdminInfoByAdminInfo(adminInfo);
		}
	}
	
	
	public static void main(String[] args) {
		IAdminService adminService = new AdminService();
		adminService.searchWorksData();
		//adminService.searchCountData();
	}
}


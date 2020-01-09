package com.prettyviewproj.Idao;

import java.util.ArrayList;

import com.prettyviewproj.entity.AdminInfo;
import com.prettyviewproj.entity.WorksLastMonthData;

public interface IAdminDao {

	ArrayList<WorksLastMonthData> selectLastMonthWorksData(String timeBegin, String timeEnd);

	String selectUserNum();

	String selectCreatorNum();

	String selectWorksNum();

	boolean selectAdminInfoIsExist(String adminID);

	AdminInfo inspectAdminPassword(String adminID, String adminPassword);

	boolean insertAdminInfoByAdminInfo(AdminInfo adminInfo);

	

}

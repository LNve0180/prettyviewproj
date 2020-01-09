package com.prettyviewproj.Idao;

import java.util.ArrayList;

import com.prettyviewproj.entity.PersonalMessageInfo;

public interface IPersonalMessageDao {

	boolean insertPersonalMessageInfo(PersonalMessageInfo personalMessageInfo);

	ArrayList<PersonalMessageInfo> selectPersonalMessageInfoByUserID(String userID);

}

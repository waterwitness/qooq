package com.tencent.mobileqq.data;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.uniqueConstraints;

@uniqueConstraints(clause=ConflictClause.REPLACE, columnNames="appId")
public class TroopAppInfo
  extends Entity
{
  public String AppTipIcon;
  public int AppTipIconTimeStamp;
  public int AppTipInfoSeq;
  public int AppTipReportIdClick;
  public int AppTipReportIdShow;
  public String AppTipToolTip;
  public String androidDownloadUrl;
  public String androidOpen;
  public int appFrom;
  public String appIcon;
  public int appIconUpdateTime;
  public long appId;
  public int appInnerType;
  public String appIntro;
  public int appIsNew;
  public String appName;
  public int appNewTime;
  public int appSortKey;
  public int appStatus;
  public int appType;
  public int appUpdateTime;
  public String appUrl;
  public int appWindowHeight;
  public int appWindowWidth;
  public int initFlag;
  public String openParam;
  public int settingFlag;
  public String tags;
  public String versionAndroid;
  
  public TroopAppInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\data\TroopAppInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
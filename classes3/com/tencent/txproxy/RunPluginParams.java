package com.tencent.txproxy;

import android.content.Intent;
import com.tencent.proxyinner.log.XLog;
import com.tencent.proxyinner.utility.UtilSchema;
import java.util.Map;

public class RunPluginParams
{
  private static final String TAG = "OpenRoomParam";
  public Intent intent;
  public String mAddr_city;
  public String mAddr_country;
  public String mAddr_province;
  public int mAge = 0;
  public String mAppid = "";
  public String mAuthId;
  public String mAuthKey;
  public int mAuthType = 1;
  public int mBirthDay = 0;
  public int mBirthMonth = 0;
  public int mBirthYear = 0;
  public boolean mDownloadInHost = false;
  public String mFromId = "0";
  public int mGender = 0;
  public String mHometown_city;
  public String mHometown_country;
  public String mHometown_province;
  public String mLaunchSchema;
  public String mLauncherName = "";
  public boolean mLogInHost = false;
  public boolean mNeedConfirmNetworkBeforeDownload = true;
  public String mNickName;
  public String mPackageName;
  public boolean mReportInHost = false;
  public long mRoomId = 0L;
  public String mRoomName;
  public String mSourceId;
  public String mUserData;
  public String mVasName = "";
  public int mVasType = 0;
  public String mXAppMainActivityName = "com.tencent.intervideo.xapp.LauncherActivity";
  public String mXAppPackageName = "com.tencent.intervideo.xapp";
  public boolean useDefaultLoading = true;
  public String vasSchema;
  
  public void parseParam()
  {
    try
    {
      Map localMap = UtilSchema.paramMap(this.mLaunchSchema);
      this.mVasType = Integer.valueOf((String)localMap.get("plugintype")).intValue();
      this.mXAppPackageName = ((String)localMap.get("packagename"));
      this.mXAppMainActivityName = ((String)localMap.get("mainActivityName"));
      return;
    }
    catch (Exception localException)
    {
      XLog.e("OpenRoomParam", "parseType cause Exception");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\txproxy\RunPluginParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
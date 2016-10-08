package com.tencent.txproxy;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class InitParam
  implements Serializable
{
  public boolean isDataReportInHost = false;
  public boolean isDownloadInHost = false;
  public boolean isLogInHost = false;
  public int mChannelId = 0;
  public int mChannelType = 0;
  public Map<String, String> mComponentMap = new HashMap();
  public String mDefaultContainerActivity;
  public String mDefaultContainerService;
  public String mDefaultLoadApkActivity;
  public boolean mNeedSilentUpdate = true;
  public String mPluginName;
  public XEventListener mSink = null;
  public String mSourceId = "";
  public String mSourceVersion;
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\txproxy\InitParam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.tencent.mobileqq.intervideo;

import android.os.Bundle;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.Serializable;

public class IVPluginInfo
  implements Serializable
{
  private static final int a = 1;
  private static final int b = 2;
  public int authType;
  public int loadingDrawableIndex;
  public Bundle mExtras;
  public String mFromId;
  public String mLoginAppId;
  public String mPackageName;
  public String mPluginid;
  public long mRoomId;
  public String mScheme;
  public String mUserData;
  
  public IVPluginInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.mFromId = "";
    this.authType = 1;
  }
  
  public void copyTo(IVPluginInfo paramIVPluginInfo)
  {
    if (paramIVPluginInfo != null)
    {
      paramIVPluginInfo.mPluginid = this.mPluginid;
      paramIVPluginInfo.mLoginAppId = this.mLoginAppId;
      paramIVPluginInfo.mPackageName = this.mPackageName;
      paramIVPluginInfo.mRoomId = this.mRoomId;
      paramIVPluginInfo.mFromId = this.mFromId;
      paramIVPluginInfo.mScheme = this.mScheme;
      paramIVPluginInfo.mExtras = this.mExtras;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\intervideo\IVPluginInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.tencent.mobileqq.troop.data;

import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class TroopAIOAppInfo
  extends Entity
{
  @unique
  public int appid;
  public boolean canRemove;
  public String hashVal;
  public String iconUrl;
  public String minVersion;
  public String name;
  public boolean redPoint;
  public String url;
  
  public TroopAIOAppInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public TroopAIOAppInfo(TroopAIOAppInfo paramTroopAIOAppInfo)
  {
    if (paramTroopAIOAppInfo != null)
    {
      this.appid = paramTroopAIOAppInfo.appid;
      this.hashVal = paramTroopAIOAppInfo.hashVal;
      this.iconUrl = paramTroopAIOAppInfo.iconUrl;
      this.name = paramTroopAIOAppInfo.name;
      this.url = paramTroopAIOAppInfo.url;
      this.redPoint = paramTroopAIOAppInfo.redPoint;
      this.canRemove = paramTroopAIOAppInfo.canRemove;
      this.minVersion = paramTroopAIOAppInfo.minVersion;
    }
  }
  
  public static boolean checkVersion(String paramString)
  {
    return (paramString != null) && (paramString.matches("\\d+(\\.\\d+)*"));
  }
  
  public boolean isValidTroopApp()
  {
    return (this.appid > 0) && (!TextUtils.isEmpty(this.hashVal)) && (!TextUtils.isEmpty(this.iconUrl)) && (!TextUtils.isEmpty(this.name));
  }
  
  public String toString()
  {
    return "TroopAppInfo{appid=" + this.appid + ", hashVal='" + this.hashVal + '\'' + ", iconUrl='" + this.iconUrl + '\'' + ", name='" + this.name + '\'' + ", url='" + this.url + '\'' + ", redPoint=" + this.redPoint + ", canRemove=" + this.canRemove + ", minVersion='" + this.minVersion + '\'' + '}';
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\data\TroopAIOAppInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
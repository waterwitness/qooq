package com.tencent.apkupdate.logic.protocol.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class GetAppUpdateRequest
  extends JceStruct
{
  static ArrayList cache_appInfoForUpdateList;
  public ArrayList appInfoForUpdateList = null;
  public byte flag = 0;
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_appInfoForUpdateList == null)
    {
      cache_appInfoForUpdateList = new ArrayList();
      AppInfoForUpdate localAppInfoForUpdate = new AppInfoForUpdate();
      cache_appInfoForUpdateList.add(localAppInfoForUpdate);
    }
    this.appInfoForUpdateList = ((ArrayList)paramJceInputStream.read(cache_appInfoForUpdateList, 0, true));
    this.flag = paramJceInputStream.read(this.flag, 1, false);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.appInfoForUpdateList, 0);
    paramJceOutputStream.write(this.flag, 1);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\apkupdate\logic\protocol\jce\GetAppUpdateRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
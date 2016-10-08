package com.tencent.mobileqq.msf.sdk;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class NotifyRegisterInfo
  extends JceStruct
{
  static ArrayList cache_notifyIds;
  static Map cache_notifyProperties;
  public ArrayList notifyIds;
  public Map notifyProperties;
  public String uin = "";
  
  public NotifyRegisterInfo() {}
  
  public NotifyRegisterInfo(String paramString, ArrayList paramArrayList, Map paramMap)
  {
    this.uin = paramString;
    this.notifyIds = paramArrayList;
    this.notifyProperties = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.readString(1, true);
    if (cache_notifyIds == null)
    {
      cache_notifyIds = new ArrayList();
      cache_notifyIds.add(Long.valueOf(0L));
    }
    this.notifyIds = ((ArrayList)paramJceInputStream.read(cache_notifyIds, 2, true));
    if (cache_notifyProperties == null)
    {
      cache_notifyProperties = new HashMap();
      cache_notifyProperties.put(Long.valueOf(0L), "");
    }
    this.notifyProperties = ((Map)paramJceInputStream.read(cache_notifyProperties, 3, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 1);
    paramJceOutputStream.write(this.notifyIds, 2);
    paramJceOutputStream.write(this.notifyProperties, 3);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\msf\sdk\NotifyRegisterInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.tencent.mobileqq.highway.netprobe;

import android.text.TextUtils;

public class ProbeRequest
{
  private String ip;
  ProbeItem root;
  int trigglePoint;
  
  public ProbeRequest(String paramString, int paramInt, ProbeItem paramProbeItem)
  {
    this.ip = paramString;
    this.root = paramProbeItem;
    this.trigglePoint = paramInt;
  }
  
  public ProbeRequest(String paramString, ProbeItem paramProbeItem)
  {
    this(paramString, -1, paramProbeItem);
  }
  
  public String getIp()
  {
    return this.ip;
  }
  
  public String toString()
  {
    if (TextUtils.isEmpty(this.ip)) {
      return "unkonw";
    }
    return this.ip;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\highway\netprobe\ProbeRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
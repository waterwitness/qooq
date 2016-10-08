package com.tencent.mobileqq.highway.iplearning;

import android.os.SystemClock;

public class IpConnInfo
{
  public int iFailCount;
  public boolean isConnSucc;
  public boolean isSameIsp;
  public long lLastSuccTimeMills;
  public String mHost;
  public int mPort = 443;
  
  public IpConnInfo(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong)
  {
    this.isConnSucc = paramBoolean1;
    this.mHost = paramString;
    this.mPort = paramInt;
    this.lLastSuccTimeMills = paramLong;
    this.iFailCount = 0;
  }
  
  public void markAsFailOnceMore()
  {
    this.isConnSucc = false;
    this.iFailCount += 1;
  }
  
  public void markAsSucc()
  {
    this.isConnSucc = true;
    this.iFailCount = 0;
    this.lLastSuccTimeMills = SystemClock.uptimeMillis();
  }
  
  public String toString()
  {
    return "_IpConnInfo_ Host:" + this.mHost + " Succ:" + this.isConnSucc + " Fail:" + this.iFailCount + " Time:" + this.lLastSuccTimeMills;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\highway\iplearning\IpConnInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
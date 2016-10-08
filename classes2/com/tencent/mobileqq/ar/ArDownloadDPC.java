package com.tencent.mobileqq.ar;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ArDownloadDPC
{
  public static final int a = 9;
  public static final int b = 0;
  public static final int c = 3;
  public static final int d = 1000;
  public static final int e = 1;
  public static final int f = 1;
  public int g;
  public int h;
  public int i;
  public int j;
  public int k;
  
  public ArDownloadDPC()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.g = 0;
    this.h = 3;
    this.i = 1000;
    this.j = 1;
    this.k = 1;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("ArDownloadDPC{");
    localStringBuilder.append("networkControl=").append(this.g);
    localStringBuilder.append(", dailyRetryTimes=").append(this.h);
    localStringBuilder.append(", countRetryTimes=").append(this.i);
    localStringBuilder.append(", entranceControl=").append(this.j);
    localStringBuilder.append(", autoPreDownload=").append(this.k);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\ar\ArDownloadDPC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
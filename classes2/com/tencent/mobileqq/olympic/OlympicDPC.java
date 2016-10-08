package com.tencent.mobileqq.olympic;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class OlympicDPC
{
  public static final int a = 9;
  public static final int b = 512;
  public static final int c = 480;
  public static final int d = 720;
  public static final int e = 0;
  public static final int f = 3;
  public static final int g = 1000;
  public static final int h = 1;
  public static final int i = 1;
  public String a;
  public boolean a;
  public boolean b;
  public boolean c;
  public boolean d;
  public int j;
  public int k;
  public int l;
  public int m;
  public int n;
  
  public OlympicDPC()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.j = 0;
    this.k = 3;
    this.l = 1000;
    this.m = 1;
    this.n = 1;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("");
    localStringBuilder.append("allUseInSimple_2=").append(this.b).append(", bgUseInSimple_2=").append(this.c).append(", cfgUse_argb8888=").append(this.d).append(", networkControl=").append(this.j).append(", dailyRetryTimes=").append(this.k).append(", countRetryTimes=").append(this.l).append(", entranceControl=").append(this.m).append(", autoPreDownload=").append(this.n);
    return localStringBuilder.toString();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\olympic\OlympicDPC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
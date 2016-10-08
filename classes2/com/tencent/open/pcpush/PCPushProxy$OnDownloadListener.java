package com.tencent.open.pcpush;

import java.util.List;

public abstract interface PCPushProxy$OnDownloadListener
{
  public static final int a = 1;
  public static final int b = 2;
  public static final int c = 3;
  public static final int d = 4;
  public static final int e = 5;
  public static final int f = 6;
  public static final int g = 7;
  
  public abstract void a(int paramInt, String paramString);
  
  public abstract void a(PCPushProxy.PkgEntry paramPkgEntry, int paramInt1, String paramString, int paramInt2);
  
  public abstract void a(List paramList);
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\open\pcpush\PCPushProxy$OnDownloadListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
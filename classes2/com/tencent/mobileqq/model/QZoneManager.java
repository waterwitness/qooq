package com.tencent.mobileqq.model;

import mqq.manager.Manager;

public abstract interface QZoneManager
  extends Manager
{
  public static final int a = 1;
  public static final String a = "creditlevel";
  public static final int b = 2;
  public static final String b = "creditmessage";
  public static final int c = 3;
  public static final String c = "qzone_jinyan";
  public static final int d = 4;
  public static final String d = "qzone_preget_passive_open";
  public static final int e = 5;
  public static final String e = "qzone_passive_undealtime";
  public static final int f = 6;
  public static final String f = "qzone_passive_undeal_readtime";
  public static final int g = 7;
  public static final String g = "qzone_passive_need_refresh";
  public static final int h = 8;
  public static final int i = 32768;
  public static final int j = 7;
  
  public abstract int a();
  
  public abstract int a(int paramInt);
  
  public abstract String a();
  
  public abstract void a(int paramInt);
  
  public abstract void a(String paramString1, String paramString2);
  
  public abstract void a(boolean paramBoolean);
  
  public abstract boolean a();
  
  public abstract void b(int paramInt);
  
  public abstract void c(int paramInt);
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\model\QZoneManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
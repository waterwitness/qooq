package com.tencent.mobileqq.model;

import SecurityAccountServer.RespondQueryQQBindingStat;
import com.tencent.mobileqq.data.PhoneContact;
import friendlist.GetOnlineInfoResp;
import java.util.List;
import mqq.manager.Manager;

public abstract interface PhoneContactManager
  extends Manager
{
  public static final String b = "PhoneContact.Manager";
  public static final int i = -1;
  public static final int j = 0;
  public static final int k = 1;
  public static final int l = 2;
  public static final int m = 3;
  public static final int n = 4;
  public static final int o = 5;
  public static final int p = 6;
  public static final int q = 0;
  public static final int r = 1;
  public static final int s = 2;
  public static final int t = 3;
  public static final int u = 1;
  public static final int v = 2;
  public static final int w = 4;
  public static final int x = 8;
  
  public abstract RespondQueryQQBindingStat a();
  
  public abstract PhoneContact a(String paramString);
  
  public abstract String a(String paramString);
  
  public abstract List a();
  
  public abstract void a(PhoneContactManager.IPhoneContactListener paramIPhoneContactListener);
  
  public abstract void a(String paramString);
  
  public abstract void a(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract void a(String paramString, GetOnlineInfoResp paramGetOnlineInfoResp);
  
  public abstract void a(String paramString1, String paramString2);
  
  public abstract void a(String paramString1, String paramString2, int paramInt, boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract void a(String paramString, boolean paramBoolean);
  
  public abstract void a(byte[] paramArrayOfByte);
  
  public abstract boolean a(RespondQueryQQBindingStat paramRespondQueryQQBindingStat);
  
  public abstract PhoneContact b(String paramString);
  
  public abstract String b(String paramString);
  
  public abstract void b(PhoneContactManager.IPhoneContactListener paramIPhoneContactListener);
  
  public abstract void b(String paramString1, String paramString2);
  
  public abstract void b(String paramString1, String paramString2, int paramInt, boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract void b(List paramList);
  
  public abstract void b(boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract boolean b();
  
  public abstract PhoneContact c(String paramString);
  
  public abstract List c();
  
  public abstract void c(String paramString1, String paramString2);
  
  public abstract int d();
  
  public abstract List d();
  
  public abstract void d(String paramString1, String paramString2);
  
  public abstract List e();
  
  public abstract void e();
  
  public abstract void e(String paramString1, String paramString2);
  
  public abstract boolean e();
  
  public abstract List f();
  
  public abstract void f();
  
  public abstract List g();
  
  public abstract void i();
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\model\PhoneContactManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
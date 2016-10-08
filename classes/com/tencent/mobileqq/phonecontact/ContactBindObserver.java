package com.tencent.mobileqq.phonecontact;

import android.os.Bundle;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import mqq.observer.BusinessObserver;

public class ContactBindObserver
  implements BusinessObserver
{
  public static final int a = 0;
  public static final String a = "k_result";
  public static final int b = 1;
  public static final String b = "k_uin";
  public static final int c = 2;
  public static final String c = "k_buto_bind";
  public static final int d = 3;
  
  public ContactBindObserver()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private void e(boolean paramBoolean, int paramInt)
  {
    a(paramBoolean, paramInt);
    if (paramBoolean) {
      c(true, 7);
    }
  }
  
  protected String a(int paramInt)
  {
    if (paramInt == 217) {
      return "手机号码不正确，请确认！";
    }
    if ((paramInt == 219) || (paramInt == 216)) {
      return "请求频率太高，请稍后重试！";
    }
    if (paramInt == 224) {
      return "所属地区运营商暂未支持开通服务";
    }
    if (paramInt == 223) {
      return "绑定失败，请稍后再试";
    }
    return "请求失败，请稍候重试。";
  }
  
  protected void a(int paramInt1, int paramInt2) {}
  
  protected void a(boolean paramBoolean) {}
  
  protected void a(boolean paramBoolean, int paramInt) {}
  
  protected void a(boolean paramBoolean, Bundle paramBundle) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString) {}
  
  public void b(boolean paramBoolean) {}
  
  protected void b(boolean paramBoolean, int paramInt) {}
  
  protected void b(boolean paramBoolean, Bundle paramBundle) {}
  
  protected void b(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void c(boolean paramBoolean) {}
  
  protected void c(boolean paramBoolean, int paramInt) {}
  
  protected void d(boolean paramBoolean) {}
  
  protected void d(boolean paramBoolean, int paramInt) {}
  
  protected void e(boolean paramBoolean) {}
  
  protected void f(boolean paramBoolean) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    int k = 0;
    int i = 0;
    int m = 0;
    int n = 0;
    int j = 0;
    switch (paramInt)
    {
    default: 
      return;
    case 12: 
      if (paramBoolean)
      {
        if (paramBundle.getBoolean("bind_state"))
        {
          a(true, true);
          return;
        }
        a(true, false);
        return;
      }
      a(false, false);
      return;
    case 35: 
      a(paramBoolean, paramBundle);
      return;
    case 14: 
      paramInt = j;
      if (paramBundle != null) {
        paramInt = paramBundle.getInt("param_fail_reason", 0);
      }
      a(paramBoolean, paramInt);
      return;
    case 15: 
      paramInt = k;
      if (paramBundle != null) {
        paramInt = paramBundle.getInt("param_fail_reason", 0);
      }
      d(paramBoolean, paramInt);
      return;
    case 28: 
      paramInt = i;
      if (paramBundle != null)
      {
        paramInt = i;
        if (paramBundle.getBoolean("hasUpdate")) {
          paramInt = 1;
        }
      }
      c(paramBoolean, paramInt);
      return;
    case 16: 
      if (paramBundle != null) {}
      for (paramInt = paramBundle.getInt("k_result");; paramInt = -1)
      {
        b(paramBoolean, paramInt);
        return;
      }
    case 17: 
      e(paramBoolean);
      return;
    case 19: 
      b(paramBoolean, paramBundle);
      return;
    case 20: 
      b(paramBoolean);
      return;
    case 23: 
      f(paramBoolean);
      return;
    case 26: 
      a(paramBoolean, paramBundle.getBoolean("bindOK"), paramBundle.getBoolean("hadBind"), paramBundle.getString("bindUin"));
      return;
    case 27: 
      b(paramBoolean, paramBundle.getBoolean("bind_state", false));
      return;
    case 31: 
      paramInt = m;
      if (paramBundle != null) {
        paramInt = paramBundle.getInt("param_fail_reason", 0);
      }
      e(paramBoolean, paramInt);
      return;
    case 30: 
      paramInt = n;
      if (paramBoolean) {
        paramInt = paramBundle.getInt("param_update_flag");
      }
      c(paramBoolean, paramInt);
      return;
    case 100: 
      a(paramBundle.getInt("current_percentage"), paramBundle.getInt("expected_percentage"));
      return;
    case 32: 
      d(paramBoolean);
      return;
    case 33: 
      c(paramBoolean);
      return;
    }
    a(paramBoolean);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\phonecontact\ContactBindObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
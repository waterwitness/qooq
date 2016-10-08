package com.tencent.mobileqq.config;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ConfigListener
{
  public ConfigListener()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a() {}
  
  public void a(boolean paramBoolean, short paramShort, int paramInt, String paramString) {}
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\config\ConfigListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
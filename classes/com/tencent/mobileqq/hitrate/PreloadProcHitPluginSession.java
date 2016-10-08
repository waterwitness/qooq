package com.tencent.mobileqq.hitrate;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class PreloadProcHitPluginSession
  extends PreloadProcHitSession
{
  public String a;
  
  public PreloadProcHitPluginSession(String paramString1, String paramString2, String paramString3)
  {
    super("plugin", paramString1, paramString2);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = "";
    this.a = paramString3;
  }
  
  @Deprecated
  public void a()
  {
    super.a();
  }
  
  @Deprecated
  public void b()
  {
    super.b();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\hitrate\PreloadProcHitPluginSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
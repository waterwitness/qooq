package com.tencent.mobileqq.hitrate;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class PreloadProcHitPluginSessionProc
  extends PreloadProcHitSession
{
  public PreloadProcHitPluginSessionProc(String paramString)
  {
    super("proc", "QPPHR_" + paramString, paramString);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\hitrate\PreloadProcHitPluginSessionProc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
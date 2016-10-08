package com.tencent.av.opengl.shader;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public abstract class ShaderParameter
{
  public int a;
  protected final String a;
  
  public ShaderParameter(String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = paramString;
  }
  
  public abstract void a(int paramInt);
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\opengl\shader\ShaderParameter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
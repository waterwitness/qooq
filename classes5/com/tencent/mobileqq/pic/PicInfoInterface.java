package com.tencent.mobileqq.pic;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class PicInfoInterface
  implements LoggerInterface
{
  public PicInfoInterface.ErrInfo a;
  
  public PicInfoInterface()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (this.a == null) {
      this.a = new PicInfoInterface.ErrInfo();
    }
    this.a.a = paramString1;
    this.a.b = paramString2;
  }
  
  protected boolean a()
  {
    return false;
  }
  
  public String toLogString()
  {
    return null;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\pic\PicInfoInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
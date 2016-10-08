package com.tencent.mobileqq.shortvideo;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.pic.LoggerInterface;
import com.tencent.mobileqq.pic.PicInfoInterface.ErrInfo;

public class ShortVideoInfoInterface
  implements LoggerInterface
{
  protected PicInfoInterface.ErrInfo a;
  
  public ShortVideoInfoInterface()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(String paramString1, String paramString2)
  {
    if (this.a == null) {
      this.a = new PicInfoInterface.ErrInfo();
    }
    this.a.a = paramString1;
    this.a.b = paramString2;
    Logger.b(this, paramString1, paramString2);
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


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\shortvideo\ShortVideoInfoInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
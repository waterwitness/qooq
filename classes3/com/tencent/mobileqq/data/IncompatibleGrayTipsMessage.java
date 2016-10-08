package com.tencent.mobileqq.data;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.Serializable;

public class IncompatibleGrayTipsMessage
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  public int linkEnd;
  public int linkStart;
  public String msg;
  public String url;
  
  public IncompatibleGrayTipsMessage()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\data\IncompatibleGrayTipsMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
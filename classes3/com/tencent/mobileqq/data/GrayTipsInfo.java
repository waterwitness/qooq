package com.tencent.mobileqq.data;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.Serializable;
import java.util.ArrayList;

public class GrayTipsInfo
  implements Serializable
{
  public ArrayList spans;
  public String text;
  
  public GrayTipsInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\data\GrayTipsInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
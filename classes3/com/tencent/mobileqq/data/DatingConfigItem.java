package com.tencent.mobileqq.data;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.Serializable;

public class DatingConfigItem
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  public String contentStr;
  public int id;
  
  public DatingConfigItem(int paramInt, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.id = paramInt;
    this.contentStr = paramString;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\data\DatingConfigItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
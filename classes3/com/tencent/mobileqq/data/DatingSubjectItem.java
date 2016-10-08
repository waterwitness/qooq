package com.tencent.mobileqq.data;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.Serializable;

public class DatingSubjectItem
  implements Serializable
{
  public int deadline;
  public String errMsg;
  public int id;
  public String name;
  
  public DatingSubjectItem(int paramInt1, String paramString1, int paramInt2, String paramString2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.id = paramInt1;
    this.name = paramString1;
    this.deadline = paramInt2;
    this.errMsg = paramString2;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\data\DatingSubjectItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.tencent.mobileqq.data;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.Serializable;

public class HWTroopMemberCard
  implements Serializable
{
  public static final long HW_GROUP_CLASS_EXT_ID = 32L;
  public static final int IDENTITY_PARENTS = 2;
  public static final int IDENTITY_STUDENT = 3;
  public static final int IDENTITY_TEACHER = 1;
  public static final int IDENTITY_UNKNOW = 0;
  private static final long serialVersionUID = 1L;
  public int identity;
  
  public HWTroopMemberCard()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.identity = 0;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\data\HWTroopMemberCard.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
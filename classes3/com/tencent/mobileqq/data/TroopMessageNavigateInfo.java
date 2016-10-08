package com.tencent.mobileqq.data;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.Entity;

public class TroopMessageNavigateInfo
  extends Entity
{
  public static int STATUS_ADD;
  public static int STATUS_DELETE = 3;
  public static int STATUS_MODIFY;
  public static int STATUS_NORMAL;
  public long msgseq;
  public int receivedFlowserCount;
  public int status = STATUS_NORMAL;
  public String summary;
  public String troopCode;
  public int type;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    STATUS_ADD = 1;
    STATUS_MODIFY = 2;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\data\TroopMessageNavigateInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
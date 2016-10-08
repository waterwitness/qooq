package com.tencent.mobileqq.troop.utils;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public abstract class TroopFileTransferManager$Task
  implements Runnable
{
  public static final int a = 0;
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 3;
  public static final int e = 4;
  public TroopFileTransferManager.Item a;
  public boolean a;
  public boolean b;
  public int f;
  
  protected TroopFileTransferManager$Task(TroopFileTransferManager paramTroopFileTransferManager, TroopFileTransferManager.Item paramItem, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item = paramItem;
    this.f = paramInt;
    paramTroopFileTransferManager.a[paramInt].a(this);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\utils\TroopFileTransferManager$Task.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
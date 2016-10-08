package com.tencent.mobileqq.troop.data;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.Comparator;

public class TroopFileInfo$UploadTimeComparator
  implements Comparator
{
  public TroopFileInfo$UploadTimeComparator()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int a(TroopFileInfo paramTroopFileInfo1, TroopFileInfo paramTroopFileInfo2)
  {
    if (paramTroopFileInfo1.b < paramTroopFileInfo2.b) {
      return 1;
    }
    if (paramTroopFileInfo1.b == paramTroopFileInfo2.b) {
      return 0;
    }
    return -1;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\data\TroopFileInfo$UploadTimeComparator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
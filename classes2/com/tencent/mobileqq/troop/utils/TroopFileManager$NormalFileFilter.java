package com.tencent.mobileqq.troop.utils;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.data.TroopFileInfo;

public class TroopFileManager$NormalFileFilter
  implements TroopFileManager.Filter
{
  public TroopFileManager$NormalFileFilter()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean a(TroopFileInfo paramTroopFileInfo)
  {
    if (paramTroopFileInfo.b) {
      return false;
    }
    switch (paramTroopFileInfo.e)
    {
    }
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\utils\TroopFileManager$NormalFileFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
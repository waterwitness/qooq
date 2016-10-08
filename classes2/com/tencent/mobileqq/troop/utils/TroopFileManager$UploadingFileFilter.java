package com.tencent.mobileqq.troop.utils;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.data.TroopFileInfo;

public class TroopFileManager$UploadingFileFilter
  implements TroopFileManager.Filter
{
  public TroopFileManager$UploadingFileFilter()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean a(TroopFileInfo paramTroopFileInfo)
  {
    switch (paramTroopFileInfo.e)
    {
    default: 
      return false;
    }
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\utils\TroopFileManager$UploadingFileFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.tencent.mobileqq.troop.utils;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.Observable;

public class TroopGiftManager$DownloadGiftResStateObservable
  extends Observable
{
  private static DownloadGiftResStateObservable a;
  
  private TroopGiftManager$DownloadGiftResStateObservable()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static DownloadGiftResStateObservable a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new DownloadGiftResStateObservable();
      }
      return a;
    }
    finally {}
  }
  
  public void setChanged()
  {
    super.setChanged();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\utils\TroopGiftManager$DownloadGiftResStateObservable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
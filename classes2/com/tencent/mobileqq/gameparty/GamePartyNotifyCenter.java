package com.tencent.mobileqq.gameparty;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.Observable;

public class GamePartyNotifyCenter
  extends Observable
{
  public static final int a = 1;
  public static final int b = 2;
  public static final int c = 3;
  
  public GamePartyNotifyCenter()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void setChanged()
  {
    super.setChanged();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\gameparty\GamePartyNotifyCenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
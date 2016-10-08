package com.tencent.litetransfersdk;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class NFCInfo
{
  public int dwServerIP;
  public byte[] vTokenKey;
  public byte[] vUrlNotify;
  public short wServerPort;
  
  public NFCInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\litetransfersdk\NFCInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
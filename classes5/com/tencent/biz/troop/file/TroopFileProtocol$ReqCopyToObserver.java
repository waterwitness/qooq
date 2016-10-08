package com.tencent.biz.troop.file;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt32Field;
import tencent.im.cs.cmd0x383.cmd0x383.RspBody;

public abstract class TroopFileProtocol$ReqCopyToObserver
  extends ProtoUtils.TroopProtocolObserver
{
  public TroopFileProtocol$ReqCopyToObserver()
  {
    super(false);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (paramInt != 0)
    {
      a(false, null, paramBundle);
      return;
    }
    cmd0x383.RspBody localRspBody = new cmd0x383.RspBody();
    try
    {
      localRspBody.mergeFrom(paramArrayOfByte);
      if (localRspBody.int32_ret_code.has())
      {
        a(true, localRspBody, paramBundle);
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      a(false, localRspBody, paramBundle);
      return;
    }
    a(false, localRspBody, paramBundle);
  }
  
  public abstract void a(boolean paramBoolean, cmd0x383.RspBody paramRspBody, Bundle paramBundle);
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\troop\file\TroopFileProtocol$ReqCopyToObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
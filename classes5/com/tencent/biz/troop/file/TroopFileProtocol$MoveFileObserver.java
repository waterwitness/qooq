package com.tencent.biz.troop.file;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import tencent.im.oidb.cmd0x6d6.oidb_0x6d6.MoveFileRspBody;
import tencent.im.oidb.cmd0x6d6.oidb_0x6d6.RspBody;

public abstract class TroopFileProtocol$MoveFileObserver
  extends ProtoUtils.TroopProtocolObserver
{
  public TroopFileProtocol$MoveFileObserver()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (paramInt != 0)
    {
      a(false, paramInt, null);
      return;
    }
    paramBundle = new oidb_0x6d6.RspBody();
    try
    {
      paramBundle.mergeFrom(paramArrayOfByte);
      paramArrayOfByte = (oidb_0x6d6.MoveFileRspBody)paramBundle.move_file_rsp.get();
      if (!paramArrayOfByte.int32_ret_code.has()) {
        break label94;
      }
      if (paramArrayOfByte.int32_ret_code.get() == 0)
      {
        a(true, 0, paramArrayOfByte.str_parent_folder_id.get());
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      a(false, -1, null);
      return;
    }
    a(false, paramArrayOfByte.int32_ret_code.get(), null);
    return;
    label94:
    a(false, -1, null);
  }
  
  protected abstract void a(boolean paramBoolean, int paramInt, String paramString);
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\troop\file\TroopFileProtocol$MoveFileObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
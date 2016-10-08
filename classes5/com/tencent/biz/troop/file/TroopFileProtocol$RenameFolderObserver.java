package com.tencent.biz.troop.file;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt32Field;
import tencent.im.oidb.cmd0x6d7.oidb_0x6d7.RenameFolderRspBody;
import tencent.im.oidb.cmd0x6d7.oidb_0x6d7.RspBody;

public abstract class TroopFileProtocol$RenameFolderObserver
  extends ProtoUtils.TroopProtocolObserver
{
  public TroopFileProtocol$RenameFolderObserver()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    String str;
    if (paramBundle != null) {
      str = paramBundle.getString("folderId");
    }
    for (paramBundle = paramBundle.getString("folderName");; paramBundle = "")
    {
      if (paramInt != 0)
      {
        a(false, paramInt, str, paramBundle);
        return;
      }
      oidb_0x6d7.RspBody localRspBody = new oidb_0x6d7.RspBody();
      try
      {
        localRspBody.mergeFrom(paramArrayOfByte);
        paramArrayOfByte = (oidb_0x6d7.RenameFolderRspBody)localRspBody.rename_folder_rsp.get();
        if (!paramArrayOfByte.int32_ret_code.has()) {
          break label118;
        }
        if (paramArrayOfByte.int32_ret_code.get() == 0)
        {
          a(true, 0, str, paramBundle);
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        a(false, -1, str, paramBundle);
        return;
      }
      a(false, paramArrayOfByte.int32_ret_code.get(), str, paramBundle);
      return;
      label118:
      a(false, -1, str, paramBundle);
      return;
      str = "";
    }
  }
  
  protected abstract void a(boolean paramBoolean, int paramInt, String paramString1, String paramString2);
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\troop\file\TroopFileProtocol$RenameFolderObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
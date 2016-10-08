package com.tencent.mobileqq.troop.utils;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.mp.mobileqq_mp.FollowResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;

public abstract class TroopBindPubAccountProtocol$FollowPublicAccountObserver
  extends ProtoUtils.TroopProtocolObserver
{
  public TroopBindPubAccountProtocol$FollowPublicAccountObserver()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    boolean bool2 = false;
    mobileqq_mp.FollowResponse localFollowResponse;
    if (paramInt == 0) {
      localFollowResponse = new mobileqq_mp.FollowResponse();
    }
    for (;;)
    {
      try
      {
        localFollowResponse.mergeFrom(paramArrayOfByte);
        if (!((mobileqq_mp.RetInfo)localFollowResponse.ret_info.get()).ret_code.has()) {
          break label146;
        }
        paramInt = ((mobileqq_mp.RetInfo)localFollowResponse.ret_info.get()).ret_code.get();
        if (paramInt != 0) {
          break label146;
        }
        bool1 = true;
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        bool1 = bool2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("TroopBindPubAccountProtocol", 2, paramArrayOfByte.toString());
        bool1 = bool2;
        continue;
      }
      a(bool1, paramBundle);
      return;
      boolean bool1 = bool2;
      if (QLog.isColorLevel())
      {
        QLog.i("TroopBindPubAccountProtocol", 2, "follow pubAccount failed, errorCode=" + paramInt);
        bool1 = bool2;
        continue;
        label146:
        bool1 = false;
      }
    }
  }
  
  protected abstract void a(boolean paramBoolean, Bundle paramBundle);
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\utils\TroopBindPubAccountProtocol$FollowPublicAccountObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
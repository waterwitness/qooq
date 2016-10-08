package com.tencent.mobileqq.app;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import tencent.im.ilive.photo.NowLiveGallary.RspBody;

public abstract class CardHandler$NowOnliveGallayCallback
  extends ProtoUtils.TroopProtocolObserver
{
  public CardHandler$NowOnliveGallayCallback()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public abstract void a(int paramInt, List paramList);
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (paramArrayOfByte == null) {
      a(-1, null);
    }
    do
    {
      return;
      try
      {
        paramBundle = new NowLiveGallary.RspBody();
        paramBundle.mergeFrom(paramArrayOfByte);
        paramArrayOfByte = paramBundle.photo_info_list.get();
        a(paramBundle.errCode.get(), paramArrayOfByte);
        return;
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte) {}
    } while (!QLog.isColorLevel());
    QLog.d("CardHandler", 2, "getNowOnliveGallary exception, e:" + paramArrayOfByte.getStackTrace());
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\app\CardHandler$NowOnliveGallayCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
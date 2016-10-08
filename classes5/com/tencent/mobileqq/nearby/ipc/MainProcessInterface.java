package com.tencent.mobileqq.nearby.ipc;

import android.os.IInterface;
import android.os.Message;

public abstract interface MainProcessInterface
  extends IInterface
{
  public abstract Message a(Message paramMessage);
  
  public abstract BasicTypeDataParcel a(BasicTypeDataParcel paramBasicTypeDataParcel);
  
  public abstract void a(NearbyProcessInterface paramNearbyProcessInterface);
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\nearby\ipc\MainProcessInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
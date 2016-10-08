package com.tencent.assistant.sdk.remote;

import android.os.IBinder;
import android.os.Parcel;

class SDKActionCallback$Stub$Proxy
  implements SDKActionCallback
{
  private IBinder mRemote;
  
  SDKActionCallback$Stub$Proxy(IBinder paramIBinder)
  {
    this.mRemote = paramIBinder;
  }
  
  public IBinder asBinder()
  {
    return this.mRemote;
  }
  
  public String getInterfaceDescriptor()
  {
    return "com.tencent.assistant.sdk.remote.SDKActionCallback";
  }
  
  public void onActionResult(byte[] paramArrayOfByte)
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.tencent.assistant.sdk.remote.SDKActionCallback");
      localParcel.writeByteArray(paramArrayOfByte);
      this.mRemote.transact(1, localParcel, null, 1);
      return;
    }
    finally
    {
      localParcel.recycle();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\assistant\sdk\remote\SDKActionCallback$Stub$Proxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
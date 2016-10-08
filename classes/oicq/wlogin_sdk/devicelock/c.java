package oicq.wlogin_sdk.devicelock;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class c
  implements Parcelable.Creator<DevlockInfo>
{
  public DevlockInfo a(Parcel paramParcel)
  {
    return new DevlockInfo(paramParcel, null);
  }
  
  public DevlockInfo[] a(int paramInt)
  {
    return new DevlockInfo[paramInt];
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\oicq\wlogin_sdk\devicelock\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
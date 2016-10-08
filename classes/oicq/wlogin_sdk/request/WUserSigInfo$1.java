package oicq.wlogin_sdk.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class WUserSigInfo$1
  implements Parcelable.Creator<WUserSigInfo>
{
  public WUserSigInfo createFromParcel(Parcel paramParcel)
  {
    return new WUserSigInfo(paramParcel, null);
  }
  
  public WUserSigInfo[] newArray(int paramInt)
  {
    return new WUserSigInfo[paramInt];
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\oicq\wlogin_sdk\request\WUserSigInfo$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
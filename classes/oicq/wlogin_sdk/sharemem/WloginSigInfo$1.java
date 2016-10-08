package oicq.wlogin_sdk.sharemem;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class WloginSigInfo$1
  implements Parcelable.Creator<WloginSigInfo>
{
  public WloginSigInfo createFromParcel(Parcel paramParcel)
  {
    return new WloginSigInfo(paramParcel, null);
  }
  
  public WloginSigInfo[] newArray(int paramInt)
  {
    return new WloginSigInfo[paramInt];
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\oicq\wlogin_sdk\sharemem\WloginSigInfo$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package oicq.wlogin_sdk.sharemem;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class WloginSimpleInfo$1
  implements Parcelable.Creator<WloginSimpleInfo>
{
  public WloginSimpleInfo createFromParcel(Parcel paramParcel)
  {
    return new WloginSimpleInfo(paramParcel, null);
  }
  
  public WloginSimpleInfo[] newArray(int paramInt)
  {
    return new WloginSimpleInfo[paramInt];
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\oicq\wlogin_sdk\sharemem\WloginSimpleInfo$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
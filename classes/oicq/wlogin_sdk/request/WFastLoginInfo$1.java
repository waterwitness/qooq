package oicq.wlogin_sdk.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class WFastLoginInfo$1
  implements Parcelable.Creator<WFastLoginInfo>
{
  public WFastLoginInfo createFromParcel(Parcel paramParcel)
  {
    return new WFastLoginInfo(paramParcel, null);
  }
  
  public WFastLoginInfo[] newArray(int paramInt)
  {
    return new WFastLoginInfo[paramInt];
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\oicq\wlogin_sdk\request\WFastLoginInfo$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
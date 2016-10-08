package oicq.wlogin_sdk.sharemem;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class a
  implements Parcelable.Creator<WloginLoginInfo>
{
  public WloginLoginInfo a(Parcel paramParcel)
  {
    return new WloginLoginInfo(paramParcel, null);
  }
  
  public WloginLoginInfo[] a(int paramInt)
  {
    return new WloginLoginInfo[paramInt];
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\oicq\wlogin_sdk\sharemem\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
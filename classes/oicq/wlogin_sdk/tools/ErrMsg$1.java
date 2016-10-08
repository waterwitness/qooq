package oicq.wlogin_sdk.tools;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class ErrMsg$1
  implements Parcelable.Creator<ErrMsg>
{
  public ErrMsg createFromParcel(Parcel paramParcel)
  {
    return new ErrMsg(paramParcel, null);
  }
  
  public ErrMsg[] newArray(int paramInt)
  {
    return new ErrMsg[paramInt];
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\oicq\wlogin_sdk\tools\ErrMsg$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
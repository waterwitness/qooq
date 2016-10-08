package eipc;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class EIPCResult$1
  implements Parcelable.Creator
{
  public EIPCResult createFromParcel(Parcel paramParcel)
  {
    return new EIPCResult(paramParcel, null);
  }
  
  public EIPCResult[] newArray(int paramInt)
  {
    return new EIPCResult[paramInt];
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\eipc\EIPCResult$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.tencent.qphone.base.remote;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class ToServiceMsg$1
  implements Parcelable.Creator
{
  public ToServiceMsg createFromParcel(Parcel paramParcel)
  {
    return new ToServiceMsg(paramParcel);
  }
  
  public ToServiceMsg[] newArray(int paramInt)
  {
    return new ToServiceMsg[paramInt];
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\qphone\base\remote\ToServiceMsg$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
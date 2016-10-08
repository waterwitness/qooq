package com.tencent.qphone.base.remote;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class FromServiceMsg$1
  implements Parcelable.Creator
{
  public FromServiceMsg createFromParcel(Parcel paramParcel)
  {
    return new FromServiceMsg(paramParcel);
  }
  
  public FromServiceMsg[] newArray(int paramInt)
  {
    return new FromServiceMsg[paramInt];
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\qphone\base\remote\FromServiceMsg$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
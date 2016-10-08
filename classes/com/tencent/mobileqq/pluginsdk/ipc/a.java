package com.tencent.mobileqq.pluginsdk.ipc;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class a
  implements Parcelable.Creator
{
  public ParcelableBinder a(Parcel paramParcel)
  {
    return new ParcelableBinder(paramParcel, null);
  }
  
  public ParcelableBinder[] a(int paramInt)
  {
    return new ParcelableBinder[paramInt];
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\pluginsdk\ipc\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
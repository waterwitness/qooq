package com.tencent.tmdownloader.internal.notification;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class g
  implements Parcelable.Creator<NotifyParam>
{
  public NotifyParam a(Parcel paramParcel)
  {
    return new NotifyParam(paramParcel);
  }
  
  public NotifyParam[] a(int paramInt)
  {
    return new NotifyParam[paramInt];
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\tmdownloader\internal\notification\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
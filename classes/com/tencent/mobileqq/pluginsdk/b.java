package com.tencent.mobileqq.pluginsdk;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class b
  implements Parcelable.Creator
{
  public PluginBaseInfo a(Parcel paramParcel)
  {
    return new PluginBaseInfo(paramParcel);
  }
  
  public PluginBaseInfo[] a(int paramInt)
  {
    return new PluginBaseInfo[paramInt];
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\pluginsdk\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
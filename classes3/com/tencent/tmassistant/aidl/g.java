package com.tencent.tmassistant.aidl;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class g
  implements Parcelable.Creator<TMAssistantDownloadLogInfo>
{
  public TMAssistantDownloadLogInfo a(Parcel paramParcel)
  {
    return new TMAssistantDownloadLogInfo(paramParcel.readString(), paramParcel.readLong(), paramParcel.readString(), paramParcel.readString(), paramParcel.readString());
  }
  
  public TMAssistantDownloadLogInfo[] a(int paramInt)
  {
    return new TMAssistantDownloadLogInfo[paramInt];
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\tmassistant\aidl\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
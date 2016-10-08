package com.tencent.component.network.downloader.common;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class IPInfo$1
  implements Parcelable.Creator<IPInfo>
{
  public IPInfo createFromParcel(Parcel paramParcel)
  {
    return new IPInfo(paramParcel);
  }
  
  public IPInfo[] newArray(int paramInt)
  {
    return new IPInfo[paramInt];
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\component\network\downloader\common\IPInfo$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
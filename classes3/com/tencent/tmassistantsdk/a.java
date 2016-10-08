package com.tencent.tmassistantsdk;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class a
  implements Parcelable.Creator<TMAssistantCallYYBTaskInfo>
{
  public TMAssistantCallYYBTaskInfo a(Parcel paramParcel)
  {
    return new TMAssistantCallYYBTaskInfo(paramParcel.readString(), paramParcel.readString(), paramParcel.readInt(), paramParcel.readLong(), paramParcel.readLong(), paramParcel.readString());
  }
  
  public TMAssistantCallYYBTaskInfo[] a(int paramInt)
  {
    return new TMAssistantCallYYBTaskInfo[paramInt];
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\tmassistantsdk\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.tencent.tmassistantsdk;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class TMAssistantCallYYBTaskInfo
  implements Parcelable
{
  public static final Parcelable.Creator<TMAssistantCallYYBTaskInfo> CREATOR = new a();
  public String mContentType;
  public long mReceiveDataLen;
  public String mSavePath;
  public int mState;
  public long mTotalDataLen;
  public String mUrl;
  
  public TMAssistantCallYYBTaskInfo(String paramString1, String paramString2, int paramInt, long paramLong1, long paramLong2, String paramString3)
  {
    this.mUrl = paramString1;
    this.mSavePath = paramString2;
    this.mState = paramInt;
    this.mReceiveDataLen = paramLong1;
    this.mTotalDataLen = paramLong2;
    this.mContentType = paramString3;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (this.mUrl != null)
    {
      paramParcel.writeString(this.mUrl);
      if (this.mSavePath == null) {
        break label72;
      }
      paramParcel.writeString(this.mSavePath);
    }
    for (;;)
    {
      paramParcel.writeInt(this.mState);
      paramParcel.writeLong(this.mReceiveDataLen);
      paramParcel.writeLong(this.mTotalDataLen);
      paramParcel.writeString(this.mContentType);
      return;
      paramParcel.writeString("");
      break;
      label72:
      paramParcel.writeString("");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\tmassistantsdk\TMAssistantCallYYBTaskInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
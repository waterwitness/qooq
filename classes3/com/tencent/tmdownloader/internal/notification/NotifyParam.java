package com.tencent.tmdownloader.internal.notification;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class NotifyParam
  implements Parcelable
{
  public static final Parcelable.Creator<NotifyParam> CREATOR = new g();
  public String content = "";
  public String nKey;
  public int notificationTypeId;
  public String title = "";
  public String url = "";
  
  public NotifyParam() {}
  
  public NotifyParam(Parcel paramParcel)
  {
    this.url = paramParcel.readString();
    this.title = paramParcel.readString();
    this.content = paramParcel.readString();
    this.nKey = paramParcel.readString();
    this.notificationTypeId = paramParcel.readInt();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.url);
    paramParcel.writeString(this.title);
    paramParcel.writeString(this.content);
    paramParcel.writeString(this.nKey);
    paramParcel.writeInt(this.notificationTypeId);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\tmdownloader\internal\notification\NotifyParam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
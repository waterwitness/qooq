package com.tencent.av.service;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import gmv;

public class AVPbInfo
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new gmv();
  public String bindId;
  public int bindIdType;
  public String phoneNum;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public AVPbInfo() {}
  
  public AVPbInfo(Parcel paramParcel)
  {
    this.bindId = paramParcel.readString();
    this.bindIdType = paramParcel.readInt();
    this.phoneNum = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.bindId);
    paramParcel.writeInt(this.bindIdType);
    paramParcel.writeString(this.phoneNum);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\service\AVPbInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
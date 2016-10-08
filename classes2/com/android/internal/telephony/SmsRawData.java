package com.android.internal.telephony;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import c;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class SmsRawData
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new c();
  byte[] a;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public SmsRawData(byte[] paramArrayOfByte)
  {
    this.a = paramArrayOfByte;
  }
  
  public byte[] a()
  {
    return this.a;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.a.length);
    paramParcel.writeByteArray(this.a);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\android\internal\telephony\SmsRawData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
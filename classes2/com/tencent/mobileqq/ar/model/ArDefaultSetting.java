package com.tencent.mobileqq.ar.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import qps;

public class ArDefaultSetting
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new qps();
  public static final int a = 0;
  public static final int b = 1;
  public String a;
  public int c;
  public int d;
  public int e;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public ArDefaultSetting() {}
  
  public ArDefaultSetting(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.c = paramParcel.readInt();
    this.d = paramParcel.readInt();
    this.e = paramParcel.readInt();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "ArDefaultSetting{key='" + this.a + '\'' + ", type=" + this.c + ", modelLevel=" + this.d + ", traceLevel=" + this.e + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeInt(this.c);
    paramParcel.writeInt(this.d);
    paramParcel.writeInt(this.e);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\ar\model\ArDefaultSetting.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
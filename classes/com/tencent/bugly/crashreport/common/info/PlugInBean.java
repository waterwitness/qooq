package com.tencent.bugly.crashreport.common.info;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class PlugInBean
  implements Parcelable
{
  public static final Parcelable.Creator<PlugInBean> CREATOR = new Parcelable.Creator() {};
  public final String a;
  public final String b;
  public final String c;
  
  public PlugInBean(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
  }
  
  public PlugInBean(String paramString1, String paramString2, String paramString3)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "plid:" + this.a + " plV:" + this.b + " plUUID:" + this.c;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\bugly\crashreport\common\info\PlugInBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
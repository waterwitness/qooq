package com.tencent.mobileqq.ar.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import qpt;

public class ArResourceInfo
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new qpt();
  public static final int a = 0;
  public static final int b = 1;
  public long a;
  public String a;
  public String b;
  public int c;
  public String c;
  public String d;
  public String e;
  public String f;
  public String g;
  public String h;
  public String i;
  public String j;
  public String k;
  public String l;
  public String m;
  public String n;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public ArResourceInfo() {}
  
  public ArResourceInfo(Parcel paramParcel)
  {
    this.jdField_c_of_type_Int = paramParcel.readInt();
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.b = paramParcel.readString();
    this.jdField_c_of_type_JavaLangString = paramParcel.readString();
    this.d = paramParcel.readString();
    this.e = paramParcel.readString();
    this.jdField_a_of_type_Long = paramParcel.readLong();
    this.f = paramParcel.readString();
    this.g = paramParcel.readString();
    this.h = paramParcel.readString();
    this.i = paramParcel.readString();
    this.j = paramParcel.readString();
    this.k = paramParcel.readString();
    this.l = paramParcel.readString();
    this.m = paramParcel.readString();
    this.n = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("ArResourceInfo{");
    localStringBuffer.append("type=").append(this.jdField_c_of_type_Int);
    localStringBuffer.append(", fileId='").append(this.jdField_a_of_type_JavaLangString).append('\'');
    localStringBuffer.append(", picId='").append(this.jdField_c_of_type_JavaLangString).append('\'');
    localStringBuffer.append(", url='").append(this.d).append('\'');
    localStringBuffer.append(", md5='").append(this.e).append('\'');
    localStringBuffer.append(", size=").append(this.jdField_a_of_type_Long);
    localStringBuffer.append(", modelConfigFile='").append(this.f).append('\'');
    localStringBuffer.append(", commonBgMusic='").append(this.h).append('\'');
    localStringBuffer.append(", fileName='").append(this.n).append('\'');
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.jdField_c_of_type_Int);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.jdField_c_of_type_JavaLangString);
    paramParcel.writeString(this.d);
    paramParcel.writeString(this.e);
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeString(this.f);
    paramParcel.writeString(this.g);
    paramParcel.writeString(this.h);
    paramParcel.writeString(this.i);
    paramParcel.writeString(this.j);
    paramParcel.writeString(this.k);
    paramParcel.writeString(this.l);
    paramParcel.writeString(this.m);
    paramParcel.writeString(this.n);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\ar\model\ArResourceInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
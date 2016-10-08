package com.tencent.device.utils;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;
import java.util.HashMap;
import kdy;

public class LightAppSettingInfo
  implements Parcelable, Cloneable
{
  public static final Parcelable.Creator CREATOR = new kdy();
  public static final int a = 0;
  public static final int b = 1;
  public static final int c = 2;
  public long a;
  public String a;
  public ArrayList a;
  public HashMap a;
  public String b;
  public String c;
  public int d;
  public String d;
  public int e;
  public String e;
  public int f;
  public String f;
  public int g;
  public String g;
  public int h;
  public String h;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public Object clone()
  {
    return super.clone();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int hashCode()
  {
    if (this.jdField_a_of_type_Long != 0L) {
      return Long.valueOf(this.jdField_a_of_type_Long).hashCode();
    }
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.jdField_d_of_type_Int);
    paramParcel.writeInt(this.jdField_e_of_type_Int);
    paramParcel.writeInt(this.jdField_f_of_type_Int);
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeList(this.jdField_a_of_type_JavaUtilArrayList);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.b);
    paramParcel.writeInt(this.jdField_g_of_type_Int);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.jdField_d_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_e_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_f_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_g_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_h_of_type_Int);
    paramParcel.writeMap(this.jdField_a_of_type_JavaUtilHashMap);
    paramParcel.writeString(this.jdField_h_of_type_JavaLangString);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\device\utils\LightAppSettingInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
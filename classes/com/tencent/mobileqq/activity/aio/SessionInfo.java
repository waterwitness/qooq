package com.tencent.mobileqq.activity.aio;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import neg;

public class SessionInfo
  implements Parcelable, Cloneable
{
  public static final Parcelable.Creator CREATOR = new neg();
  public int a;
  public long a;
  public ChatBackground a;
  public String a;
  public int b;
  public String b;
  public int c = 0;
  public String c;
  public int d;
  public String d;
  public String e;
  public String f;
  public String g = "";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public SessionInfo()
  {
    this.jdField_a_of_type_Long = -1L;
    this.jdField_d_of_type_Int = 10004;
  }
  
  public SessionInfo(Parcel paramParcel)
  {
    this.jdField_a_of_type_Long = -1L;
    this.jdField_d_of_type_Int = 10004;
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.b = paramParcel.readString();
    this.jdField_d_of_type_JavaLangString = paramParcel.readString();
    this.e = paramParcel.readString();
    this.jdField_d_of_type_Int = paramParcel.readInt();
  }
  
  public Object clone()
  {
    return super.clone();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.jdField_d_of_type_JavaLangString);
    paramParcel.writeString(this.e);
    paramParcel.writeInt(this.jdField_d_of_type_Int);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\aio\SessionInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
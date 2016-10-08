package com.tencent.biz.qqstory.takevideo.publish;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import iym;

public class PublishParam
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new iym();
  public static final String a;
  public final int a;
  public final long a;
  public final int b;
  public final String b;
  public final String c;
  public final String d;
  public final String e;
  public final String f;
  public final String g;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = PublishParam.class.getName();
  }
  
  public PublishParam(Parcel paramParcel)
  {
    this.jdField_b_of_type_JavaLangString = paramParcel.readString();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    this.e = paramParcel.readString();
    this.f = paramParcel.readString();
    this.g = paramParcel.readString();
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_b_of_type_Int = paramParcel.readInt();
    this.jdField_a_of_type_Long = paramParcel.readLong();
    paramParcel = a();
    if (paramParcel != null) {
      throw new RuntimeException(paramParcel);
    }
  }
  
  public PublishParam(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt1, int paramInt2, long paramLong)
  {
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.c = paramString2;
    this.d = paramString3;
    this.e = paramString4;
    this.f = paramString5;
    this.g = paramString6;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_Long = paramLong;
    paramString1 = a();
    if (paramString1 != null) {
      throw new RuntimeException(paramString1);
    }
  }
  
  protected String a()
  {
    if ((TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) || (TextUtils.isEmpty(this.c))) {
      return "both fakeVid and thumbPath should not be empty";
    }
    if ((this.jdField_a_of_type_Int <= 0) || (this.jdField_b_of_type_Int <= 0)) {
      return "both videoWidth and videoHeight should not be less than 0";
    }
    return null;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "PublishParam{fakeVid='" + this.jdField_b_of_type_JavaLangString + '\'' + ", thumbPath='" + this.c + '\'' + ", doodlePath='" + this.d + '\'' + ", videoLabel='" + this.e + '\'' + ", videoDoodleDescription='" + this.f + '\'' + ", videoAddress='" + this.g + '\'' + ", videoWidth=" + this.jdField_a_of_type_Int + ", videoHeight=" + this.jdField_b_of_type_Int + ", videoDuration=" + this.jdField_a_of_type_Long + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeString(this.e);
    paramParcel.writeString(this.f);
    paramParcel.writeString(this.g);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeInt(this.jdField_b_of_type_Int);
    paramParcel.writeLong(this.jdField_a_of_type_Long);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\takevideo\publish\PublishParam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
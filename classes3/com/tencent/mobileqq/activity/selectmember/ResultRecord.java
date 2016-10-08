package com.tencent.mobileqq.activity.selectmember;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import pgu;

public class ResultRecord
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new pgu();
  public int a;
  public String a;
  public String b;
  public String c;
  public String d;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public ResultRecord() {}
  
  private ResultRecord(Parcel paramParcel)
  {
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.b = paramParcel.readString();
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof ResultRecord))
    {
      paramObject = (ResultRecord)paramObject;
      if ((((ResultRecord)paramObject).jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_JavaLangString)) && (((ResultRecord)paramObject).jdField_a_of_type_Int == this.jdField_a_of_type_Int) && (((!TextUtils.isEmpty(this.d)) && (!TextUtils.isEmpty(((ResultRecord)paramObject).d)) && (this.d.equals(((ResultRecord)paramObject).d))) || ((TextUtils.isEmpty(this.d)) && (TextUtils.isEmpty(((ResultRecord)paramObject).d))))) {
        return true;
      }
    }
    return false;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[uin:").append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(", name:").append(this.b);
    localStringBuilder.append(", type:").append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", groupUin:").append(this.c);
    localStringBuilder.append(", phone:").append(this.d).append("]");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.b);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\selectmember\ResultRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.tencent.open.agent.datamodel;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import wry;

public class Friend
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new wry();
  public int a;
  public String a;
  public int b;
  public String b;
  public int c;
  public String c;
  public String d;
  public String e;
  public String f;
  public String g;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public Friend()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
    this.d = "";
    this.jdField_b_of_type_Int = -1;
    this.jdField_c_of_type_Int = -1;
    this.f = "";
    this.g = "";
  }
  
  public Friend(Friend paramFriend)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = paramFriend.jdField_a_of_type_JavaLangString;
    this.jdField_b_of_type_JavaLangString = paramFriend.jdField_b_of_type_JavaLangString;
    this.jdField_c_of_type_JavaLangString = paramFriend.jdField_c_of_type_JavaLangString;
    this.d = paramFriend.d;
    this.jdField_b_of_type_Int = paramFriend.jdField_b_of_type_Int;
    this.jdField_c_of_type_Int = paramFriend.jdField_c_of_type_Int;
    this.f = paramFriend.f;
    this.g = paramFriend.g;
    this.jdField_a_of_type_Int = paramFriend.jdField_a_of_type_Int;
    this.e = paramFriend.e;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      do
      {
        return false;
        if (paramObject == this) {
          return true;
        }
      } while (paramObject.getClass() != getClass());
      paramObject = (Friend)paramObject;
    } while (this.jdField_a_of_type_JavaLangString == null);
    return this.jdField_a_of_type_JavaLangString.equals(((Friend)paramObject).jdField_a_of_type_JavaLangString);
  }
  
  public int hashCode()
  {
    if (this.jdField_a_of_type_JavaLangString != null) {
      return this.jdField_a_of_type_JavaLangString.hashCode();
    }
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_c_of_type_JavaLangString);
    paramParcel.writeString(this.d);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeString(this.e);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\open\agent\datamodel\Friend.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
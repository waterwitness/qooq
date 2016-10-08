package com.tencent.mobileqq.activity;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import mwe;

public class TroopMemberListActivity$TroopAdmin
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new mwe();
  public String a;
  public short a;
  public String b;
  public String c;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public TroopMemberListActivity$TroopAdmin() {}
  
  private TroopMemberListActivity$TroopAdmin(Parcel paramParcel)
  {
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_a_of_type_Short = ((short)paramParcel.readInt());
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_a_of_type_Short);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\TroopMemberListActivity$TroopAdmin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
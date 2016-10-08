package com.tencent.biz.pubaccount.util;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import iex;

public class ProfileParams
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new iex();
  public static final String a = "profile_params";
  int jdField_a_of_type_Int;
  ProfileParams.CurLoginUsr jdField_a_of_type_ComTencentBizPubaccountUtilProfileParams$CurLoginUsr;
  String b;
  String c;
  String d;
  String e;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public ProfileParams.CurLoginUsr a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountUtilProfileParams$CurLoginUsr;
  }
  
  public String a()
  {
    return this.c;
  }
  
  public String b()
  {
    return this.d;
  }
  
  public String c()
  {
    return this.b;
  }
  
  public String d()
  {
    return this.e;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String e()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountUtilProfileParams$CurLoginUsr != null) {
      return this.jdField_a_of_type_ComTencentBizPubaccountUtilProfileParams$CurLoginUsr.a;
    }
    return null;
  }
  
  public String f()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountUtilProfileParams$CurLoginUsr != null) {
      return this.jdField_a_of_type_ComTencentBizPubaccountUtilProfileParams$CurLoginUsr.b;
    }
    return null;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.b);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeString(this.e);
    paramParcel.writeParcelable(this.jdField_a_of_type_ComTencentBizPubaccountUtilProfileParams$CurLoginUsr, paramInt);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\util\ProfileParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.tencent.mobileqq.util;

import AvatarInfo.QQHeadInfo;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import vyl;

public class HeadRequest
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new vyl();
  public int a;
  public QQHeadInfo a;
  public String a;
  public int b;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(Parcel paramParcel)
  {
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.b = paramParcel.readInt();
    this.jdField_a_of_type_AvatarInfoQQHeadInfo = ((QQHeadInfo)paramParcel.readParcelable(getClass().getClassLoader()));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeInt(this.b);
    paramParcel.writeParcelable(this.jdField_a_of_type_AvatarInfoQQHeadInfo, 0);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\util\HeadRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
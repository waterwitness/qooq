package com.tencent.mobileqq.redtouch;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;
import java.util.List;
import uez;

public class RedDisplayInfo
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new uez();
  private RedTypeInfo a;
  public ArrayList a;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public RedTypeInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTypeInfo;
  }
  
  public List a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a(RedTypeInfo paramRedTypeInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTypeInfo = paramRedTypeInfo;
  }
  
  public void a(ArrayList paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeList(this.jdField_a_of_type_JavaUtilArrayList);
    paramParcel.writeSerializable(this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTypeInfo);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\redtouch\RedDisplayInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
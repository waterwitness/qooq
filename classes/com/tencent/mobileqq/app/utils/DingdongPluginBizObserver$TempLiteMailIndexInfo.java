package com.tencent.mobileqq.app.utils;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import qoi;

public class DingdongPluginBizObserver$TempLiteMailIndexInfo
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new qoi();
  public int a;
  public long a;
  public String a;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeLong(this.jdField_a_of_type_Long);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\utils\DingdongPluginBizObserver$TempLiteMailIndexInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
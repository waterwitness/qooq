package com.tencent.mobileqq.nearby.ipc;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import tkb;

public class BasicTypeDataParcel
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new tkb();
  public int a;
  public Object[] a;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public BasicTypeDataParcel(int paramInt, Object... paramVarArgs)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ArrayOfJavaLangObject = paramVarArgs;
  }
  
  public BasicTypeDataParcel(Parcel paramParcel)
  {
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_a_of_type_ArrayOfJavaLangObject = paramParcel.readArray(Object.class.getClassLoader());
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("--------------------start-------------------");
    localStringBuilder.append("\n");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append("\n");
    if (this.jdField_a_of_type_ArrayOfJavaLangObject != null)
    {
      int i = 0;
      while (i < this.jdField_a_of_type_ArrayOfJavaLangObject.length)
      {
        localStringBuilder.append(this.jdField_a_of_type_ArrayOfJavaLangObject[i]);
        localStringBuilder.append("\n");
        i += 1;
      }
    }
    localStringBuilder.append("--------------------end-------------------");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeArray(this.jdField_a_of_type_ArrayOfJavaLangObject);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\nearby\ipc\BasicTypeDataParcel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
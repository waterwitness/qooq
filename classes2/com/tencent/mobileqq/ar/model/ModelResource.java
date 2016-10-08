package com.tencent.mobileqq.ar.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.HashMap;
import qpu;

public class ModelResource
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new qpu();
  public int a;
  public long a;
  public String a;
  public HashMap a;
  public boolean a;
  public String b;
  public String c;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public ModelResource()
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public ModelResource(Parcel paramParcel)
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.b = paramParcel.readString();
    this.jdField_a_of_type_Long = paramParcel.readLong();
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      this.c = paramParcel.readString();
      this.jdField_a_of_type_JavaUtilHashMap = paramParcel.readHashMap(getClass().getClassLoader());
      return;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("ModelResource{");
    localStringBuffer.append("type=").append(this.jdField_a_of_type_Int);
    localStringBuffer.append(", modelUrl='").append(this.jdField_a_of_type_JavaLangString).append('\'');
    localStringBuffer.append(", modelMd5='").append(this.b).append('\'');
    localStringBuffer.append(", fileSize=").append(this.jdField_a_of_type_Long);
    localStringBuffer.append(", reqModel=").append(this.jdField_a_of_type_Boolean);
    localStringBuffer.append(", zipFileName='").append(this.c).append('\'');
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.b);
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    if (this.jdField_a_of_type_Boolean) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeString(this.c);
      paramParcel.writeMap(this.jdField_a_of_type_JavaUtilHashMap);
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\ar\model\ModelResource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.tencent.av.service;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import gnt;
import java.util.ArrayList;
import java.util.List;

public class RecvGVideoLevelInfo
  implements Parcelable, Cloneable, Comparable
{
  public static final Parcelable.Creator CREATOR = new gnt();
  static String a;
  public int a;
  public long a;
  public List a;
  public int b;
  public long b;
  public String b;
  public int c;
  public int d;
  public int e;
  public int f;
  public int g;
  public int h;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = "RecvGVideoLevelInfo";
  }
  
  public RecvGVideoLevelInfo(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, String paramString, List paramList)
  {
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.c = paramInt3;
    this.d = paramInt4;
    this.e = paramInt5;
    this.f = paramInt6;
    this.g = paramInt7;
    this.h = paramInt8;
    this.jdField_b_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public RecvGVideoLevelInfo(Parcel paramParcel)
  {
    a(paramParcel);
  }
  
  public int a()
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0)) {}
    for (;;)
    {
      return 0;
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        RecvGVideoLevelInfo.Medal localMedal = (RecvGVideoLevelInfo.Medal)this.jdField_a_of_type_JavaUtilList.get(i);
        if (localMedal.c == 1) {
          return localMedal.jdField_b_of_type_Int;
        }
        i += 1;
      }
    }
  }
  
  public int a(RecvGVideoLevelInfo paramRecvGVideoLevelInfo)
  {
    int i = a();
    int j = paramRecvGVideoLevelInfo.a();
    if (i != j) {
      return i - j;
    }
    if (this.h != paramRecvGVideoLevelInfo.h) {
      return this.h - paramRecvGVideoLevelInfo.h;
    }
    return 0;
  }
  
  public void a(Parcel paramParcel)
  {
    try
    {
      this.jdField_a_of_type_Long = paramParcel.readLong();
      this.jdField_a_of_type_Int = paramParcel.readInt();
      this.jdField_b_of_type_Int = paramParcel.readInt();
      this.c = paramParcel.readInt();
      this.d = paramParcel.readInt();
      this.e = paramParcel.readInt();
      this.f = paramParcel.readInt();
      this.g = paramParcel.readInt();
      this.h = paramParcel.readInt();
      this.jdField_b_of_type_JavaLangString = paramParcel.readString();
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
      paramParcel.readTypedList(this.jdField_a_of_type_JavaUtilList, RecvGVideoLevelInfo.Medal.CREATOR);
      return;
    }
    catch (RuntimeException paramParcel)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d(jdField_a_of_type_JavaLangString, 2, "readFromParcel RuntimeException", paramParcel);
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    try
    {
      paramParcel.writeLong(this.jdField_a_of_type_Long);
      paramParcel.writeInt(this.jdField_a_of_type_Int);
      paramParcel.writeInt(this.jdField_b_of_type_Int);
      paramParcel.writeInt(this.c);
      paramParcel.writeInt(this.d);
      paramParcel.writeInt(this.e);
      paramParcel.writeInt(this.f);
      paramParcel.writeInt(this.g);
      paramParcel.writeInt(this.h);
      paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
      paramParcel.writeTypedList(this.jdField_a_of_type_JavaUtilList);
      return;
    }
    catch (RuntimeException paramParcel)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d(jdField_a_of_type_JavaLangString, 2, "writeToParcel RuntimeException", paramParcel);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\service\RecvGVideoLevelInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.tencent.av.service;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.SpannableString;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import gnv;

public class RecvMsg
  implements Parcelable, Cloneable
{
  public static final Parcelable.Creator CREATOR = new gnv();
  static String jdField_a_of_type_JavaLangString;
  public static final int g = 1;
  public static final int h = 2;
  public static final int i = 3;
  int jdField_a_of_type_Int;
  public long a;
  SpannableString jdField_a_of_type_AndroidTextSpannableString;
  public Object a;
  public boolean a;
  public int b;
  String b;
  public boolean b;
  public int c;
  String c;
  public int d;
  String d;
  public int e;
  String e;
  public int f;
  String f;
  public String g;
  public String h;
  String i;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = "RecvMsg";
  }
  
  public RecvMsg()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_c_of_type_JavaLangString = null;
    this.jdField_d_of_type_JavaLangString = null;
    this.jdField_e_of_type_JavaLangString = null;
    this.jdField_f_of_type_JavaLangString = null;
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = 0;
    this.jdField_a_of_type_Long = 0L;
    this.i = "";
  }
  
  public RecvMsg(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2, int paramInt3, int paramInt4, long paramLong)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_c_of_type_JavaLangString = paramString1;
    this.jdField_d_of_type_JavaLangString = paramString2;
    this.jdField_e_of_type_JavaLangString = paramString3;
    this.jdField_f_of_type_JavaLangString = paramString4;
    this.jdField_b_of_type_JavaLangString = paramString5;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_c_of_type_Int = paramInt3;
    this.jdField_d_of_type_Int = paramInt4;
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public RecvMsg(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2, int paramInt3, int paramInt4, long paramLong, String paramString6)
  {
    this(paramInt1, paramString1, paramString2, paramString3, paramString4, paramString5, paramInt2, paramInt3, paramInt4, paramLong);
    this.i = paramString6;
  }
  
  public RecvMsg(Parcel paramParcel)
  {
    a(paramParcel);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public SpannableString a()
  {
    return this.jdField_a_of_type_AndroidTextSpannableString;
  }
  
  public String a()
  {
    return this.jdField_c_of_type_JavaLangString;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(Parcel paramParcel)
  {
    try
    {
      this.jdField_a_of_type_Int = paramParcel.readInt();
      this.jdField_c_of_type_JavaLangString = paramParcel.readString();
      this.jdField_d_of_type_JavaLangString = paramParcel.readString();
      this.jdField_e_of_type_JavaLangString = paramParcel.readString();
      this.jdField_f_of_type_JavaLangString = paramParcel.readString();
      this.jdField_b_of_type_JavaLangString = paramParcel.readString();
      this.jdField_b_of_type_Int = paramParcel.readInt();
      this.jdField_c_of_type_Int = paramParcel.readInt();
      this.jdField_d_of_type_Int = paramParcel.readInt();
      this.jdField_a_of_type_Long = paramParcel.readLong();
      this.i = paramParcel.readString();
      this.jdField_e_of_type_Int = paramParcel.readInt();
      this.jdField_f_of_type_Int = paramParcel.readInt();
      return;
    }
    catch (RuntimeException paramParcel)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d(jdField_a_of_type_JavaLangString, 2, "readFromParcel RuntimeException", paramParcel);
    }
  }
  
  public void a(SpannableString paramSpannableString)
  {
    this.jdField_a_of_type_AndroidTextSpannableString = paramSpannableString;
  }
  
  public void a(String paramString)
  {
    this.jdField_c_of_type_JavaLangString = paramString;
  }
  
  public String b()
  {
    return this.jdField_e_of_type_JavaLangString;
  }
  
  public void b(String paramString)
  {
    this.jdField_e_of_type_JavaLangString = paramString;
  }
  
  public String c()
  {
    return this.jdField_f_of_type_JavaLangString;
  }
  
  public void c(String paramString)
  {
    this.jdField_f_of_type_JavaLangString = paramString;
  }
  
  public String d()
  {
    return this.jdField_d_of_type_JavaLangString;
  }
  
  public void d(String paramString)
  {
    this.jdField_d_of_type_JavaLangString = paramString;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String e()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public void e(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public String f()
  {
    return this.i;
  }
  
  public void f(String paramString)
  {
    this.i = paramString;
  }
  
  public String toString()
  {
    return jdField_a_of_type_JavaLangString + ", mVipBubbleId:" + this.jdField_a_of_type_Int + ", mAccountUin:" + this.jdField_c_of_type_JavaLangString + ", mFriendUin:" + this.jdField_d_of_type_JavaLangString + ", mSenderUin:" + this.jdField_e_of_type_JavaLangString + ", mSenderName:" + this.jdField_f_of_type_JavaLangString + ", mMsg:" + this.jdField_b_of_type_JavaLangString + ", msgType:" + this.jdField_e_of_type_Int;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    try
    {
      paramParcel.writeInt(this.jdField_a_of_type_Int);
      paramParcel.writeString(this.jdField_c_of_type_JavaLangString);
      paramParcel.writeString(this.jdField_d_of_type_JavaLangString);
      paramParcel.writeString(this.jdField_e_of_type_JavaLangString);
      paramParcel.writeString(this.jdField_f_of_type_JavaLangString);
      paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
      paramParcel.writeInt(this.jdField_b_of_type_Int);
      paramParcel.writeInt(this.jdField_c_of_type_Int);
      paramParcel.writeInt(this.jdField_d_of_type_Int);
      paramParcel.writeLong(this.jdField_a_of_type_Long);
      paramParcel.writeString(this.i);
      paramParcel.writeInt(this.jdField_e_of_type_Int);
      paramParcel.writeInt(this.jdField_f_of_type_Int);
      return;
    }
    catch (RuntimeException paramParcel)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d(jdField_a_of_type_JavaLangString, 2, "writeToParcel RuntimeException", paramParcel);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\service\RecvMsg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
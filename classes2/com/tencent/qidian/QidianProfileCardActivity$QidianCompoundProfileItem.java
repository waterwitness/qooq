package com.tencent.qidian;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import wza;

public class QidianProfileCardActivity$QidianCompoundProfileItem
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new wza();
  public static final int a = 0;
  public static final int b = 1;
  public static final int c = 3;
  public String a;
  public boolean a;
  public String b;
  public boolean b;
  public String c;
  public int d;
  public String d;
  public String e;
  
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
    int i = 1;
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeString(this.c);
    if (this.jdField_a_of_type_Boolean)
    {
      paramInt = 1;
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeInt(this.jdField_d_of_type_Int);
      if (!this.jdField_b_of_type_Boolean) {
        break label86;
      }
    }
    label86:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeString(this.jdField_d_of_type_JavaLangString);
      paramParcel.writeString(this.e);
      return;
      paramInt = 0;
      break;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\qidian\QidianProfileCardActivity$QidianCompoundProfileItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
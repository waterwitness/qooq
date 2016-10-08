package com.tencent.mobileqq.activity.photo;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import oqx;

public class ImageInfo
  extends BaseImageInfo
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new oqx();
  public long a;
  public Uri a;
  public MessageForPic a;
  public long b;
  public int c;
  public long c;
  public int d;
  public long d;
  public String d;
  public int e;
  public long e;
  public String e;
  public int f;
  public String f;
  public boolean f;
  public int g;
  public String g;
  public boolean g;
  public int h;
  public String h;
  public boolean h;
  public int i;
  public String i;
  public boolean i;
  public int j;
  public String j;
  public boolean j;
  public int k;
  public String k;
  public boolean k;
  public int l;
  public String l;
  public boolean l;
  public int m;
  public String m;
  public boolean m;
  public int n;
  public String n;
  public boolean n;
  public int o;
  public boolean o;
  public boolean p;
  public boolean q;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public ImageInfo()
  {
    this.jdField_a_of_type_Long = -1L;
    this.jdField_h_of_type_Boolean = true;
    this.jdField_f_of_type_Int = 54;
    this.jdField_h_of_type_Int = -1;
    this.jdField_l_of_type_Boolean = true;
    this.jdField_o_of_type_Int = 2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i1 = 1;
    if (this.jdField_a_of_type_Boolean)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      if (!this.jdField_b_of_type_Boolean) {
        break label362;
      }
      paramInt = 1;
      label25:
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
      if (!this.jdField_c_of_type_Boolean) {
        break label367;
      }
      paramInt = 1;
      label47:
      paramParcel.writeInt(paramInt);
      if (!this.jdField_d_of_type_Boolean) {
        break label372;
      }
      paramInt = 1;
      label61:
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
      paramParcel.writeString(this.jdField_c_of_type_JavaLangString);
      paramParcel.writeInt(this.jdField_a_of_type_Int);
      if (!this.jdField_e_of_type_Boolean) {
        break label377;
      }
      paramInt = 1;
      label99:
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.jdField_d_of_type_JavaLangString);
      paramParcel.writeInt(this.jdField_c_of_type_Int);
      paramParcel.writeString(this.jdField_e_of_type_JavaLangString);
      paramParcel.writeInt(this.jdField_d_of_type_Int);
      paramParcel.writeInt(this.jdField_e_of_type_Int);
      if (!this.jdField_f_of_type_Boolean) {
        break label382;
      }
      paramInt = 1;
      label153:
      paramParcel.writeInt(paramInt);
      paramParcel.writeLong(this.jdField_a_of_type_Long);
      if (!this.jdField_h_of_type_Boolean) {
        break label387;
      }
      paramInt = 1;
      label175:
      paramParcel.writeInt(paramInt);
      if (!this.jdField_i_of_type_Boolean) {
        break label392;
      }
      paramInt = 1;
      label189:
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.jdField_f_of_type_JavaLangString);
      paramParcel.writeLong(this.jdField_b_of_type_Long);
      paramParcel.writeString(this.g);
      paramParcel.writeLong(this.jdField_c_of_type_Long);
      paramParcel.writeString(this.jdField_h_of_type_JavaLangString);
      paramParcel.writeInt(this.jdField_h_of_type_Int);
      paramParcel.writeInt(this.jdField_i_of_type_Int);
      paramParcel.writeInt(this.jdField_j_of_type_Int);
      paramParcel.writeString(this.jdField_j_of_type_JavaLangString);
      paramParcel.writeInt(this.jdField_m_of_type_Int);
      if (!this.jdField_o_of_type_Boolean) {
        break label397;
      }
      paramInt = 1;
      label283:
      paramParcel.writeInt(paramInt);
      if (!this.n) {
        break label402;
      }
      paramInt = 1;
      label297:
      paramParcel.writeInt(paramInt);
      if (!this.q) {
        break label407;
      }
    }
    label362:
    label367:
    label372:
    label377:
    label382:
    label387:
    label392:
    label397:
    label402:
    label407:
    for (paramInt = i1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeLong(this.jdField_e_of_type_Long);
      paramParcel.writeString(this.k);
      paramParcel.writeString(this.jdField_l_of_type_JavaLangString);
      paramParcel.writeString(this.jdField_m_of_type_JavaLangString);
      paramParcel.writeInt(this.jdField_o_of_type_Int);
      return;
      paramInt = 0;
      break;
      paramInt = 0;
      break label25;
      paramInt = 0;
      break label47;
      paramInt = 0;
      break label61;
      paramInt = 0;
      break label99;
      paramInt = 0;
      break label153;
      paramInt = 0;
      break label175;
      paramInt = 0;
      break label189;
      paramInt = 0;
      break label283;
      paramInt = 0;
      break label297;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\photo\ImageInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
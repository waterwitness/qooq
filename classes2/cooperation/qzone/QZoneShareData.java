package cooperation.qzone;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;
import yky;

public class QZoneShareData
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new yky();
  public static final int a = 0;
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 0;
  public static final int e = 1;
  public long a;
  public String a;
  public ArrayList a;
  public String b;
  public String c;
  public String d;
  public String e;
  public int f;
  public String f;
  public int g;
  public String g;
  public int h;
  public String h;
  public String i;
  public String j;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public QZoneShareData() {}
  
  private QZoneShareData(Parcel paramParcel)
  {
    this.jdField_a_of_type_Long = paramParcel.readLong();
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    paramParcel.readStringList(this.jdField_a_of_type_JavaUtilArrayList);
    this.e = paramParcel.readString();
    this.jdField_f_of_type_JavaLangString = paramParcel.readString();
    this.jdField_g_of_type_JavaLangString = paramParcel.readString();
    this.jdField_f_of_type_Int = paramParcel.readInt();
    this.jdField_g_of_type_Int = paramParcel.readInt();
    this.jdField_h_of_type_JavaLangString = paramParcel.readString();
    this.i = paramParcel.readString();
    this.jdField_h_of_type_Int = paramParcel.readInt();
    this.j = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "appid:" + this.jdField_a_of_type_Long + " openId:" + this.jdField_a_of_type_JavaLangString + " mTitle:" + this.b + " mSummary:" + this.c + " targetUrl:" + this.d + " mImageUrl:" + this.jdField_a_of_type_JavaUtilArrayList.toString() + " appName:" + this.e + " shareUin:" + this.jdField_f_of_type_JavaLangString + " extString:" + this.jdField_g_of_type_JavaLangString + " from:" + this.jdField_g_of_type_Int + " action:" + this.jdField_h_of_type_JavaLangString + " pkgname:" + this.i;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeStringList(this.jdField_a_of_type_JavaUtilArrayList);
    paramParcel.writeString(this.e);
    paramParcel.writeString(this.jdField_f_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_g_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_f_of_type_Int);
    paramParcel.writeInt(this.jdField_g_of_type_Int);
    paramParcel.writeString(this.jdField_h_of_type_JavaLangString);
    paramParcel.writeString(this.i);
    paramParcel.writeInt(this.jdField_h_of_type_Int);
    paramParcel.writeString(this.j);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\QZoneShareData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
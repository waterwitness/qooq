package cooperation.qzone.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.HashMap;
import java.util.Map;
import ymr;

public class PhotoParam
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new ymr();
  public static final int a = 4;
  public long a;
  public String a;
  public Map a;
  public boolean a;
  public int b;
  public long b;
  public String b;
  public boolean b;
  public int c;
  public long c;
  public String c;
  public boolean c;
  public int d;
  public long d;
  public String d;
  public boolean d;
  public int e;
  public String e;
  public boolean e;
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
  public int j;
  public String j;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public PhotoParam()
  {
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_e_of_type_JavaLangString = "";
    this.jdField_f_of_type_JavaLangString = "";
    this.jdField_g_of_type_JavaLangString = "";
    this.jdField_h_of_type_JavaLangString = "";
    this.jdField_i_of_type_Int = 4;
    this.jdField_i_of_type_JavaLangString = "";
    this.jdField_b_of_type_Boolean = true;
    this.jdField_j_of_type_Int = -1;
    this.jdField_j_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int k = 1;
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeLong(this.jdField_b_of_type_Long);
    paramParcel.writeLong(this.jdField_c_of_type_Long);
    paramParcel.writeLong(this.jdField_d_of_type_Long);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_b_of_type_Int);
    paramParcel.writeInt(this.jdField_c_of_type_Int);
    paramParcel.writeInt(this.jdField_d_of_type_Int);
    paramParcel.writeInt(this.jdField_e_of_type_Int);
    paramParcel.writeInt(this.jdField_f_of_type_Int);
    paramParcel.writeString(this.jdField_c_of_type_JavaLangString);
    if (this.jdField_a_of_type_Boolean)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.jdField_g_of_type_Int);
      paramParcel.writeInt(this.jdField_h_of_type_Int);
      paramParcel.writeString(this.jdField_d_of_type_JavaLangString);
      paramParcel.writeString(this.jdField_e_of_type_JavaLangString);
      paramParcel.writeString(this.jdField_f_of_type_JavaLangString);
      paramParcel.writeString(this.jdField_g_of_type_JavaLangString);
      paramParcel.writeString(this.jdField_h_of_type_JavaLangString);
      paramParcel.writeInt(this.jdField_i_of_type_Int);
      paramParcel.writeMap(this.jdField_a_of_type_JavaUtilMap);
      paramParcel.writeString(this.jdField_i_of_type_JavaLangString);
      if (!this.jdField_b_of_type_Boolean) {
        break label312;
      }
      paramInt = 1;
      label201:
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.jdField_j_of_type_Int);
      if (!this.jdField_c_of_type_Boolean) {
        break label317;
      }
      paramInt = 1;
      label223:
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.jdField_j_of_type_JavaLangString);
      if (!this.jdField_d_of_type_Boolean) {
        break label322;
      }
      paramInt = 1;
      label245:
      paramParcel.writeInt(paramInt);
      if (!this.jdField_e_of_type_Boolean) {
        break label327;
      }
      paramInt = 1;
      label259:
      paramParcel.writeInt(paramInt);
      if (!this.jdField_f_of_type_Boolean) {
        break label332;
      }
      paramInt = 1;
      label273:
      paramParcel.writeInt(paramInt);
      if (!this.jdField_g_of_type_Boolean) {
        break label337;
      }
      paramInt = 1;
      label287:
      paramParcel.writeInt(paramInt);
      if (!this.jdField_h_of_type_Boolean) {
        break label342;
      }
    }
    label312:
    label317:
    label322:
    label327:
    label332:
    label337:
    label342:
    for (paramInt = k;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      return;
      paramInt = 0;
      break;
      paramInt = 0;
      break label201;
      paramInt = 0;
      break label223;
      paramInt = 0;
      break label245;
      paramInt = 0;
      break label259;
      paramInt = 0;
      break label273;
      paramInt = 0;
      break label287;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\model\PhotoParam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
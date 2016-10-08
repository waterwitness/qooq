package cooperation.qzone;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import yke;

public class LbsDataV2$PoiInfo
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new yke();
  public int a;
  public LbsDataV2.GpsInfo a;
  public String a;
  public int b;
  public String b;
  public int c;
  public String c;
  public int d;
  public String d;
  public int e;
  public String e;
  public int f;
  public String f;
  public int g;
  public String g;
  public String h = "";
  public String i = "";
  public String j = "";
  public String k = "";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public LbsDataV2$PoiInfo()
  {
    this.jdField_f_of_type_JavaLangString = "";
    this.jdField_g_of_type_JavaLangString = "";
    this.jdField_a_of_type_CooperationQzoneLbsDataV2$GpsInfo = new LbsDataV2.GpsInfo();
  }
  
  public static PoiInfo a(PoiInfo paramPoiInfo)
  {
    LbsDataV2.GpsInfo localGpsInfo = null;
    if (paramPoiInfo == null) {
      return null;
    }
    PoiInfo localPoiInfo = new PoiInfo();
    localPoiInfo.jdField_e_of_type_JavaLangString = paramPoiInfo.jdField_e_of_type_JavaLangString;
    localPoiInfo.jdField_g_of_type_JavaLangString = paramPoiInfo.jdField_g_of_type_JavaLangString;
    localPoiInfo.jdField_c_of_type_Int = paramPoiInfo.jdField_c_of_type_Int;
    localPoiInfo.jdField_b_of_type_Int = paramPoiInfo.jdField_b_of_type_Int;
    if (paramPoiInfo.jdField_a_of_type_CooperationQzoneLbsDataV2$GpsInfo != null) {
      localGpsInfo = paramPoiInfo.jdField_a_of_type_CooperationQzoneLbsDataV2$GpsInfo.a();
    }
    localPoiInfo.jdField_a_of_type_CooperationQzoneLbsDataV2$GpsInfo = localGpsInfo;
    localPoiInfo.jdField_d_of_type_Int = paramPoiInfo.jdField_d_of_type_Int;
    localPoiInfo.jdField_f_of_type_JavaLangString = paramPoiInfo.jdField_f_of_type_JavaLangString;
    localPoiInfo.jdField_d_of_type_JavaLangString = paramPoiInfo.jdField_d_of_type_JavaLangString;
    localPoiInfo.jdField_a_of_type_JavaLangString = paramPoiInfo.jdField_a_of_type_JavaLangString;
    localPoiInfo.jdField_b_of_type_JavaLangString = paramPoiInfo.jdField_b_of_type_JavaLangString;
    localPoiInfo.jdField_f_of_type_Int = paramPoiInfo.jdField_f_of_type_Int;
    localPoiInfo.jdField_e_of_type_Int = paramPoiInfo.jdField_e_of_type_Int;
    localPoiInfo.jdField_a_of_type_Int = paramPoiInfo.jdField_a_of_type_Int;
    localPoiInfo.jdField_c_of_type_JavaLangString = paramPoiInfo.jdField_c_of_type_JavaLangString;
    localPoiInfo.jdField_g_of_type_Int = paramPoiInfo.jdField_g_of_type_Int;
    return localPoiInfo;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    if (this == paramObject) {
      return true;
    }
    return ((PoiInfo)paramObject).jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_JavaLangString);
  }
  
  public String toString()
  {
    if (this.jdField_a_of_type_CooperationQzoneLbsDataV2$GpsInfo != null) {
      return " poiId: " + this.jdField_a_of_type_JavaLangString + " poiName: " + this.jdField_b_of_type_JavaLangString + " poiType: " + this.jdField_a_of_type_Int + " poiTypeName: " + this.jdField_c_of_type_JavaLangString + " address: " + this.jdField_e_of_type_JavaLangString + " districtCode: " + this.jdField_b_of_type_Int + " distance: " + this.jdField_c_of_type_Int + " phoneNumber: " + this.jdField_f_of_type_JavaLangString + "poiOrderType: " + this.jdField_e_of_type_Int + "poiNum: " + this.jdField_f_of_type_Int + " gpsInfo: " + this.jdField_a_of_type_CooperationQzoneLbsDataV2$GpsInfo.toString() + " ";
    }
    return "poiId: " + this.jdField_a_of_type_JavaLangString + "poiName: " + this.jdField_b_of_type_JavaLangString + "poiType: " + this.jdField_a_of_type_Int + "poiTypeName: " + this.jdField_c_of_type_JavaLangString + "address: " + this.jdField_e_of_type_JavaLangString + "districtCode: " + this.jdField_b_of_type_Int + "distance: " + this.jdField_c_of_type_Int + "phoneNumber: " + this.jdField_f_of_type_JavaLangString + "poiOrderType: " + this.jdField_e_of_type_Int + "poiNum: " + this.jdField_f_of_type_Int + " " + "dianPingId:" + this.jdField_g_of_type_JavaLangString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeString(this.jdField_c_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_d_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_e_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_b_of_type_Int);
    paramParcel.writeInt(this.jdField_c_of_type_Int);
    paramParcel.writeInt(this.jdField_d_of_type_Int);
    paramParcel.writeString(this.jdField_f_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_e_of_type_Int);
    paramParcel.writeInt(this.jdField_f_of_type_Int);
    paramParcel.writeString(this.jdField_g_of_type_JavaLangString);
    paramParcel.writeParcelable(this.jdField_a_of_type_CooperationQzoneLbsDataV2$GpsInfo, paramInt);
    paramParcel.writeInt(this.jdField_g_of_type_Int);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\LbsDataV2$PoiInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package cooperation.qzone;

import LBS_V2_PROTOCOL.GetGeoInfoRsp_V2;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import ykc;

public class LbsDataV2$GetGeoInfoRsp
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new ykc();
  public LbsDataV2.GeoInfo a;
  public LbsDataV2.GpsInfo a;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public LbsDataV2$GetGeoInfoRsp() {}
  
  public LbsDataV2$GetGeoInfoRsp(LbsDataV2.GpsInfo paramGpsInfo, LbsDataV2.GeoInfo paramGeoInfo)
  {
    this.jdField_a_of_type_CooperationQzoneLbsDataV2$GpsInfo = paramGpsInfo;
    this.jdField_a_of_type_CooperationQzoneLbsDataV2$GeoInfo = paramGeoInfo;
  }
  
  public static GetGeoInfoRsp_V2 a(GetGeoInfoRsp paramGetGeoInfoRsp)
  {
    GetGeoInfoRsp_V2 localGetGeoInfoRsp_V2 = new GetGeoInfoRsp_V2();
    if (paramGetGeoInfoRsp != null)
    {
      localGetGeoInfoRsp_V2.stGeoInfo = LbsDataV2.a(paramGetGeoInfoRsp.jdField_a_of_type_CooperationQzoneLbsDataV2$GeoInfo);
      localGetGeoInfoRsp_V2.stGps = LbsDataV2.a(paramGetGeoInfoRsp.jdField_a_of_type_CooperationQzoneLbsDataV2$GpsInfo);
    }
    return localGetGeoInfoRsp_V2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "GetGeoInfoRsp:{" + this.jdField_a_of_type_CooperationQzoneLbsDataV2$GpsInfo + ", " + this.jdField_a_of_type_CooperationQzoneLbsDataV2$GeoInfo + "}";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable(this.jdField_a_of_type_CooperationQzoneLbsDataV2$GpsInfo, paramInt);
    paramParcel.writeParcelable(this.jdField_a_of_type_CooperationQzoneLbsDataV2$GeoInfo, paramInt);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\LbsDataV2$GetGeoInfoRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qzone.LbsDataV2.GeoInfo;
import cooperation.qzone.LbsDataV2.GetGeoInfoRsp;
import cooperation.qzone.LbsDataV2.GpsInfo;

public final class ykc
  implements Parcelable.Creator
{
  public ykc()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public LbsDataV2.GetGeoInfoRsp a(Parcel paramParcel)
  {
    LbsDataV2.GetGeoInfoRsp localGetGeoInfoRsp = new LbsDataV2.GetGeoInfoRsp();
    if (paramParcel != null)
    {
      localGetGeoInfoRsp.jdField_a_of_type_CooperationQzoneLbsDataV2$GpsInfo = ((LbsDataV2.GpsInfo)paramParcel.readParcelable(LbsDataV2.GpsInfo.class.getClassLoader()));
      localGetGeoInfoRsp.jdField_a_of_type_CooperationQzoneLbsDataV2$GeoInfo = ((LbsDataV2.GeoInfo)paramParcel.readParcelable(LbsDataV2.GeoInfo.class.getClassLoader()));
    }
    return localGetGeoInfoRsp;
  }
  
  public LbsDataV2.GetGeoInfoRsp[] a(int paramInt)
  {
    return null;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ykc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
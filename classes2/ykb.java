import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qzone.LbsDataV2.GeoInfo;
import cooperation.qzone.LbsDataV2.GpsInfo;

public final class ykb
  implements Parcelable.Creator
{
  public ykb()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public LbsDataV2.GeoInfo a(Parcel paramParcel)
  {
    LbsDataV2.GeoInfo localGeoInfo = new LbsDataV2.GeoInfo();
    if (paramParcel != null)
    {
      localGeoInfo.jdField_a_of_type_JavaLangString = paramParcel.readString();
      localGeoInfo.jdField_a_of_type_Int = paramParcel.readInt();
      localGeoInfo.jdField_b_of_type_Int = paramParcel.readInt();
      localGeoInfo.jdField_b_of_type_JavaLangString = paramParcel.readString();
      localGeoInfo.c = paramParcel.readString();
      localGeoInfo.d = paramParcel.readString();
      localGeoInfo.e = paramParcel.readString();
      localGeoInfo.f = paramParcel.readString();
      localGeoInfo.g = paramParcel.readString();
      localGeoInfo.h = paramParcel.readString();
      localGeoInfo.i = paramParcel.readString();
      localGeoInfo.jdField_a_of_type_CooperationQzoneLbsDataV2$GpsInfo = ((LbsDataV2.GpsInfo)paramParcel.readParcelable(LbsDataV2.GpsInfo.class.getClassLoader()));
    }
    return localGeoInfo;
  }
  
  public LbsDataV2.GeoInfo[] a(int paramInt)
  {
    return null;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ykb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
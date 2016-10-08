import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qzone.LbsDataV2.GpsInfo;
import cooperation.qzone.LbsDataV2.PoiInfo;

public final class yke
  implements Parcelable.Creator
{
  public yke()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public LbsDataV2.PoiInfo a(Parcel paramParcel)
  {
    LbsDataV2.PoiInfo localPoiInfo = new LbsDataV2.PoiInfo();
    if (paramParcel != null)
    {
      localPoiInfo.jdField_a_of_type_JavaLangString = paramParcel.readString();
      localPoiInfo.jdField_b_of_type_JavaLangString = paramParcel.readString();
      localPoiInfo.jdField_a_of_type_Int = paramParcel.readInt();
      localPoiInfo.jdField_c_of_type_JavaLangString = paramParcel.readString();
      localPoiInfo.jdField_d_of_type_JavaLangString = paramParcel.readString();
      localPoiInfo.jdField_e_of_type_JavaLangString = paramParcel.readString();
      localPoiInfo.jdField_b_of_type_Int = paramParcel.readInt();
      localPoiInfo.jdField_c_of_type_Int = paramParcel.readInt();
      localPoiInfo.jdField_d_of_type_Int = paramParcel.readInt();
      localPoiInfo.jdField_f_of_type_JavaLangString = paramParcel.readString();
      localPoiInfo.jdField_e_of_type_Int = paramParcel.readInt();
      localPoiInfo.jdField_f_of_type_Int = paramParcel.readInt();
      localPoiInfo.jdField_g_of_type_JavaLangString = paramParcel.readString();
      localPoiInfo.jdField_a_of_type_CooperationQzoneLbsDataV2$GpsInfo = ((LbsDataV2.GpsInfo)paramParcel.readParcelable(LbsDataV2.GpsInfo.class.getClassLoader()));
      localPoiInfo.jdField_g_of_type_Int = paramParcel.readInt();
    }
    return localPoiInfo;
  }
  
  public LbsDataV2.PoiInfo[] a(int paramInt)
  {
    return null;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yke.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
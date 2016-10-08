import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.device.utils.LightAppSettingInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class kdy
  implements Parcelable.Creator
{
  public kdy()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public LightAppSettingInfo a(Parcel paramParcel)
  {
    LightAppSettingInfo localLightAppSettingInfo = new LightAppSettingInfo();
    localLightAppSettingInfo.jdField_d_of_type_Int = paramParcel.readInt();
    localLightAppSettingInfo.jdField_e_of_type_Int = paramParcel.readInt();
    localLightAppSettingInfo.jdField_f_of_type_Int = paramParcel.readInt();
    localLightAppSettingInfo.jdField_a_of_type_Long = paramParcel.readLong();
    localLightAppSettingInfo.jdField_a_of_type_JavaUtilArrayList = paramParcel.readArrayList(ClassLoader.getSystemClassLoader());
    localLightAppSettingInfo.jdField_a_of_type_JavaLangString = paramParcel.readString();
    localLightAppSettingInfo.b = paramParcel.readString();
    localLightAppSettingInfo.jdField_g_of_type_Int = paramParcel.readInt();
    localLightAppSettingInfo.c = paramParcel.readString();
    localLightAppSettingInfo.jdField_d_of_type_JavaLangString = paramParcel.readString();
    localLightAppSettingInfo.jdField_e_of_type_JavaLangString = paramParcel.readString();
    localLightAppSettingInfo.jdField_f_of_type_JavaLangString = paramParcel.readString();
    localLightAppSettingInfo.jdField_g_of_type_JavaLangString = paramParcel.readString();
    localLightAppSettingInfo.jdField_h_of_type_Int = paramParcel.readInt();
    localLightAppSettingInfo.jdField_a_of_type_JavaUtilHashMap = paramParcel.readHashMap(ClassLoader.getSystemClassLoader());
    localLightAppSettingInfo.jdField_h_of_type_JavaLangString = paramParcel.readString();
    return localLightAppSettingInfo;
  }
  
  public LightAppSettingInfo[] a(int paramInt)
  {
    return new LightAppSettingInfo[paramInt];
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\kdy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
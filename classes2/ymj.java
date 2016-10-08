import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qzone.model.CoverCacheData.PackageInfo;

public final class ymj
  implements Parcelable.Creator
{
  public ymj()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public CoverCacheData.PackageInfo a(Parcel paramParcel)
  {
    CoverCacheData.PackageInfo localPackageInfo = new CoverCacheData.PackageInfo();
    if (paramParcel != null)
    {
      localPackageInfo.jdField_a_of_type_JavaLangString = paramParcel.readString();
      localPackageInfo.jdField_b_of_type_JavaLangString = paramParcel.readString();
      localPackageInfo.jdField_c_of_type_JavaLangString = paramParcel.readString();
      localPackageInfo.jdField_a_of_type_Int = paramParcel.readInt();
      localPackageInfo.jdField_b_of_type_Int = paramParcel.readInt();
      localPackageInfo.jdField_c_of_type_Int = paramParcel.readInt();
      localPackageInfo.d = paramParcel.readString();
    }
    return localPackageInfo;
  }
  
  public CoverCacheData.PackageInfo[] a(int paramInt)
  {
    return null;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ymj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
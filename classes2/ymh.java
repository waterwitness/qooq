import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qzone.model.CoverCacheData;
import cooperation.qzone.model.CoverCacheData.GameCoverInfo;
import cooperation.qzone.model.CoverCacheData.PackageInfo;

public final class ymh
  implements Parcelable.Creator
{
  public ymh()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public CoverCacheData a(Parcel paramParcel)
  {
    CoverCacheData localCoverCacheData = new CoverCacheData();
    if (paramParcel != null)
    {
      localCoverCacheData.jdField_a_of_type_Long = paramParcel.readLong();
      localCoverCacheData.jdField_a_of_type_JavaLangString = paramParcel.readString();
      localCoverCacheData.jdField_b_of_type_JavaLangString = paramParcel.readString();
      localCoverCacheData.jdField_c_of_type_JavaLangString = paramParcel.readString();
      localCoverCacheData.jdField_a_of_type_JavaUtilHashMap = paramParcel.readHashMap(getClass().getClassLoader());
      localCoverCacheData.jdField_a_of_type_CooperationQzoneModelCoverCacheData$PackageInfo = ((CoverCacheData.PackageInfo)paramParcel.readParcelable(getClass().getClassLoader()));
      localCoverCacheData.jdField_a_of_type_CooperationQzoneModelCoverCacheData$GameCoverInfo = ((CoverCacheData.GameCoverInfo)paramParcel.readParcelable(getClass().getClassLoader()));
      localCoverCacheData.jdField_a_of_type_JavaUtilArrayList = paramParcel.readArrayList(getClass().getClassLoader());
      localCoverCacheData.jdField_a_of_type_Int = paramParcel.readInt();
      localCoverCacheData.jdField_b_of_type_JavaUtilHashMap = paramParcel.readHashMap(getClass().getClassLoader());
      localCoverCacheData.jdField_c_of_type_JavaUtilHashMap = paramParcel.readHashMap(getClass().getClassLoader());
    }
    return localCoverCacheData;
  }
  
  public CoverCacheData[] a(int paramInt)
  {
    return null;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ymh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
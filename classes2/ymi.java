import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qzone.model.CoverCacheData.GameCoverInfo;

public final class ymi
  implements Parcelable.Creator
{
  public ymi()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public CoverCacheData.GameCoverInfo a(Parcel paramParcel)
  {
    CoverCacheData.GameCoverInfo localGameCoverInfo = new CoverCacheData.GameCoverInfo();
    if (paramParcel != null)
    {
      localGameCoverInfo.jdField_a_of_type_Double = paramParcel.readDouble();
      localGameCoverInfo.jdField_b_of_type_Double = paramParcel.readDouble();
      localGameCoverInfo.c = paramParcel.readDouble();
      localGameCoverInfo.d = paramParcel.readDouble();
      localGameCoverInfo.jdField_a_of_type_JavaLangString = paramParcel.readString();
      localGameCoverInfo.jdField_b_of_type_JavaLangString = paramParcel.readString();
      localGameCoverInfo.jdField_a_of_type_Int = paramParcel.readInt();
    }
    return localGameCoverInfo;
  }
  
  public CoverCacheData.GameCoverInfo[] a(int paramInt)
  {
    return null;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ymi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
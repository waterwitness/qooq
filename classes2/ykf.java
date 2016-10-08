import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qzone.LbsDataV2.WifiInfo;

public final class ykf
  implements Parcelable.Creator
{
  public ykf()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public LbsDataV2.WifiInfo a(Parcel paramParcel)
  {
    LbsDataV2.WifiInfo localWifiInfo = new LbsDataV2.WifiInfo();
    if (paramParcel != null)
    {
      localWifiInfo.jdField_a_of_type_JavaLangString = paramParcel.readString();
      localWifiInfo.jdField_a_of_type_Int = paramParcel.readInt();
    }
    return localWifiInfo;
  }
  
  public LbsDataV2.WifiInfo[] a(int paramInt)
  {
    return null;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ykf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
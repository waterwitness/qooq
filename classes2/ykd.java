import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qzone.LbsDataV2.GpsInfo;

public final class ykd
  implements Parcelable.Creator
{
  public ykd()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public LbsDataV2.GpsInfo a(Parcel paramParcel)
  {
    LbsDataV2.GpsInfo localGpsInfo = new LbsDataV2.GpsInfo();
    if (paramParcel != null)
    {
      localGpsInfo.a = paramParcel.readInt();
      localGpsInfo.b = paramParcel.readInt();
      localGpsInfo.c = paramParcel.readInt();
      localGpsInfo.d = paramParcel.readInt();
      localGpsInfo.e = paramParcel.readInt();
    }
    return localGpsInfo;
  }
  
  public LbsDataV2.GpsInfo[] a(int paramInt)
  {
    return null;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ykd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
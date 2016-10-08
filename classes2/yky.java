import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qzone.QZoneShareData;

public final class yky
  implements Parcelable.Creator
{
  public yky()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public QZoneShareData a(Parcel paramParcel)
  {
    return new QZoneShareData(paramParcel, null);
  }
  
  public QZoneShareData[] a(int paramInt)
  {
    return new QZoneShareData[paramInt];
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yky.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
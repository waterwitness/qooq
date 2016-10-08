import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qzone.model.GpsInfo4LocalImage;

public final class ymm
  implements Parcelable.Creator
{
  public ymm()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public GpsInfo4LocalImage a(Parcel paramParcel)
  {
    return new GpsInfo4LocalImage(paramParcel.readFloat(), paramParcel.readFloat());
  }
  
  public GpsInfo4LocalImage[] a(int paramInt)
  {
    return null;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ymm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
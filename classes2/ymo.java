import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qzone.model.LocalImageShootInfo;

public final class ymo
  implements Parcelable.Creator
{
  public ymo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public LocalImageShootInfo a(Parcel paramParcel)
  {
    return new LocalImageShootInfo(paramParcel);
  }
  
  public LocalImageShootInfo[] a(int paramInt)
  {
    return null;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ymo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
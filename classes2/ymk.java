import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qzone.model.DiscoverTab;

public final class ymk
  implements Parcelable.Creator
{
  public ymk()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public DiscoverTab a(Parcel paramParcel)
  {
    return new DiscoverTab(paramParcel);
  }
  
  public DiscoverTab[] a(int paramInt)
  {
    return new DiscoverTab[paramInt];
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ymk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
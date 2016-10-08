import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.data.PrecoverResource;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class rcc
  implements Parcelable.Creator
{
  public rcc()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public PrecoverResource a(Parcel paramParcel)
  {
    return new PrecoverResource(paramParcel);
  }
  
  public PrecoverResource[] a(int paramInt)
  {
    return new PrecoverResource[paramInt];
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\rcc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
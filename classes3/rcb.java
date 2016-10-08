import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.data.PrecoverConfig;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class rcb
  implements Parcelable.Creator
{
  public rcb()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public PrecoverConfig a(Parcel paramParcel)
  {
    return new PrecoverConfig(paramParcel);
  }
  
  public PrecoverConfig[] a(int paramInt)
  {
    return new PrecoverConfig[paramInt];
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\rcb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
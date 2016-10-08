import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.freshnews.FreshNewsStranger;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class sra
  implements Parcelable.Creator
{
  public sra()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public FreshNewsStranger a(Parcel paramParcel)
  {
    return new FreshNewsStranger(paramParcel);
  }
  
  public FreshNewsStranger[] a(int paramInt)
  {
    return new FreshNewsStranger[paramInt];
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\sra.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
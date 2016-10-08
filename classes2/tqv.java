import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.olympic.OlyimpicConfig;

public final class tqv
  implements Parcelable.Creator
{
  public tqv()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public OlyimpicConfig a(Parcel paramParcel)
  {
    return new OlyimpicConfig(paramParcel);
  }
  
  public OlyimpicConfig[] a(int paramInt)
  {
    return new OlyimpicConfig[paramInt];
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tqv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
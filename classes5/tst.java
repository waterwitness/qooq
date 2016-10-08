import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pic.CompressInfo;

public final class tst
  implements Parcelable.Creator
{
  public tst()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public CompressInfo a(Parcel paramParcel)
  {
    return new CompressInfo(paramParcel, null);
  }
  
  public CompressInfo[] a(int paramInt)
  {
    return new CompressInfo[paramInt];
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tst.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
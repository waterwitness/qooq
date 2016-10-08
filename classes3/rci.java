import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.data.SecMsg;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class rci
  implements Parcelable.Creator
{
  public rci()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public SecMsg a(Parcel paramParcel)
  {
    return new SecMsg(paramParcel, null);
  }
  
  public SecMsg[] a(int paramInt)
  {
    return new SecMsg[paramInt];
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\rci.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
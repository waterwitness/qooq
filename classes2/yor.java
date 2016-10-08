import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qzone.remote.RecvMsg;

public final class yor
  implements Parcelable.Creator
{
  public yor()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public RecvMsg a(Parcel paramParcel)
  {
    return new RecvMsg(paramParcel);
  }
  
  public RecvMsg[] a(int paramInt)
  {
    return new RecvMsg[paramInt];
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
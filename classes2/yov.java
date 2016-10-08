import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qzone.remote.SendMsg;

public final class yov
  implements Parcelable.Creator
{
  public yov()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public SendMsg a(Parcel paramParcel)
  {
    return new SendMsg(paramParcel);
  }
  
  public SendMsg[] a(int paramInt)
  {
    return new SendMsg[paramInt];
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yov.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.data.SecMsgSession;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class rcj
  implements Parcelable.Creator
{
  public rcj()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public SecMsgSession a(Parcel paramParcel)
  {
    return new SecMsgSession(paramParcel, null);
  }
  
  public SecMsgSession[] a(int paramInt)
  {
    return new SecMsgSession[paramInt];
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\rcj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
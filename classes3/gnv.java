import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.av.service.RecvMsg;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class gnv
  implements Parcelable.Creator
{
  public gnv()
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


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gnv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
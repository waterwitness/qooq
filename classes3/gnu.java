import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.av.service.RecvGVideoLevelInfo.Medal;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class gnu
  implements Parcelable.Creator
{
  public gnu()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public RecvGVideoLevelInfo.Medal a(Parcel paramParcel)
  {
    return new RecvGVideoLevelInfo.Medal(paramParcel);
  }
  
  public RecvGVideoLevelInfo.Medal[] a(int paramInt)
  {
    return new RecvGVideoLevelInfo.Medal[paramInt];
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gnu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.av.app.PstnSessionInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class gfu
  implements Parcelable.Creator
{
  public gfu()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public PstnSessionInfo a(Parcel paramParcel)
  {
    return new PstnSessionInfo(paramParcel);
  }
  
  public PstnSessionInfo[] a(int paramInt)
  {
    return new PstnSessionInfo[paramInt];
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\gfu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
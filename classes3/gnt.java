import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.av.service.RecvGVideoLevelInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class gnt
  implements Parcelable.Creator
{
  public gnt()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public RecvGVideoLevelInfo a(Parcel paramParcel)
  {
    return new RecvGVideoLevelInfo(paramParcel);
  }
  
  public RecvGVideoLevelInfo[] a(int paramInt)
  {
    return new RecvGVideoLevelInfo[paramInt];
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gnt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
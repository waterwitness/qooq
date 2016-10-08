import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.av.service.LBSInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class gnd
  implements Parcelable.Creator
{
  public gnd()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public LBSInfo a(Parcel paramParcel)
  {
    return new LBSInfo(paramParcel);
  }
  
  public LBSInfo[] a(int paramInt)
  {
    return new LBSInfo[paramInt];
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
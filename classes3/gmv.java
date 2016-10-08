import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.av.service.AVPbInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class gmv
  implements Parcelable.Creator
{
  public gmv()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public AVPbInfo a(Parcel paramParcel)
  {
    return new AVPbInfo(paramParcel);
  }
  
  public AVPbInfo[] a(int paramInt)
  {
    return new AVPbInfo[paramInt];
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gmv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
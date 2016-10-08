import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.freshnews.ad.UserInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class srq
  implements Parcelable.Creator
{
  public srq()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public UserInfo a(Parcel paramParcel)
  {
    return new UserInfo(paramParcel);
  }
  
  public UserInfo[] a(int paramInt)
  {
    return new UserInfo[paramInt];
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\srq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
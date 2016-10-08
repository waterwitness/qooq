import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.pubaccount.util.ProfileParams.CurLoginUsr;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class iey
  implements Parcelable.Creator
{
  public iey()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public ProfileParams.CurLoginUsr a(Parcel paramParcel)
  {
    return new ProfileParams.CurLoginUsr(paramParcel.readString(), paramParcel.readString());
  }
  
  public ProfileParams.CurLoginUsr[] a(int paramInt)
  {
    return new ProfileParams.CurLoginUsr[paramInt];
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\iey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
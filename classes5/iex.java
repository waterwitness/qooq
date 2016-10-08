import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.pubaccount.util.ProfileParams;
import com.tencent.biz.pubaccount.util.ProfileParams.Builder;
import com.tencent.biz.pubaccount.util.ProfileParams.CurLoginUsr;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class iex
  implements Parcelable.Creator
{
  public iex()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public ProfileParams a(Parcel paramParcel)
  {
    ProfileParams.Builder localBuilder = new ProfileParams.Builder();
    localBuilder.a(paramParcel.readString()).a(paramParcel.readInt()).b(paramParcel.readString()).c(paramParcel.readString()).d(paramParcel.readString()).a((ProfileParams.CurLoginUsr)paramParcel.readParcelable(ProfileParams.CurLoginUsr.CREATOR.getClass().getClassLoader()));
    return localBuilder.a();
  }
  
  public ProfileParams[] a(int paramInt)
  {
    return new ProfileParams[paramInt];
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\iex.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
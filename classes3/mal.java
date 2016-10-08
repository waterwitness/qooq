import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.activity.ProfileActivity.CardContactInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class mal
  implements Parcelable.Creator
{
  public mal()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public ProfileActivity.CardContactInfo a(Parcel paramParcel)
  {
    ProfileActivity.CardContactInfo localCardContactInfo = new ProfileActivity.CardContactInfo(null);
    localCardContactInfo.a = paramParcel.readString();
    localCardContactInfo.c = paramParcel.readString();
    localCardContactInfo.b = paramParcel.readString();
    return localCardContactInfo;
  }
  
  public ProfileActivity.CardContactInfo[] a(int paramInt)
  {
    return new ProfileActivity.CardContactInfo[paramInt];
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.interestTag.InterestTagInfo;

public final class tjy
  implements Parcelable.Creator
{
  public tjy()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public InterestTagInfo a(Parcel paramParcel)
  {
    return new InterestTagInfo(paramParcel);
  }
  
  public InterestTagInfo[] a(int paramInt)
  {
    return new InterestTagInfo[paramInt];
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tjy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.data.DynamicAvatar;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class rbn
  implements Parcelable.Creator
{
  public rbn()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public DynamicAvatar a(Parcel paramParcel)
  {
    return new DynamicAvatar(paramParcel);
  }
  
  public DynamicAvatar[] a(int paramInt)
  {
    return new DynamicAvatar[paramInt];
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\rbn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
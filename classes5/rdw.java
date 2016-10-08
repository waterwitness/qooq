import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.dating.DatingFilters;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class rdw
  implements Parcelable.Creator
{
  public rdw()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public DatingFilters a(Parcel paramParcel)
  {
    return new DatingFilters(paramParcel, null);
  }
  
  public DatingFilters[] a(int paramInt)
  {
    return new DatingFilters[paramInt];
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rdw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.freshnews.FreshNewsInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class sqh
  implements Parcelable.Creator
{
  public sqh()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public FreshNewsInfo a(Parcel paramParcel)
  {
    return new FreshNewsInfo(paramParcel);
  }
  
  public FreshNewsInfo[] a(int paramInt)
  {
    return new FreshNewsInfo[paramInt];
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\sqh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
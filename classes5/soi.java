import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.freshnews.FreshNewsComment;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class soi
  implements Parcelable.Creator
{
  public soi()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public FreshNewsComment a(Parcel paramParcel)
  {
    return new FreshNewsComment(paramParcel);
  }
  
  public FreshNewsComment[] a(int paramInt)
  {
    return new FreshNewsComment[paramInt];
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\soi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
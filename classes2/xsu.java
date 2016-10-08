import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.CirclePageIndicator.SavedState;

public final class xsu
  implements Parcelable.Creator
{
  public xsu()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public CirclePageIndicator.SavedState a(Parcel paramParcel)
  {
    return new CirclePageIndicator.SavedState(paramParcel, null);
  }
  
  public CirclePageIndicator.SavedState[] a(int paramInt)
  {
    return new CirclePageIndicator.SavedState[paramInt];
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\xsu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
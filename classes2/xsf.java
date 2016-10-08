import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.AbsSpinner.SavedState;

public final class xsf
  implements Parcelable.Creator
{
  public xsf()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public AbsSpinner.SavedState a(Parcel paramParcel)
  {
    return new AbsSpinner.SavedState(paramParcel, null);
  }
  
  public AbsSpinner.SavedState[] a(int paramInt)
  {
    return new AbsSpinner.SavedState[paramInt];
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\xsf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
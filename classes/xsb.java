import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.AbsListView.SavedState;

public final class xsb
  implements Parcelable.Creator
{
  public xsb()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public AbsListView.SavedState a(Parcel paramParcel)
  {
    return new AbsListView.SavedState(paramParcel, null);
  }
  
  public AbsListView.SavedState[] a(int paramInt)
  {
    return new AbsListView.SavedState[paramInt];
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\xsb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.ExpandableListView.SavedState;

public final class xtb
  implements Parcelable.Creator
{
  public xtb()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public ExpandableListView.SavedState a(Parcel paramParcel)
  {
    return new ExpandableListView.SavedState(paramParcel, null);
  }
  
  public ExpandableListView.SavedState[] a(int paramInt)
  {
    return new ExpandableListView.SavedState[paramInt];
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\xtb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
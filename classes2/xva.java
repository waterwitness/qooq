import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.TCWDatePicker.SavedState;

public final class xva
  implements Parcelable.Creator
{
  public xva()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public TCWDatePicker.SavedState a(Parcel paramParcel)
  {
    return new TCWDatePicker.SavedState(paramParcel, null);
  }
  
  public TCWDatePicker.SavedState[] a(int paramInt)
  {
    return new TCWDatePicker.SavedState[paramInt];
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\xva.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
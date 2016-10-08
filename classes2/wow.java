import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.Workspace.SavedState;

public final class wow
  implements Parcelable.Creator
{
  public wow()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public Workspace.SavedState a(Parcel paramParcel)
  {
    return new Workspace.SavedState(paramParcel, null);
  }
  
  public Workspace.SavedState[] a(int paramInt)
  {
    return new Workspace.SavedState[paramInt];
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
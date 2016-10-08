import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.util.BinderWarpper;

public final class xrl
  implements Parcelable.Creator
{
  public xrl()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public BinderWarpper a(Parcel paramParcel)
  {
    return new BinderWarpper(paramParcel.readStrongBinder());
  }
  
  public BinderWarpper[] a(int paramInt)
  {
    return new BinderWarpper[paramInt];
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\xrl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
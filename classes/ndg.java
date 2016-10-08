import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.activity.aio.ForwardUtils.Section_Pic;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class ndg
  implements Parcelable.Creator
{
  public ndg()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public ForwardUtils.Section_Pic a(Parcel paramParcel)
  {
    return new ForwardUtils.Section_Pic(paramParcel);
  }
  
  public ForwardUtils.Section_Pic[] a(int paramInt)
  {
    return new ForwardUtils.Section_Pic[paramInt];
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\ndg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
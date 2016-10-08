import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qzone.widget.RedTouchExtendButton.RedInfo;

public final class ysh
  implements Parcelable.Creator
{
  public ysh()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public RedTouchExtendButton.RedInfo a(Parcel paramParcel)
  {
    return new RedTouchExtendButton.RedInfo(paramParcel);
  }
  
  public RedTouchExtendButton.RedInfo[] a(int paramInt)
  {
    return new RedTouchExtendButton.RedInfo[paramInt];
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ysh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
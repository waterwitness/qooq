import AvatarInfo.QQHeadInfo;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class a
  implements Parcelable.Creator
{
  public a()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public QQHeadInfo a(Parcel paramParcel)
  {
    QQHeadInfo localQQHeadInfo = new QQHeadInfo();
    localQQHeadInfo.readFromParcel(paramParcel);
    return localQQHeadInfo;
  }
  
  public QQHeadInfo[] a(int paramInt)
  {
    return new QQHeadInfo[paramInt];
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
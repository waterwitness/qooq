import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qqpim.QQPimTipsInfo;

public final class yiw
  implements Parcelable.Creator
{
  public yiw()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public QQPimTipsInfo a(Parcel paramParcel)
  {
    return new QQPimTipsInfo(paramParcel, null);
  }
  
  public QQPimTipsInfo[] a(int paramInt)
  {
    return new QQPimTipsInfo[paramInt];
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yiw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
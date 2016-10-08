import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.dataline.util.file.SendInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class ec
  implements Parcelable.Creator
{
  public ec()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public SendInfo a(Parcel paramParcel)
  {
    return new SendInfo(paramParcel, null);
  }
  
  public SendInfo[] a(int paramInt)
  {
    return new SendInfo[paramInt];
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
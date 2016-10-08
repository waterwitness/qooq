import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.downloadnew.common.NoticeParam;

public final class wxr
  implements Parcelable.Creator
{
  public wxr()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public NoticeParam a(Parcel paramParcel)
  {
    return new NoticeParam(paramParcel);
  }
  
  public NoticeParam[] a(int paramInt)
  {
    return new NoticeParam[paramInt];
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wxr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
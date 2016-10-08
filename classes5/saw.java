import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class saw
  implements Parcelable.Creator
{
  public saw()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public FileInfo a(Parcel paramParcel)
  {
    return new FileInfo(paramParcel, null);
  }
  
  public FileInfo[] a(int paramInt)
  {
    return new FileInfo[paramInt];
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\saw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
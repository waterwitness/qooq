import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.dataline.util.file.DLFileInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class ea
  implements Parcelable.Creator
{
  public ea()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public DLFileInfo a(Parcel paramParcel)
  {
    return new DLFileInfo(paramParcel, null);
  }
  
  public DLFileInfo[] a(int paramInt)
  {
    return new DLFileInfo[paramInt];
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ea.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
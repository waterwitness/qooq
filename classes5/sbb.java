import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.filemanager.data.OfflineFileInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class sbb
  implements Parcelable.Creator
{
  public sbb()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public OfflineFileInfo a(Parcel paramParcel)
  {
    return new OfflineFileInfo(paramParcel);
  }
  
  public OfflineFileInfo[] a(int paramInt)
  {
    return new OfflineFileInfo[paramInt];
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\sbb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
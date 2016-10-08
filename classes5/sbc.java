import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class sbc
  implements Parcelable.Creator
{
  public sbc()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public WeiYunFileInfo a(Parcel paramParcel)
  {
    return new WeiYunFileInfo(paramParcel);
  }
  
  public WeiYunFileInfo[] a(int paramInt)
  {
    return new WeiYunFileInfo[paramInt];
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\sbc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
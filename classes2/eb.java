import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.dataline.util.file.ImageInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class eb
  implements Parcelable.Creator
{
  public eb()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public ImageInfo a(Parcel paramParcel)
  {
    return new ImageInfo(paramParcel, null);
  }
  
  public ImageInfo[] a(int paramInt)
  {
    return new ImageInfo[paramInt];
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\eb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
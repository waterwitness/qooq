import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qzone.model.DynamicPhotoData;

public final class yml
  implements Parcelable.Creator
{
  public yml()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public DynamicPhotoData a(Parcel paramParcel)
  {
    return new DynamicPhotoData(paramParcel);
  }
  
  public DynamicPhotoData[] a(int paramInt)
  {
    return new DynamicPhotoData[paramInt];
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yml.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.picbrowser.PicInfo;

public final class tld
  implements Parcelable.Creator
{
  public tld()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public PicInfo a(Parcel paramParcel)
  {
    return new PicInfo(paramParcel);
  }
  
  public PicInfo[] a(int paramInt)
  {
    return new PicInfo[paramInt];
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tld.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
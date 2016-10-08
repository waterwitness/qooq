import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class rck
  implements Parcelable.Creator
{
  public rck()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public Setting a(Parcel paramParcel)
  {
    Setting localSetting = new Setting();
    localSetting.readFromParcel(paramParcel);
    return localSetting;
  }
  
  public Setting[] a(int paramInt)
  {
    return new Setting[paramInt];
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\rck.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.dingdong.DingdongJsApiPlugin.OpenIdData;

public final class yat
  implements Parcelable.Creator
{
  public yat()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public DingdongJsApiPlugin.OpenIdData a(Parcel paramParcel)
  {
    return new DingdongJsApiPlugin.OpenIdData(paramParcel);
  }
  
  public DingdongJsApiPlugin.OpenIdData[] a(int paramInt)
  {
    return new DingdongJsApiPlugin.OpenIdData[paramInt];
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
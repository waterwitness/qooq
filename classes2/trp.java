import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.olympic.ShuayishuaConfig;

public final class trp
  implements Parcelable.Creator
{
  public trp()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public ShuayishuaConfig a(Parcel paramParcel)
  {
    return new ShuayishuaConfig(paramParcel);
  }
  
  public ShuayishuaConfig[] a(int paramInt)
  {
    return new ShuayishuaConfig[paramInt];
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\trp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
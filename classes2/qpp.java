import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.ar.aidl.ArEffectConfig;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class qpp
  implements Parcelable.Creator
{
  public qpp()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public ArEffectConfig a(Parcel paramParcel)
  {
    return new ArEffectConfig(paramParcel);
  }
  
  public ArEffectConfig[] a(int paramInt)
  {
    return new ArEffectConfig[paramInt];
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\qpp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
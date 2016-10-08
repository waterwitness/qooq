import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.ar.model.ArDefaultSetting;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class qps
  implements Parcelable.Creator
{
  public qps()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public ArDefaultSetting a(Parcel paramParcel)
  {
    return new ArDefaultSetting(paramParcel);
  }
  
  public ArDefaultSetting[] a(int paramInt)
  {
    return new ArDefaultSetting[paramInt];
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\qps.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
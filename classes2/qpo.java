import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.ar.aidl.ArConfigInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class qpo
  implements Parcelable.Creator
{
  public qpo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public ArConfigInfo a(Parcel paramParcel)
  {
    return new ArConfigInfo(paramParcel);
  }
  
  public ArConfigInfo[] a(int paramInt)
  {
    return new ArConfigInfo[paramInt];
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\qpo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
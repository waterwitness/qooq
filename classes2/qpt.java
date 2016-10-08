import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.ar.model.ArResourceInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class qpt
  implements Parcelable.Creator
{
  public qpt()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public ArResourceInfo a(Parcel paramParcel)
  {
    return new ArResourceInfo(paramParcel);
  }
  
  public ArResourceInfo[] a(int paramInt)
  {
    return new ArResourceInfo[paramInt];
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\qpt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
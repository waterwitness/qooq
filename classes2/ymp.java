import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qzone.model.MapParcelable;

public final class ymp
  implements Parcelable.Creator
{
  public ymp()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public MapParcelable a(Parcel paramParcel)
  {
    return new MapParcelable(paramParcel.readHashMap(getClass().getClassLoader()));
  }
  
  public MapParcelable[] a(int paramInt)
  {
    return null;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ymp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
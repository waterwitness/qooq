import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.app.RoamInfoListWrapper;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public final class qfk
  implements Parcelable.Creator
{
  public qfk()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public RoamInfoListWrapper a(Parcel paramParcel)
  {
    RoamInfoListWrapper localRoamInfoListWrapper = new RoamInfoListWrapper();
    localRoamInfoListWrapper.a = paramParcel.readArrayList(ArrayList.class.getClassLoader());
    return localRoamInfoListWrapper;
  }
  
  public RoamInfoListWrapper[] a(int paramInt)
  {
    return new RoamInfoListWrapper[paramInt];
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\qfk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
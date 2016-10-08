import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.FaceInfo;

public final class vyd
  implements Parcelable.Creator
{
  public vyd()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public FaceInfo a(Parcel paramParcel)
  {
    FaceInfo localFaceInfo = new FaceInfo();
    localFaceInfo.a(paramParcel);
    return localFaceInfo;
  }
  
  public FaceInfo[] a(int paramInt)
  {
    return new FaceInfo[paramInt];
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vyd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
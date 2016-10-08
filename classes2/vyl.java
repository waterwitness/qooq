import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.HeadRequest;

public final class vyl
  implements Parcelable.Creator
{
  public vyl()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public HeadRequest a(Parcel paramParcel)
  {
    HeadRequest localHeadRequest = new HeadRequest();
    localHeadRequest.a(paramParcel);
    return localHeadRequest;
  }
  
  public HeadRequest[] a(int paramInt)
  {
    return new HeadRequest[paramInt];
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vyl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
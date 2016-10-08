import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class iym
  implements Parcelable.Creator
{
  public iym()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public PublishParam a(Parcel paramParcel)
  {
    return new PublishParam(paramParcel);
  }
  
  public PublishParam[] a(int paramInt)
  {
    return new PublishParam[paramInt];
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\iym.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
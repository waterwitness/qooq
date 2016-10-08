import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.arrange.op.MeetingInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class gcs
  implements Parcelable.Creator
{
  public gcs()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public MeetingInfo a(Parcel paramParcel)
  {
    return new MeetingInfo(paramParcel);
  }
  
  public MeetingInfo[] a(int paramInt)
  {
    return new MeetingInfo[paramInt];
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\gcs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.activity.aio.ForwardUtils.SectionBase;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class ndf
  implements Parcelable.Creator
{
  public ndf()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public ForwardUtils.SectionBase a(Parcel paramParcel)
  {
    return new ForwardUtils.SectionBase(paramParcel);
  }
  
  public ForwardUtils.SectionBase[] a(int paramInt)
  {
    return new ForwardUtils.SectionBase[paramInt];
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\ndf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
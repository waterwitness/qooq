import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.qcall.PstnCardInfo;

public final class tyx
  implements Parcelable.Creator
{
  public tyx()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public PstnCardInfo a(Parcel paramParcel)
  {
    return new PstnCardInfo(paramParcel);
  }
  
  public PstnCardInfo[] a(int paramInt)
  {
    return new PstnCardInfo[paramInt];
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tyx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
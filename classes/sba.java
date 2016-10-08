import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class sba
  implements Parcelable.Creator
{
  public sba()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public ForwardFileInfo a(Parcel paramParcel)
  {
    return new ForwardFileInfo(paramParcel, null);
  }
  
  public ForwardFileInfo[] a(int paramInt)
  {
    return new ForwardFileInfo[paramInt];
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\sba.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
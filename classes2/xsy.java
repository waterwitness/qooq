import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.ExpandableListConnector.GroupMetadata;

public final class xsy
  implements Parcelable.Creator
{
  public xsy()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public ExpandableListConnector.GroupMetadata a(Parcel paramParcel)
  {
    return ExpandableListConnector.GroupMetadata.a(paramParcel.readInt(), paramParcel.readInt(), paramParcel.readInt(), paramParcel.readLong());
  }
  
  public ExpandableListConnector.GroupMetadata[] a(int paramInt)
  {
    return new ExpandableListConnector.GroupMetadata[paramInt];
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\xsy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
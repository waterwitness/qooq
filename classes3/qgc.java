import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.app.ShieldOperationItem;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class qgc
  implements Parcelable.Creator
{
  public qgc()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public ShieldOperationItem a(Parcel paramParcel)
  {
    ShieldOperationItem localShieldOperationItem = new ShieldOperationItem();
    localShieldOperationItem.jdField_a_of_type_Int = paramParcel.readInt();
    localShieldOperationItem.b = paramParcel.readInt();
    localShieldOperationItem.c = paramParcel.readInt();
    localShieldOperationItem.jdField_a_of_type_ArrayOfLong = paramParcel.createLongArray();
    localShieldOperationItem.d = paramParcel.readInt();
    return localShieldOperationItem;
  }
  
  public ShieldOperationItem[] a(int paramInt)
  {
    return null;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\qgc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
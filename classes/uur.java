import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.UEC.UECItem;

public final class uur
  implements Parcelable.Creator
{
  public uur()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public UEC.UECItem a(Parcel paramParcel)
  {
    UEC.UECItem localUECItem = new UEC.UECItem();
    localUECItem.jdField_a_of_type_JavaLangString = paramParcel.readString();
    localUECItem.jdField_a_of_type_Int = paramParcel.readInt();
    localUECItem.jdField_a_of_type_Long = paramParcel.readLong();
    localUECItem.jdField_b_of_type_Int = paramParcel.readInt();
    localUECItem.jdField_b_of_type_JavaLangString = paramParcel.readString();
    return localUECItem;
  }
  
  public UEC.UECItem[] a(int paramInt)
  {
    return new UEC.UECItem[paramInt];
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\uur.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
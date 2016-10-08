import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qzone.LbsDataV2.CellInfo;

public final class yka
  implements Parcelable.Creator
{
  public yka()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public LbsDataV2.CellInfo a(Parcel paramParcel)
  {
    LbsDataV2.CellInfo localCellInfo = new LbsDataV2.CellInfo();
    if (paramParcel != null)
    {
      localCellInfo.jdField_a_of_type_Int = paramParcel.readInt();
      localCellInfo.jdField_b_of_type_Int = paramParcel.readInt();
      localCellInfo.c = paramParcel.readInt();
      localCellInfo.d = paramParcel.readInt();
      localCellInfo.e = paramParcel.readInt();
      localCellInfo.jdField_a_of_type_Double = paramParcel.readDouble();
      localCellInfo.jdField_b_of_type_Double = paramParcel.readDouble();
    }
    return localCellInfo;
  }
  
  public LbsDataV2.CellInfo[] a(int paramInt)
  {
    return null;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yka.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.app.utils.DingdongPluginBizObserver.TempLiteMailIndexInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class qoi
  implements Parcelable.Creator
{
  public qoi()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public DingdongPluginBizObserver.TempLiteMailIndexInfo a(Parcel paramParcel)
  {
    DingdongPluginBizObserver.TempLiteMailIndexInfo localTempLiteMailIndexInfo = new DingdongPluginBizObserver.TempLiteMailIndexInfo();
    localTempLiteMailIndexInfo.jdField_a_of_type_JavaLangString = paramParcel.readString();
    localTempLiteMailIndexInfo.jdField_a_of_type_Int = paramParcel.readInt();
    localTempLiteMailIndexInfo.jdField_a_of_type_Long = paramParcel.readLong();
    return localTempLiteMailIndexInfo;
  }
  
  public DingdongPluginBizObserver.TempLiteMailIndexInfo[] a(int paramInt)
  {
    return new DingdongPluginBizObserver.TempLiteMailIndexInfo[paramInt];
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\qoi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
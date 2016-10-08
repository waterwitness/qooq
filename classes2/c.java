import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.android.internal.telephony.SmsRawData;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class c
  implements Parcelable.Creator
{
  public c()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public SmsRawData a(Parcel paramParcel)
  {
    byte[] arrayOfByte = new byte[paramParcel.readInt()];
    paramParcel.readByteArray(arrayOfByte);
    return new SmsRawData(arrayOfByte);
  }
  
  public SmsRawData[] a(int paramInt)
  {
    return new SmsRawData[paramInt];
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
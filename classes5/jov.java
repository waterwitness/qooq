import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.device.JNICallCenter.DataPoint;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class jov
  implements Parcelable.Creator
{
  public jov()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public DataPoint a(Parcel paramParcel)
  {
    DataPoint localDataPoint = new DataPoint();
    localDataPoint.mDin = paramParcel.readLong();
    localDataPoint.mSendUinType = paramParcel.readInt();
    localDataPoint.mApiName = paramParcel.readString();
    localDataPoint.mProperityId = paramParcel.readInt();
    localDataPoint.mValueType = paramParcel.readString();
    localDataPoint.mValue = paramParcel.readString();
    localDataPoint.mRetCode = paramParcel.readInt();
    localDataPoint.mErrMsg = paramParcel.readString();
    localDataPoint.mSeq = paramParcel.readString();
    return localDataPoint;
  }
  
  public DataPoint[] a(int paramInt)
  {
    return new DataPoint[paramInt];
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jov.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
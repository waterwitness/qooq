import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class jwg
  implements Parcelable.Creator
{
  public jwg()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public DeviceInfo a(Parcel paramParcel)
  {
    DeviceInfo localDeviceInfo = new DeviceInfo();
    localDeviceInfo.osPlatform = paramParcel.readString();
    localDeviceInfo.osVersion = paramParcel.readString();
    localDeviceInfo.netType = paramParcel.readInt();
    localDeviceInfo.netDetail = paramParcel.readString();
    localDeviceInfo.netAddress = paramParcel.readString();
    localDeviceInfo.netAPN = paramParcel.readString();
    localDeviceInfo.name = paramParcel.readString();
    localDeviceInfo.remark = paramParcel.readString();
    localDeviceInfo.type = paramParcel.readString();
    localDeviceInfo.serialNum = paramParcel.readString();
    localDeviceInfo.productId = paramParcel.readInt();
    localDeviceInfo.appSecret = paramParcel.readString();
    localDeviceInfo.din = paramParcel.readLong();
    localDeviceInfo.isAdmin = paramParcel.readInt();
    localDeviceInfo.status = ((short)paramParcel.readInt());
    localDeviceInfo.userStatus = ((short)paramParcel.readInt());
    localDeviceInfo.productType = ((short)paramParcel.readInt());
    localDeviceInfo.displayName = paramParcel.readString();
    localDeviceInfo.productVer = paramParcel.readInt();
    localDeviceInfo.SSOBid_Platform = paramParcel.readInt();
    localDeviceInfo.SSOBid_Version = paramParcel.readString();
    return localDeviceInfo;
  }
  
  public DeviceInfo[] a(int paramInt)
  {
    return new DeviceInfo[paramInt];
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jwg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
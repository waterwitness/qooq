import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.device.datadef.ProductInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class jwh
  implements Parcelable.Creator
{
  public jwh()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public ProductInfo a(Parcel paramParcel)
  {
    ProductInfo localProductInfo = new ProductInfo();
    localProductInfo.productId = paramParcel.readInt();
    localProductInfo.deviceType = paramParcel.readInt();
    localProductInfo.bindType = paramParcel.readInt();
    localProductInfo.supportMainMsgType = paramParcel.readInt();
    localProductInfo.supportFuncMsgType = paramParcel.readInt();
    localProductInfo.deviceName = paramParcel.readString();
    localProductInfo.uConnectType = paramParcel.readInt();
    localProductInfo.deviceOSType = paramParcel.readInt();
    localProductInfo.regType = paramParcel.readInt();
    localProductInfo.linkStateDesc = paramParcel.readString();
    localProductInfo.linkStepDesc = paramParcel.readString();
    localProductInfo.linkDescImg = paramParcel.readString();
    return localProductInfo;
  }
  
  public ProductInfo[] a(int paramInt)
  {
    return new ProductInfo[paramInt];
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jwh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
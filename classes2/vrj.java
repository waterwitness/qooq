import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopGiftProtocolObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.troop.utils.TroopGiftCallback;
import com.tencent.mobileqq.troop.utils.TroopGiftManager;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0x6c3.oidb_0x6c3.GetExtraDataRsp;
import tencent.im.oidb.cmd0x6c3.oidb_0x6c3.GetStockRsp;
import tencent.im.oidb.cmd0x6c3.oidb_0x6c3.RspBody;

public class vrj
  extends ProtoUtils.TroopGiftProtocolObserver
{
  public vrj(TroopGiftManager paramTroopGiftManager, TroopGiftCallback paramTroopGiftCallback)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if ((paramInt != 0) || (paramArrayOfByte == null) || (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopGiftCallback == null))
    {
      if (QLog.isColorLevel()) {
        QLog.i(".troop.send_gift", 2, "send_oidb_0x6c3. onResult error=" + paramInt + " data=" + paramArrayOfByte + " callback=" + this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopGiftCallback);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopGiftCallback != null) {
        this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopGiftCallback.a(paramInt, "sso request error or callback is null.");
      }
      return;
    }
    oidb_0x6c3.RspBody localRspBody;
    try
    {
      localRspBody = new oidb_0x6c3.RspBody();
      localRspBody.mergeFrom(paramArrayOfByte);
      paramInt = localRspBody.int32_ret.get();
      if ((paramInt != 0) || (paramBundle == null)) {
        break label297;
      }
      paramInt = paramBundle.getInt("subCmd");
      if ((paramInt == 0) && (localRspBody.msg_get_stock.has()))
      {
        paramArrayOfByte = (oidb_0x6c3.GetStockRsp)localRspBody.msg_get_stock.get();
        this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopGiftCallback.a(paramArrayOfByte.int32_count.get());
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      if (QLog.isColorLevel()) {
        QLog.i(".troop.send_gift", 2, "send_oidb_0x6c3. InvalidProtocolBufferMicroException:" + paramArrayOfByte);
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopGiftCallback.a(-1, "InvalidProtocolBufferMicroException");
      return;
    }
    if ((paramInt == 1) && (localRspBody.msg_extra_data.has()))
    {
      paramArrayOfByte = (oidb_0x6c3.GetExtraDataRsp)localRspBody.msg_extra_data.get();
      paramInt = localRspBody.msg_extra_data.int32_version_seq.get();
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopGiftCallback.a(paramArrayOfByte.bytes_shop_config.get().toStringUtf8(), paramInt);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopGiftCallback.a(-1, "Invalid RspData. subCmd:" + paramInt);
    return;
    label297:
    paramArrayOfByte = localRspBody.bytes_msg.get().toStringUtf8();
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopGiftCallback.a(paramInt, paramArrayOfByte);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vrj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
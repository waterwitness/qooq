import com.tencent.litetransfersdk.LiteTransferWrapper;
import com.tencent.litetransfersdk.MsgSCBody;
import com.tencent.litetransfersdk.ProtocolHelper;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import tencent.im.cs.cmd0x346.cmd0x346.RspBody;

public class pws
  implements Runnable
{
  public pws(DataLineHandler paramDataLineHandler, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    MsgSCBody localMsgSCBody = new MsgSCBody();
    cmd0x346.RspBody localRspBody = new cmd0x346.RspBody();
    localMsgSCBody.uMsgType = 838;
    if ((this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg == null) || (this.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg == null)) {
      localMsgSCBody.bTimeOut = true;
    }
    if (this.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.FillMsgSCBody(localMsgSCBody, localRspBody, this.jdField_a_of_type_Int);
      if (this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg != null) {
        break label165;
      }
    }
    label165:
    for (long l = 0L;; l = ((Long)this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg.getAttribute("cookie")).longValue())
    {
      this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper.OnPbMsgReply(Long.valueOf(l).intValue(), localMsgSCBody);
      return;
      byte[] arrayOfByte = null;
      if (this.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getWupBuffer() != null)
      {
        int i = this.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getWupBuffer().length - 4;
        if (i < 0) {
          break;
        }
        arrayOfByte = new byte[i];
        PkgTools.a(arrayOfByte, 0, this.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getWupBuffer(), 4, i);
      }
      if (arrayOfByte == null) {
        break;
      }
      try
      {
        localRspBody.mergeFrom(arrayOfByte);
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        localInvalidProtocolBufferMicroException.printStackTrace();
      }
      break;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pws.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
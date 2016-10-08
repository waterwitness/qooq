import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyMSFService;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyMSFServlet;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;

public class hzs
  implements Runnable
{
  public hzs(ReadInJoyMSFService paramReadInJoyMSFService, ToServiceMsg paramToServiceMsg)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyMSFService", 2, "req cmd: " + this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg.getServiceCmd());
    }
    for (;;)
    {
      try
      {
        if ((!this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg.extraData.getBoolean("req_pb_protocol_flag", false)) || (this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg.getWupBuffer() == null)) {
          break label327;
        }
        long l = this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg.getWupBuffer().length;
        localObject = new byte[(int)l + 4];
        PkgTools.a((byte[])localObject, 0, 4L + l);
        PkgTools.a((byte[])localObject, 4, this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg.getWupBuffer(), (int)l);
        this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg.putWupBuffer((byte[])localObject);
        int j = 1;
        i = j;
        if (QLog.isColorLevel())
        {
          QLog.d("ReadInJoyMSFService", 2, "PB cmd: req cmd: " + this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg.getServiceCmd());
          i = j;
        }
        if (i != 0)
        {
          localObject = new NewIntent(ReadInJoyUtils.a().getApplication(), ReadInJoyMSFServlet.class);
          ((NewIntent)localObject).putExtra(ToServiceMsg.class.getSimpleName(), this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg);
          ReadInJoyUtils.a().startServlet((NewIntent)localObject);
          l = System.currentTimeMillis();
          this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg.extraData.putLong("sendtimekey", l);
        }
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder().append("handleRequest Exception. cmd=");
          if (this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg != null)
          {
            localObject = this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg.getServiceCmd();
            QLog.e("ReadInJoyMSFService", 2, (String)localObject, localException);
          }
        }
        else
        {
          localObject = new FromServiceMsg(this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg.getUin(), this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg.getServiceCmd());
          ((FromServiceMsg)localObject).setMsgFail();
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProtocolReadInJoyMSFService.a(false, this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg, (FromServiceMsg)localObject, localException);
          return;
        }
      }
      Object localObject = "";
      continue;
      label327:
      int i = 0;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hzs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
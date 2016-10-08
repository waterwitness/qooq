import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.channel.IProtocolListener;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.channel.QQStoryCmdHandler;
import com.tencent.biz.qqstory.storyHome.qqstorylist.common.AsyncJob;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.mqsafeedit.BaseApplication;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

public class iix
  extends AsyncJob
{
  public iix(QQStoryCmdHandler paramQQStoryCmdHandler, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public Void a(Void... paramVarArgs)
  {
    int i = ((Integer)this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg.getAttribute("sequence", Integer.valueOf(0))).intValue();
    int j = this.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getResultCode();
    long l = ((Long)this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg.getAttribute("sendtimekey", Long.valueOf(0L))).longValue();
    QQStoryCmdHandler.a(this.jdField_a_of_type_ComTencentBizQqstoryChannelQQStoryCmdHandler, this.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg);
    paramVarArgs = (NetworkRequest)this.jdField_a_of_type_ComTencentBizQqstoryChannelQQStoryCmdHandler.a.get(Integer.valueOf(i));
    if (paramVarArgs != null)
    {
      l = System.currentTimeMillis() - l;
      if (j == 1000)
      {
        BaseResponse localBaseResponse = paramVarArgs.a(this.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getWupBuffer());
        paramVarArgs.a().a(localBaseResponse.jdField_a_of_type_Int, localBaseResponse.jdField_a_of_type_JavaLangString, localBaseResponse);
        if (localBaseResponse.jdField_a_of_type_Int == 0) {
          SLog.b("Q.qqstory.net:QQStoryCmdHandler", "get cmd:" + this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg.getServiceCmd() + " success" + " take time:" + l);
        }
        for (;;)
        {
          StoryReportor.b("story_net", paramVarArgs.a(), 0, localBaseResponse.jdField_a_of_type_Int, new String[] { localBaseResponse.jdField_a_of_type_JavaLangString, String.valueOf(l), StoryReportor.a(BaseApplication.getContext()) });
          return null;
          SLog.d("Q.qqstory.net:QQStoryCmdHandler", "get cmd:" + this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg.getServiceCmd() + " error:" + localBaseResponse.jdField_a_of_type_Int + " msg:" + localBaseResponse.jdField_a_of_type_JavaLangString + " take time:" + l);
        }
      }
      paramVarArgs.a().a(j, "channel error", null);
      SLog.b("Q.qqstory.net:QQStoryCmdHandler", "get cmd:" + this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg.getServiceCmd() + " channel error:" + j + " take time:" + l);
      StoryReportor.b("story_net", paramVarArgs.a(), 0, j, new String[] { "channel error", String.valueOf(l), StoryReportor.a(BaseApplication.getContext()) });
      return null;
    }
    QLog.d("Q.qqstory.net:QQStoryCmdHandler", 1, "call back is null");
    return null;
  }
  
  public void a(Void paramVoid) {}
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\iix.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
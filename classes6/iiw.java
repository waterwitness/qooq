import android.os.Bundle;
import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.channel.IProtocolListener;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.storyHome.qqstorylist.common.AsyncJob;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.mqsafeedit.BaseApplication;

class iiw
  extends AsyncJob
{
  iiw(iiv paramiiv, boolean paramBoolean, Bundle paramBundle)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public Void a(Void... paramVarArgs)
  {
    long l = System.currentTimeMillis() - this.jdField_a_of_type_Iiv.jdField_a_of_type_Long;
    BaseResponse localBaseResponse;
    int i;
    if (this.jdField_a_of_type_Boolean)
    {
      paramVarArgs = this.jdField_a_of_type_AndroidOsBundle.getByteArray("data");
      if ((paramVarArgs != null) && (paramVarArgs.length > 0))
      {
        localBaseResponse = this.jdField_a_of_type_Iiv.jdField_a_of_type_ComTencentBizQqstoryChannelNetworkRequest.a(paramVarArgs);
        if (localBaseResponse != null)
        {
          this.jdField_a_of_type_Iiv.jdField_a_of_type_ComTencentBizQqstoryChannelNetworkRequest.a().a(localBaseResponse.jdField_a_of_type_Int, localBaseResponse.jdField_a_of_type_JavaLangString, localBaseResponse);
          if (localBaseResponse.jdField_a_of_type_Int == 0)
          {
            SLog.a("Q.qqstory.net:QQStoryCmdHandler", "get cmd:%s success take time:%d data length=%d respond:%s", this.jdField_a_of_type_Iiv.jdField_a_of_type_ComTencentBizQqstoryChannelNetworkRequest.a(), Long.valueOf(l), Integer.valueOf(paramVarArgs.length), localBaseResponse);
            StoryReportor.b("story_net", this.jdField_a_of_type_Iiv.jdField_a_of_type_ComTencentBizQqstoryChannelNetworkRequest.a(), 0, localBaseResponse.jdField_a_of_type_Int, new String[] { localBaseResponse.jdField_a_of_type_JavaLangString, String.valueOf(l), StoryReportor.a(BaseApplication.getContext()) });
            i = 1;
          }
        }
      }
    }
    for (;;)
    {
      if (i == 0)
      {
        this.jdField_a_of_type_Iiv.jdField_a_of_type_ComTencentBizQqstoryChannelNetworkRequest.a().a(-1, "channel error", null);
        SLog.d("Q.qqstory.net:QQStoryCmdHandler", "get cmd:" + this.jdField_a_of_type_Iiv.jdField_a_of_type_ComTencentBizQqstoryChannelNetworkRequest.a() + " channel error:%d, take time:%d", new Object[] { Integer.valueOf(-1), Long.valueOf(l) });
        StoryReportor.b("story_net", this.jdField_a_of_type_Iiv.jdField_a_of_type_ComTencentBizQqstoryChannelNetworkRequest.a(), 0, 940002, new String[] { "rsp data error", String.valueOf(l), StoryReportor.a(BaseApplication.getContext()) });
      }
      return null;
      SLog.d("Q.qqstory.net:QQStoryCmdHandler", "get cmd:%s error:%d msg:%s take time:%d data length%d", new Object[] { this.jdField_a_of_type_Iiv.jdField_a_of_type_ComTencentBizQqstoryChannelNetworkRequest.a(), Integer.valueOf(localBaseResponse.jdField_a_of_type_Int), localBaseResponse.jdField_a_of_type_JavaLangString, Long.valueOf(l), Integer.valueOf(paramVarArgs.length) });
      break;
      SLog.d("Q.qqstory.net:QQStoryCmdHandler", "get cmd:%s error. response is null", new Object[] { this.jdField_a_of_type_Iiv.jdField_a_of_type_ComTencentBizQqstoryChannelNetworkRequest.a() });
      StoryReportor.b("story_net", this.jdField_a_of_type_Iiv.jdField_a_of_type_ComTencentBizQqstoryChannelNetworkRequest.a(), 0, 940002, new String[] { "response is null", String.valueOf(l), StoryReportor.a(BaseApplication.getContext()) });
      i = 1;
      continue;
      i = 0;
    }
  }
  
  public void a(Void paramVoid) {}
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\iiw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
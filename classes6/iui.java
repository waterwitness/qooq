import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.MonitorValueRequest;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class iui
  implements CmdTaskManger.CommandCallback
{
  public iui()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(MonitorValueRequest paramMonitorValueRequest, BaseResponse paramBaseResponse, ErrorMessage paramErrorMessage)
  {
    if (paramErrorMessage.isFail()) {
      SLog.b("Q.qqstory.MonitorReport", "send monitor fail %s", paramErrorMessage);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\iui.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
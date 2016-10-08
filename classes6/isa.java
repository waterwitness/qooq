import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.StepExector.ErrorHandler;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import mqq.os.MqqHandler;

class isa
  implements StepExector.ErrorHandler
{
  isa(iry paramiry)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(ErrorMessage paramErrorMessage)
  {
    SLog.e("Q.qqstory.home.Repository", "get more data error:" + paramErrorMessage.getErrorMessage());
    int i = paramErrorMessage.errorCode;
    ThreadManager.c().post(new isb(this, i));
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\isa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
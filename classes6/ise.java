import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.Repository;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.Repository.RepositoryUpdateEvent;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.StepExector.ErrorHandler;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;
import java.util.ArrayList;

class ise
  implements StepExector.ErrorHandler
{
  ise(isc paramisc)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(ErrorMessage paramErrorMessage)
  {
    boolean bool = true;
    SLog.e("Q.qqstory.home.Repository", "get more data error:" + paramErrorMessage.getErrorMessage());
    paramErrorMessage = new Repository.RepositoryUpdateEvent();
    paramErrorMessage.jdField_a_of_type_Boolean = false;
    paramErrorMessage.c = true;
    paramErrorMessage.jdField_a_of_type_JavaLangString = "friends_story";
    if (this.a.a.e.size() == 0) {}
    for (;;)
    {
      paramErrorMessage.e = bool;
      Dispatchers.get().dispatch(paramErrorMessage);
      return;
      bool = false;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ise.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
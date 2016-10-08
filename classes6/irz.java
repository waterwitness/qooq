import com.tencent.biz.qqstory.storyHome.qqstorylist.model.Repository;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.Repository.RepositoryUpdateEvent;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.StepExector.CompletedHandler;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;
import java.util.ArrayList;

class irz
  implements StepExector.CompletedHandler
{
  irz(iry paramiry)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a()
  {
    SLog.d("Q.qqstory.home.Repository", "get more data finish!");
    Repository.RepositoryUpdateEvent localRepositoryUpdateEvent = new Repository.RepositoryUpdateEvent();
    localRepositoryUpdateEvent.jdField_a_of_type_Boolean = true;
    localRepositoryUpdateEvent.c = true;
    localRepositoryUpdateEvent.jdField_a_of_type_JavaLangString = "friends_story";
    if (this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRepository.e.size() == 0) {}
    for (boolean bool = true;; bool = false)
    {
      localRepositoryUpdateEvent.e = bool;
      Dispatchers.get().dispatch(localRepositoryUpdateEvent);
      if (this.a.jdField_a_of_type_Boolean) {
        Repository.a(this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRepository, true);
      }
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\irz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
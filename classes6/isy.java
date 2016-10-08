import android.os.Handler;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.Step;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.StepExector;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.StepExector.CompletedHandler;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public class isy
  implements Runnable
{
  public isy(StepExector paramStepExector)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.a.jdField_a_of_type_JavaUtilArrayList.size() == 0)
    {
      if (this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStepExector$CompletedHandler != null)
      {
        if (this.a.jdField_a_of_type_AndroidOsHandler != null) {
          this.a.jdField_a_of_type_AndroidOsHandler.post(new isz(this));
        }
      }
      else {
        return;
      }
      this.a.jdField_a_of_type_Int = 2;
      this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStepExector$CompletedHandler.a();
      return;
    }
    this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStep = ((Step)this.a.jdField_a_of_type_JavaUtilArrayList.get(0));
    this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStep.a();
    this.a.jdField_a_of_type_JavaUtilArrayList.remove(0);
    SLog.b("Q.qqstory.home.Repository.StepExector", "剩下step:" + this.a.jdField_a_of_type_JavaUtilArrayList.size());
    this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStep.a(this.a);
    this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStep.a(this.a);
    this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStep.a(this.a.jdField_a_of_type_JavaLangObject);
    this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStep.b();
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\isy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
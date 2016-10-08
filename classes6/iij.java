import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.videoupload.task.BasePublishTask;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class iij
  implements Runnable
{
  public iij(BasePublishTask paramBasePublishTask, int paramInt1, int paramInt2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    int i = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBasePublishTask.h = 100;
    this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBasePublishTask.g += this.b;
    if (this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBasePublishTask.g >= this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBasePublishTask.h)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBasePublishTask.g = this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBasePublishTask.h;
      i = 5;
    }
    BasePublishTask.a(this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBasePublishTask, this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBasePublishTask.g, this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBasePublishTask.h);
    if (i == 5)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBasePublishTask.a(i, new ErrorMessage());
      return;
    }
    BasePublishTask.a(this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBasePublishTask);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\iij.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
import android.os.Handler;
import android.os.Message;
import com.tencent.arrange.ui.CreateArrageActivity;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.List;

public class gdl
  implements Runnable
{
  public gdl(CreateArrageActivity paramCreateArrageActivity, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Object localObject = (DiscussionManager)this.jdField_a_of_type_ComTencentArrangeUiCreateArrageActivity.app.getManager(52);
    if (CreateArrageActivity.a(this.jdField_a_of_type_ComTencentArrangeUiCreateArrageActivity)) {}
    for (localObject = ((DiscussionManager)localObject).a(this.jdField_a_of_type_JavaLangString);; localObject = CreateArrageActivity.b(this.jdField_a_of_type_ComTencentArrangeUiCreateArrageActivity))
    {
      if (localObject != null)
      {
        CreateArrageActivity.a(this.jdField_a_of_type_ComTencentArrangeUiCreateArrageActivity, ((List)localObject).size());
        this.jdField_a_of_type_ComTencentArrangeUiCreateArrageActivity.a((List)localObject);
      }
      localObject = new Message();
      ((Message)localObject).what = 0;
      this.jdField_a_of_type_ComTencentArrangeUiCreateArrageActivity.a.sendMessage((Message)localObject);
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\gdl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
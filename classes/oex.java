import android.view.View;
import com.tencent.mobileqq.activity.aio.AIOTipsController;
import com.tencent.mobileqq.activity.aio.tips.TipsBarTask;
import com.tencent.mobileqq.activity.aio.tips.TipsManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class oex
  implements Runnable
{
  public oex(TipsManager paramTipsManager, TipsBarTask paramTipsBarTask, Object[] paramArrayOfObject)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    View localView = this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsBarTask.a(this.jdField_a_of_type_ArrayOfJavaLangObject);
    TipsManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager).a(localView);
    TipsManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager, this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsBarTask);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\oex.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
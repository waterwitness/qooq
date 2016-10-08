import com.tencent.ark.ark.Container;
import com.tencent.mobileqq.activity.aio.item.ArkContainerWrapper;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class nhz
  implements Runnable
{
  public nhz(ArkContainerWrapper paramArkContainerWrapper, boolean paramBoolean)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkContainerWrapper.a != null)
    {
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkContainerWrapper.a.ActivateRootView();
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkContainerWrapper.a.DeactivateRootView();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nhz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
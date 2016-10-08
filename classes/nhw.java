import com.tencent.mobileqq.activity.aio.item.ArkContainerWrapper;
import com.tencent.mobileqq.activity.aio.item.ArkUIView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class nhw
  implements Runnable
{
  public nhw(ArkContainerWrapper paramArkContainerWrapper)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    ArkUIView localArkUIView = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkUIView;
    if (localArkUIView != null) {
      localArkUIView.a(this.a.jdField_a_of_type_AndroidGraphicsRect);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nhw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
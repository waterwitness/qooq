import android.graphics.Rect;
import com.tencent.ark.ark.Container;
import com.tencent.mobileqq.activity.aio.item.ArkContainerWrapper;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class nih
  implements Runnable
{
  public nih(ArkContainerWrapper paramArkContainerWrapper, Rect paramRect)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkContainerWrapper.jdField_a_of_type_ComTencentArkArk$Container != null) && (!this.jdField_a_of_type_AndroidGraphicsRect.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkContainerWrapper.jdField_a_of_type_AndroidGraphicsRect)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("ark.rect", 2, String.format("setViewRect.2.rect: %s, wrapper: %s", new Object[] { this.jdField_a_of_type_AndroidGraphicsRect.toString(), this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkContainerWrapper.toString() }));
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkContainerWrapper.jdField_a_of_type_ComTencentArkArk$Container.SetSize(this.jdField_a_of_type_AndroidGraphicsRect.width(), this.jdField_a_of_type_AndroidGraphicsRect.height());
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nih.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
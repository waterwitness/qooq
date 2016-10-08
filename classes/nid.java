import android.graphics.Rect;
import com.tencent.ark.ark.Container;
import com.tencent.ark.ark.ContainerCallback;
import com.tencent.mobileqq.activity.aio.item.ArkContainerWrapper;
import com.tencent.mobileqq.activity.aio.item.ArkUIView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class nid
  implements Runnable
{
  public nid(ArkContainerWrapper paramArkContainerWrapper)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if ((this.a.jdField_a_of_type_ComTencentArkArk$Container == null) || (!this.a.f)) {
      QLog.e("ark.rect", 1, String.format("initArkContainer.attachView.0.wrapper: %s", new Object[] { this.a.toString() }));
    }
    ArkUIView localArkUIView;
    do
    {
      return;
      this.a.jdField_a_of_type_ComTencentArkArk$Container.SetContainerCallback(this.a.jdField_a_of_type_ComTencentArkArk$ContainerCallback);
      if (QLog.isColorLevel()) {
        QLog.i("ark.rect", 2, String.format("initArkContainer.attachView.1.wrapper: %s", new Object[] { this.a.toString() }));
      }
      localArkUIView = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkUIView;
      if ((this.a.jdField_a_of_type_AndroidGraphicsRect.isEmpty()) || (localArkUIView == null))
      {
        QLog.e("ark.rect", 1, String.format("initArkContainer.attachView.2.wrapper: %s", new Object[] { this.a.toString() }));
        return;
      }
      this.a.jdField_a_of_type_ComTencentArkArk$ContainerCallback.SyncRect(this.a.jdField_a_of_type_AndroidGraphicsRect.left, this.a.jdField_a_of_type_AndroidGraphicsRect.top, this.a.jdField_a_of_type_AndroidGraphicsRect.right, this.a.jdField_a_of_type_AndroidGraphicsRect.bottom);
    } while (localArkUIView == null);
    localArkUIView.a(this.a.jdField_a_of_type_AndroidGraphicsRect);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nid.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
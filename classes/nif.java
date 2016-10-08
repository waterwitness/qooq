import android.graphics.Rect;
import com.tencent.ark.ark.Container;
import com.tencent.ark.ark.ContainerCallback;
import com.tencent.mobileqq.activity.aio.item.ArkContainerWrapper;
import com.tencent.mobileqq.activity.aio.item.ArkContainerWrapper.AppInfo;
import com.tencent.mobileqq.activity.aio.item.ArkUIView;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class nif
  implements Runnable
{
  public nif(ArkContainerWrapper paramArkContainerWrapper, ArkContainerWrapper.AppInfo paramAppInfo, String paramString1, String paramString2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkContainerWrapper.d = true;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkContainerWrapper.e = true;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkContainerWrapper.jdField_a_of_type_ComTencentArkArk$Container = new ark.Container();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkContainerWrapper.jdField_a_of_type_ComTencentArkArk$Container.SetContainerCallback(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkContainerWrapper.jdField_a_of_type_ComTencentArkArk$ContainerCallback);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkContainerWrapper.jdField_a_of_type_ComTencentArkArk$Container.CreateRootView(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkContainerWrapper$AppInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkContainerWrapper$AppInfo.b, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkContainerWrapper$AppInfo.c, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkContainerWrapper$AppInfo.b, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkContainerWrapper.jdField_a_of_type_ComTencentArkArk$ApplicationCallback)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkContainerWrapper.jdField_a_of_type_ComTencentArkArk$Container.SetID(this.b);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkContainerWrapper$AppInfo.jdField_a_of_type_Int > 0) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkContainerWrapper.jdField_a_of_type_ComTencentArkArk$Container.SetSize(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkContainerWrapper$AppInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkContainerWrapper.jdField_a_of_type_AndroidGraphicsRect.height());
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkContainerWrapper.jdField_a_of_type_ComTencentArkArk$Container.SetMetadata(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkContainerWrapper$AppInfo.d, "json");
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkContainerWrapper.e = false;
    if (QLog.isColorLevel()) {
      QLog.e("ark.rect", 2, String.format("LoadArkApp.wrapper: %s  LoadArkApp successed!", new Object[] { this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkContainerWrapper.toString() }));
    }
    ??? = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkContainerWrapper.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkUIView;
    if ((!this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkContainerWrapper.f) || (??? == null)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkContainerWrapper.jdField_a_of_type_ComTencentArkArk$ContainerCallback.SyncRect(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkContainerWrapper.jdField_a_of_type_AndroidGraphicsRect.left, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkContainerWrapper.jdField_a_of_type_AndroidGraphicsRect.top, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkContainerWrapper.jdField_a_of_type_AndroidGraphicsRect.right, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkContainerWrapper.jdField_a_of_type_AndroidGraphicsRect.bottom);
    if (??? != null) {
      ((ArkUIView)???).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkContainerWrapper.jdField_a_of_type_AndroidGraphicsRect);
    }
    synchronized (ArkAppCenter.a)
    {
      ArkAppCenter.a.put(String.format("%s_%s", new Object[] { this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkContainerWrapper$AppInfo.b, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkContainerWrapper$AppInfo.c }), new Long(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkContainerWrapper.jdField_a_of_type_AndroidGraphicsRect.height()));
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nif.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
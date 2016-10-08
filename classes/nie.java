import com.tencent.mobileqq.activity.aio.item.ArkContainerWrapper;
import com.tencent.mobileqq.activity.aio.item.ArkContainerWrapper.AppInfo;
import com.tencent.mobileqq.ark.ArkLocalAppMgr.AppPathInfo;
import com.tencent.mobileqq.ark.ArkLocalAppMgr.IGetAppPathByNameCallback;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class nie
  implements ArkLocalAppMgr.IGetAppPathByNameCallback
{
  public nie(ArkContainerWrapper paramArkContainerWrapper, WeakReference paramWeakReference)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, String paramString, ArkLocalAppMgr.AppPathInfo paramAppPathInfo, Object paramObject)
  {
    paramObject = (ArkContainerWrapper.AppInfo)paramObject;
    if (QLog.isColorLevel()) {
      QLog.i("ArkApp", 2, "ark container onGetAppPathByName In!!!!");
    }
    String str = ArkContainerWrapper.a((MessageForArkApp)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkContainerWrapper.jdField_a_of_type_JavaLangRefWeakReference.get(), paramString);
    ArkContainerWrapper localArkContainerWrapper = (ArkContainerWrapper)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localArkContainerWrapper != null) {
      if (paramAppPathInfo == null) {
        break label83;
      }
    }
    label83:
    for (paramString = paramAppPathInfo.a;; paramString = null)
    {
      ((ArkContainerWrapper.AppInfo)paramObject).b = paramString;
      localArkContainerWrapper.a((ArkContainerWrapper.AppInfo)paramObject, paramInt, str);
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nie.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
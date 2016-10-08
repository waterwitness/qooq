package cooperation.qzone.remote.logic;

import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.remote.IActionListener;
import cooperation.qzone.remote.RemoteServiceProxy;
import cooperation.qzone.remote.SendMsg;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;
import yow;

public class RemoteHandleManager
{
  private static RemoteHandleManager jdField_a_of_type_CooperationQzoneRemoteLogicRemoteHandleManager;
  private static Object jdField_a_of_type_JavaLangObject = new Object();
  static final String jdField_a_of_type_JavaLangString;
  IActionListener jdField_a_of_type_CooperationQzoneRemoteIActionListener = new yow(this);
  private RemoteServiceProxy jdField_a_of_type_CooperationQzoneRemoteRemoteServiceProxy = new RemoteServiceProxy("com.qzone.common.webplugin.WebPluginHandleService", QzoneWebPluginProxyService.class, BaseApplicationImpl.a().a().getAccount());
  private RemoteRequestSender jdField_a_of_type_CooperationQzoneRemoteLogicRemoteRequestSender;
  public ArrayList a;
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(1);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = RemoteHandleManager.class.getSimpleName();
  }
  
  public RemoteHandleManager()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_CooperationQzoneRemoteRemoteServiceProxy.setActionListener(this.jdField_a_of_type_CooperationQzoneRemoteIActionListener);
  }
  
  public static RemoteHandleManager a()
  {
    if (jdField_a_of_type_CooperationQzoneRemoteLogicRemoteHandleManager == null) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_CooperationQzoneRemoteLogicRemoteHandleManager == null) {
        jdField_a_of_type_CooperationQzoneRemoteLogicRemoteHandleManager = new RemoteHandleManager();
      }
      return jdField_a_of_type_CooperationQzoneRemoteLogicRemoteHandleManager;
    }
  }
  
  protected int a(String paramString, Bundle paramBundle, long paramLong, boolean paramBoolean)
  {
    SendMsg localSendMsg = new SendMsg(paramString);
    paramString = paramBundle;
    if (paramBundle == null) {
      paramString = new Bundle();
    }
    if ((paramString != null) && (paramString.size() > 0)) {
      localSendMsg.extraData.putAll(paramString);
    }
    int i = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet();
    localSendMsg.setRequestId(i);
    if (paramLong > 0L) {
      localSendMsg.setTimeout(paramLong);
    }
    localSendMsg.setNeedCallback(paramBoolean);
    if (paramBoolean) {
      localSendMsg.actionListener = this.jdField_a_of_type_CooperationQzoneRemoteIActionListener;
    }
    try
    {
      this.jdField_a_of_type_CooperationQzoneRemoteRemoteServiceProxy.sendMsg(localSendMsg);
      return i;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      throw new RuntimeException("sendMsg is fail", paramString);
    }
  }
  
  public int a(String paramString, Bundle paramBundle, boolean paramBoolean)
  {
    try
    {
      int i = a(paramString, paramBundle, 0L, paramBoolean);
      return i;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return -1;
  }
  
  public RemoteRequestSender a()
  {
    if (this.jdField_a_of_type_CooperationQzoneRemoteLogicRemoteRequestSender == null) {
      this.jdField_a_of_type_CooperationQzoneRemoteLogicRemoteRequestSender = new RemoteRequestSender(this);
    }
    return this.jdField_a_of_type_CooperationQzoneRemoteLogicRemoteRequestSender;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "----destroy----");
    }
    if (this.jdField_a_of_type_CooperationQzoneRemoteRemoteServiceProxy != null) {
      this.jdField_a_of_type_CooperationQzoneRemoteRemoteServiceProxy.unbindBaseService();
    }
  }
  
  public void a(WebEventListener paramWebEventListener)
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(paramWebEventListener);
  }
  
  public void b(WebEventListener paramWebEventListener)
  {
    this.jdField_a_of_type_JavaUtilArrayList.remove(paramWebEventListener);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\remote\logic\RemoteHandleManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
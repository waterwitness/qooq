package cooperation.smartdevice.ipc;

import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.device.file.DevVideoMsgProcessor;
import com.tencent.device.utils.SmartDeviceReport;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.equipmentlock.EquipmentLockImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationHandler;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.smartdevice.SmartDevicePluginLoader;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import ysw;
import ysx;
import ysy;
import ysz;

public class SmartDeviceIPCHost
  implements Observer
{
  public static final String a = "SmartDeviceIPCHost";
  public ServiceConnection a;
  public QQAppInterface a;
  public ISmartDeviceService a;
  public ArrayList a;
  public boolean a;
  
  public SmartDeviceIPCHost(QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_AndroidContentServiceConnection = new ysw(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this);
    }
    for (;;)
    {
      c();
      d();
      return;
      if (QLog.isColorLevel()) {
        QLog.i("SmartDeviceIPCHost", 2, "SmartDeviceIPCHost() construct!!!!! error: app == null");
      }
    }
  }
  
  private void d()
  {
    if ((this.jdField_a_of_type_CooperationSmartdeviceIpcISmartDeviceService == null) && (!this.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_Boolean = true;
      QLog.d("SmartDeviceIPCHost", 1, "start plugin service now");
      SmartDeviceReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "Net_Start_Service_Host", 0, 0, 0);
      SmartDevicePluginLoader.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentServiceConnection);
    }
  }
  
  private void e()
  {
    PluginCommunicationHandler localPluginCommunicationHandler = PluginCommunicationHandler.getInstance();
    if (localPluginCommunicationHandler == null) {
      if (QLog.isColorLevel()) {
        QLog.d("SmartDeviceIPCHost", 2, "unregisterRemoteCommand PluginCommunicationHandler.getInstance failed");
      }
    }
    do
    {
      do
      {
        return;
      } while (!localPluginCommunicationHandler.containsCmd("com.qqsmartdevice.remotecall"));
      localPluginCommunicationHandler.unregister("com.qqsmartdevice.remotecall");
    } while (!QLog.isColorLevel());
    QLog.d("SmartDeviceIPCHost", 2, "SmartDeviceIPCHost::unregisterRemoteCommand unregister CMD:com.qqsmartdevice.remotecall");
  }
  
  public Bundle a(Bundle paramBundle)
  {
    if (paramBundle == null) {
      paramBundle = null;
    }
    for (;;)
    {
      return paramBundle;
      String str = paramBundle.getString("notify_cmd");
      if (this.jdField_a_of_type_CooperationSmartdeviceIpcISmartDeviceService == null)
      {
        boolean bool = paramBundle.getBoolean("forceStart", false);
        paramBundle = (SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
        if ((bool) || ((paramBundle != null) && (paramBundle.a())))
        {
          QLog.d("SmartDeviceIPCHost", 1, "start plugin service when send " + str);
          d();
        }
        return null;
      }
      b();
      try
      {
        paramBundle.setClassLoader(getClass().getClassLoader());
        Bundle localBundle = this.jdField_a_of_type_CooperationSmartdeviceIpcISmartDeviceService.a("com.qqsmartdevice.action.notify", paramBundle);
        paramBundle = localBundle;
        if (localBundle != null)
        {
          localBundle.setClassLoader(getClass().getClassLoader());
          return localBundle;
        }
      }
      catch (Exception paramBundle)
      {
        paramBundle.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.d("SmartDeviceIPCHost", 2, "plugin service transfer failed strNotifyCmd:" + str);
        }
      }
    }
    return null;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmartDeviceIPCHost", 2, "SmartDeviceIPCHost::OnDestory");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this);
    }
    e();
  }
  
  public void a(Bundle paramBundle)
  {
    if (paramBundle == null) {
      if (QLog.isColorLevel()) {
        QLog.d("SmartDeviceIPCHost", 2, "params is null");
      }
    }
    Object localObject;
    do
    {
      boolean bool;
      SmartDeviceProxyMgr localSmartDeviceProxyMgr;
      do
      {
        return;
        localObject = paramBundle.getString("notify_cmd");
        if (this.jdField_a_of_type_CooperationSmartdeviceIpcISmartDeviceService != null) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("SmartDeviceIPCHost", 2, "plugin service not started strNotifyCmd:" + (String)localObject + " cached");
        }
        bool = paramBundle.getBoolean("forceStart", false);
        localSmartDeviceProxyMgr = (SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
      } while ((!bool) && ((localSmartDeviceProxyMgr == null) || (!localSmartDeviceProxyMgr.a())));
      QLog.d("SmartDeviceIPCHost", 1, "start plugin service when post " + (String)localObject);
      d();
      localObject = Looper.getMainLooper();
      if (Thread.currentThread() != ((Looper)localObject).getThread())
      {
        new Handler((Looper)localObject).post(new ysx(this, paramBundle));
        return;
      }
      this.jdField_a_of_type_JavaUtilArrayList.add(paramBundle);
      b();
      return;
      b();
      if (paramBundle != null) {}
      try
      {
        paramBundle.setClassLoader(getClass().getClassLoader());
        this.jdField_a_of_type_CooperationSmartdeviceIpcISmartDeviceService.a("com.qqsmartdevice.action.notify", paramBundle);
        return;
      }
      catch (RemoteException paramBundle)
      {
        paramBundle.printStackTrace();
      }
    } while (!QLog.isColorLevel());
    QLog.d("SmartDeviceIPCHost", 2, " plugin service transfer failed strNotifyCmd:" + (String)localObject);
  }
  
  public Bundle b(Bundle paramBundle)
  {
    Object localObject = paramBundle.getString("invoke_cmd");
    if ((QLog.isColorLevel()) && (!"invokeCmdGetFaceBitmap".equals(localObject))) {
      QLog.i("SmartDeviceIPCHost", 2, "SmartDeviceIPCHost::OnRemoteInvoke strNotifyCmd:" + (String)localObject);
    }
    if (((String)localObject).compareToIgnoreCase("invokeCmdOpenChatMsgActivity") == 0) {
      ((SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51)).a(paramBundle);
    }
    do
    {
      return null;
      if (((String)localObject).equals("SmartDeviceHandler_makeSureProxyServiceStart"))
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(50);
        if (this.jdField_a_of_type_CooperationSmartdeviceIpcISmartDeviceService != null)
        {
          SmartDeviceReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "Net_Start_Service_Remote", 0, 1, 0);
          return null;
        }
        this.jdField_a_of_type_Boolean = false;
        QLog.d("SmartDeviceIPCHost", 1, "try to start service again");
        d();
        SmartDeviceReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "Net_Start_Service_Remote", 0, 0, 0);
        return null;
      }
      if (((String)localObject).compareToIgnoreCase("invokeCmdStartVideoChat") == 0)
      {
        ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext(), 9500, paramBundle.getString("din"), paramBundle.getString("devName"), "", false, paramBundle.getString("tinyid"), true, false, null, "from_internal");
        return null;
      }
      if (((String)localObject).compareToIgnoreCase("invokeCmdStartVideoMessage") == 0)
      {
        DevVideoMsgProcessor.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext(), paramBundle.getString("din"), paramBundle.getString("videoPath"));
        return null;
      }
      if (((String)localObject).compareToIgnoreCase("invokeCmdGetBuddyName") == 0)
      {
        paramBundle = paramBundle.getString("Uin");
        paramBundle = ContactUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBundle, true);
        localObject = new Bundle();
        ((Bundle)localObject).putString("BuddyName", paramBundle);
        return (Bundle)localObject;
      }
      if (((String)localObject).compareToIgnoreCase("invokeCmdTransFileController") == 0)
      {
        ((SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51)).b(paramBundle);
        return null;
      }
      if (((String)localObject).compareToIgnoreCase("invokeCmdGetLockState") == 0)
      {
        int i = EquipmentLockImpl.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.a());
        paramBundle = new Bundle();
        paramBundle.putInt("LockState", i);
        return paramBundle;
      }
      if (((String)localObject).compareToIgnoreCase("qfind_localnotify") == 0)
      {
        long l = paramBundle.getLong("din");
        paramBundle = paramBundle.getString("msg");
        localObject = (MessageForText)MessageRecordFactory.a(64536);
        ((MessageForText)localObject).msgtype = 64536;
        ((MessageForText)localObject).istroop = 9501;
        ((MessageForText)localObject).issend = 0;
        ((MessageForText)localObject).isread = false;
        ((MessageForText)localObject).selfuin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        ((MessageForText)localObject).senderuin = (l + "");
        ((MessageForText)localObject).frienduin = (l + "");
        ((MessageForText)localObject).msg = paramBundle;
        ((MessageForText)localObject).time = (NetConnInfoCenter.getServerTimeMillis() / 1000L);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((MessageRecord)localObject);
        return null;
      }
      if (((String)localObject).compareToIgnoreCase("init_msgHandler") == 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(49);
        return null;
      }
    } while (((String)localObject).compareToIgnoreCase("invokeCmdGetFaceBitmap") != 0);
    paramBundle = paramBundle.getString("uin");
    paramBundle = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramBundle, true);
    localObject = new Bundle();
    ((Bundle)localObject).putParcelable("face_bitmap", paramBundle);
    return (Bundle)localObject;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) || (this.jdField_a_of_type_CooperationSmartdeviceIpcISmartDeviceService == null)) {}
    for (;;)
    {
      return;
      Object localObject1 = Looper.getMainLooper();
      if (Thread.currentThread() != ((Looper)localObject1).getThread())
      {
        new Handler((Looper)localObject1).post(new ysy(this));
        return;
      }
      while (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty())
      {
        Bundle localBundle = (Bundle)this.jdField_a_of_type_JavaUtilArrayList.remove(0);
        localObject1 = "";
        Object localObject2 = localObject1;
        if (localBundle != null) {}
        try
        {
          localObject2 = localBundle.getString("notify_cmd");
          localObject1 = localObject2;
          localBundle.setClassLoader(getClass().getClassLoader());
          localObject1 = localObject2;
          if (QLog.isColorLevel())
          {
            localObject1 = localObject2;
            QLog.d("SmartDeviceIPCHost", 2, "qq->plugin main thread doPostCachedMsg strNotifyCmd:" + (String)localObject2 + " thread:" + Thread.currentThread());
          }
          localObject1 = localObject2;
          this.jdField_a_of_type_CooperationSmartdeviceIpcISmartDeviceService.a("com.qqsmartdevice.action.notify", localBundle);
        }
        catch (RemoteException localRemoteException)
        {
          localRemoteException.printStackTrace();
        }
        if (QLog.isColorLevel()) {
          QLog.d("SmartDeviceIPCHost", 2, "mSmartDeviceService.transfer failed strNotifyCmd:" + (String)localObject1);
        }
      }
    }
  }
  
  public void c()
  {
    PluginCommunicationHandler localPluginCommunicationHandler = PluginCommunicationHandler.getInstance();
    if (localPluginCommunicationHandler == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SmartDeviceIPCHost", 2, "PluginCommunicationHandler.getInstance failed");
      }
      return;
    }
    localPluginCommunicationHandler.register(new ysz(this, "com.qqsmartdevice.remotecall"));
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject instanceof MessageRecord))
    {
      paramObservable = (MessageRecord)paramObject;
      if (paramObservable.istroop == 9501)
      {
        int i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramObservable.frienduin, 9501);
        paramObject = new Bundle();
        ((Bundle)paramObject).putString("notify_cmd", "updateUnreadMsgsNum");
        ((Bundle)paramObject).putString("din", paramObservable.frienduin);
        ((Bundle)paramObject).putInt("unread", i);
        a((Bundle)paramObject);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\smartdevice\ipc\SmartDeviceIPCHost.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
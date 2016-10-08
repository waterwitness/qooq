import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.text.TextUtils;
import com.tencent.av.app.AvAddFriendService;
import com.tencent.av.app.PstnSessionInfo;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.service.IQQServiceCallback;
import com.tencent.av.service.IQQServiceForAV.Stub;
import com.tencent.av.service.IQQServiceLocationCallback;
import com.tencent.av.service.QQServiceForAV;
import com.tencent.av.service.UtilsServiceForAV;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.device.DeviceHeadMgr;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.device.utils.SmartDeviceUtil;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.LBSHandler;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.NearbyFlowerManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.message.OfflineFileMessageProcessor;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.earlydownload.EarlyDownloadManager;
import com.tencent.mobileqq.earlydownload.handler.QavSoDownloadHandler;
import com.tencent.mobileqq.earlydownload.handler.QavSoDownloadHandlerV7;
import com.tencent.mobileqq.earlydownload.handler.QavVideoDownloadHandler;
import com.tencent.mobileqq.filemanager.data.FMTransC2CMsgInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.nearby.NearbyFlowerAnimationController;
import com.tencent.mobileqq.nearby.business.NearbyCardHandler;
import com.tencent.mobileqq.qcall.OpenSDKUtils;
import com.tencent.mobileqq.qcall.PstnCardInfo;
import com.tencent.mobileqq.qcall.PstnManager;
import com.tencent.mobileqq.qcall.PstnSwitchConfig;
import com.tencent.mobileqq.qcall.QCallCardHandler;
import com.tencent.mobileqq.qcall.QCallCardInfo;
import com.tencent.mobileqq.qcall.QCallCardManager;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad;
import com.tencent.mobileqq.troop.utils.TroopGiftManager;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;

public class gnq
  extends IQQServiceForAV.Stub
{
  public gnq(QQServiceForAV paramQQServiceForAV)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private void a(IBinder paramIBinder)
  {
    Intent localIntent = new Intent(this.a.getApplicationContext(), UtilsServiceForAV.class);
    this.a.getApplicationContext().stopService(localIntent);
    if (QQServiceForAV.jdField_a_of_type_AndroidOsIBinder == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQServiceForAV", 2, "linkToVideoProcessDeath");
      }
      QQServiceForAV.jdField_a_of_type_AndroidOsIBinder = paramIBinder;
    }
    try
    {
      QQServiceForAV.jdField_a_of_type_AndroidOsIBinder.linkToDeath(new gnr(this), 0);
      return;
    }
    catch (RemoteException paramIBinder)
    {
      do
      {
        QQServiceForAV.jdField_a_of_type_AndroidOsIBinder = null;
      } while (!QLog.isColorLevel());
      QLog.d("QQServiceForAV", 2, "linkToVideoProcessDeath", paramIBinder);
    }
  }
  
  public int a()
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.a.a());
    }
    return ((PhoneContactManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10)).d();
  }
  
  public int a(String paramString)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.a.a());
    }
    return ((DiscussionManager)QQServiceForAV.d(this.a).getManager(52)).a(paramString);
  }
  
  public long a(String paramString)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.a.a());
    }
    return this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString);
  }
  
  public Bitmap a(int paramInt, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQServiceForAV", 2, "getFaceBitmap uinType = " + paramInt + ", uin = " + paramString1 + ", extraUin = " + paramString2 + ", isRound = " + paramBoolean1);
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.a.a());
    }
    byte b;
    if (paramBoolean1)
    {
      b = 3;
      switch (paramInt)
      {
      default: 
        paramString2 = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramString1, b, true);
      }
    }
    for (;;)
    {
      if (paramString2 == null)
      {
        if (!this.a.jdField_b_of_type_JavaUtilArrayList.contains(paramString1)) {
          this.a.jdField_b_of_type_JavaUtilArrayList.add(paramString1);
        }
        this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.a.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      }
      paramString1 = paramString2;
      if (paramString2 == null)
      {
        paramString1 = paramString2;
        if (paramBoolean2)
        {
          if (QLog.isColorLevel()) {
            QLog.w("QQServiceForAV", 2, "getFaceBitmap failed, use default face!");
          }
          if (paramInt != 1) {
            break label614;
          }
          paramString1 = ImageUtil.f();
        }
      }
      return paramString1;
      b = 1;
      break;
      paramString2 = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramString1, b, true);
      continue;
      paramString2 = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramString1, b, false, false);
      continue;
      paramString2 = (BitmapDrawable)((DiscussionHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(6)).a(paramString1, false);
      if (paramString2 != null)
      {
        paramString2 = paramString2.getBitmap();
        continue;
        if (!paramString1.startsWith("+")) {}
        for (;;)
        {
          paramString2 = FaceDrawable.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString2, b).a();
          break;
          paramString2 = FaceDrawable.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 200, paramString1, true).a();
          break;
          paramString2 = ((SmartDeviceProxyMgr)((QQAppInterface)BaseApplicationImpl.a().a()).a(51)).a(Long.parseLong(paramString1));
          paramString2 = DeviceHeadMgr.a().a(paramString2.productId);
          break;
          Object localObject = (PhoneContactManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
          if ((localObject != null) && (paramString2 != null)) {}
          for (localObject = ((PhoneContactManager)localObject).c(paramString2);; localObject = null)
          {
            if (QLog.isColorLevel()) {
              QLog.d("QQServiceForAV", 2, "getFaceBitmap contact = " + localObject);
            }
            if (localObject != null)
            {
              paramString2 = FaceDrawable.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString2, b).a();
              break;
            }
            paramString2 = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(16, paramString1, (byte)3, true, 16);
            break;
            paramString2 = OpenSDKUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString2);
            break;
            label614:
            if (paramInt == 3000) {
              return ImageUtil.g();
            }
            return ImageUtil.a();
          }
          paramString2 = paramString1;
        }
      }
      else
      {
        paramString2 = null;
      }
    }
  }
  
  public String a()
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.a.a());
    }
    return ((TicketManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(2)).getSkey(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
  }
  
  public String a(int paramInt, String paramString1, String paramString2)
  {
    Object localObject2 = null;
    if (QLog.isColorLevel()) {
      QLog.d("QQServiceForAV", 2, "getDisplayName uinType = " + paramInt + ", uin = " + paramString1 + ", extraUin = " + paramString2);
    }
    if ((paramString1 == null) || (paramString1.trim().length() == 0))
    {
      paramString2 = "";
      return paramString2;
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.a.a());
    }
    if (paramInt == 1006)
    {
      if (paramString1.startsWith("+")) {
        break label951;
      }
      if ((paramString2 == null) || (!paramString2.startsWith("+"))) {}
    }
    label260:
    label398:
    label937:
    label942:
    label951:
    for (Object localObject1 = paramString2;; localObject1 = paramString1)
    {
      localObject2 = (PhoneContactManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
      if (localObject2 != null) {}
      for (localObject2 = ((PhoneContactManager)localObject2).c((String)localObject1);; localObject2 = null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQServiceForAV", 2, "getDisplayName contact = " + localObject2);
        }
        if (localObject2 != null)
        {
          return ((PhoneContact)localObject2).name;
          return "";
        }
        Object localObject3 = ContactUtils.f(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject1);
        localObject2 = localObject3;
        if (localObject3 == null)
        {
          if (!paramString1.startsWith("+")) {
            break label942;
          }
          if ((paramString2 == null) || (paramString2.startsWith("+"))) {
            break label398;
          }
          paramString1 = paramString2;
        }
        for (;;)
        {
          localObject2 = paramString1;
          if (paramString1 != null)
          {
            ContactUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject1, paramString1);
            localObject2 = paramString1;
          }
          if (localObject2 != null)
          {
            paramString1 = (FriendsManager)QQServiceForAV.a(this.a).getManager(50);
            if (paramString1 == null) {
              break label937;
            }
          }
          for (paramString1 = paramString1.c((String)localObject2);; paramString1 = null)
          {
            if (paramString1 != null) {}
            for (paramString1 = ContactUtils.a(paramString1);; paramString1 = null)
            {
              if ((paramString1 == null) || (paramString1.equals(localObject2)))
              {
                paramString1 = (FriendListHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1);
                paramString2 = (String)localObject1;
                if (paramString1 == null) {
                  break;
                }
                this.a.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
                this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.a.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
                paramString1.b((String)localObject2);
                return (String)localObject1;
                paramString1 = null;
                break label260;
              }
              return paramString1;
              if (paramInt == 26) {
                return OpenSDKUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString2);
              }
              if (paramInt == 25)
              {
                localObject3 = (PhoneContactManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
                localObject1 = localObject2;
                if (localObject3 != null)
                {
                  localObject1 = localObject2;
                  if (paramString2 != null) {
                    localObject1 = ((PhoneContactManager)localObject3).c(paramString2);
                  }
                }
                if (QLog.isColorLevel()) {
                  QLog.d("QQServiceForAV", 2, "getDisplayName contact = " + localObject1);
                }
                if (localObject1 != null) {
                  return ((PhoneContact)localObject1).name;
                }
                localObject1 = ((QCallCardManager)QQServiceForAV.b(this.a).getManager(139)).a(paramString1);
                localObject2 = (QCallCardHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(79);
                ((QCallCardHandler)localObject2).a(paramString1);
                ((QCallCardHandler)localObject2).a(this.a.jdField_a_of_type_ComTencentMobileqqQcallQCallCardHandler$OnGetQCallCardListener);
                if ((localObject1 != null) && (((QCallCardInfo)localObject1).nickname != null)) {
                  return ((QCallCardInfo)localObject1).nickname;
                }
              }
              if (paramInt == 1)
              {
                if (!TextUtils.isEmpty(paramString2)) {
                  return ContactUtils.f(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, paramString2);
                }
                return ContactUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, false);
              }
              if (paramInt == 9500) {}
              try
              {
                localObject1 = ((SmartDeviceProxyMgr)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51)).a(Long.parseLong(paramString1));
                paramString2 = paramString1;
                if (localObject1 == null) {
                  return paramString2;
                }
                paramString2 = SmartDeviceUtil.a((DeviceInfo)localObject1);
              }
              catch (Throwable paramString2)
              {
                for (;;)
                {
                  int i;
                  if (QLog.isColorLevel()) {
                    QLog.d("QQServiceForAV", 2, "getDisplayName", paramString2);
                  }
                  localObject1 = "";
                }
              }
              i = ContactUtils.b(paramInt);
              if (i == -1) {}
              for (paramString2 = ContactUtils.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, paramInt);; paramString2 = ContactUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, paramString2, i, 0))
              {
                if (!TextUtils.isEmpty(paramString2))
                {
                  localObject1 = paramString2;
                  if (!paramString1.equals(paramString2)) {}
                }
                else
                {
                  localObject1 = ContactUtils.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, true);
                }
                boolean bool = TextUtils.isEmpty((CharSequence)localObject1);
                if (bool) {
                  localObject1 = paramString1;
                }
                paramString2 = (String)localObject1;
                if (!paramString1.equals(localObject1)) {
                  break;
                }
                paramString2 = (FriendsManager)QQServiceForAV.c(this.a).getManager(50);
                localObject2 = localObject1;
                if (paramString2 != null)
                {
                  paramString2 = paramString2.c(paramString1);
                  localObject2 = localObject1;
                  if (paramString2 != null) {
                    localObject2 = ContactUtils.a(paramString2);
                  }
                }
                if (!paramString1.equals(localObject2))
                {
                  paramString2 = (String)localObject2;
                  if (!TextUtils.isEmpty((CharSequence)localObject2)) {
                    break;
                  }
                }
                localObject1 = (FriendListHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1);
                paramString2 = (String)localObject2;
                if (localObject1 == null) {
                  break;
                }
                this.a.jdField_a_of_type_JavaUtilArrayList.add(paramString1);
                this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.a.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
                ((FriendListHandler)localObject1).b(paramString1);
                return (String)localObject2;
              }
            }
          }
        }
      }
    }
    return paramString2;
  }
  
  public String a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.a.a());
    }
    PhoneContactManager localPhoneContactManager = (PhoneContactManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
    if (localPhoneContactManager == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QQServiceForAV", 2, "getPhoneNameByPhoneNum --> can not get PhoneContactManager");
      }
      return null;
    }
    paramString = localPhoneContactManager.b(paramString);
    if ((paramString == null) || (paramString.name == null))
    {
      if (QLog.isColorLevel()) {
        QLog.e("QQServiceForAV", 2, "getPhoneNameByPhoneNum --> can not get phoneContact Or Name");
      }
      return null;
    }
    return paramString.name;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQServiceForAV", 2, "stopPumpMessage");
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.a.a());
    }
    this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this.a);
  }
  
  public void a(int paramInt)
  {
    Object localObject1 = (EarlyDownloadManager)QQServiceForAV.g(this.a).getManager(76);
    if (localObject1 != null)
    {
      Object localObject2 = (QavSoDownloadHandler)((EarlyDownloadManager)localObject1).a("qq.android.qav.so");
      if (localObject2 != null) {
        ((QavSoDownloadHandler)localObject2).a(false);
      }
      localObject2 = (QavSoDownloadHandlerV7)((EarlyDownloadManager)localObject1).a("qq.android.qav.sov7");
      if (localObject2 != null) {
        ((QavSoDownloadHandlerV7)localObject2).a(false);
      }
    }
    if (localObject1 != null)
    {
      localObject1 = (QavVideoDownloadHandler)((EarlyDownloadManager)localObject1).a("qq.android.qav.video");
      if (localObject1 != null) {
        ((QavVideoDownloadHandler)localObject1).a(false);
      }
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.a.a());
    }
    this.a.jdField_a_of_type_Int = paramInt;
    this.a.jdField_c_of_type_JavaLangString = paramString;
    this.a.jdField_c_of_type_Long = MessageCache.a();
    this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this.a);
    if (QLog.isColorLevel()) {
      QLog.d("QQServiceForAV", 2, "startPumpMessage uinType = " + paramInt + ", peerUin = " + paramString + ",mStartTime:" + this.a.jdField_c_of_type_Long);
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.a.a());
    }
    this.a.jdField_a_of_type_Int = paramInt;
    this.a.jdField_c_of_type_JavaLangString = paramString1;
    this.a.e = paramString2;
    this.a.jdField_c_of_type_Long = MessageCache.a();
    if (QLog.isColorLevel()) {
      QLog.d("QQServiceForAV", 2, "setPeerInfo uinType = " + paramInt + ", peerUin = " + paramString1 + ", extraUin = " + paramString2 + ",mStartTime:" + this.a.jdField_c_of_type_Long);
    }
  }
  
  public void a(long paramLong)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.a.a());
    }
    this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramLong);
  }
  
  public void a(long paramLong, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQServiceForAV", 2, "reportGVideoOnlineTime uin = " + paramLong + " troopuin = " + paramString + " onlineTime" + paramInt);
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.a.a());
    }
    this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.a.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    TroopHandler localTroopHandler = (TroopHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20);
    if (localTroopHandler != null) {
      try
      {
        localTroopHandler.a(paramLong, Long.parseLong(paramString), paramInt);
        return;
      }
      catch (NumberFormatException paramString)
      {
        while (!QLog.isColorLevel()) {}
        QLog.e("QQServiceForAV", 2, "getGVideoLevelInfo NumberFormatException !", paramString);
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.e("QQServiceForAV", 2, "getGVideoLevelInfo-->can not get TroopHandle");
    }
    this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.a.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
  }
  
  public void a(IQQServiceCallback paramIQQServiceCallback)
  {
    if (paramIQQServiceCallback != null)
    {
      this.a.jdField_a_of_type_AndroidOsRemoteCallbackList.register(paramIQQServiceCallback);
      if (QLog.isColorLevel()) {
        QLog.d("QQServiceForAV", 2, "registerCallback");
      }
      a(paramIQQServiceCallback.asBinder());
    }
  }
  
  public void a(IQQServiceLocationCallback paramIQQServiceLocationCallback)
  {
    if (paramIQQServiceLocationCallback == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQServiceForAV", 2, "getAddressConfig IQQServiceLocationCallback is null");
      }
      return;
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.a.a());
    }
    ConditionSearchManager localConditionSearchManager = (ConditionSearchManager)QQServiceForAV.f(this.a).getManager(58);
    if (localConditionSearchManager != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQServiceForAV", 2, "getAddressConfig for IQQServiceLocationCallback");
      }
      if (localConditionSearchManager.a() == 1)
      {
        if (localConditionSearchManager.a(localConditionSearchManager.a()) == 0)
        {
          if (QQServiceForAV.a(this.a) == null) {
            QQServiceForAV.a(this.a, new gno(this, localConditionSearchManager, paramIQQServiceLocationCallback));
          }
          for (;;)
          {
            localConditionSearchManager.c(QQServiceForAV.a(this.a));
            return;
            QQServiceForAV.a(this.a).a(paramIQQServiceLocationCallback);
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("QQServiceForAV", 2, "ConditionSearchManager update RESULT_UPDATE_REMOTE fail");
        }
        a(false, paramIQQServiceLocationCallback);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QQServiceForAV", 2, "ConditionSearchManager config exist");
      }
      a(true, paramIQQServiceLocationCallback);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQServiceForAV", 2, "Get ConditionSearchManager null");
    }
    a(false, paramIQQServiceLocationCallback);
  }
  
  public void a(String paramString)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.a.a());
    }
    NearbyCardHandler localNearbyCardHandler = (NearbyCardHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(60);
    this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.a.jdField_a_of_type_ComTencentMobileqqNearbyBusinessNearbyCardObserver);
    localNearbyCardHandler.a(paramString);
  }
  
  public void a(String paramString, long paramLong)
  {
    Object localObject = (TroopGiftManager)QQServiceForAV.j(this.a).getManager(112);
    if (localObject != null) {
      ((TroopGiftManager)localObject).a(paramString);
    }
    if ((paramLong > 0L) && ((QQServiceForAV.k(this.a) instanceof QQAppInterface)))
    {
      localObject = (QQAppInterface)QQServiceForAV.l(this.a);
      SessionInfo localSessionInfo = new SessionInfo();
      localSessionInfo.jdField_a_of_type_JavaLangString = paramString;
      localSessionInfo.jdField_a_of_type_Int = 1;
      ChatActivityFacade.a((QQAppInterface)localObject, localSessionInfo);
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQServiceForAV", 2, "sendMessageToTroop");
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.a.a());
      return;
    }
    paramString2 = MessageRecordFactory.a(64536);
    long l = MessageCache.a();
    paramString2.init(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramString3, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramString1, l, 64536, 1, l);
    paramString2.issend = 1;
    this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString2, null);
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQServiceForAV", 2, "listenTroopListUpdate bListen = " + paramBoolean);
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      if (paramBoolean) {
        this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(QQServiceForAV.a(this.a));
      }
    }
    else {
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(QQServiceForAV.a(this.a));
  }
  
  public void a(boolean paramBoolean, IQQServiceLocationCallback paramIQQServiceLocationCallback)
  {
    int i;
    if (paramBoolean) {
      i = 0;
    }
    try
    {
      for (;;)
      {
        paramIQQServiceLocationCallback.a(i, "admin_region_config");
        return;
        i = -26;
      }
    }
    catch (RemoteException paramIQQServiceLocationCallback)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("QQServiceForAV", 2, "Call onGetAddressConfig fail", paramIQQServiceLocationCallback);
    }
  }
  
  public void a(long[] paramArrayOfLong, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQServiceForAV", 2, "getGVideoLevelInfo uins = " + paramArrayOfLong.toString() + " troopuin = " + paramString);
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.a.a());
    }
    this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.a.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    TroopHandler localTroopHandler = (TroopHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20);
    if (localTroopHandler != null) {
      try
      {
        localTroopHandler.a(paramArrayOfLong, Long.parseLong(paramString));
        return;
      }
      catch (NumberFormatException paramArrayOfLong)
      {
        while (!QLog.isColorLevel()) {}
        QLog.e("QQServiceForAV", 2, "getGVideoLevelInfo NumberFormatException !", paramArrayOfLong);
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.e("QQServiceForAV", 2, "getGVideoLevelInfo-->can not get TroopHandle");
    }
    this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.a.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
  }
  
  public boolean a()
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.a.a());
    }
    return this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackground_Pause;
  }
  
  public boolean a(long paramLong)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.a.a());
    }
    return this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(2, paramLong) > 0L;
  }
  
  public boolean a(String paramString)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.a.a());
    }
    return ((FriendsManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).b(paramString);
  }
  
  public boolean a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQServiceForAV", 2, "requestDecodeStrangeFace");
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.a.a());
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder == null)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = new FaceDecoder(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext(), this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.a.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(this.a.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder$DecodeTaskCompletionListener);
    }
    if (paramInt == 25) {
      return this.a.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.c(paramString, 16, true, false);
    }
    return this.a.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(paramString, 200, true, false);
  }
  
  public boolean a(String paramString, int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.a.a());
    }
    FMTransC2CMsgInfo localFMTransC2CMsgInfo = new FMTransC2CMsgInfo();
    localFMTransC2CMsgInfo.subCmd = paramInt2;
    if (QLog.isColorLevel()) {
      QLog.e("QQServiceForAV", 2, "send0x211C2CMsg");
    }
    return this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(paramString, paramInt1, paramArrayOfByte, localFMTransC2CMsgInfo);
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQServiceForAV", 2, "queryTroopMember troopUin = " + paramString1 + "memUin:" + paramString2);
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      TroopManager localTroopManager = (TroopManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
      if ((localTroopManager != null) && (localTroopManager.a(paramString1, paramString2) == null)) {
        return false;
      }
    }
    return true;
  }
  
  public boolean a(String paramString, boolean paramBoolean)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.a.a());
    }
    this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.a.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    TroopHandler localTroopHandler = (TroopHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20);
    if (localTroopHandler != null) {
      try
      {
        localTroopHandler.f(paramString, paramBoolean);
        return true;
      }
      catch (Exception paramString)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.a.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
        if (QLog.isColorLevel()) {
          QLog.e("QQServiceForAV", 2, "joinOrExitOpenTroop-->error,e=" + paramString.getMessage());
        }
        return false;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.e("QQServiceForAV", 2, "joinOrExitOpenTroop-->can not get TroopHandle");
    }
    this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.a.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    return false;
  }
  
  public int[] a()
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.a.a());
    }
    int[] arrayOfInt = new int[3];
    PstnManager localPstnManager = (PstnManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(142);
    if (localPstnManager != null)
    {
      arrayOfInt[0] = localPstnManager.a().g;
      arrayOfInt[1] = localPstnManager.a().h;
      arrayOfInt[2] = localPstnManager.a().i;
    }
    return arrayOfInt;
  }
  
  public long[] a(String paramString)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.a.a());
    }
    paramString = ((DiscussionManager)QQServiceForAV.e(this.a).getManager(52)).a(paramString);
    if (paramString != null)
    {
      int j = paramString.size();
      long[] arrayOfLong = new long[j];
      int i = 0;
      while (i < j)
      {
        DiscussionMemberInfo localDiscussionMemberInfo = (DiscussionMemberInfo)paramString.get(i);
        if (localDiscussionMemberInfo != null) {
          arrayOfLong[i] = Long.valueOf(localDiscussionMemberInfo.memberUin).longValue();
        }
        i += 1;
      }
      return arrayOfLong;
    }
    return null;
  }
  
  public String[] a(String paramString)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      TroopManager localTroopManager = (TroopManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
      if (localTroopManager != null)
      {
        paramString = localTroopManager.a(paramString);
        if (paramString == null) {
          return new String[0];
        }
        if (!TextUtils.isEmpty(paramString.Administrator)) {
          return paramString.Administrator.split("\\|");
        }
      }
    }
    return new String[0];
  }
  
  public int b()
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.a.a());
    }
    PstnManager localPstnManager = (PstnManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(142);
    if ((localPstnManager != null) && (localPstnManager.a() == 1)) {
      return 1;
    }
    return 0;
  }
  
  public int b(String paramString)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.a.a());
    }
    return this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramString);
  }
  
  public String b(String paramString)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      TroopManager localTroopManager = (TroopManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
      if (localTroopManager != null)
      {
        paramString = localTroopManager.a(paramString);
        if (paramString == null) {
          return null;
        }
        return paramString.troopowneruin;
      }
    }
    return null;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.e("QQServiceForAV", 2, "avStartAddFriendService");
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.a.a());
    }
    this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
  }
  
  public void b(int paramInt, String paramString)
  {
    this.a.jdField_b_of_type_JavaLangString = paramString;
    this.a.jdField_b_of_type_Int = paramInt;
  }
  
  public void b(IQQServiceCallback paramIQQServiceCallback)
  {
    if (paramIQQServiceCallback != null) {
      this.a.jdField_a_of_type_AndroidOsRemoteCallbackList.unregister(paramIQQServiceCallback);
    }
  }
  
  public void b(IQQServiceLocationCallback paramIQQServiceLocationCallback)
  {
    if (paramIQQServiceLocationCallback == null) {
      if (QLog.isColorLevel()) {
        QLog.d("QQServiceForAV", 2, "getUserCurrentLocation IQQServiceLocationCallback is null, no need notify");
      }
    }
    do
    {
      do
      {
        return;
        if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
          this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.a.a());
        }
        if ((this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() == null) || (!NetworkUtil.e(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext()))) {
          break;
        }
        if (QQServiceForAV.a(this.a) == null) {
          QQServiceForAV.a(this.a, new gnp());
        }
        QQServiceForAV.a(this.a).a(paramIQQServiceLocationCallback);
        if (QQServiceForAV.a(this.a).a() == 1)
        {
          this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(QQServiceForAV.a(this.a));
          ((LBSHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(3)).b();
          return;
        }
      } while (!QLog.isColorLevel());
      QLog.d("QQServiceForAV", 2, "We are waiting getUserCurrentLocation response, so need't request again");
      return;
      try
      {
        paramIQQServiceLocationCallback.a(false, null);
        return;
      }
      catch (RemoteException paramIQQServiceLocationCallback) {}
    } while (!QLog.isColorLevel());
    QLog.e("QQServiceForAV", 2, "Call getUserCurrentLocation fail", paramIQQServiceLocationCallback);
  }
  
  public void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.e("QQServiceForAV", 2, "acceptAddFriend :" + paramString);
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.a.a());
    }
    this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramString);
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.a.a());
    }
    SharedPreferences localSharedPreferences = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext().getSharedPreferences("qav_SP", 0);
    SharedPreferences.Editor localEditor = localSharedPreferences.edit();
    if (paramBoolean)
    {
      localEditor.putBoolean("qav_random_speakeron", true);
      localEditor.commit();
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQServiceForAV", 2, "qav_random_speakeron: " + localSharedPreferences.getBoolean("qav_random_speakeron", false));
      }
      return;
      localEditor.putBoolean("qav_random_speakeron", false);
      localEditor.commit();
    }
  }
  
  public boolean b()
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.a.a());
    }
    return this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
  }
  
  public boolean b(long paramLong)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.a.a());
    }
    this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.a.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    TroopHandler localTroopHandler = (TroopHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20);
    if (localTroopHandler != null) {
      try
      {
        localTroopHandler.a(paramLong, 0L, 2, null, 0, 0);
        return true;
      }
      catch (Exception localException)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.a.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
        if (QLog.isColorLevel()) {
          QLog.e("QQServiceForAV", 2, "getAdminMemberList-->error,e=" + localException.getMessage());
        }
        return false;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.e("QQServiceForAV", 2, "getAdminMemberList-->can not get TroopHandle");
    }
    this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.a.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    return false;
  }
  
  public boolean b(String paramString)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.a.a());
    }
    return this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(paramString);
  }
  
  public boolean b(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("QQServiceForAV", 2, "avAddFriend :" + paramString);
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.a.a());
    }
    return this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, paramInt);
  }
  
  public long[] b(String paramString)
  {
    TroopGiftManager localTroopGiftManager = (TroopGiftManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(112);
    if (localTroopGiftManager != null) {
      return localTroopGiftManager.a(paramString);
    }
    return null;
  }
  
  public int c()
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.a.a());
    }
    PstnManager localPstnManager = (PstnManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(142);
    if (localPstnManager != null)
    {
      PstnCardInfo localPstnCardInfo = localPstnManager.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
      if ((localPstnCardInfo != null) && (localPstnManager.a() == 1))
      {
        if (localPstnCardInfo.pstn_multi_call_time > 0) {
          return 3;
        }
        if ((localPstnManager.c() == 1) && (localPstnCardInfo.pstn_multi_try_status == 0)) {
          return 4;
        }
        return 5;
      }
    }
    return 5;
  }
  
  public int c(String paramString)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.a.a());
    }
    return this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString);
  }
  
  public String c(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.a.a());
    }
    paramString = ((PhoneContactManager)QQServiceForAV.h(this.a).getManager(10)).b(paramString);
    if (paramString == null) {
      return null;
    }
    return paramString.uin;
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.e("QQServiceForAV", 2, "avStopAddFriendService");
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.a.a());
    }
    this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.l();
  }
  
  public void c(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.e("QQServiceForAV", 2, "acceptAddFriend :" + paramString);
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.a.a());
    }
    this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramString);
  }
  
  public void c(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQServiceForAV", 2, "playFlowerAnimation play: " + paramBoolean + ", mFlowerAnimationActive: " + this.a.jdField_a_of_type_Boolean);
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.a.a());
    }
    if (this.a.jdField_a_of_type_Boolean == paramBoolean) {}
    do
    {
      return;
      this.a.jdField_a_of_type_Boolean = paramBoolean;
      NearbyFlowerManager localNearbyFlowerManager = (NearbyFlowerManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(123);
      if (localNearbyFlowerManager != null)
      {
        if (paramBoolean)
        {
          if (this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyFlowerAnimationController == null) {
            this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyFlowerAnimationController = new NearbyFlowerAnimationController(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null);
          }
          localNearbyFlowerManager.a(null, this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyFlowerAnimationController);
          localNearbyFlowerManager.a(this.a.jdField_a_of_type_ComTencentMobileqqAppNearbyFlowerManager$NearbyFlowerListener);
          localNearbyFlowerManager.e();
          return;
        }
        localNearbyFlowerManager.c();
        localNearbyFlowerManager.a();
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.e("QQServiceForAV", 2, "playFlowerAnimation can't get nearbyfolwermanager");
  }
  
  public boolean c()
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.a.a());
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.d())
    {
      long l = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
      int i = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
      if (l > 0L)
      {
        int j = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(l);
        if ((i == 1) && (j == 2)) {
          return true;
        }
      }
    }
    return false;
  }
  
  public int d()
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.a.a());
    }
    return this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().jdField_b_of_type_Int;
  }
  
  public String d(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.a.a());
    }
    paramString = ((PhoneContactManager)QQServiceForAV.i(this.a).getManager(10)).a(paramString);
    if (paramString == null) {
      return null;
    }
    return paramString.mobileNo;
  }
  
  public boolean d()
  {
    return AppSetting.j;
  }
  
  public boolean e()
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.a.a());
    }
    return PtvFilterSoLoad.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext());
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gnq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
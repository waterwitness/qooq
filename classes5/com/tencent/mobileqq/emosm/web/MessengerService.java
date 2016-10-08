package com.tencent.mobileqq.emosm.web;

import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.specialcare.VipSpecialCareHandler;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QWalletAuthObserver;
import com.tencent.mobileqq.emoticon.EmojiListenerManager;
import com.tencent.mobileqq.emoticon.EmojiManager;
import com.tencent.mobileqq.emoticon.EmoticonPackageDownloadListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.profile.VipProfileCardPhotoHandlerActivity;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.IPCDownloadListener;
import com.tencent.mobileqq.vipav.VipFunCallObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.AppService;
import mqq.os.MqqHandler;
import rht;
import rhu;
import rhv;
import rhw;
import rhx;
import rhy;
import rhz;
import riu;

public class MessengerService
  extends AppService
  implements IPCConstants
{
  public static final String a = "Q.emoji.web.MessengerService";
  public Bundle a;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  public Messenger a;
  public VipSpecialCareHandler a;
  public CardObserver a;
  public QWalletAuthObserver a;
  public EmoticonPackageDownloadListener a;
  public DownloadListener a;
  public IPCDownloadListener a;
  public VipFunCallObserver a;
  public List a;
  private rhz jdField_a_of_type_Rhz;
  public riu a;
  Messenger b;
  
  public MessengerService()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidOsMessenger = null;
    this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonPackageDownloadListener = new rht(this);
    this.jdField_a_of_type_ComTencentMobileqqVipavVipFunCallObserver = new rhu(this);
    this.jdField_a_of_type_ComTencentMobileqqVipIPCDownloadListener = new rhv(this);
    this.jdField_a_of_type_Riu = new riu(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQWalletAuthObserver = new QWalletAuthObserver(this.jdField_a_of_type_Riu);
    this.jdField_a_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
    this.jdField_a_of_type_AndroidOsBundle = null;
    this.jdField_a_of_type_ComTencentMobileqqAppCardObserver = new rhw(this);
    this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener = new rhx(this, "param_WIFIThemeDownloadFlow", "param_XGThemeDownloadFlow");
    this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareVipSpecialCareHandler = new rhy(this);
  }
  
  public static void a(MessengerService paramMessengerService)
  {
    if ((paramMessengerService != null) && ((paramMessengerService.app instanceof QQAppInterface)))
    {
      paramMessengerService = ((QQAppInterface)paramMessengerService.app).a(Conversation.class);
      if (paramMessengerService != null) {
        paramMessengerService.sendMessage(paramMessengerService.obtainMessage(1134042));
      }
    }
  }
  
  public static void b(MessengerService paramMessengerService)
  {
    if ((paramMessengerService != null) && (Build.VERSION.SDK_INT >= 11)) {}
  }
  
  public void a(Bundle paramBundle)
  {
    if (this.jdField_a_of_type_AndroidOsMessenger != null) {}
    try
    {
      Message localMessage = Message.obtain(null, 4);
      localMessage.setData(paramBundle);
      this.jdField_a_of_type_AndroidOsMessenger.send(localMessage);
      if (QLog.isColorLevel()) {
        QLog.i("Q.emoji.web.MessengerService", 2, "resp to sever: ");
      }
      return;
    }
    catch (RemoteException paramBundle)
    {
      paramBundle.printStackTrace();
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.emoji.web.MessengerService", 2, paramString);
    }
  }
  
  public void b(String paramString)
  {
    Intent localIntent;
    if (!TextUtils.isEmpty(paramString))
    {
      localIntent = new Intent(this, VipProfileCardPhotoHandlerActivity.class);
      localIntent.setFlags(268435456);
      if (!paramString.equals("selectPhoto")) {
        break label49;
      }
      localIntent.putExtra("action", "select_photo");
    }
    for (;;)
    {
      startActivity(localIntent);
      return;
      label49:
      if (paramString.equals("takePhoto")) {
        localIntent.putExtra("action", "take_photo");
      }
    }
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.emoji.web.MessengerService", 2, "MessengerService onBind");
    }
    return this.b.getBinder();
  }
  
  public void onCreate()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.emoji.web.MessengerService", 2, "MessengerService oncreate");
    }
    super.onCreate();
    this.jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("MessengerServiceWorkerThread", -2);
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
    this.jdField_a_of_type_Rhz = new rhz(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper(), this);
    this.b = new Messenger(this.jdField_a_of_type_Rhz);
    if ((this.app != null) && ((this.app instanceof QQAppInterface)))
    {
      ((QQAppInterface)this.app).a(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareVipSpecialCareHandler);
      return;
    }
    if (this.app == null)
    {
      a("-->app is null");
      return;
    }
    a("-->app is not qqappinterface");
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_Rhz != null)
    {
      this.jdField_a_of_type_Rhz.getLooper().quit();
      this.jdField_a_of_type_Rhz = null;
    }
    if (this.jdField_a_of_type_AndroidOsHandlerThread != null) {
      this.jdField_a_of_type_AndroidOsHandlerThread = null;
    }
    this.jdField_a_of_type_AndroidOsMessenger = null;
    if (QLog.isColorLevel()) {
      QLog.i("Q.emoji.web.MessengerService", 2, "MessengerService destroied");
    }
    if ((this.app != null) && ((this.app instanceof QQAppInterface)))
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)this.app;
      if ((EmojiManager)this.app.getManager(42) != null) {
        EmojiManager.a.b(this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonPackageDownloadListener);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppQWalletAuthObserver != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQWalletAuthObserver.a();
        localQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqAppQWalletAuthObserver);
        this.jdField_a_of_type_ComTencentMobileqqAppQWalletAuthObserver = null;
      }
      this.jdField_a_of_type_Riu = null;
      if (this.jdField_a_of_type_ComTencentMobileqqAppCardObserver != null)
      {
        localQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
        this.jdField_a_of_type_ComTencentMobileqqAppCardObserver = null;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqVipavVipFunCallObserver != null)
      {
        localQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqVipavVipFunCallObserver);
        this.jdField_a_of_type_ComTencentMobileqqVipavVipFunCallObserver = null;
      }
      ((QQAppInterface)this.app).b(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareVipSpecialCareHandler);
      this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareVipSpecialCareHandler.a();
    }
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    return 2;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\emosm\web\MessengerService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
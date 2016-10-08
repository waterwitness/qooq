import ConfigPush.FileStorageServerListInfo;
import Wallet.AuthCodeReq;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.os.RemoteException;
import android.text.TextUtils;
import com.etrump.mixlayout.FontManager;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.SubLoginActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.leba.LebaShowListManager;
import com.tencent.mobileqq.activity.specialcare.QvipSpecialCareManager;
import com.tencent.mobileqq.activity.specialcare.VipSpecialCareHandler;
import com.tencent.mobileqq.apollo.ApolloManager;
import com.tencent.mobileqq.apollo.data.ApolloDress;
import com.tencent.mobileqq.apollo.store.ApolloResDownloader;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.ClubContentUpdateHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.FunnyPicHelper;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.IndividualRedPacketManager;
import com.tencent.mobileqq.app.MessageRoamManager;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QWalletAuthHandler;
import com.tencent.mobileqq.app.RedTouchHandler;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.app.SecMsgManager;
import com.tencent.mobileqq.app.ThemeHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.bubble.BubbleDiyFetcher;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.mobileqq.data.ApolloBaseInfo;
import com.tencent.mobileqq.data.ApolloPandora;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ChatBackgroundInfo;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.VipComicFavorEmoStructMsgInfo;
import com.tencent.mobileqq.emosm.favroaming.FavEmoConstant;
import com.tencent.mobileqq.emosm.favroaming.FavroamingDBManager;
import com.tencent.mobileqq.emosm.vipcomic.VipComicMqqManager;
import com.tencent.mobileqq.emosm.web.IPCConstants;
import com.tencent.mobileqq.emosm.web.MessengerService;
import com.tencent.mobileqq.emosm.web.MessengerService.IncomingHandler.10;
import com.tencent.mobileqq.emosm.web.MessengerService.IncomingHandler.12;
import com.tencent.mobileqq.emosm.web.MessengerService.IncomingHandler.9;
import com.tencent.mobileqq.emoticon.EmojiListenerManager;
import com.tencent.mobileqq.emoticon.EmojiManager;
import com.tencent.mobileqq.equipmentlock.EquipLockWebImpl;
import com.tencent.mobileqq.equipmentlock.EquipmentLockImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.loginwelcome.LoginWelcomeManager;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.phonelogin.PhoneNumLoginImpl;
import com.tencent.mobileqq.redtouch.RedAppInfo;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.redtouch.RedTouchUtils;
import com.tencent.mobileqq.redtouch.RedTypeInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.theme.ThemeReporter;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.theme.diy.ThemeDiyStyleLogic.StyleCallBack;
import com.tencent.mobileqq.transfile.FMTSrvAddrProvider;
import com.tencent.mobileqq.util.NearbyProfileUtil;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.RoamSettingController;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.ColorRingManager;
import com.tencent.mobileqq.vas.VasExtensionHandler;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.video.VipVideoManager;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.mobileqq.vipav.VipFunCallManager;
import com.tencent.mobileqq.vipav.VipSetFunCallHandler;
import com.tencent.mobileqq.vipgift.VipGiftDownloadInfo;
import com.tencent.mobileqq.vipgift.VipGiftManager;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.Login;
import cooperation.comic.QQComicPreloadManager;
import cooperation.qqreader.QRProcessManager;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.VerifyCodeManager;
import mqq.manager.WtloginManager;
import mqq.os.MqqHandler;
import oicq.wlogin_sdk.request.WtloginHelper;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class rhz
  extends Handler
{
  private static final String jdField_a_of_type_JavaLangString = "MessengerService$IncomingHandler";
  private IBinder.DeathRecipient jdField_a_of_type_AndroidOsIBinder$DeathRecipient;
  ThemeDiyStyleLogic.StyleCallBack jdField_a_of_type_ComTencentMobileqqThemeDiyThemeDiyStyleLogic$StyleCallBack;
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  
  public rhz(Looper paramLooper, MessengerService paramMessengerService)
  {
    super(paramLooper);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidOsIBinder$DeathRecipient = new ria(this);
    this.jdField_a_of_type_ComTencentMobileqqThemeDiyThemeDiyStyleLogic$StyleCallBack = new rin(this);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramMessengerService);
  }
  
  private void a(IBinder paramIBinder)
  {
    if (paramIBinder == null) {}
    do
    {
      for (;;)
      {
        return;
        try
        {
          paramIBinder.linkToDeath(this.jdField_a_of_type_AndroidOsIBinder$DeathRecipient, 0);
          return;
        }
        catch (RemoteException paramIBinder)
        {
          if (QLog.isColorLevel())
          {
            QLog.d("MessengerService$IncomingHandler", 2, "-->link to death error:" + paramIBinder.toString());
            return;
          }
        }
        catch (Exception paramIBinder) {}
      }
    } while (!QLog.isColorLevel());
    QLog.d("MessengerService$IncomingHandler", 2, "-->link to death error:" + paramIBinder.toString());
  }
  
  public void handleMessage(Message paramMessage)
  {
    Object localObject12;
    try
    {
      if (this.jdField_a_of_type_JavaLangRefWeakReference == null)
      {
        if (!QLog.isColorLevel()) {
          break label14808;
        }
        QLog.e("MessengerService$IncomingHandler", 2, "handleMessage, mServiceWeakRef null");
        return;
      }
      localObject12 = (MessengerService)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localObject12 != null) {
        break label90;
      }
      if (!QLog.isColorLevel()) {
        break label14808;
      }
      QLog.e("MessengerService$IncomingHandler", 2, "handleMessage, service null");
      return;
    }
    catch (Throwable paramMessage)
    {
      if (!QLog.isColorLevel()) {
        break label14808;
      }
    }
    QLog.e("MessengerService$IncomingHandler", 2, "handle msg error =" + paramMessage.toString());
    return;
    label90:
    Object localObject9;
    label274:
    Object localObject13;
    Object localObject10;
    boolean bool1;
    Object localObject6;
    long l1;
    int i;
    int j;
    Object localObject11;
    label1915:
    label2001:
    int k;
    label2112:
    label2265:
    label3842:
    label3970:
    Object localObject14;
    if (MessengerService.b((MessengerService)localObject12) == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("MessengerService$IncomingHandler", 2, "handleMessage, service.app null");
      }
    }
    else if ((paramMessage != null) && ((MessengerService.c((MessengerService)localObject12) instanceof QQAppInterface)))
    {
      localObject9 = (QQAppInterface)MessengerService.d((MessengerService)localObject12);
      if (localObject9 != null)
      {
        if ((paramMessage != null) && (paramMessage.replyTo != null)) {
          ((MessengerService)localObject12).jdField_a_of_type_AndroidOsMessenger = paramMessage.replyTo;
        }
        try
        {
          localObject1 = ((MessengerService)localObject12).jdField_a_of_type_AndroidOsMessenger;
          if (localObject1 != null) {
            a(((Messenger)localObject1).getBinder());
          }
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            Object localObject1;
            localException1.printStackTrace();
          }
          ((MessengerService)localObject12).jdField_a_of_type_AndroidOsMessenger = paramMessage.replyTo;
          if ((localObject9 == null) || (localException1 == null)) {
            break label274;
          }
          EmojiManager.a.a(((MessengerService)localObject12).jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonPackageDownloadListener);
          EquipLockWebImpl.a().a((QQAppInterface)localObject9, ((MessengerService)localObject12).jdField_a_of_type_AndroidOsMessenger);
          return;
        }
        localObject1 = (EmojiManager)((QQAppInterface)localObject9).getManager(42);
        switch (paramMessage.what)
        {
        case 1: 
          super.handleMessage(paramMessage);
          return;
        case 2: 
          if ((localObject9 != null) && (localException1 != null)) {
            EmojiManager.a.b(((MessengerService)localObject12).jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonPackageDownloadListener);
          }
          EquipLockWebImpl.a();
          EquipLockWebImpl.a();
          ((MessengerService)localObject12).jdField_a_of_type_AndroidOsMessenger = null;
          return;
        case 3: 
          if (QLog.isColorLevel()) {
            QLog.i("Q.emoji.web.MessengerService", 2, "Received server req: ");
          }
          localObject13 = paramMessage.getData();
          if (localObject13 != null)
          {
            try
            {
              paramMessage = ((Bundle)localObject13).getString("cmd");
              localObject10 = ((Bundle)localObject13).getBundle("request");
              if (paramMessage.equals("queryEmojiInfo"))
              {
                paramMessage = localException1.b((Bundle)localObject10);
                if ((QLog.isColorLevel()) && (paramMessage != null)) {
                  QLog.i("Q.emoji.web.MessengerService", 2, "qq queryEmojiInfo: result:" + paramMessage.getInt("result") + ";id:" + paramMessage.getInt("id") + ";status:" + paramMessage.getInt("status") + ";progress:" + paramMessage.getInt("progress") + ";pluginStatus:" + paramMessage.getInt("pluginStatus") + ";pluginSize:" + paramMessage.getLong("pluginSize"));
                }
                if (paramMessage != null) {
                  ((Bundle)localObject13).putBundle("response", paramMessage);
                }
                ((MessengerService)localObject12).a((Bundle)localObject13);
                return;
              }
            }
            catch (Exception paramMessage)
            {
              QLog.e("Q.emoji.web.MessengerService", 1, "bundle exception e = " + paramMessage.getMessage());
              return;
            }
            if (paramMessage.equals("queryEmojiInfos"))
            {
              paramMessage = localException1.a();
              if (paramMessage != null) {
                ((Bundle)localObject13).putBundle("response", paramMessage);
              }
              ((MessengerService)localObject12).a((Bundle)localObject13);
              return;
            }
            if (paramMessage.equals("startDownloadEmoji"))
            {
              paramMessage = ((EmojiManager)((QQAppInterface)localObject9).getManager(42)).a((Bundle)localObject10);
              if (QLog.isColorLevel()) {
                QLog.i("Q.emoji.web.MessengerService", 2, "qq startDownloadEmoji: result:" + paramMessage.getInt("result") + ";messge:" + paramMessage.getString("message"));
              }
              ((Bundle)localObject13).putBundle("response", paramMessage);
              ((MessengerService)localObject12).a((Bundle)localObject13);
              return;
            }
            if (paramMessage.equals("stopDownloadEmoji"))
            {
              paramMessage = ((EmojiManager)((QQAppInterface)localObject9).getManager(42)).a(String.valueOf(((Bundle)localObject10).getInt("id")));
              if (QLog.isColorLevel()) {
                QLog.i("Q.emoji.web.MessengerService", 2, "qq stopDownloadEmoji: result:" + paramMessage.getInt("result") + ";messge:" + paramMessage.getString("messge"));
              }
              ((Bundle)localObject13).putBundle("response", paramMessage);
              ((MessengerService)localObject12).a((Bundle)localObject13);
              return;
            }
            if (!"writeQFaceResult".equals(paramMessage))
            {
              Object localObject2;
              if ("getFaceFilePath".equals(paramMessage))
              {
                paramMessage = ((QQAppInterface)localObject9).a(1, ((Bundle)localObject13).getBundle("request").getString("uin"), 0);
                localObject2 = new Bundle();
                ((Bundle)localObject2).putString("faceFilePath", paramMessage);
                ((Bundle)localObject13).putBundle("response", (Bundle)localObject2);
                ((MessengerService)localObject12).a((Bundle)localObject13);
                return;
              }
              if ("changeAvatar".equals(paramMessage))
              {
                bool1 = ProfileCardUtil.a((QQAppInterface)localObject9, ((Bundle)localObject13).getBundle("request").getString("path"));
                paramMessage = new Bundle();
                paramMessage.putBoolean("updateResult", bool1);
                ((Bundle)localObject13).putBundle("response", paramMessage);
                ((MessengerService)localObject12).a((Bundle)localObject13);
                return;
              }
              if ("updatePendantId".equals(paramMessage))
              {
                paramMessage = ((Bundle)localObject13).getBundle("request");
                localObject6 = paramMessage.getString("uin");
                l1 = paramMessage.getLong("pendantId");
                localObject9 = (FriendsManager)((QQAppInterface)localObject9).getManager(50);
                localObject2 = ((FriendsManager)localObject9).a((String)localObject6);
                paramMessage = (Message)localObject2;
                if (localObject2 == null)
                {
                  paramMessage = new ExtensionInfo();
                  paramMessage.uin = ((String)localObject6);
                }
                paramMessage.pendantId = l1;
                paramMessage.timestamp = System.currentTimeMillis();
                ((FriendsManager)localObject9).a(paramMessage);
                paramMessage = new Bundle();
                paramMessage.putBoolean("updateResult", true);
                ((Bundle)localObject13).putBundle("response", paramMessage);
                ((MessengerService)localObject12).a((Bundle)localObject13);
                VasWebviewUtil.reportVasStatus("AvatarPendant", "ChangeHead", "0", 0, 0);
                return;
              }
              if ("reportActionCount".equals(paramMessage))
              {
                paramMessage = (SVIPHandler)((QQAppInterface)localObject9).a(13);
                ReportController.b((QQAppInterface)localObject9, "CliOper", "", "", ((Bundle)localObject10).getString("optype"), ((Bundle)localObject10).getString("opname"), 0, 1, paramMessage.e() + "", VipUtils.a((AppInterface)localObject9, ((QQAppInterface)localObject9).a()), NetworkUtil.b(((QQAppInterface)localObject9).a()) + "", null);
                return;
              }
              bool1 = "setup".equals(paramMessage);
              if (bool1) {
                try
                {
                  i = ((Bundle)localObject10).getInt("id");
                  ((SVIPHandler)((QQAppInterface)localObject9).a(13)).a(i);
                  paramMessage = new Bundle();
                  paramMessage.putInt("id", i);
                  ((Bundle)localObject13).putBundle("response", paramMessage);
                  ((MessengerService)localObject12).a((Bundle)localObject13);
                  return;
                }
                catch (Exception paramMessage)
                {
                  paramMessage.printStackTrace();
                  return;
                }
              }
              bool1 = "diy_setup".equals(paramMessage);
              if (bool1) {
                try
                {
                  i = ((Bundle)localObject10).getInt("id");
                  j = ((Bundle)localObject10).getInt("textId");
                  paramMessage = (SVIPHandler)((QQAppInterface)localObject9).a(13);
                  paramMessage.a(i);
                  paramMessage.a(j, true);
                  paramMessage = new Bundle();
                  paramMessage.putInt("id", i);
                  ((Bundle)localObject13).putBundle("response", paramMessage);
                  ((MessengerService)localObject12).a((Bundle)localObject13);
                  return;
                }
                catch (Exception paramMessage)
                {
                  paramMessage.printStackTrace();
                  return;
                }
              }
              if ("queryLocal".equals(paramMessage))
              {
                paramMessage = (SVIPHandler)((QQAppInterface)localObject9).a(13);
                i = paramMessage.e();
                localObject2 = new Bundle();
                ((Bundle)localObject2).putInt("id", i);
                ((Bundle)localObject13).putBundle("response", (Bundle)localObject2);
                localObject6 = ((Bundle)localObject13).getString("type");
                if ((localObject6 != null) && (((String)localObject6).equals("diy")))
                {
                  BubbleDiyFetcher.a().a((QQAppInterface)localObject9, paramMessage.g(), new rij(this, (Bundle)localObject2, (MessengerService)localObject12, (Bundle)localObject13));
                  return;
                }
                ((MessengerService)localObject12).a((Bundle)localObject13);
                return;
              }
              if ("getFaceFilePath".equals(paramMessage))
              {
                paramMessage = ((QQAppInterface)localObject9).a(1, ((Bundle)localObject13).getBundle("request").getString("uin"), 0);
                localObject2 = new Bundle();
                ((Bundle)localObject2).putString("faceFilePath", paramMessage);
                ((Bundle)localObject13).putBundle("response", (Bundle)localObject2);
                ((MessengerService)localObject12).a((Bundle)localObject13);
                return;
              }
              if ("changeAvatar".equals(paramMessage))
              {
                bool1 = ProfileCardUtil.a((QQAppInterface)localObject9, ((Bundle)localObject13).getBundle("request").getString("path"));
                paramMessage = new Bundle();
                paramMessage.putBoolean("updateResult", bool1);
                ((Bundle)localObject13).putBundle("response", paramMessage);
                ((MessengerService)localObject12).a((Bundle)localObject13);
                return;
              }
              if ("startDownloadTheme".equals(paramMessage))
              {
                localObject2 = ((Bundle)localObject10).getString("url");
                localObject6 = ((Bundle)localObject10).getString("themeZipPath");
                l1 = ((Bundle)localObject10).getLong("size");
                paramMessage = ((Bundle)localObject10).getString("id");
                localObject10 = ((Bundle)localObject10).getString("version");
                localObject11 = new Bundle();
                ((Bundle)localObject11).putString("id", paramMessage);
                ((Bundle)localObject11).putString("version", (String)localObject10);
                ((Bundle)localObject11).putLong("size", l1);
                ((Bundle)localObject11).putInt("srcType", 4);
                ((Bundle)localObject11).putString("callbackId", ((Bundle)localObject13).getString("callbackid"));
                localObject2 = new DownloadTask((String)localObject2, new File((String)localObject6));
                ((DownloadTask)localObject2).b = true;
                i = (int)(l1 / 50L);
                if (i > 2048) {
                  ((DownloadTask)localObject2).b(i);
                }
                ((DownloadTask)localObject2).b(false);
                ((DownloaderFactory)((QQAppInterface)localObject9).getManager(46)).a(1).a((DownloadTask)localObject2, ((MessengerService)localObject12).jdField_a_of_type_ComTencentMobileqqVipDownloadListener, (Bundle)localObject11);
                ThemeReporter.a((QQAppInterface)localObject9, "theme_detail", "200", 153, NetworkUtil.a(null), 20, paramMessage, (String)localObject10, ThemeReporter.t, "");
                paramMessage = new Bundle();
                paramMessage.putBoolean("StartDownloadResult", true);
                ((Bundle)localObject13).putBundle("response", paramMessage);
                ((MessengerService)localObject12).a((Bundle)localObject13);
                return;
              }
              if ("stopdownload".equals(paramMessage))
              {
                if (localObject10 != null)
                {
                  paramMessage = new Bundle();
                  localObject2 = ((Bundle)localObject10).getString("url");
                  if (((DownloaderFactory)((QQAppInterface)localObject9).getManager(46)).a(1).a(false, (String)localObject2) != 0) {
                    break label14812;
                  }
                  bool1 = true;
                  paramMessage.putBoolean("processor", bool1);
                  ((Bundle)localObject13).putBundle("response", paramMessage);
                  ((MessengerService)localObject12).a((Bundle)localObject13);
                }
              }
              else if ("pausedownload".equals(paramMessage))
              {
                if (localObject10 != null)
                {
                  paramMessage = new Bundle();
                  localObject2 = ((Bundle)localObject13).getString("url");
                  if (((DownloaderFactory)((QQAppInterface)localObject9).getManager(46)).a(1).a(false, (String)localObject2) != 0) {
                    break label14818;
                  }
                  bool1 = true;
                  paramMessage.putBoolean("processor", bool1);
                  ((Bundle)localObject13).putBundle("response", paramMessage);
                  ((MessengerService)localObject12).a((Bundle)localObject13);
                }
              }
              else if ("reportTheme".equals(paramMessage))
              {
                localObject6 = ((Bundle)localObject10).getString("themeId");
                k = ((Bundle)localObject10).getInt("actionResult");
                j = NetworkUtil.a(null);
                paramMessage = ((Bundle)localObject10).getString("actionName");
                if (!TextUtils.isEmpty(paramMessage))
                {
                  l1 = ((Bundle)localObject10).getLong("downloadTime");
                  i = ((SVIPHandler)((QQAppInterface)localObject9).a(13)).h();
                  if (i != 2) {
                    break label14824;
                  }
                  i = 0;
                  ReportController.b((QQAppInterface)localObject9, "CliOper", "", "", "theme_mall", paramMessage, 0, k, (String)localObject6, "" + i, String.valueOf(j), String.valueOf(l1));
                }
                paramMessage = ((Bundle)localObject10).getString("statistic_key");
                bool1 = TextUtils.isEmpty(paramMessage);
                if (!bool1) {}
                try
                {
                  localObject2 = new HashMap();
                  ((HashMap)localObject2).put("param_themeId", localObject6);
                  ((HashMap)localObject2).put("param_netType", String.valueOf(j));
                  ((HashMap)localObject2).put("param_FailCode", ((Bundle)localObject10).getString("param_FailCode"));
                  localObject11 = StatisticCollector.a(((QQAppInterface)localObject9).getApplication().getApplicationContext());
                  localObject12 = ((QQAppInterface)localObject9).getAccount();
                  if (k != 0) {
                    break label14836;
                  }
                  bool1 = true;
                  ((StatisticCollector)localObject11).a((String)localObject12, paramMessage, bool1, 1L, 0L, (HashMap)localObject2, "", false);
                }
                catch (Exception paramMessage)
                {
                  for (;;)
                  {
                    if (QLog.isColorLevel()) {
                      QLog.e("StatisticCollector", 2, "StatisticCollector Error:" + paramMessage.getMessage());
                    }
                  }
                }
                localObject11 = ((Bundle)localObject10).getString("from");
                if (!TextUtils.isEmpty((CharSequence)localObject11))
                {
                  i = ((Bundle)localObject10).getInt("step");
                  k = ((Bundle)localObject10).getInt("code");
                  localObject12 = ((Bundle)localObject10).getString("version");
                  localObject13 = ((Bundle)localObject10).getString("path");
                  localObject2 = ((Bundle)localObject10).getString("r5");
                  paramMessage = (Message)localObject2;
                  if (TextUtils.isEmpty((CharSequence)localObject2)) {
                    paramMessage = "";
                  }
                  ThemeReporter.a((QQAppInterface)localObject9, "theme_detail", (String)localObject11, i, j, k, (String)localObject6, (String)localObject12, (String)localObject13, paramMessage);
                }
              }
              else
              {
                if ("authTheme".equals(paramMessage))
                {
                  paramMessage = ((Bundle)localObject10).getString("themeId");
                  localObject2 = ((Bundle)localObject10).getString("version");
                  ((ThemeHandler)((QQAppInterface)localObject9).a(14)).a(paramMessage, (String)localObject2);
                  return;
                }
                if ("setSVTheme".equals(paramMessage))
                {
                  paramMessage = ((Bundle)localObject10).getString("themeId");
                  localObject2 = ((Bundle)localObject10).getString("version");
                  localObject6 = ((Bundle)localObject10).getString("seriesID");
                  if (QLog.isColorLevel()) {
                    QLog.d("Q.emoji.web.MessengerService", 2, "IPC_THEME_SET_SERVER mesgSver themeId:" + paramMessage + ", version:" + (String)localObject2 + ", seriesId:" + (String)localObject6);
                  }
                  ((ThemeHandler)((QQAppInterface)localObject9).a(14)).a(paramMessage, (String)localObject2, (String)localObject6, (Bundle)localObject13, this.jdField_a_of_type_ComTencentMobileqqThemeDiyThemeDiyStyleLogic$StyleCallBack);
                  return;
                }
                if ("themeSwitchSucess".equals(paramMessage))
                {
                  paramMessage = ((Bundle)localObject10).getString("themeId");
                  localObject2 = ((Bundle)localObject10).getString("version");
                  ThemeUtil.setCurrentThemeIdVersion((AppRuntime)localObject9, paramMessage, (String)localObject2);
                  ThemeUtil.setWeekLoopTheme((AppRuntime)localObject9, ((Bundle)localObject10).getString("seriesID"), ((Bundle)localObject10).getString("themeArray"), ((Bundle)localObject10).getLong("startTime", 0L));
                  localObject6 = (ChatBackgroundManager)((QQAppInterface)localObject9).getManager(62);
                  localObject10 = ((QQAppInterface)localObject9).a().getSharedPreferences("theme_background_path_" + ((QQAppInterface)localObject9).getAccount(), 0).getString("theme_bg_aio_path", "null");
                  localObject11 = ((ChatBackgroundManager)localObject6).b(null);
                  if ((localObject10 != null) && (!"null".equals(localObject10)) && (localObject11 != null) && (((String)localObject10).equals(localObject11))) {
                    ((ChatBackgroundManager)localObject6).a(((QQAppInterface)localObject9).getAccount(), null, "null");
                  }
                  ThemeReporter.a((QQAppInterface)localObject9, "theme_detail", "200", 155, NetworkUtil.a(null), 31, paramMessage, (String)localObject2, ThemeReporter.t, "");
                  return;
                }
                if ("weekLoopGetData".equals(paramMessage))
                {
                  localObject2 = ThemeUtil.getUinThemePreferences((AppRuntime)localObject9);
                  paramMessage = ((SharedPreferences)localObject2).getString("seriesID", "");
                  localObject2 = ((SharedPreferences)localObject2).getString("themeArray", "");
                  localObject6 = new Bundle();
                  ((Bundle)localObject6).putString("seriesID", paramMessage);
                  ((Bundle)localObject6).putString("themeArray", (String)localObject2);
                  ((Bundle)localObject13).putBundle("response", (Bundle)localObject6);
                  ((MessengerService)localObject12).a((Bundle)localObject13);
                  return;
                }
                if ("rpWebGetBitmap".equals(paramMessage))
                {
                  paramMessage = ((Bundle)localObject10).getString("templateId");
                  localObject2 = ((Bundle)localObject10).getString("content");
                  ((IndividualRedPacketManager)((QQAppInterface)localObject9).getManager(130)).a(paramMessage, (String)localObject2, (Bundle)localObject13, (MessengerService)localObject12);
                  return;
                }
                if ("businessNotifyContact".equals(paramMessage))
                {
                  ReportController.b((QQAppInterface)localObject9, "dc00898", "", "", "0X80068B0", "0X80068B0", 0, 0, "", "", "", "");
                  ((PhoneContactManagerImp)((QQAppInterface)localObject9).getManager(10)).a(true, false);
                  return;
                }
                if ("rpWebSetFlags".equals(paramMessage))
                {
                  i = ((Bundle)localObject10).getInt("iCanUseRed", -1);
                  j = ((Bundle)localObject10).getInt("iRedDisable", -1);
                  if ((i >= 0) || (j >= 0)) {
                    ((IndividualRedPacketManager)((QQAppInterface)localObject9).getManager(130)).a(i, j, true);
                  }
                }
                else if ("rpWebSetRedpacketInfo".equals(paramMessage))
                {
                  i = ((Bundle)localObject10).getInt("iRedPacketId", -1);
                  paramMessage = ((Bundle)localObject10).getString("sRedPackRemard");
                  if (QLog.isColorLevel()) {
                    QLog.d("MessengerService", 2, "IPC_RED_PACKET_WEB_SET_REDPACKETINFO iRedPacketId = " + i + ";sRedPackRemard = " + paramMessage);
                  }
                  localObject2 = (IndividualRedPacketManager)((QQAppInterface)localObject9).getManager(130);
                  if (localObject2 != null) {
                    ((IndividualRedPacketManager)localObject2).a(i, paramMessage);
                  }
                }
                else
                {
                  if ("rpWebInitTemplate".equals(paramMessage))
                  {
                    paramMessage = ((Bundle)localObject10).getString("templateId");
                    ((IndividualRedPacketManager)((QQAppInterface)localObject9).getManager(130)).a(paramMessage, (Bundle)localObject13, (MessengerService)localObject12);
                    return;
                  }
                  if ("getUserVipType".equals(paramMessage))
                  {
                    paramMessage = new Bundle();
                    localObject2 = (SVIPHandler)((QQAppInterface)localObject9).a(13);
                    localObject6 = ((Bundle)localObject10).getString("uin");
                    i = ((SVIPHandler)localObject2).h();
                    paramMessage.putString("uin", (String)localObject6);
                    paramMessage.putInt("type", i);
                    ((Bundle)localObject13).putBundle("response", paramMessage);
                    ((MessengerService)localObject12).a((Bundle)localObject13);
                    return;
                  }
                  if ("notifyTroopUpgradeSuccess".equals(paramMessage))
                  {
                    ((TroopHandler)((QQAppInterface)localObject9).a(20)).b(((Bundle)localObject10).getString("groupId"), ((Bundle)localObject10).getInt("type"));
                    return;
                  }
                  if ("chatbackground_setbg".equals(paramMessage))
                  {
                    paramMessage = ((Bundle)localObject10).getString("path");
                    localObject2 = ((Bundle)localObject10).getString("friendUin");
                    localObject6 = ((Bundle)localObject10).getString("from");
                    localObject10 = (Intent)((Bundle)localObject10).getParcelable("intent");
                    localObject11 = (ChatBackgroundManager)((QQAppInterface)localObject9).getManager(62);
                    ((ChatBackgroundManager)localObject11).a(((QQAppInterface)localObject9).getAccount(), (String)localObject2, paramMessage);
                    ((ChatBackgroundManager)localObject11).a((Intent)localObject10);
                    ((ChatBackgroundManager)localObject11).a(((QQAppInterface)localObject9).getApplication().getApplicationContext(), ((QQAppInterface)localObject9).getAccount());
                    if ((localObject6 != null) && (((String)localObject6).equals("chatbgJs")))
                    {
                      paramMessage = new Bundle();
                      paramMessage.putInt("result", 0);
                      ((Bundle)localObject13).putBundle("response", paramMessage);
                      ((MessengerService)localObject12).a((Bundle)localObject13);
                    }
                  }
                  else
                  {
                    if ("chatbackground_startDownload".equals(paramMessage))
                    {
                      paramMessage = new ChatBackgroundInfo();
                      paramMessage.id = ((Bundle)localObject10).getString("id");
                      paramMessage.url = ((Bundle)localObject10).getString("url");
                      paramMessage.name = ((Bundle)localObject10).getString("name");
                      paramMessage.thumbUrl = ((Bundle)localObject10).getString("thumbUrl");
                      localObject2 = ((Bundle)localObject13).getString("callbackid");
                      localObject6 = (ChatBackgroundManager)((QQAppInterface)localObject9).getManager(62);
                      ((ChatBackgroundManager)localObject6).a(((MessengerService)localObject12).jdField_a_of_type_ComTencentMobileqqVipIPCDownloadListener);
                      ((ChatBackgroundManager)localObject6).a(paramMessage, (String)localObject2);
                      return;
                    }
                    if ("chatbackground_stopdownload".equals(paramMessage))
                    {
                      paramMessage = ((Bundle)localObject10).getString("id");
                      localObject2 = ((Bundle)localObject10).getString("url");
                      ((ChatBackgroundManager)((QQAppInterface)localObject9).getManager(62)).a(paramMessage, (String)localObject2);
                      localObject2 = new Bundle();
                      ((Bundle)localObject2).putString("id", paramMessage);
                      ((Bundle)localObject13).putBundle("response", (Bundle)localObject2);
                      ((MessengerService)localObject12).a((Bundle)localObject13);
                      return;
                    }
                    if ("chatbackground_querinfo".equals(paramMessage))
                    {
                      paramMessage = ((Bundle)localObject10).getString("id");
                      localObject2 = ((Bundle)localObject10).getString("url");
                      paramMessage = ((ChatBackgroundManager)((QQAppInterface)localObject9).getManager(62)).a(((QQAppInterface)localObject9).getApplication().getApplicationContext(), paramMessage, (String)localObject2);
                      localObject2 = new Bundle();
                      ((Bundle)localObject2).putInt("status", paramMessage.getInt("status"));
                      ((Bundle)localObject2).putString("id", paramMessage.getString("id"));
                      ((Bundle)localObject2).putString("message", paramMessage.getString("message"));
                      ((Bundle)localObject2).putInt("result", paramMessage.getInt("result"));
                      ((Bundle)localObject2).putInt("progress", paramMessage.getInt("progress"));
                      ((Bundle)localObject13).putBundle("response", (Bundle)localObject2);
                      ((MessengerService)localObject12).a((Bundle)localObject13);
                      return;
                    }
                    if ("chatbackground_getCurrentId".equals(paramMessage))
                    {
                      localObject10 = ((Bundle)localObject10).getString("friendUin");
                      if (!"none".equals(localObject10)) {
                        break label14842;
                      }
                      paramMessage = null;
                      localObject11 = (ChatBackgroundManager)((QQAppInterface)localObject9).getManager(62);
                      localObject2 = ((ChatBackgroundManager)localObject11).c(paramMessage);
                      paramMessage = (Message)localObject2;
                      if (localObject2 != null)
                      {
                        paramMessage = (Message)localObject2;
                        if (!((String)localObject2).equals("null"))
                        {
                          paramMessage = (Message)localObject2;
                          if (!((String)localObject2).equals("custom"))
                          {
                            paramMessage = (Message)localObject2;
                            if (!new File(AppConstants.cs + (String)localObject2 + ".jpg").exists()) {
                              paramMessage = "none";
                            }
                          }
                        }
                      }
                      localObject2 = ThemeUtil.getUserCurrentThemeId((AppRuntime)localObject9);
                      if (ThemeUtil.getIsDIYTheme((String)localObject2))
                      {
                        localObject6 = "1";
                        localObject2 = "1000";
                        if (paramMessage.equals("null")) {
                          localObject9 = "none";
                        }
                        for (paramMessage = "none";; paramMessage = (Message)localObject11)
                        {
                          localObject11 = new Bundle();
                          ((Bundle)localObject11).putString("result", "0");
                          ((Bundle)localObject11).putString("friendUin", (String)localObject10);
                          ((Bundle)localObject11).putString("id", (String)localObject9);
                          ((Bundle)localObject11).putString("themeId", (String)localObject2);
                          ((Bundle)localObject11).putString("url", paramMessage);
                          ((Bundle)localObject11).putString("isDIYTheme", (String)localObject6);
                          ((Bundle)localObject13).putBundle("response", (Bundle)localObject11);
                          ((MessengerService)localObject12).a((Bundle)localObject13);
                          return;
                          localObject11 = ((ChatBackgroundManager)localObject11).a(((QQAppInterface)localObject9).getApplication().getApplicationContext(), paramMessage);
                          localObject9 = paramMessage;
                        }
                      }
                    }
                    else
                    {
                      if ("ipc_h5magic_sendmsg".equals(paramMessage))
                      {
                        ((Bundle)localObject10).setClassLoader(SessionInfo.class.getClassLoader());
                        paramMessage = (Emoticon)((Bundle)localObject10).getSerializable("emoticon");
                        localObject2 = (SessionInfo)((Bundle)localObject10).getParcelable("sessionInfo");
                        ChatActivityFacade.a((QQAppInterface)localObject9, ((QQAppInterface)localObject9).getApplication().getApplicationContext(), (SessionInfo)localObject2, paramMessage);
                        if ((paramMessage == null) || (!QLog.isColorLevel())) {
                          break label14808;
                        }
                        QLog.d("MessengerService", 2, "send childEmoticon: childEmotcionEpid = " + paramMessage.epId);
                        return;
                      }
                      if ("myIndividuationRedInfo".equals(paramMessage))
                      {
                        paramMessage = ((Bundle)localObject10).getString("path");
                        if (paramMessage == null) {
                          break label14808;
                        }
                        ((RedTouchManager)((QQAppInterface)localObject9).getManager(35)).b(paramMessage);
                        return;
                      }
                      if ("redTouch_getRedInfo".equals(paramMessage))
                      {
                        paramMessage = ((Bundle)localObject10).getString("path");
                        localObject2 = ((Bundle)localObject10).getString("callbackid");
                        localObject9 = (RedTouchManager)((QQAppInterface)localObject9).getManager(35);
                        localObject14 = ((RedTouchManager)localObject9).a(paramMessage);
                        localObject11 = RedTouchUtils.a((BusinessInfoCheckUpdate.AppInfo)localObject14);
                        localObject6 = new Bundle();
                        ((Bundle)localObject6).putParcelable("redInfo", (Parcelable)localObject11);
                        ((Bundle)localObject6).putString("path", paramMessage);
                        localObject11 = ((Bundle)localObject10).getString("subCmd");
                        if ((localObject11 == null) || ("redTouch_getIndividuationType".equals(localObject11))) {}
                        for (;;)
                        {
                          ((Bundle)localObject6).putString("subCmd", (String)localObject11);
                          ((Bundle)localObject13).putBundle("response", (Bundle)localObject6);
                          ((MessengerService)localObject12).a((Bundle)localObject13);
                          return;
                          if ("redTouch_reportRedTouch".equals(localObject11))
                          {
                            ((Bundle)localObject6).putInt("isWithRedPoint", ((Bundle)localObject10).getInt("isWithRedPoint"));
                            if (((Bundle)localObject10).getInt("isWithRedPoint") != 1) {
                              break;
                            }
                            bool1 = true;
                            label4418:
                            ((RedTouchManager)localObject9).a((BusinessInfoCheckUpdate.AppInfo)localObject14, bool1, ((Bundle)localObject10).getStringArrayList("missions"));
                            return;
                          }
                          if ("redTouch_reportBusinessRedTouch".equals(localObject11))
                          {
                            ((Bundle)localObject6).putString("json", ((Bundle)localObject10).getString("json"));
                          }
                          else if ("redTouch_getAppInfo".equals(localObject11))
                          {
                            localObject10 = ((Bundle)localObject10).getString("serial");
                            ((Bundle)localObject6).putString("serial", (String)localObject10);
                            localObject9 = ((RedTouchManager)localObject9).a();
                            if (((TextUtils.isEmpty(paramMessage)) || (!paramMessage.equals(localObject9))) || (QLog.isColorLevel())) {
                              QLog.i("MessengerService", 2, "getAppInfo: serial " + (String)localObject10 + ";path = " + paramMessage + ";callback = " + (String)localObject2);
                            }
                          }
                          else if (!"redTouch_getRedPointShowInfo_path".equals(localObject11)) {}
                        }
                      }
                      if ("redTouch_getAppInfo_report".equals(paramMessage))
                      {
                        paramMessage = ((Bundle)localObject10).getString("ret");
                        localObject2 = ((Bundle)localObject10).getString("buffer");
                        localObject6 = ((Bundle)localObject10).getString("red");
                        localObject11 = ((Bundle)localObject10).getString("path");
                        localObject12 = ((Bundle)localObject10).getString("serial");
                        localObject13 = ((Bundle)localObject10).getString("callback");
                        localObject10 = ((Bundle)localObject10).getStringArrayList("missions");
                        ((RedTouchManager)((QQAppInterface)localObject9).getManager(35)).a(12, (ArrayList)localObject10, (String)localObject6, paramMessage, (String)localObject2, (String)localObject12, (String)localObject13, RedTouchManager.a((String)localObject11));
                        return;
                      }
                      if ("redTouch_setAppInfo".equals(paramMessage))
                      {
                        ((Bundle)localObject10).setClassLoader(RedAppInfo.class.getClassLoader());
                        paramMessage = RedTouchUtils.a((RedAppInfo)((Bundle)localObject10).getParcelable("red"));
                        localObject2 = (RedTouchManager)((QQAppInterface)localObject9).getManager(35);
                        if (paramMessage != null)
                        {
                          localObject6 = new ArrayList();
                          ((ArrayList)localObject6).addAll(paramMessage.missions.get());
                          localObject9 = ((RedTouchManager)localObject2).a(paramMessage.path.get(), paramMessage.buffer.get());
                          ((RedTouchManager)localObject2).a(13, (ArrayList)localObject6, paramMessage.iNewFlag.get() + "", "", (String)localObject9, "", "", RedTouchManager.a(paramMessage.path.get()));
                        }
                        i = ((RedTouchManager)localObject2).a(paramMessage, false);
                        paramMessage = new Bundle();
                        paramMessage.putInt("iret", i);
                        ((Bundle)localObject13).putBundle("response", paramMessage);
                        ((MessengerService)localObject12).a((Bundle)localObject13);
                        return;
                      }
                      if ("redTouch_getRedPointShowInfo_set".equals(paramMessage))
                      {
                        i = ((Bundle)localObject10).getInt("setId");
                        localObject2 = ((RedTouchManager)((QQAppInterface)localObject9).getManager(35)).a(i);
                        paramMessage = new RedTypeInfo();
                        if (localObject2 != null)
                        {
                          paramMessage.setRed_content(((BusinessInfoCheckUpdate.RedTypeInfo)localObject2).red_content.get());
                          paramMessage.setRed_desc(((BusinessInfoCheckUpdate.RedTypeInfo)localObject2).red_desc.get());
                          paramMessage.setRed_priority(((BusinessInfoCheckUpdate.RedTypeInfo)localObject2).red_priority.get());
                          paramMessage.setRed_type(((BusinessInfoCheckUpdate.RedTypeInfo)localObject2).red_type.get());
                        }
                        localObject2 = new Bundle();
                        ((Bundle)localObject2).putSerializable("redInfo", paramMessage);
                        ((Bundle)localObject13).putBundle("response", (Bundle)localObject2);
                        ((MessengerService)localObject12).a((Bundle)localObject13);
                        return;
                      }
                      if (IPCConstants.a.containsKey(paramMessage)) {}
                      switch (((Integer)IPCConstants.a.get(paramMessage)).intValue())
                      {
                      case 1: 
                        i = ((Bundle)localObject10).getInt("id");
                        j = ((Bundle)localObject10).getInt("type");
                        ((SVIPHandler)((QQAppInterface)localObject9).a(13)).a(i, j);
                        paramMessage = new Bundle();
                        paramMessage.putInt("id", i);
                        paramMessage.putInt("result", 0);
                        paramMessage.putString("message", "success");
                        ((Bundle)localObject13).putBundle("response", paramMessage);
                        ((MessengerService)localObject12).a((Bundle)localObject13);
                        return;
                      case 3: 
                        i = ((Bundle)localObject10).getInt("id");
                        paramMessage = ((Bundle)localObject13).getString("callbackid");
                        localObject2 = (FontManager)((QQAppInterface)localObject9).getManager(41);
                        ((FontManager)localObject2).a(((MessengerService)localObject12).jdField_a_of_type_ComTencentMobileqqVipIPCDownloadListener);
                        ((FontManager)localObject2).a(i, paramMessage, false, false);
                        return;
                      case 2: 
                        i = ((Bundle)localObject10).getInt("id");
                        paramMessage = ((FontManager)((QQAppInterface)localObject9).getManager(41)).a(i);
                        localObject2 = new Bundle();
                        ((Bundle)localObject2).putInt("id", i);
                        ((Bundle)localObject2).putString("result", paramMessage.toString());
                        ((Bundle)localObject13).putBundle("response", (Bundle)localObject2);
                        ((MessengerService)localObject12).a((Bundle)localObject13);
                        return;
                      case 4: 
                        i = ((Bundle)localObject10).getInt("id");
                        ((FontManager)((QQAppInterface)localObject9).getManager(41)).a(i);
                        paramMessage = new Bundle();
                        paramMessage.putInt("id", i);
                        ((Bundle)localObject13).putBundle("response", paramMessage);
                        ((MessengerService)localObject12).a((Bundle)localObject13);
                        return;
                      case 5: 
                        i = ((Bundle)localObject10).getInt("id");
                        paramMessage = ((Bundle)localObject13).getString("callbackid");
                        localObject2 = (BubbleManager)((QQAppInterface)localObject9).getManager(43);
                        ((BubbleManager)localObject2).a(((MessengerService)localObject12).jdField_a_of_type_ComTencentMobileqqVipIPCDownloadListener);
                        ((BubbleManager)localObject2).c(i, paramMessage);
                        return;
                      case 7: 
                        i = ((Bundle)localObject10).getInt("id");
                        paramMessage = ((BubbleManager)((QQAppInterface)localObject9).getManager(43)).c(i);
                        localObject2 = new Bundle();
                        ((Bundle)localObject2).putInt("id", i);
                        ((Bundle)localObject2).putString("result", paramMessage.toString());
                        ((Bundle)localObject13).putBundle("response", (Bundle)localObject2);
                        ((MessengerService)localObject12).a((Bundle)localObject13);
                        return;
                      case 6: 
                        i = ((Bundle)localObject10).getInt("id");
                        paramMessage = ((BubbleManager)((QQAppInterface)localObject9).getManager(43)).a(i);
                        localObject2 = new Bundle();
                        ((Bundle)localObject2).putInt("id", i);
                        ((Bundle)localObject2).putString("result", paramMessage.toString());
                        ((Bundle)localObject13).putBundle("response", (Bundle)localObject2);
                        ((MessengerService)localObject12).a((Bundle)localObject13);
                        return;
                      case 8: 
                        i = ((Bundle)localObject10).getInt("action");
                        paramMessage = (FontManager)((QQAppInterface)localObject9).getManager(41);
                        if (i == 1)
                        {
                          bool1 = true;
                          label5585:
                          paramMessage.a(bool1);
                          ((Bundle)localObject13).putBundle("response", new Bundle());
                          ((MessengerService)localObject12).a((Bundle)localObject13);
                          return;
                          if ("qwallet_getAuthCode".equals(paramMessage))
                          {
                            l1 = ((Bundle)localObject10).getLong("appId");
                            paramMessage = new AuthCodeReq();
                            paramMessage.uin = ((QQAppInterface)localObject9).getLongAccountUin();
                            paramMessage.skey = "";
                            paramMessage.apps = new ArrayList();
                            paramMessage.apps.add(Long.valueOf(l1));
                            ((QQAppInterface)localObject9).a(((MessengerService)localObject12).jdField_a_of_type_ComTencentMobileqqAppQWalletAuthObserver);
                            ((MessengerService)localObject12).jdField_a_of_type_Riu.jdField_a_of_type_AndroidOsBundle = ((Bundle)localObject13);
                            ((QWalletAuthHandler)((QQAppInterface)localObject9).a(42)).a(paramMessage);
                            if (QLog.isColorLevel()) {
                              QLog.d("MessengerService$IncomingHandler", 2, "IPC_CMD_CREATE_AUTHCODE cmd get");
                            }
                          }
                          else
                          {
                            if ("openEquipmentLock".equals(paramMessage))
                            {
                              paramMessage = ((Bundle)localObject10).getByteArray("sppkey");
                              EquipLockWebImpl.a().a(paramMessage);
                              return;
                            }
                            if ("openDevLock".equals(paramMessage))
                            {
                              paramMessage = new IntentFilter("mqq.intent.action.DEVLOCK_ROAM");
                              localObject2 = new rio(this, (MessengerService)localObject12, (Bundle)localObject13);
                              ((QQAppInterface)localObject9).getApplication().getApplicationContext().registerReceiver((BroadcastReceiver)localObject2, paramMessage);
                              if (QLog.isColorLevel()) {
                                QLog.d("Q.emoji.web.MessengerService", 2, "openDevLock registerReceiver context: " + ((QQAppInterface)localObject9).getApplication().getApplicationContext());
                              }
                              paramMessage = new Intent();
                              paramMessage.setFlags(268435456);
                              paramMessage.setAction("android.intent.action.VIEW");
                              paramMessage.putExtra("open_devlock_from_roam", true);
                              paramMessage.putExtra("devlock_show_auth_dev_list", ((Bundle)localObject10).getBoolean("devlock_show_auth_dev_list", true));
                              paramMessage.putExtra("devlock_guide_config", ((Bundle)localObject10).getString("devlock_guide_config"));
                              paramMessage.putExtra("devlock_open_source", ((Bundle)localObject10).getString("devlock_open_source"));
                              paramMessage.setData(Uri.parse("mqqdevlock://devlock/open?"));
                              ((MessengerService)localObject12).startActivity(paramMessage);
                              return;
                            }
                            if ("queryDevLockStatus".equals(paramMessage))
                            {
                              EquipmentLockImpl.a().a((AppInterface)localObject9, ((QQAppInterface)localObject9).a(), new rip(this, (Bundle)localObject13, (MessengerService)localObject12));
                              return;
                            }
                            if ("createShortcut".equals(paramMessage))
                            {
                              paramMessage = ((Bundle)localObject13).getBundle("request");
                              localObject2 = paramMessage.getString("nickname");
                              localObject6 = paramMessage.getString("iconurl");
                              localObject10 = paramMessage.getString("starhomeurl");
                              ThreadManager.a(new riq(this, (String)localObject6, paramMessage.getString("sid"), (QQAppInterface)localObject9, (String)localObject10, (String)localObject2, (Bundle)localObject13, (MessengerService)localObject12), 5, null, true);
                              return;
                            }
                            if ("getNickName".equals(paramMessage))
                            {
                              ThreadManager.a(new rir(this, (QQAppInterface)localObject9, ((Bundle)localObject13).getBundle("request").getStringArrayList("uins"), (Bundle)localObject13, (MessengerService)localObject12), 5, null, false);
                              return;
                            }
                            if ("setHasSetPwd".equals(paramMessage))
                            {
                              PhoneNumLoginImpl.a().a((QQAppInterface)localObject9, ((QQAppInterface)localObject9).a(), true);
                              return;
                            }
                            if ("getA2".equals(paramMessage))
                            {
                              localObject2 = ((Bundle)localObject10).getString("uin");
                              paramMessage = "";
                              localObject6 = (WtloginManager)((QQAppInterface)localObject9).getManager(1);
                              if (localObject6 != null) {
                                for (;;)
                                {
                                  try
                                  {
                                    localObject2 = HexUtil.a(WtloginHelper.GetTicketSig(((WtloginManager)localObject6).GetLocalSig((String)localObject2, 16L), 64));
                                    paramMessage = (Message)localObject2;
                                    localObject2 = paramMessage;
                                  }
                                  catch (Exception localException5)
                                  {
                                    label6235:
                                    long l2;
                                    Object localObject3;
                                    int i2;
                                    int i3;
                                    Object localObject15;
                                    Object localObject16;
                                    Object localObject17;
                                    ArrayList localArrayList;
                                    FavroamingDBManager localFavroamingDBManager;
                                    JSONObject localJSONObject;
                                    String str2;
                                    VipComicFavorEmoStructMsgInfo localVipComicFavorEmoStructMsgInfo;
                                    CustomEmotionData localCustomEmotionData;
                                    Object localObject7;
                                    Object localObject8;
                                    float f;
                                    short s;
                                    continue;
                                    i = -1;
                                    l1 = 0L;
                                    continue;
                                    i = -1;
                                    l1 = 0L;
                                    continue;
                                    paramMessage = "password";
                                    continue;
                                    if (i != 3) {
                                      continue;
                                    }
                                    i = 2;
                                    continue;
                                    i = -1;
                                    continue;
                                    i = 1;
                                    continue;
                                  }
                                  try
                                  {
                                    if (QLog.isColorLevel())
                                    {
                                      QLog.d("Q.emoji.web.MessengerService", 2, "a2 = " + paramMessage);
                                      localObject2 = paramMessage;
                                    }
                                    paramMessage = (Message)localObject2;
                                    localObject2 = new Bundle();
                                    ((Bundle)localObject2).putString("A2", paramMessage);
                                    ((Bundle)localObject13).putBundle("response", (Bundle)localObject2);
                                    ((MessengerService)localObject12).a((Bundle)localObject13);
                                    return;
                                  }
                                  catch (Exception localException4)
                                  {
                                    continue;
                                  }
                                  ((Exception)localObject2).printStackTrace();
                                }
                              }
                            }
                            else
                            {
                              if ("card_getinfo".equals(paramMessage))
                              {
                                l2 = 0L;
                                paramMessage = ((FriendsManager)((QQAppInterface)localObject9).getManager(50)).a(((QQAppInterface)localObject9).a());
                                if (paramMessage == null) {
                                  break label14875;
                                }
                                if (paramMessage.lCurrentBgId == -1L) {
                                  break label14866;
                                }
                                if (paramMessage.lCurrentStyleId == -1L) {
                                  break label14866;
                                }
                                while (i == -1)
                                {
                                  if (QLog.isColorLevel()) {
                                    QLog.d("MessengerService.onCardDownload", 2, "start onCardDownload");
                                  }
                                  ((QQAppInterface)localObject9).a(((MessengerService)localObject12).jdField_a_of_type_ComTencentMobileqqAppCardObserver);
                                  ((MessengerService)localObject12).jdField_a_of_type_JavaUtilList.add(localObject13);
                                  paramMessage = (CardHandler)((QQAppInterface)localObject9).a(2);
                                  l1 = ProfileActivity.a(new ProfileActivity.AllInOne(((QQAppInterface)localObject9).a(), 0), false);
                                  paramMessage.a(((QQAppInterface)localObject9).a(), ((QQAppInterface)localObject9).a(), 0, 0L, (byte)1, 0L, 0L, null, "", l1, 10004, null);
                                  return;
                                  l2 = paramMessage.lCurrentBgId;
                                  l1 = paramMessage.lCurrentStyleId;
                                  i = 0;
                                }
                                paramMessage = new Bundle();
                                paramMessage.putLong("currentId", l2);
                                paramMessage.putLong("styleId", l1);
                                paramMessage.putInt("result", i);
                                ((Bundle)localObject13).putBundle("response", paramMessage);
                                ((MessengerService)localObject12).a((Bundle)localObject13);
                                return;
                              }
                              if ("card_setSummaryCard".equals(paramMessage))
                              {
                                ((QQAppInterface)localObject9).a(((MessengerService)localObject12).jdField_a_of_type_ComTencentMobileqqAppCardObserver);
                                ((MessengerService)localObject12).jdField_a_of_type_AndroidOsBundle = ((Bundle)localObject13);
                                i = ((Bundle)localObject13).getInt("styleId");
                                j = ((Bundle)localObject13).getInt("bgId");
                                ProfileCardUtil.a((QQAppInterface)localObject9, i, j);
                                return;
                              }
                              if ("getRoam".equals(paramMessage))
                              {
                                localObject2 = "success";
                                localObject6 = ((QQAppInterface)localObject9).getApplication().getSharedPreferences("vip_message_roam_banner_file", 0);
                                i = ((SharedPreferences)localObject6).getInt("message_roam_flag" + ((QQAppInterface)localObject9).a(), -1);
                                paramMessage = (Message)localObject2;
                                if (i != 1)
                                {
                                  paramMessage = (Message)localObject2;
                                  if (i != 2)
                                  {
                                    paramMessage = (Message)localObject2;
                                    if (i != 3)
                                    {
                                      paramMessage = (Message)localObject2;
                                      if (i != 4)
                                      {
                                        paramMessage = "messageRoamType is error , = " + i;
                                        ((MessengerService)localObject12).a(paramMessage);
                                      }
                                    }
                                  }
                                }
                                j = ((SharedPreferences)localObject6).getInt("message_roam_is_set_password" + ((QQAppInterface)localObject9).a(), -1);
                                localObject2 = paramMessage;
                                if (j != 1)
                                {
                                  localObject2 = paramMessage;
                                  if (j != 0)
                                  {
                                    localObject2 = "isSetPassWord is error , = " + j;
                                    ((MessengerService)localObject12).a((String)localObject2);
                                  }
                                }
                                k = VipUtils.a((QQAppInterface)localObject9, null);
                                if (k == -1)
                                {
                                  localObject2 = "user type is error , = " + k;
                                  ((MessengerService)localObject12).a((String)localObject2);
                                }
                                localObject6 = new Bundle();
                                paramMessage = (MessageRoamManager)((QQAppInterface)localObject9).getManager(91);
                                if (paramMessage != null)
                                {
                                  if (paramMessage.b() != 1) {
                                    break label14884;
                                  }
                                  paramMessage = "devlock";
                                  ((Bundle)localObject6).putString("verification", paramMessage);
                                }
                                ((Bundle)localObject6).putInt("type", i);
                                ((Bundle)localObject6).putInt("userType", k);
                                ((Bundle)localObject6).putInt("isSetPassword", j);
                                ((Bundle)localObject6).putInt("result", 0);
                                ((Bundle)localObject6).putString("errorMessage", (String)localObject2);
                                EquipmentLockImpl.a().a((AppInterface)localObject9, ((QQAppInterface)localObject9).a(), new ris(this, (Bundle)localObject6, (Bundle)localObject13, (MessengerService)localObject12));
                                return;
                              }
                              if ("notifyGetMsgRoam".equals(paramMessage))
                              {
                                paramMessage = ((Bundle)localObject10).getString("pwd");
                                ((MessageRoamManager)((QQAppInterface)localObject9).getManager(91)).c(paramMessage);
                                return;
                              }
                              if ("card_getVipInfo".equals(paramMessage))
                              {
                                paramMessage = new Bundle();
                                paramMessage.putString("vip_info", VipUtils.a((AppInterface)localObject9, ((QQAppInterface)localObject9).a()));
                                ((Bundle)localObject13).putBundle("response", paramMessage);
                                ((MessengerService)localObject12).a((Bundle)localObject13);
                                return;
                              }
                              if ("openEmojiMall".equals(paramMessage))
                              {
                                paramMessage = new Bundle();
                                i = ((QQAppInterface)localObject9).a().a();
                                localObject2 = ((QQAppInterface)localObject9).a().a();
                                paramMessage.putInt("curChatType", i);
                                paramMessage.putString("curChatUin", (String)localObject2);
                                ((Bundle)localObject13).putBundle("response", paramMessage);
                                ((MessengerService)localObject12).a((Bundle)localObject13);
                                return;
                              }
                              if ("openEmojiDetail".equals(paramMessage))
                              {
                                paramMessage = new Bundle();
                                i = ((QQAppInterface)localObject9).a().a();
                                localObject2 = ((QQAppInterface)localObject9).a().a();
                                paramMessage.putInt("curChatType", i);
                                paramMessage.putString("curChatUin", (String)localObject2);
                                ((Bundle)localObject13).putBundle("response", paramMessage);
                                ((MessengerService)localObject12).a((Bundle)localObject13);
                                return;
                              }
                              if ("openProfileCard".equals(paramMessage))
                              {
                                paramMessage = new Bundle();
                                j = 1;
                                localObject2 = (RedTouchManager)((QQAppInterface)localObject9).getManager(35);
                                i = j;
                                if (localObject2 != null) {}
                                try
                                {
                                  localObject2 = ((RedTouchManager)localObject2).a("100005.100012");
                                  if (localObject2 == null) {
                                    break label14783;
                                  }
                                  i = ((BusinessInfoCheckUpdate.AppInfo)localObject2).iNewFlag.get();
                                  if (1 != i) {
                                    break label14783;
                                  }
                                  i = 0;
                                }
                                catch (Exception localException2)
                                {
                                  for (;;)
                                  {
                                    label7252:
                                    localException2.printStackTrace();
                                    i = j;
                                  }
                                }
                                paramMessage.putInt("isCache", i);
                                ((Bundle)localObject13).putBundle("response", paramMessage);
                                ((MessengerService)localObject12).a((Bundle)localObject13);
                              }
                              else
                              {
                                if ("openFontSetting".equals(paramMessage))
                                {
                                  bool1 = ((FontManager)((QQAppInterface)localObject9).getManager(41)).a();
                                  paramMessage = new Bundle();
                                  paramMessage.putBoolean("feature", bool1);
                                  ((Bundle)localObject13).putBundle("response", paramMessage);
                                  ((MessengerService)localObject12).a((Bundle)localObject13);
                                  return;
                                }
                                if ("isSupportFont".equals(paramMessage))
                                {
                                  bool1 = ((FontManager)((QQAppInterface)localObject9).getManager(41)).a();
                                  paramMessage = new Bundle();
                                  paramMessage.putBoolean("feature", bool1);
                                  ((Bundle)localObject13).putBundle("response", paramMessage);
                                  ((MessengerService)localObject12).a((Bundle)localObject13);
                                  return;
                                }
                                if ("startDownloadColorRing".equals(paramMessage))
                                {
                                  i = ((Bundle)localObject10).getInt("id");
                                  j = ((Bundle)localObject10).getInt("resourceType");
                                  paramMessage = ((Bundle)localObject10).getString("colorType");
                                  localObject3 = (ColorRingManager)((QQAppInterface)localObject9).getManager(44);
                                  ((ColorRingManager)localObject3).jdField_a_of_type_ComTencentMobileqqVipIPCDownloadListener = ((MessengerService)localObject12).jdField_a_of_type_ComTencentMobileqqVipIPCDownloadListener;
                                  ((ColorRingManager)localObject3).a(i, j, true, 5, paramMessage);
                                  return;
                                }
                                if ("colorRingSetup".equals(paramMessage))
                                {
                                  localObject6 = Long.valueOf(((Bundle)localObject10).getLong("id"));
                                  localObject10 = ((QQAppInterface)localObject9).getAccount();
                                  localObject9 = (FriendsManager)((QQAppInterface)localObject9).getManager(50);
                                  localObject3 = ((FriendsManager)localObject9).a((String)localObject10);
                                  paramMessage = (Message)localObject3;
                                  if (localObject3 == null)
                                  {
                                    paramMessage = new ExtensionInfo();
                                    paramMessage.uin = ((String)localObject10);
                                  }
                                  paramMessage.colorRingId = ((Long)localObject6).longValue();
                                  paramMessage.commingRingId = ((Long)localObject6).longValue();
                                  ((FriendsManager)localObject9).a(paramMessage);
                                  return;
                                }
                                if ("stopDownloadColorRing".equals(paramMessage))
                                {
                                  i = ((Bundle)localObject10).getInt("id");
                                  j = ((Bundle)localObject10).getInt("resourceType");
                                  ((ColorRingManager)((QQAppInterface)localObject9).getManager(44)).a(i, j);
                                  return;
                                }
                                if ("reportColorRing".equals(paramMessage))
                                {
                                  paramMessage = ((Bundle)localObject10).getString("subAction");
                                  localObject3 = ((Bundle)localObject10).getString("actionName");
                                  l1 = ((Bundle)localObject10).getLong("id");
                                  j = ((Bundle)localObject10).getInt("result");
                                  i = ((SVIPHandler)((QQAppInterface)localObject9).a(13)).h();
                                  if (i != 2) {
                                    break label14891;
                                  }
                                  i = 0;
                                  label7695:
                                  ReportController.b((QQAppInterface)localObject9, "CliOper", "", "", paramMessage, (String)localObject3, 0, j, "" + i, l1 + "", "", "");
                                  return;
                                }
                                if ("puzzle_verify_code_setTicket".equals(paramMessage))
                                {
                                  bool1 = ((Bundle)localObject10).getBoolean("is_register_uin", false);
                                  i = ((Bundle)localObject10).getInt("seq");
                                  paramMessage = ((Bundle)localObject10).getString("ticket");
                                  if (bool1)
                                  {
                                    i = ((Bundle)localObject10).getInt("register_uin_msg");
                                    localObject3 = ((Bundle)localObject10).getString("register_uin_class");
                                    bool1 = TextUtils.isEmpty((CharSequence)localObject3);
                                    if (bool1) {
                                      break label14808;
                                    }
                                    try
                                    {
                                      localObject3 = ((QQAppInterface)localObject9).a(Class.forName((String)localObject3));
                                      if (localObject3 == null) {
                                        break label14808;
                                      }
                                      ((MqqHandler)localObject3).sendMessage(((MqqHandler)localObject3).obtainMessage(i, paramMessage));
                                      return;
                                    }
                                    catch (Throwable paramMessage)
                                    {
                                      paramMessage.printStackTrace();
                                      return;
                                    }
                                  }
                                  localObject3 = (VerifyCodeManager)((QQAppInterface)localObject9).getManager(6);
                                  if (localObject3 == null) {
                                    break label14808;
                                  }
                                  ((VerifyCodeManager)localObject3).submitPuzzleVerifyCodeTicket(i, paramMessage);
                                  return;
                                }
                                if ("puzzle_verify_code_clearProgressDialog".equals(paramMessage))
                                {
                                  paramMessage = ((QQAppInterface)localObject9).a(LoginActivity.class);
                                  if (paramMessage != null) {
                                    paramMessage.sendEmptyMessage(20140107);
                                  }
                                  paramMessage = ((QQAppInterface)localObject9).a(SubLoginActivity.class);
                                  if (paramMessage != null) {
                                    paramMessage.sendEmptyMessage(20140107);
                                  }
                                  paramMessage = ((QQAppInterface)localObject9).a(Login.class);
                                  if (paramMessage == null) {
                                    break label14808;
                                  }
                                  paramMessage.sendEmptyMessage(7);
                                  return;
                                }
                                if ("close_version".equals(paramMessage))
                                {
                                  paramMessage = ((Bundle)localObject13).getBundle("request");
                                  if (paramMessage != null)
                                  {
                                    l1 = paramMessage.getLong("version", 0L);
                                    paramMessage = (VipGiftManager)((QQAppInterface)localObject9).getManager(75);
                                    if ((paramMessage == null) || (!paramMessage.a(l1))) {
                                      break label14903;
                                    }
                                    paramMessage.a("0X8004B41", "3", "0", null);
                                    i = 0;
                                    label8053:
                                    paramMessage = new Bundle();
                                    paramMessage.putInt("result", i);
                                    ((Bundle)localObject13).putBundle("response", paramMessage);
                                    ((MessengerService)localObject12).a((Bundle)localObject13);
                                  }
                                }
                                else
                                {
                                  if ("close_annimate".equals(paramMessage))
                                  {
                                    paramMessage = ((Bundle)localObject13).getBundle("request");
                                    if (paramMessage == null) {
                                      break label14808;
                                    }
                                    l1 = paramMessage.getLong("Gif_msg_uniseq_key", 0L);
                                    if (l1 == 0L) {
                                      break label14808;
                                    }
                                    paramMessage = (VipGiftManager)((QQAppInterface)localObject9).getManager(75);
                                    localObject3 = paramMessage.a();
                                    if ((localObject3 == null) || (((VipGiftDownloadInfo)localObject3).d != 3L)) {
                                      break label14808;
                                    }
                                    paramMessage.a(4L, l1);
                                    return;
                                  }
                                  if ("special_care_set_ring".equals(paramMessage))
                                  {
                                    localObject3 = ((Bundle)localObject13).getBundle("request");
                                    localObject6 = new Bundle();
                                    if (localObject3 == null) {
                                      break label14808;
                                    }
                                    ((MessengerService)localObject12).jdField_a_of_type_ComTencentMobileqqActivitySpecialcareVipSpecialCareHandler.a((QQAppInterface)localObject9, paramMessage, (Bundle)localObject13, (Bundle)localObject6);
                                    return;
                                  }
                                  if ("special_care_get_ring".equals(paramMessage))
                                  {
                                    paramMessage = ((Bundle)localObject13).getBundle("request");
                                    if (paramMessage == null) {
                                      break label14808;
                                    }
                                    i = QvipSpecialCareManager.a(paramMessage.getString("uin"), (QQAppInterface)localObject9);
                                    paramMessage = new Bundle();
                                    paramMessage.putInt("id", i);
                                    ((Bundle)localObject13).putBundle("response", paramMessage);
                                    ((MessengerService)localObject12).a((Bundle)localObject13);
                                    return;
                                  }
                                  if ("special_care_get_friend_count".equals(paramMessage))
                                  {
                                    paramMessage = new Bundle();
                                    paramMessage.putInt("count", QvipSpecialCareManager.c((QQAppInterface)localObject9));
                                    ((Bundle)localObject13).putBundle("response", paramMessage);
                                    ((MessengerService)localObject12).a((Bundle)localObject13);
                                    return;
                                  }
                                  if ("sepcial_care_delete_ring".equals(paramMessage))
                                  {
                                    localObject3 = new Bundle();
                                    ((MessengerService)localObject12).jdField_a_of_type_ComTencentMobileqqActivitySpecialcareVipSpecialCareHandler.a((QQAppInterface)localObject9, paramMessage, (Bundle)localObject13, (Bundle)localObject3);
                                    return;
                                  }
                                  if ("special_care_get_switch_state".equals(paramMessage))
                                  {
                                    paramMessage = new Bundle();
                                    i = RoamSettingController.a((QQAppInterface)localObject9);
                                    if (i == 0)
                                    {
                                      i = ((QQAppInterface)localObject9).d();
                                      ((MessengerService)localObject12).a("-->state follow,all sound switch state:" + i);
                                      if (i != 0) {
                                        break label14909;
                                      }
                                      i = 0;
                                      label8438:
                                      paramMessage.putInt("state", i);
                                      ((Bundle)localObject13).putBundle("response", paramMessage);
                                      ((MessengerService)localObject12).a((Bundle)localObject13);
                                    }
                                  }
                                  else
                                  {
                                    if ("is_special_friend".equals(paramMessage))
                                    {
                                      localObject6 = new Bundle();
                                      paramMessage = ((Bundle)localObject13).getBundle("request");
                                      if (paramMessage == null) {
                                        break label14808;
                                      }
                                      localObject3 = paramMessage.getString("friendUin");
                                      paramMessage = (Message)localObject3;
                                      if (localObject3 == null) {
                                        paramMessage = "";
                                      }
                                      if (QvipSpecialCareManager.a(((QQAppInterface)localObject9).a() + paramMessage)) {
                                        ((Bundle)localObject6).putInt("isSpecialFriend", 1);
                                      }
                                      for (;;)
                                      {
                                        ((Bundle)localObject13).putBundle("response", (Bundle)localObject6);
                                        ((MessengerService)localObject12).a((Bundle)localObject13);
                                        return;
                                        ((Bundle)localObject6).putInt("isSpecialFriend", 0);
                                      }
                                    }
                                    if ("getDomainIpList".equals(paramMessage))
                                    {
                                      localObject3 = FMTSrvAddrProvider.a().a(15);
                                      paramMessage = new JSONArray();
                                      if (localObject3 == null) {}
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                        break;
                      }
                    }
                  }
                }
              }
            }
          }
          break;
        }
      }
    }
    label8893:
    label8969:
    label9396:
    label9652:
    int m;
    label9720:
    int i1;
    try
    {
      localObject3 = ((ArrayList)localObject3).iterator();
      while (((Iterator)localObject3).hasNext()) {
        paramMessage.put(((FileStorageServerListInfo)((Iterator)localObject3).next()).sIP);
      }
      localObject3 = new Bundle();
      localObject6 = new JSONObject();
      ((JSONObject)localObject6).put("result", 0);
      ((JSONObject)localObject6).put("message", "ok");
      ((JSONObject)localObject6).put("ips", paramMessage);
      ((Bundle)localObject3).putString("result", ((JSONObject)localObject6).toString());
      ((Bundle)localObject13).putBundle("response", (Bundle)localObject3);
      ((MessengerService)localObject12).a((Bundle)localObject13);
      return;
    }
    catch (JSONException paramMessage)
    {
      label9871:
      label9900:
      label10344:
      label10373:
      label10848:
      label11045:
      label12795:
      label13092:
      label13184:
      label13854:
      label14753:
      label14783:
      label14808:
      label14812:
      label14818:
      label14824:
      label14836:
      label14842:
      label14866:
      label14875:
      label14884:
      label14891:
      label14903:
      label14909:
      return;
    }
    if (("selectPhoto".equals(paramMessage)) || ("takePhoto".equals(paramMessage)))
    {
      ((MessengerService)localObject12).b(paramMessage);
      ((Bundle)localObject13).putBundle("response", new Bundle());
      ((MessengerService)localObject12).a((Bundle)localObject13);
      return;
    }
    if ("funcall_download".equals(paramMessage))
    {
      i = ((Bundle)localObject10).getInt("callId");
      VipFunCallManager.a((AppRuntime)localObject9, i, (Bundle)localObject10, null, true);
      j = ((Bundle)localObject10).getInt("ringId");
      VipFunCallManager.a();
      ((VipFunCallManager)((QQAppInterface)localObject9).getManager(83)).a(i, j, true, 6, ((MessengerService)localObject12).jdField_a_of_type_ComTencentMobileqqVipIPCDownloadListener);
      return;
    }
    int n;
    boolean bool2;
    if (("funcall_set".equals(paramMessage)) || ("funcall_delete".equals(paramMessage)))
    {
      ((Bundle)localObject10).putInt("srcType", 7);
      if ("funcall_set".equals(paramMessage))
      {
        i = 3;
        paramMessage = (VipFunCallManager)((QQAppInterface)localObject9).getManager(83);
        paramMessage = (VipSetFunCallHandler)((QQAppInterface)localObject9).a(46);
        ((QQAppInterface)localObject9).a(((MessengerService)localObject12).jdField_a_of_type_ComTencentMobileqqVipavVipFunCallObserver);
        paramMessage.a(i, localObject10);
      }
    }
    else
    {
      if ("leba_item_set".equals(paramMessage))
      {
        i = ((Bundle)localObject10).getInt("path");
        if (((Bundle)localObject10).getInt("type") != 1) {
          break label14917;
        }
        bool1 = true;
        l1 = NetConnInfoCenter.getServerTimeMillis();
        LebaShowListManager.a().a((QQAppInterface)localObject9, i, bool1, NetConnInfoCenter.getServerTimeMillis(), Long.MIN_VALUE);
        paramMessage = (RedTouchHandler)((QQAppInterface)localObject9).a(31);
        if (paramMessage != null)
        {
          paramMessage.a(String.valueOf(i), bool1, l1);
          paramMessage.a(1, true, null);
        }
        LebaShowListManager.d |= 0x4;
        paramMessage = new Bundle();
        paramMessage.putInt("ret", 0);
        ((Bundle)localObject13).putBundle("response", paramMessage);
        ((MessengerService)localObject12).a((Bundle)localObject13);
        return;
      }
      if ("leba_item_get".equals(paramMessage))
      {
        ThreadManager.a(new rit(this, (MessengerService)localObject12, (QQAppInterface)localObject9, ((Bundle)localObject10).getInt("path"), (Bundle)localObject13), 8, null, true);
        return;
      }
      if ("QQVIPFunctionReport643".equals(paramMessage))
      {
        ((Bundle)localObject10).getString("tag");
        paramMessage = ((Bundle)localObject10).getString("mainAction");
        localObject3 = ((Bundle)localObject10).getString("toUin");
        localObject6 = ((Bundle)localObject10).getString("subAction");
        localObject11 = ((Bundle)localObject10).getString("actionName");
        i = ((Bundle)localObject10).getInt("fromeType");
        j = ((Bundle)localObject10).getInt("result");
        localObject10 = ((Bundle)localObject10).getStringArray("reserves");
        ReportController.b((QQAppInterface)localObject9, "CliOper", paramMessage, (String)localObject3, (String)localObject6, (String)localObject11, i, j, localObject10[0], localObject10[1], localObject10[2], localObject10[3]);
        return;
      }
      if ("checkRelation".equals(paramMessage))
      {
        paramMessage = ((Bundle)localObject10).getString("uin");
        localObject3 = (FriendsManager)((QQAppInterface)localObject9).getManager(50);
        if ((paramMessage == null) || (localObject3 == null)) {
          break label14808;
        }
        localObject6 = new Bundle();
        ((Bundle)localObject6).putBoolean("result", ((FriendsManager)localObject3).b(paramMessage));
        ((Bundle)localObject13).putBundle("response", (Bundle)localObject6);
        ((MessengerService)localObject12).a((Bundle)localObject13);
        return;
      }
      if ("getFlowerVisibility".equals(paramMessage))
      {
        bool1 = NearbyProfileUtil.a((QQAppInterface)localObject9);
        paramMessage = new Bundle();
        paramMessage.putBoolean("result", bool1);
        ((Bundle)localObject13).putBundle("response", paramMessage);
        ((MessengerService)localObject12).a((Bundle)localObject13);
        return;
      }
      if ("setFlowerVisibility".equals(paramMessage))
      {
        if (((Bundle)localObject10).containsKey("isVisible"))
        {
          NearbyProfileUtil.a((QQAppInterface)localObject9, ((Bundle)localObject10).getBoolean("isVisible"));
          i = 0;
          paramMessage = new Bundle();
          paramMessage.putInt("result", i);
          ((Bundle)localObject13).putBundle("response", paramMessage);
          ((MessengerService)localObject12).a((Bundle)localObject13);
        }
      }
      else
      {
        if ("open_secmsg".equals(paramMessage))
        {
          paramMessage = new Bundle();
          paramMessage.putParcelable("secmsg_receiver", ((SecMsgManager)((QQAppInterface)localObject9).getManager(56)).a);
          ((Bundle)localObject13).putBundle("response", paramMessage);
          ((MessengerService)localObject12).a((Bundle)localObject13);
          return;
        }
        if ("check_sec_group".equals(paramMessage))
        {
          paramMessage = new Bundle();
          localObject3 = (SecMsgManager)((QQAppInterface)localObject9).getManager(56);
          paramMessage.putBoolean("sec_group_available", false);
          ((Bundle)localObject13).putBundle("response", paramMessage);
          ((MessengerService)localObject12).a((Bundle)localObject13);
          return;
        }
        if ("open_sec_group".equals(paramMessage))
        {
          paramMessage = new Bundle();
          paramMessage.putParcelable("secmsg_receiver", ((SecMsgManager)((QQAppInterface)localObject9).getManager(56)).a);
          ((Bundle)localObject13).putBundle("response", paramMessage);
          ((MessengerService)localObject12).a((Bundle)localObject13);
          return;
        }
        if ("starBless".equals(paramMessage)) {
          break label14808;
        }
        bool1 = paramMessage.equals("ipc_funnypic_add");
        if (bool1)
        {
          try
          {
            paramMessage = ((Bundle)localObject10).getString("jsonContent");
            if (TextUtils.isEmpty(paramMessage)) {
              break label14808;
            }
            paramMessage = new JSONObject(paramMessage);
            if (paramMessage.getInt("action") != 0) {
              break label14947;
            }
            k = 1;
            paramMessage = paramMessage.getJSONArray("uids");
            localObject3 = (FavroamingDBManager)((QQAppInterface)localObject9).getManager(148);
            localObject10 = ((FavroamingDBManager)localObject3).a();
            localObject6 = new ArrayList();
            i = 1;
            m = FavEmoConstant.a;
            j = m;
            if (localObject10 != null)
            {
              n = 0;
              j = m;
              i = 1;
              m = n;
              if (m >= ((List)localObject10).size()) {
                break label14953;
              }
              i1 = ((CustomEmotionData)((List)localObject10).get(m)).emoId;
              n = j;
              if ("needDel".equals(((CustomEmotionData)((List)localObject10).get(m)).RomaingType)) {
                break label14923;
              }
              j -= 1;
              localObject11 = ((CustomEmotionData)((List)localObject10).get(m)).md5;
              n = j;
              if (TextUtils.isEmpty((CharSequence)localObject11)) {
                break label14923;
              }
              n = j;
              if (((String)localObject11).length() <= 8) {
                break label14923;
              }
              ((List)localObject6).add("qto_" + ((String)localObject11).substring(0, 8).toLowerCase());
              n = j;
              break label14923;
            }
            localObject10 = new ArrayList();
            i1 = paramMessage.length();
            i2 = i1 - j;
            j = i;
            i = 0;
            if (i < i1)
            {
              m = j + 1;
              localObject11 = (JSONObject)paramMessage.get(i);
              j = ((JSONObject)localObject11).getInt("pkgid");
              localObject11 = ((JSONObject)localObject11).getString("uid");
              localObject14 = new CustomEmotionData();
              ((CustomEmotionData)localObject14).uin = ((QQAppInterface)localObject9).a();
              ((CustomEmotionData)localObject14).eId = ("qto_" + j);
              ((CustomEmotionData)localObject14).emoId = m;
              ((CustomEmotionData)localObject14).emoPath = "";
              ((CustomEmotionData)localObject14).url = ("http://i.gtimg.cn/qqshow/admindata/comdata/vipQutu_item_" + j + "/" + (String)localObject11);
              if (k != 0)
              {
                n = 0;
                j = n;
                if (!TextUtils.isEmpty((CharSequence)localObject11))
                {
                  i3 = ((String)localObject11).lastIndexOf(".");
                  j = n;
                  if (i3 > 0)
                  {
                    j = n;
                    if (((List)localObject6).contains(((String)localObject11).substring(0, i3).toLowerCase())) {
                      j = 1;
                    }
                  }
                }
                if (j == 0)
                {
                  ((FavroamingDBManager)localObject3).c((CustomEmotionData)localObject14);
                  ((List)localObject10).add(localObject14);
                }
              }
              while (QLog.isColorLevel())
              {
                QLog.d("Q.emoji.web.MessengerService", 2, "insert funnyPic eId->" + ((CustomEmotionData)localObject14).eId + " emoPath->" + ((CustomEmotionData)localObject14).emoPath + " exist->" + ((List)localObject6).contains(((CustomEmotionData)localObject14).emoPath));
                break;
                ((List)localObject10).add(localObject14);
              }
            }
            QLog.i("Q.emoji.web.MessengerService", 2, paramMessage);
          }
          catch (JSONException paramMessage)
          {
            ((Bundle)localObject13).putInt("result", 1);
            paramMessage = paramMessage.getMessage();
            if (paramMessage != null) {
              ((Bundle)localObject13).putString("message", paramMessage);
            }
            ((MessengerService)localObject12).a((Bundle)localObject13);
            if (!QLog.isColorLevel()) {
              break label14808;
            }
            QLog.i("Q.emoji.web.MessengerService", 2, paramMessage);
            return;
            if (k == 0) {
              break label10373;
            }
            if (!((List)localObject10).isEmpty()) {
              break label10344;
            }
            ((Bundle)localObject13).putInt("result", 0);
            ((MessengerService)localObject12).a((Bundle)localObject13);
            return;
          }
          catch (Exception paramMessage)
          {
            ((Bundle)localObject13).putInt("result", 1);
            paramMessage = paramMessage.getMessage();
            if (paramMessage != null) {
              ((Bundle)localObject13).putString("message", paramMessage);
            }
            ((MessengerService)localObject12).a((Bundle)localObject13);
            if (!QLog.isColorLevel()) {
              break label14808;
            }
          }
          return;
          FunnyPicHelper.a(((MessengerService)localObject12).getApplicationContext(), (List)localObject10, (AppInterface)localObject9, new MessengerService.IncomingHandler.9(this, (Bundle)localObject13, (FavroamingDBManager)localObject3, (MessengerService)localObject12, (QQAppInterface)localObject9));
          return;
          FunnyPicHelper.a(false, ((MessengerService)localObject12).getApplicationContext(), (List)localObject10, (AppInterface)localObject9, new MessengerService.IncomingHandler.10(this, (Bundle)localObject13, (QQAppInterface)localObject9, (MessengerService)localObject12));
          if (i2 <= 0) {
            break label14808;
          }
          ReportController.b(null, "CliOper", "", "", "0X8005C78", "0X8005C78", 0, 0, String.valueOf(i2), "", "", "");
          return;
        }
        if (paramMessage.equals("ipc_funnypic_query_info"))
        {
          if (!TextUtils.isEmpty(((Bundle)localObject10).getString("jsonContent")))
          {
            ThreadManager.a(new rib(this, (QQAppInterface)localObject9, (Bundle)localObject13, (MessengerService)localObject12), 5, null, true);
            return;
          }
          try
          {
            paramMessage = new JSONObject();
            paramMessage.put("remainNum", FavEmoConstant.a);
            paramMessage.put("uid", new JSONArray());
            ((Bundle)localObject13).putInt("result", 0);
            ((Bundle)localObject13).putString("data", paramMessage.toString());
            ((MessengerService)localObject12).a((Bundle)localObject13);
            return;
          }
          catch (Exception paramMessage)
          {
            if (!QLog.isColorLevel()) {
              break label14808;
            }
          }
          QLog.i("Q.emoji.web.MessengerService", 2, paramMessage.getMessage());
          return;
        }
        if ("ipc_comic_emoticon_add_info".equals(paramMessage))
        {
          paramMessage = new JSONObject();
          localObject3 = new JSONObject();
          try
          {
            localObject6 = new JSONArray(((Bundle)localObject10).getString("listArray"));
            localObject10 = (VipComicMqqManager)((QQAppInterface)localObject9).getManager(140);
            localObject11 = new ArrayList();
            localObject15 = ((VipComicMqqManager)localObject10).a((List)localObject11);
            k = FavEmoConstant.a - ((List)localObject11).size();
            ((JSONObject)localObject3).put("totalNum", FavEmoConstant.a);
            ((JSONObject)localObject3).put("remainNum", k);
            ((JSONObject)localObject3).put("succeedNum", 0);
            ((JSONObject)localObject3).put("failedNum", ((JSONArray)localObject6).length());
            if (((JSONArray)localObject6).length() > k)
            {
              paramMessage.put("code", 2);
              paramMessage.put("message", "limit error");
              paramMessage.put("data", localObject3);
              ((Bundle)localObject13).putString("result", paramMessage.toString());
              ((MessengerService)localObject12).a((Bundle)localObject13);
              return;
            }
          }
          catch (Exception localException6) {}
          try
          {
            paramMessage.put("code", -1);
            paramMessage.put("message", localException6.getMessage());
            paramMessage.put("data", localObject3);
            ((Bundle)localObject13).putString("result", paramMessage.toString());
            ((MessengerService)localObject12).a((Bundle)localObject13);
            localException6.printStackTrace();
            return;
            localObject11 = new ArrayList();
            localObject14 = new ArrayList();
            i = 0;
            localObject15 = ((List)localObject15).iterator();
            if (((Iterator)localObject15).hasNext())
            {
              localObject16 = (CustomEmotionData)((Iterator)localObject15).next();
              if (!"needDel".equals(((CustomEmotionData)localObject16).RomaingType))
              {
                if (!TextUtils.isEmpty(((CustomEmotionData)localObject16).md5))
                {
                  localObject17 = ((CustomEmotionData)localObject16).md5.toUpperCase();
                  if (!((List)localObject14).contains(localObject17)) {
                    ((List)localObject14).add(localObject17);
                  }
                }
                if ((!TextUtils.isEmpty(((CustomEmotionData)localObject16).emoPath)) && (!((List)localObject11).contains(((CustomEmotionData)localObject16).emoPath))) {
                  ((List)localObject11).add(((CustomEmotionData)localObject16).emoPath);
                }
              }
              j = ((CustomEmotionData)localObject16).emoId;
              if (i >= j) {
                break label14753;
              }
              i = j;
              break label14969;
            }
            localObject15 = new ArrayList(localException6.length());
            localObject16 = new HashMap();
            localObject17 = ((QQAppInterface)localObject9).a().createEntityManager();
            localArrayList = new ArrayList();
            localFavroamingDBManager = (FavroamingDBManager)((QQAppInterface)localObject9).getManager(148);
            j = 0;
            if (j < localException6.length())
            {
              localJSONObject = (JSONObject)localException6.get(j);
              str2 = localJSONObject.getString("md5").toUpperCase();
              localVipComicFavorEmoStructMsgInfo = new VipComicFavorEmoStructMsgInfo();
              localVipComicFavorEmoStructMsgInfo.picMd5 = str2;
              localVipComicFavorEmoStructMsgInfo.actionData = localJSONObject.getString("actionData");
              if ((((List)localObject11).contains(((VipComicMqqManager)localObject10).a(str2))) || (((List)localObject14).contains(str2)))
              {
                if (localVipComicFavorEmoStructMsgInfo.equals(((VipComicMqqManager)localObject10).a(str2))) {
                  break label14972;
                }
                localArrayList.clear();
                localArrayList.add(localVipComicFavorEmoStructMsgInfo);
                ((VipComicMqqManager)localObject10).a(localArrayList, true);
                break label14972;
              }
              localCustomEmotionData = new CustomEmotionData();
              localCustomEmotionData.uin = ((QQAppInterface)localObject9).a();
              localCustomEmotionData.eId = localJSONObject.optString("name");
              i += 1;
              localCustomEmotionData.emoId = i;
              localCustomEmotionData.url = localJSONObject.getString("imgUrl");
              localCustomEmotionData.md5 = str2;
              ((List)localObject15).add(localCustomEmotionData);
              ((Map)localObject16).put(localVipComicFavorEmoStructMsgInfo.picMd5, localVipComicFavorEmoStructMsgInfo);
              localFavroamingDBManager.c(localCustomEmotionData);
              ((EntityManager)localObject17).a(localVipComicFavorEmoStructMsgInfo);
              break label14972;
            }
            if ((localObject15 == null) || (((List)localObject15).isEmpty()))
            {
              ((JSONObject)localObject3).put("failedNum", 0);
              if ((localException6 != null) && (localException6.length() > 0))
              {
                ((JSONObject)localObject3).put("succeedNum", localException6.length());
                localObject7 = ((QQAppInterface)localObject9).a(ChatActivity.class);
                if (localObject7 != null) {
                  ((MqqHandler)localObject7).obtainMessage(10).sendToTarget();
                }
              }
              paramMessage.put("code", 0);
              paramMessage.put("message", "ok");
              paramMessage.put("data", localObject3);
              ((Bundle)localObject13).putString("result", paramMessage.toString());
              ((MessengerService)localObject12).a((Bundle)localObject13);
              return;
            }
            ((VipComicMqqManager)localObject10).a(((MessengerService)localObject12).getApplicationContext(), (List)localObject15, (Map)localObject16, new MessengerService.IncomingHandler.12(this, paramMessage, (JSONObject)localObject3, k, (Bundle)localObject13, (MessengerService)localObject12, (Map)localObject16, localFavroamingDBManager, (EntityManager)localObject17, (VipComicMqqManager)localObject10, (QQAppInterface)localObject9));
            return;
          }
          catch (JSONException paramMessage)
          {
            for (;;)
            {
              paramMessage.printStackTrace();
            }
          }
        }
        if ("ipc_comic_emoticon_query_info".equals(paramMessage))
        {
          paramMessage = new JSONObject();
          localObject3 = new JSONObject();
          try
          {
            localObject7 = (VipComicMqqManager)((QQAppInterface)localObject9).getManager(140);
            localObject10 = new ArrayList();
            ((VipComicMqqManager)localObject7).a((List)localObject10);
            i = FavEmoConstant.a;
            j = ((List)localObject10).size();
            ((JSONObject)localObject3).put("totalNum", FavEmoConstant.a);
            ((JSONObject)localObject3).put("remainNum", i - j);
            localObject7 = ((VipComicMqqManager)localObject7).a();
            localObject9 = new JSONArray();
            if (localObject7 != null)
            {
              localObject10 = ((List)localObject10).iterator();
              while (((Iterator)localObject10).hasNext())
              {
                localObject11 = (CustomEmotionData)((Iterator)localObject10).next();
                if (!TextUtils.isEmpty(((CustomEmotionData)localObject11).md5))
                {
                  localObject11 = ((CustomEmotionData)localObject11).md5.toUpperCase();
                  if (((Map)localObject7).get(localObject11) != null) {
                    ((JSONArray)localObject9).put(localObject11);
                  }
                }
              }
            }
            try
            {
              paramMessage.put("code", -1);
              paramMessage.put("message", localException7.getMessage());
              paramMessage.put("data", localObject3);
              ((Bundle)localObject13).putString("result", paramMessage.toString());
              ((MessengerService)localObject12).a((Bundle)localObject13);
              localException7.printStackTrace();
              return;
              ((JSONObject)localObject3).put("list", localObject9);
              paramMessage.put("code", 0);
              paramMessage.put("message", "ok");
              paramMessage.put("data", localObject3);
              ((Bundle)localObject13).putString("result", paramMessage.toString());
              ((MessengerService)localObject12).a((Bundle)localObject13);
              return;
            }
            catch (JSONException paramMessage)
            {
              for (;;)
              {
                paramMessage.printStackTrace();
              }
            }
          }
          catch (Exception localException7) {}
        }
        if ("ipc_video_isinstalled".equals(paramMessage))
        {
          paramMessage = new Bundle();
          paramMessage.putBoolean("isInstalled", VipVideoManager.a(((QQAppInterface)localObject9).a()));
          ((Bundle)localObject13).putBundle("response", paramMessage);
          ((MessengerService)localObject12).a((Bundle)localObject13);
          return;
        }
        if ("ipc_video_install_plugin".equals(paramMessage))
        {
          VipVideoManager.a(((QQAppInterface)localObject9).a(), new ric(this, (Bundle)localObject13, (MessengerService)localObject12));
          return;
        }
        if ("ipc_jump_to_conversation".equals(paramMessage))
        {
          if (localObject9 == null) {
            break label14808;
          }
          paramMessage = ((QQAppInterface)localObject9).a(Conversation.class);
          if (paramMessage == null) {
            break label14808;
          }
          localObject3 = paramMessage.obtainMessage(((Bundle)localObject13).getInt("banner_msg"));
          localObject8 = new Bundle();
          ((Bundle)localObject8).putCharSequence("tips", ((Bundle)localObject13).getCharSequence("banner_tips"));
          ((Bundle)localObject8).putInt("icon", ((Bundle)localObject13).getInt("banner_icon"));
          ((Bundle)localObject8).putInt("timeout", ((Bundle)localObject13).getInt("banner_timeout"));
          ((Bundle)localObject8).putCharSequence("activity", ((Bundle)localObject13).getCharSequence("activity"));
          ((Bundle)localObject8).putCharSequence("action", ((Bundle)localObject13).getCharSequence("action"));
          ((Bundle)localObject8).putCharSequence("category", ((Bundle)localObject13).getCharSequence("category"));
          ((Bundle)localObject8).putInt("flags", ((Bundle)localObject13).getInt("flags", 0));
          ((Message)localObject3).obj = localObject8;
          paramMessage.sendMessage((Message)localObject3);
          return;
        }
        if ("ipc_apollo_preview".equals(paramMessage))
        {
          paramMessage = ((Bundle)localObject10).getIntArray("apollo_dressIds");
          if ((paramMessage != null) && (paramMessage.length > 0))
          {
            ApolloResDownloader.b((AppInterface)localObject9, ((QQAppInterface)localObject9).f(), new rid(this, (Bundle)localObject13, (MessengerService)localObject12), -1, paramMessage, -1, -1, false);
            return;
          }
          paramMessage = new Bundle();
          paramMessage.putInt("apollo_result", 1);
          ((Bundle)localObject13).putBundle("response", paramMessage);
          ((MessengerService)localObject12).a((Bundle)localObject13);
          return;
        }
        if ("ipc_apollo_preview_action".equals(paramMessage))
        {
          k = ((Bundle)localObject10).getInt("apollo_previewAction");
          paramMessage = ((Bundle)localObject10).getString("apollo_json");
          m = ((Bundle)localObject10).getInt("apollo_type");
          n = ((Bundle)localObject10).getInt("apollo_isSpecial");
          j = ((Bundle)localObject10).getInt("apollo_partnerRoleId");
          i = j;
          if (j == 0) {
            i = -1;
          }
          if (k > 0)
          {
            ApolloResDownloader.a((AppInterface)localObject9, ((QQAppInterface)localObject9).f(), new rie(this, n, (QQAppInterface)localObject9, paramMessage, k, (Bundle)localObject13, (MessengerService)localObject12), i, null, k, m, false);
            return;
          }
          localObject3 = new Bundle();
          ((Bundle)localObject3).putInt("apollo_result", 1);
          ((Bundle)localObject3).putString("apollo_json", paramMessage);
          ((Bundle)localObject13).putBundle("response", (Bundle)localObject3);
          ((MessengerService)localObject12).a((Bundle)localObject13);
          return;
        }
        if ("ipc_apollo_changerole".equals(paramMessage))
        {
          paramMessage = ((Bundle)localObject10).getIntArray("apollo_dressIds");
          j = ((Bundle)localObject10).getInt("apollo_roleId");
          k = ((Bundle)localObject10).getInt("apollo_fromSelf");
          if (j > 0)
          {
            if (k != 1) {
              ApolloBaseInfo.saveSelfApolloDress((AppInterface)localObject9, ((Bundle)localObject10).getString("apollo_userData"));
            }
            bool1 = false;
            bool2 = bool1;
            if (j > 0)
            {
              bool2 = bool1;
              if (paramMessage != null)
              {
                bool2 = bool1;
                if (paramMessage.length > 0)
                {
                  bool1 = ApolloUtil.c(j);
                  m = paramMessage.length;
                  i = 0;
                  bool2 = bool1;
                  if (i < m)
                  {
                    n = paramMessage[i];
                    if ((!bool1) || (!ApolloUtil.b(n))) {
                      break label14990;
                    }
                    bool1 = true;
                    break label14981;
                  }
                }
              }
            }
            if (bool2)
            {
              localObject3 = new Bundle();
              ((Bundle)localObject3).putInt("apollo_result", 0);
              ((Bundle)localObject3).putInt("apollo_roleId", j);
              ((Bundle)localObject3).putInt("apollo_fromSelf", k);
              ((Bundle)localObject3).putIntArray("apollo_dressIds", paramMessage);
              ((Bundle)localObject13).putBundle("response", (Bundle)localObject3);
              ((MessengerService)localObject12).a((Bundle)localObject13);
              return;
            }
            ApolloResDownloader.a((AppInterface)localObject9, ((QQAppInterface)localObject9).a(), new rif(this, k, (Bundle)localObject13, (MessengerService)localObject12), j, paramMessage, -1, -1, false);
            return;
          }
          paramMessage = new Bundle();
          paramMessage.putInt("apollo_result", 1);
          paramMessage.putInt("apollo_fromSelf", k);
          ((Bundle)localObject13).putBundle("response", paramMessage);
          ((MessengerService)localObject12).a((Bundle)localObject13);
          return;
        }
        if ("ipc_apollo_get_apollo_data".equals(paramMessage))
        {
          localObject8 = ((ApolloManager)((QQAppInterface)localObject9).getManager(152)).b(((QQAppInterface)localObject9).a());
          n = 0;
          localObject3 = null;
          k = 0;
          i1 = 0;
          i = i1;
          paramMessage = (Message)localObject3;
          j = n;
          if (localObject8 != null)
          {
            m = ((ApolloBaseInfo)localObject8).apolloStatus;
            localObject8 = ((ApolloBaseInfo)localObject8).getApolloDress();
            k = m;
            i = i1;
            paramMessage = (Message)localObject3;
            j = n;
            if (localObject8 != null)
            {
              j = ((ApolloDress)localObject8).a;
              i = ((ApolloDress)localObject8).b;
              paramMessage = ((ApolloDress)localObject8).a();
              k = m;
            }
          }
          m = ((Bundle)localObject10).getInt("apollo_initFrom");
          localObject3 = new Bundle();
          ((Bundle)localObject3).putInt("apollo_result", 0);
          ((Bundle)localObject3).putInt("apollo_initFrom", m);
          ((Bundle)localObject3).putInt("apollo_roleId", j);
          ((Bundle)localObject3).putIntArray("apollo_dressIds", paramMessage);
          ((Bundle)localObject3).putInt("apollo_apolloStatus", k);
          if (j == 0)
          {
            paramMessage = ((FriendsManager)((QQAppInterface)localObject9).getManager(50)).a(((QQAppInterface)localObject9).a());
            if (paramMessage != null)
            {
              j = paramMessage.gender;
              break label14996;
              ((Bundle)localObject3).putInt("apollo_roleGender", i);
              ((Bundle)localObject3).putInt("apollo_gender", j);
              ((Bundle)localObject13).putBundle("response", (Bundle)localObject3);
              ((MessengerService)localObject12).a((Bundle)localObject13);
            }
          }
        }
        else
        {
          if ("ipc_apollo_initavatar".equals(paramMessage))
          {
            localObject8 = ((Bundle)localObject10).getIntArray("apollo_dressIds");
            i = ((Bundle)localObject10).getInt("apollo_roleId");
            m = ((Bundle)localObject10).getInt("apollo_x");
            n = ((Bundle)localObject10).getInt("apollo_y");
            i1 = ((Bundle)localObject10).getInt("apollo_type");
            f = ((Bundle)localObject10).getFloat("apollo_rate");
            localObject10 = ((Bundle)localObject10).getString("apollo_uin");
            if (TextUtils.isEmpty((CharSequence)localObject10))
            {
              paramMessage = new Bundle();
              paramMessage.putInt("apollo_result", 1);
              ((Bundle)localObject13).putBundle("response", paramMessage);
              ((MessengerService)localObject12).a((Bundle)localObject13);
              return;
            }
            if ((i > 0) && (localObject8 != null))
            {
              j = i;
              localObject3 = localObject8;
              if (localObject8.length > 0) {
                break label15035;
              }
            }
            localObject3 = ((ApolloManager)((QQAppInterface)localObject9).getManager(152)).b((String)localObject10);
            j = i;
            paramMessage = (Message)localObject8;
            if (localObject3 != null)
            {
              localObject3 = ((ApolloBaseInfo)localObject3).getApolloDress();
              j = i;
              paramMessage = (Message)localObject8;
              if (localObject3 != null)
              {
                j = ((ApolloDress)localObject3).a;
                paramMessage = ((ApolloDress)localObject3).a();
              }
            }
            i = j;
            if (j == 0)
            {
              localObject3 = ((FriendsManager)((QQAppInterface)localObject9).getManager(50)).a((String)localObject10);
              i = j;
              if (localObject3 != null)
              {
                if (((Friends)localObject3).gender == 1) {
                  break label15008;
                }
                if (((Friends)localObject3).gender != 0) {
                  break label15023;
                }
                break label15008;
              }
            }
            j = i;
            localObject3 = paramMessage;
            if (i <= 0) {
              break label15035;
            }
            j = i;
            localObject3 = paramMessage;
            if (paramMessage == null) {
              break label15035;
            }
            j = i;
            localObject3 = paramMessage;
            if (paramMessage.length <= 0) {
              break label15035;
            }
            bool1 = ApolloUtil.c(i);
            i2 = paramMessage.length;
            j = 0;
            bool2 = bool1;
            k = i;
            localObject3 = paramMessage;
            if (j < i2)
            {
              k = paramMessage[j];
              if ((!bool1) || (!ApolloUtil.b(k))) {
                break label15029;
              }
              bool1 = true;
              break label15014;
            }
            if (bool2)
            {
              paramMessage = new Bundle();
              paramMessage.putInt("apollo_result", 0);
              paramMessage.putInt("apollo_roleId", k);
              paramMessage.putIntArray("apollo_dressIds", (int[])localObject3);
              paramMessage.putInt("apollo_x", m);
              paramMessage.putInt("apollo_y", n);
              paramMessage.putInt("apollo_type", i1);
              paramMessage.putFloat("apollo_rate", f);
              paramMessage.putString("apollo_uin", (String)localObject10);
              ((Bundle)localObject13).putBundle("response", paramMessage);
              ((MessengerService)localObject12).a((Bundle)localObject13);
              return;
            }
            ApolloResDownloader.a((AppInterface)localObject9, (String)localObject10, new rig(this, k, (int[])localObject3, m, n, i1, f, (Bundle)localObject13, (MessengerService)localObject12), k, (int[])localObject3, -1, -1, false);
            return;
          }
          if ("ipc_apollo_setup".equals(paramMessage))
          {
            ApolloBaseInfo.saveSelfApolloDress((AppInterface)localObject9, ((Bundle)localObject10).getString("apollo_userData"));
            return;
          }
          if ("ipc_apollo_update_apollopandora".equals(paramMessage))
          {
            paramMessage = (ApolloManager)((QQAppInterface)localObject9).getManager(152);
            localObject3 = ((Bundle)localObject10).getString("apollo_uin");
            l1 = ((Bundle)localObject10).getLong("apollo_checkPoint");
            s = ((Bundle)localObject10).getShort("apollo_hadStolen");
            localObject3 = paramMessage.a((String)localObject3, true);
            if (localObject3 == null) {
              break label14808;
            }
            ((ApolloPandora)localObject3).checkPoint = l1;
            ((ApolloPandora)localObject3).updateTime = System.currentTimeMillis();
            ((ApolloPandora)localObject3).hadStolen = s;
            paramMessage.a((ApolloPandora)localObject3);
            return;
          }
          if ("ipc_apollo_get_openapollo_friends".equals(paramMessage)) {
            if (((QQAppInterface)localObject9).isLogin())
            {
              paramMessage = ((QQAppInterface)localObject9).a().createEntityManager().a(true, "ApolloBaseInfo", new String[] { "uin" }, "apolloStatus=? ", new String[] { "1" }, null, null, null, null);
              if (paramMessage == null) {
                break label13854;
              }
              bool1 = paramMessage.moveToFirst();
              if (!bool1) {
                break label13854;
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        localObject8 = (FriendsManager)((QQAppInterface)localObject9).getManager(50);
        k = paramMessage.getColumnIndex("uin");
        if (k >= 0)
        {
          localObject3 = new JSONArray();
          i = 0;
          localObject9 = paramMessage.getString(k);
          localObject10 = ((FriendsManager)localObject8).a((String)localObject9);
          j = i;
          if (localObject10 == null) {
            break label15045;
          }
          j = i;
          if (!((Friends)localObject10).isFriend()) {
            break label15045;
          }
          localObject11 = new JSONObject();
          ((JSONObject)localObject11).put("uin", localObject9);
          ((JSONObject)localObject11).put("nick", ((Friends)localObject10).name);
          ((JSONArray)localObject3).put(localObject11);
          j = i + 1;
          break label15045;
          localObject8 = new Bundle();
          ((Bundle)localObject8).putInt("apollo_result", 0);
          localObject9 = new JSONObject();
          ((JSONObject)localObject9).put("friends", localObject3);
          ((Bundle)localObject8).putString("apollo_data", ((JSONObject)localObject9).toString());
          ((Bundle)localObject13).putBundle("response", (Bundle)localObject8);
          ((MessengerService)localObject12).a((Bundle)localObject13);
          if (QLog.isColorLevel()) {
            QLog.d("MessengerService$IncomingHandler", 2, "IPC_APOLLO_GET_OPENAPOLLO_FRIENDS array is:" + ((JSONArray)localObject3).toString());
          }
          return;
          bool1 = paramMessage.moveToNext();
          i = j;
          if (bool1) {
            continue;
          }
          continue;
        }
      }
      catch (Exception localException3)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("Q.emoji.web.MessengerService", 2, localException3.getMessage());
        paramMessage.close();
        continue;
      }
      finally
      {
        paramMessage.close();
      }
      paramMessage = new Bundle();
      paramMessage.putInt("apollo_result", 1);
      ((Bundle)localObject13).putBundle("response", paramMessage);
      ((MessengerService)localObject12).a((Bundle)localObject13);
      return;
      if (QLog.isColorLevel())
      {
        QLog.d("MessengerService$IncomingHandler", 2, "IPC_APOLLO_GET_OPENAPOLLO_FRIENDS cursor is null");
        continue;
        Object localObject5;
        if ("ipc_apollo_query_mine_redinfo".equals(paramMessage))
        {
          paramMessage = ((RedTouchManager)((QQAppInterface)localObject9).getManager(35)).a("103100.103200.103201.103204");
          if ((paramMessage != null) && (localObject13 != null))
          {
            localObject5 = new Bundle();
            ((Bundle)localObject5).putInt("isNewFlag", paramMessage.iNewFlag.get());
            ((Bundle)localObject13).putBundle("response", (Bundle)localObject5);
            ((MessengerService)localObject12).a((Bundle)localObject13);
            if (QLog.isColorLevel()) {
              QLog.d("MessengerService$IncomingHandler", 2, "IPC_APOLLO_QUERY_MINE_REDINFO cmd get and isNewFlag=" + paramMessage.iNewFlag.get());
            }
          }
        }
        else if ("ipc_apollo_clean_mine_redtouch".equals(paramMessage))
        {
          ((RedTouchManager)((QQAppInterface)localObject9).getManager(35)).b(String.valueOf("103100.103200.103201.103204"));
          if (QLog.isColorLevel()) {
            QLog.d("MessengerService$IncomingHandler", 2, "IPC_APOLLO_CLEAN_MINE_REDTOUCH cmd get");
          }
        }
        else
        {
          if ("batchGetUserInfo".equals(paramMessage))
          {
            ThreadManager.a(new rih(this, ((Bundle)localObject13).getBundle("request").getString("member_list"), (QQAppInterface)localObject9, (Bundle)localObject13, (MessengerService)localObject12), 5, null, false);
            return;
          }
          if ("ipc_apollo_refresh_action".equals(paramMessage))
          {
            ((VasExtensionHandler)((QQAppInterface)localObject9).a(71)).a(((QQAppInterface)localObject9).f(), 128, "refreshAction");
            if (QLog.isColorLevel()) {
              QLog.d("Q.emoji.web.MessengerService", 2, "ipc call refreshAction");
            }
          }
          else if ("ipc_apollo_check_action".equals(paramMessage))
          {
            ClubContentUpdateHandler.d((QQAppInterface)localObject9);
            if (QLog.isColorLevel()) {
              QLog.d("Q.emoji.web.MessengerService", 2, "ipc call check_action");
            }
          }
          else
          {
            if ("ipc_apollo_getfav_action".equals(paramMessage))
            {
              ThreadManager.a(new rii(this, (QQAppInterface)localObject9, (Bundle)localObject13, (MessengerService)localObject12), 5, null, true);
              return;
            }
            if ("ipc_apollo_add_fav_action".equals(paramMessage))
            {
              paramMessage = ((Bundle)localObject13).getBundle("request");
              ThreadManager.a(new rik(this, (QQAppInterface)localObject9, paramMessage.getInt("actionId"), paramMessage.getString("actionText"), paramMessage.getInt("textType"), (Bundle)localObject13, (MessengerService)localObject12), 5, null, false);
              return;
            }
            if ("ipc_apollo_del_fav_action".equals(paramMessage))
            {
              paramMessage = ((Bundle)localObject13).getBundle("request");
              i = paramMessage.getInt("actionId");
              ThreadManager.a(new ril(this, (QQAppInterface)localObject9, paramMessage.getLong("seq"), i, (Bundle)localObject13, (MessengerService)localObject12), 5, null, false);
              return;
            }
            if ("ipc_apollo_del_fav_list".equals(paramMessage))
            {
              ThreadManager.a(new rim(this, (QQAppInterface)localObject9, ((Bundle)localObject13).getBundle("request").getString("delJson"), (Bundle)localObject13, (MessengerService)localObject12), 5, null, false);
              return;
            }
            if ("ipc_hotchat_plugin".equals(paramMessage))
            {
              if (((Bundle)localObject10).getString("key_action").endsWith("updateFavoriteFlag"))
              {
                paramMessage = ((Bundle)localObject10).getString("key_uin");
                bool1 = ((Bundle)localObject10).getBoolean("key_favorite_flag");
                i = 1;
                localObject5 = (HotChatManager)((QQAppInterface)localObject9).getManager(59);
                if (localObject5 == null) {}
                for (paramMessage = null;; paramMessage = ((HotChatManager)localObject5).b(paramMessage))
                {
                  if (paramMessage != null)
                  {
                    j = 0;
                    i = j;
                    if (paramMessage.isFavorite != bool1)
                    {
                      paramMessage.isFavorite = bool1;
                      ((HotChatManager)localObject5).b(paramMessage);
                      i = j;
                    }
                  }
                  if (QLog.isColorLevel()) {
                    QLog.i("HotchatPlugin", 2, "updateFavoriteFlag in main");
                  }
                  ((Bundle)localObject10).putInt("result", i);
                  ((MessengerService)localObject12).a((Bundle)localObject13);
                  return;
                }
              }
            }
            else
            {
              if ("ipc_newer_guide".equals(paramMessage))
              {
                LoginWelcomeManager.a((QQAppInterface)localObject9).a((MessengerService)localObject12, (Bundle)localObject13);
                return;
              }
              if ("ipc_preload_plugin_process".equals(paramMessage))
              {
                localObject5 = ((Bundle)localObject10).getString("processId");
                paramMessage = new Bundle();
                if ("qqcomic".equals(localObject5))
                {
                  localObject5 = (QQComicPreloadManager)((QQAppInterface)localObject9).getManager(141);
                  if (localObject5 == null)
                  {
                    paramMessage.putInt("code", -1);
                    paramMessage.putString("message", "feature not support.");
                  }
                }
                for (;;)
                {
                  ((Bundle)localObject13).putBundle("response", paramMessage);
                  ((MessengerService)localObject12).a((Bundle)localObject13);
                  return;
                  paramMessage.putInt("code", 0);
                  paramMessage.putString("message", "ok.");
                  ((QQComicPreloadManager)localObject5).a(9999);
                  continue;
                  if ("qqreader".equals(localObject5))
                  {
                    localObject5 = (QRProcessManager)((QQAppInterface)localObject9).getManager(128);
                    if (localObject5 == null)
                    {
                      paramMessage.putInt("code", -1);
                      paramMessage.putString("message", "feature not support.");
                    }
                    else
                    {
                      paramMessage.putInt("code", 0);
                      paramMessage.putString("message", "ok.");
                      ((QRProcessManager)localObject5).a(9999);
                    }
                  }
                  else
                  {
                    paramMessage.putInt("code", 1);
                    paramMessage.putString("message", "invalid process id.");
                  }
                }
              }
            }
          }
        }
        label14917:
        label14923:
        label14934:
        label14947:
        label14953:
        label14969:
        label14972:
        label14981:
        label14990:
        label14996:
        do
        {
          break label12795;
          j = 1;
          continue;
          break label14969;
          for (;;)
          {
            break label14934;
            i = -1;
            break label9396;
            i = 5;
            break label8893;
            break label8438;
            i = -1;
            break label8053;
            break label7695;
            i = 1;
            break label7252;
            String str1 = "";
            break label6235;
            localObject8 = "0";
            break label3970;
            do
            {
              break label2112;
              return;
              break;
              bool1 = false;
              break label1915;
              bool1 = false;
              break label2001;
            } while (i != 3);
            i = 2;
            break label2112;
            bool1 = false;
            break label2265;
            paramMessage = (Message)localObject10;
            break label3842;
            bool1 = false;
            break label4418;
            return;
            bool1 = false;
            break label5585;
            bool1 = false;
            break label8969;
            if (i < i1) {
              i = i1;
            }
          }
          m += 1;
          j = n;
          break label9720;
          k = 0;
          break label9652;
          break label9871;
          i += 1;
          j = m;
          break label9900;
          break label10848;
          j += 1;
          break label11045;
          for (;;)
          {
            i += 1;
            break;
            bool1 = false;
          }
        } while (i != 0);
        i = j;
        break label12795;
        label15008:
        i = 1;
        label15011:
        break label13092;
        for (;;)
        {
          label15014:
          j += 1;
          break;
          label15023:
          i = 2;
          break label15011;
          label15029:
          bool1 = false;
        }
        label15035:
        bool2 = false;
        k = j;
        break label13184;
        label15045:
        if (j < 10) {}
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rhz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
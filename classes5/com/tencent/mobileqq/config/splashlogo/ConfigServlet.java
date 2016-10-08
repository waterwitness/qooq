package com.tencent.mobileqq.config.splashlogo;

import android.content.ComponentName;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Process;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Xml;
import com.tencent.av.funchat.magicface.MagicfaceManagerForAV;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.biz.bmqq.util.BmqqSegmentUtil;
import com.tencent.biz.now.NowLiveManager;
import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager;
import com.tencent.biz.pubaccount.subscript.SubscriptRecommendController;
import com.tencent.biz.pubaccount.util.PublicAccountConfigUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.device.qfind.QFindConfigUtil;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.aio.tips.LightalkBlueTipsBarData;
import com.tencent.mobileqq.activity.bless.BlessManager;
import com.tencent.mobileqq.activity.qwallet.PasswdRedBagManager;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import com.tencent.mobileqq.activity.recent.LightTalkTipsData;
import com.tencent.mobileqq.activity.shortvideo.ProgressiveUtils;
import com.tencent.mobileqq.apollo.utils.ApolloConfigUtils;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.app.ClubContentUpdateHandler;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.GuardManager;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.MayknowRecommendManager;
import com.tencent.mobileqq.app.NearbyFlowerManager;
import com.tencent.mobileqq.app.NearbyGrayTipsManager;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.PhoneUnityBannerData;
import com.tencent.mobileqq.app.PhoneUnityManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.ar.ArConfigUtils;
import com.tencent.mobileqq.ar.ArResourceManager;
import com.tencent.mobileqq.ar.aidl.ArConfigInfo;
import com.tencent.mobileqq.ar.aidl.ArEffectConfig;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.businessCard.BusinessCardManager;
import com.tencent.mobileqq.camera.utils.CameraUtils;
import com.tencent.mobileqq.config.Config;
import com.tencent.mobileqq.config.ConfigManager;
import com.tencent.mobileqq.config.ConfigParser;
import com.tencent.mobileqq.config.operation.QQOperateManager;
import com.tencent.mobileqq.config.operation.QQOperationViopTipTask;
import com.tencent.mobileqq.config.struct.NearbyBannerManager;
import com.tencent.mobileqq.config.struct.PicAndAdConf;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.ConfigSeq;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Content;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.DeviceInfo;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.OS;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.ReqGetConfig;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.RespGetConfig;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Screen;
import com.tencent.mobileqq.cooperation.ApkUtils;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ExpiredPushBanner;
import com.tencent.mobileqq.data.MessageForFoldMsgGrayTips;
import com.tencent.mobileqq.hotpatch.HotPatchManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.jumplightalk.AIOJumpLightalkConfig;
import com.tencent.mobileqq.jumplightalk.CLJumpLightalkConfig;
import com.tencent.mobileqq.jumplightalk.CallTabLightalkConfig;
import com.tencent.mobileqq.jumplightalk.PCJumpLightalkConfig;
import com.tencent.mobileqq.jumplightalk.QQCallLightalkConfig;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.multimsg.LongTextMsgManager;
import com.tencent.mobileqq.nearby.NearbyProxy;
import com.tencent.mobileqq.nearby.NearbySPUtil;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.olympic.OlympicActConfig;
import com.tencent.mobileqq.olympic.OlympicManager;
import com.tencent.mobileqq.olympic.OlympicServlet;
import com.tencent.mobileqq.olympic.utils.OlympicUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.precover.PrecoverControl;
import com.tencent.mobileqq.precover.PrecoverManager;
import com.tencent.mobileqq.precover.PrecoverUtils;
import com.tencent.mobileqq.ptt.PttConfigController;
import com.tencent.mobileqq.qcall.LightalkSwitchManager;
import com.tencent.mobileqq.search.util.PAOfflineSearchManager;
import com.tencent.mobileqq.search.util.SearchConfigManager;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.profile.ProfileUtil;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager;
import com.tencent.mobileqq.shortvideo.ShortVideoPreDownloader;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraCompatibleList;
import com.tencent.mobileqq.statistics.DAUStatistic;
import com.tencent.mobileqq.statistics.GeneralConfigUtils;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.troop.data.TroopRankColorConfig;
import com.tencent.mobileqq.troop.utils.ChangeMachineManager;
import com.tencent.mobileqq.troop.utils.TroopTopicMgr;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.mobileqq.vas.IndividuationABTestManager;
import com.tencent.mobileqq.vip.AioVipKeywordHelper;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import cooperation.dingdong.data.OfficeCenterConfigLoader;
import cooperation.huangye.HYConfigLoader;
import cooperation.photoplus.PhotoPlusManager;
import cooperation.pluginbridge.BridgeHelper;
import cooperation.qwallet.plugin.QWalletHelper;
import cooperation.readinjoy.ReadInJoyHelper;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import mqq.app.AppRuntime;
import mqq.app.MSFServlet;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.app.Packet;
import mqq.os.MqqHandler;
import oicq.wlogin_sdk.tools.MD5;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xmlpull.v1.XmlPullParser;
import rao;
import rap;
import raq;
import rar;
import ras;
import rat;
import rav;
import raw;
import rax;
import ray;
import raz;

public class ConfigServlet
  extends MSFServlet
{
  private static final int A = 6;
  private static final int B = 43;
  private static final int C = 104;
  private static final int D = 113;
  private static final int E = 1;
  private static final int F = 2;
  private static final int G = 3;
  private static final int H = 5;
  private static final int I = 10;
  private static final int J = 12;
  private static final int K = 17;
  private static final int L = 18;
  private static final int M = 23;
  private static final int N = 26;
  private static final int O = 28;
  private static final int P = 31;
  private static final int Q = 32;
  private static final int R = 33;
  private static final int S = 35;
  private static final int T = 38;
  private static final int U = 42;
  private static final int V = 44;
  private static final int W = 47;
  private static final int X = 50;
  private static final int Y = 53;
  private static final int Z = 54;
  public static final int a = 40;
  public static long a = 0L;
  public static Intent a;
  public static final String a = "ConfigurationService.ReqGetConfig";
  public static boolean a = false;
  private static final int[] a;
  private static final int aA = 102;
  private static final int aB = 115;
  private static final int aC = 91;
  private static final int aD = 97;
  private static final int aa = 55;
  private static final int ab = 56;
  private static final int ac = 57;
  private static final int ad = 60;
  private static final int ae = 61;
  private static final int af = 62;
  private static final int ag = 63;
  private static final int ah = 64;
  private static final int ai = 66;
  private static final int aj = 67;
  private static final int ak = 68;
  private static final int al = 69;
  private static final int am = 72;
  private static final int an = 73;
  private static final int ao = 74;
  private static final int ap = 75;
  private static final int aq = 76;
  private static final int ar = 94;
  private static final int as = 78;
  private static final int at = 79;
  private static final int au = 80;
  private static final int av = 81;
  private static final int aw = 90;
  private static final int ax = 93;
  private static final int ay = 99;
  private static final int az = 101;
  public static final int b = 42;
  public static final String b = "k_cmd_type";
  public static boolean b = false;
  public static final int c = 13;
  public static final String c = "key_uin";
  public static boolean c = false;
  public static final int d = 34;
  public static final String d = "key_province";
  public static boolean d = false;
  public static final int e = 46;
  public static final String e = "key_city";
  public static final int f = 49;
  public static final String f = "SPLASH_ConfigServlet";
  public static final int g = 65;
  public static final String g = "troop_contacts_mode_tag";
  public static final int h = 70;
  public static String h;
  public static final int i = 82;
  public static final String i = "Olympic.configServlet";
  public static final int j = 83;
  public static String j = "你的推送功能尚未开启，不能及时看到好友发来的消息，请开启QQ消息通知。";
  public static final int k = 85;
  public static String k;
  public static final int l = 92;
  public static final String l = "Q.camera.configServlet";
  public static final int m = 84;
  private static String m;
  public static final int n = 106;
  public static final int o = 86;
  public static final int p = 87;
  public static final int q = 88;
  public static final int r = 95;
  public static final int s = 96;
  public static final int t = 108;
  public static final int u = 110;
  public static final int v = 109;
  public static final int w = 111;
  public static final int x = 120;
  public static final int y = 118;
  public static int z;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    h = "";
    m = "用户";
    jdField_a_of_type_ArrayOfInt = new int[] { 1, 2, 3, 5, 10, 12, 13, 17, 18, 23, 26, 28, 31, 32, 33, 35, 38, 42, 44, 46, 47, 49, 50, 53, 54, 55, 56, 57, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 72, 73, 74, 75, 76, 94, 78, 79, 92, 80, 84, 106, 81, 82, 101, 102, 70, 83, 85, 91, 86, 93, 88, 90, 95, 96, 97, 108, 110, 111, 99, 109, 115, 118 };
    jdField_a_of_type_Boolean = true;
    jdField_b_of_type_Boolean = true;
  }
  
  private void A(ConfigurationService.Config paramConfig)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)getAppRuntime();
    int i1 = paramConfig.version.get();
    int i2 = SharedPreUtils.B(localQQAppInterface.a(), localQQAppInterface.getAccount());
    if (QLog.isColorLevel()) {
      QLog.d("msgFold", 2, "received RedBagFoldMsgConfig remote version: " + i1 + " | localVersion: " + i2);
    }
    if ((paramConfig.content_list != null) && (paramConfig.content_list.size() > 0))
    {
      String str = (String)paramConfig.content_list.get(0);
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 69,content: " + str + ",version: " + paramConfig.version.get());
      }
      if (QLog.isColorLevel()) {
        QLog.d("msgFold", 2, "received RedBagFoldMsgConfig content: " + str);
      }
      if (i1 != i2) {
        PasswdRedBagManager.a(localQQAppInterface, i1, str);
      }
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 69,content_list is empty ,version: " + paramConfig.version.get());
      }
      if (i1 != i2) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("msgFold", 2, "received RedBagFoldMsgConfig, content_list is empty, ignored because of SAME VERSION");
    return;
    if (QLog.isColorLevel()) {
      QLog.d("msgFold", 2, "received RedBagFoldMsgConfig, content_list is empty, use default config");
    }
    paramConfig = (PasswdRedBagManager)localQQAppInterface.getManager(124);
    paramConfig.jdField_a_of_type_Boolean = true;
    paramConfig.jdField_b_of_type_Boolean = MessageForFoldMsgGrayTips.PASSWD_REDBAG_MSG_SWITCH_DEFAULT;
    paramConfig.j = MessageForFoldMsgGrayTips.PASSWD_REDBAG_MSG_DISPLAY_NUM_DEFAULT;
    SharedPreUtils.a(localQQAppInterface.a(), localQQAppInterface.getAccount(), i1, paramConfig.jdField_b_of_type_Boolean, paramConfig.j);
  }
  
  private void B(ConfigurationService.Config paramConfig)
  {
    Object localObject = (QQAppInterface)getAppRuntime();
    if ((paramConfig.content_list != null) && (paramConfig.content_list.size() > 0))
    {
      localObject = (MayknowRecommendManager)((QQAppInterface)localObject).getManager(158);
      if (paramConfig.content_list.size() < 0)
      {
        str = (String)paramConfig.content_list.get(0);
        i1 = paramConfig.version.get();
        i2 = ((MayknowRecommendManager)localObject).b();
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 74,content: " + str + ",version: " + paramConfig.version.get());
        }
        if ((i1 != i2) || (paramConfig.content_list.size() > 0)) {
          ((MayknowRecommendManager)localObject).a(i1, str);
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      String str;
      int i1;
      int i2;
      return;
    }
    QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 74,content_list is empty ,version: " + paramConfig.version.get());
  }
  
  /* Error */
  private void C(ConfigurationService.Config paramConfig)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 224	com/tencent/mobileqq/config/splashlogo/ConfigServlet:getAppRuntime	()Lmqq/app/AppRuntime;
    //   4: checkcast 226	com/tencent/mobileqq/app/QQAppInterface
    //   7: astore_2
    //   8: aload_1
    //   9: getfield 232	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   12: invokevirtual 238	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   15: istore 15
    //   17: aload_2
    //   18: invokevirtual 241	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   21: aload_2
    //   22: invokevirtual 245	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   25: invokestatic 343	com/tencent/mobileqq/utils/SharedPreUtils:C	(Landroid/content/Context;Ljava/lang/String;)I
    //   28: istore 4
    //   30: invokestatic 256	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   33: ifeq +36 -> 69
    //   36: ldc_w 345
    //   39: iconst_2
    //   40: ldc_w 347
    //   43: iconst_2
    //   44: anewarray 349	java/lang/Object
    //   47: dup
    //   48: iconst_0
    //   49: iload 15
    //   51: invokestatic 355	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   54: aastore
    //   55: dup
    //   56: iconst_1
    //   57: iload 4
    //   59: invokestatic 355	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   62: aastore
    //   63: invokestatic 359	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   66: invokestatic 278	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   69: iload 15
    //   71: iload 4
    //   73: if_icmpeq +519 -> 592
    //   76: aload_1
    //   77: getfield 282	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   80: ifnull +616 -> 696
    //   83: aload_1
    //   84: getfield 282	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   87: invokevirtual 287	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   90: ifle +606 -> 696
    //   93: aload_1
    //   94: getfield 282	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   97: iconst_0
    //   98: invokevirtual 290	com/tencent/mobileqq/pb/PBRepeatField:get	(I)Ljava/lang/Object;
    //   101: checkcast 292	java/lang/String
    //   104: astore_3
    //   105: invokestatic 256	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   108: ifeq +45 -> 153
    //   111: ldc -111
    //   113: iconst_2
    //   114: new 260	java/lang/StringBuilder
    //   117: dup
    //   118: invokespecial 261	java/lang/StringBuilder:<init>	()V
    //   121: ldc_w 361
    //   124: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: aload_3
    //   128: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: ldc_w 296
    //   134: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: aload_1
    //   138: getfield 232	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   141: invokevirtual 238	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   144: invokevirtual 270	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   147: invokevirtual 275	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   150: invokestatic 278	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   153: iconst_m1
    //   154: istore 7
    //   156: iconst_0
    //   157: istore 6
    //   159: iconst_0
    //   160: istore 8
    //   162: iconst_0
    //   163: istore 5
    //   165: aload_3
    //   166: ldc_w 363
    //   169: invokevirtual 367	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   172: astore_1
    //   173: aload_1
    //   174: ifnull +686 -> 860
    //   177: aload_1
    //   178: arraylength
    //   179: istore 16
    //   181: iconst_0
    //   182: istore 12
    //   184: iconst_0
    //   185: istore 9
    //   187: iconst_m1
    //   188: istore 4
    //   190: iconst_m1
    //   191: istore 7
    //   193: iconst_m1
    //   194: istore 11
    //   196: iconst_m1
    //   197: istore 10
    //   199: iload 12
    //   201: iload 16
    //   203: if_icmpge +241 -> 444
    //   206: aload_1
    //   207: iload 12
    //   209: aaload
    //   210: astore_3
    //   211: aload_3
    //   212: ldc_w 369
    //   215: invokevirtual 373	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   218: ifeq +639 -> 857
    //   221: aload_3
    //   222: ldc_w 375
    //   225: invokevirtual 367	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   228: iconst_1
    //   229: aaload
    //   230: invokevirtual 378	java/lang/String:trim	()Ljava/lang/String;
    //   233: invokestatic 381	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   236: invokevirtual 384	java/lang/Integer:intValue	()I
    //   239: istore 10
    //   241: iload 10
    //   243: ifeq +15 -> 258
    //   246: iload 10
    //   248: iconst_1
    //   249: if_icmpeq +9 -> 258
    //   252: iload 10
    //   254: iconst_2
    //   255: if_icmpne +165 -> 420
    //   258: iconst_1
    //   259: istore 6
    //   261: aload_3
    //   262: ldc_w 386
    //   265: invokevirtual 373	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   268: ifeq +582 -> 850
    //   271: aload_3
    //   272: ldc_w 375
    //   275: invokevirtual 367	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   278: iconst_1
    //   279: aaload
    //   280: invokevirtual 378	java/lang/String:trim	()Ljava/lang/String;
    //   283: invokestatic 381	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   286: invokevirtual 384	java/lang/Integer:intValue	()I
    //   289: istore 13
    //   291: iload 13
    //   293: ifeq +15 -> 308
    //   296: iload 13
    //   298: iconst_1
    //   299: if_icmpeq +9 -> 308
    //   302: iload 13
    //   304: iconst_2
    //   305: if_icmpne +121 -> 426
    //   308: iconst_1
    //   309: istore 8
    //   311: aload_3
    //   312: ldc_w 388
    //   315: invokevirtual 373	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   318: ifeq +529 -> 847
    //   321: aload_3
    //   322: ldc_w 375
    //   325: invokevirtual 367	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   328: iconst_1
    //   329: aaload
    //   330: invokevirtual 378	java/lang/String:trim	()Ljava/lang/String;
    //   333: invokestatic 381	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   336: invokevirtual 384	java/lang/Integer:intValue	()I
    //   339: istore 11
    //   341: iload 11
    //   343: istore 7
    //   345: iload 7
    //   347: ifle +85 -> 432
    //   350: iconst_1
    //   351: istore 5
    //   353: iload 9
    //   355: istore 11
    //   357: iload 4
    //   359: istore 14
    //   361: aload_3
    //   362: ldc_w 390
    //   365: invokevirtual 373	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   368: ifeq +31 -> 399
    //   371: aload_3
    //   372: ldc_w 375
    //   375: invokevirtual 367	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   378: iconst_1
    //   379: aaload
    //   380: invokevirtual 378	java/lang/String:trim	()Ljava/lang/String;
    //   383: invokestatic 381	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   386: invokevirtual 384	java/lang/Integer:intValue	()I
    //   389: istore 14
    //   391: iload 14
    //   393: ifle +45 -> 438
    //   396: iconst_1
    //   397: istore 11
    //   399: iload 12
    //   401: iconst_1
    //   402: iadd
    //   403: istore 12
    //   405: iload 11
    //   407: istore 9
    //   409: iload 14
    //   411: istore 4
    //   413: iload 13
    //   415: istore 11
    //   417: goto -218 -> 199
    //   420: iconst_0
    //   421: istore 6
    //   423: goto -162 -> 261
    //   426: iconst_0
    //   427: istore 8
    //   429: goto -118 -> 311
    //   432: iconst_0
    //   433: istore 5
    //   435: goto -82 -> 353
    //   438: iconst_0
    //   439: istore 11
    //   441: goto -42 -> 399
    //   444: iload 8
    //   446: istore 12
    //   448: iload 4
    //   450: istore 8
    //   452: iload 5
    //   454: istore 4
    //   456: iload 8
    //   458: istore 5
    //   460: iload 6
    //   462: istore 8
    //   464: iload 12
    //   466: istore 6
    //   468: iload 6
    //   470: istore 12
    //   472: iload 7
    //   474: istore 6
    //   476: iload 5
    //   478: istore 7
    //   480: iload 12
    //   482: istore 5
    //   484: aload_2
    //   485: invokevirtual 241	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   488: aload_2
    //   489: invokevirtual 392	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   492: iconst_0
    //   493: invokevirtual 398	com/tencent/qphone/base/util/BaseApplication:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   496: astore_1
    //   497: aload_1
    //   498: invokeinterface 404 1 0
    //   503: ldc_w 406
    //   506: iconst_0
    //   507: invokeinterface 412 3 0
    //   512: invokeinterface 415 1 0
    //   517: pop
    //   518: aload_1
    //   519: invokeinterface 404 1 0
    //   524: ldc_w 417
    //   527: iconst_0
    //   528: invokeinterface 412 3 0
    //   533: invokeinterface 415 1 0
    //   538: pop
    //   539: iload 8
    //   541: ifeq +117 -> 658
    //   544: iload 5
    //   546: ifeq +112 -> 658
    //   549: iload 4
    //   551: ifeq +107 -> 658
    //   554: iload 9
    //   556: ifeq +102 -> 658
    //   559: iload 10
    //   561: iload 11
    //   563: iload 6
    //   565: iload 7
    //   567: invokestatic 422	com/tencent/mobileqq/activity/aio/item/PokeItemHelper:a	(IIII)V
    //   570: aload_2
    //   571: invokevirtual 241	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   574: aload_2
    //   575: invokevirtual 245	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   578: iload 15
    //   580: iconst_1
    //   581: iload 10
    //   583: iload 11
    //   585: iload 6
    //   587: iload 7
    //   589: invokestatic 425	com/tencent/mobileqq/utils/SharedPreUtils:a	(Landroid/content/Context;Ljava/lang/String;IZIIII)V
    //   592: return
    //   593: astore_1
    //   594: iconst_0
    //   595: istore 9
    //   597: iconst_0
    //   598: istore 4
    //   600: iconst_0
    //   601: istore 5
    //   603: iconst_0
    //   604: istore 8
    //   606: iconst_m1
    //   607: istore 6
    //   609: invokestatic 256	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   612: ifeq +33 -> 645
    //   615: ldc_w 345
    //   618: iconst_2
    //   619: new 260	java/lang/StringBuilder
    //   622: dup
    //   623: invokespecial 261	java/lang/StringBuilder:<init>	()V
    //   626: ldc_w 427
    //   629: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   632: aload_1
    //   633: invokevirtual 430	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   636: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   639: invokevirtual 275	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   642: invokestatic 432	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   645: getstatic 434	com/tencent/mobileqq/activity/aio/item/PokeItemHelper:i	I
    //   648: istore 10
    //   650: getstatic 435	com/tencent/mobileqq/activity/aio/item/PokeItemHelper:j	I
    //   653: istore 11
    //   655: goto -171 -> 484
    //   658: iload 10
    //   660: iload 11
    //   662: iload 6
    //   664: iload 7
    //   666: invokestatic 422	com/tencent/mobileqq/activity/aio/item/PokeItemHelper:a	(IIII)V
    //   669: aload_2
    //   670: invokevirtual 241	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   673: aload_2
    //   674: invokevirtual 245	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   677: iload 15
    //   679: iconst_1
    //   680: getstatic 434	com/tencent/mobileqq/activity/aio/item/PokeItemHelper:i	I
    //   683: getstatic 435	com/tencent/mobileqq/activity/aio/item/PokeItemHelper:j	I
    //   686: getstatic 437	com/tencent/mobileqq/activity/aio/item/PokeItemHelper:k	I
    //   689: getstatic 439	com/tencent/mobileqq/activity/aio/item/PokeItemHelper:l	I
    //   692: invokestatic 425	com/tencent/mobileqq/utils/SharedPreUtils:a	(Landroid/content/Context;Ljava/lang/String;IZIIII)V
    //   695: return
    //   696: invokestatic 256	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   699: ifeq -107 -> 592
    //   702: ldc -111
    //   704: iconst_2
    //   705: new 260	java/lang/StringBuilder
    //   708: dup
    //   709: invokespecial 261	java/lang/StringBuilder:<init>	()V
    //   712: ldc_w 441
    //   715: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   718: aload_1
    //   719: getfield 232	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   722: invokevirtual 238	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   725: invokevirtual 270	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   728: invokevirtual 275	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   731: invokestatic 278	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   734: return
    //   735: astore_1
    //   736: iload 4
    //   738: istore 10
    //   740: iload 5
    //   742: istore 4
    //   744: iload 8
    //   746: istore 5
    //   748: iload 6
    //   750: istore 8
    //   752: iload 7
    //   754: istore 6
    //   756: iload 10
    //   758: istore 7
    //   760: goto -151 -> 609
    //   763: astore_1
    //   764: iload 4
    //   766: istore 10
    //   768: iload 5
    //   770: istore 4
    //   772: iload 8
    //   774: istore 5
    //   776: iload 6
    //   778: istore 8
    //   780: iload 7
    //   782: istore 6
    //   784: iload 10
    //   786: istore 7
    //   788: goto -179 -> 609
    //   791: astore_1
    //   792: iload 4
    //   794: istore 10
    //   796: iload 5
    //   798: istore 4
    //   800: iload 8
    //   802: istore 5
    //   804: iload 6
    //   806: istore 8
    //   808: iload 7
    //   810: istore 6
    //   812: iload 10
    //   814: istore 7
    //   816: goto -207 -> 609
    //   819: astore_1
    //   820: iload 4
    //   822: istore 10
    //   824: iload 5
    //   826: istore 4
    //   828: iload 8
    //   830: istore 5
    //   832: iload 6
    //   834: istore 8
    //   836: iload 7
    //   838: istore 6
    //   840: iload 10
    //   842: istore 7
    //   844: goto -235 -> 609
    //   847: goto -494 -> 353
    //   850: iload 11
    //   852: istore 13
    //   854: goto -543 -> 311
    //   857: goto -596 -> 261
    //   860: iconst_0
    //   861: istore 9
    //   863: iconst_0
    //   864: istore 4
    //   866: iconst_0
    //   867: istore 6
    //   869: iconst_0
    //   870: istore 8
    //   872: iconst_m1
    //   873: istore 5
    //   875: iconst_m1
    //   876: istore 7
    //   878: iconst_m1
    //   879: istore 11
    //   881: iconst_m1
    //   882: istore 10
    //   884: goto -416 -> 468
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	887	0	this	ConfigServlet
    //   0	887	1	paramConfig	ConfigurationService.Config
    //   7	667	2	localQQAppInterface	QQAppInterface
    //   104	268	3	str	String
    //   28	837	4	i1	int
    //   163	711	5	i2	int
    //   157	711	6	i3	int
    //   154	723	7	i4	int
    //   160	711	8	i5	int
    //   185	677	9	i6	int
    //   197	686	10	i7	int
    //   194	686	11	i8	int
    //   182	299	12	i9	int
    //   289	564	13	i10	int
    //   359	51	14	i11	int
    //   15	663	15	i12	int
    //   179	25	16	i13	int
    // Exception table:
    //   from	to	target	type
    //   165	173	593	java/lang/Exception
    //   177	181	593	java/lang/Exception
    //   211	241	735	java/lang/Exception
    //   261	291	763	java/lang/Exception
    //   311	341	791	java/lang/Exception
    //   361	391	819	java/lang/Exception
  }
  
  private void D(ConfigurationService.Config paramConfig)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SPLASH_ConfigServlet", 2, "received TROOP_SHARE_MSG_COMMENT_WHITELIST response: -------");
    }
    try
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)getAppRuntime();
      if ((paramConfig != null) && (paramConfig.content_list != null) && (paramConfig.content_list.size() > 0))
      {
        String str = (String)paramConfig.content_list.get(0);
        int i1 = paramConfig.version.get();
        paramConfig = (TroopTopicMgr)localQQAppInterface.getManager(97);
        int i2 = paramConfig.g;
        if (i1 != i2)
        {
          paramConfig.a(str, i1);
          return;
        }
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.d("SPLASH_ConfigServlet", 2, "received TROOP_SHARE_MSG_COMMENT_WHITELIST remote version: " + i1 + " | localVersion: " + i2);
        return;
      }
    }
    catch (Exception paramConfig)
    {
      if (QLog.isColorLevel()) {
        QLog.e("SPLASH_ConfigServlet", 2, "received TROOP_SHARE_MSG_COMMENT_WHITELIST error", paramConfig);
      }
      paramConfig.printStackTrace();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SPLASH_ConfigServlet", 2, "received TROOP_SHARE_MSG_COMMENT_WHITELIST content_list is empty");
    }
  }
  
  private void E(ConfigurationService.Config paramConfig)
  {
    try
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)getAppRuntime();
      if ((paramConfig != null) && (paramConfig.content_list != null) && (paramConfig.content_list.size() > 0))
      {
        String str = (String)paramConfig.content_list.get(0);
        int i1 = paramConfig.version.get();
        paramConfig = (TroopManager)localQQAppInterface.getManager(51);
        int i2 = paramConfig.d;
        if (i1 != i2)
        {
          paramConfig.a(str, i1);
          return;
        }
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.d("SPLASH_ConfigServlet", 2, "received TROOP_SHARE_MSG_COMMENT_WHITELIST remote version: " + i1 + " | localVersion: " + i2);
        return;
      }
    }
    catch (Exception paramConfig)
    {
      if (QLog.isColorLevel()) {
        QLog.e("SPLASH_ConfigServlet", 2, "received TROOP_SHARE_MSG_COMMENT_WHITELIST error", paramConfig);
      }
      paramConfig.printStackTrace();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SPLASH_ConfigServlet", 2, "received TROOP_SHARE_MSG_COMMENT_WHITELIST content_list is empty");
    }
  }
  
  private void F(ConfigurationService.Config paramConfig)
  {
    boolean bool2 = true;
    for (;;)
    {
      try
      {
        localQQAppInterface = (QQAppInterface)getAppRuntime();
        i1 = paramConfig.version.get();
        i2 = SharedPreUtils.K(localQQAppInterface.a(), localQQAppInterface.getAccount());
        if (QLog.isColorLevel()) {
          QLog.d("longText", 2, "received LongTextMsgConfig configVersion:" + i1 + " ,localVersion:" + i2);
        }
        if ((paramConfig.content_list != null) && (paramConfig.content_list.size() > 0))
        {
          paramConfig = (String)paramConfig.content_list.get(0);
          if (QLog.isColorLevel()) {
            QLog.d("longText", 2, "received LongTextMsgConfig configContent" + paramConfig);
          }
          if (i1 == i2) {
            break label453;
          }
        }
      }
      catch (Exception paramConfig)
      {
        QQAppInterface localQQAppInterface;
        int i1;
        int i2;
        int i3;
        boolean bool3;
        boolean bool4;
        if (QLog.isColorLevel())
        {
          QLog.e("SPLASH_ConfigServlet", 2, "received PUBLIC_ACCOUNT_CENTER_URL_CONFIG_CMD error", paramConfig);
          return;
          if (i1 == i2)
          {
            if (QLog.isColorLevel()) {
              QLog.d("longText", 2, "received LongTextMsgConfig, content_list is empty, ignored because of SAME VERSION");
            }
          }
          else if (QLog.isColorLevel())
          {
            QLog.d("longText", 2, "received LongTextMsgConfig, content_list is empty, use default config");
            return;
            bool1 = false;
            continue;
            bool2 = true;
            bool1 = false;
            continue;
          }
        }
      }
      try
      {
        if (TextUtils.isEmpty(paramConfig)) {
          continue;
        }
        paramConfig = new JSONObject(paramConfig);
        if (paramConfig == null) {
          continue;
        }
        i2 = Integer.parseInt(paramConfig.optString("largeMsgOp"));
        if (i2 != 1) {
          continue;
        }
        bool1 = true;
      }
      catch (Exception paramConfig)
      {
        bool1 = false;
        continue;
      }
      try
      {
        i3 = Integer.parseInt(paramConfig.optString("msfPullFilter"));
        if (i3 != 0) {
          continue;
        }
        bool2 = false;
      }
      catch (Exception paramConfig)
      {
        continue;
        bool2 = true;
        continue;
      }
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("longText", 2, "received LongTextMsgConfig, parse content ltValue:" + i2 + ",ltSwitch:" + bool1 + ",mpfValue:" + i3 + ",mpfSwitch:" + bool2);
        }
        bool3 = bool1;
        bool4 = bool2;
        paramConfig = (LongTextMsgManager)localQQAppInterface.getManager(165);
        paramConfig.jdField_b_of_type_Boolean = true;
        paramConfig.c = bool3;
        localQQAppInterface.g = true;
        localQQAppInterface.h = bool4;
        SharedPreUtils.a(localQQAppInterface.a(), localQQAppInterface.getAccount(), i1, bool3, bool4);
        return;
      }
      catch (Exception paramConfig)
      {
        continue;
      }
      bool4 = bool2;
      bool3 = bool1;
      if (QLog.isColorLevel())
      {
        QLog.d("longText", 2, "received LongTextMsgConfig, parse content error!", paramConfig);
        bool4 = bool2;
        bool3 = bool1;
      }
    }
    label453:
  }
  
  private float a(float paramFloat)
  {
    return paramFloat / (50.0F * 2.0F) * (float)DeviceInfoUtil.f();
  }
  
  private float a(float paramFloat1, float paramFloat2)
  {
    return (50.0F + paramFloat1) / (50.0F * 2.0F) * paramFloat2;
  }
  
  private float a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return paramFloat2 / 2.0F - paramFloat1 * paramFloat3 / (50.0F * 2.0F);
  }
  
  private static int a(String paramString1, String paramString2)
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("MM-dd");
    try
    {
      long l1 = (localSimpleDateFormat.parse(paramString2).getTime() - localSimpleDateFormat.parse(paramString1).getTime()) / 86400000L;
      return (int)l1;
    }
    catch (ParseException paramString1)
    {
      paramString1.printStackTrace();
    }
    return -1;
  }
  
  private QQOperationViopTipTask a(String paramString)
  {
    return a(paramString, new QQOperationViopTipTask());
  }
  
  /* Error */
  private QQOperationViopTipTask a(String paramString, QQOperationViopTipTask paramQQOperationViopTipTask)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: invokestatic 589	javax/xml/parsers/DocumentBuilderFactory:newInstance	()Ljavax/xml/parsers/DocumentBuilderFactory;
    //   6: invokevirtual 593	javax/xml/parsers/DocumentBuilderFactory:newDocumentBuilder	()Ljavax/xml/parsers/DocumentBuilder;
    //   9: new 595	java/io/ByteArrayInputStream
    //   12: dup
    //   13: aload_1
    //   14: ldc_w 597
    //   17: invokevirtual 601	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   20: invokespecial 604	java/io/ByteArrayInputStream:<init>	([B)V
    //   23: invokevirtual 609	javax/xml/parsers/DocumentBuilder:parse	(Ljava/io/InputStream;)Lorg/w3c/dom/Document;
    //   26: astore_1
    //   27: aload_1
    //   28: ldc_w 611
    //   31: invokeinterface 617 2 0
    //   36: astore_3
    //   37: aload_3
    //   38: ifnull +1200 -> 1238
    //   41: aload_3
    //   42: invokeinterface 622 1 0
    //   47: ifle +1191 -> 1238
    //   50: aload_1
    //   51: ldc_w 624
    //   54: invokeinterface 617 2 0
    //   59: astore_3
    //   60: aload_3
    //   61: ifnull +44 -> 105
    //   64: aload_3
    //   65: invokeinterface 622 1 0
    //   70: ifle +35 -> 105
    //   73: aload_2
    //   74: aload_1
    //   75: ldc_w 624
    //   78: invokeinterface 617 2 0
    //   83: iconst_0
    //   84: invokeinterface 628 2 0
    //   89: invokeinterface 634 1 0
    //   94: invokeinterface 637 1 0
    //   99: invokestatic 497	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   102: putfield 640	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:taskid	I
    //   105: aload_1
    //   106: ldc_w 642
    //   109: invokeinterface 617 2 0
    //   114: astore_3
    //   115: aload_3
    //   116: ifnull +44 -> 160
    //   119: aload_3
    //   120: invokeinterface 622 1 0
    //   125: ifle +35 -> 160
    //   128: aload_2
    //   129: aload_1
    //   130: ldc_w 642
    //   133: invokeinterface 617 2 0
    //   138: iconst_0
    //   139: invokeinterface 628 2 0
    //   144: invokeinterface 634 1 0
    //   149: invokeinterface 637 1 0
    //   154: invokestatic 497	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   157: putfield 645	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:limitDayAIOCount	I
    //   160: aload_1
    //   161: ldc_w 647
    //   164: invokeinterface 617 2 0
    //   169: astore_3
    //   170: aload_3
    //   171: ifnull +44 -> 215
    //   174: aload_3
    //   175: invokeinterface 622 1 0
    //   180: ifle +35 -> 215
    //   183: aload_2
    //   184: aload_1
    //   185: ldc_w 647
    //   188: invokeinterface 617 2 0
    //   193: iconst_0
    //   194: invokeinterface 628 2 0
    //   199: invokeinterface 634 1 0
    //   204: invokeinterface 637 1 0
    //   209: invokestatic 497	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   212: putfield 650	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:limitDayAIOShowCount	I
    //   215: aload_1
    //   216: ldc_w 652
    //   219: invokeinterface 617 2 0
    //   224: astore_3
    //   225: aload_3
    //   226: ifnull +44 -> 270
    //   229: aload_3
    //   230: invokeinterface 622 1 0
    //   235: ifle +35 -> 270
    //   238: aload_2
    //   239: aload_1
    //   240: ldc_w 652
    //   243: invokeinterface 617 2 0
    //   248: iconst_0
    //   249: invokeinterface 628 2 0
    //   254: invokeinterface 634 1 0
    //   259: invokeinterface 637 1 0
    //   264: invokestatic 497	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   267: putfield 655	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:limitTotalAIOCount	I
    //   270: aload_1
    //   271: ldc_w 657
    //   274: invokeinterface 617 2 0
    //   279: astore_3
    //   280: aload_3
    //   281: ifnull +44 -> 325
    //   284: aload_3
    //   285: invokeinterface 622 1 0
    //   290: ifle +35 -> 325
    //   293: aload_2
    //   294: aload_1
    //   295: ldc_w 657
    //   298: invokeinterface 617 2 0
    //   303: iconst_0
    //   304: invokeinterface 628 2 0
    //   309: invokeinterface 634 1 0
    //   314: invokeinterface 637 1 0
    //   319: invokestatic 497	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   322: putfield 660	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:limitTotalShowCount	I
    //   325: aload_1
    //   326: ldc_w 662
    //   329: invokeinterface 617 2 0
    //   334: astore_3
    //   335: aload_3
    //   336: ifnull +41 -> 377
    //   339: aload_3
    //   340: invokeinterface 622 1 0
    //   345: ifle +32 -> 377
    //   348: aload_2
    //   349: aload_1
    //   350: ldc_w 662
    //   353: invokeinterface 617 2 0
    //   358: iconst_0
    //   359: invokeinterface 628 2 0
    //   364: invokeinterface 634 1 0
    //   369: invokeinterface 637 1 0
    //   374: invokevirtual 665	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:setKeywordString	(Ljava/lang/String;)V
    //   377: invokestatic 668	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   380: ifeq +33 -> 413
    //   383: ldc_w 670
    //   386: iconst_4
    //   387: new 260	java/lang/StringBuilder
    //   390: dup
    //   391: invokespecial 261	java/lang/StringBuilder:<init>	()V
    //   394: ldc_w 672
    //   397: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   400: aload_2
    //   401: invokevirtual 676	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:getKeywordList	()Ljava/util/ArrayList;
    //   404: invokevirtual 679	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   407: invokevirtual 275	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   410: invokestatic 278	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   413: aload_1
    //   414: ldc_w 681
    //   417: invokeinterface 617 2 0
    //   422: astore_3
    //   423: aload_3
    //   424: ifnull +41 -> 465
    //   427: aload_3
    //   428: invokeinterface 622 1 0
    //   433: ifle +32 -> 465
    //   436: aload_2
    //   437: aload_1
    //   438: ldc_w 681
    //   441: invokeinterface 617 2 0
    //   446: iconst_0
    //   447: invokeinterface 628 2 0
    //   452: invokeinterface 634 1 0
    //   457: invokeinterface 637 1 0
    //   462: invokevirtual 684	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:setBeginTime	(Ljava/lang/String;)V
    //   465: aload_1
    //   466: ldc_w 686
    //   469: invokeinterface 617 2 0
    //   474: astore_3
    //   475: aload_3
    //   476: ifnull +41 -> 517
    //   479: aload_3
    //   480: invokeinterface 622 1 0
    //   485: ifle +32 -> 517
    //   488: aload_2
    //   489: aload_1
    //   490: ldc_w 686
    //   493: invokeinterface 617 2 0
    //   498: iconst_0
    //   499: invokeinterface 628 2 0
    //   504: invokeinterface 634 1 0
    //   509: invokeinterface 637 1 0
    //   514: invokevirtual 689	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:setEndTime	(Ljava/lang/String;)V
    //   517: aload_1
    //   518: ldc_w 691
    //   521: invokeinterface 617 2 0
    //   526: astore_3
    //   527: aload_3
    //   528: ifnull +50 -> 578
    //   531: aload_3
    //   532: invokeinterface 622 1 0
    //   537: ifle +41 -> 578
    //   540: aload_1
    //   541: ldc_w 691
    //   544: invokeinterface 617 2 0
    //   549: iconst_0
    //   550: invokeinterface 628 2 0
    //   555: invokeinterface 634 1 0
    //   560: invokeinterface 637 1 0
    //   565: invokestatic 497	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   568: iconst_1
    //   569: if_icmpne +671 -> 1240
    //   572: aload_2
    //   573: iload 4
    //   575: putfield 694	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:uinType	I
    //   578: aload_1
    //   579: ldc_w 696
    //   582: invokeinterface 617 2 0
    //   587: astore_3
    //   588: aload_3
    //   589: ifnull +190 -> 779
    //   592: aload_3
    //   593: invokeinterface 622 1 0
    //   598: ifle +181 -> 779
    //   601: aload_1
    //   602: ldc_w 696
    //   605: invokeinterface 617 2 0
    //   610: iconst_0
    //   611: invokeinterface 628 2 0
    //   616: checkcast 698	org/w3c/dom/Element
    //   619: ldc_w 700
    //   622: invokeinterface 701 2 0
    //   627: astore_3
    //   628: aload_3
    //   629: ifnull +61 -> 690
    //   632: aload_3
    //   633: invokeinterface 622 1 0
    //   638: ifle +52 -> 690
    //   641: aload_2
    //   642: aload_1
    //   643: ldc_w 696
    //   646: invokeinterface 617 2 0
    //   651: iconst_0
    //   652: invokeinterface 628 2 0
    //   657: checkcast 698	org/w3c/dom/Element
    //   660: ldc_w 700
    //   663: invokeinterface 701 2 0
    //   668: iconst_0
    //   669: invokeinterface 628 2 0
    //   674: invokeinterface 634 1 0
    //   679: invokeinterface 637 1 0
    //   684: invokestatic 497	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   687: putfield 704	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:frequencyTime	I
    //   690: aload_1
    //   691: ldc_w 696
    //   694: invokeinterface 617 2 0
    //   699: iconst_0
    //   700: invokeinterface 628 2 0
    //   705: checkcast 698	org/w3c/dom/Element
    //   708: ldc_w 706
    //   711: invokeinterface 701 2 0
    //   716: astore_3
    //   717: aload_3
    //   718: ifnull +61 -> 779
    //   721: aload_3
    //   722: invokeinterface 622 1 0
    //   727: ifle +52 -> 779
    //   730: aload_2
    //   731: aload_1
    //   732: ldc_w 696
    //   735: invokeinterface 617 2 0
    //   740: iconst_0
    //   741: invokeinterface 628 2 0
    //   746: checkcast 698	org/w3c/dom/Element
    //   749: ldc_w 706
    //   752: invokeinterface 701 2 0
    //   757: iconst_0
    //   758: invokeinterface 628 2 0
    //   763: invokeinterface 634 1 0
    //   768: invokeinterface 637 1 0
    //   773: invokestatic 497	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   776: putfield 709	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:frequencyMessage	I
    //   779: aload_1
    //   780: ldc_w 711
    //   783: invokeinterface 617 2 0
    //   788: astore_3
    //   789: aload_3
    //   790: ifnull +448 -> 1238
    //   793: aload_3
    //   794: invokeinterface 622 1 0
    //   799: ifle +439 -> 1238
    //   802: aload_1
    //   803: ldc_w 711
    //   806: invokeinterface 617 2 0
    //   811: iconst_0
    //   812: invokeinterface 628 2 0
    //   817: checkcast 698	org/w3c/dom/Element
    //   820: ldc_w 713
    //   823: invokeinterface 701 2 0
    //   828: astore_3
    //   829: aload_3
    //   830: ifnull +61 -> 891
    //   833: aload_3
    //   834: invokeinterface 622 1 0
    //   839: ifle +52 -> 891
    //   842: aload_2
    //   843: aload_1
    //   844: ldc_w 711
    //   847: invokeinterface 617 2 0
    //   852: iconst_0
    //   853: invokeinterface 628 2 0
    //   858: checkcast 698	org/w3c/dom/Element
    //   861: ldc_w 713
    //   864: invokeinterface 701 2 0
    //   869: iconst_0
    //   870: invokeinterface 628 2 0
    //   875: invokeinterface 634 1 0
    //   880: invokeinterface 637 1 0
    //   885: invokestatic 497	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   888: putfield 716	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:tipType	I
    //   891: aload_1
    //   892: ldc_w 711
    //   895: invokeinterface 617 2 0
    //   900: iconst_0
    //   901: invokeinterface 628 2 0
    //   906: checkcast 698	org/w3c/dom/Element
    //   909: ldc_w 706
    //   912: invokeinterface 701 2 0
    //   917: astore_3
    //   918: aload_3
    //   919: ifnull +58 -> 977
    //   922: aload_3
    //   923: invokeinterface 622 1 0
    //   928: ifle +49 -> 977
    //   931: aload_2
    //   932: aload_1
    //   933: ldc_w 711
    //   936: invokeinterface 617 2 0
    //   941: iconst_0
    //   942: invokeinterface 628 2 0
    //   947: checkcast 698	org/w3c/dom/Element
    //   950: ldc_w 706
    //   953: invokeinterface 701 2 0
    //   958: iconst_0
    //   959: invokeinterface 628 2 0
    //   964: invokeinterface 634 1 0
    //   969: invokeinterface 637 1 0
    //   974: putfield 719	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:adwords	Ljava/lang/String;
    //   977: aload_1
    //   978: ldc_w 711
    //   981: invokeinterface 617 2 0
    //   986: iconst_0
    //   987: invokeinterface 628 2 0
    //   992: checkcast 698	org/w3c/dom/Element
    //   995: ldc_w 721
    //   998: invokeinterface 701 2 0
    //   1003: astore_3
    //   1004: aload_3
    //   1005: ifnull +61 -> 1066
    //   1008: aload_3
    //   1009: invokeinterface 622 1 0
    //   1014: ifle +52 -> 1066
    //   1017: aload_2
    //   1018: aload_1
    //   1019: ldc_w 711
    //   1022: invokeinterface 617 2 0
    //   1027: iconst_0
    //   1028: invokeinterface 628 2 0
    //   1033: checkcast 698	org/w3c/dom/Element
    //   1036: ldc_w 721
    //   1039: invokeinterface 701 2 0
    //   1044: iconst_0
    //   1045: invokeinterface 628 2 0
    //   1050: invokeinterface 634 1 0
    //   1055: invokeinterface 637 1 0
    //   1060: invokestatic 497	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   1063: putfield 724	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:linkOffset	I
    //   1066: aload_1
    //   1067: ldc_w 711
    //   1070: invokeinterface 617 2 0
    //   1075: iconst_0
    //   1076: invokeinterface 628 2 0
    //   1081: checkcast 698	org/w3c/dom/Element
    //   1084: ldc_w 726
    //   1087: invokeinterface 701 2 0
    //   1092: astore_3
    //   1093: aload_3
    //   1094: ifnull +58 -> 1152
    //   1097: aload_3
    //   1098: invokeinterface 622 1 0
    //   1103: ifle +49 -> 1152
    //   1106: aload_2
    //   1107: aload_1
    //   1108: ldc_w 711
    //   1111: invokeinterface 617 2 0
    //   1116: iconst_0
    //   1117: invokeinterface 628 2 0
    //   1122: checkcast 698	org/w3c/dom/Element
    //   1125: ldc_w 726
    //   1128: invokeinterface 701 2 0
    //   1133: iconst_0
    //   1134: invokeinterface 628 2 0
    //   1139: invokeinterface 634 1 0
    //   1144: invokeinterface 637 1 0
    //   1149: putfield 729	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:clickableWord	Ljava/lang/String;
    //   1152: aload_1
    //   1153: ldc_w 711
    //   1156: invokeinterface 617 2 0
    //   1161: iconst_0
    //   1162: invokeinterface 628 2 0
    //   1167: checkcast 698	org/w3c/dom/Element
    //   1170: ldc_w 731
    //   1173: invokeinterface 701 2 0
    //   1178: astore_3
    //   1179: aload_3
    //   1180: ifnull +58 -> 1238
    //   1183: aload_3
    //   1184: invokeinterface 622 1 0
    //   1189: ifle +49 -> 1238
    //   1192: aload_2
    //   1193: aload_1
    //   1194: ldc_w 711
    //   1197: invokeinterface 617 2 0
    //   1202: iconst_0
    //   1203: invokeinterface 628 2 0
    //   1208: checkcast 698	org/w3c/dom/Element
    //   1211: ldc_w 731
    //   1214: invokeinterface 701 2 0
    //   1219: iconst_0
    //   1220: invokeinterface 628 2 0
    //   1225: invokeinterface 634 1 0
    //   1230: invokeinterface 637 1 0
    //   1235: putfield 733	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:url	Ljava/lang/String;
    //   1238: aload_2
    //   1239: areturn
    //   1240: sipush 3000
    //   1243: istore 4
    //   1245: goto -673 -> 572
    //   1248: astore_1
    //   1249: aload_1
    //   1250: invokevirtual 734	javax/xml/parsers/ParserConfigurationException:printStackTrace	()V
    //   1253: aconst_null
    //   1254: areturn
    //   1255: astore_1
    //   1256: aload_1
    //   1257: invokevirtual 735	org/xml/sax/SAXException:printStackTrace	()V
    //   1260: goto -7 -> 1253
    //   1263: astore_1
    //   1264: aload_1
    //   1265: invokevirtual 736	java/io/IOException:printStackTrace	()V
    //   1268: goto -15 -> 1253
    //   1271: astore_1
    //   1272: aload_1
    //   1273: invokevirtual 460	java/lang/Exception:printStackTrace	()V
    //   1276: goto -23 -> 1253
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1279	0	this	ConfigServlet
    //   0	1279	1	paramString	String
    //   0	1279	2	paramQQOperationViopTipTask	QQOperationViopTipTask
    //   36	1148	3	localNodeList	NodeList
    //   1	1243	4	i1	int
    // Exception table:
    //   from	to	target	type
    //   3	37	1248	javax/xml/parsers/ParserConfigurationException
    //   41	60	1248	javax/xml/parsers/ParserConfigurationException
    //   64	105	1248	javax/xml/parsers/ParserConfigurationException
    //   105	115	1248	javax/xml/parsers/ParserConfigurationException
    //   119	160	1248	javax/xml/parsers/ParserConfigurationException
    //   160	170	1248	javax/xml/parsers/ParserConfigurationException
    //   174	215	1248	javax/xml/parsers/ParserConfigurationException
    //   215	225	1248	javax/xml/parsers/ParserConfigurationException
    //   229	270	1248	javax/xml/parsers/ParserConfigurationException
    //   270	280	1248	javax/xml/parsers/ParserConfigurationException
    //   284	325	1248	javax/xml/parsers/ParserConfigurationException
    //   325	335	1248	javax/xml/parsers/ParserConfigurationException
    //   339	377	1248	javax/xml/parsers/ParserConfigurationException
    //   377	413	1248	javax/xml/parsers/ParserConfigurationException
    //   413	423	1248	javax/xml/parsers/ParserConfigurationException
    //   427	465	1248	javax/xml/parsers/ParserConfigurationException
    //   465	475	1248	javax/xml/parsers/ParserConfigurationException
    //   479	517	1248	javax/xml/parsers/ParserConfigurationException
    //   517	527	1248	javax/xml/parsers/ParserConfigurationException
    //   531	572	1248	javax/xml/parsers/ParserConfigurationException
    //   572	578	1248	javax/xml/parsers/ParserConfigurationException
    //   578	588	1248	javax/xml/parsers/ParserConfigurationException
    //   592	628	1248	javax/xml/parsers/ParserConfigurationException
    //   632	690	1248	javax/xml/parsers/ParserConfigurationException
    //   690	717	1248	javax/xml/parsers/ParserConfigurationException
    //   721	779	1248	javax/xml/parsers/ParserConfigurationException
    //   779	789	1248	javax/xml/parsers/ParserConfigurationException
    //   793	829	1248	javax/xml/parsers/ParserConfigurationException
    //   833	891	1248	javax/xml/parsers/ParserConfigurationException
    //   891	918	1248	javax/xml/parsers/ParserConfigurationException
    //   922	977	1248	javax/xml/parsers/ParserConfigurationException
    //   977	1004	1248	javax/xml/parsers/ParserConfigurationException
    //   1008	1066	1248	javax/xml/parsers/ParserConfigurationException
    //   1066	1093	1248	javax/xml/parsers/ParserConfigurationException
    //   1097	1152	1248	javax/xml/parsers/ParserConfigurationException
    //   1152	1179	1248	javax/xml/parsers/ParserConfigurationException
    //   1183	1238	1248	javax/xml/parsers/ParserConfigurationException
    //   3	37	1255	org/xml/sax/SAXException
    //   41	60	1255	org/xml/sax/SAXException
    //   64	105	1255	org/xml/sax/SAXException
    //   105	115	1255	org/xml/sax/SAXException
    //   119	160	1255	org/xml/sax/SAXException
    //   160	170	1255	org/xml/sax/SAXException
    //   174	215	1255	org/xml/sax/SAXException
    //   215	225	1255	org/xml/sax/SAXException
    //   229	270	1255	org/xml/sax/SAXException
    //   270	280	1255	org/xml/sax/SAXException
    //   284	325	1255	org/xml/sax/SAXException
    //   325	335	1255	org/xml/sax/SAXException
    //   339	377	1255	org/xml/sax/SAXException
    //   377	413	1255	org/xml/sax/SAXException
    //   413	423	1255	org/xml/sax/SAXException
    //   427	465	1255	org/xml/sax/SAXException
    //   465	475	1255	org/xml/sax/SAXException
    //   479	517	1255	org/xml/sax/SAXException
    //   517	527	1255	org/xml/sax/SAXException
    //   531	572	1255	org/xml/sax/SAXException
    //   572	578	1255	org/xml/sax/SAXException
    //   578	588	1255	org/xml/sax/SAXException
    //   592	628	1255	org/xml/sax/SAXException
    //   632	690	1255	org/xml/sax/SAXException
    //   690	717	1255	org/xml/sax/SAXException
    //   721	779	1255	org/xml/sax/SAXException
    //   779	789	1255	org/xml/sax/SAXException
    //   793	829	1255	org/xml/sax/SAXException
    //   833	891	1255	org/xml/sax/SAXException
    //   891	918	1255	org/xml/sax/SAXException
    //   922	977	1255	org/xml/sax/SAXException
    //   977	1004	1255	org/xml/sax/SAXException
    //   1008	1066	1255	org/xml/sax/SAXException
    //   1066	1093	1255	org/xml/sax/SAXException
    //   1097	1152	1255	org/xml/sax/SAXException
    //   1152	1179	1255	org/xml/sax/SAXException
    //   1183	1238	1255	org/xml/sax/SAXException
    //   3	37	1263	java/io/IOException
    //   41	60	1263	java/io/IOException
    //   64	105	1263	java/io/IOException
    //   105	115	1263	java/io/IOException
    //   119	160	1263	java/io/IOException
    //   160	170	1263	java/io/IOException
    //   174	215	1263	java/io/IOException
    //   215	225	1263	java/io/IOException
    //   229	270	1263	java/io/IOException
    //   270	280	1263	java/io/IOException
    //   284	325	1263	java/io/IOException
    //   325	335	1263	java/io/IOException
    //   339	377	1263	java/io/IOException
    //   377	413	1263	java/io/IOException
    //   413	423	1263	java/io/IOException
    //   427	465	1263	java/io/IOException
    //   465	475	1263	java/io/IOException
    //   479	517	1263	java/io/IOException
    //   517	527	1263	java/io/IOException
    //   531	572	1263	java/io/IOException
    //   572	578	1263	java/io/IOException
    //   578	588	1263	java/io/IOException
    //   592	628	1263	java/io/IOException
    //   632	690	1263	java/io/IOException
    //   690	717	1263	java/io/IOException
    //   721	779	1263	java/io/IOException
    //   779	789	1263	java/io/IOException
    //   793	829	1263	java/io/IOException
    //   833	891	1263	java/io/IOException
    //   891	918	1263	java/io/IOException
    //   922	977	1263	java/io/IOException
    //   977	1004	1263	java/io/IOException
    //   1008	1066	1263	java/io/IOException
    //   1066	1093	1263	java/io/IOException
    //   1097	1152	1263	java/io/IOException
    //   1152	1179	1263	java/io/IOException
    //   1183	1238	1263	java/io/IOException
    //   3	37	1271	java/lang/Exception
    //   41	60	1271	java/lang/Exception
    //   64	105	1271	java/lang/Exception
    //   105	115	1271	java/lang/Exception
    //   119	160	1271	java/lang/Exception
    //   160	170	1271	java/lang/Exception
    //   174	215	1271	java/lang/Exception
    //   215	225	1271	java/lang/Exception
    //   229	270	1271	java/lang/Exception
    //   270	280	1271	java/lang/Exception
    //   284	325	1271	java/lang/Exception
    //   325	335	1271	java/lang/Exception
    //   339	377	1271	java/lang/Exception
    //   377	413	1271	java/lang/Exception
    //   413	423	1271	java/lang/Exception
    //   427	465	1271	java/lang/Exception
    //   465	475	1271	java/lang/Exception
    //   479	517	1271	java/lang/Exception
    //   517	527	1271	java/lang/Exception
    //   531	572	1271	java/lang/Exception
    //   572	578	1271	java/lang/Exception
    //   578	588	1271	java/lang/Exception
    //   592	628	1271	java/lang/Exception
    //   632	690	1271	java/lang/Exception
    //   690	717	1271	java/lang/Exception
    //   721	779	1271	java/lang/Exception
    //   779	789	1271	java/lang/Exception
    //   793	829	1271	java/lang/Exception
    //   833	891	1271	java/lang/Exception
    //   891	918	1271	java/lang/Exception
    //   922	977	1271	java/lang/Exception
    //   977	1004	1271	java/lang/Exception
    //   1008	1066	1271	java/lang/Exception
    //   1066	1093	1271	java/lang/Exception
    //   1097	1152	1271	java/lang/Exception
    //   1152	1179	1271	java/lang/Exception
    //   1183	1238	1271	java/lang/Exception
  }
  
  /* Error */
  public static String a(int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: new 741	java/io/File
    //   5: dup
    //   6: new 260	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 261	java/lang/StringBuilder:<init>	()V
    //   13: invokestatic 747	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   16: invokevirtual 750	java/io/File:getPath	()Ljava/lang/String;
    //   19: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: ldc_w 752
    //   25: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: iload_0
    //   29: invokevirtual 270	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   32: ldc_w 754
    //   35: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: invokevirtual 275	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: invokespecial 755	java/io/File:<init>	(Ljava/lang/String;)V
    //   44: astore 6
    //   46: aload 6
    //   48: invokevirtual 758	java/io/File:exists	()Z
    //   51: ifeq +101 -> 152
    //   54: new 760	java/io/FileInputStream
    //   57: dup
    //   58: aload 6
    //   60: invokespecial 763	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   63: astore_1
    //   64: new 765	java/io/ByteArrayOutputStream
    //   67: dup
    //   68: invokespecial 766	java/io/ByteArrayOutputStream:<init>	()V
    //   71: astore_3
    //   72: aload_3
    //   73: astore 5
    //   75: aload_1
    //   76: astore 4
    //   78: aload 6
    //   80: invokevirtual 769	java/io/File:length	()J
    //   83: l2i
    //   84: newarray <illegal type>
    //   86: astore_2
    //   87: aload_3
    //   88: astore 5
    //   90: aload_1
    //   91: astore 4
    //   93: aload_1
    //   94: aload_2
    //   95: iconst_0
    //   96: aload_2
    //   97: arraylength
    //   98: invokevirtual 773	java/io/FileInputStream:read	([BII)I
    //   101: istore_0
    //   102: iload_0
    //   103: iconst_m1
    //   104: if_icmpeq +53 -> 157
    //   107: aload_3
    //   108: astore 5
    //   110: aload_1
    //   111: astore 4
    //   113: aload_3
    //   114: aload_2
    //   115: iconst_0
    //   116: iload_0
    //   117: invokevirtual 777	java/io/ByteArrayOutputStream:write	([BII)V
    //   120: goto -33 -> 87
    //   123: astore 4
    //   125: aload_1
    //   126: astore_2
    //   127: aload_3
    //   128: astore_1
    //   129: aload 4
    //   131: astore_3
    //   132: aload_3
    //   133: invokevirtual 778	java/io/FileNotFoundException:printStackTrace	()V
    //   136: aload_2
    //   137: ifnull +7 -> 144
    //   140: aload_2
    //   141: invokevirtual 781	java/io/FileInputStream:close	()V
    //   144: aload_1
    //   145: ifnull +7 -> 152
    //   148: aload_1
    //   149: invokevirtual 782	java/io/ByteArrayOutputStream:close	()V
    //   152: ldc -57
    //   154: astore_1
    //   155: aload_1
    //   156: areturn
    //   157: aload_3
    //   158: astore 5
    //   160: aload_1
    //   161: astore 4
    //   163: new 292	java/lang/String
    //   166: dup
    //   167: aload_3
    //   168: invokevirtual 786	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   171: ldc_w 597
    //   174: invokespecial 789	java/lang/String:<init>	([BLjava/lang/String;)V
    //   177: astore_2
    //   178: aload_1
    //   179: ifnull +7 -> 186
    //   182: aload_1
    //   183: invokevirtual 781	java/io/FileInputStream:close	()V
    //   186: aload_2
    //   187: astore_1
    //   188: aload_3
    //   189: ifnull -34 -> 155
    //   192: aload_3
    //   193: invokevirtual 782	java/io/ByteArrayOutputStream:close	()V
    //   196: aload_2
    //   197: areturn
    //   198: astore_1
    //   199: aload_1
    //   200: invokevirtual 736	java/io/IOException:printStackTrace	()V
    //   203: aload_2
    //   204: areturn
    //   205: astore_1
    //   206: aload_1
    //   207: invokevirtual 736	java/io/IOException:printStackTrace	()V
    //   210: goto -58 -> 152
    //   213: astore 6
    //   215: aconst_null
    //   216: astore_2
    //   217: aconst_null
    //   218: astore_1
    //   219: aload_2
    //   220: astore 5
    //   222: aload_1
    //   223: astore 4
    //   225: aload 6
    //   227: invokevirtual 736	java/io/IOException:printStackTrace	()V
    //   230: aload_1
    //   231: ifnull +7 -> 238
    //   234: aload_1
    //   235: invokevirtual 781	java/io/FileInputStream:close	()V
    //   238: aload_2
    //   239: ifnull -87 -> 152
    //   242: aload_2
    //   243: invokevirtual 782	java/io/ByteArrayOutputStream:close	()V
    //   246: goto -94 -> 152
    //   249: astore_1
    //   250: aload_1
    //   251: invokevirtual 736	java/io/IOException:printStackTrace	()V
    //   254: goto -102 -> 152
    //   257: astore_2
    //   258: aconst_null
    //   259: astore_3
    //   260: aconst_null
    //   261: astore_1
    //   262: aload_1
    //   263: ifnull +7 -> 270
    //   266: aload_1
    //   267: invokevirtual 781	java/io/FileInputStream:close	()V
    //   270: aload_3
    //   271: ifnull +7 -> 278
    //   274: aload_3
    //   275: invokevirtual 782	java/io/ByteArrayOutputStream:close	()V
    //   278: aload_2
    //   279: athrow
    //   280: astore_1
    //   281: aload_1
    //   282: invokevirtual 736	java/io/IOException:printStackTrace	()V
    //   285: goto -7 -> 278
    //   288: astore_2
    //   289: aconst_null
    //   290: astore_3
    //   291: goto -29 -> 262
    //   294: astore_2
    //   295: aload 5
    //   297: astore_3
    //   298: aload 4
    //   300: astore_1
    //   301: goto -39 -> 262
    //   304: astore_3
    //   305: aload_2
    //   306: astore 4
    //   308: aload_3
    //   309: astore_2
    //   310: aload_1
    //   311: astore_3
    //   312: aload 4
    //   314: astore_1
    //   315: goto -53 -> 262
    //   318: astore 6
    //   320: aconst_null
    //   321: astore_2
    //   322: goto -103 -> 219
    //   325: astore 6
    //   327: aload_3
    //   328: astore_2
    //   329: goto -110 -> 219
    //   332: astore_3
    //   333: aconst_null
    //   334: astore_1
    //   335: goto -203 -> 132
    //   338: astore_3
    //   339: aconst_null
    //   340: astore 4
    //   342: aload_1
    //   343: astore_2
    //   344: aload 4
    //   346: astore_1
    //   347: goto -215 -> 132
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	350	0	paramInt	int
    //   63	125	1	localObject1	Object
    //   198	2	1	localIOException1	IOException
    //   205	2	1	localIOException2	IOException
    //   218	17	1	localObject2	Object
    //   249	2	1	localIOException3	IOException
    //   261	6	1	localObject3	Object
    //   280	2	1	localIOException4	IOException
    //   300	47	1	localObject4	Object
    //   1	242	2	localObject5	Object
    //   257	22	2	localObject6	Object
    //   288	1	2	localObject7	Object
    //   294	12	2	localObject8	Object
    //   309	35	2	localObject9	Object
    //   71	227	3	localObject10	Object
    //   304	5	3	localObject11	Object
    //   311	17	3	localObject12	Object
    //   332	1	3	localFileNotFoundException1	java.io.FileNotFoundException
    //   338	1	3	localFileNotFoundException2	java.io.FileNotFoundException
    //   76	36	4	localObject13	Object
    //   123	7	4	localFileNotFoundException3	java.io.FileNotFoundException
    //   161	184	4	localObject14	Object
    //   73	223	5	localObject15	Object
    //   44	35	6	localFile	File
    //   213	13	6	localIOException5	IOException
    //   318	1	6	localIOException6	IOException
    //   325	1	6	localIOException7	IOException
    // Exception table:
    //   from	to	target	type
    //   78	87	123	java/io/FileNotFoundException
    //   93	102	123	java/io/FileNotFoundException
    //   113	120	123	java/io/FileNotFoundException
    //   163	178	123	java/io/FileNotFoundException
    //   182	186	198	java/io/IOException
    //   192	196	198	java/io/IOException
    //   140	144	205	java/io/IOException
    //   148	152	205	java/io/IOException
    //   54	64	213	java/io/IOException
    //   234	238	249	java/io/IOException
    //   242	246	249	java/io/IOException
    //   54	64	257	finally
    //   266	270	280	java/io/IOException
    //   274	278	280	java/io/IOException
    //   64	72	288	finally
    //   78	87	294	finally
    //   93	102	294	finally
    //   113	120	294	finally
    //   163	178	294	finally
    //   225	230	294	finally
    //   132	136	304	finally
    //   64	72	318	java/io/IOException
    //   78	87	325	java/io/IOException
    //   93	102	325	java/io/IOException
    //   113	120	325	java/io/IOException
    //   163	178	325	java/io/IOException
    //   54	64	332	java/io/FileNotFoundException
    //   64	72	338	java/io/FileNotFoundException
  }
  
  public static String a(int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt1).append('-').append(paramInt2);
    return localStringBuilder.toString();
  }
  
  private String a(InputStream paramInputStream)
  {
    BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(paramInputStream));
    StringBuilder localStringBuilder = new StringBuilder();
    try
    {
      for (;;)
      {
        String str = localBufferedReader.readLine();
        if (str == null) {
          break;
        }
        localStringBuilder.append(str);
      }
      try
      {
        paramInputStream.close();
        throw ((Throwable)localObject);
      }
      catch (IOException paramInputStream)
      {
        for (;;)
        {
          paramInputStream.printStackTrace();
        }
      }
    }
    catch (IOException localIOException)
    {
      localIOException = localIOException;
      localIOException.printStackTrace();
      try
      {
        paramInputStream.close();
        for (;;)
        {
          return localStringBuilder.toString();
          try
          {
            paramInputStream.close();
          }
          catch (IOException paramInputStream)
          {
            paramInputStream.printStackTrace();
          }
        }
      }
      catch (IOException paramInputStream)
      {
        for (;;)
        {
          paramInputStream.printStackTrace();
        }
      }
    }
    finally {}
  }
  
  /* Error */
  private void a(int paramInt, String paramString1, String paramString2, QQAppInterface paramQQAppInterface)
  {
    // Byte code:
    //   0: getstatic 816	cooperation/readinjoy/content/ReadInJoyDataProvider:e	Landroid/net/Uri;
    //   3: invokevirtual 822	android/net/Uri:buildUpon	()Landroid/net/Uri$Builder;
    //   6: astore 5
    //   8: aload 5
    //   10: ldc_w 824
    //   13: getstatic 201	com/tencent/mobileqq/config/splashlogo/ConfigServlet:h	Ljava/lang/String;
    //   16: invokevirtual 830	android/net/Uri$Builder:appendQueryParameter	(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   19: pop
    //   20: aload 5
    //   22: invokevirtual 834	android/net/Uri$Builder:build	()Landroid/net/Uri;
    //   25: astore 5
    //   27: new 836	android/content/ContentValues
    //   30: dup
    //   31: invokespecial 837	android/content/ContentValues:<init>	()V
    //   34: astore 6
    //   36: aload 6
    //   38: ldc_w 839
    //   41: iload_1
    //   42: invokestatic 355	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   45: invokevirtual 843	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   48: aload 6
    //   50: ldc_w 845
    //   53: aload_2
    //   54: invokevirtual 848	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   57: aload 6
    //   59: ldc_w 850
    //   62: aload_3
    //   63: invokevirtual 848	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   66: ldc_w 852
    //   69: iconst_2
    //   70: anewarray 349	java/lang/Object
    //   73: dup
    //   74: iconst_0
    //   75: ldc_w 845
    //   78: aastore
    //   79: dup
    //   80: iconst_1
    //   81: aload_2
    //   82: aastore
    //   83: invokestatic 359	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   86: astore_2
    //   87: aload 4
    //   89: invokevirtual 241	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   92: invokevirtual 856	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   95: aload 5
    //   97: aconst_null
    //   98: aload_2
    //   99: aconst_null
    //   100: aconst_null
    //   101: invokevirtual 862	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   104: astore_2
    //   105: aload_2
    //   106: ifnull +148 -> 254
    //   109: aload_2
    //   110: invokeinterface 867 1 0
    //   115: ifle +61 -> 176
    //   118: aload 4
    //   120: invokevirtual 241	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   123: invokevirtual 856	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   126: aload 5
    //   128: aload 6
    //   130: aconst_null
    //   131: aconst_null
    //   132: invokevirtual 871	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   135: pop
    //   136: invokestatic 256	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   139: ifeq +12 -> 151
    //   142: ldc -111
    //   144: iconst_2
    //   145: ldc_w 873
    //   148: invokestatic 278	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   151: aload 4
    //   153: invokevirtual 241	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   156: invokevirtual 856	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   159: aload 5
    //   161: aconst_null
    //   162: invokevirtual 877	android/content/ContentResolver:notifyChange	(Landroid/net/Uri;Landroid/database/ContentObserver;)V
    //   165: aload_2
    //   166: ifnull +9 -> 175
    //   169: aload_2
    //   170: invokeinterface 878 1 0
    //   175: return
    //   176: aload 4
    //   178: invokevirtual 241	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   181: invokevirtual 856	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   184: aload 5
    //   186: aload 6
    //   188: invokevirtual 882	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   191: pop
    //   192: invokestatic 256	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   195: ifeq -44 -> 151
    //   198: ldc -111
    //   200: iconst_2
    //   201: ldc_w 884
    //   204: invokestatic 278	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   207: goto -56 -> 151
    //   210: astore_3
    //   211: invokestatic 256	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   214: ifeq +29 -> 243
    //   217: ldc -111
    //   219: iconst_2
    //   220: new 260	java/lang/StringBuilder
    //   223: dup
    //   224: invokespecial 261	java/lang/StringBuilder:<init>	()V
    //   227: ldc_w 886
    //   230: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: aload_3
    //   234: invokevirtual 679	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   237: invokevirtual 275	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   240: invokestatic 278	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   243: aload_2
    //   244: ifnull -69 -> 175
    //   247: aload_2
    //   248: invokeinterface 878 1 0
    //   253: return
    //   254: invokestatic 256	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   257: ifeq -106 -> 151
    //   260: ldc -111
    //   262: iconst_2
    //   263: ldc_w 888
    //   266: invokestatic 278	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   269: goto -118 -> 151
    //   272: astore 4
    //   274: aload_2
    //   275: astore_3
    //   276: aload 4
    //   278: astore_2
    //   279: aload_3
    //   280: ifnull +9 -> 289
    //   283: aload_3
    //   284: invokeinterface 878 1 0
    //   289: aload_2
    //   290: athrow
    //   291: astore_2
    //   292: aconst_null
    //   293: astore_3
    //   294: goto -15 -> 279
    //   297: astore 4
    //   299: aload_2
    //   300: astore_3
    //   301: aload 4
    //   303: astore_2
    //   304: goto -25 -> 279
    //   307: astore_3
    //   308: aconst_null
    //   309: astore_2
    //   310: goto -99 -> 211
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	313	0	this	ConfigServlet
    //   0	313	1	paramInt	int
    //   0	313	2	paramString1	String
    //   0	313	3	paramString2	String
    //   0	313	4	paramQQAppInterface	QQAppInterface
    //   6	179	5	localObject	Object
    //   34	153	6	localContentValues	android.content.ContentValues
    // Exception table:
    //   from	to	target	type
    //   109	151	210	java/lang/Exception
    //   151	165	210	java/lang/Exception
    //   176	207	210	java/lang/Exception
    //   254	269	210	java/lang/Exception
    //   109	151	272	finally
    //   151	165	272	finally
    //   176	207	272	finally
    //   254	269	272	finally
    //   27	105	291	finally
    //   211	243	297	finally
    //   27	105	307	java/lang/Exception
  }
  
  private void a(Intent paramIntent, ConfigurationService.Config paramConfig)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_configServlet", 2, "handleResp_GetArEntranceConfig|type= " + paramConfig.type.get());
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)getAppRuntime();
    ArResourceManager localArResourceManager = (ArResourceManager)localQQAppInterface.getManager(167);
    if (paramConfig.type.get() != 88)
    {
      OlympicServlet.a(localQQAppInterface, 88, 0, 0, 1, 3, 0);
      return;
    }
    int i1 = paramConfig.version.get();
    int i2;
    if (paramIntent.getIntExtra("key_ar_entrance_effect_version", 0) != i1) {
      if ((paramConfig.msg_content_list != null) && (paramConfig.msg_content_list.size() > 0))
      {
        paramIntent = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
        i2 = paramIntent.task_id.get();
        if (paramIntent.compress.get() == 1)
        {
          paramIntent = ArConfigUtils.a(paramIntent.content.get().toByteArray());
          if (paramIntent == null)
          {
            OlympicServlet.a(localQQAppInterface, 88, i1, i2, 1, 4, 0);
            if (!QLog.isColorLevel()) {
              break label393;
            }
            QLog.d("ArConfig_configServlet", 2, "handleResp_GetArEntranceConfig||deCompress error!");
            paramIntent = null;
          }
        }
      }
    }
    for (;;)
    {
      paramIntent = ArEffectConfig.a(paramIntent);
      if (paramIntent != null)
      {
        paramIntent.jdField_a_of_type_Int = i1;
        if (localArResourceManager != null) {
          localArResourceManager.a(paramIntent);
        }
        for (;;)
        {
          OlympicServlet.a(localQQAppInterface, 88, i1, i2, 1, 0, 0);
          return;
          try
          {
            paramIntent = new String(paramIntent, "utf-8");
          }
          catch (UnsupportedEncodingException localUnsupportedEncodingException)
          {
            paramConfig = null;
            paramIntent = paramConfig;
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("SPLASH_ConfigServlet", 2, localUnsupportedEncodingException.getMessage());
          paramIntent = paramConfig;
          break;
          paramIntent = paramIntent.content.get().toStringUtf8();
          break;
          if (QLog.isColorLevel()) {
            QLog.d("ArConfig_configServlet", 2, "handleResp_GetArEntranceConfig|arManager is null ");
          }
        }
      }
      OlympicServlet.a(localQQAppInterface, 88, i1, i2, 1, 5, 0);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ArConfig_configServlet", 2, "handleResp_GetArEntranceConfig||parseArEffectConfig error!");
      return;
      if (localArResourceManager != null) {
        localArResourceManager.b();
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ArConfig_configServlet", 2, "handleResp_GetArEntranceConfig || msg_content_list is null");
      return;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ArConfig_configServlet", 2, "handleResp_GetArEntranceConfig || has same version");
      return;
      label393:
      paramIntent = null;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    a(paramQQAppInterface, 5);
    if (QLog.isDevelopLevel()) {
      QLog.d("QQOperateVoIP", 4, "onSend configXml request");
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    a(paramQQAppInterface, paramInt, null);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt, String paramString)
  {
    NewIntent localNewIntent = new NewIntent(paramQQAppInterface.a(), ConfigServlet.class);
    localNewIntent.putExtra("k_cmd_type", new int[] { paramInt });
    if (!StringUtil.b(paramString)) {
      localNewIntent.putExtra("key_uin", paramString);
    }
    paramQQAppInterface.startServlet(localNewIntent);
  }
  
  private void a(QQAppInterface paramQQAppInterface, Intent paramIntent, int[] paramArrayOfInt, Packet paramPacket)
  {
    ConfigurationService.ReqGetConfig localReqGetConfig = new ConfigurationService.ReqGetConfig();
    int i3 = paramArrayOfInt.length;
    ArrayList localArrayList1 = new ArrayList(i3);
    ArrayList localArrayList2 = new ArrayList(i3);
    int i1 = 0;
    if (i1 < i3)
    {
      ConfigurationService.ConfigSeq localConfigSeq = new ConfigurationService.ConfigSeq();
      int i4 = paramArrayOfInt[i1];
      localConfigSeq.type.set(i4);
      switch (i4)
      {
      }
      for (;;)
      {
        label568:
        localArrayList1.add(localConfigSeq);
        localArrayList2.add(Integer.valueOf(i4));
        int i2;
        for (;;)
        {
          i1 += 1;
          break;
          localConfigSeq.version.set(SharedPreUtils.e(paramQQAppInterface.a()));
          break label568;
          localConfigSeq.version.set(SharedPreUtils.i(paramQQAppInterface.a(), h));
          break label568;
          SharedPreUtils.a(paramQQAppInterface.getApplication(), paramQQAppInterface.a());
          if (paramQQAppInterface.a() != null)
          {
            m = paramQQAppInterface.b();
            Object localObject1 = ProfileCardUtil.a(paramQQAppInterface, paramQQAppInterface.a());
            int i5;
            if (localObject1 != null)
            {
              if (QLog.isColorLevel()) {
                QLog.i("SPLASH_ConfigServlet_birth", 2, "card!=null");
              }
              i5 = (int)((Card)localObject1).lBirthday;
              i2 = ProfileUtil.c(i5);
              i5 = ProfileUtil.d(i5);
              SharedPreUtils.b(paramQQAppInterface.a(), a(i2, i5));
              i2 = a(new SimpleDateFormat("MM-dd").format(new Date()), a(i2, i5));
              if (QLog.isColorLevel()) {
                QLog.i("SPLASH_ConfigServlet_birth", 2, "birthday date diff is " + i2);
              }
              if (i2 < 0) {
                continue;
              }
              if (i2 <= 3) {}
            }
            else
            {
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.i("SPLASH_ConfigServlet_birth", 2, "card===null");
              continue;
            }
            localConfigSeq.version.set(SharedPreUtils.j(paramQQAppInterface.a(), h));
            break label568;
            localObject1 = (NearbyBannerManager)paramQQAppInterface.getManager(73);
            localConfigSeq.version.set(((NearbyBannerManager)localObject1).a());
            break label568;
            localConfigSeq.version.set(SharedPreUtils.p(paramQQAppInterface.a(), h));
            break label568;
            localConfigSeq.version.set(SharedPreUtils.k(paramQQAppInterface.a(), paramQQAppInterface.a()));
            break label568;
            localConfigSeq.version.set(SharedPreUtils.l(paramQQAppInterface.a(), paramQQAppInterface.a()));
            break label568;
            localConfigSeq.version.set(SharedPreUtils.d(paramQQAppInterface.a()));
            break label568;
            localConfigSeq.version.set(SharedPreUtils.k(paramQQAppInterface.a()));
            break label568;
            BridgeHelper.a(BaseApplication.getContext(), h).a();
            localConfigSeq.version.set(SharedPreUtils.a(paramQQAppInterface.a(), paramQQAppInterface.getAccount()));
            break label568;
            i2 = ApkUtils.a(BaseApplicationImpl.getContext());
            if (SettingCloneUtil.readValueForInt(BaseApplicationImpl.getContext(), h, null, "qqsetting_calltab_show_key_version", 0) < i2)
            {
              localConfigSeq.version.set(0);
              break label568;
            }
            localConfigSeq.version.set(SharedPreUtils.n(paramQQAppInterface.a(), paramQQAppInterface.getAccount()));
            break label568;
            i2 = ApkUtils.a(BaseApplicationImpl.getContext());
            if (SettingCloneUtil.readValueForInt(BaseApplicationImpl.getContext(), h, null, "qqsetting_calltab_show_key_version", 0) < i2)
            {
              localConfigSeq.version.set(0);
              paramIntent.putExtra("update101Version", i2);
              break label568;
            }
            localConfigSeq.version.set(SharedPreUtils.m(paramQQAppInterface.a(), paramQQAppInterface.getAccount()));
            break label568;
            localObject1 = (PhoneUnityManager)paramQQAppInterface.getManager(101);
            localConfigSeq.version.set(((PhoneUnityManager)localObject1).a());
            break label568;
            localConfigSeq.version.set(SharedPreUtils.g(paramQQAppInterface.a()));
            break label568;
            localConfigSeq.version.set(SharedPreUtils.u(paramQQAppInterface.a(), h));
            break label568;
            localConfigSeq.version.set(SharedPreUtils.v(paramQQAppInterface.a(), h));
            break label568;
            if (!PtvTemplateManager.a())
            {
              localConfigSeq.version.set(0);
              break label568;
            }
            localConfigSeq.version.set(SharedPreUtils.h(paramQQAppInterface.a()));
            break label568;
            i2 = 0;
            if (PtvTemplateManager.b()) {
              i2 = SharedPreUtils.i(paramQQAppInterface.a());
            }
            localConfigSeq.version.set(i2);
            localConfigSeq.compress.set(1);
            if (!QLog.isDevelopLevel()) {
              break label568;
            }
            QLog.d("SPLASH_ConfigServlet", 4, String.format("双人挂件配置版本[%s]", new Object[] { Integer.valueOf(i2) }));
            break label568;
            if (OfficeCenterConfigLoader.a().a() != null)
            {
              localConfigSeq.version.set(SharedPreUtils.c(paramQQAppInterface.a()));
              break label568;
            }
            localConfigSeq.version.set(0);
            break label568;
            if (HYConfigLoader.a().a() != null)
            {
              localConfigSeq.version.set(SharedPreUtils.a(paramQQAppInterface.a()));
              break label568;
            }
            localConfigSeq.version.set(0);
            break label568;
            localConfigSeq.version.set(SharedPreUtils.b(paramQQAppInterface.a(), paramQQAppInterface.getAccount()));
            break label568;
            localConfigSeq.version.set(SharedPreUtils.c(paramQQAppInterface.a(), ""));
            break label568;
            localConfigSeq.version.set(SharedPreUtils.d(paramQQAppInterface.a(), ""));
            break label568;
            localConfigSeq.version.set(SharedPreUtils.e(paramQQAppInterface.a(), paramQQAppInterface.getAccount()));
            break label568;
            localConfigSeq.version.set(SharedPreUtils.w(paramQQAppInterface.a(), paramQQAppInterface.getAccount()));
            break label568;
            localConfigSeq.version.set(SharedPreUtils.j(paramQQAppInterface.a()));
            break label568;
            localConfigSeq.version.set(SharedPreUtils.z(paramQQAppInterface.a(), paramQQAppInterface.getAccount()));
            break label568;
            localConfigSeq.version.set(SharedPreUtils.q(paramQQAppInterface.a(), h));
            break label568;
            localConfigSeq.version.set(SharedPreUtils.r(paramQQAppInterface.a(), h));
            break label568;
            localConfigSeq.version.set(SharedPreUtils.s(paramQQAppInterface.a(), h));
            break label568;
            localConfigSeq.version.set(SharedPreUtils.f(paramQQAppInterface.a(), h));
            break label568;
            localConfigSeq.version.set(SharedPreUtils.E(paramQQAppInterface.a(), h));
            break label568;
            boolean bool = QFindConfigUtil.a();
            if (QLog.isColorLevel()) {
              QLog.d("SPLASH_ConfigServlet", 2, "addAllConfigs, support ble=" + bool);
            }
            if (bool)
            {
              localConfigSeq.version.set(SharedPreUtils.g(paramQQAppInterface.a(), h));
              break label568;
              bool = QFindConfigUtil.a();
              if (QLog.isColorLevel()) {
                QLog.d("SPLASH_ConfigServlet", 2, "addAllConfigs, support ble=" + bool);
              }
              if (bool)
              {
                localConfigSeq.version.set(SharedPreUtils.h(paramQQAppInterface.a(), h));
                break label568;
                localConfigSeq.version.set(SharedPreUtils.p(paramQQAppInterface.a()));
                break label568;
                i2 = SharedPreUtils.y(paramQQAppInterface.a(), h);
                i5 = AppSetting.jdField_a_of_type_Int;
                if (i2 != i5)
                {
                  SharedPreUtils.f(paramQQAppInterface.a(), h, 0);
                  SharedPreUtils.g(paramQQAppInterface.a(), h, i5);
                  SearchConfigManager.a(paramQQAppInterface, h);
                }
                localConfigSeq.version.set(SharedPreUtils.x(paramQQAppInterface.a(), h));
                break label568;
                localConfigSeq.version.set(SharedPreUtils.F(paramQQAppInterface.a(), h));
                break label568;
                localConfigSeq.version.set(SharedPreUtils.t(paramQQAppInterface.a(), h));
                break label568;
                localConfigSeq.version.set(SharedPreUtils.r(paramQQAppInterface.a()));
                break label568;
                localConfigSeq.version.set(SharedPreUtils.s(paramQQAppInterface.a()));
                break label568;
                localConfigSeq.version.set(SharedPreUtils.t(paramQQAppInterface.a()));
                break label568;
                i2 = SharedPreUtils.G(paramQQAppInterface.a(), h);
                localConfigSeq.version.set(i2);
                break label568;
                localConfigSeq.version.set(SharedPreUtils.u(paramQQAppInterface.a()));
                break label568;
                localConfigSeq.version.set(SharedPreUtils.A(paramQQAppInterface.a(), h));
                break label568;
                localConfigSeq.version.set(SharedPreUtils.v(paramQQAppInterface.a()));
                break label568;
                localConfigSeq.version.set(SharedPreUtils.w(paramQQAppInterface.a()));
                break label568;
                localConfigSeq.version.set(SharedPreUtils.n(paramQQAppInterface.a()));
                break label568;
                localConfigSeq.version.set(PublicAccountConfigUtil.b(paramQQAppInterface));
                break label568;
                try
                {
                  if (!new File(PreloadManager.a(paramQQAppInterface)).exists()) {
                    SharedPreUtils.o(paramQQAppInterface.a(), paramQQAppInterface.a(), 0);
                  }
                  localConfigSeq.version.set(SharedPreUtils.I(paramQQAppInterface.a(), h));
                }
                catch (Exception localException)
                {
                  for (;;)
                  {
                    localException.printStackTrace();
                  }
                }
                i2 = SharedPreUtils.B(paramQQAppInterface.a(), h);
                localConfigSeq.version.set(i2);
                break label568;
                localConfigSeq.version.set(((MayknowRecommendManager)paramQQAppInterface.getManager(158)).b());
                break label568;
                i2 = SharedPreUtils.C(paramQQAppInterface.a(), h);
                localConfigSeq.version.set(i2);
                break label568;
                localReqGetConfig = DeviceProfileManager.a(paramQQAppInterface);
              }
            }
          }
        }
        localConfigSeq.version.set(SharedPreUtils.D(paramQQAppInterface.a(), h));
        continue;
        localConfigSeq.version.set(SharedPreUtils.o(paramQQAppInterface.a(), h));
        Object localObject3 = paramIntent.getStringExtra("key_province");
        Object localObject2 = localObject3;
        if (localObject3 == null) {
          localObject2 = "";
        }
        String str = paramIntent.getStringExtra("key_city");
        localObject3 = str;
        if (str == null) {
          localObject3 = "";
        }
        localReqGetConfig.province.set((String)localObject2);
        localReqGetConfig.city.set((String)localObject3);
        continue;
        localConfigSeq.version.set(PrecoverUtils.a(paramQQAppInterface.a(), h));
        localConfigSeq.compress.set(1);
        localObject3 = paramIntent.getStringExtra("key_province");
        localObject2 = localObject3;
        if (localObject3 == null) {
          localObject2 = "";
        }
        str = paramIntent.getStringExtra("key_city");
        localObject3 = str;
        if (str == null) {
          localObject3 = "";
        }
        localReqGetConfig.province.set((String)localObject2);
        localReqGetConfig.city.set((String)localObject3);
        continue;
        localConfigSeq.version.set(SharedPreUtils.l(paramQQAppInterface.a()));
        continue;
        localConfigSeq.version.set(SharedPreUtils.m(paramQQAppInterface.a()));
        continue;
        localConfigSeq.version.set(SharedPreUtils.J(paramQQAppInterface.a(), paramQQAppInterface.a()));
        continue;
        localConfigSeq.version.set(PublicAccountConfigUtil.a(paramQQAppInterface));
        continue;
        localObject2 = (TroopManager)paramQQAppInterface.getManager(51);
        localConfigSeq.version.set(((TroopManager)localObject2).d);
        continue;
        localConfigSeq.version.set(SharedPreUtils.y(paramQQAppInterface.a()));
        continue;
        localObject2 = (TroopTopicMgr)paramQQAppInterface.getManager(97);
        localConfigSeq.version.set(((TroopTopicMgr)localObject2).g);
        continue;
        localConfigSeq.version.set(SharedPreUtils.K(paramQQAppInterface.a(), h));
        continue;
        localConfigSeq.version.set(SharedPreUtils.H(paramQQAppInterface.a(), paramQQAppInterface.a()));
        continue;
        localConfigSeq.version.set(SharedPreUtils.b(paramQQAppInterface.a(), "Ecshop_Folder", h));
        continue;
        localObject2 = (OlympicManager)paramQQAppInterface.getManager(166);
        if (localObject2 != null)
        {
          ((OlympicManager)localObject2).k();
          localObject2 = ((OlympicManager)localObject2).a();
          i2 = 0;
          if (localObject2 != null) {
            i2 = ((OlympicActConfig)localObject2).version;
          }
          localConfigSeq.version.set(i2);
          localConfigSeq.compress.set(1);
          paramIntent.putExtra("config_version", i2);
          if (QLog.isColorLevel()) {
            QLog.d("Olympic.OLYMPIC_ACT_RESOURCE_CONFIG_INFO", 2, new Object[] { "oldVersion=", Integer.valueOf(i2) });
          }
          if (OlympicUtil.a(BaseApplicationImpl.getContext(), "olympic_config_act_get"))
          {
            if (QLog.isColorLevel()) {
              QLog.d("Olympic.configServlet", 2, new Object[] { "check24Hour, result=true, do Report, key=", "olympic_config_act_get" });
            }
            StatisticCollector.a(BaseApplicationImpl.getContext()).a("", "olympic_config_act_get", true, 0L, 0L, null, "", false);
            OlympicUtil.a(BaseApplicationImpl.getContext(), "olympic_config_act_get");
            continue;
            localObject2 = (ArResourceManager)paramQQAppInterface.getManager(167);
            if (localObject2 != null)
            {
              i2 = ((ArResourceManager)localObject2).a();
              localConfigSeq.version.set(i2);
              localConfigSeq.compress.set(1);
              localObject3 = paramIntent.getStringExtra("key_province");
              localObject2 = localObject3;
              if (localObject3 == null) {
                localObject2 = "";
              }
              str = paramIntent.getStringExtra("key_city");
              localObject3 = str;
              if (str == null) {
                localObject3 = "";
              }
              localReqGetConfig.province.set((String)localObject2);
              localReqGetConfig.city.set((String)localObject3);
              paramIntent.putExtra("key_config_version", i2);
              continue;
              localObject2 = (ArResourceManager)paramQQAppInterface.getManager(167);
              if (localObject2 != null)
              {
                i2 = ((ArResourceManager)localObject2).b();
                localConfigSeq.version.set(i2);
                localConfigSeq.compress.set(1);
                paramIntent.putExtra("key_ar_entrance_effect_version", i2);
                continue;
                i2 = SharedPreUtils.b(paramQQAppInterface.a(), "push_open_notify_version", h);
                localConfigSeq.version.set(i2);
                continue;
                i2 = SharedPreUtils.b(paramQQAppInterface.a(), "readinjoy_interested_push_config", h);
                localConfigSeq.version.set(i2);
                continue;
                localObject2 = (PhoneContactManagerImp)paramQQAppInterface.getManager(10);
                localConfigSeq.version.set(((PhoneContactManagerImp)localObject2).f());
                continue;
                if (MagicfaceManagerForAV.a().a() != null) {
                  if (AudioHelper.b()) {
                    localConfigSeq.version.set(0);
                  }
                }
                for (;;)
                {
                  localConfigSeq.compress.set(1);
                  break;
                  localConfigSeq.version.set(SharedPreUtils.b(paramQQAppInterface.a()));
                  continue;
                  localConfigSeq.version.set(0);
                }
                i2 = CameraUtils.a(BaseApplicationImpl.getContext());
                localConfigSeq.version.set(i2);
                localConfigSeq.compress.set(1);
                paramIntent.putExtra("qcamera_conf_version", i2);
                paramIntent.putExtra("uin", paramQQAppInterface.a());
                if (QLog.isColorLevel())
                {
                  QLog.i("Q.camera.configServlet", 2, "request QCAMERA_PHONE_CONFIG version: " + i2);
                  continue;
                  i2 = SharedPreUtils.b(paramQQAppInterface.a(), "change_machine_version", h);
                  localConfigSeq.version.set(i2);
                  continue;
                  i2 = SharedPreUtils.b(paramQQAppInterface.a(), "now_entrance_action_version", h);
                  localConfigSeq.version.set(i2);
                  continue;
                  localObject2 = (ActivateFriendsManager)paramQQAppInterface.getManager(84);
                  localConfigSeq.version.set(((ActivateFriendsManager)localObject2).a());
                  continue;
                  localConfigSeq.version.set(SharedPreUtils.L(paramQQAppInterface.a(), ""));
                }
              }
            }
          }
        }
      }
    }
    if (QLog.isColorLevel())
    {
      i1 = localArrayList2.size();
      paramQQAppInterface = localArrayList2.iterator();
      while (paramQQAppInterface.hasNext())
      {
        paramIntent = (Integer)paramQQAppInterface.next();
        QLog.d("SPLASH_ConfigServlet", 2, "addAllConfigs|send type: " + paramIntent + ",length: " + i1);
      }
    }
    paramQQAppInterface = new ConfigurationService.DeviceInfo();
    if ((localArrayList2.contains(Integer.valueOf(1))) || (localArrayList2.contains(Integer.valueOf(2))) || (localArrayList2.contains(Integer.valueOf(3))) || (localArrayList2.contains(Integer.valueOf(18))) || (localArrayList2.contains(Integer.valueOf(12))))
    {
      paramIntent = new ConfigurationService.Screen();
      paramIntent.setHasFlag(true);
      paramIntent.width.set((int)DeviceInfoUtil.h());
      paramIntent.height.set((int)DeviceInfoUtil.i());
      paramQQAppInterface.screen = paramIntent;
      paramQQAppInterface.setHasFlag(true);
      localReqGetConfig.device_info = paramQQAppInterface;
    }
    if ((localArrayList2.contains(Integer.valueOf(47))) || (localArrayList2.contains(Integer.valueOf(65))))
    {
      paramIntent = new ConfigurationService.OS();
      paramIntent.setHasFlag(true);
      paramIntent.type.set(2);
      paramIntent.kernel.set(DeviceInfoUtil.m());
      paramIntent.sdk.set(String.valueOf(DeviceInfoUtil.a()));
      paramIntent.version.set(DeviceInfoUtil.e());
      paramIntent.rom.set(DeviceInfoUtil.j());
      paramQQAppInterface.brand.set(DeviceInfoUtil.h());
      paramQQAppInterface.model.set(DeviceInfoUtil.d());
      paramQQAppInterface.os = paramIntent;
      paramQQAppInterface.setHasFlag(true);
      localReqGetConfig.device_info = paramQQAppInterface;
    }
    localReqGetConfig.setHasFlag(true);
    localReqGetConfig.seq_list.addAll(localArrayList1);
    paramQQAppInterface = a(localReqGetConfig);
    if ((paramQQAppInterface != null) && (paramQQAppInterface.length > 0)) {
      paramPacket.putSendData(paramQQAppInterface);
    }
    paramPacket.setSSOCommand("ConfigurationService.ReqGetConfig");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    h = paramString;
    a(paramQQAppInterface, 60);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.nearby", 2, "HOTCHAT_SCENE_CONFIGS_CMD, app is null, or uin is empty");
      }
    }
    do
    {
      do
      {
        return;
        if ((paramInt == -1) || (SharedPreUtils.p(paramQQAppInterface.a()) != paramInt)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("Q.nearby", 2, "HOTCHAT_SCENE_CONFIGS_CMD, same version " + paramInt);
      return;
      h = paramString;
      a(paramQQAppInterface, 49);
    } while (!QLog.isColorLevel());
    QLog.d("Q.nearby", 2, "HOTCHAT_SCENE_CONFIGS_CMD, " + paramInt);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, int paramInt, String paramString2)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString1)))
    {
      QLog.d("SPLASH_ConfigServlet", 1, "PATCH_CONFIG_CMD getPatchConfig: app is null or uin is empty");
      return;
    }
    if ((paramInt != -1) && (SharedPreUtils.k(paramQQAppInterface.getApplication()) == paramInt))
    {
      QLog.d("SPLASH_ConfigServlet", 1, "PATCH_CONFIG_CMD getPatchConfig same version=" + paramInt + ", reason=" + paramString2);
      return;
    }
    h = paramString1;
    a(paramQQAppInterface, 46);
    QLog.d("SPLASH_ConfigServlet", 1, "PATCH_CONFIG_CMD getPatchConfig version=" + paramInt + ", reason=" + paramString2);
  }
  
  private static void a(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {
      paramString = PreferenceManager.getDefaultSharedPreferences(paramQQAppInterface.a()).getString(paramQQAppInterface.f() + "_" + "push_open_notify_xml", null);
    }
    if (paramString == null) {
      return;
    }
    Object localObject;
    label137:
    label226:
    label304:
    do
    {
      for (;;)
      {
        try
        {
          localObject = new ByteArrayInputStream(paramString.getBytes("utf-8"));
          paramString = Xml.newPullParser();
          paramString.setInput((InputStream)localObject, "utf-8");
          int i1 = paramString.getEventType();
          if (i1 == 1) {
            break label642;
          }
          if (paramString.getEventType() == 2)
          {
            localObject = paramString.getName();
            if (((String)localObject).equals("switch")) {
              jdField_a_of_type_Boolean = paramString.nextText().equals("true");
            }
          }
          else
          {
            i1 = paramString.next();
            continue;
          }
          if (!((String)localObject).equals("frequency")) {
            break label226;
          }
          jdField_a_of_type_Long = Long.valueOf(paramString.nextText()).longValue();
          if (jdField_a_of_type_Long >= 0L) {
            continue;
          }
          jdField_a_of_type_Long = 0L;
          continue;
          if (!QLog.isColorLevel()) {
            break;
          }
        }
        catch (Exception paramQQAppInterface) {}
        QLog.i("PushOpenNotify", 2, "handlePushOpenNotifyConfig, exception: " + paramQQAppInterface.getStackTrace());
        return;
        if (((String)localObject).equals("wording"))
        {
          j = paramString.nextText();
        }
        else if (((String)localObject).equals("maxOSVersion"))
        {
          z = Integer.valueOf(paramString.nextText()).intValue();
        }
        else
        {
          if (!((String)localObject).equals("defaultSwitch")) {
            break label304;
          }
          jdField_b_of_type_Boolean = paramString.nextText().equals("true");
        }
      }
    } while ((!((String)localObject).equals("device")) || (!paramString.getAttributeValue(null, "id").equals(DeviceInfoUtil.d())));
    for (;;)
    {
      if (paramString.next() != 3)
      {
        if (paramString.getEventType() != 2) {
          continue;
        }
        if (jdField_a_of_type_AndroidContentIntent == null) {
          jdField_a_of_type_AndroidContentIntent = new Intent();
        }
        localObject = paramString.getName();
        if (((String)localObject).equals("action"))
        {
          jdField_a_of_type_AndroidContentIntent.setAction(paramString.nextText());
          continue;
        }
        if (((String)localObject).equals("data"))
        {
          localObject = Uri.parse(paramString.nextText());
          jdField_a_of_type_AndroidContentIntent.setData((Uri)localObject);
          continue;
        }
        if (((String)localObject).equals("type"))
        {
          jdField_a_of_type_AndroidContentIntent.setType(paramString.nextText());
          continue;
        }
        if (((String)localObject).equals("package"))
        {
          jdField_a_of_type_AndroidContentIntent.setPackage(paramString.nextText());
          continue;
        }
        if (((String)localObject).equals("component"))
        {
          localObject = paramString.nextText().split(";");
          localObject = new ComponentName(localObject[0].trim(), localObject[1].trim());
          jdField_a_of_type_AndroidContentIntent.setComponent((ComponentName)localObject);
          continue;
        }
        if (((String)localObject).equals("category"))
        {
          jdField_a_of_type_AndroidContentIntent.addCategory(paramString.nextText());
          continue;
        }
        if (((String)localObject).equals("blackList"))
        {
          c = true;
          jdField_a_of_type_AndroidContentIntent = null;
        }
      }
      else
      {
        if (jdField_a_of_type_AndroidContentIntent == null) {
          break label137;
        }
        if (QLog.isColorLevel()) {
          QLog.i("PushOpenNotify", 2, String.format("handlePushOpenNotifyConfig, switch: %s, frequency: %d, word:%s intent: %s", new Object[] { Boolean.valueOf(jdField_a_of_type_Boolean), Long.valueOf(jdField_a_of_type_Long), j, jdField_a_of_type_AndroidContentIntent }));
        }
        label642:
        if ((!jdField_b_of_type_Boolean) || (c) || (jdField_a_of_type_AndroidContentIntent != null)) {
          break;
        }
        jdField_a_of_type_AndroidContentIntent = new Intent();
        jdField_a_of_type_AndroidContentIntent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        paramQQAppInterface = Uri.parse("package:" + paramQQAppInterface.a().getPackageName());
        jdField_a_of_type_AndroidContentIntent.setData(paramQQAppInterface);
        return;
      }
      if (((String)localObject).equals("app_uid"))
      {
        jdField_a_of_type_AndroidContentIntent.putExtra("app_uid", Process.myUid());
        paramString.nextText();
      }
      else
      {
        jdField_a_of_type_AndroidContentIntent.putExtra((String)localObject, paramString.nextText());
      }
    }
  }
  
  private void a(ConfigurationService.RespGetConfig paramRespGetConfig, QQAppInterface paramQQAppInterface, Intent paramIntent, int[] paramArrayOfInt, boolean paramBoolean)
  {
    int i1;
    label55:
    int i2;
    long l1;
    ArrayList localArrayList;
    ConfigurationService.Config localConfig;
    Object localObject1;
    if ((!paramBoolean) || (paramRespGetConfig.result.get() != 0) || (paramRespGetConfig.config_list == null) || (paramRespGetConfig.config_list.size() == 0))
    {
      if (!paramBoolean)
      {
        if (QLog.isColorLevel()) {
          QLog.i("SPLASH_ConfigServlet", 2, "receiveAllConfigs|isSuccess == false");
        }
        i1 = 0;
        if (i1 >= paramArrayOfInt.length) {
          break label7390;
        }
        i2 = paramArrayOfInt[i1];
        if (QLog.isColorLevel()) {
          QLog.i("SPLASH_ConfigServlet", 2, "receiveAllConfigs|failed type: " + i2);
        }
        switch (i2)
        {
        }
      }
      for (;;)
      {
        i1 += 1;
        break label55;
        if (paramRespGetConfig.result.get() != 0)
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("SPLASH_ConfigServlet", 2, "receiveAllConfigs|resultCode != 0");
          break;
        }
        if (((paramRespGetConfig.config_list != null) && (paramRespGetConfig.config_list.size() != 0)) || (!QLog.isColorLevel())) {
          break;
        }
        QLog.i("SPLASH_ConfigServlet", 2, "receiveAllConfigs|config_list empty data");
        break;
        if (paramRespGetConfig.result.get() != 0)
        {
          StatisticCollector.a(BaseApplicationImpl.a()).a(paramQQAppInterface.f(), "actNvwaConfig", 101, "");
        }
        else if (((paramRespGetConfig.config_list == null) || (paramRespGetConfig.config_list.size() == 0)) && (SharedPreUtils.k(paramQQAppInterface.getApplication()) > 0))
        {
          ((HotPatchManager)paramQQAppInterface.getManager(119)).a(false);
          continue;
          if ((!paramBoolean) || (paramRespGetConfig.result.get() != 0))
          {
            paramIntent = (PasswdRedBagManager)paramQQAppInterface.getManager(124);
            paramIntent.jdField_a_of_type_Boolean = true;
            paramIntent.jdField_b_of_type_Boolean = MessageForFoldMsgGrayTips.PASSWD_REDBAG_MSG_SWITCH_DEFAULT;
            paramIntent.j = MessageForFoldMsgGrayTips.PASSWD_REDBAG_MSG_DISPLAY_NUM_DEFAULT;
            SharedPreUtils.a(paramQQAppInterface.a(), paramQQAppInterface.getAccount(), 0, paramIntent.jdField_b_of_type_Boolean, paramIntent.j);
            continue;
            HYConfigLoader.a().a(paramQQAppInterface, null, 0);
            continue;
            OfficeCenterConfigLoader.a().a(paramQQAppInterface, null, 0);
            continue;
            if (!paramBoolean)
            {
              OlympicServlet.a(paramQQAppInterface, 88, 0, 0, 1, 1, 0);
              if (QLog.isColorLevel()) {
                QLog.d("ArConfig_configServlet", 2, "handleResp_GetArEntranceConfig||isSuccess =" + paramBoolean);
              }
            }
            else if (paramRespGetConfig.result.get() != 0)
            {
              i2 = paramRespGetConfig.result.get();
              OlympicServlet.a(paramQQAppInterface, 88, 0, 0, 1, i2, 0);
              if (QLog.isColorLevel()) {
                QLog.d("ArConfig_configServlet", 2, "handleResp_GetArEntranceConfig||result =" + i2);
              }
            }
            else if (((paramRespGetConfig.config_list == null) || (paramRespGetConfig.config_list.size() == 0)) && (QLog.isColorLevel()))
            {
              QLog.d("ArConfig_configServlet", 2, "handleResp_GetArEntranceConfig||config_list is null");
              continue;
              if (!paramBoolean)
              {
                OlympicServlet.a(paramQQAppInterface, 87, 0, 0, 1, 1, 0);
                if (QLog.isColorLevel()) {
                  QLog.d("ArConfig_configServlet", 2, "handleResp_GetArResource||isSuccess =" + paramBoolean);
                }
              }
              for (;;)
              {
                paramIntent = (ArResourceManager)paramQQAppInterface.getManager(167);
                if (paramIntent == null) {
                  break;
                }
                paramIntent.a(true, false);
                break;
                if (paramRespGetConfig.result.get() != 0)
                {
                  i2 = paramRespGetConfig.result.get();
                  OlympicServlet.a(paramQQAppInterface, 87, 0, 0, 1, i2, 0);
                  if (QLog.isColorLevel()) {
                    QLog.d("ArConfig_configServlet", 2, "handleResp_GetArResource||result =" + i2);
                  }
                }
                else if (((paramRespGetConfig.config_list == null) || (paramRespGetConfig.config_list.size() == 0)) && (QLog.isColorLevel()))
                {
                  QLog.d("ArConfig_configServlet", 2, "handleResp_GetArResource||config_list is null");
                }
              }
              if (!paramBoolean)
              {
                OlympicServlet.a(getAppRuntime(), 86, 0, 0, 1, 1, 0);
                if (QLog.isColorLevel()) {
                  QLog.d("Olympic.configServlet", 2, "handleResp_GetOlympicActConfig||isSuccess =" + paramBoolean);
                }
              }
              for (;;)
              {
                paramIntent = (OlympicManager)paramQQAppInterface.getManager(166);
                if (paramIntent == null) {
                  break;
                }
                paramIntent.n();
                paramIntent.q();
                break;
                if (paramRespGetConfig.result.get() != 0)
                {
                  i2 = paramRespGetConfig.result.get();
                  OlympicServlet.a(getAppRuntime(), 86, 0, 0, 1, i2, 0);
                  if (QLog.isColorLevel()) {
                    QLog.d("Olympic.configServlet", 2, "handleResp_GetOlympicActConfig||result =" + i2);
                  }
                }
                else if (((paramRespGetConfig.config_list == null) || (paramRespGetConfig.config_list.size() == 0)) && (QLog.isColorLevel()))
                {
                  QLog.d("Olympic.configServlet", 2, "handleResp_GetOlympicActConfig||config_list is null");
                }
              }
              if (QLog.isColorLevel()) {
                QLog.d("SPLASH_ConfigServlet", 2, "precover PRECOVER_CONFIG_CMD, failed");
              }
              paramIntent = (PrecoverManager)paramQQAppInterface.getManager(178);
              if (paramIntent != null)
              {
                paramIntent.a();
                paramIntent.a(false);
              }
            }
          }
        }
      }
    }
    else
    {
      l1 = System.currentTimeMillis();
      int i3 = paramRespGetConfig.config_list.size();
      localArrayList = new ArrayList(paramArrayOfInt.length);
      i1 = 0;
      while (i1 < paramArrayOfInt.length)
      {
        localArrayList.add(Integer.valueOf(paramArrayOfInt[i1]));
        i1 += 1;
      }
      i2 = 0;
      if (i2 >= i3) {
        break label7589;
      }
      localConfig = (ConfigurationService.Config)paramRespGetConfig.config_list.get(i2);
      if (localConfig == null) {}
      for (;;)
      {
        i2 += 1;
        break;
        if (localConfig.type.has())
        {
          paramArrayOfInt = new Integer(localConfig.type.get());
          localArrayList.remove(paramArrayOfInt);
          if (QLog.isColorLevel()) {
            QLog.i("SPLASH_ConfigServlet", 2, "receiveAllConfigs|receive type: " + paramArrayOfInt + ", length: " + i3);
          }
          switch (paramArrayOfInt.intValue())
          {
          case 4: 
          case 7: 
          case 8: 
          case 9: 
          case 11: 
          case 14: 
          case 15: 
          case 16: 
          case 19: 
          case 20: 
          case 21: 
          case 22: 
          case 24: 
          case 25: 
          case 27: 
          case 29: 
          case 30: 
          case 36: 
          case 37: 
          case 39: 
          case 40: 
          case 41: 
          case 45: 
          case 48: 
          case 51: 
          case 52: 
          case 58: 
          case 59: 
          case 71: 
          case 77: 
          case 89: 
          case 98: 
          case 100: 
          case 103: 
          case 105: 
          case 107: 
          case 112: 
          case 114: 
          case 116: 
          case 117: 
          case 119: 
          default: 
            break;
          case 1: 
            if ((localConfig.content_list != null) && (localConfig.content_list.size() > 0))
            {
              paramArrayOfInt = new File(getAppRuntime().getApplication().getFilesDir().getAbsolutePath() + "/" + "splashpic");
              if (!paramArrayOfInt.exists()) {
                paramArrayOfInt.mkdirs();
              }
            }
          case 44: 
          case 47: 
          case 65: 
            while ((paramArrayOfInt == null) || (!paramArrayOfInt.isDirectory()))
            {
              paramArrayOfInt = localConfig.content_list.get().iterator();
              while (paramArrayOfInt.hasNext())
              {
                localObject1 = (String)paramArrayOfInt.next();
                if (QLog.isColorLevel()) {
                  QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 1,content: " + (String)localObject1 + ",version: " + localConfig.version.get());
                }
                h((String)localObject1, localConfig.version.get());
                if (QLog.isColorLevel()) {
                  QLog.i("SPLASH_ConfigServlet", 2, "onreceive cmd==1 version_back is " + localConfig.version.get());
                }
              }
              if ((localConfig.content_list != null) && (localConfig.content_list.size() > 0))
              {
                SharedPreUtils.i(getAppRuntime().getApplication(), localConfig.version.get(), h);
                i1 = 0;
                while (i1 < localConfig.content_list.size())
                {
                  paramArrayOfInt = (String)localConfig.content_list.get(i1);
                  if (QLog.isColorLevel()) {
                    QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 44,content: " + paramArrayOfInt + ",version: " + localConfig.version.get());
                  }
                  if (!TextUtils.isEmpty(paramArrayOfInt)) {
                    ((HotChatManager)paramQQAppInterface.getManager(59)).d(paramArrayOfInt);
                  }
                  i1 += 1;
                }
              }
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 44content_list is emtpy,version: " + localConfig.version.get());
              break;
              if ((localConfig.content_list != null) && (localConfig.content_list.size() > 0))
              {
                SharedPreUtils.g(getAppRuntime().getApplication(), localConfig.version.get(), h);
                i1 = 0;
                while (i1 < localConfig.content_list.size())
                {
                  paramArrayOfInt = (String)localConfig.content_list.get(i1);
                  if (QLog.isColorLevel()) {
                    QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 47,content: " + paramArrayOfInt + ",version: " + localConfig.version.get());
                  }
                  if (!TextUtils.isEmpty(paramArrayOfInt)) {
                    ((SmartDeviceProxyMgr)paramQQAppInterface.a(51)).a(paramArrayOfInt, false);
                  }
                  i1 += 1;
                }
              }
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 47content_list is emtpy,version: " + localConfig.version.get());
              break;
              if (localConfig.version == null) {
                break;
              }
              SharedPreUtils.h(getAppRuntime().getApplication(), localConfig.version.get(), h);
              ((SmartDeviceProxyMgr)paramQQAppInterface.a(51)).a(localConfig);
              break;
            }
            paramArrayOfInt = paramArrayOfInt.listFiles();
            int i4 = paramArrayOfInt.length;
            i1 = 0;
            while (i1 < i4)
            {
              localObject1 = paramArrayOfInt[i1];
              if ((localObject1 != null) && (((File)localObject1).exists())) {
                ((File)localObject1).delete();
              }
              i1 += 1;
            }
            if (QLog.isColorLevel()) {
              QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 1,content_list is empty ,version: " + localConfig.version.get());
            }
            paramArrayOfInt = new File(getAppRuntime().getApplication().getFilesDir().getAbsolutePath() + "/" + "flashlogo.png");
            if (paramArrayOfInt != null) {
              paramArrayOfInt.delete();
            }
            SharedPreUtils.a(getAppRuntime().getApplication(), localConfig.version.get(), "1|2", "");
            break;
          case 2: 
            if ((localConfig.content_list != null) && (localConfig.content_list.size() > 0))
            {
              Config.a.b();
              paramArrayOfInt = localConfig.content_list.get().iterator();
              while (paramArrayOfInt.hasNext())
              {
                localObject1 = (String)paramArrayOfInt.next();
                if (QLog.isColorLevel()) {
                  QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 2,content: " + (String)localObject1 + ",version: " + localConfig.version.get());
                }
                f((String)localObject1, localConfig.version.get());
              }
              paramArrayOfInt = new ConfigManager(getAppRuntime().getApplication(), h);
              if (paramArrayOfInt != null)
              {
                paramArrayOfInt.b();
                paramArrayOfInt.c();
              }
              paramArrayOfInt = BaseApplication.getContext().getSharedPreferences("mobileQQ", 0);
              paramArrayOfInt.edit().putBoolean("reveive_newpb" + getAppRuntime().getAccount(), true).commit();
              paramArrayOfInt.edit().putBoolean("push_banner_display" + getAppRuntime().getAccount(), true).commit();
              SharedPreUtils.i(getAppRuntime().getApplication(), localConfig.version.get(), h);
              if (QLog.isColorLevel()) {
                QLog.i("SPLASH_ConfigServlet", 2, "pushbanner onreceive cmd==2 version_back is " + localConfig.version.get());
              }
            }
            else
            {
              if (QLog.isColorLevel()) {
                QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 2,content_list is empty ,version: " + localConfig.version.get());
              }
              Config.a.b();
              Config.a.c();
              paramArrayOfInt = new ConfigManager(getAppRuntime().getApplication(), h);
              if (paramArrayOfInt != null)
              {
                paramArrayOfInt.b();
                paramArrayOfInt.c();
              }
              BaseApplication.getContext().getSharedPreferences("mobileQQ", 0).edit().putBoolean("push_banner_display" + getAppRuntime().getAccount(), false).commit();
              SharedPreUtils.i(getAppRuntime().getApplication(), localConfig.version.get(), h);
            }
            break;
          case 3: 
            if ((localConfig.content_list != null) && (localConfig.content_list.size() > 0))
            {
              paramArrayOfInt = (String)localConfig.content_list.get(0);
              if (QLog.isColorLevel()) {
                QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 3,content: " + paramArrayOfInt + ",version: " + localConfig.version.get());
              }
              g(paramArrayOfInt, localConfig.version.get());
            }
            else
            {
              if (QLog.isColorLevel()) {
                QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 3,content_list is empty ,version: " + localConfig.version.get());
              }
              paramArrayOfInt = new File(getAppRuntime().getApplication().getFilesDir().getAbsolutePath() + "/" + h + "/" + "birthdayflashlogo.png");
              if (paramArrayOfInt.exists()) {
                paramArrayOfInt.delete();
              }
              SharedPreUtils.b(getAppRuntime().getApplication(), localConfig.version.get(), "", h);
            }
            break;
          case 5: 
            if ((localConfig.content_list != null) && (localConfig.content_list.size() > 0))
            {
              paramArrayOfInt = new ArrayList();
              i1 = 0;
              while (i1 < localConfig.content_list.size())
              {
                localObject1 = (String)localConfig.content_list.get(i1);
                if (QLog.isColorLevel()) {
                  QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 5,content: " + (String)localObject1 + ",version: " + localConfig.version.get());
                }
                localObject1 = a((String)localObject1);
                if (localObject1 != null) {
                  paramArrayOfInt.add(localObject1);
                }
                i1 += 1;
              }
              QQOperateManager.a((QQAppInterface)getAppRuntime()).a((QQAppInterface)getAppRuntime(), paramArrayOfInt);
              SharedPreUtils.a(getAppRuntime().getApplication(), getAppRuntime().getAccount(), localConfig.version.get());
            }
            else if (QLog.isColorLevel())
            {
              QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 5,content_list is empty ,version: " + localConfig.version.get());
            }
            break;
          case 12: 
            paramArrayOfInt = (NearbyBannerManager)paramQQAppInterface.getManager(73);
            Object localObject2 = paramArrayOfInt.a();
            localObject1 = new PicAndAdConf((short)21, (byte)2);
            Iterator localIterator;
            if ((localConfig.content_list != null) && (localConfig.content_list.size() > 0)) {
              localIterator = localConfig.content_list.get().iterator();
            }
            while (localIterator.hasNext())
            {
              String str = (String)localIterator.next();
              if (QLog.isColorLevel()) {
                QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 12,content: " + str + ",version: " + localConfig.version.get());
              }
              a((PicAndAdConf)localObject1, str, (Set)localObject2);
              continue;
              if (QLog.isColorLevel()) {
                QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 12,content_list is empty ,version: " + localConfig.version.get());
              }
            }
            if (QLog.isColorLevel())
            {
              localObject2 = new StringBuilder().append("NearbyBanner onreceive, content count = ");
              if (localConfig.content_list != null) {
                break label3758;
              }
            }
            for (i1 = 0;; i1 = localConfig.content_list.get().size())
            {
              QLog.i("SPLASH_ConfigServlet", 2, i1 + " , item count = " + ((PicAndAdConf)localObject1).b() + ", version = " + localConfig.version.get());
              paramArrayOfInt.a((PicAndAdConf)localObject1, localConfig.version.get());
              break;
            }
          case 55: 
            if ((localConfig.content_list != null) && (localConfig.content_list.size() > 0))
            {
              if (QLog.isColorLevel()) {
                QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 55,content: " + (String)localConfig.content_list.get(0) + ",version: " + localConfig.version.get());
              }
              ((BlessManager)paramQQAppInterface.getManager(137)).a((String)localConfig.content_list.get(0));
              SharedPreUtils.b(getAppRuntime().getApplication(), getAppRuntime().getAccount(), localConfig.version.get());
            }
            else if (QLog.isColorLevel())
            {
              QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 55,content_list is empty ,version: " + localConfig.version.get());
            }
            break;
          case 10: 
            localObject1 = null;
            paramArrayOfInt = (int[])localObject1;
            if (localConfig.content_list != null)
            {
              paramArrayOfInt = (int[])localObject1;
              if (localConfig.content_list.size() > 0) {
                paramArrayOfInt = localConfig.content_list.get();
              }
            }
            if ((paramArrayOfInt != null) && (paramArrayOfInt.size() > 0))
            {
              paramArrayOfInt = (String)paramArrayOfInt.get(0);
              if (QLog.isColorLevel()) {
                QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 10,content: " + paramArrayOfInt + ",version: " + localConfig.version.get());
              }
              BmqqSegmentUtil.a(paramArrayOfInt);
            }
            for (;;)
            {
              i1 = localConfig.version.get();
              SharedPreUtils.d(getAppRuntime().getApplication(), i1);
              break;
              BmqqSegmentUtil.a(null);
              if (QLog.isColorLevel()) {
                QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 10,content_list is empty ,version: " + localConfig.version.get());
              }
            }
          case 13: 
            BridgeHelper.a(BaseApplication.getContext(), paramQQAppInterface.getAccount()).a(localConfig);
            break;
          case 101: 
            i(paramIntent, localConfig);
            break;
          case 115: 
            h(paramIntent, localConfig);
            break;
          case 34: 
            k(localConfig);
            break;
          case 102: 
            label3758:
            j(localConfig);
          }
        }
      }
      if ((localConfig.content_list != null) && (localConfig.content_list.size() > 0))
      {
        paramArrayOfInt = (String)localConfig.content_list.get(0);
        i1 = localConfig.version.get();
        if (!QLog.isColorLevel()) {
          break label8254;
        }
        QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 62,content: " + paramArrayOfInt + ",version: " + localConfig.version.get());
      }
    }
    label5340:
    label6812:
    label7390:
    label7589:
    label8251:
    label8254:
    for (;;)
    {
      OfficeCenterConfigLoader.a().a(paramQQAppInterface, paramArrayOfInt, i1);
      break;
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 62,content_list is empty ,version: " + localConfig.version.get());
      }
      i1 = 0;
      paramArrayOfInt = null;
      continue;
      if ((localConfig.content_list != null) && (localConfig.content_list.size() > 0))
      {
        paramArrayOfInt = (String)localConfig.content_list.get(0);
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 17,content: " + paramArrayOfInt + ",version: " + localConfig.version.get());
        }
        i1 = localConfig.version.get();
      }
      for (;;)
      {
        HYConfigLoader.a().a(paramQQAppInterface, paramArrayOfInt, i1);
        break;
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 17,content_list is empty ,version: " + localConfig.version.get());
        }
        i1 = 0;
        paramArrayOfInt = null;
      }
      if ((localConfig.content_list != null) && (localConfig.content_list.size() > 0))
      {
        paramArrayOfInt = (String)localConfig.content_list.get(0);
        i1 = localConfig.version.get();
        paramQQAppInterface.a().a(paramQQAppInterface, paramArrayOfInt, i1);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 31,content: " + paramArrayOfInt + ",version: " + localConfig.version.get());
        break;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 31,content_list is empty ,version: " + localConfig.version.get());
      break;
      if ((localConfig.content_list != null) && (localConfig.content_list.size() > 0))
      {
        paramArrayOfInt = (ClubContentUpdateHandler)paramQQAppInterface.a(16);
        if (paramArrayOfInt != null) {
          paramArrayOfInt.a(paramQQAppInterface, (String)localConfig.content_list.get(0), localConfig.version.get());
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 26,content: " + (String)localConfig.content_list.get(0) + ",version: " + localConfig.version.get());
        break;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 26,content_list is empty ,version: " + localConfig.version.get());
      break;
      if ((localConfig.content_list != null) && (localConfig.content_list.size() > 0))
      {
        paramArrayOfInt = (String)localConfig.content_list.get(0);
        i1 = localConfig.version.get();
        AioVipKeywordHelper.a().a(paramQQAppInterface.getApplication(), paramArrayOfInt, paramQQAppInterface.a(), i1);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 76,content: " + paramArrayOfInt + ",version: " + i1);
        break;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 76,content_list is empty ,version: " + localConfig.version.get());
      break;
      paramArrayOfInt = (IndividuationABTestManager)paramQQAppInterface.getManager(176);
      if ((localConfig.content_list != null) && (localConfig.content_list.size() > 0))
      {
        localObject1 = (String)localConfig.content_list.get(0);
        i1 = localConfig.version.get();
        paramArrayOfInt.a((String)localObject1, paramQQAppInterface.a(), i1);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 94,content: " + (String)localObject1 + ",version: " + i1);
        break;
      }
      paramArrayOfInt.a(localConfig.version.get(), paramQQAppInterface.a());
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 94,content_list is empty ,version: " + localConfig.version.get());
      break;
      try
      {
        if ((localConfig.content_list == null) || (localConfig.content_list.size() <= 0)) {
          break label5340;
        }
        paramArrayOfInt = localConfig.content_list.get().iterator();
        while (paramArrayOfInt.hasNext())
        {
          localObject1 = (String)paramArrayOfInt.next();
          if (QLog.isColorLevel()) {
            QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 18,content: " + (String)localObject1 + ",version: " + localConfig.version.get());
          }
          e((String)localObject1, localConfig.version.get());
        }
      }
      catch (Exception paramArrayOfInt)
      {
        if (QLog.isColorLevel()) {
          QLog.e("SPLASH_ConfigServlet", 2, "error: " + paramArrayOfInt.toString());
        }
        paramArrayOfInt.printStackTrace();
      }
      paramQQAppInterface.y();
      for (i1 = 0; i1 != 0; i1 = 1)
      {
        LightTalkTipsData.b();
        LightalkBlueTipsBarData.b();
        break;
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 18,content_list is empty ,version: " + localConfig.version.get());
        }
      }
      g(paramIntent, localConfig);
      break;
      c(paramIntent, localConfig);
      break;
      d(paramIntent, localConfig);
      break;
      f(paramIntent, localConfig);
      break;
      e(paramIntent, localConfig);
      break;
      try
      {
        if ((localConfig.content_list == null) || (localConfig.content_list.size() <= 0)) {
          break;
        }
        paramArrayOfInt = localConfig.content_list.get().iterator();
        while (paramArrayOfInt.hasNext())
        {
          localObject1 = (String)paramArrayOfInt.next();
          if (QLog.isColorLevel()) {
            QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 28,content: " + (String)localObject1 + ",version: " + localConfig.version.get());
          }
          i((String)localObject1, localConfig.version.get());
        }
      }
      catch (Exception paramArrayOfInt)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 28,content_list is empty ,version: " + localConfig.version.get());
        }
        paramArrayOfInt.printStackTrace();
      }
      l(localConfig);
      break;
      m(localConfig);
      break;
      try
      {
        i1 = localConfig.version.get();
        if (i1 != SharedPreUtils.q(paramQQAppInterface.a(), h))
        {
          AIOJumpLightalkConfig.a(h);
          PCJumpLightalkConfig.a(h);
          CLJumpLightalkConfig.a(h);
          CallTabLightalkConfig.a(h);
          QQCallLightalkConfig.a(h);
          SharedPreUtils.n(getAppRuntime().getApplication(), i1, h);
        }
        if ((localConfig.content_list != null) && (localConfig.content_list.size() > 0))
        {
          paramArrayOfInt = localConfig.content_list.get().iterator();
          while (paramArrayOfInt.hasNext())
          {
            localObject1 = (String)paramArrayOfInt.next();
            if (QLog.isColorLevel()) {
              QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 33,content: " + (String)localObject1 + ",version: " + localConfig.version.get());
            }
            b((String)localObject1, localConfig.version.get());
          }
        }
      }
      catch (Exception paramArrayOfInt)
      {
        if (QLog.isColorLevel()) {
          QLog.e("SPLASH_ConfigServlet", 2, "error: " + paramArrayOfInt.toString());
        }
        paramArrayOfInt.printStackTrace();
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 33,content_list is empty ,version: " + localConfig.version.get());
      break;
      try
      {
        if ((localConfig.content_list != null) && (localConfig.content_list.size() > 0))
        {
          paramArrayOfInt = localConfig.content_list.get().iterator();
          while (paramArrayOfInt.hasNext())
          {
            localObject1 = (String)paramArrayOfInt.next();
            if (QLog.isColorLevel()) {
              QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 38,content: " + (String)localObject1 + ",version: " + localConfig.version.get());
            }
            c((String)localObject1, localConfig.version.get());
          }
        }
      }
      catch (Exception paramArrayOfInt)
      {
        if (QLog.isColorLevel()) {
          QLog.e("SPLASH_ConfigServlet", 2, "qav_upgrade_invite error: " + paramArrayOfInt.toString());
        }
        paramArrayOfInt.printStackTrace();
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 38,content_list is empty ,version: " + localConfig.version.get());
      break;
      try
      {
        if ((localConfig.content_list != null) && (localConfig.content_list.size() > 0))
        {
          paramArrayOfInt = localConfig.content_list.get().iterator();
          while (paramArrayOfInt.hasNext())
          {
            localObject1 = (String)paramArrayOfInt.next();
            if (QLog.isColorLevel()) {
              QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 93,content: " + (String)localObject1 + ",version: " + localConfig.version.get());
            }
            d((String)localObject1, localConfig.version.get());
          }
        }
      }
      catch (Exception paramArrayOfInt)
      {
        if (QLog.isColorLevel()) {
          QLog.e("SPLASH_ConfigServlet", 2, "qav_anychat_time_limit_error: " + paramArrayOfInt.toString());
        }
        paramArrayOfInt.printStackTrace();
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 93,content_list is empty ,version: " + localConfig.version.get());
      break;
      s(localConfig);
      break;
      p(localConfig);
      break;
      q(localConfig);
      break;
      r(localConfig);
      break;
      w(localConfig);
      break;
      u(localConfig);
      break;
      f(localConfig);
      break;
      t(localConfig);
      break;
      v(localConfig);
      break;
      e(localConfig);
      break;
      try
      {
        if ((localConfig.content_list != null) && (localConfig.content_list.size() > 0))
        {
          paramArrayOfInt = localConfig.content_list.get().iterator();
          while (paramArrayOfInt.hasNext())
          {
            localObject1 = (String)paramArrayOfInt.next();
            if (QLog.isColorLevel()) {
              QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 57,content: " + (String)localObject1 + ",version: " + localConfig.version.get());
            }
            j((String)localObject1, localConfig.version.get());
          }
        }
      }
      catch (Exception paramArrayOfInt)
      {
        if (QLog.isColorLevel()) {
          QLog.e("SPLASH_ConfigServlet", 2, "error: " + paramArrayOfInt.toString());
        }
        paramArrayOfInt.printStackTrace();
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 57,content_list is empty ,version: " + localConfig.version.get());
      break;
      n(localConfig);
      break;
      try
      {
        if ((localConfig.content_list == null) || (localConfig.content_list.size() <= 0)) {
          break label6812;
        }
        paramArrayOfInt = (String)localConfig.content_list.get(0);
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 67,content: " + paramArrayOfInt + ",version: " + localConfig.version.get());
        }
        FileUtils.a(ApolloConstant.j + "/apolloConfig.json", paramArrayOfInt);
        a(paramArrayOfInt, localConfig.version.get());
      }
      catch (Exception paramArrayOfInt)
      {
        if (QLog.isColorLevel()) {
          QLog.e("SPLASH_ConfigServlet", 2, "error: " + paramArrayOfInt.toString());
        }
        paramArrayOfInt.printStackTrace();
      }
      break;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 67,content_list is empty ,version: " + localConfig.version.get());
      break;
      c(localConfig);
      break;
      b(localConfig, paramQQAppInterface);
      break;
      d(localConfig);
      break;
      z(localConfig);
      break;
      A(localConfig);
      break;
      B(localConfig);
      break;
      C(localConfig);
      break;
      o(localConfig);
      break;
      x(localConfig);
      break;
      y(localConfig);
      break;
      DeviceProfileManager.a().a(paramRespGetConfig, "");
      break;
      h(localConfig);
      break;
      i(localConfig);
      break;
      a(localConfig);
      break;
      b(localConfig);
      break;
      g(localConfig);
      break;
      D(localConfig);
      break;
      E(localConfig);
      break;
      F(localConfig);
      break;
      if ((localConfig.content_list != null) && (localConfig.content_list.size() > 0))
      {
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: " + paramArrayOfInt + ",content: " + (String)localConfig.content_list.get(0) + ",version: " + localConfig.version.get());
        }
        if (!((PhotoPlusManager)paramQQAppInterface.getManager(168)).a((String)localConfig.content_list.get(0))) {
          break;
        }
        SharedPreUtils.n(getAppRuntime().getApplication(), getAppRuntime().getAccount(), localConfig.version.get());
        break;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: " + paramArrayOfInt + ",content_list is empty " + ",version: " + localConfig.version.get());
      break;
      a(localConfig, paramQQAppInterface);
      break;
      a(paramIntent, paramBoolean, localConfig, paramRespGetConfig.result.get());
      break;
      b(paramIntent, localConfig);
      break;
      a(paramIntent, localConfig);
      break;
      g(paramQQAppInterface, localConfig);
      break;
      b(paramQQAppInterface, localConfig);
      break;
      f(paramQQAppInterface, localConfig);
      break;
      if ((localConfig.msg_content_list != null) && (localConfig.msg_content_list.size() > 0))
      {
        paramArrayOfInt = ((ConfigurationService.Content)localConfig.msg_content_list.get(0)).content.get().toByteArray();
        if (((ConfigurationService.Content)localConfig.msg_content_list.get(0)).compress.get() != 1) {
          break label8251;
        }
        paramArrayOfInt = ArConfigUtils.a(paramArrayOfInt);
      }
      for (;;)
      {
        if (paramArrayOfInt == null) {}
        for (;;)
        {
          return;
          for (;;)
          {
            try
            {
              paramArrayOfInt = new String(paramArrayOfInt, "utf-8");
              if (QLog.isColorLevel()) {
                QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 99,content: " + paramArrayOfInt + ",version: " + localConfig.version.get());
              }
              i1 = localConfig.version.get();
              MagicfaceManagerForAV.a().a(paramArrayOfInt);
              SharedPreUtils.b(paramQQAppInterface.getApplication(), i1);
              e(paramQQAppInterface, localConfig);
            }
            catch (UnsupportedEncodingException paramRespGetConfig)
            {
              paramRespGetConfig.printStackTrace();
              return;
            }
            if (QLog.isColorLevel()) {
              QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 99,content_list is empty ,version: " + localConfig.version.get());
            }
          }
          a(paramQQAppInterface, localConfig);
          break;
          b(paramIntent, paramBoolean, localConfig, paramRespGetConfig.result.get());
          break;
          d(paramQQAppInterface, localConfig);
          break;
          c(paramQQAppInterface, localConfig);
          break;
          long l2 = System.currentTimeMillis();
          if (QLog.isColorLevel()) {
            QLog.w("SPLASH_ConfigServlet", 2, "receiveAllConfigs|executeSpendTime: " + (l2 - l1));
          }
          paramRespGetConfig = localArrayList.iterator();
          while (paramRespGetConfig.hasNext())
          {
            paramIntent = (Integer)paramRespGetConfig.next();
            if (QLog.isColorLevel()) {
              QLog.w("SPLASH_ConfigServlet", 2, "receiveAllConfigs|noReceiveType: " + paramIntent + ",length: " + localArrayList.size());
            }
            switch (paramIntent.intValue())
            {
            default: 
              break;
            case 1: 
              paramIntent = getAppRuntime().getApplication().getFilesDir().getAbsolutePath() + "/" + "splashpic/";
              paramArrayOfInt = new File(paramIntent);
              if ((paramArrayOfInt != null) && (paramArrayOfInt.exists()) && (paramArrayOfInt.isDirectory()))
              {
                paramArrayOfInt = paramArrayOfInt.listFiles();
                if (paramArrayOfInt != null)
                {
                  i2 = paramArrayOfInt.length;
                  i1 = 0;
                  while (i1 < i2)
                  {
                    ThreadManager.a(new rao(this, paramArrayOfInt[i1], paramIntent), 5, null, true);
                    i1 += 1;
                  }
                }
              }
              break;
            case 46: 
              if (SharedPreUtils.k(paramQQAppInterface.getApplication()) > 0) {
                ((HotPatchManager)paramQQAppInterface.getManager(119)).a(false);
              }
              break;
            case 26: 
              paramIntent = (ClubContentUpdateHandler)paramQQAppInterface.a(16);
              if (paramIntent != null) {
                paramIntent.a(paramQQAppInterface.getApplication().getApplicationContext());
              }
              break;
            case 38: 
              paramIntent = SharedPreUtils.d(paramQQAppInterface.a());
              paramIntent.edit().putString("qav_upgrade_invite_video", null).commit();
              paramIntent.edit().putString("qav_upgrade_invite_multi", null).commit();
              break;
            case 69: 
              paramIntent = (PasswdRedBagManager)paramQQAppInterface.getManager(124);
              paramIntent.jdField_a_of_type_Boolean = true;
              paramIntent.jdField_b_of_type_Boolean = MessageForFoldMsgGrayTips.PASSWD_REDBAG_MSG_SWITCH_DEFAULT;
              paramIntent.j = MessageForFoldMsgGrayTips.PASSWD_REDBAG_MSG_DISPLAY_NUM_DEFAULT;
              SharedPreUtils.a(paramQQAppInterface.a(), paramQQAppInterface.getAccount(), 0, paramIntent.jdField_b_of_type_Boolean, paramIntent.j);
              break;
            case 17: 
              HYConfigLoader.a().a(paramQQAppInterface, null, 0);
              break;
            case 62: 
              OfficeCenterConfigLoader.a().a(paramQQAppInterface, null, 0);
              break;
            case 87: 
              paramIntent = (ArResourceManager)paramQQAppInterface.getManager(167);
              if (paramIntent != null) {
                paramIntent.a(true, false);
              }
              if (QLog.isColorLevel()) {
                QLog.d("ArConfig_configServlet", 2, "handleResp_GetArResource:no receive respConfig");
              }
              break;
            case 86: 
              paramIntent = (OlympicManager)paramQQAppInterface.getManager(166);
              if (paramIntent != null)
              {
                paramIntent.n();
                paramIntent.q();
              }
              if (QLog.isColorLevel()) {
                QLog.d("Olympic.configServlet", 2, "handleResp_GetOlympicActConfig: no receive respConfig");
              }
              break;
            case 42: 
              s(null);
              break;
            case 113: 
              if (QLog.isColorLevel()) {
                QLog.d("SPLASH_ConfigServlet", 2, "precover PRECOVER_CONFIG_CMD, failed");
              }
              paramIntent = (PrecoverManager)paramQQAppInterface.getManager(178);
              if (paramIntent != null)
              {
                paramIntent.a();
                paramIntent.a(true);
              }
              break;
            }
          }
        }
      }
    }
  }
  
  private void a(File paramFile, String paramString1, String paramString2)
  {
    ThreadManager.d(new ras(this, paramFile, paramString1, paramString2));
  }
  
  /* Error */
  private void a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 224	com/tencent/mobileqq/config/splashlogo/ConfigServlet:getAppRuntime	()Lmqq/app/AppRuntime;
    //   4: checkcast 226	com/tencent/mobileqq/app/QQAppInterface
    //   7: sipush 142
    //   10: invokevirtual 313	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   13: checkcast 2235	com/tencent/mobileqq/qcall/PstnManager
    //   16: astore 11
    //   18: aload_1
    //   19: invokestatic 482	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   22: ifne +8 -> 30
    //   25: aload 11
    //   27: ifnonnull +13 -> 40
    //   30: ldc -111
    //   32: iconst_1
    //   33: ldc_w 2237
    //   36: invokestatic 1053	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   39: return
    //   40: aconst_null
    //   41: astore_2
    //   42: aconst_null
    //   43: astore 5
    //   45: aconst_null
    //   46: astore 10
    //   48: aconst_null
    //   49: astore 6
    //   51: aconst_null
    //   52: astore 9
    //   54: iconst_m1
    //   55: istore 15
    //   57: iconst_m1
    //   58: istore 14
    //   60: iconst_0
    //   61: istore 13
    //   63: aconst_null
    //   64: astore 7
    //   66: aconst_null
    //   67: astore 8
    //   69: iload 13
    //   71: istore 18
    //   73: aload 9
    //   75: astore 4
    //   77: aload 10
    //   79: astore_3
    //   80: iload 14
    //   82: istore 17
    //   84: iload 15
    //   86: istore 16
    //   88: invokestatic 1532	android/util/Xml:newPullParser	()Lorg/xmlpull/v1/XmlPullParser;
    //   91: astore 12
    //   93: iload 13
    //   95: istore 18
    //   97: aload 9
    //   99: astore 4
    //   101: aload 10
    //   103: astore_3
    //   104: iload 14
    //   106: istore 17
    //   108: iload 15
    //   110: istore 16
    //   112: aload 12
    //   114: new 595	java/io/ByteArrayInputStream
    //   117: dup
    //   118: aload_1
    //   119: ldc_w 597
    //   122: invokevirtual 601	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   125: invokespecial 604	java/io/ByteArrayInputStream:<init>	([B)V
    //   128: ldc_w 597
    //   131: invokeinterface 1538 3 0
    //   136: iload 13
    //   138: istore 18
    //   140: aload 9
    //   142: astore 4
    //   144: aload 10
    //   146: astore_3
    //   147: iload 14
    //   149: istore 17
    //   151: iload 15
    //   153: istore 16
    //   155: aload 12
    //   157: invokeinterface 1541 1 0
    //   162: istore 22
    //   164: iconst_0
    //   165: istore 13
    //   167: aconst_null
    //   168: astore_1
    //   169: aload 6
    //   171: astore_2
    //   172: iload 13
    //   174: istore 21
    //   176: aload_1
    //   177: astore 6
    //   179: aload_2
    //   180: astore 5
    //   182: iload 14
    //   184: istore 18
    //   186: iload 15
    //   188: istore 20
    //   190: iload 22
    //   192: iconst_1
    //   193: if_icmpeq +765 -> 958
    //   196: iload 13
    //   198: istore 19
    //   200: aload_1
    //   201: astore 4
    //   203: aload_2
    //   204: astore_3
    //   205: iload 14
    //   207: istore 16
    //   209: iload 15
    //   211: istore 17
    //   213: aload 12
    //   215: invokeinterface 1544 1 0
    //   220: astore 5
    //   222: iload 22
    //   224: tableswitch	default:+24->248, 2:+69->293, 3:+4841->5065
    //   248: aload 7
    //   250: astore 6
    //   252: aload 8
    //   254: astore 5
    //   256: iload 13
    //   258: istore 18
    //   260: aload_1
    //   261: astore 4
    //   263: aload_2
    //   264: astore_3
    //   265: iload 14
    //   267: istore 17
    //   269: iload 15
    //   271: istore 16
    //   273: aload 12
    //   275: invokeinterface 1556 1 0
    //   280: istore 22
    //   282: aload 5
    //   284: astore 8
    //   286: aload 6
    //   288: astore 7
    //   290: goto -118 -> 172
    //   293: iload 13
    //   295: istore 19
    //   297: aload_1
    //   298: astore 4
    //   300: aload_2
    //   301: astore_3
    //   302: iload 14
    //   304: istore 16
    //   306: iload 15
    //   308: istore 17
    //   310: aload 5
    //   312: ldc_w 2239
    //   315: invokevirtual 1549	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   318: ifeq +209 -> 527
    //   321: iload 13
    //   323: istore 19
    //   325: aload_1
    //   326: astore 4
    //   328: aload_2
    //   329: astore_3
    //   330: iload 14
    //   332: istore 16
    //   334: iload 15
    //   336: istore 17
    //   338: aload 12
    //   340: iconst_0
    //   341: invokeinterface 2241 2 0
    //   346: astore 5
    //   348: iload 13
    //   350: istore 19
    //   352: aload_1
    //   353: astore 4
    //   355: aload_2
    //   356: astore_3
    //   357: iload 14
    //   359: istore 16
    //   361: iload 15
    //   363: istore 17
    //   365: aload 5
    //   367: invokestatic 482	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   370: ifne +4824 -> 5194
    //   373: iload 13
    //   375: istore 19
    //   377: aload_1
    //   378: astore 4
    //   380: aload_2
    //   381: astore_3
    //   382: iload 14
    //   384: istore 16
    //   386: iload 15
    //   388: istore 17
    //   390: aload 5
    //   392: ldc_w 1546
    //   395: invokevirtual 1549	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   398: ifeq +35 -> 433
    //   401: iload 13
    //   403: istore 19
    //   405: aload_1
    //   406: astore 4
    //   408: aload_2
    //   409: astore_3
    //   410: iload 14
    //   412: istore 16
    //   414: iload 15
    //   416: istore 17
    //   418: new 2243	com/tencent/mobileqq/qcall/PstnSwitchConfig
    //   421: dup
    //   422: invokespecial 2244	com/tencent/mobileqq/qcall/PstnSwitchConfig:<init>	()V
    //   425: astore 5
    //   427: aload 5
    //   429: astore_2
    //   430: goto +4764 -> 5194
    //   433: iload 13
    //   435: istore 19
    //   437: aload_1
    //   438: astore 4
    //   440: aload_2
    //   441: astore_3
    //   442: iload 14
    //   444: istore 16
    //   446: iload 15
    //   448: istore 17
    //   450: aload 5
    //   452: ldc_w 2246
    //   455: invokevirtual 1549	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   458: ifeq +35 -> 493
    //   461: iload 13
    //   463: istore 19
    //   465: aload_1
    //   466: astore 4
    //   468: aload_2
    //   469: astore_3
    //   470: iload 14
    //   472: istore 16
    //   474: iload 15
    //   476: istore 17
    //   478: new 2248	java/util/HashMap
    //   481: dup
    //   482: invokespecial 2249	java/util/HashMap:<init>	()V
    //   485: astore 5
    //   487: aload 5
    //   489: astore_1
    //   490: goto +4704 -> 5194
    //   493: iload 13
    //   495: istore 19
    //   497: aload_1
    //   498: astore 4
    //   500: aload_2
    //   501: astore_3
    //   502: iload 14
    //   504: istore 16
    //   506: iload 15
    //   508: istore 17
    //   510: aload 5
    //   512: ldc_w 2251
    //   515: invokevirtual 1549	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   518: ifeq +4676 -> 5194
    //   521: iconst_1
    //   522: istore 13
    //   524: goto +4670 -> 5194
    //   527: iload 13
    //   529: istore 19
    //   531: aload_1
    //   532: astore 4
    //   534: aload_2
    //   535: astore_3
    //   536: iload 14
    //   538: istore 16
    //   540: iload 15
    //   542: istore 17
    //   544: aload 5
    //   546: ldc_w 2253
    //   549: invokevirtual 1549	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   552: ifeq +37 -> 589
    //   555: iload 13
    //   557: istore 19
    //   559: aload_1
    //   560: astore 4
    //   562: aload_2
    //   563: astore_3
    //   564: iload 14
    //   566: istore 16
    //   568: iload 15
    //   570: istore 17
    //   572: aload 12
    //   574: iconst_0
    //   575: invokeinterface 2241 2 0
    //   580: astore 6
    //   582: aload 8
    //   584: astore 5
    //   586: goto -330 -> 256
    //   589: iload 13
    //   591: istore 19
    //   593: aload_1
    //   594: astore 4
    //   596: aload_2
    //   597: astore_3
    //   598: iload 14
    //   600: istore 16
    //   602: iload 15
    //   604: istore 17
    //   606: aload 5
    //   608: ldc_w 2254
    //   611: invokevirtual 1549	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   614: ifeq +1407 -> 2021
    //   617: iload 13
    //   619: istore 19
    //   621: aload_1
    //   622: astore 4
    //   624: aload_2
    //   625: astore_3
    //   626: iload 14
    //   628: istore 16
    //   630: iload 15
    //   632: istore 17
    //   634: aload 7
    //   636: invokestatic 482	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   639: ifne +1134 -> 1773
    //   642: aload_2
    //   643: ifnull +1130 -> 1773
    //   646: iload 13
    //   648: istore 19
    //   650: aload_1
    //   651: astore 4
    //   653: aload_2
    //   654: astore_3
    //   655: iload 14
    //   657: istore 16
    //   659: iload 15
    //   661: istore 17
    //   663: aload 12
    //   665: iconst_0
    //   666: invokeinterface 2241 2 0
    //   671: astore 5
    //   673: iload 13
    //   675: istore 19
    //   677: aload_1
    //   678: astore 4
    //   680: aload_2
    //   681: astore_3
    //   682: iload 14
    //   684: istore 16
    //   686: iload 15
    //   688: istore 17
    //   690: aload 5
    //   692: invokestatic 482	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   695: ifne +4510 -> 5205
    //   698: iload 13
    //   700: istore 19
    //   702: aload_1
    //   703: astore 4
    //   705: aload_2
    //   706: astore_3
    //   707: iload 14
    //   709: istore 16
    //   711: iload 15
    //   713: istore 17
    //   715: aload 7
    //   717: ldc_w 2256
    //   720: invokevirtual 1549	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   723: ifeq +711 -> 1434
    //   726: iload 13
    //   728: istore 19
    //   730: aload_1
    //   731: astore 4
    //   733: aload_2
    //   734: astore_3
    //   735: iload 14
    //   737: istore 16
    //   739: iload 15
    //   741: istore 17
    //   743: aload 5
    //   745: ldc_w 2258
    //   748: invokevirtual 1549	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   751: ifeq +37 -> 788
    //   754: iload 13
    //   756: istore 19
    //   758: aload_1
    //   759: astore 4
    //   761: aload_2
    //   762: astore_3
    //   763: iload 14
    //   765: istore 16
    //   767: iload 15
    //   769: istore 17
    //   771: aload_2
    //   772: aload 12
    //   774: invokeinterface 1552 1 0
    //   779: invokestatic 497	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   782: putfield 2260	com/tencent/mobileqq/qcall/PstnSwitchConfig:c	I
    //   785: goto +4420 -> 5205
    //   788: iload 13
    //   790: istore 19
    //   792: aload_1
    //   793: astore 4
    //   795: aload_2
    //   796: astore_3
    //   797: iload 14
    //   799: istore 16
    //   801: iload 15
    //   803: istore 17
    //   805: aload 5
    //   807: ldc_w 2262
    //   810: invokevirtual 1549	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   813: ifeq +298 -> 1111
    //   816: iload 13
    //   818: istore 19
    //   820: aload_1
    //   821: astore 4
    //   823: aload_2
    //   824: astore_3
    //   825: iload 14
    //   827: istore 16
    //   829: iload 15
    //   831: istore 17
    //   833: aload_2
    //   834: aload 12
    //   836: invokeinterface 1552 1 0
    //   841: invokestatic 497	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   844: putfield 2263	com/tencent/mobileqq/qcall/PstnSwitchConfig:d	I
    //   847: goto +4358 -> 5205
    //   850: astore 7
    //   852: iload 13
    //   854: istore 21
    //   856: aload_1
    //   857: astore 6
    //   859: aload_2
    //   860: astore 5
    //   862: iload 14
    //   864: istore 18
    //   866: iload 15
    //   868: istore 20
    //   870: iload 13
    //   872: istore 19
    //   874: aload_1
    //   875: astore 4
    //   877: aload_2
    //   878: astore_3
    //   879: iload 14
    //   881: istore 16
    //   883: iload 15
    //   885: istore 17
    //   887: invokestatic 256	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   890: ifeq +68 -> 958
    //   893: iload 13
    //   895: istore 19
    //   897: aload_1
    //   898: astore 4
    //   900: aload_2
    //   901: astore_3
    //   902: iload 14
    //   904: istore 16
    //   906: iload 15
    //   908: istore 17
    //   910: ldc -111
    //   912: iconst_2
    //   913: new 260	java/lang/StringBuilder
    //   916: dup
    //   917: invokespecial 261	java/lang/StringBuilder:<init>	()V
    //   920: ldc_w 2265
    //   923: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   926: aload 7
    //   928: invokevirtual 2266	java/lang/NumberFormatException:toString	()Ljava/lang/String;
    //   931: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   934: invokevirtual 275	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   937: invokestatic 1053	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   940: iload 15
    //   942: istore 20
    //   944: iload 14
    //   946: istore 18
    //   948: aload_2
    //   949: astore 5
    //   951: aload_1
    //   952: astore 6
    //   954: iload 13
    //   956: istore 21
    //   958: aload 6
    //   960: astore_2
    //   961: iload 21
    //   963: istore 15
    //   965: iload 18
    //   967: istore 14
    //   969: aload 11
    //   971: ifnull -932 -> 39
    //   974: aload 5
    //   976: ifnull +27 -> 1003
    //   979: aload 11
    //   981: aload 5
    //   983: invokevirtual 2269	com/tencent/mobileqq/qcall/PstnManager:a	(Lcom/tencent/mobileqq/qcall/PstnSwitchConfig;)V
    //   986: invokestatic 256	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   989: ifeq +14 -> 1003
    //   992: ldc -111
    //   994: iconst_2
    //   995: aload 5
    //   997: invokevirtual 2270	com/tencent/mobileqq/qcall/PstnSwitchConfig:toString	()Ljava/lang/String;
    //   1000: invokestatic 1053	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1003: aload_2
    //   1004: ifnull +9 -> 1013
    //   1007: aload 11
    //   1009: aload_2
    //   1010: invokevirtual 2273	com/tencent/mobileqq/qcall/PstnManager:a	(Ljava/util/HashMap;)V
    //   1013: iload 14
    //   1015: iconst_m1
    //   1016: if_icmpeq +43 -> 1059
    //   1019: aload 11
    //   1021: iload 14
    //   1023: invokevirtual 2275	com/tencent/mobileqq/qcall/PstnManager:b	(I)V
    //   1026: invokestatic 256	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1029: ifeq +30 -> 1059
    //   1032: ldc -111
    //   1034: iconst_2
    //   1035: new 260	java/lang/StringBuilder
    //   1038: dup
    //   1039: invokespecial 261	java/lang/StringBuilder:<init>	()V
    //   1042: ldc_w 2277
    //   1045: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1048: iload 14
    //   1050: invokevirtual 270	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1053: invokevirtual 275	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1056: invokestatic 1053	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1059: iload 15
    //   1061: ifeq -1022 -> 39
    //   1064: iload 20
    //   1066: iconst_m1
    //   1067: if_icmpeq -1028 -> 39
    //   1070: aload 11
    //   1072: iload 20
    //   1074: invokevirtual 2279	com/tencent/mobileqq/qcall/PstnManager:a	(I)V
    //   1077: invokestatic 256	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1080: ifeq -1041 -> 39
    //   1083: ldc -111
    //   1085: iconst_2
    //   1086: new 260	java/lang/StringBuilder
    //   1089: dup
    //   1090: invokespecial 261	java/lang/StringBuilder:<init>	()V
    //   1093: ldc_w 2281
    //   1096: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1099: iload 20
    //   1101: invokevirtual 270	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1104: invokevirtual 275	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1107: invokestatic 1053	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1110: return
    //   1111: iload 13
    //   1113: istore 19
    //   1115: aload_1
    //   1116: astore 4
    //   1118: aload_2
    //   1119: astore_3
    //   1120: iload 14
    //   1122: istore 16
    //   1124: iload 15
    //   1126: istore 17
    //   1128: aload 5
    //   1130: ldc_w 2283
    //   1133: invokevirtual 1549	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1136: ifeq +235 -> 1371
    //   1139: iload 13
    //   1141: istore 19
    //   1143: aload_1
    //   1144: astore 4
    //   1146: aload_2
    //   1147: astore_3
    //   1148: iload 14
    //   1150: istore 16
    //   1152: iload 15
    //   1154: istore 17
    //   1156: aload_2
    //   1157: aload 12
    //   1159: invokeinterface 1552 1 0
    //   1164: invokestatic 497	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   1167: putfield 2285	com/tencent/mobileqq/qcall/PstnSwitchConfig:e	I
    //   1170: goto +4035 -> 5205
    //   1173: astore 7
    //   1175: iload 13
    //   1177: istore 21
    //   1179: aload_1
    //   1180: astore 6
    //   1182: aload_2
    //   1183: astore 5
    //   1185: iload 14
    //   1187: istore 18
    //   1189: iload 15
    //   1191: istore 20
    //   1193: iload 13
    //   1195: istore 19
    //   1197: aload_1
    //   1198: astore 4
    //   1200: aload_2
    //   1201: astore_3
    //   1202: iload 14
    //   1204: istore 16
    //   1206: iload 15
    //   1208: istore 17
    //   1210: invokestatic 256	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1213: ifeq -255 -> 958
    //   1216: iload 13
    //   1218: istore 19
    //   1220: aload_1
    //   1221: astore 4
    //   1223: aload_2
    //   1224: astore_3
    //   1225: iload 14
    //   1227: istore 16
    //   1229: iload 15
    //   1231: istore 17
    //   1233: ldc -111
    //   1235: iconst_2
    //   1236: new 260	java/lang/StringBuilder
    //   1239: dup
    //   1240: invokespecial 261	java/lang/StringBuilder:<init>	()V
    //   1243: ldc_w 2287
    //   1246: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1249: aload 7
    //   1251: invokevirtual 2288	java/io/IOException:toString	()Ljava/lang/String;
    //   1254: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1257: invokevirtual 275	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1260: invokestatic 1053	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1263: iload 13
    //   1265: istore 21
    //   1267: aload_1
    //   1268: astore 6
    //   1270: aload_2
    //   1271: astore 5
    //   1273: iload 14
    //   1275: istore 18
    //   1277: iload 15
    //   1279: istore 20
    //   1281: goto -323 -> 958
    //   1284: astore_1
    //   1285: iload 19
    //   1287: istore 18
    //   1289: iload 17
    //   1291: istore 13
    //   1293: iload 16
    //   1295: istore 17
    //   1297: iload 18
    //   1299: istore 15
    //   1301: aload 4
    //   1303: astore_2
    //   1304: aload_3
    //   1305: astore 5
    //   1307: iload 17
    //   1309: istore 14
    //   1311: iload 13
    //   1313: istore 20
    //   1315: invokestatic 256	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1318: ifeq -349 -> 969
    //   1321: ldc -111
    //   1323: iconst_2
    //   1324: new 260	java/lang/StringBuilder
    //   1327: dup
    //   1328: invokespecial 261	java/lang/StringBuilder:<init>	()V
    //   1331: ldc_w 2290
    //   1334: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1337: aload_1
    //   1338: invokevirtual 2291	org/xmlpull/v1/XmlPullParserException:toString	()Ljava/lang/String;
    //   1341: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1344: invokevirtual 275	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1347: invokestatic 1053	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1350: iload 18
    //   1352: istore 15
    //   1354: aload 4
    //   1356: astore_2
    //   1357: aload_3
    //   1358: astore 5
    //   1360: iload 17
    //   1362: istore 14
    //   1364: iload 13
    //   1366: istore 20
    //   1368: goto -399 -> 969
    //   1371: iload 13
    //   1373: istore 19
    //   1375: aload_1
    //   1376: astore 4
    //   1378: aload_2
    //   1379: astore_3
    //   1380: iload 14
    //   1382: istore 16
    //   1384: iload 15
    //   1386: istore 17
    //   1388: aload 5
    //   1390: ldc_w 2293
    //   1393: invokevirtual 1549	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1396: ifeq +3809 -> 5205
    //   1399: iload 13
    //   1401: istore 19
    //   1403: aload_1
    //   1404: astore 4
    //   1406: aload_2
    //   1407: astore_3
    //   1408: iload 14
    //   1410: istore 16
    //   1412: iload 15
    //   1414: istore 17
    //   1416: aload 11
    //   1418: aload 12
    //   1420: invokeinterface 1552 1 0
    //   1425: invokestatic 497	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   1428: invokevirtual 2295	com/tencent/mobileqq/qcall/PstnManager:c	(I)V
    //   1431: goto +3774 -> 5205
    //   1434: iload 13
    //   1436: istore 19
    //   1438: aload_1
    //   1439: astore 4
    //   1441: aload_2
    //   1442: astore_3
    //   1443: iload 14
    //   1445: istore 16
    //   1447: iload 15
    //   1449: istore 17
    //   1451: aload 7
    //   1453: ldc_w 2297
    //   1456: invokevirtual 1549	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1459: ifeq +3746 -> 5205
    //   1462: iload 13
    //   1464: istore 19
    //   1466: aload_1
    //   1467: astore 4
    //   1469: aload_2
    //   1470: astore_3
    //   1471: iload 14
    //   1473: istore 16
    //   1475: iload 15
    //   1477: istore 17
    //   1479: aload 5
    //   1481: ldc_w 2258
    //   1484: invokevirtual 1549	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1487: ifeq +37 -> 1524
    //   1490: iload 13
    //   1492: istore 19
    //   1494: aload_1
    //   1495: astore 4
    //   1497: aload_2
    //   1498: astore_3
    //   1499: iload 14
    //   1501: istore 16
    //   1503: iload 15
    //   1505: istore 17
    //   1507: aload_2
    //   1508: aload 12
    //   1510: invokeinterface 1552 1 0
    //   1515: invokestatic 497	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   1518: putfield 2299	com/tencent/mobileqq/qcall/PstnSwitchConfig:f	I
    //   1521: goto +3684 -> 5205
    //   1524: iload 13
    //   1526: istore 19
    //   1528: aload_1
    //   1529: astore 4
    //   1531: aload_2
    //   1532: astore_3
    //   1533: iload 14
    //   1535: istore 16
    //   1537: iload 15
    //   1539: istore 17
    //   1541: aload 5
    //   1543: ldc_w 2301
    //   1546: invokevirtual 1549	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1549: ifeq +37 -> 1586
    //   1552: iload 13
    //   1554: istore 19
    //   1556: aload_1
    //   1557: astore 4
    //   1559: aload_2
    //   1560: astore_3
    //   1561: iload 14
    //   1563: istore 16
    //   1565: iload 15
    //   1567: istore 17
    //   1569: aload_2
    //   1570: aload 12
    //   1572: invokeinterface 1552 1 0
    //   1577: invokestatic 497	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   1580: putfield 2302	com/tencent/mobileqq/qcall/PstnSwitchConfig:g	I
    //   1583: goto +3622 -> 5205
    //   1586: iload 13
    //   1588: istore 19
    //   1590: aload_1
    //   1591: astore 4
    //   1593: aload_2
    //   1594: astore_3
    //   1595: iload 14
    //   1597: istore 16
    //   1599: iload 15
    //   1601: istore 17
    //   1603: aload 5
    //   1605: ldc_w 2304
    //   1608: invokevirtual 1549	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1611: ifeq +37 -> 1648
    //   1614: iload 13
    //   1616: istore 19
    //   1618: aload_1
    //   1619: astore 4
    //   1621: aload_2
    //   1622: astore_3
    //   1623: iload 14
    //   1625: istore 16
    //   1627: iload 15
    //   1629: istore 17
    //   1631: aload_2
    //   1632: aload 12
    //   1634: invokeinterface 1552 1 0
    //   1639: invokestatic 497	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   1642: putfield 2306	com/tencent/mobileqq/qcall/PstnSwitchConfig:h	I
    //   1645: goto +3560 -> 5205
    //   1648: iload 13
    //   1650: istore 19
    //   1652: aload_1
    //   1653: astore 4
    //   1655: aload_2
    //   1656: astore_3
    //   1657: iload 14
    //   1659: istore 16
    //   1661: iload 15
    //   1663: istore 17
    //   1665: aload 5
    //   1667: ldc_w 2308
    //   1670: invokevirtual 1549	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1673: ifeq +37 -> 1710
    //   1676: iload 13
    //   1678: istore 19
    //   1680: aload_1
    //   1681: astore 4
    //   1683: aload_2
    //   1684: astore_3
    //   1685: iload 14
    //   1687: istore 16
    //   1689: iload 15
    //   1691: istore 17
    //   1693: aload_2
    //   1694: aload 12
    //   1696: invokeinterface 1552 1 0
    //   1701: invokestatic 497	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   1704: putfield 2309	com/tencent/mobileqq/qcall/PstnSwitchConfig:i	I
    //   1707: goto +3498 -> 5205
    //   1710: iload 13
    //   1712: istore 19
    //   1714: aload_1
    //   1715: astore 4
    //   1717: aload_2
    //   1718: astore_3
    //   1719: iload 14
    //   1721: istore 16
    //   1723: iload 15
    //   1725: istore 17
    //   1727: aload 5
    //   1729: ldc_w 2293
    //   1732: invokevirtual 1549	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1735: ifeq +3470 -> 5205
    //   1738: iload 13
    //   1740: istore 19
    //   1742: aload_1
    //   1743: astore 4
    //   1745: aload_2
    //   1746: astore_3
    //   1747: iload 14
    //   1749: istore 16
    //   1751: iload 15
    //   1753: istore 17
    //   1755: aload 11
    //   1757: aload 12
    //   1759: invokeinterface 1552 1 0
    //   1764: invokestatic 497	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   1767: invokevirtual 2311	com/tencent/mobileqq/qcall/PstnManager:d	(I)V
    //   1770: goto +3435 -> 5205
    //   1773: aload_1
    //   1774: ifnull +37 -> 1811
    //   1777: iload 13
    //   1779: istore 19
    //   1781: aload_1
    //   1782: astore 4
    //   1784: aload_2
    //   1785: astore_3
    //   1786: iload 14
    //   1788: istore 16
    //   1790: iload 15
    //   1792: istore 17
    //   1794: aload 12
    //   1796: iconst_0
    //   1797: invokeinterface 2241 2 0
    //   1802: astore 5
    //   1804: aload 7
    //   1806: astore 6
    //   1808: goto -1552 -> 256
    //   1811: iload 13
    //   1813: ifeq -1565 -> 248
    //   1816: iload 13
    //   1818: istore 19
    //   1820: aload_1
    //   1821: astore 4
    //   1823: aload_2
    //   1824: astore_3
    //   1825: iload 14
    //   1827: istore 16
    //   1829: iload 15
    //   1831: istore 17
    //   1833: aload 12
    //   1835: iconst_0
    //   1836: invokeinterface 2241 2 0
    //   1841: astore 5
    //   1843: iload 13
    //   1845: istore 19
    //   1847: aload_1
    //   1848: astore 4
    //   1850: aload_2
    //   1851: astore_3
    //   1852: iload 14
    //   1854: istore 16
    //   1856: iload 15
    //   1858: istore 17
    //   1860: aload 5
    //   1862: invokestatic 482	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1865: ifne +67 -> 1932
    //   1868: iload 13
    //   1870: istore 19
    //   1872: aload_1
    //   1873: astore 4
    //   1875: aload_2
    //   1876: astore_3
    //   1877: iload 14
    //   1879: istore 16
    //   1881: iload 15
    //   1883: istore 17
    //   1885: aload 5
    //   1887: ldc_w 2313
    //   1890: invokevirtual 1549	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1893: ifeq +39 -> 1932
    //   1896: iload 13
    //   1898: istore 19
    //   1900: aload_1
    //   1901: astore 4
    //   1903: aload_2
    //   1904: astore_3
    //   1905: iload 14
    //   1907: istore 16
    //   1909: iload 15
    //   1911: istore 17
    //   1913: aload 12
    //   1915: invokeinterface 1552 1 0
    //   1920: invokestatic 497	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   1923: istore 18
    //   1925: iload 18
    //   1927: istore 15
    //   1929: goto +3287 -> 5216
    //   1932: iload 13
    //   1934: istore 19
    //   1936: aload_1
    //   1937: astore 4
    //   1939: aload_2
    //   1940: astore_3
    //   1941: iload 14
    //   1943: istore 16
    //   1945: iload 15
    //   1947: istore 17
    //   1949: aload 5
    //   1951: invokestatic 482	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1954: ifne +3237 -> 5191
    //   1957: iload 13
    //   1959: istore 19
    //   1961: aload_1
    //   1962: astore 4
    //   1964: aload_2
    //   1965: astore_3
    //   1966: iload 14
    //   1968: istore 16
    //   1970: iload 15
    //   1972: istore 17
    //   1974: aload 5
    //   1976: ldc_w 2315
    //   1979: invokevirtual 1549	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1982: ifeq +3209 -> 5191
    //   1985: iload 13
    //   1987: istore 19
    //   1989: aload_1
    //   1990: astore 4
    //   1992: aload_2
    //   1993: astore_3
    //   1994: iload 14
    //   1996: istore 16
    //   1998: iload 15
    //   2000: istore 17
    //   2002: aload 12
    //   2004: invokeinterface 1552 1 0
    //   2009: invokestatic 497	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   2012: istore 18
    //   2014: iload 18
    //   2016: istore 14
    //   2018: goto +3198 -> 5216
    //   2021: iload 13
    //   2023: istore 19
    //   2025: aload_1
    //   2026: astore 4
    //   2028: aload_2
    //   2029: astore_3
    //   2030: iload 14
    //   2032: istore 16
    //   2034: iload 15
    //   2036: istore 17
    //   2038: aload 5
    //   2040: ldc_w 2317
    //   2043: invokevirtual 1549	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2046: ifeq +1045 -> 3091
    //   2049: iload 13
    //   2051: istore 19
    //   2053: aload_1
    //   2054: astore 4
    //   2056: aload_2
    //   2057: astore_3
    //   2058: iload 14
    //   2060: istore 16
    //   2062: iload 15
    //   2064: istore 17
    //   2066: aload 8
    //   2068: invokestatic 482	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2071: ifne -1823 -> 248
    //   2074: aload_1
    //   2075: ifnull -1827 -> 248
    //   2078: iload 13
    //   2080: istore 19
    //   2082: aload_1
    //   2083: astore 4
    //   2085: aload_2
    //   2086: astore_3
    //   2087: iload 14
    //   2089: istore 16
    //   2091: iload 15
    //   2093: istore 17
    //   2095: aload 12
    //   2097: iconst_0
    //   2098: invokeinterface 2241 2 0
    //   2103: astore 5
    //   2105: iload 13
    //   2107: istore 19
    //   2109: aload_1
    //   2110: astore 4
    //   2112: aload_2
    //   2113: astore_3
    //   2114: iload 14
    //   2116: istore 16
    //   2118: iload 15
    //   2120: istore 17
    //   2122: aload 12
    //   2124: invokeinterface 1552 1 0
    //   2129: astore 6
    //   2131: iload 13
    //   2133: istore 19
    //   2135: aload_1
    //   2136: astore 4
    //   2138: aload_2
    //   2139: astore_3
    //   2140: iload 14
    //   2142: istore 16
    //   2144: iload 15
    //   2146: istore 17
    //   2148: aload 6
    //   2150: invokestatic 482	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2153: ifeq +40 -> 2193
    //   2156: iload 13
    //   2158: istore 19
    //   2160: aload_1
    //   2161: astore 4
    //   2163: aload_2
    //   2164: astore_3
    //   2165: iload 14
    //   2167: istore 16
    //   2169: iload 15
    //   2171: istore 17
    //   2173: ldc -111
    //   2175: iconst_1
    //   2176: ldc_w 2319
    //   2179: invokestatic 1053	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2182: aload 8
    //   2184: astore 5
    //   2186: aload 7
    //   2188: astore 6
    //   2190: goto -1934 -> 256
    //   2193: iload 13
    //   2195: istore 19
    //   2197: aload_1
    //   2198: astore 4
    //   2200: aload_2
    //   2201: astore_3
    //   2202: iload 14
    //   2204: istore 16
    //   2206: iload 15
    //   2208: istore 17
    //   2210: aload 8
    //   2212: ldc_w 2321
    //   2215: invokevirtual 1549	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2218: ifeq +366 -> 2584
    //   2221: iload 13
    //   2223: istore 19
    //   2225: aload_1
    //   2226: astore 4
    //   2228: aload_2
    //   2229: astore_3
    //   2230: iload 14
    //   2232: istore 16
    //   2234: iload 15
    //   2236: istore 17
    //   2238: aload 5
    //   2240: invokestatic 482	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2243: ifne +2984 -> 5227
    //   2246: iload 13
    //   2248: istore 19
    //   2250: aload_1
    //   2251: astore 4
    //   2253: aload_2
    //   2254: astore_3
    //   2255: iload 14
    //   2257: istore 16
    //   2259: iload 15
    //   2261: istore 17
    //   2263: aload 5
    //   2265: ldc_w 2256
    //   2268: invokevirtual 1549	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2271: ifeq +144 -> 2415
    //   2274: iload 13
    //   2276: istore 19
    //   2278: aload_1
    //   2279: astore 4
    //   2281: aload_2
    //   2282: astore_3
    //   2283: iload 14
    //   2285: istore 16
    //   2287: iload 15
    //   2289: istore 17
    //   2291: aload 7
    //   2293: invokestatic 482	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2296: ifne +2931 -> 5227
    //   2299: iload 13
    //   2301: istore 19
    //   2303: aload_1
    //   2304: astore 4
    //   2306: aload_2
    //   2307: astore_3
    //   2308: iload 14
    //   2310: istore 16
    //   2312: iload 15
    //   2314: istore 17
    //   2316: aload 7
    //   2318: ldc_w 2323
    //   2321: invokevirtual 1549	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2324: ifeq +33 -> 2357
    //   2327: iload 13
    //   2329: istore 19
    //   2331: aload_1
    //   2332: astore 4
    //   2334: aload_2
    //   2335: astore_3
    //   2336: iload 14
    //   2338: istore 16
    //   2340: iload 15
    //   2342: istore 17
    //   2344: aload_1
    //   2345: ldc_w 2325
    //   2348: aload 6
    //   2350: invokevirtual 2328	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2353: pop
    //   2354: goto +2873 -> 5227
    //   2357: iload 13
    //   2359: istore 19
    //   2361: aload_1
    //   2362: astore 4
    //   2364: aload_2
    //   2365: astore_3
    //   2366: iload 14
    //   2368: istore 16
    //   2370: iload 15
    //   2372: istore 17
    //   2374: aload 7
    //   2376: ldc_w 2330
    //   2379: invokevirtual 1549	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2382: ifeq +2845 -> 5227
    //   2385: iload 13
    //   2387: istore 19
    //   2389: aload_1
    //   2390: astore 4
    //   2392: aload_2
    //   2393: astore_3
    //   2394: iload 14
    //   2396: istore 16
    //   2398: iload 15
    //   2400: istore 17
    //   2402: aload_1
    //   2403: ldc_w 2332
    //   2406: aload 6
    //   2408: invokevirtual 2328	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2411: pop
    //   2412: goto +2815 -> 5227
    //   2415: iload 13
    //   2417: istore 19
    //   2419: aload_1
    //   2420: astore 4
    //   2422: aload_2
    //   2423: astore_3
    //   2424: iload 14
    //   2426: istore 16
    //   2428: iload 15
    //   2430: istore 17
    //   2432: aload 5
    //   2434: ldc_w 2297
    //   2437: invokevirtual 1549	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2440: ifeq +2787 -> 5227
    //   2443: iload 13
    //   2445: istore 19
    //   2447: aload_1
    //   2448: astore 4
    //   2450: aload_2
    //   2451: astore_3
    //   2452: iload 14
    //   2454: istore 16
    //   2456: iload 15
    //   2458: istore 17
    //   2460: aload 7
    //   2462: invokestatic 482	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2465: ifne +2762 -> 5227
    //   2468: iload 13
    //   2470: istore 19
    //   2472: aload_1
    //   2473: astore 4
    //   2475: aload_2
    //   2476: astore_3
    //   2477: iload 14
    //   2479: istore 16
    //   2481: iload 15
    //   2483: istore 17
    //   2485: aload 7
    //   2487: ldc_w 2323
    //   2490: invokevirtual 1549	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2493: ifeq +33 -> 2526
    //   2496: iload 13
    //   2498: istore 19
    //   2500: aload_1
    //   2501: astore 4
    //   2503: aload_2
    //   2504: astore_3
    //   2505: iload 14
    //   2507: istore 16
    //   2509: iload 15
    //   2511: istore 17
    //   2513: aload_1
    //   2514: ldc_w 2334
    //   2517: aload 6
    //   2519: invokevirtual 2328	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2522: pop
    //   2523: goto +2704 -> 5227
    //   2526: iload 13
    //   2528: istore 19
    //   2530: aload_1
    //   2531: astore 4
    //   2533: aload_2
    //   2534: astore_3
    //   2535: iload 14
    //   2537: istore 16
    //   2539: iload 15
    //   2541: istore 17
    //   2543: aload 7
    //   2545: ldc_w 2330
    //   2548: invokevirtual 1549	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2551: ifeq +2676 -> 5227
    //   2554: iload 13
    //   2556: istore 19
    //   2558: aload_1
    //   2559: astore 4
    //   2561: aload_2
    //   2562: astore_3
    //   2563: iload 14
    //   2565: istore 16
    //   2567: iload 15
    //   2569: istore 17
    //   2571: aload_1
    //   2572: ldc_w 2336
    //   2575: aload 6
    //   2577: invokevirtual 2328	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2580: pop
    //   2581: goto +2646 -> 5227
    //   2584: iload 13
    //   2586: istore 19
    //   2588: aload_1
    //   2589: astore 4
    //   2591: aload_2
    //   2592: astore_3
    //   2593: iload 14
    //   2595: istore 16
    //   2597: iload 15
    //   2599: istore 17
    //   2601: aload 8
    //   2603: ldc_w 2338
    //   2606: invokevirtual 1549	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2609: ifeq +144 -> 2753
    //   2612: iload 13
    //   2614: istore 19
    //   2616: aload_1
    //   2617: astore 4
    //   2619: aload_2
    //   2620: astore_3
    //   2621: iload 14
    //   2623: istore 16
    //   2625: iload 15
    //   2627: istore 17
    //   2629: aload 5
    //   2631: invokestatic 482	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2634: ifne +2593 -> 5227
    //   2637: iload 13
    //   2639: istore 19
    //   2641: aload_1
    //   2642: astore 4
    //   2644: aload_2
    //   2645: astore_3
    //   2646: iload 14
    //   2648: istore 16
    //   2650: iload 15
    //   2652: istore 17
    //   2654: aload 5
    //   2656: ldc_w 2256
    //   2659: invokevirtual 1549	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2662: ifeq +33 -> 2695
    //   2665: iload 13
    //   2667: istore 19
    //   2669: aload_1
    //   2670: astore 4
    //   2672: aload_2
    //   2673: astore_3
    //   2674: iload 14
    //   2676: istore 16
    //   2678: iload 15
    //   2680: istore 17
    //   2682: aload_1
    //   2683: ldc_w 2340
    //   2686: aload 6
    //   2688: invokevirtual 2328	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2691: pop
    //   2692: goto +2535 -> 5227
    //   2695: iload 13
    //   2697: istore 19
    //   2699: aload_1
    //   2700: astore 4
    //   2702: aload_2
    //   2703: astore_3
    //   2704: iload 14
    //   2706: istore 16
    //   2708: iload 15
    //   2710: istore 17
    //   2712: aload 5
    //   2714: ldc_w 2297
    //   2717: invokevirtual 1549	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2720: ifeq +2507 -> 5227
    //   2723: iload 13
    //   2725: istore 19
    //   2727: aload_1
    //   2728: astore 4
    //   2730: aload_2
    //   2731: astore_3
    //   2732: iload 14
    //   2734: istore 16
    //   2736: iload 15
    //   2738: istore 17
    //   2740: aload_1
    //   2741: ldc_w 2342
    //   2744: aload 6
    //   2746: invokevirtual 2328	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2749: pop
    //   2750: goto +2477 -> 5227
    //   2753: iload 13
    //   2755: istore 19
    //   2757: aload_1
    //   2758: astore 4
    //   2760: aload_2
    //   2761: astore_3
    //   2762: iload 14
    //   2764: istore 16
    //   2766: iload 15
    //   2768: istore 17
    //   2770: aload 8
    //   2772: ldc_w 2344
    //   2775: invokevirtual 1549	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2778: ifeq +144 -> 2922
    //   2781: iload 13
    //   2783: istore 19
    //   2785: aload_1
    //   2786: astore 4
    //   2788: aload_2
    //   2789: astore_3
    //   2790: iload 14
    //   2792: istore 16
    //   2794: iload 15
    //   2796: istore 17
    //   2798: aload 5
    //   2800: invokestatic 482	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2803: ifne +2424 -> 5227
    //   2806: iload 13
    //   2808: istore 19
    //   2810: aload_1
    //   2811: astore 4
    //   2813: aload_2
    //   2814: astore_3
    //   2815: iload 14
    //   2817: istore 16
    //   2819: iload 15
    //   2821: istore 17
    //   2823: aload 5
    //   2825: ldc_w 2346
    //   2828: invokevirtual 1549	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2831: ifeq +33 -> 2864
    //   2834: iload 13
    //   2836: istore 19
    //   2838: aload_1
    //   2839: astore 4
    //   2841: aload_2
    //   2842: astore_3
    //   2843: iload 14
    //   2845: istore 16
    //   2847: iload 15
    //   2849: istore 17
    //   2851: aload_1
    //   2852: ldc_w 2348
    //   2855: aload 6
    //   2857: invokevirtual 2328	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2860: pop
    //   2861: goto +2366 -> 5227
    //   2864: iload 13
    //   2866: istore 19
    //   2868: aload_1
    //   2869: astore 4
    //   2871: aload_2
    //   2872: astore_3
    //   2873: iload 14
    //   2875: istore 16
    //   2877: iload 15
    //   2879: istore 17
    //   2881: aload 5
    //   2883: ldc_w 2350
    //   2886: invokevirtual 1549	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2889: ifeq +2338 -> 5227
    //   2892: iload 13
    //   2894: istore 19
    //   2896: aload_1
    //   2897: astore 4
    //   2899: aload_2
    //   2900: astore_3
    //   2901: iload 14
    //   2903: istore 16
    //   2905: iload 15
    //   2907: istore 17
    //   2909: aload_1
    //   2910: ldc_w 2352
    //   2913: aload 6
    //   2915: invokevirtual 2328	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2918: pop
    //   2919: goto +2308 -> 5227
    //   2922: iload 13
    //   2924: istore 19
    //   2926: aload_1
    //   2927: astore 4
    //   2929: aload_2
    //   2930: astore_3
    //   2931: iload 14
    //   2933: istore 16
    //   2935: iload 15
    //   2937: istore 17
    //   2939: aload 8
    //   2941: ldc_w 2354
    //   2944: invokevirtual 1549	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2947: ifeq +2280 -> 5227
    //   2950: iload 13
    //   2952: istore 19
    //   2954: aload_1
    //   2955: astore 4
    //   2957: aload_2
    //   2958: astore_3
    //   2959: iload 14
    //   2961: istore 16
    //   2963: iload 15
    //   2965: istore 17
    //   2967: aload 5
    //   2969: invokestatic 482	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2972: ifne +2255 -> 5227
    //   2975: iload 13
    //   2977: istore 19
    //   2979: aload_1
    //   2980: astore 4
    //   2982: aload_2
    //   2983: astore_3
    //   2984: iload 14
    //   2986: istore 16
    //   2988: iload 15
    //   2990: istore 17
    //   2992: aload 5
    //   2994: ldc_w 2256
    //   2997: invokevirtual 1549	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3000: ifeq +33 -> 3033
    //   3003: iload 13
    //   3005: istore 19
    //   3007: aload_1
    //   3008: astore 4
    //   3010: aload_2
    //   3011: astore_3
    //   3012: iload 14
    //   3014: istore 16
    //   3016: iload 15
    //   3018: istore 17
    //   3020: aload_1
    //   3021: ldc_w 2356
    //   3024: aload 6
    //   3026: invokevirtual 2328	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3029: pop
    //   3030: goto +2197 -> 5227
    //   3033: iload 13
    //   3035: istore 19
    //   3037: aload_1
    //   3038: astore 4
    //   3040: aload_2
    //   3041: astore_3
    //   3042: iload 14
    //   3044: istore 16
    //   3046: iload 15
    //   3048: istore 17
    //   3050: aload 5
    //   3052: ldc_w 2297
    //   3055: invokevirtual 1549	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3058: ifeq +2169 -> 5227
    //   3061: iload 13
    //   3063: istore 19
    //   3065: aload_1
    //   3066: astore 4
    //   3068: aload_2
    //   3069: astore_3
    //   3070: iload 14
    //   3072: istore 16
    //   3074: iload 15
    //   3076: istore 17
    //   3078: aload_1
    //   3079: ldc_w 2358
    //   3082: aload 6
    //   3084: invokevirtual 2328	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3087: pop
    //   3088: goto +2139 -> 5227
    //   3091: iload 13
    //   3093: istore 19
    //   3095: aload_1
    //   3096: astore 4
    //   3098: aload_2
    //   3099: astore_3
    //   3100: iload 14
    //   3102: istore 16
    //   3104: iload 15
    //   3106: istore 17
    //   3108: aload 5
    //   3110: ldc_w 2360
    //   3113: invokevirtual 1549	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3116: ifeq +876 -> 3992
    //   3119: iload 13
    //   3121: istore 19
    //   3123: aload_1
    //   3124: astore 4
    //   3126: aload_2
    //   3127: astore_3
    //   3128: iload 14
    //   3130: istore 16
    //   3132: iload 15
    //   3134: istore 17
    //   3136: aload 8
    //   3138: invokestatic 482	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3141: ifne -2893 -> 248
    //   3144: aload_1
    //   3145: ifnull -2897 -> 248
    //   3148: iload 13
    //   3150: istore 19
    //   3152: aload_1
    //   3153: astore 4
    //   3155: aload_2
    //   3156: astore_3
    //   3157: iload 14
    //   3159: istore 16
    //   3161: iload 15
    //   3163: istore 17
    //   3165: aload 12
    //   3167: iconst_0
    //   3168: invokeinterface 2241 2 0
    //   3173: astore 5
    //   3175: iload 13
    //   3177: istore 19
    //   3179: aload_1
    //   3180: astore 4
    //   3182: aload_2
    //   3183: astore_3
    //   3184: iload 14
    //   3186: istore 16
    //   3188: iload 15
    //   3190: istore 17
    //   3192: aload 12
    //   3194: invokeinterface 1552 1 0
    //   3199: astore 6
    //   3201: iload 13
    //   3203: istore 19
    //   3205: aload_1
    //   3206: astore 4
    //   3208: aload_2
    //   3209: astore_3
    //   3210: iload 14
    //   3212: istore 16
    //   3214: iload 15
    //   3216: istore 17
    //   3218: aload 6
    //   3220: invokestatic 482	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3223: ifeq +40 -> 3263
    //   3226: iload 13
    //   3228: istore 19
    //   3230: aload_1
    //   3231: astore 4
    //   3233: aload_2
    //   3234: astore_3
    //   3235: iload 14
    //   3237: istore 16
    //   3239: iload 15
    //   3241: istore 17
    //   3243: ldc -111
    //   3245: iconst_1
    //   3246: ldc_w 2362
    //   3249: invokestatic 1053	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   3252: aload 8
    //   3254: astore 5
    //   3256: aload 7
    //   3258: astore 6
    //   3260: goto -3004 -> 256
    //   3263: iload 13
    //   3265: istore 19
    //   3267: aload_1
    //   3268: astore 4
    //   3270: aload_2
    //   3271: astore_3
    //   3272: iload 14
    //   3274: istore 16
    //   3276: iload 15
    //   3278: istore 17
    //   3280: aload 8
    //   3282: ldc_w 2321
    //   3285: invokevirtual 1549	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3288: ifeq +366 -> 3654
    //   3291: iload 13
    //   3293: istore 19
    //   3295: aload_1
    //   3296: astore 4
    //   3298: aload_2
    //   3299: astore_3
    //   3300: iload 14
    //   3302: istore 16
    //   3304: iload 15
    //   3306: istore 17
    //   3308: aload 5
    //   3310: invokestatic 482	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3313: ifne +1925 -> 5238
    //   3316: iload 13
    //   3318: istore 19
    //   3320: aload_1
    //   3321: astore 4
    //   3323: aload_2
    //   3324: astore_3
    //   3325: iload 14
    //   3327: istore 16
    //   3329: iload 15
    //   3331: istore 17
    //   3333: aload 5
    //   3335: ldc_w 2256
    //   3338: invokevirtual 1549	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3341: ifeq +144 -> 3485
    //   3344: iload 13
    //   3346: istore 19
    //   3348: aload_1
    //   3349: astore 4
    //   3351: aload_2
    //   3352: astore_3
    //   3353: iload 14
    //   3355: istore 16
    //   3357: iload 15
    //   3359: istore 17
    //   3361: aload 7
    //   3363: invokestatic 482	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3366: ifne +1872 -> 5238
    //   3369: iload 13
    //   3371: istore 19
    //   3373: aload_1
    //   3374: astore 4
    //   3376: aload_2
    //   3377: astore_3
    //   3378: iload 14
    //   3380: istore 16
    //   3382: iload 15
    //   3384: istore 17
    //   3386: aload 7
    //   3388: ldc_w 2323
    //   3391: invokevirtual 1549	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3394: ifeq +33 -> 3427
    //   3397: iload 13
    //   3399: istore 19
    //   3401: aload_1
    //   3402: astore 4
    //   3404: aload_2
    //   3405: astore_3
    //   3406: iload 14
    //   3408: istore 16
    //   3410: iload 15
    //   3412: istore 17
    //   3414: aload_1
    //   3415: ldc_w 2364
    //   3418: aload 6
    //   3420: invokevirtual 2328	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3423: pop
    //   3424: goto +1814 -> 5238
    //   3427: iload 13
    //   3429: istore 19
    //   3431: aload_1
    //   3432: astore 4
    //   3434: aload_2
    //   3435: astore_3
    //   3436: iload 14
    //   3438: istore 16
    //   3440: iload 15
    //   3442: istore 17
    //   3444: aload 7
    //   3446: ldc_w 2330
    //   3449: invokevirtual 1549	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3452: ifeq +1786 -> 5238
    //   3455: iload 13
    //   3457: istore 19
    //   3459: aload_1
    //   3460: astore 4
    //   3462: aload_2
    //   3463: astore_3
    //   3464: iload 14
    //   3466: istore 16
    //   3468: iload 15
    //   3470: istore 17
    //   3472: aload_1
    //   3473: ldc_w 2366
    //   3476: aload 6
    //   3478: invokevirtual 2328	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3481: pop
    //   3482: goto +1756 -> 5238
    //   3485: iload 13
    //   3487: istore 19
    //   3489: aload_1
    //   3490: astore 4
    //   3492: aload_2
    //   3493: astore_3
    //   3494: iload 14
    //   3496: istore 16
    //   3498: iload 15
    //   3500: istore 17
    //   3502: aload 5
    //   3504: ldc_w 2297
    //   3507: invokevirtual 1549	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3510: ifeq +1728 -> 5238
    //   3513: iload 13
    //   3515: istore 19
    //   3517: aload_1
    //   3518: astore 4
    //   3520: aload_2
    //   3521: astore_3
    //   3522: iload 14
    //   3524: istore 16
    //   3526: iload 15
    //   3528: istore 17
    //   3530: aload 7
    //   3532: invokestatic 482	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3535: ifne +1703 -> 5238
    //   3538: iload 13
    //   3540: istore 19
    //   3542: aload_1
    //   3543: astore 4
    //   3545: aload_2
    //   3546: astore_3
    //   3547: iload 14
    //   3549: istore 16
    //   3551: iload 15
    //   3553: istore 17
    //   3555: aload 7
    //   3557: ldc_w 2323
    //   3560: invokevirtual 1549	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3563: ifeq +33 -> 3596
    //   3566: iload 13
    //   3568: istore 19
    //   3570: aload_1
    //   3571: astore 4
    //   3573: aload_2
    //   3574: astore_3
    //   3575: iload 14
    //   3577: istore 16
    //   3579: iload 15
    //   3581: istore 17
    //   3583: aload_1
    //   3584: ldc_w 2368
    //   3587: aload 6
    //   3589: invokevirtual 2328	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3592: pop
    //   3593: goto +1645 -> 5238
    //   3596: iload 13
    //   3598: istore 19
    //   3600: aload_1
    //   3601: astore 4
    //   3603: aload_2
    //   3604: astore_3
    //   3605: iload 14
    //   3607: istore 16
    //   3609: iload 15
    //   3611: istore 17
    //   3613: aload 7
    //   3615: ldc_w 2330
    //   3618: invokevirtual 1549	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3621: ifeq +1617 -> 5238
    //   3624: iload 13
    //   3626: istore 19
    //   3628: aload_1
    //   3629: astore 4
    //   3631: aload_2
    //   3632: astore_3
    //   3633: iload 14
    //   3635: istore 16
    //   3637: iload 15
    //   3639: istore 17
    //   3641: aload_1
    //   3642: ldc_w 2370
    //   3645: aload 6
    //   3647: invokevirtual 2328	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3650: pop
    //   3651: goto +1587 -> 5238
    //   3654: iload 13
    //   3656: istore 19
    //   3658: aload_1
    //   3659: astore 4
    //   3661: aload_2
    //   3662: astore_3
    //   3663: iload 14
    //   3665: istore 16
    //   3667: iload 15
    //   3669: istore 17
    //   3671: aload 8
    //   3673: ldc_w 2338
    //   3676: invokevirtual 1549	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3679: ifeq +144 -> 3823
    //   3682: iload 13
    //   3684: istore 19
    //   3686: aload_1
    //   3687: astore 4
    //   3689: aload_2
    //   3690: astore_3
    //   3691: iload 14
    //   3693: istore 16
    //   3695: iload 15
    //   3697: istore 17
    //   3699: aload 5
    //   3701: invokestatic 482	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3704: ifne +1534 -> 5238
    //   3707: iload 13
    //   3709: istore 19
    //   3711: aload_1
    //   3712: astore 4
    //   3714: aload_2
    //   3715: astore_3
    //   3716: iload 14
    //   3718: istore 16
    //   3720: iload 15
    //   3722: istore 17
    //   3724: aload 5
    //   3726: ldc_w 2256
    //   3729: invokevirtual 1549	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3732: ifeq +33 -> 3765
    //   3735: iload 13
    //   3737: istore 19
    //   3739: aload_1
    //   3740: astore 4
    //   3742: aload_2
    //   3743: astore_3
    //   3744: iload 14
    //   3746: istore 16
    //   3748: iload 15
    //   3750: istore 17
    //   3752: aload_1
    //   3753: ldc_w 2372
    //   3756: aload 6
    //   3758: invokevirtual 2328	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3761: pop
    //   3762: goto +1476 -> 5238
    //   3765: iload 13
    //   3767: istore 19
    //   3769: aload_1
    //   3770: astore 4
    //   3772: aload_2
    //   3773: astore_3
    //   3774: iload 14
    //   3776: istore 16
    //   3778: iload 15
    //   3780: istore 17
    //   3782: aload 5
    //   3784: ldc_w 2297
    //   3787: invokevirtual 1549	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3790: ifeq +1448 -> 5238
    //   3793: iload 13
    //   3795: istore 19
    //   3797: aload_1
    //   3798: astore 4
    //   3800: aload_2
    //   3801: astore_3
    //   3802: iload 14
    //   3804: istore 16
    //   3806: iload 15
    //   3808: istore 17
    //   3810: aload_1
    //   3811: ldc_w 2374
    //   3814: aload 6
    //   3816: invokevirtual 2328	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3819: pop
    //   3820: goto +1418 -> 5238
    //   3823: iload 13
    //   3825: istore 19
    //   3827: aload_1
    //   3828: astore 4
    //   3830: aload_2
    //   3831: astore_3
    //   3832: iload 14
    //   3834: istore 16
    //   3836: iload 15
    //   3838: istore 17
    //   3840: aload 8
    //   3842: ldc_w 2354
    //   3845: invokevirtual 1549	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3848: ifeq +1390 -> 5238
    //   3851: iload 13
    //   3853: istore 19
    //   3855: aload_1
    //   3856: astore 4
    //   3858: aload_2
    //   3859: astore_3
    //   3860: iload 14
    //   3862: istore 16
    //   3864: iload 15
    //   3866: istore 17
    //   3868: aload 5
    //   3870: invokestatic 482	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3873: ifne +1365 -> 5238
    //   3876: iload 13
    //   3878: istore 19
    //   3880: aload_1
    //   3881: astore 4
    //   3883: aload_2
    //   3884: astore_3
    //   3885: iload 14
    //   3887: istore 16
    //   3889: iload 15
    //   3891: istore 17
    //   3893: aload 5
    //   3895: ldc_w 2256
    //   3898: invokevirtual 1549	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3901: ifeq +33 -> 3934
    //   3904: iload 13
    //   3906: istore 19
    //   3908: aload_1
    //   3909: astore 4
    //   3911: aload_2
    //   3912: astore_3
    //   3913: iload 14
    //   3915: istore 16
    //   3917: iload 15
    //   3919: istore 17
    //   3921: aload_1
    //   3922: ldc_w 2376
    //   3925: aload 6
    //   3927: invokevirtual 2328	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3930: pop
    //   3931: goto +1307 -> 5238
    //   3934: iload 13
    //   3936: istore 19
    //   3938: aload_1
    //   3939: astore 4
    //   3941: aload_2
    //   3942: astore_3
    //   3943: iload 14
    //   3945: istore 16
    //   3947: iload 15
    //   3949: istore 17
    //   3951: aload 5
    //   3953: ldc_w 2297
    //   3956: invokevirtual 1549	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3959: ifeq +1279 -> 5238
    //   3962: iload 13
    //   3964: istore 19
    //   3966: aload_1
    //   3967: astore 4
    //   3969: aload_2
    //   3970: astore_3
    //   3971: iload 14
    //   3973: istore 16
    //   3975: iload 15
    //   3977: istore 17
    //   3979: aload_1
    //   3980: ldc_w 2378
    //   3983: aload 6
    //   3985: invokevirtual 2328	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3988: pop
    //   3989: goto +1249 -> 5238
    //   3992: iload 13
    //   3994: istore 19
    //   3996: aload_1
    //   3997: astore 4
    //   3999: aload_2
    //   4000: astore_3
    //   4001: iload 14
    //   4003: istore 16
    //   4005: iload 15
    //   4007: istore 17
    //   4009: aload 5
    //   4011: ldc_w 2380
    //   4014: invokevirtual 1549	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4017: ifeq +707 -> 4724
    //   4020: iload 13
    //   4022: istore 19
    //   4024: aload_1
    //   4025: astore 4
    //   4027: aload_2
    //   4028: astore_3
    //   4029: iload 14
    //   4031: istore 16
    //   4033: iload 15
    //   4035: istore 17
    //   4037: aload 8
    //   4039: invokestatic 482	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4042: ifne -3794 -> 248
    //   4045: aload_1
    //   4046: ifnull -3798 -> 248
    //   4049: iload 13
    //   4051: istore 19
    //   4053: aload_1
    //   4054: astore 4
    //   4056: aload_2
    //   4057: astore_3
    //   4058: iload 14
    //   4060: istore 16
    //   4062: iload 15
    //   4064: istore 17
    //   4066: aload 12
    //   4068: iconst_0
    //   4069: invokeinterface 2241 2 0
    //   4074: astore 5
    //   4076: iload 13
    //   4078: istore 19
    //   4080: aload_1
    //   4081: astore 4
    //   4083: aload_2
    //   4084: astore_3
    //   4085: iload 14
    //   4087: istore 16
    //   4089: iload 15
    //   4091: istore 17
    //   4093: aload 12
    //   4095: invokeinterface 1552 1 0
    //   4100: astore 6
    //   4102: iload 13
    //   4104: istore 19
    //   4106: aload_1
    //   4107: astore 4
    //   4109: aload_2
    //   4110: astore_3
    //   4111: iload 14
    //   4113: istore 16
    //   4115: iload 15
    //   4117: istore 17
    //   4119: aload 6
    //   4121: invokestatic 482	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4124: ifeq +40 -> 4164
    //   4127: iload 13
    //   4129: istore 19
    //   4131: aload_1
    //   4132: astore 4
    //   4134: aload_2
    //   4135: astore_3
    //   4136: iload 14
    //   4138: istore 16
    //   4140: iload 15
    //   4142: istore 17
    //   4144: ldc -111
    //   4146: iconst_1
    //   4147: ldc_w 2382
    //   4150: invokestatic 1053	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4153: aload 8
    //   4155: astore 5
    //   4157: aload 7
    //   4159: astore 6
    //   4161: goto -3905 -> 256
    //   4164: iload 13
    //   4166: istore 19
    //   4168: aload_1
    //   4169: astore 4
    //   4171: aload_2
    //   4172: astore_3
    //   4173: iload 14
    //   4175: istore 16
    //   4177: iload 15
    //   4179: istore 17
    //   4181: aload 8
    //   4183: ldc_w 2321
    //   4186: invokevirtual 1549	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4189: ifeq +366 -> 4555
    //   4192: iload 13
    //   4194: istore 19
    //   4196: aload_1
    //   4197: astore 4
    //   4199: aload_2
    //   4200: astore_3
    //   4201: iload 14
    //   4203: istore 16
    //   4205: iload 15
    //   4207: istore 17
    //   4209: aload 5
    //   4211: invokestatic 482	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4214: ifne +1035 -> 5249
    //   4217: iload 13
    //   4219: istore 19
    //   4221: aload_1
    //   4222: astore 4
    //   4224: aload_2
    //   4225: astore_3
    //   4226: iload 14
    //   4228: istore 16
    //   4230: iload 15
    //   4232: istore 17
    //   4234: aload 5
    //   4236: ldc_w 2256
    //   4239: invokevirtual 1549	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4242: ifeq +144 -> 4386
    //   4245: iload 13
    //   4247: istore 19
    //   4249: aload_1
    //   4250: astore 4
    //   4252: aload_2
    //   4253: astore_3
    //   4254: iload 14
    //   4256: istore 16
    //   4258: iload 15
    //   4260: istore 17
    //   4262: aload 7
    //   4264: invokestatic 482	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4267: ifne +982 -> 5249
    //   4270: iload 13
    //   4272: istore 19
    //   4274: aload_1
    //   4275: astore 4
    //   4277: aload_2
    //   4278: astore_3
    //   4279: iload 14
    //   4281: istore 16
    //   4283: iload 15
    //   4285: istore 17
    //   4287: aload 7
    //   4289: ldc_w 2323
    //   4292: invokevirtual 1549	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4295: ifeq +33 -> 4328
    //   4298: iload 13
    //   4300: istore 19
    //   4302: aload_1
    //   4303: astore 4
    //   4305: aload_2
    //   4306: astore_3
    //   4307: iload 14
    //   4309: istore 16
    //   4311: iload 15
    //   4313: istore 17
    //   4315: aload_1
    //   4316: ldc_w 2384
    //   4319: aload 6
    //   4321: invokevirtual 2328	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   4324: pop
    //   4325: goto +924 -> 5249
    //   4328: iload 13
    //   4330: istore 19
    //   4332: aload_1
    //   4333: astore 4
    //   4335: aload_2
    //   4336: astore_3
    //   4337: iload 14
    //   4339: istore 16
    //   4341: iload 15
    //   4343: istore 17
    //   4345: aload 7
    //   4347: ldc_w 2330
    //   4350: invokevirtual 1549	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4353: ifeq +896 -> 5249
    //   4356: iload 13
    //   4358: istore 19
    //   4360: aload_1
    //   4361: astore 4
    //   4363: aload_2
    //   4364: astore_3
    //   4365: iload 14
    //   4367: istore 16
    //   4369: iload 15
    //   4371: istore 17
    //   4373: aload_1
    //   4374: ldc_w 2386
    //   4377: aload 6
    //   4379: invokevirtual 2328	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   4382: pop
    //   4383: goto +866 -> 5249
    //   4386: iload 13
    //   4388: istore 19
    //   4390: aload_1
    //   4391: astore 4
    //   4393: aload_2
    //   4394: astore_3
    //   4395: iload 14
    //   4397: istore 16
    //   4399: iload 15
    //   4401: istore 17
    //   4403: aload 5
    //   4405: ldc_w 2297
    //   4408: invokevirtual 1549	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4411: ifeq +838 -> 5249
    //   4414: iload 13
    //   4416: istore 19
    //   4418: aload_1
    //   4419: astore 4
    //   4421: aload_2
    //   4422: astore_3
    //   4423: iload 14
    //   4425: istore 16
    //   4427: iload 15
    //   4429: istore 17
    //   4431: aload 7
    //   4433: invokestatic 482	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4436: ifne +813 -> 5249
    //   4439: iload 13
    //   4441: istore 19
    //   4443: aload_1
    //   4444: astore 4
    //   4446: aload_2
    //   4447: astore_3
    //   4448: iload 14
    //   4450: istore 16
    //   4452: iload 15
    //   4454: istore 17
    //   4456: aload 7
    //   4458: ldc_w 2323
    //   4461: invokevirtual 1549	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4464: ifeq +33 -> 4497
    //   4467: iload 13
    //   4469: istore 19
    //   4471: aload_1
    //   4472: astore 4
    //   4474: aload_2
    //   4475: astore_3
    //   4476: iload 14
    //   4478: istore 16
    //   4480: iload 15
    //   4482: istore 17
    //   4484: aload_1
    //   4485: ldc_w 2388
    //   4488: aload 6
    //   4490: invokevirtual 2328	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   4493: pop
    //   4494: goto +755 -> 5249
    //   4497: iload 13
    //   4499: istore 19
    //   4501: aload_1
    //   4502: astore 4
    //   4504: aload_2
    //   4505: astore_3
    //   4506: iload 14
    //   4508: istore 16
    //   4510: iload 15
    //   4512: istore 17
    //   4514: aload 7
    //   4516: ldc_w 2330
    //   4519: invokevirtual 1549	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4522: ifeq +727 -> 5249
    //   4525: iload 13
    //   4527: istore 19
    //   4529: aload_1
    //   4530: astore 4
    //   4532: aload_2
    //   4533: astore_3
    //   4534: iload 14
    //   4536: istore 16
    //   4538: iload 15
    //   4540: istore 17
    //   4542: aload_1
    //   4543: ldc_w 2390
    //   4546: aload 6
    //   4548: invokevirtual 2328	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   4551: pop
    //   4552: goto +697 -> 5249
    //   4555: iload 13
    //   4557: istore 19
    //   4559: aload_1
    //   4560: astore 4
    //   4562: aload_2
    //   4563: astore_3
    //   4564: iload 14
    //   4566: istore 16
    //   4568: iload 15
    //   4570: istore 17
    //   4572: aload 8
    //   4574: ldc_w 2338
    //   4577: invokevirtual 1549	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4580: ifeq +669 -> 5249
    //   4583: iload 13
    //   4585: istore 19
    //   4587: aload_1
    //   4588: astore 4
    //   4590: aload_2
    //   4591: astore_3
    //   4592: iload 14
    //   4594: istore 16
    //   4596: iload 15
    //   4598: istore 17
    //   4600: aload 5
    //   4602: invokestatic 482	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4605: ifne +644 -> 5249
    //   4608: iload 13
    //   4610: istore 19
    //   4612: aload_1
    //   4613: astore 4
    //   4615: aload_2
    //   4616: astore_3
    //   4617: iload 14
    //   4619: istore 16
    //   4621: iload 15
    //   4623: istore 17
    //   4625: aload 5
    //   4627: ldc_w 2256
    //   4630: invokevirtual 1549	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4633: ifeq +33 -> 4666
    //   4636: iload 13
    //   4638: istore 19
    //   4640: aload_1
    //   4641: astore 4
    //   4643: aload_2
    //   4644: astore_3
    //   4645: iload 14
    //   4647: istore 16
    //   4649: iload 15
    //   4651: istore 17
    //   4653: aload_1
    //   4654: ldc_w 2392
    //   4657: aload 6
    //   4659: invokevirtual 2328	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   4662: pop
    //   4663: goto +586 -> 5249
    //   4666: iload 13
    //   4668: istore 19
    //   4670: aload_1
    //   4671: astore 4
    //   4673: aload_2
    //   4674: astore_3
    //   4675: iload 14
    //   4677: istore 16
    //   4679: iload 15
    //   4681: istore 17
    //   4683: aload 5
    //   4685: ldc_w 2297
    //   4688: invokevirtual 1549	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4691: ifeq +558 -> 5249
    //   4694: iload 13
    //   4696: istore 19
    //   4698: aload_1
    //   4699: astore 4
    //   4701: aload_2
    //   4702: astore_3
    //   4703: iload 14
    //   4705: istore 16
    //   4707: iload 15
    //   4709: istore 17
    //   4711: aload_1
    //   4712: ldc_w 2394
    //   4715: aload 6
    //   4717: invokevirtual 2328	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   4720: pop
    //   4721: goto +528 -> 5249
    //   4724: iload 13
    //   4726: istore 19
    //   4728: aload_1
    //   4729: astore 4
    //   4731: aload_2
    //   4732: astore_3
    //   4733: iload 14
    //   4735: istore 16
    //   4737: iload 15
    //   4739: istore 17
    //   4741: aload 5
    //   4743: ldc_w 2396
    //   4746: invokevirtual 1549	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4749: ifeq -4501 -> 248
    //   4752: iload 13
    //   4754: istore 19
    //   4756: aload_1
    //   4757: astore 4
    //   4759: aload_2
    //   4760: astore_3
    //   4761: iload 14
    //   4763: istore 16
    //   4765: iload 15
    //   4767: istore 17
    //   4769: aload 8
    //   4771: invokestatic 482	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4774: ifne -4526 -> 248
    //   4777: aload_1
    //   4778: ifnull -4530 -> 248
    //   4781: iload 13
    //   4783: istore 19
    //   4785: aload_1
    //   4786: astore 4
    //   4788: aload_2
    //   4789: astore_3
    //   4790: iload 14
    //   4792: istore 16
    //   4794: iload 15
    //   4796: istore 17
    //   4798: aload 12
    //   4800: iconst_0
    //   4801: invokeinterface 2241 2 0
    //   4806: astore 5
    //   4808: iload 13
    //   4810: istore 19
    //   4812: aload_1
    //   4813: astore 4
    //   4815: aload_2
    //   4816: astore_3
    //   4817: iload 14
    //   4819: istore 16
    //   4821: iload 15
    //   4823: istore 17
    //   4825: aload 12
    //   4827: invokeinterface 1552 1 0
    //   4832: astore 6
    //   4834: iload 13
    //   4836: istore 19
    //   4838: aload_1
    //   4839: astore 4
    //   4841: aload_2
    //   4842: astore_3
    //   4843: iload 14
    //   4845: istore 16
    //   4847: iload 15
    //   4849: istore 17
    //   4851: aload 6
    //   4853: invokestatic 482	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4856: ifeq +40 -> 4896
    //   4859: iload 13
    //   4861: istore 19
    //   4863: aload_1
    //   4864: astore 4
    //   4866: aload_2
    //   4867: astore_3
    //   4868: iload 14
    //   4870: istore 16
    //   4872: iload 15
    //   4874: istore 17
    //   4876: ldc -111
    //   4878: iconst_1
    //   4879: ldc_w 2398
    //   4882: invokestatic 1053	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4885: aload 8
    //   4887: astore 5
    //   4889: aload 7
    //   4891: astore 6
    //   4893: goto -4637 -> 256
    //   4896: iload 13
    //   4898: istore 19
    //   4900: aload_1
    //   4901: astore 4
    //   4903: aload_2
    //   4904: astore_3
    //   4905: iload 14
    //   4907: istore 16
    //   4909: iload 15
    //   4911: istore 17
    //   4913: aload 8
    //   4915: ldc_w 2354
    //   4918: invokevirtual 1549	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4921: ifeq +339 -> 5260
    //   4924: iload 13
    //   4926: istore 19
    //   4928: aload_1
    //   4929: astore 4
    //   4931: aload_2
    //   4932: astore_3
    //   4933: iload 14
    //   4935: istore 16
    //   4937: iload 15
    //   4939: istore 17
    //   4941: aload 5
    //   4943: invokestatic 482	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4946: ifne +314 -> 5260
    //   4949: iload 13
    //   4951: istore 19
    //   4953: aload_1
    //   4954: astore 4
    //   4956: aload_2
    //   4957: astore_3
    //   4958: iload 14
    //   4960: istore 16
    //   4962: iload 15
    //   4964: istore 17
    //   4966: aload 5
    //   4968: ldc_w 2256
    //   4971: invokevirtual 1549	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4974: ifeq +33 -> 5007
    //   4977: iload 13
    //   4979: istore 19
    //   4981: aload_1
    //   4982: astore 4
    //   4984: aload_2
    //   4985: astore_3
    //   4986: iload 14
    //   4988: istore 16
    //   4990: iload 15
    //   4992: istore 17
    //   4994: aload_1
    //   4995: ldc_w 2400
    //   4998: aload 6
    //   5000: invokevirtual 2328	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   5003: pop
    //   5004: goto +256 -> 5260
    //   5007: iload 13
    //   5009: istore 19
    //   5011: aload_1
    //   5012: astore 4
    //   5014: aload_2
    //   5015: astore_3
    //   5016: iload 14
    //   5018: istore 16
    //   5020: iload 15
    //   5022: istore 17
    //   5024: aload 5
    //   5026: ldc_w 2297
    //   5029: invokevirtual 1549	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   5032: ifeq +228 -> 5260
    //   5035: iload 13
    //   5037: istore 19
    //   5039: aload_1
    //   5040: astore 4
    //   5042: aload_2
    //   5043: astore_3
    //   5044: iload 14
    //   5046: istore 16
    //   5048: iload 15
    //   5050: istore 17
    //   5052: aload_1
    //   5053: ldc_w 2402
    //   5056: aload 6
    //   5058: invokevirtual 2328	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   5061: pop
    //   5062: goto +198 -> 5260
    //   5065: iload 13
    //   5067: istore 19
    //   5069: aload_1
    //   5070: astore 4
    //   5072: aload_2
    //   5073: astore_3
    //   5074: iload 14
    //   5076: istore 16
    //   5078: iload 15
    //   5080: istore 17
    //   5082: aload 5
    //   5084: ldc_w 2253
    //   5087: invokevirtual 1549	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   5090: ifeq +13 -> 5103
    //   5093: aconst_null
    //   5094: astore 6
    //   5096: aload 8
    //   5098: astore 5
    //   5100: goto -4844 -> 256
    //   5103: iload 13
    //   5105: istore 19
    //   5107: aload_1
    //   5108: astore 4
    //   5110: aload_2
    //   5111: astore_3
    //   5112: iload 14
    //   5114: istore 16
    //   5116: iload 15
    //   5118: istore 17
    //   5120: aload 5
    //   5122: ldc_w 2254
    //   5125: invokevirtual 1549	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   5128: istore 23
    //   5130: iload 23
    //   5132: ifeq -4884 -> 248
    //   5135: aload 7
    //   5137: ifnonnull -4889 -> 248
    //   5140: aconst_null
    //   5141: astore 5
    //   5143: aload 7
    //   5145: astore 6
    //   5147: goto -4891 -> 256
    //   5150: astore_1
    //   5151: iload 16
    //   5153: istore 13
    //   5155: goto -3858 -> 1297
    //   5158: astore 7
    //   5160: iconst_0
    //   5161: istore 13
    //   5163: aconst_null
    //   5164: astore_1
    //   5165: aload 5
    //   5167: astore_2
    //   5168: goto -3993 -> 1175
    //   5171: astore 7
    //   5173: goto -3998 -> 1175
    //   5176: astore 7
    //   5178: iconst_0
    //   5179: istore 13
    //   5181: aconst_null
    //   5182: astore_1
    //   5183: goto -4331 -> 852
    //   5186: astore 7
    //   5188: goto -4336 -> 852
    //   5191: goto +25 -> 5216
    //   5194: aload 8
    //   5196: astore 5
    //   5198: aload 7
    //   5200: astore 6
    //   5202: goto -4946 -> 256
    //   5205: aload 8
    //   5207: astore 5
    //   5209: aload 7
    //   5211: astore 6
    //   5213: goto -4957 -> 256
    //   5216: aload 8
    //   5218: astore 5
    //   5220: aload 7
    //   5222: astore 6
    //   5224: goto -4968 -> 256
    //   5227: aload 8
    //   5229: astore 5
    //   5231: aload 7
    //   5233: astore 6
    //   5235: goto -4979 -> 256
    //   5238: aload 8
    //   5240: astore 5
    //   5242: aload 7
    //   5244: astore 6
    //   5246: goto -4990 -> 256
    //   5249: aload 8
    //   5251: astore 5
    //   5253: aload 7
    //   5255: astore 6
    //   5257: goto -5001 -> 256
    //   5260: aload 8
    //   5262: astore 5
    //   5264: aload 7
    //   5266: astore 6
    //   5268: goto -5012 -> 256
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	5271	0	this	ConfigServlet
    //   0	5271	1	paramString	String
    //   41	5127	2	localObject1	Object
    //   79	5033	3	localObject2	Object
    //   75	5034	4	localObject3	Object
    //   43	5220	5	localObject4	Object
    //   49	5218	6	localObject5	Object
    //   64	652	7	localObject6	Object
    //   850	77	7	localNumberFormatException1	NumberFormatException
    //   1173	3971	7	localIOException1	IOException
    //   5158	1	7	localIOException2	IOException
    //   5171	1	7	localIOException3	IOException
    //   5176	1	7	localNumberFormatException2	NumberFormatException
    //   5186	79	7	localNumberFormatException3	NumberFormatException
    //   67	5194	8	localObject7	Object
    //   52	89	9	localObject8	Object
    //   46	99	10	localObject9	Object
    //   16	1740	11	localPstnManager	com.tencent.mobileqq.qcall.PstnManager
    //   91	4735	12	localXmlPullParser	XmlPullParser
    //   61	5119	13	i1	int
    //   58	5055	14	i2	int
    //   55	5062	15	i3	int
    //   86	5066	16	i4	int
    //   82	5037	17	i5	int
    //   71	1944	18	i6	int
    //   198	4908	19	i7	int
    //   188	1179	20	i8	int
    //   174	1092	21	i9	int
    //   162	119	22	i10	int
    //   5128	3	23	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   213	222	850	java/lang/NumberFormatException
    //   310	321	850	java/lang/NumberFormatException
    //   338	348	850	java/lang/NumberFormatException
    //   365	373	850	java/lang/NumberFormatException
    //   390	401	850	java/lang/NumberFormatException
    //   418	427	850	java/lang/NumberFormatException
    //   450	461	850	java/lang/NumberFormatException
    //   478	487	850	java/lang/NumberFormatException
    //   510	521	850	java/lang/NumberFormatException
    //   544	555	850	java/lang/NumberFormatException
    //   572	582	850	java/lang/NumberFormatException
    //   606	617	850	java/lang/NumberFormatException
    //   634	642	850	java/lang/NumberFormatException
    //   663	673	850	java/lang/NumberFormatException
    //   690	698	850	java/lang/NumberFormatException
    //   715	726	850	java/lang/NumberFormatException
    //   743	754	850	java/lang/NumberFormatException
    //   771	785	850	java/lang/NumberFormatException
    //   805	816	850	java/lang/NumberFormatException
    //   833	847	850	java/lang/NumberFormatException
    //   1128	1139	850	java/lang/NumberFormatException
    //   1156	1170	850	java/lang/NumberFormatException
    //   1388	1399	850	java/lang/NumberFormatException
    //   1416	1431	850	java/lang/NumberFormatException
    //   1451	1462	850	java/lang/NumberFormatException
    //   1479	1490	850	java/lang/NumberFormatException
    //   1507	1521	850	java/lang/NumberFormatException
    //   1541	1552	850	java/lang/NumberFormatException
    //   1569	1583	850	java/lang/NumberFormatException
    //   1603	1614	850	java/lang/NumberFormatException
    //   1631	1645	850	java/lang/NumberFormatException
    //   1665	1676	850	java/lang/NumberFormatException
    //   1693	1707	850	java/lang/NumberFormatException
    //   1727	1738	850	java/lang/NumberFormatException
    //   1755	1770	850	java/lang/NumberFormatException
    //   1794	1804	850	java/lang/NumberFormatException
    //   1833	1843	850	java/lang/NumberFormatException
    //   1860	1868	850	java/lang/NumberFormatException
    //   1885	1896	850	java/lang/NumberFormatException
    //   1913	1925	850	java/lang/NumberFormatException
    //   1949	1957	850	java/lang/NumberFormatException
    //   1974	1985	850	java/lang/NumberFormatException
    //   2002	2014	850	java/lang/NumberFormatException
    //   2038	2049	850	java/lang/NumberFormatException
    //   2066	2074	850	java/lang/NumberFormatException
    //   2095	2105	850	java/lang/NumberFormatException
    //   2122	2131	850	java/lang/NumberFormatException
    //   2148	2156	850	java/lang/NumberFormatException
    //   2173	2182	850	java/lang/NumberFormatException
    //   2210	2221	850	java/lang/NumberFormatException
    //   2238	2246	850	java/lang/NumberFormatException
    //   2263	2274	850	java/lang/NumberFormatException
    //   2291	2299	850	java/lang/NumberFormatException
    //   2316	2327	850	java/lang/NumberFormatException
    //   2344	2354	850	java/lang/NumberFormatException
    //   2374	2385	850	java/lang/NumberFormatException
    //   2402	2412	850	java/lang/NumberFormatException
    //   2432	2443	850	java/lang/NumberFormatException
    //   2460	2468	850	java/lang/NumberFormatException
    //   2485	2496	850	java/lang/NumberFormatException
    //   2513	2523	850	java/lang/NumberFormatException
    //   2543	2554	850	java/lang/NumberFormatException
    //   2571	2581	850	java/lang/NumberFormatException
    //   2601	2612	850	java/lang/NumberFormatException
    //   2629	2637	850	java/lang/NumberFormatException
    //   2654	2665	850	java/lang/NumberFormatException
    //   2682	2692	850	java/lang/NumberFormatException
    //   2712	2723	850	java/lang/NumberFormatException
    //   2740	2750	850	java/lang/NumberFormatException
    //   2770	2781	850	java/lang/NumberFormatException
    //   2798	2806	850	java/lang/NumberFormatException
    //   2823	2834	850	java/lang/NumberFormatException
    //   2851	2861	850	java/lang/NumberFormatException
    //   2881	2892	850	java/lang/NumberFormatException
    //   2909	2919	850	java/lang/NumberFormatException
    //   2939	2950	850	java/lang/NumberFormatException
    //   2967	2975	850	java/lang/NumberFormatException
    //   2992	3003	850	java/lang/NumberFormatException
    //   3020	3030	850	java/lang/NumberFormatException
    //   3050	3061	850	java/lang/NumberFormatException
    //   3078	3088	850	java/lang/NumberFormatException
    //   3108	3119	850	java/lang/NumberFormatException
    //   3136	3144	850	java/lang/NumberFormatException
    //   3165	3175	850	java/lang/NumberFormatException
    //   3192	3201	850	java/lang/NumberFormatException
    //   3218	3226	850	java/lang/NumberFormatException
    //   3243	3252	850	java/lang/NumberFormatException
    //   3280	3291	850	java/lang/NumberFormatException
    //   3308	3316	850	java/lang/NumberFormatException
    //   3333	3344	850	java/lang/NumberFormatException
    //   3361	3369	850	java/lang/NumberFormatException
    //   3386	3397	850	java/lang/NumberFormatException
    //   3414	3424	850	java/lang/NumberFormatException
    //   3444	3455	850	java/lang/NumberFormatException
    //   3472	3482	850	java/lang/NumberFormatException
    //   3502	3513	850	java/lang/NumberFormatException
    //   3530	3538	850	java/lang/NumberFormatException
    //   3555	3566	850	java/lang/NumberFormatException
    //   3583	3593	850	java/lang/NumberFormatException
    //   3613	3624	850	java/lang/NumberFormatException
    //   3641	3651	850	java/lang/NumberFormatException
    //   3671	3682	850	java/lang/NumberFormatException
    //   3699	3707	850	java/lang/NumberFormatException
    //   3724	3735	850	java/lang/NumberFormatException
    //   3752	3762	850	java/lang/NumberFormatException
    //   3782	3793	850	java/lang/NumberFormatException
    //   3810	3820	850	java/lang/NumberFormatException
    //   3840	3851	850	java/lang/NumberFormatException
    //   3868	3876	850	java/lang/NumberFormatException
    //   3893	3904	850	java/lang/NumberFormatException
    //   3921	3931	850	java/lang/NumberFormatException
    //   3951	3962	850	java/lang/NumberFormatException
    //   3979	3989	850	java/lang/NumberFormatException
    //   4009	4020	850	java/lang/NumberFormatException
    //   4037	4045	850	java/lang/NumberFormatException
    //   4066	4076	850	java/lang/NumberFormatException
    //   4093	4102	850	java/lang/NumberFormatException
    //   4119	4127	850	java/lang/NumberFormatException
    //   4144	4153	850	java/lang/NumberFormatException
    //   4181	4192	850	java/lang/NumberFormatException
    //   4209	4217	850	java/lang/NumberFormatException
    //   4234	4245	850	java/lang/NumberFormatException
    //   4262	4270	850	java/lang/NumberFormatException
    //   4287	4298	850	java/lang/NumberFormatException
    //   4315	4325	850	java/lang/NumberFormatException
    //   4345	4356	850	java/lang/NumberFormatException
    //   4373	4383	850	java/lang/NumberFormatException
    //   4403	4414	850	java/lang/NumberFormatException
    //   4431	4439	850	java/lang/NumberFormatException
    //   4456	4467	850	java/lang/NumberFormatException
    //   4484	4494	850	java/lang/NumberFormatException
    //   4514	4525	850	java/lang/NumberFormatException
    //   4542	4552	850	java/lang/NumberFormatException
    //   4572	4583	850	java/lang/NumberFormatException
    //   4600	4608	850	java/lang/NumberFormatException
    //   4625	4636	850	java/lang/NumberFormatException
    //   4653	4663	850	java/lang/NumberFormatException
    //   4683	4694	850	java/lang/NumberFormatException
    //   4711	4721	850	java/lang/NumberFormatException
    //   4741	4752	850	java/lang/NumberFormatException
    //   4769	4777	850	java/lang/NumberFormatException
    //   4798	4808	850	java/lang/NumberFormatException
    //   4825	4834	850	java/lang/NumberFormatException
    //   4851	4859	850	java/lang/NumberFormatException
    //   4876	4885	850	java/lang/NumberFormatException
    //   4913	4924	850	java/lang/NumberFormatException
    //   4941	4949	850	java/lang/NumberFormatException
    //   4966	4977	850	java/lang/NumberFormatException
    //   4994	5004	850	java/lang/NumberFormatException
    //   5024	5035	850	java/lang/NumberFormatException
    //   5052	5062	850	java/lang/NumberFormatException
    //   5082	5093	850	java/lang/NumberFormatException
    //   5120	5130	850	java/lang/NumberFormatException
    //   213	222	1173	java/io/IOException
    //   310	321	1173	java/io/IOException
    //   338	348	1173	java/io/IOException
    //   365	373	1173	java/io/IOException
    //   390	401	1173	java/io/IOException
    //   418	427	1173	java/io/IOException
    //   450	461	1173	java/io/IOException
    //   478	487	1173	java/io/IOException
    //   510	521	1173	java/io/IOException
    //   544	555	1173	java/io/IOException
    //   572	582	1173	java/io/IOException
    //   606	617	1173	java/io/IOException
    //   634	642	1173	java/io/IOException
    //   663	673	1173	java/io/IOException
    //   690	698	1173	java/io/IOException
    //   715	726	1173	java/io/IOException
    //   743	754	1173	java/io/IOException
    //   771	785	1173	java/io/IOException
    //   805	816	1173	java/io/IOException
    //   833	847	1173	java/io/IOException
    //   1128	1139	1173	java/io/IOException
    //   1156	1170	1173	java/io/IOException
    //   1388	1399	1173	java/io/IOException
    //   1416	1431	1173	java/io/IOException
    //   1451	1462	1173	java/io/IOException
    //   1479	1490	1173	java/io/IOException
    //   1507	1521	1173	java/io/IOException
    //   1541	1552	1173	java/io/IOException
    //   1569	1583	1173	java/io/IOException
    //   1603	1614	1173	java/io/IOException
    //   1631	1645	1173	java/io/IOException
    //   1665	1676	1173	java/io/IOException
    //   1693	1707	1173	java/io/IOException
    //   1727	1738	1173	java/io/IOException
    //   1755	1770	1173	java/io/IOException
    //   1794	1804	1173	java/io/IOException
    //   1833	1843	1173	java/io/IOException
    //   1860	1868	1173	java/io/IOException
    //   1885	1896	1173	java/io/IOException
    //   1913	1925	1173	java/io/IOException
    //   1949	1957	1173	java/io/IOException
    //   1974	1985	1173	java/io/IOException
    //   2002	2014	1173	java/io/IOException
    //   2038	2049	1173	java/io/IOException
    //   2066	2074	1173	java/io/IOException
    //   2095	2105	1173	java/io/IOException
    //   2122	2131	1173	java/io/IOException
    //   2148	2156	1173	java/io/IOException
    //   2173	2182	1173	java/io/IOException
    //   2210	2221	1173	java/io/IOException
    //   2238	2246	1173	java/io/IOException
    //   2263	2274	1173	java/io/IOException
    //   2291	2299	1173	java/io/IOException
    //   2316	2327	1173	java/io/IOException
    //   2344	2354	1173	java/io/IOException
    //   2374	2385	1173	java/io/IOException
    //   2402	2412	1173	java/io/IOException
    //   2432	2443	1173	java/io/IOException
    //   2460	2468	1173	java/io/IOException
    //   2485	2496	1173	java/io/IOException
    //   2513	2523	1173	java/io/IOException
    //   2543	2554	1173	java/io/IOException
    //   2571	2581	1173	java/io/IOException
    //   2601	2612	1173	java/io/IOException
    //   2629	2637	1173	java/io/IOException
    //   2654	2665	1173	java/io/IOException
    //   2682	2692	1173	java/io/IOException
    //   2712	2723	1173	java/io/IOException
    //   2740	2750	1173	java/io/IOException
    //   2770	2781	1173	java/io/IOException
    //   2798	2806	1173	java/io/IOException
    //   2823	2834	1173	java/io/IOException
    //   2851	2861	1173	java/io/IOException
    //   2881	2892	1173	java/io/IOException
    //   2909	2919	1173	java/io/IOException
    //   2939	2950	1173	java/io/IOException
    //   2967	2975	1173	java/io/IOException
    //   2992	3003	1173	java/io/IOException
    //   3020	3030	1173	java/io/IOException
    //   3050	3061	1173	java/io/IOException
    //   3078	3088	1173	java/io/IOException
    //   3108	3119	1173	java/io/IOException
    //   3136	3144	1173	java/io/IOException
    //   3165	3175	1173	java/io/IOException
    //   3192	3201	1173	java/io/IOException
    //   3218	3226	1173	java/io/IOException
    //   3243	3252	1173	java/io/IOException
    //   3280	3291	1173	java/io/IOException
    //   3308	3316	1173	java/io/IOException
    //   3333	3344	1173	java/io/IOException
    //   3361	3369	1173	java/io/IOException
    //   3386	3397	1173	java/io/IOException
    //   3414	3424	1173	java/io/IOException
    //   3444	3455	1173	java/io/IOException
    //   3472	3482	1173	java/io/IOException
    //   3502	3513	1173	java/io/IOException
    //   3530	3538	1173	java/io/IOException
    //   3555	3566	1173	java/io/IOException
    //   3583	3593	1173	java/io/IOException
    //   3613	3624	1173	java/io/IOException
    //   3641	3651	1173	java/io/IOException
    //   3671	3682	1173	java/io/IOException
    //   3699	3707	1173	java/io/IOException
    //   3724	3735	1173	java/io/IOException
    //   3752	3762	1173	java/io/IOException
    //   3782	3793	1173	java/io/IOException
    //   3810	3820	1173	java/io/IOException
    //   3840	3851	1173	java/io/IOException
    //   3868	3876	1173	java/io/IOException
    //   3893	3904	1173	java/io/IOException
    //   3921	3931	1173	java/io/IOException
    //   3951	3962	1173	java/io/IOException
    //   3979	3989	1173	java/io/IOException
    //   4009	4020	1173	java/io/IOException
    //   4037	4045	1173	java/io/IOException
    //   4066	4076	1173	java/io/IOException
    //   4093	4102	1173	java/io/IOException
    //   4119	4127	1173	java/io/IOException
    //   4144	4153	1173	java/io/IOException
    //   4181	4192	1173	java/io/IOException
    //   4209	4217	1173	java/io/IOException
    //   4234	4245	1173	java/io/IOException
    //   4262	4270	1173	java/io/IOException
    //   4287	4298	1173	java/io/IOException
    //   4315	4325	1173	java/io/IOException
    //   4345	4356	1173	java/io/IOException
    //   4373	4383	1173	java/io/IOException
    //   4403	4414	1173	java/io/IOException
    //   4431	4439	1173	java/io/IOException
    //   4456	4467	1173	java/io/IOException
    //   4484	4494	1173	java/io/IOException
    //   4514	4525	1173	java/io/IOException
    //   4542	4552	1173	java/io/IOException
    //   4572	4583	1173	java/io/IOException
    //   4600	4608	1173	java/io/IOException
    //   4625	4636	1173	java/io/IOException
    //   4653	4663	1173	java/io/IOException
    //   4683	4694	1173	java/io/IOException
    //   4711	4721	1173	java/io/IOException
    //   4741	4752	1173	java/io/IOException
    //   4769	4777	1173	java/io/IOException
    //   4798	4808	1173	java/io/IOException
    //   4825	4834	1173	java/io/IOException
    //   4851	4859	1173	java/io/IOException
    //   4876	4885	1173	java/io/IOException
    //   4913	4924	1173	java/io/IOException
    //   4941	4949	1173	java/io/IOException
    //   4966	4977	1173	java/io/IOException
    //   4994	5004	1173	java/io/IOException
    //   5024	5035	1173	java/io/IOException
    //   5052	5062	1173	java/io/IOException
    //   5082	5093	1173	java/io/IOException
    //   5120	5130	1173	java/io/IOException
    //   213	222	1284	org/xmlpull/v1/XmlPullParserException
    //   310	321	1284	org/xmlpull/v1/XmlPullParserException
    //   338	348	1284	org/xmlpull/v1/XmlPullParserException
    //   365	373	1284	org/xmlpull/v1/XmlPullParserException
    //   390	401	1284	org/xmlpull/v1/XmlPullParserException
    //   418	427	1284	org/xmlpull/v1/XmlPullParserException
    //   450	461	1284	org/xmlpull/v1/XmlPullParserException
    //   478	487	1284	org/xmlpull/v1/XmlPullParserException
    //   510	521	1284	org/xmlpull/v1/XmlPullParserException
    //   544	555	1284	org/xmlpull/v1/XmlPullParserException
    //   572	582	1284	org/xmlpull/v1/XmlPullParserException
    //   606	617	1284	org/xmlpull/v1/XmlPullParserException
    //   634	642	1284	org/xmlpull/v1/XmlPullParserException
    //   663	673	1284	org/xmlpull/v1/XmlPullParserException
    //   690	698	1284	org/xmlpull/v1/XmlPullParserException
    //   715	726	1284	org/xmlpull/v1/XmlPullParserException
    //   743	754	1284	org/xmlpull/v1/XmlPullParserException
    //   771	785	1284	org/xmlpull/v1/XmlPullParserException
    //   805	816	1284	org/xmlpull/v1/XmlPullParserException
    //   833	847	1284	org/xmlpull/v1/XmlPullParserException
    //   887	893	1284	org/xmlpull/v1/XmlPullParserException
    //   910	940	1284	org/xmlpull/v1/XmlPullParserException
    //   1128	1139	1284	org/xmlpull/v1/XmlPullParserException
    //   1156	1170	1284	org/xmlpull/v1/XmlPullParserException
    //   1210	1216	1284	org/xmlpull/v1/XmlPullParserException
    //   1233	1263	1284	org/xmlpull/v1/XmlPullParserException
    //   1388	1399	1284	org/xmlpull/v1/XmlPullParserException
    //   1416	1431	1284	org/xmlpull/v1/XmlPullParserException
    //   1451	1462	1284	org/xmlpull/v1/XmlPullParserException
    //   1479	1490	1284	org/xmlpull/v1/XmlPullParserException
    //   1507	1521	1284	org/xmlpull/v1/XmlPullParserException
    //   1541	1552	1284	org/xmlpull/v1/XmlPullParserException
    //   1569	1583	1284	org/xmlpull/v1/XmlPullParserException
    //   1603	1614	1284	org/xmlpull/v1/XmlPullParserException
    //   1631	1645	1284	org/xmlpull/v1/XmlPullParserException
    //   1665	1676	1284	org/xmlpull/v1/XmlPullParserException
    //   1693	1707	1284	org/xmlpull/v1/XmlPullParserException
    //   1727	1738	1284	org/xmlpull/v1/XmlPullParserException
    //   1755	1770	1284	org/xmlpull/v1/XmlPullParserException
    //   1794	1804	1284	org/xmlpull/v1/XmlPullParserException
    //   1833	1843	1284	org/xmlpull/v1/XmlPullParserException
    //   1860	1868	1284	org/xmlpull/v1/XmlPullParserException
    //   1885	1896	1284	org/xmlpull/v1/XmlPullParserException
    //   1913	1925	1284	org/xmlpull/v1/XmlPullParserException
    //   1949	1957	1284	org/xmlpull/v1/XmlPullParserException
    //   1974	1985	1284	org/xmlpull/v1/XmlPullParserException
    //   2002	2014	1284	org/xmlpull/v1/XmlPullParserException
    //   2038	2049	1284	org/xmlpull/v1/XmlPullParserException
    //   2066	2074	1284	org/xmlpull/v1/XmlPullParserException
    //   2095	2105	1284	org/xmlpull/v1/XmlPullParserException
    //   2122	2131	1284	org/xmlpull/v1/XmlPullParserException
    //   2148	2156	1284	org/xmlpull/v1/XmlPullParserException
    //   2173	2182	1284	org/xmlpull/v1/XmlPullParserException
    //   2210	2221	1284	org/xmlpull/v1/XmlPullParserException
    //   2238	2246	1284	org/xmlpull/v1/XmlPullParserException
    //   2263	2274	1284	org/xmlpull/v1/XmlPullParserException
    //   2291	2299	1284	org/xmlpull/v1/XmlPullParserException
    //   2316	2327	1284	org/xmlpull/v1/XmlPullParserException
    //   2344	2354	1284	org/xmlpull/v1/XmlPullParserException
    //   2374	2385	1284	org/xmlpull/v1/XmlPullParserException
    //   2402	2412	1284	org/xmlpull/v1/XmlPullParserException
    //   2432	2443	1284	org/xmlpull/v1/XmlPullParserException
    //   2460	2468	1284	org/xmlpull/v1/XmlPullParserException
    //   2485	2496	1284	org/xmlpull/v1/XmlPullParserException
    //   2513	2523	1284	org/xmlpull/v1/XmlPullParserException
    //   2543	2554	1284	org/xmlpull/v1/XmlPullParserException
    //   2571	2581	1284	org/xmlpull/v1/XmlPullParserException
    //   2601	2612	1284	org/xmlpull/v1/XmlPullParserException
    //   2629	2637	1284	org/xmlpull/v1/XmlPullParserException
    //   2654	2665	1284	org/xmlpull/v1/XmlPullParserException
    //   2682	2692	1284	org/xmlpull/v1/XmlPullParserException
    //   2712	2723	1284	org/xmlpull/v1/XmlPullParserException
    //   2740	2750	1284	org/xmlpull/v1/XmlPullParserException
    //   2770	2781	1284	org/xmlpull/v1/XmlPullParserException
    //   2798	2806	1284	org/xmlpull/v1/XmlPullParserException
    //   2823	2834	1284	org/xmlpull/v1/XmlPullParserException
    //   2851	2861	1284	org/xmlpull/v1/XmlPullParserException
    //   2881	2892	1284	org/xmlpull/v1/XmlPullParserException
    //   2909	2919	1284	org/xmlpull/v1/XmlPullParserException
    //   2939	2950	1284	org/xmlpull/v1/XmlPullParserException
    //   2967	2975	1284	org/xmlpull/v1/XmlPullParserException
    //   2992	3003	1284	org/xmlpull/v1/XmlPullParserException
    //   3020	3030	1284	org/xmlpull/v1/XmlPullParserException
    //   3050	3061	1284	org/xmlpull/v1/XmlPullParserException
    //   3078	3088	1284	org/xmlpull/v1/XmlPullParserException
    //   3108	3119	1284	org/xmlpull/v1/XmlPullParserException
    //   3136	3144	1284	org/xmlpull/v1/XmlPullParserException
    //   3165	3175	1284	org/xmlpull/v1/XmlPullParserException
    //   3192	3201	1284	org/xmlpull/v1/XmlPullParserException
    //   3218	3226	1284	org/xmlpull/v1/XmlPullParserException
    //   3243	3252	1284	org/xmlpull/v1/XmlPullParserException
    //   3280	3291	1284	org/xmlpull/v1/XmlPullParserException
    //   3308	3316	1284	org/xmlpull/v1/XmlPullParserException
    //   3333	3344	1284	org/xmlpull/v1/XmlPullParserException
    //   3361	3369	1284	org/xmlpull/v1/XmlPullParserException
    //   3386	3397	1284	org/xmlpull/v1/XmlPullParserException
    //   3414	3424	1284	org/xmlpull/v1/XmlPullParserException
    //   3444	3455	1284	org/xmlpull/v1/XmlPullParserException
    //   3472	3482	1284	org/xmlpull/v1/XmlPullParserException
    //   3502	3513	1284	org/xmlpull/v1/XmlPullParserException
    //   3530	3538	1284	org/xmlpull/v1/XmlPullParserException
    //   3555	3566	1284	org/xmlpull/v1/XmlPullParserException
    //   3583	3593	1284	org/xmlpull/v1/XmlPullParserException
    //   3613	3624	1284	org/xmlpull/v1/XmlPullParserException
    //   3641	3651	1284	org/xmlpull/v1/XmlPullParserException
    //   3671	3682	1284	org/xmlpull/v1/XmlPullParserException
    //   3699	3707	1284	org/xmlpull/v1/XmlPullParserException
    //   3724	3735	1284	org/xmlpull/v1/XmlPullParserException
    //   3752	3762	1284	org/xmlpull/v1/XmlPullParserException
    //   3782	3793	1284	org/xmlpull/v1/XmlPullParserException
    //   3810	3820	1284	org/xmlpull/v1/XmlPullParserException
    //   3840	3851	1284	org/xmlpull/v1/XmlPullParserException
    //   3868	3876	1284	org/xmlpull/v1/XmlPullParserException
    //   3893	3904	1284	org/xmlpull/v1/XmlPullParserException
    //   3921	3931	1284	org/xmlpull/v1/XmlPullParserException
    //   3951	3962	1284	org/xmlpull/v1/XmlPullParserException
    //   3979	3989	1284	org/xmlpull/v1/XmlPullParserException
    //   4009	4020	1284	org/xmlpull/v1/XmlPullParserException
    //   4037	4045	1284	org/xmlpull/v1/XmlPullParserException
    //   4066	4076	1284	org/xmlpull/v1/XmlPullParserException
    //   4093	4102	1284	org/xmlpull/v1/XmlPullParserException
    //   4119	4127	1284	org/xmlpull/v1/XmlPullParserException
    //   4144	4153	1284	org/xmlpull/v1/XmlPullParserException
    //   4181	4192	1284	org/xmlpull/v1/XmlPullParserException
    //   4209	4217	1284	org/xmlpull/v1/XmlPullParserException
    //   4234	4245	1284	org/xmlpull/v1/XmlPullParserException
    //   4262	4270	1284	org/xmlpull/v1/XmlPullParserException
    //   4287	4298	1284	org/xmlpull/v1/XmlPullParserException
    //   4315	4325	1284	org/xmlpull/v1/XmlPullParserException
    //   4345	4356	1284	org/xmlpull/v1/XmlPullParserException
    //   4373	4383	1284	org/xmlpull/v1/XmlPullParserException
    //   4403	4414	1284	org/xmlpull/v1/XmlPullParserException
    //   4431	4439	1284	org/xmlpull/v1/XmlPullParserException
    //   4456	4467	1284	org/xmlpull/v1/XmlPullParserException
    //   4484	4494	1284	org/xmlpull/v1/XmlPullParserException
    //   4514	4525	1284	org/xmlpull/v1/XmlPullParserException
    //   4542	4552	1284	org/xmlpull/v1/XmlPullParserException
    //   4572	4583	1284	org/xmlpull/v1/XmlPullParserException
    //   4600	4608	1284	org/xmlpull/v1/XmlPullParserException
    //   4625	4636	1284	org/xmlpull/v1/XmlPullParserException
    //   4653	4663	1284	org/xmlpull/v1/XmlPullParserException
    //   4683	4694	1284	org/xmlpull/v1/XmlPullParserException
    //   4711	4721	1284	org/xmlpull/v1/XmlPullParserException
    //   4741	4752	1284	org/xmlpull/v1/XmlPullParserException
    //   4769	4777	1284	org/xmlpull/v1/XmlPullParserException
    //   4798	4808	1284	org/xmlpull/v1/XmlPullParserException
    //   4825	4834	1284	org/xmlpull/v1/XmlPullParserException
    //   4851	4859	1284	org/xmlpull/v1/XmlPullParserException
    //   4876	4885	1284	org/xmlpull/v1/XmlPullParserException
    //   4913	4924	1284	org/xmlpull/v1/XmlPullParserException
    //   4941	4949	1284	org/xmlpull/v1/XmlPullParserException
    //   4966	4977	1284	org/xmlpull/v1/XmlPullParserException
    //   4994	5004	1284	org/xmlpull/v1/XmlPullParserException
    //   5024	5035	1284	org/xmlpull/v1/XmlPullParserException
    //   5052	5062	1284	org/xmlpull/v1/XmlPullParserException
    //   5082	5093	1284	org/xmlpull/v1/XmlPullParserException
    //   5120	5130	1284	org/xmlpull/v1/XmlPullParserException
    //   88	93	5150	org/xmlpull/v1/XmlPullParserException
    //   112	136	5150	org/xmlpull/v1/XmlPullParserException
    //   155	164	5150	org/xmlpull/v1/XmlPullParserException
    //   273	282	5150	org/xmlpull/v1/XmlPullParserException
    //   112	136	5158	java/io/IOException
    //   155	164	5158	java/io/IOException
    //   273	282	5171	java/io/IOException
    //   112	136	5176	java/lang/NumberFormatException
    //   155	164	5176	java/lang/NumberFormatException
    //   273	282	5186	java/lang/NumberFormatException
  }
  
  private void a(String paramString, int paramInt)
  {
    if (paramString == null) {
      return;
    }
    SharedPreUtils.j(getAppRuntime().getApplication(), paramInt);
    ApolloConfigUtils.a(paramString, getAppRuntime().getApplication());
  }
  
  public static boolean a(PicAndAdConf paramPicAndAdConf, String paramString, Set paramSet)
  {
    for (;;)
    {
      Document localDocument;
      String str1;
      int i1;
      long l1;
      String str2;
      String str3;
      int i3;
      Object localObject;
      long l2;
      long l3;
      boolean bool;
      try
      {
        localDocument = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(paramString.getBytes("utf-8")));
        NodeList localNodeList = localDocument.getElementsByTagName("pushbanner");
        str1 = "";
        i1 = 0;
        if (i1 < localNodeList.getLength())
        {
          l1 = Long.parseLong(localDocument.getElementsByTagName("channel").item(i1).getFirstChild().getNodeValue());
          str2 = localDocument.getElementsByTagName("img").item(i1).getFirstChild().getNodeValue();
          str3 = localDocument.getElementsByTagName("digest").item(i1).getFirstChild().getNodeValue();
          i3 = Integer.parseInt(localDocument.getElementsByTagName("weight").item(i1).getFirstChild().getNodeValue());
          localObject = localDocument.getElementsByTagName("md5").item(i1).getFirstChild();
          if (localObject != null) {
            str1 = ((Node)localObject).getNodeValue();
          }
          localObject = localDocument.getElementsByTagName("end").item(i1).getFirstChild().getNodeValue();
          SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
          l2 = localSimpleDateFormat.parse((String)localObject).getTime();
          l3 = localSimpleDateFormat.parse(localDocument.getElementsByTagName("begin").item(i1).getFirstChild().getNodeValue()).getTime();
          if (System.currentTimeMillis() > l2)
          {
            if (QLog.isColorLevel()) {
              QLog.i("SPLASH_ConfigServlet", 2, "parseXML | NearbyBanner out of date, cid = " + l1 + ", endTime = " + (String)localObject);
            }
          }
          else if (str1.length() < 15)
          {
            if (!QLog.isColorLevel()) {
              break label741;
            }
            QLog.i("SPLASH_ConfigServlet", 2, "parseXML | NearbyBanner md5 length < 15, cid = " + l1);
          }
        }
      }
      catch (Exception paramPicAndAdConf)
      {
        if (QLog.isColorLevel()) {
          QLog.i("SPLASH_ConfigServlet", 2, "parseXML | NearbyBanner parse exception,", paramPicAndAdConf);
        }
        bool = false;
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "parseNearbyBannerXml,result = " + bool + ",bannerContent =" + paramString);
        }
        return bool;
        if ((paramSet != null) && (paramSet.contains(l1 + str1)))
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("SPLASH_ConfigServlet", 2, "parseXML | NearbyBanner " + l1 + " had been closed, throw it");
          break;
        }
        localObject = new StringBuffer();
        int i2 = 0;
        while (i2 < localDocument.getElementsByTagName("url").item(i1).getChildNodes().getLength())
        {
          ((StringBuffer)localObject).append(localDocument.getElementsByTagName("url").item(i1).getChildNodes().item(i2).getNodeValue());
          i2 += 1;
        }
        paramPicAndAdConf.a(paramPicAndAdConf.a(l1, str3, (byte)3, str2, ((StringBuffer)localObject).toString(), BaseApplication.getContext().getFilesDir().getAbsolutePath() + "/" + "NearbyBannerPic" + "/" + str1, l3 + "|" + l2, (short)i3, str1));
        break;
        bool = true;
      }
      label741:
      i1 += 1;
    }
  }
  
  private static byte[] a(ConfigurationService.ReqGetConfig paramReqGetConfig)
  {
    paramReqGetConfig = paramReqGetConfig.toByteArray();
    long l1 = paramReqGetConfig.length;
    byte[] arrayOfByte = new byte[(int)l1 + 4];
    PkgTools.a(arrayOfByte, 0, 4L + l1);
    PkgTools.a(arrayOfByte, 4, paramReqGetConfig, (int)l1);
    return arrayOfByte;
  }
  
  public static byte[] a(byte[] paramArrayOfByte)
  {
    int i1 = paramArrayOfByte.length - 4;
    byte[] arrayOfByte = new byte[i1];
    PkgTools.a(arrayOfByte, 0, paramArrayOfByte, 4, i1);
    return arrayOfByte;
  }
  
  private void b(Intent paramIntent, ConfigurationService.Config paramConfig)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_configServlet", 2, "handleResp_GetArResourceConfig|type= " + paramConfig.type.get());
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)getAppRuntime();
    ArResourceManager localArResourceManager = (ArResourceManager)localQQAppInterface.getManager(167);
    int i1;
    if (paramConfig.type.get() == 87)
    {
      int i2 = paramConfig.version.get();
      if (paramIntent.getIntExtra("key_config_version", 0) != i2)
      {
        if (paramConfig.msg_content_list != null)
        {
          int i3 = paramConfig.msg_content_list.size();
          if (i3 > 0)
          {
            Intent localIntent = null;
            ArrayList localArrayList1 = new ArrayList();
            ArrayList localArrayList2 = new ArrayList();
            i1 = 0;
            if (i1 < i3)
            {
              ConfigurationService.Content localContent = (ConfigurationService.Content)paramConfig.msg_content_list.get(i1);
              int i4 = localContent.task_id.get();
              Object localObject = localContent.content.get().toByteArray();
              paramIntent = (Intent)localObject;
              if (localContent.compress.get() == 1) {
                paramIntent = ArConfigUtils.a((byte[])localObject);
              }
              if (paramIntent != null) {}
              for (;;)
              {
                try
                {
                  paramIntent = new String(paramIntent, "utf-8");
                  localObject = ArConfigInfo.parseArConfig(paramIntent);
                  if (localObject != null) {
                    if (localIntent == null)
                    {
                      paramIntent = (Intent)localObject;
                      localArrayList1.addAll(((ArConfigInfo)localObject).featureResources);
                      localArrayList2.addAll(((ArConfigInfo)localObject).modelResources);
                      if (QLog.isColorLevel()) {
                        QLog.d("ArConfig_configServlet", 2, "config loop|| taskid=" + i4 + ",endtime=" + ((ArConfigInfo)localObject).aREnd);
                      }
                      OlympicServlet.a(localQQAppInterface, 87, i2, i4, 1, 0, 0);
                      i1 += 1;
                      localIntent = paramIntent;
                    }
                  }
                }
                catch (UnsupportedEncodingException localUnsupportedEncodingException)
                {
                  localObject = null;
                  paramIntent = (Intent)localObject;
                  if (!QLog.isColorLevel()) {
                    continue;
                  }
                  QLog.d("SPLASH_ConfigServlet", 2, localUnsupportedEncodingException.getMessage());
                  paramIntent = (Intent)localObject;
                  continue;
                  paramIntent = localIntent;
                  if (localIntent.aREnd >= ((ArConfigInfo)localObject).aREnd) {
                    continue;
                  }
                  paramIntent = (Intent)localObject;
                  continue;
                  OlympicServlet.a(localQQAppInterface, 87, i2, i4, 1, 5, 0);
                  paramIntent = localIntent;
                  if (!QLog.isColorLevel()) {
                    continue;
                  }
                  QLog.d("ArConfig_configServlet", 2, "handleResp_GetArResource||parseArConfig error!");
                  paramIntent = localIntent;
                  continue;
                }
                OlympicServlet.a(localQQAppInterface, 87, i2, i4, 1, 4, 0);
                paramIntent = localIntent;
                if (QLog.isColorLevel())
                {
                  QLog.d("ArConfig_configServlet", 2, "handleResp_GetArResource||deCompress error!");
                  paramIntent = localIntent;
                }
              }
            }
            if (localIntent != null)
            {
              localIntent.featureResources = localArrayList1;
              localIntent.modelResources = localArrayList2;
              localIntent.version = i2;
              if (localArResourceManager != null)
              {
                localArResourceManager.a(localIntent);
                if (QLog.isColorLevel()) {
                  QLog.d("ArConfig_configServlet", 2, "maxEndTimeArConfigInfo|| maxEndtime=" + localIntent.aREnd);
                }
                OlympicServlet.a(localQQAppInterface, 87, i2, 0, 0, 0, 0);
              }
            }
          }
        }
        for (;;)
        {
          i1 = 0;
          if ((i1 != 0) && (localArResourceManager != null)) {
            localArResourceManager.a(true, false);
          }
          return;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("ArConfig_configServlet", 2, "handleResp_GetArResource|arManager= null");
          break;
          if (QLog.isColorLevel()) {
            QLog.d("ArConfig_configServlet", 2, "handleResp_GetArResource|combineArConfigInfo is null");
          }
          OlympicServlet.a(localQQAppInterface, 87, i2, 0, 0, 5, 0);
          continue;
          if (localArResourceManager != null) {
            localArResourceManager.a();
          }
          if (QLog.isColorLevel()) {
            QLog.d("ArConfig_configServlet", 2, "handleResp_GetArResource||msg_content_list is null!");
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("ArConfig_configServlet", 2, "handleResp_GetArResource || has same version");
      }
    }
    for (;;)
    {
      i1 = 1;
      break;
      OlympicServlet.a(localQQAppInterface, 87, 0, 0, 1, 3, 0);
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface)
  {
    if ((!d) || (!paramQQAppInterface.f().equals(k)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PushOpenNotify", 2, "initPushOpeNotifyConfig");
      }
      d = true;
      k = paramQQAppInterface.f();
      a(paramQQAppInterface, null, true);
    }
  }
  
  private void b(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    for (;;)
    {
      int i1;
      try
      {
        if ((paramConfig.content_list != null) && (paramConfig.content_list.size() > 0))
        {
          i1 = 0;
          if (i1 < paramConfig.content_list.size())
          {
            Object localObject = ((String)paramConfig.content_list.get(i1)).trim();
            if (QLog.isColorLevel()) {
              QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 96,content: " + (String)localObject + ",version: " + paramConfig.version.get());
            }
            int i2 = paramConfig.version.get();
            if ((i2 != SharedPreUtils.b(paramQQAppInterface.a(), "readinjoy_interested_push_config", h)) && (!TextUtils.isEmpty((CharSequence)localObject)))
            {
              localObject = ((String)localObject).split("=");
              if ((localObject.length >= 2) && ("xqh_insert_into_feeds".equals(localObject[0])))
              {
                ReadInJoyHelper.c(paramQQAppInterface, "1".equals(localObject[1]));
                if (QLog.isColorLevel()) {
                  QLog.d("SPLASH_ConfigServlet", 2, "update KANDIAN_INTERESTED_PUSH_CONFiG config , switch : " + "1".equals(localObject[1]));
                }
              }
              SharedPreUtils.a(paramQQAppInterface.a(), "readinjoy_interested_push_config", h, i2);
            }
            else if (QLog.isColorLevel())
            {
              QLog.d("SPLASH_ConfigServlet", 2, "received KANDIAN_INTERESTED_PUSH_CONFiG IGNORE THIS ACTION  because of SAME VERSION ");
            }
          }
        }
      }
      catch (Exception paramQQAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.e("SPLASH_ConfigServlet", 2, "received readinjoy interested push config error,cmd : 96" + paramQQAppInterface.toString());
        }
      }
      do
      {
        return;
      } while (!QLog.isColorLevel());
      QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 96,content_list is empty ,version: " + paramConfig.version.get());
      return;
      i1 += 1;
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString)
  {
    h = paramString;
    NewIntent localNewIntent = new NewIntent(paramQQAppInterface.a(), ConfigServlet.class);
    localNewIntent.putExtra("k_cmd_type", jdField_a_of_type_ArrayOfInt);
    localNewIntent.putExtra("key_uin", paramString);
    paramQQAppInterface.startServlet(localNewIntent);
  }
  
  private void b(ConfigurationService.Config paramConfig, QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SPLASH_ConfigServlet", 2, "received PUBLIC_ACCOUNT_CENTER_URL_CONFIG_CMD response");
    }
    label293:
    do
    {
      int i1;
      int i2;
      do
      {
        Iterator localIterator;
        for (;;)
        {
          String str;
          try
          {
            if ((paramConfig.content_list == null) || (paramConfig.content_list.size() <= 0)) {
              break label293;
            }
            i1 = paramConfig.version.get();
            i2 = PublicAccountConfigUtil.b(paramQQAppInterface);
            if (i1 == i2) {
              break;
            }
            localIterator = paramConfig.content_list.get().iterator();
            if (localIterator.hasNext())
            {
              str = (String)localIterator.next();
              if (QLog.isColorLevel()) {
                QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 70, version:" + paramConfig.version.get() + ", content:" + str);
              }
              if (PublicAccountConfigUtil.b(str))
              {
                PublicAccountConfigUtil.c(paramQQAppInterface);
                PublicAccountConfigUtil.b(paramQQAppInterface, i1);
                if (!QLog.isColorLevel()) {
                  continue;
                }
                QLog.d("SPLASH_ConfigServlet", 2, "received PUBLIC_ACCOUNT_CENTER_URL_CONFIG_CMD save version: " + i1);
              }
            }
            else
            {
              return;
            }
          }
          catch (Exception paramConfig)
          {
            if (QLog.isColorLevel()) {
              QLog.e("SPLASH_ConfigServlet", 2, "received PUBLIC_ACCOUNT_CENTER_URL_CONFIG_CMD error", paramConfig);
            }
            paramConfig.printStackTrace();
          }
          if (QLog.isColorLevel()) {
            QLog.d("SPLASH_ConfigServlet", 2, "received PUBLIC_ACCOUNT_CENTER_URL_CONFIG_CMD content error:" + str);
          }
        }
      } while (!QLog.isColorLevel());
      QLog.d("SPLASH_ConfigServlet", 2, "received PUBLIC_ACCOUNT_CENTER_URL_CONFIG_CMD remote version: " + i1 + " | localVersion: " + i2);
      return;
    } while (!QLog.isColorLevel());
    QLog.d("SPLASH_ConfigServlet", 2, "received PUBLIC_ACCOUNT_CENTER_URL_CONFIG_CMD content_list is empty");
  }
  
  private void b(String paramString, int paramInt)
  {
    for (int i1 = 1;; i1 = 0) {
      for (;;)
      {
        try
        {
          localObject = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(paramString.getBytes("utf-8")));
          str1 = ((Document)localObject).getElementsByTagName("location").item(0).getFirstChild().getNodeValue();
          str2 = ((Document)localObject).getElementsByTagName("title").item(0).getFirstChild().getNodeValue();
          if (((Document)localObject).getElementsByTagName("iconUrl").item(0).getFirstChild() != null)
          {
            paramString = ((Document)localObject).getElementsByTagName("iconUrl").item(0).getFirstChild().getNodeValue();
            localObject = ((Document)localObject).getElementsByTagName("backupUrl").item(0).getFirstChild().getNodeValue();
            if ("aio".equals(str1))
            {
              if (str1 != null)
              {
                if (str2 == null) {
                  break label429;
                }
                paramInt = 1;
                continue;
                if (((i1 & paramInt) != 0) && (!"".equals(str1)) && (!"".equals(str2)) && (!"".equals(paramString)) && (localObject != null) && (!"".equals(localObject))) {
                  SharedPreUtils.c(((QQAppInterface)getAppRuntime()).a()).edit().putBoolean("aio_jump_lightalk_red_dot", true).commit();
                }
              }
              AIOJumpLightalkConfig.a(str1, str2, paramString, (String)localObject, h);
              return;
            }
            if ("profile".equals(str1))
            {
              PCJumpLightalkConfig.a(str1, str2, paramString, (String)localObject, h);
              return;
            }
          }
        }
        catch (Exception paramString)
        {
          Object localObject;
          String str1;
          String str2;
          paramString.printStackTrace();
          if (QLog.isColorLevel())
          {
            QLog.i("SPLASH_ConfigServlet", 2, "parse jump_lightalk xml  exception : " + paramString.getMessage());
            return;
            if ("call_detail".equals(str1))
            {
              CLJumpLightalkConfig.a(str1, str2, paramString, (String)localObject, h);
              return;
            }
            if ("call_list".equals(str1))
            {
              CallTabLightalkConfig.a(str1, str2, paramString, (String)localObject, h);
              return;
            }
            if ("calling".equals(str1))
            {
              QQCallLightalkConfig.a(str1, str2, paramString, (String)localObject, h);
              return;
              paramString = "";
              continue;
              if (paramString == null) {
                break;
              }
              continue;
            }
          }
          return;
        }
        label429:
        paramInt = 0;
      }
    }
  }
  
  private void c(Intent paramIntent, ConfigurationService.Config paramConfig)
  {
    paramIntent = paramIntent.getStringExtra("key_uin");
    if (!TextUtils.isEmpty(paramIntent))
    {
      int i1 = paramConfig.version.get();
      int i2 = SharedPreUtils.u(((QQAppInterface)getAppRuntime()).a(), paramIntent);
      if (QLog.isColorLevel()) {
        QLog.d("nearby_flower_operation_gray_tips", 2, "serverVersion=" + i1 + "|localVersion=" + i2);
      }
      if (i1 > i2)
      {
        SharedPreUtils.d(((QQAppInterface)getAppRuntime()).a(), paramIntent, i1);
        NearbyFlowerManager localNearbyFlowerManager = (NearbyFlowerManager)((QQAppInterface)getAppRuntime()).getManager(123);
        if ((!paramConfig.content_list.has()) || (paramConfig.content_list.get().size() <= 0)) {
          break label247;
        }
        localList = paramConfig.content_list.get();
        if ((localList != null) && (localList.size() > 0))
        {
          localNearbyFlowerManager.a(paramIntent, (String)localList.get(0));
          if (QLog.isColorLevel()) {
            QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 53,content: " + (String)localList.get(0) + ",version: " + paramConfig.version.get());
          }
        }
      }
    }
    label247:
    while (!QLog.isColorLevel())
    {
      List localList;
      return;
    }
    QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 53,content_list is empty ,version: " + paramConfig.version.get());
  }
  
  private void c(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    for (;;)
    {
      int i1;
      try
      {
        if ((paramConfig.content_list != null) && (paramConfig.content_list.size() > 0))
        {
          i1 = 0;
          if (i1 < paramConfig.content_list.size())
          {
            Object localObject = ((String)paramConfig.content_list.get(i1)).trim();
            if (QLog.isColorLevel()) {
              QLog.d("SPLASH_ConfigServletQ.qqstory.TAG_NOW_ENTRANCE_ACTION_CONFIG", 2, "receiveAllConfigs|type: 118,content: " + (String)localObject + ",version: " + paramConfig.version.get());
            }
            int i3 = paramConfig.version.get();
            if (i3 != SharedPreUtils.b(paramQQAppInterface.a(), "now_entrance_action_version", h))
            {
              boolean bool = TextUtils.isEmpty((CharSequence)localObject);
              if (!bool) {
                try
                {
                  localObject = new JSONArray((String)localObject);
                  int i4 = ((JSONArray)localObject).length();
                  int i2 = 0;
                  if (i2 < i4)
                  {
                    JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(i2);
                    SharedPreUtils.a(paramQQAppInterface.a(), paramQQAppInterface.a(), localJSONObject.optInt("bid"), localJSONObject.optInt("actionType"));
                    i2 += 1;
                    continue;
                  }
                  if (!QLog.isColorLevel()) {
                    break label336;
                  }
                }
                catch (JSONException localJSONException)
                {
                  if (QLog.isColorLevel()) {
                    QLog.e("SPLASH_ConfigServletQ.qqstory.TAG_NOW_ENTRANCE_ACTION_CONFIG", 2, "received JSONException ");
                  }
                  SharedPreUtils.a(paramQQAppInterface.a(), "now_entrance_action_version", h, i3);
                }
              }
            }
            QLog.d("SPLASH_ConfigServletQ.qqstory.TAG_NOW_ENTRANCE_ACTION_CONFIG", 2, "received CHNAGE_MACHINE_CONFIG IGNORE THIS ACTION  because of SAME VERSION ");
          }
        }
      }
      catch (Exception paramQQAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.e("SPLASH_ConfigServletQ.qqstory.TAG_NOW_ENTRANCE_ACTION_CONFIG", 2, "received change machine config error,cmd : 118" + paramQQAppInterface.toString());
        }
      }
      do
      {
        return;
      } while (!QLog.isColorLevel());
      QLog.d("SPLASH_ConfigServletQ.qqstory.TAG_NOW_ENTRANCE_ACTION_CONFIG", 2, "receiveAllConfigs|type: 118,content_list is empty ,version: " + paramConfig.version.get());
      return;
      label336:
      i1 += 1;
    }
  }
  
  public static void c(QQAppInterface paramQQAppInterface, String paramString)
  {
    h = paramString;
    NewIntent localNewIntent = new NewIntent(paramQQAppInterface.a(), ConfigServlet.class);
    localNewIntent.putExtra("k_cmd_type", new int[] { 34 });
    localNewIntent.putExtra("key_uin", paramString);
    paramQQAppInterface.startServlet(localNewIntent);
  }
  
  private void c(String paramString, int paramInt)
  {
    try
    {
      Object localObject = a(new ByteArrayInputStream(paramString.getBytes("utf-8")));
      if (localObject != null)
      {
        paramString = ((String)localObject).substring(((String)localObject).indexOf("<?xml"), ((String)localObject).indexOf("</msg><msg")) + "</msg>";
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "qav_upgrade_invite msg1 = " + paramString);
        }
        String str = ((String)localObject).substring(((String)localObject).indexOf("<?xml"), ((String)localObject).indexOf("?>")) + "?>";
        localObject = ((String)localObject).substring(((String)localObject).indexOf("</msg><msg"), ((String)localObject).lastIndexOf("</msg>"));
        str = str + ((String)localObject).substring(6) + "</msg>";
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "qav_upgrade_invite msg2 = " + str);
        }
        localObject = SharedPreUtils.d(((QQAppInterface)getAppRuntime()).a());
        ((SharedPreferences)localObject).edit().putString("qav_upgrade_invite_video", paramString).commit();
        ((SharedPreferences)localObject).edit().putString("qav_upgrade_invite_multi", str).commit();
        SharedPreUtils.o(getAppRuntime().getApplication(), paramInt, h);
      }
      return;
    }
    catch (Exception paramString)
    {
      do
      {
        paramString.printStackTrace();
      } while (!QLog.isColorLevel());
      QLog.i("SPLASH_ConfigServlet", 2, "parse qav_upgrade_invite xml  exception : " + paramString.getMessage());
    }
  }
  
  private void d(Intent paramIntent, ConfigurationService.Config paramConfig)
  {
    paramIntent = paramIntent.getStringExtra("key_uin");
    if (!TextUtils.isEmpty(paramIntent))
    {
      int i1 = paramConfig.version.get();
      int i2 = SharedPreUtils.v(((QQAppInterface)getAppRuntime()).a(), paramIntent);
      if (QLog.isColorLevel()) {
        QLog.d("HotChatManager", 2, "serverVersion=" + i1 + "|localVersion=" + i2);
      }
      if (i1 > i2)
      {
        SharedPreUtils.e(((QQAppInterface)getAppRuntime()).a(), paramIntent, i1);
        HotChatManager localHotChatManager = (HotChatManager)((QQAppInterface)getAppRuntime()).getManager(59);
        if ((!paramConfig.content_list.has()) || (paramConfig.content_list.get().size() <= 0)) {
          break label247;
        }
        localList = paramConfig.content_list.get();
        if ((localList != null) && (localList.size() > 0))
        {
          localHotChatManager.a(paramIntent, (String)localList.get(0));
          if (QLog.isColorLevel()) {
            QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 78,content: " + (String)localList.get(0) + ",version: " + paramConfig.version.get());
          }
        }
      }
    }
    label247:
    while (!QLog.isColorLevel())
    {
      List localList;
      return;
    }
    QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 78,content_list is empty ,version: " + paramConfig.version.get());
  }
  
  private void d(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    for (;;)
    {
      int i1;
      try
      {
        if ((paramConfig.content_list != null) && (paramConfig.content_list.size() > 0))
        {
          i1 = 0;
          if (i1 < paramConfig.content_list.size())
          {
            String str = ((String)paramConfig.content_list.get(i1)).trim();
            if (QLog.isColorLevel()) {
              QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 120,content: " + str + ",version: " + paramConfig.version.get());
            }
            int i2 = paramConfig.version.get();
            if ((i2 != SharedPreUtils.b(paramQQAppInterface.a(), "change_machine_version", h)) && (!TextUtils.isEmpty(str)))
            {
              ((ChangeMachineManager)paramQQAppInterface.getManager(182)).a(str);
              SharedPreUtils.a(paramQQAppInterface.a(), "change_machine_version", h, i2);
            }
            else if (QLog.isColorLevel())
            {
              QLog.d("SPLASH_ConfigServlet", 2, "received CHNAGE_MACHINE_CONFIG IGNORE THIS ACTION  because of SAME VERSION ");
            }
          }
        }
      }
      catch (Exception paramQQAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.e("SPLASH_ConfigServlet", 2, "received change machine config error,cmd : 120" + paramQQAppInterface.toString());
        }
      }
      do
      {
        return;
      } while (!QLog.isColorLevel());
      QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 120,content_list is empty ,version: " + paramConfig.version.get());
      return;
      i1 += 1;
    }
  }
  
  public static void d(QQAppInterface paramQQAppInterface, String paramString)
  {
    h = paramString;
    a(paramQQAppInterface, 17);
  }
  
  private void d(String paramString, int paramInt)
  {
    try
    {
      paramString = a(new ByteArrayInputStream(paramString.getBytes("utf-8")));
      if (paramString != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "qav_anychat_time_limit stream = " + paramString);
        }
        SharedPreUtils.e(((QQAppInterface)getAppRuntime()).a()).edit().putString("qav_anychat_time_value", paramString).commit();
        SharedPreUtils.p(getAppRuntime().getApplication(), paramInt, h);
      }
      return;
    }
    catch (Exception paramString)
    {
      do
      {
        paramString.printStackTrace();
      } while (!QLog.isColorLevel());
      QLog.i("SPLASH_ConfigServlet", 2, "parse qav_anychat_time_limit  exception : " + paramString.getMessage());
    }
  }
  
  private void e(Intent paramIntent, ConfigurationService.Config paramConfig)
  {
    Object localObject = null;
    PtvTemplateManager localPtvTemplateManager = PtvTemplateManager.a((QQAppInterface)getAppRuntime());
    int i2 = paramConfig.version.get();
    int i1 = SharedPreUtils.i(((QQAppInterface)getAppRuntime()).a());
    if (!PtvTemplateManager.b()) {
      i1 = 0;
    }
    if (QLog.isColorLevel()) {
      QLog.d(PtvTemplateManager.jdField_a_of_type_JavaLangString, 2, String.format("双人挂件配置回包, serverVersion[%s], localVersion[%s]", new Object[] { Integer.valueOf(i2), Integer.valueOf(i1) }));
    }
    byte[] arrayOfByte;
    if (i2 > i1)
    {
      paramConfig = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
      paramIntent = "";
      if (paramConfig.compress.get() != 1) {
        break label354;
      }
      arrayOfByte = OlympicUtil.a(paramConfig.content.get().toByteArray());
      if (arrayOfByte == null) {
        break label345;
      }
    }
    for (;;)
    {
      try
      {
        paramConfig = new String(arrayOfByte, "UTF-8");
        if (TextUtils.isEmpty(paramConfig)) {
          break label372;
        }
        localPtvTemplateManager.a(paramConfig, (QQAppInterface)getAppRuntime());
        SharedPreUtils.g(((QQAppInterface)getAppRuntime()).a(), i2);
        if (QLog.isColorLevel()) {
          QLog.d(PtvTemplateManager.jdField_a_of_type_JavaLangString, 2, "receiveAllConfigs|type: 双人挂件配置, content: \n" + paramConfig);
        }
        return;
      }
      catch (UnsupportedEncodingException paramIntent)
      {
        if (!QLog.isColorLevel()) {
          break label406;
        }
        paramIntent.printStackTrace();
        paramIntent = "编码失败" + paramIntent.getMessage();
        paramConfig = (ConfigurationService.Config)localObject;
        continue;
      }
      catch (OutOfMemoryError paramConfig)
      {
        if (QLog.isColorLevel())
        {
          paramConfig.printStackTrace();
          paramIntent = "内存不足" + paramConfig.getMessage();
        }
        System.gc();
      }
      try
      {
        paramConfig = new String(arrayOfByte, "UTF-8");
      }
      catch (Throwable paramIntent)
      {
        for (;;)
        {
          paramIntent = "异常" + paramIntent.getMessage();
          paramConfig = null;
        }
      }
      label345:
      paramIntent = "解压失败";
      paramConfig = (ConfigurationService.Config)localObject;
      continue;
      label354:
      paramConfig = paramConfig.content.get().toStringUtf8();
      paramIntent = "无压缩";
      continue;
      label372:
      if (QLog.isColorLevel())
      {
        QLog.d(PtvTemplateManager.jdField_a_of_type_JavaLangString, 2, "receiveAllConfigs|type: 双人挂件配置, content is empty, " + paramIntent);
        return;
        label406:
        paramIntent = "";
      }
    }
  }
  
  private void e(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    if ((paramConfig.content_list != null) && (paramConfig.content_list.size() > 0))
    {
      paramQQAppInterface = (ActivateFriendsManager)paramQQAppInterface.getManager(84);
      if (paramConfig.content_list.size() < 0)
      {
        str = (String)paramConfig.content_list.get(0);
        i1 = paramConfig.version.get();
        i2 = paramQQAppInterface.a();
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "handleActivateFriendsConfig " + str + ",version: " + paramConfig.version.get());
        }
        if ((i1 != i2) || (paramConfig.content_list.size() > 0)) {
          paramQQAppInterface.a(i1, str);
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      String str;
      int i1;
      int i2;
      return;
    }
    QLog.d("SPLASH_ConfigServlet", 2, "handleActivateFriendsConfig,content_list is empty ,version: " + paramConfig.version.get());
  }
  
  public static void e(QQAppInterface paramQQAppInterface, String paramString)
  {
    h = paramString;
    a(paramQQAppInterface, 62);
  }
  
  private void e(ConfigurationService.Config paramConfig)
  {
    int i1 = paramConfig.version.get();
    int i2 = SharedPreUtils.G(((QQAppInterface)getAppRuntime()).a(), h);
    if (QLog.isColorLevel()) {
      QLog.i("SPLASH_ConfigServlet", 2, "pstn_switch_wording_config_version serverVersion=" + i1 + "|localVersion=" + i2);
    }
    if (i1 > i2)
    {
      SharedPreUtils.m(((QQAppInterface)getAppRuntime()).a(), h, i1);
      if ((paramConfig.content_list.get() == null) || (paramConfig.content_list.get().size() <= 0)) {
        break label235;
      }
      localStringBuilder = new StringBuilder(512);
      localStringBuilder.append("receiveAllConfigs|type: ").append(60);
      localIterator = paramConfig.content_list.get().iterator();
      while (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        localStringBuilder.append(",content: ").append(str);
        a(str);
      }
      localStringBuilder.append(",version: ").append(paramConfig.version.get());
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, localStringBuilder.toString());
      }
    }
    label235:
    while (!QLog.isColorLevel())
    {
      StringBuilder localStringBuilder;
      Iterator localIterator;
      String str;
      return;
    }
    QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 60,content_list is empty ,version: " + paramConfig.version.get());
  }
  
  private void e(String paramString, int paramInt)
  {
    try
    {
      paramString = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(paramString.getBytes("utf-8")));
      Object localObject2 = (Element)paramString.getElementsByTagName("call_tab").item(0);
      String str1 = ((Element)localObject2).getElementsByTagName("wording").item(0).getFirstChild().getNodeValue();
      String str2 = ((Element)localObject2).getElementsByTagName("jump_url").item(0).getFirstChild().getNodeValue();
      Object localObject1 = ((Element)localObject2).getElementsByTagName("icon_img").item(0).getFirstChild().getNodeValue();
      localObject2 = ((Element)localObject2).getElementsByTagName("icon_md5").item(0).getFirstChild().getNodeValue();
      if (LightTalkTipsData.a(str1, str2, (String)localObject1, (String)localObject2)) {
        SharedPreUtils.a(((QQAppInterface)getAppRuntime()).a()).edit().putInt("show_tab_lightalk_tips", 0).commit();
      }
      LightTalkTipsData.a(str1, str2, (String)localObject1, (String)localObject2);
      a(new File(LightTalkTipsData.d), (String)localObject1, (String)localObject2);
      localObject1 = (Element)paramString.getElementsByTagName("aio").item(0);
      paramString = ((Element)localObject1).getElementsByTagName("wording").item(0).getFirstChild().getNodeValue();
      str1 = ((Element)localObject1).getElementsByTagName("jump_url").item(0).getFirstChild().getNodeValue();
      str2 = ((Element)localObject1).getElementsByTagName("icon_img").item(0).getFirstChild().getNodeValue();
      localObject1 = ((Element)localObject1).getElementsByTagName("icon_md5").item(0).getFirstChild().getNodeValue();
      LightalkBlueTipsBarData.a(paramString, str1);
      a(new File(LightalkBlueTipsBarData.d), str2, (String)localObject1);
      SharedPreUtils.m(getAppRuntime().getApplication(), paramInt, h);
      return;
    }
    catch (Exception paramString)
    {
      do
      {
        paramString.printStackTrace();
      } while (!QLog.isColorLevel());
      QLog.i("SPLASH_ConfigServlet", 2, "parse lightalk xml  exception : " + paramString.getMessage());
    }
  }
  
  private void f(Intent paramIntent, ConfigurationService.Config paramConfig)
  {
    paramIntent = PtvTemplateManager.a((QQAppInterface)getAppRuntime());
    int i2 = paramConfig.version.get();
    int i1 = SharedPreUtils.h(((QQAppInterface)getAppRuntime()).a());
    if (!PtvTemplateManager.a()) {
      i1 = 0;
    }
    if (QLog.isColorLevel()) {
      QLog.d(PtvTemplateManager.jdField_a_of_type_JavaLangString, 2, "serverVersion=" + i2 + "|localVersion=" + i1);
    }
    if (i2 > i1)
    {
      SharedPreUtils.f(((QQAppInterface)getAppRuntime()).a(), i2);
      if ((!paramConfig.content_list.has()) || (paramConfig.content_list.get().size() <= 0)) {
        break label237;
      }
      localList = paramConfig.content_list.get();
      if ((localList != null) && (localList.size() > 0))
      {
        paramIntent.b((String)localList.get(0), (QQAppInterface)getAppRuntime());
        if (QLog.isColorLevel()) {
          QLog.d(PtvTemplateManager.jdField_a_of_type_JavaLangString, 2, "receiveAllConfigs|type: 84,content: " + (String)localList.get(0) + ",version: " + paramConfig.version.get());
        }
      }
    }
    label237:
    while (!QLog.isColorLevel())
    {
      List localList;
      return;
    }
    QLog.d(PtvTemplateManager.jdField_a_of_type_JavaLangString, 2, "receiveAllConfigs|type: 84,content_list is empty ,version: " + paramConfig.version.get());
  }
  
  private void f(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    if ((paramConfig.content_list != null) && (paramConfig.content_list.size() > 0))
    {
      paramQQAppInterface = (PhoneContactManagerImp)paramQQAppInterface.getManager(10);
      if (paramConfig.content_list.size() < 0)
      {
        str = (String)paramConfig.content_list.get(0);
        i1 = paramConfig.version.get();
        i2 = paramQQAppInterface.f();
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 97,content: " + str + ",version: " + paramConfig.version.get());
        }
        if ((i1 != i2) || (paramConfig.content_list.size() > 0)) {
          paramQQAppInterface.a(i1, str);
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      String str;
      int i1;
      int i2;
      return;
    }
    QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 97,content_list is empty ,version: " + paramConfig.version.get());
  }
  
  public static void f(QQAppInterface paramQQAppInterface, String paramString)
  {
    h = paramString;
    a(paramQQAppInterface, 86, paramString);
    if (QLog.isColorLevel()) {
      QLog.d("Olympic.configServlet", 2, new Object[] { "ConfigServlet.getOlympicActConfig(), uin=", paramString });
    }
  }
  
  private void f(ConfigurationService.Config paramConfig)
  {
    int i1 = paramConfig.version.get();
    int i2 = SharedPreUtils.t(((QQAppInterface)getAppRuntime()).a(), h);
    if (QLog.isColorLevel()) {
      QLog.d("Q.getTroopMemberLevelInfo", 2, "handleFlowerRankColorConfigCmd, serverVersion=" + i1 + "|localVersion=" + i2);
    }
    if (i1 > i2)
    {
      if ((!paramConfig.content_list.has()) || (paramConfig.content_list.get().size() <= 0)) {
        break label177;
      }
      paramConfig = (String)paramConfig.content_list.get(0);
      if (paramConfig != null)
      {
        bool = TroopRankColorConfig.a(paramConfig);
        if (bool) {
          SharedPreUtils.c(((QQAppInterface)getAppRuntime()).a(), h, i1);
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.getTroopMemberLevelInfo", 2, "refreshConfig ret=" + bool);
        }
      }
    }
    label177:
    while (!QLog.isColorLevel())
    {
      boolean bool;
      return;
    }
    QLog.d("Q.getTroopMemberLevelInfo", 2, "config.content_list size is 0");
  }
  
  private void f(String paramString, int paramInt)
  {
    label693:
    label696:
    label705:
    for (;;)
    {
      int i1;
      long l1;
      String str1;
      String str2;
      int i3;
      Object localObject1;
      Object localObject2;
      long l2;
      long l3;
      try
      {
        Document localDocument = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(paramString.getBytes("utf-8")));
        NodeList localNodeList = localDocument.getElementsByTagName("pushbanner");
        paramString = "";
        i1 = 0;
        if (i1 < localNodeList.getLength())
        {
          l1 = Long.parseLong(localDocument.getElementsByTagName("channel").item(i1).getFirstChild().getNodeValue());
          str1 = localDocument.getElementsByTagName("img").item(i1).getFirstChild().getNodeValue();
          str2 = localDocument.getElementsByTagName("digest").item(i1).getFirstChild().getNodeValue();
          i3 = Integer.parseInt(localDocument.getElementsByTagName("weight").item(i1).getFirstChild().getNodeValue());
          localObject1 = localDocument.getElementsByTagName("md5").item(i1).getFirstChild();
          if (localObject1 != null) {
            paramString = ((Node)localObject1).getNodeValue();
          }
          localObject1 = localDocument.getElementsByTagName("end").item(i1).getFirstChild().getNodeValue();
          localObject2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
          l2 = ((SimpleDateFormat)localObject2).parse((String)localObject1).getTime();
          l3 = ((SimpleDateFormat)localObject2).parse(localDocument.getElementsByTagName("begin").item(i1).getFirstChild().getNodeValue()).getTime();
          if (System.currentTimeMillis() > l2)
          {
            if (QLog.isColorLevel()) {
              QLog.i("SPLASH_ConfigServlet", 2, "this pushbanner is outdate , throw it");
            }
          }
          else
          {
            localObject1 = new StringBuffer();
            paramInt = 0;
            if (paramInt < localDocument.getElementsByTagName("url").item(i1).getChildNodes().getLength())
            {
              ((StringBuffer)localObject1).append(localDocument.getElementsByTagName("url").item(i1).getChildNodes().item(paramInt).getNodeValue());
              paramInt += 1;
              continue;
            }
            localObject1 = ((StringBuffer)localObject1).toString();
            localObject2 = ((QQAppInterface)getAppRuntime()).a().createEntityManager().a(ExpiredPushBanner.class);
            int i2 = 0;
            paramInt = 0;
            if (localObject2 != null)
            {
              localObject2 = ((List)localObject2).iterator();
              i2 = paramInt;
              if (((Iterator)localObject2).hasNext())
              {
                if (((ExpiredPushBanner)((Iterator)localObject2).next()).cid != l1) {
                  break label693;
                }
                paramInt = 1;
                break label705;
              }
            }
            if (i2 != 0)
            {
              if (!QLog.isColorLevel()) {
                break label696;
              }
              QLog.i("SPLASH_ConfigServlet", 2, "this pushbanner had been close or click , throw it");
            }
          }
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.i("SPLASH_ConfigServlet", 2, "push exception : " + paramString.getMessage());
        }
      }
      return;
      if (paramString.length() < 15)
      {
        if (QLog.isColorLevel()) {
          QLog.i("SPLASH_ConfigServlet", 2, "this pushbanner md5 length < 15 .throw");
        }
      }
      else
      {
        localObject2 = BaseApplication.getContext().getFilesDir().getAbsolutePath() + "/ADPic/" + paramString;
        if (!ConfigParser.a(paramString)) {
          ThreadManager.d(new rat(this, str1));
        }
        Config.a.a(Config.a.a(l1, str2, (byte)3, str1, (String)localObject1, (String)localObject2, l3 + "|" + l2, (short)i3, paramString));
        break label696;
        break label705;
      }
      i1 += 1;
    }
  }
  
  private void g(Intent paramIntent, ConfigurationService.Config paramConfig)
  {
    NearbyGrayTipsManager localNearbyGrayTipsManager;
    String str;
    if (!TextUtils.isEmpty(paramIntent.getStringExtra("key_uin")))
    {
      int i1 = paramConfig.version.get();
      int i2 = SharedPreUtils.g(((QQAppInterface)getAppRuntime()).a());
      if (QLog.isColorLevel()) {
        QLog.d("nearby_aio_operation_gray_tips", 2, "serverVersion=" + i1 + "|localVersion=" + i2);
      }
      if (i1 > i2)
      {
        SharedPreUtils.e(((QQAppInterface)getAppRuntime()).a(), i1);
        localNearbyGrayTipsManager = (NearbyGrayTipsManager)((QQAppInterface)getAppRuntime()).getManager(92);
        if ((!paramConfig.content_list.has()) || (paramConfig.content_list.get().size() <= 0)) {
          break label579;
        }
        paramIntent = paramConfig.content_list.get();
        if (QLog.isColorLevel()) {
          QLog.d("nearby_aio_operation_gray_tips", 2, "config.content_list size=" + paramIntent.size());
        }
        if ((paramIntent != null) && (paramIntent.size() > 0))
        {
          localNearbyGrayTipsManager.b();
          Iterator localIterator = paramIntent.iterator();
          do
          {
            if (!localIterator.hasNext()) {
              break;
            }
            str = (String)localIterator.next();
            if (QLog.isColorLevel()) {
              QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 23,content: " + str + ",version: " + paramConfig.version.get());
            }
          } while (StringUtil.b(str));
        }
      }
    }
    for (;;)
    {
      try
      {
        localObject1 = new JSONObject(str);
        if (((JSONObject)localObject1).isNull("MD5")) {
          break label628;
        }
        paramIntent = ((JSONObject)localObject1).getString("MD5");
        if (((JSONObject)localObject1).isNull("URL")) {
          break label623;
        }
        localObject1 = ((JSONObject)localObject1).getString("URL");
        if (StringUtil.b((String)localObject1)) {
          break;
        }
        Object localObject2 = NearbyGrayTipsManager.a();
        localObject2 = new File((String)localObject2 + "temp.txt");
        if (!HttpDownloadUtil.a((QQAppInterface)getAppRuntime(), (String)localObject1, (File)localObject2)) {
          break label531;
        }
        if (QLog.isColorLevel()) {
          QLog.d("nearby_aio_operation_gray_tips", 2, "file download succeed. url=" + (String)localObject1);
        }
        if ((!StringUtil.b(paramIntent)) && (!paramIntent.equals(MD5.getFileMD5((File)localObject2)))) {
          break;
        }
        paramIntent = NearbyGrayTipsManager.a((File)localObject2);
        if (paramIntent != null)
        {
          localNearbyGrayTipsManager.a(paramIntent);
          localNearbyGrayTipsManager.a(paramIntent, true);
          NearbyGrayTipsManager.a(paramIntent);
        }
        ((File)localObject2).delete();
      }
      catch (JSONException paramIntent)
      {
        if (QLog.isColorLevel()) {
          QLog.d("nearby_aio_operation_gray_tips", 2, "JSONException was thrown when parse json!!! string=" + str);
        }
        paramIntent.printStackTrace();
      }
      break;
      label531:
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("nearby_aio_operation_gray_tips", 2, "file download failed. url=" + (String)localObject1);
      break;
      localNearbyGrayTipsManager.a();
      localNearbyGrayTipsManager.a(true);
      return;
      label579:
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 23,content_list is empty ,version: " + paramConfig.version.get());
      }
      localNearbyGrayTipsManager.b();
      return;
      label623:
      Object localObject1 = null;
      continue;
      label628:
      paramIntent = null;
    }
  }
  
  private void g(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i1 = SharedPreUtils.b(paramQQAppInterface.a(), "push_open_notify_version", h);
    int i2 = paramConfig.version.get();
    if (QLog.isColorLevel()) {
      QLog.d("PushOpenNotify", 2, "handlePushOpenNotifyConfig, version: " + i2 + " oldVersion: " + i1);
    }
    if (i1 == i2) {}
    String str;
    do
    {
      return;
      while (!paramConfig.hasNext())
      {
        do
        {
          SharedPreUtils.a(getAppRuntime().getApplication(), "push_open_notify_version", h, i2);
        } while ((paramConfig.content_list == null) || (paramConfig.content_list.size() <= 0));
        paramConfig = paramConfig.content_list.get().iterator();
      }
      str = (String)paramConfig.next();
      if (QLog.isColorLevel()) {
        QLog.i("PushOpenNotify", 2, "config :" + str);
      }
    } while (TextUtils.isEmpty(str));
    a(paramQQAppInterface, str, false);
    PreferenceManager.getDefaultSharedPreferences(paramQQAppInterface.a()).edit().putString(paramQQAppInterface.f() + "_" + "push_open_notify_xml", str).commit();
  }
  
  public static void g(QQAppInterface paramQQAppInterface, String paramString)
  {
    h = paramString;
    a(paramQQAppInterface, 43);
  }
  
  private void g(ConfigurationService.Config paramConfig)
  {
    int i1;
    int i2;
    String str;
    try
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)getAppRuntime();
      if ((paramConfig.content_list != null) && (paramConfig.content_list.size() > 0))
      {
        i1 = paramConfig.version.get();
        i2 = PublicAccountConfigUtil.a(localQQAppInterface);
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 81, version:" + paramConfig.version.get());
        }
        if (i1 != i2)
        {
          Iterator localIterator = paramConfig.content_list.get().iterator();
          while (localIterator.hasNext())
          {
            str = (String)localIterator.next();
            if (QLog.isColorLevel()) {
              QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 81, version:" + paramConfig.version.get() + ", content:" + str);
            }
            if (!PublicAccountConfigUtil.c(localQQAppInterface, str)) {
              break label244;
            }
            PublicAccountConfigUtil.b(localQQAppInterface);
            PublicAccountConfigUtil.a(localQQAppInterface, i1);
            if (QLog.isColorLevel()) {
              QLog.d("SPLASH_ConfigServlet", 2, "received SERVICE_ACCOUNT_FOLDER_CONFIG_CMD save version: " + i1);
            }
          }
          return;
        }
      }
    }
    catch (Exception paramConfig)
    {
      if (QLog.isColorLevel()) {
        QLog.e("SPLASH_ConfigServlet", 2, "received SERVICE_ACCOUNT_FOLDER_CONFIG_CMD error", paramConfig);
      }
      paramConfig.printStackTrace();
    }
    label244:
    do
    {
      do
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("SPLASH_ConfigServlet", 2, "received SERVICE_ACCOUNT_FOLDER_CONFIG_CMD content error:" + str);
        break;
      } while (!QLog.isColorLevel());
      QLog.d("SPLASH_ConfigServlet", 2, "received SERVICE_ACCOUNT_FOLDER_CONFIG_CMD remote version: " + i1 + " | localVersion: " + i2);
      return;
    } while (!QLog.isColorLevel());
    QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 81, content_list is empty , version: " + paramConfig.version.get());
  }
  
  /* Error */
  private void g(String paramString, int paramInt)
  {
    // Byte code:
    //   0: invokestatic 589	javax/xml/parsers/DocumentBuilderFactory:newInstance	()Ljavax/xml/parsers/DocumentBuilderFactory;
    //   3: invokevirtual 593	javax/xml/parsers/DocumentBuilderFactory:newDocumentBuilder	()Ljavax/xml/parsers/DocumentBuilder;
    //   6: new 595	java/io/ByteArrayInputStream
    //   9: dup
    //   10: aload_1
    //   11: ldc_w 597
    //   14: invokevirtual 601	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   17: invokespecial 604	java/io/ByteArrayInputStream:<init>	([B)V
    //   20: invokevirtual 609	javax/xml/parsers/DocumentBuilder:parse	(Ljava/io/InputStream;)Lorg/w3c/dom/Document;
    //   23: astore 12
    //   25: aload 12
    //   27: ldc_w 2942
    //   30: invokeinterface 617 2 0
    //   35: astore 13
    //   37: ldc -57
    //   39: astore 10
    //   41: fconst_0
    //   42: fstore 4
    //   44: fconst_0
    //   45: fstore 5
    //   47: iconst_0
    //   48: istore 15
    //   50: ldc -57
    //   52: astore 9
    //   54: fconst_0
    //   55: fstore 6
    //   57: fconst_0
    //   58: fstore_3
    //   59: ldc_w 2944
    //   62: astore_1
    //   63: ldc -57
    //   65: astore 11
    //   67: iconst_0
    //   68: istore 14
    //   70: iload 14
    //   72: aload 13
    //   74: invokeinterface 622 1 0
    //   79: if_icmpge +480 -> 559
    //   82: aload 12
    //   84: ldc_w 2419
    //   87: invokeinterface 617 2 0
    //   92: iload 14
    //   94: invokeinterface 628 2 0
    //   99: invokeinterface 634 1 0
    //   104: invokeinterface 637 1 0
    //   109: astore 11
    //   111: aload 12
    //   113: ldc_w 2425
    //   116: invokeinterface 617 2 0
    //   121: iload 14
    //   123: invokeinterface 628 2 0
    //   128: invokeinterface 634 1 0
    //   133: invokeinterface 637 1 0
    //   138: astore 10
    //   140: aload 12
    //   142: ldc_w 2945
    //   145: invokeinterface 617 2 0
    //   150: iload 14
    //   152: invokeinterface 628 2 0
    //   157: invokeinterface 634 1 0
    //   162: invokeinterface 637 1 0
    //   167: invokestatic 2951	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   170: fstore 4
    //   172: aload 12
    //   174: ldc_w 2952
    //   177: invokeinterface 617 2 0
    //   182: iload 14
    //   184: invokeinterface 628 2 0
    //   189: invokeinterface 634 1 0
    //   194: invokeinterface 637 1 0
    //   199: invokestatic 2951	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   202: fstore_3
    //   203: iconst_1
    //   204: istore 15
    //   206: aload 12
    //   208: ldc_w 2953
    //   211: invokeinterface 617 2 0
    //   216: iload 14
    //   218: invokeinterface 628 2 0
    //   223: invokeinterface 634 1 0
    //   228: invokeinterface 637 1 0
    //   233: invokestatic 2951	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   236: fstore 5
    //   238: aload 12
    //   240: ldc_w 2954
    //   243: invokeinterface 617 2 0
    //   248: iload 14
    //   250: invokeinterface 628 2 0
    //   255: invokeinterface 634 1 0
    //   260: invokeinterface 637 1 0
    //   265: invokestatic 2951	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   268: fstore 8
    //   270: aload 12
    //   272: ldc_w 2956
    //   275: invokeinterface 617 2 0
    //   280: iload 14
    //   282: invokeinterface 628 2 0
    //   287: invokeinterface 634 1 0
    //   292: invokeinterface 637 1 0
    //   297: astore 9
    //   299: aload 12
    //   301: ldc_w 2957
    //   304: invokeinterface 617 2 0
    //   309: iload 14
    //   311: invokeinterface 628 2 0
    //   316: invokeinterface 634 1 0
    //   321: invokeinterface 637 1 0
    //   326: invokestatic 2951	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   329: fstore 7
    //   331: aload 12
    //   333: ldc_w 2953
    //   336: invokeinterface 617 2 0
    //   341: iload 14
    //   343: invokeinterface 628 2 0
    //   348: invokeinterface 634 1 0
    //   353: invokeinterface 637 1 0
    //   358: invokestatic 2951	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   361: fstore 6
    //   363: aload 12
    //   365: ldc_w 2959
    //   368: invokeinterface 617 2 0
    //   373: iload 14
    //   375: invokeinterface 628 2 0
    //   380: invokeinterface 634 1 0
    //   385: invokeinterface 637 1 0
    //   390: astore_1
    //   391: invokestatic 256	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   394: ifeq +296 -> 690
    //   397: ldc -111
    //   399: iconst_2
    //   400: new 260	java/lang/StringBuilder
    //   403: dup
    //   404: invokespecial 261	java/lang/StringBuilder:<init>	()V
    //   407: ldc_w 2961
    //   410: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   413: aload 11
    //   415: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   418: ldc_w 2963
    //   421: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   424: aload 10
    //   426: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   429: ldc_w 2965
    //   432: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   435: fload 4
    //   437: invokevirtual 2968	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   440: ldc_w 2970
    //   443: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   446: fload_3
    //   447: invokevirtual 2968	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   450: ldc_w 2972
    //   453: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   456: iload 15
    //   458: invokevirtual 506	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   461: ldc_w 2974
    //   464: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   467: fload 5
    //   469: invokevirtual 2968	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   472: ldc_w 2976
    //   475: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   478: fload 8
    //   480: invokevirtual 2968	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   483: ldc_w 2978
    //   486: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   489: aload 9
    //   491: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   494: ldc_w 2980
    //   497: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   500: fload 7
    //   502: invokevirtual 2968	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   505: ldc_w 2982
    //   508: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   511: aload_1
    //   512: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   515: invokevirtual 275	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   518: invokestatic 1053	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   521: goto +169 -> 690
    //   524: astore_1
    //   525: aload 12
    //   527: ldc_w 2983
    //   530: invokeinterface 617 2 0
    //   535: iload 14
    //   537: invokeinterface 628 2 0
    //   542: invokeinterface 634 1 0
    //   547: invokeinterface 637 1 0
    //   552: invokestatic 2951	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   555: fstore_3
    //   556: goto -350 -> 206
    //   559: aload 11
    //   561: ifnull +126 -> 687
    //   564: aload 11
    //   566: invokevirtual 378	java/lang/String:trim	()Ljava/lang/String;
    //   569: ldc -57
    //   571: invokevirtual 1549	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   574: ifne +113 -> 687
    //   577: new 260	java/lang/StringBuilder
    //   580: dup
    //   581: invokespecial 261	java/lang/StringBuilder:<init>	()V
    //   584: aload_0
    //   585: invokevirtual 224	com/tencent/mobileqq/config/splashlogo/ConfigServlet:getAppRuntime	()Lmqq/app/AppRuntime;
    //   588: invokevirtual 1739	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   591: invokevirtual 1744	mqq/app/MobileQQ:getFilesDir	()Ljava/io/File;
    //   594: invokevirtual 1747	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   597: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   600: ldc_w 1749
    //   603: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   606: getstatic 201	com/tencent/mobileqq/config/splashlogo/ConfigServlet:h	Ljava/lang/String;
    //   609: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   612: ldc_w 1749
    //   615: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   618: ldc_w 1850
    //   621: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   624: invokevirtual 275	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   627: astore 12
    //   629: ldc_w 2985
    //   632: aload 11
    //   634: invokestatic 2990	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:insertMtype	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   637: astore 11
    //   639: fload_3
    //   640: fstore 7
    //   642: fload_3
    //   643: fconst_0
    //   644: fcmpg
    //   645: ifge +8 -> 653
    //   648: ldc_w 534
    //   651: fstore 7
    //   653: new 2992	rau
    //   656: dup
    //   657: aload_0
    //   658: aload 12
    //   660: aload 11
    //   662: fload 4
    //   664: fload 5
    //   666: fload 7
    //   668: aload 9
    //   670: aload_1
    //   671: fload 6
    //   673: iload 15
    //   675: iload_2
    //   676: aload 10
    //   678: invokespecial 2995	rau:<init>	(Lcom/tencent/mobileqq/config/splashlogo/ConfigServlet;Ljava/lang/String;Ljava/lang/String;FFFLjava/lang/String;Ljava/lang/String;FZILjava/lang/String;)V
    //   681: iconst_2
    //   682: aconst_null
    //   683: iconst_0
    //   684: invokestatic 2198	com/tencent/mobileqq/app/ThreadManager:a	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   687: return
    //   688: astore_1
    //   689: return
    //   690: iload 14
    //   692: iconst_1
    //   693: iadd
    //   694: istore 14
    //   696: fload_3
    //   697: fstore 5
    //   699: fload 6
    //   701: fstore_3
    //   702: fload 7
    //   704: fstore 6
    //   706: goto -636 -> 70
    //   709: astore_1
    //   710: ldc_w 2944
    //   713: astore_1
    //   714: goto -323 -> 391
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	717	0	this	ConfigServlet
    //   0	717	1	paramString	String
    //   0	717	2	paramInt	int
    //   58	644	3	f1	float
    //   42	621	4	f2	float
    //   45	653	5	f3	float
    //   55	650	6	f4	float
    //   329	374	7	f5	float
    //   268	211	8	f6	float
    //   52	617	9	str1	String
    //   39	638	10	str2	String
    //   65	596	11	str3	String
    //   23	636	12	localObject	Object
    //   35	38	13	localNodeList	NodeList
    //   68	627	14	i1	int
    //   48	626	15	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   172	203	524	java/lang/Exception
    //   0	37	688	java/lang/Exception
    //   70	172	688	java/lang/Exception
    //   206	363	688	java/lang/Exception
    //   391	521	688	java/lang/Exception
    //   525	556	688	java/lang/Exception
    //   564	639	688	java/lang/Exception
    //   653	687	688	java/lang/Exception
    //   363	391	709	java/lang/Exception
  }
  
  private void h(Intent paramIntent, ConfigurationService.Config paramConfig)
  {
    int i2 = 0;
    paramIntent = (QQAppInterface)getAppRuntime();
    Object localObject1;
    HashMap localHashMap;
    int i1;
    if ((paramConfig.content_list != null) && (paramConfig.content_list.size() > 0))
    {
      localObject1 = paramConfig.content_list.get();
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        localHashMap = new HashMap();
        i1 = 0;
        if (i1 < ((List)localObject1).size())
        {
          Object localObject2 = (String)((List)localObject1).get(i1);
          if (QLog.isColorLevel()) {
            QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 115,content: " + (String)localObject2 + ",version: " + paramConfig.version.get());
          }
          if (TextUtils.isEmpty((CharSequence)localObject2)) {}
          for (;;)
          {
            i1 += 1;
            break;
            localObject2 = ((String)localObject2).split("=");
            if ((localObject2 != null) && (localObject2.length == 2))
            {
              localHashMap.put(localObject2[0], localObject2[1]);
              if (QLog.isColorLevel()) {
                QLog.i("SPLASH_ConfigServlet", 2, "NowTabConfigCmd, name=" + localObject2[0] + ", val=" + localObject2[1]);
              }
            }
          }
        }
        paramConfig = (String)localHashMap.get("mqq_nowtab_plan");
        if (QLog.isColorLevel()) {
          QLog.i("nowtabPlan", 2, "nowtabPlan=" + paramConfig);
        }
        if (paramConfig == null) {}
      }
    }
    for (;;)
    {
      try
      {
        localObject1 = paramIntent.a().getSharedPreferences("now_tab_sp", 0).getString("now_show_key" + paramIntent.a(), "00000");
        i1 = Integer.valueOf("" + ((String)localObject1).charAt(2)).intValue();
        i3 = Integer.valueOf(paramConfig).intValue();
        if (i1 != i3)
        {
          localObject1 = new Integer[5];
          i1 = i2;
          switch (i3)
          {
          }
        }
      }
      catch (Exception paramConfig)
      {
        int i3;
        QLog.w("nowtabPlan", 2, "" + paramConfig.getMessage(), paramConfig);
        continue;
        localObject1[1] = Integer.valueOf(0);
        localObject1[2] = Integer.valueOf(i3);
        paramIntent.a().a((Integer[])localObject1);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("nowtabPlan", 2, "case 2 nowtabPlan=" + paramConfig);
        continue;
        localObject1[2] = Integer.valueOf(i3);
        localObject1[1] = Integer.valueOf(1);
        paramIntent.a().a((Integer[])localObject1);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("nowtabPlan", 2, "case 3 nowtabPlan=" + paramConfig);
        continue;
      }
      paramIntent.a().a = paramConfig.charAt(0);
      paramConfig = (String)localHashMap.get("mqq_nowtab_index");
      if (QLog.isColorLevel()) {
        QLog.i("nowtabIndex", 2, "nowtabIndex=" + paramConfig);
      }
      if (paramConfig != null) {}
      try
      {
        paramIntent.a().getSharedPreferences("now_tab_sp", 0).edit().putInt("now_index_key", Integer.valueOf(paramConfig).intValue());
        paramIntent.a().g = Integer.valueOf(paramConfig).intValue();
        return;
      }
      catch (Exception paramIntent)
      {
        QLog.w("nowtabIndex", 2, "nowtabIndex is not value of Int!");
        return;
      }
      if (i1 < localObject1.length)
      {
        localObject1[i1] = Integer.valueOf(0);
        i1 += 1;
      }
      else
      {
        localObject1[2] = Integer.valueOf(i3);
        if (QLog.isColorLevel()) {
          QLog.i("nowtabPlan", 2, "case 0 1 nowtabPlan=" + paramConfig);
        }
        paramIntent.a().a((Integer[])localObject1);
      }
    }
  }
  
  public static void h(QQAppInterface paramQQAppInterface, String paramString)
  {
    long l1 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      NearbyUtils.a("GENERAL_LBS_CONFIGS_CMD", new Object[] { "getGeneralLBSConfigs", paramString, Long.valueOf(l1) });
    }
    SosoInterface.a(new rap(3, true, true, 3600000L, false, false, "GeneralLBSConfigs", paramString, l1, paramQQAppInterface));
  }
  
  private void h(ConfigurationService.Config paramConfig)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)getAppRuntime();
    int i1 = paramConfig.version.get();
    int i2 = SharedPreUtils.l(localQQAppInterface.a());
    if (QLog.isColorLevel()) {
      QLog.d("VideoDownCTWhiteList", 2, String.format("received VideoDownCTWhiteList remote version: %d, localVersion: %d, cmd: %d", new Object[] { Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(80) }));
    }
    if (i1 != i2)
    {
      if ((paramConfig.content_list == null) || (paramConfig.content_list.size() <= 0)) {
        break label168;
      }
      str = (String)paramConfig.content_list.get(0);
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 80,content: " + str + ",version: " + paramConfig.version.get());
      }
      SharedPreUtils.r(localQQAppInterface.a(), i1, str);
    }
    label168:
    while (!QLog.isColorLevel())
    {
      String str;
      return;
    }
    QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 80,content_list is empty ,version: " + paramConfig.version.get());
  }
  
  private void h(String paramString, int paramInt)
  {
    Object localObject1 = null;
    for (;;)
    {
      int i1;
      try
      {
        String str4 = getAppRuntime().getApplication().getFilesDir().getAbsolutePath() + "/" + "splashpic" + "/";
        Object localObject2 = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(paramString.getBytes("utf-8")));
        NodeList localNodeList = ((Document)localObject2).getElementsByTagName("splash");
        paramString = "";
        String str1 = "";
        i1 = 0;
        String str2 = null;
        String str3 = null;
        if (i1 < localNodeList.getLength())
        {
          str3 = ((Document)localObject2).getElementsByTagName("img").item(i1).getFirstChild().getNodeValue();
          str2 = ((Document)localObject2).getElementsByTagName("begin").item(i1).getFirstChild().getNodeValue();
          localObject1 = ((Document)localObject2).getElementsByTagName("end").item(i1).getFirstChild().getNodeValue();
          paramString = ((Document)localObject2).getElementsByTagName("md5").item(i1).getFirstChild().getNodeValue();
          str1 = ((Document)localObject2).getElementsByTagName("channel").item(i1).getFirstChild().getNodeValue();
          if (QLog.isColorLevel()) {
            QLog.i("SPLASH_ConfigServlet", 2, "parse result,img == " + str3 + " ,begin = " + str2 + " ,end=" + (String)localObject1 + ",md5=" + paramString);
          }
        }
        else
        {
          if ((str3 == null) || (str3.trim().equals(""))) {
            break;
          }
          str3 = MsfSdkUtils.insertMtype("ConfigCheck", str3);
          localObject2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
          str2 = ((SimpleDateFormat)localObject2).parse(str2).getTime() + "|" + ((SimpleDateFormat)localObject2).parse((String)localObject1).getTime();
          SharedPreUtils.a(getAppRuntime().getApplication(), paramInt, str2, paramString);
          new File(getAppRuntime().getApplication().getFilesDir().getAbsolutePath() + "/" + "splashpic");
          if (((SimpleDateFormat)localObject2).parse((String)localObject1).getTime() < System.currentTimeMillis())
          {
            paramString = new File(str4 + paramString);
            if (paramString.exists()) {
              paramString.delete();
            }
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.i("SPLASH_ConfigServlet", 2, "this splash is outdate, throw it");
            return;
          }
          localObject1 = new File(str4 + paramString);
          localObject2 = new File(str4 + str2 + "_" + paramString + "_" + str1);
          if (((File)localObject2).exists()) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.i("SPLASH_ConfigServlet", 2, "begin a thread try to download");
          }
          ThreadManager.a(new rav(this, (File)localObject1, str3, paramString, (File)localObject2, str4, str2, str1, str3), 5, null, true);
          return;
        }
      }
      catch (Exception paramString)
      {
        return;
      }
      i1 += 1;
    }
  }
  
  private void i(Intent paramIntent, ConfigurationService.Config paramConfig)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)getAppRuntime();
    if ((paramConfig.content_list != null) && (paramConfig.content_list.size() > 0)) {}
    for (Object localObject1 = paramConfig.content_list.get();; localObject1 = null)
    {
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        localHashMap = new HashMap();
        i1 = 0;
        if (i1 < ((List)localObject1).size())
        {
          localObject2 = (String)((List)localObject1).get(i1);
          if (QLog.isColorLevel()) {
            QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 101,content: " + (String)localObject2 + ",version: " + paramConfig.version.get());
          }
          if (TextUtils.isEmpty((CharSequence)localObject2)) {}
          for (;;)
          {
            i1 += 1;
            break;
            localObject2 = ((String)localObject2).split("=");
            if ((localObject2 != null) && (localObject2.length == 2))
            {
              localHashMap.put(localObject2[0], localObject2[1]);
              if (QLog.isColorLevel()) {
                QLog.i("SPLASH_ConfigServlet", 2, "GENERAL_CONFIGS_CMD, name=" + localObject2[0] + ", val=" + localObject2[1]);
              }
            }
          }
        }
        localObject1 = (String)localHashMap.get("mask_lightalk");
        localObject2 = (LightalkSwitchManager)localQQAppInterface.getManager(85);
        if (!"1".equals(localObject1))
        {
          bool = true;
          ((LightalkSwitchManager)localObject2).a(bool);
          localObject2 = (String)localHashMap.get("ptlogin_flag");
          localObject1 = BaseApplication.getContext().getSharedPreferences("mobileQQ", 4);
          ((SharedPreferences)localObject1).edit().putBoolean("ptlogin_flag" + getAppRuntime().getAccount(), "1".equalsIgnoreCase((String)localObject2)).commit();
          localObject2 = (String)localHashMap.get("msgrevoke_flag");
          if (QLog.isColorLevel()) {
            QLog.i("msgrevoke", 2, "GENERAL_CONFIGS_CMD, msgRevokeFlag=" + (String)localObject2);
          }
          if (localObject2 != null) {
            BaseApplication.getContext().getSharedPreferences("mobileQQ", 0).edit().putBoolean("msgrevoke_flag" + getAppRuntime().getAccount(), "1".equalsIgnoreCase((String)localObject2)).commit();
          }
          localObject2 = (String)localHashMap.get("lmr_block");
          if (QLog.isColorLevel()) {
            QLog.i("new_regprxy_switch", 2, "GENERAL_CONFIGS_CMD, new_regprxy_switch=" + (String)localObject2);
          }
          if (localObject2 != null) {
            BaseApplication.getContext().getSharedPreferences("mobileQQ", 0).edit().putBoolean("new_regprxy_switch", "1".equalsIgnoreCase((String)localObject2)).commit();
          }
          localObject2 = (String)localHashMap.get("qfind_report_gps_bt_stat");
          str = (String)localHashMap.get("qfind_searching");
          localObject3 = ((SharedPreferences)localObject1).edit();
          ((SharedPreferences.Editor)localObject3).putBoolean("qfind_searching" + getAppRuntime().getAccount(), "1".equals(str));
          ((SharedPreferences.Editor)localObject3).putBoolean("qfind_report_gps_bt_stat" + getAppRuntime().getAccount(), "1".equals(localObject2));
          ((SharedPreferences.Editor)localObject3).commit();
          if (QLog.isColorLevel()) {
            QLog.w("QFind", 2, "qfind flags qfindStatFlag=" + (String)localObject2 + ", qfind_searching=" + str);
          }
          localObject2 = (String)localHashMap.get("enable_public_device");
          if (localObject2 != null) {
            BaseApplication.getContext().getSharedPreferences("smartdevice_entry", 4).edit().putBoolean("enable_public_device" + "_" + getAppRuntime().getAccount(), "1".equalsIgnoreCase((String)localObject2)).commit();
          }
          localObject2 = (String)localHashMap.get("search_device_enable_https");
          if (localObject2 != null)
          {
            BaseApplication.getContext().getSharedPreferences("smartdevice_entry", 4).edit().putBoolean("search_device_enable_https" + "_" + getAppRuntime().getAccount(), "1".equalsIgnoreCase((String)localObject2)).commit();
            if (QLog.isColorLevel()) {
              QLog.w("smartdevice", 2, "search_device_enable_https=" + (String)localObject2);
            }
          }
          localObject2 = (String)localHashMap.get("mqq_calltab");
          str = (String)localHashMap.get("mqq_calltab_setting");
          if ((localObject2 != null) || (str != null))
          {
            localObject3 = new Integer[7];
            if (localObject2 != null)
            {
              if (((String)localObject2).indexOf('|') <= 0) {
                break label2256;
              }
              if (!localObject2.split("|")[0].equals("1")) {
                break label2250;
              }
              i1 = 1;
              localObject3[1] = Integer.valueOf(i1);
            }
            if (str != null)
            {
              if (!str.equals("1")) {
                break label2288;
              }
              i1 = 1;
              localObject3[5] = Integer.valueOf(i1);
            }
            localQQAppInterface.a((Integer[])localObject3);
          }
          localObject3 = (String)localHashMap.get("subscribe_discovery");
          if (!TextUtils.isEmpty((CharSequence)localObject3))
          {
            SubscriptRecommendController.d(localQQAppInterface, "1".equals(localObject3));
            if (QLog.isColorLevel()) {
              QLog.d("SPLASH_ConfigServlet", 2, "subscribe discovery btn config : " + (String)localObject3);
            }
          }
          if ((localObject2 == null) || (str == null))
          {
            localObject3 = new Integer[7];
            if (localObject2 == null)
            {
              localObject3[1] = Integer.valueOf("0111100".charAt(1) - '0');
              localObject3[2] = Integer.valueOf("0111100".charAt(2) - '0');
            }
            if (str == null)
            {
              localObject3[5] = Integer.valueOf("0111100".charAt(5) - '0');
              localObject3[6] = Integer.valueOf("0111100".charAt(6) - '0');
            }
            localQQAppInterface.a((Integer[])localObject3);
          }
          localObject2 = (String)localHashMap.get("share_to_news");
          if (localObject2 != null) {
            ReadInJoyHelper.a((String)localObject2, localQQAppInterface);
          }
          localObject2 = (String)localHashMap.get("synchronize_to_qzone");
          if (localObject2 != null) {
            ReadInJoyHelper.b((String)localObject2, localQQAppInterface);
          }
          localObject2 = (String)localHashMap.get("merge_feeds");
          if (localObject2 != null) {
            ReadInJoyHelper.d((String)localObject2, localQQAppInterface);
          }
          localObject2 = (String)localHashMap.get("kandian_feeds");
          if (localObject2 != null) {
            ReadInJoyHelper.e((String)localObject2, localQQAppInterface);
          }
          i1 = paramConfig.version.get();
          SharedPreUtils.j(getAppRuntime().getApplication(), i1, h);
          if ((paramIntent != null) && (paramIntent.hasExtra("update101Version"))) {
            SettingCloneUtil.writeValueForInt(getAppRuntime().getApplication(), h, null, "qqsetting_calltab_show_key_version", paramIntent.getIntExtra("update101Version", 0));
          }
          ArkAppCenter.a((String)localHashMap.get("arkapp_pa_nshow"));
          NearbySPUtil.a(localQQAppInterface.getAccount(), "supportHotChatDemo", Boolean.valueOf("1".equals(localHashMap.get("hotchat_demo"))));
          paramIntent = (PttConfigController)localQQAppInterface.getManager(88);
          paramIntent.a((String)localHashMap.get("ptt_stream_slice_cfg"));
          paramIntent.b((String)localHashMap.get("ptt_optimize_cfg_v2"));
          paramIntent.c((String)localHashMap.get("ptt_pre_download"));
          paramIntent = (String)localHashMap.get("splashpic_charm_requirement");
          if (paramIntent != null) {
            HotChatManager.a(localQQAppInterface, paramIntent);
          }
          paramIntent = (String)localHashMap.get("kFreezeTipsShow");
          paramConfig = localQQAppInterface.a();
          if (Build.VERSION.SDK_INT <= 10) {
            break label2294;
          }
          i1 = 4;
          paramConfig = paramConfig.getSharedPreferences("qwallet_multi", i1);
          if (paramConfig != null)
          {
            paramConfig = paramConfig.edit();
            if ((!TextUtils.isEmpty(paramIntent)) && (!"1".equals(paramIntent))) {
              break label2300;
            }
            bool = true;
            paramConfig.putBoolean("is_tenpay_yellowtip_valid", bool);
            paramIntent = (String)localHashMap.get("publicWhiteList");
            QWalletHelper.a(paramIntent);
            paramConfig.putString("publicAcc_white_list", paramIntent);
            paramConfig.commit();
          }
          QWalletHelper.a(localQQAppInterface, (String)localHashMap.get("hongbao_speed"));
          paramIntent = (String)localHashMap.get("shortvideo_predownload_strategy");
          if (paramIntent == null) {}
        }
      }
      label2250:
      label2256:
      label2288:
      label2294:
      label2300:
      label2371:
      while (!QLog.isColorLevel()) {
        try
        {
          String str;
          i1 = Integer.valueOf(paramIntent).intValue();
          localQQAppInterface.a().a.set(i1);
          paramIntent = (String)localHashMap.get("camera_compatible_list");
          if (paramIntent == null) {}
        }
        catch (Exception paramIntent)
        {
          try
          {
            CameraCompatibleList.a(paramIntent, true);
            paramIntent = (String)localHashMap.get("qqwifi_provider_mask");
            if (paramIntent != null) {
              ((SharedPreferences)localObject1).edit().putString("qqwifi_provider_mask", paramIntent).commit();
            }
            paramIntent = (String)localHashMap.get("signalling_switch");
            if (QLog.isColorLevel()) {
              QLog.i("signalling_switch", 2, "GENERAL_CONFIGS_CMD, signalling_switch=" + paramIntent);
            }
            if (paramIntent != null)
            {
              paramConfig = localQQAppInterface.a();
              if ("1".equals(paramIntent))
              {
                i1 = 1;
                paramConfig.b(i1);
              }
            }
            else
            {
              paramIntent = (String)localHashMap.get("public_offline_search_enable");
              if (QLog.isColorLevel()) {
                QLog.i("PAOfflineSearchManager", 2, "GENERAL_CONFIGS_CMD, public_offline_search_enable=" + paramIntent);
              }
              if (paramIntent != null)
              {
                paramConfig = PAOfflineSearchManager.a();
                if (!"1".equals(paramIntent)) {
                  break label2371;
                }
                bool = true;
                paramConfig.jdField_b_of_type_Boolean = bool;
              }
              paramIntent = (String)localHashMap.get("public_advance_search_freq");
              if (QLog.isColorLevel()) {
                QLog.i("searchutils", 2, "GENERAL_CONFIGS_CMD, netsearchlevel=" + paramIntent);
              }
              if (paramIntent == null) {}
            }
          }
          catch (Exception paramIntent)
          {
            try
            {
              for (;;)
              {
                HashMap localHashMap;
                Object localObject2;
                Object localObject3;
                com.tencent.mobileqq.search.util.SearchUtils.f = Integer.valueOf(paramIntent).intValue();
                paramIntent = (String)localHashMap.get("activity_dau_percent_report");
                if (QLog.isColorLevel()) {
                  QLog.d("Q.activity_dau", 2, "dauSwitch:" + paramIntent);
                }
                DAUStatistic.a(paramIntent);
                ProgressiveUtils.a((String)localHashMap.get("shortvideo_progressive_enable"));
                paramIntent = (String)localHashMap.get("aio_autoinput_time");
                if (paramIntent != null) {
                  i1 = 900;
                }
                try
                {
                  int i2 = Integer.parseInt(paramIntent);
                  i1 = i2;
                }
                catch (NumberFormatException paramConfig)
                {
                  for (;;)
                  {
                    QLog.i("inputx", 2, "GENERAL_CONFIGS_CMD, aio_autoinput_time not a int");
                  }
                }
                if (QLog.isColorLevel()) {
                  QLog.i("inputx", 2, "GENERAL_CONFIGS_CMD, aio_autoinput_time=" + paramIntent);
                }
                BaseApplication.getContext().getSharedPreferences("mobileQQ", 0).edit().putInt("aio_autoinput_time", i1).commit();
                paramIntent = (String)localHashMap.get("guardmgr_qzone_bg_time");
                if (paramIntent != null) {
                  GuardManager.a(paramIntent);
                }
                paramIntent = (String)localHashMap.get("pic_thumb_400");
                if (QLog.isColorLevel()) {
                  QLog.i("inputx", 2, "GENERAL_CONFIGS_CMD, pic_thumb_400=" + paramIntent);
                }
                GeneralConfigUtils.a("pic_thumb_400Enable", paramIntent);
                paramIntent = (String)localHashMap.get("Show_Business_Card");
                if (QLog.isColorLevel()) {
                  QLog.d("BusinessCara_Manager", 2, "Show_Business_Card= " + paramIntent);
                }
                paramConfig = (BusinessCardManager)localQQAppInterface.getManager(111);
                if (paramConfig != null) {
                  paramConfig.a(0, "1".equals(paramIntent));
                }
                return;
                bool = false;
                continue;
                int i1 = 0;
                continue;
                if (((String)localObject2).equals("1")) {}
                for (i1 = 1;; i1 = 0)
                {
                  localObject3[1] = Integer.valueOf(i1);
                  break;
                }
                i1 = 0;
                continue;
                i1 = 0;
                continue;
                bool = false;
                continue;
                paramIntent = paramIntent;
                if (QLog.isColorLevel())
                {
                  QLog.i("SPLASH_ConfigServlet", 2, paramIntent.getMessage());
                  continue;
                  paramIntent = paramIntent;
                  if (QLog.isColorLevel())
                  {
                    QLog.i("SPLASH_ConfigServlet", 2, "camera_compatible_list ERROR = " + paramIntent.getMessage());
                    continue;
                    i1 = 0;
                  }
                }
              }
              boolean bool = false;
            }
            catch (Exception paramIntent)
            {
              for (;;)
              {
                paramIntent.printStackTrace();
              }
            }
          }
        }
      }
      QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 101,content_list is empty ,version: " + paramConfig.version.get());
      return;
    }
  }
  
  public static void i(QQAppInterface paramQQAppInterface, String paramString)
  {
    long l2 = 3600000L;
    if (QLog.isColorLevel()) {
      QLog.d("SPLASH_ConfigServlet", 2, "getPrecoverConfig, PRECOVER_CONFIG_CMD, uin=" + paramString);
    }
    PrecoverManager localPrecoverManager = (PrecoverManager)paramQQAppInterface.getManager(178);
    long l1 = l2;
    if (localPrecoverManager != null)
    {
      l1 = l2;
      if (localPrecoverManager.a() != null)
      {
        l1 = localPrecoverManager.a().k * 1000L;
        if (l1 > 0L) {
          break label109;
        }
        l1 = l2;
      }
    }
    label109:
    for (;;)
    {
      SosoInterface.a(new raq(3, true, true, l1, false, false, "PrecoverLbsConfig", paramString, paramQQAppInterface));
      return;
    }
  }
  
  private void i(ConfigurationService.Config paramConfig)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)getAppRuntime();
    int i1 = paramConfig.version.get();
    int i2 = SharedPreUtils.m(localQQAppInterface.a());
    if (QLog.isColorLevel()) {
      QLog.d("MixMsgForwardConfig", 2, String.format("received MixMsgForwardConfig remote version: %d, localVersion: %d, cmd: %d", new Object[] { Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(111) }));
    }
    if (i1 != i2)
    {
      if ((paramConfig.content_list == null) || (paramConfig.content_list.size() <= 0)) {
        break label168;
      }
      str = (String)paramConfig.content_list.get(0);
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 111,content: " + str + ",version: " + paramConfig.version.get());
      }
      SharedPreUtils.s(localQQAppInterface.a(), i1, str);
    }
    label168:
    while (!QLog.isColorLevel())
    {
      String str;
      return;
    }
    QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 111,content_list is empty ,version:" + paramConfig.version.get());
  }
  
  /* Error */
  private void i(String paramString, int paramInt)
  {
    // Byte code:
    //   0: invokestatic 589	javax/xml/parsers/DocumentBuilderFactory:newInstance	()Ljavax/xml/parsers/DocumentBuilderFactory;
    //   3: invokevirtual 593	javax/xml/parsers/DocumentBuilderFactory:newDocumentBuilder	()Ljavax/xml/parsers/DocumentBuilder;
    //   6: new 595	java/io/ByteArrayInputStream
    //   9: dup
    //   10: aload_1
    //   11: ldc_w 597
    //   14: invokevirtual 601	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   17: invokespecial 604	java/io/ByteArrayInputStream:<init>	([B)V
    //   20: invokevirtual 609	javax/xml/parsers/DocumentBuilder:parse	(Ljava/io/InputStream;)Lorg/w3c/dom/Document;
    //   23: ldc_w 3372
    //   26: invokeinterface 617 2 0
    //   31: iconst_0
    //   32: invokeinterface 628 2 0
    //   37: checkcast 698	org/w3c/dom/Element
    //   40: ldc_w 3374
    //   43: invokeinterface 701 2 0
    //   48: iconst_0
    //   49: invokeinterface 628 2 0
    //   54: invokeinterface 3378 1 0
    //   59: ldc_w 3380
    //   62: invokeinterface 3386 2 0
    //   67: invokeinterface 637 1 0
    //   72: astore_3
    //   73: aload_3
    //   74: invokestatic 998	com/tencent/mobileqq/utils/StringUtil:b	(Ljava/lang/String;)Z
    //   77: ifeq +4 -> 81
    //   80: return
    //   81: invokestatic 256	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   84: ifeq +29 -> 113
    //   87: ldc -107
    //   89: iconst_2
    //   90: new 260	java/lang/StringBuilder
    //   93: dup
    //   94: invokespecial 261	java/lang/StringBuilder:<init>	()V
    //   97: ldc_w 3388
    //   100: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: aload_3
    //   104: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: invokevirtual 275	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   110: invokestatic 278	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   113: new 741	java/io/File
    //   116: dup
    //   117: new 260	java/lang/StringBuilder
    //   120: dup
    //   121: invokespecial 261	java/lang/StringBuilder:<init>	()V
    //   124: invokestatic 1110	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   127: invokevirtual 2462	com/tencent/qphone/base/util/BaseApplication:getFilesDir	()Ljava/io/File;
    //   130: invokevirtual 1747	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   133: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: ldc_w 1749
    //   139: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: ldc_w 3390
    //   145: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: invokevirtual 275	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   151: invokespecial 755	java/io/File:<init>	(Ljava/lang/String;)V
    //   154: astore_1
    //   155: aload_1
    //   156: invokevirtual 758	java/io/File:exists	()Z
    //   159: ifeq +8 -> 167
    //   162: aload_1
    //   163: invokevirtual 1802	java/io/File:delete	()Z
    //   166: pop
    //   167: aload_1
    //   168: invokevirtual 3393	java/io/File:createNewFile	()Z
    //   171: pop
    //   172: new 260	java/lang/StringBuilder
    //   175: dup
    //   176: invokespecial 261	java/lang/StringBuilder:<init>	()V
    //   179: astore 4
    //   181: aload 4
    //   183: aload_3
    //   184: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: pop
    //   188: aload 4
    //   190: invokevirtual 275	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   193: ldc_w 2724
    //   196: invokevirtual 601	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   199: astore 4
    //   201: new 3395	java/io/FileOutputStream
    //   204: dup
    //   205: aload_1
    //   206: invokespecial 3396	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   209: astore_3
    //   210: aload_3
    //   211: astore_1
    //   212: aload_3
    //   213: aload 4
    //   215: invokevirtual 3398	java/io/FileOutputStream:write	([B)V
    //   218: aload_3
    //   219: astore_1
    //   220: aload_3
    //   221: invokevirtual 3401	java/io/FileOutputStream:flush	()V
    //   224: aload_3
    //   225: astore_1
    //   226: aload_0
    //   227: invokevirtual 224	com/tencent/mobileqq/config/splashlogo/ConfigServlet:getAppRuntime	()Lmqq/app/AppRuntime;
    //   230: invokevirtual 1739	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   233: iload_2
    //   234: getstatic 201	com/tencent/mobileqq/config/splashlogo/ConfigServlet:h	Ljava/lang/String;
    //   237: invokestatic 3403	com/tencent/mobileqq/utils/SharedPreUtils:q	(Landroid/content/Context;ILjava/lang/String;)V
    //   240: aload_3
    //   241: astore_1
    //   242: invokestatic 3406	com/tencent/mobileqq/troop/utils/TroopUtils:a	()V
    //   245: aload_3
    //   246: ifnull +143 -> 389
    //   249: aload_3
    //   250: invokevirtual 3407	java/io/FileOutputStream:close	()V
    //   253: return
    //   254: astore_1
    //   255: aload_1
    //   256: invokevirtual 736	java/io/IOException:printStackTrace	()V
    //   259: return
    //   260: astore_1
    //   261: aload_1
    //   262: invokevirtual 460	java/lang/Exception:printStackTrace	()V
    //   265: invokestatic 256	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   268: ifeq +121 -> 389
    //   271: ldc -107
    //   273: iconst_2
    //   274: new 260	java/lang/StringBuilder
    //   277: dup
    //   278: invokespecial 261	java/lang/StringBuilder:<init>	()V
    //   281: ldc_w 3409
    //   284: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: aload_1
    //   288: invokevirtual 430	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   291: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   294: invokevirtual 275	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   297: invokestatic 1053	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   300: return
    //   301: astore 4
    //   303: aconst_null
    //   304: astore_3
    //   305: aload_3
    //   306: astore_1
    //   307: aload 4
    //   309: invokevirtual 736	java/io/IOException:printStackTrace	()V
    //   312: aload_3
    //   313: astore_1
    //   314: ldc -107
    //   316: iconst_2
    //   317: new 260	java/lang/StringBuilder
    //   320: dup
    //   321: invokespecial 261	java/lang/StringBuilder:<init>	()V
    //   324: ldc_w 3411
    //   327: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   330: aload 4
    //   332: invokevirtual 2288	java/io/IOException:toString	()Ljava/lang/String;
    //   335: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   338: invokevirtual 275	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   341: invokestatic 278	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   344: aload_3
    //   345: ifnull +44 -> 389
    //   348: aload_3
    //   349: invokevirtual 3407	java/io/FileOutputStream:close	()V
    //   352: return
    //   353: astore_1
    //   354: aload_1
    //   355: invokevirtual 736	java/io/IOException:printStackTrace	()V
    //   358: return
    //   359: astore_3
    //   360: aconst_null
    //   361: astore_1
    //   362: aload_1
    //   363: ifnull +7 -> 370
    //   366: aload_1
    //   367: invokevirtual 3407	java/io/FileOutputStream:close	()V
    //   370: aload_3
    //   371: athrow
    //   372: astore_1
    //   373: aload_1
    //   374: invokevirtual 736	java/io/IOException:printStackTrace	()V
    //   377: goto -7 -> 370
    //   380: astore_3
    //   381: goto -19 -> 362
    //   384: astore 4
    //   386: goto -81 -> 305
    //   389: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	390	0	this	ConfigServlet
    //   0	390	1	paramString	String
    //   0	390	2	paramInt	int
    //   72	277	3	localObject1	Object
    //   359	12	3	localObject2	Object
    //   380	1	3	localObject3	Object
    //   179	35	4	localObject4	Object
    //   301	30	4	localIOException1	IOException
    //   384	1	4	localIOException2	IOException
    // Exception table:
    //   from	to	target	type
    //   249	253	254	java/io/IOException
    //   0	80	260	java/lang/Exception
    //   81	113	260	java/lang/Exception
    //   113	167	260	java/lang/Exception
    //   249	253	260	java/lang/Exception
    //   255	259	260	java/lang/Exception
    //   348	352	260	java/lang/Exception
    //   354	358	260	java/lang/Exception
    //   366	370	260	java/lang/Exception
    //   370	372	260	java/lang/Exception
    //   373	377	260	java/lang/Exception
    //   167	210	301	java/io/IOException
    //   348	352	353	java/io/IOException
    //   167	210	359	finally
    //   366	370	372	java/io/IOException
    //   212	218	380	finally
    //   220	224	380	finally
    //   226	240	380	finally
    //   242	245	380	finally
    //   307	312	380	finally
    //   314	344	380	finally
    //   212	218	384	java/io/IOException
    //   220	224	384	java/io/IOException
    //   226	240	384	java/io/IOException
    //   242	245	384	java/io/IOException
  }
  
  public static void j(QQAppInterface paramQQAppInterface, String paramString)
  {
    h = paramString;
    a(paramQQAppInterface, 70);
  }
  
  private void j(ConfigurationService.Config paramConfig)
  {
    int i1 = paramConfig.version.get();
    SharedPreUtils.k(getAppRuntime().getApplication(), i1, h);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramConfig.content_list != null)
    {
      localObject1 = localObject2;
      if (paramConfig.content_list.size() > 0) {
        localObject1 = paramConfig.content_list.get();
      }
    }
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      localObject1 = (String)((List)localObject1).get(0);
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 102,content: " + (String)localObject1 + ",version: " + paramConfig.version.get());
      }
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
      try
      {
        paramConfig = Xml.newPullParser();
        paramConfig.setInput(new ByteArrayInputStream(((String)localObject1).getBytes()), "UTF-8");
        i1 = 0;
        if (i1 != 1)
        {
          if (i1 == 2)
          {
            localObject1 = paramConfig.getName();
            if (!((String)localObject1).equalsIgnoreCase("guardmgr_qzone_bg_time")) {
              break label210;
            }
            GuardManager.a(paramConfig.nextText());
          }
          for (;;)
          {
            i1 = paramConfig.next();
            break;
            label210:
            if (((String)localObject1).equalsIgnoreCase("JA_Switch")) {
              JumpActivity.a(paramConfig.nextText(), true);
            }
          }
        }
        while (!QLog.isColorLevel()) {}
      }
      catch (Exception paramConfig)
      {
        paramConfig = paramConfig;
        paramConfig.printStackTrace();
        return;
      }
      finally {}
    }
    QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 102,content_list is empty ,version: " + paramConfig.version.get());
  }
  
  private void j(String paramString, int paramInt)
  {
    ThreadManager.a(new rar(this, paramString, paramInt), 5, null, false);
  }
  
  private void k(ConfigurationService.Config paramConfig)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)getAppRuntime();
    if (QLog.isColorLevel()) {
      QLog.d("MobileUnityManager", 2, "CMD_PHONE_UNITY_BANNER_CONFIG");
    }
    PhoneUnityManager localPhoneUnityManager = (PhoneUnityManager)localQQAppInterface.getManager(101);
    i1 = localPhoneUnityManager.a();
    int i4 = paramConfig.version.get();
    if (QLog.isColorLevel()) {
      QLog.d("SPLASH_ConfigServlet", 2, "newVersion " + i4);
    }
    if (i1 == i4) {
      return;
    }
    localObject1 = null;
    Object localObject2;
    Object localObject6;
    if ((paramConfig.content_list != null) && (paramConfig.content_list.size() > 0))
    {
      localObject2 = paramConfig.content_list.get();
      localObject6 = localObject1;
      if (localObject2 != null)
      {
        localObject6 = localObject1;
        if (((List)localObject2).size() > 0)
        {
          localObject1 = (String)((List)localObject2).get(0);
          localObject6 = localObject1;
          if (QLog.isColorLevel())
          {
            QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 34,content: " + (String)localObject1 + ",version: " + paramConfig.version.get());
            localObject6 = localObject1;
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty((CharSequence)localObject6)) {
          continue;
        }
        localPhoneUnityBannerData2 = new PhoneUnityBannerData();
      }
      catch (Throwable localThrowable2)
      {
        PhoneUnityBannerData localPhoneUnityBannerData2;
        XmlPullParser localXmlPullParser;
        int i3;
        Object localObject3;
        PhoneUnityBannerData localPhoneUnityBannerData1 = null;
        i1 = 0;
        paramConfig = null;
        localObject1 = null;
        continue;
        localPhoneUnityBannerData1 = null;
        int i2 = 0;
        Object localObject4 = null;
        Object localObject5 = null;
        continue;
      }
      try
      {
        localXmlPullParser = Xml.newPullParser();
        localXmlPullParser.setInput(new ByteArrayInputStream(((String)localObject6).getBytes()), "UTF-8");
        i1 = 0;
        paramConfig = null;
        localObject1 = null;
        i3 = 0;
        localPhoneUnityBannerData1 = localPhoneUnityBannerData2;
        i2 = i1;
        localObject2 = paramConfig;
        localObject5 = localObject1;
        if (i3 == 1) {
          continue;
        }
        if (i3 != 2) {
          continue;
        }
        try
        {
          localObject2 = localXmlPullParser.getName();
          if (!((String)localObject2).equalsIgnoreCase("banner")) {
            continue;
          }
          i3 = localXmlPullParser.getAttributeCount();
          i2 = 0;
          if (i2 >= i3) {
            continue;
          }
          localObject2 = localXmlPullParser.getAttributeName(i2);
          if ("text".equals(localObject2))
          {
            localPhoneUnityBannerData2.jdField_b_of_type_JavaLangString = localXmlPullParser.getAttributeValue(i2);
            i2 += 1;
            continue;
            localObject6 = localObject1;
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 34,content_list is empty ,version: " + paramConfig.version.get());
            localObject6 = localObject1;
            continue;
          }
          if (!"url".equals(localObject2)) {
            continue;
          }
          localPhoneUnityBannerData2.jdField_a_of_type_JavaLangString = localXmlPullParser.getAttributeValue(i2);
          continue;
          QLog.e("PhoneContact.Manager", 1, "", localThrowable1);
        }
        catch (Throwable localThrowable1)
        {
          localPhoneUnityBannerData1 = localPhoneUnityBannerData2;
        }
      }
      catch (Throwable localThrowable3)
      {
        i1 = 0;
        paramConfig = null;
        localObject1 = null;
        localPhoneUnityBannerData1 = localPhoneUnityBannerData2;
        continue;
        continue;
        continue;
      }
      localObject5 = localObject1;
      localObject3 = paramConfig;
      i2 = i1;
      localPhoneUnityManager.a(i4, (String)localObject6, localPhoneUnityBannerData1);
      ((PhoneContactManagerImp)localQQAppInterface.getManager(10)).a(i2, (String)localObject5, (String)localObject3);
      return;
      if ("dayNum".equals(localObject3)) {
        localPhoneUnityBannerData2.jdField_a_of_type_Int = Integer.valueOf(localXmlPullParser.getAttributeValue(i2)).intValue();
      } else if ("dayIntervalNum".equals(localObject3)) {
        localPhoneUnityBannerData2.jdField_b_of_type_Int = Integer.valueOf(localXmlPullParser.getAttributeValue(i2)).intValue();
      } else if ("totalNum".equals(localObject3)) {
        localPhoneUnityBannerData2.c = Integer.valueOf(localXmlPullParser.getAttributeValue(i2)).intValue();
      } else if ("loginNum".equals(localObject3)) {
        localPhoneUnityBannerData2.e = Integer.valueOf(localXmlPullParser.getAttributeValue(i2)).intValue();
      } else if ("banner".equals(localObject3)) {
        localPhoneUnityBannerData2.jdField_a_of_type_Boolean = "1".equals(localXmlPullParser.getAttributeValue(i2));
      } else if ("setEntry".equals(localObject3)) {
        localPhoneUnityBannerData2.jdField_b_of_type_Boolean = "1".equals(localXmlPullParser.getAttributeValue(i2));
      }
    }
    for (;;)
    {
      try
      {
        i3 = localXmlPullParser.next();
      }
      catch (Throwable localThrowable4)
      {
        localPhoneUnityBannerData1 = localPhoneUnityBannerData2;
      }
      if (((String)localObject3).equalsIgnoreCase("bindGuideWording"))
      {
        localObject3 = localXmlPullParser.nextText();
        localObject1 = localObject3;
      }
      else if (((String)localObject3).equalsIgnoreCase("bindGuideStyle"))
      {
        i2 = Integer.valueOf(localXmlPullParser.nextText()).intValue();
        i1 = i2;
      }
      else
      {
        if (!((String)localObject3).equalsIgnoreCase("guideWording")) {
          break label817;
        }
        localObject3 = localXmlPullParser.nextText();
        paramConfig = (ConfigurationService.Config)localObject3;
      }
    }
  }
  
  private void l(ConfigurationService.Config paramConfig)
  {
    try
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)getAppRuntime();
      if ((paramConfig.content_list != null) && (paramConfig.content_list.size() > 0))
      {
        String str = (String)paramConfig.content_list.get(0);
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 32,content: " + str + ",version: " + paramConfig.version.get());
        }
        int i1 = paramConfig.version.get();
        int i2 = SharedPreUtils.j(localQQAppInterface.a());
        if (i1 > i2)
        {
          if (!PublicAccountConfigUtil.a((QQAppInterface)getAppRuntime(), getAppRuntime().getApplication(), str)) {
            return;
          }
          if (QLog.isColorLevel()) {
            QLog.d("SPLASH_ConfigServlet", 2, "received PUBLIC_ACCOUNT_CONFIG_CMD save version: " + i1);
          }
          SharedPreUtils.h(getAppRuntime().getApplication(), i1);
          return;
        }
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.d("SPLASH_ConfigServlet", 2, "received PUBLIC_ACCOUNT_CONFIG_CMD remote version: " + i1 + " | localVersion: " + i2);
        return;
      }
    }
    catch (Exception paramConfig)
    {
      if (QLog.isColorLevel()) {
        QLog.e("SPLASH_ConfigServlet", 2, "received PUBLIC_ACCOUNT_CONFIG_CMD error", paramConfig);
      }
      paramConfig.printStackTrace();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 32,content_list is empty ,version: " + paramConfig.version.get());
    }
  }
  
  private void m(ConfigurationService.Config paramConfig)
  {
    try
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)getAppRuntime();
      if ((paramConfig.content_list != null) && (paramConfig.content_list.size() > 0))
      {
        String str = (String)paramConfig.content_list.get(0);
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 35,content: " + str + ",version: " + paramConfig.version.get());
        }
        int i1 = paramConfig.version.get();
        int i2 = SharedPreUtils.z(localQQAppInterface.a(), localQQAppInterface.getAccount());
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "received PA_SUBCRIBE_RED_DOT remote version: " + i1 + " | localVersion: " + i2);
        }
        if (i1 != i2)
        {
          if ((PublicAccountConfigUtil.b((QQAppInterface)getAppRuntime(), getAppRuntime().getApplication(), str)) && (QLog.isColorLevel())) {
            QLog.d("SPLASH_ConfigServlet", 2, "received PA_SUBCRIBE_RED_DOT save version: " + i1);
          }
          SharedPreUtils.h(getAppRuntime().getApplication(), localQQAppInterface.getAccount(), i1);
          return;
        }
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.d("SPLASH_ConfigServlet", 2, "received PA_SUBCRIBE_RED_DOT IGNORE THIS ACTION  because of SAME VERSION");
        return;
      }
    }
    catch (Exception paramConfig)
    {
      if (QLog.isColorLevel()) {
        QLog.e("SPLASH_ConfigServlet", 2, "received PA_SUBCRIBE_RED_DOT error", paramConfig);
      }
      paramConfig.printStackTrace();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 35,content_list is empty ,version: " + paramConfig.version.get());
    }
  }
  
  private void n(ConfigurationService.Config paramConfig)
  {
    for (;;)
    {
      int i1;
      try
      {
        QQAppInterface localQQAppInterface = (QQAppInterface)getAppRuntime();
        if ((paramConfig.content_list != null) && (paramConfig.content_list.size() > 0))
        {
          i1 = 0;
          if (i1 < paramConfig.content_list.size())
          {
            String str = (String)paramConfig.content_list.get(i1);
            if (QLog.isColorLevel()) {
              QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 66,content: " + str + ",version: " + paramConfig.version.get());
            }
            int i2 = paramConfig.version.get();
            int i3 = SharedPreUtils.A(localQQAppInterface.a(), localQQAppInterface.getAccount());
            if (QLog.isColorLevel()) {
              QLog.d("SPLASH_ConfigServlet", 2, "received SUBSCRIPT_RECOMMEND_CMD remote version: " + i2 + " | localVersion: " + i3);
            }
            if ((i2 != i3) || (paramConfig.content_list.size() > 0))
            {
              if ((PublicAccountConfigUtil.a((QQAppInterface)getAppRuntime(), str)) && (QLog.isColorLevel())) {
                QLog.d("SPLASH_ConfigServlet", 2, "received SUBSCRIPT_RECOMMEND_CMD save version: " + i2);
              }
              SharedPreUtils.i(getAppRuntime().getApplication(), localQQAppInterface.getAccount(), i2);
            }
            else if (QLog.isColorLevel())
            {
              QLog.d("SPLASH_ConfigServlet", 2, "received SUBSCRIPT_RECOMMEND_CMD IGNORE THIS ACTION  because of SAME VERSION");
            }
          }
        }
      }
      catch (Exception paramConfig)
      {
        if (QLog.isColorLevel()) {
          QLog.e("SPLASH_ConfigServlet", 2, "received subscript recommend config error,cmd : 66");
        }
      }
      do
      {
        return;
      } while (!QLog.isColorLevel());
      QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 66,content_list is empty ,version: " + paramConfig.version.get());
      return;
      i1 += 1;
    }
  }
  
  private void o(ConfigurationService.Config paramConfig)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)getAppRuntime();
    if ((paramConfig.content_list != null) && (paramConfig.content_list.size() > 0))
    {
      str = (String)paramConfig.content_list.get(0);
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 43,content: " + str + ",version: " + paramConfig.version.get());
      }
      i1 = paramConfig.version.get();
      i2 = SharedPreUtils.D(localQQAppInterface.a(), h);
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, "received READINJOY_LOCAL_CHANNEL_CONFIG_CMD remote version: " + i1 + " | localVersion: " + i2);
      }
      if (i1 > i2)
      {
        SharedPreUtils.j(localQQAppInterface.a(), h, i1);
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "received READINJOY_LOCAL_CHANNEL_CONFIG_CMD save version: " + i1);
        }
        a(i1, "LocalChannelCity", str, localQQAppInterface);
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "received READINJOY_LOCAL_CHANNEL_CONFIG_CMD save to database");
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      String str;
      int i1;
      int i2;
      return;
    }
    QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 43,content_list is empty ,version: " + paramConfig.version.get());
  }
  
  private void p(ConfigurationService.Config paramConfig)
  {
    try
    {
      int i1 = SharedPreUtils.p(((QQAppInterface)getAppRuntime()).a());
      int i2 = paramConfig.version.get();
      if (i1 != i2)
      {
        ThreadManager.a(new raw(this, paramConfig), 8, null, false);
        return;
      }
      if (QLog.isColorLevel())
      {
        QLog.d("SPLASH_ConfigServlet", 2, "received HOTCHAT_SCENE_CONFIGS_CMD same version, " + i2);
        return;
      }
    }
    catch (Exception paramConfig)
    {
      paramConfig.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, "received HOTCHAT_SCENE_CONFIGS_CMD, EXCEPTION" + paramConfig.toString());
      }
    }
  }
  
  private void q(ConfigurationService.Config paramConfig)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)getAppRuntime();
    Object localObject2 = "";
    Object localObject1 = localObject2;
    for (;;)
    {
      Object localObject3;
      int i2;
      try
      {
        i1 = SharedPreUtils.k(localQQAppInterface.getApplication());
        localObject1 = localObject2;
        localObject3 = (HotPatchManager)localQQAppInterface.getManager(119);
        localObject1 = localObject2;
        if (paramConfig.content_list != null)
        {
          localObject1 = localObject2;
          if (paramConfig.content_list.size() > 0)
          {
            localObject1 = localObject2;
            i2 = paramConfig.version.get();
            localObject1 = localObject2;
            QLog.d("SPLASH_ConfigServlet", 1, "received PATCH_CONFIG_CMD remote version: " + i2 + " | localVersion: " + i1 + ", content_list size: " + paramConfig.content_list.size());
            if (i2 != i1)
            {
              localObject1 = localObject2;
              Object localObject4 = new ArrayList();
              i1 = 0;
              localObject1 = localObject2;
              if (i1 < paramConfig.content_list.size())
              {
                localObject1 = localObject2;
                String str = (String)paramConfig.content_list.get(i1);
                localObject1 = localObject2;
                if (QLog.isColorLevel())
                {
                  localObject1 = localObject2;
                  QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 46,content:  " + str + ",version: " + paramConfig.version.get());
                }
                localObject1 = localObject2;
                if (TextUtils.isEmpty(str)) {
                  break label708;
                }
                localObject1 = localObject2;
                ((ArrayList)localObject4).add(str);
                break label708;
              }
              localObject1 = localObject2;
              i1 = ((HotPatchManager)localObject3).a((ArrayList)localObject4);
              localObject1 = localObject2;
              SharedPreUtils.i(localQQAppInterface.getApplication(), i2);
              if ((i1 & 0x1) != 1) {
                break;
              }
              localObject1 = localObject2;
              localObject3 = localQQAppInterface.getApplication().getSharedPreferences("sp_dex_patch", 4);
              localObject1 = localObject2;
              paramConfig = ((SharedPreferences)localObject3).getString("name", "");
              localObject1 = paramConfig;
              localObject2 = StatisticCollector.a(BaseApplicationImpl.a());
              localObject1 = paramConfig;
              localObject4 = localQQAppInterface.f();
              if ((i1 & 0x2) != 2) {
                break label724;
              }
              i1 = 100;
              localObject1 = paramConfig;
              ((StatisticCollector)localObject2).a((String)localObject4, "actNvwaConfig", i1, paramConfig);
              localObject1 = paramConfig;
              localObject2 = ((SharedPreferences)localObject3).edit();
              localObject1 = paramConfig;
              localObject3 = ((SharedPreferences)localObject3).getAll();
              i1 = 0;
              localObject1 = paramConfig;
              localObject3 = ((Map)localObject3).entrySet().iterator();
              localObject1 = paramConfig;
              if (((Iterator)localObject3).hasNext())
              {
                localObject1 = paramConfig;
                localObject4 = (String)((Map.Entry)((Iterator)localObject3).next()).getKey();
                localObject1 = paramConfig;
                i2 = i1;
                if (TextUtils.isEmpty((CharSequence)localObject4)) {
                  break label717;
                }
                localObject1 = paramConfig;
                if (!((String)localObject4).equals("installFailCount"))
                {
                  localObject1 = paramConfig;
                  if (!((String)localObject4).equals("patchCrashCount"))
                  {
                    localObject1 = paramConfig;
                    if (!((String)localObject4).contains("startFailCount"))
                    {
                      localObject1 = paramConfig;
                      if (!((String)localObject4).contains("startFailRetryRound"))
                      {
                        localObject1 = paramConfig;
                        if (!((String)localObject4).contains("actNvwaCheck"))
                        {
                          localObject1 = paramConfig;
                          i2 = i1;
                          if (!((String)localObject4).contains("actNvwaInstall")) {
                            break label717;
                          }
                        }
                      }
                    }
                  }
                }
                i2 = 1;
                localObject1 = paramConfig;
                ((SharedPreferences.Editor)localObject2).remove((String)localObject4);
                break label717;
              }
              if (i1 == 0) {
                break;
              }
              localObject1 = paramConfig;
              ((SharedPreferences.Editor)localObject2).commit();
              return;
            }
            localObject1 = localObject2;
            QLog.d("SPLASH_ConfigServlet", 1, "received PATCH_CONFIG_CMD IGNORE THIS ACTION  because of SAME VERSION");
            if (i1 <= 0) {
              break;
            }
            localObject1 = localObject2;
            ((HotPatchManager)localObject3).a(false);
            return;
          }
        }
      }
      catch (Throwable paramConfig)
      {
        QLog.e("SPLASH_ConfigServlet", 1, "received PATCH_CONFIG_CMD throwable=" + paramConfig.toString());
        paramConfig.printStackTrace();
        StatisticCollector.a(BaseApplicationImpl.a()).a(localQQAppInterface.f(), "actNvwaConfig", 102, (String)localObject1);
        return;
      }
      localObject1 = localObject2;
      if (QLog.isColorLevel())
      {
        localObject1 = localObject2;
        QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 46,content_list is empty ,version: " + paramConfig.version.get());
      }
      localObject1 = localObject2;
      QLog.d("SPLASH_ConfigServlet", 1, "received PATCH_CONFIG_CMD content_list is empty");
      if (i1 <= 0) {
        break;
      }
      localObject1 = localObject2;
      ((HotPatchManager)localObject3).a(false);
      return;
      label708:
      i1 += 1;
      continue;
      label717:
      int i1 = i2;
      continue;
      label724:
      i1 = 102;
    }
  }
  
  private void r(ConfigurationService.Config paramConfig)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)getAppRuntime();
    if ((paramConfig.content_list != null) && (paramConfig.content_list.size() > 0))
    {
      str = (String)paramConfig.content_list.get(0);
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 50,content: " + str + ",version: " + paramConfig.version.get());
      }
      i1 = paramConfig.version.get();
      i2 = SharedPreUtils.x(localQQAppInterface.a(), h);
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, "received SEARCH_CONFIG_CMD remote version: " + i1 + " | localVersion: " + i2);
      }
      if (i1 > i2)
      {
        SharedPreUtils.f(localQQAppInterface.a(), h, i1);
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "received SEARCH_CONFIG_CMD save version: " + i1);
        }
        SearchConfigManager.a(localQQAppInterface, h, str);
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "received SEARCH_CONFIG_CMD save to sps");
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      String str;
      int i1;
      int i2;
      return;
    }
    QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 50,content_list is empty ,version: " + paramConfig.version.get());
  }
  
  private void s(ConfigurationService.Config paramConfig)
  {
    ThreadManager.b().post(new rax(this, paramConfig));
  }
  
  private void t(ConfigurationService.Config paramConfig)
  {
    ThreadManager.a(new ray(this, paramConfig), 5, null, false);
  }
  
  private void u(ConfigurationService.Config paramConfig)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)getAppRuntime();
    if ((paramConfig.content_list != null) && (paramConfig.content_list.size() > 0))
    {
      str = (String)paramConfig.content_list.get(0);
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 61,content: " + str + ",version: " + paramConfig.version.get());
      }
      i1 = paramConfig.version.get();
      i2 = SharedPreUtils.r(localQQAppInterface.a());
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, "received CAMERA_COMPATIBLE_LIST_CONFIG remote version: " + i1 + " | localVersion: " + i2);
      }
      if (i1 > i2)
      {
        SharedPreUtils.m(localQQAppInterface.a(), i1);
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "received CAMERA_COMPATIBLE_LIST_CONFIG save version: " + i1);
        }
        CameraCompatibleList.a(str, true);
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "received CAMERA_COMPATIBLE_LIST_CONFIG save to sps");
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      String str;
      int i1;
      int i2;
      return;
    }
    QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 61,content_list is empty ,version: " + paramConfig.version.get());
  }
  
  private void v(ConfigurationService.Config paramConfig)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)getAppRuntime();
    if ((paramConfig.content_list != null) && (paramConfig.content_list.size() > 0))
    {
      str = (String)paramConfig.content_list.get(0);
      i1 = paramConfig.version.get();
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 64,content: " + str + ",version: " + paramConfig.version.get());
      }
      if (i1 > SharedPreUtils.t(localQQAppInterface.a()))
      {
        SharedPreUtils.o(localQQAppInterface.a(), i1);
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "received SHORTVIDEO_PROGRESSIVE_BLACKLIST_CONFIG save version: " + i1);
        }
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "received SHORTVIDEO_PROGRESSIVE_BLACKLIST_CONFIG save to sps");
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      String str;
      int i1;
      return;
    }
    QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 64,content_list is empty ,version: " + paramConfig.version.get());
  }
  
  private void w(ConfigurationService.Config paramConfig)
  {
    ThreadManager.b().post(new raz(this, paramConfig));
  }
  
  private void x(ConfigurationService.Config paramConfig)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)getAppRuntime();
    if (QLog.isDevelopLevel()) {
      NearbyUtils.a("GENERAL_LBS_CONFIGS_CMD", "handleGeneralLbsConfigsCmd", new Object[] { Integer.valueOf(paramConfig.version.get()), Integer.valueOf(paramConfig.type.get()), paramConfig.content_list.get() });
    }
    if ((paramConfig.content_list != null) && (paramConfig.content_list.size() > 0)) {}
    for (List localList = paramConfig.content_list.get();; localList = null)
    {
      if ((localList != null) && (localList.size() > 0))
      {
        HashMap localHashMap = new HashMap();
        int i1 = 0;
        if (i1 < localList.size())
        {
          Object localObject = (String)localList.get(i1);
          if (QLog.isColorLevel()) {
            QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 104,content: " + (String)localObject + ",version: " + paramConfig.version.get());
          }
          if (TextUtils.isEmpty((CharSequence)localObject)) {}
          for (;;)
          {
            i1 += 1;
            break;
            localObject = ((String)localObject).split("=");
            if ((localObject != null) && (localObject.length == 2))
            {
              localHashMap.put(localObject[0], localObject[1]);
              if (QLog.isColorLevel()) {
                NearbyUtils.a("GENERAL_LBS_CONFIGS_CMD", new Object[] { "name", localObject[0], "val", localObject[1] });
              }
            }
          }
        }
        NearbyProxy.b(localQQAppInterface, (String)localHashMap.get("nearby_fresh_news_show"));
        NearbyProxy.a(localQQAppInterface, (String)localHashMap.get("hotchat_tab_switch"));
        localQQAppInterface.a().a(localQQAppInterface, (String)localHashMap.get("da_ren_bang"));
      }
      for (;;)
      {
        SharedPreUtils.l(localQQAppInterface.a(), paramConfig.version.get(), h);
        return;
        NearbyProxy.b(localQQAppInterface, "");
        NearbyProxy.a(localQQAppInterface, "");
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 104,content_list is empty ,version: " + paramConfig.version.get());
        }
      }
    }
  }
  
  private void y(ConfigurationService.Config paramConfig)
  {
    int i1 = 0;
    if (QLog.isDevelopLevel()) {
      QLog.d("SPLASH_ConfigServlet", 2, new Object[] { "handlePrecoverConfig, version=", Integer.valueOf(paramConfig.version.get()), ", type=", Integer.valueOf(paramConfig.type.get()), ", msg_content_list=", paramConfig.msg_content_list.get() });
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)getAppRuntime();
    ArrayList localArrayList = new ArrayList();
    if ((paramConfig.msg_content_list != null) && (paramConfig.msg_content_list.size() > 0)) {}
    for (List localList = paramConfig.msg_content_list.get();; localList = null)
    {
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("handlePrecoverConfig, configList.size=");
        if (localList != null) {
          break label250;
        }
      }
      label250:
      for (Object localObject = "null";; localObject = Integer.valueOf(localList.size()))
      {
        QLog.d("SPLASH_ConfigServlet", 2, localObject);
        if ((localList == null) || (localList.size() <= 0)) {
          break;
        }
        while (i1 < localList.size())
        {
          localObject = (ConfigurationService.Content)paramConfig.msg_content_list.get(i1);
          if (localObject != null)
          {
            int i2 = ((ConfigurationService.Content)localObject).task_id.get();
            localObject = PrecoverUtils.a((ConfigurationService.Content)localObject);
            if (localObject != null) {
              localArrayList.add(new Pair(Integer.valueOf(i2), localObject));
            }
          }
          i1 += 1;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, "handlePrecoverConfig, configList is empty");
      }
      PrecoverUtils.a(localQQAppInterface.a(), paramConfig.version.get(), h);
      paramConfig = (PrecoverManager)localQQAppInterface.getManager(178);
      if (paramConfig != null)
      {
        paramConfig.a(localArrayList);
        paramConfig.a();
        paramConfig.a(true);
      }
      return;
    }
  }
  
  private void z(ConfigurationService.Config paramConfig)
  {
    Object localObject = (QQAppInterface)getAppRuntime();
    PreloadManager localPreloadManager = (PreloadManager)((QQAppInterface)localObject).getManager(150);
    if ((paramConfig.content_list != null) && (paramConfig.content_list.size() > 0) && (paramConfig.version.has()))
    {
      int i1 = paramConfig.version.get();
      int i2 = SharedPreUtils.I(((QQAppInterface)localObject).a(), ((QQAppInterface)localObject).a());
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, "received PRELOAD_CONFIG remote version: " + i1 + " | localVersion: " + i2);
      }
      if (i1 > i2)
      {
        SharedPreUtils.o(((QQAppInterface)localObject).a(), ((QQAppInterface)localObject).a(), i1);
        localObject = paramConfig.content_list.get().iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          if (QLog.isColorLevel()) {
            QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 68,content: " + str + ",version: " + paramConfig.version.get());
          }
          localPreloadManager.a(str);
        }
        localPreloadManager.c();
      }
      localPreloadManager.b();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 68,content_list is empty ,version: " + paramConfig.version.get());
    }
    localPreloadManager.a();
  }
  
  public void a(Intent paramIntent, boolean paramBoolean, ConfigurationService.Config paramConfig, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Olympic.configServlet", 2, new Object[] { "handleResp_GetOlympicActConfig, success=", Boolean.valueOf(paramBoolean) });
    }
    int i4 = 0;
    int i1 = 0;
    int i2 = 2;
    int i3;
    OlympicActConfig localOlympicActConfig;
    if ((paramBoolean) && (paramConfig != null) && (paramConfig.type.get() == 86))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Olympic.configServlet", 2, new Object[] { "handleResp_GetOlympicActConfig, result=", Integer.valueOf(paramInt) });
      }
      if (paramInt == 0)
      {
        i3 = paramConfig.version.get();
        paramInt = paramIntent.getIntExtra("config_version", 0);
        if (QLog.isColorLevel()) {
          QLog.d("Olympic.configServlet", 2, new Object[] { "handleResp_GetOlympicActConfig, reqVersion=", Integer.valueOf(paramInt), ", receiveVersion=", Integer.valueOf(i3) });
        }
        if (i3 != paramInt) {
          if ((paramConfig.msg_content_list != null) && (paramConfig.msg_content_list.size() > 0))
          {
            paramIntent = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
            if (paramIntent != null)
            {
              i2 = paramIntent.task_id.get();
              if (paramIntent.compress.get() == 1)
              {
                paramConfig = OlympicUtil.a(paramIntent.content.get().toByteArray());
                if (paramConfig == null)
                {
                  paramInt = 4;
                  paramIntent = null;
                  if (QLog.isColorLevel()) {
                    QLog.d("Olympic.configServlet", 2, new Object[] { "handleResp_GetOlympicActConfig, xmlContent=", paramIntent });
                  }
                  localOlympicActConfig = OlympicActConfig.parse(getAppRuntime(), paramIntent);
                  if (QLog.isColorLevel())
                  {
                    if (localOlympicActConfig != null) {
                      break label518;
                    }
                    paramConfig = "null";
                    label290:
                    QLog.d("Olympic.configServlet", 2, new Object[] { "handleResp_GetOlympicActConfig, newConfig=", paramConfig });
                  }
                  if (localOlympicActConfig == null) {
                    break label550;
                  }
                  i1 = 0;
                  localOlympicActConfig.version = i3;
                  paramIntent = (OlympicManager)((QQAppInterface)getAppRuntime()).getManager(166);
                  if (paramIntent == null) {
                    break label524;
                  }
                  paramIntent.a(localOlympicActConfig);
                  paramInt = i1;
                  label356:
                  i1 = i2;
                  label360:
                  i2 = i3;
                  i3 = i1;
                  i1 = paramInt;
                  paramInt = i3;
                }
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      OlympicServlet.a(getAppRuntime(), 86, i2, paramInt, 1, i1, -1);
      paramIntent = (OlympicManager)((QQAppInterface)getAppRuntime()).getManager(166);
      if (paramIntent != null)
      {
        paramIntent.q();
        paramIntent.n();
      }
      return;
      try
      {
        paramIntent = new String(paramConfig, "UTF-8");
        paramInt = 2;
      }
      catch (UnsupportedEncodingException paramIntent)
      {
        if (QLog.isColorLevel()) {
          paramIntent.printStackTrace();
        }
        paramIntent = null;
        paramInt = 2;
      }
      catch (OutOfMemoryError paramIntent)
      {
        if (QLog.isColorLevel()) {
          paramIntent.printStackTrace();
        }
        System.gc();
        try
        {
          paramIntent = new String(paramConfig, "UTF-8");
          paramInt = 2;
        }
        catch (Throwable paramIntent)
        {
          paramIntent = null;
          paramInt = 2;
        }
      }
      break;
      paramIntent = paramIntent.content.get().toStringUtf8();
      paramInt = 2;
      break;
      label518:
      paramConfig = localOlympicActConfig;
      break label290;
      label524:
      paramInt = i1;
      if (!QLog.isColorLevel()) {
        break label356;
      }
      QLog.d("Olympic.configServlet", 2, "handleResp_GetOlympicActConfig, manager is null!");
      paramInt = i1;
      break label356;
      label550:
      i1 = paramInt;
      if (paramIntent != null) {
        i1 = 5;
      }
      paramInt = i1;
      if (!QLog.isColorLevel()) {
        break label356;
      }
      QLog.d("Olympic.configServlet", 2, "handleResp_GetOlympicActConfig, parse failed, newConfig is null!");
      paramInt = i1;
      break label356;
      if (QLog.isColorLevel()) {
        QLog.d("Olympic.configServlet", 2, "handleResp_GetOlympicActConfig, content is null");
      }
      i1 = 0;
      paramInt = i2;
      break label360;
      if (QLog.isColorLevel()) {
        QLog.d("Olympic.configServlet", 2, "handleResp_GetOlympicActConfig, msg_content_list is null");
      }
      paramIntent = (QQAppInterface)getAppRuntime();
      paramConfig = (OlympicManager)paramIntent.getManager(166);
      if (paramConfig != null) {
        paramConfig.m();
      }
      OlympicActConfig.deleteFile(paramIntent, BaseApplicationImpl.getContext());
      paramInt = i2;
      i1 = i4;
      break label360;
      paramInt = i2;
      i1 = i4;
      if (!QLog.isColorLevel()) {
        break label360;
      }
      QLog.d("Olympic.configServlet", 2, "handleResp_GetOlympicActConfig, has same version");
      paramInt = i2;
      i1 = i4;
      break label360;
      paramInt = 0;
      i3 = 1;
      i2 = i1;
      i1 = i3;
      continue;
      paramInt = 0;
      i3 = 1;
      i2 = i1;
      i1 = i3;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HotFriend_SPLASH_ConfigServlet", 2, "handleRespGetHotDaysConfig|type= " + paramConfig.type.get());
    }
    int i14 = paramConfig.version.get();
    Object localObject;
    boolean bool1;
    boolean bool3;
    int i7;
    int i8;
    int i9;
    int i10;
    int i11;
    int i12;
    if ((paramConfig.content_list != null) && (paramConfig.content_list.size() > 0))
    {
      paramConfig = (String)paramConfig.content_list.get(0);
      if (QLog.isColorLevel()) {
        QLog.d("HotFriend_SPLASH_ConfigServlet", 2, "content" + paramConfig);
      }
      if (paramConfig == null) {
        break label1247;
      }
      localObject = Xml.newPullParser();
      bool1 = false;
      bool3 = false;
      i7 = 0;
      i8 = 30;
      i9 = 0;
      i10 = 30;
      i11 = 0;
      i12 = 30;
    }
    for (;;)
    {
      boolean bool2;
      int i1;
      try
      {
        ((XmlPullParser)localObject).setInput(new ByteArrayInputStream(paramConfig.getBytes()), "UTF-8");
        i13 = ((XmlPullParser)localObject).getEventType();
      }
      catch (Exception paramQQAppInterface)
      {
        String str;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("HotFriend_SPLASH_ConfigServlet", 2, paramConfig, paramQQAppInterface);
        return;
      }
      int i13 = ((XmlPullParser)localObject).next();
      bool1 = bool2;
      boolean bool4;
      bool3 = bool4;
      i7 = i1;
      int i2;
      i8 = i2;
      int i3;
      i9 = i3;
      int i4;
      i10 = i4;
      int i5;
      i11 = i5;
      int i6;
      i12 = i6;
      break label1264;
      str = ((XmlPullParser)localObject).getName();
      if (str.equalsIgnoreCase("ShowInContact"))
      {
        bool2 = bool1;
        bool4 = bool3;
        i1 = i7;
        i2 = i8;
        i3 = i9;
        i4 = i10;
        i5 = i11;
        i6 = i12;
        if (Integer.valueOf(((XmlPullParser)localObject).nextText()).intValue() == 1)
        {
          bool2 = true;
          bool4 = bool3;
          i1 = i7;
          i2 = i8;
          i3 = i9;
          i4 = i10;
          i5 = i11;
          i6 = i12;
        }
      }
      else if (str.equalsIgnoreCase("ShowInChat"))
      {
        bool2 = bool1;
        bool4 = bool3;
        i1 = i7;
        i2 = i8;
        i3 = i9;
        i4 = i10;
        i5 = i11;
        i6 = i12;
        if (Integer.valueOf(((XmlPullParser)localObject).nextText()).intValue() == 1)
        {
          bool4 = true;
          bool2 = bool1;
          i1 = i7;
          i2 = i8;
          i3 = i9;
          i4 = i10;
          i5 = i11;
          i6 = i12;
        }
      }
      else if (str.equalsIgnoreCase("minInteractiveDays"))
      {
        i7 = Integer.valueOf(((XmlPullParser)localObject).nextText()).intValue();
        bool2 = bool1;
        bool4 = bool3;
        i1 = i7;
        i2 = i8;
        i3 = i9;
        i4 = i10;
        i5 = i11;
        i6 = i12;
        if (i7 <= 0)
        {
          i1 = 3;
          bool2 = bool1;
          bool4 = bool3;
          i2 = i8;
          i3 = i9;
          i4 = i10;
          i5 = i11;
          i6 = i12;
        }
      }
      else if (str.equalsIgnoreCase("maxInteractiveDays"))
      {
        i8 = Integer.valueOf(((XmlPullParser)localObject).nextText()).intValue();
        bool2 = bool1;
        bool4 = bool3;
        i1 = i7;
        i2 = i8;
        i3 = i9;
        i4 = i10;
        i5 = i11;
        i6 = i12;
        if (i8 <= 0)
        {
          i2 = 30;
          bool2 = bool1;
          bool4 = bool3;
          i1 = i7;
          i3 = i9;
          i4 = i10;
          i5 = i11;
          i6 = i12;
        }
      }
      else if (str.equalsIgnoreCase("minLinkDays"))
      {
        i9 = Integer.valueOf(((XmlPullParser)localObject).nextText()).intValue();
        bool2 = bool1;
        bool4 = bool3;
        i1 = i7;
        i2 = i8;
        i3 = i9;
        i4 = i10;
        i5 = i11;
        i6 = i12;
        if (i9 <= 0)
        {
          i3 = 3;
          bool2 = bool1;
          bool4 = bool3;
          i1 = i7;
          i2 = i8;
          i4 = i10;
          i5 = i11;
          i6 = i12;
        }
      }
      else if (str.equalsIgnoreCase("maxLinkDays"))
      {
        i10 = Integer.valueOf(((XmlPullParser)localObject).nextText()).intValue();
        bool2 = bool1;
        bool4 = bool3;
        i1 = i7;
        i2 = i8;
        i3 = i9;
        i4 = i10;
        i5 = i11;
        i6 = i12;
        if (i10 <= 0)
        {
          i4 = 30;
          bool2 = bool1;
          bool4 = bool3;
          i1 = i7;
          i2 = i8;
          i3 = i9;
          i5 = i11;
          i6 = i12;
        }
      }
      else if (str.equalsIgnoreCase("minIntimacyDays"))
      {
        i11 = Integer.valueOf(((XmlPullParser)localObject).nextText()).intValue();
        bool2 = bool1;
        bool4 = bool3;
        i1 = i7;
        i2 = i8;
        i3 = i9;
        i4 = i10;
        i5 = i11;
        i6 = i12;
        if (i11 <= 0)
        {
          i5 = 3;
          bool2 = bool1;
          bool4 = bool3;
          i1 = i7;
          i2 = i8;
          i3 = i9;
          i4 = i10;
          i6 = i12;
        }
      }
      else
      {
        bool2 = bool1;
        bool4 = bool3;
        i1 = i7;
        i2 = i8;
        i3 = i9;
        i4 = i10;
        i5 = i11;
        i6 = i12;
        if (str.equalsIgnoreCase("maxIntimacyDays"))
        {
          i12 = Integer.valueOf(((XmlPullParser)localObject).nextText()).intValue();
          bool2 = bool1;
          bool4 = bool3;
          i1 = i7;
          i2 = i8;
          i3 = i9;
          i4 = i10;
          i5 = i11;
          i6 = i12;
          if (i12 <= 0)
          {
            i6 = 30;
            bool2 = bool1;
            bool4 = bool3;
            i1 = i7;
            i2 = i8;
            i3 = i9;
            i4 = i10;
            i5 = i11;
            continue;
            localObject = bool1 + "|" + bool3 + "|" + i7 + "|" + i8 + "|" + i9 + "|" + i10 + "|" + i11 + "|" + i12;
            if (QLog.isColorLevel()) {
              QLog.d("HotFriend_SPLASH_ConfigServlet", 2, "handleRespGetHotDaysConfig success：showInContact|ShowInChat|settingdays=" + bool1 + "|" + bool3 + "|" + (String)localObject);
            }
            SharedPreUtils.u(paramQQAppInterface.a(), i14, paramQQAppInterface.a());
            SharedPreUtils.a(paramQQAppInterface.a(), paramQQAppInterface.a(), bool1, bool3, (String)localObject);
            ((FriendsManager)paramQQAppInterface.getManager(50)).a(bool1, bool3, i7, i8, i9, i10, i11, i12);
            return;
            label1247:
            if (QLog.isColorLevel())
            {
              QLog.d("HotFriend_SPLASH_ConfigServlet", 2, "content = null");
              return;
              label1264:
              if (i13 != 1)
              {
                bool2 = bool1;
                bool4 = bool3;
                i1 = i7;
                i2 = i8;
                i3 = i9;
                i4 = i10;
                i5 = i11;
                i6 = i12;
                switch (i13)
                {
                }
                bool2 = bool1;
                bool4 = bool3;
                i1 = i7;
                i2 = i8;
                i3 = i9;
                i4 = i10;
                i5 = i11;
                i6 = i12;
              }
            }
          }
        }
      }
    }
  }
  
  public void a(ConfigurationService.Config paramConfig)
  {
    for (;;)
    {
      int i1;
      try
      {
        QQAppInterface localQQAppInterface = (QQAppInterface)getAppRuntime();
        if ((paramConfig.content_list != null) && (paramConfig.content_list.size() > 0))
        {
          i1 = 0;
          if (i1 < paramConfig.content_list.size())
          {
            String str = ((String)paramConfig.content_list.get(i1)).trim();
            if (QLog.isColorLevel()) {
              QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 79,content: " + str + ",version: " + paramConfig.version.get());
            }
            int i2 = paramConfig.version.get();
            if ((i2 != SharedPreUtils.J(localQQAppInterface.a(), localQQAppInterface.a())) || (paramConfig.content_list.size() > 0))
            {
              str = str.split("=")[1];
              if (!TextUtils.isEmpty(str)) {
                ReadInJoyHelper.c(str, localQQAppInterface);
              }
              SharedPreUtils.t(localQQAppInterface.a(), i2, localQQAppInterface.a());
            }
            else if (QLog.isColorLevel())
            {
              QLog.d("SPLASH_ConfigServlet", 2, "received READINJOY_MERGE_CONFIG_CMD IGNORE THIS ACTION  because of SAME VERSION");
            }
          }
        }
      }
      catch (Exception paramConfig)
      {
        if (QLog.isColorLevel()) {
          QLog.e("SPLASH_ConfigServlet", 2, "received readinjoy merge config error,cmd : 79" + paramConfig.toString());
        }
      }
      do
      {
        return;
      } while (!QLog.isColorLevel());
      QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 79,content_list is empty ,version: " + paramConfig.version.get());
      return;
      i1 += 1;
    }
  }
  
  void a(ConfigurationService.Config paramConfig, QQAppInterface paramQQAppInterface)
  {
    int i3 = paramConfig.version.get();
    if (QLog.isColorLevel()) {
      QLog.i("Ecshop", 2, "config :" + paramConfig.content_list.get().toString() + "; version:" + i3);
    }
    if (!paramConfig.content_list.has()) {
      return;
    }
    int i4 = paramConfig.content_list.size();
    int i1 = 0;
    boolean bool1 = false;
    if (i1 < i4) {}
    for (;;)
    {
      try
      {
        localJSONObject = new JSONObject((String)paramConfig.content_list.get(i1));
        if (localJSONObject.optJSONObject("global") != null) {
          continue;
        }
        localJSONObject = localJSONObject.optJSONObject("whiteList");
        if (localJSONObject == null) {
          continue;
        }
        i2 = localJSONObject.getInt("android");
        if (i2 != 1) {
          continue;
        }
        i2 = 1;
        if ((!bool1) && (i2 == 0)) {
          continue;
        }
        bool1 = true;
        bool2 = bool1;
        if (i2 == 0) {
          continue;
        }
      }
      catch (Exception paramConfig)
      {
        JSONObject localJSONObject;
        int i2;
        boolean bool2;
        continue;
      }
      EcShopAssistantManager.jdField_a_of_type_Boolean = bool1;
      getAppRuntime().getApplication().getSharedPreferences("ecshop_sp" + h, 0).edit().putBoolean("folder_can_del", EcShopAssistantManager.jdField_a_of_type_Boolean).commit();
      paramConfig = paramQQAppInterface.a(Conversation.class);
      if (paramConfig != null) {
        paramConfig.sendEmptyMessage(1009);
      }
      SharedPreUtils.a(getAppRuntime().getApplication(), "Ecshop_Folder", h, i3);
      return;
      localJSONObject = localJSONObject.optJSONObject("global");
      continue;
      i2 = 0;
      continue;
      bool1 = false;
      continue;
      bool2 = bool1;
      i1 += 1;
      bool1 = bool2;
      break;
    }
  }
  
  public void b(Intent paramIntent, boolean paramBoolean, ConfigurationService.Config paramConfig, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.camera.configServlet", 2, "[handleRespQCameraPhoneConfig] ENTER success=" + paramBoolean + " result=" + paramInt);
    }
    int i2 = 0;
    int i1 = 2;
    String str = paramIntent.getStringExtra("uin");
    int i3;
    if ((paramBoolean) && (paramConfig != null) && (paramConfig.type.get() == 109)) {
      if (paramInt == 0)
      {
        i3 = paramConfig.version.get();
        int i4 = paramIntent.getIntExtra("qcamera_conf_version", 0);
        QLog.i("Q.camera.configServlet", 1, "[handleRespQCameraPhoneConfig] reqVersion=" + i4 + " receiveVersion=" + i3);
        paramInt = i1;
        i1 = i2;
        if (i3 != i4)
        {
          CameraUtils.a(BaseApplicationImpl.getContext(), i3);
          if (QLog.isColorLevel()) {
            QLog.d("Q.camera.configServlet", 2, "[handleRespQCameraPhoneConfig] save version: " + i3 + " and check config version: " + CameraUtils.a(BaseApplicationImpl.getContext()));
          }
          if ((paramConfig.msg_content_list == null) || (paramConfig.msg_content_list.size() <= 0)) {
            break label611;
          }
          paramIntent = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
          i1 = paramIntent.task_id.get();
          if (paramIntent.compress.get() != 1) {
            break label547;
          }
          paramIntent = CameraUtils.a(paramIntent.content.get().toByteArray());
          if (paramIntent != null) {
            break label485;
          }
          i2 = 4;
          CameraUtils.a(BaseApplicationImpl.getContext(), true);
          paramInt = i2;
          if (QLog.isColorLevel())
          {
            QLog.d("Q.camera.configServlet", 2, "[handleRespQCameraPhoneConfig] uncompress failed, check disableCameraSDK=" + CameraUtils.a(BaseApplicationImpl.getContext()));
            paramInt = i2;
          }
        }
        i2 = paramInt;
        paramInt = i3;
        i3 = i1;
        i1 = i4;
      }
    }
    for (;;)
    {
      QLog.i("Q.camera.configServlet", 1, "[handleRespQCameraPhoneConfig] rptResult=" + i2);
      paramIntent = new HashMap();
      paramIntent.put("rpt_type", String.valueOf(109));
      paramIntent.put("rpt_task_id", String.valueOf(i3));
      paramIntent.put("rpt_req_version", String.valueOf(i1));
      paramIntent.put("rpt_version", String.valueOf(paramInt));
      paramIntent.put("rpt_report_type", String.valueOf(1));
      paramIntent.put("rpt_result", String.valueOf(i2));
      StatisticCollector.a(BaseApplication.getContext()).a(str, "qcamera_phone_config_pull_event", paramBoolean, 0L, 0L, paramIntent, String.valueOf(i2));
      return;
      label485:
      paramInt = 0;
      paramIntent = new String(paramIntent);
      if (QLog.isColorLevel()) {
        QLog.d("Q.camera.configServlet", 4, new Object[] { "[handleRespQCameraPhoneConfig] zip xmlContent=", paramIntent });
      }
      try
      {
        CameraUtils.a(BaseApplicationImpl.getContext(), paramIntent, i3);
      }
      catch (Exception paramIntent)
      {
        paramIntent.printStackTrace();
        paramInt = 3;
      }
      break;
      label547:
      paramIntent = paramIntent.content.get().toStringUtf8();
      if (QLog.isColorLevel()) {
        QLog.d("Q.camera.configServlet", 4, new Object[] { "[handleRespQCameraPhoneConfig] raw xmlContent=", paramIntent });
      }
      try
      {
        CameraUtils.a(BaseApplicationImpl.getContext(), paramIntent, i3);
        paramInt = 0;
      }
      catch (Exception paramIntent)
      {
        paramIntent.printStackTrace();
        paramInt = 3;
      }
      break;
      label611:
      paramInt = 5;
      QLog.w("Q.camera.configServlet", 1, "[handleRespQCameraPhoneConfig] no data, current disableCameraSDK=" + CameraUtils.a(BaseApplicationImpl.getContext()));
      i1 = i2;
      break;
      paramInt = 0;
      i2 = 1;
      i3 = 0;
      i1 = 0;
      continue;
      paramInt = 0;
      i2 = 1;
      i3 = 0;
      i1 = 0;
    }
  }
  
  public void b(ConfigurationService.Config paramConfig)
  {
    for (;;)
    {
      QQAppInterface localQQAppInterface;
      int i1;
      int i2;
      String str1;
      String str2;
      try
      {
        localQQAppInterface = (QQAppInterface)getAppRuntime();
        if ((paramConfig.content_list == null) || (paramConfig.content_list.size() <= 0)) {
          break label380;
        }
        i1 = 0;
        if (i1 < paramConfig.content_list.size())
        {
          Object localObject = ((String)paramConfig.content_list.get(i1)).trim();
          if (QLog.isColorLevel()) {
            QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 92,content: " + (String)localObject + ",version: " + paramConfig.version.get());
          }
          i2 = paramConfig.version.get();
          if ((i2 == SharedPreUtils.y(localQQAppInterface.a())) && (paramConfig.content_list.size() <= 0)) {
            break label362;
          }
          localObject = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(((String)localObject).getBytes("utf-8"))).getElementsByTagName("configs").item(0).getFirstChild();
          if (localObject == null) {
            break label350;
          }
          if (((Node)localObject).getFirstChild() != null)
          {
            str1 = ((Node)localObject).getNodeName();
            str2 = ((Node)localObject).getFirstChild().getNodeValue();
            if (TextUtils.equals(str1, "smartcrop_pic")) {
              ReadInJoyHelper.c(localQQAppInterface, str2);
            }
          }
          else
          {
            localObject = ((Node)localObject).getNextSibling();
            continue;
          }
          if (TextUtils.equals(str1, "feeds_group"))
          {
            ReadInJoyHelper.a(localQQAppInterface, str2);
            continue;
          }
        }
        else
        {
          return;
        }
      }
      catch (Exception paramConfig)
      {
        if (QLog.isColorLevel()) {
          QLog.e("SPLASH_ConfigServlet", 2, "received readinjoy cropandgroup config error,cmd : 92" + paramConfig.toString());
        }
      }
      label295:
      if (TextUtils.equals(str1, "remind_only_wifi"))
      {
        ReadInJoyHelper.b(localQQAppInterface, str2);
      }
      else if (TextUtils.equals(str1, "kandian_individual_time_push"))
      {
        if (TextUtils.equals(str2, "1")) {}
        for (boolean bool = true;; bool = false)
        {
          ReadInJoyHelper.b(localQQAppInterface, bool);
          break;
          label350:
          SharedPreUtils.t(localQQAppInterface.a(), i2);
          break label425;
          label362:
          if (!QLog.isColorLevel()) {
            break label425;
          }
          QLog.d("SPLASH_ConfigServlet", 2, "received READINJOY_CROP_AND_GROUP_CONFIG IGNORE THIS ACTION  because of SAME VERSION");
          break label425;
          label380:
          if (!QLog.isColorLevel()) {
            break label295;
          }
          QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 92,content_list is empty ,version: " + paramConfig.version.get());
          return;
        }
        label425:
        i1 += 1;
      }
    }
  }
  
  public void c(ConfigurationService.Config paramConfig)
  {
    for (;;)
    {
      int i1;
      try
      {
        QQAppInterface localQQAppInterface = (QQAppInterface)getAppRuntime();
        if ((paramConfig.content_list != null) && (paramConfig.content_list.size() > 0))
        {
          i1 = 0;
          if (i1 < paramConfig.content_list.size())
          {
            String str = (String)paramConfig.content_list.get(i1);
            if (QLog.isColorLevel()) {
              QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 72,content: " + str + ",version: " + paramConfig.version.get());
            }
            int i2 = paramConfig.version.get();
            if ((i2 != SharedPreUtils.v(localQQAppInterface.a())) || (paramConfig.content_list.size() > 0))
            {
              if ((PublicAccountConfigUtil.b((QQAppInterface)getAppRuntime(), str)) && (QLog.isColorLevel())) {
                QLog.d("SPLASH_ConfigServlet", 2, "received READINJOY_FOLDER_CONFIG_CMD save version: " + i2);
              }
              SharedPreUtils.q(getAppRuntime().getApplication(), i2);
            }
            else if (QLog.isColorLevel())
            {
              QLog.d("SPLASH_ConfigServlet", 2, "received READINJOY_FOLDER_CONFIG_CMD IGNORE THIS ACTION  because of SAME VERSION");
            }
          }
        }
      }
      catch (Exception paramConfig)
      {
        if (QLog.isColorLevel()) {
          QLog.e("SPLASH_ConfigServlet", 2, "received readinjoy folder config error,cmd : 72");
        }
      }
      do
      {
        return;
      } while (!QLog.isColorLevel());
      QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 72,content_list is empty ,version: " + paramConfig.version.get());
      return;
      i1 += 1;
    }
  }
  
  public void d(ConfigurationService.Config paramConfig)
  {
    for (;;)
    {
      int i1;
      try
      {
        QQAppInterface localQQAppInterface = (QQAppInterface)getAppRuntime();
        if ((paramConfig.content_list != null) && (paramConfig.content_list.size() > 0))
        {
          i1 = 0;
          if (i1 < paramConfig.content_list.size())
          {
            Object localObject1 = ((String)paramConfig.content_list.get(i1)).trim();
            if (QLog.isColorLevel()) {
              QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 73,content: " + (String)localObject1 + ",version: " + paramConfig.version.get());
            }
            int i2 = paramConfig.version.get();
            if ((i2 != SharedPreUtils.w(localQQAppInterface.a())) || (paramConfig.content_list.size() > 0))
            {
              Object localObject2 = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(((String)localObject1).getBytes("utf-8")));
              localObject1 = (Element)((Document)localObject2).getElementsByTagName("kandian_setting").item(0);
              localObject2 = (Element)((Document)localObject2).getElementsByTagName("url").item(0);
              localObject1 = ((Element)localObject1).getFirstChild().getNodeValue();
              localObject2 = ((Element)localObject2).getFirstChild().getNodeValue();
              if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty((CharSequence)localObject2))) {
                SharedPreUtils.d(localQQAppInterface.a(), (String)localObject2, "1".equals(localObject1));
              }
              SharedPreUtils.r(localQQAppInterface.a(), i2);
            }
            else if (QLog.isColorLevel())
            {
              QLog.d("SPLASH_ConfigServlet", 2, "received READINJOY_FOLDER_SETTING_CMD IGNORE THIS ACTION  because of SAME VERSION");
            }
          }
        }
      }
      catch (Exception paramConfig)
      {
        if (QLog.isColorLevel()) {
          QLog.e("SPLASH_ConfigServlet", 2, "received readinjoy folder setting config error,cmd : 73");
        }
      }
      do
      {
        return;
      } while (!QLog.isColorLevel());
      QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 73,content_list is empty ,version: " + paramConfig.version.get());
      return;
      i1 += 1;
    }
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)getAppRuntime();
    int[] arrayOfInt = paramIntent.getIntArrayExtra("k_cmd_type");
    boolean bool = paramFromServiceMsg.isSuccess();
    if ((arrayOfInt == null) || (arrayOfInt.length == 0)) {}
    do
    {
      return;
      if (QLog.isColorLevel())
      {
        int i1 = 0;
        while (i1 < arrayOfInt.length)
        {
          QLog.i("SPLASH_ConfigServlet", 2, "onReceive. isSuccess: " + bool + ",cmd: " + arrayOfInt[i1] + ",length: " + arrayOfInt.length);
          i1 += 1;
        }
      }
      localObject = paramFromServiceMsg.getWupBuffer();
      if ((localObject != null) && (localObject.length >= 4)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("SPLASH_ConfigServlet", 2, "wup buf is null!!!");
    return;
    paramFromServiceMsg.putWupBuffer(a((byte[])localObject));
    Object localObject = new ConfigurationService.RespGetConfig();
    try
    {
      ((ConfigurationService.RespGetConfig)localObject).mergeFrom(paramFromServiceMsg.getWupBuffer());
      a((ConfigurationService.RespGetConfig)localObject, localQQAppInterface, paramIntent, arrayOfInt, bool);
      return;
    }
    catch (InvalidProtocolBufferMicroException paramIntent)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, "error: " + paramIntent.toString());
      }
      paramIntent.printStackTrace();
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)getAppRuntime();
    int[] arrayOfInt = paramIntent.getIntArrayExtra("k_cmd_type");
    if ((arrayOfInt == null) || (arrayOfInt.length == 0)) {
      return;
    }
    if (QLog.isColorLevel())
    {
      int i1 = 0;
      while (i1 < arrayOfInt.length)
      {
        QLog.i("SPLASH_ConfigServlet", 2, "onSend. cmd: " + arrayOfInt[i1] + ",length: " + arrayOfInt.length);
        i1 += 1;
      }
    }
    a(localQQAppInterface, paramIntent, arrayOfInt, paramPacket);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\config\splashlogo\ConfigServlet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
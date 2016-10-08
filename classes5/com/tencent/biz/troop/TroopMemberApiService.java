package com.tencent.biz.troop;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.biz.ProtoServlet;
import com.tencent.biz.TroopRedpoint.TroopRedTouchHandler;
import com.tencent.biz.TroopRedpoint.TroopRedTouchManager;
import com.tencent.biz.apiproxy.QQMusicService;
import com.tencent.biz.pubaccount.util.PAH5Manager;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.leba.LebaShowListManager;
import com.tencent.mobileqq.app.BizTroopHandler;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.LBSHandler;
import com.tencent.mobileqq.app.LBSObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQMapActivityProxy;
import com.tencent.mobileqq.app.RedTouchHandler;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.config.struct.LebaViewItem;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.troop.utils.TroopFileManager;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.dingdong.data.DingdongOfficeOpenService;
import cooperation.troop_homework.model.HWTroopFileStatusInfo;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import jdc;
import jdd;
import jde;
import jdf;
import jdg;
import jdh;
import mqq.app.AppRuntime;
import mqq.app.AppService;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import oicq.wlogin_sdk.request.WFastLoginInfo;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.request.WtloginHelper;
import tencent.im.group.nearbybanner.nearbybanner.ClientInfo;
import tencent.im.group.nearbybanner.nearbybanner.ReqBody;
import tencent.im.oidb.cmd0x791.oidb_0x791.RedDotInfo;

public class TroopMemberApiService
  extends AppService
{
  public static final int A = 28;
  public static final int B = 29;
  public static final int C = 30;
  public static final int D = 31;
  public static final int E = 32;
  public static final int F = 33;
  public static final int G = 34;
  public static final int H = 35;
  public static final int I = 36;
  public static final int J = 37;
  public static final int K = 38;
  public static final int L = 39;
  public static final int M = 40;
  public static final int N = 41;
  public static final int O = 42;
  public static final int P = 43;
  public static final int Q = 44;
  public static final int R = 45;
  public static final int S = 46;
  public static final int T = 47;
  public static final int U = 48;
  public static final int V = 49;
  public static final int W = 50;
  public static final int X = 51;
  public static final int Y = 52;
  public static final int Z = 53;
  public static final int a = 1;
  static final String jdField_a_of_type_JavaLangString = "com.tencent.biz.troop.TroopMemberApiService";
  public static final int aa = 54;
  public static final int ab = 55;
  public static final int ac = 56;
  public static final int ad = 57;
  public static final int ae = 58;
  public static final int af = 59;
  public static final int ag = 60;
  public static final int ah = 61;
  public static final int ai = 62;
  public static final int aj = 1;
  public static final int ak = 2;
  public static final int al = 3;
  public static final int am = 4;
  public static final int b = 2;
  public static final String b = "http://jubao.qq.com/cn/jubao";
  public static final int c = 3;
  public static final String c = "nearby_group_banner.get_banner_info";
  public static final int d = 4;
  private static final String d = TroopMemberApiService.class.getSimpleName();
  public static final int e = 5;
  public static final int f = 6;
  public static final int g = 7;
  public static final int h = 8;
  public static final int i = 9;
  public static final int j = 11;
  public static final int k = 12;
  public static final int l = 13;
  public static final int m = 14;
  public static final int n = 15;
  public static final int o = 16;
  public static final int p = 17;
  public static final int q = 18;
  public static final int r = 19;
  public static final int s = 20;
  public static final int t = 21;
  public static final int u = 22;
  public static final int v = 23;
  public static final int w = 24;
  public static final int x = 25;
  public static final int y = 26;
  public static final int z = 27;
  final Messenger jdField_a_of_type_AndroidOsMessenger = new Messenger(new jdh(this));
  QQMusicService jdField_a_of_type_ComTencentBizApiproxyQQMusicService;
  public PAH5Manager a;
  public BizTroopHandler a;
  BizTroopObserver jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver = new jdd(this);
  public FriendListObserver a;
  public LBSHandler a;
  public LBSObserver a;
  public QQMapActivityProxy a;
  public TroopHandler a;
  TroopObserver jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new jdc(this);
  public DingdongOfficeOpenService a;
  ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  public ConcurrentHashMap a;
  public boolean a;
  public int an;
  int ao;
  public int ap;
  public Messenger b = null;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public TroopMemberApiService()
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqAppLBSObserver = new jde(this);
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new jdf(this);
  }
  
  /* Error */
  public static String a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_1
    //   4: aconst_null
    //   5: aload_0
    //   6: invokestatic 227	com/tencent/mobileqq/shortvideo/ShortVideoUtils:a	(Landroid/content/Context;Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   9: astore_2
    //   10: aload_2
    //   11: ifnull +139 -> 150
    //   14: new 229	java/io/ByteArrayOutputStream
    //   17: dup
    //   18: invokespecial 230	java/io/ByteArrayOutputStream:<init>	()V
    //   21: astore_1
    //   22: aload_1
    //   23: astore_0
    //   24: aload_2
    //   25: getstatic 236	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   28: bipush 60
    //   30: aload_1
    //   31: invokevirtual 242	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   34: pop
    //   35: aload_1
    //   36: astore_0
    //   37: aload_1
    //   38: invokevirtual 245	java/io/ByteArrayOutputStream:flush	()V
    //   41: aload_1
    //   42: astore_0
    //   43: aload_1
    //   44: invokevirtual 248	java/io/ByteArrayOutputStream:close	()V
    //   47: aload_1
    //   48: astore_0
    //   49: aload_1
    //   50: invokevirtual 252	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   53: iconst_0
    //   54: invokestatic 258	android/util/Base64:encodeToString	([BI)Ljava/lang/String;
    //   57: astore_2
    //   58: aload_2
    //   59: astore_0
    //   60: aload_0
    //   61: astore_2
    //   62: aload_1
    //   63: ifnull +13 -> 76
    //   66: aload_1
    //   67: invokevirtual 245	java/io/ByteArrayOutputStream:flush	()V
    //   70: aload_1
    //   71: invokevirtual 248	java/io/ByteArrayOutputStream:close	()V
    //   74: aload_0
    //   75: astore_2
    //   76: aload_2
    //   77: areturn
    //   78: astore_1
    //   79: aload_1
    //   80: invokevirtual 261	java/io/IOException:printStackTrace	()V
    //   83: aload_0
    //   84: areturn
    //   85: astore_2
    //   86: aconst_null
    //   87: astore_1
    //   88: aload_1
    //   89: astore_0
    //   90: aload_2
    //   91: invokevirtual 261	java/io/IOException:printStackTrace	()V
    //   94: aload_3
    //   95: astore_2
    //   96: aload_1
    //   97: ifnull -21 -> 76
    //   100: aload_1
    //   101: invokevirtual 245	java/io/ByteArrayOutputStream:flush	()V
    //   104: aload_1
    //   105: invokevirtual 248	java/io/ByteArrayOutputStream:close	()V
    //   108: aconst_null
    //   109: areturn
    //   110: astore_0
    //   111: aload_0
    //   112: invokevirtual 261	java/io/IOException:printStackTrace	()V
    //   115: aconst_null
    //   116: areturn
    //   117: astore_1
    //   118: aconst_null
    //   119: astore_0
    //   120: aload_0
    //   121: ifnull +11 -> 132
    //   124: aload_0
    //   125: invokevirtual 245	java/io/ByteArrayOutputStream:flush	()V
    //   128: aload_0
    //   129: invokevirtual 248	java/io/ByteArrayOutputStream:close	()V
    //   132: aload_1
    //   133: athrow
    //   134: astore_0
    //   135: aload_0
    //   136: invokevirtual 261	java/io/IOException:printStackTrace	()V
    //   139: goto -7 -> 132
    //   142: astore_1
    //   143: goto -23 -> 120
    //   146: astore_2
    //   147: goto -59 -> 88
    //   150: aconst_null
    //   151: astore_2
    //   152: aload_1
    //   153: astore_0
    //   154: aload_2
    //   155: astore_1
    //   156: goto -96 -> 60
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	159	0	paramString	String
    //   3	68	1	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   78	2	1	localIOException1	java.io.IOException
    //   87	18	1	localObject1	Object
    //   117	16	1	localObject2	Object
    //   142	11	1	localObject3	Object
    //   155	1	1	localObject4	Object
    //   9	68	2	localObject5	Object
    //   85	6	2	localIOException2	java.io.IOException
    //   95	1	2	localObject6	Object
    //   146	1	2	localIOException3	java.io.IOException
    //   151	4	2	localObject7	Object
    //   1	94	3	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   66	74	78	java/io/IOException
    //   14	22	85	java/io/IOException
    //   100	108	110	java/io/IOException
    //   14	22	117	finally
    //   124	132	134	java/io/IOException
    //   24	35	142	finally
    //   37	41	142	finally
    //   43	47	142	finally
    //   49	58	142	finally
    //   90	94	142	finally
    //   24	35	146	java/io/IOException
    //   37	41	146	java/io/IOException
    //   43	47	146	java/io/IOException
    //   49	58	146	java/io/IOException
  }
  
  private void a(QQAppInterface paramQQAppInterface, long paramLong, HWTroopFileStatusInfo paramHWTroopFileStatusInfo, Bundle paramBundle)
  {
    if (paramHWTroopFileStatusInfo == null) {
      return;
    }
    FileInfo localFileInfo = new FileInfo();
    if (!FileUtil.a(paramHWTroopFileStatusInfo.LocalFile)) {
      TroopFileTransferManager.a(paramQQAppInterface, paramLong).b();
    }
    String str = "";
    if (!TextUtils.isEmpty(paramHWTroopFileStatusInfo.FileName)) {
      str = paramHWTroopFileStatusInfo.FileName;
    }
    TroopFileManager.a(paramQQAppInterface, paramLong).a(paramHWTroopFileStatusInfo.Id);
    localFileInfo.d(str);
    localFileInfo.e(paramHWTroopFileStatusInfo.LocalFile);
    localFileInfo.a(paramHWTroopFileStatusInfo.ProgressTotal);
    paramQQAppInterface = new TroopFileStatusInfo();
    paramQQAppInterface.g = str;
    paramQQAppInterface.jdField_a_of_type_JavaLangString = paramHWTroopFileStatusInfo.LocalFile;
    paramQQAppInterface.jdField_b_of_type_Long = paramHWTroopFileStatusInfo.ProgressTotal;
    paramQQAppInterface.jdField_a_of_type_JavaUtilUUID = paramHWTroopFileStatusInfo.Id;
    paramQQAppInterface.jdField_a_of_type_Long = paramLong;
    paramQQAppInterface.jdField_e_of_type_Int = paramHWTroopFileStatusInfo.BusId;
    paramQQAppInterface.jdField_e_of_type_JavaLangString = paramHWTroopFileStatusInfo.FilePath;
    paramQQAppInterface.f = paramHWTroopFileStatusInfo.sha1;
    paramQQAppInterface.jdField_b_of_type_JavaLangString = paramHWTroopFileStatusInfo.ThumbnailFile_Small;
    paramQQAppInterface.c = paramHWTroopFileStatusInfo.ThumbnailFile_Large;
    paramQQAppInterface.jdField_b_of_type_Int = paramHWTroopFileStatusInfo.Status;
    paramBundle.putLong("sessionId", FileManagerUtil.a(paramQQAppInterface).nSessionId);
    paramBundle.putInt("cloudType", 4);
    paramBundle.putInt("type", 10006);
    paramBundle.putString("filePath", localFileInfo.d());
    paramBundle.putString("fileName", localFileInfo.e());
    paramBundle.putLong("fileSize", localFileInfo.a());
    paramBundle.putLong("troopCode", paramLong);
    a(20, paramBundle);
  }
  
  private boolean a(long paramLong, boolean paramBoolean)
  {
    LebaViewItem localLebaViewItem = LebaShowListManager.a().a(paramLong);
    if ((localLebaViewItem == null) || (localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo == null)) {
      return false;
    }
    boolean bool;
    if (localLebaViewItem.jdField_a_of_type_Byte == 0)
    {
      bool = true;
      label35:
      if (paramBoolean == bool) {
        break label143;
      }
      if (!paramBoolean) {
        break label145;
      }
    }
    label143:
    label145:
    for (byte b1 = 0;; b1 = 1)
    {
      localLebaViewItem.jdField_a_of_type_Byte = b1;
      if (!(this.app instanceof QQAppInterface)) {
        break;
      }
      LebaShowListManager.a().a((QQAppInterface)this.app, localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.uiResId, paramBoolean, NetConnInfoCenter.getServerTimeMillis(), Long.MIN_VALUE);
      paramLong = NetConnInfoCenter.getServerTimeMillis();
      RedTouchHandler localRedTouchHandler = (RedTouchHandler)((QQAppInterface)this.app).a(31);
      if (localRedTouchHandler != null) {
        localRedTouchHandler.a(String.valueOf(localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.uiResId), paramBoolean, paramLong);
      }
      return true;
      bool = false;
      break label35;
      break;
    }
  }
  
  public static boolean a(AppRuntime paramAppRuntime, BusinessObserver paramBusinessObserver)
  {
    nearbybanner.ReqBody localReqBody = new nearbybanner.ReqBody();
    try
    {
      Object localObject = paramAppRuntime.getApplication().getResources().getDisplayMetrics();
      int i1 = ((DisplayMetrics)localObject).widthPixels;
      int i2 = ((DisplayMetrics)localObject).heightPixels;
      localObject = new nearbybanner.ClientInfo();
      ((nearbybanner.ClientInfo)localObject).uint32_lcd_height.set(i2);
      ((nearbybanner.ClientInfo)localObject).uint32_lcd_width.set(i1);
      ((nearbybanner.ClientInfo)localObject).bytes_client_version.set(ByteStringMicro.copyFromUtf8("6.5.5.2880"));
      ((nearbybanner.ClientInfo)localObject).uint32_os.set(0);
      localReqBody.msg_client_info.set((MessageMicro)localObject);
      localObject = new NewIntent(paramAppRuntime.getApplication(), ProtoServlet.class);
      ((NewIntent)localObject).putExtra("cmd", "nearby_group_banner.get_banner_info");
      ((NewIntent)localObject).putExtra("data", localReqBody.toByteArray());
      ((NewIntent)localObject).setObserver(paramBusinessObserver);
      paramAppRuntime.startServlet((NewIntent)localObject);
      return true;
    }
    catch (Exception paramAppRuntime) {}
    return false;
  }
  
  public QQMusicService a()
  {
    if (this.jdField_a_of_type_ComTencentBizApiproxyQQMusicService == null) {
      this.jdField_a_of_type_ComTencentBizApiproxyQQMusicService = new QQMusicService(this);
    }
    return this.jdField_a_of_type_ComTencentBizApiproxyQQMusicService;
  }
  
  public DingdongOfficeOpenService a(QQAppInterface paramQQAppInterface)
  {
    if (this.jdField_a_of_type_CooperationDingdongDataDingdongOfficeOpenService == null) {
      this.jdField_a_of_type_CooperationDingdongDataDingdongOfficeOpenService = new DingdongOfficeOpenService(this, paramQQAppInterface);
    }
    return this.jdField_a_of_type_CooperationDingdongDataDingdongOfficeOpenService;
  }
  
  public void a(int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("code", paramInt);
    localBundle.putString("method", "onOpenRoomResult");
    a(32, localBundle);
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    Message localMessage = Message.obtain(null, paramInt);
    Messenger localMessenger2 = this.b;
    String str = paramBundle.getString("processName");
    Messenger localMessenger1 = localMessenger2;
    if (str != null)
    {
      localMessenger1 = localMessenger2;
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null)
      {
        localMessenger1 = localMessenger2;
        if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str) != null) {
          localMessenger1 = (Messenger)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str);
        }
      }
    }
    localMessage.setData(paramBundle);
    if (localMessenger1 != null) {}
    try
    {
      localMessenger1.send(localMessage);
      return;
    }
    catch (RemoteException paramBundle)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("com.tencent.biz.troop.TroopMemberApiService", 2, "messeage not sent:" + paramBundle.getMessage());
    }
  }
  
  public void a(Bundle paramBundle)
  {
    int i2 = 0;
    Object localObject1;
    if ((this.app instanceof QQAppInterface))
    {
      localObject1 = (QQAppInterface)this.app;
      Object localObject2 = (TroopRedTouchManager)((QQAppInterface)localObject1).getManager(69);
      i1 = i2;
      if (localObject2 != null)
      {
        localObject2 = ((TroopRedTouchManager)localObject2).a(7);
        i1 = i2;
        if (localObject2 != null)
        {
          TroopRedTouchHandler.a((QQAppInterface)localObject1, (oidb_0x791.RedDotInfo)localObject2);
          localObject1 = (TroopRedTouchHandler)((QQAppInterface)this.app).a(43);
          i1 = i2;
          if (localObject1 != null) {
            ((TroopRedTouchHandler)localObject1).a(105, true, null);
          }
        }
      }
    }
    for (int i1 = i2;; i1 = 1)
    {
      localObject1 = new Bundle();
      if (paramBundle != null)
      {
        ((Bundle)localObject1).putInt("seq", paramBundle.getInt("seq", -1));
        if (!TextUtils.isEmpty(paramBundle.getString("callback"))) {
          ((Bundle)localObject1).putString("callback", paramBundle.getString("callback"));
        }
      }
      ((Bundle)localObject1).putString("data", "{code:\"" + i1 + "\"}");
      ((Bundle)localObject1).putString("method", "cleanDynamicRedPoint");
      a(15, (Bundle)localObject1);
      return;
      ReportController.b(null, "P_CliOper", "BizTechReport", "", "tribe", "clearreddot", 0, 1, "", "", "", "");
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    WtloginHelper localWtloginHelper = new WtloginHelper(this.app.getApplication().getApplicationContext());
    localWtloginHelper.SetListener(new jdg(this, localWtloginHelper));
    String str = this.app.getAccount();
    paramString1 = paramString1.getBytes();
    long l1 = Long.valueOf(paramString2).longValue();
    paramString2 = "5.2".getBytes();
    WUserSigInfo localWUserSigInfo = new WUserSigInfo();
    WFastLoginInfo localWFastLoginInfo = new WFastLoginInfo();
    if (localWtloginHelper.GetA1WithA1(str, 16L, 16L, paramString1, 1L, l1, 1L, paramString2, new byte[] { -51, 50, 114, -105, -54, -19, 112, -124, -125, -52, -72, -101, -27, 33, 65, -128 }, localWUserSigInfo, localWFastLoginInfo) != 64535) {
      a(62, null);
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppRuntime localAppRuntime = this.app;
    if ((localAppRuntime == null) || (!(localAppRuntime instanceof QQAppInterface))) {}
    do
    {
      return;
      if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString3)) && (!TextUtils.isEmpty(paramString4))) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("com.tencent.biz.troop.TroopMemberApiService", 2, "safetyReport param null");
    return;
    if (!TextUtils.isEmpty(paramString1)) {}
    for (;;)
    {
      paramString2 = URLEncoder.encode(paramString2);
      paramString1 = "groupuin=" + paramString1 + "&eviluin=0&anonyid=" + paramString2 + "&impeachuin=" + paramString3 + "&msglist=" + paramString4;
      paramString1 = paramString1 + "&uin_source=unfriend";
      paramString1 = "SourceID=401&appname=KQQ&jubaotype=uin&system=android&subapp=BusinessCard&" + paramString1;
      if (paramString1 == null) {
        paramString1 = null;
      }
      for (;;)
      {
        paramString2 = new Intent(BaseApplication.getContext(), QQBrowserActivity.class);
        paramString2.putExtra("BSafeReportPost", true);
        paramString2.putExtra("SafeReportData", paramString1);
        paramString2.putExtra("hide_more_button", true);
        paramString2.putExtra("ishiderefresh", true);
        paramString2.putExtra("ishidebackforward", true);
        paramString2.putExtra("url", "http://jubao.qq.com/cn/jubao");
        paramString2.addFlags(268435456);
        BaseApplication.getContext().startActivity(paramString2);
        return;
        try
        {
          paramString1 = paramString1.getBytes("utf-8");
        }
        catch (Exception paramString1) {}
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("com.tencent.biz.troop.TroopMemberApiService", 2, "safetyReport exception" + paramString1.getMessage());
      return;
      paramString1 = "0";
    }
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.i("com.tencent.biz.troop.TroopMemberApiService", 2, "MessengerService onBind");
    }
    return this.jdField_a_of_type_AndroidOsMessenger.getBinder();
  }
  
  public void onCreate()
  {
    if (QLog.isColorLevel()) {
      QLog.i("com.tencent.biz.troop.TroopMemberApiService", 2, "MessengerService onCreate");
    }
    super.onCreate();
    if ((this.app instanceof QQAppInterface))
    {
      ((QQAppInterface)this.app).a(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver, true);
      ((QQAppInterface)this.app).a(this.jdField_a_of_type_ComTencentMobileqqAppLBSObserver);
      ((QQAppInterface)this.app).a(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      ((QQAppInterface)this.app).a(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    }
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.i("com.tencent.biz.troop.TroopMemberApiService", 2, "MessengerService onDestroy");
    }
    super.onDestroy();
    if ((this.app instanceof QQAppInterface))
    {
      ((QQAppInterface)this.app).b(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
      ((QQAppInterface)this.app).b(this.jdField_a_of_type_ComTencentMobileqqAppLBSObserver);
      ((QQAppInterface)this.app).b(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      ((QQAppInterface)this.app).b(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    }
    this.app = null;
    this.jdField_a_of_type_ComTencentMobileqqAppBizTroopHandler = null;
    this.jdField_a_of_type_ComTencentMobileqqAppLBSHandler = null;
    this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler = null;
    this.b = null;
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null)
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = null;
    }
    if (this.jdField_a_of_type_CooperationDingdongDataDingdongOfficeOpenService != null)
    {
      this.jdField_a_of_type_CooperationDingdongDataDingdongOfficeOpenService.a();
      this.jdField_a_of_type_CooperationDingdongDataDingdongOfficeOpenService = null;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\troop\TroopMemberApiService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.tencent.mobileqq.app;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.SecMsgUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.secmsg.ipc.SecMsgResultReceiver;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import mqq.os.MqqHandler;

public class SecMsgManager
  implements Manager
{
  public static final int a = 0;
  public static final long a = 16L;
  public static final String a = "secmsg_";
  public static final int b = 1;
  public static final String b = "sp_key_sec_msg_shield_list";
  public static final int c = 2;
  public static final String c = "sp_key_forbidden";
  public static final int d = 3;
  public static final String d = "sp_key_in_white_list";
  public static final int e = 4;
  public static final String e = "sp_key_disable";
  public static final int f = 5;
  public static final String f = "sp_key_newest_seq";
  public static final int g = 6;
  public static final String g = "sp_key_feature_state";
  public static final String h = "sp_key_local_available";
  public static final int i = 1;
  public static final String i = ",";
  private static final int j = 0;
  public static final String j = "sp_key_sec_msg_last_fetch_seq";
  public static final String k = "sp_key_sec_msg_last_msg_time";
  public static final String l = "first_install";
  public static String m = "sec_msg_newr_guide_flag_home";
  public static String n = "sec_msg_newr_guide_flag_aio_send";
  public static String o = "sec_msg_newr_guide_flag_create";
  public static String p = "sec_msg_newr_guide_flag_aio_receive";
  public static String q = "sec_msg_draft_uin";
  public static String r = "sec_msg_draft_content";
  public static String s = "sec_msg_draftpaperid";
  private static final String t = "SecMsgManager";
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private SecMsgManager.SecMsgBaseInfo jdField_a_of_type_ComTencentMobileqqAppSecMsgManager$SecMsgBaseInfo;
  public SecMsgResultReceiver a;
  public int h = 0;
  private int k = Integer.MIN_VALUE;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public SecMsgManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_CooperationSecmsgIpcSecMsgResultReceiver = new SecMsgResultReceiver(paramQQAppInterface, new Handler(Looper.getMainLooper()));
    b();
  }
  
  private String a(List paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int i2 = paramList.size();
    int i1 = 0;
    while (i1 < i2)
    {
      String str = (String)paramList.get(i1);
      if (!TextUtils.isEmpty(str))
      {
        localStringBuilder.append(str);
        if (i1 != i2 - 1) {
          localStringBuilder.append(",");
        }
      }
      i1 += 1;
    }
    return localStringBuilder.toString();
  }
  
  private List a()
  {
    Object localObject2 = null;
    int i1 = SecMsgUtil.a();
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences("secmsg_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), i1);
    if (((SharedPreferences)localObject1).contains("sp_key_sec_msg_shield_list"))
    {
      Object localObject3 = ((SharedPreferences)localObject1).getString("sp_key_sec_msg_shield_list", null);
      localObject1 = localObject2;
      if (!TextUtils.isEmpty((CharSequence)localObject3))
      {
        localObject3 = ((String)localObject3).split(",");
        localObject1 = localObject2;
        if (localObject3 != null)
        {
          localObject2 = Arrays.asList((Object[])localObject3);
          localObject1 = new ArrayList(((List)localObject2).size());
          ((List)localObject1).addAll((Collection)localObject2);
        }
      }
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = new ArrayList();
      }
      return (List)localObject2;
      localObject1 = new ArrayList();
    }
  }
  
  /* Error */
  public static void a(QQAppInterface paramQQAppInterface)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: new 146	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   12: ldc -37
    //   14: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: ldc -35
    //   19: invokevirtual 226	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   22: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: ldc -28
    //   27: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   33: astore_1
    //   34: iconst_0
    //   35: istore 5
    //   37: iconst_0
    //   38: istore 4
    //   40: aload_0
    //   41: invokevirtual 231	com/tencent/mobileqq/app/QQAppInterface:b	()Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   44: aload_1
    //   45: aconst_null
    //   46: aconst_null
    //   47: aconst_null
    //   48: invokevirtual 236	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   51: astore_1
    //   52: iload 4
    //   54: istore_3
    //   55: aload_1
    //   56: ifnull +31 -> 87
    //   59: iload 4
    //   61: istore_3
    //   62: iload 5
    //   64: istore 4
    //   66: aload_1
    //   67: invokeinterface 242 1 0
    //   72: ifeq +15 -> 87
    //   75: iload 5
    //   77: istore 4
    //   79: aload_1
    //   80: iconst_0
    //   81: invokeinterface 246 2 0
    //   86: istore_3
    //   87: iload_3
    //   88: istore 4
    //   90: aload_0
    //   91: ldc -8
    //   93: ldc -112
    //   95: ldc -112
    //   97: ldc -6
    //   99: ldc -4
    //   101: iconst_0
    //   102: iconst_0
    //   103: iload_3
    //   104: invokestatic 256	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   107: ldc -112
    //   109: ldc -112
    //   111: ldc -112
    //   113: invokestatic 261	com/tencent/mobileqq/statistics/ReportController:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   116: aload_1
    //   117: ifnull +322 -> 439
    //   120: aload_1
    //   121: invokeinterface 264 1 0
    //   126: invokestatic 269	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   129: ifeq +29 -> 158
    //   132: ldc 64
    //   134: iconst_2
    //   135: new 146	java/lang/StringBuilder
    //   138: dup
    //   139: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   142: ldc_w 271
    //   145: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: iload_3
    //   149: invokevirtual 274	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   152: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   155: invokestatic 277	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   158: aload_0
    //   159: bipush 56
    //   161: invokevirtual 281	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   164: checkcast 2	com/tencent/mobileqq/app/SecMsgManager
    //   167: astore_1
    //   168: aload_1
    //   169: invokevirtual 284	com/tencent/mobileqq/app/SecMsgManager:a	()Lcom/tencent/mobileqq/app/SecMsgManager$SecMsgBaseInfo;
    //   172: astore_2
    //   173: aload_1
    //   174: ifnull -170 -> 4
    //   177: aload_2
    //   178: getfield 288	com/tencent/mobileqq/app/SecMsgManager$SecMsgBaseInfo:c	Z
    //   181: ifne +223 -> 404
    //   184: ldc_w 290
    //   187: astore_1
    //   188: aload_0
    //   189: ldc -8
    //   191: ldc -112
    //   193: ldc -112
    //   195: ldc -6
    //   197: ldc_w 292
    //   200: iconst_0
    //   201: iconst_0
    //   202: ldc_w 294
    //   205: ldc -112
    //   207: aload_1
    //   208: ldc -112
    //   210: invokestatic 261	com/tencent/mobileqq/statistics/ReportController:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   213: invokestatic 269	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   216: ifeq +42 -> 258
    //   219: new 146	java/lang/StringBuilder
    //   222: dup
    //   223: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   226: ldc_w 296
    //   229: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: astore_1
    //   233: aload_2
    //   234: getfield 288	com/tencent/mobileqq/app/SecMsgManager$SecMsgBaseInfo:c	Z
    //   237: ifne +174 -> 411
    //   240: iconst_1
    //   241: istore 6
    //   243: ldc 64
    //   245: iconst_2
    //   246: aload_1
    //   247: iload 6
    //   249: invokevirtual 299	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   252: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   255: invokestatic 277	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   258: aload_2
    //   259: getfield 302	com/tencent/mobileqq/app/SecMsgManager$SecMsgBaseInfo:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   262: astore_1
    //   263: aload_1
    //   264: ifnonnull +153 -> 417
    //   267: iconst_0
    //   268: istore_3
    //   269: aload_0
    //   270: ldc -8
    //   272: ldc -112
    //   274: ldc -112
    //   276: ldc -6
    //   278: ldc_w 304
    //   281: iconst_0
    //   282: iconst_0
    //   283: iload_3
    //   284: invokestatic 256	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   287: ldc -112
    //   289: ldc -112
    //   291: ldc -112
    //   293: invokestatic 261	com/tencent/mobileqq/statistics/ReportController:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   296: invokestatic 269	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   299: ifeq -295 -> 4
    //   302: ldc 64
    //   304: iconst_2
    //   305: new 146	java/lang/StringBuilder
    //   308: dup
    //   309: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   312: ldc_w 306
    //   315: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   318: iload_3
    //   319: invokevirtual 274	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   322: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   325: invokestatic 277	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   328: return
    //   329: astore_2
    //   330: aconst_null
    //   331: astore_1
    //   332: iconst_0
    //   333: istore 4
    //   335: invokestatic 269	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   338: ifeq +32 -> 370
    //   341: ldc 64
    //   343: iconst_2
    //   344: new 146	java/lang/StringBuilder
    //   347: dup
    //   348: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   351: ldc_w 308
    //   354: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   357: aload_2
    //   358: invokevirtual 311	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   361: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   364: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   367: invokestatic 313	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   370: iload 4
    //   372: istore_3
    //   373: aload_1
    //   374: ifnull -248 -> 126
    //   377: aload_1
    //   378: invokeinterface 264 1 0
    //   383: iload 4
    //   385: istore_3
    //   386: goto -260 -> 126
    //   389: astore_0
    //   390: aconst_null
    //   391: astore_1
    //   392: aload_1
    //   393: ifnull +9 -> 402
    //   396: aload_1
    //   397: invokeinterface 264 1 0
    //   402: aload_0
    //   403: athrow
    //   404: ldc_w 315
    //   407: astore_1
    //   408: goto -220 -> 188
    //   411: iconst_0
    //   412: istore 6
    //   414: goto -171 -> 243
    //   417: aload_1
    //   418: invokeinterface 142 1 0
    //   423: istore_3
    //   424: goto -155 -> 269
    //   427: astore_0
    //   428: goto -36 -> 392
    //   431: astore_0
    //   432: goto -40 -> 392
    //   435: astore_2
    //   436: goto -101 -> 335
    //   439: goto -313 -> 126
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	442	0	paramQQAppInterface	QQAppInterface
    //   33	385	1	localObject	Object
    //   172	87	2	localSecMsgBaseInfo	SecMsgManager.SecMsgBaseInfo
    //   329	29	2	localException1	Exception
    //   435	1	2	localException2	Exception
    //   54	370	3	i1	int
    //   38	346	4	i2	int
    //   35	41	5	i3	int
    //   241	172	6	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   40	52	329	java/lang/Exception
    //   40	52	389	finally
    //   66	75	427	finally
    //   79	87	427	finally
    //   90	116	427	finally
    //   335	370	431	finally
    //   66	75	435	java/lang/Exception
    //   79	87	435	java/lang/Exception
    //   90	116	435	java/lang/Exception
  }
  
  private void a(SecMsgManager.SecMsgBaseInfo paramSecMsgBaseInfo)
  {
    if (paramSecMsgBaseInfo == null) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppSecMsgManager$SecMsgBaseInfo == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppSecMsgManager$SecMsgBaseInfo = new SecMsgManager.SecMsgBaseInfo();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppSecMsgManager$SecMsgBaseInfo.jdField_a_of_type_Boolean = paramSecMsgBaseInfo.jdField_a_of_type_Boolean;
    this.jdField_a_of_type_ComTencentMobileqqAppSecMsgManager$SecMsgBaseInfo.jdField_b_of_type_Boolean = paramSecMsgBaseInfo.jdField_b_of_type_Boolean;
    this.jdField_a_of_type_ComTencentMobileqqAppSecMsgManager$SecMsgBaseInfo.c = paramSecMsgBaseInfo.c;
    this.jdField_a_of_type_ComTencentMobileqqAppSecMsgManager$SecMsgBaseInfo.jdField_a_of_type_Long = paramSecMsgBaseInfo.jdField_a_of_type_Long;
    this.jdField_a_of_type_ComTencentMobileqqAppSecMsgManager$SecMsgBaseInfo.jdField_a_of_type_JavaUtilList = paramSecMsgBaseInfo.jdField_a_of_type_JavaUtilList;
    this.jdField_a_of_type_ComTencentMobileqqAppSecMsgManager$SecMsgBaseInfo.jdField_b_of_type_Long = paramSecMsgBaseInfo.jdField_b_of_type_Long;
    this.jdField_a_of_type_ComTencentMobileqqAppSecMsgManager$SecMsgBaseInfo.d = paramSecMsgBaseInfo.d;
  }
  
  public long a()
  {
    long l1 = 0L;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      int i1 = SecMsgUtil.a();
      l1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences("secmsg_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), i1).getLong("sp_key_sec_msg_last_fetch_seq", 0L);
    }
    return l1;
  }
  
  public SecMsgManager.SecMsgBaseInfo a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppSecMsgManager$SecMsgBaseInfo == null) {
      b();
    }
    SecMsgManager.SecMsgBaseInfo localSecMsgBaseInfo = new SecMsgManager.SecMsgBaseInfo();
    localSecMsgBaseInfo.jdField_a_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqAppSecMsgManager$SecMsgBaseInfo.jdField_a_of_type_Boolean;
    localSecMsgBaseInfo.jdField_b_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqAppSecMsgManager$SecMsgBaseInfo.jdField_b_of_type_Boolean;
    localSecMsgBaseInfo.c = this.jdField_a_of_type_ComTencentMobileqqAppSecMsgManager$SecMsgBaseInfo.c;
    localSecMsgBaseInfo.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqAppSecMsgManager$SecMsgBaseInfo.jdField_a_of_type_Long;
    localSecMsgBaseInfo.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_ComTencentMobileqqAppSecMsgManager$SecMsgBaseInfo.jdField_a_of_type_JavaUtilList;
    localSecMsgBaseInfo.jdField_b_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqAppSecMsgManager$SecMsgBaseInfo.jdField_b_of_type_Long;
    localSecMsgBaseInfo.d = this.jdField_a_of_type_ComTencentMobileqqAppSecMsgManager$SecMsgBaseInfo.d;
    return localSecMsgBaseInfo;
  }
  
  public String a(Context paramContext)
  {
    if (paramContext == null) {}
    do
    {
      return "";
      paramContext = paramContext.getResources();
    } while (this.h != 1);
    return paramContext.getString(2131371331);
  }
  
  public void a()
  {
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      localObject = new Intent("com.tencent.mobileqq.secmsg.NetReconnect");
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().sendBroadcast((Intent)localObject);
      localObject = (SecMsgHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(40);
      if (localObject != null) {
        if (!d()) {
          break label74;
        }
      }
    }
    label74:
    for (long l1 = 0x10 | 0L;; l1 = 0L)
    {
      if (l1 != 0L) {
        ((SecMsgHandler)localObject).a(l1, SecMsgUtil.a());
      }
      return;
    }
  }
  
  public void a(long paramLong)
  {
    if ((paramLong == 2L) || (paramLong == 1L))
    {
      this.h = 1;
      if (this.jdField_a_of_type_ComTencentMobileqqAppSecMsgManager$SecMsgBaseInfo == null) {
        b();
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqAppSecMsgManager$SecMsgBaseInfo.d == 1) && (!this.jdField_a_of_type_ComTencentMobileqqAppSecMsgManager$SecMsgBaseInfo.jdField_b_of_type_Boolean))
      {
        int i1 = SecMsgUtil.a();
        SharedPreferences.Editor localEditor = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences("secmsg_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), i1).edit();
        localEditor.putBoolean("sp_key_in_white_list", true);
        localEditor.commit();
        this.jdField_a_of_type_ComTencentMobileqqAppSecMsgManager$SecMsgBaseInfo.jdField_b_of_type_Boolean = true;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("SecMsgManager", 2, "handleMsgHintStatus, pushMsgType=" + paramLong + ", mMsgTabHintStatus=" + this.h);
    }
  }
  
  public void a(SecMsgManager.SecMsgBaseInfo paramSecMsgBaseInfo, long paramLong)
  {
    if (paramSecMsgBaseInfo == null) {
      return;
    }
    int i1 = SecMsgUtil.a();
    SharedPreferences.Editor localEditor = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences("secmsg_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), i1).edit();
    if ((paramLong >>> 0 & 1L) == 1L) {
      localEditor.putBoolean("sp_key_forbidden", paramSecMsgBaseInfo.jdField_a_of_type_Boolean);
    }
    if ((paramLong >>> 1 & 1L) == 1L) {
      localEditor.putBoolean("sp_key_in_white_list", paramSecMsgBaseInfo.jdField_b_of_type_Boolean);
    }
    if ((paramLong >>> 2 & 1L) == 1L) {
      localEditor.putBoolean("sp_key_disable", paramSecMsgBaseInfo.c);
    }
    if ((paramLong >>> 4 & 1L) == 1L) {
      localEditor.putLong("sp_key_newest_seq", paramSecMsgBaseInfo.jdField_a_of_type_Long);
    }
    if (((paramLong >>> 3 & 1L) == 1L) && (paramSecMsgBaseInfo.jdField_a_of_type_JavaUtilList != null)) {
      localEditor.putString("sp_key_sec_msg_shield_list", a(paramSecMsgBaseInfo.jdField_a_of_type_JavaUtilList));
    }
    if (((paramLong >>> 5 & 1L) != 1L) || ((paramLong >>> 6 & 1L) == 1L)) {
      localEditor.putInt("sp_key_feature_state", paramSecMsgBaseInfo.d);
    }
    localEditor.commit();
    a(paramSecMsgBaseInfo);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (paramString2 == null)
    {
      paramString2 = "";
      if (paramString3 != null) {
        break label73;
      }
      paramString3 = "";
      label28:
      if (paramString4 != null) {
        break label76;
      }
      paramString4 = "";
      label37:
      if (paramString5 != null) {
        break label79;
      }
      paramString5 = "";
    }
    label73:
    label76:
    label79:
    for (;;)
    {
      ReportController.b(localQQAppInterface, "CliOper", "", "", "AnonyMsg", paramString1, 0, 1, paramString2, paramString3, paramString4, paramString5);
      return;
      break;
      break label28;
      break label37;
    }
  }
  
  public void a(boolean paramBoolean, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SecMsgManager", 2, "preProcessPushMsg, isSecProcessForground=" + paramBoolean + ", pushMsgType=" + paramLong);
    }
    if (paramBoolean)
    {
      c();
      return;
    }
    a(paramLong);
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppSecMsgManager$SecMsgBaseInfo == null) {
      b();
    }
    return (this.jdField_a_of_type_ComTencentMobileqqAppSecMsgManager$SecMsgBaseInfo.d == 2) || ((this.jdField_a_of_type_ComTencentMobileqqAppSecMsgManager$SecMsgBaseInfo.d == 1) && (this.jdField_a_of_type_ComTencentMobileqqAppSecMsgManager$SecMsgBaseInfo.jdField_b_of_type_Boolean));
  }
  
  public boolean a(int paramInt)
  {
    if (this.k == paramInt) {}
    for (boolean bool = true;; bool = false)
    {
      this.k = paramInt;
      return bool;
    }
  }
  
  public boolean a(long paramLong)
  {
    return ((paramLong != 1L) && (paramLong != 2L)) || (!d());
  }
  
  public boolean a(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SecMsgManager", 2, "add secmsg to ru show=" + paramBoolean + ", msgTime=" + paramLong1);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SecMsgManager", 2, "mApp or app.getProxyManager is null!!");
      }
      return false;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
    RecentUser localRecentUser = ((RecentUserProxy)localObject).a(AppConstants.aF, 9001);
    if (paramBoolean)
    {
      localRecentUser.uin = AppConstants.aF;
      localRecentUser.type = 9001;
      if (localRecentUser.lastmsgtime < paramLong1) {
        localRecentUser.lastmsgtime = paramLong1;
      }
      if (QLog.isColorLevel()) {
        QLog.d("SecMsgManager", 2, "addSecMsgEntryToRU, show entrance, real time=" + localRecentUser.lastmsgtime);
      }
      ((RecentUserProxy)localObject).a(localRecentUser);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(Conversation.class);
        if (localObject != null) {
          ((MqqHandler)localObject).sendEmptyMessage(1009);
        }
      }
      return true;
      if (QLog.isColorLevel()) {
        QLog.d("SecMsgManager", 2, "addSecMsgEntryToRU, hide entrance");
      }
      ((RecentUserProxy)localObject).b(localRecentUser);
    }
  }
  
  public long b()
  {
    long l1 = 0L;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      int i1 = SecMsgUtil.a();
      l1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences("secmsg_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), i1).getLong("sp_key_sec_msg_last_msg_time", 0L);
    }
    return l1 / 1000L;
  }
  
  public void b()
  {
    int i1;
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqAppSecMsgManager$SecMsgBaseInfo == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppSecMsgManager$SecMsgBaseInfo = new SecMsgManager.SecMsgBaseInfo();
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
        break label357;
      }
      i1 = SecMsgUtil.a();
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences("secmsg_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), i1);
      if (localObject == null) {
        break label357;
      }
      i1 = 1;
      this.jdField_a_of_type_ComTencentMobileqqAppSecMsgManager$SecMsgBaseInfo.jdField_a_of_type_Boolean = ((SharedPreferences)localObject).getBoolean("sp_key_forbidden", false);
      this.jdField_a_of_type_ComTencentMobileqqAppSecMsgManager$SecMsgBaseInfo.c = ((SharedPreferences)localObject).getBoolean("sp_key_disable", false);
      this.jdField_a_of_type_ComTencentMobileqqAppSecMsgManager$SecMsgBaseInfo.jdField_b_of_type_Boolean = ((SharedPreferences)localObject).getBoolean("sp_key_in_white_list", false);
      this.jdField_a_of_type_ComTencentMobileqqAppSecMsgManager$SecMsgBaseInfo.jdField_a_of_type_JavaUtilList = a();
      this.jdField_a_of_type_ComTencentMobileqqAppSecMsgManager$SecMsgBaseInfo.d = ((SharedPreferences)localObject).getInt("sp_key_feature_state", 0);
      this.jdField_a_of_type_ComTencentMobileqqAppSecMsgManager$SecMsgBaseInfo.jdField_a_of_type_Long = ((SharedPreferences)localObject).getLong("sp_key_newest_seq", 0L);
    }
    for (;;)
    {
      if (i1 == 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppSecMsgManager$SecMsgBaseInfo.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_ComTencentMobileqqAppSecMsgManager$SecMsgBaseInfo.c = false;
        this.jdField_a_of_type_ComTencentMobileqqAppSecMsgManager$SecMsgBaseInfo.jdField_b_of_type_Boolean = false;
        this.jdField_a_of_type_ComTencentMobileqqAppSecMsgManager$SecMsgBaseInfo.d = 0;
        this.jdField_a_of_type_ComTencentMobileqqAppSecMsgManager$SecMsgBaseInfo.jdField_a_of_type_JavaUtilList = a();
        this.jdField_a_of_type_ComTencentMobileqqAppSecMsgManager$SecMsgBaseInfo.jdField_a_of_type_Long = 0L;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuffer();
        ((StringBuffer)localObject).append("initSecMsgBaseInfo from sp, mIsForbidden=").append(this.jdField_a_of_type_ComTencentMobileqqAppSecMsgManager$SecMsgBaseInfo.jdField_a_of_type_Boolean).append(",mIsWhiteUser=").append(this.jdField_a_of_type_ComTencentMobileqqAppSecMsgManager$SecMsgBaseInfo.jdField_b_of_type_Boolean).append(",mIsDisable=").append(this.jdField_a_of_type_ComTencentMobileqqAppSecMsgManager$SecMsgBaseInfo.c).append(",mNewestSeq=").append(this.jdField_a_of_type_ComTencentMobileqqAppSecMsgManager$SecMsgBaseInfo.jdField_a_of_type_Long).append(",mServerTimestamp=").append(this.jdField_a_of_type_ComTencentMobileqqAppSecMsgManager$SecMsgBaseInfo.jdField_b_of_type_Long).append(",mFeatureState=").append(this.jdField_a_of_type_ComTencentMobileqqAppSecMsgManager$SecMsgBaseInfo.d).append(",mShieldSessionList=").append(this.jdField_a_of_type_ComTencentMobileqqAppSecMsgManager$SecMsgBaseInfo.jdField_a_of_type_JavaUtilList);
        QLog.d("SecMsgManager", 2, ((StringBuffer)localObject).toString());
      }
      return;
      label357:
      i1 = 0;
    }
  }
  
  public boolean b()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      int i1 = SecMsgUtil.a();
      SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences("secmsg_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), i1);
      bool1 = bool2;
      if (localSharedPreferences != null) {
        bool1 = localSharedPreferences.getBoolean("sp_key_local_available", false);
      }
    }
    return bool1;
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SecMsgManager", 2, "clearHint");
    }
    this.h = 0;
  }
  
  public boolean c()
  {
    boolean bool2 = false;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      int i1 = SecMsgUtil.a();
      SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences("secmsg_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), i1);
      if (localSharedPreferences != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppSecMsgManager$SecMsgBaseInfo.c = localSharedPreferences.getBoolean("sp_key_disable", false);
      }
    }
    boolean bool1 = bool2;
    if (b())
    {
      bool1 = bool2;
      if (!this.jdField_a_of_type_ComTencentMobileqqAppSecMsgManager$SecMsgBaseInfo.c) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean d()
  {
    boolean bool2 = false;
    if (this.jdField_a_of_type_ComTencentMobileqqAppSecMsgManager$SecMsgBaseInfo == null) {
      b();
    }
    int i1 = SecMsgUtil.a();
    boolean bool3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences("secmsg_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), i1).getBoolean("sp_key_disable", false);
    boolean bool1 = bool2;
    if (b())
    {
      bool1 = bool2;
      if (!bool3)
      {
        bool1 = bool2;
        if (a()) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public boolean e()
  {
    return this.h != 0;
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\app\SecMsgManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.tencent.biz.pubaccount.util;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.biz.bmqq.util.BmqqSegmentUtil;
import com.tencent.biz.coupon.CouponActivity;
import com.tencent.biz.pubaccount.AccountDetail.activity.EqqAccountDetailActivity;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.biz.pubaccount.PublicAccountServlet;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.model.UserOperationModule;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyMSFService;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.PublicAccountListActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.EqqDetailDataManager;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.PublicAccountObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.UinPair;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.mp.mobileqq_mp.FollowRequest;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountDetailInfoRequest;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountDetailInfoResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.UnFollowRequest;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.base.http.HttpBaseUtil;
import com.tencent.open.base.http.HttpBaseUtil.HttpResponseBean;
import com.tencent.qidian.QidianProfileCardActivity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import cooperation.dingdong.OfficeOpenBrowserActivity;
import cooperation.qzone.QZoneShareManager;
import cooperation.readinjoy.ReadInJoyHelper;
import ifv;
import ifw;
import ifx;
import ify;
import ifz;
import iga;
import igc;
import igd;
import ige;
import igf;
import igj;
import igl;
import igm;
import java.net.URLDecoder;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.manager.TicketManager;
import mqq.os.MqqHandler;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class PublicAccountUtil
{
  public static final int a = 1;
  private static Handler jdField_a_of_type_AndroidOsHandler;
  public static QQCustomDialog a;
  private static Object jdField_a_of_type_JavaLangObject = new Object();
  public static final String a = "PublicAccountUtil";
  public static MqqHandler a;
  public static final int b = 200;
  public static final String b = "ab_test_sharePre";
  public static final int c = -1;
  public static final String c = "ab_test_switch_";
  public static final int d = -2;
  public static final String d = "ab_test_loadtime_";
  public static final int e = -3;
  public static final String e = "http://c.mp.qq.com/post/pageview/report?ftype=5&ctype=1&aid=%s&vid=%s&rtype=%d";
  public static final int f = -4;
  public static final String f = "VIDEO_REALTIME_REPORT_AID";
  public static final int g = -5;
  public static final String g = "VIDEO_REALTIME_REPORT_VID";
  public static final int h = -6;
  public static final String h = "VIDEO_REALTIME_REPORT_RTYPE";
  public static final int i = -7;
  public static final String i = "VIDEO_REALTIME_REPORT_RCODE";
  public static final int j = -8;
  public static final String j = "need_finish";
  public static final int k = 1;
  public static final String k = "3046055438";
  public static final int l = 2;
  public static final String l = "3026775809";
  public static final int m = 3;
  public static final String m = "2711679534";
  public static final int n = 4;
  private static String n;
  private static volatile int o;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    o = -1;
    n = "tag_delete_oldkandian_flag";
  }
  
  public static int a(int paramInt)
  {
    if (paramInt < 0) {
      return paramInt;
    }
    if ((0x200000 & paramInt) != 0) {
      return -2;
    }
    if ((0x4000000 & paramInt) != 0) {
      return -3;
    }
    if ((0x2000000 & paramInt) != 0) {
      return -4;
    }
    if ((0x800000 & paramInt) != 0) {
      return -5;
    }
    if ((0x8000000 & paramInt) != 0) {
      return -6;
    }
    return -1;
  }
  
  public static int a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = (PublicAccountDataManager)paramQQAppInterface.getManager(55);
      if (paramQQAppInterface == null) {}
    }
    for (int i1 = paramQQAppInterface.c().size();; i1 = 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PublicAccountUtil", 2, "getSubscriptCount count: " + i1);
      }
      return i1;
    }
  }
  
  public static int a(QQAppInterface paramQQAppInterface, String paramString)
  {
    int i2 = -1;
    int i3 = i2;
    if (paramQQAppInterface != null)
    {
      if (!TextUtils.isEmpty(paramString)) {
        break label25;
      }
      i3 = i2;
    }
    label25:
    do
    {
      int i1;
      do
      {
        do
        {
          return i3;
          localObject = (PublicAccountDataManager)paramQQAppInterface.getManager(55);
          i3 = i2;
        } while (localObject == null);
        Object localObject = ((PublicAccountDataManager)localObject).b(paramString);
        if (localObject != null)
        {
          if (((PublicAccountInfo)localObject).extendType == 2) {
            return -7;
          }
          return a(((PublicAccountInfo)localObject).accountFlag);
        }
        localObject = ((TroopManager)paramQQAppInterface.getManager(51)).a(paramString);
        i1 = i2;
        if (localObject != null)
        {
          i1 = i2;
          if (((TroopInfo)localObject).associatePubAccount != 0L) {
            i1 = -4;
          }
        }
        paramQQAppInterface = (EqqDetailDataManager)paramQQAppInterface.getManager(68);
        i3 = i1;
      } while (paramQQAppInterface == null);
      i3 = i1;
    } while (paramQQAppInterface.a(paramString) == null);
    return -7;
  }
  
  private static int a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    int i2 = a(paramQQAppInterface, paramString);
    int i1 = i2;
    if (i2 == -1) {
      i1 = a(paramInt);
    }
    return i1;
  }
  
  public static long a(long paramLong)
  {
    long l1 = -1L;
    if ((0x200 & paramLong) != 0L) {
      l1 = -8L;
    }
    return l1;
  }
  
  public static AccountDetail a(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = paramQQAppInterface.a().createEntityManager();
    paramString = (AccountDetail)paramQQAppInterface.a(AccountDetail.class, paramString);
    paramQQAppInterface.a();
    return paramString;
  }
  
  public static String a()
  {
    return "6.5.5,3,2880";
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString)
  {
    String str = paramString;
    if (!TextUtils.isEmpty(paramString))
    {
      paramQQAppInterface = (PublicAccountDataManager)paramQQAppInterface.getManager(55);
      str = paramString;
      if (paramQQAppInterface != null)
      {
        paramQQAppInterface = paramQQAppInterface.c(paramString);
        str = paramString;
        if (paramQQAppInterface != null) {
          str = paramQQAppInterface.name;
        }
      }
    }
    return str;
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i2 = paramArrayOfByte.length;
    int i1 = 0;
    while (i1 < i2)
    {
      localStringBuffer.append(paramArrayOfByte[i1]).append(",");
      i1 += 1;
    }
    return localStringBuffer.toString();
  }
  
  /* Error */
  public static NewIntent a(QQAppInterface paramQQAppInterface, Context paramContext, MqqHandler paramMqqHandler, String paramString)
  {
    // Byte code:
    //   0: invokestatic 114	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +11 -> 14
    //   6: ldc 13
    //   8: iconst_2
    //   9: ldc -23
    //   11: invokestatic 133	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   14: ldc 2
    //   16: monitorenter
    //   17: aload_2
    //   18: ifnull +7 -> 25
    //   21: aload_2
    //   22: putstatic 235	com/tencent/biz/pubaccount/util/PublicAccountUtil:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   25: ldc 2
    //   27: monitorexit
    //   28: new 237	mqq/app/NewIntent
    //   31: dup
    //   32: aload_1
    //   33: ldc -17
    //   35: invokespecial 242	mqq/app/NewIntent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   38: astore_1
    //   39: aload_1
    //   40: ldc -12
    //   42: ldc -10
    //   44: invokevirtual 250	mqq/app/NewIntent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   47: pop
    //   48: new 252	com/tencent/mobileqq/mp/mobileqq_mp$GetPublicAccountDetailInfoRequest
    //   51: dup
    //   52: invokespecial 253	com/tencent/mobileqq/mp/mobileqq_mp$GetPublicAccountDetailInfoRequest:<init>	()V
    //   55: astore_2
    //   56: aload_2
    //   57: getfield 257	com/tencent/mobileqq/mp/mobileqq_mp$GetPublicAccountDetailInfoRequest:seqno	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   60: iconst_0
    //   61: invokevirtual 263	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   64: aload_2
    //   65: getfield 266	com/tencent/mobileqq/mp/mobileqq_mp$GetPublicAccountDetailInfoRequest:version	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   68: iconst_1
    //   69: invokevirtual 263	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   72: aload_2
    //   73: getfield 270	com/tencent/mobileqq/mp/mobileqq_mp$GetPublicAccountDetailInfoRequest:versionInfo	Lcom/tencent/mobileqq/pb/PBStringField;
    //   76: ldc -47
    //   78: invokevirtual 275	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   81: aload_2
    //   82: getfield 278	com/tencent/mobileqq/mp/mobileqq_mp$GetPublicAccountDetailInfoRequest:uin	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   85: aload_3
    //   86: invokestatic 284	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   89: l2i
    //   90: invokevirtual 263	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   93: aload_1
    //   94: ldc_w 286
    //   97: aload_2
    //   98: invokevirtual 290	com/tencent/mobileqq/mp/mobileqq_mp$GetPublicAccountDetailInfoRequest:toByteArray	()[B
    //   101: invokevirtual 293	mqq/app/NewIntent:putExtra	(Ljava/lang/String;[B)Landroid/content/Intent;
    //   104: pop
    //   105: aload_1
    //   106: new 295	igh
    //   109: dup
    //   110: aload_0
    //   111: invokespecial 298	igh:<init>	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   114: invokevirtual 302	mqq/app/NewIntent:setObserver	(Lmqq/observer/BusinessObserver;)V
    //   117: aload_0
    //   118: aload_1
    //   119: invokevirtual 306	com/tencent/mobileqq/app/QQAppInterface:startServlet	(Lmqq/app/NewIntent;)V
    //   122: invokestatic 114	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   125: ifeq +12 -> 137
    //   128: ldc 13
    //   130: iconst_2
    //   131: ldc_w 308
    //   134: invokestatic 133	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   137: aload_1
    //   138: areturn
    //   139: astore_0
    //   140: ldc 2
    //   142: monitorexit
    //   143: aload_0
    //   144: athrow
    //   145: astore_3
    //   146: goto -53 -> 93
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	149	0	paramQQAppInterface	QQAppInterface
    //   0	149	1	paramContext	Context
    //   0	149	2	paramMqqHandler	MqqHandler
    //   0	149	3	paramString	String
    // Exception table:
    //   from	to	target	type
    //   21	25	139	finally
    //   25	28	139	finally
    //   140	143	139	finally
    //   81	93	145	java/lang/Exception
  }
  
  public static JSONObject a(String paramString)
  {
    try
    {
      paramString = (JSONObject)new JSONTokener(paramString).nextValue();
      return paramString;
    }
    catch (JSONException paramString)
    {
      return null;
    }
    catch (NullPointerException paramString)
    {
      return null;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  public static void a()
  {
    try
    {
      jdField_a_of_type_MqqOsMqqHandler = null;
      return;
    }
    finally {}
  }
  
  public static void a(int paramInt1, String paramString, int paramInt2)
  {
    if (TextUtils.isEmpty(paramString)) {}
    Uri localUri;
    String str;
    do
    {
      do
      {
        return;
        localUri = Uri.parse(paramString);
      } while (localUri == null);
      str = localUri.getHost();
    } while ((TextUtils.isEmpty(str)) || ((!"article.mp.qq.com".equalsIgnoreCase(str)) && (!"post.mp.qq.com".equalsIgnoreCase(str))));
    ThreadManager.a(new ify(localUri, paramInt2, paramInt1, paramString), 5, null, false);
  }
  
  public static void a(Activity paramActivity, QQAppInterface paramQQAppInterface, ProfileParams paramProfileParams)
  {
    Object localObject = paramProfileParams.a;
    if ((TextUtils.isEmpty(((ProfileParams.CurLoginUsr)localObject).a)) && (TextUtils.isEmpty(((ProfileParams.CurLoginUsr)localObject).b))) {
      b(paramActivity, paramQQAppInterface, paramProfileParams);
    }
    for (;;)
    {
      return;
      if (!TextUtils.isEmpty(((ProfileParams.CurLoginUsr)localObject).b))
      {
        String str = paramQQAppInterface.a();
        if (!((ProfileParams.CurLoginUsr)localObject).b.equals(str))
        {
          c(paramActivity, paramQQAppInterface, paramProfileParams);
          return;
        }
        b(paramActivity, paramQQAppInterface, paramProfileParams);
        return;
      }
      localObject = new igj(paramActivity, paramQQAppInterface, paramProfileParams);
      localObject = QZoneShareManager.a(paramQQAppInterface, paramProfileParams.b(), (BusinessObserver)localObject);
      if (localObject != null)
      {
        if (!a(paramActivity, (OpenID)localObject, paramQQAppInterface, paramProfileParams)) {}
        for (int i1 = 1; i1 != 0; i1 = 0)
        {
          b(paramActivity, paramQQAppInterface, paramProfileParams);
          return;
        }
      }
    }
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    Toast.makeText(paramContext, paramInt, 0).show();
  }
  
  private static void a(Context paramContext, QQAppInterface paramQQAppInterface, String paramString, int paramInt, Intent paramIntent)
  {
    switch (a(paramQQAppInterface, paramString, paramInt))
    {
    default: 
      b(paramIntent, paramContext, paramString);
    case -6: 
      return;
    }
    a(paramIntent, paramContext, paramString);
  }
  
  private static void a(Intent paramIntent, Activity paramActivity, String paramString, int paramInt1, int paramInt2)
  {
    if (paramIntent == null) {
      paramIntent = new Intent(paramActivity, QidianProfileCardActivity.class);
    }
    for (;;)
    {
      paramIntent.putExtra("AllInOne", new ProfileActivity.AllInOne(paramString, 78));
      paramIntent.putExtra("uin", paramString);
      paramActivity.startActivityForResult(paramIntent, paramInt1);
      return;
      paramIntent.setClassName(paramActivity, QidianProfileCardActivity.class.getName());
    }
  }
  
  public static void a(Intent paramIntent, Context paramContext, String paramString)
  {
    if (paramIntent == null) {
      paramIntent = new Intent(paramContext, EqqAccountDetailActivity.class);
    }
    for (;;)
    {
      paramIntent.putExtra("uin", paramString);
      paramIntent.addFlags(67108864);
      paramContext.startActivity(paramIntent);
      if ((paramContext instanceof Activity)) {
        ((Activity)paramContext).overridePendingTransition(2130968590, 2130968591);
      }
      return;
      paramIntent.setClassName(paramContext, EqqAccountDetailActivity.class.getName());
    }
  }
  
  private static void a(Intent paramIntent, QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString, int paramInt1, int paramInt2)
  {
    if (paramIntent == null) {
      paramIntent = new Intent(paramActivity, AccountDetailActivity.class);
    }
    for (;;)
    {
      paramIntent.putExtra("uin", paramString);
      paramIntent.putExtra("source", 5);
      paramIntent.addFlags(67108864);
      paramActivity.startActivityForResult(paramIntent, paramInt1);
      switch (paramInt2)
      {
      default: 
        return;
        paramIntent.setClassName(paramActivity, AccountDetailActivity.class.getName());
      }
    }
    PublicAccountHandler.a(paramQQAppInterface, paramString, "Pb_account_lifeservice", "mp_msg_sys_2", "detail");
  }
  
  public static void a(Intent paramIntent, QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountUtil", 2, "gotoProfileForResult app: " + paramQQAppInterface + " | activity: " + paramActivity + " | uin: " + paramString + " | accountFlag: " + paramInt1 + " | requestCode: " + paramInt2 + " | source: " + paramInt3);
    }
    if ((paramQQAppInterface == null) || (paramActivity == null) || (TextUtils.isEmpty(paramString))) {}
    do
    {
      return;
      switch (a(paramQQAppInterface, paramString, paramInt1))
      {
      default: 
        a(paramIntent, paramQQAppInterface, paramActivity, paramString, paramInt2, paramInt3);
        return;
      }
    } while (!BmqqSegmentUtil.a(paramActivity, paramString));
    a(paramIntent, paramActivity, paramString, paramInt2, paramInt3);
    return;
    b(paramIntent, paramQQAppInterface, paramActivity, paramString, paramInt2, paramInt3);
  }
  
  public static void a(Intent paramIntent, QQAppInterface paramQQAppInterface, Context paramContext, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountUtil", 2, "gotoProfile app: " + paramQQAppInterface + " | context: " + paramContext + " | uin: " + paramString + " | accountFlag: " + paramInt);
    }
    if ((paramQQAppInterface == null) || (paramContext == null) || (TextUtils.isEmpty(paramString))) {}
    do
    {
      return;
      paramInt = a(paramQQAppInterface, paramString, paramInt);
      if ((paramInt == -2) || (paramInt == -3) || (paramInt == -4))
      {
        paramQQAppInterface = paramIntent;
        if (paramIntent == null)
        {
          paramQQAppInterface = new Intent();
          paramQQAppInterface.putExtra("source", 105);
        }
      }
      for (;;)
      {
        switch (paramInt)
        {
        default: 
          b(paramQQAppInterface, paramContext, paramString);
          return;
          paramQQAppInterface = paramIntent;
          if (paramInt == -1)
          {
            paramQQAppInterface = paramIntent;
            if (paramIntent == null)
            {
              paramQQAppInterface = new Intent();
              paramQQAppInterface.putExtra("source", 104);
            }
          }
          break;
        }
      }
    } while (!BmqqSegmentUtil.a(paramContext, paramString));
    c(paramQQAppInterface, paramContext, paramString);
    return;
    a(paramQQAppInterface, paramContext, paramString);
  }
  
  public static void a(Intent paramIntent, String paramString)
  {
    a(null, paramIntent, paramString);
  }
  
  public static void a(Handler paramHandler)
  {
    try
    {
      jdField_a_of_type_AndroidOsHandler = paramHandler;
      return;
    }
    finally {}
  }
  
  public static void a(AppInterface paramAppInterface, Context paramContext, String paramString, PublicAccountObserver paramPublicAccountObserver)
  {
    a(paramAppInterface, paramContext, paramString, paramPublicAccountObserver, true);
  }
  
  public static void a(AppInterface paramAppInterface, Context paramContext, String paramString, PublicAccountObserver paramPublicAccountObserver, int paramInt)
  {
    if ((paramAppInterface == null) || (paramContext == null) || (TextUtils.isEmpty(paramString))) {}
    do
    {
      return;
      NewIntent localNewIntent = new NewIntent(paramContext.getApplicationContext(), PublicAccountServlet.class);
      localNewIntent.putExtra("cmd", "PubAccountFollowSvc.follow");
      mobileqq_mp.FollowRequest localFollowRequest = new mobileqq_mp.FollowRequest();
      try
      {
        localFollowRequest.uin.set((int)Long.parseLong(paramString));
        localFollowRequest.type.set(paramInt);
        localNewIntent.setObserver(new ige(paramPublicAccountObserver, paramString, paramContext, paramAppInterface));
        localNewIntent.putExtra("data", localFollowRequest.toByteArray());
        paramAppInterface.startServlet(localNewIntent);
        return;
      }
      catch (NumberFormatException paramAppInterface) {}
    } while (!QLog.isColorLevel());
    QLog.w("PublicAccountUtil", 2, "Follow Request got wrong uin:" + paramString);
  }
  
  public static void a(AppInterface paramAppInterface, Context paramContext, String paramString, PublicAccountObserver paramPublicAccountObserver, boolean paramBoolean)
  {
    if ((paramAppInterface == null) || (paramContext == null) || (TextUtils.isEmpty(paramString))) {}
    do
    {
      return;
      NewIntent localNewIntent = new NewIntent(paramContext.getApplicationContext(), PublicAccountServlet.class);
      localNewIntent.putExtra("cmd", "follow");
      mobileqq_mp.FollowRequest localFollowRequest = new mobileqq_mp.FollowRequest();
      try
      {
        localFollowRequest.uin.set((int)Long.parseLong(paramString));
        localNewIntent.setObserver(new igc(paramPublicAccountObserver, paramString, paramBoolean, paramContext, paramAppInterface));
        localNewIntent.putExtra("data", localFollowRequest.toByteArray());
        paramAppInterface.startServlet(localNewIntent);
        return;
      }
      catch (NumberFormatException paramAppInterface) {}
    } while (!QLog.isColorLevel());
    QLog.w("PublicAccountUtil", 2, "Follow Request got wrong uin:" + paramString);
  }
  
  private static void a(QQAppInterface paramQQAppInterface, long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    ArrayList localArrayList = new ArrayList();
    ReportInfo localReportInfo = new ReportInfo();
    localReportInfo.mUin = paramQQAppInterface.getLongAccountUin();
    localReportInfo.mSource = 0;
    localReportInfo.mSourceArticleId = paramLong;
    localReportInfo.mAlgorithmId = paramInt1;
    localReportInfo.mOperation = paramInt3;
    localReportInfo.mOpSource = 3;
    localReportInfo.mStrategyId = paramInt2;
    localArrayList.add(localReportInfo);
    new UserOperationModule(paramQQAppInterface, null, null, ReadInJoyMSFService.a(), null).a(localArrayList);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString)
  {
    b(paramQQAppInterface, paramContext, paramString);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountUtil", 2, "gotoAIO app: " + paramQQAppInterface + " | context: " + paramContext + " | uin: " + paramString + " | accountFlag: " + paramInt);
    }
    if ((paramQQAppInterface == null) || (paramContext == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    Object localObject1 = (PublicAccountDataManager)paramQQAppInterface.getManager(55);
    if (localObject1 != null)
    {
      localObject1 = ((PublicAccountDataManager)localObject1).c(paramString);
      if (localObject1 == null) {}
    }
    for (localObject1 = ((PublicAccountInfo)localObject1).name;; localObject1 = "")
    {
      Object localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = paramString;
      }
      int i1 = a(paramQQAppInterface, paramString, paramInt);
      paramQQAppInterface = new Intent(paramContext, ChatActivity.class);
      paramInt = 1008;
      if (i1 == -7)
      {
        paramQQAppInterface.putExtra("chat_subType", 1);
        paramInt = 0;
      }
      paramQQAppInterface.putExtra("uin", paramString);
      paramQQAppInterface.putExtra("uintype", paramInt);
      paramQQAppInterface.putExtra("uinname", (String)localObject2);
      paramQQAppInterface.putExtra("leftViewText", paramContext.getString(2131367975));
      paramContext.startActivity(paramQQAppInterface);
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, int paramInt, long paramLong, boolean paramBoolean)
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(paramContext, null);
    localActionSheet.a(paramContext.getResources().getString(2131364614));
    localActionSheet.a(2131368306, 3);
    if (paramString.equals("2010741172")) {
      localActionSheet.c(2131364495);
    }
    localActionSheet.d(2131367262);
    localActionSheet.a(new ifv(paramQQAppInterface, paramString, paramInt, paramLong, paramBoolean, paramContext, localActionSheet));
    localActionSheet.show();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, boolean paramBoolean, PublicAccountObserver paramPublicAccountObserver)
  {
    Object localObject2 = null;
    if ((paramQQAppInterface == null) || (paramContext == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    NewIntent localNewIntent = new NewIntent(paramQQAppInterface.a().getApplicationContext(), PublicAccountServlet.class);
    localNewIntent.putExtra("cmd", "unfollow");
    Object localObject3 = (PublicAccountDataManager)paramQQAppInterface.getManager(55);
    Object localObject1;
    if (localObject3 != null)
    {
      localObject1 = ((PublicAccountDataManager)localObject3).a(paramString);
      ((PublicAccountDataManager)localObject3).b(paramString);
      if (localObject1 == null)
      {
        localObject2 = (EqqDetailDataManager)paramQQAppInterface.getManager(68);
        if (localObject2 != null)
        {
          localObject3 = ((EqqDetailDataManager)localObject2).a(paramString);
          localObject2 = localObject1;
          localObject1 = localObject3;
        }
      }
    }
    for (;;)
    {
      localObject3 = new mobileqq_mp.UnFollowRequest();
      for (;;)
      {
        try
        {
          ((mobileqq_mp.UnFollowRequest)localObject3).uin.set((int)Long.parseLong(paramString));
          if (localObject1 != null) {
            break label220;
          }
          paramContext = new igd(paramPublicAccountObserver, paramString, paramBoolean, paramContext, localObject1, paramQQAppInterface);
          localNewIntent.putExtra("data", ((mobileqq_mp.UnFollowRequest)localObject3).toByteArray());
          localNewIntent.setObserver(paramContext);
          paramQQAppInterface.startServlet(localNewIntent);
          return;
        }
        catch (NumberFormatException paramQQAppInterface) {}
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.w("PublicAccountUtil", 2, "Unfollow Request got wrong uin:" + paramString);
        return;
        label220:
        localObject1 = localObject2;
      }
      localObject3 = null;
      localObject2 = localObject1;
      localObject1 = localObject3;
      continue;
      localObject1 = null;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, MessageForStructing paramMessageForStructing, int paramInt)
  {
    if (paramMessageForStructing == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    int i2;
    int i1;
    if (!TextUtils.isEmpty(paramMessageForStructing.structingMsg.mAlgorithmIds))
    {
      localObject = paramMessageForStructing.structingMsg.mAlgorithmIds.split("\\|");
      i2 = localObject.length;
      i1 = 0;
      for (;;)
      {
        if (i1 < i2)
        {
          String str1 = localObject[i1];
          try
          {
            localArrayList.add(Integer.valueOf(Integer.parseInt(str1)));
            i1 += 1;
          }
          catch (Exception localException1)
          {
            for (;;)
            {
              localException1.printStackTrace();
            }
          }
        }
      }
    }
    Object localObject = new ArrayList();
    if (!TextUtils.isEmpty(paramMessageForStructing.structingMsg.mStrategyIds))
    {
      String[] arrayOfString = paramMessageForStructing.structingMsg.mStrategyIds.split("\\|");
      i2 = arrayOfString.length;
      i1 = 0;
      for (;;)
      {
        if (i1 < i2)
        {
          String str2 = arrayOfString[i1];
          try
          {
            ((ArrayList)localObject).add(Integer.valueOf(Integer.parseInt(str2)));
            i1 += 1;
          }
          catch (Exception localException2)
          {
            for (;;)
            {
              localException2.printStackTrace();
            }
          }
        }
      }
    }
    if (!TextUtils.isEmpty(paramMessageForStructing.structingMsg.mMsgActionData))
    {
      paramMessageForStructing = a(paramMessageForStructing.structingMsg.mMsgActionData);
      if (paramMessageForStructing == null) {}
    }
    for (;;)
    {
      try
      {
        l1 = Long.parseLong(paramMessageForStructing.getString("id"));
        if ((l1 == -1L) || (localArrayList.size() <= 0) || (((ArrayList)localObject).size() <= 0)) {
          break;
        }
        a(paramQQAppInterface, l1, ((Integer)localArrayList.get(0)).intValue(), ((Integer)((ArrayList)localObject).get(0)).intValue(), paramInt);
        return;
      }
      catch (Exception paramMessageForStructing)
      {
        paramMessageForStructing.printStackTrace();
      }
      long l1 = -1L;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramString = new UinPair(paramQQAppInterface.a(), paramString);
    PublicAccountHandler localPublicAccountHandler = (PublicAccountHandler)paramQQAppInterface.a(11);
    if (localPublicAccountHandler.a == null) {
      localPublicAccountHandler.a = new ArrayList();
    }
    localPublicAccountHandler.a.add(paramString);
    paramQQAppInterface = paramQQAppInterface.a().createEntityManager();
    paramQQAppInterface.a(paramString);
    paramQQAppInterface.a();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    if (ReadInJoyHelper.a(paramQQAppInterface)) {
      ((KandianMergeManager)paramQQAppInterface.getManager(161)).a(paramString1, paramString2, paramInt, paramBoolean);
    }
    QQMessageFacade localQQMessageFacade;
    do
    {
      return;
      localQQMessageFacade = paramQQAppInterface.a();
    } while (localQQMessageFacade == null);
    ThreadManager.a(new ifz(localQQMessageFacade, paramString1, paramString2, paramQQAppInterface), 10, null, false);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, boolean paramBoolean)
  {
    a(paramQQAppInterface, paramString1, paramString2, 0, paramBoolean);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    int i1 = 1;
    Object localObject2 = paramQQAppInterface.getApplication().getSharedPreferences("mobileQQ", 0);
    for (;;)
    {
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        if (o == -1) {
          o = ((SharedPreferences)localObject2).getInt(n + paramQQAppInterface.a(), 0);
        }
        boolean bool;
        if (o == 0)
        {
          bool = true;
          break label284;
          o = i1;
          ((SharedPreferences)localObject2).edit().putInt(n + paramQQAppInterface.a(), o).commit();
          if ((bool) && (paramBoolean))
          {
            ??? = paramQQAppInterface.a().a();
            if (??? != null)
            {
              localObject2 = ((RecentUserProxy)???).b(AppConstants.aY, 1008);
              if (localObject2 != null)
              {
                ((RecentUserProxy)???).b((RecentUser)localObject2);
                ??? = paramQQAppInterface.a(Conversation.class);
                if (??? != null) {
                  ((MqqHandler)???).sendEmptyMessage(1009);
                }
              }
            }
            ??? = (PublicAccountDataManager)paramQQAppInterface.getManager(55);
            if (??? != null)
            {
              ((PublicAccountDataManager)???).c(AppConstants.aY);
              paramQQAppInterface = paramQQAppInterface.a(PublicAccountListActivity.class);
              if (paramQQAppInterface != null) {
                paramQQAppInterface.sendEmptyMessage(0);
              }
            }
          }
          if (QLog.isColorLevel()) {
            QLog.i("PublicAccountUtil", 2, "updateDeleteOldKandian notDeleteState = " + bool + ", isDelete = " + paramBoolean);
          }
        }
        else
        {
          bool = false;
          break label284;
          i1 = 0;
        }
      }
      label284:
      if (!paramBoolean) {}
    }
  }
  
  public static void a(MessageRecord paramMessageRecord, Intent paramIntent, String paramString)
  {
    if (paramMessageRecord != null)
    {
      if (paramMessageRecord.istroop == 1) {
        paramIntent.putExtra("groupUin", paramMessageRecord.frienduin);
      }
      paramIntent.putExtra("friendUin", paramMessageRecord.senderuin);
      paramIntent.putExtra("uinType", paramMessageRecord.istroop);
      paramIntent.putExtra("fromAio", true);
    }
    paramMessageRecord = paramIntent.getComponent();
    if ((paramMessageRecord == null) || (TextUtils.isEmpty(paramString))) {}
    for (;;)
    {
      return;
      int i1 = paramString.indexOf("?");
      if (i1 != -1)
      {
        paramString = paramString.substring(i1 + 1).split("&");
        i1 = 0;
        if (i1 < paramString.length) {
          if (paramString[i1].startsWith("_webviewtype="))
          {
            paramString = paramString[i1].split("=");
            if ((paramString.length != 2) || (TextUtils.isEmpty(paramString[1]))) {
              break;
            }
          }
          else
          {
            try
            {
              switch (Integer.parseInt(paramString[1]))
              {
              case 0: 
              case 1: 
                paramIntent.setComponent(new ComponentName(paramMessageRecord.getPackageName(), CouponActivity.class.getName()));
                return;
              case 2: 
                paramIntent.setComponent(new ComponentName(paramMessageRecord.getPackageName(), OfficeOpenBrowserActivity.class.getName()));
                return;
                if (paramString[i1].startsWith("url="))
                {
                  paramMessageRecord = paramString[i1].split("=");
                  if ((paramMessageRecord.length == 2) && (!TextUtils.isEmpty(paramMessageRecord[1]))) {
                    a(paramIntent, URLDecoder.decode(paramMessageRecord[1]));
                  }
                }
                else
                {
                  i1 += 1;
                }
                break;
              }
            }
            catch (NumberFormatException paramMessageRecord) {}
          }
        }
      }
    }
  }
  
  public static void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    Uri localUri;
    String str;
    do
    {
      do
      {
        return;
        localUri = Uri.parse(paramString);
      } while (localUri == null);
      str = localUri.getHost();
    } while ((TextUtils.isEmpty(str)) || ((!"article.mp.qq.com".equalsIgnoreCase(str)) && (!"post.mp.qq.com".equalsIgnoreCase(str))));
    ThreadManager.a(new ifx(localUri, paramString), 5, null, false);
  }
  
  public static void a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PublicAccountUtil", 2, "videoPlayRealtimeReport aid=" + paramString1 + ", vid=" + paramString2 + ", rtype=" + paramInt1 + ", rcode=" + paramInt2);
    }
    if ((TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString1))) {}
    do
    {
      return;
      localObject = BaseApplicationImpl.a().a();
      if ((localObject != null) && ((localObject instanceof QQAppInterface)))
      {
        b(paramString1, paramString2, paramInt1, paramInt2);
        return;
      }
    } while ((localObject == null) || (!"ReadInJoyAppInterface".equals(localObject.getClass().getSimpleName())));
    Object localObject = new Intent("readInJoy_video_play_real_time_report");
    ((Intent)localObject).putExtra("VIDEO_REALTIME_REPORT_AID", paramString1);
    ((Intent)localObject).putExtra("VIDEO_REALTIME_REPORT_VID", paramString2);
    ((Intent)localObject).putExtra("VIDEO_REALTIME_REPORT_RTYPE", paramInt1);
    ((Intent)localObject).putExtra("VIDEO_REALTIME_REPORT_RCODE", paramInt2);
    BaseApplicationImpl.a().sendBroadcast((Intent)localObject);
  }
  
  public static boolean a()
  {
    return false;
  }
  
  public static boolean a(int paramInt)
  {
    boolean bool = false;
    paramInt = a(paramInt);
    if ((paramInt == -3) || (paramInt == -4)) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean a(int paramInt, long paramLong)
  {
    paramInt = a(paramInt);
    if ((paramInt == -2) || (paramInt == -3) || (paramInt == -4)) {}
    while (a(paramLong) == -8L) {
      return true;
    }
    return false;
  }
  
  public static boolean a(Activity paramActivity, OpenID paramOpenID, QQAppInterface paramQQAppInterface, ProfileParams paramProfileParams)
  {
    if ((paramOpenID != null) && (!TextUtils.isEmpty(paramOpenID.openID)))
    {
      if (!paramOpenID.openID.equals(paramProfileParams.a().a)) {}
      for (int i1 = 1; i1 != 0; i1 = 0)
      {
        c(paramActivity, paramQQAppInterface, paramProfileParams);
        return true;
      }
    }
    return false;
  }
  
  private static boolean a(Context paramContext, ProfileParams paramProfileParams)
  {
    return (paramContext == null) || (paramProfileParams == null) || (paramProfileParams.a == null) || (TextUtils.isEmpty(paramProfileParams.b()));
  }
  
  public static boolean a(AppInterface paramAppInterface, String paramString)
  {
    if ((paramAppInterface == null) || (TextUtils.isEmpty(paramString))) {}
    AccountDetail localAccountDetail;
    do
    {
      return false;
      paramAppInterface = paramAppInterface.a(paramAppInterface.getAccount()).createEntityManager();
      localAccountDetail = (AccountDetail)paramAppInterface.a(AccountDetail.class, paramString);
      if (localAccountDetail != null) {
        break;
      }
      paramString = (PublicAccountInfo)paramAppInterface.a(PublicAccountInfo.class, paramString);
      paramAppInterface.a();
    } while (paramString == null);
    return true;
    paramAppInterface.a();
    try
    {
      paramAppInterface = new mobileqq_mp.GetPublicAccountDetailInfoResponse();
      paramAppInterface.mergeFrom(localAccountDetail.accountData);
      int i1 = paramAppInterface.follow_type.get();
      if (i1 == 1) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
      return false;
    }
    catch (Exception paramAppInterface) {}
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramString = new UinPair(paramQQAppInterface.a(), paramString);
    PublicAccountHandler localPublicAccountHandler = (PublicAccountHandler)paramQQAppInterface.a(11);
    if (localPublicAccountHandler.a == null)
    {
      EntityManager localEntityManager = paramQQAppInterface.a().createEntityManager();
      localPublicAccountHandler.a = localEntityManager.a(UinPair.class, false, "userUin=? ", new String[] { paramQQAppInterface.a() }, null, null, null, null);
      localEntityManager.a();
      if (localPublicAccountHandler.a == null) {
        localPublicAccountHandler.a = new ArrayList();
      }
    }
    return localPublicAccountHandler.a.contains(paramString);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    boolean bool = false;
    if (ReadInJoyHelper.g(paramQQAppInterface)) {
      if ((paramInt == 63536) || (paramInt == 64536)) {
        bool = true;
      }
    }
    while ((!d(paramQQAppInterface, paramString)) && (paramInt != 63536) && (paramInt != 64536)) {
      return bool;
    }
    return true;
  }
  
  public static boolean a(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {}
    do
    {
      int i1;
      do
      {
        return false;
        i1 = paramMessageRecord.msgtype;
      } while ((i1 != 64536) && (i1 != 64499));
      paramMessageRecord = paramMessageRecord.getExtInfoFromExtStr("welcome_msg");
    } while ((TextUtils.isEmpty(paramMessageRecord)) || (!paramMessageRecord.equals("true")));
    return true;
  }
  
  public static boolean a(String paramString)
  {
    return ("3046055438".equals(paramString)) || ("3026775809".equals(paramString)) || ("2711679534".equals(paramString));
  }
  
  public static boolean a(String paramString1, int paramInt, String paramString2)
  {
    if (paramInt == 0) {}
    do
    {
      return false;
      paramString1 = Uri.parse(paramString1);
    } while ((paramString1 == null) || (TextUtils.isEmpty(paramString1.getHost())) || ((!"article.mp.qq.com".equalsIgnoreCase(paramString1.getHost())) && (!"post.mp.qq.com".equalsIgnoreCase(paramString1.getHost()))));
    ThreadManager.a(new ifw(paramString1, paramInt, paramString2), 5, null, false);
    return true;
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    if (paramString2.indexOf("?") != -1) {
      return b(paramString1, paramString2);
    }
    if (paramString2.indexOf("*") != -1) {
      return c(paramString1, paramString2);
    }
    return false;
  }
  
  public static byte[] a(String paramString)
  {
    paramString = paramString.split(",");
    ByteBuffer localByteBuffer = ByteBuffer.allocate(paramString.length);
    int i2 = paramString.length;
    int i1 = 0;
    while (i1 < i2)
    {
      localByteBuffer.put((byte)Integer.parseInt(paramString[i1]));
      i1 += 1;
    }
    return localByteBuffer.array();
  }
  
  public static long b(long paramLong)
  {
    return TimeZone.getDefault().getRawOffset() + paramLong;
  }
  
  private static MessageForStructing b(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    MessageForStructing localMessageForStructing = (MessageForStructing)MessageRecordFactory.a(63525);
    localMessageForStructing.structingMsg = StructMsgFactory.a();
    localMessageForStructing.structingMsg.mMsgServiceID = 500;
    localMessageForStructing.selfuin = paramQQAppInterface.f();
    localMessageForStructing.frienduin = AppConstants.aZ;
    localMessageForStructing.senderuin = AppConstants.aZ;
    localMessageForStructing.istroop = 1008;
    localMessageForStructing.issend = 1;
    localMessageForStructing.isread = true;
    if (!TextUtils.isEmpty(paramString1))
    {
      localMessageForStructing.structingMsg.mMsgBrief = paramString1;
      localMessageForStructing.doPrewrite();
    }
    if (!TextUtils.isEmpty(paramString2)) {
      localMessageForStructing.structingMsg.mArticleIds = paramString2;
    }
    if (!TextUtils.isEmpty(paramString3)) {
      localMessageForStructing.structingMsg.mOrangeWord = paramString3;
    }
    if (!TextUtils.isEmpty(paramString4)) {}
    try
    {
      localMessageForStructing.time = Long.parseLong(paramString4);
      localMessageForStructing.extInt = 0;
      localMessageForStructing.extLong = 0;
      return localMessageForStructing;
    }
    catch (Exception paramQQAppInterface)
    {
      for (;;)
      {
        paramQQAppInterface.printStackTrace();
      }
    }
  }
  
  private static MessageForStructing b(MessageForStructing paramMessageForStructing, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if ((paramMessageForStructing == null) || (!(paramMessageForStructing instanceof MessageForStructing)) || (!paramMessageForStructing.isread)) {
      return null;
    }
    MessageForStructing localMessageForStructing = (MessageForStructing)MessageRecordFactory.a(paramMessageForStructing.msgtype);
    localMessageForStructing.copyStructingMsg(paramMessageForStructing);
    localMessageForStructing.issend = 1;
    localMessageForStructing.isread = true;
    if (!TextUtils.isEmpty(paramString1))
    {
      localMessageForStructing.structingMsg.mMsgBrief = paramString1;
      localMessageForStructing.doPrewrite();
    }
    if (!TextUtils.isEmpty(paramString2)) {
      localMessageForStructing.structingMsg.mArticleIds = paramString2;
    }
    if (!TextUtils.isEmpty(paramString3)) {
      localMessageForStructing.structingMsg.mOrangeWord = paramString3;
    }
    if (!TextUtils.isEmpty(paramString4)) {}
    try
    {
      localMessageForStructing.time = Long.parseLong(paramString4);
      localMessageForStructing.extInt = 0;
      localMessageForStructing.extLong = 0;
      return localMessageForStructing;
    }
    catch (Exception paramMessageForStructing)
    {
      for (;;)
      {
        paramMessageForStructing.printStackTrace();
      }
    }
  }
  
  public static void b()
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      o = -1;
      return;
    }
  }
  
  public static void b(Activity paramActivity, QQAppInterface paramQQAppInterface, ProfileParams paramProfileParams)
  {
    d(paramActivity, paramQQAppInterface, paramProfileParams);
    paramActivity.finish();
  }
  
  public static void b(Intent paramIntent, Context paramContext, String paramString)
  {
    if (paramIntent == null) {
      paramIntent = new Intent(paramContext, AccountDetailActivity.class);
    }
    for (;;)
    {
      paramIntent.putExtra("uin", paramString);
      paramIntent.addFlags(67108864);
      paramContext.startActivity(paramIntent);
      if ((paramContext instanceof Activity)) {
        ((Activity)paramContext).overridePendingTransition(2130968590, 2130968591);
      }
      return;
      paramIntent.setClassName(paramContext, AccountDetailActivity.class.getName());
    }
  }
  
  private static void b(Intent paramIntent, QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString, int paramInt1, int paramInt2)
  {
    if (paramIntent == null) {
      paramIntent = new Intent(paramActivity, EqqAccountDetailActivity.class);
    }
    for (;;)
    {
      paramIntent.putExtra("uin", paramString);
      paramIntent.putExtra("source", 5);
      paramIntent.addFlags(67108864);
      paramActivity.startActivityForResult(paramIntent, paramInt1);
      switch (paramInt2)
      {
      default: 
        return;
        paramIntent.setClassName(paramActivity, EqqAccountDetailActivity.class.getName());
      }
    }
    PublicAccountHandler.a(paramQQAppInterface, paramString, "Pb_account_lifeservice", "mp_msg_sys_2", "detail");
  }
  
  private static void b(AppInterface paramAppInterface, Context paramContext, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountUtil", 2, "sendDetailInfoRequest");
    }
    NewIntent localNewIntent = new NewIntent(paramContext, PublicAccountServlet.class);
    localNewIntent.putExtra("cmd", "get_detail_info");
    mobileqq_mp.GetPublicAccountDetailInfoRequest localGetPublicAccountDetailInfoRequest = new mobileqq_mp.GetPublicAccountDetailInfoRequest();
    localGetPublicAccountDetailInfoRequest.versionInfo.set("6.5.5,3,2880");
    localGetPublicAccountDetailInfoRequest.seqno.set(0);
    localGetPublicAccountDetailInfoRequest.version.set(1);
    try
    {
      localGetPublicAccountDetailInfoRequest.uin.set((int)Long.parseLong(paramString));
      localNewIntent.putExtra("data", localGetPublicAccountDetailInfoRequest.toByteArray());
      localNewIntent.setObserver(new igf(paramContext, paramAppInterface));
      paramAppInterface.startServlet(localNewIntent);
      if (QLog.isColorLevel()) {
        QLog.d("PublicAccountUtil", 2, "sendDetailInfoRequest exit");
      }
      return;
    }
    catch (Exception paramString)
    {
      for (;;) {}
    }
  }
  
  static void b(QQAppInterface paramQQAppInterface, Context paramContext, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    label37:
    label111:
    label299:
    label306:
    for (;;)
    {
      return;
      int i1 = paramString.indexOf("?");
      if (i1 != -1)
      {
        paramString = paramString.substring(i1 + 1).split("&");
        i1 = 0;
        if (i1 < paramString.length) {
          if (!paramString[i1].startsWith("url=")) {}
        }
        for (paramString = URLDecoder.decode(paramString[i1].split("=")[1]);; paramString = "")
        {
          if (TextUtils.isEmpty(paramString)) {
            break label306;
          }
          i1 = paramString.indexOf("?");
          if (i1 == -1) {
            break;
          }
          paramString = paramString.substring(i1 + 1).split("&");
          paramQQAppInterface.a();
          i1 = 0;
          if (i1 < paramString.length) {
            if (!paramString[i1].startsWith("mailid=")) {}
          }
          for (paramString = paramString[i1].split("=")[1];; paramString = "")
          {
            if (TextUtils.isEmpty(paramString)) {
              break label299;
            }
            paramQQAppInterface = String.format("http://w.mail.qq.com/cgi-bin/login?mailid=%1$s&target=mobileqqdel&fwd=mq&uin=%2$s&fun=from3g", new Object[] { paramString, paramQQAppInterface.a() });
            try
            {
              paramQQAppInterface = HttpBaseUtil.a(paramQQAppInterface, "GET", new Bundle(), null).a;
              if (paramQQAppInterface.getStatusLine().getStatusCode() != 200) {
                continue;
              }
              paramQQAppInterface = new JSONObject(HttpBaseUtil.a(paramQQAppInterface));
              if (!paramQQAppInterface.has("ret")) {
                continue;
              }
              i1 = paramQQAppInterface.getInt("ret");
              if (i1 != 0) {
                continue;
              }
              i1 = 1;
            }
            catch (Exception paramQQAppInterface)
            {
              for (;;)
              {
                i1 = 0;
                continue;
                i1 = 0;
              }
            }
            if (i1 != 0) {
              break;
            }
            QQToast.a(paramContext.getApplicationContext(), paramContext.getResources().getString(2131364496), 0).a();
            return;
            i1 += 1;
            break label37;
            i1 += 1;
            break label111;
          }
          break;
        }
      }
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramString = new UinPair(paramQQAppInterface.a(), paramString);
    PublicAccountHandler localPublicAccountHandler = (PublicAccountHandler)paramQQAppInterface.a(11);
    if ((localPublicAccountHandler.a != null) && (localPublicAccountHandler.a.contains(paramString))) {
      localPublicAccountHandler.a.remove(paramString);
    }
    paramQQAppInterface = paramQQAppInterface.a().createEntityManager();
    paramQQAppInterface.b(paramString);
    paramQQAppInterface.a();
  }
  
  public static void b(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PublicAccountUtil", 2, "doVideoPlayRealtimeReport aid=" + paramString1 + ", vid=" + paramString2 + ", rtype=" + paramInt1 + ", rcode=" + paramInt2);
    }
    if ((TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString1))) {}
    label186:
    for (;;)
    {
      return;
      Object localObject = BaseApplicationImpl.a().a();
      if ((localObject != null) && ((localObject instanceof QQAppInterface))) {}
      for (localObject = (QQAppInterface)localObject;; localObject = null)
      {
        if (localObject == null) {
          break label186;
        }
        String str = ((AppInterface)localObject).a();
        if (TextUtils.isEmpty(str)) {
          break;
        }
        localObject = (TicketManager)((AppInterface)localObject).getManager(2);
        if (localObject == null) {
          break;
        }
        localObject = ((TicketManager)localObject).getSkey(str);
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break;
        }
        ThreadManager.a(new iga(paramString1, paramString2, paramInt1, str, (String)localObject, paramInt2), 5, null, true);
        return;
      }
    }
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface)
  {
    boolean bool = false;
    SharedPreferences localSharedPreferences = paramQQAppInterface.getApplication().getSharedPreferences("mobileQQ", 0);
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (o == -1) {
        o = localSharedPreferences.getInt(n + paramQQAppInterface.a(), 0);
      }
      if (o != 0) {
        bool = true;
      }
      return bool;
    }
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, String paramString)
  {
    boolean bool = false;
    int i1 = a(paramQQAppInterface, paramString);
    if ((i1 == -3) || (i1 == -4)) {
      bool = true;
    }
    return bool;
  }
  
  private static boolean b(String paramString1, String paramString2)
  {
    if (paramString1.length() != paramString2.length()) {
      return false;
    }
    int i1 = 0;
    for (;;)
    {
      if (i1 >= paramString2.length()) {
        break label53;
      }
      if ((paramString1.charAt(i1) != paramString2.charAt(i1)) && (paramString2.charAt(i1) != '?')) {
        break;
      }
      i1 += 1;
    }
    label53:
    return true;
  }
  
  protected static final void c(Activity paramActivity, QQAppInterface paramQQAppInterface, ProfileParams paramProfileParams)
  {
    if (jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null)
    {
      jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    }
    paramQQAppInterface = new igl(paramActivity, paramProfileParams, paramQQAppInterface);
    paramProfileParams = new igm(paramActivity, paramProfileParams);
    jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(paramActivity, 230);
    jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage(2131364481);
    jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setTitle(2131364602);
    jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton(2131367262, paramQQAppInterface);
    jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(2131364482, paramQQAppInterface);
    jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setOnCancelListener(paramProfileParams);
    if ((paramActivity != null) && (!paramActivity.isFinishing())) {}
    try
    {
      jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
      return;
    }
    catch (Exception paramActivity) {}
    jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
    jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    return;
  }
  
  private static void c(Intent paramIntent, Context paramContext, String paramString)
  {
    if (paramIntent == null) {
      paramIntent = new Intent(paramContext, QidianProfileCardActivity.class);
    }
    for (;;)
    {
      paramIntent.putExtra("AllInOne", new ProfileActivity.AllInOne(paramString, 78));
      paramIntent.putExtra("uin", paramString);
      paramContext.startActivity(paramIntent);
      return;
      paramIntent.setClassName(paramContext, QidianProfileCardActivity.class.getName());
    }
  }
  
  public static boolean c(QQAppInterface paramQQAppInterface, String paramString)
  {
    int i1 = a(paramQQAppInterface, paramString);
    return (i1 == -3) || (i1 == -4) || (i1 == -2);
  }
  
  private static boolean c(String paramString1, String paramString2)
  {
    boolean bool2 = true;
    int i4 = paramString1.length();
    int i3 = paramString2.length();
    int i5 = paramString2.indexOf("*");
    int i1;
    boolean bool1;
    switch (i5)
    {
    default: 
      i1 = 0;
      if (i1 < i5) {
        if (paramString1.charAt(i1) != paramString2.charAt(i1)) {
          bool1 = false;
        }
      }
      break;
    case -1: 
    case 0: 
      label72:
      do
      {
        do
        {
          return bool1;
          if (i4 != i3) {
            break;
          }
          bool1 = bool2;
        } while (i4 == 0);
        i1 = 0;
        for (;;)
        {
          bool1 = bool2;
          if (i1 >= i3) {
            break;
          }
          if (paramString1.charAt(i1) != paramString2.charAt(i1)) {
            return false;
          }
          i1 += 1;
        }
        return false;
        bool1 = bool2;
      } while (i3 == 1);
      i1 = 0;
      label139:
      if (i1 < i4) {
        if ((paramString1.charAt(i1) != paramString2.charAt(i5 + 1)) && (paramString2.charAt(i5 + 1) != '*')) {}
      }
      break;
    }
    for (int i2 = 1;; i2 = 0)
    {
      if (i2 == 0)
      {
        return false;
        i1 += 1;
        break label139;
      }
      bool1 = bool2;
      if (i1 == i4) {
        break label72;
      }
      return c(paramString1.substring(i1, i4), paramString2.substring(i5 + 1, i3));
      i1 += 1;
      break;
      return c(paramString1.substring(i5, i4), paramString2.substring(i5, i3));
      i1 = 0;
    }
  }
  
  public static void d(Activity paramActivity, QQAppInterface paramQQAppInterface, ProfileParams paramProfileParams)
  {
    if (a(paramActivity, paramProfileParams)) {
      return;
    }
    Intent localIntent = new Intent(paramActivity, AccountDetailActivity.class);
    localIntent.addFlags(268435456);
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("profile_params", paramProfileParams);
    localBundle.putString("pkg_name", paramActivity.getIntent().getStringExtra("pkg_name"));
    localIntent.putExtras(localBundle);
    a(paramActivity, paramQQAppInterface, paramProfileParams.c(), paramProfileParams.a(), localIntent);
  }
  
  public static boolean d(QQAppInterface paramQQAppInterface, String paramString)
  {
    return a(paramQQAppInterface, paramString) == -2;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\util\PublicAccountUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
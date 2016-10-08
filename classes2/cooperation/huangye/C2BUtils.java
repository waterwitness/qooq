package cooperation.huangye;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.biz.pubaccount.PublicAccountServlet;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.aio.PlusPanelUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountDetailInfoRequest;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import java.util.HashMap;
import java.util.Map;
import mqq.app.NewIntent;
import ycb;
import ycc;
import ycd;
import yce;
import ycf;
import ycg;

public class C2BUtils
{
  public static final String a = "com.tencent.mobile.qq.action.voicecall.failed";
  private static Map a;
  public static final String b = "from_where";
  public static final String c = "callHistoryPage";
  public static final String d = "callDetailPage";
  public static final String e = "publicAccountAIOMsg";
  public static final String f = "publicAccountAIOTitle";
  public static final String g = "publicAccountInfoCard";
  public static final String h = "huangye";
  public static final String i = "qrCodeConfirm";
  public static final String j = "openApi";
  public static final String k = "publicAccountList";
  public static final String l = "old_yuantong";
  public static final String m = "C2BUtilsObject";
  private static final String n = "C2BUtils";
  
  public C2BUtils()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static String a(String paramString)
  {
    if ((a != null) && (a.containsKey(paramString))) {
      return (String)a.get(paramString);
    }
    return null;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, String paramString)
  {
    ActionSheet localActionSheet = ActionSheet.a(paramContext);
    localActionSheet.c(2131368096);
    localActionSheet.d(2131367262);
    localActionSheet.a(new ycg(localActionSheet, paramQQAppInterface, paramContext, paramSessionInfo, paramString));
    localActionSheet.show();
  }
  
  private static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, Map paramMap)
  {
    NewIntent localNewIntent = new NewIntent(paramContext, PublicAccountServlet.class);
    localNewIntent.putExtra("cmd", "get_detail_info");
    mobileqq_mp.GetPublicAccountDetailInfoRequest localGetPublicAccountDetailInfoRequest = new mobileqq_mp.GetPublicAccountDetailInfoRequest();
    localGetPublicAccountDetailInfoRequest.versionInfo.set("6.5.5,3,2880");
    localGetPublicAccountDetailInfoRequest.version.set(1);
    localGetPublicAccountDetailInfoRequest.seqno.set(0);
    try
    {
      localGetPublicAccountDetailInfoRequest.uin.set((int)Long.parseLong(paramSessionInfo.jdField_a_of_type_JavaLangString));
      localNewIntent.putExtra("data", localGetPublicAccountDetailInfoRequest.toByteArray());
      localNewIntent.setObserver(new yce(paramQQAppInterface, paramContext, paramSessionInfo, paramMap));
      paramQQAppInterface.startServlet(localNewIntent);
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("curPageName", paramString);
    localHashMap.put("category", "");
    localHashMap.put("businessName", paramSessionInfo.d);
    localHashMap.put("operPosition", "");
    localHashMap.put("operation", "clickQQPhoneBtn");
    localHashMap.put("termType", "1");
    localHashMap.put("termVersion", "6.5.5");
    localHashMap.put("uin", paramSessionInfo.jdField_a_of_type_JavaLangString);
    localHashMap.put("cityName", "");
    StatisticCollector.a(BaseApplication.getContext()).a(paramQQAppInterface.a(), "actQQYellowpageEvt", true, 0L, 0L, localHashMap, null, true);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, AccountDetail paramAccountDetail)
  {
    ThreadManager.a(new ycf(paramQQAppInterface, paramAccountDetail), 5, null, false);
  }
  
  public static boolean a()
  {
    return Build.VERSION.SDK_INT >= 15;
  }
  
  public static boolean a(AppInterface paramAppInterface, Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    paramAppInterface = new Bundle();
    paramAppInterface.putString("invoke_cmd", "BusinessHandler_voiceCall");
    paramAppInterface.putString("businessName", paramString2);
    paramAppInterface.putString("uin", paramString1);
    paramAppInterface.putString("from_where", paramString3);
    paramString1 = new Intent(paramContext, HYBlankActivity.class);
    paramString1.putExtra("Bundle", paramAppInterface);
    paramString1.addFlags(268435456);
    paramContext.startActivity(paramString1);
    return true;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, Context paramContext, Bundle paramBundle)
  {
    SessionInfo localSessionInfo = new SessionInfo();
    localSessionInfo.jdField_a_of_type_Int = 1008;
    localSessionInfo.d = paramBundle.getString("businessName");
    localSessionInfo.jdField_a_of_type_JavaLangString = paramBundle.getString("uin");
    localSessionInfo.g = paramBundle.getString("directartificial");
    if (!a())
    {
      b(paramQQAppInterface, paramContext, localSessionInfo, "你手机版本过低，暂不支持企业电话！");
      return false;
    }
    a(paramQQAppInterface, localSessionInfo, paramBundle.getString("from_where"));
    HYIvrBusinessManager.a().a(paramQQAppInterface, localSessionInfo.jdField_a_of_type_JavaLangString, new ycd(paramQQAppInterface, paramContext, localSessionInfo));
    return true;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramQQAppInterface == null) || (paramString == null)) {
      return false;
    }
    paramQQAppInterface = (PublicAccountDataManager)paramQQAppInterface.getManager(55);
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.c(paramString);
      if ((paramQQAppInterface != null) && (paramQQAppInterface.extendType == 0)) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString)) || (!a()))
    {
      bool2 = bool1;
      if (QLog.isColorLevel())
      {
        QLog.d("C2BUtils", 2, "app is null or uin is empty");
        bool2 = bool1;
      }
      return bool2;
    }
    if (paramInt == 1008) {
      bool1 = HYIvrBusinessManager.a().a(paramQQAppInterface, paramString);
    }
    for (;;)
    {
      bool2 = bool1;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("C2BUtils", 2, "supportC2bCall : uin = " + paramString + ", isSupport = " + bool1);
      return bool1;
      bool1 = bool2;
      if (QLog.isColorLevel())
      {
        QLog.d("C2BUtils", 2, new Object[] { "uin " + paramString + " is not public account", paramString });
        bool1 = bool2;
      }
    }
  }
  
  public static boolean a(String paramString)
  {
    return true;
  }
  
  private static void b(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, String paramString)
  {
    Intent localIntent = new Intent("com.tencent.mobile.qq.action.voicecall.failed");
    localIntent.setPackage(paramQQAppInterface.a().getPackageName());
    localIntent.putExtra("uin", paramSessionInfo.jdField_a_of_type_JavaLangString);
    paramQQAppInterface.a().sendBroadcast(localIntent);
    if ((paramContext instanceof HYBlankActivity))
    {
      paramQQAppInterface = (HYBlankActivity)paramContext;
      if ((paramQQAppInterface != null) && (!paramQQAppInterface.a())) {
        paramQQAppInterface.b(paramString);
      }
      return;
    }
    try
    {
      paramQQAppInterface = new Dialog(paramContext, 2131558973);
      paramQQAppInterface.setContentView(2130903236);
      paramContext = (TextView)paramQQAppInterface.findViewById(2131297840);
      if (paramContext != null) {
        paramContext.setText("呼叫错误");
      }
      ((TextView)paramQQAppInterface.findViewById(2131296852)).setText(paramString);
      paramContext = (TextView)paramQQAppInterface.findViewById(2131297843);
      if (paramContext != null) {
        paramContext.setVisibility(8);
      }
      paramContext = (TextView)paramQQAppInterface.findViewById(2131297844);
      if (paramContext != null)
      {
        paramContext.setText(2131367263);
        paramContext.setOnClickListener(new ycb(paramQQAppInterface));
      }
      paramQQAppInterface.show();
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      paramQQAppInterface.getStackTrace();
      QLog.e("C2BUtils", 1, "showError|" + paramQQAppInterface.getMessage());
    }
  }
  
  private static void b(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, String paramString1, String paramString2, String paramString3)
  {
    if (paramString1 != null)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("c2b_session_id", paramString1);
      localHashMap.put("c2b_app_id", paramString2);
      localHashMap.put("c2b_user_info", paramString3);
      localHashMap.put("c2b_call_direct_artificial", paramSessionInfo.g);
      if ((a != null) && (a.containsKey(paramSessionInfo.jdField_a_of_type_JavaLangString)))
      {
        PlusPanelUtils.a(paramQQAppInterface, paramContext.getApplicationContext(), paramSessionInfo, true, "from_internal", localHashMap);
        return;
      }
      a(paramQQAppInterface, paramContext, paramSessionInfo, localHashMap);
      return;
    }
    b(paramQQAppInterface, paramContext, paramSessionInfo, "加载失败，请使用系统电话拨打商家客服。");
  }
  
  private static void b(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      HYIvrSessionIdManager.a().a(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString, new ycc(paramQQAppInterface, paramContext, paramSessionInfo));
      return;
    }
    b(paramQQAppInterface, paramContext, paramSessionInfo, "加载失败，请使用系统电话拨打商家客服。");
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\huangye\C2BUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.tencent.mobileqq.dating;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HotChatHandler;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.HotChatObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.CustomHandler;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;
import rgd;
import rge;
import rgf;
import rgg;
import tencent.im.oidb.hotchat.Common.WifiPOIInfo;

public class NearbyTransitActivity
  extends BaseActivity
  implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener, Handler.Callback
{
  public static final int a = 1;
  public static final String a = "NearbyTransitActivity";
  public static final int b = 2;
  public static long b = 0L;
  public static final String b = "加入热聊失败，请稍后再试。";
  public static final int c = 0;
  public static long c = 0L;
  public static final int d = 1;
  private static long jdField_d_of_type_Long = 0L;
  public static final int e = 2;
  public static final int f = 3;
  public static final int g = 4;
  public static final int h = 5;
  public static final int i = 6;
  public static final int j = 7;
  public static final int k = 8;
  public static final int l = 9;
  public static final int m = 10;
  public static final int n = 11;
  public static final int o = 100;
  public static final int q = 1;
  public static final int r = 2;
  public static final int s = 3;
  public static final int t = 4;
  public static final int u = 5;
  long jdField_a_of_type_Long;
  private HotChatObserver jdField_a_of_type_ComTencentMobileqqAppHotChatObserver;
  public QQProgressNotifier a;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  private String c;
  private String jdField_d_of_type_JavaLangString;
  private String e;
  protected int p;
  private int v;
  private int w;
  private int x;
  
  public NearbyTransitActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.b = true;
    this.jdField_a_of_type_ComTencentMobileqqAppHotChatObserver = new rge(this);
  }
  
  private void a()
  {
    DatingUtil.a("NearbyTransitActivity", new Object[] { "parseParams" });
    Intent localIntent = getIntent();
    Bundle localBundle = localIntent.getExtras();
    this.c = localBundle.getString("from");
    this.v = localBundle.getInt("action");
    this.e = localBundle.getString("params");
    if (this.v == 1) {
      this.jdField_d_of_type_JavaLangString = localIntent.getExtras().getString("hotnamecode");
    }
    if ("1".equals(localBundle.getString("onwall"))) {
      this.w |= 0x2;
    }
    if ("1".equals(localBundle.getString("nonelbs"))) {
      this.b = false;
    }
    if ("1".equals(localBundle.getString("fissile"))) {
      this.x = 1;
    }
    this.jdField_a_of_type_Long = localIntent.getLongExtra("enter_time", System.currentTimeMillis());
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = new QQProgressNotifier(this, 2130904317);
    this.p = getResources().getDimensionPixelSize(2131492908);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_MqqOsMqqHandler = new CustomHandler(Looper.getMainLooper(), this);
  }
  
  public static void a(Context paramContext, String paramString)
  {
    a("openNearbyTransitActivity", 0);
    long l1 = Math.abs(System.currentTimeMillis() - jdField_d_of_type_Long);
    if ((paramContext == null) || ((l1 >= 0L) && (l1 < 800L))) {
      return;
    }
    jdField_d_of_type_Long = System.currentTimeMillis();
    Intent localIntent = new Intent(paramContext, NearbyTransitActivity.class);
    localIntent.putExtra("from", "10002");
    localIntent.putExtra("action", 2);
    localIntent.putExtra("params", paramString);
    localIntent.putExtra("enter_time", System.currentTimeMillis());
    paramContext.startActivity(localIntent);
  }
  
  public static void a(Context paramContext, String paramString, int paramInt, HashMap paramHashMap)
  {
    a("openNearbyTransitActivity", 0);
    long l1 = Math.abs(System.currentTimeMillis() - jdField_d_of_type_Long);
    if ((paramContext == null) || ((l1 >= 0L) && (l1 < 800L)) || (paramHashMap == null)) {
      return;
    }
    jdField_d_of_type_Long = System.currentTimeMillis();
    String str1;
    String str2;
    label89:
    String str3;
    label109:
    String str4;
    label129:
    String str5;
    label149:
    String str6;
    label169:
    String str7;
    if (paramHashMap.containsKey("src_type"))
    {
      str1 = (String)paramHashMap.get("src_type");
      if (!paramHashMap.containsKey("from_type")) {
        break label342;
      }
      str2 = (String)paramHashMap.get("from_type");
      if (!paramHashMap.containsKey("from")) {
        break label349;
      }
      str3 = (String)paramHashMap.get("from");
      if (!paramHashMap.containsKey("version")) {
        break label356;
      }
      str4 = (String)paramHashMap.get("version");
      if (!paramHashMap.containsKey("onwall")) {
        break label363;
      }
      str5 = (String)paramHashMap.get("onwall");
      if (!paramHashMap.containsKey("nonelbs")) {
        break label370;
      }
      str6 = (String)paramHashMap.get("nonelbs");
      if (!paramHashMap.containsKey("fissile")) {
        break label377;
      }
      str7 = (String)paramHashMap.get("fissile");
      label189:
      if (!paramHashMap.containsKey("newly_created")) {
        break label384;
      }
    }
    label342:
    label349:
    label356:
    label363:
    label370:
    label377:
    label384:
    for (paramHashMap = (String)paramHashMap.get("newly_created");; paramHashMap = "")
    {
      Intent localIntent = new Intent(paramContext, NearbyTransitActivity.class);
      localIntent.putExtra("src_type", str1);
      localIntent.putExtra("from_type", str2);
      localIntent.putExtra("from", str3);
      localIntent.putExtra("version", str4);
      localIntent.putExtra("action", paramInt);
      localIntent.putExtra("hotnamecode", paramString);
      localIntent.putExtra("newly_created", paramHashMap);
      localIntent.putExtra("onwall", str5);
      localIntent.putExtra("nonelbs", str6);
      localIntent.putExtra("fissile", str7);
      localIntent.putExtra("enter_time", System.currentTimeMillis());
      paramContext.startActivity(localIntent);
      return;
      str1 = "";
      break;
      str2 = "";
      break label89;
      str3 = "";
      break label109;
      str4 = "";
      break label129;
      str5 = "";
      break label149;
      str6 = "";
      break label169;
      str7 = "";
      break label189;
    }
  }
  
  private void a(HotChatInfo paramHotChatInfo)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 4;
    localMessage.obj = HotChatInfo.createWifiPOIInfo(paramHotChatInfo);
    this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(localMessage);
  }
  
  public static void a(String paramString, int paramInt) {}
  
  private void a(String paramString1, String paramString2, String paramString3)
  {
    a("enterAIO", 1);
    Intent localIntent = new Intent(this, ChatActivity.class);
    localIntent.putExtra("uin", paramString1);
    localIntent.putExtra("uintype", 1);
    localIntent.putExtra("troop_uin", paramString2);
    localIntent.putExtra("uinname", paramString3);
    localIntent.addFlags(67108864);
    localIntent.putExtra("is_from_web", true);
    localIntent.putExtra("is_new_add", true);
    paramString1 = getIntent().getStringExtra("newly_created");
    if ((paramString1 != null) && ("1".equals(paramString1))) {}
    for (boolean bool = true;; bool = false)
    {
      localIntent.putExtra("param_newly_created_hot_chat", bool);
      localIntent.putExtra("hotnamecode", getIntent().getStringExtra("hotnamecode"));
      localIntent.putExtra("HOTCHAT_EXTRA_FLAG", this.w);
      if ("10002".equals(this.c))
      {
        localIntent.putExtra("abp_flag", true);
        localIntent.addFlags(268435456);
      }
      startActivity(localIntent);
      long l1 = System.currentTimeMillis() - this.jdField_a_of_type_Long;
      if (l1 > 0L) {
        a(this.app.a(), true, l1, 0);
      }
      finish();
      return;
    }
  }
  
  public static void a(String paramString, boolean paramBoolean, long paramLong, int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      NearbyUtils.a("NearbyTransitActivity", "reportResult", new Object[] { Boolean.valueOf(paramBoolean), Long.valueOf(paramLong), Integer.valueOf(paramInt) });
    }
    ThreadManager.b().post(new rgg(paramInt, paramString, paramBoolean, paramLong));
  }
  
  private boolean a(HotChatInfo paramHotChatInfo)
  {
    HotChatInfo localHotChatInfo = ((HotChatManager)this.app.getManager(59)).a();
    ReportController.b(this.app, "CliOper", "", "", "0X8004412", "0X8004412", 1, 0, "", "", "", "");
    if (localHotChatInfo == null)
    {
      a(paramHotChatInfo);
      return true;
    }
    if (TextUtils.equals(paramHotChatInfo.uuid, localHotChatInfo.uuid))
    {
      if (QLog.isColorLevel()) {
        QLog.d("NearbyTransitActivity", 2, "enter poi hotchat start aio, has joined");
      }
      a(paramHotChatInfo.troopUin, paramHotChatInfo.troopCode, paramHotChatInfo.name);
      return true;
    }
    a(paramHotChatInfo);
    return true;
  }
  
  private void b()
  {
    int i2 = 0;
    a("doAction", 1);
    DatingUtil.a("NearbyTransitActivity", new Object[] { "doAction", Boolean.valueOf(this.jdField_a_of_type_Boolean) });
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    Object localObject;
    int i1;
    label129:
    int i3;
    if (NetworkUtil.e(BaseApplication.getContext()))
    {
      this.app.a(this.jdField_a_of_type_ComTencentMobileqqAppHotChatObserver, true);
      if (this.v == 1)
      {
        localObject = (HotChatHandler)this.app.a(35);
        if ((localObject != null) && (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)))
        {
          if (!((HotChatHandler)localObject).a(this.jdField_d_of_type_JavaLangString, this.w, this.b)) {
            i2 = 1;
          }
          if (i2 == 0) {
            break label410;
          }
          i1 = 6;
        }
        for (;;)
        {
          i3 = i2;
          i2 = i1;
          i1 = i3;
          label139:
          if (i1 == 0) {
            break;
          }
          localObject = Message.obtain();
          ((Message)localObject).what = 1;
          ((Message)localObject).arg1 = i2;
          ((Message)localObject).obj = "加入热聊失败，请稍后再试。";
          label164:
          if (localObject == null) {
            break label408;
          }
          this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed((Message)localObject, 200L);
          return;
          if (localObject == null)
          {
            i1 = 9;
            i2 = 1;
          }
          else
          {
            i1 = 10;
            i2 = 1;
          }
        }
      }
      if ((this.v != 2) || (this.e == null)) {}
    }
    for (;;)
    {
      try
      {
        localObject = new JSONObject(this.e).getJSONObject("params");
        localHotChatInfo = HotChatInfo.createHotChat((JSONObject)localObject);
        if (localHotChatInfo == null) {
          break label428;
        }
        boolean bool = localHotChatInfo.isWifiHotChat;
        if (bool)
        {
          i1 = 1;
          i2 = 1;
          i3 = i1;
          i4 = i2;
        }
      }
      catch (JSONException localJSONException)
      {
        HotChatInfo localHotChatInfo;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("NearbyTransitActivity", 2, "", localJSONException);
        this.app.b(this.jdField_a_of_type_ComTencentMobileqqAppHotChatObserver);
        i3 = 7;
        int i4 = 1;
        continue;
      }
      try
      {
        if (((JSONObject)localObject).has("fissile"))
        {
          this.x = ((JSONObject)localObject).getInt("fissile");
          i4 = i2;
          i3 = i1;
        }
      }
      catch (Exception localException)
      {
        localException.fillInStackTrace();
        i3 = i1;
        i4 = i2;
        continue;
      }
      i1 = i4;
      i2 = i3;
      break label139;
      if (!a(localHotChatInfo))
      {
        i1 = 1;
        break label415;
        i2 = 1;
        i1 = 1;
        break label139;
        Message localMessage = Message.obtain();
        localMessage.what = 1;
        localMessage.arg1 = 2;
        localMessage.obj = getString(2131371469);
        break label164;
        localMessage = null;
        break label164;
        label408:
        break;
        label410:
        i1 = 1;
        break label129;
      }
      for (;;)
      {
        label415:
        i2 = i1;
        i1 = 1;
        break;
        i1 = 0;
      }
      label428:
      i1 = 8;
      i2 = 1;
    }
  }
  
  protected void a(Common.WifiPOIInfo paramWifiPOIInfo)
  {
    if (NetworkUtil.e(BaseApplication.getContext()))
    {
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(2);
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(5);
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(5, 200L);
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(2, 30000L);
      ThreadManager.a(new rgf(this, paramWifiPOIInfo), 5, null, true);
      return;
    }
    paramWifiPOIInfo = Message.obtain();
    paramWifiPOIInfo.what = 1;
    paramWifiPOIInfo.arg1 = 2;
    paramWifiPOIInfo.obj = getString(2131371469);
    this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(paramWifiPOIInfo);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    a("doOnCreate", 1);
    super.doOnCreate(paramBundle);
    a();
    if (this.v == 1)
    {
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(5, 800L);
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(2, 30000L);
    }
    ThreadManager.a().post(new rgd(this));
    return false;
  }
  
  protected void doOnDestroy()
  {
    DatingUtil.a("NearbyTransitActivity", new Object[] { "doOnDestroy" });
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    this.app.b(this.jdField_a_of_type_ComTencentMobileqqAppHotChatObserver);
    super.doOnDestroy();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    DatingUtil.a("NearbyTransitActivity", new Object[] { "handleMessage", Integer.valueOf(paramMessage.what) });
    switch (paramMessage.what)
    {
    }
    label224:
    do
    {
      return false;
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier != null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a();
      }
      long l1;
      if ((paramMessage.what == 2) || ((paramMessage.obj instanceof String)))
      {
        if (paramMessage.what == 2)
        {
          str1 = getString(2131371469);
          if ((paramMessage.obj instanceof String)) {
            str1 = (String)paramMessage.obj;
          }
          QQToast.a(BaseApplication.getContext(), str1, 0).b(this.p);
        }
      }
      else
      {
        this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
        this.app.b(this.jdField_a_of_type_ComTencentMobileqqAppHotChatObserver);
        l1 = System.currentTimeMillis() - this.jdField_a_of_type_Long;
        if (l1 > 0L)
        {
          str1 = this.app.a();
          if (paramMessage.what != 2) {
            break label224;
          }
        }
      }
      for (int i1 = 4;; i1 = paramMessage.arg1)
      {
        a(str1, false, l1, i1);
        finish();
        return false;
        str1 = "加入热聊失败，请稍后再试。";
        break;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier != null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a();
      }
      paramMessage = (Object[])paramMessage.obj;
      a((String)paramMessage[0], (String)paramMessage[1], (String)paramMessage[2]);
      this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
      this.app.b(this.jdField_a_of_type_ComTencentMobileqqAppHotChatObserver);
      finish();
      return false;
      a((Common.WifiPOIInfo)paramMessage.obj);
      return false;
    } while (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier == null);
    if (this.x == 1) {}
    for (String str1 = getString(2131371471);; str1 = getString(2131371470))
    {
      String str2 = str1;
      if (paramMessage.obj != null)
      {
        str2 = str1;
        if ((paramMessage.obj instanceof String))
        {
          str2 = (String)paramMessage.obj;
          NearbyUtils.a("NearbyTransitActivity", new Object[] { "handleMessage MSG_SHOW_LOADING ", str2 });
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a(0, str2, 0, this);
      return false;
    }
  }
  
  protected boolean onBackEvent()
  {
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    localMessage.arg1 = 3;
    this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(localMessage);
    return true;
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    paramDialogInterface = Message.obtain();
    paramDialogInterface.what = 1;
    paramDialogInterface.arg1 = 3;
    this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(paramDialogInterface);
  }
  
  public void onDismiss(DialogInterface paramDialogInterface) {}
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\dating\NearbyTransitActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
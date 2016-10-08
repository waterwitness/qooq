package com.tencent.open.agent;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.activity.GesturePWDUnlockActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBSInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.open.agent.util.AuthorityUtil;
import com.tencent.open.appcommon.OpensdkServlet;
import com.tencent.open.base.LogUtility;
import com.tencent.open.base.http.AvatarUpdateService;
import com.tencent.open.base.http.HttpBaseUtil;
import com.tencent.open.base.http.HttpImageDownloadAsyncTask.TaskCompleteCallback;
import com.tencent.open.data.SharedPrefs;
import com.tencent.open.model.AccountManage;
import com.tencent.open.settings.OpensdkPreference;
import com.tencent.open.util.HandlerPlus;
import com.tencent.protofile.getappinfo.GetAppInfoProto.GetAppinfoRequest;
import com.tencent.protofile.sdkauthorize.SdkAuthorize.AuthorizeRequest;
import com.tencent.protofile.sdkauthorize.SdkAuthorize.AuthorizeResponse;
import com.tencent.protofile.sdkauthorize.SdkAuthorize.GetAuthApiListRequest;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.Login;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.manager.WtloginManager;
import mqq.observer.SSOAccountObserver;
import oicq.wlogin_sdk.sharemem.WloginSimpleInfo;
import oicq.wlogin_sdk.tools.cryptor;
import org.json.JSONException;
import org.json.JSONObject;
import wpq;
import wpr;
import wps;
import wpt;
import wpv;
import wpw;
import wpy;
import wpz;
import wqa;
import wqf;
import wqg;

public class AuthorityActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, HttpImageDownloadAsyncTask.TaskCompleteCallback
{
  public static final String A = "agent_login";
  public static final String B = "agent_query_authority";
  protected static final int C = 2;
  public static final String C = "agent_authority";
  public static final String E = "internal_authority";
  public static final String F = "package_name";
  protected static final int a = 1;
  public static final long a = 16L;
  protected static final String a = "AuthorityActivity";
  protected static boolean a = false;
  public static final int b = 100044;
  public static final String b = "Authority_Report";
  public static final int c = 110405;
  public static final String c = "Authority_TimeCost";
  public static final int d = 1105030;
  protected static final String d = "AuthorityActivity";
  public static final int e = 110507;
  public static final String e = "isLogin";
  public static final int f = 110401;
  public static final String f = "accList";
  protected static final int g = 0;
  public static final String g = "last_account";
  protected static final int h = 1;
  public static final String h = "uin";
  protected static final int i = 2;
  public static final String i = "nick";
  protected static final int j = 3;
  public static final String j = "skey";
  protected static final int k = 4;
  public static final String k = "st_temp";
  protected static final int l = 5;
  public static final String l = "st_temp_key";
  protected static final int m = 6;
  protected static final int n = 7;
  public static final String n = "param_uin";
  protected static final int o = 3000;
  public static final String o;
  protected static final int p = 3001;
  protected static final String p = "ConnAuthSvr.get_auth_api_list";
  protected static final int q = 3002;
  protected static final String q = "ConnAuthSvr.sdk_auth_api";
  protected static final int r = 3003;
  protected static final String r = "ConnAuthSvr.get_app_info";
  protected static final int s = 3004;
  protected static final String s = "ConnAuthSvr.get_auth_api_list_emp";
  protected static final int t = 3005;
  protected static final String t = "ConnAuthSvr.sdk_auth_api_emp";
  protected static final int u = 1002;
  protected static final String u = "ConnAuthSvr.get_app_info_emp";
  protected static final int w = 100;
  public static String y;
  public int A;
  public int B;
  protected String D = "";
  protected float a;
  protected SharedPreferences a;
  protected Bundle a;
  protected Handler.Callback a;
  public Button a;
  protected TextView a;
  public QQProgressDialog a;
  public AuthorityActivity.AccountInfo a;
  public CardContainer a;
  public HandlerPlus a;
  public SdkAuthorize.AuthorizeResponse a;
  public OpenSDKAppInterface a;
  public Runnable a;
  ArrayList a;
  protected List a;
  protected WtloginManager a;
  protected SSOAccountObserver a;
  public long b;
  protected SharedPreferences b;
  public Runnable b;
  public boolean b;
  public long c;
  protected SharedPreferences c;
  public boolean c;
  protected long d;
  protected boolean d;
  public long e;
  public boolean e;
  public long f;
  public boolean f;
  public long g;
  public boolean g;
  public long h;
  public boolean h;
  public long i;
  public boolean i;
  public long j;
  public boolean j;
  public boolean k;
  public boolean l;
  public String m;
  private boolean m;
  public int v;
  public String v;
  public String w;
  public int x;
  protected String x;
  public int y;
  public int z;
  protected String z;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    o = AppConstants.bj + "qqconnect/";
    jdField_a_of_type_Boolean = true;
  }
  
  public AuthorityActivity()
  {
    this.jdField_x_of_type_Int = 6;
    this.jdField_a_of_type_MqqObserverSSOAccountObserver = new wpq(this);
    this.jdField_a_of_type_JavaLangRunnable = new wpw(this);
    this.jdField_a_of_type_AndroidOsHandler$Callback = new wqa(this);
    this.jdField_a_of_type_ComTencentOpenUtilHandlerPlus = new HandlerPlus(this.jdField_a_of_type_AndroidOsHandler$Callback);
    this.jdField_b_of_type_JavaLangRunnable = new wps(this);
  }
  
  public static Bitmap a(String paramString)
  {
    try
    {
      Object localObject = (HttpURLConnection)new URL(paramString).openConnection();
      ((HttpURLConnection)localObject).setDoInput(true);
      ((HttpURLConnection)localObject).connect();
      localObject = ((HttpURLConnection)localObject).getInputStream();
      Bitmap localBitmap = SafeBitmapFactory.decodeStream((InputStream)localObject);
      ((InputStream)localObject).close();
      return localBitmap;
    }
    catch (IOException paramString)
    {
      paramString.printStackTrace();
      return null;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      QLog.d("AuthorityActivity", 1, "-->getbitmap decodeStream oom, url = " + paramString);
      return null;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_AndroidWidgetTextView != null) && (this.jdField_x_of_type_JavaLangString != null))
    {
      localObject = this.jdField_x_of_type_JavaLangString;
      if (this.jdField_x_of_type_JavaLangString.length() > 12) {
        localObject = this.jdField_x_of_type_JavaLangString.substring(0, 12) + "...";
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(String.format(getResources().getString(2131369829), new Object[] { localObject }));
    }
    Object localObject = new WloginSimpleInfo();
    this.jdField_a_of_type_MqqManagerWtloginManager.GetBasicUserInfo(this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.jdField_a_of_type_JavaLangString, (WloginSimpleInfo)localObject);
    String str = new String(((WloginSimpleInfo)localObject)._nick);
    localObject = str;
    if (TextUtils.isEmpty(str)) {
      localObject = this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.jdField_a_of_type_JavaLangString;
    }
    this.jdField_a_of_type_ComTencentOpenAgentCardContainer.a("", (String)localObject, null, false);
    b();
  }
  
  public void a(int paramInt, String paramString)
  {
    Message localMessage = this.jdField_a_of_type_ComTencentOpenUtilHandlerPlus.obtainMessage();
    localMessage.what = 6;
    localMessage.arg1 = 3004;
    localMessage.obj = paramString;
    this.jdField_a_of_type_ComTencentOpenUtilHandlerPlus.sendMessage(localMessage);
  }
  
  public void a(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    paramString2 = this.jdField_a_of_type_ComTencentOpenUtilHandlerPlus.obtainMessage();
    paramString3 = new Bundle();
    paramString3.putInt("error", paramInt);
    paramString3.putString("response", paramString1);
    paramString3.putString("msg", null);
    paramString3.putString("detail", null);
    paramString2.setData(paramString3);
    paramString2.what = 7;
    this.jdField_a_of_type_ComTencentOpenUtilHandlerPlus.sendMessageDelayed(paramString2, 1000L);
    paramString1 = "0";
    if (paramInt != 0) {
      paramString1 = "1";
    }
    try
    {
      ReportCenter.a().a(this.jdField_m_of_type_JavaLangString, "", y, "1", "3", paramString1, true);
      return;
    }
    catch (Exception paramString1) {}
  }
  
  public void a(long paramLong)
  {
    Object localObject2 = new GetAppInfoProto.GetAppinfoRequest();
    this.jdField_v_of_type_Int = 2;
    ((GetAppInfoProto.GetAppinfoRequest)localObject2).client_id.set(paramLong);
    ((GetAppInfoProto.GetAppinfoRequest)localObject2).sdkp.set("android");
    if (Build.VERSION.RELEASE == null) {}
    for (Object localObject1 = "";; localObject1 = Build.VERSION.RELEASE)
    {
      ((GetAppInfoProto.GetAppinfoRequest)localObject2).os.set((String)localObject1);
      ((GetAppInfoProto.GetAppinfoRequest)localObject2).qqv.set(CommonDataAdapter.a().c());
      ((GetAppInfoProto.GetAppinfoRequest)localObject2).setHasFlag(true);
      NewIntent localNewIntent = new NewIntent(this, OpensdkServlet.class);
      localNewIntent.setWithouLogin(true);
      localNewIntent.putExtra("uin", this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.jdField_a_of_type_JavaLangString);
      byte[] arrayOfByte = ((GetAppInfoProto.GetAppinfoRequest)localObject2).toByteArray();
      localObject2 = "ConnAuthSvr.get_app_info";
      localObject1 = arrayOfByte;
      if (!this.j)
      {
        localObject1 = a(arrayOfByte);
        localObject2 = "ConnAuthSvr.get_app_info_emp";
      }
      localNewIntent.putExtra("data", (byte[])localObject1);
      localNewIntent.putExtra("cmd", (String)localObject2);
      localNewIntent.setObserver(new wpy(this));
      super.getAppRuntime().startServlet(localNewIntent);
      this.jdField_a_of_type_ComTencentOpenUtilHandlerPlus.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_ComTencentOpenUtilHandlerPlus.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 30000L);
      return;
    }
  }
  
  public void a(SdkAuthorize.GetAuthApiListRequest paramGetAuthApiListRequest)
  {
    if (this.jdField_a_of_type_MqqManagerWtloginManager == null) {
      this.jdField_a_of_type_MqqManagerWtloginManager = ((WtloginManager)this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.getManager(1));
    }
    this.j = false;
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext()) {
        if (((SimpleAccount)((Iterator)localObject).next()).getUin().equals(this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.jdField_a_of_type_JavaLangString)) {
          this.j = true;
        }
      }
    }
    NewIntent localNewIntent = new NewIntent(this, OpensdkServlet.class);
    localNewIntent.setWithouLogin(true);
    localNewIntent.putExtra("uin", this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.jdField_a_of_type_JavaLangString);
    byte[] arrayOfByte = paramGetAuthApiListRequest.toByteArray();
    String str = "ConnAuthSvr.get_auth_api_list";
    Object localObject = "g_a_a_l";
    paramGetAuthApiListRequest = arrayOfByte;
    if (!this.j)
    {
      if ((this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.jdField_a_of_type_ArrayOfByte == null) || (this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.jdField_a_of_type_ArrayOfByte.length == 0))
      {
        paramGetAuthApiListRequest = this.jdField_a_of_type_ComTencentOpenUtilHandlerPlus.obtainMessage();
        paramGetAuthApiListRequest.what = 6;
        paramGetAuthApiListRequest.arg1 = 3000;
        paramGetAuthApiListRequest.obj = getResources().getString(2131369833);
        this.jdField_a_of_type_ComTencentOpenUtilHandlerPlus.sendMessage(paramGetAuthApiListRequest);
        return;
      }
      paramGetAuthApiListRequest = a(arrayOfByte);
      str = "ConnAuthSvr.get_auth_api_list_emp";
      localObject = "g_a_a_l_emp";
    }
    localNewIntent.putExtra("data", paramGetAuthApiListRequest);
    localNewIntent.putExtra("cmd", str);
    this.jdField_v_of_type_Int = 0;
    localNewIntent.setObserver(new wpv(this));
    super.getAppRuntime().startServlet(localNewIntent);
    this.jdField_a_of_type_ComTencentOpenUtilHandlerPlus.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_ComTencentOpenUtilHandlerPlus.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 30000L);
    QLog.d("AuthorityActivity", 1, "send | cmd: " + (String)localObject + " | uin : *" + AuthorityUtil.a(this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.jdField_a_of_type_JavaLangString));
  }
  
  protected void a(String paramString)
  {
    if ((this.jdField_m_of_type_Boolean) || (TextUtils.isEmpty(paramString)) || (paramString.equals("0"))) {
      return;
    }
    WloginSimpleInfo localWloginSimpleInfo = new WloginSimpleInfo();
    this.jdField_a_of_type_MqqManagerWtloginManager.GetBasicUserInfo(paramString, localWloginSimpleInfo);
    Object localObject2 = new String(localWloginSimpleInfo._nick);
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = paramString;
    }
    this.jdField_m_of_type_JavaLangString = Long.toString(localWloginSimpleInfo._uin);
    paramString = this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a(paramString, (int)(58.0F * this.jdField_a_of_type_Float), true);
    if (paramString != null)
    {
      localObject2 = AuthorityUtil.a(this, paramString, 63, 63);
      paramString.recycle();
      this.jdField_a_of_type_ComTencentOpenAgentCardContainer.a(this.jdField_m_of_type_JavaLangString, (String)localObject1, (Bitmap)localObject2, false);
      return;
    }
    ThreadManager.b(new wpt(this, (String)localObject1));
  }
  
  public void a(String paramString, DialogInterface.OnClickListener paramOnClickListener)
  {
    paramString = DialogUtil.b(this, 230).setMessageWithUrl(paramString).setTitle(super.getString(2131368399)).setPositiveButton(17039370, paramOnClickListener);
    if (!super.isFinishing()) {
      paramString.show();
    }
  }
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    LogUtility.c("AuthorityActivity", "-->onTaskCompleted identifier = " + paramString + " - b = " + paramBitmap);
    if ((this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo != null) && (paramString.equals(this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.jdField_a_of_type_JavaLangString)) && (paramBitmap != null)) {
      runOnUiThread(new wqf(this, paramBitmap));
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (paramString2 != null))
    {
      SharedPreferences.Editor localEditor = this.jdField_c_of_type_AndroidContentSharedPreferences.edit();
      localEditor.putString(paramString1, paramString2);
      localEditor.commit();
    }
  }
  
  /* Error */
  public void a(String paramString1, String paramString2, long paramLong, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: new 665	java/io/File
    //   6: dup
    //   7: getstatic 158	com/tencent/open/agent/AuthorityActivity:o	Ljava/lang/String;
    //   10: invokespecial 666	java/io/File:<init>	(Ljava/lang/String;)V
    //   13: astore 7
    //   15: aload 7
    //   17: invokevirtual 669	java/io/File:exists	()Z
    //   20: ifne +118 -> 138
    //   23: aload 7
    //   25: invokevirtual 672	java/io/File:mkdirs	()Z
    //   28: pop
    //   29: new 138	java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   36: aload_1
    //   37: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: ldc_w 674
    //   43: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: aload_2
    //   47: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   53: invokestatic 678	com/tencent/mobileqq/utils/HexUtil:b	(Ljava/lang/String;)Ljava/lang/String;
    //   56: astore_2
    //   57: new 665	java/io/File
    //   60: dup
    //   61: aload 7
    //   63: aload_2
    //   64: invokespecial 681	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   67: astore_1
    //   68: aload_1
    //   69: invokevirtual 669	java/io/File:exists	()Z
    //   72: ifeq +8 -> 80
    //   75: aload_1
    //   76: invokevirtual 684	java/io/File:delete	()Z
    //   79: pop
    //   80: invokestatic 690	java/lang/System:currentTimeMillis	()J
    //   83: ldc2_w 379
    //   86: ldiv
    //   87: lstore 8
    //   89: new 692	java/io/DataOutputStream
    //   92: dup
    //   93: new 694	java/io/FileOutputStream
    //   96: dup
    //   97: aload_1
    //   98: invokespecial 697	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   101: invokespecial 700	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   104: astore_1
    //   105: aload_1
    //   106: lload 8
    //   108: lload_3
    //   109: ladd
    //   110: invokevirtual 703	java/io/DataOutputStream:writeLong	(J)V
    //   113: aload_1
    //   114: aload 5
    //   116: aload_2
    //   117: ldc_w 705
    //   120: invokevirtual 709	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   123: invokestatic 714	com/tencent/util/ThreeDes:a	([B[B)[B
    //   126: invokevirtual 717	java/io/DataOutputStream:write	([B)V
    //   129: aload_1
    //   130: ifnull +7 -> 137
    //   133: aload_1
    //   134: invokevirtual 718	java/io/DataOutputStream:close	()V
    //   137: return
    //   138: aload 7
    //   140: invokevirtual 721	java/io/File:isFile	()Z
    //   143: ifeq -114 -> 29
    //   146: aload 7
    //   148: invokevirtual 684	java/io/File:delete	()Z
    //   151: pop
    //   152: aload 7
    //   154: invokevirtual 672	java/io/File:mkdirs	()Z
    //   157: pop
    //   158: goto -129 -> 29
    //   161: astore_1
    //   162: aload 6
    //   164: astore_1
    //   165: aload_1
    //   166: ifnull -29 -> 137
    //   169: aload_1
    //   170: invokevirtual 718	java/io/DataOutputStream:close	()V
    //   173: return
    //   174: astore_1
    //   175: aload_1
    //   176: invokevirtual 247	java/io/IOException:printStackTrace	()V
    //   179: return
    //   180: astore_1
    //   181: aload_1
    //   182: invokevirtual 247	java/io/IOException:printStackTrace	()V
    //   185: return
    //   186: astore_2
    //   187: aconst_null
    //   188: astore_1
    //   189: aload_1
    //   190: ifnull +7 -> 197
    //   193: aload_1
    //   194: invokevirtual 718	java/io/DataOutputStream:close	()V
    //   197: aload_2
    //   198: athrow
    //   199: astore_1
    //   200: aload_1
    //   201: invokevirtual 247	java/io/IOException:printStackTrace	()V
    //   204: goto -7 -> 197
    //   207: astore_2
    //   208: goto -19 -> 189
    //   211: astore_2
    //   212: goto -47 -> 165
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	215	0	this	AuthorityActivity
    //   0	215	1	paramString1	String
    //   0	215	2	paramString2	String
    //   0	215	3	paramLong	long
    //   0	215	5	paramArrayOfByte	byte[]
    //   1	162	6	localObject	Object
    //   13	140	7	localFile	java.io.File
    //   87	20	8	l1	long
    // Exception table:
    //   from	to	target	type
    //   3	29	161	java/io/IOException
    //   29	80	161	java/io/IOException
    //   80	105	161	java/io/IOException
    //   138	158	161	java/io/IOException
    //   169	173	174	java/io/IOException
    //   133	137	180	java/io/IOException
    //   3	29	186	finally
    //   29	80	186	finally
    //   80	105	186	finally
    //   138	158	186	finally
    //   193	197	199	java/io/IOException
    //   105	129	207	finally
    //   105	129	211	java/io/IOException
  }
  
  public void a(String paramString1, String paramString2, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AuthorityActivity", 2, "-->loginSuccess--userAccount = *" + AuthorityUtil.a(paramString1));
    }
    if (!this.jdField_m_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentOpenUtilHandlerPlus.sendEmptyMessage(5);
    }
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
    paramString1 = "" + this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a(this.jdField_a_of_type_MqqManagerWtloginManager, paramString1);
    AuthorityActivity.AccountInfo localAccountInfo = new AuthorityActivity.AccountInfo(this);
    localAccountInfo.jdField_a_of_type_JavaLangString = paramString1;
    localAccountInfo.jdField_b_of_type_JavaLangString = paramString2;
    if (paramBundle != null)
    {
      localAccountInfo.jdField_a_of_type_ArrayOfByte = paramBundle.getByteArray("st_temp");
      localAccountInfo.jdField_b_of_type_ArrayOfByte = paramBundle.getByteArray("st_temp_key");
    }
    this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo = localAccountInfo;
    this.jdField_m_of_type_JavaLangString = paramString1;
    i();
  }
  
  protected void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AuthorityActivity", 2, "-->changeAccountActivity--isFirstLogin = " + paramBoolean);
    }
    int i1 = 0;
    if (this.jdField_a_of_type_JavaUtilList != null) {
      i1 = this.jdField_a_of_type_JavaUtilList.size();
    }
    Intent localIntent2;
    Intent localIntent1;
    if (i1 > 1)
    {
      localIntent2 = new Intent(this, SwitchAccountActivity.class);
      localIntent2.putExtra("key_req_src", 1);
      localIntent1 = localIntent2;
      if (this.jdField_m_of_type_JavaLangString != null)
      {
        localIntent2.putExtra("param_uin", this.jdField_m_of_type_JavaLangString);
        localIntent1 = localIntent2;
      }
    }
    for (;;)
    {
      super.startActivityForResult(localIntent1, 1);
      return;
      localIntent2 = new Intent(this, Login.class);
      localIntent2.putExtra("key_req_src", 1);
      localIntent1 = localIntent2;
      if (paramBoolean)
      {
        localIntent2.putExtra("is_first_login", true);
        localIntent1 = localIntent2;
      }
    }
  }
  
  protected boolean a(Intent paramIntent)
  {
    Object localObject;
    if (paramIntent != null) {
      localObject = paramIntent.getStringExtra("result_data");
    }
    try
    {
      localObject = HttpBaseUtil.a((String)localObject);
      AuthorityActivity.AccountInfo localAccountInfo = new AuthorityActivity.AccountInfo(this);
      localAccountInfo.jdField_a_of_type_JavaLangString = ((JSONObject)localObject).getString("uin");
      localAccountInfo.jdField_b_of_type_JavaLangString = ((JSONObject)localObject).getString("skey");
      localAccountInfo.jdField_a_of_type_ArrayOfByte = paramIntent.getByteArrayExtra("st_temp");
      localAccountInfo.jdField_b_of_type_ArrayOfByte = paramIntent.getByteArrayExtra("st_temp_key");
      if ((localAccountInfo.jdField_a_of_type_JavaLangString != null) && (localAccountInfo.jdField_b_of_type_JavaLangString != null)) {
        this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo = localAccountInfo;
      }
      if (this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo != null) {
        return true;
      }
    }
    catch (JSONException paramIntent)
    {
      for (;;)
      {
        a(3005, paramIntent.getMessage());
      }
    }
    return false;
  }
  
  /* Error */
  public byte[] a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 138	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   9: aload_1
    //   10: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13: ldc_w 674
    //   16: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: aload_2
    //   20: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   26: invokestatic 678	com/tencent/mobileqq/utils/HexUtil:b	(Ljava/lang/String;)Ljava/lang/String;
    //   29: astore_2
    //   30: new 665	java/io/File
    //   33: dup
    //   34: new 138	java/lang/StringBuilder
    //   37: dup
    //   38: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   41: getstatic 158	com/tencent/open/agent/AuthorityActivity:o	Ljava/lang/String;
    //   44: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: aload_2
    //   48: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   54: invokespecial 666	java/io/File:<init>	(Ljava/lang/String;)V
    //   57: astore_1
    //   58: aload_1
    //   59: invokevirtual 669	java/io/File:exists	()Z
    //   62: istore 6
    //   64: iload 6
    //   66: ifne +26 -> 92
    //   69: aload_3
    //   70: astore_2
    //   71: iconst_0
    //   72: ifeq +11 -> 83
    //   75: new 816	java/lang/NullPointerException
    //   78: dup
    //   79: invokespecial 817	java/lang/NullPointerException:<init>	()V
    //   82: athrow
    //   83: aload_2
    //   84: areturn
    //   85: astore_1
    //   86: aload_1
    //   87: invokevirtual 255	java/lang/Exception:printStackTrace	()V
    //   90: aconst_null
    //   91: areturn
    //   92: new 819	java/io/DataInputStream
    //   95: dup
    //   96: new 821	java/io/FileInputStream
    //   99: dup
    //   100: aload_1
    //   101: invokespecial 822	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   104: invokespecial 825	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   107: astore_1
    //   108: aload_1
    //   109: invokevirtual 828	java/io/DataInputStream:readLong	()J
    //   112: invokestatic 690	java/lang/System:currentTimeMillis	()J
    //   115: ldc2_w 379
    //   118: ldiv
    //   119: lcmp
    //   120: ifle +65 -> 185
    //   123: aload_1
    //   124: invokevirtual 831	java/io/DataInputStream:available	()I
    //   127: istore 5
    //   129: iload 5
    //   131: ifle +54 -> 185
    //   134: iload 5
    //   136: newarray <illegal type>
    //   138: astore 4
    //   140: aload_1
    //   141: aload 4
    //   143: invokevirtual 835	java/io/DataInputStream:read	([B)I
    //   146: pop
    //   147: aload_1
    //   148: invokevirtual 836	java/io/DataInputStream:close	()V
    //   151: aload 4
    //   153: aload_2
    //   154: ldc_w 705
    //   157: invokevirtual 709	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   160: invokestatic 838	com/tencent/util/ThreeDes:b	([B[B)[B
    //   163: astore_2
    //   164: aload_2
    //   165: astore_3
    //   166: aload_3
    //   167: astore_2
    //   168: aload_1
    //   169: ifnull -86 -> 83
    //   172: aload_1
    //   173: invokevirtual 836	java/io/DataInputStream:close	()V
    //   176: aload_3
    //   177: areturn
    //   178: astore_1
    //   179: aload_1
    //   180: invokevirtual 255	java/lang/Exception:printStackTrace	()V
    //   183: aload_3
    //   184: areturn
    //   185: aload_3
    //   186: astore_2
    //   187: aload_1
    //   188: ifnull -105 -> 83
    //   191: aload_1
    //   192: invokevirtual 836	java/io/DataInputStream:close	()V
    //   195: aconst_null
    //   196: areturn
    //   197: astore_1
    //   198: aload_1
    //   199: invokevirtual 255	java/lang/Exception:printStackTrace	()V
    //   202: aconst_null
    //   203: areturn
    //   204: astore_1
    //   205: aconst_null
    //   206: astore_1
    //   207: aload_3
    //   208: astore_2
    //   209: aload_1
    //   210: ifnull -127 -> 83
    //   213: aload_1
    //   214: invokevirtual 836	java/io/DataInputStream:close	()V
    //   217: aconst_null
    //   218: areturn
    //   219: astore_1
    //   220: aload_1
    //   221: invokevirtual 255	java/lang/Exception:printStackTrace	()V
    //   224: aconst_null
    //   225: areturn
    //   226: astore_2
    //   227: aconst_null
    //   228: astore_1
    //   229: aload_1
    //   230: ifnull +7 -> 237
    //   233: aload_1
    //   234: invokevirtual 836	java/io/DataInputStream:close	()V
    //   237: aload_2
    //   238: athrow
    //   239: astore_1
    //   240: aload_1
    //   241: invokevirtual 255	java/lang/Exception:printStackTrace	()V
    //   244: goto -7 -> 237
    //   247: astore_2
    //   248: goto -19 -> 229
    //   251: astore_2
    //   252: goto -45 -> 207
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	255	0	this	AuthorityActivity
    //   0	255	1	paramString1	String
    //   0	255	2	paramString2	String
    //   1	207	3	str	String
    //   138	14	4	arrayOfByte	byte[]
    //   127	8	5	i1	int
    //   62	3	6	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   75	83	85	java/lang/Exception
    //   172	176	178	java/lang/Exception
    //   191	195	197	java/lang/Exception
    //   2	64	204	java/io/IOException
    //   92	108	204	java/io/IOException
    //   213	217	219	java/lang/Exception
    //   2	64	226	finally
    //   92	108	226	finally
    //   233	237	239	java/lang/Exception
    //   108	129	247	finally
    //   134	164	247	finally
    //   108	129	251	java/io/IOException
    //   134	164	251	java/io/IOException
  }
  
  protected byte[] a(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte1 = this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.jdField_a_of_type_ArrayOfByte;
    byte[] arrayOfByte2 = this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.jdField_b_of_type_ArrayOfByte;
    paramArrayOfByte = cryptor.encrypt(paramArrayOfByte, 0, paramArrayOfByte.length, arrayOfByte2);
    arrayOfByte2 = new byte[arrayOfByte1.length + 4 + paramArrayOfByte.length];
    byte[] arrayOfByte3 = new byte[4];
    arrayOfByte3[0] = ((byte)(arrayOfByte1.length >> 24));
    arrayOfByte3[1] = ((byte)(arrayOfByte1.length >> 16));
    arrayOfByte3[2] = ((byte)(arrayOfByte1.length >> 8));
    arrayOfByte3[3] = ((byte)(arrayOfByte1.length >> 0));
    System.arraycopy(arrayOfByte3, 0, arrayOfByte2, 0, arrayOfByte3.length);
    System.arraycopy(arrayOfByte1, 0, arrayOfByte2, arrayOfByte3.length, arrayOfByte1.length);
    int i1 = arrayOfByte3.length;
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte2, arrayOfByte1.length + i1, paramArrayOfByte.length);
    return arrayOfByte2;
  }
  
  protected void b()
  {
    AvatarUpdateService.a().a(this, this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.b(this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.jdField_a_of_type_JavaLangString), this);
  }
  
  public void b(int paramInt, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    if (TextUtils.isEmpty(paramString)) {
      a(String.format(super.getString(2131369831), new Object[] { Integer.valueOf(paramInt) }), new wqg(this));
    }
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
    this.jdField_a_of_type_AndroidWidgetButton.setText(2131369833);
    d(paramInt, paramString);
  }
  
  public void b(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AuthorityActivity", 2, "-->setSdkResult--error = " + paramInt);
    }
    this.jdField_a_of_type_ComTencentProtofileSdkauthorizeSdkAuthorize$AuthorizeResponse = null;
    Intent localIntent = new Intent();
    localIntent.putExtra("key_error_code", paramInt);
    localIntent.putExtra("key_error_msg", paramString2);
    localIntent.putExtra("key_error_detail", paramString3);
    localIntent.putExtra("key_response", paramString1);
    super.setResult(-1, localIntent);
    super.finish();
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    if (paramInt != 0)
    {
      paramString1 = new HashMap();
      paramString1.put("appid", y);
      paramString1.put("errorcode", paramInt + "");
      paramString1.put("errormsg", paramString2);
      paramString1.put("errordetail", paramString3);
      paramString2 = AppNetConnInfo.getRecentNetworkInfo();
      if (paramString2 != null)
      {
        if (paramString2.getType() == 1) {
          paramString1.put("network", "wifi");
        }
      }
      else {
        StatisticCollector.a(this).a(this.jdField_m_of_type_JavaLangString, "connect_sso_authfail", false, 0L, 0L, paramString1, "");
      }
    }
    for (;;)
    {
      paramString1 = "0";
      if (paramInt != 0) {
        paramString1 = "1";
      }
      try
      {
        ReportCenter.a().a(this.jdField_m_of_type_JavaLangString, "", y, "1", "3", paramString1, true);
        return;
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
      }
      if (paramString2.getType() != 0) {
        break;
      }
      switch (paramString2.getSubtype())
      {
      case 7: 
      default: 
        paramString1.put("network", "2G");
        break;
      case 1: 
      case 2: 
      case 4: 
        paramString1.put("network", "2G");
        break;
      case 3: 
      case 5: 
      case 6: 
      case 8: 
        paramString1.put("network", "3G");
        break;
        try
        {
          ReportCenter.a().a(this.jdField_m_of_type_JavaLangString, "", y, "1", "6", "0", false);
        }
        catch (Exception paramString1)
        {
          paramString1.printStackTrace();
        }
      }
    }
  }
  
  public void b(String paramString)
  {
    SharedPreferences.Editor localEditor = this.jdField_b_of_type_AndroidContentSharedPreferences.edit();
    localEditor.putString(paramString, this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.jdField_a_of_type_JavaLangString);
    if ((TextUtils.isEmpty(y)) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.jdField_a_of_type_JavaLangString))) {
      return;
    }
    localEditor.putString(y + ":" + this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.jdField_a_of_type_JavaLangString, paramString);
    localEditor.commit();
  }
  
  public void b(String paramString1, String paramString2)
  {
    StatisticCollector.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface, paramString1, y + "|" + paramString2 + "|" + this.D);
  }
  
  public byte[] b(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.jdField_b_of_type_ArrayOfByte;
    return cryptor.decrypt(paramArrayOfByte, 0, paramArrayOfByte.length, arrayOfByte);
  }
  
  protected void c()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("appid", y);
    if (this.jdField_e_of_type_Boolean)
    {
      str = "notlogged";
      localHashMap.put("p1", str);
      if (!this.jdField_f_of_type_Boolean) {
        break label87;
      }
    }
    label87:
    for (String str = "auth";; str = "uauth")
    {
      localHashMap.put("p2", str);
      StatisticCollector.a(this).a(this.jdField_m_of_type_JavaLangString, "connect_sso_backto3rd", false, 0L, 0L, localHashMap, "");
      return;
      str = "logged";
      break;
    }
  }
  
  public void c(int paramInt, String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("ret", paramInt);
    localJSONObject.put("msg", paramString);
    if (TextUtils.isEmpty(paramString)) {}
    for (paramString = String.format(super.getString(2131369831), new Object[] { Integer.valueOf(paramInt) });; paramString = String.format(super.getString(2131369836), new Object[] { paramString, Integer.valueOf(paramInt) }))
    {
      a(paramString, new wpr(this, paramInt, localJSONObject));
      return;
    }
  }
  
  public void c(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AuthorityActivity", 2, "-->showLoginActivity--uin = *" + AuthorityUtil.a(this.jdField_m_of_type_JavaLangString));
    }
    Intent localIntent = new Intent(this, Login.class);
    if (paramString != null) {
      localIntent.putExtra("param_uin", paramString);
    }
    super.startActivityForResult(localIntent, 1);
  }
  
  protected void d()
  {
    this.jdField_v_of_type_JavaLangString = ((String)super.getText(2131369818));
    this.w = ((String)super.getText(2131369826));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131298890));
    this.jdField_a_of_type_ComTencentOpenAgentCardContainer = ((CardContainer)super.findViewById(2131298889));
    if (this.jdField_m_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentOpenAgentCardContainer.setTag(Boolean.valueOf(this.jdField_m_of_type_Boolean));
    }
    super.setLeftViewName(2131369828);
    if (this.jdField_m_of_type_Boolean)
    {
      super.setTitle(2131369824);
      this.w = ((String)super.getText(2131369825));
      this.jdField_v_of_type_JavaLangString = this.w;
      this.jdField_a_of_type_AndroidWidgetButton.setText(this.w);
      this.jdField_a_of_type_ComTencentOpenAgentCardContainer.findViewById(2131298882).setVisibility(8);
      this.jdField_a_of_type_ComTencentOpenAgentCardContainer.setVisibility(4);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      this.jdField_a_of_type_Float = super.getResources().getDisplayMetrics().density;
      return;
      super.setTitle(2131369823);
      setRightButton(2131369821, this);
    }
  }
  
  public void d(int paramInt, String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("appid", y);
    localHashMap.put("errorcode", paramInt + "");
    localHashMap.put("errormsg", paramString);
    paramString = AppNetConnInfo.getRecentNetworkInfo();
    if (paramString != null)
    {
      if (paramString.getType() != 1) {
        break label103;
      }
      localHashMap.put("network", "wifi");
    }
    for (;;)
    {
      StatisticCollector.a(this).a(this.jdField_m_of_type_JavaLangString, "connect_sso_authfail", false, 0L, 0L, localHashMap, "");
      return;
      label103:
      if (paramString.getType() == 0) {
        switch (paramString.getSubtype())
        {
        case 7: 
        default: 
          localHashMap.put("network", "2G");
          break;
        case 1: 
        case 2: 
        case 4: 
          localHashMap.put("network", "2G");
          break;
        case 3: 
        case 5: 
        case 6: 
        case 8: 
          localHashMap.put("network", "3G");
        }
      }
    }
  }
  
  protected void d(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AuthorityActivity", 2, "-->LocalAccountCache--userAccount = *" + AuthorityUtil.a(paramString));
    }
    SharedPreferences.Editor localEditor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
    localEditor.putString("last_account", paramString);
    Object localObject2 = new ArrayList();
    if (this.jdField_a_of_type_AndroidContentSharedPreferences.getString("accList", null) != null) {}
    for (Object localObject1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("accList", null).split(",");; localObject1 = null)
    {
      if (localObject1 != null)
      {
        int i2 = localObject1.length;
        int i1 = 0;
        while (i1 < i2)
        {
          ((ArrayList)localObject2).add(localObject1[i1]);
          i1 += 1;
        }
      }
      while (((ArrayList)localObject2).contains("")) {
        ((ArrayList)localObject2).remove("");
      }
      if (!((ArrayList)localObject2).contains(paramString)) {
        ((ArrayList)localObject2).add(paramString);
      }
      for (;;)
      {
        localObject1 = ((ArrayList)localObject2).iterator();
        for (paramString = ""; ((Iterator)localObject1).hasNext(); paramString = paramString + "," + (String)localObject2) {
          localObject2 = (String)((Iterator)localObject1).next();
        }
        ((ArrayList)localObject2).remove(paramString);
        ((ArrayList)localObject2).add(paramString);
      }
      localEditor.putString("accList", paramString);
      localEditor.commit();
      return;
    }
  }
  
  protected void e()
  {
    if (!a(null)) {
      g();
    }
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AuthorityActivity", 2, "-->login--");
    }
    this.jdField_e_of_type_Long = SystemClock.elapsedRealtime();
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
    if (!NetworkUtil.h(this))
    {
      this.jdField_a_of_type_ComTencentOpenUtilHandlerPlus.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_ComTencentOpenUtilHandlerPlus.post(this.jdField_a_of_type_JavaLangRunnable);
      return;
    }
    if (this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface == null)
    {
      a(false);
      return;
    }
    if (!this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.isLogin())
    {
      h();
      return;
    }
    if (this.z != null) {
      this.jdField_m_of_type_JavaLangString = this.z;
    }
    if (!this.jdField_a_of_type_MqqManagerWtloginManager.IsNeedLoginWithPasswd(this.jdField_m_of_type_JavaLangString, 16))
    {
      QLog.d("AuthorityActivity", 1, "send | cmd: g_t_n_p | uin : *" + AuthorityUtil.a(this.jdField_m_of_type_JavaLangString));
      this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.ssoGetTicketNoPasswd(this.jdField_m_of_type_JavaLangString, 4096, this.jdField_a_of_type_MqqObserverSSOAccountObserver);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(getResources().getString(2131369835));
      if ((!super.isFinishing()) && (!this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {}
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
        a("" + this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a(this.jdField_a_of_type_MqqManagerWtloginManager, this.jdField_m_of_type_JavaLangString));
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("AuthorityActivity", 2, "-->login(), mProgress.show();", localException);
          }
        }
      }
    }
    h();
  }
  
  protected void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AuthorityActivity", 2, "-->startAccountActivity--");
    }
    if (!SharedPrefs.a())
    {
      a(true);
      HashMap localHashMap = new HashMap();
      localHashMap.put("appid", y);
      localHashMap.put("p1", "notlogged");
      localHashMap.put("p2", "uauth");
      StatisticCollector.a(this).a(this.jdField_m_of_type_JavaLangString, "connect_sso_pageview", false, System.currentTimeMillis() - this.jdField_b_of_type_Long, 0L, localHashMap, "");
      return;
    }
    f();
  }
  
  protected void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AuthorityActivity", 2, "-->loginSSO--");
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(super.getString(2131369832));
    if ((!super.isFinishing()) && (!this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      if (this.jdField_m_of_type_JavaLangString != null) {
        if (this.jdField_a_of_type_MqqManagerWtloginManager.IsNeedLoginWithPasswd(this.jdField_m_of_type_JavaLangString, 16))
        {
          c(this.jdField_m_of_type_JavaLangString);
          return;
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AuthorityActivity", 2, "-->loginSSO(), mProgress.show();", localException);
        }
      }
      QLog.d("AuthorityActivity", 1, "send | cmd: g_t_n_p | uin :*" + AuthorityUtil.a(this.jdField_m_of_type_JavaLangString));
      this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.ssoGetTicketNoPasswd(this.jdField_m_of_type_JavaLangString, 4096, this.jdField_a_of_type_MqqObserverSSOAccountObserver);
      a("" + this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a(this.jdField_a_of_type_MqqManagerWtloginManager, this.jdField_m_of_type_JavaLangString));
      return;
    }
    a(true);
    this.jdField_e_of_type_Boolean = true;
    b("wtl_notlogged", "0");
  }
  
  public void i()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AuthorityActivity", 2, "-->queryAuthority");
    }
    this.g = SystemClock.elapsedRealtime();
    if (this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo == null)
    {
      this.jdField_a_of_type_ComTencentOpenUtilHandlerPlus.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_ComTencentOpenUtilHandlerPlus.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 30000L);
      return;
    }
    this.jdField_a_of_type_AndroidOsBundle = super.getIntent().getBundleExtra("key_params");
    SdkAuthorize.GetAuthApiListRequest localGetAuthApiListRequest = new SdkAuthorize.GetAuthApiListRequest();
    Object localObject = this.jdField_a_of_type_AndroidOsBundle.getString("client_id") + "";
    long l1 = 0L;
    try
    {
      long l2 = Long.parseLong((String)localObject);
      l1 = l2;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      String str;
      for (;;) {}
    }
    localGetAuthApiListRequest.client_id.set(l1);
    if (Build.VERSION.RELEASE == null)
    {
      localObject = "";
      localGetAuthApiListRequest.os.set((String)localObject);
      localGetAuthApiListRequest.qqv.set(CommonDataAdapter.a().c());
      str = this.jdField_a_of_type_AndroidOsBundle.getString("pf");
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      localGetAuthApiListRequest.pf.set((String)localObject);
      str = this.jdField_a_of_type_AndroidOsBundle.getString("scope");
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      localGetAuthApiListRequest.scope.set((String)localObject);
      localObject = this.jdField_a_of_type_AndroidOsBundle.getString("sdkp");
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        break label372;
      }
      localGetAuthApiListRequest.sdkp.set("android");
      label243:
      localObject = this.jdField_a_of_type_AndroidOsBundle.getString("sdkv");
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        break label383;
      }
      localGetAuthApiListRequest.sdkv.set("1.5.9");
    }
    for (;;)
    {
      localObject = this.jdField_a_of_type_AndroidOsBundle.getString("sign");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localGetAuthApiListRequest.sign.set((String)localObject);
        localObject = this.jdField_a_of_type_AndroidOsBundle.getString("time");
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          l1 = Long.parseLong((String)localObject);
          localGetAuthApiListRequest.time.set(l1);
        }
      }
      localGetAuthApiListRequest.need_pay.set(1);
      if (this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo != null) {
        localGetAuthApiListRequest.skey.set(this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.jdField_b_of_type_JavaLangString);
      }
      a(localGetAuthApiListRequest);
      return;
      localObject = Build.VERSION.RELEASE;
      break;
      label372:
      localGetAuthApiListRequest.sdkp.set((String)localObject);
      break label243;
      label383:
      localGetAuthApiListRequest.sdkv.set((String)localObject);
    }
  }
  
  public void j()
  {
    if (QLog.isColorLevel()) {
      QLog.i("AuthorityActivity", 2, "doAuthorize");
    }
    this.jdField_c_of_type_Long = System.currentTimeMillis();
    Object localObject1 = this.jdField_a_of_type_ComTencentOpenAgentCardContainer.a();
    this.jdField_a_of_type_AndroidOsBundle.putString("openapi", "");
    this.jdField_a_of_type_AndroidOsBundle.putBoolean("doAuthorize", true);
    this.jdField_a_of_type_AndroidOsBundle.putString("need_pay", "1");
    this.jdField_a_of_type_AndroidOsBundle.putString("appid_for_getting_config", this.jdField_a_of_type_AndroidOsBundle.getString("client_id") + "");
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(getResources().getString(2131369832));
    if ((!super.isFinishing()) && (!this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    }
    long l1 = Long.parseLong(y);
    Object localObject3 = new SdkAuthorize.AuthorizeRequest();
    ((SdkAuthorize.AuthorizeRequest)localObject3).client_id.set(l1);
    ((SdkAuthorize.AuthorizeRequest)localObject3).need_pay.set(1);
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (CardContainer.Permission)((Iterator)localObject1).next();
      if (((CardContainer.Permission)localObject2).a > 0) {
        ((SdkAuthorize.AuthorizeRequest)localObject3).openapi.add(Integer.valueOf(((CardContainer.Permission)localObject2).b));
      }
    }
    if (Build.VERSION.RELEASE == null)
    {
      localObject1 = "";
      ((SdkAuthorize.AuthorizeRequest)localObject3).os.set((String)localObject1);
      ((SdkAuthorize.AuthorizeRequest)localObject3).qqv.set(CommonDataAdapter.a().c());
      localObject2 = this.jdField_a_of_type_AndroidOsBundle.getString("pf");
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "openmobile_android";
      }
      ((SdkAuthorize.AuthorizeRequest)localObject3).pf.set((String)localObject1);
      localObject1 = this.jdField_a_of_type_AndroidOsBundle.getString("sdkp");
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        break label576;
      }
      ((SdkAuthorize.AuthorizeRequest)localObject3).sdkp.set("android");
      label315:
      localObject1 = this.jdField_a_of_type_AndroidOsBundle.getString("sdkv");
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        break label587;
      }
      ((SdkAuthorize.AuthorizeRequest)localObject3).sdkv.set("1.5.9");
      label343:
      ((SdkAuthorize.AuthorizeRequest)localObject3).response_type.set("token");
      localObject1 = this.jdField_a_of_type_AndroidOsBundle.getString("sign");
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        ((SdkAuthorize.AuthorizeRequest)localObject3).sign.set((String)localObject1);
        localObject1 = this.jdField_a_of_type_AndroidOsBundle.getString("time");
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          l1 = Long.parseLong((String)localObject1);
          ((SdkAuthorize.AuthorizeRequest)localObject3).time.set(l1);
        }
      }
      localObject1 = this.jdField_a_of_type_AndroidOsBundle.keySet();
      ((Set)localObject1).remove("sdkp");
      ((Set)localObject1).remove("sign");
      ((Set)localObject1).remove("sdkv");
      ((Set)localObject1).remove("sign");
      ((Set)localObject1).remove("time");
      localObject2 = new StringBuffer();
      localObject4 = ((Set)localObject1).iterator();
      label486:
      if (!((Iterator)localObject4).hasNext()) {
        break label604;
      }
      localObject5 = (String)((Iterator)localObject4).next();
      localObject1 = this.jdField_a_of_type_AndroidOsBundle.get((String)localObject5);
      if (localObject1 == null) {
        break label598;
      }
    }
    label576:
    label587:
    label598:
    for (localObject1 = localObject1.toString();; localObject1 = "")
    {
      ((StringBuffer)localObject2).append((String)localObject5 + "=" + URLEncoder.encode((String)localObject1) + "&");
      break label486;
      localObject1 = Build.VERSION.RELEASE;
      break;
      ((SdkAuthorize.AuthorizeRequest)localObject3).sdkp.set((String)localObject1);
      break label315;
      ((SdkAuthorize.AuthorizeRequest)localObject3).sdkv.set((String)localObject1);
      break label343;
    }
    label604:
    if (((StringBuffer)localObject2).length() > 0)
    {
      ((StringBuffer)localObject2).delete(((StringBuffer)localObject2).length() - 1, ((StringBuffer)localObject2).length());
      ((SdkAuthorize.AuthorizeRequest)localObject3).passData.set(((StringBuffer)localObject2).toString());
    }
    ((SdkAuthorize.AuthorizeRequest)localObject3).skey.set(this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.jdField_b_of_type_JavaLangString);
    this.jdField_v_of_type_Int = 1;
    Object localObject5 = new NewIntent(this, OpensdkServlet.class);
    ((NewIntent)localObject5).setWithouLogin(true);
    ((NewIntent)localObject5).putExtra("uin", this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.jdField_a_of_type_JavaLangString);
    Object localObject4 = ((SdkAuthorize.AuthorizeRequest)localObject3).toByteArray();
    localObject3 = "ConnAuthSvr.sdk_auth_api";
    Object localObject2 = "s_a_a";
    localObject1 = localObject4;
    if (!this.j)
    {
      localObject1 = a((byte[])localObject4);
      localObject3 = "ConnAuthSvr.sdk_auth_api_emp";
      localObject2 = "s_a_a_emp";
    }
    ((NewIntent)localObject5).putExtra("data", (byte[])localObject1);
    ((NewIntent)localObject5).putExtra("cmd", (String)localObject3);
    ((NewIntent)localObject5).setObserver(new wpz(this));
    super.getAppRuntime().startServlet((NewIntent)localObject5);
    this.jdField_a_of_type_ComTencentOpenUtilHandlerPlus.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_ComTencentOpenUtilHandlerPlus.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 30000L);
    QLog.d("AuthorityActivity", 1, "send | cmd: " + (String)localObject2 + " | uin : *" + AuthorityUtil.a(this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.jdField_a_of_type_JavaLangString));
    if (QLog.isColorLevel()) {
      QLog.d("SDKQQAgentPref", 2, "AuthorSwitch_AGENT:" + SystemClock.elapsedRealtime());
    }
  }
  
  protected void k()
  {
    this.i = true;
    this.jdField_a_of_type_ComTencentOpenUtilHandlerPlus.postDelayed(this.jdField_b_of_type_JavaLangRunnable, 500L);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AuthorityActivity", 2, "--onActivityResult, requestCode: " + paramInt1 + " | resultCode:" + paramInt2 + " | data: " + paramIntent);
    }
    if (paramInt1 == 100) {
      if (paramInt2 == -1)
      {
        if (paramIntent != null) {
          this.z = paramIntent.getStringExtra("uin");
        }
        e();
      }
    }
    do
    {
      do
      {
        return;
        super.setResult(0);
        super.finish();
        c();
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
        }
        if (paramInt2 == 0)
        {
          if (TextUtils.isEmpty(this.jdField_m_of_type_JavaLangString))
          {
            super.setResult(0, paramIntent);
            super.finish();
            c();
          }
          this.jdField_f_of_type_Long = SystemClock.elapsedRealtime();
          LogUtility.c("Authority_TimeCost", "<TimeStamp> login cost : " + (this.jdField_f_of_type_Long - this.jdField_e_of_type_Long));
          return;
        }
      } while (-1 != paramInt2);
      this.jdField_f_of_type_Long = SystemClock.elapsedRealtime();
      LogUtility.c("Authority_TimeCost", "<TimeStamp> login cost : " + (this.jdField_f_of_type_Long - this.jdField_e_of_type_Long));
      this.jdField_a_of_type_ComTencentProtofileSdkauthorizeSdkAuthorize$AuthorizeResponse = null;
      this.jdField_c_of_type_Boolean = a(paramIntent);
    } while (!jdField_a_of_type_Boolean);
    this.jdField_m_of_type_JavaLangString = paramIntent.getStringExtra("last_account");
    boolean bool = paramIntent.getBooleanExtra("isLogin", false);
    Object localObject = new WloginSimpleInfo();
    if (this.jdField_a_of_type_MqqManagerWtloginManager != null)
    {
      this.jdField_a_of_type_MqqManagerWtloginManager.GetBasicUserInfo(this.jdField_m_of_type_JavaLangString, (WloginSimpleInfo)localObject);
      this.jdField_m_of_type_JavaLangString = Long.toString(((WloginSimpleInfo)localObject)._uin);
    }
    this.jdField_a_of_type_ComTencentOpenAgentCardContainer.a(1);
    a(this.jdField_m_of_type_JavaLangString);
    if (bool) {
      d(this.jdField_m_of_type_JavaLangString);
    }
    localObject = paramIntent.getBundleExtra("ssobundle");
    if (localObject != null)
    {
      paramIntent = ((Bundle)localObject).getByteArray("st_temp");
      localObject = ((Bundle)localObject).getByteArray("st_temp_key");
      if ((paramIntent != null) && (localObject != null))
      {
        this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.jdField_a_of_type_ArrayOfByte = paramIntent;
        this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.jdField_b_of_type_ArrayOfByte = ((byte[])localObject);
      }
    }
    this.jdField_a_of_type_ComTencentOpenUtilHandlerPlus.sendEmptyMessage(5);
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
    i();
  }
  
  public void onBackPressed()
  {
    if ((this.jdField_d_of_type_Boolean) && (this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo != null)) {}
    super.setResult(0);
    super.finish();
    c();
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.leftView)
    {
      super.setResult(0);
      super.finish();
      c();
    }
    do
    {
      return;
      if (paramView == this.rightViewText)
      {
        this.jdField_a_of_type_ComTencentOpenUtilHandlerPlus.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
        if (this.i)
        {
          this.i = false;
          this.jdField_a_of_type_AndroidWidgetButton.setText(this.jdField_v_of_type_JavaLangString);
        }
        HashMap localHashMap = new HashMap();
        localHashMap.put("appid", y);
        localHashMap.put("p1", "logged");
        localHashMap.put("p2", "uauth");
        paramView = "0";
        if (this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo != null) {
          paramView = this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.jdField_a_of_type_JavaLangString + "";
        }
        StatisticCollector.a(this).a(paramView, "connect_sso_change", false, 0L, 0L, localHashMap, "");
        ReportCenter.a().a(this.jdField_m_of_type_JavaLangString, "", y, "1000", "200", "0", false);
        a(false);
        this.l = true;
        return;
      }
    } while (paramView != this.jdField_a_of_type_AndroidWidgetButton);
    if (QLog.isColorLevel()) {
      QLog.d("AuthorityActivity", 2, "<user:>authorize btn is clicked.");
    }
    long l1 = System.currentTimeMillis();
    try
    {
      if (l1 - this.jdField_d_of_type_Long < 500L) {
        return;
      }
    }
    finally {}
    this.jdField_d_of_type_Long = l1;
    this.jdField_a_of_type_ComTencentOpenUtilHandlerPlus.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    if (!NetworkUtil.h(this))
    {
      this.jdField_a_of_type_ComTencentOpenUtilHandlerPlus.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_ComTencentOpenUtilHandlerPlus.post(this.jdField_a_of_type_JavaLangRunnable);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
    if ((this.k) || (this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo == null))
    {
      f();
      return;
    }
    if (this.jdField_v_of_type_Int == 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(super.getString(2131369835));
      if ((!super.isFinishing()) && (!this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      }
      i();
      return;
    }
    if (this.jdField_a_of_type_AndroidWidgetButton.getText().equals(super.getString(2131369833)))
    {
      f();
      return;
    }
    if (this.jdField_a_of_type_ComTencentProtofileSdkauthorizeSdkAuthorize$AuthorizeResponse != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SDKQQAgentPref", 2, "ClickAuthButton: " + SystemClock.elapsedRealtime());
      }
      paramView = this.jdField_a_of_type_ComTencentOpenUtilHandlerPlus.obtainMessage();
      paramView.what = 1;
      paramView.obj = this.jdField_a_of_type_ComTencentProtofileSdkauthorizeSdkAuthorize$AuthorizeResponse;
      this.jdField_a_of_type_ComTencentOpenUtilHandlerPlus.sendMessage(paramView);
      this.jdField_a_of_type_ComTencentProtofileSdkauthorizeSdkAuthorize$AuthorizeResponse = null;
    }
    for (;;)
    {
      ReportCenter.a().a(this.jdField_m_of_type_JavaLangString, "", y, "1", "2", "0", false);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("SDKQQAgentPref", 2, "ClickAuthButton -- doAuthorize(): " + SystemClock.elapsedRealtime());
      }
      j();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (QLog.isColorLevel()) {
      QLog.d("AuthorityActivity", 2, "-->onCreate--");
    }
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    super.setContentView(2130903512);
    if (!(super.getAppRuntime() instanceof OpenSDKAppInterface)) {
      return;
    }
    this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface = ((OpenSDKAppInterface)super.getAppRuntime());
    this.jdField_a_of_type_AndroidOsBundle = super.getIntent().getBundleExtra("key_params");
    y = this.jdField_a_of_type_AndroidOsBundle.getString("client_id");
    this.jdField_m_of_type_Boolean = super.getIntent().getBooleanExtra("internal_authority", false);
    String str2;
    String str1;
    Object localObject;
    if (this.jdField_m_of_type_Boolean)
    {
      this.jdField_m_of_type_JavaLangString = this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.getAccount();
      str2 = System.currentTimeMillis() / 1000L + "";
      str1 = this.jdField_a_of_type_AndroidOsBundle.getString("package_name");
      localObject = this.jdField_a_of_type_AndroidOsBundle.getString("sign");
      str1 = str1 + "_" + ((String)localObject).replace(":", "").toLowerCase() + "_" + str2;
    }
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.update(str1.getBytes());
      str1 = HexUtil.a(localMessageDigest.digest());
      localObject = str1;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      try
      {
        for (;;)
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
          if (this.jdField_x_of_type_JavaLangString != null) {
            this.jdField_a_of_type_ComTencentOpenAgentCardContainer.a(this.jdField_x_of_type_JavaLangString, null);
          }
          if (Build.VERSION.SDK_INT <= 10) {
            break;
          }
          i1 = 4;
          this.jdField_a_of_type_AndroidContentSharedPreferences = super.getSharedPreferences("accountList", i1);
          localObject = super.getIntent().getStringExtra("key_action");
          this.jdField_a_of_type_MqqManagerWtloginManager = ((WtloginManager)this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.getManager(1));
          if ((!this.jdField_m_of_type_Boolean) && (!"action_login".equals(localObject))) {
            break label636;
          }
          jdField_a_of_type_Boolean = true;
          this.jdField_b_of_type_Boolean = false;
          localObject = super.getAppRuntime().getAccount();
          if ((this.jdField_m_of_type_Boolean) || (!GesturePWDUtils.getJumpLock(this, (String)localObject)) || (GesturePWDUtils.getAppForground(this))) {
            break label628;
          }
          if (QLog.isColorLevel()) {
            QLog.d("AuthorityActivity", 2, "-->onCreate--has gesture password, will start unlock activity");
          }
          this.z = ((String)localObject);
          paramBundle = new Intent(this, GesturePWDUnlockActivity.class);
          paramBundle.putExtra("key_gesture_from_authority", true);
          super.startActivityForResult(paramBundle, 100);
          return;
          localNoSuchAlgorithmException = localNoSuchAlgorithmException;
          localNoSuchAlgorithmException.printStackTrace();
        }
        localObject = this;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          int i1;
          if (QLog.isColorLevel())
          {
            QLog.e("AuthorityActivity", 2, "-->onCreate--mProgress.show() ", localException);
            continue;
            i1 = 0;
          }
        }
      }
    }
    this.jdField_a_of_type_AndroidOsBundle.putString("sign", (String)localObject);
    this.jdField_a_of_type_AndroidOsBundle.putString("time", str2);
    AccountManage.a().a();
    this.jdField_a_of_type_JavaUtilList = SharedPrefs.a();
    if (this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.isLogin()) {
      this.jdField_m_of_type_JavaLangString = this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.getAccount();
    }
    if ((this.jdField_m_of_type_JavaLangString == null) && (this.jdField_a_of_type_JavaUtilList != null)) {
      this.jdField_m_of_type_JavaLangString = ((String)this.jdField_a_of_type_JavaUtilList.get(0));
    }
    d();
    this.jdField_x_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("oauth_app_name");
    this.D = this.jdField_a_of_type_AndroidOsBundle.getString("sdkv");
    this.jdField_b_of_type_AndroidContentSharedPreferences = OpensdkPreference.a(this, "uin_openid_store");
    this.jdField_c_of_type_AndroidContentSharedPreferences = OpensdkPreference.a(this, "openid_encrytoken");
    if (isChild())
    {
      localObject = getParent();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog((Context)localObject, super.getTitleBarHeight());
    }
    label628:
    if (paramBundle == null) {
      e();
    }
    for (;;)
    {
      label636:
      this.jdField_a_of_type_ComTencentOpenAgentCardContainer.a(1);
      ReportCenter.a().a(this.jdField_m_of_type_JavaLangString, "", y, "1", "1", "0", false);
      return;
      if (!TextUtils.isEmpty(this.jdField_m_of_type_JavaLangString)) {
        a("" + this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a(this.jdField_a_of_type_MqqManagerWtloginManager, this.jdField_m_of_type_JavaLangString));
      }
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    if (QLog.isColorLevel()) {
      QLog.d("AuthorityActivity", 2, "-->onDestroy--");
    }
  }
  
  protected void onPause()
  {
    super.onPause();
    this.jdField_b_of_type_Long = 0L;
    this.j = false;
  }
  
  protected void onResume()
  {
    super.onResume();
    this.l = false;
    if (QLog.isColorLevel()) {
      QLog.d("AuthorityActivity", 2, "-->onResume-- SDKQQAgentPref|FirstLaunch_AGENT:" + SystemClock.elapsedRealtime());
    }
    if (this.jdField_b_of_type_Long == 0L) {
      this.jdField_b_of_type_Long = System.currentTimeMillis();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\open\agent\AuthorityActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
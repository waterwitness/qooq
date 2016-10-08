package com.tencent.mobileqq.activity.qwallet;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.util.CommonUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.qwallet.plugin.QWalletPayProgressDialog;
import org.json.JSONException;
import org.json.JSONObject;

public class TenpayJumpActivity
  extends BaseActivity
{
  public static final int a = 70010;
  public static final String a = "tenpay";
  private Context jdField_a_of_type_AndroidContentContext;
  private QWalletPayProgressDialog jdField_a_of_type_CooperationQwalletPluginQWalletPayProgressDialog;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private String c;
  private String d;
  private String e;
  private String f;
  private String g;
  private String h;
  private String i;
  private String j;
  private String k;
  
  public TenpayJumpActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private void a(String paramString1, String paramString2)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("userId", this.jdField_b_of_type_JavaLangString);
      localJSONObject.put("viewTag", paramString1);
      localJSONObject.put("comeForm", this.jdField_b_of_type_Int);
      localJSONObject.put("appInfo", this.g);
      localJSONObject.put("extra_data", paramString2);
      PayBridgeActivity.tenpay(this, localJSONObject.toString(), 5, "0");
      return;
    }
    catch (JSONException paramString1)
    {
      a(-1, null);
      paramString1.printStackTrace();
      return;
    }
    catch (Exception paramString1)
    {
      a(-1, null);
      paramString1.printStackTrace();
    }
  }
  
  public int a(Context paramContext)
  {
    try
    {
      int m = paramContext.getResources().getDimensionPixelSize(2131492908);
      float f1 = paramContext.getResources().getDisplayMetrics().density;
      return m - (int)(f1 * 5.0F);
    }
    catch (Exception paramContext) {}
    return 0;
  }
  
  public String a(String paramString1, String paramString2, String paramString3)
  {
    if ((TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3)) || (TextUtils.isEmpty(paramString1))) {}
    int m;
    int i1;
    do
    {
      return "";
      m = paramString1.indexOf(paramString2);
      i1 = paramString2.length() + m;
      int n = paramString1.indexOf(paramString3, i1);
      m = n;
      if (n == -1) {
        m = paramString1.length();
      }
    } while ((i1 == -1) || (i1 >= paramString1.length()) || (m == -1));
    return paramString1.substring(i1, m);
  }
  
  protected void a()
  {
    this.jdField_a_of_type_CooperationQwalletPluginQWalletPayProgressDialog = new QWalletPayProgressDialog(this);
    this.jdField_a_of_type_CooperationQwalletPluginQWalletPayProgressDialog.show();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      int m = this.h.indexOf("ac=");
      String str2 = this.h.substring(m + 3);
      m = str2.indexOf("&");
      String str1 = str2;
      if (m > 0) {
        str1 = str2.substring(0, m);
      }
      localJSONObject.put("auth_code", str1);
    }
    catch (JSONException localJSONException)
    {
      for (;;) {}
    }
    a("verifyqrcode", localJSONObject.toString());
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    if (paramBundle == null) {
      new Bundle();
    }
    paramBundle = new JSONObject();
    try
    {
      paramBundle.put("resultCode", paramInt);
      Intent localIntent = new Intent();
      localIntent.putExtra("callbackSn", this.f);
      localIntent.putExtra("PayInvokerId", 5);
      localIntent.putExtra("result", paramBundle.toString());
      setResult(-1, localIntent);
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  public void a(CharSequence paramCharSequence)
  {
    if (!isFinishing()) {
      QQToast.a(this, paramCharSequence, 0).b(a(this.jdField_a_of_type_AndroidContentContext));
    }
  }
  
  public void a(String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, int paramInt2, String paramString5)
  {
    paramString5 = new StringBuilder();
    paramString5.append("Tenpay_mqq");
    paramString5.append("|");
    paramString5.append(paramString1);
    paramString5.append("||");
    paramString5.append(paramInt1);
    paramString5.append("|");
    paramString5.append(paramString2);
    paramString5.append("|0|1|0|android.");
    paramString5.append(6);
    paramString5.append("|");
    paramString5.append(CommonUtil.a());
    paramString5.append("|");
    if ((!TextUtils.isEmpty(paramString3)) || (!TextUtils.isEmpty(paramString4)))
    {
      paramString5.append(paramString3);
      paramString5.append(".");
      paramString5.append(paramString4);
    }
    paramString5.append("|");
    paramString5.append(paramInt2);
    paramString5.append(".");
    if (!TextUtils.isEmpty(this.g)) {
      paramString5.append(this.g.replace("|", ","));
    }
    paramString5.append("|");
    StatisticCollector.a(BaseApplication.getContext()).c(this.app, paramString5.toString());
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setProgressBarIndeterminateVisibility(false);
    setRequestedOrientation(1);
    this.jdField_a_of_type_AndroidContentContext = this;
    for (;;)
    {
      try
      {
        this.jdField_b_of_type_JavaLangString = this.app.a();
        this.c = this.app.b();
        this.e = "2";
        this.jdField_b_of_type_Int = getIntent().getIntExtra("come_from", 5);
        this.f = getIntent().getStringExtra("callbackSn");
        this.g = getIntent().getStringExtra("app_info");
        paramBundle = new JSONObject(getIntent().getStringExtra("extra_data"));
        this.h = paramBundle.optString("url");
        this.i = paramBundle.optString("uin");
        this.j = paramBundle.optString("name");
        String str = paramBundle.optString("url");
        int m = str.indexOf("&f=");
        paramBundle = str;
        if (m > 0)
        {
          str = str.substring(m + 3);
          m = str.indexOf('&');
          paramBundle = str;
          if (m > 0) {
            paramBundle = str.substring(0, m);
          }
        }
        if (!"wallet".equals(paramBundle)) {
          continue;
        }
        this.k = "1";
        paramBundle = ContactUtils.l(this.app, this.i);
        if ((!TextUtils.isEmpty(paramBundle)) && (!paramBundle.equals(this.i))) {
          this.j = paramBundle;
        }
        a();
      }
      catch (Exception paramBundle)
      {
        paramBundle.printStackTrace();
        continue;
      }
      a(this.jdField_b_of_type_JavaLangString, 128, "scan.qrcode.loading", "", "", this.jdField_b_of_type_Int, "");
      return true;
      if ("apw".equals(paramBundle)) {
        this.k = "2";
      }
    }
  }
  
  /* Error */
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    // Byte code:
    //   0: iload_1
    //   1: ldc 7
    //   3: if_icmpne +59 -> 62
    //   6: new 165	android/content/Intent
    //   9: dup
    //   10: invokespecial 166	android/content/Intent:<init>	()V
    //   13: astore 4
    //   15: aload 4
    //   17: ldc -88
    //   19: aload_0
    //   20: getfield 170	com/tencent/mobileqq/activity/qwallet/TenpayJumpActivity:f	Ljava/lang/String;
    //   23: invokevirtual 174	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   26: pop
    //   27: aload 4
    //   29: ldc -80
    //   31: iconst_5
    //   32: invokevirtual 179	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   35: pop
    //   36: aload 4
    //   38: ldc -75
    //   40: aload_3
    //   41: ldc -75
    //   43: invokevirtual 288	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   46: invokevirtual 174	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   49: pop
    //   50: aload_0
    //   51: iconst_m1
    //   52: aload 4
    //   54: invokevirtual 185	com/tencent/mobileqq/activity/qwallet/TenpayJumpActivity:setResult	(ILandroid/content/Intent;)V
    //   57: aload_0
    //   58: invokevirtual 341	com/tencent/mobileqq/activity/qwallet/TenpayJumpActivity:finish	()V
    //   61: return
    //   62: aload_3
    //   63: ifnull -2 -> 61
    //   66: iload_2
    //   67: iconst_m1
    //   68: if_icmpne -7 -> 61
    //   71: aload_3
    //   72: ldc -75
    //   74: invokevirtual 288	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   77: astore_3
    //   78: aload_3
    //   79: ifnull +148 -> 227
    //   82: aload_3
    //   83: invokevirtual 126	java/lang/String:length	()I
    //   86: ifle +141 -> 227
    //   89: new 40	org/json/JSONObject
    //   92: dup
    //   93: aload_3
    //   94: invokespecial 293	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   97: astore_3
    //   98: aload_3
    //   99: ifnull +477 -> 576
    //   102: aload_3
    //   103: ldc_w 343
    //   106: invokevirtual 298	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   109: astore 4
    //   111: aload_3
    //   112: ldc -93
    //   114: iconst_m1
    //   115: invokevirtual 346	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   118: istore_2
    //   119: aload_3
    //   120: ldc_w 348
    //   123: invokevirtual 298	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   126: astore_3
    //   127: aload_3
    //   128: ifnull +109 -> 237
    //   131: aload_3
    //   132: invokevirtual 126	java/lang/String:length	()I
    //   135: ifle +102 -> 237
    //   138: new 40	org/json/JSONObject
    //   141: dup
    //   142: aload_3
    //   143: invokespecial 293	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   146: astore_3
    //   147: aload_0
    //   148: getfield 140	com/tencent/mobileqq/activity/qwallet/TenpayJumpActivity:jdField_a_of_type_CooperationQwalletPluginQWalletPayProgressDialog	Lcooperation/qwallet/plugin/QWalletPayProgressDialog;
    //   151: invokevirtual 351	cooperation/qwallet/plugin/QWalletPayProgressDialog:dismiss	()V
    //   154: iload_2
    //   155: ifne +370 -> 525
    //   158: aload_3
    //   159: ifnull +366 -> 525
    //   162: iload_1
    //   163: tableswitch	default:+17->180, 5:+18->181
    //   180: return
    //   181: aload_3
    //   182: ldc_w 353
    //   185: invokevirtual 355	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   188: pop
    //   189: aload_3
    //   190: ldc_w 357
    //   193: invokevirtual 298	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   196: astore 5
    //   198: aload_0
    //   199: getfield 302	com/tencent/mobileqq/activity/qwallet/TenpayJumpActivity:i	Ljava/lang/String;
    //   202: aload 5
    //   204: invokevirtual 316	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   207: ifne +35 -> 242
    //   210: aload_0
    //   211: ldc_w 359
    //   214: invokevirtual 361	com/tencent/mobileqq/activity/qwallet/TenpayJumpActivity:a	(Ljava/lang/CharSequence;)V
    //   217: aload_0
    //   218: invokevirtual 341	com/tencent/mobileqq/activity/qwallet/TenpayJumpActivity:finish	()V
    //   221: return
    //   222: astore_3
    //   223: aload_3
    //   224: invokevirtual 82	java/lang/Exception:printStackTrace	()V
    //   227: aconst_null
    //   228: astore_3
    //   229: goto -131 -> 98
    //   232: astore_3
    //   233: aload_3
    //   234: invokevirtual 82	java/lang/Exception:printStackTrace	()V
    //   237: aconst_null
    //   238: astore_3
    //   239: goto -92 -> 147
    //   242: aload_3
    //   243: ldc_w 363
    //   246: invokevirtual 298	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   249: astore 6
    //   251: aload_3
    //   252: ldc_w 365
    //   255: invokevirtual 298	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   258: pop
    //   259: aload_0
    //   260: aload_3
    //   261: ldc_w 367
    //   264: invokevirtual 298	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   267: ldc_w 369
    //   270: ldc -104
    //   272: invokevirtual 371	com/tencent/mobileqq/activity/qwallet/TenpayJumpActivity:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   275: astore 7
    //   277: aload_3
    //   278: ldc_w 373
    //   281: invokevirtual 298	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   284: astore_3
    //   285: aload_0
    //   286: getfield 248	com/tencent/mobileqq/activity/qwallet/TenpayJumpActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   289: aload_0
    //   290: getfield 302	com/tencent/mobileqq/activity/qwallet/TenpayJumpActivity:i	Ljava/lang/String;
    //   293: invokestatic 326	com/tencent/mobileqq/utils/ContactUtils:l	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)Ljava/lang/String;
    //   296: astore 4
    //   298: aload 4
    //   300: invokestatic 114	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   303: ifne +270 -> 573
    //   306: aload 4
    //   308: aload_0
    //   309: getfield 302	com/tencent/mobileqq/activity/qwallet/TenpayJumpActivity:i	Ljava/lang/String;
    //   312: invokevirtual 316	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   315: ifne +258 -> 573
    //   318: aload 4
    //   320: astore_3
    //   321: aload_3
    //   322: invokestatic 114	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   325: ifne +17 -> 342
    //   328: aload_3
    //   329: astore 4
    //   331: aload_3
    //   332: aload_0
    //   333: getfield 302	com/tencent/mobileqq/activity/qwallet/TenpayJumpActivity:i	Ljava/lang/String;
    //   336: invokevirtual 316	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   339: ifeq +9 -> 348
    //   342: aload_0
    //   343: getfield 306	com/tencent/mobileqq/activity/qwallet/TenpayJumpActivity:j	Ljava/lang/String;
    //   346: astore 4
    //   348: new 165	android/content/Intent
    //   351: dup
    //   352: invokespecial 166	android/content/Intent:<init>	()V
    //   355: astore_3
    //   356: aload_3
    //   357: ldc_w 281
    //   360: aload_0
    //   361: getfield 55	com/tencent/mobileqq/activity/qwallet/TenpayJumpActivity:jdField_b_of_type_Int	I
    //   364: invokevirtual 179	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   367: pop
    //   368: new 40	org/json/JSONObject
    //   371: dup
    //   372: invokespecial 41	org/json/JSONObject:<init>	()V
    //   375: astore 8
    //   377: aload 8
    //   379: ldc_w 375
    //   382: aload 5
    //   384: invokevirtual 49	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   387: pop
    //   388: aload 8
    //   390: ldc_w 377
    //   393: aload 4
    //   395: invokevirtual 49	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   398: pop
    //   399: aload 8
    //   401: ldc_w 363
    //   404: aload 6
    //   406: invokevirtual 49	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   409: pop
    //   410: aload 8
    //   412: ldc_w 379
    //   415: ldc 116
    //   417: invokevirtual 49	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   420: pop
    //   421: aload 8
    //   423: ldc_w 381
    //   426: aload_0
    //   427: getfield 320	com/tencent/mobileqq/activity/qwallet/TenpayJumpActivity:k	Ljava/lang/String;
    //   430: invokevirtual 49	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   433: pop
    //   434: aload 8
    //   436: ldc_w 383
    //   439: aload 7
    //   441: ldc_w 385
    //   444: invokestatic 391	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   447: invokevirtual 49	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   450: pop
    //   451: aload_3
    //   452: ldc 64
    //   454: aload 8
    //   456: invokevirtual 68	org/json/JSONObject:toString	()Ljava/lang/String;
    //   459: invokevirtual 174	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   462: pop
    //   463: aload_3
    //   464: ldc_w 290
    //   467: aload_0
    //   468: getfield 62	com/tencent/mobileqq/activity/qwallet/TenpayJumpActivity:g	Ljava/lang/String;
    //   471: invokevirtual 174	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   474: pop
    //   475: aload_3
    //   476: ldc -88
    //   478: aload_0
    //   479: getfield 170	com/tencent/mobileqq/activity/qwallet/TenpayJumpActivity:f	Ljava/lang/String;
    //   482: invokevirtual 174	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   485: pop
    //   486: aload_3
    //   487: ldc_w 393
    //   490: iconst_1
    //   491: invokevirtual 396	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   494: pop
    //   495: aload_3
    //   496: aload_0
    //   497: getfield 197	com/tencent/mobileqq/activity/qwallet/TenpayJumpActivity:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   500: ldc_w 398
    //   503: invokevirtual 402	android/content/Intent:setClass	(Landroid/content/Context;Ljava/lang/Class;)Landroid/content/Intent;
    //   506: pop
    //   507: aload_0
    //   508: aload_3
    //   509: ldc 7
    //   511: invokevirtual 406	com/tencent/mobileqq/activity/qwallet/TenpayJumpActivity:startActivityForResult	(Landroid/content/Intent;I)V
    //   514: return
    //   515: astore 4
    //   517: aload 4
    //   519: invokevirtual 407	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   522: goto -71 -> 451
    //   525: aload_0
    //   526: ldc_w 408
    //   529: invokevirtual 411	com/tencent/mobileqq/activity/qwallet/TenpayJumpActivity:getString	(I)Ljava/lang/String;
    //   532: astore_3
    //   533: aload 4
    //   535: ifnull +20 -> 555
    //   538: aload_0
    //   539: aload 4
    //   541: invokevirtual 361	com/tencent/mobileqq/activity/qwallet/TenpayJumpActivity:a	(Ljava/lang/CharSequence;)V
    //   544: aload_0
    //   545: iconst_m1
    //   546: aconst_null
    //   547: invokevirtual 78	com/tencent/mobileqq/activity/qwallet/TenpayJumpActivity:a	(ILandroid/os/Bundle;)V
    //   550: aload_0
    //   551: invokevirtual 341	com/tencent/mobileqq/activity/qwallet/TenpayJumpActivity:finish	()V
    //   554: return
    //   555: aload_0
    //   556: aload_3
    //   557: invokevirtual 361	com/tencent/mobileqq/activity/qwallet/TenpayJumpActivity:a	(Ljava/lang/CharSequence;)V
    //   560: goto -16 -> 544
    //   563: astore 4
    //   565: goto -114 -> 451
    //   568: astore 5
    //   570: goto -416 -> 154
    //   573: goto -252 -> 321
    //   576: aconst_null
    //   577: astore_3
    //   578: aconst_null
    //   579: astore 4
    //   581: goto -434 -> 147
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	584	0	this	TenpayJumpActivity
    //   0	584	1	paramInt1	int
    //   0	584	2	paramInt2	int
    //   0	584	3	paramIntent	Intent
    //   13	381	4	localObject1	Object
    //   515	25	4	localUnsupportedEncodingException	java.io.UnsupportedEncodingException
    //   563	1	4	localJSONException	JSONException
    //   579	1	4	localObject2	Object
    //   196	187	5	str1	String
    //   568	1	5	localException	Exception
    //   249	156	6	str2	String
    //   275	165	7	str3	String
    //   375	80	8	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   89	98	222	java/lang/Exception
    //   138	147	232	java/lang/Exception
    //   377	451	515	java/io/UnsupportedEncodingException
    //   377	451	563	org/json/JSONException
    //   147	154	568	java/lang/Exception
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\qwallet\TenpayJumpActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.tencent.mobileqq.vaswebviewplugin;

import Wallet.AuthCodeItem;
import Wallet.AuthCodeRsp;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.provider.ContactsContract.Contacts;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.activity.qwallet.TransactionActivity;
import com.tencent.mobileqq.emosm.Client.onRemoteRespObserver;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.emosm.web.WebIPCOperator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.DcReportUtil;
import com.tencent.mobileqq.utils.JumpQqPimSecureUtil;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.QWalletHelper;
import java.io.File;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

public class QWalletCommonJsPlugin
  extends VasWebviewJsPlugin
{
  public static final String PLUGIN_NAMESPACE = "qw_charge";
  private static byte REQUESTCODE_TRANSFER = 1;
  private final String EMOJI_USER_CHARGE_RESULT = "qw_charge_emojiPayResultOk";
  private final String QQPIMSECURE_SAFE_SECURITYPAY_ISOPEN = "qw_charge_qqpimsecure_safe_isopen_securitypay";
  private final String QWALLET_CHECK_WEBANK_PERMISSION = "qw_charge_checkPermission";
  private final String QWALLET_GET_APP_AUTHCODE = "qw_charge_getAppAuthorizationCode";
  private final byte QWALLET_REQUEST_CHECK_PERMISSION = 17;
  private final byte QWALLET_REQUEST_CONTACT = 16;
  private final String QWALLET_TOKEN_AIO_TRANSFER = "qw_charge_tenpayTransfer";
  private final String QWALLET_TOKEN_GET_ALL_CONTATC = "qw_charge_getAllContact";
  private final String QWALLET_TOKEN_GET_SELECT_CONTACT = "qw_charge_getSelectContact";
  private final String QWALLET_TOKEN_GOTO_QWALLET_HOME = "qw_charge_gotoQWalletHome";
  private final String TAG = "QWalletGetContactJsPlugin";
  protected QWalletCommonJsPlugin.ChooseQQFriendForTransferReceiver aioChoFriReceiver;
  private ExecutorService executorService;
  private long mAuthCodeAppId;
  private String mCallback;
  private Context mContext;
  private long mLastAuthCodeReqTime;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public QWalletCommonJsPlugin()
  {
    this.mPluginNameSpace = "qw_charge";
  }
  
  private void checkWebankPermission()
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("pay_requestcode", 13);
    Intent localIntent = new Intent(this.mContext, PayBridgeActivity.class);
    localIntent.putExtras(localBundle);
    startActivityForResult(localIntent, (byte)17);
  }
  
  private void chooseQQFriendsForTransfer(String paramString)
  {
    boolean bool2 = true;
    if (this.mRuntime == null) {
      return;
    }
    Object localObject1 = this.mRuntime.a();
    if ((localObject1 == null) || (TextUtils.isEmpty(paramString)))
    {
      dochooseQQFriendsForTransferResult(null);
      return;
    }
    try
    {
      Object localObject2 = new JSONObject(paramString);
      paramString = ((JSONObject)localObject2).optString("title", "选择联系人");
      int i = ((JSONObject)localObject2).optInt("type", 1);
      this.mCallback = ((JSONObject)localObject2).optString("callback");
      if ((i & 0x1) == 0) {}
      for (boolean bool1 = false;; bool1 = true)
      {
        if ((i & 0x2) == 0) {
          bool2 = false;
        }
        if (this.aioChoFriReceiver == null) {
          this.aioChoFriReceiver = new QWalletCommonJsPlugin.ChooseQQFriendForTransferReceiver(this, new Handler());
        }
        Parcel localParcel = Parcel.obtain();
        this.aioChoFriReceiver.writeToParcel(localParcel, 0);
        localParcel.setDataPosition(0);
        localObject2 = (ResultReceiver)ResultReceiver.CREATOR.createFromParcel(localParcel);
        localParcel.recycle();
        localObject1 = new Intent((Context)localObject1, ForwardRecentActivity.class);
        ((Intent)localObject1).putExtra("forward_type", 15);
        ((Intent)localObject1).putExtra("choose_friend_title", paramString);
        ((Intent)localObject1).putExtra("choose_friend_is_qqfriends", bool1);
        ((Intent)localObject1).putExtra("choose_friend_is_contacts", bool2);
        ((Intent)localObject1).putExtra("choose_friend_callback", (Parcelable)localObject2);
        super.startActivityForResult((Intent)localObject1, REQUESTCODE_TRANSFER);
        return;
      }
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
      dochooseQQFriendsForTransferResult(null);
    }
  }
  
  private void doCallback(String paramString)
  {
    doCallback(this.mCallback, paramString);
  }
  
  private void doCallback(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
      callJs(paramString1, new String[] { paramString2 });
    }
  }
  
  /* Error */
  private JSONObject getAllContact()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 7
    //   6: aconst_null
    //   7: astore_1
    //   8: aconst_null
    //   9: astore_2
    //   10: aconst_null
    //   11: astore 4
    //   13: aconst_null
    //   14: astore_3
    //   15: aload_0
    //   16: getfield 133	com/tencent/mobileqq/vaswebviewplugin/QWalletCommonJsPlugin:mContext	Landroid/content/Context;
    //   19: ifnonnull +5 -> 24
    //   22: aconst_null
    //   23: areturn
    //   24: new 170	org/json/JSONObject
    //   27: dup
    //   28: invokespecial 271	org/json/JSONObject:<init>	()V
    //   31: astore 8
    //   33: new 273	org/json/JSONArray
    //   36: dup
    //   37: invokespecial 274	org/json/JSONArray:<init>	()V
    //   40: astore 9
    //   42: getstatic 280	android/provider/ContactsContract$Contacts:CONTENT_URI	Landroid/net/Uri;
    //   45: astore 5
    //   47: aload_0
    //   48: getfield 133	com/tencent/mobileqq/vaswebviewplugin/QWalletCommonJsPlugin:mContext	Landroid/content/Context;
    //   51: invokevirtual 286	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   54: aload 5
    //   56: aconst_null
    //   57: aconst_null
    //   58: aconst_null
    //   59: aconst_null
    //   60: invokevirtual 292	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   63: astore 5
    //   65: aload 6
    //   67: astore 4
    //   69: aload 5
    //   71: ifnull +91 -> 162
    //   74: aload 6
    //   76: astore 4
    //   78: aload 7
    //   80: astore_1
    //   81: aload 5
    //   83: invokeinterface 298 1 0
    //   88: ifeq +74 -> 162
    //   91: aload_3
    //   92: astore 4
    //   94: aload 4
    //   96: astore_1
    //   97: aload 4
    //   99: astore_2
    //   100: aload 5
    //   102: aload 5
    //   104: ldc_w 300
    //   107: invokeinterface 304 2 0
    //   112: invokeinterface 308 2 0
    //   117: astore_3
    //   118: aload 4
    //   120: astore_1
    //   121: aload 4
    //   123: astore_2
    //   124: aload_3
    //   125: invokestatic 165	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   128: ifeq +94 -> 222
    //   131: aload 4
    //   133: astore_3
    //   134: aload_3
    //   135: astore 4
    //   137: aload 5
    //   139: ifnull +23 -> 162
    //   142: aload_3
    //   143: astore 4
    //   145: aload_3
    //   146: astore_1
    //   147: aload_3
    //   148: astore_2
    //   149: aload 5
    //   151: invokeinterface 311 1 0
    //   156: ifne -62 -> 94
    //   159: aload_3
    //   160: astore 4
    //   162: aload 4
    //   164: astore_1
    //   165: aload 4
    //   167: astore_2
    //   168: aload 8
    //   170: ldc_w 313
    //   173: aload 9
    //   175: invokevirtual 317	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   178: pop
    //   179: aload 4
    //   181: astore_1
    //   182: aload 4
    //   184: astore_2
    //   185: aload 8
    //   187: ldc_w 319
    //   190: iconst_0
    //   191: invokevirtual 322	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   194: pop
    //   195: aload 5
    //   197: ifnull +10 -> 207
    //   200: aload 5
    //   202: invokeinterface 325 1 0
    //   207: aload 4
    //   209: ifnull +10 -> 219
    //   212: aload 4
    //   214: invokeinterface 325 1 0
    //   219: aload 8
    //   221: areturn
    //   222: aload 4
    //   224: astore_1
    //   225: aload 4
    //   227: astore_2
    //   228: aload_0
    //   229: aload_3
    //   230: invokevirtual 328	com/tencent/mobileqq/vaswebviewplugin/QWalletCommonJsPlugin:trimPhoneName	(Ljava/lang/String;)Ljava/lang/String;
    //   233: astore 6
    //   235: aload 4
    //   237: astore_3
    //   238: aload 4
    //   240: astore_1
    //   241: aload 4
    //   243: astore_2
    //   244: aload 5
    //   246: aload 5
    //   248: ldc_w 330
    //   251: invokeinterface 304 2 0
    //   256: invokeinterface 334 2 0
    //   261: ifle -127 -> 134
    //   264: aload 4
    //   266: astore_1
    //   267: aload 4
    //   269: astore_2
    //   270: aload 5
    //   272: aload 5
    //   274: ldc_w 336
    //   277: invokeinterface 304 2 0
    //   282: invokeinterface 308 2 0
    //   287: astore_3
    //   288: aload 4
    //   290: astore_1
    //   291: aload 4
    //   293: astore_2
    //   294: aload_0
    //   295: getfield 133	com/tencent/mobileqq/vaswebviewplugin/QWalletCommonJsPlugin:mContext	Landroid/content/Context;
    //   298: invokevirtual 286	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   301: getstatic 339	android/provider/ContactsContract$CommonDataKinds$Phone:CONTENT_URI	Landroid/net/Uri;
    //   304: aconst_null
    //   305: new 341	java/lang/StringBuilder
    //   308: dup
    //   309: invokespecial 342	java/lang/StringBuilder:<init>	()V
    //   312: ldc_w 344
    //   315: invokevirtual 348	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   318: aload_3
    //   319: invokevirtual 348	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: invokevirtual 352	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   325: aconst_null
    //   326: aconst_null
    //   327: invokevirtual 292	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   330: astore 4
    //   332: aload 4
    //   334: astore_3
    //   335: aload 4
    //   337: ifnull -203 -> 134
    //   340: aload 4
    //   342: astore_3
    //   343: aload 4
    //   345: astore_1
    //   346: aload 4
    //   348: astore_2
    //   349: aload 4
    //   351: invokeinterface 298 1 0
    //   356: ifeq -222 -> 134
    //   359: aload 4
    //   361: astore_1
    //   362: aload 4
    //   364: astore_2
    //   365: aload 4
    //   367: aload 4
    //   369: ldc_w 354
    //   372: invokeinterface 304 2 0
    //   377: invokeinterface 308 2 0
    //   382: astore_3
    //   383: aload 4
    //   385: astore_1
    //   386: aload 4
    //   388: astore_2
    //   389: aload_3
    //   390: invokestatic 165	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   393: ifeq +103 -> 496
    //   396: aload 4
    //   398: ifnull +19 -> 417
    //   401: aload 4
    //   403: astore_1
    //   404: aload 4
    //   406: astore_2
    //   407: aload 4
    //   409: invokeinterface 311 1 0
    //   414: ifne -55 -> 359
    //   417: aload 4
    //   419: astore_1
    //   420: aload 4
    //   422: astore_2
    //   423: aload 4
    //   425: invokeinterface 325 1 0
    //   430: aload 4
    //   432: astore_3
    //   433: goto -299 -> 134
    //   436: astore_3
    //   437: aload 5
    //   439: astore_2
    //   440: aload_3
    //   441: invokevirtual 355	java/lang/Exception:printStackTrace	()V
    //   444: aload 8
    //   446: ldc_w 313
    //   449: aload 9
    //   451: invokevirtual 317	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   454: pop
    //   455: aload 8
    //   457: ldc_w 319
    //   460: iconst_m1
    //   461: invokevirtual 322	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   464: pop
    //   465: aload_2
    //   466: ifnull +9 -> 475
    //   469: aload_2
    //   470: invokeinterface 325 1 0
    //   475: aload_1
    //   476: ifnull -257 -> 219
    //   479: aload_1
    //   480: invokeinterface 325 1 0
    //   485: goto -266 -> 219
    //   488: astore_1
    //   489: aload_1
    //   490: invokevirtual 355	java/lang/Exception:printStackTrace	()V
    //   493: goto -274 -> 219
    //   496: aload 4
    //   498: astore_1
    //   499: aload 4
    //   501: astore_2
    //   502: aload_0
    //   503: aload_3
    //   504: invokevirtual 358	com/tencent/mobileqq/vaswebviewplugin/QWalletCommonJsPlugin:trimPhoneNumPre	(Ljava/lang/String;)Ljava/lang/String;
    //   507: astore_3
    //   508: aload 4
    //   510: astore_1
    //   511: aload 4
    //   513: astore_2
    //   514: new 170	org/json/JSONObject
    //   517: dup
    //   518: invokespecial 271	org/json/JSONObject:<init>	()V
    //   521: astore 7
    //   523: aload 4
    //   525: astore_1
    //   526: aload 4
    //   528: astore_2
    //   529: aload 7
    //   531: ldc_w 360
    //   534: aload 6
    //   536: invokevirtual 317	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   539: pop
    //   540: aload 4
    //   542: astore_1
    //   543: aload 4
    //   545: astore_2
    //   546: aload 7
    //   548: ldc_w 362
    //   551: aload_3
    //   552: invokevirtual 317	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   555: pop
    //   556: aload 4
    //   558: astore_1
    //   559: aload 4
    //   561: astore_2
    //   562: aload 9
    //   564: aload 7
    //   566: invokevirtual 365	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   569: pop
    //   570: goto -174 -> 396
    //   573: astore_3
    //   574: aload_2
    //   575: astore_1
    //   576: aload_3
    //   577: astore_2
    //   578: aload 5
    //   580: ifnull +10 -> 590
    //   583: aload 5
    //   585: invokeinterface 325 1 0
    //   590: aload_1
    //   591: ifnull +9 -> 600
    //   594: aload_1
    //   595: invokeinterface 325 1 0
    //   600: aload_2
    //   601: athrow
    //   602: astore_1
    //   603: aload_1
    //   604: invokevirtual 355	java/lang/Exception:printStackTrace	()V
    //   607: goto -400 -> 207
    //   610: astore_1
    //   611: aload_1
    //   612: invokevirtual 355	java/lang/Exception:printStackTrace	()V
    //   615: goto -396 -> 219
    //   618: astore_3
    //   619: aload_3
    //   620: invokevirtual 259	org/json/JSONException:printStackTrace	()V
    //   623: goto -158 -> 465
    //   626: astore_3
    //   627: aload_2
    //   628: astore 5
    //   630: aload_3
    //   631: astore_2
    //   632: goto -54 -> 578
    //   635: astore_2
    //   636: aload_2
    //   637: invokevirtual 355	java/lang/Exception:printStackTrace	()V
    //   640: goto -165 -> 475
    //   643: astore_3
    //   644: aload_3
    //   645: invokevirtual 355	java/lang/Exception:printStackTrace	()V
    //   648: goto -58 -> 590
    //   651: astore_1
    //   652: aload_1
    //   653: invokevirtual 355	java/lang/Exception:printStackTrace	()V
    //   656: goto -56 -> 600
    //   659: astore_2
    //   660: aconst_null
    //   661: astore 5
    //   663: aload 4
    //   665: astore_1
    //   666: goto -88 -> 578
    //   669: astore_3
    //   670: aconst_null
    //   671: astore_2
    //   672: goto -232 -> 440
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	675	0	this	QWalletCommonJsPlugin
    //   7	473	1	localObject1	Object
    //   488	2	1	localException1	Exception
    //   498	97	1	localObject2	Object
    //   602	2	1	localException2	Exception
    //   610	2	1	localException3	Exception
    //   651	2	1	localException4	Exception
    //   665	1	1	localObject3	Object
    //   9	623	2	localObject4	Object
    //   635	2	2	localException5	Exception
    //   659	1	2	localObject5	Object
    //   671	1	2	localObject6	Object
    //   14	419	3	localObject7	Object
    //   436	68	3	localException6	Exception
    //   507	45	3	str1	String
    //   573	4	3	localObject8	Object
    //   618	2	3	localJSONException	JSONException
    //   626	5	3	localObject9	Object
    //   643	2	3	localException7	Exception
    //   669	1	3	localException8	Exception
    //   11	653	4	localObject10	Object
    //   45	617	5	localObject11	Object
    //   1	534	6	str2	String
    //   4	561	7	localJSONObject1	JSONObject
    //   31	425	8	localJSONObject2	JSONObject
    //   40	523	9	localJSONArray	org.json.JSONArray
    // Exception table:
    //   from	to	target	type
    //   81	91	436	java/lang/Exception
    //   100	118	436	java/lang/Exception
    //   124	131	436	java/lang/Exception
    //   149	159	436	java/lang/Exception
    //   168	179	436	java/lang/Exception
    //   185	195	436	java/lang/Exception
    //   228	235	436	java/lang/Exception
    //   244	264	436	java/lang/Exception
    //   270	288	436	java/lang/Exception
    //   294	332	436	java/lang/Exception
    //   349	359	436	java/lang/Exception
    //   365	383	436	java/lang/Exception
    //   389	396	436	java/lang/Exception
    //   407	417	436	java/lang/Exception
    //   423	430	436	java/lang/Exception
    //   502	508	436	java/lang/Exception
    //   514	523	436	java/lang/Exception
    //   529	540	436	java/lang/Exception
    //   546	556	436	java/lang/Exception
    //   562	570	436	java/lang/Exception
    //   479	485	488	java/lang/Exception
    //   81	91	573	finally
    //   100	118	573	finally
    //   124	131	573	finally
    //   149	159	573	finally
    //   168	179	573	finally
    //   185	195	573	finally
    //   228	235	573	finally
    //   244	264	573	finally
    //   270	288	573	finally
    //   294	332	573	finally
    //   349	359	573	finally
    //   365	383	573	finally
    //   389	396	573	finally
    //   407	417	573	finally
    //   423	430	573	finally
    //   502	508	573	finally
    //   514	523	573	finally
    //   529	540	573	finally
    //   546	556	573	finally
    //   562	570	573	finally
    //   200	207	602	java/lang/Exception
    //   212	219	610	java/lang/Exception
    //   444	465	618	org/json/JSONException
    //   440	444	626	finally
    //   444	465	626	finally
    //   619	623	626	finally
    //   469	475	635	java/lang/Exception
    //   583	590	643	java/lang/Exception
    //   594	600	651	java/lang/Exception
    //   42	65	659	finally
    //   42	65	669	java/lang/Exception
  }
  
  private void getAppAuthCode(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return;
      long l = SystemClock.uptimeMillis();
      if ((l <= this.mLastAuthCodeReqTime) || (l - this.mLastAuthCodeReqTime >= 200L))
      {
        this.mLastAuthCodeReqTime = l;
        try
        {
          paramString = new JSONObject(paramString).optString("appid");
          if (!TextUtils.isEmpty(paramString))
          {
            this.mAuthCodeAppId = Long.valueOf(paramString).longValue();
            Object localObject = null;
            paramString = (String)localObject;
            if (this.mRuntime != null)
            {
              paramString = (String)localObject;
              if (this.mRuntime.a() != null) {
                paramString = this.mRuntime.a().a();
              }
            }
            if (TextUtils.isEmpty(paramString))
            {
              sendAuthCodeReq();
              return;
            }
          }
        }
        catch (JSONException paramString)
        {
          paramString.printStackTrace();
          return;
          paramString = this.mRuntime.a().getFilesDir() + "/QWallet/" + "cache_ac_" + paramString;
          if (!new File(paramString).exists())
          {
            sendAuthCodeReq();
            return;
          }
        }
        catch (NumberFormatException paramString)
        {
          paramString.printStackTrace();
          return;
        }
      }
    }
    if ((this.executorService == null) || (this.executorService.isShutdown())) {
      this.executorService = Executors.newFixedThreadPool(1);
    }
    this.executorService.execute(new QWalletCommonJsPlugin.1(this, paramString));
  }
  
  private JSONObject getSecurityPayIsOpenJson()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("isSecurityPayOpen", isSecurityPayOpen());
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return localJSONObject;
  }
  
  /* Error */
  private JSONObject getSelectContact(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore 4
    //   5: aconst_null
    //   6: astore 6
    //   8: new 170	org/json/JSONObject
    //   11: dup
    //   12: invokespecial 271	org/json/JSONObject:<init>	()V
    //   15: astore 7
    //   17: getstatic 280	android/provider/ContactsContract$Contacts:CONTENT_URI	Landroid/net/Uri;
    //   20: astore_3
    //   21: aload_0
    //   22: getfield 133	com/tencent/mobileqq/vaswebviewplugin/QWalletCommonJsPlugin:mContext	Landroid/content/Context;
    //   25: invokevirtual 286	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   28: aload_3
    //   29: aconst_null
    //   30: ldc_w 448
    //   33: iconst_1
    //   34: anewarray 264	java/lang/String
    //   37: dup
    //   38: iconst_0
    //   39: aload_1
    //   40: aastore
    //   41: aconst_null
    //   42: invokevirtual 292	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   45: astore_3
    //   46: aload_3
    //   47: astore_2
    //   48: aload_2
    //   49: invokeinterface 298 1 0
    //   54: ifeq +412 -> 466
    //   57: aload_0
    //   58: aload_2
    //   59: aload_2
    //   60: ldc_w 300
    //   63: invokeinterface 304 2 0
    //   68: invokeinterface 308 2 0
    //   73: invokevirtual 328	com/tencent/mobileqq/vaswebviewplugin/QWalletCommonJsPlugin:trimPhoneName	(Ljava/lang/String;)Ljava/lang/String;
    //   76: astore_3
    //   77: aload_2
    //   78: aload_2
    //   79: ldc_w 330
    //   82: invokeinterface 304 2 0
    //   87: invokeinterface 334 2 0
    //   92: ifle +369 -> 461
    //   95: aload_0
    //   96: getfield 133	com/tencent/mobileqq/vaswebviewplugin/QWalletCommonJsPlugin:mContext	Landroid/content/Context;
    //   99: invokevirtual 286	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   102: getstatic 339	android/provider/ContactsContract$CommonDataKinds$Phone:CONTENT_URI	Landroid/net/Uri;
    //   105: aconst_null
    //   106: new 341	java/lang/StringBuilder
    //   109: dup
    //   110: invokespecial 342	java/lang/StringBuilder:<init>	()V
    //   113: ldc_w 344
    //   116: invokevirtual 348	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: aload_1
    //   120: invokevirtual 348	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: invokevirtual 352	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   126: aconst_null
    //   127: aconst_null
    //   128: invokevirtual 292	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   131: astore_1
    //   132: aload_1
    //   133: astore 5
    //   135: aload_1
    //   136: astore 4
    //   138: aload_1
    //   139: invokeinterface 298 1 0
    //   144: ifeq +314 -> 458
    //   147: aload_1
    //   148: astore 5
    //   150: aload_1
    //   151: astore 4
    //   153: aload_0
    //   154: aload_1
    //   155: aload_1
    //   156: ldc_w 354
    //   159: invokeinterface 304 2 0
    //   164: invokeinterface 308 2 0
    //   169: invokevirtual 358	com/tencent/mobileqq/vaswebviewplugin/QWalletCommonJsPlugin:trimPhoneNumPre	(Ljava/lang/String;)Ljava/lang/String;
    //   172: astore 6
    //   174: aload_1
    //   175: astore 5
    //   177: aload_1
    //   178: astore 4
    //   180: aload 6
    //   182: invokestatic 165	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   185: ifne +65 -> 250
    //   188: aload_1
    //   189: astore 5
    //   191: aload_1
    //   192: astore 4
    //   194: aload_3
    //   195: invokestatic 165	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   198: ifne +52 -> 250
    //   201: aload_1
    //   202: astore 5
    //   204: aload_1
    //   205: astore 4
    //   207: aload 7
    //   209: ldc_w 319
    //   212: iconst_0
    //   213: invokevirtual 322	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   216: pop
    //   217: aload_1
    //   218: astore 5
    //   220: aload_1
    //   221: astore 4
    //   223: aload 7
    //   225: ldc_w 360
    //   228: aload_3
    //   229: invokevirtual 317	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   232: pop
    //   233: aload_1
    //   234: astore 5
    //   236: aload_1
    //   237: astore 4
    //   239: aload 7
    //   241: ldc_w 362
    //   244: aload 6
    //   246: invokevirtual 317	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   249: pop
    //   250: aload_2
    //   251: ifnull +9 -> 260
    //   254: aload_2
    //   255: invokeinterface 325 1 0
    //   260: aload_1
    //   261: ifnull +9 -> 270
    //   264: aload_1
    //   265: invokeinterface 325 1 0
    //   270: aload 7
    //   272: areturn
    //   273: astore_2
    //   274: aload_2
    //   275: invokevirtual 355	java/lang/Exception:printStackTrace	()V
    //   278: goto -18 -> 260
    //   281: astore_1
    //   282: aload_1
    //   283: invokevirtual 355	java/lang/Exception:printStackTrace	()V
    //   286: aload 7
    //   288: areturn
    //   289: astore_3
    //   290: aconst_null
    //   291: astore_1
    //   292: aload_3
    //   293: invokevirtual 355	java/lang/Exception:printStackTrace	()V
    //   296: aload 7
    //   298: ldc_w 319
    //   301: iconst_m1
    //   302: invokevirtual 322	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   305: pop
    //   306: aload 7
    //   308: ldc_w 360
    //   311: ldc_w 450
    //   314: invokevirtual 317	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   317: pop
    //   318: aload 7
    //   320: ldc_w 362
    //   323: ldc_w 450
    //   326: invokevirtual 317	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   329: pop
    //   330: aload_2
    //   331: ifnull +9 -> 340
    //   334: aload_2
    //   335: invokeinterface 325 1 0
    //   340: aload_1
    //   341: ifnull -71 -> 270
    //   344: aload_1
    //   345: invokeinterface 325 1 0
    //   350: aload 7
    //   352: areturn
    //   353: astore_1
    //   354: aload_1
    //   355: invokevirtual 355	java/lang/Exception:printStackTrace	()V
    //   358: aload 7
    //   360: areturn
    //   361: astore_3
    //   362: aload_3
    //   363: invokevirtual 259	org/json/JSONException:printStackTrace	()V
    //   366: goto -36 -> 330
    //   369: astore 4
    //   371: aload_1
    //   372: astore_3
    //   373: aload 4
    //   375: astore_1
    //   376: aload_2
    //   377: ifnull +9 -> 386
    //   380: aload_2
    //   381: invokeinterface 325 1 0
    //   386: aload_3
    //   387: ifnull +9 -> 396
    //   390: aload_3
    //   391: invokeinterface 325 1 0
    //   396: aload_1
    //   397: athrow
    //   398: astore_2
    //   399: aload_2
    //   400: invokevirtual 355	java/lang/Exception:printStackTrace	()V
    //   403: goto -63 -> 340
    //   406: astore_2
    //   407: aload_2
    //   408: invokevirtual 355	java/lang/Exception:printStackTrace	()V
    //   411: goto -25 -> 386
    //   414: astore_2
    //   415: aload_2
    //   416: invokevirtual 355	java/lang/Exception:printStackTrace	()V
    //   419: goto -23 -> 396
    //   422: astore_1
    //   423: aconst_null
    //   424: astore_2
    //   425: aload 4
    //   427: astore_3
    //   428: goto -52 -> 376
    //   431: astore_1
    //   432: aload 4
    //   434: astore_3
    //   435: goto -59 -> 376
    //   438: astore_1
    //   439: aload 5
    //   441: astore_3
    //   442: goto -66 -> 376
    //   445: astore_3
    //   446: aconst_null
    //   447: astore_1
    //   448: goto -156 -> 292
    //   451: astore_3
    //   452: aload 4
    //   454: astore_1
    //   455: goto -163 -> 292
    //   458: goto -284 -> 174
    //   461: aconst_null
    //   462: astore_1
    //   463: goto -289 -> 174
    //   466: aconst_null
    //   467: astore_3
    //   468: aconst_null
    //   469: astore_1
    //   470: goto -296 -> 174
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	473	0	this	QWalletCommonJsPlugin
    //   0	473	1	paramString	String
    //   1	254	2	localObject1	Object
    //   273	108	2	localException1	Exception
    //   398	2	2	localException2	Exception
    //   406	2	2	localException3	Exception
    //   414	2	2	localException4	Exception
    //   424	1	2	localObject2	Object
    //   20	209	3	localObject3	Object
    //   289	4	3	localException5	Exception
    //   361	2	3	localJSONException	JSONException
    //   372	70	3	localObject4	Object
    //   445	1	3	localException6	Exception
    //   451	1	3	localException7	Exception
    //   467	1	3	localObject5	Object
    //   3	235	4	str1	String
    //   369	84	4	localObject6	Object
    //   133	307	5	str2	String
    //   6	239	6	str3	String
    //   15	344	7	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   254	260	273	java/lang/Exception
    //   264	270	281	java/lang/Exception
    //   17	46	289	java/lang/Exception
    //   344	350	353	java/lang/Exception
    //   296	330	361	org/json/JSONException
    //   292	296	369	finally
    //   296	330	369	finally
    //   362	366	369	finally
    //   334	340	398	java/lang/Exception
    //   380	386	406	java/lang/Exception
    //   390	396	414	java/lang/Exception
    //   17	46	422	finally
    //   48	132	431	finally
    //   138	147	438	finally
    //   153	174	438	finally
    //   180	188	438	finally
    //   194	201	438	finally
    //   207	217	438	finally
    //   223	233	438	finally
    //   239	250	438	finally
    //   48	132	445	java/lang/Exception
    //   138	147	451	java/lang/Exception
    //   153	174	451	java/lang/Exception
    //   180	188	451	java/lang/Exception
    //   194	201	451	java/lang/Exception
    //   207	217	451	java/lang/Exception
    //   223	233	451	java/lang/Exception
    //   239	250	451	java/lang/Exception
  }
  
  private boolean isSecurityPayOpen()
  {
    if (this.mContext == null) {
      return false;
    }
    return JumpQqPimSecureUtil.f(this.mContext);
  }
  
  private boolean openContact()
  {
    Intent localIntent = new Intent();
    localIntent.setAction("android.intent.action.PICK");
    localIntent.setData(ContactsContract.Contacts.CONTENT_URI);
    super.startActivityForResult(localIntent, (byte)16);
    return true;
  }
  
  private void parseCallback(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramString.toLowerCase().indexOf("callback") < 0)) {
      return;
    }
    try
    {
      this.mCallback = new JSONObject(paramString).optString("callback");
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void reportAuthCode(String paramString, long paramLong)
  {
    str2 = "";
    try
    {
      localObject = this.mRuntime.a();
      str1 = "";
      if (localObject != null) {
        str1 = ((CustomWebView)localObject).getUrl();
      }
      localObject = str2;
      if (!TextUtils.isEmpty(str1)) {
        localObject = URLEncoder.encode(str1, "utf-8");
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        String str1;
        int i;
        Object localObject = str2;
        if (QLog.isDevelopLevel())
        {
          localException.printStackTrace();
          localObject = str2;
        }
      }
    }
    i = 3;
    str1 = paramString;
    if (TextUtils.isEmpty(paramString))
    {
      i = 4;
      str1 = "";
    }
    DcReportUtil.a(null, "dc01021", "" + i + '|' + str1 + '|' + (String)localObject + '|' + "2|" + paramLong + "||", false);
  }
  
  private void sendAuthCodeReq()
  {
    Bundle localBundle = new Bundle();
    localBundle.putLong("appId", this.mAuthCodeAppId);
    localBundle = DataFactory.a("qwallet_getAuthCode", this.mCallback, this.mOnRemoteResp.key, localBundle);
    WebIPCOperator.a().a(localBundle);
  }
  
  protected void doAuthCodeCallback(String paramString, AuthCodeItem paramAuthCodeItem)
  {
    int j = 0;
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        if ((paramAuthCodeItem != null) && (this.mAuthCodeAppId == paramAuthCodeItem.appid))
        {
          if (TextUtils.isEmpty(paramAuthCodeItem.urlDomain)) {
            break label204;
          }
          String[] arrayOfString = (paramAuthCodeItem.urlDomain + "|#").split("\\|");
          String str = Uri.parse(this.mRuntime.a().getUrl()).getHost().toLowerCase();
          i = 0;
          if ((i < arrayOfString.length - 1) && (!str.contains(arrayOfString[i]))) {
            break label210;
          }
          if (i < arrayOfString.length - 1) {
            break label204;
          }
          i = j;
          if (i != 0)
          {
            localJSONObject.put("code", paramAuthCodeItem.authCode);
            doCallback(paramString, localJSONObject.toString());
            reportAuthCode(paramAuthCodeItem.authCode, this.mAuthCodeAppId);
            return;
          }
        }
        localJSONObject.put("code", "");
        doCallback(paramString, localJSONObject.toString());
        reportAuthCode(null, this.mAuthCodeAppId);
        return;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        return;
      }
      label204:
      int i = 1;
      continue;
      label210:
      i += 1;
    }
  }
  
  protected void dochooseQQFriendsForTransferResult(String paramString)
  {
    String str;
    if (paramString != null)
    {
      str = paramString;
      if (paramString.length() != 0) {}
    }
    else
    {
      str = "{\"resultCode\":-1}";
    }
    doCallback(str.toString());
  }
  
  protected long getPluginBusiness()
  {
    return 2415919104L;
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3)) || (this.mContext == null)) {
      bool1 = false;
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return bool1;
              paramJsBridgeListener = paramString2 + "_" + paramString3;
              if (paramVarArgs.length > 0) {
                parseCallback(paramVarArgs[0]);
              }
              if ("qw_charge_getSelectContact".equals(paramJsBridgeListener))
              {
                openContact();
                return true;
              }
              if ("qw_charge_getAllContact".equals(paramJsBridgeListener))
              {
                new QWalletCommonJsPlugin.GetAllContactTask(this).execute(new Void[0]);
                return true;
              }
              if (!"qw_charge_gotoQWalletHome".equals(paramJsBridgeListener)) {
                break;
              }
              bool1 = bool2;
            } while (this.mRuntime == null);
            bool1 = bool2;
          } while (this.mRuntime.a() == null);
          QWalletHelper.a(this.mRuntime.a());
          return true;
          if ("qw_charge_qqpimsecure_safe_isopen_securitypay".equals(paramJsBridgeListener))
          {
            doCallback(getSecurityPayIsOpenJson().toString());
            return true;
          }
          if ("qw_charge_tenpayTransfer".equals(paramJsBridgeListener))
          {
            if (paramVarArgs.length <= 0)
            {
              chooseQQFriendsForTransfer(null);
              return true;
            }
            chooseQQFriendsForTransfer(paramVarArgs[0]);
            return true;
          }
          if ("qw_charge_checkPermission".equals(paramJsBridgeListener))
          {
            checkWebankPermission();
            return true;
          }
          if (!"qw_charge_emojiPayResultOk".equals(paramJsBridgeListener)) {
            break;
          }
          bool1 = bool2;
        } while (this.mRuntime == null);
        bool1 = bool2;
      } while (this.mRuntime.a() == null);
      this.mRuntime.a().setResult(8213);
      this.mRuntime.a().finish();
      return true;
      if (!"qw_charge_getAppAuthorizationCode".equals(paramJsBridgeListener)) {
        break;
      }
      bool1 = bool2;
    } while (paramVarArgs.length <= 0);
    getAppAuthCode(paramVarArgs[0]);
    return true;
    return false;
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    super.onActivityResult(paramIntent, paramByte, paramInt);
    if (paramByte == 16) {
      if ((paramInt == -1) && (paramIntent != null) && (paramIntent.getData() != null))
      {
        paramIntent = paramIntent.getData().getLastPathSegment();
        if ((paramIntent != null) && (paramIntent.length() > 0)) {
          new QWalletCommonJsPlugin.SelectContactTask(this).execute(new String[] { paramIntent });
        }
      }
    }
    do
    {
      return;
      if (paramByte == REQUESTCODE_TRANSFER)
      {
        if (paramIntent == null)
        {
          dochooseQQFriendsForTransferResult(null);
          return;
        }
        dochooseQQFriendsForTransferResult(paramIntent.getStringExtra("result"));
        return;
      }
    } while (paramByte != 17);
    Object localObject = paramIntent;
    if (paramIntent == null) {
      localObject = new Intent();
    }
    JSONObject localJSONObject1 = new JSONObject();
    for (;;)
    {
      try
      {
        paramInt = ((Intent)localObject).getIntExtra("retCode", 0);
        paramIntent = ((Intent)localObject).getStringExtra("card_status");
        String str = ((Intent)localObject).getStringExtra("available_amount");
        localObject = ((Intent)localObject).getStringExtra("overdue_amount");
        localJSONObject1.put("retCode", paramInt);
        JSONObject localJSONObject2 = new JSONObject();
        if (paramIntent != null)
        {
          localJSONObject2.put("card_status", paramIntent);
          if (str == null) {
            break label285;
          }
          paramIntent = str;
          localJSONObject2.put("available_amount", paramIntent);
          if (localObject == null) {
            break label278;
          }
          paramIntent = (Intent)localObject;
          localJSONObject2.put("overdue_amount", paramIntent);
          localJSONObject1.put("data", localJSONObject2);
          doCallback(localJSONObject1.toString());
          return;
        }
      }
      catch (JSONException paramIntent)
      {
        paramIntent.printStackTrace();
        doCallback("{'retCode':-1,data:{}}");
        return;
      }
      paramIntent = "0";
      continue;
      label278:
      paramIntent = "0";
      continue;
      label285:
      paramIntent = "0";
    }
  }
  
  protected void onCreate()
  {
    super.onCreate();
    if ((this.mRuntime != null) && (this.mRuntime.a() != null)) {
      this.mContext = this.mRuntime.a().getApplicationContext();
    }
  }
  
  protected void onResponse(Bundle paramBundle)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("QWalletGetContactJsPlugin", 4, "onResponse i:" + toString());
    }
    if ((this.mRuntime == null) || (paramBundle == null)) {}
    String str1;
    int i;
    boolean bool;
    do
    {
      String str2;
      do
      {
        do
        {
          return;
        } while (paramBundle.getInt("respkey", -1) != this.mOnRemoteResp.key);
        str1 = paramBundle.getString("callbackid");
        str2 = paramBundle.getString("cmd");
      } while ((TextUtils.isEmpty(str2)) || (str2.compareTo("qwallet_getAuthCode") != 0));
      paramBundle = paramBundle.getBundle("response");
      i = paramBundle.getInt("qwallet.type");
      bool = paramBundle.getBoolean("qwallet.isSuccess");
      paramBundle = paramBundle.getSerializable("qwallet.data");
    } while ((i != 4) || (this.mAuthCodeAppId == 0L));
    if ((bool) && (paramBundle != null) && ((paramBundle instanceof AuthCodeRsp)))
    {
      paramBundle = (AuthCodeRsp)paramBundle;
      if ((paramBundle.items == null) || (paramBundle.items.size() <= 0)) {}
    }
    for (paramBundle = (AuthCodeItem)paramBundle.items.get(0);; paramBundle = null)
    {
      doAuthCodeCallback(str1, paramBundle);
      return;
    }
  }
  
  void startTransactionActivity(String paramString1, String paramString2)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("come_from", 2);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("targetUin", paramString1);
      localJSONObject.put("targetNickname", paramString2);
      localJSONObject.put("sign", "");
      localIntent.putExtra("extra_data", localJSONObject.toString());
      localIntent.putExtra("app_info", "appid#20000001|bargainor_id#1000026901|channel#wallet");
      localIntent.setClass(this.mContext, TransactionActivity.class);
      super.startActivityForResult(localIntent, REQUESTCODE_TRANSFER);
      return;
    }
    catch (JSONException paramString1)
    {
      for (;;)
      {
        paramString1.printStackTrace();
      }
    }
  }
  
  public String trimPhoneName(String paramString)
  {
    int j = 0;
    if ((paramString == null) || (paramString.equals(""))) {
      localObject = "";
    }
    String str;
    int i;
    do
    {
      return (String)localObject;
      str = "";
      i = 0;
      localObject = str;
    } while (j >= paramString.length());
    if (i >= 10) {
      return str + "...";
    }
    Object localObject = paramString.substring(j, j + 1);
    if (((String)localObject).matches("[Α-￥]")) {
      i += 2;
    }
    for (;;)
    {
      str = str + (String)localObject;
      j += 1;
      break;
      i += 1;
    }
  }
  
  public String trimPhoneNumPre(String paramString)
  {
    if ((paramString == null) || (paramString.equals(""))) {
      paramString = "";
    }
    String str;
    do
    {
      return paramString;
      str = paramString;
      if (paramString.contains("+86"))
      {
        if (paramString.length() == 3) {
          return "";
        }
        str = paramString;
        if (paramString.length() > 3)
        {
          str = paramString;
          if (paramString.startsWith("+86")) {
            str = paramString.substring(3);
          }
        }
      }
      str = Pattern.compile("[^0-9]").matcher(str).replaceAll("").trim();
      paramString = str;
    } while (str.length() <= 11);
    return str.subSequence(str.length() - 11, str.length()).toString();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\vaswebviewplugin\QWalletCommonJsPlugin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
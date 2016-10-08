package com.tencent.open.agent;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Handler;
import android.os.Process;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.qphone.base.util.QLog;
import java.security.MessageDigest;

public class AgentActivity
  extends Activity
{
  protected static final String b = "AgentActivity";
  protected Handler a;
  protected String a;
  protected boolean a;
  
  public AgentActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
  }
  
  public static String a(Context paramContext, String paramString1, String paramString2)
  {
    String str = "";
    Object localObject = str;
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramString1, 64).signatures;
      localObject = str;
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localObject = str;
      localMessageDigest.update(paramContext[0].toByteArray());
      localObject = str;
      paramContext = HexUtil.a(localMessageDigest.digest());
      if (paramContext == null) {
        return "";
      }
      localObject = str;
      paramContext = paramContext.toLowerCase();
      localObject = str;
      QLog.i("AgentActivity", 1, "-->getAppSignatureMD5, sign: " + paramContext);
      localObject = str;
      localMessageDigest.reset();
      localObject = str;
      localMessageDigest.update((paramString1 + "_" + paramContext + "_" + paramString2 + "").getBytes());
      localObject = str;
      paramContext = HexUtil.a(localMessageDigest.digest());
      localObject = paramContext;
      localMessageDigest.reset();
      return paramContext;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return (String)localObject;
  }
  
  protected void a(int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("key_error_code", paramInt);
    localIntent.putExtra("key_error_msg", "传入参数有误!");
    localIntent.putExtra("key_error_detail", "");
    localIntent.putExtra("key_response", "");
    super.setResult(-1, localIntent);
    super.finish();
  }
  
  public SharedPreferences getSharedPreferences(String paramString, int paramInt)
  {
    return SharedPreferencesProxyManager.getInstance().getProxy(paramString, paramInt);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AgentActivity", 2, "-->onActivityResult, action: " + this.jdField_a_of_type_JavaLangString + " | requestCode: " + paramInt1 + " | resultCode: " + paramInt2 + " | data: " + paramIntent);
    }
    super.setResult(paramInt2, paramIntent);
    super.finish();
    this.jdField_a_of_type_Boolean = true;
  }
  
  /* Error */
  public void onCreate(android.os.Bundle paramBundle)
  {
    // Byte code:
    //   0: invokestatic 184	com/tencent/common/app/BaseApplicationImpl:a	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   3: aload_0
    //   4: invokevirtual 188	com/tencent/common/app/BaseApplicationImpl:addOtherTypeActivity	(Landroid/app/Activity;)V
    //   7: aload_0
    //   8: aload_1
    //   9: invokespecial 190	android/app/Activity:onCreate	(Landroid/os/Bundle;)V
    //   12: aload_0
    //   13: invokespecial 194	android/app/Activity:getIntent	()Landroid/content/Intent;
    //   16: ifnull +7 -> 23
    //   19: aload_1
    //   20: ifnull +69 -> 89
    //   23: invokestatic 154	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   26: ifeq +40 -> 66
    //   29: ldc 8
    //   31: iconst_2
    //   32: new 83	java/lang/StringBuilder
    //   35: dup
    //   36: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   39: ldc -60
    //   41: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: aload_0
    //   45: invokespecial 194	android/app/Activity:getIntent	()Landroid/content/Intent;
    //   48: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   51: ldc -58
    //   53: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: aload_1
    //   57: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   60: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   63: invokestatic 173	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   66: invokestatic 203	com/tencent/open/business/viareport/OpenSdkStatic:a	()Lcom/tencent/open/business/viareport/OpenSdkStatic;
    //   69: iconst_1
    //   70: ldc -51
    //   72: aconst_null
    //   73: aconst_null
    //   74: aconst_null
    //   75: invokestatic 211	android/os/SystemClock:elapsedRealtime	()J
    //   78: invokestatic 217	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   81: iconst_0
    //   82: iconst_1
    //   83: ldc -37
    //   85: invokevirtual 222	com/tencent/open/business/viareport/OpenSdkStatic:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;IILjava/lang/String;)V
    //   88: return
    //   89: ldc 31
    //   91: astore_3
    //   92: aload_0
    //   93: invokespecial 194	android/app/Activity:getIntent	()Landroid/content/Intent;
    //   96: ldc -32
    //   98: invokevirtual 228	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   101: astore_1
    //   102: aload_1
    //   103: astore_3
    //   104: aload_0
    //   105: aload_3
    //   106: putfield 158	com/tencent/open/agent/AgentActivity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   109: invokestatic 154	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   112: ifeq +28 -> 140
    //   115: ldc 8
    //   117: iconst_2
    //   118: new 83	java/lang/StringBuilder
    //   121: dup
    //   122: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   125: ldc -26
    //   127: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: aload_3
    //   131: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   137: invokestatic 173	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   140: aload_0
    //   141: invokespecial 194	android/app/Activity:getIntent	()Landroid/content/Intent;
    //   144: ldc -24
    //   146: invokevirtual 236	android/content/Intent:getBundleExtra	(Ljava/lang/String;)Landroid/os/Bundle;
    //   149: astore_2
    //   150: aload_2
    //   151: ifnonnull +63 -> 214
    //   154: aload_0
    //   155: bipush -5
    //   157: invokevirtual 238	com/tencent/open/agent/AgentActivity:a	(I)V
    //   160: ldc -16
    //   162: aload_3
    //   163: invokevirtual 244	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   166: ifeq -78 -> 88
    //   169: invokestatic 203	com/tencent/open/business/viareport/OpenSdkStatic:a	()Lcom/tencent/open/business/viareport/OpenSdkStatic;
    //   172: iconst_1
    //   173: ldc -51
    //   175: aconst_null
    //   176: aconst_null
    //   177: aconst_null
    //   178: invokestatic 211	android/os/SystemClock:elapsedRealtime	()J
    //   181: invokestatic 217	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   184: iconst_0
    //   185: iconst_1
    //   186: ldc -10
    //   188: invokevirtual 222	com/tencent/open/business/viareport/OpenSdkStatic:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;IILjava/lang/String;)V
    //   191: return
    //   192: astore_1
    //   193: return
    //   194: astore_1
    //   195: invokestatic 154	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   198: ifeq +11 -> 209
    //   201: ldc 8
    //   203: iconst_2
    //   204: ldc -8
    //   206: invokestatic 173	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   209: aconst_null
    //   210: astore_2
    //   211: goto -61 -> 150
    //   214: aload_2
    //   215: ldc -6
    //   217: invokevirtual 255	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   220: astore 7
    //   222: ldc -16
    //   224: aload_3
    //   225: invokevirtual 244	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   228: ifeq +472 -> 700
    //   231: new 113	android/content/Intent
    //   234: dup
    //   235: aload_0
    //   236: ldc_w 257
    //   239: invokespecial 260	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   242: astore 5
    //   244: aload 5
    //   246: ldc -32
    //   248: aload_3
    //   249: invokevirtual 127	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   252: pop
    //   253: aload_0
    //   254: invokespecial 263	android/app/Activity:getCallingPackage	()Ljava/lang/String;
    //   257: astore_1
    //   258: aload_1
    //   259: astore_3
    //   260: aload_1
    //   261: invokestatic 269	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   264: ifeq +46 -> 310
    //   267: ldc 8
    //   269: iconst_1
    //   270: ldc_w 271
    //   273: invokestatic 99	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   276: aload_0
    //   277: invokespecial 275	android/app/Activity:getCallingActivity	()Landroid/content/ComponentName;
    //   280: astore_3
    //   281: aload_3
    //   282: ifnull +347 -> 629
    //   285: aload_3
    //   286: invokevirtual 280	android/content/ComponentName:getPackageName	()Ljava/lang/String;
    //   289: astore_1
    //   290: aload_1
    //   291: astore_3
    //   292: aload_1
    //   293: invokestatic 269	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   296: ifeq +14 -> 310
    //   299: ldc 8
    //   301: iconst_1
    //   302: ldc_w 282
    //   305: invokestatic 99	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   308: aload_1
    //   309: astore_3
    //   310: aload_3
    //   311: invokestatic 269	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   314: ifne +346 -> 660
    //   317: new 83	java/lang/StringBuilder
    //   320: dup
    //   321: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   324: invokestatic 287	java/lang/System:currentTimeMillis	()J
    //   327: ldc2_w 288
    //   330: ldiv
    //   331: invokevirtual 292	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   334: ldc 31
    //   336: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   339: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   342: astore 8
    //   344: ldc 31
    //   346: astore 6
    //   348: aload_0
    //   349: invokevirtual 293	com/tencent/open/agent/AgentActivity:getPackageManager	()Landroid/content/pm/PackageManager;
    //   352: astore_1
    //   353: aload_1
    //   354: aload_3
    //   355: bipush 64
    //   357: invokevirtual 43	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   360: getfield 49	android/content/pm/PackageInfo:signatures	[Landroid/content/pm/Signature;
    //   363: astore_1
    //   364: ldc 51
    //   366: invokestatic 57	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   369: astore 4
    //   371: aload 4
    //   373: aload_1
    //   374: iconst_0
    //   375: aaload
    //   376: invokevirtual 63	android/content/pm/Signature:toByteArray	()[B
    //   379: invokevirtual 67	java/security/MessageDigest:update	([B)V
    //   382: aload 4
    //   384: invokevirtual 70	java/security/MessageDigest:digest	()[B
    //   387: invokestatic 75	com/tencent/mobileqq/utils/HexUtil:a	([B)Ljava/lang/String;
    //   390: invokevirtual 81	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   393: astore_1
    //   394: aload 4
    //   396: invokevirtual 102	java/security/MessageDigest:reset	()V
    //   399: aload 4
    //   401: new 83	java/lang/StringBuilder
    //   404: dup
    //   405: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   408: aload_3
    //   409: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   412: ldc 104
    //   414: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   417: aload_1
    //   418: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   421: ldc 104
    //   423: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   426: aload 8
    //   428: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   431: ldc 31
    //   433: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   436: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   439: invokevirtual 107	java/lang/String:getBytes	()[B
    //   442: invokevirtual 67	java/security/MessageDigest:update	([B)V
    //   445: aload 4
    //   447: invokevirtual 70	java/security/MessageDigest:digest	()[B
    //   450: invokestatic 75	com/tencent/mobileqq/utils/HexUtil:a	([B)Ljava/lang/String;
    //   453: astore 4
    //   455: ldc 8
    //   457: iconst_1
    //   458: new 83	java/lang/StringBuilder
    //   461: dup
    //   462: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   465: ldc_w 295
    //   468: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   471: aload 7
    //   473: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   476: ldc_w 297
    //   479: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   482: aload_3
    //   483: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   486: ldc_w 299
    //   489: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   492: aload_1
    //   493: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   496: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   499: invokestatic 99	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   502: aload_2
    //   503: ldc_w 301
    //   506: aload_3
    //   507: invokevirtual 305	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   510: aload_2
    //   511: ldc_w 307
    //   514: aload_1
    //   515: invokevirtual 305	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   518: aload_2
    //   519: ldc_w 309
    //   522: aload 4
    //   524: invokevirtual 305	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   527: aload_2
    //   528: ldc_w 311
    //   531: aload 8
    //   533: invokevirtual 305	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   536: invokestatic 154	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   539: ifeq +30 -> 569
    //   542: ldc 8
    //   544: iconst_2
    //   545: new 83	java/lang/StringBuilder
    //   548: dup
    //   549: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   552: ldc_w 313
    //   555: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   558: aload 4
    //   560: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   563: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   566: invokestatic 173	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   569: invokestatic 203	com/tencent/open/business/viareport/OpenSdkStatic:a	()Lcom/tencent/open/business/viareport/OpenSdkStatic;
    //   572: iconst_0
    //   573: ldc -51
    //   575: aconst_null
    //   576: aload 7
    //   578: aconst_null
    //   579: invokestatic 211	android/os/SystemClock:elapsedRealtime	()J
    //   582: invokestatic 217	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   585: iconst_0
    //   586: iconst_1
    //   587: aconst_null
    //   588: invokevirtual 222	com/tencent/open/business/viareport/OpenSdkStatic:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;IILjava/lang/String;)V
    //   591: aload 5
    //   593: astore_1
    //   594: aload_1
    //   595: ifnull -507 -> 88
    //   598: aload_1
    //   599: ldc -24
    //   601: aload_2
    //   602: invokevirtual 316	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Bundle;)Landroid/content/Intent;
    //   605: pop
    //   606: aload_0
    //   607: aload_1
    //   608: iconst_0
    //   609: invokespecial 320	android/app/Activity:startActivityForResult	(Landroid/content/Intent;I)V
    //   612: return
    //   613: astore_1
    //   614: aload_1
    //   615: invokevirtual 321	android/content/ActivityNotFoundException:printStackTrace	()V
    //   618: aload_0
    //   619: bipush -6
    //   621: invokevirtual 238	com/tencent/open/agent/AgentActivity:a	(I)V
    //   624: aload_0
    //   625: invokespecial 138	android/app/Activity:finish	()V
    //   628: return
    //   629: ldc 8
    //   631: iconst_1
    //   632: ldc_w 323
    //   635: invokestatic 99	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   638: aload_1
    //   639: astore_3
    //   640: goto -330 -> 310
    //   643: astore 4
    //   645: ldc 31
    //   647: astore_1
    //   648: aload 4
    //   650: invokevirtual 110	java/lang/Exception:printStackTrace	()V
    //   653: aload 6
    //   655: astore 4
    //   657: goto -202 -> 455
    //   660: ldc 8
    //   662: iconst_1
    //   663: ldc_w 325
    //   666: invokestatic 99	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   669: invokestatic 203	com/tencent/open/business/viareport/OpenSdkStatic:a	()Lcom/tencent/open/business/viareport/OpenSdkStatic;
    //   672: iconst_1
    //   673: ldc -51
    //   675: aconst_null
    //   676: aload 7
    //   678: aconst_null
    //   679: invokestatic 211	android/os/SystemClock:elapsedRealtime	()J
    //   682: invokestatic 217	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   685: iconst_0
    //   686: iconst_1
    //   687: ldc_w 327
    //   690: invokevirtual 222	com/tencent/open/business/viareport/OpenSdkStatic:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;IILjava/lang/String;)V
    //   693: goto -102 -> 591
    //   696: astore_1
    //   697: goto -106 -> 591
    //   700: ldc_w 329
    //   703: aload_3
    //   704: invokevirtual 244	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   707: ifeq +26 -> 733
    //   710: new 113	android/content/Intent
    //   713: dup
    //   714: aload_0
    //   715: ldc_w 257
    //   718: invokespecial 260	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   721: astore_1
    //   722: aload_1
    //   723: ldc -32
    //   725: aload_3
    //   726: invokevirtual 127	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   729: pop
    //   730: goto -136 -> 594
    //   733: ldc_w 331
    //   736: aload_3
    //   737: invokevirtual 244	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   740: ifne +13 -> 753
    //   743: ldc_w 333
    //   746: aload_3
    //   747: invokevirtual 244	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   750: ifeq +41 -> 791
    //   753: aload_0
    //   754: invokespecial 263	android/app/Activity:getCallingPackage	()Ljava/lang/String;
    //   757: astore 4
    //   759: new 113	android/content/Intent
    //   762: dup
    //   763: aload_0
    //   764: ldc_w 335
    //   767: invokespecial 260	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   770: astore_1
    //   771: aload_1
    //   772: ldc -32
    //   774: aload_3
    //   775: invokevirtual 127	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   778: pop
    //   779: aload_2
    //   780: ldc_w 301
    //   783: aload 4
    //   785: invokevirtual 305	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   788: goto -194 -> 594
    //   791: ldc_w 337
    //   794: aload_3
    //   795: invokevirtual 244	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   798: ifne +33 -> 831
    //   801: ldc_w 339
    //   804: aload_3
    //   805: invokevirtual 244	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   808: ifne +23 -> 831
    //   811: ldc_w 341
    //   814: aload_3
    //   815: invokevirtual 244	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   818: ifne +13 -> 831
    //   821: ldc_w 343
    //   824: aload_3
    //   825: invokevirtual 244	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   828: ifeq +60 -> 888
    //   831: new 113	android/content/Intent
    //   834: dup
    //   835: aload_0
    //   836: ldc_w 345
    //   839: invokespecial 260	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   842: astore_1
    //   843: aload_1
    //   844: ifnull +41 -> 885
    //   847: aload_1
    //   848: ldc -32
    //   850: aload_3
    //   851: invokevirtual 127	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   854: pop
    //   855: aload_2
    //   856: ldc_w 347
    //   859: invokevirtual 255	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   862: astore_3
    //   863: aload_2
    //   864: ldc_w 349
    //   867: aload_0
    //   868: ldc_w 351
    //   871: invokestatic 356	com/tencent/open/settings/OpensdkPreference:a	(Landroid/content/Context;Ljava/lang/String;)Landroid/content/SharedPreferences;
    //   874: aload_3
    //   875: ldc 31
    //   877: invokeinterface 361 3 0
    //   882: invokevirtual 305	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   885: goto -291 -> 594
    //   888: ldc_w 363
    //   891: aload_3
    //   892: invokevirtual 244	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   895: ifeq +18 -> 913
    //   898: new 113	android/content/Intent
    //   901: dup
    //   902: aload_0
    //   903: ldc_w 365
    //   906: invokespecial 260	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   909: astore_1
    //   910: goto -67 -> 843
    //   913: ldc_w 367
    //   916: aload_3
    //   917: invokevirtual 244	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   920: ifeq +18 -> 938
    //   923: new 113	android/content/Intent
    //   926: dup
    //   927: aload_0
    //   928: ldc_w 369
    //   931: invokespecial 260	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   934: astore_1
    //   935: goto -92 -> 843
    //   938: ldc_w 371
    //   941: aload_3
    //   942: invokevirtual 244	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   945: ifeq +18 -> 963
    //   948: new 113	android/content/Intent
    //   951: dup
    //   952: aload_0
    //   953: ldc_w 373
    //   956: invokespecial 260	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   959: astore_1
    //   960: goto -117 -> 843
    //   963: aload_0
    //   964: bipush -5
    //   966: invokevirtual 238	com/tencent/open/agent/AgentActivity:a	(I)V
    //   969: return
    //   970: astore_1
    //   971: goto -380 -> 591
    //   974: astore 4
    //   976: goto -328 -> 648
    //   979: astore_1
    //   980: goto -876 -> 104
    //   983: astore_1
    //   984: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	985	0	this	AgentActivity
    //   0	985	1	paramBundle	android.os.Bundle
    //   149	715	2	localBundle	android.os.Bundle
    //   91	851	3	localObject1	Object
    //   369	190	4	localObject2	Object
    //   643	6	4	localException1	Exception
    //   655	129	4	str1	String
    //   974	1	4	localException2	Exception
    //   242	350	5	localIntent	Intent
    //   346	308	6	str2	String
    //   220	457	7	str3	String
    //   342	190	8	str4	String
    // Exception table:
    //   from	to	target	type
    //   169	191	192	java/lang/Exception
    //   140	150	194	java/lang/Exception
    //   606	612	613	android/content/ActivityNotFoundException
    //   353	394	643	java/lang/Exception
    //   669	693	696	java/lang/Exception
    //   569	591	970	java/lang/Exception
    //   394	455	974	java/lang/Exception
    //   92	102	979	java/lang/Exception
    //   66	88	983	java/lang/Exception
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (QLog.isColorLevel()) {
      QLog.d("AgentActivity", 2, "-->onDestroy, action: " + this.jdField_a_of_type_JavaLangString);
    }
    BaseApplicationImpl.a().removeOtherTypeActivity(this);
    if (this.jdField_a_of_type_Boolean)
    {
      boolean bool = GesturePWDUtils.isAppOnForeground(this);
      if (!bool) {
        GesturePWDUtils.setAppForground(this, bool);
      }
      Process.killProcess(Process.myPid());
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\open\agent\AgentActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.tencent.mobileqq.vip;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.FriendChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import mqq.os.MqqHandler;
import wfw;

public class AioVipKeywordHelper
{
  private static AioVipKeywordHelper jdField_a_of_type_ComTencentMobileqqVipAioVipKeywordHelper;
  public static final String a;
  public static final String b = "vipKerwordJson";
  public static String c = "mvip.pt.android.aiocuifei_recikai";
  public static String d = "mvip.pt.android.aiocuifei_recizeng";
  private static String k = "对自己好点，开通会员享特权无极限。立即开通";
  private static String l = "见证友情的时刻到咯！立即赠送好友会员。";
  private static String m = "立即开通";
  private static String n = "立即赠送";
  private int jdField_a_of_type_Int;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  private boolean jdField_a_of_type_Boolean;
  public String e = k;
  public String f = l;
  public String g = m;
  public String h = n;
  public String i;
  public String j;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = AioVipKeywordHelper.class.getSimpleName();
  }
  
  public static AioVipKeywordHelper a()
  {
    if (jdField_a_of_type_ComTencentMobileqqVipAioVipKeywordHelper == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqVipAioVipKeywordHelper == null) {
        jdField_a_of_type_ComTencentMobileqqVipAioVipKeywordHelper = new AioVipKeywordHelper();
      }
      return jdField_a_of_type_ComTencentMobileqqVipAioVipKeywordHelper;
    }
    finally {}
  }
  
  private String[] a(Context arg1, String paramString)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() < 1))
    {
      ThreadManager.a().post(new wfw(this, ???, paramString));
      return null;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      paramString = new String[this.jdField_a_of_type_JavaUtilArrayList.size()];
      this.jdField_a_of_type_JavaUtilArrayList.toArray(paramString);
      return paramString;
    }
  }
  
  public void a(Context paramContext, String paramString)
  {
    if (paramContext == null) {}
    do
    {
      return;
      Object localObject = null;
      File localFile = new File(paramContext.getFilesDir(), "vipKerwordJson");
      paramContext = (Context)localObject;
      if (localFile.exists()) {
        paramContext = FileUtils.a(localFile);
      }
    } while (TextUtils.isEmpty(paramContext));
    a(paramContext, paramString);
  }
  
  public void a(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "updateKeywordJson");
    }
    if ((paramContext == null) || (TextUtils.isEmpty(paramString1))) {}
    do
    {
      return;
      a(paramString1, paramString2);
    } while (!FileUtils.a(paramContext.getFilesDir() + File.separator + "vipKerwordJson", paramString1));
    SharedPreUtils.d(paramContext, paramInt, "");
  }
  
  public void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString, Context paramContext, boolean paramBoolean)
  {
    if ((paramQQAppInterface == null) || (paramContext == null) || (TextUtils.isEmpty(paramString))) {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "detectKeyword : params error");
      }
    }
    label235:
    label347:
    label356:
    do
    {
      long l1;
      long l2;
      do
      {
        String[] arrayOfString;
        String str;
        Object localObject;
        do
        {
          do
          {
            return;
            arrayOfString = a(paramContext, paramQQAppInterface.a());
          } while (arrayOfString == null);
          if ((this.jdField_a_of_type_Int != 1) || (paramSessionInfo.jdField_a_of_type_Int != 0) || (!this.jdField_a_of_type_Boolean)) {
            break;
          }
          str = null;
          localObject = str;
          if ((paramContext instanceof FragmentActivity))
          {
            localObject = ((FragmentActivity)paramContext).getChatFragment();
            paramContext = null;
            if (localObject != null) {
              paramContext = ((ChatFragment)localObject).a();
            }
            localObject = str;
            if (paramContext != null)
            {
              localObject = str;
              if ((paramContext instanceof FriendChatPie)) {
                localObject = (FriendChatPie)paramContext;
              }
            }
          }
        } while ((localObject == null) || (!((FriendChatPie)localObject).J));
        l1 = System.currentTimeMillis();
        paramString = paramString.toLowerCase();
        int i1;
        if ((arrayOfString != null) && (arrayOfString.length > 0)) {
          i1 = 0;
        }
        while (i1 < arrayOfString.length)
        {
          str = arrayOfString[i1];
          if ((!TextUtils.isEmpty(str)) && (paramString.contains(str)))
          {
            if (paramBoolean)
            {
              paramString = this.e;
              ((FriendChatPie)localObject).J = false;
              if (!paramBoolean) {
                break label347;
              }
              paramContext = paramQQAppInterface.a();
              l2 = System.currentTimeMillis();
              if (QLog.isColorLevel()) {
                QLog.d(jdField_a_of_type_JavaLangString, 2, "keyword ok , time = " + (l2 - l1) + ";keyword = " + str);
              }
              paramQQAppInterface.a().a(paramSessionInfo.jdField_a_of_type_JavaLangString, paramContext, paramSessionInfo.jdField_a_of_type_Int, 61515, paramString);
              if (!paramBoolean) {
                break label356;
              }
            }
            for (paramQQAppInterface = "0";; paramQQAppInterface = "1")
            {
              VasWebviewUtil.reportVipKeywords(str, paramQQAppInterface, "", "", "", "", "", "", "", "");
              return;
              paramString = this.f;
              break;
              paramContext = paramSessionInfo.jdField_a_of_type_JavaLangString;
              break label235;
            }
          }
          i1 += 1;
          continue;
          QLog.e(jdField_a_of_type_JavaLangString, 1, "vipKeywords null");
        }
        l2 = System.currentTimeMillis();
      } while (!QLog.isColorLevel());
      QLog.d(jdField_a_of_type_JavaLangString, 2, "keywords fail : time = " + (l2 - l1));
      return;
    } while (paramSessionInfo.jdField_a_of_type_Int != 0);
    QLog.d(jdField_a_of_type_JavaLangString, 1, "isUseKeywordFunction = " + this.jdField_a_of_type_Int + ";isGrayNumber = " + this.jdField_a_of_type_Boolean);
  }
  
  /* Error */
  public void a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: iconst_0
    //   3: istore 7
    //   5: aload_1
    //   6: invokestatic 141	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9: ifne +10 -> 19
    //   12: aload_2
    //   13: invokestatic 141	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   16: ifeq +4 -> 20
    //   19: return
    //   20: new 271	org/json/JSONObject
    //   23: dup
    //   24: aload_1
    //   25: invokespecial 274	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   28: astore 4
    //   30: aload 4
    //   32: ldc_w 276
    //   35: invokevirtual 280	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   38: ifeq +470 -> 508
    //   41: aload 4
    //   43: ldc_w 276
    //   46: invokevirtual 284	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   49: istore 6
    //   51: aload_0
    //   52: iload 6
    //   54: putfield 192	com/tencent/mobileqq/vip/AioVipKeywordHelper:jdField_a_of_type_Int	I
    //   57: aload 4
    //   59: ldc_w 286
    //   62: invokevirtual 280	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   65: ifeq +320 -> 385
    //   68: aload 4
    //   70: ldc_w 286
    //   73: invokevirtual 290	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   76: astore_1
    //   77: aload_0
    //   78: aload_1
    //   79: putfield 71	com/tencent/mobileqq/vip/AioVipKeywordHelper:e	Ljava/lang/String;
    //   82: aload 4
    //   84: ldc_w 292
    //   87: invokevirtual 280	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   90: ifeq +302 -> 392
    //   93: aload 4
    //   95: ldc_w 292
    //   98: invokevirtual 290	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   101: astore_1
    //   102: aload_0
    //   103: aload_1
    //   104: putfield 75	com/tencent/mobileqq/vip/AioVipKeywordHelper:g	Ljava/lang/String;
    //   107: aload 4
    //   109: ldc_w 294
    //   112: invokevirtual 280	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   115: ifeq +284 -> 399
    //   118: aload 4
    //   120: ldc_w 294
    //   123: invokevirtual 290	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   126: astore_1
    //   127: aload_0
    //   128: aload_1
    //   129: putfield 73	com/tencent/mobileqq/vip/AioVipKeywordHelper:f	Ljava/lang/String;
    //   132: aload 4
    //   134: ldc_w 296
    //   137: invokevirtual 280	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   140: ifeq +266 -> 406
    //   143: aload 4
    //   145: ldc_w 296
    //   148: invokevirtual 290	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   151: astore_1
    //   152: aload_0
    //   153: aload_1
    //   154: putfield 77	com/tencent/mobileqq/vip/AioVipKeywordHelper:h	Ljava/lang/String;
    //   157: aload 4
    //   159: ldc_w 298
    //   162: invokevirtual 280	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   165: ifeq +349 -> 514
    //   168: aload 4
    //   170: ldc_w 298
    //   173: invokevirtual 290	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   176: astore_1
    //   177: aload_0
    //   178: aload_1
    //   179: putfield 300	com/tencent/mobileqq/vip/AioVipKeywordHelper:i	Ljava/lang/String;
    //   182: aload 4
    //   184: ldc_w 302
    //   187: invokevirtual 280	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   190: ifeq +329 -> 519
    //   193: aload 4
    //   195: ldc_w 302
    //   198: invokevirtual 290	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   201: astore_1
    //   202: aload_0
    //   203: aload_1
    //   204: putfield 304	com/tencent/mobileqq/vip/AioVipKeywordHelper:j	Ljava/lang/String;
    //   207: aload 4
    //   209: ldc_w 306
    //   212: invokevirtual 280	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   215: ifeq +309 -> 524
    //   218: aload 4
    //   220: ldc_w 306
    //   223: invokevirtual 290	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   226: astore_1
    //   227: aload_0
    //   228: iconst_0
    //   229: putfield 197	com/tencent/mobileqq/vip/AioVipKeywordHelper:jdField_a_of_type_Boolean	Z
    //   232: aload_1
    //   233: invokestatic 141	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   236: ifne +52 -> 288
    //   239: aload_1
    //   240: ldc_w 308
    //   243: invokevirtual 312	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   246: astore_1
    //   247: iconst_0
    //   248: istore 6
    //   250: iload 6
    //   252: aload_1
    //   253: arraylength
    //   254: if_icmpge +34 -> 288
    //   257: aload_1
    //   258: iload 6
    //   260: aaload
    //   261: astore 5
    //   263: aload 5
    //   265: invokestatic 141	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   268: ifne +261 -> 529
    //   271: aload_2
    //   272: aload 5
    //   274: invokevirtual 315	java/lang/String:trim	()Ljava/lang/String;
    //   277: invokevirtual 318	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   280: ifeq +249 -> 529
    //   283: aload_0
    //   284: iconst_1
    //   285: putfield 197	com/tencent/mobileqq/vip/AioVipKeywordHelper:jdField_a_of_type_Boolean	Z
    //   288: aload_3
    //   289: astore_1
    //   290: aload 4
    //   292: ldc_w 320
    //   295: invokevirtual 280	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   298: ifeq +12 -> 310
    //   301: aload 4
    //   303: ldc_w 320
    //   306: invokevirtual 290	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   309: astore_1
    //   310: aload_1
    //   311: invokestatic 141	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   314: ifne +113 -> 427
    //   317: new 88	java/util/ArrayList
    //   320: dup
    //   321: invokespecial 321	java/util/ArrayList:<init>	()V
    //   324: astore_2
    //   325: aload_1
    //   326: ldc_w 308
    //   329: invokevirtual 312	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   332: astore_3
    //   333: iload 7
    //   335: istore 6
    //   337: iload 6
    //   339: aload_3
    //   340: arraylength
    //   341: if_icmpge +72 -> 413
    //   344: aload_3
    //   345: iload 6
    //   347: aaload
    //   348: astore 4
    //   350: aload 4
    //   352: invokestatic 141	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   355: ifne +144 -> 499
    //   358: aload 4
    //   360: invokevirtual 315	java/lang/String:trim	()Ljava/lang/String;
    //   363: invokestatic 141	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   366: ifne +133 -> 499
    //   369: aload_2
    //   370: aload 4
    //   372: invokevirtual 315	java/lang/String:trim	()Ljava/lang/String;
    //   375: invokevirtual 222	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   378: invokevirtual 325	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   381: pop
    //   382: goto +117 -> 499
    //   385: getstatic 53	com/tencent/mobileqq/vip/AioVipKeywordHelper:k	Ljava/lang/String;
    //   388: astore_1
    //   389: goto -312 -> 77
    //   392: getstatic 61	com/tencent/mobileqq/vip/AioVipKeywordHelper:m	Ljava/lang/String;
    //   395: astore_1
    //   396: goto -294 -> 102
    //   399: getstatic 57	com/tencent/mobileqq/vip/AioVipKeywordHelper:l	Ljava/lang/String;
    //   402: astore_1
    //   403: goto -276 -> 127
    //   406: getstatic 65	com/tencent/mobileqq/vip/AioVipKeywordHelper:n	Ljava/lang/String;
    //   409: astore_1
    //   410: goto -258 -> 152
    //   413: aload_0
    //   414: getfield 79	com/tencent/mobileqq/vip/AioVipKeywordHelper:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   417: astore_3
    //   418: aload_3
    //   419: monitorenter
    //   420: aload_0
    //   421: aload_2
    //   422: putfield 86	com/tencent/mobileqq/vip/AioVipKeywordHelper:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   425: aload_3
    //   426: monitorexit
    //   427: invokestatic 150	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   430: ifeq -411 -> 19
    //   433: getstatic 41	com/tencent/mobileqq/vip/AioVipKeywordHelper:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   436: iconst_2
    //   437: new 157	java/lang/StringBuilder
    //   440: dup
    //   441: invokespecial 158	java/lang/StringBuilder:<init>	()V
    //   444: ldc_w 327
    //   447: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   450: aload_1
    //   451: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   454: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   457: invokestatic 155	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   460: return
    //   461: astore_1
    //   462: aload_1
    //   463: invokevirtual 330	java/lang/Exception:printStackTrace	()V
    //   466: getstatic 41	com/tencent/mobileqq/vip/AioVipKeywordHelper:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   469: iconst_1
    //   470: new 157	java/lang/StringBuilder
    //   473: dup
    //   474: invokespecial 158	java/lang/StringBuilder:<init>	()V
    //   477: ldc_w 332
    //   480: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   483: aload_1
    //   484: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   487: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   490: invokestatic 155	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   493: return
    //   494: astore_1
    //   495: aload_3
    //   496: monitorexit
    //   497: aload_1
    //   498: athrow
    //   499: iload 6
    //   501: iconst_1
    //   502: iadd
    //   503: istore 6
    //   505: goto -168 -> 337
    //   508: iconst_0
    //   509: istore 6
    //   511: goto -460 -> 51
    //   514: aconst_null
    //   515: astore_1
    //   516: goto -339 -> 177
    //   519: aconst_null
    //   520: astore_1
    //   521: goto -319 -> 202
    //   524: aconst_null
    //   525: astore_1
    //   526: goto -299 -> 227
    //   529: iload 6
    //   531: iconst_1
    //   532: iadd
    //   533: istore 6
    //   535: goto -285 -> 250
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	538	0	this	AioVipKeywordHelper
    //   0	538	1	paramString1	String
    //   0	538	2	paramString2	String
    //   28	343	4	localJSONObject	org.json.JSONObject
    //   261	12	5	localCharSequence	CharSequence
    //   49	485	6	i1	int
    //   3	331	7	i2	int
    // Exception table:
    //   from	to	target	type
    //   20	51	461	java/lang/Exception
    //   51	77	461	java/lang/Exception
    //   77	102	461	java/lang/Exception
    //   102	127	461	java/lang/Exception
    //   127	152	461	java/lang/Exception
    //   152	177	461	java/lang/Exception
    //   177	202	461	java/lang/Exception
    //   202	227	461	java/lang/Exception
    //   227	247	461	java/lang/Exception
    //   250	257	461	java/lang/Exception
    //   263	288	461	java/lang/Exception
    //   290	310	461	java/lang/Exception
    //   310	333	461	java/lang/Exception
    //   337	344	461	java/lang/Exception
    //   350	382	461	java/lang/Exception
    //   385	389	461	java/lang/Exception
    //   392	396	461	java/lang/Exception
    //   399	403	461	java/lang/Exception
    //   406	410	461	java/lang/Exception
    //   413	420	461	java/lang/Exception
    //   427	460	461	java/lang/Exception
    //   497	499	461	java/lang/Exception
    //   420	427	494	finally
    //   495	497	494	finally
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\vip\AioVipKeywordHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.tencent.biz.huangye.util;

import android.content.Context;
import android.content.Intent;
import com.tencent.biz.huangye.QQYPQRCodePreviewActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;

public class QQYPQRCodeUtil
{
  private static String a = "mqqc2bapi://qqc2b/callc2bphone";
  private static String b = "mqqapi://qqc2b/callc2bphone";
  private static String c = "0/4QwvDnoI#L8euo";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static boolean a(Context paramContext, String paramString, boolean paramBoolean)
  {
    Intent localIntent = new Intent(paramContext, QQYPQRCodePreviewActivity.class);
    boolean bool = a(paramContext, paramString, paramBoolean, localIntent);
    if (!bool) {
      localIntent.putExtra("error", true);
    }
    for (;;)
    {
      localIntent.putExtra("fromInternal", paramBoolean);
      paramContext.startActivity(localIntent);
      ReportController.b(null, "CliOper", "", "", "0X8005F1C", "0X8005F1C", 0, 0, "", "", "", "");
      return bool;
      ReportController.b(null, "CliOper", "", "", "0X8005F1D", "0X8005F1D", 0, 0, "", "", "", "");
    }
  }
  
  /* Error */
  private static boolean a(Context paramContext, String paramString, boolean paramBoolean, Intent paramIntent)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +5 -> 6
    //   4: iconst_0
    //   5: ireturn
    //   6: aload_1
    //   7: ldc 78
    //   9: invokevirtual 84	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   12: astore_0
    //   13: aload_0
    //   14: arraylength
    //   15: iconst_2
    //   16: if_icmpne -12 -> 4
    //   19: aload_0
    //   20: iconst_1
    //   21: aaload
    //   22: ifnull -18 -> 4
    //   25: aload_0
    //   26: iconst_1
    //   27: aaload
    //   28: invokevirtual 88	java/lang/String:length	()I
    //   31: ifeq -27 -> 4
    //   34: new 90	java/util/HashMap
    //   37: dup
    //   38: invokespecial 91	java/util/HashMap:<init>	()V
    //   41: astore_1
    //   42: aload_0
    //   43: iconst_1
    //   44: aaload
    //   45: ldc 93
    //   47: invokevirtual 84	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   50: astore_0
    //   51: iconst_0
    //   52: istore 5
    //   54: iload 5
    //   56: aload_0
    //   57: arraylength
    //   58: if_icmpge +65 -> 123
    //   61: aload_0
    //   62: iload 5
    //   64: aaload
    //   65: ldc 95
    //   67: invokevirtual 99	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   70: istore 6
    //   72: iload 6
    //   74: iconst_m1
    //   75: if_icmpne +12 -> 87
    //   78: iload 5
    //   80: iconst_1
    //   81: iadd
    //   82: istore 5
    //   84: goto -30 -> 54
    //   87: aload_1
    //   88: aload_0
    //   89: iload 5
    //   91: aaload
    //   92: iconst_0
    //   93: iload 6
    //   95: invokevirtual 103	java/lang/String:substring	(II)Ljava/lang/String;
    //   98: aload_0
    //   99: iload 5
    //   101: aaload
    //   102: iload 6
    //   104: iconst_1
    //   105: iadd
    //   106: aload_0
    //   107: iload 5
    //   109: aaload
    //   110: invokevirtual 88	java/lang/String:length	()I
    //   113: invokevirtual 103	java/lang/String:substring	(II)Ljava/lang/String;
    //   116: invokevirtual 107	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   119: pop
    //   120: goto -42 -> 78
    //   123: aload_1
    //   124: ldc 109
    //   126: invokevirtual 113	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   129: checkcast 80	java/lang/String
    //   132: astore_0
    //   133: aload_0
    //   134: ifnull -130 -> 4
    //   137: aload_0
    //   138: invokevirtual 88	java/lang/String:length	()I
    //   141: ifeq -137 -> 4
    //   144: aload_0
    //   145: iconst_0
    //   146: invokestatic 119	android/util/Base64:decode	(Ljava/lang/String;I)[B
    //   149: astore_0
    //   150: aload_0
    //   151: ifnull -147 -> 4
    //   154: new 121	com/tencent/qphone/base/util/Cryptor
    //   157: dup
    //   158: invokespecial 122	com/tencent/qphone/base/util/Cryptor:<init>	()V
    //   161: aload_0
    //   162: getstatic 28	com/tencent/biz/huangye/util/QQYPQRCodeUtil:c	Ljava/lang/String;
    //   165: invokevirtual 126	java/lang/String:getBytes	()[B
    //   168: invokevirtual 130	com/tencent/qphone/base/util/Cryptor:decrypt	([B[B)[B
    //   171: astore_0
    //   172: aload_0
    //   173: ifnull -169 -> 4
    //   176: new 80	java/lang/String
    //   179: dup
    //   180: aload_0
    //   181: invokespecial 133	java/lang/String:<init>	([B)V
    //   184: astore_0
    //   185: aload_0
    //   186: ifnull -182 -> 4
    //   189: new 135	org/json/JSONObject
    //   192: dup
    //   193: aload_0
    //   194: invokespecial 138	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   197: astore 4
    //   199: aload 4
    //   201: ldc -116
    //   203: invokevirtual 144	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   206: astore_0
    //   207: aload 4
    //   209: ldc -110
    //   211: invokevirtual 144	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   214: astore 4
    //   216: aload_0
    //   217: aload 4
    //   219: invokestatic 149	com/tencent/biz/huangye/util/QQYPQRCodeUtil:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   222: ifeq -218 -> 4
    //   225: aload_3
    //   226: ldc -116
    //   228: aload_0
    //   229: invokevirtual 152	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   232: pop
    //   233: aload_3
    //   234: ldc -110
    //   236: aload 4
    //   238: invokevirtual 152	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   241: pop
    //   242: aload_3
    //   243: ldc 51
    //   245: iload_2
    //   246: invokevirtual 49	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   249: pop
    //   250: aload_3
    //   251: ldc -102
    //   253: aload_1
    //   254: ldc -102
    //   256: invokevirtual 113	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   259: checkcast 80	java/lang/String
    //   262: invokevirtual 152	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   265: pop
    //   266: iconst_1
    //   267: ireturn
    //   268: astore_0
    //   269: aconst_null
    //   270: astore_0
    //   271: goto -121 -> 150
    //   274: astore_0
    //   275: aconst_null
    //   276: astore_0
    //   277: goto -127 -> 150
    //   280: astore_0
    //   281: aconst_null
    //   282: astore_0
    //   283: goto -98 -> 185
    //   286: astore_0
    //   287: aload_0
    //   288: invokevirtual 157	org/json/JSONException:printStackTrace	()V
    //   291: iconst_0
    //   292: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	293	0	paramContext	Context
    //   0	293	1	paramString	String
    //   0	293	2	paramBoolean	boolean
    //   0	293	3	paramIntent	Intent
    //   197	40	4	localObject	Object
    //   52	56	5	i	int
    //   70	36	6	j	int
    // Exception table:
    //   from	to	target	type
    //   144	150	268	java/lang/IllegalArgumentException
    //   144	150	274	java/lang/Exception
    //   176	185	280	java/lang/Exception
    //   189	216	286	org/json/JSONException
  }
  
  public static boolean a(String paramString)
  {
    return (paramString != null) && ((paramString.startsWith(a)) || (paramString.startsWith(b)));
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {}
    while (paramString1.getBytes().length > 60) {
      return false;
    }
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\huangye\util\QQYPQRCodeUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
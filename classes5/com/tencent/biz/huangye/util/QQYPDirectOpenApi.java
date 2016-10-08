package com.tencent.biz.huangye.util;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.huangye.HYBlankActivity;

public class QQYPDirectOpenApi
{
  private static String a = "mqqapi://qqc2b/callc2bphonedirect";
  private static String b = "0/4QwvDnoI#L8euo";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private static void a(Context paramContext, Bundle paramBundle)
  {
    Intent localIntent = new Intent(paramContext, HYBlankActivity.class);
    localIntent.putExtra("Bundle", paramBundle);
    localIntent.addFlags(268435456);
    paramContext.startActivity(localIntent);
  }
  
  public static boolean a(Context paramContext, String paramString, boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("invoke_cmd", "BusinessHandler_voiceCall");
    localBundle.putString("from_where", "openApi");
    paramBoolean = a(paramContext, paramString, paramBoolean, localBundle);
    a(paramContext, localBundle);
    return paramBoolean;
  }
  
  /* Error */
  private static boolean a(Context paramContext, String paramString, boolean paramBoolean, Bundle paramBundle)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +5 -> 6
    //   4: iconst_0
    //   5: ireturn
    //   6: aload_1
    //   7: ldc 81
    //   9: invokevirtual 87	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
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
    //   28: invokevirtual 91	java/lang/String:length	()I
    //   31: ifeq -27 -> 4
    //   34: new 93	java/util/HashMap
    //   37: dup
    //   38: invokespecial 94	java/util/HashMap:<init>	()V
    //   41: astore 4
    //   43: aload_0
    //   44: iconst_1
    //   45: aaload
    //   46: ldc 96
    //   48: invokevirtual 87	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   51: astore_0
    //   52: iconst_0
    //   53: istore 8
    //   55: iload 8
    //   57: aload_0
    //   58: arraylength
    //   59: if_icmpge +66 -> 125
    //   62: aload_0
    //   63: iload 8
    //   65: aaload
    //   66: ldc 98
    //   68: invokevirtual 102	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   71: istore 9
    //   73: iload 9
    //   75: iconst_m1
    //   76: if_icmpne +12 -> 88
    //   79: iload 8
    //   81: iconst_1
    //   82: iadd
    //   83: istore 8
    //   85: goto -30 -> 55
    //   88: aload 4
    //   90: aload_0
    //   91: iload 8
    //   93: aaload
    //   94: iconst_0
    //   95: iload 9
    //   97: invokevirtual 106	java/lang/String:substring	(II)Ljava/lang/String;
    //   100: aload_0
    //   101: iload 8
    //   103: aaload
    //   104: iload 9
    //   106: iconst_1
    //   107: iadd
    //   108: aload_0
    //   109: iload 8
    //   111: aaload
    //   112: invokevirtual 91	java/lang/String:length	()I
    //   115: invokevirtual 106	java/lang/String:substring	(II)Ljava/lang/String;
    //   118: invokevirtual 110	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   121: pop
    //   122: goto -43 -> 79
    //   125: aload 4
    //   127: ldc 112
    //   129: invokevirtual 116	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   132: checkcast 83	java/lang/String
    //   135: astore_0
    //   136: aload_0
    //   137: ifnull -133 -> 4
    //   140: aload_0
    //   141: invokevirtual 91	java/lang/String:length	()I
    //   144: ifeq -140 -> 4
    //   147: aload_0
    //   148: iconst_0
    //   149: invokestatic 122	android/util/Base64:decode	(Ljava/lang/String;I)[B
    //   152: astore_0
    //   153: aload_0
    //   154: ifnull -150 -> 4
    //   157: new 124	com/tencent/qphone/base/util/Cryptor
    //   160: dup
    //   161: invokespecial 125	com/tencent/qphone/base/util/Cryptor:<init>	()V
    //   164: aload_0
    //   165: getstatic 23	com/tencent/biz/huangye/util/QQYPDirectOpenApi:b	Ljava/lang/String;
    //   168: invokevirtual 129	java/lang/String:getBytes	()[B
    //   171: invokevirtual 133	com/tencent/qphone/base/util/Cryptor:decrypt	([B[B)[B
    //   174: astore_0
    //   175: aload_0
    //   176: ifnull -172 -> 4
    //   179: ldc -121
    //   181: astore_1
    //   182: new 83	java/lang/String
    //   185: dup
    //   186: aload_0
    //   187: invokespecial 138	java/lang/String:<init>	([B)V
    //   190: astore_0
    //   191: aload_0
    //   192: ifnull -188 -> 4
    //   195: new 140	org/json/JSONObject
    //   198: dup
    //   199: aload_0
    //   200: invokespecial 143	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   203: astore 7
    //   205: aload 7
    //   207: ldc -111
    //   209: invokevirtual 149	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   212: astore 5
    //   214: aload 7
    //   216: ldc -105
    //   218: invokevirtual 149	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   221: astore 6
    //   223: aload_1
    //   224: astore_0
    //   225: aload 7
    //   227: ldc -103
    //   229: invokevirtual 157	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   232: ifeq +11 -> 243
    //   235: aload 7
    //   237: ldc -103
    //   239: invokevirtual 149	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   242: astore_0
    //   243: aload 5
    //   245: aload 6
    //   247: invokestatic 160	com/tencent/biz/huangye/util/QQYPDirectOpenApi:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   250: ifeq -246 -> 4
    //   253: aload_3
    //   254: ldc -94
    //   256: aload 5
    //   258: invokevirtual 64	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   261: aload_3
    //   262: ldc -105
    //   264: aload 6
    //   266: invokevirtual 64	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   269: aload_3
    //   270: ldc -103
    //   272: aload_0
    //   273: invokevirtual 64	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   276: aload_3
    //   277: ldc -92
    //   279: aload 4
    //   281: ldc -92
    //   283: invokevirtual 116	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   286: checkcast 83	java/lang/String
    //   289: invokevirtual 64	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   292: iconst_1
    //   293: ireturn
    //   294: astore_0
    //   295: aconst_null
    //   296: astore_0
    //   297: goto -144 -> 153
    //   300: astore_0
    //   301: aconst_null
    //   302: astore_0
    //   303: goto -150 -> 153
    //   306: astore_0
    //   307: aconst_null
    //   308: astore_0
    //   309: goto -118 -> 191
    //   312: astore_0
    //   313: aload_0
    //   314: invokevirtual 167	org/json/JSONException:printStackTrace	()V
    //   317: iconst_0
    //   318: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	319	0	paramContext	Context
    //   0	319	1	paramString	String
    //   0	319	2	paramBoolean	boolean
    //   0	319	3	paramBundle	Bundle
    //   41	239	4	localHashMap	java.util.HashMap
    //   212	45	5	str1	String
    //   221	44	6	str2	String
    //   203	33	7	localJSONObject	org.json.JSONObject
    //   53	57	8	i	int
    //   71	37	9	j	int
    // Exception table:
    //   from	to	target	type
    //   147	153	294	java/lang/IllegalArgumentException
    //   147	153	300	java/lang/Exception
    //   182	191	306	java/lang/Exception
    //   195	223	312	org/json/JSONException
    //   225	243	312	org/json/JSONException
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


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\huangye\util\QQYPDirectOpenApi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
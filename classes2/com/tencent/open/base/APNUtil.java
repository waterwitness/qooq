package com.tencent.open.base;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;

public class APNUtil
{
  public static final int a = 1;
  protected static Uri a;
  protected static final String a;
  public static final int b = 2;
  public static final String b = "wifi";
  public static final int c = 4;
  public static final String c = "cmwap";
  public static final int d = 8;
  public static final String d = "cmnet";
  public static final int e = 16;
  public static final String e = "uniwap";
  public static final int f = 32;
  public static final String f = "uninet";
  public static final int g = 64;
  public static final String g = "wap";
  public static final int h = 128;
  public static final String h = "net";
  public static final int i = 256;
  public static final String i = "ctwap";
  public static final int j = 512;
  public static final String j = "ctnet";
  public static final int k = 1024;
  public static final String k = "none";
  public static final int l = 2048;
  public static final String l = "3gnet";
  public static final String m = "3gwap";
  public static final String n = "unconnect";
  public static final String o = "unknown";
  public static final String p = "wifi";
  public static final String q = "2g";
  public static final String r = "3g";
  public static final String s = "4g";
  public static final String t = "apn";
  public static final String u = "proxy";
  public static final String v = "port";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = APNUtil.class.getName();
    jdField_a_of_type_AndroidNetUri = Uri.parse("content://telephony/carriers/preferapn");
  }
  
  /* Error */
  public static int a(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 120	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   4: getstatic 107	com/tencent/open/base/APNUtil:jdField_a_of_type_AndroidNetUri	Landroid/net/Uri;
    //   7: aconst_null
    //   8: aconst_null
    //   9: aconst_null
    //   10: aconst_null
    //   11: invokevirtual 126	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   14: astore_1
    //   15: aload_1
    //   16: ifnonnull +17 -> 33
    //   19: aload_1
    //   20: ifnull +9 -> 29
    //   23: aload_1
    //   24: invokeinterface 131 1 0
    //   29: iconst_m1
    //   30: istore_3
    //   31: iload_3
    //   32: ireturn
    //   33: aload_1
    //   34: astore_0
    //   35: aload_1
    //   36: invokeinterface 135 1 0
    //   41: pop
    //   42: aload_1
    //   43: astore_0
    //   44: aload_1
    //   45: aload_1
    //   46: ldc 81
    //   48: invokeinterface 139 2 0
    //   53: invokeinterface 143 2 0
    //   58: istore 4
    //   60: iload 4
    //   62: istore_3
    //   63: aload_1
    //   64: ifnull -33 -> 31
    //   67: aload_1
    //   68: invokeinterface 131 1 0
    //   73: iload 4
    //   75: ireturn
    //   76: astore_2
    //   77: aconst_null
    //   78: astore_1
    //   79: aload_1
    //   80: astore_0
    //   81: aload_2
    //   82: invokevirtual 146	java/lang/Exception:printStackTrace	()V
    //   85: aload_1
    //   86: ifnull +9 -> 95
    //   89: aload_1
    //   90: invokeinterface 131 1 0
    //   95: iconst_m1
    //   96: ireturn
    //   97: astore_1
    //   98: aconst_null
    //   99: astore_0
    //   100: aload_0
    //   101: ifnull +9 -> 110
    //   104: aload_0
    //   105: invokeinterface 131 1 0
    //   110: aload_1
    //   111: athrow
    //   112: astore_1
    //   113: goto -13 -> 100
    //   116: astore_2
    //   117: goto -38 -> 79
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	120	0	paramContext	Context
    //   14	76	1	localCursor	android.database.Cursor
    //   97	14	1	localObject1	Object
    //   112	1	1	localObject2	Object
    //   76	6	2	localException1	Exception
    //   116	1	2	localException2	Exception
    //   30	33	3	i1	int
    //   58	16	4	i2	int
    // Exception table:
    //   from	to	target	type
    //   0	15	76	java/lang/Exception
    //   0	15	97	finally
    //   35	42	112	finally
    //   44	60	112	finally
    //   81	85	112	finally
    //   35	42	116	java/lang/Exception
    //   44	60	116	java/lang/Exception
  }
  
  public static String a(Context paramContext)
  {
    int i1 = b(paramContext);
    if (i1 == 2) {
      paramContext = "wifi";
    }
    String str;
    do
    {
      return paramContext;
      if (i1 == 1) {
        return "cmwap";
      }
      if (i1 == 4) {
        return "cmnet";
      }
      if (i1 == 16) {
        return "uniwap";
      }
      if (i1 == 8) {
        return "uninet";
      }
      if (i1 == 64) {
        return "wap";
      }
      if (i1 == 32) {
        return "net";
      }
      if (i1 == 512) {
        return "ctwap";
      }
      if (i1 == 256) {
        return "ctnet";
      }
      if (i1 == 2048) {
        return "3gnet";
      }
      if (i1 == 1024) {
        return "3gwap";
      }
      str = b(paramContext);
      if (str == null) {
        break;
      }
      paramContext = str;
    } while (str.length() != 0);
    return "none";
  }
  
  public static boolean a(Context paramContext)
  {
    int i1 = b(paramContext);
    return (i1 == 1) || (i1 == 16) || (i1 == 64) || (i1 == 512) || (i1 == 1024);
  }
  
  public static int b(Context paramContext)
  {
    try
    {
      Object localObject = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (localObject == null) {
        return 128;
      }
      localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
      if (localObject == null) {
        return 128;
      }
      if (((NetworkInfo)localObject).getTypeName().toUpperCase().equals("WIFI")) {
        return 2;
      }
      localObject = ((NetworkInfo)localObject).getExtraInfo().toLowerCase();
      if (((String)localObject).startsWith("cmwap")) {
        return 1;
      }
      if ((((String)localObject).startsWith("cmnet")) || (((String)localObject).startsWith("epc.tmobile.com"))) {
        break label232;
      }
      if (((String)localObject).startsWith("uniwap")) {
        return 16;
      }
      if (((String)localObject).startsWith("uninet")) {
        return 8;
      }
      if (((String)localObject).startsWith("wap")) {
        return 64;
      }
      if (((String)localObject).startsWith("net")) {
        return 32;
      }
      if (((String)localObject).startsWith("ctwap")) {
        return 512;
      }
      if (((String)localObject).startsWith("ctnet")) {
        return 256;
      }
      if (((String)localObject).startsWith("3gwap")) {
        return 1024;
      }
      if (((String)localObject).startsWith("3gnet")) {
        return 2048;
      }
      if (((String)localObject).startsWith("#777"))
      {
        paramContext = c(paramContext);
        if (paramContext != null)
        {
          int i1 = paramContext.length();
          if (i1 > 0) {
            return 512;
          }
        }
        return 256;
      }
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return 128;
    label232:
    return 4;
  }
  
  public static String b(Context paramContext)
  {
    return AppNetConnInfo.getCurrentAPN();
  }
  
  public static boolean b(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext == null) {
      return false;
    }
    paramContext = paramContext.getActiveNetworkInfo();
    return (paramContext != null) && (paramContext.isAvailable());
  }
  
  /* Error */
  public static String c(Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aload_0
    //   3: invokevirtual 120	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   6: getstatic 107	com/tencent/open/base/APNUtil:jdField_a_of_type_AndroidNetUri	Landroid/net/Uri;
    //   9: aconst_null
    //   10: aconst_null
    //   11: aconst_null
    //   12: aconst_null
    //   13: invokevirtual 126	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   16: astore_0
    //   17: aload_0
    //   18: ifnonnull +17 -> 35
    //   21: aload_0
    //   22: ifnull +9 -> 31
    //   25: aload_0
    //   26: invokeinterface 131 1 0
    //   31: aconst_null
    //   32: astore_1
    //   33: aload_1
    //   34: areturn
    //   35: aload_0
    //   36: invokeinterface 135 1 0
    //   41: pop
    //   42: aload_0
    //   43: aload_0
    //   44: ldc 78
    //   46: invokeinterface 139 2 0
    //   51: invokeinterface 212 2 0
    //   56: astore_2
    //   57: aload_2
    //   58: astore_1
    //   59: aload_0
    //   60: ifnull -27 -> 33
    //   63: aload_0
    //   64: invokeinterface 131 1 0
    //   69: aload_2
    //   70: areturn
    //   71: astore_2
    //   72: aload_1
    //   73: astore_0
    //   74: aload_2
    //   75: astore_1
    //   76: aload_1
    //   77: invokevirtual 146	java/lang/Exception:printStackTrace	()V
    //   80: aload_0
    //   81: ifnull +9 -> 90
    //   84: aload_0
    //   85: invokeinterface 131 1 0
    //   90: ldc -42
    //   92: areturn
    //   93: astore_1
    //   94: aconst_null
    //   95: astore_0
    //   96: aload_0
    //   97: ifnull +9 -> 106
    //   100: aload_0
    //   101: invokeinterface 131 1 0
    //   106: aload_1
    //   107: athrow
    //   108: astore_1
    //   109: goto -13 -> 96
    //   112: astore_1
    //   113: goto -17 -> 96
    //   116: astore_1
    //   117: goto -41 -> 76
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	120	0	paramContext	Context
    //   1	76	1	localObject1	Object
    //   93	14	1	localObject2	Object
    //   108	1	1	localObject3	Object
    //   112	1	1	localObject4	Object
    //   116	1	1	localException1	Exception
    //   56	14	2	str	String
    //   71	4	2	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   2	17	71	java/lang/Exception
    //   2	17	93	finally
    //   35	57	108	finally
    //   76	80	112	finally
    //   35	57	116	java/lang/Exception
  }
  
  public static boolean c(Context paramContext)
  {
    return AppNetConnInfo.isWifiConn();
  }
  
  /* Error */
  public static String d(Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aload_0
    //   3: invokevirtual 120	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   6: getstatic 107	com/tencent/open/base/APNUtil:jdField_a_of_type_AndroidNetUri	Landroid/net/Uri;
    //   9: aconst_null
    //   10: aconst_null
    //   11: aconst_null
    //   12: aconst_null
    //   13: invokevirtual 126	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   16: astore_0
    //   17: aload_0
    //   18: ifnonnull +17 -> 35
    //   21: aload_0
    //   22: ifnull +9 -> 31
    //   25: aload_0
    //   26: invokeinterface 131 1 0
    //   31: aconst_null
    //   32: astore_2
    //   33: aload_2
    //   34: areturn
    //   35: aload_0
    //   36: invokeinterface 135 1 0
    //   41: pop
    //   42: aload_0
    //   43: invokeinterface 220 1 0
    //   48: ifeq +29 -> 77
    //   51: aload_0
    //   52: ifnull +9 -> 61
    //   55: aload_0
    //   56: invokeinterface 131 1 0
    //   61: ldc -34
    //   63: astore_2
    //   64: aload_0
    //   65: ifnull -32 -> 33
    //   68: aload_0
    //   69: invokeinterface 131 1 0
    //   74: ldc -34
    //   76: areturn
    //   77: aload_0
    //   78: aload_0
    //   79: ldc 81
    //   81: invokeinterface 139 2 0
    //   86: invokeinterface 212 2 0
    //   91: astore_2
    //   92: aload_2
    //   93: astore_1
    //   94: aload_2
    //   95: ifnonnull +6 -> 101
    //   98: ldc -34
    //   100: astore_1
    //   101: aload_1
    //   102: astore_2
    //   103: aload_0
    //   104: ifnull -71 -> 33
    //   107: aload_0
    //   108: invokeinterface 131 1 0
    //   113: aload_1
    //   114: areturn
    //   115: astore_2
    //   116: aload_1
    //   117: astore_0
    //   118: aload_2
    //   119: astore_1
    //   120: aload_1
    //   121: invokevirtual 146	java/lang/Exception:printStackTrace	()V
    //   124: aload_0
    //   125: ifnull +9 -> 134
    //   128: aload_0
    //   129: invokeinterface 131 1 0
    //   134: ldc -34
    //   136: areturn
    //   137: astore_1
    //   138: aconst_null
    //   139: astore_0
    //   140: aload_0
    //   141: ifnull +9 -> 150
    //   144: aload_0
    //   145: invokeinterface 131 1 0
    //   150: aload_1
    //   151: athrow
    //   152: astore_1
    //   153: goto -13 -> 140
    //   156: astore_1
    //   157: goto -17 -> 140
    //   160: astore_1
    //   161: goto -41 -> 120
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	164	0	paramContext	Context
    //   1	120	1	localObject1	Object
    //   137	14	1	localObject2	Object
    //   152	1	1	localObject3	Object
    //   156	1	1	localObject4	Object
    //   160	1	1	localException1	Exception
    //   32	71	2	localObject5	Object
    //   115	4	2	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   2	17	115	java/lang/Exception
    //   2	17	137	finally
    //   35	51	152	finally
    //   55	61	152	finally
    //   77	92	152	finally
    //   120	124	156	finally
    //   35	51	160	java/lang/Exception
    //   55	61	160	java/lang/Exception
    //   77	92	160	java/lang/Exception
  }
  
  public static boolean d(Context paramContext)
  {
    try
    {
      paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (paramContext == null) {
        return true;
      }
      paramContext = paramContext.getAllNetworkInfo();
      if (paramContext != null)
      {
        int i1 = 0;
        while (i1 < paramContext.length)
        {
          boolean bool = paramContext[i1].isConnectedOrConnecting();
          if (bool) {
            return true;
          }
          i1 += 1;
        }
      }
      return false;
    }
    catch (Exception paramContext)
    {
      LogUtility.c(jdField_a_of_type_JavaLangString, "checkNetWork Exception", paramContext);
    }
  }
  
  public static String e(Context paramContext)
  {
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext == null) {
      return "MOBILE";
    }
    paramContext = paramContext.getActiveNetworkInfo();
    if (paramContext != null) {
      return paramContext.getTypeName();
    }
    return "MOBILE";
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\open\base\APNUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
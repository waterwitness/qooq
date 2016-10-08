package com.tencent.mobileqq.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.Intent.ShortcutIconResource;
import android.content.res.Resources;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import wdj;

public class ShortcutUtils
{
  private static final int jdField_a_of_type_Int = 3;
  static String jdField_a_of_type_JavaLangString;
  private static int jdField_b_of_type_Int;
  private static String jdField_b_of_type_JavaLangString;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_b_of_type_JavaLangString = "QQUtils";
    a = null;
  }
  
  /* Error */
  public static String a(Context paramContext, String[] paramArrayOfString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: invokestatic 37	com/tencent/mobileqq/utils/ShortcutUtils:a	(Landroid/content/Context;)Z
    //   6: ifne +7 -> 13
    //   9: aconst_null
    //   10: astore_1
    //   11: aload_1
    //   12: areturn
    //   13: getstatic 23	com/tencent/mobileqq/utils/ShortcutUtils:a	Ljava/lang/String;
    //   16: astore 4
    //   18: aload_0
    //   19: invokevirtual 43	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   22: astore 5
    //   24: invokestatic 49	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   27: ifeq +78 -> 105
    //   30: ldc 51
    //   32: astore_3
    //   33: aload_3
    //   34: astore_0
    //   35: aload_1
    //   36: ifnull +33 -> 69
    //   39: aload_3
    //   40: astore_0
    //   41: aload_1
    //   42: arraylength
    //   43: iconst_1
    //   44: if_icmplt +25 -> 69
    //   47: new 53	java/lang/StringBuilder
    //   50: dup
    //   51: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   54: ldc 51
    //   56: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: aload_1
    //   60: iconst_0
    //   61: aaload
    //   62: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   68: astore_0
    //   69: getstatic 21	com/tencent/mobileqq/utils/ShortcutUtils:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   72: iconst_2
    //   73: new 53	java/lang/StringBuilder
    //   76: dup
    //   77: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   80: ldc 63
    //   82: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: aload 4
    //   87: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: ldc 65
    //   92: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: aload_0
    //   96: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   102: invokestatic 69	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   105: aload 5
    //   107: aload 4
    //   109: invokestatic 75	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   112: aconst_null
    //   113: ldc 77
    //   115: aload_1
    //   116: aconst_null
    //   117: invokevirtual 83	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   120: astore_0
    //   121: aload_0
    //   122: ifnull +43 -> 165
    //   125: aload_0
    //   126: astore_1
    //   127: aload_0
    //   128: invokeinterface 88 1 0
    //   133: pop
    //   134: aload_0
    //   135: astore_1
    //   136: aload_0
    //   137: aload_0
    //   138: ldc 90
    //   140: invokeinterface 94 2 0
    //   145: invokeinterface 98 2 0
    //   150: astore_2
    //   151: aload_2
    //   152: astore_1
    //   153: aload_0
    //   154: ifnull -143 -> 11
    //   157: aload_0
    //   158: invokeinterface 101 1 0
    //   163: aload_2
    //   164: areturn
    //   165: aload_0
    //   166: ifnull +9 -> 175
    //   169: aload_0
    //   170: invokeinterface 101 1 0
    //   175: aconst_null
    //   176: areturn
    //   177: astore_2
    //   178: aconst_null
    //   179: astore_0
    //   180: aload_0
    //   181: astore_1
    //   182: invokestatic 49	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   185: ifeq +34 -> 219
    //   188: aload_0
    //   189: astore_1
    //   190: getstatic 21	com/tencent/mobileqq/utils/ShortcutUtils:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   193: iconst_2
    //   194: new 53	java/lang/StringBuilder
    //   197: dup
    //   198: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   201: ldc 103
    //   203: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: aload_2
    //   207: invokevirtual 104	java/lang/Exception:toString	()Ljava/lang/String;
    //   210: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   216: invokestatic 69	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   219: aload_0
    //   220: ifnull -45 -> 175
    //   223: aload_0
    //   224: invokeinterface 101 1 0
    //   229: goto -54 -> 175
    //   232: astore_0
    //   233: aload_2
    //   234: astore_1
    //   235: aload_1
    //   236: ifnull +9 -> 245
    //   239: aload_1
    //   240: invokeinterface 101 1 0
    //   245: aload_0
    //   246: athrow
    //   247: astore_0
    //   248: goto -13 -> 235
    //   251: astore_2
    //   252: goto -72 -> 180
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	255	0	paramContext	Context
    //   0	255	1	paramArrayOfString	String[]
    //   1	163	2	str1	String
    //   177	57	2	localException1	Exception
    //   251	1	2	localException2	Exception
    //   32	8	3	str2	String
    //   16	92	4	str3	String
    //   22	84	5	localContentResolver	android.content.ContentResolver
    // Exception table:
    //   from	to	target	type
    //   24	30	177	java/lang/Exception
    //   41	69	177	java/lang/Exception
    //   69	105	177	java/lang/Exception
    //   105	121	177	java/lang/Exception
    //   24	30	232	finally
    //   41	69	232	finally
    //   69	105	232	finally
    //   105	121	232	finally
    //   127	134	247	finally
    //   136	151	247	finally
    //   182	188	247	finally
    //   190	219	247	finally
    //   127	134	251	java/lang/Exception
    //   136	151	251	java/lang/Exception
  }
  
  public static void a(Activity paramActivity, String paramString)
  {
    Intent localIntent = new Intent("android.intent.action.MAIN");
    localIntent.setClassName(paramActivity, paramString);
    localIntent.addCategory("android.intent.category.LAUNCHER");
    localIntent.addFlags(268435456);
    localIntent.addFlags(2097152);
    paramString = new Intent();
    paramString.putExtra("android.intent.extra.shortcut.INTENT", localIntent);
    paramString.putExtra("android.intent.extra.shortcut.NAME", paramActivity.getResources().getString(2131367251));
    paramString.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(paramActivity.getApplicationContext(), 2130838592));
    paramString.setAction("com.android.launcher.action.UNINSTALL_SHORTCUT");
    paramActivity.sendOrderedBroadcast(paramString, null);
  }
  
  public static void a(Context paramContext, String paramString)
  {
    paramContext = new wdj(paramContext, paramString);
    ThreadManager.b().post(paramContext);
  }
  
  static boolean a(Context paramContext)
  {
    if (a == null) {
      a = QQShortCutUtils.a(paramContext);
    }
    if ("empty".equals(a))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_b_of_type_JavaLangString, 2, "cannot find authority");
      }
      return false;
    }
    return true;
  }
  
  /* Error */
  public static boolean a(Context paramContext, String[] paramArrayOfString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: invokestatic 37	com/tencent/mobileqq/utils/ShortcutUtils:a	(Landroid/content/Context;)Z
    //   6: ifne +9 -> 15
    //   9: iconst_0
    //   10: istore 6
    //   12: iload 6
    //   14: ireturn
    //   15: getstatic 23	com/tencent/mobileqq/utils/ShortcutUtils:a	Ljava/lang/String;
    //   18: astore 4
    //   20: aload_0
    //   21: invokevirtual 43	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   24: astore 5
    //   26: invokestatic 49	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   29: ifeq +78 -> 107
    //   32: ldc 51
    //   34: astore_3
    //   35: aload_3
    //   36: astore_0
    //   37: aload_1
    //   38: ifnull +33 -> 71
    //   41: aload_3
    //   42: astore_0
    //   43: aload_1
    //   44: arraylength
    //   45: iconst_1
    //   46: if_icmplt +25 -> 71
    //   49: new 53	java/lang/StringBuilder
    //   52: dup
    //   53: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   56: ldc 51
    //   58: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: aload_1
    //   62: iconst_0
    //   63: aaload
    //   64: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   70: astore_0
    //   71: getstatic 21	com/tencent/mobileqq/utils/ShortcutUtils:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   74: iconst_2
    //   75: new 53	java/lang/StringBuilder
    //   78: dup
    //   79: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   82: ldc 63
    //   84: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: aload 4
    //   89: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: ldc 65
    //   94: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: aload_0
    //   98: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   104: invokestatic 69	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   107: aload 5
    //   109: aload 4
    //   111: invokestatic 75	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   114: aconst_null
    //   115: ldc 77
    //   117: aload_1
    //   118: aconst_null
    //   119: invokevirtual 83	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   122: astore_1
    //   123: aload_1
    //   124: ifnull +30 -> 154
    //   127: aload_1
    //   128: astore_0
    //   129: aload_1
    //   130: invokeinterface 88 1 0
    //   135: istore 7
    //   137: iload 7
    //   139: istore 6
    //   141: aload_1
    //   142: ifnull -130 -> 12
    //   145: aload_1
    //   146: invokeinterface 101 1 0
    //   151: iload 7
    //   153: ireturn
    //   154: aload_1
    //   155: ifnull +9 -> 164
    //   158: aload_1
    //   159: invokeinterface 101 1 0
    //   164: iconst_0
    //   165: ireturn
    //   166: astore_2
    //   167: aconst_null
    //   168: astore_1
    //   169: aload_1
    //   170: astore_0
    //   171: invokestatic 49	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   174: ifeq +34 -> 208
    //   177: aload_1
    //   178: astore_0
    //   179: getstatic 21	com/tencent/mobileqq/utils/ShortcutUtils:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   182: iconst_2
    //   183: new 53	java/lang/StringBuilder
    //   186: dup
    //   187: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   190: ldc 103
    //   192: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: aload_2
    //   196: invokevirtual 104	java/lang/Exception:toString	()Ljava/lang/String;
    //   199: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   205: invokestatic 69	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   208: aload_1
    //   209: ifnull -45 -> 164
    //   212: aload_1
    //   213: invokeinterface 101 1 0
    //   218: goto -54 -> 164
    //   221: astore_0
    //   222: aload_2
    //   223: astore_1
    //   224: aload_1
    //   225: ifnull +9 -> 234
    //   228: aload_1
    //   229: invokeinterface 101 1 0
    //   234: aload_0
    //   235: athrow
    //   236: astore_2
    //   237: aload_0
    //   238: astore_1
    //   239: aload_2
    //   240: astore_0
    //   241: goto -17 -> 224
    //   244: astore_2
    //   245: goto -76 -> 169
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	248	0	paramContext	Context
    //   0	248	1	paramArrayOfString	String[]
    //   1	1	2	localObject1	Object
    //   166	57	2	localException1	Exception
    //   236	4	2	localObject2	Object
    //   244	1	2	localException2	Exception
    //   34	8	3	str1	String
    //   18	92	4	str2	String
    //   24	84	5	localContentResolver	android.content.ContentResolver
    //   10	130	6	bool1	boolean
    //   135	17	7	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   26	32	166	java/lang/Exception
    //   43	71	166	java/lang/Exception
    //   71	107	166	java/lang/Exception
    //   107	123	166	java/lang/Exception
    //   26	32	221	finally
    //   43	71	221	finally
    //   71	107	221	finally
    //   107	123	221	finally
    //   129	137	236	finally
    //   171	177	236	finally
    //   179	208	236	finally
    //   129	137	244	java/lang/Exception
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\utils\ShortcutUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
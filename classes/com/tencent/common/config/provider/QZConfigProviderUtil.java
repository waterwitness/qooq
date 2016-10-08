package com.tencent.common.config.provider;

import NS_UNDEAL_COUNT.entrance_cfg;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.SQLException;
import android.net.Uri;
import android.text.TextUtils;
import com.qq.jce.wup.UniAttribute;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class QZConfigProviderUtil
{
  public static final String a = "unknow";
  public static final boolean a = false;
  public static final String b = "ConfigProvider";
  public static final boolean b = false;
  public static final String c = "NavigationBar";
  public static final String d = "HomepageBar";
  private static final String e = "QZConfigProviderUtil";
  
  public QZConfigProviderUtil()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private static int a(String paramString)
  {
    if ((paramString == null) || (TextUtils.getTrimmedLength(paramString) <= 0)) {}
    do
    {
      return 0;
      try
      {
        int i = BaseApplication.getContext().getContentResolver().delete(QZoneConfigProvider.e, "key=?", new String[] { paramString });
        return i;
      }
      catch (Exception paramString) {}
    } while (!QLog.isColorLevel());
    QLog.e("QZConfigProviderUtil", 2, "deleteOneIspConfig error:" + paramString.getMessage());
    return 0;
  }
  
  private static int a(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (TextUtils.getTrimmedLength(paramString1) <= 0)) {}
    do
    {
      do
      {
        return 0;
      } while ((paramString2 == null) || (TextUtils.getTrimmedLength(paramString2) <= 0));
      try
      {
        int i = BaseApplication.getContext().getContentResolver().delete(QZoneConfigProvider.a, "main_key=? and second_key=? ", new String[] { paramString1, paramString2 });
        return i;
      }
      catch (Exception paramString1) {}
    } while (!QLog.isColorLevel());
    QLog.e("QZConfigProviderUtil", 2, "deleteOneConfig error:" + paramString1.getMessage());
    return 0;
  }
  
  /* Error */
  public static long a()
  {
    // Byte code:
    //   0: invokestatic 47	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3: invokevirtual 51	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   6: getstatic 102	com/tencent/common/config/provider/QZoneConfigProvider:f	Landroid/net/Uri;
    //   9: aconst_null
    //   10: aconst_null
    //   11: aconst_null
    //   12: aconst_null
    //   13: invokevirtual 106	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   16: astore_0
    //   17: aload_0
    //   18: ifnull +39 -> 57
    //   21: aload_0
    //   22: invokeinterface 111 1 0
    //   27: ifeq +30 -> 57
    //   30: aload_0
    //   31: aload_0
    //   32: ldc 113
    //   34: invokeinterface 116 2 0
    //   39: invokeinterface 120 2 0
    //   44: lstore_2
    //   45: aload_0
    //   46: ifnull +9 -> 55
    //   49: aload_0
    //   50: invokeinterface 123 1 0
    //   55: lload_2
    //   56: lreturn
    //   57: aload_0
    //   58: ifnull +9 -> 67
    //   61: aload_0
    //   62: invokeinterface 123 1 0
    //   67: lconst_0
    //   68: lreturn
    //   69: astore_1
    //   70: aconst_null
    //   71: astore_0
    //   72: invokestatic 72	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   75: ifeq +32 -> 107
    //   78: ldc 22
    //   80: iconst_2
    //   81: new 74	java/lang/StringBuilder
    //   84: dup
    //   85: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   88: ldc 125
    //   90: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: aload_1
    //   94: invokevirtual 85	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   97: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   103: aload_1
    //   104: invokestatic 128	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   107: aload_0
    //   108: ifnull -41 -> 67
    //   111: aload_0
    //   112: invokeinterface 123 1 0
    //   117: goto -50 -> 67
    //   120: astore_1
    //   121: aconst_null
    //   122: astore_0
    //   123: aload_0
    //   124: ifnull +9 -> 133
    //   127: aload_0
    //   128: invokeinterface 123 1 0
    //   133: aload_1
    //   134: athrow
    //   135: astore_1
    //   136: goto -13 -> 123
    //   139: astore_1
    //   140: goto -17 -> 123
    //   143: astore_1
    //   144: goto -72 -> 72
    // Local variable table:
    //   start	length	slot	name	signature
    //   16	112	0	localCursor	android.database.Cursor
    //   69	35	1	localException1	Exception
    //   120	14	1	localObject1	Object
    //   135	1	1	localObject2	Object
    //   139	1	1	localObject3	Object
    //   143	1	1	localException2	Exception
    //   44	12	2	l	long
    // Exception table:
    //   from	to	target	type
    //   0	17	69	java/lang/Exception
    //   0	17	120	finally
    //   21	45	135	finally
    //   72	107	139	finally
    //   21	45	143	java/lang/Exception
  }
  
  /* Error */
  private static entrance_cfg a(String paramString, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +10 -> 11
    //   4: aload_0
    //   5: invokestatic 41	android/text/TextUtils:getTrimmedLength	(Ljava/lang/CharSequence;)I
    //   8: ifgt +5 -> 13
    //   11: aconst_null
    //   12: areturn
    //   13: iload_1
    //   14: iflt -3 -> 11
    //   17: iload_1
    //   18: sipush 999
    //   21: if_icmpgt -10 -> 11
    //   24: aload_0
    //   25: ldc -125
    //   27: ldc -123
    //   29: invokevirtual 137	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   32: astore_0
    //   33: new 74	java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   40: aload_0
    //   41: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: ldc -117
    //   46: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: iload_1
    //   50: invokestatic 143	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   53: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   59: astore_0
    //   60: invokestatic 47	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   63: invokevirtual 51	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   66: getstatic 146	com/tencent/common/config/provider/QZoneConfigProvider:g	Landroid/net/Uri;
    //   69: aconst_null
    //   70: ldc -108
    //   72: iconst_1
    //   73: anewarray 60	java/lang/String
    //   76: dup
    //   77: iconst_0
    //   78: aload_0
    //   79: aastore
    //   80: aconst_null
    //   81: invokevirtual 106	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   84: astore_2
    //   85: aload_2
    //   86: ifnull +276 -> 362
    //   89: aload_2
    //   90: invokeinterface 111 1 0
    //   95: ifeq +267 -> 362
    //   98: new 150	NS_UNDEAL_COUNT/entrance_cfg
    //   101: dup
    //   102: aload_2
    //   103: aload_2
    //   104: ldc -104
    //   106: invokeinterface 116 2 0
    //   111: invokeinterface 156 2 0
    //   116: new 60	java/lang/String
    //   119: dup
    //   120: aload_2
    //   121: aload_2
    //   122: ldc -98
    //   124: invokeinterface 116 2 0
    //   129: invokeinterface 161 2 0
    //   134: invokevirtual 165	java/lang/String:getBytes	()[B
    //   137: ldc -89
    //   139: invokespecial 170	java/lang/String:<init>	([BLjava/lang/String;)V
    //   142: new 60	java/lang/String
    //   145: dup
    //   146: aload_2
    //   147: aload_2
    //   148: ldc -84
    //   150: invokeinterface 116 2 0
    //   155: invokeinterface 161 2 0
    //   160: invokevirtual 165	java/lang/String:getBytes	()[B
    //   163: ldc -89
    //   165: invokespecial 170	java/lang/String:<init>	([BLjava/lang/String;)V
    //   168: new 60	java/lang/String
    //   171: dup
    //   172: aload_2
    //   173: aload_2
    //   174: ldc -82
    //   176: invokeinterface 116 2 0
    //   181: invokeinterface 161 2 0
    //   186: invokevirtual 165	java/lang/String:getBytes	()[B
    //   189: ldc -89
    //   191: invokespecial 170	java/lang/String:<init>	([BLjava/lang/String;)V
    //   194: aload_2
    //   195: aload_2
    //   196: ldc -80
    //   198: invokeinterface 116 2 0
    //   203: invokeinterface 156 2 0
    //   208: aload_2
    //   209: aload_2
    //   210: ldc -78
    //   212: invokeinterface 116 2 0
    //   217: invokeinterface 156 2 0
    //   222: invokespecial 181	NS_UNDEAL_COUNT/entrance_cfg:<init>	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;II)V
    //   225: astore_3
    //   226: aload_3
    //   227: astore_0
    //   228: aload_2
    //   229: ifnull +11 -> 240
    //   232: aload_2
    //   233: invokeinterface 123 1 0
    //   238: aload_3
    //   239: astore_0
    //   240: aload_0
    //   241: areturn
    //   242: astore_0
    //   243: aload_0
    //   244: invokevirtual 184	java/lang/Exception:printStackTrace	()V
    //   247: aload_3
    //   248: astore_0
    //   249: goto -9 -> 240
    //   252: astore_2
    //   253: aconst_null
    //   254: astore_0
    //   255: invokestatic 72	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   258: ifeq +31 -> 289
    //   261: ldc 22
    //   263: iconst_2
    //   264: new 74	java/lang/StringBuilder
    //   267: dup
    //   268: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   271: ldc -70
    //   273: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: aload_2
    //   277: invokevirtual 85	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   280: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   286: invokestatic 91	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   289: aload_0
    //   290: ifnull +67 -> 357
    //   293: aload_0
    //   294: invokeinterface 123 1 0
    //   299: aconst_null
    //   300: astore_0
    //   301: goto -61 -> 240
    //   304: astore_0
    //   305: aload_0
    //   306: invokevirtual 184	java/lang/Exception:printStackTrace	()V
    //   309: aconst_null
    //   310: astore_0
    //   311: goto -71 -> 240
    //   314: astore_0
    //   315: aconst_null
    //   316: astore_2
    //   317: aload_2
    //   318: ifnull +9 -> 327
    //   321: aload_2
    //   322: invokeinterface 123 1 0
    //   327: aload_0
    //   328: athrow
    //   329: astore_2
    //   330: aload_2
    //   331: invokevirtual 184	java/lang/Exception:printStackTrace	()V
    //   334: goto -7 -> 327
    //   337: astore_0
    //   338: goto -21 -> 317
    //   341: astore_3
    //   342: aload_0
    //   343: astore_2
    //   344: aload_3
    //   345: astore_0
    //   346: goto -29 -> 317
    //   349: astore_3
    //   350: aload_2
    //   351: astore_0
    //   352: aload_3
    //   353: astore_2
    //   354: goto -99 -> 255
    //   357: aconst_null
    //   358: astore_0
    //   359: goto -119 -> 240
    //   362: aconst_null
    //   363: astore_3
    //   364: goto -138 -> 226
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	367	0	paramString	String
    //   0	367	1	paramInt	int
    //   84	149	2	localCursor	android.database.Cursor
    //   252	25	2	localException1	Exception
    //   316	6	2	localObject1	Object
    //   329	2	2	localException2	Exception
    //   343	11	2	localObject2	Object
    //   225	23	3	localentrance_cfg	entrance_cfg
    //   341	4	3	localObject3	Object
    //   349	4	3	localException3	Exception
    //   363	1	3	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   232	238	242	java/lang/Exception
    //   60	85	252	java/lang/Exception
    //   293	299	304	java/lang/Exception
    //   60	85	314	finally
    //   321	327	329	java/lang/Exception
    //   89	226	337	finally
    //   255	289	341	finally
    //   89	226	349	java/lang/Exception
  }
  
  /* Error */
  public static String a()
  {
    // Byte code:
    //   0: invokestatic 47	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3: invokevirtual 51	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   6: getstatic 188	com/tencent/common/config/provider/QZoneConfigProvider:b	Landroid/net/Uri;
    //   9: aconst_null
    //   10: aconst_null
    //   11: aconst_null
    //   12: aconst_null
    //   13: invokevirtual 106	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   16: astore_1
    //   17: aload_1
    //   18: ifnull +55 -> 73
    //   21: aload_1
    //   22: astore_0
    //   23: aload_1
    //   24: invokeinterface 111 1 0
    //   29: ifeq +44 -> 73
    //   32: aload_1
    //   33: astore_0
    //   34: new 60	java/lang/String
    //   37: dup
    //   38: aload_1
    //   39: aload_1
    //   40: ldc -66
    //   42: invokeinterface 116 2 0
    //   47: invokeinterface 161 2 0
    //   52: invokevirtual 165	java/lang/String:getBytes	()[B
    //   55: ldc -89
    //   57: invokespecial 170	java/lang/String:<init>	([BLjava/lang/String;)V
    //   60: astore_2
    //   61: aload_1
    //   62: ifnull +9 -> 71
    //   65: aload_1
    //   66: invokeinterface 123 1 0
    //   71: aload_2
    //   72: areturn
    //   73: aload_1
    //   74: ifnull +9 -> 83
    //   77: aload_1
    //   78: invokeinterface 123 1 0
    //   83: ldc -123
    //   85: areturn
    //   86: astore_2
    //   87: aconst_null
    //   88: astore_1
    //   89: aload_1
    //   90: astore_0
    //   91: invokestatic 72	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   94: ifeq +34 -> 128
    //   97: aload_1
    //   98: astore_0
    //   99: ldc 22
    //   101: iconst_2
    //   102: new 74	java/lang/StringBuilder
    //   105: dup
    //   106: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   109: ldc -64
    //   111: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: aload_2
    //   115: invokevirtual 85	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   118: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   124: aload_2
    //   125: invokestatic 194	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   128: aload_1
    //   129: ifnull -46 -> 83
    //   132: aload_1
    //   133: invokeinterface 123 1 0
    //   138: goto -55 -> 83
    //   141: astore_1
    //   142: aconst_null
    //   143: astore_0
    //   144: aload_0
    //   145: ifnull +9 -> 154
    //   148: aload_0
    //   149: invokeinterface 123 1 0
    //   154: aload_1
    //   155: athrow
    //   156: astore_1
    //   157: goto -13 -> 144
    //   160: astore_2
    //   161: goto -72 -> 89
    // Local variable table:
    //   start	length	slot	name	signature
    //   22	127	0	localCursor1	android.database.Cursor
    //   16	117	1	localCursor2	android.database.Cursor
    //   141	14	1	localObject1	Object
    //   156	1	1	localObject2	Object
    //   60	12	2	str	String
    //   86	39	2	localException1	Exception
    //   160	1	2	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   0	17	86	java/lang/Exception
    //   0	17	141	finally
    //   23	32	156	finally
    //   34	61	156	finally
    //   91	97	156	finally
    //   99	128	156	finally
    //   23	32	160	java/lang/Exception
    //   34	61	160	java/lang/Exception
  }
  
  /* Error */
  private static String a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +10 -> 11
    //   4: aload_0
    //   5: invokestatic 41	android/text/TextUtils:getTrimmedLength	(Ljava/lang/CharSequence;)I
    //   8: ifgt +7 -> 15
    //   11: aconst_null
    //   12: astore_2
    //   13: aload_2
    //   14: areturn
    //   15: invokestatic 47	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   18: invokevirtual 51	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   21: getstatic 56	com/tencent/common/config/provider/QZoneConfigProvider:e	Landroid/net/Uri;
    //   24: aconst_null
    //   25: ldc 58
    //   27: iconst_1
    //   28: anewarray 60	java/lang/String
    //   31: dup
    //   32: iconst_0
    //   33: aload_0
    //   34: aastore
    //   35: aconst_null
    //   36: invokevirtual 106	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   39: astore_0
    //   40: aload_0
    //   41: ifnull +138 -> 179
    //   44: aload_0
    //   45: astore_1
    //   46: aload_0
    //   47: invokeinterface 111 1 0
    //   52: ifeq +127 -> 179
    //   55: aload_0
    //   56: astore_1
    //   57: new 60	java/lang/String
    //   60: dup
    //   61: aload_0
    //   62: aload_0
    //   63: ldc -59
    //   65: invokeinterface 116 2 0
    //   70: invokeinterface 161 2 0
    //   75: invokevirtual 165	java/lang/String:getBytes	()[B
    //   78: ldc -89
    //   80: invokespecial 170	java/lang/String:<init>	([BLjava/lang/String;)V
    //   83: astore_2
    //   84: aload_2
    //   85: astore_1
    //   86: aload_1
    //   87: astore_2
    //   88: aload_0
    //   89: ifnull -76 -> 13
    //   92: aload_0
    //   93: invokeinterface 123 1 0
    //   98: aload_1
    //   99: areturn
    //   100: astore_2
    //   101: aconst_null
    //   102: astore_0
    //   103: aload_0
    //   104: astore_1
    //   105: invokestatic 72	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   108: ifeq +34 -> 142
    //   111: aload_0
    //   112: astore_1
    //   113: ldc 22
    //   115: iconst_2
    //   116: new 74	java/lang/StringBuilder
    //   119: dup
    //   120: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   123: ldc -57
    //   125: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: aload_2
    //   129: invokevirtual 85	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   132: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   138: aload_2
    //   139: invokestatic 128	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   142: aload_0
    //   143: ifnull +34 -> 177
    //   146: aload_0
    //   147: invokeinterface 123 1 0
    //   152: aconst_null
    //   153: areturn
    //   154: astore_0
    //   155: aconst_null
    //   156: astore_1
    //   157: aload_1
    //   158: ifnull +9 -> 167
    //   161: aload_1
    //   162: invokeinterface 123 1 0
    //   167: aload_0
    //   168: athrow
    //   169: astore_0
    //   170: goto -13 -> 157
    //   173: astore_2
    //   174: goto -71 -> 103
    //   177: aconst_null
    //   178: areturn
    //   179: aconst_null
    //   180: astore_1
    //   181: goto -95 -> 86
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	184	0	paramString	String
    //   45	136	1	localObject1	Object
    //   12	76	2	localObject2	Object
    //   100	39	2	localException1	Exception
    //   173	1	2	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   15	40	100	java/lang/Exception
    //   15	40	154	finally
    //   46	55	169	finally
    //   57	84	169	finally
    //   105	111	169	finally
    //   113	142	169	finally
    //   46	55	173	java/lang/Exception
    //   57	84	173	java/lang/Exception
  }
  
  /* Error */
  public static String a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +10 -> 11
    //   4: aload_0
    //   5: invokestatic 41	android/text/TextUtils:getTrimmedLength	(Ljava/lang/CharSequence;)I
    //   8: ifgt +5 -> 13
    //   11: aconst_null
    //   12: areturn
    //   13: aload_1
    //   14: ifnull -3 -> 11
    //   17: aload_1
    //   18: invokestatic 41	android/text/TextUtils:getTrimmedLength	(Ljava/lang/CharSequence;)I
    //   21: ifle -10 -> 11
    //   24: invokestatic 47	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   27: invokevirtual 51	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   30: getstatic 94	com/tencent/common/config/provider/QZoneConfigProvider:a	Landroid/net/Uri;
    //   33: aconst_null
    //   34: ldc -54
    //   36: iconst_2
    //   37: anewarray 60	java/lang/String
    //   40: dup
    //   41: iconst_0
    //   42: aload_0
    //   43: aastore
    //   44: dup
    //   45: iconst_1
    //   46: aload_1
    //   47: aastore
    //   48: aconst_null
    //   49: invokevirtual 106	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   52: astore_1
    //   53: aload_1
    //   54: ifnull +159 -> 213
    //   57: aload_1
    //   58: astore_0
    //   59: aload_1
    //   60: invokeinterface 111 1 0
    //   65: ifeq +148 -> 213
    //   68: aload_1
    //   69: astore_0
    //   70: aload_1
    //   71: aload_1
    //   72: ldc -59
    //   74: invokeinterface 116 2 0
    //   79: invokeinterface 161 2 0
    //   84: astore_2
    //   85: aload_2
    //   86: astore_0
    //   87: aload_1
    //   88: ifnull +11 -> 99
    //   91: aload_1
    //   92: invokeinterface 123 1 0
    //   97: aload_2
    //   98: astore_0
    //   99: aload_0
    //   100: areturn
    //   101: astore_0
    //   102: aload_0
    //   103: invokevirtual 184	java/lang/Exception:printStackTrace	()V
    //   106: aload_2
    //   107: astore_0
    //   108: goto -9 -> 99
    //   111: astore_2
    //   112: aconst_null
    //   113: astore_1
    //   114: aload_1
    //   115: astore_0
    //   116: invokestatic 72	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   119: ifeq +33 -> 152
    //   122: aload_1
    //   123: astore_0
    //   124: ldc 22
    //   126: iconst_2
    //   127: new 74	java/lang/StringBuilder
    //   130: dup
    //   131: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   134: ldc -52
    //   136: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: aload_2
    //   140: invokevirtual 85	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   143: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   149: invokestatic 91	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   152: aload_1
    //   153: ifnull +55 -> 208
    //   156: aload_1
    //   157: invokeinterface 123 1 0
    //   162: aconst_null
    //   163: astore_0
    //   164: goto -65 -> 99
    //   167: astore_0
    //   168: aload_0
    //   169: invokevirtual 184	java/lang/Exception:printStackTrace	()V
    //   172: aconst_null
    //   173: astore_0
    //   174: goto -75 -> 99
    //   177: astore_1
    //   178: aconst_null
    //   179: astore_0
    //   180: aload_0
    //   181: ifnull +9 -> 190
    //   184: aload_0
    //   185: invokeinterface 123 1 0
    //   190: aload_1
    //   191: athrow
    //   192: astore_0
    //   193: aload_0
    //   194: invokevirtual 184	java/lang/Exception:printStackTrace	()V
    //   197: goto -7 -> 190
    //   200: astore_1
    //   201: goto -21 -> 180
    //   204: astore_2
    //   205: goto -91 -> 114
    //   208: aconst_null
    //   209: astore_0
    //   210: goto -111 -> 99
    //   213: aconst_null
    //   214: astore_2
    //   215: goto -130 -> 85
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	218	0	paramString1	String
    //   0	218	1	paramString2	String
    //   84	23	2	str	String
    //   111	29	2	localException1	Exception
    //   204	1	2	localException2	Exception
    //   214	1	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   91	97	101	java/lang/Exception
    //   24	53	111	java/lang/Exception
    //   156	162	167	java/lang/Exception
    //   24	53	177	finally
    //   184	190	192	java/lang/Exception
    //   59	68	200	finally
    //   70	85	200	finally
    //   116	122	200	finally
    //   124	152	200	finally
    //   59	68	204	java/lang/Exception
    //   70	85	204	java/lang/Exception
  }
  
  /* Error */
  public static Map a()
  {
    // Byte code:
    //   0: new 207	java/util/HashMap
    //   3: dup
    //   4: invokespecial 208	java/util/HashMap:<init>	()V
    //   7: astore_2
    //   8: invokestatic 47	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   11: invokevirtual 51	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   14: getstatic 56	com/tencent/common/config/provider/QZoneConfigProvider:e	Landroid/net/Uri;
    //   17: aconst_null
    //   18: aconst_null
    //   19: aconst_null
    //   20: aconst_null
    //   21: invokevirtual 106	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   24: astore_1
    //   25: aload_1
    //   26: ifnull +88 -> 114
    //   29: aload_1
    //   30: astore_0
    //   31: aload_1
    //   32: invokeinterface 111 1 0
    //   37: ifeq +77 -> 114
    //   40: aload_1
    //   41: astore_0
    //   42: aload_2
    //   43: new 60	java/lang/String
    //   46: dup
    //   47: aload_1
    //   48: aload_1
    //   49: ldc -46
    //   51: invokeinterface 116 2 0
    //   56: invokeinterface 161 2 0
    //   61: invokevirtual 165	java/lang/String:getBytes	()[B
    //   64: ldc -89
    //   66: invokespecial 170	java/lang/String:<init>	([BLjava/lang/String;)V
    //   69: new 60	java/lang/String
    //   72: dup
    //   73: aload_1
    //   74: aload_1
    //   75: ldc -59
    //   77: invokeinterface 116 2 0
    //   82: invokeinterface 161 2 0
    //   87: invokevirtual 165	java/lang/String:getBytes	()[B
    //   90: ldc -89
    //   92: invokespecial 170	java/lang/String:<init>	([BLjava/lang/String;)V
    //   95: invokeinterface 216 3 0
    //   100: pop
    //   101: aload_1
    //   102: astore_0
    //   103: aload_1
    //   104: invokeinterface 219 1 0
    //   109: istore_3
    //   110: iload_3
    //   111: ifne -71 -> 40
    //   114: aload_1
    //   115: ifnull +9 -> 124
    //   118: aload_1
    //   119: invokeinterface 123 1 0
    //   124: aload_2
    //   125: areturn
    //   126: astore_2
    //   127: aconst_null
    //   128: astore_1
    //   129: aload_1
    //   130: astore_0
    //   131: invokestatic 72	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   134: ifeq +34 -> 168
    //   137: aload_1
    //   138: astore_0
    //   139: ldc 22
    //   141: iconst_2
    //   142: new 74	java/lang/StringBuilder
    //   145: dup
    //   146: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   149: ldc -35
    //   151: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: aload_2
    //   155: invokevirtual 85	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   158: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   164: aload_2
    //   165: invokestatic 128	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   168: aload_1
    //   169: ifnull +9 -> 178
    //   172: aload_1
    //   173: invokeinterface 123 1 0
    //   178: aconst_null
    //   179: areturn
    //   180: astore_1
    //   181: aconst_null
    //   182: astore_0
    //   183: aload_0
    //   184: ifnull +9 -> 193
    //   187: aload_0
    //   188: invokeinterface 123 1 0
    //   193: aload_1
    //   194: athrow
    //   195: astore_1
    //   196: goto -13 -> 183
    //   199: astore_2
    //   200: goto -71 -> 129
    // Local variable table:
    //   start	length	slot	name	signature
    //   30	158	0	localCursor1	android.database.Cursor
    //   24	149	1	localCursor2	android.database.Cursor
    //   180	14	1	localObject1	Object
    //   195	1	1	localObject2	Object
    //   7	118	2	localHashMap	java.util.HashMap
    //   126	39	2	localException1	Exception
    //   199	1	2	localException2	Exception
    //   109	2	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   8	25	126	java/lang/Exception
    //   8	25	180	finally
    //   31	40	195	finally
    //   42	101	195	finally
    //   103	110	195	finally
    //   131	137	195	finally
    //   139	168	195	finally
    //   31	40	199	java/lang/Exception
    //   42	101	199	java/lang/Exception
    //   103	110	199	java/lang/Exception
  }
  
  public static void a()
  {
    try
    {
      BaseApplication.getContext().getContentResolver().delete(QZoneConfigProvider.d, null, null);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("QZConfigProviderUtil", 2, "database clear error" + localException.getMessage(), localException);
    }
  }
  
  public static void a(long paramLong)
  {
    if (paramLong <= 0L) {
      return;
    }
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("check_time", Long.valueOf(paramLong));
    if (QLog.isColorLevel()) {
      QLog.d("QZConfigProviderUtil", 2, "saveIspCheckTime time:" + paramLong);
    }
    try
    {
      BaseApplication.getContext().getContentResolver().insert(QZoneConfigProvider.f, localContentValues);
      localContentValues.clear();
      return;
    }
    catch (SQLException localSQLException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("QZConfigProviderUtil", 2, "saveIspCheckTime error :" + localSQLException.getMessage(), localSQLException);
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("QZConfigProviderUtil", 2, "saveIspCheckTime error :" + localException.getMessage(), localException);
        }
      }
    }
  }
  
  public static void a(String paramString)
  {
    ContentValues localContentValues = new ContentValues();
    String str;
    if (paramString == null)
    {
      str = "";
      localContentValues.put("cookie", str);
      QLog.i("ConfigProvider", 1, "saveConfigCookie cookie" + paramString);
    }
    for (;;)
    {
      try
      {
        paramString = BaseApplication.getContext().getContentResolver().insert(QZoneConfigProvider.b, localContentValues);
        if (paramString == null) {
          continue;
        }
        QLog.i("QZConfigProviderUtil", 1, paramString.toString() + " saveConfigCookie done.");
      }
      catch (SQLException paramString)
      {
        QLog.e("QZConfigProviderUtil", 1, "saveConfigCookie error:" + paramString.getMessage(), paramString);
        continue;
      }
      catch (Exception paramString)
      {
        QLog.e("QZConfigProviderUtil", 1, "saveConfigCookie error:" + paramString.getMessage(), paramString);
        continue;
      }
      localContentValues.clear();
      return;
      str = paramString;
      break;
      QLog.e("QZConfigProviderUtil", 1, "saveConfigCookie error!");
    }
  }
  
  public static void a(String paramString, ArrayList paramArrayList)
  {
    if (paramArrayList == null) {}
    for (;;)
    {
      return;
      if (paramArrayList.size() != 0)
      {
        paramArrayList = paramArrayList.iterator();
        while (paramArrayList.hasNext()) {
          a(paramString, (entrance_cfg)paramArrayList.next());
        }
      }
    }
  }
  
  public static void a(Map paramMap)
  {
    if (paramMap == null) {}
    for (;;)
    {
      return;
      if (!paramMap.isEmpty())
      {
        Iterator localIterator = paramMap.keySet().iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          a(str, (String)paramMap.get(str));
        }
      }
    }
  }
  
  public static void a(Map paramMap, String paramString1, String paramString2)
  {
    boolean bool = a(paramMap, paramString2);
    if ((b("PhotoUpload")) && (b("PhotoSvrList"))) {
      if (bool) {
        a(paramString1);
      }
    }
    for (;;)
    {
      a(paramString2);
      return;
      a("");
    }
  }
  
  public static boolean a(String paramString)
  {
    if ((paramString == null) || (TextUtils.getTrimmedLength(paramString) <= 0)) {
      return false;
    }
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("updatelog", paramString);
    try
    {
      BaseApplication.getContext().getContentResolver().insert(QZoneConfigProvider.c, localContentValues);
      return true;
    }
    catch (SQLException paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QZConfigProviderUtil", 1, "recUpdateSource error:" + paramString.getMessage(), paramString);
      }
      return false;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QZConfigProviderUtil", 1, "recUpdateSource error:" + paramString.getMessage(), paramString);
      }
      return false;
    }
    finally
    {
      localContentValues.clear();
    }
  }
  
  private static boolean a(String paramString, entrance_cfg paramentrance_cfg)
  {
    if ((paramString == null) || (TextUtils.isEmpty(paramString))) {}
    String str;
    do
    {
      do
      {
        return false;
      } while ((paramentrance_cfg == null) || (paramentrance_cfg.iEntranceId < 0) || (paramentrance_cfg.iEntranceId > 999));
      str = paramString.replace(" ", "");
      if (QLog.isColorLevel()) {
        QLog.e("QZConfigProviderUtil", 2, "********* insertNavigatorConfigItem ******** rsp return navigator item id:" + paramentrance_cfg.iEntranceId + " item name: " + paramentrance_cfg.sEntranceName + " item icon: " + paramentrance_cfg.sEntranceIcon + " item action: " + paramentrance_cfg.sEntranceAction);
      }
    } while ((TextUtils.isEmpty(str)) || (TextUtils.isEmpty(paramentrance_cfg.sEntranceName)));
    paramString = new ContentValues();
    paramString.put("uin", str + "&" + paramentrance_cfg.iEntranceId);
    paramString.put("entraceid", Integer.valueOf(paramentrance_cfg.iEntranceId));
    paramString.put("entracename", paramentrance_cfg.sEntranceName);
    paramString.put("entraceicon", paramentrance_cfg.sEntranceIcon);
    paramString.put("entraceaction", paramentrance_cfg.sEntranceAction);
    paramString.put("isDefault", Integer.valueOf(paramentrance_cfg.isDefualt));
    paramString.put("tabid", Integer.valueOf(paramentrance_cfg.tabid));
    try
    {
      BaseApplication.getContext().getContentResolver().insert(QZoneConfigProvider.g, paramString);
      return true;
    }
    catch (SQLException paramentrance_cfg)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QZConfigProviderUtil", 2, "insertNavigatorConfigItem error:" + paramentrance_cfg.getMessage(), paramentrance_cfg);
      }
      return false;
    }
    catch (Exception paramentrance_cfg)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QZConfigProviderUtil", 2, "insertNavigatorConfigItem error:" + paramentrance_cfg.getMessage(), paramentrance_cfg);
      }
      return false;
    }
    finally
    {
      paramString.clear();
    }
  }
  
  private static boolean a(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (TextUtils.getTrimmedLength(paramString1) <= 0)) {}
    while ((paramString2 == null) || (TextUtils.getTrimmedLength(paramString2) <= 0)) {
      return false;
    }
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("key", paramString1);
    localContentValues.put("value", paramString2);
    try
    {
      BaseApplication.getContext().getContentResolver().insert(QZoneConfigProvider.e, localContentValues);
      return true;
    }
    catch (SQLException paramString1)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QZConfigProviderUtil", 2, "insertUpdateIspConfigItem error:" + paramString1.getMessage(), paramString1);
      }
      return false;
    }
    catch (Exception paramString1)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QZConfigProviderUtil", 2, "insertUpdateIspConfigItem error:" + paramString1.getMessage(), paramString1);
      }
      return false;
    }
    finally
    {
      localContentValues.clear();
    }
  }
  
  /* Error */
  public static boolean a(String paramString, ArrayList paramArrayList)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +10 -> 11
    //   4: aload_0
    //   5: invokestatic 41	android/text/TextUtils:getTrimmedLength	(Ljava/lang/CharSequence;)I
    //   8: ifgt +5 -> 13
    //   11: iconst_0
    //   12: ireturn
    //   13: aload_1
    //   14: ifnull -3 -> 11
    //   17: aload_1
    //   18: invokevirtual 384	java/util/ArrayList:clear	()V
    //   21: aload_0
    //   22: ldc -125
    //   24: ldc -123
    //   26: invokevirtual 137	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   29: astore_0
    //   30: new 74	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   37: ldc_w 386
    //   40: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: aload_0
    //   44: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: ldc_w 388
    //   50: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   56: astore_0
    //   57: invokestatic 47	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   60: invokevirtual 51	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   63: getstatic 146	com/tencent/common/config/provider/QZoneConfigProvider:g	Landroid/net/Uri;
    //   66: aconst_null
    //   67: aload_0
    //   68: aconst_null
    //   69: aconst_null
    //   70: invokevirtual 106	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   73: astore_0
    //   74: aload_0
    //   75: ifnull +155 -> 230
    //   78: aload_0
    //   79: invokeinterface 111 1 0
    //   84: ifeq +146 -> 230
    //   87: aload_1
    //   88: new 150	NS_UNDEAL_COUNT/entrance_cfg
    //   91: dup
    //   92: aload_0
    //   93: aload_0
    //   94: ldc -104
    //   96: invokeinterface 116 2 0
    //   101: invokeinterface 156 2 0
    //   106: new 60	java/lang/String
    //   109: dup
    //   110: aload_0
    //   111: aload_0
    //   112: ldc -98
    //   114: invokeinterface 116 2 0
    //   119: invokeinterface 161 2 0
    //   124: invokevirtual 165	java/lang/String:getBytes	()[B
    //   127: ldc -89
    //   129: invokespecial 170	java/lang/String:<init>	([BLjava/lang/String;)V
    //   132: new 60	java/lang/String
    //   135: dup
    //   136: aload_0
    //   137: aload_0
    //   138: ldc -84
    //   140: invokeinterface 116 2 0
    //   145: invokeinterface 161 2 0
    //   150: invokevirtual 165	java/lang/String:getBytes	()[B
    //   153: ldc -89
    //   155: invokespecial 170	java/lang/String:<init>	([BLjava/lang/String;)V
    //   158: new 60	java/lang/String
    //   161: dup
    //   162: aload_0
    //   163: aload_0
    //   164: ldc -82
    //   166: invokeinterface 116 2 0
    //   171: invokeinterface 161 2 0
    //   176: invokevirtual 165	java/lang/String:getBytes	()[B
    //   179: ldc -89
    //   181: invokespecial 170	java/lang/String:<init>	([BLjava/lang/String;)V
    //   184: aload_0
    //   185: aload_0
    //   186: ldc -80
    //   188: invokeinterface 116 2 0
    //   193: invokeinterface 156 2 0
    //   198: aload_0
    //   199: aload_0
    //   200: ldc -78
    //   202: invokeinterface 116 2 0
    //   207: invokeinterface 156 2 0
    //   212: invokespecial 181	NS_UNDEAL_COUNT/entrance_cfg:<init>	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;II)V
    //   215: invokevirtual 392	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   218: pop
    //   219: aload_0
    //   220: invokeinterface 219 1 0
    //   225: istore_2
    //   226: iload_2
    //   227: ifne -140 -> 87
    //   230: aload_0
    //   231: ifnull -220 -> 11
    //   234: aload_0
    //   235: invokeinterface 123 1 0
    //   240: iconst_0
    //   241: ireturn
    //   242: astore_1
    //   243: aconst_null
    //   244: astore_0
    //   245: invokestatic 72	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   248: ifeq +33 -> 281
    //   251: ldc 22
    //   253: iconst_2
    //   254: new 74	java/lang/StringBuilder
    //   257: dup
    //   258: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   261: ldc_w 394
    //   264: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: aload_1
    //   268: invokevirtual 85	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   271: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   277: aload_1
    //   278: invokestatic 128	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   281: aload_0
    //   282: ifnull -271 -> 11
    //   285: aload_0
    //   286: invokeinterface 123 1 0
    //   291: iconst_0
    //   292: ireturn
    //   293: astore_1
    //   294: aconst_null
    //   295: astore_0
    //   296: aload_0
    //   297: ifnull +9 -> 306
    //   300: aload_0
    //   301: invokeinterface 123 1 0
    //   306: aload_1
    //   307: athrow
    //   308: astore_1
    //   309: goto -13 -> 296
    //   312: astore_1
    //   313: goto -17 -> 296
    //   316: astore_1
    //   317: goto -72 -> 245
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	320	0	paramString	String
    //   0	320	1	paramArrayList	ArrayList
    //   225	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   57	74	242	java/lang/Exception
    //   57	74	293	finally
    //   78	87	308	finally
    //   87	226	308	finally
    //   245	281	312	finally
    //   78	87	316	java/lang/Exception
    //   87	226	316	java/lang/Exception
  }
  
  /* Error */
  public static boolean a(Map paramMap)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokeinterface 396 1 0
    //   6: invokestatic 47	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   9: invokevirtual 51	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   12: getstatic 94	com/tencent/common/config/provider/QZoneConfigProvider:a	Landroid/net/Uri;
    //   15: aconst_null
    //   16: aconst_null
    //   17: aconst_null
    //   18: aconst_null
    //   19: invokevirtual 106	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   22: astore_2
    //   23: aload_2
    //   24: astore_1
    //   25: aload_2
    //   26: invokeinterface 219 1 0
    //   31: ifeq +147 -> 178
    //   34: aload_2
    //   35: astore_1
    //   36: aload_2
    //   37: iconst_0
    //   38: invokeinterface 161 2 0
    //   43: astore 5
    //   45: aload_2
    //   46: astore_1
    //   47: aload_2
    //   48: iconst_1
    //   49: invokeinterface 161 2 0
    //   54: astore 6
    //   56: aload 5
    //   58: ifnull -35 -> 23
    //   61: aload 6
    //   63: ifnull -40 -> 23
    //   66: aload_2
    //   67: astore_1
    //   68: aload_2
    //   69: iconst_2
    //   70: invokeinterface 161 2 0
    //   75: astore 7
    //   77: aload_2
    //   78: astore_1
    //   79: aload_0
    //   80: aload 5
    //   82: invokeinterface 312 2 0
    //   87: checkcast 398	java/util/concurrent/ConcurrentHashMap
    //   90: astore 4
    //   92: aload 4
    //   94: astore_3
    //   95: aload 4
    //   97: ifnonnull +25 -> 122
    //   100: aload_2
    //   101: astore_1
    //   102: new 398	java/util/concurrent/ConcurrentHashMap
    //   105: dup
    //   106: invokespecial 399	java/util/concurrent/ConcurrentHashMap:<init>	()V
    //   109: astore_3
    //   110: aload_2
    //   111: astore_1
    //   112: aload_0
    //   113: aload 5
    //   115: aload_3
    //   116: invokeinterface 216 3 0
    //   121: pop
    //   122: aload_3
    //   123: ifnull -100 -> 23
    //   126: aload_2
    //   127: astore_1
    //   128: aload_3
    //   129: aload 6
    //   131: aload 7
    //   133: invokevirtual 400	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   136: pop
    //   137: goto -114 -> 23
    //   140: astore_0
    //   141: aload_2
    //   142: astore_1
    //   143: invokestatic 72	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   146: ifeq +15 -> 161
    //   149: aload_2
    //   150: astore_1
    //   151: ldc 22
    //   153: iconst_2
    //   154: ldc_w 402
    //   157: aload_0
    //   158: invokestatic 128	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   161: aload_2
    //   162: astore_1
    //   163: aload_0
    //   164: athrow
    //   165: astore_0
    //   166: aload_1
    //   167: ifnull +9 -> 176
    //   170: aload_1
    //   171: invokeinterface 123 1 0
    //   176: aload_0
    //   177: athrow
    //   178: aload_2
    //   179: ifnull +9 -> 188
    //   182: aload_2
    //   183: invokeinterface 123 1 0
    //   188: iconst_1
    //   189: ireturn
    //   190: astore_0
    //   191: invokestatic 72	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   194: ifeq +13 -> 207
    //   197: ldc 22
    //   199: iconst_2
    //   200: ldc_w 402
    //   203: aload_0
    //   204: invokestatic 128	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   207: aload_0
    //   208: athrow
    //   209: astore_0
    //   210: invokestatic 72	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   213: ifeq +13 -> 226
    //   216: ldc 22
    //   218: iconst_2
    //   219: ldc_w 402
    //   222: aload_0
    //   223: invokestatic 128	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   226: aload_0
    //   227: athrow
    //   228: astore_0
    //   229: aconst_null
    //   230: astore_1
    //   231: goto -65 -> 166
    //   234: astore_0
    //   235: aconst_null
    //   236: astore_2
    //   237: goto -96 -> 141
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	240	0	paramMap	Map
    //   24	207	1	localCursor1	android.database.Cursor
    //   22	215	2	localCursor2	android.database.Cursor
    //   94	35	3	localConcurrentHashMap1	java.util.concurrent.ConcurrentHashMap
    //   90	6	4	localConcurrentHashMap2	java.util.concurrent.ConcurrentHashMap
    //   43	71	5	str1	String
    //   54	76	6	str2	String
    //   75	57	7	str3	String
    // Exception table:
    //   from	to	target	type
    //   25	34	140	java/lang/Exception
    //   36	45	140	java/lang/Exception
    //   47	56	140	java/lang/Exception
    //   68	77	140	java/lang/Exception
    //   79	92	140	java/lang/Exception
    //   102	110	140	java/lang/Exception
    //   112	122	140	java/lang/Exception
    //   128	137	140	java/lang/Exception
    //   25	34	165	finally
    //   36	45	165	finally
    //   47	56	165	finally
    //   68	77	165	finally
    //   79	92	165	finally
    //   102	110	165	finally
    //   112	122	165	finally
    //   128	137	165	finally
    //   143	149	165	finally
    //   151	161	165	finally
    //   163	165	165	finally
    //   182	188	190	java/lang/Exception
    //   170	176	209	java/lang/Exception
    //   0	23	228	finally
    //   0	23	234	java/lang/Exception
  }
  
  private static boolean a(Map paramMap, String paramString)
  {
    if (paramMap == null) {}
    while (paramMap.isEmpty()) {
      return false;
    }
    paramString = paramMap.keySet();
    QLog.i("QZConfigProviderUtil", 1, "saveConfig mainkey count:" + paramString.size());
    localArrayList = new ArrayList();
    Iterator localIterator1 = paramString.iterator();
    while (localIterator1.hasNext())
    {
      paramString = (String)localIterator1.next();
      Object localObject1 = (byte[])paramMap.get(paramString);
      if ((paramString != null) && (localObject1 != null) && (localObject1.length > 0))
      {
        QLog.i("QZConfigProviderUtil", 1, "saveConfig mainKey:" + paramString);
        UniAttribute localUniAttribute = new UniAttribute();
        if ((paramString.equalsIgnoreCase("NavigationBar")) || (paramString.equalsIgnoreCase("HomepageBar"))) {
          localUniAttribute.setEncodeName("utf-8");
        }
        localUniAttribute.decode((byte[])localObject1);
        Iterator localIterator2 = localUniAttribute.getKeySet().iterator();
        while (localIterator2.hasNext())
        {
          Object localObject2 = (String)localIterator2.next();
          String str = (String)localUniAttribute.get((String)localObject2);
          localObject1 = paramString;
          if (paramString != null)
          {
            localObject1 = paramString;
            if (localObject2 != null)
            {
              QLog.i("QZConfigProviderUtil", 2, " main key:" + paramString + " second key:" + (String)localObject2 + " value:" + str);
              localObject1 = paramString.toLowerCase();
              paramString = ((String)localObject2).toLowerCase();
              localObject2 = new ContentValues();
              ((ContentValues)localObject2).put("main_key", (String)localObject1);
              ((ContentValues)localObject2).put("second_key", paramString);
              ((ContentValues)localObject2).put("value", str);
              QzoneConfig.a().a((String)localObject1, paramString, str);
              localArrayList.add(localObject2);
            }
          }
          paramString = (String)localObject1;
        }
      }
    }
    try
    {
      BaseApplication.getContext().getContentResolver().bulkInsert(QZoneConfigProvider.a, (ContentValues[])localArrayList.toArray(new ContentValues[localArrayList.size()]));
      localArrayList.clear();
      bool = true;
    }
    catch (SQLException paramMap)
    {
      for (;;)
      {
        QLog.e("QZConfigProviderUtil", 1, "saveConfig error:" + paramMap.getMessage());
        localArrayList.clear();
        bool = false;
      }
    }
    catch (Exception paramMap)
    {
      for (;;)
      {
        QLog.e("QZConfigProviderUtil", 1, "saveConfig error:" + paramMap.getMessage());
        localArrayList.clear();
        boolean bool = false;
      }
    }
    finally
    {
      localArrayList.clear();
    }
    return bool;
  }
  
  /* Error */
  public static String b()
  {
    // Byte code:
    //   0: invokestatic 47	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3: invokevirtual 51	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   6: getstatic 334	com/tencent/common/config/provider/QZoneConfigProvider:c	Landroid/net/Uri;
    //   9: aconst_null
    //   10: aconst_null
    //   11: aconst_null
    //   12: aconst_null
    //   13: invokevirtual 106	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   16: astore_0
    //   17: aload_0
    //   18: ifnull +128 -> 146
    //   21: aload_0
    //   22: astore_1
    //   23: aload_0
    //   24: invokeinterface 111 1 0
    //   29: ifeq +117 -> 146
    //   32: aload_0
    //   33: astore_1
    //   34: aload_0
    //   35: aload_0
    //   36: ldc_w 332
    //   39: invokeinterface 116 2 0
    //   44: invokeinterface 161 2 0
    //   49: astore_2
    //   50: aload_2
    //   51: astore_1
    //   52: aload_0
    //   53: ifnull +9 -> 62
    //   56: aload_0
    //   57: invokeinterface 123 1 0
    //   62: aload_1
    //   63: areturn
    //   64: astore_2
    //   65: aconst_null
    //   66: astore_0
    //   67: aload_0
    //   68: astore_1
    //   69: invokestatic 72	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   72: ifeq +35 -> 107
    //   75: aload_0
    //   76: astore_1
    //   77: ldc 22
    //   79: iconst_2
    //   80: new 74	java/lang/StringBuilder
    //   83: dup
    //   84: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   87: ldc_w 464
    //   90: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: aload_2
    //   94: invokevirtual 85	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   97: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   103: aload_2
    //   104: invokestatic 128	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   107: aload_0
    //   108: ifnull +35 -> 143
    //   111: aload_0
    //   112: invokeinterface 123 1 0
    //   117: ldc -123
    //   119: areturn
    //   120: astore_0
    //   121: aconst_null
    //   122: astore_1
    //   123: aload_1
    //   124: ifnull +9 -> 133
    //   127: aload_1
    //   128: invokeinterface 123 1 0
    //   133: aload_0
    //   134: athrow
    //   135: astore_0
    //   136: goto -13 -> 123
    //   139: astore_2
    //   140: goto -73 -> 67
    //   143: ldc -123
    //   145: areturn
    //   146: ldc -123
    //   148: astore_1
    //   149: goto -97 -> 52
    // Local variable table:
    //   start	length	slot	name	signature
    //   16	96	0	localCursor	android.database.Cursor
    //   120	14	0	localObject1	Object
    //   135	1	0	localObject2	Object
    //   22	127	1	localObject3	Object
    //   49	2	2	str	String
    //   64	40	2	localException1	Exception
    //   139	1	2	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   0	17	64	java/lang/Exception
    //   0	17	120	finally
    //   23	32	135	finally
    //   34	50	135	finally
    //   69	75	135	finally
    //   77	107	135	finally
    //   23	32	139	java/lang/Exception
    //   34	50	139	java/lang/Exception
  }
  
  private static void b()
  {
    try
    {
      BaseApplication.getContext().getContentResolver().delete(QZoneConfigProvider.b, null, null);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("QZConfigProviderUtil", 2, "deleteCookie error " + localException.getMessage(), localException);
    }
  }
  
  /* Error */
  private static boolean b(String paramString)
  {
    // Byte code:
    //   0: invokestatic 47	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3: invokevirtual 51	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   6: getstatic 94	com/tencent/common/config/provider/QZoneConfigProvider:a	Landroid/net/Uri;
    //   9: iconst_1
    //   10: anewarray 60	java/lang/String
    //   13: dup
    //   14: iconst_0
    //   15: ldc_w 468
    //   18: aastore
    //   19: ldc_w 470
    //   22: iconst_1
    //   23: anewarray 60	java/lang/String
    //   26: dup
    //   27: iconst_0
    //   28: aload_0
    //   29: aastore
    //   30: aconst_null
    //   31: invokevirtual 106	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   34: astore_2
    //   35: aload_2
    //   36: ifnull +169 -> 205
    //   39: aload_2
    //   40: astore_1
    //   41: aload_2
    //   42: invokeinterface 473 1 0
    //   47: istore 4
    //   49: iload 4
    //   51: ifne +31 -> 82
    //   54: iconst_0
    //   55: istore 4
    //   57: iload 4
    //   59: istore 5
    //   61: aload_2
    //   62: ifnull +13 -> 75
    //   65: aload_2
    //   66: invokeinterface 123 1 0
    //   71: iload 4
    //   73: istore 5
    //   75: iload 5
    //   77: ifle +112 -> 189
    //   80: iconst_1
    //   81: ireturn
    //   82: aload_2
    //   83: astore_1
    //   84: aload_2
    //   85: invokeinterface 111 1 0
    //   90: pop
    //   91: aload_2
    //   92: astore_1
    //   93: aload_2
    //   94: iconst_0
    //   95: invokeinterface 156 2 0
    //   100: istore 4
    //   102: goto -45 -> 57
    //   105: astore_3
    //   106: aconst_null
    //   107: astore_2
    //   108: aload_2
    //   109: astore_1
    //   110: invokestatic 72	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   113: ifeq +45 -> 158
    //   116: aload_2
    //   117: astore_1
    //   118: ldc 22
    //   120: iconst_2
    //   121: new 74	java/lang/StringBuilder
    //   124: dup
    //   125: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   128: ldc_w 475
    //   131: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: aload_0
    //   135: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: ldc_w 477
    //   141: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: aload_3
    //   145: invokevirtual 85	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   148: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   154: aload_3
    //   155: invokestatic 128	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   158: aload_2
    //   159: ifnull +40 -> 199
    //   162: aload_2
    //   163: invokeinterface 123 1 0
    //   168: iconst_0
    //   169: istore 5
    //   171: goto -96 -> 75
    //   174: astore_0
    //   175: aconst_null
    //   176: astore_1
    //   177: aload_1
    //   178: ifnull +9 -> 187
    //   181: aload_1
    //   182: invokeinterface 123 1 0
    //   187: aload_0
    //   188: athrow
    //   189: iconst_0
    //   190: ireturn
    //   191: astore_0
    //   192: goto -15 -> 177
    //   195: astore_3
    //   196: goto -88 -> 108
    //   199: iconst_0
    //   200: istore 5
    //   202: goto -127 -> 75
    //   205: iconst_0
    //   206: istore 4
    //   208: goto -151 -> 57
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	211	0	paramString	String
    //   40	142	1	localCursor1	android.database.Cursor
    //   34	129	2	localCursor2	android.database.Cursor
    //   105	50	3	localException1	Exception
    //   195	1	3	localException2	Exception
    //   47	160	4	i	int
    //   59	142	5	j	int
    // Exception table:
    //   from	to	target	type
    //   0	35	105	java/lang/Exception
    //   0	35	174	finally
    //   41	49	191	finally
    //   84	91	191	finally
    //   93	102	191	finally
    //   110	116	191	finally
    //   118	158	191	finally
    //   41	49	195	java/lang/Exception
    //   84	91	195	java/lang/Exception
    //   93	102	195	java/lang/Exception
  }
  
  private static void c()
  {
    try
    {
      BaseApplication.getContext().getContentResolver().delete(QZoneConfigProvider.f, null, null);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("QZConfigProviderUtil", 2, "deleteIspCheckTime error" + localException.getMessage(), localException);
    }
  }
  
  private static void d()
  {
    try
    {
      BaseApplication.getContext().getContentResolver().delete(QZoneConfigProvider.a, null, null);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("QZConfigProviderUtil", 2, "deleteConfig error" + localException.getMessage(), localException);
    }
  }
  
  private static void e()
  {
    try
    {
      BaseApplication.getContext().getContentResolver().delete(QZoneConfigProvider.e, null, null);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("QZConfigProviderUtil", 2, "deleteIspConfig error " + localException.getMessage(), localException);
    }
  }
  
  private static void f()
  {
    try
    {
      BaseApplication.getContext().getContentResolver().delete(QZoneConfigProvider.c, null, null);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("QZConfigProviderUtil", 2, "deleteLastUpdateLog error " + localException.getMessage(), localException);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\common\config\provider\QZConfigProviderUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
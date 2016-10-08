package cooperation.qqwifi;

import android.app.Notification;
import android.os.Build.VERSION;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pluginsdk.PluginProxyService;
import com.tencent.qphone.base.util.QLog;

public class QQWiFiAssistService
  extends PluginProxyService
{
  private static final String jdField_a_of_type_JavaLangString = "QQWiFiAssistService";
  private long jdField_a_of_type_Long;
  
  public QQWiFiAssistService()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private void a()
  {
    try
    {
      if (Build.VERSION.SDK_INT < 18) {
        startForeground(9998, new Notification());
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  private void b()
  {
    try
    {
      if (Build.VERSION.SDK_INT < 18) {
        stopForeground(true);
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  public void onCreate()
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "QQWiFiAssistService onCreate");
    }
    a();
    super.onCreate();
  }
  
  public void onDestroy()
  {
    b();
    super.onDestroy();
  }
  
  /* Error */
  public int onStartCommand(android.content.Intent paramIntent, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 6
    //   3: invokestatic 47	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6: ifeq +37 -> 43
    //   9: ldc 8
    //   11: iconst_2
    //   12: new 72	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   19: ldc 75
    //   21: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: aload_1
    //   25: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   28: ldc 84
    //   30: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: iload_3
    //   34: invokevirtual 87	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   37: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   40: invokestatic 94	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   43: aload_0
    //   44: invokevirtual 98	cooperation/qqwifi/QQWiFiAssistService:getApplicationContext	()Landroid/content/Context;
    //   47: invokestatic 104	android/preference/PreferenceManager:getDefaultSharedPreferences	(Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   50: astore 4
    //   52: aload_1
    //   53: ifnull +121 -> 174
    //   56: aload_1
    //   57: invokevirtual 109	android/content/Intent:toURI	()Ljava/lang/String;
    //   60: astore 5
    //   62: aload 4
    //   64: invokeinterface 115 1 0
    //   69: ldc 117
    //   71: aload 5
    //   73: invokeinterface 123 3 0
    //   78: invokeinterface 126 1 0
    //   83: pop
    //   84: aload_0
    //   85: aload_1
    //   86: iload_2
    //   87: iload_3
    //   88: invokespecial 128	com/tencent/mobileqq/pluginsdk/PluginProxyService:onStartCommand	(Landroid/content/Intent;II)I
    //   91: pop
    //   92: aload_1
    //   93: ldc -126
    //   95: iconst_0
    //   96: invokevirtual 134	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   99: istore 7
    //   101: aload_1
    //   102: ldc -120
    //   104: iconst_0
    //   105: invokevirtual 134	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   108: istore 8
    //   110: aload_1
    //   111: ldc -118
    //   113: iconst_0
    //   114: invokevirtual 134	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   117: istore 9
    //   119: invokestatic 47	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   122: ifeq +248 -> 370
    //   125: ldc 8
    //   127: iconst_2
    //   128: new 72	java/lang/StringBuilder
    //   131: dup
    //   132: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   135: ldc -116
    //   137: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: iload 7
    //   142: invokevirtual 143	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   145: ldc -111
    //   147: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: iload 8
    //   152: invokevirtual 143	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   155: ldc -109
    //   157: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: iload 9
    //   162: invokevirtual 143	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   165: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   168: invokestatic 94	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   171: goto +199 -> 370
    //   174: aload 4
    //   176: ldc 117
    //   178: ldc -107
    //   180: invokeinterface 153 3 0
    //   185: astore 5
    //   187: invokestatic 47	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   190: ifeq +29 -> 219
    //   193: ldc 8
    //   195: iconst_2
    //   196: new 72	java/lang/StringBuilder
    //   199: dup
    //   200: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   203: ldc -101
    //   205: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: aload 5
    //   210: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   216: invokestatic 94	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   219: aconst_null
    //   220: astore 4
    //   222: aload 4
    //   224: astore_1
    //   225: aload 5
    //   227: invokestatic 161	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   230: ifne +10 -> 240
    //   233: aload 5
    //   235: iconst_0
    //   236: invokestatic 165	android/content/Intent:parseUri	(Ljava/lang/String;I)Landroid/content/Intent;
    //   239: astore_1
    //   240: aload_1
    //   241: astore 4
    //   243: aload_1
    //   244: ifnonnull +74 -> 318
    //   247: new 106	android/content/Intent
    //   250: dup
    //   251: aload_0
    //   252: invokevirtual 98	cooperation/qqwifi/QQWiFiAssistService:getApplicationContext	()Landroid/content/Context;
    //   255: ldc 2
    //   257: invokespecial 168	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   260: astore 4
    //   262: aload 4
    //   264: ldc -86
    //   266: iconst_m1
    //   267: invokevirtual 173	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   270: pop
    //   271: aload 4
    //   273: ldc -81
    //   275: aload_0
    //   276: ldc -79
    //   278: invokestatic 183	com/tencent/mobileqq/pluginsdk/PluginUtils:getInstalledPluginPath	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   281: invokevirtual 188	java/io/File:getCanonicalPath	()Ljava/lang/String;
    //   284: invokevirtual 191	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   287: pop
    //   288: aload 4
    //   290: ldc -63
    //   292: ldc -61
    //   294: invokevirtual 191	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   297: pop
    //   298: aload 4
    //   300: ldc -59
    //   302: ldc -79
    //   304: invokevirtual 191	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   307: pop
    //   308: aload 4
    //   310: ldc -57
    //   312: ldc -55
    //   314: invokevirtual 191	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   317: pop
    //   318: invokestatic 47	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   321: ifeq +11 -> 332
    //   324: ldc 8
    //   326: iconst_2
    //   327: ldc -53
    //   329: invokestatic 94	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   332: aload 4
    //   334: ldc -51
    //   336: iconst_1
    //   337: invokevirtual 208	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   340: pop
    //   341: aload_0
    //   342: aload 4
    //   344: iload_2
    //   345: iload_3
    //   346: invokespecial 128	com/tencent/mobileqq/pluginsdk/PluginProxyService:onStartCommand	(Landroid/content/Intent;II)I
    //   349: pop
    //   350: iconst_2
    //   351: ireturn
    //   352: astore_1
    //   353: aload_1
    //   354: invokevirtual 211	java/net/URISyntaxException:printStackTrace	()V
    //   357: aload 4
    //   359: astore_1
    //   360: goto -120 -> 240
    //   363: astore_1
    //   364: iconst_2
    //   365: ireturn
    //   366: astore_1
    //   367: goto -79 -> 288
    //   370: iload 7
    //   372: ifne +16 -> 388
    //   375: iload 8
    //   377: ifne +11 -> 388
    //   380: iload 6
    //   382: istore_2
    //   383: iload 9
    //   385: ifeq +5 -> 390
    //   388: iconst_2
    //   389: istore_2
    //   390: iload_2
    //   391: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	392	0	this	QQWiFiAssistService
    //   0	392	1	paramIntent	android.content.Intent
    //   0	392	2	paramInt1	int
    //   0	392	3	paramInt2	int
    //   50	308	4	localObject	Object
    //   60	174	5	str	String
    //   1	380	6	i	int
    //   99	272	7	bool1	boolean
    //   108	268	8	bool2	boolean
    //   117	267	9	bool3	boolean
    // Exception table:
    //   from	to	target	type
    //   225	240	352	java/net/URISyntaxException
    //   3	43	363	java/lang/Throwable
    //   43	52	363	java/lang/Throwable
    //   56	171	363	java/lang/Throwable
    //   174	219	363	java/lang/Throwable
    //   225	240	363	java/lang/Throwable
    //   247	271	363	java/lang/Throwable
    //   271	288	363	java/lang/Throwable
    //   288	318	363	java/lang/Throwable
    //   318	332	363	java/lang/Throwable
    //   332	350	363	java/lang/Throwable
    //   353	357	363	java/lang/Throwable
    //   271	288	366	java/lang/Exception
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qqwifi\QQWiFiAssistService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
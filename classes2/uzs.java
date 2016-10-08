import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.AsyncTask;
import android.support.v4.util.MQLruCache;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.theme.ThemeSwitchManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class uzs
  extends AsyncTask
{
  private int jdField_a_of_type_Int;
  private AppRuntime jdField_a_of_type_MqqAppAppRuntime;
  private int b;
  private int c;
  private int d;
  private int e;
  
  public uzs(ThemeSwitchManager paramThemeSwitchManager, AppRuntime paramAppRuntime)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = -1;
    this.c = 1;
    this.d = 2;
    this.e = 3;
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
  }
  
  /* Error */
  protected org.json.JSONObject a(Object... paramVarArgs)
  {
    // Byte code:
    //   0: aload_1
    //   1: iconst_0
    //   2: aaload
    //   3: checkcast 45	java/lang/String
    //   6: astore_2
    //   7: aload_1
    //   8: iconst_1
    //   9: aaload
    //   10: checkcast 45	java/lang/String
    //   13: astore 8
    //   15: new 47	org/json/JSONObject
    //   18: dup
    //   19: invokespecial 48	org/json/JSONObject:<init>	()V
    //   22: astore 7
    //   24: aload_2
    //   25: astore_3
    //   26: aload_2
    //   27: astore 4
    //   29: aload 7
    //   31: ldc 50
    //   33: aload_2
    //   34: invokevirtual 54	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   37: pop
    //   38: aload_2
    //   39: astore_3
    //   40: aload_2
    //   41: astore 4
    //   43: aload 7
    //   45: ldc 56
    //   47: aload 8
    //   49: invokevirtual 54	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   52: pop
    //   53: aload_2
    //   54: astore_3
    //   55: aload_2
    //   56: astore 4
    //   58: aload 7
    //   60: ldc 58
    //   62: aload_0
    //   63: getfield 27	uzs:jdField_a_of_type_Int	I
    //   66: invokevirtual 61	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   69: pop
    //   70: aload_2
    //   71: astore_3
    //   72: aload_2
    //   73: astore 4
    //   75: aload 7
    //   77: ldc 63
    //   79: ldc 65
    //   81: invokevirtual 54	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   84: pop
    //   85: aload_2
    //   86: astore_3
    //   87: aload_2
    //   88: astore 4
    //   90: ldc 67
    //   92: iconst_1
    //   93: new 69	java/lang/StringBuilder
    //   96: dup
    //   97: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   100: ldc 72
    //   102: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: aload_2
    //   106: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: ldc 78
    //   111: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: aload 8
    //   116: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   122: invokestatic 88	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   125: aload_2
    //   126: ifnull +17 -> 143
    //   129: aload_2
    //   130: astore_3
    //   131: aload_2
    //   132: astore 4
    //   134: aload_2
    //   135: ldc 90
    //   137: invokevirtual 94	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   140: ifeq +207 -> 347
    //   143: aload_2
    //   144: astore_1
    //   145: aload_2
    //   146: ifnonnull +21 -> 167
    //   149: ldc 90
    //   151: astore_1
    //   152: aload_1
    //   153: astore_3
    //   154: aload_1
    //   155: astore 4
    //   157: aload 7
    //   159: ldc 50
    //   161: ldc 90
    //   163: invokevirtual 54	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   166: pop
    //   167: aload_1
    //   168: astore_3
    //   169: ldc2_w 95
    //   172: invokestatic 102	java/lang/Thread:sleep	(J)V
    //   175: aload_1
    //   176: astore_3
    //   177: aload_1
    //   178: astore 4
    //   180: aload 7
    //   182: ldc 58
    //   184: aload_0
    //   185: getfield 104	uzs:b	I
    //   188: invokevirtual 61	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   191: pop
    //   192: aload_1
    //   193: astore_3
    //   194: aload_1
    //   195: astore 4
    //   197: aload 7
    //   199: ldc 63
    //   201: ldc 106
    //   203: invokevirtual 54	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   206: pop
    //   207: aconst_null
    //   208: astore_2
    //   209: aload_1
    //   210: astore 5
    //   212: aload_2
    //   213: astore_1
    //   214: aload 5
    //   216: astore_3
    //   217: invokestatic 110	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   220: ifeq +32 -> 252
    //   223: ldc 67
    //   225: iconst_2
    //   226: new 69	java/lang/StringBuilder
    //   229: dup
    //   230: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   233: ldc 112
    //   235: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: aload 7
    //   240: invokevirtual 113	org/json/JSONObject:toString	()Ljava/lang/String;
    //   243: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   249: invokestatic 88	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   252: new 115	java/util/HashMap
    //   255: dup
    //   256: invokespecial 116	java/util/HashMap:<init>	()V
    //   259: astore 4
    //   261: aload 4
    //   263: ldc 118
    //   265: aload_3
    //   266: invokevirtual 121	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   269: pop
    //   270: aload 4
    //   272: ldc 123
    //   274: aload 8
    //   276: invokevirtual 121	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   279: pop
    //   280: aload_1
    //   281: ifnonnull +1556 -> 1837
    //   284: ldc 125
    //   286: astore_2
    //   287: aload 4
    //   289: ldc 127
    //   291: aload_2
    //   292: invokevirtual 121	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   295: pop
    //   296: aload_0
    //   297: getfield 35	uzs:jdField_a_of_type_MqqAppAppRuntime	Lmqq/app/AppRuntime;
    //   300: invokevirtual 133	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   303: invokevirtual 139	mqq/app/MobileQQ:getApplicationContext	()Landroid/content/Context;
    //   306: invokestatic 144	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   309: astore_2
    //   310: aload_0
    //   311: getfield 35	uzs:jdField_a_of_type_MqqAppAppRuntime	Lmqq/app/AppRuntime;
    //   314: checkcast 146	com/tencent/mobileqq/app/QQAppInterface
    //   317: invokevirtual 149	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   320: astore_3
    //   321: aload_1
    //   322: ifnonnull +1520 -> 1842
    //   325: iconst_1
    //   326: istore 14
    //   328: aload_2
    //   329: aload_3
    //   330: ldc -105
    //   332: iload 14
    //   334: lconst_1
    //   335: lconst_0
    //   336: aload 4
    //   338: ldc -103
    //   340: iconst_0
    //   341: invokevirtual 156	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   344: aload 7
    //   346: areturn
    //   347: aload_2
    //   348: astore_3
    //   349: aload_2
    //   350: astore 4
    //   352: aload_0
    //   353: getfield 35	uzs:jdField_a_of_type_MqqAppAppRuntime	Lmqq/app/AppRuntime;
    //   356: invokevirtual 133	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   359: aload_2
    //   360: invokestatic 162	com/tencent/mobileqq/theme/ThemeUtil:getThemeInfo	(Landroid/content/Context;Ljava/lang/String;)Lcom/tencent/mobileqq/theme/ThemeUtil$ThemeInfo;
    //   363: astore 6
    //   365: aload_2
    //   366: astore_3
    //   367: aload_2
    //   368: astore 4
    //   370: aload_0
    //   371: getfield 35	uzs:jdField_a_of_type_MqqAppAppRuntime	Lmqq/app/AppRuntime;
    //   374: invokevirtual 133	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   377: aload_2
    //   378: aload 8
    //   380: invokestatic 166	com/tencent/mobileqq/theme/ThemeUtil:getThemeResourcePath	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   383: astore 9
    //   385: aload_2
    //   386: astore_3
    //   387: aload_2
    //   388: astore 4
    //   390: aload_0
    //   391: getfield 35	uzs:jdField_a_of_type_MqqAppAppRuntime	Lmqq/app/AppRuntime;
    //   394: invokevirtual 133	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   397: aload_2
    //   398: aload 8
    //   400: invokestatic 169	com/tencent/mobileqq/theme/ThemeUtil:getThemeDownloadFilePath	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   403: astore 5
    //   405: aload_2
    //   406: astore_3
    //   407: aload_2
    //   408: astore 4
    //   410: new 171	java/io/File
    //   413: dup
    //   414: aload 5
    //   416: invokespecial 174	java/io/File:<init>	(Ljava/lang/String;)V
    //   419: astore_1
    //   420: aload 6
    //   422: ifnull +311 -> 733
    //   425: aload_2
    //   426: astore_3
    //   427: aload_2
    //   428: astore 4
    //   430: aload 6
    //   432: getfield 180	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:status	Ljava/lang/String;
    //   435: ldc -74
    //   437: invokevirtual 94	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   440: ifeq +293 -> 733
    //   443: aload_2
    //   444: astore_3
    //   445: aload_2
    //   446: astore 4
    //   448: new 171	java/io/File
    //   451: dup
    //   452: aload 9
    //   454: invokespecial 174	java/io/File:<init>	(Ljava/lang/String;)V
    //   457: astore 10
    //   459: aload_2
    //   460: astore_3
    //   461: aload_2
    //   462: astore 4
    //   464: aload 10
    //   466: invokevirtual 185	java/io/File:exists	()Z
    //   469: ifeq +727 -> 1196
    //   472: aload_2
    //   473: astore_3
    //   474: aload_2
    //   475: astore 4
    //   477: aload 10
    //   479: invokestatic 191	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:getFileNumInFile	(Ljava/io/File;)I
    //   482: istore 12
    //   484: iload 12
    //   486: ifle +117 -> 603
    //   489: aload_2
    //   490: astore_3
    //   491: aload_2
    //   492: astore 4
    //   494: aload 6
    //   496: getfield 194	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:fileNum	I
    //   499: istore 13
    //   501: iload 12
    //   503: iload 13
    //   505: bipush 15
    //   507: isub
    //   508: if_icmplt +95 -> 603
    //   511: aload_2
    //   512: astore_3
    //   513: ldc2_w 95
    //   516: invokestatic 102	java/lang/Thread:sleep	(J)V
    //   519: aload_2
    //   520: astore_3
    //   521: aload_2
    //   522: astore 4
    //   524: aload 7
    //   526: ldc 58
    //   528: aload_0
    //   529: getfield 104	uzs:b	I
    //   532: invokevirtual 61	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   535: pop
    //   536: aload_2
    //   537: astore_3
    //   538: aload_2
    //   539: astore 4
    //   541: aload 7
    //   543: ldc -60
    //   545: aload 9
    //   547: invokevirtual 54	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   550: pop
    //   551: aload_2
    //   552: astore_3
    //   553: aload_2
    //   554: astore 4
    //   556: aload 7
    //   558: ldc 63
    //   560: ldc -58
    //   562: invokevirtual 54	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   565: pop
    //   566: aload_2
    //   567: astore_3
    //   568: aload_2
    //   569: astore 4
    //   571: ldc 67
    //   573: iconst_1
    //   574: new 69	java/lang/StringBuilder
    //   577: dup
    //   578: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   581: ldc -56
    //   583: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   586: aload 7
    //   588: invokevirtual 113	org/json/JSONObject:toString	()Ljava/lang/String;
    //   591: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   594: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   597: invokestatic 88	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   600: aload 7
    //   602: areturn
    //   603: aload_2
    //   604: astore_3
    //   605: aload_2
    //   606: astore 4
    //   608: ldc 67
    //   610: iconst_1
    //   611: new 69	java/lang/StringBuilder
    //   614: dup
    //   615: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   618: ldc -54
    //   620: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   623: aload 6
    //   625: getfield 194	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:fileNum	I
    //   628: invokevirtual 205	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   631: ldc -49
    //   633: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   636: iload 12
    //   638: invokevirtual 205	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   641: ldc -47
    //   643: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   646: aload 6
    //   648: getfield 211	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:themeId	Ljava/lang/String;
    //   651: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   654: ldc -43
    //   656: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   659: aload 6
    //   661: getfield 215	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:version	Ljava/lang/String;
    //   664: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   667: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   670: invokestatic 217	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   673: aload_2
    //   674: astore_3
    //   675: new 115	java/util/HashMap
    //   678: dup
    //   679: invokespecial 116	java/util/HashMap:<init>	()V
    //   682: astore 4
    //   684: aload_2
    //   685: astore_3
    //   686: aload 4
    //   688: ldc 127
    //   690: ldc -37
    //   692: invokevirtual 121	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   695: pop
    //   696: aload_2
    //   697: astore_3
    //   698: aload_0
    //   699: getfield 16	uzs:jdField_a_of_type_ComTencentMobileqqThemeThemeSwitchManager	Lcom/tencent/mobileqq/theme/ThemeSwitchManager;
    //   702: getfield 224	com/tencent/mobileqq/theme/ThemeSwitchManager:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   705: invokestatic 144	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   708: getstatic 229	com/tencent/common/app/BaseApplicationImpl:jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl	Lcom/tencent/common/app/BaseApplicationImpl;
    //   711: invokevirtual 232	com/tencent/common/app/BaseApplicationImpl:a	()Lmqq/app/AppRuntime;
    //   714: checkcast 146	com/tencent/mobileqq/app/QQAppInterface
    //   717: invokevirtual 149	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   720: ldc -22
    //   722: iconst_0
    //   723: lconst_1
    //   724: lconst_0
    //   725: aload 4
    //   727: ldc -103
    //   729: iconst_0
    //   730: invokevirtual 156	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   733: aload 6
    //   735: ifnull +839 -> 1574
    //   738: aload_2
    //   739: astore_3
    //   740: aload_2
    //   741: astore 4
    //   743: aload_1
    //   744: invokevirtual 185	java/io/File:exists	()Z
    //   747: ifeq +827 -> 1574
    //   750: aload_2
    //   751: astore_3
    //   752: aload_2
    //   753: astore 4
    //   755: aload_1
    //   756: invokevirtual 238	java/io/File:length	()J
    //   759: aload 6
    //   761: getfield 242	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:size	J
    //   764: lcmp
    //   765: ifne +809 -> 1574
    //   768: aload_2
    //   769: astore_3
    //   770: aload_2
    //   771: astore 4
    //   773: invokestatic 110	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   776: ifeq +46 -> 822
    //   779: aload_2
    //   780: astore_3
    //   781: aload_2
    //   782: astore 4
    //   784: ldc 67
    //   786: iconst_2
    //   787: new 69	java/lang/StringBuilder
    //   790: dup
    //   791: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   794: ldc -12
    //   796: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   799: aload_1
    //   800: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   803: ldc -7
    //   805: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   808: aload 6
    //   810: getfield 180	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:status	Ljava/lang/String;
    //   813: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   816: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   819: invokestatic 88	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   822: aload_2
    //   823: astore_3
    //   824: aload_2
    //   825: astore 4
    //   827: aload_0
    //   828: aload_2
    //   829: aload 9
    //   831: invokevirtual 252	uzs:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   834: iconst_0
    //   835: istore 14
    //   837: aload_2
    //   838: astore_3
    //   839: aload_2
    //   840: astore 4
    //   842: aload 5
    //   844: aload 9
    //   846: iconst_0
    //   847: invokestatic 257	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   850: iconst_1
    //   851: istore 12
    //   853: aconst_null
    //   854: astore_1
    //   855: iload 12
    //   857: ifne +1042 -> 1899
    //   860: aload_2
    //   861: astore_3
    //   862: aload_2
    //   863: astore 4
    //   865: new 171	java/io/File
    //   868: dup
    //   869: aload 9
    //   871: invokespecial 174	java/io/File:<init>	(Ljava/lang/String;)V
    //   874: astore 10
    //   876: aload_2
    //   877: astore_3
    //   878: aload_2
    //   879: astore 4
    //   881: new 171	java/io/File
    //   884: dup
    //   885: aload 5
    //   887: invokespecial 174	java/io/File:<init>	(Ljava/lang/String;)V
    //   890: astore 11
    //   892: aload_2
    //   893: astore_3
    //   894: aload_2
    //   895: astore 4
    //   897: invokestatic 110	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   900: ifeq +35 -> 935
    //   903: aload_2
    //   904: astore_3
    //   905: aload_2
    //   906: astore 4
    //   908: ldc 67
    //   910: iconst_2
    //   911: new 69	java/lang/StringBuilder
    //   914: dup
    //   915: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   918: ldc_w 259
    //   921: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   924: aload 5
    //   926: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   929: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   932: invokestatic 261	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   935: aload_2
    //   936: astore_3
    //   937: aload_2
    //   938: astore 4
    //   940: aload 11
    //   942: aload 10
    //   944: iconst_0
    //   945: invokestatic 266	com/tencent/mobileqq/vip/DownloaderFactory:a	(Ljava/io/File;Ljava/io/File;Z)Z
    //   948: istore 14
    //   950: goto +949 -> 1899
    //   953: aload_2
    //   954: astore_3
    //   955: aload_2
    //   956: astore 4
    //   958: new 171	java/io/File
    //   961: dup
    //   962: aload 9
    //   964: invokespecial 174	java/io/File:<init>	(Ljava/lang/String;)V
    //   967: astore 10
    //   969: aload_2
    //   970: astore_3
    //   971: aload_2
    //   972: astore 4
    //   974: aload 10
    //   976: invokevirtual 185	java/io/File:exists	()Z
    //   979: ifeq +434 -> 1413
    //   982: aload_2
    //   983: astore_3
    //   984: aload_2
    //   985: astore 4
    //   987: aload 6
    //   989: ldc -74
    //   991: putfield 180	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:status	Ljava/lang/String;
    //   994: aload_2
    //   995: astore_3
    //   996: aload_2
    //   997: astore 4
    //   999: aload 10
    //   1001: invokestatic 191	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:getFileNumInFile	(Ljava/io/File;)I
    //   1004: istore 12
    //   1006: aload_2
    //   1007: astore_3
    //   1008: aload_2
    //   1009: astore 4
    //   1011: aload 6
    //   1013: iload 12
    //   1015: putfield 194	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:fileNum	I
    //   1018: aload_2
    //   1019: astore_3
    //   1020: aload_2
    //   1021: astore 4
    //   1023: aload_0
    //   1024: getfield 35	uzs:jdField_a_of_type_MqqAppAppRuntime	Lmqq/app/AppRuntime;
    //   1027: invokevirtual 133	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   1030: aload 6
    //   1032: invokestatic 270	com/tencent/mobileqq/theme/ThemeUtil:setThemeInfo	(Landroid/content/Context;Lcom/tencent/mobileqq/theme/ThemeUtil$ThemeInfo;)Ljava/lang/Boolean;
    //   1035: invokevirtual 275	java/lang/Boolean:booleanValue	()Z
    //   1038: istore 14
    //   1040: aload_2
    //   1041: astore_3
    //   1042: aload_2
    //   1043: astore 4
    //   1045: ldc 67
    //   1047: iconst_1
    //   1048: new 69	java/lang/StringBuilder
    //   1051: dup
    //   1052: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   1055: ldc_w 277
    //   1058: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1061: iload 14
    //   1063: invokevirtual 280	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1066: ldc -49
    //   1068: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1071: iload 12
    //   1073: invokevirtual 205	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1076: ldc_w 282
    //   1079: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1082: aload 5
    //   1084: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1087: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1090: invokestatic 217	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1093: iload 14
    //   1095: iconst_1
    //   1096: if_icmpne +274 -> 1370
    //   1099: aload_2
    //   1100: astore_3
    //   1101: aload_2
    //   1102: astore 4
    //   1104: aload 7
    //   1106: ldc 58
    //   1108: aload_0
    //   1109: getfield 104	uzs:b	I
    //   1112: invokevirtual 61	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1115: pop
    //   1116: aload_2
    //   1117: astore_3
    //   1118: aload_2
    //   1119: astore 4
    //   1121: aload 7
    //   1123: ldc -60
    //   1125: aload 9
    //   1127: invokevirtual 54	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1130: pop
    //   1131: aload_2
    //   1132: astore_3
    //   1133: aload_2
    //   1134: astore 4
    //   1136: aload 7
    //   1138: ldc 63
    //   1140: ldc_w 284
    //   1143: invokevirtual 54	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1146: pop
    //   1147: aload_2
    //   1148: astore 5
    //   1150: goto -936 -> 214
    //   1153: astore_1
    //   1154: invokestatic 110	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1157: ifeq +32 -> 1189
    //   1160: ldc 67
    //   1162: iconst_2
    //   1163: new 69	java/lang/StringBuilder
    //   1166: dup
    //   1167: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   1170: ldc_w 286
    //   1173: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1176: aload_1
    //   1177: invokevirtual 289	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   1180: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1183: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1186: invokestatic 88	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1189: ldc_w 291
    //   1192: astore_1
    //   1193: goto -976 -> 217
    //   1196: aload_2
    //   1197: astore_3
    //   1198: aload_2
    //   1199: astore 4
    //   1201: invokestatic 110	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1204: ifeq -471 -> 733
    //   1207: aload_2
    //   1208: astore_3
    //   1209: aload_2
    //   1210: astore 4
    //   1212: ldc 67
    //   1214: iconst_2
    //   1215: new 69	java/lang/StringBuilder
    //   1218: dup
    //   1219: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   1222: ldc_w 293
    //   1225: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1228: aload 9
    //   1230: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1233: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1236: invokestatic 88	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1239: goto -506 -> 733
    //   1242: astore_1
    //   1243: invokestatic 110	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1246: ifeq +32 -> 1278
    //   1249: ldc 67
    //   1251: iconst_2
    //   1252: new 69	java/lang/StringBuilder
    //   1255: dup
    //   1256: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   1259: ldc_w 295
    //   1262: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1265: aload_1
    //   1266: invokevirtual 296	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1269: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1272: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1275: invokestatic 88	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1278: ldc_w 298
    //   1281: astore_1
    //   1282: aload 4
    //   1284: astore_3
    //   1285: goto -1068 -> 217
    //   1288: astore_1
    //   1289: aload_2
    //   1290: astore_3
    //   1291: aload_2
    //   1292: astore 4
    //   1294: aload 7
    //   1296: ldc 63
    //   1298: ldc_w 300
    //   1301: invokevirtual 54	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1304: pop
    //   1305: aload_2
    //   1306: astore_3
    //   1307: aload_2
    //   1308: astore 4
    //   1310: aload 7
    //   1312: ldc 58
    //   1314: aload_0
    //   1315: getfield 31	uzs:d	I
    //   1318: invokevirtual 61	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1321: pop
    //   1322: aload_2
    //   1323: astore_3
    //   1324: aload_2
    //   1325: astore 4
    //   1327: invokestatic 110	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1330: ifeq +582 -> 1912
    //   1333: aload_2
    //   1334: astore_3
    //   1335: aload_2
    //   1336: astore 4
    //   1338: ldc 67
    //   1340: iconst_2
    //   1341: new 69	java/lang/StringBuilder
    //   1344: dup
    //   1345: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   1348: ldc_w 302
    //   1351: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1354: aload_1
    //   1355: invokevirtual 303	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1358: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1361: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1364: invokestatic 217	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1367: goto +545 -> 1912
    //   1370: aload_2
    //   1371: astore_3
    //   1372: aload_2
    //   1373: astore 4
    //   1375: aload 7
    //   1377: ldc 63
    //   1379: ldc_w 305
    //   1382: invokevirtual 54	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1385: pop
    //   1386: aload_2
    //   1387: astore_3
    //   1388: aload_2
    //   1389: astore 4
    //   1391: aload 7
    //   1393: ldc 58
    //   1395: aload_0
    //   1396: getfield 33	uzs:e	I
    //   1399: invokevirtual 61	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1402: pop
    //   1403: ldc_w 307
    //   1406: astore_1
    //   1407: aload_2
    //   1408: astore 5
    //   1410: goto -1196 -> 214
    //   1413: aload_2
    //   1414: astore_3
    //   1415: aload_2
    //   1416: astore 4
    //   1418: aload 7
    //   1420: ldc 63
    //   1422: ldc_w 309
    //   1425: invokevirtual 54	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1428: pop
    //   1429: aload_2
    //   1430: astore_3
    //   1431: aload_2
    //   1432: astore 4
    //   1434: aload 7
    //   1436: ldc 58
    //   1438: aload_0
    //   1439: getfield 31	uzs:d	I
    //   1442: invokevirtual 61	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1445: pop
    //   1446: ldc_w 311
    //   1449: astore_1
    //   1450: aload_2
    //   1451: astore_3
    //   1452: aload_2
    //   1453: astore 4
    //   1455: aload 5
    //   1457: invokestatic 314	com/tencent/mobileqq/utils/FileUtils:d	(Ljava/lang/String;)Z
    //   1460: pop
    //   1461: aload_2
    //   1462: astore 5
    //   1464: goto -1250 -> 214
    //   1467: aload_2
    //   1468: astore_3
    //   1469: aload_2
    //   1470: astore 4
    //   1472: aload 7
    //   1474: ldc 63
    //   1476: ldc_w 316
    //   1479: invokevirtual 54	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1482: pop
    //   1483: aload_2
    //   1484: astore_3
    //   1485: aload_2
    //   1486: astore 4
    //   1488: aload 7
    //   1490: ldc 58
    //   1492: aload_0
    //   1493: getfield 31	uzs:d	I
    //   1496: invokevirtual 61	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1499: pop
    //   1500: ldc_w 318
    //   1503: astore 6
    //   1505: aload_2
    //   1506: astore_3
    //   1507: aload_2
    //   1508: astore 4
    //   1510: aload 5
    //   1512: invokestatic 314	com/tencent/mobileqq/utils/FileUtils:d	(Ljava/lang/String;)Z
    //   1515: pop
    //   1516: aload 6
    //   1518: astore_1
    //   1519: aload_2
    //   1520: astore 5
    //   1522: aload_2
    //   1523: astore_3
    //   1524: aload_2
    //   1525: astore 4
    //   1527: invokestatic 110	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1530: ifeq -1316 -> 214
    //   1533: aload_2
    //   1534: astore_3
    //   1535: aload_2
    //   1536: astore 4
    //   1538: ldc 67
    //   1540: iconst_2
    //   1541: new 69	java/lang/StringBuilder
    //   1544: dup
    //   1545: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   1548: ldc_w 320
    //   1551: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1554: aload 9
    //   1556: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1559: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1562: invokestatic 217	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1565: aload 6
    //   1567: astore_1
    //   1568: aload_2
    //   1569: astore 5
    //   1571: goto -1357 -> 214
    //   1574: aload 6
    //   1576: ifnonnull +46 -> 1622
    //   1579: aload_2
    //   1580: astore_3
    //   1581: aload_2
    //   1582: astore 4
    //   1584: aload 7
    //   1586: ldc 63
    //   1588: ldc_w 322
    //   1591: invokevirtual 54	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1594: pop
    //   1595: ldc_w 324
    //   1598: astore_1
    //   1599: aload_2
    //   1600: astore_3
    //   1601: aload_2
    //   1602: astore 4
    //   1604: aload 7
    //   1606: ldc 58
    //   1608: aload_0
    //   1609: getfield 29	uzs:c	I
    //   1612: invokevirtual 61	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1615: pop
    //   1616: aload_2
    //   1617: astore 5
    //   1619: goto -1405 -> 214
    //   1622: aload_2
    //   1623: astore_3
    //   1624: aload_2
    //   1625: astore 4
    //   1627: aload_1
    //   1628: invokevirtual 185	java/io/File:exists	()Z
    //   1631: ifne +92 -> 1723
    //   1634: aload 6
    //   1636: ifnull +64 -> 1700
    //   1639: aload_2
    //   1640: astore_3
    //   1641: aload_2
    //   1642: astore 4
    //   1644: aload 6
    //   1646: getfield 180	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:status	Ljava/lang/String;
    //   1649: ldc_w 326
    //   1652: invokevirtual 94	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1655: ifne +45 -> 1700
    //   1658: aload_2
    //   1659: astore_3
    //   1660: aload_2
    //   1661: astore 4
    //   1663: aload 6
    //   1665: ldc_w 326
    //   1668: putfield 180	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:status	Ljava/lang/String;
    //   1671: aload_2
    //   1672: astore_3
    //   1673: aload_2
    //   1674: astore 4
    //   1676: aload 6
    //   1678: lconst_0
    //   1679: putfield 329	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:downsize	J
    //   1682: aload_2
    //   1683: astore_3
    //   1684: aload_2
    //   1685: astore 4
    //   1687: aload_0
    //   1688: getfield 35	uzs:jdField_a_of_type_MqqAppAppRuntime	Lmqq/app/AppRuntime;
    //   1691: invokevirtual 133	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   1694: aload 6
    //   1696: invokestatic 270	com/tencent/mobileqq/theme/ThemeUtil:setThemeInfo	(Landroid/content/Context;Lcom/tencent/mobileqq/theme/ThemeUtil$ThemeInfo;)Ljava/lang/Boolean;
    //   1699: pop
    //   1700: aload_2
    //   1701: astore_3
    //   1702: aload_2
    //   1703: astore 4
    //   1705: aload 7
    //   1707: ldc 63
    //   1709: ldc_w 331
    //   1712: invokevirtual 54	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1715: pop
    //   1716: ldc_w 333
    //   1719: astore_1
    //   1720: goto -121 -> 1599
    //   1723: aload_2
    //   1724: astore_3
    //   1725: aload_2
    //   1726: astore 4
    //   1728: aload_1
    //   1729: invokevirtual 238	java/io/File:length	()J
    //   1732: aload 6
    //   1734: getfield 242	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:size	J
    //   1737: lcmp
    //   1738: ifeq +92 -> 1830
    //   1741: aload 6
    //   1743: ifnull +64 -> 1807
    //   1746: aload_2
    //   1747: astore_3
    //   1748: aload_2
    //   1749: astore 4
    //   1751: aload 6
    //   1753: getfield 180	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:status	Ljava/lang/String;
    //   1756: ldc_w 335
    //   1759: invokevirtual 94	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1762: ifne +45 -> 1807
    //   1765: aload_2
    //   1766: astore_3
    //   1767: aload_2
    //   1768: astore 4
    //   1770: aload 6
    //   1772: ldc_w 335
    //   1775: putfield 180	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:status	Ljava/lang/String;
    //   1778: aload_2
    //   1779: astore_3
    //   1780: aload_2
    //   1781: astore 4
    //   1783: aload 6
    //   1785: lconst_0
    //   1786: putfield 329	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:downsize	J
    //   1789: aload_2
    //   1790: astore_3
    //   1791: aload_2
    //   1792: astore 4
    //   1794: aload_0
    //   1795: getfield 35	uzs:jdField_a_of_type_MqqAppAppRuntime	Lmqq/app/AppRuntime;
    //   1798: invokevirtual 133	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   1801: aload 6
    //   1803: invokestatic 270	com/tencent/mobileqq/theme/ThemeUtil:setThemeInfo	(Landroid/content/Context;Lcom/tencent/mobileqq/theme/ThemeUtil$ThemeInfo;)Ljava/lang/Boolean;
    //   1806: pop
    //   1807: aload_2
    //   1808: astore_3
    //   1809: aload_2
    //   1810: astore 4
    //   1812: aload 7
    //   1814: ldc 63
    //   1816: ldc_w 337
    //   1819: invokevirtual 54	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1822: pop
    //   1823: ldc_w 339
    //   1826: astore_1
    //   1827: goto -228 -> 1599
    //   1830: ldc_w 341
    //   1833: astore_1
    //   1834: goto -235 -> 1599
    //   1837: aload_1
    //   1838: astore_2
    //   1839: goto -1552 -> 287
    //   1842: iconst_0
    //   1843: istore 14
    //   1845: goto -1517 -> 328
    //   1848: astore_1
    //   1849: invokestatic 110	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1852: ifeq -1508 -> 344
    //   1855: ldc 67
    //   1857: iconst_2
    //   1858: new 69	java/lang/StringBuilder
    //   1861: dup
    //   1862: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   1865: ldc_w 343
    //   1868: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1871: aload_1
    //   1872: invokevirtual 344	java/lang/Exception:toString	()Ljava/lang/String;
    //   1875: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1878: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1881: invokestatic 88	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1884: goto -1540 -> 344
    //   1887: astore_2
    //   1888: goto -1713 -> 175
    //   1891: astore_1
    //   1892: goto -1373 -> 519
    //   1895: astore_3
    //   1896: goto -1163 -> 733
    //   1899: iload 12
    //   1901: ifne -948 -> 953
    //   1904: iload 14
    //   1906: ifeq -439 -> 1467
    //   1909: goto -956 -> 953
    //   1912: iconst_0
    //   1913: istore 12
    //   1915: ldc_w 318
    //   1918: astore_1
    //   1919: goto -1064 -> 855
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1922	0	this	uzs
    //   0	1922	1	paramVarArgs	Object[]
    //   6	1833	2	localObject1	Object
    //   1887	1	2	localException1	Exception
    //   25	1784	3	localObject2	Object
    //   1895	1	3	localException2	Exception
    //   27	1784	4	localObject3	Object
    //   210	1408	5	localObject4	Object
    //   363	1439	6	localObject5	Object
    //   22	1791	7	localJSONObject	org.json.JSONObject
    //   13	386	8	str1	String
    //   383	1172	9	str2	String
    //   457	543	10	localFile1	File
    //   890	51	11	localFile2	File
    //   482	1432	12	i	int
    //   499	9	13	j	int
    //   326	1579	14	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   29	38	1153	org/json/JSONException
    //   43	53	1153	org/json/JSONException
    //   58	70	1153	org/json/JSONException
    //   75	85	1153	org/json/JSONException
    //   90	125	1153	org/json/JSONException
    //   134	143	1153	org/json/JSONException
    //   157	167	1153	org/json/JSONException
    //   169	175	1153	org/json/JSONException
    //   180	192	1153	org/json/JSONException
    //   197	207	1153	org/json/JSONException
    //   352	365	1153	org/json/JSONException
    //   370	385	1153	org/json/JSONException
    //   390	405	1153	org/json/JSONException
    //   410	420	1153	org/json/JSONException
    //   430	443	1153	org/json/JSONException
    //   448	459	1153	org/json/JSONException
    //   464	472	1153	org/json/JSONException
    //   477	484	1153	org/json/JSONException
    //   494	501	1153	org/json/JSONException
    //   513	519	1153	org/json/JSONException
    //   524	536	1153	org/json/JSONException
    //   541	551	1153	org/json/JSONException
    //   556	566	1153	org/json/JSONException
    //   571	600	1153	org/json/JSONException
    //   608	673	1153	org/json/JSONException
    //   675	684	1153	org/json/JSONException
    //   686	696	1153	org/json/JSONException
    //   698	733	1153	org/json/JSONException
    //   743	750	1153	org/json/JSONException
    //   755	768	1153	org/json/JSONException
    //   773	779	1153	org/json/JSONException
    //   784	822	1153	org/json/JSONException
    //   827	834	1153	org/json/JSONException
    //   842	850	1153	org/json/JSONException
    //   865	876	1153	org/json/JSONException
    //   881	892	1153	org/json/JSONException
    //   897	903	1153	org/json/JSONException
    //   908	935	1153	org/json/JSONException
    //   940	950	1153	org/json/JSONException
    //   958	969	1153	org/json/JSONException
    //   974	982	1153	org/json/JSONException
    //   987	994	1153	org/json/JSONException
    //   999	1006	1153	org/json/JSONException
    //   1011	1018	1153	org/json/JSONException
    //   1023	1040	1153	org/json/JSONException
    //   1045	1093	1153	org/json/JSONException
    //   1104	1116	1153	org/json/JSONException
    //   1121	1131	1153	org/json/JSONException
    //   1136	1147	1153	org/json/JSONException
    //   1201	1207	1153	org/json/JSONException
    //   1212	1239	1153	org/json/JSONException
    //   1294	1305	1153	org/json/JSONException
    //   1310	1322	1153	org/json/JSONException
    //   1327	1333	1153	org/json/JSONException
    //   1338	1367	1153	org/json/JSONException
    //   1375	1386	1153	org/json/JSONException
    //   1391	1403	1153	org/json/JSONException
    //   1418	1429	1153	org/json/JSONException
    //   1434	1446	1153	org/json/JSONException
    //   1455	1461	1153	org/json/JSONException
    //   1472	1483	1153	org/json/JSONException
    //   1488	1500	1153	org/json/JSONException
    //   1510	1516	1153	org/json/JSONException
    //   1527	1533	1153	org/json/JSONException
    //   1538	1565	1153	org/json/JSONException
    //   1584	1595	1153	org/json/JSONException
    //   1604	1616	1153	org/json/JSONException
    //   1627	1634	1153	org/json/JSONException
    //   1644	1658	1153	org/json/JSONException
    //   1663	1671	1153	org/json/JSONException
    //   1676	1682	1153	org/json/JSONException
    //   1687	1700	1153	org/json/JSONException
    //   1705	1716	1153	org/json/JSONException
    //   1728	1741	1153	org/json/JSONException
    //   1751	1765	1153	org/json/JSONException
    //   1770	1778	1153	org/json/JSONException
    //   1783	1789	1153	org/json/JSONException
    //   1794	1807	1153	org/json/JSONException
    //   1812	1823	1153	org/json/JSONException
    //   29	38	1242	java/lang/Exception
    //   43	53	1242	java/lang/Exception
    //   58	70	1242	java/lang/Exception
    //   75	85	1242	java/lang/Exception
    //   90	125	1242	java/lang/Exception
    //   134	143	1242	java/lang/Exception
    //   157	167	1242	java/lang/Exception
    //   180	192	1242	java/lang/Exception
    //   197	207	1242	java/lang/Exception
    //   352	365	1242	java/lang/Exception
    //   370	385	1242	java/lang/Exception
    //   390	405	1242	java/lang/Exception
    //   410	420	1242	java/lang/Exception
    //   430	443	1242	java/lang/Exception
    //   448	459	1242	java/lang/Exception
    //   464	472	1242	java/lang/Exception
    //   477	484	1242	java/lang/Exception
    //   494	501	1242	java/lang/Exception
    //   524	536	1242	java/lang/Exception
    //   541	551	1242	java/lang/Exception
    //   556	566	1242	java/lang/Exception
    //   571	600	1242	java/lang/Exception
    //   608	673	1242	java/lang/Exception
    //   743	750	1242	java/lang/Exception
    //   755	768	1242	java/lang/Exception
    //   773	779	1242	java/lang/Exception
    //   784	822	1242	java/lang/Exception
    //   827	834	1242	java/lang/Exception
    //   842	850	1242	java/lang/Exception
    //   865	876	1242	java/lang/Exception
    //   881	892	1242	java/lang/Exception
    //   897	903	1242	java/lang/Exception
    //   908	935	1242	java/lang/Exception
    //   940	950	1242	java/lang/Exception
    //   958	969	1242	java/lang/Exception
    //   974	982	1242	java/lang/Exception
    //   987	994	1242	java/lang/Exception
    //   999	1006	1242	java/lang/Exception
    //   1011	1018	1242	java/lang/Exception
    //   1023	1040	1242	java/lang/Exception
    //   1045	1093	1242	java/lang/Exception
    //   1104	1116	1242	java/lang/Exception
    //   1121	1131	1242	java/lang/Exception
    //   1136	1147	1242	java/lang/Exception
    //   1201	1207	1242	java/lang/Exception
    //   1212	1239	1242	java/lang/Exception
    //   1294	1305	1242	java/lang/Exception
    //   1310	1322	1242	java/lang/Exception
    //   1327	1333	1242	java/lang/Exception
    //   1338	1367	1242	java/lang/Exception
    //   1375	1386	1242	java/lang/Exception
    //   1391	1403	1242	java/lang/Exception
    //   1418	1429	1242	java/lang/Exception
    //   1434	1446	1242	java/lang/Exception
    //   1455	1461	1242	java/lang/Exception
    //   1472	1483	1242	java/lang/Exception
    //   1488	1500	1242	java/lang/Exception
    //   1510	1516	1242	java/lang/Exception
    //   1527	1533	1242	java/lang/Exception
    //   1538	1565	1242	java/lang/Exception
    //   1584	1595	1242	java/lang/Exception
    //   1604	1616	1242	java/lang/Exception
    //   1627	1634	1242	java/lang/Exception
    //   1644	1658	1242	java/lang/Exception
    //   1663	1671	1242	java/lang/Exception
    //   1676	1682	1242	java/lang/Exception
    //   1687	1700	1242	java/lang/Exception
    //   1705	1716	1242	java/lang/Exception
    //   1728	1741	1242	java/lang/Exception
    //   1751	1765	1242	java/lang/Exception
    //   1770	1778	1242	java/lang/Exception
    //   1783	1789	1242	java/lang/Exception
    //   1794	1807	1242	java/lang/Exception
    //   1812	1823	1242	java/lang/Exception
    //   842	850	1288	java/io/IOException
    //   252	280	1848	java/lang/Exception
    //   287	321	1848	java/lang/Exception
    //   328	344	1848	java/lang/Exception
    //   169	175	1887	java/lang/Exception
    //   513	519	1891	java/lang/Exception
    //   675	684	1895	java/lang/Exception
    //   686	696	1895	java/lang/Exception
    //   698	733	1895	java/lang/Exception
  }
  
  public void a()
  {
    if (BaseApplicationImpl.jdField_a_of_type_AndroidSupportV4UtilMQLruCache != null) {
      BaseApplicationImpl.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.evictAll();
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    int i = 0;
    if (paramString1 != null) {
      try
      {
        if ((paramString1.length() > 0) && (paramString2 != null) && (paramString2.length() > 0))
        {
          paramString2 = paramString2.substring(0, paramString2.lastIndexOf(File.separator));
          File[] arrayOfFile = new File(paramString2).listFiles();
          if ((arrayOfFile != null) && (arrayOfFile.length > 0)) {
            while (i < arrayOfFile.length)
            {
              String str = arrayOfFile[i].getName();
              if (str.startsWith(paramString1))
              {
                if (QLog.isColorLevel()) {
                  QLog.d("ThemeSwitch", 2, "delete old theme res dir,themeId=" + paramString1 + ",dirName=" + str);
                }
                FileUtils.a(paramString2 + File.separator + str);
              }
              i += 1;
            }
          }
        }
        return;
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
      }
    }
  }
  
  public void b()
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_MqqAppAppRuntime.getApplication().getSharedPreferences("chat_background_path_" + ((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime).a(), 0);
    String str2 = localSharedPreferences.getString("chat_uniform_bg", "null");
    String str1;
    if (str2 != null)
    {
      str1 = str2;
      if (str2.trim().length() != 0) {}
    }
    else
    {
      str1 = "null";
    }
    localSharedPreferences.edit().clear().commit();
    if (QLog.isColorLevel()) {
      QLog.d("ThemeSwitch", 2, "oldPicPath is:" + str1 + ",newPicPath is:" + "null");
    }
    if (!str1.equals("null")) {
      ((ChatBackgroundManager)((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime).getManager(62)).a(this.jdField_a_of_type_MqqAppAppRuntime.getApplication(), ((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime).a());
    }
  }
  
  /* Error */
  protected void onPostExecute(Object paramObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: invokestatic 110	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8: ifeq +32 -> 40
    //   11: ldc 67
    //   13: iconst_2
    //   14: new 69	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   21: ldc_w 439
    //   24: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: aload_1
    //   28: invokevirtual 442	java/lang/Object:toString	()Ljava/lang/String;
    //   31: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   37: invokestatic 88	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   40: new 444	android/os/Bundle
    //   43: dup
    //   44: invokespecial 445	android/os/Bundle:<init>	()V
    //   47: astore_2
    //   48: new 115	java/util/HashMap
    //   51: dup
    //   52: invokespecial 116	java/util/HashMap:<init>	()V
    //   55: astore_3
    //   56: aload_1
    //   57: instanceof 47
    //   60: ifeq +1137 -> 1197
    //   63: aload_1
    //   64: checkcast 47	org/json/JSONObject
    //   67: astore_1
    //   68: aload_1
    //   69: ldc 58
    //   71: invokevirtual 448	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   74: istore 8
    //   76: aload_1
    //   77: ldc 63
    //   79: invokevirtual 451	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   82: pop
    //   83: aload_1
    //   84: ldc 50
    //   86: invokevirtual 451	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   89: astore 4
    //   91: aload_1
    //   92: ldc 56
    //   94: invokevirtual 451	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   97: astore 5
    //   99: aload_3
    //   100: ldc 118
    //   102: aload 4
    //   104: invokevirtual 121	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   107: pop
    //   108: aload_3
    //   109: ldc 123
    //   111: aload 5
    //   113: invokevirtual 121	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   116: pop
    //   117: invokestatic 110	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   120: ifeq +30 -> 150
    //   123: ldc 67
    //   125: iconst_2
    //   126: new 69	java/lang/StringBuilder
    //   129: dup
    //   130: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   133: ldc_w 453
    //   136: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: iload 8
    //   141: invokevirtual 205	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   144: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   147: invokestatic 88	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   150: iload 8
    //   152: aload_0
    //   153: getfield 104	uzs:b	I
    //   156: if_icmpne +928 -> 1084
    //   159: aload 4
    //   161: ldc 90
    //   163: invokevirtual 94	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   166: ifeq +573 -> 739
    //   169: aconst_null
    //   170: astore_1
    //   171: aload_0
    //   172: getfield 16	uzs:jdField_a_of_type_ComTencentMobileqqThemeThemeSwitchManager	Lcom/tencent/mobileqq/theme/ThemeSwitchManager;
    //   175: invokevirtual 455	com/tencent/mobileqq/theme/ThemeSwitchManager:b	()V
    //   178: invokestatic 459	com/tencent/mobileqq/theme/ThemeUtil:getCurrentThemeInfo	()Landroid/os/Bundle;
    //   181: astore 6
    //   183: invokestatic 465	com/tencent/theme/SkinEngine:getInstances	()Lcom/tencent/theme/SkinEngine;
    //   186: aload_0
    //   187: getfield 35	uzs:jdField_a_of_type_MqqAppAppRuntime	Lmqq/app/AppRuntime;
    //   190: invokevirtual 133	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   193: aload_1
    //   194: invokevirtual 469	com/tencent/theme/SkinEngine:setSkinRootPath	(Landroid/content/Context;Ljava/lang/String;)Z
    //   197: istore 9
    //   199: invokestatic 110	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   202: ifeq +30 -> 232
    //   205: ldc 67
    //   207: iconst_2
    //   208: new 69	java/lang/StringBuilder
    //   211: dup
    //   212: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   215: ldc_w 471
    //   218: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: iload 9
    //   223: invokevirtual 280	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   226: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   229: invokestatic 88	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   232: iload 9
    //   234: iconst_1
    //   235: if_icmpne +736 -> 971
    //   238: aload_0
    //   239: invokevirtual 473	uzs:a	()V
    //   242: aload 6
    //   244: ldc 50
    //   246: invokevirtual 474	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   249: astore_1
    //   250: aload 6
    //   252: ldc 56
    //   254: invokevirtual 474	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   257: astore 6
    //   259: invokestatic 110	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   262: ifeq +40 -> 302
    //   265: ldc 67
    //   267: iconst_2
    //   268: new 69	java/lang/StringBuilder
    //   271: dup
    //   272: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   275: ldc_w 476
    //   278: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: aload_1
    //   282: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   285: ldc_w 478
    //   288: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   291: aload 6
    //   293: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   296: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   299: invokestatic 88	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   302: aload_1
    //   303: ldc_w 480
    //   306: invokevirtual 94	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   309: ifne +17 -> 326
    //   312: aload_0
    //   313: getfield 35	uzs:jdField_a_of_type_MqqAppAppRuntime	Lmqq/app/AppRuntime;
    //   316: checkcast 146	com/tencent/mobileqq/app/QQAppInterface
    //   319: aload_1
    //   320: aload 6
    //   322: invokestatic 485	com/tencent/mobileqq/theme/ThemeSwitchUtil:a	(Lcom/tencent/common/app/AppInterface;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Boolean;
    //   325: pop
    //   326: aload_0
    //   327: getfield 35	uzs:jdField_a_of_type_MqqAppAppRuntime	Lmqq/app/AppRuntime;
    //   330: checkcast 146	com/tencent/mobileqq/app/QQAppInterface
    //   333: aload 4
    //   335: aload 5
    //   337: invokestatic 489	com/tencent/mobileqq/theme/ThemeUtil:setCurrentThemeIdVersion	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Boolean;
    //   340: pop
    //   341: aload_2
    //   342: ldc_w 491
    //   345: iconst_2
    //   346: invokevirtual 495	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   349: iconst_0
    //   350: putstatic 497	com/tencent/mobileqq/theme/ThemeSwitchManager:jdField_a_of_type_Boolean	Z
    //   353: aload_0
    //   354: getfield 16	uzs:jdField_a_of_type_ComTencentMobileqqThemeThemeSwitchManager	Lcom/tencent/mobileqq/theme/ThemeSwitchManager;
    //   357: iconst_1
    //   358: iconst_0
    //   359: aload_2
    //   360: invokevirtual 500	com/tencent/mobileqq/theme/ThemeSwitchManager:a	(ZZLandroid/os/Bundle;)V
    //   363: aload_0
    //   364: getfield 35	uzs:jdField_a_of_type_MqqAppAppRuntime	Lmqq/app/AppRuntime;
    //   367: checkcast 146	com/tencent/mobileqq/app/QQAppInterface
    //   370: bipush 62
    //   372: invokevirtual 426	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   375: checkcast 428	com/tencent/mobileqq/model/ChatBackgroundManager
    //   378: astore_1
    //   379: aload_0
    //   380: getfield 16	uzs:jdField_a_of_type_ComTencentMobileqqThemeThemeSwitchManager	Lcom/tencent/mobileqq/theme/ThemeSwitchManager;
    //   383: getfield 224	com/tencent/mobileqq/theme/ThemeSwitchManager:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   386: new 69	java/lang/StringBuilder
    //   389: dup
    //   390: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   393: ldc_w 502
    //   396: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   399: aload_0
    //   400: getfield 35	uzs:jdField_a_of_type_MqqAppAppRuntime	Lmqq/app/AppRuntime;
    //   403: checkcast 146	com/tencent/mobileqq/app/QQAppInterface
    //   406: invokevirtual 149	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   409: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   412: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   415: iconst_0
    //   416: invokevirtual 505	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   419: astore 6
    //   421: ldc_w 480
    //   424: aload 4
    //   426: invokevirtual 94	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   429: ifeq +320 -> 749
    //   432: aload_1
    //   433: aconst_null
    //   434: invokevirtual 507	com/tencent/mobileqq/model/ChatBackgroundManager:b	(Ljava/lang/String;)Ljava/lang/String;
    //   437: astore 7
    //   439: aload 6
    //   441: invokeinterface 410 1 0
    //   446: ldc_w 509
    //   449: aload 7
    //   451: invokeinterface 513 3 0
    //   456: ldc_w 515
    //   459: aload_0
    //   460: getfield 35	uzs:jdField_a_of_type_MqqAppAppRuntime	Lmqq/app/AppRuntime;
    //   463: invokestatic 519	com/tencent/mobileqq/theme/ThemeUtil:getUinThemePreferences	(Lmqq/app/AppRuntime;)Landroid/content/SharedPreferences;
    //   466: ldc_w 521
    //   469: ldc -103
    //   471: invokeinterface 403 3 0
    //   476: invokeinterface 513 3 0
    //   481: invokeinterface 418 1 0
    //   486: pop
    //   487: aload_1
    //   488: aload_0
    //   489: getfield 35	uzs:jdField_a_of_type_MqqAppAppRuntime	Lmqq/app/AppRuntime;
    //   492: checkcast 146	com/tencent/mobileqq/app/QQAppInterface
    //   495: invokevirtual 149	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   498: aconst_null
    //   499: ldc_w 397
    //   502: invokevirtual 524	com/tencent/mobileqq/model/ChatBackgroundManager:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   505: aload_0
    //   506: getfield 35	uzs:jdField_a_of_type_MqqAppAppRuntime	Lmqq/app/AppRuntime;
    //   509: invokevirtual 133	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   512: aload 4
    //   514: invokestatic 528	com/tencent/mobileqq/theme/ThemeUtil:getErrorThemeId	(Landroid/content/Context;Ljava/lang/String;)I
    //   517: istore 8
    //   519: iload 8
    //   521: ifle +72 -> 593
    //   524: aload_3
    //   525: ldc_w 530
    //   528: iload 8
    //   530: invokestatic 534	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   533: invokevirtual 121	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   536: pop
    //   537: ldc2_w 535
    //   540: invokestatic 102	java/lang/Thread:sleep	(J)V
    //   543: iload 8
    //   545: ldc_w 537
    //   548: idiv
    //   549: ldc_w 539
    //   552: invokestatic 544	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   555: if_icmpne +16 -> 571
    //   558: aload_0
    //   559: getfield 35	uzs:jdField_a_of_type_MqqAppAppRuntime	Lmqq/app/AppRuntime;
    //   562: invokevirtual 133	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   565: aload 4
    //   567: iconst_1
    //   568: invokestatic 548	com/tencent/mobileqq/theme/ThemeUtil:setErrorThemeId	(Landroid/content/Context;Ljava/lang/String;Z)V
    //   571: aload_0
    //   572: getfield 35	uzs:jdField_a_of_type_MqqAppAppRuntime	Lmqq/app/AppRuntime;
    //   575: checkcast 146	com/tencent/mobileqq/app/QQAppInterface
    //   578: bipush 14
    //   580: invokevirtual 551	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   583: checkcast 553	com/tencent/mobileqq/app/ThemeHandler
    //   586: aload 4
    //   588: aload 5
    //   590: invokevirtual 554	com/tencent/mobileqq/app/ThemeHandler:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   593: getstatic 229	com/tencent/common/app/BaseApplicationImpl:jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl	Lcom/tencent/common/app/BaseApplicationImpl;
    //   596: invokevirtual 232	com/tencent/common/app/BaseApplicationImpl:a	()Lmqq/app/AppRuntime;
    //   599: checkcast 146	com/tencent/mobileqq/app/QQAppInterface
    //   602: ldc_w 556
    //   605: ldc_w 558
    //   608: sipush 155
    //   611: aconst_null
    //   612: invokestatic 563	com/tencent/mobileqq/utils/NetworkUtil:a	(Landroid/content/Context;)I
    //   615: bipush 23
    //   617: aload 4
    //   619: aload 5
    //   621: getstatic 568	com/tencent/mobileqq/theme/ThemeReporter:t	Ljava/lang/String;
    //   624: ldc -103
    //   626: invokestatic 571	com/tencent/mobileqq/theme/ThemeReporter:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   629: aconst_null
    //   630: astore_1
    //   631: aload_2
    //   632: ldc_w 491
    //   635: iconst_m1
    //   636: invokevirtual 574	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   639: sipush 512
    //   642: iand
    //   643: sipush 512
    //   646: if_icmpne +22 -> 668
    //   649: aload_0
    //   650: getfield 16	uzs:jdField_a_of_type_ComTencentMobileqqThemeThemeSwitchManager	Lcom/tencent/mobileqq/theme/ThemeSwitchManager;
    //   653: aload_2
    //   654: invokevirtual 577	com/tencent/mobileqq/theme/ThemeSwitchManager:a	(Landroid/os/Bundle;)V
    //   657: aload_3
    //   658: ldc_w 579
    //   661: ldc_w 326
    //   664: invokevirtual 121	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   667: pop
    //   668: aload_1
    //   669: ifnonnull +550 -> 1219
    //   672: ldc 125
    //   674: astore_2
    //   675: aload_3
    //   676: ldc 127
    //   678: aload_2
    //   679: invokevirtual 121	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   682: pop
    //   683: aload_0
    //   684: getfield 35	uzs:jdField_a_of_type_MqqAppAppRuntime	Lmqq/app/AppRuntime;
    //   687: invokevirtual 133	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   690: invokevirtual 139	mqq/app/MobileQQ:getApplicationContext	()Landroid/content/Context;
    //   693: invokestatic 144	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   696: astore_2
    //   697: aload_0
    //   698: getfield 35	uzs:jdField_a_of_type_MqqAppAppRuntime	Lmqq/app/AppRuntime;
    //   701: checkcast 146	com/tencent/mobileqq/app/QQAppInterface
    //   704: invokevirtual 149	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   707: astore 4
    //   709: aload_1
    //   710: ifnonnull +514 -> 1224
    //   713: iconst_1
    //   714: istore 9
    //   716: aload_2
    //   717: aload 4
    //   719: ldc_w 581
    //   722: iload 9
    //   724: lconst_1
    //   725: lconst_0
    //   726: aload_3
    //   727: ldc -103
    //   729: iconst_0
    //   730: invokevirtual 156	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   733: aload_0
    //   734: aconst_null
    //   735: putfield 35	uzs:jdField_a_of_type_MqqAppAppRuntime	Lmqq/app/AppRuntime;
    //   738: return
    //   739: aload_1
    //   740: ldc -60
    //   742: invokevirtual 451	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   745: astore_1
    //   746: goto -575 -> 171
    //   749: aload 6
    //   751: ldc_w 509
    //   754: ldc_w 397
    //   757: invokeinterface 403 3 0
    //   762: astore 7
    //   764: aload_1
    //   765: aload_0
    //   766: getfield 35	uzs:jdField_a_of_type_MqqAppAppRuntime	Lmqq/app/AppRuntime;
    //   769: checkcast 146	com/tencent/mobileqq/app/QQAppInterface
    //   772: invokevirtual 149	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   775: aconst_null
    //   776: aload 7
    //   778: invokevirtual 524	com/tencent/mobileqq/model/ChatBackgroundManager:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   781: aload_0
    //   782: getfield 35	uzs:jdField_a_of_type_MqqAppAppRuntime	Lmqq/app/AppRuntime;
    //   785: invokestatic 519	com/tencent/mobileqq/theme/ThemeUtil:getUinThemePreferences	(Lmqq/app/AppRuntime;)Landroid/content/SharedPreferences;
    //   788: invokeinterface 410 1 0
    //   793: ldc_w 521
    //   796: aload 6
    //   798: ldc_w 515
    //   801: ldc -103
    //   803: invokeinterface 403 3 0
    //   808: invokeinterface 513 3 0
    //   813: invokeinterface 418 1 0
    //   818: pop
    //   819: goto -314 -> 505
    //   822: astore_1
    //   823: invokestatic 110	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   826: ifeq +32 -> 858
    //   829: ldc 67
    //   831: iconst_2
    //   832: new 69	java/lang/StringBuilder
    //   835: dup
    //   836: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   839: ldc_w 286
    //   842: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   845: aload_1
    //   846: invokevirtual 289	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   849: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   852: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   855: invokestatic 88	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   858: aload_2
    //   859: ldc_w 491
    //   862: sipush 512
    //   865: invokevirtual 495	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   868: aload_2
    //   869: ldc_w 583
    //   872: ldc_w 585
    //   875: invokevirtual 589	android/os/Bundle:putCharSequence	(Ljava/lang/String;Ljava/lang/CharSequence;)V
    //   878: aload_0
    //   879: getfield 16	uzs:jdField_a_of_type_ComTencentMobileqqThemeThemeSwitchManager	Lcom/tencent/mobileqq/theme/ThemeSwitchManager;
    //   882: getfield 592	com/tencent/mobileqq/theme/ThemeSwitchManager:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   885: ifnull +34 -> 919
    //   888: aload_0
    //   889: getfield 16	uzs:jdField_a_of_type_ComTencentMobileqqThemeThemeSwitchManager	Lcom/tencent/mobileqq/theme/ThemeSwitchManager;
    //   892: getfield 592	com/tencent/mobileqq/theme/ThemeSwitchManager:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   895: invokevirtual 597	com/tencent/mobileqq/widget/QQProgressDialog:isShowing	()Z
    //   898: ifeq +21 -> 919
    //   901: aload_0
    //   902: getfield 16	uzs:jdField_a_of_type_ComTencentMobileqqThemeThemeSwitchManager	Lcom/tencent/mobileqq/theme/ThemeSwitchManager;
    //   905: getfield 592	com/tencent/mobileqq/theme/ThemeSwitchManager:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   908: invokevirtual 600	com/tencent/mobileqq/widget/QQProgressDialog:dismiss	()V
    //   911: aload_0
    //   912: getfield 16	uzs:jdField_a_of_type_ComTencentMobileqqThemeThemeSwitchManager	Lcom/tencent/mobileqq/theme/ThemeSwitchManager;
    //   915: aconst_null
    //   916: putfield 592	com/tencent/mobileqq/theme/ThemeSwitchManager:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   919: aload_0
    //   920: getfield 16	uzs:jdField_a_of_type_ComTencentMobileqqThemeThemeSwitchManager	Lcom/tencent/mobileqq/theme/ThemeSwitchManager;
    //   923: astore_1
    //   924: iconst_0
    //   925: putstatic 497	com/tencent/mobileqq/theme/ThemeSwitchManager:jdField_a_of_type_Boolean	Z
    //   928: getstatic 229	com/tencent/common/app/BaseApplicationImpl:jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl	Lcom/tencent/common/app/BaseApplicationImpl;
    //   931: invokevirtual 232	com/tencent/common/app/BaseApplicationImpl:a	()Lmqq/app/AppRuntime;
    //   934: checkcast 146	com/tencent/mobileqq/app/QQAppInterface
    //   937: ldc_w 556
    //   940: ldc_w 558
    //   943: sipush 155
    //   946: aconst_null
    //   947: invokestatic 563	com/tencent/mobileqq/utils/NetworkUtil:a	(Landroid/content/Context;)I
    //   950: bipush -36
    //   952: ldc -103
    //   954: ldc -103
    //   956: ldc_w 602
    //   959: ldc -103
    //   961: invokestatic 571	com/tencent/mobileqq/theme/ThemeReporter:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   964: ldc_w 602
    //   967: astore_1
    //   968: goto -337 -> 631
    //   971: aload_2
    //   972: ldc_w 491
    //   975: sipush 512
    //   978: invokevirtual 495	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   981: aload_2
    //   982: ldc_w 583
    //   985: ldc_w 585
    //   988: invokevirtual 589	android/os/Bundle:putCharSequence	(Ljava/lang/String;Ljava/lang/CharSequence;)V
    //   991: aload_0
    //   992: getfield 16	uzs:jdField_a_of_type_ComTencentMobileqqThemeThemeSwitchManager	Lcom/tencent/mobileqq/theme/ThemeSwitchManager;
    //   995: getfield 592	com/tencent/mobileqq/theme/ThemeSwitchManager:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   998: ifnull +34 -> 1032
    //   1001: aload_0
    //   1002: getfield 16	uzs:jdField_a_of_type_ComTencentMobileqqThemeThemeSwitchManager	Lcom/tencent/mobileqq/theme/ThemeSwitchManager;
    //   1005: getfield 592	com/tencent/mobileqq/theme/ThemeSwitchManager:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   1008: invokevirtual 597	com/tencent/mobileqq/widget/QQProgressDialog:isShowing	()Z
    //   1011: ifeq +21 -> 1032
    //   1014: aload_0
    //   1015: getfield 16	uzs:jdField_a_of_type_ComTencentMobileqqThemeThemeSwitchManager	Lcom/tencent/mobileqq/theme/ThemeSwitchManager;
    //   1018: getfield 592	com/tencent/mobileqq/theme/ThemeSwitchManager:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   1021: invokevirtual 600	com/tencent/mobileqq/widget/QQProgressDialog:dismiss	()V
    //   1024: aload_0
    //   1025: getfield 16	uzs:jdField_a_of_type_ComTencentMobileqqThemeThemeSwitchManager	Lcom/tencent/mobileqq/theme/ThemeSwitchManager;
    //   1028: aconst_null
    //   1029: putfield 592	com/tencent/mobileqq/theme/ThemeSwitchManager:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   1032: aload_0
    //   1033: getfield 16	uzs:jdField_a_of_type_ComTencentMobileqqThemeThemeSwitchManager	Lcom/tencent/mobileqq/theme/ThemeSwitchManager;
    //   1036: astore_1
    //   1037: iconst_0
    //   1038: putstatic 497	com/tencent/mobileqq/theme/ThemeSwitchManager:jdField_a_of_type_Boolean	Z
    //   1041: ldc_w 604
    //   1044: astore_1
    //   1045: getstatic 229	com/tencent/common/app/BaseApplicationImpl:jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl	Lcom/tencent/common/app/BaseApplicationImpl;
    //   1048: invokevirtual 232	com/tencent/common/app/BaseApplicationImpl:a	()Lmqq/app/AppRuntime;
    //   1051: checkcast 146	com/tencent/mobileqq/app/QQAppInterface
    //   1054: ldc_w 556
    //   1057: ldc_w 558
    //   1060: sipush 155
    //   1063: aconst_null
    //   1064: invokestatic 563	com/tencent/mobileqq/utils/NetworkUtil:a	(Landroid/content/Context;)I
    //   1067: bipush -24
    //   1069: aload 4
    //   1071: aload 5
    //   1073: getstatic 568	com/tencent/mobileqq/theme/ThemeReporter:t	Ljava/lang/String;
    //   1076: ldc -103
    //   1078: invokestatic 571	com/tencent/mobileqq/theme/ThemeReporter:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1081: goto +192 -> 1273
    //   1084: aload_2
    //   1085: ldc_w 491
    //   1088: sipush 512
    //   1091: invokevirtual 495	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1094: aload_2
    //   1095: ldc_w 583
    //   1098: ldc_w 585
    //   1101: invokevirtual 589	android/os/Bundle:putCharSequence	(Ljava/lang/String;Ljava/lang/CharSequence;)V
    //   1104: aload_0
    //   1105: getfield 16	uzs:jdField_a_of_type_ComTencentMobileqqThemeThemeSwitchManager	Lcom/tencent/mobileqq/theme/ThemeSwitchManager;
    //   1108: getfield 592	com/tencent/mobileqq/theme/ThemeSwitchManager:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   1111: ifnull +34 -> 1145
    //   1114: aload_0
    //   1115: getfield 16	uzs:jdField_a_of_type_ComTencentMobileqqThemeThemeSwitchManager	Lcom/tencent/mobileqq/theme/ThemeSwitchManager;
    //   1118: getfield 592	com/tencent/mobileqq/theme/ThemeSwitchManager:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   1121: invokevirtual 597	com/tencent/mobileqq/widget/QQProgressDialog:isShowing	()Z
    //   1124: ifeq +21 -> 1145
    //   1127: aload_0
    //   1128: getfield 16	uzs:jdField_a_of_type_ComTencentMobileqqThemeThemeSwitchManager	Lcom/tencent/mobileqq/theme/ThemeSwitchManager;
    //   1131: getfield 592	com/tencent/mobileqq/theme/ThemeSwitchManager:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   1134: invokevirtual 600	com/tencent/mobileqq/widget/QQProgressDialog:dismiss	()V
    //   1137: aload_0
    //   1138: getfield 16	uzs:jdField_a_of_type_ComTencentMobileqqThemeThemeSwitchManager	Lcom/tencent/mobileqq/theme/ThemeSwitchManager;
    //   1141: aconst_null
    //   1142: putfield 592	com/tencent/mobileqq/theme/ThemeSwitchManager:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   1145: aload_0
    //   1146: getfield 16	uzs:jdField_a_of_type_ComTencentMobileqqThemeThemeSwitchManager	Lcom/tencent/mobileqq/theme/ThemeSwitchManager;
    //   1149: astore_1
    //   1150: iconst_0
    //   1151: putstatic 497	com/tencent/mobileqq/theme/ThemeSwitchManager:jdField_a_of_type_Boolean	Z
    //   1154: ldc_w 606
    //   1157: astore_1
    //   1158: getstatic 229	com/tencent/common/app/BaseApplicationImpl:jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl	Lcom/tencent/common/app/BaseApplicationImpl;
    //   1161: invokevirtual 232	com/tencent/common/app/BaseApplicationImpl:a	()Lmqq/app/AppRuntime;
    //   1164: checkcast 146	com/tencent/mobileqq/app/QQAppInterface
    //   1167: ldc_w 556
    //   1170: ldc_w 558
    //   1173: sipush 155
    //   1176: aconst_null
    //   1177: invokestatic 563	com/tencent/mobileqq/utils/NetworkUtil:a	(Landroid/content/Context;)I
    //   1180: bipush -30
    //   1182: aload 4
    //   1184: aload 5
    //   1186: getstatic 568	com/tencent/mobileqq/theme/ThemeReporter:t	Ljava/lang/String;
    //   1189: ldc -103
    //   1191: invokestatic 571	com/tencent/mobileqq/theme/ThemeReporter:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1194: goto +79 -> 1273
    //   1197: invokestatic 110	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1200: ifeq +12 -> 1212
    //   1203: ldc 67
    //   1205: iconst_2
    //   1206: ldc_w 608
    //   1209: invokestatic 88	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1212: ldc_w 610
    //   1215: astore_1
    //   1216: goto -585 -> 631
    //   1219: aload_1
    //   1220: astore_2
    //   1221: goto -546 -> 675
    //   1224: iconst_0
    //   1225: istore 9
    //   1227: goto -511 -> 716
    //   1230: astore_1
    //   1231: invokestatic 110	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1234: ifeq -501 -> 733
    //   1237: ldc 67
    //   1239: iconst_2
    //   1240: new 69	java/lang/StringBuilder
    //   1243: dup
    //   1244: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   1247: ldc_w 343
    //   1250: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1253: aload_1
    //   1254: invokevirtual 344	java/lang/Exception:toString	()Ljava/lang/String;
    //   1257: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1260: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1263: invokestatic 88	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1266: goto -533 -> 733
    //   1269: astore_1
    //   1270: goto -727 -> 543
    //   1273: goto -642 -> 631
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1276	0	this	uzs
    //   0	1276	1	paramObject	Object
    //   47	1174	2	localObject1	Object
    //   55	672	3	localHashMap	java.util.HashMap
    //   89	1094	4	str1	String
    //   97	1088	5	str2	String
    //   181	616	6	localObject2	Object
    //   437	340	7	str3	String
    //   74	475	8	i	int
    //   197	1029	9	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   68	150	822	org/json/JSONException
    //   150	169	822	org/json/JSONException
    //   171	232	822	org/json/JSONException
    //   238	302	822	org/json/JSONException
    //   302	326	822	org/json/JSONException
    //   326	505	822	org/json/JSONException
    //   505	519	822	org/json/JSONException
    //   524	537	822	org/json/JSONException
    //   537	543	822	org/json/JSONException
    //   543	571	822	org/json/JSONException
    //   571	593	822	org/json/JSONException
    //   593	629	822	org/json/JSONException
    //   739	746	822	org/json/JSONException
    //   749	819	822	org/json/JSONException
    //   971	1032	822	org/json/JSONException
    //   1032	1041	822	org/json/JSONException
    //   1045	1081	822	org/json/JSONException
    //   1084	1145	822	org/json/JSONException
    //   1145	1154	822	org/json/JSONException
    //   1158	1194	822	org/json/JSONException
    //   675	709	1230	java/lang/Exception
    //   716	733	1230	java/lang/Exception
    //   537	543	1269	java/lang/Exception
  }
  
  protected void onPreExecute()
  {
    Activity localActivity = null;
    if (this.jdField_a_of_type_ComTencentMobileqqThemeThemeSwitchManager.jdField_a_of_type_JavaLangRefWeakReference != null) {
      localActivity = (Activity)this.jdField_a_of_type_ComTencentMobileqqThemeThemeSwitchManager.jdField_a_of_type_JavaLangRefWeakReference.get();
    }
    if (localActivity != null)
    {
      ThemeSwitchManager localThemeSwitchManager = this.jdField_a_of_type_ComTencentMobileqqThemeThemeSwitchManager;
      ThemeSwitchManager.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqThemeThemeSwitchManager.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(localActivity, ((BaseActivity)localActivity).getTitleBarHeight());
      this.jdField_a_of_type_ComTencentMobileqqThemeThemeSwitchManager.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCancelable(false);
      this.jdField_a_of_type_ComTencentMobileqqThemeThemeSwitchManager.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(2131368351);
      this.jdField_a_of_type_ComTencentMobileqqThemeThemeSwitchManager.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    }
    for (;;)
    {
      super.onPreExecute();
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ThemeSwitch", 2, "activity is not TitleBarActivity");
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\uzs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
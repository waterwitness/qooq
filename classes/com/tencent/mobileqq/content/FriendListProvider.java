package com.tencent.mobileqq.content;

import android.content.ContentValues;
import android.content.UriMatcher;
import android.net.Uri;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import mqq.app.AppContentProvider;

public class FriendListProvider
  extends AppContentProvider
  implements FriendList
{
  public static final int a = 1000;
  public static final int b = 1001;
  public static final int c = 1002;
  public static final int d = 1003;
  public static final int e = 1004;
  public static final int f = 1005;
  public static final int g = 1006;
  public static final int h = 1007;
  public static final String r = "FriendListProvider";
  private final UriMatcher a;
  
  public FriendListProvider()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = new UriMatcher(-1);
  }
  
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    return 0;
  }
  
  public String getType(Uri paramUri)
  {
    return null;
  }
  
  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    return null;
  }
  
  public boolean onCreate()
  {
    super.onCreate();
    this.a.addURI("qq.friendlist", "group/#", 1000);
    this.a.addURI("qq.friendlist", "friendlist/#", 1001);
    this.a.addURI("qq.friendlist", "trooplist/#", 1002);
    this.a.addURI("qq.friendlist", "troopmemberinfo/#/#/#", 1003);
    this.a.addURI("qq.friendlist", "troopname/#/#", 1004);
    this.a.addURI("qq.friendlist", "discussinfo/#/#", 1005);
    this.a.addURI("qq.friendlist", "discussmenberinfo/#/#/#", 1006);
    this.a.addURI("qq.friendlist", "individuationUserData/#", 1007);
    return true;
  }
  
  /* Error */
  public android.database.Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 45	com/tencent/mobileqq/content/FriendListProvider:a	Landroid/content/UriMatcher;
    //   4: aload_1
    //   5: invokevirtual 86	android/content/UriMatcher:match	(Landroid/net/Uri;)I
    //   8: istore 8
    //   10: aload_1
    //   11: invokevirtual 92	android/net/Uri:getPathSegments	()Ljava/util/List;
    //   14: iconst_1
    //   15: invokeinterface 98 2 0
    //   20: checkcast 100	java/lang/String
    //   23: astore 6
    //   25: aload_0
    //   26: aload 6
    //   28: invokevirtual 104	com/tencent/mobileqq/content/FriendListProvider:getRuntime	(Ljava/lang/String;)Lmqq/app/AppRuntime;
    //   31: astore 7
    //   33: new 106	com/tencent/mobileqq/content/ProviderAppRuntimeProxy
    //   36: dup
    //   37: invokespecial 107	com/tencent/mobileqq/content/ProviderAppRuntimeProxy:<init>	()V
    //   40: aload 7
    //   42: aload 6
    //   44: iconst_1
    //   45: invokevirtual 110	com/tencent/mobileqq/content/ProviderAppRuntimeProxy:a	(Lmqq/app/AppRuntime;Ljava/lang/String;Z)Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   48: astore 6
    //   50: aload 6
    //   52: ifnonnull +32 -> 84
    //   55: ldc 27
    //   57: iconst_1
    //   58: new 112	java/lang/StringBuilder
    //   61: dup
    //   62: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   65: ldc 115
    //   67: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: aload_1
    //   71: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   74: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   77: invokestatic 131	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   80: aconst_null
    //   81: astore_3
    //   82: aload_3
    //   83: areturn
    //   84: iload 8
    //   86: tableswitch	default:+46->132, 1000:+101->187, 1001:+155->241, 1002:+181->267, 1003:+230->316, 1004:+299->385, 1005:+368->454, 1006:+424->510, 1007:+549->635
    //   132: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   135: ifeq +28 -> 163
    //   138: ldc 27
    //   140: iconst_2
    //   141: new 112	java/lang/StringBuilder
    //   144: dup
    //   145: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   148: ldc -120
    //   150: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: aload_1
    //   154: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   157: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   160: invokestatic 131	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   163: aconst_null
    //   164: astore_2
    //   165: aload_2
    //   166: astore_3
    //   167: aload_2
    //   168: ifnull -86 -> 82
    //   171: aload_2
    //   172: aload_0
    //   173: invokevirtual 140	com/tencent/mobileqq/content/FriendListProvider:getContext	()Landroid/content/Context;
    //   176: invokevirtual 146	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   179: aload_1
    //   180: invokeinterface 152 3 0
    //   185: aload_2
    //   186: areturn
    //   187: aload 6
    //   189: new 154	com/tencent/mobileqq/data/Groups
    //   192: dup
    //   193: invokespecial 155	com/tencent/mobileqq/data/Groups:<init>	()V
    //   196: invokevirtual 158	com/tencent/mobileqq/data/Groups:getTableName	()Ljava/lang/String;
    //   199: iconst_5
    //   200: anewarray 100	java/lang/String
    //   203: dup
    //   204: iconst_0
    //   205: ldc -96
    //   207: aastore
    //   208: dup
    //   209: iconst_1
    //   210: ldc -94
    //   212: aastore
    //   213: dup
    //   214: iconst_2
    //   215: ldc -92
    //   217: aastore
    //   218: dup
    //   219: iconst_3
    //   220: ldc -90
    //   222: aastore
    //   223: dup
    //   224: iconst_4
    //   225: ldc -88
    //   227: aastore
    //   228: aload_3
    //   229: aload 4
    //   231: aload 5
    //   233: aconst_null
    //   234: invokevirtual 173	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   237: astore_2
    //   238: goto -73 -> 165
    //   241: aload 6
    //   243: new 175	com/tencent/mobileqq/data/Friends
    //   246: dup
    //   247: invokespecial 176	com/tencent/mobileqq/data/Friends:<init>	()V
    //   250: invokevirtual 177	com/tencent/mobileqq/data/Friends:getTableName	()Ljava/lang/String;
    //   253: aload_2
    //   254: aload_3
    //   255: aload 4
    //   257: aload 5
    //   259: aconst_null
    //   260: invokevirtual 173	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   263: astore_2
    //   264: goto -99 -> 165
    //   267: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   270: ifeq +34 -> 304
    //   273: ldc -78
    //   275: iconst_2
    //   276: new 112	java/lang/StringBuilder
    //   279: dup
    //   280: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   283: aload_0
    //   284: invokevirtual 184	java/lang/Object:getClass	()Ljava/lang/Class;
    //   287: invokevirtual 189	java/lang/Class:getName	()Ljava/lang/String;
    //   290: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: ldc -65
    //   295: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   301: invokestatic 193	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   304: aload 6
    //   306: ldc -61
    //   308: aconst_null
    //   309: invokevirtual 198	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   312: astore_2
    //   313: goto -148 -> 165
    //   316: aload_1
    //   317: invokevirtual 92	android/net/Uri:getPathSegments	()Ljava/util/List;
    //   320: astore_2
    //   321: aload_2
    //   322: invokeinterface 202 1 0
    //   327: iconst_4
    //   328: if_icmplt +664 -> 992
    //   331: aload 6
    //   333: new 204	com/tencent/mobileqq/data/TroopMemberInfo
    //   336: dup
    //   337: invokespecial 205	com/tencent/mobileqq/data/TroopMemberInfo:<init>	()V
    //   340: invokevirtual 206	com/tencent/mobileqq/data/TroopMemberInfo:getTableName	()Ljava/lang/String;
    //   343: aconst_null
    //   344: ldc -48
    //   346: iconst_2
    //   347: anewarray 100	java/lang/String
    //   350: dup
    //   351: iconst_0
    //   352: aload_2
    //   353: iconst_2
    //   354: invokeinterface 98 2 0
    //   359: checkcast 100	java/lang/String
    //   362: aastore
    //   363: dup
    //   364: iconst_1
    //   365: aload_2
    //   366: iconst_3
    //   367: invokeinterface 98 2 0
    //   372: checkcast 100	java/lang/String
    //   375: aastore
    //   376: aconst_null
    //   377: aconst_null
    //   378: invokevirtual 173	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   381: astore_2
    //   382: goto -217 -> 165
    //   385: aload_1
    //   386: invokevirtual 92	android/net/Uri:getPathSegments	()Ljava/util/List;
    //   389: astore_3
    //   390: aload_3
    //   391: invokeinterface 202 1 0
    //   396: iconst_2
    //   397: if_icmplt -234 -> 163
    //   400: new 210	com/tencent/mobileqq/data/TroopInfo
    //   403: dup
    //   404: invokespecial 211	com/tencent/mobileqq/data/TroopInfo:<init>	()V
    //   407: invokevirtual 212	com/tencent/mobileqq/data/TroopInfo:getTableName	()Ljava/lang/String;
    //   410: astore_2
    //   411: aload_3
    //   412: iconst_2
    //   413: invokeinterface 98 2 0
    //   418: checkcast 100	java/lang/String
    //   421: astore_3
    //   422: aload 6
    //   424: aload_2
    //   425: iconst_1
    //   426: anewarray 100	java/lang/String
    //   429: dup
    //   430: iconst_0
    //   431: ldc -42
    //   433: aastore
    //   434: ldc -40
    //   436: iconst_1
    //   437: anewarray 100	java/lang/String
    //   440: dup
    //   441: iconst_0
    //   442: aload_3
    //   443: aastore
    //   444: aload 5
    //   446: aconst_null
    //   447: invokevirtual 173	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   450: astore_2
    //   451: goto -286 -> 165
    //   454: aload_1
    //   455: invokevirtual 92	android/net/Uri:getPathSegments	()Ljava/util/List;
    //   458: astore_2
    //   459: aload_2
    //   460: invokeinterface 202 1 0
    //   465: iconst_3
    //   466: if_icmplt -303 -> 163
    //   469: aload 6
    //   471: new 218	com/tencent/mobileqq/data/DiscussionInfo
    //   474: dup
    //   475: invokespecial 219	com/tencent/mobileqq/data/DiscussionInfo:<init>	()V
    //   478: invokevirtual 220	com/tencent/mobileqq/data/DiscussionInfo:getTableName	()Ljava/lang/String;
    //   481: aconst_null
    //   482: ldc -34
    //   484: iconst_1
    //   485: anewarray 100	java/lang/String
    //   488: dup
    //   489: iconst_0
    //   490: aload_2
    //   491: iconst_2
    //   492: invokeinterface 98 2 0
    //   497: checkcast 100	java/lang/String
    //   500: aastore
    //   501: aconst_null
    //   502: aconst_null
    //   503: invokevirtual 173	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   506: astore_2
    //   507: goto -342 -> 165
    //   510: aload_1
    //   511: invokevirtual 92	android/net/Uri:getPathSegments	()Ljava/util/List;
    //   514: astore_2
    //   515: aload_2
    //   516: invokeinterface 202 1 0
    //   521: iconst_4
    //   522: if_icmplt -359 -> 163
    //   525: ldc -32
    //   527: aload_2
    //   528: iconst_3
    //   529: invokeinterface 98 2 0
    //   534: invokevirtual 228	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   537: ifeq +44 -> 581
    //   540: aload 6
    //   542: new 230	com/tencent/mobileqq/data/DiscussionMemberInfo
    //   545: dup
    //   546: invokespecial 231	com/tencent/mobileqq/data/DiscussionMemberInfo:<init>	()V
    //   549: invokevirtual 232	com/tencent/mobileqq/data/DiscussionMemberInfo:getTableName	()Ljava/lang/String;
    //   552: aconst_null
    //   553: ldc -22
    //   555: iconst_1
    //   556: anewarray 100	java/lang/String
    //   559: dup
    //   560: iconst_0
    //   561: aload_2
    //   562: iconst_2
    //   563: invokeinterface 98 2 0
    //   568: checkcast 100	java/lang/String
    //   571: aastore
    //   572: aconst_null
    //   573: aconst_null
    //   574: invokevirtual 173	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   577: astore_2
    //   578: goto -413 -> 165
    //   581: aload 6
    //   583: new 230	com/tencent/mobileqq/data/DiscussionMemberInfo
    //   586: dup
    //   587: invokespecial 231	com/tencent/mobileqq/data/DiscussionMemberInfo:<init>	()V
    //   590: invokevirtual 232	com/tencent/mobileqq/data/DiscussionMemberInfo:getTableName	()Ljava/lang/String;
    //   593: aconst_null
    //   594: ldc -20
    //   596: iconst_2
    //   597: anewarray 100	java/lang/String
    //   600: dup
    //   601: iconst_0
    //   602: aload_2
    //   603: iconst_2
    //   604: invokeinterface 98 2 0
    //   609: checkcast 100	java/lang/String
    //   612: aastore
    //   613: dup
    //   614: iconst_1
    //   615: aload_2
    //   616: iconst_3
    //   617: invokeinterface 98 2 0
    //   622: checkcast 100	java/lang/String
    //   625: aastore
    //   626: aconst_null
    //   627: aconst_null
    //   628: invokevirtual 173	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   631: astore_2
    //   632: goto -467 -> 165
    //   635: invokestatic 242	android/os/SystemClock:uptimeMillis	()J
    //   638: lstore 9
    //   640: aload 6
    //   642: ldc -12
    //   644: invokevirtual 247	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   647: aconst_null
    //   648: aload_3
    //   649: aload 4
    //   651: ldc -7
    //   653: ldc -5
    //   655: invokevirtual 173	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   658: astore_2
    //   659: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   662: ifeq +28 -> 690
    //   665: ldc 27
    //   667: iconst_2
    //   668: new 112	java/lang/StringBuilder
    //   671: dup
    //   672: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   675: ldc -3
    //   677: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   680: aload_2
    //   681: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   684: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   687: invokestatic 193	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   690: aload_2
    //   691: ifnull +296 -> 987
    //   694: aload_2
    //   695: invokeinterface 256 1 0
    //   700: ifeq +287 -> 987
    //   703: new 258	android/database/MatrixCursor
    //   706: dup
    //   707: iconst_2
    //   708: anewarray 100	java/lang/String
    //   711: dup
    //   712: iconst_0
    //   713: ldc_w 260
    //   716: aastore
    //   717: dup
    //   718: iconst_1
    //   719: ldc_w 262
    //   722: aastore
    //   723: invokespecial 265	android/database/MatrixCursor:<init>	([Ljava/lang/String;)V
    //   726: astore_3
    //   727: aload_2
    //   728: aload_2
    //   729: ldc_w 260
    //   732: invokeinterface 269 2 0
    //   737: invokeinterface 273 2 0
    //   742: astore 4
    //   744: aload_2
    //   745: aload_2
    //   746: ldc_w 262
    //   749: invokeinterface 269 2 0
    //   754: invokeinterface 273 2 0
    //   759: astore 5
    //   761: aload_3
    //   762: iconst_2
    //   763: anewarray 180	java/lang/Object
    //   766: dup
    //   767: iconst_0
    //   768: aload 4
    //   770: aastore
    //   771: dup
    //   772: iconst_1
    //   773: aload 5
    //   775: aastore
    //   776: invokevirtual 277	android/database/MatrixCursor:addRow	([Ljava/lang/Object;)V
    //   779: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   782: ifeq +56 -> 838
    //   785: ldc 27
    //   787: iconst_2
    //   788: new 112	java/lang/StringBuilder
    //   791: dup
    //   792: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   795: ldc_w 279
    //   798: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   801: aload_2
    //   802: invokeinterface 282 1 0
    //   807: invokevirtual 285	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   810: ldc_w 287
    //   813: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   816: aload 4
    //   818: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   821: ldc_w 289
    //   824: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   827: aload 5
    //   829: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   832: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   835: invokestatic 193	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   838: aload_3
    //   839: astore 4
    //   841: aload_2
    //   842: ifnull +12 -> 854
    //   845: aload_2
    //   846: invokeinterface 292 1 0
    //   851: aload_3
    //   852: astore 4
    //   854: aload 4
    //   856: astore_2
    //   857: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   860: ifeq -695 -> 165
    //   863: ldc 27
    //   865: iconst_2
    //   866: new 112	java/lang/StringBuilder
    //   869: dup
    //   870: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   873: ldc_w 294
    //   876: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   879: invokestatic 242	android/os/SystemClock:uptimeMillis	()J
    //   882: lload 9
    //   884: lsub
    //   885: invokevirtual 297	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   888: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   891: invokestatic 193	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   894: aload 4
    //   896: astore_2
    //   897: goto -732 -> 165
    //   900: astore 4
    //   902: aconst_null
    //   903: astore_3
    //   904: aconst_null
    //   905: astore_2
    //   906: ldc 27
    //   908: iconst_1
    //   909: ldc_w 299
    //   912: aload 4
    //   914: invokestatic 302	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   917: aload_2
    //   918: astore 4
    //   920: aload_3
    //   921: ifnull -67 -> 854
    //   924: aload_3
    //   925: invokeinterface 292 1 0
    //   930: aload_2
    //   931: astore 4
    //   933: goto -79 -> 854
    //   936: astore_1
    //   937: aconst_null
    //   938: astore_2
    //   939: aload_2
    //   940: ifnull +9 -> 949
    //   943: aload_2
    //   944: invokeinterface 292 1 0
    //   949: aload_1
    //   950: athrow
    //   951: astore_1
    //   952: goto -13 -> 939
    //   955: astore_1
    //   956: aload_3
    //   957: astore_2
    //   958: goto -19 -> 939
    //   961: astore 4
    //   963: aload_2
    //   964: astore_3
    //   965: aconst_null
    //   966: astore_2
    //   967: goto -61 -> 906
    //   970: astore 5
    //   972: aload_3
    //   973: astore 4
    //   975: aload_2
    //   976: astore_3
    //   977: aload 4
    //   979: astore_2
    //   980: aload 5
    //   982: astore 4
    //   984: goto -78 -> 906
    //   987: aconst_null
    //   988: astore_3
    //   989: goto -151 -> 838
    //   992: aconst_null
    //   993: astore_2
    //   994: goto -829 -> 165
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	997	0	this	FriendListProvider
    //   0	997	1	paramUri	Uri
    //   0	997	2	paramArrayOfString1	String[]
    //   0	997	3	paramString1	String
    //   0	997	4	paramArrayOfString2	String[]
    //   0	997	5	paramString2	String
    //   23	618	6	localObject	Object
    //   31	10	7	localAppRuntime	mqq.app.AppRuntime
    //   8	77	8	i	int
    //   638	245	9	l	long
    // Exception table:
    //   from	to	target	type
    //   640	659	900	java/lang/Exception
    //   640	659	936	finally
    //   659	690	951	finally
    //   694	779	951	finally
    //   779	838	951	finally
    //   906	917	955	finally
    //   659	690	961	java/lang/Exception
    //   694	779	961	java/lang/Exception
    //   779	838	970	java/lang/Exception
  }
  
  /* Error */
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    // Byte code:
    //   0: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +39 -> 42
    //   6: ldc 27
    //   8: iconst_2
    //   9: new 112	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   16: ldc_w 306
    //   19: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: aload_1
    //   23: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   26: ldc_w 308
    //   29: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: aload_2
    //   33: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   36: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: invokestatic 193	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   42: aload_1
    //   43: ifnonnull +18 -> 61
    //   46: ldc 27
    //   48: iconst_1
    //   49: ldc_w 310
    //   52: invokestatic 131	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   55: iconst_0
    //   56: istore 8
    //   58: iload 8
    //   60: ireturn
    //   61: aload_1
    //   62: invokevirtual 92	android/net/Uri:getPathSegments	()Ljava/util/List;
    //   65: iconst_1
    //   66: invokeinterface 98 2 0
    //   71: checkcast 100	java/lang/String
    //   74: astore_3
    //   75: aload_3
    //   76: invokestatic 316	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   79: ifeq +14 -> 93
    //   82: ldc 27
    //   84: iconst_1
    //   85: ldc_w 318
    //   88: invokestatic 131	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   91: iconst_0
    //   92: ireturn
    //   93: aload_0
    //   94: aload_3
    //   95: invokevirtual 104	com/tencent/mobileqq/content/FriendListProvider:getRuntime	(Ljava/lang/String;)Lmqq/app/AppRuntime;
    //   98: astore 4
    //   100: aload 4
    //   102: ifnonnull +14 -> 116
    //   105: ldc 27
    //   107: iconst_1
    //   108: ldc_w 320
    //   111: invokestatic 131	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   114: iconst_0
    //   115: ireturn
    //   116: new 106	com/tencent/mobileqq/content/ProviderAppRuntimeProxy
    //   119: dup
    //   120: invokespecial 107	com/tencent/mobileqq/content/ProviderAppRuntimeProxy:<init>	()V
    //   123: aload 4
    //   125: aload_3
    //   126: iconst_0
    //   127: invokevirtual 110	com/tencent/mobileqq/content/ProviderAppRuntimeProxy:a	(Lmqq/app/AppRuntime;Ljava/lang/String;Z)Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   130: astore_3
    //   131: aload_3
    //   132: ifnonnull +14 -> 146
    //   135: ldc 27
    //   137: iconst_1
    //   138: ldc_w 322
    //   141: invokestatic 131	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   144: iconst_0
    //   145: ireturn
    //   146: aload_0
    //   147: getfield 45	com/tencent/mobileqq/content/FriendListProvider:a	Landroid/content/UriMatcher;
    //   150: aload_1
    //   151: invokevirtual 86	android/content/UriMatcher:match	(Landroid/net/Uri;)I
    //   154: tableswitch	default:+18->172, 1007:+20->174
    //   172: iconst_0
    //   173: ireturn
    //   174: invokestatic 242	android/os/SystemClock:uptimeMillis	()J
    //   177: lstore 10
    //   179: ldc -12
    //   181: invokevirtual 247	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   184: astore 4
    //   186: aload_3
    //   187: aload 4
    //   189: invokevirtual 325	com/tencent/mobileqq/app/SQLiteDatabase:b	(Ljava/lang/String;)Z
    //   192: ifne +68 -> 260
    //   195: aload_3
    //   196: new 244	com/tencent/mobileqq/vas/VasKeyValue
    //   199: dup
    //   200: invokespecial 326	com/tencent/mobileqq/vas/VasKeyValue:<init>	()V
    //   203: invokestatic 331	com/tencent/mobileqq/persistence/TableBuilder:a	(Lcom/tencent/mobileqq/persistence/Entity;)Ljava/lang/String;
    //   206: invokevirtual 333	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/String;)Z
    //   209: istore 14
    //   211: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   214: ifeq +30 -> 244
    //   217: ldc 27
    //   219: iconst_2
    //   220: new 112	java/lang/StringBuilder
    //   223: dup
    //   224: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   227: ldc_w 335
    //   230: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: iload 14
    //   235: invokevirtual 338	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   238: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   241: invokestatic 193	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   244: iload 14
    //   246: ifne +14 -> 260
    //   249: ldc 27
    //   251: iconst_1
    //   252: ldc_w 340
    //   255: invokestatic 193	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   258: iconst_0
    //   259: ireturn
    //   260: aload_2
    //   261: ldc_w 260
    //   264: invokevirtual 346	android/content/ContentValues:getAsString	(Ljava/lang/String;)Ljava/lang/String;
    //   267: astore 5
    //   269: aload_2
    //   270: ldc_w 262
    //   273: invokevirtual 346	android/content/ContentValues:getAsString	(Ljava/lang/String;)Ljava/lang/String;
    //   276: astore_1
    //   277: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   280: ifeq +40 -> 320
    //   283: ldc 27
    //   285: iconst_2
    //   286: new 112	java/lang/StringBuilder
    //   289: dup
    //   290: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   293: ldc_w 348
    //   296: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: aload 5
    //   301: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   304: ldc_w 350
    //   307: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: aload_1
    //   311: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   314: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   317: invokestatic 193	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   320: aload 5
    //   322: invokestatic 316	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   325: ifeq +14 -> 339
    //   328: ldc 27
    //   330: iconst_1
    //   331: ldc_w 352
    //   334: invokestatic 193	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   337: iconst_0
    //   338: ireturn
    //   339: aload_3
    //   340: aload 4
    //   342: aconst_null
    //   343: ldc_w 354
    //   346: iconst_1
    //   347: anewarray 100	java/lang/String
    //   350: dup
    //   351: iconst_0
    //   352: aload 5
    //   354: aastore
    //   355: aconst_null
    //   356: aconst_null
    //   357: invokevirtual 173	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   360: astore_1
    //   361: aload_1
    //   362: ifnull +200 -> 562
    //   365: aload_1
    //   366: invokeinterface 282 1 0
    //   371: ifle +191 -> 562
    //   374: aload_1
    //   375: invokeinterface 256 1 0
    //   380: ifeq +182 -> 562
    //   383: aload_1
    //   384: aload_1
    //   385: ldc_w 260
    //   388: invokeinterface 269 2 0
    //   393: invokeinterface 273 2 0
    //   398: astore 6
    //   400: aload_1
    //   401: aload_1
    //   402: ldc_w 262
    //   405: invokeinterface 269 2 0
    //   410: invokeinterface 273 2 0
    //   415: astore 7
    //   417: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   420: ifeq +56 -> 476
    //   423: ldc 27
    //   425: iconst_2
    //   426: new 112	java/lang/StringBuilder
    //   429: dup
    //   430: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   433: ldc_w 356
    //   436: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   439: aload 6
    //   441: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   444: ldc_w 358
    //   447: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   450: aload 7
    //   452: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   455: ldc_w 360
    //   458: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   461: aload_1
    //   462: invokeinterface 282 1 0
    //   467: invokevirtual 285	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   470: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   473: invokestatic 193	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   476: aload_3
    //   477: aload 4
    //   479: aload_2
    //   480: ldc_w 354
    //   483: iconst_1
    //   484: anewarray 100	java/lang/String
    //   487: dup
    //   488: iconst_0
    //   489: aload 5
    //   491: aastore
    //   492: invokevirtual 363	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   495: istore 9
    //   497: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   500: ifeq +45 -> 545
    //   503: ldc 27
    //   505: iconst_2
    //   506: new 112	java/lang/StringBuilder
    //   509: dup
    //   510: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   513: ldc_w 365
    //   516: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   519: iload 9
    //   521: invokevirtual 285	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   524: ldc_w 367
    //   527: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   530: invokestatic 242	android/os/SystemClock:uptimeMillis	()J
    //   533: lload 10
    //   535: lsub
    //   536: invokevirtual 297	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   539: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   542: invokestatic 193	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   545: iload 9
    //   547: istore 8
    //   549: aload_1
    //   550: ifnull -492 -> 58
    //   553: aload_1
    //   554: invokeinterface 292 1 0
    //   559: iload 9
    //   561: ireturn
    //   562: aload_3
    //   563: aload 4
    //   565: aconst_null
    //   566: aload_2
    //   567: invokevirtual 370	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   570: lstore 12
    //   572: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   575: ifeq +45 -> 620
    //   578: ldc 27
    //   580: iconst_2
    //   581: new 112	java/lang/StringBuilder
    //   584: dup
    //   585: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   588: ldc_w 372
    //   591: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   594: lload 12
    //   596: invokevirtual 297	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   599: ldc_w 367
    //   602: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   605: invokestatic 242	android/os/SystemClock:uptimeMillis	()J
    //   608: lload 10
    //   610: lsub
    //   611: invokevirtual 297	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   614: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   617: invokestatic 193	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   620: lload 12
    //   622: ldc2_w 373
    //   625: lcmp
    //   626: ifeq +23 -> 649
    //   629: iconst_1
    //   630: istore 9
    //   632: iload 9
    //   634: istore 8
    //   636: aload_1
    //   637: ifnull -579 -> 58
    //   640: aload_1
    //   641: invokeinterface 292 1 0
    //   646: iload 9
    //   648: ireturn
    //   649: iconst_0
    //   650: istore 9
    //   652: goto -20 -> 632
    //   655: astore_2
    //   656: aconst_null
    //   657: astore_1
    //   658: ldc 27
    //   660: iconst_1
    //   661: ldc_w 376
    //   664: aload_2
    //   665: invokestatic 302	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   668: aload_1
    //   669: ifnull -497 -> 172
    //   672: aload_1
    //   673: invokeinterface 292 1 0
    //   678: goto -506 -> 172
    //   681: astore_2
    //   682: aconst_null
    //   683: astore_1
    //   684: aload_1
    //   685: ifnull +9 -> 694
    //   688: aload_1
    //   689: invokeinterface 292 1 0
    //   694: aload_2
    //   695: athrow
    //   696: astore_2
    //   697: goto -13 -> 684
    //   700: astore_2
    //   701: goto -17 -> 684
    //   704: astore_2
    //   705: goto -47 -> 658
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	708	0	this	FriendListProvider
    //   0	708	1	paramUri	Uri
    //   0	708	2	paramContentValues	ContentValues
    //   0	708	3	paramString	String
    //   0	708	4	paramArrayOfString	String[]
    //   267	223	5	str1	String
    //   398	42	6	str2	String
    //   415	36	7	str3	String
    //   56	579	8	i	int
    //   495	156	9	j	int
    //   177	432	10	l1	long
    //   570	51	12	l2	long
    //   209	36	14	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   339	361	655	java/lang/Exception
    //   339	361	681	finally
    //   365	476	696	finally
    //   476	545	696	finally
    //   562	620	696	finally
    //   658	668	700	finally
    //   365	476	704	java/lang/Exception
    //   476	545	704	java/lang/Exception
    //   562	620	704	java/lang/Exception
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\content\FriendListProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.tencent.mobileqq.search.util;

import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import unc;

public class PAOfflineSearchManager
{
  static PAOfflineSearchManager jdField_a_of_type_ComTencentMobileqqSearchUtilPAOfflineSearchManager;
  public static final String a = "PAOfflineSearchManager";
  private static final String c = "1011";
  private static final String d = "pubAcc_JSON";
  ArrayList jdField_a_of_type_JavaUtilArrayList;
  HashMap jdField_a_of_type_JavaUtilHashMap;
  AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean;
  public boolean a;
  public String b;
  public boolean b;
  public boolean c;
  
  PAOfflineSearchManager()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilArrayList = null;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_b_of_type_JavaLangString = "0";
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.c = false;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(1024);
  }
  
  public static PAOfflineSearchManager a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqSearchUtilPAOfflineSearchManager == null) {
        jdField_a_of_type_ComTencentMobileqqSearchUtilPAOfflineSearchManager = new PAOfflineSearchManager();
      }
      PAOfflineSearchManager localPAOfflineSearchManager = jdField_a_of_type_ComTencentMobileqqSearchUtilPAOfflineSearchManager;
      return localPAOfflineSearchManager;
    }
    finally {}
  }
  
  public ArrayList a()
  {
    if (!this.jdField_b_of_type_Boolean) {
      return null;
    }
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(1024);
    }
    if ((this.jdField_a_of_type_JavaUtilArrayList.size() == 0) || (this.c == true))
    {
      if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true))
      {
        b();
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
        this.c = false;
      }
      c();
      this.jdField_a_of_type_Boolean = false;
    }
    if (this.jdField_a_of_type_Boolean == true)
    {
      c();
      this.jdField_a_of_type_Boolean = false;
    }
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a()
  {
    if (!this.jdField_b_of_type_Boolean) {}
    do
    {
      do
      {
        return;
        if (!HtmlOffline.f("1011")) {
          break;
        }
      } while (HttpUtil.a() != 1);
      HtmlOffline.b("1011", BaseApplicationImpl.a().a(), true, new unc(this));
      return;
    } while (!QLog.isColorLevel());
    QLog.d("PAOfflineSearchManager", 2, "check sign failed for publicaccount offline search");
  }
  
  public boolean a(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    if (this.jdField_a_of_type_JavaUtilHashMap == null) {
      this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    }
    return this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString);
  }
  
  /* Error */
  void b()
  {
    // Byte code:
    //   0: invokestatic 132	java/lang/System:currentTimeMillis	()J
    //   3: lstore 13
    //   5: new 134	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   12: ldc 12
    //   14: invokestatic 138	com/tencent/biz/common/offline/HtmlOffline:a	(Ljava/lang/String;)Ljava/lang/String;
    //   17: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: ldc 12
    //   22: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: getstatic 147	java/io/File:separator	Ljava/lang/String;
    //   28: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: ldc 15
    //   33: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: astore_1
    //   40: invokestatic 111	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   43: ifeq +11 -> 54
    //   46: ldc 9
    //   48: iconst_2
    //   49: ldc -103
    //   51: invokestatic 116	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   54: aload_1
    //   55: invokestatic 157	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;)Z
    //   58: ifeq +709 -> 767
    //   61: new 144	java/io/File
    //   64: dup
    //   65: aload_1
    //   66: invokespecial 160	java/io/File:<init>	(Ljava/lang/String;)V
    //   69: astore_1
    //   70: aconst_null
    //   71: astore_2
    //   72: aconst_null
    //   73: astore_3
    //   74: new 162	java/lang/StringBuffer
    //   77: dup
    //   78: ldc -93
    //   80: invokespecial 164	java/lang/StringBuffer:<init>	(I)V
    //   83: astore 4
    //   85: new 166	java/io/BufferedReader
    //   88: dup
    //   89: new 168	java/io/FileReader
    //   92: dup
    //   93: aload_1
    //   94: invokespecial 171	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   97: invokespecial 174	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   100: astore_1
    //   101: aload_1
    //   102: astore_2
    //   103: aload_1
    //   104: invokevirtual 177	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   107: astore_3
    //   108: aload_3
    //   109: ifnull +271 -> 380
    //   112: aload_1
    //   113: astore_2
    //   114: aload 4
    //   116: aload_3
    //   117: invokevirtual 180	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   120: pop
    //   121: goto -20 -> 101
    //   124: astore_3
    //   125: aload_1
    //   126: astore_2
    //   127: invokestatic 111	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   130: ifeq +30 -> 160
    //   133: aload_1
    //   134: astore_2
    //   135: ldc 9
    //   137: iconst_2
    //   138: new 134	java/lang/StringBuilder
    //   141: dup
    //   142: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   145: ldc -74
    //   147: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: aload_3
    //   151: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   154: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   157: invokestatic 116	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   160: aload_1
    //   161: ifnull +7 -> 168
    //   164: aload_1
    //   165: invokevirtual 188	java/io/BufferedReader:close	()V
    //   168: invokestatic 132	java/lang/System:currentTimeMillis	()J
    //   171: lstore 15
    //   173: aload_0
    //   174: getfield 31	com/tencent/mobileqq/search/util/PAOfflineSearchManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   177: ifnonnull +421 -> 598
    //   180: aload_0
    //   181: new 55	java/util/ArrayList
    //   184: dup
    //   185: sipush 1024
    //   188: invokespecial 58	java/util/ArrayList:<init>	(I)V
    //   191: putfield 31	com/tencent/mobileqq/search/util/PAOfflineSearchManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   194: new 190	org/json/JSONObject
    //   197: dup
    //   198: aload 4
    //   200: invokevirtual 191	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   203: invokespecial 192	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   206: astore_1
    //   207: aload_1
    //   208: invokevirtual 196	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   211: astore_2
    //   212: aload_2
    //   213: invokeinterface 201 1 0
    //   218: ifeq +479 -> 697
    //   221: aload_2
    //   222: invokeinterface 205 1 0
    //   227: checkcast 207	java/lang/String
    //   230: astore_3
    //   231: aload_1
    //   232: aload_3
    //   233: invokevirtual 210	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   236: ifeq -24 -> 212
    //   239: aload_1
    //   240: aload_3
    //   241: invokevirtual 214	org/json/JSONObject:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   244: checkcast 216	org/json/JSONArray
    //   247: astore 8
    //   249: aload 8
    //   251: iconst_0
    //   252: invokevirtual 220	org/json/JSONArray:getLong	(I)J
    //   255: invokestatic 226	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   258: invokevirtual 229	java/lang/Long:longValue	()J
    //   261: lstore 17
    //   263: aload 8
    //   265: iconst_1
    //   266: invokevirtual 233	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   269: astore 4
    //   271: aload 8
    //   273: iconst_2
    //   274: invokevirtual 233	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   277: astore 5
    //   279: aload 8
    //   281: iconst_3
    //   282: invokevirtual 233	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   285: astore 6
    //   287: aload 8
    //   289: iconst_4
    //   290: invokevirtual 237	org/json/JSONArray:getInt	(I)I
    //   293: invokestatic 242	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   296: invokevirtual 245	java/lang/Integer:intValue	()I
    //   299: istore 11
    //   301: new 50	java/util/HashMap
    //   304: dup
    //   305: invokespecial 51	java/util/HashMap:<init>	()V
    //   308: astore 7
    //   310: aload 8
    //   312: iconst_5
    //   313: invokevirtual 233	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   316: ldc -9
    //   318: invokevirtual 251	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   321: astore 8
    //   323: aload 8
    //   325: arraylength
    //   326: istore 12
    //   328: iconst_0
    //   329: istore 10
    //   331: iload 10
    //   333: iload 12
    //   335: if_icmpge +327 -> 662
    //   338: aload 8
    //   340: iload 10
    //   342: aaload
    //   343: ldc -3
    //   345: invokevirtual 251	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   348: astore 9
    //   350: aload 9
    //   352: arraylength
    //   353: iconst_1
    //   354: if_icmpne +288 -> 642
    //   357: aload 7
    //   359: aload 9
    //   361: iconst_0
    //   362: aaload
    //   363: iconst_0
    //   364: invokestatic 242	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   367: invokevirtual 257	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   370: pop
    //   371: iload 10
    //   373: iconst_1
    //   374: iadd
    //   375: istore 10
    //   377: goto -46 -> 331
    //   380: aload_1
    //   381: ifnull -213 -> 168
    //   384: aload_1
    //   385: invokevirtual 188	java/io/BufferedReader:close	()V
    //   388: goto -220 -> 168
    //   391: astore_1
    //   392: invokestatic 111	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   395: ifeq -227 -> 168
    //   398: ldc 9
    //   400: iconst_2
    //   401: new 134	java/lang/StringBuilder
    //   404: dup
    //   405: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   408: ldc_w 259
    //   411: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   414: aload_1
    //   415: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   418: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   421: invokestatic 116	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   424: goto -256 -> 168
    //   427: astore_1
    //   428: invokestatic 111	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   431: ifeq -263 -> 168
    //   434: ldc 9
    //   436: iconst_2
    //   437: new 134	java/lang/StringBuilder
    //   440: dup
    //   441: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   444: ldc_w 259
    //   447: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   450: aload_1
    //   451: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   454: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   457: invokestatic 116	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   460: goto -292 -> 168
    //   463: astore_2
    //   464: aload_3
    //   465: astore_1
    //   466: aload_2
    //   467: astore_3
    //   468: aload_1
    //   469: astore_2
    //   470: invokestatic 111	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   473: ifeq +31 -> 504
    //   476: aload_1
    //   477: astore_2
    //   478: ldc 9
    //   480: iconst_2
    //   481: new 134	java/lang/StringBuilder
    //   484: dup
    //   485: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   488: ldc_w 261
    //   491: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   494: aload_3
    //   495: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   498: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   501: invokestatic 116	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   504: aload_1
    //   505: ifnull -337 -> 168
    //   508: aload_1
    //   509: invokevirtual 188	java/io/BufferedReader:close	()V
    //   512: goto -344 -> 168
    //   515: astore_1
    //   516: invokestatic 111	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   519: ifeq -351 -> 168
    //   522: ldc 9
    //   524: iconst_2
    //   525: new 134	java/lang/StringBuilder
    //   528: dup
    //   529: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   532: ldc_w 259
    //   535: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   538: aload_1
    //   539: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   542: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   545: invokestatic 116	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   548: goto -380 -> 168
    //   551: astore_1
    //   552: aload_2
    //   553: ifnull +7 -> 560
    //   556: aload_2
    //   557: invokevirtual 188	java/io/BufferedReader:close	()V
    //   560: aload_1
    //   561: athrow
    //   562: astore_2
    //   563: invokestatic 111	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   566: ifeq -6 -> 560
    //   569: ldc 9
    //   571: iconst_2
    //   572: new 134	java/lang/StringBuilder
    //   575: dup
    //   576: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   579: ldc_w 259
    //   582: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   585: aload_2
    //   586: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   589: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   592: invokestatic 116	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   595: goto -35 -> 560
    //   598: aload_0
    //   599: getfield 31	com/tencent/mobileqq/search/util/PAOfflineSearchManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   602: invokevirtual 264	java/util/ArrayList:clear	()V
    //   605: goto -411 -> 194
    //   608: astore_1
    //   609: invokestatic 111	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   612: ifeq +29 -> 641
    //   615: ldc 9
    //   617: iconst_2
    //   618: new 134	java/lang/StringBuilder
    //   621: dup
    //   622: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   625: ldc_w 266
    //   628: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   631: aload_1
    //   632: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   635: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   638: invokestatic 116	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   641: return
    //   642: aload 7
    //   644: aload 9
    //   646: iconst_0
    //   647: aaload
    //   648: aload 9
    //   650: iconst_1
    //   651: aaload
    //   652: invokestatic 269	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   655: invokevirtual 257	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   658: pop
    //   659: goto -288 -> 371
    //   662: lload 17
    //   664: aload 4
    //   666: aload 5
    //   668: aload 6
    //   670: iload 11
    //   672: aload 7
    //   674: aload_3
    //   675: invokestatic 269	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   678: invokevirtual 245	java/lang/Integer:intValue	()I
    //   681: invokestatic 275	com/tencent/mobileqq/data/PublicAccountInfo:createPublicAccountInfo	(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/util/HashMap;I)Lcom/tencent/mobileqq/data/PublicAccountInfo;
    //   684: astore_3
    //   685: aload_0
    //   686: getfield 31	com/tencent/mobileqq/search/util/PAOfflineSearchManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   689: aload_3
    //   690: invokevirtual 278	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   693: pop
    //   694: goto -482 -> 212
    //   697: invokestatic 132	java/lang/System:currentTimeMillis	()J
    //   700: lstore 17
    //   702: invokestatic 281	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   705: ifeq -64 -> 641
    //   708: ldc 9
    //   710: iconst_4
    //   711: new 134	java/lang/StringBuilder
    //   714: dup
    //   715: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   718: ldc_w 283
    //   721: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   724: lload 17
    //   726: lload 13
    //   728: lsub
    //   729: invokevirtual 286	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   732: ldc_w 288
    //   735: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   738: lload 15
    //   740: lload 13
    //   742: lsub
    //   743: invokevirtual 286	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   746: ldc_w 290
    //   749: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   752: lload 17
    //   754: lload 15
    //   756: lsub
    //   757: invokevirtual 286	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   760: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   763: invokestatic 116	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   766: return
    //   767: invokestatic 111	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   770: ifeq -129 -> 641
    //   773: ldc 9
    //   775: iconst_2
    //   776: ldc_w 292
    //   779: invokestatic 116	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   782: return
    //   783: astore_1
    //   784: goto -232 -> 552
    //   787: astore_3
    //   788: goto -320 -> 468
    //   791: astore_3
    //   792: aconst_null
    //   793: astore_1
    //   794: goto -669 -> 125
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	797	0	this	PAOfflineSearchManager
    //   39	346	1	localObject1	Object
    //   391	24	1	localIOException1	java.io.IOException
    //   427	24	1	localIOException2	java.io.IOException
    //   465	44	1	localObject2	Object
    //   515	24	1	localIOException3	java.io.IOException
    //   551	10	1	localObject3	Object
    //   608	24	1	localException	Exception
    //   783	1	1	localObject4	Object
    //   793	1	1	localObject5	Object
    //   71	151	2	localObject6	Object
    //   463	4	2	localIOException4	java.io.IOException
    //   469	88	2	localObject7	Object
    //   562	24	2	localIOException5	java.io.IOException
    //   73	44	3	str1	String
    //   124	27	3	localFileNotFoundException1	java.io.FileNotFoundException
    //   230	460	3	localObject8	Object
    //   787	1	3	localIOException6	java.io.IOException
    //   791	1	3	localFileNotFoundException2	java.io.FileNotFoundException
    //   83	582	4	localObject9	Object
    //   277	390	5	str2	String
    //   285	384	6	str3	String
    //   308	365	7	localHashMap	HashMap
    //   247	92	8	localObject10	Object
    //   348	301	9	arrayOfString	String[]
    //   329	47	10	i	int
    //   299	372	11	j	int
    //   326	10	12	k	int
    //   3	738	13	l1	long
    //   171	584	15	l2	long
    //   261	492	17	l3	long
    // Exception table:
    //   from	to	target	type
    //   103	108	124	java/io/FileNotFoundException
    //   114	121	124	java/io/FileNotFoundException
    //   384	388	391	java/io/IOException
    //   164	168	427	java/io/IOException
    //   85	101	463	java/io/IOException
    //   508	512	515	java/io/IOException
    //   85	101	551	finally
    //   470	476	551	finally
    //   478	504	551	finally
    //   556	560	562	java/io/IOException
    //   173	194	608	java/lang/Exception
    //   194	212	608	java/lang/Exception
    //   212	328	608	java/lang/Exception
    //   338	371	608	java/lang/Exception
    //   598	605	608	java/lang/Exception
    //   642	659	608	java/lang/Exception
    //   662	694	608	java/lang/Exception
    //   697	766	608	java/lang/Exception
    //   103	108	783	finally
    //   114	121	783	finally
    //   127	133	783	finally
    //   135	160	783	finally
    //   103	108	787	java/io/IOException
    //   114	121	787	java/io/IOException
    //   85	101	791	java/io/FileNotFoundException
  }
  
  void c()
  {
    long l1;
    Object localObject1;
    Object localObject2;
    try
    {
      l1 = System.currentTimeMillis();
      HashMap localHashMap = new HashMap();
      localObject1 = BaseApplicationImpl.a().a();
      if ((localObject1 instanceof QQAppInterface))
      {
        localObject1 = ((PublicAccountDataManager)((AppRuntime)localObject1).getManager(55)).a().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (Entity)((Iterator)localObject1).next();
          if ((localObject2 != null) && ((localObject2 instanceof PublicAccountInfo)))
          {
            localObject2 = (PublicAccountInfo)localObject2;
            localHashMap.put(((PublicAccountInfo)localObject2).getUin(), localObject2);
            continue;
            return;
          }
        }
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PAOfflineSearchManager", 2, "", localException);
      }
    }
    int j = this.jdField_a_of_type_JavaUtilArrayList.size();
    if (this.jdField_a_of_type_JavaUtilHashMap == null) {
      this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    }
    for (;;)
    {
      int i;
      if (i < j)
      {
        localObject1 = (PublicAccountInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        localObject2 = ((PublicAccountInfo)localObject1).getUin();
        if (localException.containsKey(localObject2))
        {
          if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(localObject2)) {
            this.jdField_a_of_type_JavaUtilHashMap.remove(localObject2);
          }
          ((PublicAccountInfo)localException.get(localObject2)).Marks = ((PublicAccountInfo)localObject1).Marks;
        }
        else if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(localObject2))
        {
          this.jdField_a_of_type_JavaUtilHashMap.put(localObject2, Integer.valueOf(1));
        }
      }
      else
      {
        long l2 = System.currentTimeMillis();
        if (!QLog.isDevelopLevel()) {
          break;
        }
        QLog.d("PAOfflineSearchManager", 4, "adjust list cost:" + (l2 - l1));
        return;
        i = 0;
        continue;
      }
      i += 1;
    }
  }
  
  public void d()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\search\util\PAOfflineSearchManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
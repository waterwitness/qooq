package com.tencent.mobileqq.business.sougou;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask.Callback;
import com.tencent.mobileqq.utils.SoLoadUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.manager.Manager;
import mqq.manager.TicketManager;
import qur;
import qus;
import qut;
import quv;
import quw;

public class WordMatchManager
  implements Manager
{
  public static final int a = 0;
  public static final String a = "GB2312";
  protected static final int b = 4096;
  protected static final String b = ".business.sougou.DicFileDownloader";
  protected static final int c = 30000;
  protected static final String c;
  protected static final int d = 30000;
  protected static final String d = "BUSINESS_DICT_FILE_MANAGER";
  protected static final int e = 86400;
  protected static final String e = "REQUEST_DICT_MD5_";
  protected static final int f = 0;
  protected static final String f = "DICT_MD5_";
  protected static final int g = 1;
  protected static final String g = "DICT_ID_";
  protected static final int h = 2;
  protected static final String h = "DICT_LAST_MODIFIED_";
  protected static final int i = 3;
  protected static final String i = "DICT_LAST_REQUEST_TIME";
  protected static final int j = 4;
  protected static final String j = "big";
  protected static final String k = "small";
  protected static final String l = "dict.xdb";
  protected static final String m = "rules.ini";
  protected static final String n = "http://pub.idqqimg.com/pc/qqclient/sfile/big.gz";
  protected static final String o = "http://pub.idqqimg.com/pc/qqclient/sfile/small.gz";
  protected static final String p = "http://pub.idqqimg.com/pc/qqclient/sfile/wsdict.gz";
  protected static final String q = "http://pub.idqqimg.com/pc/qqclient/sfile/srule.gz";
  protected static final String r = "http://cgi.qqweb.qq.com/cgi-bin/frequency/whether_request_cdn";
  public QQAppInterface a;
  protected WordMatchManager.DictLocalMetaInfo a;
  protected WordMatchManager.Environment a;
  public WordMatchManager.WordMatcher a;
  protected HttpWebCgiAsyncTask.Callback a;
  public ArrayList a;
  boolean a;
  protected WordMatchManager.DictLocalMetaInfo b;
  public boolean b;
  public boolean c;
  public boolean d;
  public boolean e = false;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_c_of_type_JavaLangString = AppConstants.bh + "/Tencent/QQ_business";
  }
  
  public WordMatchManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$WordMatcher = new WordMatchManager.HotWordMatcher(this);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$Environment = new WordMatchManager.Environment();
    this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$DictLocalMetaInfo = new WordMatchManager.DictLocalMetaInfo();
    this.jdField_b_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$DictLocalMetaInfo = new WordMatchManager.DictLocalMetaInfo();
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsHttpWebCgiAsyncTask$Callback = new quv(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    paramQQAppInterface.a();
    if ((!this.jdField_a_of_type_Boolean) && (SoLoadUtil.a(BaseApplication.getContext(), "stlport_shared", 0, false))) {}
    try
    {
      this.jdField_a_of_type_Boolean = SoLoadUtil.a(BaseApplication.getContext(), "Matcher", 0, false);
      return;
    }
    catch (UnsatisfiedLinkError paramQQAppInterface)
    {
      this.jdField_a_of_type_Boolean = false;
      paramQQAppInterface.printStackTrace();
    }
  }
  
  protected long a(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences("BUSINESS_DICT_FILE_MANAGER", 0).getLong("DICT_LAST_MODIFIED_" + paramInt, 0L);
  }
  
  public WordMatchManager.WordMatcher a(WordMatchManager.MatcherCallback paramMatcherCallback)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return null;
    }
    if (this.jdField_c_of_type_Boolean) {
      return this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$WordMatcher;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.runOnUiThread(new qur(this, paramMatcherCallback));
    return null;
  }
  
  protected String a(int paramInt)
  {
    String str = jdField_c_of_type_JavaLangString;
    switch (paramInt)
    {
    default: 
      return "";
    case 1: 
      return str + File.separator + "small";
    case 2: 
      return str + File.separator + "big";
    case 3: 
      return str + File.separator + "dict.xdb";
    }
    return str + File.separator + "rules.ini";
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$Environment.jdField_a_of_type_Boolean = a(2);
    this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$Environment.jdField_b_of_type_Boolean = a(1);
    WordMatchManager.Environment localEnvironment = this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$Environment;
    if ((a(3)) && (a(4))) {}
    for (boolean bool = true;; bool = false)
    {
      localEnvironment.jdField_c_of_type_Boolean = bool;
      if (this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$Environment.jdField_a_of_type_Boolean) {
        b(2);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$Environment.jdField_b_of_type_Boolean) {
        b(1);
      }
      return;
    }
  }
  
  protected void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.runOnUiThread(new quw(this, paramInt));
  }
  
  protected void a(int paramInt, long paramLong)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences("BUSINESS_DICT_FILE_MANAGER", 0).edit().putLong("DICT_LAST_MODIFIED_" + paramInt, paramLong).commit();
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(".business.sougou.DicFileDownloader", 2, "requestGetDictOrNot cgi begin| type:" + paramInt + ",time:" + System.currentTimeMillis());
    }
    Object localObject2 = (TicketManager)paramQQAppInterface.getManager(2);
    Object localObject1 = paramQQAppInterface.a();
    localObject2 = ((TicketManager)localObject2).getSkey(paramQQAppInterface.a());
    paramQQAppInterface = new Bundle();
    paramQQAppInterface.putString("type", "" + paramInt);
    paramQQAppInterface.putString("id", c(paramInt));
    paramQQAppInterface.putString("md5", "" + d(paramInt));
    paramQQAppInterface.putString("version", "6.5.5");
    paramQQAppInterface.putString("platform", "android");
    paramQQAppInterface.putString("Cookie", "uin=o" + (String)localObject1 + ";skey=" + (String)localObject2);
    localObject1 = new HashMap();
    ((HashMap)localObject1).put("BUNDLE", paramQQAppInterface);
    ((HashMap)localObject1).put("CONTEXT", BaseApplication.getContext());
    new HttpWebCgiAsyncTask("http://cgi.qqweb.qq.com/cgi-bin/frequency/whether_request_cdn", "POST", this.jdField_a_of_type_ComTencentMobileqqTroopUtilsHttpWebCgiAsyncTask$Callback, paramInt, null, true).execute(new HashMap[] { localObject1 });
  }
  
  public void a(WordMatchManager.DictLocalMetaInfo paramDictLocalMetaInfo)
  {
    if (paramDictLocalMetaInfo.jdField_b_of_type_Int != 1)
    {
      a(paramDictLocalMetaInfo.jdField_a_of_type_Int);
      return;
    }
    if (paramDictLocalMetaInfo.jdField_a_of_type_Int == 2) {
      this.jdField_b_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$DictLocalMetaInfo = paramDictLocalMetaInfo;
    }
    for (;;)
    {
      ThreadManager.a(new WordMatchManager.TaskHttpDownload(this, paramDictLocalMetaInfo.jdField_a_of_type_Int), 8, null, true);
      return;
      if (paramDictLocalMetaInfo.jdField_a_of_type_Int == 1) {
        this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$DictLocalMetaInfo = paramDictLocalMetaInfo;
      }
    }
  }
  
  public void a(WordMatchManager.MatcherCallback paramMatcherCallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.runOnUiThread(new qus(this, paramMatcherCallback));
  }
  
  public void a(boolean paramBoolean)
  {
    ThreadManager.a(new qut(this, paramBoolean), 5, null, true);
    if (QLog.isDevelopLevel()) {
      QLog.d(".business.sougou.DicFileDownloader", 4, "handleUpdateCompleted:" + paramBoolean);
    }
  }
  
  protected boolean a(int paramInt)
  {
    String str = a(paramInt);
    if (!new File(str).exists()) {
      return false;
    }
    return e(paramInt).equalsIgnoreCase(DictFileUtil.a(str));
  }
  
  protected String b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 1: 
      return "http://pub.idqqimg.com/pc/qqclient/sfile/small.gz";
    case 2: 
      return "http://pub.idqqimg.com/pc/qqclient/sfile/big.gz";
    case 3: 
      return "http://pub.idqqimg.com/pc/qqclient/sfile/wsdict.gz";
    }
    return "http://pub.idqqimg.com/pc/qqclient/sfile/srule.gz";
  }
  
  public void b()
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences("BUSINESS_DICT_FILE_MANAGER", 0);
    long l1 = localSharedPreferences.getLong("DICT_LAST_REQUEST_TIME", 0L);
    long l2 = System.currentTimeMillis() / 1000L;
    if ((this.jdField_b_of_type_Boolean) && (l2 - l1 < 86400L))
    {
      a(true);
      return;
    }
    this.jdField_b_of_type_Boolean = true;
    localSharedPreferences.edit().putLong("DICT_LAST_REQUEST_TIME", l2).commit();
    a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2);
  }
  
  /* Error */
  protected void b(int paramInt)
  {
    // Byte code:
    //   0: new 197	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: iload_1
    //   6: invokevirtual 352	com/tencent/mobileqq/business/sougou/WordMatchManager:a	(I)Ljava/lang/String;
    //   9: invokespecial 355	java/io/File:<init>	(Ljava/lang/String;)V
    //   12: astore 4
    //   14: iconst_4
    //   15: newarray <illegal type>
    //   17: astore 5
    //   19: new 387	java/io/FileInputStream
    //   22: dup
    //   23: aload 4
    //   25: invokespecial 390	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   28: astore_3
    //   29: aload_3
    //   30: astore_2
    //   31: aload_3
    //   32: aload 5
    //   34: invokevirtual 396	java/io/InputStream:read	([B)I
    //   37: pop
    //   38: aload_3
    //   39: astore_2
    //   40: aload_3
    //   41: aload 5
    //   43: invokevirtual 396	java/io/InputStream:read	([B)I
    //   46: pop
    //   47: aload_3
    //   48: astore_2
    //   49: aload 5
    //   51: invokestatic 398	com/tencent/mobileqq/business/sougou/DictFileUtil:a	([B)I
    //   54: istore_1
    //   55: iload_1
    //   56: iconst_4
    //   57: iadd
    //   58: i2l
    //   59: lstore 7
    //   61: aload_3
    //   62: astore_2
    //   63: aload 4
    //   65: invokevirtual 401	java/io/File:length	()J
    //   68: lstore 9
    //   70: lload 7
    //   72: lload 9
    //   74: lcmp
    //   75: ifle +18 -> 93
    //   78: aload_3
    //   79: ifnull +7 -> 86
    //   82: aload_3
    //   83: invokevirtual 404	java/io/InputStream:close	()V
    //   86: return
    //   87: astore_2
    //   88: aload_2
    //   89: invokevirtual 405	java/io/IOException:printStackTrace	()V
    //   92: return
    //   93: aload_3
    //   94: astore_2
    //   95: iload_1
    //   96: newarray <illegal type>
    //   98: astore 4
    //   100: aload_3
    //   101: astore_2
    //   102: aload_3
    //   103: aload 4
    //   105: invokevirtual 396	java/io/InputStream:read	([B)I
    //   108: pop
    //   109: aload_3
    //   110: astore_2
    //   111: new 366	java/lang/String
    //   114: dup
    //   115: aload 4
    //   117: invokespecial 408	java/lang/String:<init>	([B)V
    //   120: astore 4
    //   122: aload 4
    //   124: astore_2
    //   125: aload_3
    //   126: ifnull +10 -> 136
    //   129: aload_3
    //   130: invokevirtual 404	java/io/InputStream:close	()V
    //   133: aload 4
    //   135: astore_2
    //   136: new 410	org/json/JSONObject
    //   139: dup
    //   140: aload_2
    //   141: invokespecial 411	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   144: ldc_w 413
    //   147: invokevirtual 417	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   150: astore_2
    //   151: iconst_0
    //   152: istore_1
    //   153: iload_1
    //   154: aload_2
    //   155: invokevirtual 422	org/json/JSONArray:length	()I
    //   158: if_icmpge -72 -> 86
    //   161: aload_2
    //   162: iload_1
    //   163: invokevirtual 426	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   166: astore_3
    //   167: aload_3
    //   168: ldc_w 428
    //   171: invokevirtual 431	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   174: ldc_w 433
    //   177: invokevirtual 370	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   180: ifeq +30 -> 210
    //   183: aload_3
    //   184: ldc_w 435
    //   187: invokevirtual 439	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   190: istore 6
    //   192: aload_0
    //   193: getfield 128	com/tencent/mobileqq/business/sougou/WordMatchManager:jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$Environment	Lcom/tencent/mobileqq/business/sougou/WordMatchManager$Environment;
    //   196: getfield 442	com/tencent/mobileqq/business/sougou/WordMatchManager$Environment:jdField_a_of_type_JavaUtilSet	Ljava/util/Set;
    //   199: iload 6
    //   201: invokestatic 448	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   204: invokeinterface 454 2 0
    //   209: pop
    //   210: iload_1
    //   211: iconst_1
    //   212: iadd
    //   213: istore_1
    //   214: goto -61 -> 153
    //   217: astore_2
    //   218: aload_2
    //   219: invokevirtual 405	java/io/IOException:printStackTrace	()V
    //   222: aload 4
    //   224: astore_2
    //   225: goto -89 -> 136
    //   228: astore 4
    //   230: aconst_null
    //   231: astore_3
    //   232: aload_3
    //   233: astore_2
    //   234: aload 4
    //   236: invokevirtual 455	java/io/FileNotFoundException:printStackTrace	()V
    //   239: aload_3
    //   240: ifnull +101 -> 341
    //   243: aload_3
    //   244: invokevirtual 404	java/io/InputStream:close	()V
    //   247: ldc -61
    //   249: astore_2
    //   250: goto -114 -> 136
    //   253: astore_2
    //   254: aload_2
    //   255: invokevirtual 405	java/io/IOException:printStackTrace	()V
    //   258: ldc -61
    //   260: astore_2
    //   261: goto -125 -> 136
    //   264: astore 4
    //   266: aconst_null
    //   267: astore_3
    //   268: aload_3
    //   269: astore_2
    //   270: aload 4
    //   272: invokevirtual 405	java/io/IOException:printStackTrace	()V
    //   275: aload_3
    //   276: ifnull +65 -> 341
    //   279: aload_3
    //   280: invokevirtual 404	java/io/InputStream:close	()V
    //   283: ldc -61
    //   285: astore_2
    //   286: goto -150 -> 136
    //   289: astore_2
    //   290: aload_2
    //   291: invokevirtual 405	java/io/IOException:printStackTrace	()V
    //   294: ldc -61
    //   296: astore_2
    //   297: goto -161 -> 136
    //   300: astore_3
    //   301: aconst_null
    //   302: astore_2
    //   303: aload_2
    //   304: ifnull +7 -> 311
    //   307: aload_2
    //   308: invokevirtual 404	java/io/InputStream:close	()V
    //   311: aload_3
    //   312: athrow
    //   313: astore_2
    //   314: aload_2
    //   315: invokevirtual 405	java/io/IOException:printStackTrace	()V
    //   318: goto -7 -> 311
    //   321: astore_2
    //   322: aload_2
    //   323: invokevirtual 456	org/json/JSONException:printStackTrace	()V
    //   326: return
    //   327: astore_3
    //   328: goto -25 -> 303
    //   331: astore 4
    //   333: goto -65 -> 268
    //   336: astore 4
    //   338: goto -106 -> 232
    //   341: ldc -61
    //   343: astore_2
    //   344: goto -208 -> 136
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	347	0	this	WordMatchManager
    //   0	347	1	paramInt	int
    //   30	33	2	localObject1	Object
    //   87	2	2	localIOException1	java.io.IOException
    //   94	68	2	localObject2	Object
    //   217	2	2	localIOException2	java.io.IOException
    //   224	26	2	localObject3	Object
    //   253	2	2	localIOException3	java.io.IOException
    //   260	26	2	localObject4	Object
    //   289	2	2	localIOException4	java.io.IOException
    //   296	12	2	str1	String
    //   313	2	2	localIOException5	java.io.IOException
    //   321	2	2	localJSONException	org.json.JSONException
    //   343	1	2	str2	String
    //   28	252	3	localObject5	Object
    //   300	12	3	localObject6	Object
    //   327	1	3	localObject7	Object
    //   12	211	4	localObject8	Object
    //   228	7	4	localFileNotFoundException1	java.io.FileNotFoundException
    //   264	7	4	localIOException6	java.io.IOException
    //   331	1	4	localIOException7	java.io.IOException
    //   336	1	4	localFileNotFoundException2	java.io.FileNotFoundException
    //   17	33	5	arrayOfByte	byte[]
    //   190	10	6	i1	int
    //   59	12	7	l1	long
    //   68	5	9	l2	long
    // Exception table:
    //   from	to	target	type
    //   82	86	87	java/io/IOException
    //   129	133	217	java/io/IOException
    //   14	29	228	java/io/FileNotFoundException
    //   243	247	253	java/io/IOException
    //   14	29	264	java/io/IOException
    //   279	283	289	java/io/IOException
    //   14	29	300	finally
    //   307	311	313	java/io/IOException
    //   136	151	321	org/json/JSONException
    //   153	210	321	org/json/JSONException
    //   31	38	327	finally
    //   40	47	327	finally
    //   49	55	327	finally
    //   63	70	327	finally
    //   95	100	327	finally
    //   102	109	327	finally
    //   111	122	327	finally
    //   234	239	327	finally
    //   270	275	327	finally
    //   31	38	331	java/io/IOException
    //   40	47	331	java/io/IOException
    //   49	55	331	java/io/IOException
    //   63	70	331	java/io/IOException
    //   95	100	331	java/io/IOException
    //   102	109	331	java/io/IOException
    //   111	122	331	java/io/IOException
    //   31	38	336	java/io/FileNotFoundException
    //   40	47	336	java/io/FileNotFoundException
    //   49	55	336	java/io/FileNotFoundException
    //   63	70	336	java/io/FileNotFoundException
    //   95	100	336	java/io/FileNotFoundException
    //   102	109	336	java/io/FileNotFoundException
    //   111	122	336	java/io/FileNotFoundException
  }
  
  protected void b(WordMatchManager.DictLocalMetaInfo paramDictLocalMetaInfo)
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences("BUSINESS_DICT_FILE_MANAGER", 0);
    localSharedPreferences.edit().putString("REQUEST_DICT_MD5_" + paramDictLocalMetaInfo.jdField_a_of_type_Int, paramDictLocalMetaInfo.jdField_a_of_type_JavaLangString).commit();
    localSharedPreferences.edit().putString("DICT_ID_" + paramDictLocalMetaInfo.jdField_a_of_type_Int, paramDictLocalMetaInfo.jdField_c_of_type_JavaLangString).commit();
    localSharedPreferences.edit().putString("DICT_MD5_" + paramDictLocalMetaInfo.jdField_a_of_type_Int, paramDictLocalMetaInfo.jdField_b_of_type_JavaLangString).commit();
  }
  
  protected String c(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences("BUSINESS_DICT_FILE_MANAGER", 0).getString("DICT_ID_" + paramInt, "0");
  }
  
  protected String d(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences("BUSINESS_DICT_FILE_MANAGER", 0).getString("REQUEST_DICT_MD5_" + paramInt, "0");
  }
  
  protected String e(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences("BUSINESS_DICT_FILE_MANAGER", 0).getString("DICT_MD5_" + paramInt, "0");
  }
  
  public void onDestroy() {}
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\business\sougou\WordMatchManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
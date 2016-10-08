import android.text.TextUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.vashealth.HealthBusinessPlugin;
import com.tencent.qphone.base.util.QLog;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.util.WeakReference;
import org.json.JSONObject;

public class wfb
  extends Thread
{
  String jdField_a_of_type_JavaLangString;
  List jdField_a_of_type_JavaUtilList;
  WeakReference jdField_a_of_type_MqqUtilWeakReference;
  boolean jdField_a_of_type_Boolean;
  String b;
  String c;
  String d;
  
  public wfb(HealthBusinessPlugin paramHealthBusinessPlugin, BaseActivity paramBaseActivity, List paramList, String paramString1, String paramString2, boolean paramBoolean, String paramString3, String paramString4)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilList = new ArrayList(paramList);
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramBaseActivity);
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.c = paramString3;
    this.d = paramString4;
  }
  
  String a(String paramString1, String paramString2, String paramString3, String paramString4, Map paramMap)
  {
    HashMap localHashMap1;
    HashMap localHashMap2;
    if (FileUtil.a(paramString2))
    {
      localHashMap1 = new HashMap();
      localHashMap1.put("Connection", "keep-alive");
      localHashMap1.put("Referer", "c.yundong.qq.com");
      localHashMap2 = new HashMap();
      localHashMap2.put("picstream", paramString2);
      if (paramMap != null) {
        break label200;
      }
    }
    label200:
    for (paramString2 = new HashMap();; paramString2 = paramMap)
    {
      paramString1 = HttpUtil.a(paramString1, paramString3, paramString4, paramString2, localHashMap2, localHashMap1);
      if (QLog.isColorLevel()) {
        QLog.i("HealthBusinessPlugin", 2, "upload result:" + paramString1);
      }
      if (TextUtils.isEmpty(paramString1)) {}
      for (;;)
      {
        return null;
        try
        {
          paramString1 = new JSONObject(paramString1);
          if (paramString1.getInt("code") == 0)
          {
            paramString1 = URLDecoder.decode(paramString1.getJSONObject("data").getString("picUrl"), "utf-8");
            return paramString1;
          }
        }
        catch (Exception paramString1)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.i("HealthBusinessPlugin", 2, "parse json Exception:" + paramString1);
            }
            paramString1 = null;
          }
        }
      }
    }
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 39	wfb:jdField_a_of_type_MqqUtilWeakReference	Lmqq/util/WeakReference;
    //   4: ifnonnull +64 -> 68
    //   7: aconst_null
    //   8: astore_1
    //   9: aload_1
    //   10: ifnull +20 -> 30
    //   13: aload_1
    //   14: invokevirtual 156	com/tencent/mobileqq/app/BaseActivity:getAppInterface	()Lcom/tencent/common/app/AppInterface;
    //   17: ifnull +13 -> 30
    //   20: aload_0
    //   21: getfield 41	wfb:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   24: invokestatic 113	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   27: ifeq +55 -> 82
    //   30: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   33: ifeq +34 -> 67
    //   36: ldc 90
    //   38: iconst_2
    //   39: new 92	java/lang/StringBuilder
    //   42: dup
    //   43: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   46: ldc -98
    //   48: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: aload_0
    //   52: getfield 41	wfb:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   55: invokestatic 113	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   58: invokevirtual 161	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   61: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   64: invokestatic 163	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   67: return
    //   68: aload_0
    //   69: getfield 39	wfb:jdField_a_of_type_MqqUtilWeakReference	Lmqq/util/WeakReference;
    //   72: invokevirtual 167	mqq/util/WeakReference:get	()Ljava/lang/Object;
    //   75: checkcast 152	com/tencent/mobileqq/app/BaseActivity
    //   78: astore_1
    //   79: goto -70 -> 9
    //   82: aload_1
    //   83: invokevirtual 156	com/tencent/mobileqq/app/BaseActivity:getAppInterface	()Lcom/tencent/common/app/AppInterface;
    //   86: invokevirtual 171	com/tencent/common/app/AppInterface:a	()Ljava/lang/String;
    //   89: astore 5
    //   91: aload_1
    //   92: invokevirtual 156	com/tencent/mobileqq/app/BaseActivity:getAppInterface	()Lcom/tencent/common/app/AppInterface;
    //   95: iconst_2
    //   96: invokevirtual 175	com/tencent/common/app/AppInterface:getManager	(I)Lmqq/manager/Manager;
    //   99: checkcast 177	mqq/manager/TicketManager
    //   102: aload 5
    //   104: invokeinterface 180 2 0
    //   109: astore 6
    //   111: aload 6
    //   113: invokestatic 113	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   116: ifeq +18 -> 134
    //   119: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   122: ifeq -55 -> 67
    //   125: ldc 90
    //   127: iconst_2
    //   128: ldc -74
    //   130: invokestatic 163	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   133: return
    //   134: sipush 5381
    //   137: istore 11
    //   139: iconst_0
    //   140: istore 10
    //   142: aload 6
    //   144: invokevirtual 188	java/lang/String:length	()I
    //   147: istore 12
    //   149: iload 10
    //   151: iload 12
    //   153: if_icmpge +29 -> 182
    //   156: iload 11
    //   158: iload 11
    //   160: iconst_5
    //   161: ishl
    //   162: aload 6
    //   164: iload 10
    //   166: invokevirtual 192	java/lang/String:charAt	(I)C
    //   169: iadd
    //   170: iadd
    //   171: istore 11
    //   173: iload 10
    //   175: iconst_1
    //   176: iadd
    //   177: istore 10
    //   179: goto -30 -> 149
    //   182: iload 11
    //   184: ldc -63
    //   186: iand
    //   187: istore 12
    //   189: aload_0
    //   190: getfield 45	wfb:jdField_a_of_type_Boolean	Z
    //   193: ifeq +192 -> 385
    //   196: new 92	java/lang/StringBuilder
    //   199: dup
    //   200: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   203: ldc -61
    //   205: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: iload 12
    //   210: invokevirtual 198	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   213: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   216: astore_1
    //   217: aload_0
    //   218: getfield 17	wfb:jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin	Lcom/tencent/mobileqq/vashealth/HealthBusinessPlugin;
    //   221: getfield 202	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:b	Z
    //   224: ifeq +12 -> 236
    //   227: aload_1
    //   228: ldc -52
    //   230: ldc -50
    //   232: invokevirtual 209	java/lang/String:replaceFirst	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   235: pop
    //   236: aload_0
    //   237: getfield 45	wfb:jdField_a_of_type_Boolean	Z
    //   240: ifne +169 -> 409
    //   243: aload_0
    //   244: getfield 32	wfb:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   247: iconst_0
    //   248: invokeinterface 214 2 0
    //   253: checkcast 184	java/lang/String
    //   256: astore_3
    //   257: aload_3
    //   258: invokestatic 113	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   261: ifne -194 -> 67
    //   264: new 60	java/util/HashMap
    //   267: dup
    //   268: invokespecial 61	java/util/HashMap:<init>	()V
    //   271: astore_2
    //   272: aload_2
    //   273: ldc -40
    //   275: aload_0
    //   276: getfield 41	wfb:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   279: invokevirtual 217	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   282: pop
    //   283: new 219	android/os/Bundle
    //   286: dup
    //   287: invokespecial 220	android/os/Bundle:<init>	()V
    //   290: astore 4
    //   292: aload 4
    //   294: ldc -34
    //   296: aload_0
    //   297: getfield 47	wfb:c	Ljava/lang/String;
    //   300: invokevirtual 226	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   303: aload 4
    //   305: ldc -28
    //   307: aload_0
    //   308: getfield 49	wfb:d	Ljava/lang/String;
    //   311: invokevirtual 226	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   314: aload 4
    //   316: ldc -26
    //   318: aload_3
    //   319: invokevirtual 226	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   322: aload 4
    //   324: ldc -24
    //   326: new 234	java/io/File
    //   329: dup
    //   330: aload_3
    //   331: invokespecial 235	java/io/File:<init>	(Ljava/lang/String;)V
    //   334: invokevirtual 238	java/io/File:getName	()Ljava/lang/String;
    //   337: invokevirtual 226	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   340: aload_0
    //   341: getfield 17	wfb:jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin	Lcom/tencent/mobileqq/vashealth/HealthBusinessPlugin;
    //   344: aload_1
    //   345: aload_3
    //   346: aload 5
    //   348: aload 6
    //   350: aload_2
    //   351: aload 4
    //   353: invokevirtual 241	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Landroid/os/Bundle;)V
    //   356: getstatic 242	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   359: aload_0
    //   360: getfield 43	wfb:b	Ljava/lang/String;
    //   363: invokeinterface 246 2 0
    //   368: ifeq -301 -> 67
    //   371: getstatic 242	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   374: aload_0
    //   375: getfield 43	wfb:b	Ljava/lang/String;
    //   378: invokeinterface 249 2 0
    //   383: pop
    //   384: return
    //   385: new 92	java/lang/StringBuilder
    //   388: dup
    //   389: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   392: ldc -5
    //   394: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   397: iload 12
    //   399: invokevirtual 198	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   402: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   405: astore_1
    //   406: goto -189 -> 217
    //   409: aload_0
    //   410: getfield 39	wfb:jdField_a_of_type_MqqUtilWeakReference	Lmqq/util/WeakReference;
    //   413: invokevirtual 167	mqq/util/WeakReference:get	()Ljava/lang/Object;
    //   416: checkcast 152	com/tencent/mobileqq/app/BaseActivity
    //   419: new 92	java/lang/StringBuilder
    //   422: dup
    //   423: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   426: aload 5
    //   428: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   431: ldc -3
    //   433: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   436: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   439: iconst_0
    //   440: invokevirtual 257	com/tencent/mobileqq/app/BaseActivity:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   443: astore_3
    //   444: aload_0
    //   445: getfield 32	wfb:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   448: invokeinterface 261 1 0
    //   453: astore_2
    //   454: iconst_0
    //   455: istore 11
    //   457: iconst_0
    //   458: istore 10
    //   460: aload_2
    //   461: invokeinterface 266 1 0
    //   466: ifeq +256 -> 722
    //   469: aload_2
    //   470: invokeinterface 269 1 0
    //   475: checkcast 184	java/lang/String
    //   478: astore 9
    //   480: aload_3
    //   481: aload_0
    //   482: getfield 43	wfb:b	Ljava/lang/String;
    //   485: aconst_null
    //   486: invokeinterface 273 3 0
    //   491: astore 7
    //   493: aload 9
    //   495: ldc_w 275
    //   498: ldc_w 277
    //   501: invokevirtual 281	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   504: astore 4
    //   506: aload 7
    //   508: invokestatic 113	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   511: ifeq +13 -> 524
    //   514: ldc 90
    //   516: iconst_1
    //   517: ldc_w 283
    //   520: invokestatic 286	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   523: return
    //   524: aload 9
    //   526: iconst_0
    //   527: invokestatic 291	com/tencent/mobileqq/jsp/MediaApiPlugin:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   530: astore 8
    //   532: aload 8
    //   534: invokestatic 113	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   537: ifeq +88 -> 625
    //   540: ldc 90
    //   542: iconst_1
    //   543: new 92	java/lang/StringBuilder
    //   546: dup
    //   547: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   550: ldc_w 293
    //   553: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   556: aload 9
    //   558: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   561: ldc_w 295
    //   564: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   567: aload 9
    //   569: invokestatic 58	com/tencent/mobileqq/filemanager/util/FileUtil:a	(Ljava/lang/String;)Z
    //   572: invokevirtual 161	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   575: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   578: invokestatic 286	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   581: aload 7
    //   583: aload 4
    //   585: ldc_w 297
    //   588: invokevirtual 281	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   591: astore 4
    //   593: aload_3
    //   594: invokeinterface 301 1 0
    //   599: aload_0
    //   600: getfield 43	wfb:b	Ljava/lang/String;
    //   603: aload 4
    //   605: invokeinterface 306 3 0
    //   610: invokeinterface 309 1 0
    //   615: pop
    //   616: iload 10
    //   618: iconst_1
    //   619: iadd
    //   620: istore 10
    //   622: goto -162 -> 460
    //   625: new 60	java/util/HashMap
    //   628: dup
    //   629: invokespecial 61	java/util/HashMap:<init>	()V
    //   632: astore 9
    //   634: aload 9
    //   636: ldc_w 311
    //   639: aload_0
    //   640: getfield 41	wfb:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   643: invokevirtual 217	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   646: pop
    //   647: aload_0
    //   648: aload_1
    //   649: aload 8
    //   651: aload 5
    //   653: aload 6
    //   655: aload 9
    //   657: invokevirtual 313	wfb:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)Ljava/lang/String;
    //   660: astore 8
    //   662: aload 8
    //   664: ifnull +49 -> 713
    //   667: aload 7
    //   669: aload 4
    //   671: aload 8
    //   673: ldc_w 275
    //   676: ldc_w 277
    //   679: invokevirtual 281	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   682: invokevirtual 281	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   685: astore 4
    //   687: aload_3
    //   688: invokeinterface 301 1 0
    //   693: aload_0
    //   694: getfield 43	wfb:b	Ljava/lang/String;
    //   697: aload 4
    //   699: invokeinterface 306 3 0
    //   704: invokeinterface 309 1 0
    //   709: pop
    //   710: goto -250 -> 460
    //   713: iload 11
    //   715: iconst_1
    //   716: iadd
    //   717: istore 11
    //   719: goto -259 -> 460
    //   722: aconst_null
    //   723: astore_2
    //   724: aconst_null
    //   725: astore 4
    //   727: aload_2
    //   728: astore_1
    //   729: iload 10
    //   731: aload_0
    //   732: getfield 32	wfb:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   735: invokeinterface 316 1 0
    //   740: if_icmpne +119 -> 859
    //   743: aload_2
    //   744: astore_1
    //   745: new 115	org/json/JSONObject
    //   748: dup
    //   749: aload_3
    //   750: aload_0
    //   751: getfield 43	wfb:b	Ljava/lang/String;
    //   754: ldc_w 318
    //   757: invokeinterface 273 3 0
    //   762: invokespecial 118	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   765: astore 5
    //   767: aload_2
    //   768: astore_1
    //   769: aload 5
    //   771: ldc_w 320
    //   774: iconst_1
    //   775: invokevirtual 323	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   778: pop
    //   779: aload_2
    //   780: astore_1
    //   781: aload_3
    //   782: invokeinterface 301 1 0
    //   787: aload_0
    //   788: getfield 43	wfb:b	Ljava/lang/String;
    //   791: aload 5
    //   793: invokevirtual 324	org/json/JSONObject:toString	()Ljava/lang/String;
    //   796: invokeinterface 306 3 0
    //   801: invokeinterface 309 1 0
    //   806: pop
    //   807: aload_2
    //   808: astore_1
    //   809: ldc 90
    //   811: iconst_1
    //   812: ldc_w 326
    //   815: invokestatic 286	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   818: iconst_0
    //   819: ifeq +11 -> 830
    //   822: new 328	java/lang/NullPointerException
    //   825: dup
    //   826: invokespecial 329	java/lang/NullPointerException:<init>	()V
    //   829: athrow
    //   830: getstatic 242	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   833: aload_0
    //   834: getfield 43	wfb:b	Ljava/lang/String;
    //   837: invokeinterface 246 2 0
    //   842: ifeq -775 -> 67
    //   845: getstatic 242	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   848: aload_0
    //   849: getfield 43	wfb:b	Ljava/lang/String;
    //   852: invokeinterface 249 2 0
    //   857: pop
    //   858: return
    //   859: iload 11
    //   861: ifle +91 -> 952
    //   864: aload_2
    //   865: astore_1
    //   866: ldc 90
    //   868: iconst_1
    //   869: new 92	java/lang/StringBuilder
    //   872: dup
    //   873: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   876: ldc_w 331
    //   879: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   882: iload 11
    //   884: invokevirtual 198	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   887: ldc_w 333
    //   890: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   893: aload_0
    //   894: getfield 32	wfb:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   897: invokeinterface 316 1 0
    //   902: invokevirtual 198	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   905: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   908: invokestatic 286	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   911: iconst_0
    //   912: ifeq +11 -> 923
    //   915: new 328	java/lang/NullPointerException
    //   918: dup
    //   919: invokespecial 329	java/lang/NullPointerException:<init>	()V
    //   922: athrow
    //   923: getstatic 242	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   926: aload_0
    //   927: getfield 43	wfb:b	Ljava/lang/String;
    //   930: invokeinterface 246 2 0
    //   935: ifeq -868 -> 67
    //   938: getstatic 242	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   941: aload_0
    //   942: getfield 43	wfb:b	Ljava/lang/String;
    //   945: invokeinterface 249 2 0
    //   950: pop
    //   951: return
    //   952: aload_2
    //   953: astore_1
    //   954: aload_0
    //   955: getfield 17	wfb:jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin	Lcom/tencent/mobileqq/vashealth/HealthBusinessPlugin;
    //   958: getfield 202	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:b	Z
    //   961: ifeq +16 -> 977
    //   964: aload_2
    //   965: astore_1
    //   966: ldc_w 335
    //   969: ldc -52
    //   971: ldc -50
    //   973: invokevirtual 209	java/lang/String:replaceFirst	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   976: pop
    //   977: aload_2
    //   978: astore_1
    //   979: new 337	java/net/URL
    //   982: dup
    //   983: new 92	java/lang/StringBuilder
    //   986: dup
    //   987: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   990: ldc_w 335
    //   993: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   996: iload 12
    //   998: invokevirtual 198	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1001: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1004: invokespecial 338	java/net/URL:<init>	(Ljava/lang/String;)V
    //   1007: invokevirtual 342	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   1010: checkcast 344	java/net/HttpURLConnection
    //   1013: astore_2
    //   1014: aload_2
    //   1015: sipush 5000
    //   1018: invokevirtual 348	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   1021: aload_2
    //   1022: sipush 30000
    //   1025: invokevirtual 351	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   1028: aload_2
    //   1029: iconst_1
    //   1030: invokevirtual 355	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   1033: aload_2
    //   1034: iconst_1
    //   1035: invokevirtual 358	java/net/HttpURLConnection:setDoInput	(Z)V
    //   1038: aload_2
    //   1039: iconst_0
    //   1040: invokevirtual 361	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   1043: aload_2
    //   1044: ldc_w 363
    //   1047: invokevirtual 366	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   1050: aload_2
    //   1051: ldc 63
    //   1053: ldc_w 368
    //   1056: invokevirtual 371	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   1059: aload_2
    //   1060: ldc_w 373
    //   1063: new 92	java/lang/StringBuilder
    //   1066: dup
    //   1067: ldc_w 375
    //   1070: invokespecial 376	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1073: ldc_w 378
    //   1076: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1079: getstatic 383	android/os/Build$VERSION:SDK	Ljava/lang/String;
    //   1082: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1085: ldc_w 378
    //   1088: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1091: getstatic 388	android/os/Build:DEVICE	Ljava/lang/String;
    //   1094: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1097: ldc_w 378
    //   1100: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1103: getstatic 391	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   1106: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1109: ldc_w 378
    //   1112: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1115: ldc_w 393
    //   1118: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1121: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1124: invokevirtual 371	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   1127: aload_2
    //   1128: ldc_w 395
    //   1131: ldc_w 397
    //   1134: invokevirtual 371	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   1137: aload_2
    //   1138: ldc_w 399
    //   1141: new 92	java/lang/StringBuilder
    //   1144: dup
    //   1145: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   1148: ldc_w 401
    //   1151: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1154: aload 5
    //   1156: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1159: ldc_w 403
    //   1162: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1165: aload 6
    //   1167: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1170: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1173: invokevirtual 371	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   1176: new 405	java/io/DataOutputStream
    //   1179: dup
    //   1180: aload_2
    //   1181: invokevirtual 409	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   1184: invokespecial 412	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   1187: astore 4
    //   1189: new 414	java/lang/StringBuffer
    //   1192: dup
    //   1193: invokespecial 415	java/lang/StringBuffer:<init>	()V
    //   1196: astore_1
    //   1197: aload_1
    //   1198: ldc_w 417
    //   1201: invokevirtual 420	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1204: pop
    //   1205: aload_1
    //   1206: aload_0
    //   1207: getfield 41	wfb:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1210: invokevirtual 420	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1213: pop
    //   1214: aload 4
    //   1216: aload_1
    //   1217: invokevirtual 421	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   1220: invokevirtual 425	java/lang/String:getBytes	()[B
    //   1223: invokevirtual 431	java/io/OutputStream:write	([B)V
    //   1226: aload 4
    //   1228: invokevirtual 434	java/io/OutputStream:flush	()V
    //   1231: aload 4
    //   1233: invokevirtual 437	java/io/OutputStream:close	()V
    //   1236: new 414	java/lang/StringBuffer
    //   1239: dup
    //   1240: invokespecial 415	java/lang/StringBuffer:<init>	()V
    //   1243: astore 4
    //   1245: new 439	java/io/BufferedReader
    //   1248: dup
    //   1249: new 441	java/io/InputStreamReader
    //   1252: dup
    //   1253: aload_2
    //   1254: invokevirtual 445	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   1257: invokespecial 448	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   1260: invokespecial 451	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   1263: astore_1
    //   1264: aload_1
    //   1265: invokevirtual 454	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   1268: astore 5
    //   1270: aload 5
    //   1272: ifnull +86 -> 1358
    //   1275: aload 4
    //   1277: aload 5
    //   1279: invokevirtual 420	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1282: ldc_w 456
    //   1285: invokevirtual 420	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1288: pop
    //   1289: goto -25 -> 1264
    //   1292: astore_3
    //   1293: aload_2
    //   1294: astore_1
    //   1295: ldc 90
    //   1297: iconst_2
    //   1298: new 92	java/lang/StringBuilder
    //   1301: dup
    //   1302: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   1305: ldc_w 458
    //   1308: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1311: aload_3
    //   1312: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1315: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1318: invokestatic 163	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1321: aload_2
    //   1322: ifnull +7 -> 1329
    //   1325: aload_2
    //   1326: invokevirtual 461	java/net/HttpURLConnection:disconnect	()V
    //   1329: getstatic 242	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   1332: aload_0
    //   1333: getfield 43	wfb:b	Ljava/lang/String;
    //   1336: invokeinterface 246 2 0
    //   1341: ifeq -1274 -> 67
    //   1344: getstatic 242	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   1347: aload_0
    //   1348: getfield 43	wfb:b	Ljava/lang/String;
    //   1351: invokeinterface 249 2 0
    //   1356: pop
    //   1357: return
    //   1358: aload 4
    //   1360: invokevirtual 421	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   1363: astore 4
    //   1365: aload 4
    //   1367: invokestatic 113	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1370: ifeq +12 -> 1382
    //   1373: ldc 90
    //   1375: iconst_1
    //   1376: ldc_w 463
    //   1379: invokestatic 286	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1382: new 115	org/json/JSONObject
    //   1385: dup
    //   1386: aload 4
    //   1388: invokespecial 118	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1391: ldc 120
    //   1393: invokevirtual 124	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   1396: ifne +142 -> 1538
    //   1399: new 115	org/json/JSONObject
    //   1402: dup
    //   1403: aload_3
    //   1404: aload_0
    //   1405: getfield 43	wfb:b	Ljava/lang/String;
    //   1408: ldc_w 318
    //   1411: invokeinterface 273 3 0
    //   1416: invokespecial 118	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1419: astore 5
    //   1421: aload 5
    //   1423: ldc_w 320
    //   1426: iconst_0
    //   1427: invokevirtual 323	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1430: pop
    //   1431: aload_3
    //   1432: invokeinterface 301 1 0
    //   1437: aload_0
    //   1438: getfield 43	wfb:b	Ljava/lang/String;
    //   1441: aload 5
    //   1443: invokevirtual 324	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1446: invokeinterface 306 3 0
    //   1451: invokeinterface 309 1 0
    //   1456: pop
    //   1457: ldc 90
    //   1459: iconst_1
    //   1460: new 92	java/lang/StringBuilder
    //   1463: dup
    //   1464: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   1467: ldc_w 465
    //   1470: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1473: aload_0
    //   1474: getfield 41	wfb:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1477: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1480: ldc_w 467
    //   1483: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1486: aload 4
    //   1488: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1491: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1494: invokestatic 107	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1497: aload_1
    //   1498: invokevirtual 468	java/io/BufferedReader:close	()V
    //   1501: aload_2
    //   1502: ifnull +7 -> 1509
    //   1505: aload_2
    //   1506: invokevirtual 461	java/net/HttpURLConnection:disconnect	()V
    //   1509: getstatic 242	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   1512: aload_0
    //   1513: getfield 43	wfb:b	Ljava/lang/String;
    //   1516: invokeinterface 246 2 0
    //   1521: ifeq -1454 -> 67
    //   1524: getstatic 242	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   1527: aload_0
    //   1528: getfield 43	wfb:b	Ljava/lang/String;
    //   1531: invokeinterface 249 2 0
    //   1536: pop
    //   1537: return
    //   1538: new 115	org/json/JSONObject
    //   1541: dup
    //   1542: aload_3
    //   1543: aload_0
    //   1544: getfield 43	wfb:b	Ljava/lang/String;
    //   1547: ldc_w 318
    //   1550: invokeinterface 273 3 0
    //   1555: invokespecial 118	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1558: astore 5
    //   1560: aload 5
    //   1562: ldc_w 320
    //   1565: iconst_2
    //   1566: invokevirtual 323	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1569: pop
    //   1570: aload_3
    //   1571: invokeinterface 301 1 0
    //   1576: aload_0
    //   1577: getfield 43	wfb:b	Ljava/lang/String;
    //   1580: aload 5
    //   1582: invokevirtual 324	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1585: invokeinterface 306 3 0
    //   1590: invokeinterface 309 1 0
    //   1595: pop
    //   1596: ldc 90
    //   1598: iconst_1
    //   1599: new 92	java/lang/StringBuilder
    //   1602: dup
    //   1603: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   1606: ldc_w 470
    //   1609: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1612: aload_0
    //   1613: getfield 41	wfb:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1616: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1619: ldc_w 467
    //   1622: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1625: aload 4
    //   1627: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1630: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1633: invokestatic 286	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1636: goto -139 -> 1497
    //   1639: astore_3
    //   1640: aload_2
    //   1641: astore_1
    //   1642: aload_3
    //   1643: astore_2
    //   1644: aload_1
    //   1645: ifnull +7 -> 1652
    //   1648: aload_1
    //   1649: invokevirtual 461	java/net/HttpURLConnection:disconnect	()V
    //   1652: getstatic 242	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   1655: aload_0
    //   1656: getfield 43	wfb:b	Ljava/lang/String;
    //   1659: invokeinterface 246 2 0
    //   1664: ifeq +16 -> 1680
    //   1667: getstatic 242	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   1670: aload_0
    //   1671: getfield 43	wfb:b	Ljava/lang/String;
    //   1674: invokeinterface 249 2 0
    //   1679: pop
    //   1680: aload_2
    //   1681: athrow
    //   1682: astore_2
    //   1683: goto -39 -> 1644
    //   1686: astore_3
    //   1687: aload 4
    //   1689: astore_2
    //   1690: goto -397 -> 1293
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1693	0	this	wfb
    //   8	1641	1	localObject1	Object
    //   271	1410	2	localObject2	Object
    //   1682	1	2	localObject3	Object
    //   1689	1	2	localObject4	Object
    //   256	526	3	localObject5	Object
    //   1292	279	3	localException1	Exception
    //   1639	4	3	localObject6	Object
    //   1686	1	3	localException2	Exception
    //   290	1398	4	localObject7	Object
    //   89	1492	5	localObject8	Object
    //   109	1057	6	str1	String
    //   491	177	7	str2	String
    //   530	142	8	str3	String
    //   478	178	9	localObject9	Object
    //   140	601	10	i	int
    //   137	746	11	j	int
    //   147	850	12	k	int
    // Exception table:
    //   from	to	target	type
    //   1014	1264	1292	java/lang/Exception
    //   1264	1270	1292	java/lang/Exception
    //   1275	1289	1292	java/lang/Exception
    //   1358	1382	1292	java/lang/Exception
    //   1382	1497	1292	java/lang/Exception
    //   1497	1501	1292	java/lang/Exception
    //   1538	1636	1292	java/lang/Exception
    //   1014	1264	1639	finally
    //   1264	1270	1639	finally
    //   1275	1289	1639	finally
    //   1358	1382	1639	finally
    //   1382	1497	1639	finally
    //   1497	1501	1639	finally
    //   1538	1636	1639	finally
    //   729	743	1682	finally
    //   745	767	1682	finally
    //   769	779	1682	finally
    //   781	807	1682	finally
    //   809	818	1682	finally
    //   866	911	1682	finally
    //   954	964	1682	finally
    //   966	977	1682	finally
    //   979	1014	1682	finally
    //   1295	1321	1682	finally
    //   729	743	1686	java/lang/Exception
    //   745	767	1686	java/lang/Exception
    //   769	779	1686	java/lang/Exception
    //   781	807	1686	java/lang/Exception
    //   809	818	1686	java/lang/Exception
    //   866	911	1686	java/lang/Exception
    //   954	964	1686	java/lang/Exception
    //   966	977	1686	java/lang/Exception
    //   979	1014	1686	java/lang/Exception
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wfb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
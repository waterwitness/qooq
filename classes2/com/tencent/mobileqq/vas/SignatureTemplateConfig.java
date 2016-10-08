package com.tencent.mobileqq.vas;

import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.File;

public class SignatureTemplateConfig
{
  public static final int a = 16;
  public static final String a = "vipSignature_common_data";
  public static final int b = 17;
  public static final String b = "vipSignature_item";
  public static final int c = 18;
  public static final int d = 19;
  
  public SignatureTemplateConfig()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static String a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder(AppConstants.ca);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramString1);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramString2);
    return localStringBuilder.toString();
  }
  
  /* Error */
  public static SignatureTemplateConfig.SignatureTemplateType[] a(com.tencent.mobileqq.app.QQAppInterface paramQQAppInterface)
  {
    // Byte code:
    //   0: new 66	java/util/LinkedHashMap
    //   3: dup
    //   4: invokespecial 67	java/util/LinkedHashMap:<init>	()V
    //   7: astore_3
    //   8: new 48	java/io/File
    //   11: dup
    //   12: getstatic 72	com/tencent/mobileqq/app/SignatureManager:g	Ljava/lang/String;
    //   15: invokespecial 73	java/io/File:<init>	(Ljava/lang/String;)V
    //   18: astore_0
    //   19: aload_0
    //   20: invokestatic 78	com/tencent/mobileqq/utils/FileUtils:b	(Ljava/io/File;)Ljava/lang/String;
    //   23: astore_0
    //   24: new 80	org/json/JSONObject
    //   27: dup
    //   28: aload_0
    //   29: aload_0
    //   30: ldc 82
    //   32: invokevirtual 88	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   35: aload_0
    //   36: invokevirtual 92	java/lang/String:length	()I
    //   39: invokevirtual 96	java/lang/String:subSequence	(II)Ljava/lang/CharSequence;
    //   42: checkcast 84	java/lang/String
    //   45: invokespecial 97	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   48: ldc 99
    //   50: invokevirtual 103	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   53: astore_0
    //   54: aload_0
    //   55: ldc 105
    //   57: invokevirtual 109	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   60: astore 4
    //   62: iconst_0
    //   63: istore 12
    //   65: iload 12
    //   67: aload 4
    //   69: invokevirtual 112	org/json/JSONArray:length	()I
    //   72: if_icmpge +90 -> 162
    //   75: aload 4
    //   77: iload 12
    //   79: invokevirtual 115	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   82: astore 5
    //   84: new 117	com/tencent/mobileqq/vas/SignatureTemplateConfig$SignatureTemplateType
    //   87: dup
    //   88: invokespecial 118	com/tencent/mobileqq/vas/SignatureTemplateConfig$SignatureTemplateType:<init>	()V
    //   91: astore 6
    //   93: aload 6
    //   95: aload 5
    //   97: ldc 120
    //   99: invokevirtual 123	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   102: putfield 125	com/tencent/mobileqq/vas/SignatureTemplateConfig$SignatureTemplateType:jdField_a_of_type_Int	I
    //   105: aload 6
    //   107: aload 5
    //   109: ldc 127
    //   111: invokevirtual 131	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   114: putfield 133	com/tencent/mobileqq/vas/SignatureTemplateConfig$SignatureTemplateType:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   117: aload_3
    //   118: aload 6
    //   120: getfield 125	com/tencent/mobileqq/vas/SignatureTemplateConfig$SignatureTemplateType:jdField_a_of_type_Int	I
    //   123: invokestatic 139	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   126: aload 6
    //   128: invokeinterface 145 3 0
    //   133: pop
    //   134: iload 12
    //   136: iconst_1
    //   137: iadd
    //   138: istore 12
    //   140: goto -75 -> 65
    //   143: astore_0
    //   144: invokestatic 151	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   147: ifeq +1478 -> 1625
    //   150: ldc -103
    //   152: iconst_2
    //   153: ldc -101
    //   155: aload_0
    //   156: invokestatic 159	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   159: goto +1466 -> 1625
    //   162: aload_0
    //   163: ldc -95
    //   165: invokevirtual 103	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   168: astore 4
    //   170: aload 4
    //   172: invokevirtual 165	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   175: astore 5
    //   177: aload 5
    //   179: invokeinterface 170 1 0
    //   184: ifeq +1355 -> 1539
    //   187: aload 4
    //   189: aload 5
    //   191: invokeinterface 174 1 0
    //   196: checkcast 84	java/lang/String
    //   199: invokevirtual 109	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   202: astore 6
    //   204: iconst_0
    //   205: istore 13
    //   207: iload 13
    //   209: aload 6
    //   211: invokevirtual 112	org/json/JSONArray:length	()I
    //   214: if_icmpge -37 -> 177
    //   217: aload 6
    //   219: iload 13
    //   221: invokevirtual 115	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   224: astore 8
    //   226: new 176	com/tencent/mobileqq/vas/SignatureTemplateInfo
    //   229: dup
    //   230: aload 8
    //   232: ldc -78
    //   234: invokevirtual 131	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   237: invokespecial 179	com/tencent/mobileqq/vas/SignatureTemplateInfo:<init>	(Ljava/lang/String;)V
    //   240: astore 7
    //   242: aload 8
    //   244: ldc 99
    //   246: invokevirtual 109	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   249: astore 9
    //   251: iconst_0
    //   252: istore 12
    //   254: iload 12
    //   256: aload 9
    //   258: invokevirtual 112	org/json/JSONArray:length	()I
    //   261: if_icmpge +718 -> 979
    //   264: aload 9
    //   266: iload 12
    //   268: invokevirtual 115	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   271: astore 10
    //   273: aload 10
    //   275: ldc -75
    //   277: invokevirtual 123	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   280: iconst_1
    //   281: if_icmpne +6 -> 287
    //   284: goto +1343 -> 1627
    //   287: aload 7
    //   289: aload 10
    //   291: ldc -73
    //   293: invokevirtual 131	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   296: putfield 186	com/tencent/mobileqq/vas/SignatureTemplateInfo:f	Ljava/lang/String;
    //   299: aload 7
    //   301: getfield 186	com/tencent/mobileqq/vas/SignatureTemplateInfo:f	Ljava/lang/String;
    //   304: ldc -68
    //   306: invokevirtual 191	java/lang/String:compareTo	(Ljava/lang/String;)I
    //   309: ifgt +1318 -> 1627
    //   312: aload 10
    //   314: ldc -63
    //   316: invokevirtual 197	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   319: ifeq +617 -> 936
    //   322: aload 10
    //   324: ldc -63
    //   326: invokevirtual 131	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   329: astore_0
    //   330: aload 7
    //   332: aload_0
    //   333: putfield 199	com/tencent/mobileqq/vas/SignatureTemplateInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   336: aload 10
    //   338: ldc -55
    //   340: invokevirtual 197	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   343: ifeq +1293 -> 1636
    //   346: aload 10
    //   348: ldc -55
    //   350: invokevirtual 123	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   353: istore 14
    //   355: aload 7
    //   357: iload 14
    //   359: putfield 203	com/tencent/mobileqq/vas/SignatureTemplateInfo:jdField_b_of_type_Int	I
    //   362: aload 10
    //   364: ldc -51
    //   366: invokevirtual 197	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   369: ifeq +1273 -> 1642
    //   372: aload 10
    //   374: ldc -51
    //   376: invokevirtual 123	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   379: istore 14
    //   381: aload 7
    //   383: iload 14
    //   385: putfield 206	com/tencent/mobileqq/vas/SignatureTemplateInfo:jdField_a_of_type_Int	I
    //   388: aload 10
    //   390: ldc -48
    //   392: invokevirtual 197	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   395: ifeq +1253 -> 1648
    //   398: aload 10
    //   400: ldc -48
    //   402: invokevirtual 131	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   405: astore_0
    //   406: aload 7
    //   408: aload_0
    //   409: putfield 210	com/tencent/mobileqq/vas/SignatureTemplateInfo:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   412: aload 10
    //   414: ldc -44
    //   416: invokevirtual 197	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   419: ifeq +1234 -> 1653
    //   422: aload 10
    //   424: ldc -44
    //   426: invokevirtual 123	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   429: istore 14
    //   431: aload 7
    //   433: iload 14
    //   435: putfield 214	com/tencent/mobileqq/vas/SignatureTemplateInfo:jdField_c_of_type_Int	I
    //   438: aload 7
    //   440: aload 10
    //   442: ldc -75
    //   444: invokevirtual 123	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   447: putfield 216	com/tencent/mobileqq/vas/SignatureTemplateInfo:jdField_d_of_type_Int	I
    //   450: aload 10
    //   452: ldc -38
    //   454: invokevirtual 197	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   457: ifeq +1202 -> 1659
    //   460: aload 10
    //   462: ldc -38
    //   464: invokevirtual 131	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   467: astore_0
    //   468: aload 7
    //   470: aload_0
    //   471: putfield 220	com/tencent/mobileqq/vas/SignatureTemplateInfo:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   474: aload 7
    //   476: getfield 220	com/tencent/mobileqq/vas/SignatureTemplateInfo:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   479: invokestatic 225	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   482: pop
    //   483: aload 10
    //   485: ldc -29
    //   487: invokevirtual 197	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   490: ifeq +1176 -> 1666
    //   493: aload 10
    //   495: ldc -29
    //   497: invokevirtual 131	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   500: astore_0
    //   501: aload 7
    //   503: aload_0
    //   504: putfield 230	com/tencent/mobileqq/vas/SignatureTemplateInfo:n	Ljava/lang/String;
    //   507: aload 10
    //   509: ldc -24
    //   511: invokevirtual 197	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   514: ifeq +1159 -> 1673
    //   517: aload 10
    //   519: ldc -24
    //   521: invokevirtual 131	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   524: astore_0
    //   525: aload 7
    //   527: aload_0
    //   528: putfield 235	com/tencent/mobileqq/vas/SignatureTemplateInfo:o	Ljava/lang/String;
    //   531: aload 7
    //   533: getfield 235	com/tencent/mobileqq/vas/SignatureTemplateInfo:o	Ljava/lang/String;
    //   536: invokestatic 225	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   539: pop
    //   540: aload 10
    //   542: ldc -19
    //   544: invokevirtual 197	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   547: ifeq +1133 -> 1680
    //   550: aload 10
    //   552: ldc -19
    //   554: invokevirtual 131	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   557: astore_0
    //   558: aload 7
    //   560: aload_0
    //   561: putfield 240	com/tencent/mobileqq/vas/SignatureTemplateInfo:p	Ljava/lang/String;
    //   564: aload 7
    //   566: getfield 240	com/tencent/mobileqq/vas/SignatureTemplateInfo:p	Ljava/lang/String;
    //   569: invokestatic 225	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   572: pop
    //   573: aload 10
    //   575: ldc -14
    //   577: invokevirtual 197	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   580: ifeq +1107 -> 1687
    //   583: aload 10
    //   585: ldc -14
    //   587: invokevirtual 123	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   590: istore 14
    //   592: aload 7
    //   594: iload 14
    //   596: putfield 244	com/tencent/mobileqq/vas/SignatureTemplateInfo:jdField_e_of_type_Int	I
    //   599: aload 10
    //   601: ldc -10
    //   603: invokevirtual 197	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   606: ifeq +1087 -> 1693
    //   609: aload 10
    //   611: ldc -10
    //   613: invokevirtual 131	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   616: astore_0
    //   617: aload 7
    //   619: aload_0
    //   620: putfield 249	com/tencent/mobileqq/vas/SignatureTemplateInfo:q	Ljava/lang/String;
    //   623: aload 10
    //   625: ldc -5
    //   627: invokevirtual 197	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   630: ifeq +1070 -> 1700
    //   633: aload 10
    //   635: ldc -5
    //   637: invokevirtual 131	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   640: astore_0
    //   641: aload 7
    //   643: aload_0
    //   644: putfield 254	com/tencent/mobileqq/vas/SignatureTemplateInfo:r	Ljava/lang/String;
    //   647: aload 10
    //   649: ldc_w 256
    //   652: invokevirtual 197	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   655: ifeq +1052 -> 1707
    //   658: aload 10
    //   660: ldc_w 256
    //   663: invokevirtual 131	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   666: astore_0
    //   667: aload 7
    //   669: aload_0
    //   670: putfield 259	com/tencent/mobileqq/vas/SignatureTemplateInfo:s	Ljava/lang/String;
    //   673: aload 10
    //   675: ldc_w 261
    //   678: invokevirtual 197	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   681: ifeq +16 -> 697
    //   684: aload 7
    //   686: aload 10
    //   688: ldc_w 261
    //   691: invokevirtual 131	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   694: putfield 263	com/tencent/mobileqq/vas/SignatureTemplateInfo:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   697: aload 10
    //   699: ldc_w 265
    //   702: invokevirtual 197	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   705: ifeq +16 -> 721
    //   708: aload 7
    //   710: aload 10
    //   712: ldc_w 265
    //   715: invokevirtual 131	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   718: putfield 266	com/tencent/mobileqq/vas/SignatureTemplateInfo:g	Ljava/lang/String;
    //   721: aload 10
    //   723: ldc_w 268
    //   726: invokevirtual 197	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   729: ifeq +16 -> 745
    //   732: aload 7
    //   734: aload 10
    //   736: ldc_w 268
    //   739: invokevirtual 131	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   742: putfield 271	com/tencent/mobileqq/vas/SignatureTemplateInfo:h	Ljava/lang/String;
    //   745: aload 10
    //   747: ldc_w 273
    //   750: invokevirtual 197	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   753: ifeq +16 -> 769
    //   756: aload 7
    //   758: aload 10
    //   760: ldc_w 273
    //   763: invokevirtual 131	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   766: putfield 276	com/tencent/mobileqq/vas/SignatureTemplateInfo:i	Ljava/lang/String;
    //   769: aload 10
    //   771: ldc_w 278
    //   774: invokevirtual 197	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   777: ifeq +16 -> 793
    //   780: aload 7
    //   782: aload 10
    //   784: ldc_w 278
    //   787: invokevirtual 131	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   790: putfield 281	com/tencent/mobileqq/vas/SignatureTemplateInfo:j	Ljava/lang/String;
    //   793: aload 10
    //   795: ldc_w 283
    //   798: invokevirtual 197	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   801: ifeq +16 -> 817
    //   804: aload 7
    //   806: aload 10
    //   808: ldc_w 283
    //   811: invokevirtual 131	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   814: putfield 286	com/tencent/mobileqq/vas/SignatureTemplateInfo:k	Ljava/lang/String;
    //   817: aload 10
    //   819: ldc_w 288
    //   822: invokevirtual 197	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   825: ifeq +16 -> 841
    //   828: aload 7
    //   830: aload 10
    //   832: ldc_w 288
    //   835: invokevirtual 131	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   838: putfield 291	com/tencent/mobileqq/vas/SignatureTemplateInfo:l	Ljava/lang/String;
    //   841: aload 10
    //   843: ldc_w 293
    //   846: invokevirtual 197	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   849: ifeq +778 -> 1627
    //   852: aload 7
    //   854: aload 10
    //   856: ldc_w 293
    //   859: invokevirtual 131	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   862: putfield 296	com/tencent/mobileqq/vas/SignatureTemplateInfo:m	Ljava/lang/String;
    //   865: goto +762 -> 1627
    //   868: astore_0
    //   869: new 48	java/io/File
    //   872: dup
    //   873: getstatic 72	com/tencent/mobileqq/app/SignatureManager:g	Ljava/lang/String;
    //   876: invokespecial 73	java/io/File:<init>	(Ljava/lang/String;)V
    //   879: astore_3
    //   880: aload_3
    //   881: invokevirtual 299	java/io/File:exists	()Z
    //   884: ifeq +15 -> 899
    //   887: aload_3
    //   888: invokevirtual 302	java/io/File:isFile	()Z
    //   891: ifeq +8 -> 899
    //   894: aload_3
    //   895: invokevirtual 305	java/io/File:delete	()Z
    //   898: pop
    //   899: invokestatic 151	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   902: ifeq +32 -> 934
    //   905: ldc -103
    //   907: iconst_2
    //   908: new 38	java/lang/StringBuilder
    //   911: dup
    //   912: invokespecial 306	java/lang/StringBuilder:<init>	()V
    //   915: ldc_w 308
    //   918: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   921: aload_0
    //   922: invokevirtual 311	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   925: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   928: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   931: invokestatic 314	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   934: aconst_null
    //   935: areturn
    //   936: ldc_w 316
    //   939: astore_0
    //   940: goto -610 -> 330
    //   943: astore_0
    //   944: aload 7
    //   946: ldc_w 318
    //   949: putfield 220	com/tencent/mobileqq/vas/SignatureTemplateInfo:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   952: goto -469 -> 483
    //   955: astore_0
    //   956: aload 7
    //   958: ldc_w 318
    //   961: putfield 235	com/tencent/mobileqq/vas/SignatureTemplateInfo:o	Ljava/lang/String;
    //   964: goto -424 -> 540
    //   967: astore_0
    //   968: aload 7
    //   970: ldc_w 318
    //   973: putfield 240	com/tencent/mobileqq/vas/SignatureTemplateInfo:p	Ljava/lang/String;
    //   976: goto -403 -> 573
    //   979: aload 8
    //   981: ldc_w 320
    //   984: invokevirtual 197	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   987: ifeq +407 -> 1394
    //   990: aload 8
    //   992: ldc_w 320
    //   995: invokevirtual 109	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   998: astore 9
    //   1000: iconst_0
    //   1001: istore 14
    //   1003: iload 14
    //   1005: aload 9
    //   1007: invokevirtual 112	org/json/JSONArray:length	()I
    //   1010: if_icmpge +384 -> 1394
    //   1013: aload 9
    //   1015: iload 14
    //   1017: invokevirtual 115	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   1020: astore 10
    //   1022: aload 10
    //   1024: ldc_w 322
    //   1027: invokevirtual 197	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1030: ifeq +714 -> 1744
    //   1033: aload 10
    //   1035: ldc_w 322
    //   1038: invokevirtual 123	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   1041: istore 12
    //   1043: goto +671 -> 1714
    //   1046: aload 7
    //   1048: getfield 325	com/tencent/mobileqq/vas/SignatureTemplateInfo:jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateInfo$DynamicItem	[Lcom/tencent/mobileqq/vas/SignatureTemplateInfo$DynamicItem;
    //   1051: astore_0
    //   1052: iload 12
    //   1054: ifne +696 -> 1750
    //   1057: iload 12
    //   1059: istore 15
    //   1061: aload_0
    //   1062: iload 15
    //   1064: aaload
    //   1065: iload 12
    //   1067: putfield 328	com/tencent/mobileqq/vas/SignatureTemplateInfo$DynamicItem:jdField_a_of_type_Int	I
    //   1070: aload 7
    //   1072: getfield 325	com/tencent/mobileqq/vas/SignatureTemplateInfo:jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateInfo$DynamicItem	[Lcom/tencent/mobileqq/vas/SignatureTemplateInfo$DynamicItem;
    //   1075: astore_0
    //   1076: iload 12
    //   1078: ifne +681 -> 1759
    //   1081: iload 12
    //   1083: istore 15
    //   1085: aload_0
    //   1086: iload 15
    //   1088: aaload
    //   1089: astore 11
    //   1091: aload 10
    //   1093: ldc_w 330
    //   1096: invokevirtual 197	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1099: ifeq +669 -> 1768
    //   1102: aload 10
    //   1104: ldc_w 330
    //   1107: invokevirtual 131	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1110: astore_0
    //   1111: aload 11
    //   1113: aload_0
    //   1114: putfield 331	com/tencent/mobileqq/vas/SignatureTemplateInfo$DynamicItem:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1117: aload 7
    //   1119: getfield 325	com/tencent/mobileqq/vas/SignatureTemplateInfo:jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateInfo$DynamicItem	[Lcom/tencent/mobileqq/vas/SignatureTemplateInfo$DynamicItem;
    //   1122: astore_0
    //   1123: iload 12
    //   1125: ifne +650 -> 1775
    //   1128: iload 12
    //   1130: istore 15
    //   1132: aload_0
    //   1133: iload 15
    //   1135: aaload
    //   1136: astore_0
    //   1137: aload 10
    //   1139: ldc_w 333
    //   1142: invokevirtual 197	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1145: ifeq +639 -> 1784
    //   1148: aload 10
    //   1150: ldc_w 333
    //   1153: invokevirtual 337	org/json/JSONObject:getDouble	(Ljava/lang/String;)D
    //   1156: dstore_1
    //   1157: aload_0
    //   1158: dload_1
    //   1159: d2f
    //   1160: putfield 340	com/tencent/mobileqq/vas/SignatureTemplateInfo$DynamicItem:jdField_a_of_type_Float	F
    //   1163: aload 7
    //   1165: getfield 325	com/tencent/mobileqq/vas/SignatureTemplateInfo:jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateInfo$DynamicItem	[Lcom/tencent/mobileqq/vas/SignatureTemplateInfo$DynamicItem;
    //   1168: astore_0
    //   1169: iload 12
    //   1171: ifne +618 -> 1789
    //   1174: iload 12
    //   1176: istore 15
    //   1178: aload_0
    //   1179: iload 15
    //   1181: aaload
    //   1182: astore_0
    //   1183: aload 10
    //   1185: ldc_w 342
    //   1188: invokevirtual 197	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1191: ifeq +607 -> 1798
    //   1194: aload 10
    //   1196: ldc_w 342
    //   1199: invokevirtual 337	org/json/JSONObject:getDouble	(Ljava/lang/String;)D
    //   1202: dstore_1
    //   1203: aload_0
    //   1204: dload_1
    //   1205: d2f
    //   1206: putfield 344	com/tencent/mobileqq/vas/SignatureTemplateInfo$DynamicItem:jdField_b_of_type_Float	F
    //   1209: aload 7
    //   1211: getfield 325	com/tencent/mobileqq/vas/SignatureTemplateInfo:jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateInfo$DynamicItem	[Lcom/tencent/mobileqq/vas/SignatureTemplateInfo$DynamicItem;
    //   1214: astore_0
    //   1215: iload 12
    //   1217: ifne +586 -> 1803
    //   1220: iload 12
    //   1222: istore 15
    //   1224: aload_0
    //   1225: iload 15
    //   1227: aaload
    //   1228: astore_0
    //   1229: aload 10
    //   1231: ldc_w 346
    //   1234: invokevirtual 197	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1237: ifeq +575 -> 1812
    //   1240: aload 10
    //   1242: ldc_w 346
    //   1245: invokevirtual 337	org/json/JSONObject:getDouble	(Ljava/lang/String;)D
    //   1248: dstore_1
    //   1249: aload_0
    //   1250: dload_1
    //   1251: d2f
    //   1252: putfield 348	com/tencent/mobileqq/vas/SignatureTemplateInfo$DynamicItem:jdField_c_of_type_Float	F
    //   1255: aload 7
    //   1257: getfield 325	com/tencent/mobileqq/vas/SignatureTemplateInfo:jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateInfo$DynamicItem	[Lcom/tencent/mobileqq/vas/SignatureTemplateInfo$DynamicItem;
    //   1260: astore_0
    //   1261: iload 12
    //   1263: ifne +554 -> 1817
    //   1266: iload 12
    //   1268: istore 15
    //   1270: aload_0
    //   1271: iload 15
    //   1273: aaload
    //   1274: astore_0
    //   1275: aload 10
    //   1277: ldc_w 350
    //   1280: invokevirtual 197	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1283: ifeq +543 -> 1826
    //   1286: aload 10
    //   1288: ldc_w 350
    //   1291: invokevirtual 337	org/json/JSONObject:getDouble	(Ljava/lang/String;)D
    //   1294: dstore_1
    //   1295: aload_0
    //   1296: dload_1
    //   1297: d2f
    //   1298: putfield 352	com/tencent/mobileqq/vas/SignatureTemplateInfo$DynamicItem:d	F
    //   1301: aload 7
    //   1303: getfield 325	com/tencent/mobileqq/vas/SignatureTemplateInfo:jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateInfo$DynamicItem	[Lcom/tencent/mobileqq/vas/SignatureTemplateInfo$DynamicItem;
    //   1306: astore_0
    //   1307: iload 12
    //   1309: ifne +522 -> 1831
    //   1312: iload 12
    //   1314: istore 15
    //   1316: aload_0
    //   1317: iload 15
    //   1319: aaload
    //   1320: astore_0
    //   1321: aload 10
    //   1323: ldc_w 354
    //   1326: invokevirtual 197	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1329: ifeq +511 -> 1840
    //   1332: aload 10
    //   1334: ldc_w 354
    //   1337: invokevirtual 123	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   1340: istore 15
    //   1342: aload_0
    //   1343: iload 15
    //   1345: putfield 355	com/tencent/mobileqq/vas/SignatureTemplateInfo$DynamicItem:jdField_b_of_type_Int	I
    //   1348: aload 7
    //   1350: getfield 325	com/tencent/mobileqq/vas/SignatureTemplateInfo:jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateInfo$DynamicItem	[Lcom/tencent/mobileqq/vas/SignatureTemplateInfo$DynamicItem;
    //   1353: astore_0
    //   1354: iload 12
    //   1356: ifne +490 -> 1846
    //   1359: aload_0
    //   1360: iload 12
    //   1362: aaload
    //   1363: astore_0
    //   1364: aload 10
    //   1366: ldc_w 357
    //   1369: invokevirtual 197	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1372: ifeq +483 -> 1855
    //   1375: aload 10
    //   1377: ldc_w 357
    //   1380: invokevirtual 123	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   1383: istore 12
    //   1385: aload_0
    //   1386: iload 12
    //   1388: putfield 358	com/tencent/mobileqq/vas/SignatureTemplateInfo$DynamicItem:jdField_c_of_type_Int	I
    //   1391: goto +344 -> 1735
    //   1394: aload 8
    //   1396: ldc_w 360
    //   1399: invokevirtual 363	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   1402: astore_0
    //   1403: aload_0
    //   1404: ifnull +100 -> 1504
    //   1407: aload_0
    //   1408: invokevirtual 112	org/json/JSONArray:length	()I
    //   1411: ifle +93 -> 1504
    //   1414: aload_0
    //   1415: iconst_0
    //   1416: invokevirtual 115	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   1419: astore_0
    //   1420: aload 7
    //   1422: invokevirtual 367	java/lang/Object:getClass	()Ljava/lang/Class;
    //   1425: pop
    //   1426: new 369	com/tencent/mobileqq/vas/SignatureTemplateInfo$ImageItem
    //   1429: dup
    //   1430: aload 7
    //   1432: invokespecial 372	com/tencent/mobileqq/vas/SignatureTemplateInfo$ImageItem:<init>	(Lcom/tencent/mobileqq/vas/SignatureTemplateInfo;)V
    //   1435: astore 8
    //   1437: aload 8
    //   1439: aload_0
    //   1440: ldc_w 374
    //   1443: invokevirtual 377	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1446: putfield 378	com/tencent/mobileqq/vas/SignatureTemplateInfo$ImageItem:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1449: aload 8
    //   1451: aload_0
    //   1452: ldc_w 380
    //   1455: invokevirtual 377	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1458: putfield 381	com/tencent/mobileqq/vas/SignatureTemplateInfo$ImageItem:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1461: aload 8
    //   1463: aload_0
    //   1464: ldc_w 383
    //   1467: invokevirtual 386	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   1470: putfield 387	com/tencent/mobileqq/vas/SignatureTemplateInfo$ImageItem:jdField_a_of_type_Int	I
    //   1473: aload 8
    //   1475: aload_0
    //   1476: ldc_w 389
    //   1479: invokevirtual 386	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   1482: putfield 390	com/tencent/mobileqq/vas/SignatureTemplateInfo$ImageItem:jdField_b_of_type_Int	I
    //   1485: aload 8
    //   1487: aload_0
    //   1488: ldc_w 392
    //   1491: invokevirtual 377	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1494: putfield 393	com/tencent/mobileqq/vas/SignatureTemplateInfo$ImageItem:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   1497: aload 7
    //   1499: aload 8
    //   1501: putfield 396	com/tencent/mobileqq/vas/SignatureTemplateInfo:jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo$ImageItem	Lcom/tencent/mobileqq/vas/SignatureTemplateInfo$ImageItem;
    //   1504: aload_3
    //   1505: aload 7
    //   1507: getfield 203	com/tencent/mobileqq/vas/SignatureTemplateInfo:jdField_b_of_type_Int	I
    //   1510: invokestatic 139	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1513: invokeinterface 400 2 0
    //   1518: checkcast 117	com/tencent/mobileqq/vas/SignatureTemplateConfig$SignatureTemplateType
    //   1521: astore_0
    //   1522: aload_0
    //   1523: ifnull +338 -> 1861
    //   1526: aload_0
    //   1527: getfield 403	com/tencent/mobileqq/vas/SignatureTemplateConfig$SignatureTemplateType:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1530: aload 7
    //   1532: invokevirtual 409	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1535: pop
    //   1536: goto +325 -> 1861
    //   1539: aload_3
    //   1540: invokeinterface 413 1 0
    //   1545: invokeinterface 418 1 0
    //   1550: astore_0
    //   1551: aload_0
    //   1552: invokeinterface 170 1 0
    //   1557: ifeq +38 -> 1595
    //   1560: aload_0
    //   1561: invokeinterface 174 1 0
    //   1566: checkcast 420	java/util/Map$Entry
    //   1569: invokeinterface 423 1 0
    //   1574: checkcast 117	com/tencent/mobileqq/vas/SignatureTemplateConfig$SignatureTemplateType
    //   1577: getfield 403	com/tencent/mobileqq/vas/SignatureTemplateConfig$SignatureTemplateType:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1580: invokevirtual 426	java/util/ArrayList:size	()I
    //   1583: ifne -32 -> 1551
    //   1586: aload_0
    //   1587: invokeinterface 429 1 0
    //   1592: goto -41 -> 1551
    //   1595: aload_3
    //   1596: invokeinterface 433 1 0
    //   1601: invokeinterface 436 1 0
    //   1606: anewarray 117	com/tencent/mobileqq/vas/SignatureTemplateConfig$SignatureTemplateType
    //   1609: astore_0
    //   1610: aload_3
    //   1611: invokeinterface 433 1 0
    //   1616: aload_0
    //   1617: invokeinterface 440 2 0
    //   1622: pop
    //   1623: aload_0
    //   1624: areturn
    //   1625: aconst_null
    //   1626: areturn
    //   1627: iload 12
    //   1629: iconst_1
    //   1630: iadd
    //   1631: istore 12
    //   1633: goto -1379 -> 254
    //   1636: iconst_m1
    //   1637: istore 14
    //   1639: goto -1284 -> 355
    //   1642: iconst_1
    //   1643: istore 14
    //   1645: goto -1264 -> 381
    //   1648: aconst_null
    //   1649: astore_0
    //   1650: goto -1244 -> 406
    //   1653: iconst_0
    //   1654: istore 14
    //   1656: goto -1225 -> 431
    //   1659: ldc_w 318
    //   1662: astore_0
    //   1663: goto -1195 -> 468
    //   1666: ldc_w 318
    //   1669: astore_0
    //   1670: goto -1169 -> 501
    //   1673: ldc_w 318
    //   1676: astore_0
    //   1677: goto -1152 -> 525
    //   1680: ldc_w 318
    //   1683: astore_0
    //   1684: goto -1126 -> 558
    //   1687: iconst_1
    //   1688: istore 14
    //   1690: goto -1098 -> 592
    //   1693: ldc_w 318
    //   1696: astore_0
    //   1697: goto -1080 -> 617
    //   1700: ldc_w 318
    //   1703: astore_0
    //   1704: goto -1063 -> 641
    //   1707: ldc_w 318
    //   1710: astore_0
    //   1711: goto -1044 -> 667
    //   1714: iload 12
    //   1716: ifeq -670 -> 1046
    //   1719: iload 12
    //   1721: iconst_1
    //   1722: if_icmple +13 -> 1735
    //   1725: iload 12
    //   1727: bipush 6
    //   1729: if_icmpge +6 -> 1735
    //   1732: goto -686 -> 1046
    //   1735: iload 14
    //   1737: iconst_1
    //   1738: iadd
    //   1739: istore 14
    //   1741: goto -738 -> 1003
    //   1744: iconst_m1
    //   1745: istore 12
    //   1747: goto -33 -> 1714
    //   1750: iload 12
    //   1752: iconst_1
    //   1753: isub
    //   1754: istore 15
    //   1756: goto -695 -> 1061
    //   1759: iload 12
    //   1761: iconst_1
    //   1762: isub
    //   1763: istore 15
    //   1765: goto -680 -> 1085
    //   1768: ldc_w 318
    //   1771: astore_0
    //   1772: goto -661 -> 1111
    //   1775: iload 12
    //   1777: iconst_1
    //   1778: isub
    //   1779: istore 15
    //   1781: goto -649 -> 1132
    //   1784: dconst_0
    //   1785: dstore_1
    //   1786: goto -629 -> 1157
    //   1789: iload 12
    //   1791: iconst_1
    //   1792: isub
    //   1793: istore 15
    //   1795: goto -617 -> 1178
    //   1798: dconst_0
    //   1799: dstore_1
    //   1800: goto -597 -> 1203
    //   1803: iload 12
    //   1805: iconst_1
    //   1806: isub
    //   1807: istore 15
    //   1809: goto -585 -> 1224
    //   1812: dconst_0
    //   1813: dstore_1
    //   1814: goto -565 -> 1249
    //   1817: iload 12
    //   1819: iconst_1
    //   1820: isub
    //   1821: istore 15
    //   1823: goto -553 -> 1270
    //   1826: dconst_0
    //   1827: dstore_1
    //   1828: goto -533 -> 1295
    //   1831: iload 12
    //   1833: iconst_1
    //   1834: isub
    //   1835: istore 15
    //   1837: goto -521 -> 1316
    //   1840: iconst_0
    //   1841: istore 15
    //   1843: goto -501 -> 1342
    //   1846: iload 12
    //   1848: iconst_1
    //   1849: isub
    //   1850: istore 12
    //   1852: goto -493 -> 1359
    //   1855: iconst_0
    //   1856: istore 12
    //   1858: goto -473 -> 1385
    //   1861: iload 13
    //   1863: iconst_1
    //   1864: iadd
    //   1865: istore 13
    //   1867: goto -1660 -> 207
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1870	0	paramQQAppInterface	com.tencent.mobileqq.app.QQAppInterface
    //   1156	672	1	d1	double
    //   7	1604	3	localObject1	Object
    //   60	128	4	localObject2	Object
    //   82	108	5	localObject3	Object
    //   91	127	6	localObject4	Object
    //   240	1291	7	localSignatureTemplateInfo	SignatureTemplateInfo
    //   224	1276	8	localObject5	Object
    //   249	765	9	localJSONArray	org.json.JSONArray
    //   271	1105	10	localJSONObject	org.json.JSONObject
    //   1089	23	11	localObject6	Object
    //   63	1794	12	i	int
    //   205	1661	13	j	int
    //   353	1387	14	k	int
    //   1059	783	15	m	int
    // Exception table:
    //   from	to	target	type
    //   19	24	143	java/lang/OutOfMemoryError
    //   0	19	868	java/lang/Exception
    //   19	24	868	java/lang/Exception
    //   24	62	868	java/lang/Exception
    //   65	134	868	java/lang/Exception
    //   144	159	868	java/lang/Exception
    //   162	177	868	java/lang/Exception
    //   177	204	868	java/lang/Exception
    //   207	251	868	java/lang/Exception
    //   254	284	868	java/lang/Exception
    //   287	330	868	java/lang/Exception
    //   330	355	868	java/lang/Exception
    //   355	381	868	java/lang/Exception
    //   381	406	868	java/lang/Exception
    //   406	431	868	java/lang/Exception
    //   431	468	868	java/lang/Exception
    //   468	474	868	java/lang/Exception
    //   483	501	868	java/lang/Exception
    //   501	525	868	java/lang/Exception
    //   525	531	868	java/lang/Exception
    //   540	558	868	java/lang/Exception
    //   558	564	868	java/lang/Exception
    //   573	592	868	java/lang/Exception
    //   592	617	868	java/lang/Exception
    //   617	641	868	java/lang/Exception
    //   641	667	868	java/lang/Exception
    //   667	697	868	java/lang/Exception
    //   697	721	868	java/lang/Exception
    //   721	745	868	java/lang/Exception
    //   745	769	868	java/lang/Exception
    //   769	793	868	java/lang/Exception
    //   793	817	868	java/lang/Exception
    //   817	841	868	java/lang/Exception
    //   841	865	868	java/lang/Exception
    //   944	952	868	java/lang/Exception
    //   956	964	868	java/lang/Exception
    //   968	976	868	java/lang/Exception
    //   979	1000	868	java/lang/Exception
    //   1003	1043	868	java/lang/Exception
    //   1046	1052	868	java/lang/Exception
    //   1061	1076	868	java/lang/Exception
    //   1091	1111	868	java/lang/Exception
    //   1111	1123	868	java/lang/Exception
    //   1137	1157	868	java/lang/Exception
    //   1157	1169	868	java/lang/Exception
    //   1183	1203	868	java/lang/Exception
    //   1203	1215	868	java/lang/Exception
    //   1229	1249	868	java/lang/Exception
    //   1249	1261	868	java/lang/Exception
    //   1275	1295	868	java/lang/Exception
    //   1295	1307	868	java/lang/Exception
    //   1321	1342	868	java/lang/Exception
    //   1342	1354	868	java/lang/Exception
    //   1364	1385	868	java/lang/Exception
    //   1385	1391	868	java/lang/Exception
    //   1394	1403	868	java/lang/Exception
    //   1407	1504	868	java/lang/Exception
    //   1504	1522	868	java/lang/Exception
    //   1526	1536	868	java/lang/Exception
    //   1539	1551	868	java/lang/Exception
    //   1551	1592	868	java/lang/Exception
    //   1595	1623	868	java/lang/Exception
    //   474	483	943	java/lang/Exception
    //   531	540	955	java/lang/Exception
    //   564	573	967	java/lang/Exception
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\vas\SignatureTemplateConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
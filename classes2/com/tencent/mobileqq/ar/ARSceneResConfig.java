package com.tencent.mobileqq.ar;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class ARSceneResConfig
{
  public long a;
  public String a;
  public ArrayList a;
  public HashMap a;
  public HashSet a;
  public boolean a;
  public String b;
  public ArrayList b;
  public String c;
  public ArrayList c;
  public String d;
  
  public ARSceneResConfig()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_c_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaUtilHashSet = new HashSet(3);
    this.d = "";
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  /* Error */
  public static ARSceneResConfig a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: new 2	com/tencent/mobileqq/ar/ARSceneResConfig
    //   5: dup
    //   6: invokespecial 53	com/tencent/mobileqq/ar/ARSceneResConfig:<init>	()V
    //   9: astore 4
    //   11: aload 4
    //   13: aload_0
    //   14: putfield 55	com/tencent/mobileqq/ar/ARSceneResConfig:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   17: new 57	java/io/FileInputStream
    //   20: dup
    //   21: aload_1
    //   22: invokespecial 60	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   25: astore_0
    //   26: invokestatic 66	android/util/Xml:newPullParser	()Lorg/xmlpull/v1/XmlPullParser;
    //   29: astore 5
    //   31: aload 5
    //   33: aload_0
    //   34: ldc 68
    //   36: invokeinterface 74 3 0
    //   41: aload 5
    //   43: invokeinterface 78 1 0
    //   48: istore 7
    //   50: aload_2
    //   51: astore_1
    //   52: goto +673 -> 725
    //   55: aload 5
    //   57: invokeinterface 81 1 0
    //   62: istore 7
    //   64: aload_3
    //   65: astore_1
    //   66: goto +659 -> 725
    //   69: aload 5
    //   71: invokeinterface 85 1 0
    //   76: astore 6
    //   78: aload 6
    //   80: ldc 87
    //   82: invokevirtual 93	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   85: ifeq +56 -> 141
    //   88: aload 5
    //   90: iconst_0
    //   91: invokeinterface 97 2 0
    //   96: astore_3
    //   97: aload 4
    //   99: getfield 28	com/tencent/mobileqq/ar/ARSceneResConfig:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   102: aload_3
    //   103: invokevirtual 101	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   106: pop
    //   107: goto -52 -> 55
    //   110: astore_1
    //   111: aload_0
    //   112: astore_2
    //   113: invokestatic 107	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   116: ifeq +14 -> 130
    //   119: ldc 109
    //   121: iconst_2
    //   122: ldc 111
    //   124: aload_1
    //   125: invokestatic 114	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   128: aload_0
    //   129: astore_2
    //   130: aload_2
    //   131: ifnull +7 -> 138
    //   134: aload_2
    //   135: invokevirtual 117	java/io/FileInputStream:close	()V
    //   138: aload 4
    //   140: areturn
    //   141: aload 6
    //   143: ldc 119
    //   145: invokevirtual 93	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   148: ifeq +139 -> 287
    //   151: new 121	com/tencent/mobileqq/ar/ARSceneResConfig$Texture
    //   154: dup
    //   155: invokespecial 122	com/tencent/mobileqq/ar/ARSceneResConfig$Texture:<init>	()V
    //   158: astore_2
    //   159: aload 5
    //   161: invokeinterface 125 1 0
    //   166: istore 8
    //   168: iconst_0
    //   169: istore 7
    //   171: iload 7
    //   173: iload 8
    //   175: if_icmpge +97 -> 272
    //   178: aload 5
    //   180: iload 7
    //   182: invokeinterface 128 2 0
    //   187: astore_3
    //   188: ldc -126
    //   190: aload_3
    //   191: invokevirtual 133	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   194: ifeq +19 -> 213
    //   197: aload_2
    //   198: aload 5
    //   200: iload 7
    //   202: invokeinterface 97 2 0
    //   207: putfield 134	com/tencent/mobileqq/ar/ARSceneResConfig$Texture:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   210: goto +559 -> 769
    //   213: ldc -120
    //   215: aload_3
    //   216: invokevirtual 133	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   219: ifeq +25 -> 244
    //   222: aload_2
    //   223: aload 5
    //   225: iload 7
    //   227: invokeinterface 97 2 0
    //   232: invokestatic 142	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   235: putfield 145	com/tencent/mobileqq/ar/ARSceneResConfig$Texture:jdField_a_of_type_Int	I
    //   238: goto +531 -> 769
    //   241: astore_0
    //   242: aload_0
    //   243: athrow
    //   244: ldc -109
    //   246: aload_3
    //   247: invokevirtual 133	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   250: ifeq +519 -> 769
    //   253: aload_2
    //   254: aload 5
    //   256: iload 7
    //   258: invokeinterface 97 2 0
    //   263: invokestatic 142	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   266: putfield 149	com/tencent/mobileqq/ar/ARSceneResConfig$Texture:b	I
    //   269: goto +500 -> 769
    //   272: aload 4
    //   274: getfield 30	com/tencent/mobileqq/ar/ARSceneResConfig:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   277: aload_2
    //   278: invokevirtual 101	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   281: pop
    //   282: aload_1
    //   283: astore_3
    //   284: goto -229 -> 55
    //   287: aload 6
    //   289: ldc -105
    //   291: invokevirtual 93	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   294: ifeq +21 -> 315
    //   297: aload 4
    //   299: aload 5
    //   301: iconst_0
    //   302: invokeinterface 97 2 0
    //   307: putfield 153	com/tencent/mobileqq/ar/ARSceneResConfig:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   310: aload_1
    //   311: astore_3
    //   312: goto -257 -> 55
    //   315: aload 6
    //   317: ldc -101
    //   319: invokevirtual 93	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   322: ifeq +21 -> 343
    //   325: aload 4
    //   327: aload 5
    //   329: iconst_0
    //   330: invokeinterface 97 2 0
    //   335: putfield 157	com/tencent/mobileqq/ar/ARSceneResConfig:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   338: aload_1
    //   339: astore_3
    //   340: goto -285 -> 55
    //   343: aload 6
    //   345: ldc -97
    //   347: invokevirtual 93	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   350: ifne +43 -> 393
    //   353: aload 6
    //   355: ldc -95
    //   357: invokevirtual 93	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   360: ifne +33 -> 393
    //   363: aload 6
    //   365: ldc -93
    //   367: invokevirtual 93	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   370: ifne +23 -> 393
    //   373: aload 6
    //   375: ldc -91
    //   377: invokevirtual 93	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   380: ifne +13 -> 393
    //   383: aload 6
    //   385: ldc -89
    //   387: invokevirtual 93	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   390: ifeq +203 -> 593
    //   393: new 169	com/tencent/mobileqq/ar/ARSceneResConfig$Clip
    //   396: dup
    //   397: invokespecial 170	com/tencent/mobileqq/ar/ARSceneResConfig$Clip:<init>	()V
    //   400: astore_2
    //   401: aload_2
    //   402: aload 6
    //   404: putfield 171	com/tencent/mobileqq/ar/ARSceneResConfig$Clip:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   407: aload_2
    //   408: aload_1
    //   409: putfield 172	com/tencent/mobileqq/ar/ARSceneResConfig$Clip:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   412: aload 5
    //   414: invokeinterface 125 1 0
    //   419: istore 8
    //   421: iconst_0
    //   422: istore 7
    //   424: iload 7
    //   426: iload 8
    //   428: if_icmpge +75 -> 503
    //   431: aload 5
    //   433: iload 7
    //   435: invokeinterface 128 2 0
    //   440: astore_3
    //   441: ldc -82
    //   443: aload_3
    //   444: invokevirtual 133	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   447: ifeq +25 -> 472
    //   450: aload_2
    //   451: aload 5
    //   453: iload 7
    //   455: invokeinterface 97 2 0
    //   460: invokestatic 180	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   463: invokevirtual 184	java/lang/Long:longValue	()J
    //   466: putfield 186	com/tencent/mobileqq/ar/ARSceneResConfig$Clip:jdField_a_of_type_Long	J
    //   469: goto +309 -> 778
    //   472: ldc -68
    //   474: aload_3
    //   475: invokevirtual 133	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   478: ifeq +300 -> 778
    //   481: aload_2
    //   482: aload 5
    //   484: iload 7
    //   486: invokeinterface 97 2 0
    //   491: invokestatic 180	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   494: invokevirtual 184	java/lang/Long:longValue	()J
    //   497: putfield 190	com/tencent/mobileqq/ar/ARSceneResConfig$Clip:jdField_b_of_type_Long	J
    //   500: goto +278 -> 778
    //   503: aload 4
    //   505: getfield 32	com/tencent/mobileqq/ar/ARSceneResConfig:jdField_c_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   508: aload_2
    //   509: invokevirtual 101	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   512: pop
    //   513: aload 4
    //   515: getfield 39	com/tencent/mobileqq/ar/ARSceneResConfig:jdField_a_of_type_JavaUtilHashSet	Ljava/util/HashSet;
    //   518: aload 6
    //   520: invokevirtual 191	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   523: pop
    //   524: aload_2
    //   525: getfield 190	com/tencent/mobileqq/ar/ARSceneResConfig$Clip:jdField_b_of_type_Long	J
    //   528: aload_2
    //   529: getfield 186	com/tencent/mobileqq/ar/ARSceneResConfig$Clip:jdField_a_of_type_Long	J
    //   532: lsub
    //   533: lstore 9
    //   535: aload 4
    //   537: getfield 48	com/tencent/mobileqq/ar/ARSceneResConfig:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   540: aload 6
    //   542: invokevirtual 195	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   545: checkcast 176	java/lang/Long
    //   548: astore_3
    //   549: aload_3
    //   550: astore_2
    //   551: aload_3
    //   552: ifnonnull +8 -> 560
    //   555: lconst_0
    //   556: invokestatic 198	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   559: astore_2
    //   560: aload_1
    //   561: astore_3
    //   562: lload 9
    //   564: aload_2
    //   565: invokevirtual 184	java/lang/Long:longValue	()J
    //   568: lcmp
    //   569: ifle -514 -> 55
    //   572: aload 4
    //   574: getfield 48	com/tencent/mobileqq/ar/ARSceneResConfig:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   577: aload 6
    //   579: lload 9
    //   581: invokestatic 198	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   584: invokevirtual 202	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   587: pop
    //   588: aload_1
    //   589: astore_3
    //   590: goto -535 -> 55
    //   593: aload_1
    //   594: astore_3
    //   595: aload 6
    //   597: ldc -52
    //   599: invokevirtual 93	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   602: ifeq -547 -> 55
    //   605: aload 4
    //   607: iconst_1
    //   608: putfield 206	com/tencent/mobileqq/ar/ARSceneResConfig:jdField_a_of_type_Boolean	Z
    //   611: aload 5
    //   613: invokeinterface 125 1 0
    //   618: istore 8
    //   620: iconst_0
    //   621: istore 7
    //   623: aload_1
    //   624: astore_3
    //   625: iload 7
    //   627: iload 8
    //   629: if_icmpge -574 -> 55
    //   632: aload 5
    //   634: iload 7
    //   636: invokeinterface 128 2 0
    //   641: astore_2
    //   642: ldc -48
    //   644: aload_2
    //   645: invokevirtual 133	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   648: ifeq +20 -> 668
    //   651: aload 4
    //   653: aload 5
    //   655: iload 7
    //   657: invokeinterface 97 2 0
    //   662: putfield 43	com/tencent/mobileqq/ar/ARSceneResConfig:d	Ljava/lang/String;
    //   665: goto +122 -> 787
    //   668: ldc -46
    //   670: aload_2
    //   671: invokevirtual 133	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   674: ifeq +113 -> 787
    //   677: aload 4
    //   679: aload 5
    //   681: iload 7
    //   683: invokeinterface 97 2 0
    //   688: invokestatic 180	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   691: invokevirtual 184	java/lang/Long:longValue	()J
    //   694: putfield 211	com/tencent/mobileqq/ar/ARSceneResConfig:jdField_a_of_type_Long	J
    //   697: goto +90 -> 787
    //   700: astore_0
    //   701: invokestatic 107	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   704: ifeq -566 -> 138
    //   707: ldc 109
    //   709: iconst_2
    //   710: ldc 111
    //   712: aload_0
    //   713: invokestatic 114	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   716: aload 4
    //   718: areturn
    //   719: astore_1
    //   720: aconst_null
    //   721: astore_0
    //   722: goto -611 -> 111
    //   725: aload_0
    //   726: astore_2
    //   727: iload 7
    //   729: iconst_1
    //   730: if_icmpeq -600 -> 130
    //   733: aload_1
    //   734: astore_3
    //   735: iload 7
    //   737: tableswitch	default:+27->764, 2:+-668->69, 3:+-682->55, 4:+-682->55
    //   764: aload_1
    //   765: astore_3
    //   766: goto -711 -> 55
    //   769: iload 7
    //   771: iconst_1
    //   772: iadd
    //   773: istore 7
    //   775: goto -604 -> 171
    //   778: iload 7
    //   780: iconst_1
    //   781: iadd
    //   782: istore 7
    //   784: goto -360 -> 424
    //   787: iload 7
    //   789: iconst_1
    //   790: iadd
    //   791: istore 7
    //   793: goto -170 -> 623
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	796	0	paramString1	String
    //   0	796	1	paramString2	String
    //   1	726	2	localObject1	Object
    //   64	702	3	localObject2	Object
    //   9	708	4	localARSceneResConfig	ARSceneResConfig
    //   29	651	5	localXmlPullParser	org.xmlpull.v1.XmlPullParser
    //   76	520	6	str	String
    //   48	744	7	i	int
    //   166	464	8	j	int
    //   533	47	9	l	long
    // Exception table:
    //   from	to	target	type
    //   26	50	110	java/lang/Exception
    //   55	64	110	java/lang/Exception
    //   69	107	110	java/lang/Exception
    //   141	168	110	java/lang/Exception
    //   178	210	110	java/lang/Exception
    //   213	238	110	java/lang/Exception
    //   244	269	110	java/lang/Exception
    //   272	282	110	java/lang/Exception
    //   287	310	110	java/lang/Exception
    //   315	338	110	java/lang/Exception
    //   343	393	110	java/lang/Exception
    //   393	421	110	java/lang/Exception
    //   431	469	110	java/lang/Exception
    //   472	500	110	java/lang/Exception
    //   503	549	110	java/lang/Exception
    //   555	560	110	java/lang/Exception
    //   562	588	110	java/lang/Exception
    //   595	620	110	java/lang/Exception
    //   632	665	110	java/lang/Exception
    //   668	697	110	java/lang/Exception
    //   17	26	241	finally
    //   26	50	241	finally
    //   55	64	241	finally
    //   69	107	241	finally
    //   113	128	241	finally
    //   141	168	241	finally
    //   178	210	241	finally
    //   213	238	241	finally
    //   244	269	241	finally
    //   272	282	241	finally
    //   287	310	241	finally
    //   315	338	241	finally
    //   343	393	241	finally
    //   393	421	241	finally
    //   431	469	241	finally
    //   472	500	241	finally
    //   503	549	241	finally
    //   555	560	241	finally
    //   562	588	241	finally
    //   595	620	241	finally
    //   632	665	241	finally
    //   668	697	241	finally
    //   134	138	700	java/lang/Exception
    //   17	26	719	java/lang/Exception
  }
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilHashSet.size();
  }
  
  public long a(String paramString)
  {
    Long localLong = (Long)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    paramString = localLong;
    if (localLong == null) {
      paramString = Long.valueOf(0L);
    }
    return paramString.longValue();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ARSceneResConfig");
    localStringBuilder.append(",");
    localStringBuilder.append("basePath");
    localStringBuilder.append(",");
    localStringBuilder.append(this.jdField_a_of_type_JavaUtilArrayList.size());
    localStringBuilder.append(",");
    localStringBuilder.append(this.jdField_c_of_type_JavaUtilArrayList.size());
    return localStringBuilder.toString();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\ar\ARSceneResConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
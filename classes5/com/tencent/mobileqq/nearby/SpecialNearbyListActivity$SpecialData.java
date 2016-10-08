package com.tencent.mobileqq.nearby;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.interestTag.InterestTag;
import java.util.ArrayList;
import java.util.List;

public class SpecialNearbyListActivity$SpecialData
{
  public byte a;
  public int a;
  public long a;
  public InterestTag a;
  public String a;
  public final List a;
  public boolean a;
  public String b;
  public boolean b;
  public String c;
  public boolean c;
  
  public SpecialNearbyListActivity$SpecialData()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  /* Error */
  public void a(android.content.res.Resources paramResources)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 34	com/tencent/mobileqq/nearby/SpecialNearbyListActivity$SpecialData:jdField_a_of_type_ComTencentMobileqqNearbyInterestTagInterestTag	Lcom/tencent/mobileqq/nearby/interestTag/InterestTag;
    //   4: ifnonnull +52 -> 56
    //   7: new 36	org/json/JSONObject
    //   10: dup
    //   11: aload_0
    //   12: getfield 38	com/tencent/mobileqq/nearby/SpecialNearbyListActivity$SpecialData:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   15: invokespecial 41	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   18: invokestatic 47	com/tencent/mobileqq/nearby/interestTag/InterestTagInfo:convertFrom	(Lorg/json/JSONObject;)Lcom/tencent/mobileqq/nearby/interestTag/InterestTagInfo;
    //   21: astore 5
    //   23: aload 5
    //   25: ifnull +31 -> 56
    //   28: aload_0
    //   29: new 49	com/tencent/mobileqq/nearby/interestTag/InterestTag
    //   32: dup
    //   33: aload_0
    //   34: getfield 51	com/tencent/mobileqq/nearby/SpecialNearbyListActivity$SpecialData:jdField_a_of_type_Byte	B
    //   37: invokespecial 54	com/tencent/mobileqq/nearby/interestTag/InterestTag:<init>	(I)V
    //   40: putfield 34	com/tencent/mobileqq/nearby/SpecialNearbyListActivity$SpecialData:jdField_a_of_type_ComTencentMobileqqNearbyInterestTagInterestTag	Lcom/tencent/mobileqq/nearby/interestTag/InterestTag;
    //   43: aload_0
    //   44: getfield 34	com/tencent/mobileqq/nearby/SpecialNearbyListActivity$SpecialData:jdField_a_of_type_ComTencentMobileqqNearbyInterestTagInterestTag	Lcom/tencent/mobileqq/nearby/interestTag/InterestTag;
    //   47: getfield 57	com/tencent/mobileqq/nearby/interestTag/InterestTag:a	Ljava/util/ArrayList;
    //   50: aload 5
    //   52: invokevirtual 61	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   55: pop
    //   56: aload_0
    //   57: aload_0
    //   58: getfield 63	com/tencent/mobileqq/nearby/SpecialNearbyListActivity$SpecialData:b	Ljava/lang/String;
    //   61: putfield 65	com/tencent/mobileqq/nearby/SpecialNearbyListActivity$SpecialData:c	Ljava/lang/String;
    //   64: aload_0
    //   65: getfield 65	com/tencent/mobileqq/nearby/SpecialNearbyListActivity$SpecialData:c	Ljava/lang/String;
    //   68: ifnonnull +9 -> 77
    //   71: aload_0
    //   72: ldc 67
    //   74: putfield 65	com/tencent/mobileqq/nearby/SpecialNearbyListActivity$SpecialData:c	Ljava/lang/String;
    //   77: aload_0
    //   78: getfield 65	com/tencent/mobileqq/nearby/SpecialNearbyListActivity$SpecialData:c	Ljava/lang/String;
    //   81: invokevirtual 73	java/lang/String:length	()I
    //   84: iconst_3
    //   85: if_icmple +334 -> 419
    //   88: aload_1
    //   89: invokevirtual 79	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   92: astore 6
    //   94: aload 6
    //   96: getfield 84	android/util/DisplayMetrics:widthPixels	I
    //   99: aload 6
    //   101: getfield 87	android/util/DisplayMetrics:heightPixels	I
    //   104: invokestatic 93	java/lang/Math:min	(II)I
    //   107: aload_1
    //   108: ldc 94
    //   110: invokevirtual 98	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   113: isub
    //   114: aload_1
    //   115: ldc 99
    //   117: invokevirtual 98	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   120: isub
    //   121: aload_1
    //   122: ldc 100
    //   124: invokevirtual 98	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   127: isub
    //   128: aload_1
    //   129: ldc 101
    //   131: invokevirtual 98	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   134: isub
    //   135: istore 9
    //   137: new 103	android/text/TextPaint
    //   140: dup
    //   141: iconst_1
    //   142: invokespecial 104	android/text/TextPaint:<init>	(I)V
    //   145: astore 5
    //   147: aload 5
    //   149: aload 6
    //   151: getfield 108	android/util/DisplayMetrics:density	F
    //   154: putfield 109	android/text/TextPaint:density	F
    //   157: aload 5
    //   159: aload 6
    //   161: getfield 108	android/util/DisplayMetrics:density	F
    //   164: ldc 110
    //   166: fmul
    //   167: invokevirtual 114	android/text/TextPaint:setTextSize	(F)V
    //   170: aload 5
    //   172: aload_1
    //   173: ldc 115
    //   175: invokevirtual 119	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   178: iconst_1
    //   179: anewarray 4	java/lang/Object
    //   182: dup
    //   183: iconst_0
    //   184: aload_0
    //   185: getfield 65	com/tencent/mobileqq/nearby/SpecialNearbyListActivity$SpecialData:c	Ljava/lang/String;
    //   188: aastore
    //   189: invokestatic 123	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   192: invokevirtual 127	android/text/TextPaint:measureText	(Ljava/lang/String;)F
    //   195: fstore_2
    //   196: ldc -128
    //   198: fload_2
    //   199: fadd
    //   200: iload 9
    //   202: i2f
    //   203: fcmpl
    //   204: ifle +172 -> 376
    //   207: aload_1
    //   208: ldc 115
    //   210: invokevirtual 119	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   213: astore_1
    //   214: aload_0
    //   215: getfield 65	com/tencent/mobileqq/nearby/SpecialNearbyListActivity$SpecialData:c	Ljava/lang/String;
    //   218: invokevirtual 73	java/lang/String:length	()I
    //   221: istore 10
    //   223: aload 5
    //   225: aload_1
    //   226: invokevirtual 127	android/text/TextPaint:measureText	(Ljava/lang/String;)F
    //   229: fstore_3
    //   230: aload 5
    //   232: aload_0
    //   233: getfield 65	com/tencent/mobileqq/nearby/SpecialNearbyListActivity$SpecialData:c	Ljava/lang/String;
    //   236: invokevirtual 127	android/text/TextPaint:measureText	(Ljava/lang/String;)F
    //   239: fstore 4
    //   241: iload 9
    //   243: i2f
    //   244: fload_3
    //   245: fsub
    //   246: fload 4
    //   248: iload 10
    //   250: i2f
    //   251: fdiv
    //   252: fdiv
    //   253: f2i
    //   254: istore 8
    //   256: iload 8
    //   258: istore 7
    //   260: iload 8
    //   262: iload 10
    //   264: if_icmplt +9 -> 273
    //   267: iload 10
    //   269: iconst_1
    //   270: isub
    //   271: istore 7
    //   273: aload_0
    //   274: new 130	java/lang/StringBuilder
    //   277: dup
    //   278: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   281: aload_0
    //   282: getfield 65	com/tencent/mobileqq/nearby/SpecialNearbyListActivity$SpecialData:c	Ljava/lang/String;
    //   285: iconst_0
    //   286: iload 7
    //   288: invokevirtual 135	java/lang/String:substring	(II)Ljava/lang/String;
    //   291: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   294: ldc -115
    //   296: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   302: putfield 65	com/tencent/mobileqq/nearby/SpecialNearbyListActivity$SpecialData:c	Ljava/lang/String;
    //   305: invokestatic 150	com/tencent/mobileqq/nearby/NearbyUtils:b	()Z
    //   308: ifeq +57 -> 365
    //   311: getstatic 153	com/tencent/mobileqq/nearby/SpecialNearbyListActivity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   314: bipush 6
    //   316: anewarray 4	java/lang/Object
    //   319: dup
    //   320: iconst_0
    //   321: ldc -101
    //   323: aastore
    //   324: dup
    //   325: iconst_1
    //   326: fload_2
    //   327: invokestatic 161	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   330: aastore
    //   331: dup
    //   332: iconst_2
    //   333: iload 9
    //   335: invokestatic 166	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   338: aastore
    //   339: dup
    //   340: iconst_3
    //   341: fload_3
    //   342: invokestatic 161	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   345: aastore
    //   346: dup
    //   347: iconst_4
    //   348: fload 4
    //   350: invokestatic 161	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   353: aastore
    //   354: dup
    //   355: iconst_5
    //   356: iload 7
    //   358: invokestatic 166	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   361: aastore
    //   362: invokestatic 169	com/tencent/mobileqq/nearby/NearbyUtils:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   365: return
    //   366: astore 5
    //   368: aload 5
    //   370: invokevirtual 172	java/lang/Exception:printStackTrace	()V
    //   373: goto -317 -> 56
    //   376: invokestatic 150	com/tencent/mobileqq/nearby/NearbyUtils:b	()Z
    //   379: ifeq -14 -> 365
    //   382: getstatic 153	com/tencent/mobileqq/nearby/SpecialNearbyListActivity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   385: iconst_3
    //   386: anewarray 4	java/lang/Object
    //   389: dup
    //   390: iconst_0
    //   391: ldc -101
    //   393: aastore
    //   394: dup
    //   395: iconst_1
    //   396: fload_2
    //   397: invokestatic 161	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   400: aastore
    //   401: dup
    //   402: iconst_2
    //   403: iload 9
    //   405: invokestatic 166	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   408: aastore
    //   409: invokestatic 169	com/tencent/mobileqq/nearby/NearbyUtils:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   412: return
    //   413: astore_1
    //   414: aload_1
    //   415: invokevirtual 172	java/lang/Exception:printStackTrace	()V
    //   418: return
    //   419: invokestatic 150	com/tencent/mobileqq/nearby/NearbyUtils:b	()Z
    //   422: ifeq -57 -> 365
    //   425: getstatic 153	com/tencent/mobileqq/nearby/SpecialNearbyListActivity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   428: iconst_2
    //   429: anewarray 4	java/lang/Object
    //   432: dup
    //   433: iconst_0
    //   434: ldc -101
    //   436: aastore
    //   437: dup
    //   438: iconst_1
    //   439: aload_0
    //   440: getfield 65	com/tencent/mobileqq/nearby/SpecialNearbyListActivity$SpecialData:c	Ljava/lang/String;
    //   443: aastore
    //   444: invokestatic 169	com/tencent/mobileqq/nearby/NearbyUtils:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   447: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	448	0	this	SpecialData
    //   0	448	1	paramResources	android.content.res.Resources
    //   195	202	2	f1	float
    //   229	113	3	f2	float
    //   239	110	4	f3	float
    //   21	210	5	localObject	Object
    //   366	3	5	localException	Exception
    //   92	68	6	localDisplayMetrics	android.util.DisplayMetrics
    //   258	99	7	i	int
    //   254	11	8	j	int
    //   135	269	9	k	int
    //   221	50	10	m	int
    // Exception table:
    //   from	to	target	type
    //   7	23	366	java/lang/Exception
    //   28	56	366	java/lang/Exception
    //   56	77	413	java/lang/Exception
    //   77	196	413	java/lang/Exception
    //   207	256	413	java/lang/Exception
    //   273	365	413	java/lang/Exception
    //   376	412	413	java/lang/Exception
    //   419	447	413	java/lang/Exception
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\nearby\SpecialNearbyListActivity$SpecialData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
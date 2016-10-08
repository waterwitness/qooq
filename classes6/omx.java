import com.tencent.mobileqq.activity.pendant.AvatarPendantActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class omx
  implements Runnable
{
  public omx(AvatarPendantActivity paramAvatarPendantActivity, String paramString, boolean paramBoolean)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: invokestatic 40	android/os/SystemClock:uptimeMillis	()J
    //   3: lstore 18
    //   5: new 42	java/io/File
    //   8: dup
    //   9: aload_0
    //   10: getfield 16	omx:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   13: invokespecial 45	java/io/File:<init>	(Ljava/lang/String;)V
    //   16: astore_1
    //   17: invokestatic 49	com/tencent/mobileqq/utils/AvatarPendantUtil:a	()V
    //   20: aload_1
    //   21: invokevirtual 53	java/io/File:exists	()Z
    //   24: ifeq +236 -> 260
    //   27: aload_1
    //   28: invokestatic 59	com/tencent/mobileqq/utils/FileUtils:b	(Ljava/io/File;)Ljava/lang/String;
    //   31: astore_3
    //   32: aload_3
    //   33: invokestatic 65	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   36: ifne +224 -> 260
    //   39: aload_0
    //   40: getfield 14	omx:jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity	Lcom/tencent/mobileqq/activity/pendant/AvatarPendantActivity;
    //   43: getfield 71	com/tencent/mobileqq/activity/pendant/AvatarPendantActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   46: bipush 45
    //   48: invokevirtual 77	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   51: checkcast 79	com/tencent/mobileqq/vas/AvatarPendantManager
    //   54: invokevirtual 82	com/tencent/mobileqq/vas/AvatarPendantManager:a	()Ljava/util/List;
    //   57: astore_2
    //   58: new 84	org/json/JSONObject
    //   61: dup
    //   62: aload_3
    //   63: invokespecial 85	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   66: astore_3
    //   67: aload_3
    //   68: ldc 87
    //   70: invokevirtual 91	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   73: ifeq +153 -> 226
    //   76: aload_3
    //   77: ldc 87
    //   79: invokevirtual 95	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   82: iconst_1
    //   83: if_icmpne +137 -> 220
    //   86: iconst_1
    //   87: istore 22
    //   89: iload 22
    //   91: putstatic 98	com/tencent/mobileqq/vas/AvatarPendantManager:c	Z
    //   94: aload_3
    //   95: ldc 100
    //   97: invokevirtual 104	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   100: astore 6
    //   102: new 106	java/util/HashSet
    //   105: dup
    //   106: invokespecial 107	java/util/HashSet:<init>	()V
    //   109: astore 4
    //   111: aload 6
    //   113: ldc 109
    //   115: invokevirtual 91	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   118: ifeq +195 -> 313
    //   121: aload 6
    //   123: ldc 109
    //   125: invokevirtual 113	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   128: astore 5
    //   130: aload 5
    //   132: invokestatic 65	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   135: ifne +178 -> 313
    //   138: aload 5
    //   140: ldc 115
    //   142: invokevirtual 121	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   145: astore 5
    //   147: aload 5
    //   149: arraylength
    //   150: istore 15
    //   152: iconst_0
    //   153: istore 14
    //   155: iload 14
    //   157: iload 15
    //   159: if_icmpge +154 -> 313
    //   162: aload 5
    //   164: iload 14
    //   166: aaload
    //   167: astore 7
    //   169: aload 7
    //   171: invokestatic 65	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   174: ifne +14 -> 188
    //   177: aload 4
    //   179: aload 7
    //   181: invokestatic 127	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   184: invokevirtual 131	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   187: pop
    //   188: iload 14
    //   190: iconst_1
    //   191: iadd
    //   192: istore 14
    //   194: goto -39 -> 155
    //   197: astore_1
    //   198: invokestatic 136	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   201: ifeq +12 -> 213
    //   204: ldc -118
    //   206: iconst_2
    //   207: ldc -116
    //   209: aload_1
    //   210: invokestatic 144	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   213: return
    //   214: astore_1
    //   215: aload_1
    //   216: invokevirtual 147	java/io/IOException:printStackTrace	()V
    //   219: return
    //   220: iconst_0
    //   221: istore 22
    //   223: goto -134 -> 89
    //   226: iconst_0
    //   227: putstatic 98	com/tencent/mobileqq/vas/AvatarPendantManager:c	Z
    //   230: goto -136 -> 94
    //   233: astore_3
    //   234: aload_2
    //   235: invokeinterface 152 1 0
    //   240: aload_1
    //   241: invokevirtual 155	java/io/File:delete	()Z
    //   244: pop
    //   245: invokestatic 136	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   248: ifeq +12 -> 260
    //   251: ldc -118
    //   253: iconst_2
    //   254: ldc -99
    //   256: aload_3
    //   257: invokestatic 144	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   260: invokestatic 40	android/os/SystemClock:uptimeMillis	()J
    //   263: lstore 20
    //   265: invokestatic 136	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   268: ifeq -55 -> 213
    //   271: ldc -118
    //   273: iconst_2
    //   274: new 159	java/lang/StringBuilder
    //   277: dup
    //   278: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   281: ldc -94
    //   283: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   286: lload 20
    //   288: lload 18
    //   290: lsub
    //   291: invokevirtual 169	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   294: ldc -85
    //   296: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: aload_1
    //   300: invokevirtual 174	java/io/File:length	()J
    //   303: invokevirtual 169	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   306: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   309: invokestatic 182	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   312: return
    //   313: new 106	java/util/HashSet
    //   316: dup
    //   317: invokespecial 107	java/util/HashSet:<init>	()V
    //   320: astore 5
    //   322: aload 6
    //   324: ldc -72
    //   326: invokevirtual 91	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   329: ifeq +73 -> 402
    //   332: aload 6
    //   334: ldc -72
    //   336: invokevirtual 113	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   339: astore 7
    //   341: aload 7
    //   343: invokestatic 65	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   346: ifne +56 -> 402
    //   349: aload 7
    //   351: ldc 115
    //   353: invokevirtual 121	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   356: astore 7
    //   358: aload 7
    //   360: arraylength
    //   361: istore 15
    //   363: iconst_0
    //   364: istore 14
    //   366: iload 14
    //   368: iload 15
    //   370: if_icmpge +32 -> 402
    //   373: aload 7
    //   375: iload 14
    //   377: aaload
    //   378: astore 8
    //   380: aload 8
    //   382: invokestatic 65	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   385: ifne +951 -> 1336
    //   388: aload 5
    //   390: aload 8
    //   392: invokestatic 127	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   395: invokevirtual 131	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   398: pop
    //   399: goto +937 -> 1336
    //   402: new 106	java/util/HashSet
    //   405: dup
    //   406: invokespecial 107	java/util/HashSet:<init>	()V
    //   409: astore 7
    //   411: aload 6
    //   413: ldc -70
    //   415: invokevirtual 91	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   418: ifeq +73 -> 491
    //   421: aload 6
    //   423: ldc -70
    //   425: invokevirtual 113	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   428: astore 6
    //   430: aload 6
    //   432: invokestatic 65	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   435: ifne +56 -> 491
    //   438: aload 6
    //   440: ldc 115
    //   442: invokevirtual 121	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   445: astore 6
    //   447: aload 6
    //   449: arraylength
    //   450: istore 15
    //   452: iconst_0
    //   453: istore 14
    //   455: iload 14
    //   457: iload 15
    //   459: if_icmpge +32 -> 491
    //   462: aload 6
    //   464: iload 14
    //   466: aaload
    //   467: astore 8
    //   469: aload 8
    //   471: invokestatic 65	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   474: ifne +871 -> 1345
    //   477: aload 7
    //   479: aload 8
    //   481: invokestatic 127	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   484: invokevirtual 131	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   487: pop
    //   488: goto +857 -> 1345
    //   491: new 188	android/util/SparseArray
    //   494: dup
    //   495: invokespecial 189	android/util/SparseArray:<init>	()V
    //   498: astore 6
    //   500: aload_3
    //   501: ldc -65
    //   503: invokevirtual 104	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   506: astore 8
    //   508: aload 8
    //   510: invokevirtual 195	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   513: astore 9
    //   515: ldc -59
    //   517: iconst_0
    //   518: iconst_2
    //   519: invokevirtual 201	java/lang/String:substring	(II)Ljava/lang/String;
    //   522: astore 10
    //   524: aload 9
    //   526: invokeinterface 206 1 0
    //   531: ifeq +375 -> 906
    //   534: aload 9
    //   536: invokeinterface 210 1 0
    //   541: invokevirtual 211	java/lang/Object:toString	()Ljava/lang/String;
    //   544: astore 11
    //   546: aload 11
    //   548: ifnull -24 -> 524
    //   551: aload 8
    //   553: aload 11
    //   555: invokevirtual 104	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   558: astore 12
    //   560: aload 12
    //   562: ldc -43
    //   564: invokevirtual 104	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   567: astore 13
    //   569: aload 13
    //   571: ldc -41
    //   573: invokevirtual 95	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   576: ifeq -52 -> 524
    //   579: aload 10
    //   581: aload 13
    //   583: ldc -39
    //   585: invokevirtual 113	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   588: iconst_0
    //   589: iconst_2
    //   590: invokevirtual 201	java/lang/String:substring	(II)Ljava/lang/String;
    //   593: invokevirtual 220	java/lang/String:compareTo	(Ljava/lang/String;)I
    //   596: iflt -72 -> 524
    //   599: new 222	com/tencent/mobileqq/vas/AvatarPendantShopItemInfo
    //   602: dup
    //   603: invokespecial 223	com/tencent/mobileqq/vas/AvatarPendantShopItemInfo:<init>	()V
    //   606: astore 11
    //   608: aload 11
    //   610: aload 13
    //   612: ldc -31
    //   614: invokevirtual 95	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   617: putfield 228	com/tencent/mobileqq/vas/AvatarPendantShopItemInfo:jdField_c_of_type_Int	I
    //   620: aload 11
    //   622: aload 13
    //   624: ldc -26
    //   626: invokevirtual 95	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   629: putfield 233	com/tencent/mobileqq/vas/AvatarPendantShopItemInfo:f	I
    //   632: aload 11
    //   634: aload 13
    //   636: ldc -21
    //   638: invokevirtual 239	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   641: putfield 242	com/tencent/mobileqq/vas/AvatarPendantShopItemInfo:jdField_a_of_type_Long	J
    //   644: aload 11
    //   646: aload 13
    //   648: ldc -12
    //   650: invokevirtual 239	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   653: putfield 246	com/tencent/mobileqq/vas/AvatarPendantShopItemInfo:jdField_b_of_type_Long	J
    //   656: aload 12
    //   658: ldc -8
    //   660: invokevirtual 104	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   663: astore 12
    //   665: aload 11
    //   667: aload 12
    //   669: ldc -6
    //   671: invokevirtual 95	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   674: putfield 252	com/tencent/mobileqq/vas/AvatarPendantShopItemInfo:jdField_b_of_type_Int	I
    //   677: aload 11
    //   679: aload 12
    //   681: ldc -2
    //   683: invokevirtual 113	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   686: putfield 255	com/tencent/mobileqq/vas/AvatarPendantShopItemInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   689: aload 11
    //   691: aload 12
    //   693: ldc_w 257
    //   696: invokevirtual 113	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   699: putfield 259	com/tencent/mobileqq/vas/AvatarPendantShopItemInfo:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   702: aload 11
    //   704: aload 12
    //   706: ldc_w 261
    //   709: invokevirtual 113	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   712: invokestatic 127	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   715: invokevirtual 265	java/lang/Integer:intValue	()I
    //   718: putfield 267	com/tencent/mobileqq/vas/AvatarPendantShopItemInfo:jdField_a_of_type_Int	I
    //   721: aload 12
    //   723: ldc_w 269
    //   726: invokevirtual 95	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   729: iconst_1
    //   730: if_icmpne +624 -> 1354
    //   733: iconst_1
    //   734: istore 22
    //   736: aload 11
    //   738: iload 22
    //   740: putfield 270	com/tencent/mobileqq/vas/AvatarPendantShopItemInfo:jdField_a_of_type_Boolean	Z
    //   743: aload 11
    //   745: aload 12
    //   747: ldc_w 272
    //   750: invokevirtual 113	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   753: putfield 274	com/tencent/mobileqq/vas/AvatarPendantShopItemInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   756: aload 4
    //   758: aload 11
    //   760: getfield 267	com/tencent/mobileqq/vas/AvatarPendantShopItemInfo:jdField_a_of_type_Int	I
    //   763: invokestatic 277	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   766: invokevirtual 280	java/util/HashSet:contains	(Ljava/lang/Object;)Z
    //   769: ifeq +91 -> 860
    //   772: aload 11
    //   774: bipush 7
    //   776: putfield 283	com/tencent/mobileqq/vas/AvatarPendantShopItemInfo:g	I
    //   779: invokestatic 288	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getServerTimeMillis	()J
    //   782: lstore 20
    //   784: aload 11
    //   786: getfield 228	com/tencent/mobileqq/vas/AvatarPendantShopItemInfo:jdField_c_of_type_Int	I
    //   789: iconst_1
    //   790: if_icmpne +96 -> 886
    //   793: aload 11
    //   795: getfield 242	com/tencent/mobileqq/vas/AvatarPendantShopItemInfo:jdField_a_of_type_Long	J
    //   798: lload 20
    //   800: lcmp
    //   801: ifgt +85 -> 886
    //   804: lload 20
    //   806: aload 11
    //   808: getfield 246	com/tencent/mobileqq/vas/AvatarPendantShopItemInfo:jdField_b_of_type_Long	J
    //   811: lcmp
    //   812: ifgt +74 -> 886
    //   815: aload 11
    //   817: bipush 10
    //   819: putfield 291	com/tencent/mobileqq/vas/AvatarPendantShopItemInfo:h	I
    //   822: aload 7
    //   824: aload 11
    //   826: getfield 267	com/tencent/mobileqq/vas/AvatarPendantShopItemInfo:jdField_a_of_type_Int	I
    //   829: invokestatic 277	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   832: invokevirtual 280	java/util/HashSet:contains	(Ljava/lang/Object;)Z
    //   835: ifeq +10 -> 845
    //   838: aload 11
    //   840: bipush 9
    //   842: putfield 291	com/tencent/mobileqq/vas/AvatarPendantShopItemInfo:h	I
    //   845: aload 6
    //   847: aload 11
    //   849: getfield 267	com/tencent/mobileqq/vas/AvatarPendantShopItemInfo:jdField_a_of_type_Int	I
    //   852: aload 11
    //   854: invokevirtual 295	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   857: goto -333 -> 524
    //   860: aload 5
    //   862: aload 11
    //   864: getfield 267	com/tencent/mobileqq/vas/AvatarPendantShopItemInfo:jdField_a_of_type_Int	I
    //   867: invokestatic 277	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   870: invokevirtual 280	java/util/HashSet:contains	(Ljava/lang/Object;)Z
    //   873: ifeq -94 -> 779
    //   876: aload 11
    //   878: bipush 8
    //   880: putfield 283	com/tencent/mobileqq/vas/AvatarPendantShopItemInfo:g	I
    //   883: goto -104 -> 779
    //   886: aload 11
    //   888: getfield 228	com/tencent/mobileqq/vas/AvatarPendantShopItemInfo:jdField_c_of_type_Int	I
    //   891: bipush 6
    //   893: if_icmpne -71 -> 822
    //   896: aload 11
    //   898: bipush 6
    //   900: putfield 291	com/tencent/mobileqq/vas/AvatarPendantShopItemInfo:h	I
    //   903: goto -81 -> 822
    //   906: aload_2
    //   907: invokeinterface 152 1 0
    //   912: aload_3
    //   913: ldc_w 297
    //   916: invokevirtual 301	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   919: astore_3
    //   920: aload_3
    //   921: invokevirtual 305	org/json/JSONArray:length	()I
    //   924: istore 16
    //   926: iconst_0
    //   927: istore 14
    //   929: iload 14
    //   931: iload 16
    //   933: if_icmpge +335 -> 1268
    //   936: aload_3
    //   937: iload 14
    //   939: invokevirtual 309	org/json/JSONArray:get	(I)Ljava/lang/Object;
    //   942: checkcast 84	org/json/JSONObject
    //   945: astore 4
    //   947: aload 4
    //   949: ldc -41
    //   951: invokevirtual 95	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   954: ifne +6 -> 960
    //   957: goto +403 -> 1360
    //   960: aload 4
    //   962: ldc_w 311
    //   965: invokevirtual 113	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   968: astore 7
    //   970: aload 7
    //   972: invokestatic 65	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   975: ifne +385 -> 1360
    //   978: aload 4
    //   980: ldc_w 313
    //   983: invokevirtual 95	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   986: bipush 100
    //   988: if_icmpge +372 -> 1360
    //   991: new 315	com/tencent/mobileqq/vas/AvatarPendantShopSeriesInfo
    //   994: dup
    //   995: invokespecial 316	com/tencent/mobileqq/vas/AvatarPendantShopSeriesInfo:<init>	()V
    //   998: astore 5
    //   1000: aload 5
    //   1002: new 318	java/util/ArrayList
    //   1005: dup
    //   1006: invokespecial 319	java/util/ArrayList:<init>	()V
    //   1009: putfield 322	com/tencent/mobileqq/vas/AvatarPendantShopSeriesInfo:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   1012: aload 7
    //   1014: ldc 115
    //   1016: invokevirtual 121	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   1019: astore 7
    //   1021: aload 7
    //   1023: arraylength
    //   1024: istore 17
    //   1026: iconst_0
    //   1027: istore 15
    //   1029: iload 15
    //   1031: iload 17
    //   1033: if_icmpge +57 -> 1090
    //   1036: aload 7
    //   1038: iload 15
    //   1040: aaload
    //   1041: astore 8
    //   1043: aload 8
    //   1045: invokestatic 65	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1048: ifne +321 -> 1369
    //   1051: aload 6
    //   1053: aload 8
    //   1055: invokestatic 127	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1058: invokevirtual 265	java/lang/Integer:intValue	()I
    //   1061: invokevirtual 323	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   1064: checkcast 222	com/tencent/mobileqq/vas/AvatarPendantShopItemInfo
    //   1067: astore 8
    //   1069: aload 8
    //   1071: ifnull +298 -> 1369
    //   1074: aload 5
    //   1076: getfield 322	com/tencent/mobileqq/vas/AvatarPendantShopSeriesInfo:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   1079: aload 8
    //   1081: invokeinterface 324 2 0
    //   1086: pop
    //   1087: goto +282 -> 1369
    //   1090: aload 5
    //   1092: getfield 322	com/tencent/mobileqq/vas/AvatarPendantShopSeriesInfo:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   1095: invokeinterface 327 1 0
    //   1100: ifle +260 -> 1360
    //   1103: aload 5
    //   1105: aload 4
    //   1107: ldc_w 313
    //   1110: invokevirtual 95	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   1113: putfield 328	com/tencent/mobileqq/vas/AvatarPendantShopSeriesInfo:jdField_a_of_type_Int	I
    //   1116: aload 5
    //   1118: aload 4
    //   1120: ldc_w 330
    //   1123: invokevirtual 113	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1126: putfield 331	com/tencent/mobileqq/vas/AvatarPendantShopSeriesInfo:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   1129: aload 4
    //   1131: ldc_w 333
    //   1134: invokevirtual 113	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1137: invokestatic 65	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1140: ifne +119 -> 1259
    //   1143: aload 5
    //   1145: aload 4
    //   1147: ldc_w 333
    //   1150: invokevirtual 113	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1153: invokestatic 127	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1156: invokevirtual 265	java/lang/Integer:intValue	()I
    //   1159: putfield 334	com/tencent/mobileqq/vas/AvatarPendantShopSeriesInfo:jdField_b_of_type_Int	I
    //   1162: aload 5
    //   1164: aload 4
    //   1166: ldc_w 272
    //   1169: invokevirtual 113	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1172: putfield 336	com/tencent/mobileqq/vas/AvatarPendantShopSeriesInfo:d	Ljava/lang/String;
    //   1175: aload 5
    //   1177: aload 4
    //   1179: ldc_w 338
    //   1182: invokevirtual 113	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1185: putfield 340	com/tencent/mobileqq/vas/AvatarPendantShopSeriesInfo:e	Ljava/lang/String;
    //   1188: aload 5
    //   1190: aload 4
    //   1192: ldc_w 342
    //   1195: invokevirtual 113	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1198: putfield 343	com/tencent/mobileqq/vas/AvatarPendantShopSeriesInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1201: aload 5
    //   1203: aload 4
    //   1205: ldc -2
    //   1207: invokevirtual 113	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1210: putfield 344	com/tencent/mobileqq/vas/AvatarPendantShopSeriesInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1213: aload 5
    //   1215: iconst_m1
    //   1216: putfield 345	com/tencent/mobileqq/vas/AvatarPendantShopSeriesInfo:jdField_c_of_type_Int	I
    //   1219: aload 5
    //   1221: getfield 340	com/tencent/mobileqq/vas/AvatarPendantShopSeriesInfo:e	Ljava/lang/String;
    //   1224: ifnull +23 -> 1247
    //   1227: aload 5
    //   1229: getfield 340	com/tencent/mobileqq/vas/AvatarPendantShopSeriesInfo:e	Ljava/lang/String;
    //   1232: ldc_w 347
    //   1235: invokevirtual 350	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1238: ifne +9 -> 1247
    //   1241: aload 5
    //   1243: iconst_1
    //   1244: putfield 351	com/tencent/mobileqq/vas/AvatarPendantShopSeriesInfo:jdField_a_of_type_Boolean	Z
    //   1247: aload_2
    //   1248: aload 5
    //   1250: invokeinterface 324 2 0
    //   1255: pop
    //   1256: goto +104 -> 1360
    //   1259: aload 5
    //   1261: iconst_0
    //   1262: putfield 334	com/tencent/mobileqq/vas/AvatarPendantShopSeriesInfo:jdField_b_of_type_Int	I
    //   1265: goto -103 -> 1162
    //   1268: aload_0
    //   1269: getfield 14	omx:jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity	Lcom/tencent/mobileqq/activity/pendant/AvatarPendantActivity;
    //   1272: getfield 354	com/tencent/mobileqq/activity/pendant/AvatarPendantActivity:a	Landroid/os/Handler;
    //   1275: sipush 1000
    //   1278: invokevirtual 360	android/os/Handler:sendEmptyMessage	(I)Z
    //   1281: pop
    //   1282: aload_0
    //   1283: getfield 14	omx:jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity	Lcom/tencent/mobileqq/activity/pendant/AvatarPendantActivity;
    //   1286: getfield 71	com/tencent/mobileqq/activity/pendant/AvatarPendantActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1289: invokevirtual 363	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1292: ldc_w 365
    //   1295: iconst_0
    //   1296: invokevirtual 371	com/tencent/qphone/base/util/BaseApplication:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   1299: invokeinterface 377 1 0
    //   1304: ldc_w 365
    //   1307: iconst_0
    //   1308: invokeinterface 383 3 0
    //   1313: invokeinterface 386 1 0
    //   1318: pop
    //   1319: aload_0
    //   1320: getfield 18	omx:jdField_a_of_type_Boolean	Z
    //   1323: ifeq -1063 -> 260
    //   1326: aload_0
    //   1327: getfield 14	omx:jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity	Lcom/tencent/mobileqq/activity/pendant/AvatarPendantActivity;
    //   1330: invokevirtual 388	com/tencent/mobileqq/activity/pendant/AvatarPendantActivity:e	()V
    //   1333: goto -1073 -> 260
    //   1336: iload 14
    //   1338: iconst_1
    //   1339: iadd
    //   1340: istore 14
    //   1342: goto -976 -> 366
    //   1345: iload 14
    //   1347: iconst_1
    //   1348: iadd
    //   1349: istore 14
    //   1351: goto -896 -> 455
    //   1354: iconst_0
    //   1355: istore 22
    //   1357: goto -621 -> 736
    //   1360: iload 14
    //   1362: iconst_1
    //   1363: iadd
    //   1364: istore 14
    //   1366: goto -437 -> 929
    //   1369: iload 15
    //   1371: iconst_1
    //   1372: iadd
    //   1373: istore 15
    //   1375: goto -346 -> 1029
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1378	0	this	omx
    //   16	12	1	localFile	java.io.File
    //   197	13	1	localOutOfMemoryError	OutOfMemoryError
    //   214	86	1	localIOException	java.io.IOException
    //   57	1191	2	localList	java.util.List
    //   31	64	3	localObject1	Object
    //   233	680	3	localException	Exception
    //   919	18	3	localJSONArray	org.json.JSONArray
    //   109	1095	4	localObject2	Object
    //   128	1132	5	localObject3	Object
    //   100	952	6	localObject4	Object
    //   167	870	7	localObject5	Object
    //   378	702	8	localObject6	Object
    //   513	22	9	localIterator	java.util.Iterator
    //   522	58	10	str	String
    //   544	353	11	localObject7	Object
    //   558	188	12	localJSONObject1	org.json.JSONObject
    //   567	80	13	localJSONObject2	org.json.JSONObject
    //   153	1212	14	i	int
    //   150	1224	15	j	int
    //   924	10	16	k	int
    //   1024	10	17	m	int
    //   3	286	18	l1	long
    //   263	542	20	l2	long
    //   87	1269	22	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   27	32	197	java/lang/OutOfMemoryError
    //   27	32	214	java/io/IOException
    //   58	86	233	java/lang/Exception
    //   89	94	233	java/lang/Exception
    //   94	152	233	java/lang/Exception
    //   169	188	233	java/lang/Exception
    //   226	230	233	java/lang/Exception
    //   313	363	233	java/lang/Exception
    //   380	399	233	java/lang/Exception
    //   402	452	233	java/lang/Exception
    //   469	488	233	java/lang/Exception
    //   491	524	233	java/lang/Exception
    //   524	546	233	java/lang/Exception
    //   551	733	233	java/lang/Exception
    //   736	779	233	java/lang/Exception
    //   779	822	233	java/lang/Exception
    //   822	845	233	java/lang/Exception
    //   845	857	233	java/lang/Exception
    //   860	883	233	java/lang/Exception
    //   886	903	233	java/lang/Exception
    //   906	926	233	java/lang/Exception
    //   936	957	233	java/lang/Exception
    //   960	1026	233	java/lang/Exception
    //   1043	1069	233	java/lang/Exception
    //   1074	1087	233	java/lang/Exception
    //   1090	1162	233	java/lang/Exception
    //   1162	1247	233	java/lang/Exception
    //   1247	1256	233	java/lang/Exception
    //   1259	1265	233	java/lang/Exception
    //   1268	1333	233	java/lang/Exception
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\omx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
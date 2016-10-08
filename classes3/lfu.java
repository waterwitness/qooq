import android.app.Activity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQProgressDialog;

public final class lfu
  implements Runnable
{
  public lfu(long paramLong, QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, Activity paramActivity, int paramInt, QQProgressDialog paramQQProgressDialog)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: iconst_0
    //   4: istore 9
    //   6: lconst_1
    //   7: aload_0
    //   8: getfield 20	lfu:jdField_a_of_type_Long	J
    //   11: lcmp
    //   12: ifne +553 -> 565
    //   15: invokestatic 54	com/tencent/mobileqq/util/SystemUtil:a	()Z
    //   18: ifeq +342 -> 360
    //   21: getstatic 59	com/tencent/mobileqq/app/AppConstants:bG	Ljava/lang/String;
    //   24: astore_1
    //   25: new 61	java/lang/StringBuilder
    //   28: dup
    //   29: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   32: aload_1
    //   33: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: ldc 68
    //   38: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   44: astore_1
    //   45: new 74	java/io/File
    //   48: dup
    //   49: aload_1
    //   50: invokespecial 77	java/io/File:<init>	(Ljava/lang/String;)V
    //   53: astore_2
    //   54: aload_2
    //   55: invokevirtual 80	java/io/File:exists	()Z
    //   58: ifeq +308 -> 366
    //   61: iconst_1
    //   62: istore 8
    //   64: iload 8
    //   66: ifne +689 -> 755
    //   69: ldc 82
    //   71: astore_2
    //   72: new 84	com/tencent/mobileqq/structmsg/AbsShareMsg$Builder
    //   75: dup
    //   76: ldc 86
    //   78: invokespecial 89	com/tencent/mobileqq/structmsg/AbsShareMsg$Builder:<init>	(Ljava/lang/Class;)V
    //   81: bipush 15
    //   83: invokevirtual 92	com/tencent/mobileqq/structmsg/AbsShareMsg$Builder:c	(I)Lcom/tencent/mobileqq/structmsg/AbsShareMsg$Builder;
    //   86: new 61	java/lang/StringBuilder
    //   89: dup
    //   90: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   93: ldc 94
    //   95: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: aload_0
    //   99: getfield 28	lfu:c	Ljava/lang/String;
    //   102: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   108: invokevirtual 97	com/tencent/mobileqq/structmsg/AbsShareMsg$Builder:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/structmsg/AbsShareMsg$Builder;
    //   111: aload_0
    //   112: getfield 30	lfu:d	Ljava/lang/String;
    //   115: invokevirtual 100	com/tencent/mobileqq/structmsg/AbsShareMsg$Builder:e	(Ljava/lang/String;)Lcom/tencent/mobileqq/structmsg/AbsShareMsg$Builder;
    //   118: invokevirtual 103	com/tencent/mobileqq/structmsg/AbsShareMsg$Builder:a	()Lcom/tencent/mobileqq/structmsg/AbsShareMsg;
    //   121: astore 5
    //   123: aload_0
    //   124: getfield 22	lfu:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   127: bipush 50
    //   129: invokevirtual 109	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   132: checkcast 111	com/tencent/mobileqq/app/FriendsManager
    //   135: astore 6
    //   137: aload_0
    //   138: getfield 22	lfu:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   141: bipush 52
    //   143: invokevirtual 109	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   146: checkcast 113	com/tencent/mobileqq/app/DiscussionManager
    //   149: astore 7
    //   151: aload 4
    //   153: astore_1
    //   154: aload 6
    //   156: ifnull +47 -> 203
    //   159: aload 7
    //   161: aload_0
    //   162: getfield 24	lfu:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   165: invokevirtual 116	com/tencent/mobileqq/app/DiscussionManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/DiscussionInfo;
    //   168: astore_3
    //   169: aload 4
    //   171: astore_1
    //   172: aload_3
    //   173: ifnull +30 -> 203
    //   176: aload 7
    //   178: aload_0
    //   179: getfield 24	lfu:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   182: aload_3
    //   183: getfield 121	com/tencent/mobileqq/data/DiscussionInfo:ownerUin	Ljava/lang/String;
    //   186: invokevirtual 124	com/tencent/mobileqq/app/DiscussionManager:a	(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/mobileqq/data/DiscussionMemberInfo;
    //   189: astore_1
    //   190: aload_1
    //   191: ifnull +487 -> 678
    //   194: aload_1
    //   195: aload_0
    //   196: getfield 22	lfu:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   199: invokestatic 129	com/tencent/mobileqq/utils/ContactUtils:a	(Lcom/tencent/mobileqq/data/DiscussionMemberInfo;Lcom/tencent/mobileqq/app/QQAppInterface;)Ljava/lang/String;
    //   202: astore_1
    //   203: aload_1
    //   204: astore_3
    //   205: aload_1
    //   206: invokestatic 135	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   209: ifeq +6 -> 215
    //   212: ldc -119
    //   214: astore_3
    //   215: new 139	com/tencent/mobileqq/structmsg/view/StructMsgItemLayoutDefault
    //   218: dup
    //   219: invokespecial 140	com/tencent/mobileqq/structmsg/view/StructMsgItemLayoutDefault:<init>	()V
    //   222: astore_1
    //   223: aload_1
    //   224: iconst_1
    //   225: invokevirtual 145	com/tencent/mobileqq/structmsg/AbsStructMsgItem:d	(I)V
    //   228: aload_1
    //   229: ldc -109
    //   231: invokevirtual 149	com/tencent/mobileqq/structmsg/AbsStructMsgItem:b	(Ljava/lang/String;)V
    //   234: iconst_2
    //   235: invokestatic 154	com/tencent/mobileqq/structmsg/StructMsgElementFactory:a	(I)Lcom/tencent/mobileqq/structmsg/AbsStructMsgItem;
    //   238: astore 4
    //   240: aload 4
    //   242: aload_2
    //   243: aload_0
    //   244: getfield 22	lfu:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   247: aload_0
    //   248: getfield 28	lfu:c	Ljava/lang/String;
    //   251: aload_0
    //   252: getfield 24	lfu:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   255: invokestatic 159	com/tencent/mobileqq/activity/aio/ForwardUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   258: new 61	java/lang/StringBuilder
    //   261: dup
    //   262: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   265: ldc -95
    //   267: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: aload_3
    //   271: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   277: iconst_1
    //   278: invokevirtual 164	com/tencent/mobileqq/structmsg/AbsStructMsgItem:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
    //   281: aload 5
    //   283: aload_1
    //   284: invokevirtual 170	com/tencent/mobileqq/structmsg/AbsShareMsg:addItem	(Lcom/tencent/mobileqq/structmsg/AbsStructMsgElement;)V
    //   287: aload 5
    //   289: aload 4
    //   291: invokevirtual 170	com/tencent/mobileqq/structmsg/AbsShareMsg:addItem	(Lcom/tencent/mobileqq/structmsg/AbsStructMsgElement;)V
    //   294: new 172	android/content/Intent
    //   297: dup
    //   298: invokespecial 173	android/content/Intent:<init>	()V
    //   301: astore_1
    //   302: aload_1
    //   303: ldc -81
    //   305: bipush -3
    //   307: invokevirtual 179	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   310: pop
    //   311: aload_1
    //   312: ldc -75
    //   314: aload 5
    //   316: invokevirtual 185	com/tencent/mobileqq/structmsg/AbsShareMsg:getBytes	()[B
    //   319: invokevirtual 188	android/content/Intent:putExtra	(Ljava/lang/String;[B)Landroid/content/Intent;
    //   322: pop
    //   323: aload_0
    //   324: getfield 32	lfu:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   327: aload_1
    //   328: aload_0
    //   329: getfield 34	lfu:jdField_a_of_type_Int	I
    //   332: invokestatic 193	com/tencent/mobileqq/forward/ForwardBaseOption:a	(Landroid/app/Activity;Landroid/content/Intent;I)V
    //   335: aload_0
    //   336: getfield 36	lfu:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   339: ifnull +20 -> 359
    //   342: aload_0
    //   343: getfield 36	lfu:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   346: invokevirtual 198	com/tencent/mobileqq/widget/QQProgressDialog:isShowing	()Z
    //   349: ifeq +10 -> 359
    //   352: aload_0
    //   353: getfield 36	lfu:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   356: invokevirtual 201	com/tencent/mobileqq/widget/QQProgressDialog:dismiss	()V
    //   359: return
    //   360: ldc -53
    //   362: astore_1
    //   363: goto -338 -> 25
    //   366: aload_2
    //   367: invokevirtual 206	java/io/File:createNewFile	()Z
    //   370: pop
    //   371: new 208	java/io/BufferedOutputStream
    //   374: dup
    //   375: new 210	java/io/FileOutputStream
    //   378: dup
    //   379: aload_2
    //   380: invokespecial 213	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   383: sipush 8192
    //   386: invokespecial 216	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   389: astore_3
    //   390: invokestatic 221	com/tencent/mobileqq/utils/ImageUtil:d	()Landroid/graphics/drawable/Drawable;
    //   393: checkcast 223	android/graphics/drawable/BitmapDrawable
    //   396: invokevirtual 227	android/graphics/drawable/BitmapDrawable:getBitmap	()Landroid/graphics/Bitmap;
    //   399: getstatic 233	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   402: bipush 100
    //   404: aload_3
    //   405: invokevirtual 239	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   408: istore 10
    //   410: iload 10
    //   412: ifeq +365 -> 777
    //   415: iconst_1
    //   416: istore 9
    //   418: aload_1
    //   419: astore_2
    //   420: aload_2
    //   421: astore_1
    //   422: iload 9
    //   424: istore 8
    //   426: aload_3
    //   427: ifnull -363 -> 64
    //   430: aload_3
    //   431: invokevirtual 244	java/io/OutputStream:close	()V
    //   434: aload_2
    //   435: astore_1
    //   436: iload 9
    //   438: istore 8
    //   440: goto -376 -> 64
    //   443: astore_3
    //   444: aload_2
    //   445: astore_1
    //   446: iload 9
    //   448: istore 8
    //   450: invokestatic 249	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   453: ifeq -389 -> 64
    //   456: ldc -5
    //   458: iconst_2
    //   459: aload_3
    //   460: invokevirtual 254	java/io/IOException:getMessage	()Ljava/lang/String;
    //   463: aload_3
    //   464: invokestatic 257	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   467: aload_2
    //   468: astore_1
    //   469: iload 9
    //   471: istore 8
    //   473: goto -409 -> 64
    //   476: astore_2
    //   477: aconst_null
    //   478: astore_1
    //   479: invokestatic 249	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   482: ifeq +7 -> 489
    //   485: aload_2
    //   486: invokevirtual 260	java/io/IOException:printStackTrace	()V
    //   489: aload_1
    //   490: ifnull +279 -> 769
    //   493: aload_1
    //   494: invokevirtual 244	java/io/OutputStream:close	()V
    //   497: aconst_null
    //   498: astore_1
    //   499: iconst_0
    //   500: istore 8
    //   502: goto -438 -> 64
    //   505: astore_1
    //   506: invokestatic 249	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   509: ifeq +14 -> 523
    //   512: ldc -5
    //   514: iconst_2
    //   515: aload_1
    //   516: invokevirtual 254	java/io/IOException:getMessage	()Ljava/lang/String;
    //   519: aload_1
    //   520: invokestatic 257	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   523: aconst_null
    //   524: astore_1
    //   525: iconst_0
    //   526: istore 8
    //   528: goto -464 -> 64
    //   531: astore_1
    //   532: aconst_null
    //   533: astore_2
    //   534: aload_2
    //   535: ifnull +7 -> 542
    //   538: aload_2
    //   539: invokevirtual 244	java/io/OutputStream:close	()V
    //   542: aload_1
    //   543: athrow
    //   544: astore_2
    //   545: invokestatic 249	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   548: ifeq -6 -> 542
    //   551: ldc -5
    //   553: iconst_2
    //   554: aload_2
    //   555: invokevirtual 254	java/io/IOException:getMessage	()Ljava/lang/String;
    //   558: aload_2
    //   559: invokestatic 257	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   562: goto -20 -> 542
    //   565: new 262	java/util/ArrayList
    //   568: dup
    //   569: invokespecial 263	java/util/ArrayList:<init>	()V
    //   572: astore_1
    //   573: aload_1
    //   574: aload_0
    //   575: getfield 22	lfu:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   578: bipush 101
    //   580: aload_0
    //   581: getfield 24	lfu:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   584: iconst_0
    //   585: invokevirtual 266	com/tencent/mobileqq/app/QQAppInterface:a	(ILjava/lang/String;I)Ljava/lang/String;
    //   588: invokevirtual 270	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   591: pop
    //   592: aload_1
    //   593: aload_0
    //   594: getfield 22	lfu:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   597: invokevirtual 272	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   600: aload_0
    //   601: getfield 26	lfu:b	Ljava/lang/String;
    //   604: ldc_w 274
    //   607: invokestatic 279	cooperation/qzone/QZoneShareManager:a	(Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/ArrayList;
    //   610: astore_1
    //   611: aload_1
    //   612: ifnull +148 -> 760
    //   615: aload_1
    //   616: invokevirtual 283	java/util/ArrayList:size	()I
    //   619: ifle +141 -> 760
    //   622: aload_1
    //   623: iconst_0
    //   624: invokevirtual 287	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   627: checkcast 289	java/lang/String
    //   630: astore_2
    //   631: aload_2
    //   632: astore_1
    //   633: iload 9
    //   635: istore 8
    //   637: aload_2
    //   638: invokestatic 135	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   641: ifne -577 -> 64
    //   644: aload_2
    //   645: ldc_w 291
    //   648: invokevirtual 295	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   651: ifne +19 -> 670
    //   654: aload_2
    //   655: astore_1
    //   656: iload 9
    //   658: istore 8
    //   660: aload_2
    //   661: ldc_w 297
    //   664: invokevirtual 295	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   667: ifeq -603 -> 64
    //   670: iconst_1
    //   671: istore 8
    //   673: aload_2
    //   674: astore_1
    //   675: goto -611 -> 64
    //   678: aload 6
    //   680: aload_3
    //   681: getfield 121	com/tencent/mobileqq/data/DiscussionInfo:ownerUin	Ljava/lang/String;
    //   684: invokevirtual 299	com/tencent/mobileqq/app/FriendsManager:b	(Ljava/lang/String;)Z
    //   687: ifeq +18 -> 705
    //   690: aload_0
    //   691: getfield 22	lfu:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   694: aload_3
    //   695: getfield 121	com/tencent/mobileqq/data/DiscussionInfo:ownerUin	Ljava/lang/String;
    //   698: invokestatic 303	com/tencent/mobileqq/utils/ContactUtils:k	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)Ljava/lang/String;
    //   701: astore_1
    //   702: goto -499 -> 203
    //   705: aload 6
    //   707: aload_3
    //   708: getfield 121	com/tencent/mobileqq/data/DiscussionInfo:ownerUin	Ljava/lang/String;
    //   711: invokevirtual 306	com/tencent/mobileqq/app/FriendsManager:c	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Friends;
    //   714: astore_1
    //   715: aload_1
    //   716: ifnull +11 -> 727
    //   719: aload_1
    //   720: getfield 311	com/tencent/mobileqq/data/Friends:name	Ljava/lang/String;
    //   723: astore_1
    //   724: goto -521 -> 203
    //   727: aload_3
    //   728: getfield 121	com/tencent/mobileqq/data/DiscussionInfo:ownerUin	Ljava/lang/String;
    //   731: astore_1
    //   732: goto -529 -> 203
    //   735: astore_1
    //   736: aload_3
    //   737: astore_2
    //   738: goto -204 -> 534
    //   741: astore_3
    //   742: aload_1
    //   743: astore_2
    //   744: aload_3
    //   745: astore_1
    //   746: goto -212 -> 534
    //   749: astore_2
    //   750: aload_3
    //   751: astore_1
    //   752: goto -273 -> 479
    //   755: aload_1
    //   756: astore_2
    //   757: goto -685 -> 72
    //   760: aconst_null
    //   761: astore_1
    //   762: iload 9
    //   764: istore 8
    //   766: goto -702 -> 64
    //   769: aconst_null
    //   770: astore_1
    //   771: iconst_0
    //   772: istore 8
    //   774: goto -710 -> 64
    //   777: aconst_null
    //   778: astore_2
    //   779: iconst_0
    //   780: istore 9
    //   782: goto -362 -> 420
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	785	0	this	lfu
    //   24	475	1	localObject1	Object
    //   505	15	1	localIOException1	java.io.IOException
    //   524	1	1	localObject2	Object
    //   531	12	1	localObject3	Object
    //   572	160	1	localObject4	Object
    //   735	8	1	localObject5	Object
    //   745	26	1	localObject6	Object
    //   53	415	2	localObject7	Object
    //   476	10	2	localIOException2	java.io.IOException
    //   533	6	2	localObject8	Object
    //   544	15	2	localIOException3	java.io.IOException
    //   630	114	2	localObject9	Object
    //   749	1	2	localIOException4	java.io.IOException
    //   756	23	2	localObject10	Object
    //   168	263	3	localObject11	Object
    //   443	294	3	localIOException5	java.io.IOException
    //   741	10	3	localObject12	Object
    //   1	289	4	localAbsStructMsgItem	com.tencent.mobileqq.structmsg.AbsStructMsgItem
    //   121	194	5	localAbsShareMsg	com.tencent.mobileqq.structmsg.AbsShareMsg
    //   135	571	6	localFriendsManager	com.tencent.mobileqq.app.FriendsManager
    //   149	28	7	localDiscussionManager	com.tencent.mobileqq.app.DiscussionManager
    //   62	711	8	i	int
    //   4	777	9	j	int
    //   408	3	10	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   430	434	443	java/io/IOException
    //   366	390	476	java/io/IOException
    //   493	497	505	java/io/IOException
    //   366	390	531	finally
    //   538	542	544	java/io/IOException
    //   390	410	735	finally
    //   479	489	741	finally
    //   390	410	749	java/io/IOException
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lfu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
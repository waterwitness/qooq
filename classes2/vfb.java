import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.activity.NearbyTroopsView;

public class vfb
  implements Runnable
{
  public vfb(NearbyTroopsView paramNearbyTroopsView, String paramString, long paramLong)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aconst_null
    //   3: astore_2
    //   4: aload_2
    //   5: astore 4
    //   7: aload_1
    //   8: astore_3
    //   9: aload_0
    //   10: getfield 14	vfb:jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView	Lcom/tencent/mobileqq/troop/activity/NearbyTroopsView;
    //   13: invokevirtual 40	com/tencent/mobileqq/troop/activity/NearbyTroopsView:a	()Landroid/app/Activity;
    //   16: invokevirtual 46	android/app/Activity:isFinishing	()Z
    //   19: istore 10
    //   21: iload 10
    //   23: ifeq +22 -> 45
    //   26: iconst_0
    //   27: ifeq +11 -> 38
    //   30: new 48	java/lang/NullPointerException
    //   33: dup
    //   34: invokespecial 49	java/lang/NullPointerException:<init>	()V
    //   37: athrow
    //   38: return
    //   39: astore_1
    //   40: aload_1
    //   41: invokevirtual 52	java/io/IOException:printStackTrace	()V
    //   44: return
    //   45: aload_2
    //   46: astore 4
    //   48: aload_1
    //   49: astore_3
    //   50: new 54	java/net/URL
    //   53: dup
    //   54: aload_0
    //   55: getfield 16	vfb:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   58: invokespecial 57	java/net/URL:<init>	(Ljava/lang/String;)V
    //   61: invokevirtual 61	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   64: astore 6
    //   66: aload_2
    //   67: astore 4
    //   69: aload_1
    //   70: astore_3
    //   71: aload 6
    //   73: ldc 63
    //   75: ldc 65
    //   77: invokevirtual 71	java/net/URLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   80: aload_2
    //   81: astore 4
    //   83: aload_1
    //   84: astore_3
    //   85: aload 6
    //   87: invokevirtual 75	java/net/URLConnection:getLastModified	()J
    //   90: lstore 8
    //   92: aload_2
    //   93: astore 4
    //   95: aload_1
    //   96: astore_3
    //   97: aload 6
    //   99: invokevirtual 79	java/net/URLConnection:getContentEncoding	()Ljava/lang/String;
    //   102: astore 5
    //   104: aload_2
    //   105: astore 4
    //   107: aload_1
    //   108: astore_3
    //   109: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   112: ifeq +84 -> 196
    //   115: aload_2
    //   116: astore 4
    //   118: aload_1
    //   119: astore_3
    //   120: ldc 86
    //   122: iconst_2
    //   123: new 88	java/lang/StringBuilder
    //   126: dup
    //   127: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   130: ldc 91
    //   132: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: lload 8
    //   137: invokevirtual 98	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   140: ldc 100
    //   142: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: aload_0
    //   146: getfield 18	vfb:jdField_a_of_type_Long	J
    //   149: invokevirtual 98	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   152: ldc 102
    //   154: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: aload 5
    //   159: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: ldc 104
    //   164: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: aload 6
    //   169: invokevirtual 108	java/net/URLConnection:getContentLength	()I
    //   172: invokevirtual 111	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   175: ldc 113
    //   177: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: aload_0
    //   181: getfield 14	vfb:jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView	Lcom/tencent/mobileqq/troop/activity/NearbyTroopsView;
    //   184: getfield 116	com/tencent/mobileqq/troop/activity/NearbyTroopsView:d	Z
    //   187: invokevirtual 119	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   190: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   193: invokestatic 125	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   196: aload_2
    //   197: astore 4
    //   199: aload_1
    //   200: astore_3
    //   201: lload 8
    //   203: aload_0
    //   204: getfield 18	vfb:jdField_a_of_type_Long	J
    //   207: lcmp
    //   208: ifgt +135 -> 343
    //   211: aload_2
    //   212: astore 4
    //   214: aload_1
    //   215: astore_3
    //   216: aload_0
    //   217: getfield 14	vfb:jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView	Lcom/tencent/mobileqq/troop/activity/NearbyTroopsView;
    //   220: getfield 116	com/tencent/mobileqq/troop/activity/NearbyTroopsView:d	Z
    //   223: ifeq +120 -> 343
    //   226: aload_2
    //   227: astore 4
    //   229: aload_1
    //   230: astore_3
    //   231: aload_0
    //   232: getfield 14	vfb:jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView	Lcom/tencent/mobileqq/troop/activity/NearbyTroopsView;
    //   235: getfield 128	com/tencent/mobileqq/troop/activity/NearbyTroopsView:a	Lcom/tencent/mobileqq/troop/activity/NearbyTroopsView$UIHandler;
    //   238: ifnull +25 -> 263
    //   241: aload_2
    //   242: astore 4
    //   244: aload_1
    //   245: astore_3
    //   246: aload_0
    //   247: getfield 14	vfb:jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView	Lcom/tencent/mobileqq/troop/activity/NearbyTroopsView;
    //   250: invokevirtual 40	com/tencent/mobileqq/troop/activity/NearbyTroopsView:a	()Landroid/app/Activity;
    //   253: invokevirtual 46	android/app/Activity:isFinishing	()Z
    //   256: istore 10
    //   258: iload 10
    //   260: ifeq +21 -> 281
    //   263: iconst_0
    //   264: ifeq -226 -> 38
    //   267: new 48	java/lang/NullPointerException
    //   270: dup
    //   271: invokespecial 49	java/lang/NullPointerException:<init>	()V
    //   274: athrow
    //   275: astore_1
    //   276: aload_1
    //   277: invokevirtual 52	java/io/IOException:printStackTrace	()V
    //   280: return
    //   281: aload_2
    //   282: astore 4
    //   284: aload_1
    //   285: astore_3
    //   286: aload_0
    //   287: getfield 14	vfb:jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView	Lcom/tencent/mobileqq/troop/activity/NearbyTroopsView;
    //   290: getfield 128	com/tencent/mobileqq/troop/activity/NearbyTroopsView:a	Lcom/tencent/mobileqq/troop/activity/NearbyTroopsView$UIHandler;
    //   293: invokestatic 134	android/os/Message:obtain	(Landroid/os/Handler;)Landroid/os/Message;
    //   296: astore 5
    //   298: aload 5
    //   300: ifnull +25 -> 325
    //   303: aload_2
    //   304: astore 4
    //   306: aload_1
    //   307: astore_3
    //   308: aload 5
    //   310: bipush 9
    //   312: putfield 138	android/os/Message:what	I
    //   315: aload_2
    //   316: astore 4
    //   318: aload_1
    //   319: astore_3
    //   320: aload 5
    //   322: invokevirtual 141	android/os/Message:sendToTarget	()V
    //   325: iconst_0
    //   326: ifeq -288 -> 38
    //   329: new 48	java/lang/NullPointerException
    //   332: dup
    //   333: invokespecial 49	java/lang/NullPointerException:<init>	()V
    //   336: athrow
    //   337: astore_1
    //   338: aload_1
    //   339: invokevirtual 52	java/io/IOException:printStackTrace	()V
    //   342: return
    //   343: aload_2
    //   344: astore 4
    //   346: aload_1
    //   347: astore_3
    //   348: aload_0
    //   349: getfield 14	vfb:jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView	Lcom/tencent/mobileqq/troop/activity/NearbyTroopsView;
    //   352: invokevirtual 40	com/tencent/mobileqq/troop/activity/NearbyTroopsView:a	()Landroid/app/Activity;
    //   355: invokevirtual 46	android/app/Activity:isFinishing	()Z
    //   358: istore 10
    //   360: iload 10
    //   362: ifeq +21 -> 383
    //   365: iconst_0
    //   366: ifeq -328 -> 38
    //   369: new 48	java/lang/NullPointerException
    //   372: dup
    //   373: invokespecial 49	java/lang/NullPointerException:<init>	()V
    //   376: athrow
    //   377: astore_1
    //   378: aload_1
    //   379: invokevirtual 52	java/io/IOException:printStackTrace	()V
    //   382: return
    //   383: aload_2
    //   384: astore 4
    //   386: aload_1
    //   387: astore_3
    //   388: aload 5
    //   390: invokestatic 147	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   393: ifne +117 -> 510
    //   396: aload_2
    //   397: astore 4
    //   399: aload_1
    //   400: astore_3
    //   401: aload 5
    //   403: invokevirtual 152	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   406: ldc -102
    //   408: invokevirtual 157	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   411: ifeq +99 -> 510
    //   414: aload_2
    //   415: astore 4
    //   417: aload_1
    //   418: astore_3
    //   419: new 159	java/util/zip/GZIPInputStream
    //   422: dup
    //   423: aload 6
    //   425: invokevirtual 163	java/net/URLConnection:getInputStream	()Ljava/io/InputStream;
    //   428: invokespecial 166	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   431: astore_1
    //   432: aload_1
    //   433: astore 4
    //   435: aload_1
    //   436: astore_3
    //   437: aload_1
    //   438: astore_2
    //   439: new 168	org/json/JSONObject
    //   442: dup
    //   443: new 170	java/io/BufferedReader
    //   446: dup
    //   447: new 172	java/io/InputStreamReader
    //   450: dup
    //   451: aload_1
    //   452: ldc -82
    //   454: invokestatic 180	java/nio/charset/Charset:forName	(Ljava/lang/String;)Ljava/nio/charset/Charset;
    //   457: invokespecial 183	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/nio/charset/Charset;)V
    //   460: invokespecial 186	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   463: invokestatic 189	com/tencent/mobileqq/troop/activity/NearbyTroopsView:a	(Ljava/io/Reader;)Ljava/lang/String;
    //   466: invokespecial 190	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   469: astore 5
    //   471: aload_1
    //   472: astore 4
    //   474: aload_1
    //   475: astore_3
    //   476: aload_1
    //   477: astore_2
    //   478: aload_0
    //   479: getfield 14	vfb:jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView	Lcom/tencent/mobileqq/troop/activity/NearbyTroopsView;
    //   482: invokevirtual 40	com/tencent/mobileqq/troop/activity/NearbyTroopsView:a	()Landroid/app/Activity;
    //   485: invokevirtual 46	android/app/Activity:isFinishing	()Z
    //   488: istore 10
    //   490: iload 10
    //   492: ifeq +32 -> 524
    //   495: aload_1
    //   496: ifnull -458 -> 38
    //   499: aload_1
    //   500: invokevirtual 195	java/io/InputStream:close	()V
    //   503: return
    //   504: astore_1
    //   505: aload_1
    //   506: invokevirtual 52	java/io/IOException:printStackTrace	()V
    //   509: return
    //   510: aload_2
    //   511: astore 4
    //   513: aload_1
    //   514: astore_3
    //   515: aload 6
    //   517: invokevirtual 163	java/net/URLConnection:getInputStream	()Ljava/io/InputStream;
    //   520: astore_1
    //   521: goto -89 -> 432
    //   524: aload_1
    //   525: astore 4
    //   527: aload_1
    //   528: astore_3
    //   529: aload_1
    //   530: astore_2
    //   531: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   534: ifeq +39 -> 573
    //   537: aload_1
    //   538: astore 4
    //   540: aload_1
    //   541: astore_3
    //   542: aload_1
    //   543: astore_2
    //   544: ldc 86
    //   546: iconst_2
    //   547: new 88	java/lang/StringBuilder
    //   550: dup
    //   551: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   554: ldc -59
    //   556: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   559: aload 5
    //   561: invokevirtual 198	org/json/JSONObject:toString	()Ljava/lang/String;
    //   564: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   567: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   570: invokestatic 125	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   573: aload_1
    //   574: astore 4
    //   576: aload_1
    //   577: astore_3
    //   578: aload_1
    //   579: astore_2
    //   580: aload_0
    //   581: getfield 14	vfb:jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView	Lcom/tencent/mobileqq/troop/activity/NearbyTroopsView;
    //   584: getfield 128	com/tencent/mobileqq/troop/activity/NearbyTroopsView:a	Lcom/tencent/mobileqq/troop/activity/NearbyTroopsView$UIHandler;
    //   587: ifnull +27 -> 614
    //   590: aload_1
    //   591: astore 4
    //   593: aload_1
    //   594: astore_3
    //   595: aload_1
    //   596: astore_2
    //   597: aload_0
    //   598: getfield 14	vfb:jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView	Lcom/tencent/mobileqq/troop/activity/NearbyTroopsView;
    //   601: invokevirtual 40	com/tencent/mobileqq/troop/activity/NearbyTroopsView:a	()Landroid/app/Activity;
    //   604: invokevirtual 46	android/app/Activity:isFinishing	()Z
    //   607: istore 10
    //   609: iload 10
    //   611: ifeq +18 -> 629
    //   614: aload_1
    //   615: ifnull -577 -> 38
    //   618: aload_1
    //   619: invokevirtual 195	java/io/InputStream:close	()V
    //   622: return
    //   623: astore_1
    //   624: aload_1
    //   625: invokevirtual 52	java/io/IOException:printStackTrace	()V
    //   628: return
    //   629: aload_1
    //   630: astore 4
    //   632: aload_1
    //   633: astore_3
    //   634: aload_1
    //   635: astore_2
    //   636: aload_0
    //   637: getfield 14	vfb:jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView	Lcom/tencent/mobileqq/troop/activity/NearbyTroopsView;
    //   640: getfield 128	com/tencent/mobileqq/troop/activity/NearbyTroopsView:a	Lcom/tencent/mobileqq/troop/activity/NearbyTroopsView$UIHandler;
    //   643: invokestatic 134	android/os/Message:obtain	(Landroid/os/Handler;)Landroid/os/Message;
    //   646: astore 6
    //   648: aload 6
    //   650: ifnull +94 -> 744
    //   653: aload_1
    //   654: astore 4
    //   656: aload_1
    //   657: astore_3
    //   658: aload_1
    //   659: astore_2
    //   660: new 200	android/os/Bundle
    //   663: dup
    //   664: invokespecial 201	android/os/Bundle:<init>	()V
    //   667: astore 7
    //   669: aload_1
    //   670: astore 4
    //   672: aload_1
    //   673: astore_3
    //   674: aload_1
    //   675: astore_2
    //   676: aload 7
    //   678: ldc -53
    //   680: aload 5
    //   682: invokevirtual 198	org/json/JSONObject:toString	()Ljava/lang/String;
    //   685: invokevirtual 206	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   688: aload_1
    //   689: astore 4
    //   691: aload_1
    //   692: astore_3
    //   693: aload_1
    //   694: astore_2
    //   695: aload 7
    //   697: ldc -48
    //   699: lload 8
    //   701: invokevirtual 212	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   704: aload_1
    //   705: astore 4
    //   707: aload_1
    //   708: astore_3
    //   709: aload_1
    //   710: astore_2
    //   711: aload 6
    //   713: aload 7
    //   715: invokevirtual 216	android/os/Message:setData	(Landroid/os/Bundle;)V
    //   718: aload_1
    //   719: astore 4
    //   721: aload_1
    //   722: astore_3
    //   723: aload_1
    //   724: astore_2
    //   725: aload 6
    //   727: bipush 8
    //   729: putfield 138	android/os/Message:what	I
    //   732: aload_1
    //   733: astore 4
    //   735: aload_1
    //   736: astore_3
    //   737: aload_1
    //   738: astore_2
    //   739: aload 6
    //   741: invokevirtual 141	android/os/Message:sendToTarget	()V
    //   744: aload_1
    //   745: ifnull -707 -> 38
    //   748: aload_1
    //   749: invokevirtual 195	java/io/InputStream:close	()V
    //   752: return
    //   753: astore_1
    //   754: aload_1
    //   755: invokevirtual 52	java/io/IOException:printStackTrace	()V
    //   758: return
    //   759: astore_1
    //   760: aload 4
    //   762: astore_2
    //   763: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   766: ifeq +14 -> 780
    //   769: aload 4
    //   771: astore_2
    //   772: ldc 86
    //   774: iconst_2
    //   775: ldc -38
    //   777: invokestatic 221	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   780: aload 4
    //   782: ifnull +8 -> 790
    //   785: aload 4
    //   787: invokevirtual 195	java/io/InputStream:close	()V
    //   790: aload_0
    //   791: getfield 14	vfb:jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView	Lcom/tencent/mobileqq/troop/activity/NearbyTroopsView;
    //   794: getfield 128	com/tencent/mobileqq/troop/activity/NearbyTroopsView:a	Lcom/tencent/mobileqq/troop/activity/NearbyTroopsView$UIHandler;
    //   797: ifnull -759 -> 38
    //   800: aload_0
    //   801: getfield 14	vfb:jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView	Lcom/tencent/mobileqq/troop/activity/NearbyTroopsView;
    //   804: invokevirtual 40	com/tencent/mobileqq/troop/activity/NearbyTroopsView:a	()Landroid/app/Activity;
    //   807: invokevirtual 46	android/app/Activity:isFinishing	()Z
    //   810: ifne -772 -> 38
    //   813: aload_0
    //   814: getfield 14	vfb:jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView	Lcom/tencent/mobileqq/troop/activity/NearbyTroopsView;
    //   817: getfield 128	com/tencent/mobileqq/troop/activity/NearbyTroopsView:a	Lcom/tencent/mobileqq/troop/activity/NearbyTroopsView$UIHandler;
    //   820: invokestatic 134	android/os/Message:obtain	(Landroid/os/Handler;)Landroid/os/Message;
    //   823: astore_1
    //   824: aload_1
    //   825: ifnull -787 -> 38
    //   828: aload_1
    //   829: bipush 9
    //   831: putfield 138	android/os/Message:what	I
    //   834: aload_1
    //   835: invokevirtual 141	android/os/Message:sendToTarget	()V
    //   838: return
    //   839: astore_1
    //   840: aload_1
    //   841: invokevirtual 52	java/io/IOException:printStackTrace	()V
    //   844: goto -54 -> 790
    //   847: astore_1
    //   848: aload_3
    //   849: astore_2
    //   850: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   853: ifeq +13 -> 866
    //   856: aload_3
    //   857: astore_2
    //   858: ldc 86
    //   860: iconst_2
    //   861: ldc -33
    //   863: invokestatic 221	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   866: aload_3
    //   867: ifnull -77 -> 790
    //   870: aload_3
    //   871: invokevirtual 195	java/io/InputStream:close	()V
    //   874: goto -84 -> 790
    //   877: astore_1
    //   878: aload_1
    //   879: invokevirtual 52	java/io/IOException:printStackTrace	()V
    //   882: goto -92 -> 790
    //   885: astore_3
    //   886: aconst_null
    //   887: astore_2
    //   888: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   891: ifeq +31 -> 922
    //   894: ldc 86
    //   896: iconst_2
    //   897: new 88	java/lang/StringBuilder
    //   900: dup
    //   901: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   904: ldc -31
    //   906: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   909: aload_3
    //   910: invokevirtual 226	java/lang/Exception:toString	()Ljava/lang/String;
    //   913: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   916: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   919: invokestatic 221	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   922: aload_2
    //   923: ifnull -133 -> 790
    //   926: aload_2
    //   927: invokevirtual 195	java/io/InputStream:close	()V
    //   930: goto -140 -> 790
    //   933: astore_1
    //   934: aload_1
    //   935: invokevirtual 52	java/io/IOException:printStackTrace	()V
    //   938: goto -148 -> 790
    //   941: astore_1
    //   942: aconst_null
    //   943: astore_2
    //   944: aload_2
    //   945: ifnull +7 -> 952
    //   948: aload_2
    //   949: invokevirtual 195	java/io/InputStream:close	()V
    //   952: aload_1
    //   953: athrow
    //   954: astore_2
    //   955: aload_2
    //   956: invokevirtual 52	java/io/IOException:printStackTrace	()V
    //   959: goto -7 -> 952
    //   962: astore_1
    //   963: goto -19 -> 944
    //   966: astore_1
    //   967: goto -23 -> 944
    //   970: astore_3
    //   971: aload_1
    //   972: astore_2
    //   973: goto -85 -> 888
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	976	0	this	vfb
    //   1	7	1	localObject1	Object
    //   39	206	1	localIOException1	java.io.IOException
    //   275	44	1	localIOException2	java.io.IOException
    //   337	10	1	localIOException3	java.io.IOException
    //   377	41	1	localIOException4	java.io.IOException
    //   431	69	1	localGZIPInputStream	java.util.zip.GZIPInputStream
    //   504	10	1	localIOException5	java.io.IOException
    //   520	99	1	localInputStream	java.io.InputStream
    //   623	126	1	localIOException6	java.io.IOException
    //   753	2	1	localIOException7	java.io.IOException
    //   759	1	1	localJSONException	org.json.JSONException
    //   823	12	1	localMessage	android.os.Message
    //   839	2	1	localIOException8	java.io.IOException
    //   847	1	1	localIOException9	java.io.IOException
    //   877	2	1	localIOException10	java.io.IOException
    //   933	2	1	localIOException11	java.io.IOException
    //   941	12	1	localObject2	Object
    //   962	1	1	localObject3	Object
    //   966	6	1	localObject4	Object
    //   3	946	2	localObject5	Object
    //   954	2	2	localIOException12	java.io.IOException
    //   972	1	2	localObject6	Object
    //   8	863	3	localObject7	Object
    //   885	25	3	localException1	Exception
    //   970	1	3	localException2	Exception
    //   5	781	4	localObject8	Object
    //   102	579	5	localObject9	Object
    //   64	676	6	localObject10	Object
    //   667	47	7	localBundle	android.os.Bundle
    //   90	610	8	l	long
    //   19	591	10	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   30	38	39	java/io/IOException
    //   267	275	275	java/io/IOException
    //   329	337	337	java/io/IOException
    //   369	377	377	java/io/IOException
    //   499	503	504	java/io/IOException
    //   618	622	623	java/io/IOException
    //   748	752	753	java/io/IOException
    //   9	21	759	org/json/JSONException
    //   50	66	759	org/json/JSONException
    //   71	80	759	org/json/JSONException
    //   85	92	759	org/json/JSONException
    //   97	104	759	org/json/JSONException
    //   109	115	759	org/json/JSONException
    //   120	196	759	org/json/JSONException
    //   201	211	759	org/json/JSONException
    //   216	226	759	org/json/JSONException
    //   231	241	759	org/json/JSONException
    //   246	258	759	org/json/JSONException
    //   286	298	759	org/json/JSONException
    //   308	315	759	org/json/JSONException
    //   320	325	759	org/json/JSONException
    //   348	360	759	org/json/JSONException
    //   388	396	759	org/json/JSONException
    //   401	414	759	org/json/JSONException
    //   419	432	759	org/json/JSONException
    //   439	471	759	org/json/JSONException
    //   478	490	759	org/json/JSONException
    //   515	521	759	org/json/JSONException
    //   531	537	759	org/json/JSONException
    //   544	573	759	org/json/JSONException
    //   580	590	759	org/json/JSONException
    //   597	609	759	org/json/JSONException
    //   636	648	759	org/json/JSONException
    //   660	669	759	org/json/JSONException
    //   676	688	759	org/json/JSONException
    //   695	704	759	org/json/JSONException
    //   711	718	759	org/json/JSONException
    //   725	732	759	org/json/JSONException
    //   739	744	759	org/json/JSONException
    //   785	790	839	java/io/IOException
    //   9	21	847	java/io/IOException
    //   50	66	847	java/io/IOException
    //   71	80	847	java/io/IOException
    //   85	92	847	java/io/IOException
    //   97	104	847	java/io/IOException
    //   109	115	847	java/io/IOException
    //   120	196	847	java/io/IOException
    //   201	211	847	java/io/IOException
    //   216	226	847	java/io/IOException
    //   231	241	847	java/io/IOException
    //   246	258	847	java/io/IOException
    //   286	298	847	java/io/IOException
    //   308	315	847	java/io/IOException
    //   320	325	847	java/io/IOException
    //   348	360	847	java/io/IOException
    //   388	396	847	java/io/IOException
    //   401	414	847	java/io/IOException
    //   419	432	847	java/io/IOException
    //   439	471	847	java/io/IOException
    //   478	490	847	java/io/IOException
    //   515	521	847	java/io/IOException
    //   531	537	847	java/io/IOException
    //   544	573	847	java/io/IOException
    //   580	590	847	java/io/IOException
    //   597	609	847	java/io/IOException
    //   636	648	847	java/io/IOException
    //   660	669	847	java/io/IOException
    //   676	688	847	java/io/IOException
    //   695	704	847	java/io/IOException
    //   711	718	847	java/io/IOException
    //   725	732	847	java/io/IOException
    //   739	744	847	java/io/IOException
    //   870	874	877	java/io/IOException
    //   9	21	885	java/lang/Exception
    //   50	66	885	java/lang/Exception
    //   71	80	885	java/lang/Exception
    //   85	92	885	java/lang/Exception
    //   97	104	885	java/lang/Exception
    //   109	115	885	java/lang/Exception
    //   120	196	885	java/lang/Exception
    //   201	211	885	java/lang/Exception
    //   216	226	885	java/lang/Exception
    //   231	241	885	java/lang/Exception
    //   246	258	885	java/lang/Exception
    //   286	298	885	java/lang/Exception
    //   308	315	885	java/lang/Exception
    //   320	325	885	java/lang/Exception
    //   348	360	885	java/lang/Exception
    //   388	396	885	java/lang/Exception
    //   401	414	885	java/lang/Exception
    //   419	432	885	java/lang/Exception
    //   515	521	885	java/lang/Exception
    //   926	930	933	java/io/IOException
    //   9	21	941	finally
    //   50	66	941	finally
    //   71	80	941	finally
    //   85	92	941	finally
    //   97	104	941	finally
    //   109	115	941	finally
    //   120	196	941	finally
    //   201	211	941	finally
    //   216	226	941	finally
    //   231	241	941	finally
    //   246	258	941	finally
    //   286	298	941	finally
    //   308	315	941	finally
    //   320	325	941	finally
    //   348	360	941	finally
    //   388	396	941	finally
    //   401	414	941	finally
    //   419	432	941	finally
    //   515	521	941	finally
    //   948	952	954	java/io/IOException
    //   439	471	962	finally
    //   478	490	962	finally
    //   531	537	962	finally
    //   544	573	962	finally
    //   580	590	962	finally
    //   597	609	962	finally
    //   636	648	962	finally
    //   660	669	962	finally
    //   676	688	962	finally
    //   695	704	962	finally
    //   711	718	962	finally
    //   725	732	962	finally
    //   739	744	962	finally
    //   763	769	962	finally
    //   772	780	962	finally
    //   850	856	962	finally
    //   858	866	962	finally
    //   888	922	966	finally
    //   439	471	970	java/lang/Exception
    //   478	490	970	java/lang/Exception
    //   531	537	970	java/lang/Exception
    //   544	573	970	java/lang/Exception
    //   580	590	970	java/lang/Exception
    //   597	609	970	java/lang/Exception
    //   636	648	970	java/lang/Exception
    //   660	669	970	java/lang/Exception
    //   676	688	970	java/lang/Exception
    //   695	704	970	java/lang/Exception
    //   711	718	970	java/lang/Exception
    //   725	732	970	java/lang/Exception
    //   739	744	970	java/lang/Exception
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vfb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
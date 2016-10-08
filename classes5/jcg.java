import android.os.Handler;
import com.tencent.biz.qrcode.activity.QRLoginActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class jcg
  extends Handler
{
  public jcg(QRLoginActivity paramQRLoginActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  /* Error */
  public void handleMessage(android.os.Message paramMessage)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 32	android/os/Message:getData	()Landroid/os/Bundle;
    //   4: astore_2
    //   5: aload_1
    //   6: getfield 36	android/os/Message:what	I
    //   9: tableswitch	default:+27->36, 1:+28->37, 2:+3492->3501, 3:+3560->3569
    //   36: return
    //   37: aload_2
    //   38: ldc 38
    //   40: iconst_1
    //   41: invokevirtual 44	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   44: istore 22
    //   46: aload_2
    //   47: ldc 46
    //   49: invokevirtual 50	android/os/Bundle:getByteArray	(Ljava/lang/String;)[B
    //   52: astore_3
    //   53: aload_2
    //   54: ldc 52
    //   56: invokevirtual 50	android/os/Bundle:getByteArray	(Ljava/lang/String;)[B
    //   59: astore 20
    //   61: aload_2
    //   62: ldc 54
    //   64: invokevirtual 50	android/os/Bundle:getByteArray	(Ljava/lang/String;)[B
    //   67: astore_2
    //   68: aload_2
    //   69: astore_1
    //   70: aload_2
    //   71: ifnonnull +7 -> 78
    //   74: iconst_0
    //   75: newarray <illegal type>
    //   77: astore_1
    //   78: aload_0
    //   79: getfield 10	jcg:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   82: getfield 59	com/tencent/biz/qrcode/activity/QRLoginActivity:jdField_a_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   85: iconst_0
    //   86: invokevirtual 65	android/widget/LinearLayout:setVisibility	(I)V
    //   89: aload_0
    //   90: getfield 10	jcg:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   93: getfield 68	com/tencent/biz/qrcode/activity/QRLoginActivity:jdField_a_of_type_AndroidWidgetProgressBar	Landroid/widget/ProgressBar;
    //   96: bipush 8
    //   98: invokevirtual 71	android/widget/ProgressBar:setVisibility	(I)V
    //   101: iload 22
    //   103: ifne +3382 -> 3485
    //   106: aload_3
    //   107: ifnull +8 -> 115
    //   110: aload_3
    //   111: arraylength
    //   112: ifne +332 -> 444
    //   115: aload_0
    //   116: getfield 10	jcg:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   119: aload_0
    //   120: getfield 10	jcg:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   123: ldc 72
    //   125: invokevirtual 76	com/tencent/biz/qrcode/activity/QRLoginActivity:getString	(I)Ljava/lang/String;
    //   128: putfield 80	com/tencent/biz/qrcode/activity/QRLoginActivity:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   131: aload_0
    //   132: getfield 10	jcg:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   135: ldc 81
    //   137: invokevirtual 76	com/tencent/biz/qrcode/activity/QRLoginActivity:getString	(I)Ljava/lang/String;
    //   140: astore_1
    //   141: aload_0
    //   142: getfield 10	jcg:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   145: ldc 82
    //   147: invokevirtual 76	com/tencent/biz/qrcode/activity/QRLoginActivity:getString	(I)Ljava/lang/String;
    //   150: astore_3
    //   151: aload_0
    //   152: getfield 10	jcg:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   155: ldc 83
    //   157: invokevirtual 76	com/tencent/biz/qrcode/activity/QRLoginActivity:getString	(I)Ljava/lang/String;
    //   160: astore_2
    //   161: aconst_null
    //   162: astore 4
    //   164: aconst_null
    //   165: astore 5
    //   167: iconst_1
    //   168: istore 22
    //   170: iconst_1
    //   171: istore 23
    //   173: aconst_null
    //   174: astore 6
    //   176: aconst_null
    //   177: astore 8
    //   179: iconst_0
    //   180: istore 24
    //   182: iconst_0
    //   183: istore 27
    //   185: iload 24
    //   187: istore 29
    //   189: iload 23
    //   191: istore 31
    //   193: iload 22
    //   195: istore 26
    //   197: aload 5
    //   199: astore 9
    //   201: aload 4
    //   203: astore 10
    //   205: aload_2
    //   206: astore 12
    //   208: aload_3
    //   209: astore 14
    //   211: aload_1
    //   212: astore 16
    //   214: iload 27
    //   216: aload 20
    //   218: arraylength
    //   219: if_icmpge +2539 -> 2758
    //   222: aload 20
    //   224: iload 27
    //   226: baload
    //   227: istore 25
    //   229: iload 27
    //   231: iconst_1
    //   232: iadd
    //   233: istore 27
    //   235: iload 25
    //   237: bipush 8
    //   239: ishl
    //   240: ldc 84
    //   242: iand
    //   243: aload 20
    //   245: iload 27
    //   247: baload
    //   248: sipush 255
    //   251: iand
    //   252: ior
    //   253: istore 26
    //   255: iload 27
    //   257: iconst_1
    //   258: iadd
    //   259: istore 25
    //   261: aload 20
    //   263: iload 25
    //   265: baload
    //   266: istore 27
    //   268: iload 25
    //   270: iconst_1
    //   271: iadd
    //   272: istore 25
    //   274: iload 27
    //   276: bipush 8
    //   278: ishl
    //   279: ldc 84
    //   281: iand
    //   282: aload 20
    //   284: iload 25
    //   286: baload
    //   287: sipush 255
    //   290: iand
    //   291: ior
    //   292: istore 40
    //   294: iload 26
    //   296: iconst_5
    //   297: if_icmpne +165 -> 462
    //   300: iload 25
    //   302: iconst_1
    //   303: iadd
    //   304: istore 27
    //   306: iload 24
    //   308: istore 29
    //   310: iload 23
    //   312: istore 31
    //   314: iload 22
    //   316: istore 26
    //   318: aload 5
    //   320: astore 9
    //   322: aload 4
    //   324: astore 10
    //   326: aload_2
    //   327: astore 12
    //   329: aload_3
    //   330: astore 14
    //   332: aload_1
    //   333: astore 16
    //   335: new 86	java/lang/String
    //   338: dup
    //   339: aload 20
    //   341: iload 27
    //   343: iload 40
    //   345: invokespecial 89	java/lang/String:<init>	([BII)V
    //   348: astore 11
    //   350: iload 23
    //   352: istore 25
    //   354: aload 5
    //   356: astore 7
    //   358: aload 4
    //   360: astore 9
    //   362: aload_1
    //   363: astore 6
    //   365: aload_3
    //   366: astore 5
    //   368: aload_2
    //   369: astore 4
    //   371: aload 9
    //   373: astore_3
    //   374: aload 7
    //   376: astore_2
    //   377: iload 22
    //   379: istore 23
    //   381: iload 25
    //   383: istore 22
    //   385: aload 11
    //   387: astore_1
    //   388: iload 27
    //   390: istore 25
    //   392: iload 25
    //   394: iload 40
    //   396: iadd
    //   397: istore 27
    //   399: aload 6
    //   401: astore 7
    //   403: aload 5
    //   405: astore 9
    //   407: aload 4
    //   409: astore 10
    //   411: iload 23
    //   413: istore 25
    //   415: aload_1
    //   416: astore 6
    //   418: iload 22
    //   420: istore 23
    //   422: iload 25
    //   424: istore 22
    //   426: aload_2
    //   427: astore 5
    //   429: aload_3
    //   430: astore 4
    //   432: aload 10
    //   434: astore_2
    //   435: aload 9
    //   437: astore_3
    //   438: aload 7
    //   440: astore_1
    //   441: goto -256 -> 185
    //   444: aload_0
    //   445: getfield 10	jcg:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   448: new 86	java/lang/String
    //   451: dup
    //   452: aload_3
    //   453: invokespecial 92	java/lang/String:<init>	([B)V
    //   456: putfield 80	com/tencent/biz/qrcode/activity/QRLoginActivity:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   459: goto -328 -> 131
    //   462: iload 26
    //   464: iconst_3
    //   465: if_icmpne +102 -> 567
    //   468: iload 25
    //   470: iconst_1
    //   471: iadd
    //   472: istore 25
    //   474: iload 24
    //   476: istore 29
    //   478: iload 23
    //   480: istore 31
    //   482: iload 22
    //   484: istore 26
    //   486: aload 5
    //   488: astore 9
    //   490: aload 4
    //   492: astore 10
    //   494: aload_2
    //   495: astore 12
    //   497: aload_3
    //   498: astore 14
    //   500: aload_1
    //   501: astore 16
    //   503: new 86	java/lang/String
    //   506: dup
    //   507: aload 20
    //   509: iload 25
    //   511: iload 40
    //   513: invokespecial 89	java/lang/String:<init>	([BII)V
    //   516: astore 7
    //   518: aload 7
    //   520: astore 8
    //   522: iload 22
    //   524: istore 26
    //   526: aload_2
    //   527: astore 7
    //   529: aload_3
    //   530: astore 9
    //   532: aload_1
    //   533: astore 10
    //   535: aload 6
    //   537: astore_1
    //   538: iload 23
    //   540: istore 22
    //   542: iload 26
    //   544: istore 23
    //   546: aload 5
    //   548: astore_2
    //   549: aload 4
    //   551: astore_3
    //   552: aload 7
    //   554: astore 4
    //   556: aload 9
    //   558: astore 5
    //   560: aload 10
    //   562: astore 6
    //   564: goto -172 -> 392
    //   567: iload 26
    //   569: bipush 32
    //   571: if_icmpne +3158 -> 3729
    //   574: iload 25
    //   576: istore 28
    //   578: iload 24
    //   580: istore 30
    //   582: iload 23
    //   584: istore 32
    //   586: iload 22
    //   588: istore 27
    //   590: aload 5
    //   592: astore 18
    //   594: aload 4
    //   596: astore 17
    //   598: aload_2
    //   599: astore 15
    //   601: aload_3
    //   602: astore 13
    //   604: aload_1
    //   605: astore 11
    //   607: iload 24
    //   609: istore 29
    //   611: iload 23
    //   613: istore 31
    //   615: iload 22
    //   617: istore 26
    //   619: aload 5
    //   621: astore 9
    //   623: aload 4
    //   625: astore 10
    //   627: aload_2
    //   628: astore 12
    //   630: aload_3
    //   631: astore 14
    //   633: aload_1
    //   634: astore 16
    //   636: iload 40
    //   638: newarray <illegal type>
    //   640: astore 7
    //   642: iload 25
    //   644: iconst_1
    //   645: iadd
    //   646: istore 25
    //   648: iload 25
    //   650: istore 28
    //   652: iload 24
    //   654: istore 30
    //   656: iload 23
    //   658: istore 32
    //   660: iload 22
    //   662: istore 27
    //   664: aload 5
    //   666: astore 18
    //   668: aload 4
    //   670: astore 17
    //   672: aload_2
    //   673: astore 15
    //   675: aload_3
    //   676: astore 13
    //   678: aload_1
    //   679: astore 11
    //   681: iload 24
    //   683: istore 29
    //   685: iload 23
    //   687: istore 31
    //   689: iload 22
    //   691: istore 26
    //   693: aload 5
    //   695: astore 9
    //   697: aload 4
    //   699: astore 10
    //   701: aload_2
    //   702: astore 12
    //   704: aload_3
    //   705: astore 14
    //   707: aload_1
    //   708: astore 16
    //   710: aload 20
    //   712: iload 25
    //   714: aload 7
    //   716: iconst_0
    //   717: iload 40
    //   719: invokestatic 98	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   722: iload 25
    //   724: istore 28
    //   726: iload 24
    //   728: istore 30
    //   730: iload 23
    //   732: istore 32
    //   734: iload 22
    //   736: istore 27
    //   738: aload 5
    //   740: astore 18
    //   742: aload 4
    //   744: astore 17
    //   746: aload_2
    //   747: astore 15
    //   749: aload_3
    //   750: astore 13
    //   752: aload_1
    //   753: astore 11
    //   755: iload 24
    //   757: istore 29
    //   759: iload 23
    //   761: istore 31
    //   763: iload 22
    //   765: istore 26
    //   767: aload 5
    //   769: astore 9
    //   771: aload 4
    //   773: astore 10
    //   775: aload_2
    //   776: astore 12
    //   778: aload_3
    //   779: astore 14
    //   781: aload_1
    //   782: astore 16
    //   784: new 100	com/tencent/ims/devlock_verify_scheme$SchemePkg
    //   787: dup
    //   788: invokespecial 101	com/tencent/ims/devlock_verify_scheme$SchemePkg:<init>	()V
    //   791: astore 21
    //   793: iload 25
    //   795: istore 28
    //   797: iload 24
    //   799: istore 30
    //   801: iload 23
    //   803: istore 32
    //   805: iload 22
    //   807: istore 27
    //   809: aload 5
    //   811: astore 18
    //   813: aload 4
    //   815: astore 17
    //   817: aload_2
    //   818: astore 15
    //   820: aload_3
    //   821: astore 13
    //   823: aload_1
    //   824: astore 11
    //   826: iload 24
    //   828: istore 29
    //   830: iload 23
    //   832: istore 31
    //   834: iload 22
    //   836: istore 26
    //   838: aload 5
    //   840: astore 9
    //   842: aload 4
    //   844: astore 10
    //   846: aload_2
    //   847: astore 12
    //   849: aload_3
    //   850: astore 14
    //   852: aload_1
    //   853: astore 16
    //   855: aload 21
    //   857: aload 7
    //   859: invokevirtual 105	com/tencent/ims/devlock_verify_scheme$SchemePkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   862: pop
    //   863: iconst_1
    //   864: istore 34
    //   866: iconst_1
    //   867: istore 37
    //   869: iconst_1
    //   870: istore 35
    //   872: iconst_1
    //   873: istore 38
    //   875: iconst_1
    //   876: istore 36
    //   878: iconst_1
    //   879: istore 39
    //   881: iconst_1
    //   882: istore 33
    //   884: iload 25
    //   886: istore 28
    //   888: iload 37
    //   890: istore 30
    //   892: iload 23
    //   894: istore 32
    //   896: iload 22
    //   898: istore 27
    //   900: aload 5
    //   902: astore 18
    //   904: aload 4
    //   906: astore 17
    //   908: aload_2
    //   909: astore 15
    //   911: aload_3
    //   912: astore 13
    //   914: aload_1
    //   915: astore 11
    //   917: iload 38
    //   919: istore 29
    //   921: iload 23
    //   923: istore 31
    //   925: iload 22
    //   927: istore 26
    //   929: aload 5
    //   931: astore 9
    //   933: aload 4
    //   935: astore 10
    //   937: aload_2
    //   938: astore 12
    //   940: aload_3
    //   941: astore 14
    //   943: aload_1
    //   944: astore 16
    //   946: aload 21
    //   948: getfield 109	com/tencent/ims/devlock_verify_scheme$SchemePkg:u32_verify_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   951: invokevirtual 115	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   954: ifeq +75 -> 1029
    //   957: iload 25
    //   959: istore 28
    //   961: iload 37
    //   963: istore 30
    //   965: iload 23
    //   967: istore 32
    //   969: iload 22
    //   971: istore 27
    //   973: aload 5
    //   975: astore 18
    //   977: aload 4
    //   979: astore 17
    //   981: aload_2
    //   982: astore 15
    //   984: aload_3
    //   985: astore 13
    //   987: aload_1
    //   988: astore 11
    //   990: iload 38
    //   992: istore 29
    //   994: iload 23
    //   996: istore 31
    //   998: iload 22
    //   1000: istore 26
    //   1002: aload 5
    //   1004: astore 9
    //   1006: aload 4
    //   1008: astore 10
    //   1010: aload_2
    //   1011: astore 12
    //   1013: aload_3
    //   1014: astore 14
    //   1016: aload_1
    //   1017: astore 16
    //   1019: aload 21
    //   1021: getfield 109	com/tencent/ims/devlock_verify_scheme$SchemePkg:u32_verify_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1024: invokevirtual 119	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1027: istore 33
    //   1029: iload 25
    //   1031: istore 27
    //   1033: iload 39
    //   1035: istore 24
    //   1037: iload 33
    //   1039: iconst_1
    //   1040: if_icmpne -855 -> 185
    //   1043: iconst_1
    //   1044: istore 33
    //   1046: iload 25
    //   1048: istore 28
    //   1050: iload 37
    //   1052: istore 30
    //   1054: iload 23
    //   1056: istore 32
    //   1058: iload 22
    //   1060: istore 27
    //   1062: aload 5
    //   1064: astore 18
    //   1066: aload 4
    //   1068: astore 17
    //   1070: aload_2
    //   1071: astore 15
    //   1073: aload_3
    //   1074: astore 13
    //   1076: aload_1
    //   1077: astore 11
    //   1079: iload 38
    //   1081: istore 29
    //   1083: iload 23
    //   1085: istore 31
    //   1087: iload 22
    //   1089: istore 26
    //   1091: aload 5
    //   1093: astore 9
    //   1095: aload 4
    //   1097: astore 10
    //   1099: aload_2
    //   1100: astore 12
    //   1102: aload_3
    //   1103: astore 14
    //   1105: aload_1
    //   1106: astore 16
    //   1108: aload 21
    //   1110: getfield 122	com/tencent/ims/devlock_verify_scheme$SchemePkg:u32_use_local_scheme	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1113: invokevirtual 115	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   1116: ifeq +75 -> 1191
    //   1119: iload 25
    //   1121: istore 28
    //   1123: iload 37
    //   1125: istore 30
    //   1127: iload 23
    //   1129: istore 32
    //   1131: iload 22
    //   1133: istore 27
    //   1135: aload 5
    //   1137: astore 18
    //   1139: aload 4
    //   1141: astore 17
    //   1143: aload_2
    //   1144: astore 15
    //   1146: aload_3
    //   1147: astore 13
    //   1149: aload_1
    //   1150: astore 11
    //   1152: iload 38
    //   1154: istore 29
    //   1156: iload 23
    //   1158: istore 31
    //   1160: iload 22
    //   1162: istore 26
    //   1164: aload 5
    //   1166: astore 9
    //   1168: aload 4
    //   1170: astore 10
    //   1172: aload_2
    //   1173: astore 12
    //   1175: aload_3
    //   1176: astore 14
    //   1178: aload_1
    //   1179: astore 16
    //   1181: aload 21
    //   1183: getfield 122	com/tencent/ims/devlock_verify_scheme$SchemePkg:u32_use_local_scheme	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1186: invokevirtual 119	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1189: istore 33
    //   1191: iload 25
    //   1193: istore 27
    //   1195: iload 39
    //   1197: istore 24
    //   1199: iload 33
    //   1201: iconst_1
    //   1202: if_icmpeq -1017 -> 185
    //   1205: aload_1
    //   1206: astore 7
    //   1208: iload 25
    //   1210: istore 28
    //   1212: iload 37
    //   1214: istore 30
    //   1216: iload 23
    //   1218: istore 32
    //   1220: iload 22
    //   1222: istore 27
    //   1224: aload 5
    //   1226: astore 18
    //   1228: aload 4
    //   1230: astore 17
    //   1232: aload_2
    //   1233: astore 15
    //   1235: aload_3
    //   1236: astore 13
    //   1238: aload_1
    //   1239: astore 11
    //   1241: iload 38
    //   1243: istore 29
    //   1245: iload 23
    //   1247: istore 31
    //   1249: iload 22
    //   1251: istore 26
    //   1253: aload 5
    //   1255: astore 9
    //   1257: aload 4
    //   1259: astore 10
    //   1261: aload_2
    //   1262: astore 12
    //   1264: aload_3
    //   1265: astore 14
    //   1267: aload_1
    //   1268: astore 16
    //   1270: aload 21
    //   1272: getfield 126	com/tencent/ims/devlock_verify_scheme$SchemePkg:str_title	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1275: invokevirtual 129	com/tencent/mobileqq/pb/PBStringField:has	()Z
    //   1278: ifeq +75 -> 1353
    //   1281: iload 25
    //   1283: istore 28
    //   1285: iload 37
    //   1287: istore 30
    //   1289: iload 23
    //   1291: istore 32
    //   1293: iload 22
    //   1295: istore 27
    //   1297: aload 5
    //   1299: astore 18
    //   1301: aload 4
    //   1303: astore 17
    //   1305: aload_2
    //   1306: astore 15
    //   1308: aload_3
    //   1309: astore 13
    //   1311: aload_1
    //   1312: astore 11
    //   1314: iload 38
    //   1316: istore 29
    //   1318: iload 23
    //   1320: istore 31
    //   1322: iload 22
    //   1324: istore 26
    //   1326: aload 5
    //   1328: astore 9
    //   1330: aload 4
    //   1332: astore 10
    //   1334: aload_2
    //   1335: astore 12
    //   1337: aload_3
    //   1338: astore 14
    //   1340: aload_1
    //   1341: astore 16
    //   1343: aload 21
    //   1345: getfield 126	com/tencent/ims/devlock_verify_scheme$SchemePkg:str_title	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1348: invokevirtual 132	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1351: astore 7
    //   1353: aload_3
    //   1354: astore_1
    //   1355: iload 25
    //   1357: istore 28
    //   1359: iload 37
    //   1361: istore 30
    //   1363: iload 23
    //   1365: istore 32
    //   1367: iload 22
    //   1369: istore 27
    //   1371: aload 5
    //   1373: astore 18
    //   1375: aload 4
    //   1377: astore 17
    //   1379: aload_2
    //   1380: astore 15
    //   1382: aload_3
    //   1383: astore 13
    //   1385: aload 7
    //   1387: astore 11
    //   1389: iload 38
    //   1391: istore 29
    //   1393: iload 23
    //   1395: istore 31
    //   1397: iload 22
    //   1399: istore 26
    //   1401: aload 5
    //   1403: astore 9
    //   1405: aload 4
    //   1407: astore 10
    //   1409: aload_2
    //   1410: astore 12
    //   1412: aload_3
    //   1413: astore 14
    //   1415: aload 7
    //   1417: astore 16
    //   1419: aload 21
    //   1421: getfield 135	com/tencent/ims/devlock_verify_scheme$SchemePkg:str_text	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1424: invokevirtual 129	com/tencent/mobileqq/pb/PBStringField:has	()Z
    //   1427: ifeq +76 -> 1503
    //   1430: iload 25
    //   1432: istore 28
    //   1434: iload 37
    //   1436: istore 30
    //   1438: iload 23
    //   1440: istore 32
    //   1442: iload 22
    //   1444: istore 27
    //   1446: aload 5
    //   1448: astore 18
    //   1450: aload 4
    //   1452: astore 17
    //   1454: aload_2
    //   1455: astore 15
    //   1457: aload_3
    //   1458: astore 13
    //   1460: aload 7
    //   1462: astore 11
    //   1464: iload 38
    //   1466: istore 29
    //   1468: iload 23
    //   1470: istore 31
    //   1472: iload 22
    //   1474: istore 26
    //   1476: aload 5
    //   1478: astore 9
    //   1480: aload 4
    //   1482: astore 10
    //   1484: aload_2
    //   1485: astore 12
    //   1487: aload_3
    //   1488: astore 14
    //   1490: aload 7
    //   1492: astore 16
    //   1494: aload 21
    //   1496: getfield 135	com/tencent/ims/devlock_verify_scheme$SchemePkg:str_text	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1499: invokevirtual 132	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1502: astore_1
    //   1503: aload_2
    //   1504: astore_3
    //   1505: iload 25
    //   1507: istore 28
    //   1509: iload 37
    //   1511: istore 30
    //   1513: iload 23
    //   1515: istore 32
    //   1517: iload 22
    //   1519: istore 27
    //   1521: aload 5
    //   1523: astore 18
    //   1525: aload 4
    //   1527: astore 17
    //   1529: aload_2
    //   1530: astore 15
    //   1532: aload_1
    //   1533: astore 13
    //   1535: aload 7
    //   1537: astore 11
    //   1539: iload 38
    //   1541: istore 29
    //   1543: iload 23
    //   1545: istore 31
    //   1547: iload 22
    //   1549: istore 26
    //   1551: aload 5
    //   1553: astore 9
    //   1555: aload 4
    //   1557: astore 10
    //   1559: aload_2
    //   1560: astore 12
    //   1562: aload_1
    //   1563: astore 14
    //   1565: aload 7
    //   1567: astore 16
    //   1569: aload 21
    //   1571: getfield 138	com/tencent/ims/devlock_verify_scheme$SchemePkg:str_subtext	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1574: invokevirtual 129	com/tencent/mobileqq/pb/PBStringField:has	()Z
    //   1577: ifeq +76 -> 1653
    //   1580: iload 25
    //   1582: istore 28
    //   1584: iload 37
    //   1586: istore 30
    //   1588: iload 23
    //   1590: istore 32
    //   1592: iload 22
    //   1594: istore 27
    //   1596: aload 5
    //   1598: astore 18
    //   1600: aload 4
    //   1602: astore 17
    //   1604: aload_2
    //   1605: astore 15
    //   1607: aload_1
    //   1608: astore 13
    //   1610: aload 7
    //   1612: astore 11
    //   1614: iload 38
    //   1616: istore 29
    //   1618: iload 23
    //   1620: istore 31
    //   1622: iload 22
    //   1624: istore 26
    //   1626: aload 5
    //   1628: astore 9
    //   1630: aload 4
    //   1632: astore 10
    //   1634: aload_2
    //   1635: astore 12
    //   1637: aload_1
    //   1638: astore 14
    //   1640: aload 7
    //   1642: astore 16
    //   1644: aload 21
    //   1646: getfield 138	com/tencent/ims/devlock_verify_scheme$SchemePkg:str_subtext	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1649: invokevirtual 132	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1652: astore_3
    //   1653: iload 25
    //   1655: istore 28
    //   1657: iload 37
    //   1659: istore 30
    //   1661: iload 23
    //   1663: istore 32
    //   1665: iload 22
    //   1667: istore 27
    //   1669: aload 5
    //   1671: astore 18
    //   1673: aload 4
    //   1675: astore 17
    //   1677: aload_3
    //   1678: astore 15
    //   1680: aload_1
    //   1681: astore 13
    //   1683: aload 7
    //   1685: astore 11
    //   1687: iload 38
    //   1689: istore 29
    //   1691: iload 23
    //   1693: istore 31
    //   1695: iload 22
    //   1697: istore 26
    //   1699: aload 5
    //   1701: astore 9
    //   1703: aload 4
    //   1705: astore 10
    //   1707: aload_3
    //   1708: astore 12
    //   1710: aload_1
    //   1711: astore 14
    //   1713: aload 7
    //   1715: astore 16
    //   1717: aload 21
    //   1719: getfield 141	com/tencent/ims/devlock_verify_scheme$SchemePkg:u32_button1_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1722: invokevirtual 115	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   1725: ifeq +82 -> 1807
    //   1728: iload 25
    //   1730: istore 28
    //   1732: iload 37
    //   1734: istore 30
    //   1736: iload 23
    //   1738: istore 32
    //   1740: iload 22
    //   1742: istore 27
    //   1744: aload 5
    //   1746: astore 18
    //   1748: aload 4
    //   1750: astore 17
    //   1752: aload_3
    //   1753: astore 15
    //   1755: aload_1
    //   1756: astore 13
    //   1758: aload 7
    //   1760: astore 11
    //   1762: iload 38
    //   1764: istore 29
    //   1766: iload 23
    //   1768: istore 31
    //   1770: iload 22
    //   1772: istore 26
    //   1774: aload 5
    //   1776: astore 9
    //   1778: aload 4
    //   1780: astore 10
    //   1782: aload_3
    //   1783: astore 12
    //   1785: aload_1
    //   1786: astore 14
    //   1788: aload 7
    //   1790: astore 16
    //   1792: aload_0
    //   1793: getfield 10	jcg:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   1796: aload 21
    //   1798: getfield 141	com/tencent/ims/devlock_verify_scheme$SchemePkg:u32_button1_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1801: invokevirtual 119	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1804: putfield 144	com/tencent/biz/qrcode/activity/QRLoginActivity:jdField_c_of_type_Int	I
    //   1807: iload 25
    //   1809: istore 28
    //   1811: iload 37
    //   1813: istore 30
    //   1815: iload 23
    //   1817: istore 32
    //   1819: iload 22
    //   1821: istore 27
    //   1823: aload 5
    //   1825: astore 18
    //   1827: aload 4
    //   1829: astore 17
    //   1831: aload_3
    //   1832: astore 15
    //   1834: aload_1
    //   1835: astore 13
    //   1837: aload 7
    //   1839: astore 11
    //   1841: iload 38
    //   1843: istore 29
    //   1845: iload 23
    //   1847: istore 31
    //   1849: iload 22
    //   1851: istore 26
    //   1853: aload 5
    //   1855: astore 9
    //   1857: aload 4
    //   1859: astore 10
    //   1861: aload_3
    //   1862: astore 12
    //   1864: aload_1
    //   1865: astore 14
    //   1867: aload 7
    //   1869: astore 16
    //   1871: aload 21
    //   1873: getfield 147	com/tencent/ims/devlock_verify_scheme$SchemePkg:str_button1_caption	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1876: invokevirtual 129	com/tencent/mobileqq/pb/PBStringField:has	()Z
    //   1879: ifeq +810 -> 2689
    //   1882: iload 25
    //   1884: istore 28
    //   1886: iload 37
    //   1888: istore 30
    //   1890: iload 23
    //   1892: istore 32
    //   1894: iload 22
    //   1896: istore 27
    //   1898: aload 5
    //   1900: astore 18
    //   1902: aload 4
    //   1904: astore 17
    //   1906: aload_3
    //   1907: astore 15
    //   1909: aload_1
    //   1910: astore 13
    //   1912: aload 7
    //   1914: astore 11
    //   1916: iload 38
    //   1918: istore 29
    //   1920: iload 23
    //   1922: istore 31
    //   1924: iload 22
    //   1926: istore 26
    //   1928: aload 5
    //   1930: astore 9
    //   1932: aload 4
    //   1934: astore 10
    //   1936: aload_3
    //   1937: astore 12
    //   1939: aload_1
    //   1940: astore 14
    //   1942: aload 7
    //   1944: astore 16
    //   1946: aload 21
    //   1948: getfield 147	com/tencent/ims/devlock_verify_scheme$SchemePkg:str_button1_caption	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1951: invokevirtual 132	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1954: astore 4
    //   1956: iload 22
    //   1958: istore 24
    //   1960: iload 24
    //   1962: istore 22
    //   1964: iload 25
    //   1966: istore 28
    //   1968: iload 37
    //   1970: istore 30
    //   1972: iload 23
    //   1974: istore 32
    //   1976: iload 24
    //   1978: istore 27
    //   1980: aload 5
    //   1982: astore 18
    //   1984: aload 4
    //   1986: astore 17
    //   1988: aload_3
    //   1989: astore 15
    //   1991: aload_1
    //   1992: astore 13
    //   1994: aload 7
    //   1996: astore 11
    //   1998: iload 38
    //   2000: istore 29
    //   2002: iload 23
    //   2004: istore 31
    //   2006: iload 24
    //   2008: istore 26
    //   2010: aload 5
    //   2012: astore 9
    //   2014: aload 4
    //   2016: astore 10
    //   2018: aload_3
    //   2019: astore 12
    //   2021: aload_1
    //   2022: astore 14
    //   2024: aload 7
    //   2026: astore 16
    //   2028: aload_0
    //   2029: getfield 10	jcg:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   2032: getfield 149	com/tencent/biz/qrcode/activity/QRLoginActivity:jdField_e_of_type_Int	I
    //   2035: ifne +6 -> 2041
    //   2038: iconst_0
    //   2039: istore 22
    //   2041: iload 25
    //   2043: istore 28
    //   2045: iload 37
    //   2047: istore 30
    //   2049: iload 23
    //   2051: istore 32
    //   2053: iload 22
    //   2055: istore 27
    //   2057: aload 5
    //   2059: astore 18
    //   2061: aload 4
    //   2063: astore 17
    //   2065: aload_3
    //   2066: astore 15
    //   2068: aload_1
    //   2069: astore 13
    //   2071: aload 7
    //   2073: astore 11
    //   2075: iload 38
    //   2077: istore 29
    //   2079: iload 23
    //   2081: istore 31
    //   2083: iload 22
    //   2085: istore 26
    //   2087: aload 5
    //   2089: astore 9
    //   2091: aload 4
    //   2093: astore 10
    //   2095: aload_3
    //   2096: astore 12
    //   2098: aload_1
    //   2099: astore 14
    //   2101: aload 7
    //   2103: astore 16
    //   2105: aload 21
    //   2107: getfield 152	com/tencent/ims/devlock_verify_scheme$SchemePkg:u32_button1_auth	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2110: invokevirtual 115	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   2113: ifeq +82 -> 2195
    //   2116: iload 25
    //   2118: istore 28
    //   2120: iload 37
    //   2122: istore 30
    //   2124: iload 23
    //   2126: istore 32
    //   2128: iload 22
    //   2130: istore 27
    //   2132: aload 5
    //   2134: astore 18
    //   2136: aload 4
    //   2138: astore 17
    //   2140: aload_3
    //   2141: astore 15
    //   2143: aload_1
    //   2144: astore 13
    //   2146: aload 7
    //   2148: astore 11
    //   2150: iload 38
    //   2152: istore 29
    //   2154: iload 23
    //   2156: istore 31
    //   2158: iload 22
    //   2160: istore 26
    //   2162: aload 5
    //   2164: astore 9
    //   2166: aload 4
    //   2168: astore 10
    //   2170: aload_3
    //   2171: astore 12
    //   2173: aload_1
    //   2174: astore 14
    //   2176: aload 7
    //   2178: astore 16
    //   2180: aload_0
    //   2181: getfield 10	jcg:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   2184: aload 21
    //   2186: getfield 152	com/tencent/ims/devlock_verify_scheme$SchemePkg:u32_button1_auth	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2189: invokevirtual 119	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2192: putfield 155	com/tencent/biz/qrcode/activity/QRLoginActivity:jdField_b_of_type_Int	I
    //   2195: iload 25
    //   2197: istore 28
    //   2199: iload 37
    //   2201: istore 30
    //   2203: iload 23
    //   2205: istore 32
    //   2207: iload 22
    //   2209: istore 27
    //   2211: aload 5
    //   2213: astore 18
    //   2215: aload 4
    //   2217: astore 17
    //   2219: aload_3
    //   2220: astore 15
    //   2222: aload_1
    //   2223: astore 13
    //   2225: aload 7
    //   2227: astore 11
    //   2229: iload 38
    //   2231: istore 29
    //   2233: iload 23
    //   2235: istore 31
    //   2237: iload 22
    //   2239: istore 26
    //   2241: aload 5
    //   2243: astore 9
    //   2245: aload 4
    //   2247: astore 10
    //   2249: aload_3
    //   2250: astore 12
    //   2252: aload_1
    //   2253: astore 14
    //   2255: aload 7
    //   2257: astore 16
    //   2259: aload 21
    //   2261: getfield 158	com/tencent/ims/devlock_verify_scheme$SchemePkg:u32_button2_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2264: invokevirtual 115	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   2267: ifeq +82 -> 2349
    //   2270: iload 25
    //   2272: istore 28
    //   2274: iload 37
    //   2276: istore 30
    //   2278: iload 23
    //   2280: istore 32
    //   2282: iload 22
    //   2284: istore 27
    //   2286: aload 5
    //   2288: astore 18
    //   2290: aload 4
    //   2292: astore 17
    //   2294: aload_3
    //   2295: astore 15
    //   2297: aload_1
    //   2298: astore 13
    //   2300: aload 7
    //   2302: astore 11
    //   2304: iload 38
    //   2306: istore 29
    //   2308: iload 23
    //   2310: istore 31
    //   2312: iload 22
    //   2314: istore 26
    //   2316: aload 5
    //   2318: astore 9
    //   2320: aload 4
    //   2322: astore 10
    //   2324: aload_3
    //   2325: astore 12
    //   2327: aload_1
    //   2328: astore 14
    //   2330: aload 7
    //   2332: astore 16
    //   2334: aload_0
    //   2335: getfield 10	jcg:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   2338: aload 21
    //   2340: getfield 158	com/tencent/ims/devlock_verify_scheme$SchemePkg:u32_button2_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2343: invokevirtual 119	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2346: putfield 149	com/tencent/biz/qrcode/activity/QRLoginActivity:jdField_e_of_type_Int	I
    //   2349: iconst_0
    //   2350: istore 24
    //   2352: iconst_0
    //   2353: istore 23
    //   2355: iload 25
    //   2357: istore 28
    //   2359: iload 37
    //   2361: istore 30
    //   2363: iload 23
    //   2365: istore 32
    //   2367: iload 22
    //   2369: istore 27
    //   2371: aload 5
    //   2373: astore 18
    //   2375: aload 4
    //   2377: astore 17
    //   2379: aload_3
    //   2380: astore 15
    //   2382: aload_1
    //   2383: astore 13
    //   2385: aload 7
    //   2387: astore 11
    //   2389: iload 38
    //   2391: istore 29
    //   2393: iload 24
    //   2395: istore 31
    //   2397: iload 22
    //   2399: istore 26
    //   2401: aload 5
    //   2403: astore 9
    //   2405: aload 4
    //   2407: astore 10
    //   2409: aload_3
    //   2410: astore 12
    //   2412: aload_1
    //   2413: astore 14
    //   2415: aload 7
    //   2417: astore 16
    //   2419: aload 5
    //   2421: astore 19
    //   2423: aload 21
    //   2425: getfield 161	com/tencent/ims/devlock_verify_scheme$SchemePkg:str_button2_caption	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2428: invokevirtual 129	com/tencent/mobileqq/pb/PBStringField:has	()Z
    //   2431: ifeq +1289 -> 3720
    //   2434: iload 25
    //   2436: istore 28
    //   2438: iload 37
    //   2440: istore 30
    //   2442: iload 23
    //   2444: istore 32
    //   2446: iload 22
    //   2448: istore 27
    //   2450: aload 5
    //   2452: astore 18
    //   2454: aload 4
    //   2456: astore 17
    //   2458: aload_3
    //   2459: astore 15
    //   2461: aload_1
    //   2462: astore 13
    //   2464: aload 7
    //   2466: astore 11
    //   2468: iload 38
    //   2470: istore 29
    //   2472: iload 24
    //   2474: istore 31
    //   2476: iload 22
    //   2478: istore 26
    //   2480: aload 5
    //   2482: astore 9
    //   2484: aload 4
    //   2486: astore 10
    //   2488: aload_3
    //   2489: astore 12
    //   2491: aload_1
    //   2492: astore 14
    //   2494: aload 7
    //   2496: astore 16
    //   2498: aload 21
    //   2500: getfield 161	com/tencent/ims/devlock_verify_scheme$SchemePkg:str_button2_caption	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2503: invokevirtual 132	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   2506: astore_2
    //   2507: iload 25
    //   2509: istore 28
    //   2511: iload 37
    //   2513: istore 30
    //   2515: iload 23
    //   2517: istore 32
    //   2519: iload 22
    //   2521: istore 27
    //   2523: aload_2
    //   2524: astore 18
    //   2526: aload 4
    //   2528: astore 17
    //   2530: aload_3
    //   2531: astore 15
    //   2533: aload_1
    //   2534: astore 13
    //   2536: aload 7
    //   2538: astore 11
    //   2540: iload 38
    //   2542: istore 29
    //   2544: iload 24
    //   2546: istore 31
    //   2548: iload 22
    //   2550: istore 26
    //   2552: aload_2
    //   2553: astore 9
    //   2555: aload 4
    //   2557: astore 10
    //   2559: aload_3
    //   2560: astore 12
    //   2562: aload_1
    //   2563: astore 14
    //   2565: aload 7
    //   2567: astore 16
    //   2569: aload_2
    //   2570: invokestatic 167	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2573: istore 41
    //   2575: aload_2
    //   2576: astore 19
    //   2578: iload 41
    //   2580: ifne +1140 -> 3720
    //   2583: iconst_1
    //   2584: istore 23
    //   2586: aload 21
    //   2588: getfield 170	com/tencent/ims/devlock_verify_scheme$SchemePkg:u32_button2_auth	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2591: invokevirtual 115	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   2594: ifeq +18 -> 2612
    //   2597: aload_0
    //   2598: getfield 10	jcg:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   2601: aload 21
    //   2603: getfield 170	com/tencent/ims/devlock_verify_scheme$SchemePkg:u32_button2_auth	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2606: invokevirtual 119	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2609: putfield 173	com/tencent/biz/qrcode/activity/QRLoginActivity:d	I
    //   2612: iload 23
    //   2614: istore 24
    //   2616: iload 23
    //   2618: ifeq +24 -> 2642
    //   2621: aload_0
    //   2622: getfield 10	jcg:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   2625: getfield 149	com/tencent/biz/qrcode/activity/QRLoginActivity:jdField_e_of_type_Int	I
    //   2628: istore 26
    //   2630: iload 23
    //   2632: istore 24
    //   2634: iload 26
    //   2636: ifne +6 -> 2642
    //   2639: iconst_0
    //   2640: istore 24
    //   2642: aload_3
    //   2643: astore 5
    //   2645: aload_1
    //   2646: astore 9
    //   2648: iload 24
    //   2650: istore 23
    //   2652: aload 6
    //   2654: astore_1
    //   2655: iload 22
    //   2657: istore 26
    //   2659: iload 34
    //   2661: istore 24
    //   2663: iload 23
    //   2665: istore 22
    //   2667: iload 26
    //   2669: istore 23
    //   2671: aload 4
    //   2673: astore_3
    //   2674: aload 5
    //   2676: astore 4
    //   2678: aload 9
    //   2680: astore 5
    //   2682: aload 7
    //   2684: astore 6
    //   2686: goto -2294 -> 392
    //   2689: iconst_0
    //   2690: istore 24
    //   2692: goto -732 -> 1960
    //   2695: astore 9
    //   2697: iload 32
    //   2699: istore 24
    //   2701: iload 27
    //   2703: istore 23
    //   2705: aload 18
    //   2707: astore_2
    //   2708: aload 17
    //   2710: astore_3
    //   2711: aload 15
    //   2713: astore 4
    //   2715: aload 13
    //   2717: astore 5
    //   2719: aload 11
    //   2721: astore 7
    //   2723: iload 30
    //   2725: istore 22
    //   2727: iload 28
    //   2729: istore 25
    //   2731: aload 9
    //   2733: invokevirtual 176	java/lang/Throwable:printStackTrace	()V
    //   2736: iload 24
    //   2738: istore 26
    //   2740: aload 6
    //   2742: astore_1
    //   2743: iload 22
    //   2745: istore 24
    //   2747: iload 26
    //   2749: istore 22
    //   2751: aload 7
    //   2753: astore 6
    //   2755: goto -2363 -> 392
    //   2758: aload_1
    //   2759: astore 7
    //   2761: iload 23
    //   2763: istore 25
    //   2765: iload 24
    //   2767: istore 23
    //   2769: aload 4
    //   2771: astore_1
    //   2772: aload_3
    //   2773: astore 4
    //   2775: aload 5
    //   2777: astore_3
    //   2778: aload 6
    //   2780: ifnull +15 -> 2795
    //   2783: aload 6
    //   2785: astore 5
    //   2787: aload 6
    //   2789: invokevirtual 179	java/lang/String:length	()I
    //   2792: ifne +14 -> 2806
    //   2795: aload_0
    //   2796: getfield 10	jcg:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   2799: ldc -76
    //   2801: invokevirtual 76	com/tencent/biz/qrcode/activity/QRLoginActivity:getString	(I)Ljava/lang/String;
    //   2804: astore 5
    //   2806: aload_0
    //   2807: getfield 10	jcg:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   2810: aload 5
    //   2812: putfield 183	com/tencent/biz/qrcode/activity/QRLoginActivity:f	Ljava/lang/String;
    //   2815: aload_0
    //   2816: getfield 10	jcg:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   2819: getfield 187	com/tencent/biz/qrcode/activity/QRLoginActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2822: invokevirtual 191	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   2825: astore 6
    //   2827: aload_0
    //   2828: getfield 10	jcg:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   2831: getfield 194	com/tencent/biz/qrcode/activity/QRLoginActivity:jdField_c_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   2834: aload_0
    //   2835: getfield 10	jcg:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   2838: getfield 187	com/tencent/biz/qrcode/activity/QRLoginActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2841: aload 6
    //   2843: invokestatic 200	com/tencent/mobileqq/utils/ContactUtils:i	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)Ljava/lang/String;
    //   2846: invokevirtual 206	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   2849: aload_0
    //   2850: getfield 10	jcg:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   2853: aload 7
    //   2855: invokevirtual 209	com/tencent/biz/qrcode/activity/QRLoginActivity:setTitle	(Ljava/lang/CharSequence;)V
    //   2858: iload 23
    //   2860: ifne +853 -> 3713
    //   2863: aload 8
    //   2865: invokestatic 167	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2868: ifne +317 -> 3185
    //   2871: aload_0
    //   2872: getfield 10	jcg:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   2875: ldc -46
    //   2877: invokevirtual 76	com/tencent/biz/qrcode/activity/QRLoginActivity:getString	(I)Ljava/lang/String;
    //   2880: astore_3
    //   2881: aconst_null
    //   2882: astore_2
    //   2883: aload 8
    //   2885: invokestatic 167	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2888: ifne +330 -> 3218
    //   2891: aload_0
    //   2892: getfield 10	jcg:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   2895: getfield 212	com/tencent/biz/qrcode/activity/QRLoginActivity:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   2898: aload 8
    //   2900: invokevirtual 206	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   2903: aload_2
    //   2904: invokestatic 167	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2907: ifne +326 -> 3233
    //   2910: aload_0
    //   2911: getfield 10	jcg:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   2914: getfield 214	com/tencent/biz/qrcode/activity/QRLoginActivity:jdField_b_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   2917: aload_2
    //   2918: invokevirtual 206	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   2921: iload 22
    //   2923: ifeq +435 -> 3358
    //   2926: aload_1
    //   2927: invokestatic 167	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2930: ifeq +780 -> 3710
    //   2933: aload_0
    //   2934: getfield 10	jcg:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   2937: getfield 155	com/tencent/biz/qrcode/activity/QRLoginActivity:jdField_b_of_type_Int	I
    //   2940: iconst_1
    //   2941: if_icmpne +320 -> 3261
    //   2944: aload_0
    //   2945: getfield 10	jcg:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   2948: getfield 80	com/tencent/biz/qrcode/activity/QRLoginActivity:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   2951: invokestatic 167	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2954: ifne +294 -> 3248
    //   2957: aload_0
    //   2958: getfield 10	jcg:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   2961: ldc -41
    //   2963: iconst_1
    //   2964: anewarray 217	java/lang/Object
    //   2967: dup
    //   2968: iconst_0
    //   2969: aload_0
    //   2970: getfield 10	jcg:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   2973: getfield 80	com/tencent/biz/qrcode/activity/QRLoginActivity:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   2976: aastore
    //   2977: invokevirtual 220	com/tencent/biz/qrcode/activity/QRLoginActivity:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   2980: astore_1
    //   2981: aload_0
    //   2982: getfield 10	jcg:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   2985: getfield 223	com/tencent/biz/qrcode/activity/QRLoginActivity:jdField_a_of_type_AndroidWidgetButton	Landroid/widget/Button;
    //   2988: aload_1
    //   2989: invokevirtual 226	android/widget/Button:setText	(Ljava/lang/CharSequence;)V
    //   2992: aload_0
    //   2993: getfield 10	jcg:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   2996: getfield 144	com/tencent/biz/qrcode/activity/QRLoginActivity:jdField_c_of_type_Int	I
    //   2999: iconst_2
    //   3000: if_icmpne +274 -> 3274
    //   3003: aload_0
    //   3004: getfield 10	jcg:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   3007: getfield 223	com/tencent/biz/qrcode/activity/QRLoginActivity:jdField_a_of_type_AndroidWidgetButton	Landroid/widget/Button;
    //   3010: ldc -29
    //   3012: invokevirtual 230	android/widget/Button:setBackgroundResource	(I)V
    //   3015: aload_0
    //   3016: getfield 10	jcg:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   3019: getfield 223	com/tencent/biz/qrcode/activity/QRLoginActivity:jdField_a_of_type_AndroidWidgetButton	Landroid/widget/Button;
    //   3022: aload_0
    //   3023: getfield 10	jcg:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   3026: ldc -25
    //   3028: invokevirtual 235	android/widget/Button:setTextAppearance	(Landroid/content/Context;I)V
    //   3031: iload 25
    //   3033: ifeq +437 -> 3470
    //   3036: aload_3
    //   3037: astore_1
    //   3038: aload_3
    //   3039: invokestatic 167	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3042: ifeq +24 -> 3066
    //   3045: aload_0
    //   3046: getfield 10	jcg:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   3049: getfield 173	com/tencent/biz/qrcode/activity/QRLoginActivity:d	I
    //   3052: iconst_1
    //   3053: if_icmpne +320 -> 3373
    //   3056: aload_0
    //   3057: getfield 10	jcg:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   3060: ldc -20
    //   3062: invokevirtual 76	com/tencent/biz/qrcode/activity/QRLoginActivity:getString	(I)Ljava/lang/String;
    //   3065: astore_1
    //   3066: aload_0
    //   3067: getfield 10	jcg:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   3070: getfield 238	com/tencent/biz/qrcode/activity/QRLoginActivity:jdField_b_of_type_AndroidWidgetButton	Landroid/widget/Button;
    //   3073: aload_1
    //   3074: invokevirtual 226	android/widget/Button:setText	(Ljava/lang/CharSequence;)V
    //   3077: aload_0
    //   3078: getfield 10	jcg:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   3081: getfield 149	com/tencent/biz/qrcode/activity/QRLoginActivity:jdField_e_of_type_Int	I
    //   3084: iconst_2
    //   3085: if_icmpne +301 -> 3386
    //   3088: aload_0
    //   3089: getfield 10	jcg:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   3092: getfield 238	com/tencent/biz/qrcode/activity/QRLoginActivity:jdField_b_of_type_AndroidWidgetButton	Landroid/widget/Button;
    //   3095: ldc -29
    //   3097: invokevirtual 230	android/widget/Button:setBackgroundResource	(I)V
    //   3100: aload_0
    //   3101: getfield 10	jcg:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   3104: getfield 238	com/tencent/biz/qrcode/activity/QRLoginActivity:jdField_b_of_type_AndroidWidgetButton	Landroid/widget/Button;
    //   3107: aload_0
    //   3108: getfield 10	jcg:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   3111: ldc -25
    //   3113: invokevirtual 235	android/widget/Button:setTextAppearance	(Landroid/content/Context;I)V
    //   3116: new 240	jch
    //   3119: dup
    //   3120: aload_0
    //   3121: aload 6
    //   3123: invokespecial 243	jch:<init>	(Ljcg;Ljava/lang/String;)V
    //   3126: invokevirtual 246	jch:start	()V
    //   3129: return
    //   3130: astore_1
    //   3131: aload 16
    //   3133: astore 7
    //   3135: aload 14
    //   3137: astore_1
    //   3138: aload 12
    //   3140: astore_3
    //   3141: aload 10
    //   3143: astore 4
    //   3145: aload 9
    //   3147: astore_2
    //   3148: iload 26
    //   3150: istore 22
    //   3152: iload 31
    //   3154: istore 24
    //   3156: iload 29
    //   3158: istore 23
    //   3160: aload 4
    //   3162: astore 5
    //   3164: aload_3
    //   3165: astore 4
    //   3167: aload_2
    //   3168: astore_3
    //   3169: aload 4
    //   3171: astore_2
    //   3172: aload_1
    //   3173: astore 4
    //   3175: aload 5
    //   3177: astore_1
    //   3178: iload 24
    //   3180: istore 25
    //   3182: goto -404 -> 2778
    //   3185: aload_0
    //   3186: getfield 10	jcg:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   3189: ldc -9
    //   3191: iconst_2
    //   3192: anewarray 217	java/lang/Object
    //   3195: dup
    //   3196: iconst_0
    //   3197: aload_0
    //   3198: getfield 10	jcg:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   3201: getfield 80	com/tencent/biz/qrcode/activity/QRLoginActivity:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   3204: aastore
    //   3205: dup
    //   3206: iconst_1
    //   3207: aload 5
    //   3209: aastore
    //   3210: invokevirtual 220	com/tencent/biz/qrcode/activity/QRLoginActivity:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   3213: astore 8
    //   3215: goto -344 -> 2871
    //   3218: aload_0
    //   3219: getfield 10	jcg:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   3222: getfield 212	com/tencent/biz/qrcode/activity/QRLoginActivity:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   3225: bipush 8
    //   3227: invokevirtual 248	android/widget/TextView:setVisibility	(I)V
    //   3230: goto -327 -> 2903
    //   3233: aload_0
    //   3234: getfield 10	jcg:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   3237: getfield 214	com/tencent/biz/qrcode/activity/QRLoginActivity:jdField_b_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   3240: bipush 8
    //   3242: invokevirtual 248	android/widget/TextView:setVisibility	(I)V
    //   3245: goto -324 -> 2921
    //   3248: aload_0
    //   3249: getfield 10	jcg:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   3252: ldc -20
    //   3254: invokevirtual 76	com/tencent/biz/qrcode/activity/QRLoginActivity:getString	(I)Ljava/lang/String;
    //   3257: astore_1
    //   3258: goto -277 -> 2981
    //   3261: aload_0
    //   3262: getfield 10	jcg:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   3265: ldc -7
    //   3267: invokevirtual 76	com/tencent/biz/qrcode/activity/QRLoginActivity:getString	(I)Ljava/lang/String;
    //   3270: astore_1
    //   3271: goto -290 -> 2981
    //   3274: aload_0
    //   3275: getfield 10	jcg:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   3278: getfield 144	com/tencent/biz/qrcode/activity/QRLoginActivity:jdField_c_of_type_Int	I
    //   3281: iconst_3
    //   3282: if_icmpne +34 -> 3316
    //   3285: aload_0
    //   3286: getfield 10	jcg:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   3289: getfield 223	com/tencent/biz/qrcode/activity/QRLoginActivity:jdField_a_of_type_AndroidWidgetButton	Landroid/widget/Button;
    //   3292: ldc -6
    //   3294: invokevirtual 230	android/widget/Button:setBackgroundResource	(I)V
    //   3297: aload_0
    //   3298: getfield 10	jcg:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   3301: getfield 223	com/tencent/biz/qrcode/activity/QRLoginActivity:jdField_a_of_type_AndroidWidgetButton	Landroid/widget/Button;
    //   3304: aload_0
    //   3305: getfield 10	jcg:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   3308: ldc -5
    //   3310: invokevirtual 235	android/widget/Button:setTextAppearance	(Landroid/content/Context;I)V
    //   3313: goto -282 -> 3031
    //   3316: aload_0
    //   3317: getfield 10	jcg:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   3320: getfield 144	com/tencent/biz/qrcode/activity/QRLoginActivity:jdField_c_of_type_Int	I
    //   3323: iconst_1
    //   3324: if_icmpne -293 -> 3031
    //   3327: aload_0
    //   3328: getfield 10	jcg:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   3331: getfield 223	com/tencent/biz/qrcode/activity/QRLoginActivity:jdField_a_of_type_AndroidWidgetButton	Landroid/widget/Button;
    //   3334: ldc -4
    //   3336: invokevirtual 230	android/widget/Button:setBackgroundResource	(I)V
    //   3339: aload_0
    //   3340: getfield 10	jcg:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   3343: getfield 223	com/tencent/biz/qrcode/activity/QRLoginActivity:jdField_a_of_type_AndroidWidgetButton	Landroid/widget/Button;
    //   3346: aload_0
    //   3347: getfield 10	jcg:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   3350: ldc -3
    //   3352: invokevirtual 235	android/widget/Button:setTextAppearance	(Landroid/content/Context;I)V
    //   3355: goto -324 -> 3031
    //   3358: aload_0
    //   3359: getfield 10	jcg:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   3362: getfield 223	com/tencent/biz/qrcode/activity/QRLoginActivity:jdField_a_of_type_AndroidWidgetButton	Landroid/widget/Button;
    //   3365: bipush 8
    //   3367: invokevirtual 254	android/widget/Button:setVisibility	(I)V
    //   3370: goto -339 -> 3031
    //   3373: aload_0
    //   3374: getfield 10	jcg:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   3377: ldc -7
    //   3379: invokevirtual 76	com/tencent/biz/qrcode/activity/QRLoginActivity:getString	(I)Ljava/lang/String;
    //   3382: astore_1
    //   3383: goto -317 -> 3066
    //   3386: aload_0
    //   3387: getfield 10	jcg:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   3390: getfield 149	com/tencent/biz/qrcode/activity/QRLoginActivity:jdField_e_of_type_Int	I
    //   3393: iconst_3
    //   3394: if_icmpne +34 -> 3428
    //   3397: aload_0
    //   3398: getfield 10	jcg:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   3401: getfield 238	com/tencent/biz/qrcode/activity/QRLoginActivity:jdField_b_of_type_AndroidWidgetButton	Landroid/widget/Button;
    //   3404: ldc -6
    //   3406: invokevirtual 230	android/widget/Button:setBackgroundResource	(I)V
    //   3409: aload_0
    //   3410: getfield 10	jcg:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   3413: getfield 238	com/tencent/biz/qrcode/activity/QRLoginActivity:jdField_b_of_type_AndroidWidgetButton	Landroid/widget/Button;
    //   3416: aload_0
    //   3417: getfield 10	jcg:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   3420: ldc -5
    //   3422: invokevirtual 235	android/widget/Button:setTextAppearance	(Landroid/content/Context;I)V
    //   3425: goto -309 -> 3116
    //   3428: aload_0
    //   3429: getfield 10	jcg:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   3432: getfield 149	com/tencent/biz/qrcode/activity/QRLoginActivity:jdField_e_of_type_Int	I
    //   3435: iconst_1
    //   3436: if_icmpne -320 -> 3116
    //   3439: aload_0
    //   3440: getfield 10	jcg:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   3443: getfield 238	com/tencent/biz/qrcode/activity/QRLoginActivity:jdField_b_of_type_AndroidWidgetButton	Landroid/widget/Button;
    //   3446: ldc -4
    //   3448: invokevirtual 230	android/widget/Button:setBackgroundResource	(I)V
    //   3451: aload_0
    //   3452: getfield 10	jcg:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   3455: getfield 238	com/tencent/biz/qrcode/activity/QRLoginActivity:jdField_b_of_type_AndroidWidgetButton	Landroid/widget/Button;
    //   3458: aload_0
    //   3459: getfield 10	jcg:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   3462: ldc -3
    //   3464: invokevirtual 235	android/widget/Button:setTextAppearance	(Landroid/content/Context;I)V
    //   3467: goto -351 -> 3116
    //   3470: aload_0
    //   3471: getfield 10	jcg:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   3474: getfield 238	com/tencent/biz/qrcode/activity/QRLoginActivity:jdField_b_of_type_AndroidWidgetButton	Landroid/widget/Button;
    //   3477: bipush 8
    //   3479: invokevirtual 254	android/widget/Button:setVisibility	(I)V
    //   3482: goto -366 -> 3116
    //   3485: aload_0
    //   3486: getfield 10	jcg:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   3489: new 86	java/lang/String
    //   3492: dup
    //   3493: aload_1
    //   3494: invokespecial 92	java/lang/String:<init>	([B)V
    //   3497: invokevirtual 257	com/tencent/biz/qrcode/activity/QRLoginActivity:a	(Ljava/lang/String;)V
    //   3500: return
    //   3501: aload_2
    //   3502: ldc 38
    //   3504: iconst_1
    //   3505: invokevirtual 44	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   3508: istore 22
    //   3510: aload_2
    //   3511: ldc 54
    //   3513: invokevirtual 50	android/os/Bundle:getByteArray	(Ljava/lang/String;)[B
    //   3516: astore_1
    //   3517: aload_0
    //   3518: getfield 10	jcg:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   3521: getfield 260	com/tencent/biz/qrcode/activity/QRLoginActivity:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   3524: invokevirtual 265	com/tencent/mobileqq/widget/QQProgressDialog:isShowing	()Z
    //   3527: ifeq +13 -> 3540
    //   3530: aload_0
    //   3531: getfield 10	jcg:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   3534: getfield 260	com/tencent/biz/qrcode/activity/QRLoginActivity:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   3537: invokevirtual 268	com/tencent/mobileqq/widget/QQProgressDialog:dismiss	()V
    //   3540: iload 22
    //   3542: ifne +11 -> 3553
    //   3545: aload_0
    //   3546: getfield 10	jcg:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   3549: invokevirtual 270	com/tencent/biz/qrcode/activity/QRLoginActivity:b	()V
    //   3552: return
    //   3553: aload_0
    //   3554: getfield 10	jcg:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   3557: new 86	java/lang/String
    //   3560: dup
    //   3561: aload_1
    //   3562: invokespecial 92	java/lang/String:<init>	([B)V
    //   3565: invokevirtual 257	com/tencent/biz/qrcode/activity/QRLoginActivity:a	(Ljava/lang/String;)V
    //   3568: return
    //   3569: aload_0
    //   3570: getfield 10	jcg:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   3573: getfield 260	com/tencent/biz/qrcode/activity/QRLoginActivity:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   3576: ifnull +26 -> 3602
    //   3579: aload_0
    //   3580: getfield 10	jcg:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   3583: getfield 260	com/tencent/biz/qrcode/activity/QRLoginActivity:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   3586: invokevirtual 265	com/tencent/mobileqq/widget/QQProgressDialog:isShowing	()Z
    //   3589: ifeq +13 -> 3602
    //   3592: aload_0
    //   3593: getfield 10	jcg:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   3596: getfield 260	com/tencent/biz/qrcode/activity/QRLoginActivity:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   3599: invokevirtual 268	com/tencent/mobileqq/widget/QQProgressDialog:dismiss	()V
    //   3602: aload_0
    //   3603: getfield 10	jcg:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   3606: getfield 68	com/tencent/biz/qrcode/activity/QRLoginActivity:jdField_a_of_type_AndroidWidgetProgressBar	Landroid/widget/ProgressBar;
    //   3609: bipush 8
    //   3611: invokevirtual 71	android/widget/ProgressBar:setVisibility	(I)V
    //   3614: aload_0
    //   3615: getfield 10	jcg:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   3618: getfield 59	com/tencent/biz/qrcode/activity/QRLoginActivity:jdField_a_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   3621: iconst_0
    //   3622: invokevirtual 65	android/widget/LinearLayout:setVisibility	(I)V
    //   3625: aload_0
    //   3626: getfield 10	jcg:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   3629: aconst_null
    //   3630: invokevirtual 257	com/tencent/biz/qrcode/activity/QRLoginActivity:a	(Ljava/lang/String;)V
    //   3633: return
    //   3634: astore 5
    //   3636: iload 23
    //   3638: istore 24
    //   3640: iload 36
    //   3642: istore 23
    //   3644: goto -484 -> 3160
    //   3647: astore_1
    //   3648: aload 5
    //   3650: astore_1
    //   3651: aload 4
    //   3653: astore 5
    //   3655: iload 23
    //   3657: istore 25
    //   3659: iload 22
    //   3661: istore 23
    //   3663: iload 25
    //   3665: istore 22
    //   3667: aload_3
    //   3668: astore 4
    //   3670: aload 5
    //   3672: astore_3
    //   3673: goto -513 -> 3160
    //   3676: astore 9
    //   3678: aload_3
    //   3679: astore 5
    //   3681: iload 22
    //   3683: istore 26
    //   3685: iload 35
    //   3687: istore 22
    //   3689: iload 23
    //   3691: istore 24
    //   3693: iload 26
    //   3695: istore 23
    //   3697: aload 4
    //   3699: astore_3
    //   3700: aload 5
    //   3702: astore 4
    //   3704: aload_1
    //   3705: astore 5
    //   3707: goto -976 -> 2731
    //   3710: goto -729 -> 2981
    //   3713: aload 4
    //   3715: astore 8
    //   3717: goto -834 -> 2883
    //   3720: iconst_0
    //   3721: istore 23
    //   3723: aload 19
    //   3725: astore_2
    //   3726: goto -1140 -> 2586
    //   3729: iload 22
    //   3731: istore 26
    //   3733: aload_2
    //   3734: astore 7
    //   3736: aload_3
    //   3737: astore 9
    //   3739: aload_1
    //   3740: astore 10
    //   3742: aload 6
    //   3744: astore_1
    //   3745: iload 23
    //   3747: istore 22
    //   3749: iload 26
    //   3751: istore 23
    //   3753: aload 5
    //   3755: astore_2
    //   3756: aload 4
    //   3758: astore_3
    //   3759: aload 7
    //   3761: astore 4
    //   3763: aload 9
    //   3765: astore 5
    //   3767: aload 10
    //   3769: astore 6
    //   3771: goto -3379 -> 392
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3774	0	this	jcg
    //   0	3774	1	paramMessage	android.os.Message
    //   4	3752	2	localObject1	Object
    //   52	3707	3	localObject2	Object
    //   162	3600	4	localObject3	Object
    //   165	3043	5	localObject4	Object
    //   3634	15	5	localException	Exception
    //   3653	113	5	localObject5	Object
    //   174	3596	6	localObject6	Object
    //   356	3404	7	localObject7	Object
    //   177	3539	8	localObject8	Object
    //   199	2480	9	localObject9	Object
    //   2695	451	9	localThrowable1	Throwable
    //   3676	1	9	localThrowable2	Throwable
    //   3737	27	9	localObject10	Object
    //   203	3565	10	localObject11	Object
    //   348	2372	11	localObject12	Object
    //   206	2933	12	localObject13	Object
    //   602	2114	13	localObject14	Object
    //   209	2927	14	localObject15	Object
    //   599	2113	15	localObject16	Object
    //   212	2920	16	localObject17	Object
    //   596	2113	17	localObject18	Object
    //   592	2114	18	localObject19	Object
    //   2421	1303	19	localObject20	Object
    //   59	652	20	arrayOfByte	byte[]
    //   791	1811	21	localSchemePkg	com.tencent.ims.devlock_verify_scheme.SchemePkg
    //   44	3704	22	i	int
    //   171	3581	23	j	int
    //   180	3512	24	k	int
    //   227	3437	25	m	int
    //   195	3555	26	n	int
    //   183	2519	27	i1	int
    //   576	2152	28	i2	int
    //   187	2970	29	i3	int
    //   580	2144	30	i4	int
    //   191	2962	31	i5	int
    //   584	2114	32	i6	int
    //   882	321	33	i7	int
    //   864	1796	34	i8	int
    //   870	2816	35	i9	int
    //   876	2765	36	i10	int
    //   867	1645	37	i11	int
    //   873	1668	38	i12	int
    //   879	317	39	i13	int
    //   292	426	40	i14	int
    //   2573	6	41	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   636	642	2695	java/lang/Throwable
    //   710	722	2695	java/lang/Throwable
    //   784	793	2695	java/lang/Throwable
    //   855	863	2695	java/lang/Throwable
    //   946	957	2695	java/lang/Throwable
    //   1019	1029	2695	java/lang/Throwable
    //   1108	1119	2695	java/lang/Throwable
    //   1181	1191	2695	java/lang/Throwable
    //   1270	1281	2695	java/lang/Throwable
    //   1343	1353	2695	java/lang/Throwable
    //   1419	1430	2695	java/lang/Throwable
    //   1494	1503	2695	java/lang/Throwable
    //   1569	1580	2695	java/lang/Throwable
    //   1644	1653	2695	java/lang/Throwable
    //   1717	1728	2695	java/lang/Throwable
    //   1792	1807	2695	java/lang/Throwable
    //   1871	1882	2695	java/lang/Throwable
    //   1946	1956	2695	java/lang/Throwable
    //   2028	2038	2695	java/lang/Throwable
    //   2105	2116	2695	java/lang/Throwable
    //   2180	2195	2695	java/lang/Throwable
    //   2259	2270	2695	java/lang/Throwable
    //   2334	2349	2695	java/lang/Throwable
    //   2423	2434	2695	java/lang/Throwable
    //   2498	2507	2695	java/lang/Throwable
    //   2569	2575	2695	java/lang/Throwable
    //   214	222	3130	java/lang/Exception
    //   335	350	3130	java/lang/Exception
    //   503	518	3130	java/lang/Exception
    //   636	642	3130	java/lang/Exception
    //   710	722	3130	java/lang/Exception
    //   784	793	3130	java/lang/Exception
    //   855	863	3130	java/lang/Exception
    //   946	957	3130	java/lang/Exception
    //   1019	1029	3130	java/lang/Exception
    //   1108	1119	3130	java/lang/Exception
    //   1181	1191	3130	java/lang/Exception
    //   1270	1281	3130	java/lang/Exception
    //   1343	1353	3130	java/lang/Exception
    //   1419	1430	3130	java/lang/Exception
    //   1494	1503	3130	java/lang/Exception
    //   1569	1580	3130	java/lang/Exception
    //   1644	1653	3130	java/lang/Exception
    //   1717	1728	3130	java/lang/Exception
    //   1792	1807	3130	java/lang/Exception
    //   1871	1882	3130	java/lang/Exception
    //   1946	1956	3130	java/lang/Exception
    //   2028	2038	3130	java/lang/Exception
    //   2105	2116	3130	java/lang/Exception
    //   2180	2195	3130	java/lang/Exception
    //   2259	2270	3130	java/lang/Exception
    //   2334	2349	3130	java/lang/Exception
    //   2423	2434	3130	java/lang/Exception
    //   2498	2507	3130	java/lang/Exception
    //   2569	2575	3130	java/lang/Exception
    //   2586	2612	3634	java/lang/Exception
    //   2621	2630	3634	java/lang/Exception
    //   2731	2736	3647	java/lang/Exception
    //   2586	2612	3676	java/lang/Throwable
    //   2621	2630	3676	java/lang/Throwable
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jcg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
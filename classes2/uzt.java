import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.theme.ThemeSwitchManager;
import com.tencent.mobileqq.transfile.TransProcessorHandler;

public class uzt
  extends TransProcessorHandler
{
  private uzt(ThemeSwitchManager paramThemeSwitchManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  /* Error */
  public void handleMessage(android.os.Message paramMessage)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 33	android/os/Message:obj	Ljava/lang/Object;
    //   4: checkcast 35	com/tencent/mobileqq/transfile/FileMsg
    //   7: astore_3
    //   8: aload_3
    //   9: ifnull +131 -> 140
    //   12: aload_1
    //   13: getfield 39	android/os/Message:what	I
    //   16: istore 9
    //   18: aload_3
    //   19: getfield 43	com/tencent/mobileqq/transfile/FileMsg:e	Ljava/lang/String;
    //   22: astore_1
    //   23: aload_3
    //   24: getfield 47	com/tencent/mobileqq/transfile/FileMsg:f	J
    //   27: lstore 10
    //   29: invokestatic 53	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   32: ifeq +58 -> 90
    //   35: ldc 55
    //   37: iconst_2
    //   38: new 57	java/lang/StringBuilder
    //   41: dup
    //   42: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   45: ldc 60
    //   47: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: iload 9
    //   52: invokevirtual 67	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   55: ldc 69
    //   57: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: ldc 69
    //   62: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: aload_1
    //   66: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: ldc 69
    //   71: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: lload 10
    //   76: invokevirtual 72	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   79: ldc 69
    //   81: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   87: invokestatic 80	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   90: aload_1
    //   91: invokestatic 86	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   94: ifne +13 -> 107
    //   97: aload_1
    //   98: getstatic 91	com/tencent/mobileqq/app/AppConstants:cG	Ljava/lang/String;
    //   101: invokevirtual 97	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   104: ifne +37 -> 141
    //   107: invokestatic 53	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   110: ifeq +30 -> 140
    //   113: ldc 55
    //   115: iconst_2
    //   116: new 57	java/lang/StringBuilder
    //   119: dup
    //   120: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   123: ldc 99
    //   125: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: getstatic 91	com/tencent/mobileqq/app/AppConstants:cG	Ljava/lang/String;
    //   131: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   137: invokestatic 102	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   140: return
    //   141: aload_0
    //   142: getfield 10	uzt:a	Lcom/tencent/mobileqq/theme/ThemeSwitchManager;
    //   145: getfield 107	com/tencent/mobileqq/theme/ThemeSwitchManager:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   148: aload_0
    //   149: getfield 10	uzt:a	Lcom/tencent/mobileqq/theme/ThemeSwitchManager;
    //   152: getfield 109	com/tencent/mobileqq/theme/ThemeSwitchManager:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   155: invokevirtual 115	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   158: checkcast 117	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo
    //   161: astore_1
    //   162: aload_1
    //   163: ifnull +17 -> 180
    //   166: aload_1
    //   167: getfield 120	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:downloadUrl	Ljava/lang/String;
    //   170: aload_3
    //   171: getfield 123	com/tencent/mobileqq/transfile/FileMsg:k	Ljava/lang/String;
    //   174: invokevirtual 127	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   177: ifne +38 -> 215
    //   180: invokestatic 130	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   183: ifeq -43 -> 140
    //   186: ldc 55
    //   188: iconst_4
    //   189: new 57	java/lang/StringBuilder
    //   192: dup
    //   193: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   196: ldc -124
    //   198: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: aload_3
    //   202: getfield 123	com/tencent/mobileqq/transfile/FileMsg:k	Ljava/lang/String;
    //   205: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   211: invokestatic 102	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   214: return
    //   215: new 134	android/os/Bundle
    //   218: dup
    //   219: invokespecial 135	android/os/Bundle:<init>	()V
    //   222: astore_2
    //   223: iconst_0
    //   224: istore 8
    //   226: iload 9
    //   228: sipush 2002
    //   231: if_icmpne +317 -> 548
    //   234: invokestatic 130	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   237: ifeq +41 -> 278
    //   240: ldc 55
    //   242: iconst_4
    //   243: new 57	java/lang/StringBuilder
    //   246: dup
    //   247: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   250: ldc -119
    //   252: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: lload 10
    //   257: invokevirtual 72	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   260: ldc -117
    //   262: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: aload_3
    //   266: getfield 141	com/tencent/mobileqq/transfile/FileMsg:a	J
    //   269: invokevirtual 72	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   272: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   275: invokestatic 102	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   278: aload_1
    //   279: ifnull +120 -> 399
    //   282: aload_1
    //   283: lload 10
    //   285: putfield 144	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:downsize	J
    //   288: aload_1
    //   289: ldc -110
    //   291: putfield 149	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:status	Ljava/lang/String;
    //   294: aload_0
    //   295: getfield 10	uzt:a	Lcom/tencent/mobileqq/theme/ThemeSwitchManager;
    //   298: getfield 107	com/tencent/mobileqq/theme/ThemeSwitchManager:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   301: aload_0
    //   302: getfield 10	uzt:a	Lcom/tencent/mobileqq/theme/ThemeSwitchManager;
    //   305: getfield 109	com/tencent/mobileqq/theme/ThemeSwitchManager:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   308: aload_1
    //   309: invokevirtual 153	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   312: pop
    //   313: aload_0
    //   314: getfield 10	uzt:a	Lcom/tencent/mobileqq/theme/ThemeSwitchManager;
    //   317: getfield 156	com/tencent/mobileqq/theme/ThemeSwitchManager:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   320: aload_1
    //   321: invokestatic 162	com/tencent/mobileqq/theme/ThemeUtil:setThemeInfo	(Landroid/content/Context;Lcom/tencent/mobileqq/theme/ThemeUtil$ThemeInfo;)Ljava/lang/Boolean;
    //   324: pop
    //   325: aload_2
    //   326: ldc -92
    //   328: iconst_3
    //   329: invokevirtual 168	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   332: aload_2
    //   333: ldc -86
    //   335: lload 10
    //   337: invokevirtual 174	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   340: aload_2
    //   341: ldc -80
    //   343: aload_1
    //   344: getfield 179	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:size	J
    //   347: invokevirtual 174	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   350: aload_0
    //   351: getfield 10	uzt:a	Lcom/tencent/mobileqq/theme/ThemeSwitchManager;
    //   354: iconst_1
    //   355: iconst_0
    //   356: aload_2
    //   357: invokevirtual 182	com/tencent/mobileqq/theme/ThemeSwitchManager:a	(ZZLandroid/os/Bundle;)V
    //   360: iload 8
    //   362: istore 7
    //   364: lload 10
    //   366: aload_1
    //   367: getfield 179	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:size	J
    //   370: lcmp
    //   371: ifne +14 -> 385
    //   374: aload_0
    //   375: sipush 2002
    //   378: invokevirtual 186	uzt:removeMessages	(I)V
    //   381: iload 8
    //   383: istore 7
    //   385: iload 7
    //   387: ifeq -247 -> 140
    //   390: aload_0
    //   391: getfield 10	uzt:a	Lcom/tencent/mobileqq/theme/ThemeSwitchManager;
    //   394: aload_2
    //   395: invokevirtual 189	com/tencent/mobileqq/theme/ThemeSwitchManager:a	(Landroid/os/Bundle;)V
    //   398: return
    //   399: getstatic 192	com/tencent/mobileqq/theme/ThemeSwitchManager:b	Z
    //   402: ifeq +98 -> 500
    //   405: invokestatic 53	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   408: ifeq +34 -> 442
    //   411: ldc 55
    //   413: iconst_2
    //   414: new 57	java/lang/StringBuilder
    //   417: dup
    //   418: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   421: ldc -62
    //   423: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   426: aload_0
    //   427: getfield 10	uzt:a	Lcom/tencent/mobileqq/theme/ThemeSwitchManager;
    //   430: getfield 109	com/tencent/mobileqq/theme/ThemeSwitchManager:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   433: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   436: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   439: invokestatic 102	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   442: iconst_0
    //   443: putstatic 192	com/tencent/mobileqq/theme/ThemeSwitchManager:b	Z
    //   446: aload_2
    //   447: ldc -92
    //   449: sipush 256
    //   452: invokevirtual 168	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   455: aload_2
    //   456: ldc -60
    //   458: new 57	java/lang/StringBuilder
    //   461: dup
    //   462: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   465: ldc -62
    //   467: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   470: aload_0
    //   471: getfield 10	uzt:a	Lcom/tencent/mobileqq/theme/ThemeSwitchManager;
    //   474: getfield 109	com/tencent/mobileqq/theme/ThemeSwitchManager:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   477: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   480: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   483: invokevirtual 200	android/os/Bundle:putCharSequence	(Ljava/lang/String;Ljava/lang/CharSequence;)V
    //   486: iconst_1
    //   487: istore 7
    //   489: aload_2
    //   490: ldc -54
    //   492: ldc -52
    //   494: invokevirtual 200	android/os/Bundle:putCharSequence	(Ljava/lang/String;Ljava/lang/CharSequence;)V
    //   497: goto -112 -> 385
    //   500: iload 8
    //   502: istore 7
    //   504: invokestatic 53	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   507: ifeq -122 -> 385
    //   510: ldc 55
    //   512: iconst_2
    //   513: new 57	java/lang/StringBuilder
    //   516: dup
    //   517: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   520: ldc -50
    //   522: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   525: aload_0
    //   526: getfield 10	uzt:a	Lcom/tencent/mobileqq/theme/ThemeSwitchManager;
    //   529: getfield 109	com/tencent/mobileqq/theme/ThemeSwitchManager:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   532: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   535: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   538: invokestatic 102	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   541: iload 8
    //   543: istore 7
    //   545: goto -160 -> 385
    //   548: iload 9
    //   550: sipush 2003
    //   553: if_icmpne +1010 -> 1563
    //   556: aload_0
    //   557: getfield 10	uzt:a	Lcom/tencent/mobileqq/theme/ThemeSwitchManager;
    //   560: getfield 107	com/tencent/mobileqq/theme/ThemeSwitchManager:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   563: aload_0
    //   564: getfield 10	uzt:a	Lcom/tencent/mobileqq/theme/ThemeSwitchManager;
    //   567: getfield 109	com/tencent/mobileqq/theme/ThemeSwitchManager:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   570: invokevirtual 115	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   573: checkcast 117	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo
    //   576: astore 4
    //   578: new 111	java/util/HashMap
    //   581: dup
    //   582: invokespecial 207	java/util/HashMap:<init>	()V
    //   585: astore_3
    //   586: getstatic 212	com/tencent/common/app/BaseApplicationImpl:a	Lcom/tencent/common/app/BaseApplicationImpl;
    //   589: invokevirtual 215	com/tencent/common/app/BaseApplicationImpl:a	()Lmqq/app/AppRuntime;
    //   592: checkcast 217	com/tencent/mobileqq/app/QQAppInterface
    //   595: astore 5
    //   597: aconst_null
    //   598: invokestatic 222	com/tencent/mobileqq/utils/NetworkUtil:a	(Landroid/content/Context;)I
    //   601: istore 7
    //   603: aload 4
    //   605: ifnull +230 -> 835
    //   608: aload 4
    //   610: getfield 225	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:version	Ljava/lang/String;
    //   613: astore_1
    //   614: aload 5
    //   616: ldc -29
    //   618: ldc -27
    //   620: sipush 153
    //   623: iload 7
    //   625: bipush 9
    //   627: ldc -25
    //   629: aload_1
    //   630: getstatic 236	com/tencent/mobileqq/theme/ThemeReporter:t	Ljava/lang/String;
    //   633: ldc -18
    //   635: invokestatic 241	com/tencent/mobileqq/theme/ThemeReporter:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   638: aload 4
    //   640: ifnull +821 -> 1461
    //   643: invokestatic 130	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   646: ifeq +32 -> 678
    //   649: ldc 55
    //   651: iconst_4
    //   652: new 57	java/lang/StringBuilder
    //   655: dup
    //   656: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   659: ldc -13
    //   661: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   664: aload 4
    //   666: getfield 246	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:themeId	Ljava/lang/String;
    //   669: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   672: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   675: invokestatic 102	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   678: aload_3
    //   679: ldc -8
    //   681: aload 4
    //   683: getfield 246	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:themeId	Ljava/lang/String;
    //   686: invokevirtual 153	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   689: pop
    //   690: aload_3
    //   691: ldc -6
    //   693: aload 4
    //   695: getfield 225	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:version	Ljava/lang/String;
    //   698: invokevirtual 153	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   701: pop
    //   702: aload 4
    //   704: lload 10
    //   706: putfield 144	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:downsize	J
    //   709: aload 4
    //   711: ldc -4
    //   713: putfield 149	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:status	Ljava/lang/String;
    //   716: aload_0
    //   717: getfield 10	uzt:a	Lcom/tencent/mobileqq/theme/ThemeSwitchManager;
    //   720: getfield 107	com/tencent/mobileqq/theme/ThemeSwitchManager:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   723: aload_0
    //   724: getfield 10	uzt:a	Lcom/tencent/mobileqq/theme/ThemeSwitchManager;
    //   727: getfield 109	com/tencent/mobileqq/theme/ThemeSwitchManager:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   730: invokevirtual 255	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   733: pop
    //   734: aload_0
    //   735: getfield 10	uzt:a	Lcom/tencent/mobileqq/theme/ThemeSwitchManager;
    //   738: getfield 156	com/tencent/mobileqq/theme/ThemeSwitchManager:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   741: aload 4
    //   743: invokestatic 162	com/tencent/mobileqq/theme/ThemeUtil:setThemeInfo	(Landroid/content/Context;Lcom/tencent/mobileqq/theme/ThemeUtil$ThemeInfo;)Ljava/lang/Boolean;
    //   746: pop
    //   747: aload_2
    //   748: ldc -92
    //   750: iconst_1
    //   751: invokevirtual 168	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   754: aload_2
    //   755: ldc -60
    //   757: ldc_w 257
    //   760: invokevirtual 200	android/os/Bundle:putCharSequence	(Ljava/lang/String;Ljava/lang/CharSequence;)V
    //   763: iconst_0
    //   764: putstatic 192	com/tencent/mobileqq/theme/ThemeSwitchManager:b	Z
    //   767: aload_0
    //   768: getfield 10	uzt:a	Lcom/tencent/mobileqq/theme/ThemeSwitchManager;
    //   771: aload_0
    //   772: getfield 10	uzt:a	Lcom/tencent/mobileqq/theme/ThemeSwitchManager;
    //   775: getfield 156	com/tencent/mobileqq/theme/ThemeSwitchManager:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   778: invokevirtual 260	com/tencent/mobileqq/theme/ThemeSwitchManager:a	(Landroid/content/Context;)[Ljava/lang/String;
    //   781: astore_1
    //   782: aload_1
    //   783: ifnonnull +58 -> 841
    //   786: aload_3
    //   787: ldc_w 262
    //   790: ldc_w 264
    //   793: invokevirtual 153	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   796: pop
    //   797: aload_0
    //   798: getfield 10	uzt:a	Lcom/tencent/mobileqq/theme/ThemeSwitchManager;
    //   801: getfield 156	com/tencent/mobileqq/theme/ThemeSwitchManager:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   804: invokestatic 269	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   807: getstatic 212	com/tencent/common/app/BaseApplicationImpl:a	Lcom/tencent/common/app/BaseApplicationImpl;
    //   810: invokevirtual 215	com/tencent/common/app/BaseApplicationImpl:a	()Lmqq/app/AppRuntime;
    //   813: checkcast 217	com/tencent/mobileqq/app/QQAppInterface
    //   816: invokevirtual 272	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   819: ldc_w 274
    //   822: iconst_0
    //   823: lconst_1
    //   824: lconst_0
    //   825: aload_3
    //   826: ldc -18
    //   828: iconst_0
    //   829: invokevirtual 277	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   832: return
    //   833: astore_1
    //   834: return
    //   835: ldc -18
    //   837: astore_1
    //   838: goto -224 -> 614
    //   841: aload_1
    //   842: iconst_1
    //   843: aaload
    //   844: astore 5
    //   846: aload_0
    //   847: getfield 10	uzt:a	Lcom/tencent/mobileqq/theme/ThemeSwitchManager;
    //   850: getfield 280	com/tencent/mobileqq/theme/ThemeSwitchManager:jdField_a_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   853: invokevirtual 285	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   856: checkcast 287	android/app/Activity
    //   859: astore 6
    //   861: aload 5
    //   863: ifnull +138 -> 1001
    //   866: aload 6
    //   868: ifnull +133 -> 1001
    //   871: aload 5
    //   873: ldc_w 289
    //   876: invokevirtual 294	java/lang/Class:getName	()Ljava/lang/String;
    //   879: invokevirtual 127	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   882: ifeq +119 -> 1001
    //   885: aload 6
    //   887: instanceof 289
    //   890: ifeq +111 -> 1001
    //   893: aload 6
    //   895: checkcast 289	com/tencent/mobileqq/activity/SplashActivity
    //   898: invokevirtual 297	com/tencent/mobileqq/activity/SplashActivity:a	()I
    //   901: iconst_3
    //   902: if_icmpne +99 -> 1001
    //   905: aload_2
    //   906: ldc_w 299
    //   909: aload 4
    //   911: invokevirtual 303	android/os/Bundle:putSerializable	(Ljava/lang/String;Ljava/io/Serializable;)V
    //   914: aload_0
    //   915: getfield 10	uzt:a	Lcom/tencent/mobileqq/theme/ThemeSwitchManager;
    //   918: invokevirtual 305	com/tencent/mobileqq/theme/ThemeSwitchManager:a	()Z
    //   921: ifeq +13 -> 934
    //   924: aload_0
    //   925: getfield 10	uzt:a	Lcom/tencent/mobileqq/theme/ThemeSwitchManager;
    //   928: iconst_1
    //   929: iconst_0
    //   930: aload_2
    //   931: invokevirtual 182	com/tencent/mobileqq/theme/ThemeSwitchManager:a	(ZZLandroid/os/Bundle;)V
    //   934: aload_0
    //   935: getfield 10	uzt:a	Lcom/tencent/mobileqq/theme/ThemeSwitchManager;
    //   938: getstatic 212	com/tencent/common/app/BaseApplicationImpl:a	Lcom/tencent/common/app/BaseApplicationImpl;
    //   941: invokevirtual 215	com/tencent/common/app/BaseApplicationImpl:a	()Lmqq/app/AppRuntime;
    //   944: aload 4
    //   946: invokevirtual 308	com/tencent/mobileqq/theme/ThemeSwitchManager:b	(Lmqq/app/AppRuntime;Lcom/tencent/mobileqq/theme/ThemeUtil$ThemeInfo;)V
    //   949: aload_3
    //   950: ldc_w 262
    //   953: ldc_w 310
    //   956: invokevirtual 153	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   959: pop
    //   960: aload_0
    //   961: getfield 10	uzt:a	Lcom/tencent/mobileqq/theme/ThemeSwitchManager;
    //   964: getfield 156	com/tencent/mobileqq/theme/ThemeSwitchManager:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   967: invokestatic 269	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   970: getstatic 212	com/tencent/common/app/BaseApplicationImpl:a	Lcom/tencent/common/app/BaseApplicationImpl;
    //   973: invokevirtual 215	com/tencent/common/app/BaseApplicationImpl:a	()Lmqq/app/AppRuntime;
    //   976: checkcast 217	com/tencent/mobileqq/app/QQAppInterface
    //   979: invokevirtual 272	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   982: ldc_w 274
    //   985: iconst_1
    //   986: lconst_1
    //   987: lconst_0
    //   988: aload_3
    //   989: ldc -18
    //   991: iconst_0
    //   992: invokevirtual 277	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   995: iconst_0
    //   996: istore 7
    //   998: goto -613 -> 385
    //   1001: aload_1
    //   1002: iconst_0
    //   1003: aaload
    //   1004: aload_0
    //   1005: getfield 10	uzt:a	Lcom/tencent/mobileqq/theme/ThemeSwitchManager;
    //   1008: getfield 156	com/tencent/mobileqq/theme/ThemeSwitchManager:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   1011: invokevirtual 315	android/content/Context:getPackageName	()Ljava/lang/String;
    //   1014: invokevirtual 127	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1017: ifeq +45 -> 1062
    //   1020: aload 5
    //   1022: ldc_w 317
    //   1025: invokevirtual 294	java/lang/Class:getName	()Ljava/lang/String;
    //   1028: invokevirtual 127	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1031: ifne +31 -> 1062
    //   1034: aload 5
    //   1036: ldc_w 319
    //   1039: invokevirtual 294	java/lang/Class:getName	()Ljava/lang/String;
    //   1042: invokevirtual 127	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1045: ifne +17 -> 1062
    //   1048: aload 5
    //   1050: ldc_w 321
    //   1053: invokevirtual 294	java/lang/Class:getName	()Ljava/lang/String;
    //   1056: invokevirtual 127	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1059: ifeq +201 -> 1260
    //   1062: aload_0
    //   1063: getfield 10	uzt:a	Lcom/tencent/mobileqq/theme/ThemeSwitchManager;
    //   1066: getfield 324	com/tencent/mobileqq/theme/ThemeSwitchManager:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   1069: ifnonnull +13 -> 1082
    //   1072: aload_0
    //   1073: getfield 10	uzt:a	Lcom/tencent/mobileqq/theme/ThemeSwitchManager;
    //   1076: invokestatic 329	com/tencent/mobileqq/app/ThreadManager:b	()Lmqq/os/MqqHandler;
    //   1079: putfield 324	com/tencent/mobileqq/theme/ThemeSwitchManager:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   1082: aload_0
    //   1083: getfield 10	uzt:a	Lcom/tencent/mobileqq/theme/ThemeSwitchManager;
    //   1086: iconst_0
    //   1087: putfield 331	com/tencent/mobileqq/theme/ThemeSwitchManager:jdField_d_of_type_Boolean	Z
    //   1090: aload_0
    //   1091: getfield 10	uzt:a	Lcom/tencent/mobileqq/theme/ThemeSwitchManager;
    //   1094: getfield 334	com/tencent/mobileqq/theme/ThemeSwitchManager:jdField_a_of_type_JavaLangRunnable	Ljava/lang/Runnable;
    //   1097: ifnonnull +23 -> 1120
    //   1100: aload_0
    //   1101: getfield 10	uzt:a	Lcom/tencent/mobileqq/theme/ThemeSwitchManager;
    //   1104: new 336	uzu
    //   1107: dup
    //   1108: aload_0
    //   1109: aload 6
    //   1111: aload_2
    //   1112: aload 4
    //   1114: invokespecial 339	uzu:<init>	(Luzt;Landroid/app/Activity;Landroid/os/Bundle;Lcom/tencent/mobileqq/theme/ThemeUtil$ThemeInfo;)V
    //   1117: putfield 334	com/tencent/mobileqq/theme/ThemeSwitchManager:jdField_a_of_type_JavaLangRunnable	Ljava/lang/Runnable;
    //   1120: new 341	android/content/IntentFilter
    //   1123: dup
    //   1124: invokespecial 342	android/content/IntentFilter:<init>	()V
    //   1127: astore_1
    //   1128: aload_1
    //   1129: ldc_w 344
    //   1132: invokevirtual 348	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   1135: aload_1
    //   1136: ldc_w 350
    //   1139: invokevirtual 348	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   1142: aload_0
    //   1143: getfield 10	uzt:a	Lcom/tencent/mobileqq/theme/ThemeSwitchManager;
    //   1146: getfield 353	com/tencent/mobileqq/theme/ThemeSwitchManager:jdField_a_of_type_AndroidContentBroadcastReceiver	Landroid/content/BroadcastReceiver;
    //   1149: ifnonnull +18 -> 1167
    //   1152: aload_0
    //   1153: getfield 10	uzt:a	Lcom/tencent/mobileqq/theme/ThemeSwitchManager;
    //   1156: new 355	uzv
    //   1159: dup
    //   1160: aload_0
    //   1161: invokespecial 358	uzv:<init>	(Luzt;)V
    //   1164: putfield 353	com/tencent/mobileqq/theme/ThemeSwitchManager:jdField_a_of_type_AndroidContentBroadcastReceiver	Landroid/content/BroadcastReceiver;
    //   1167: aload_0
    //   1168: getfield 10	uzt:a	Lcom/tencent/mobileqq/theme/ThemeSwitchManager;
    //   1171: getfield 156	com/tencent/mobileqq/theme/ThemeSwitchManager:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   1174: aload_0
    //   1175: getfield 10	uzt:a	Lcom/tencent/mobileqq/theme/ThemeSwitchManager;
    //   1178: getfield 353	com/tencent/mobileqq/theme/ThemeSwitchManager:jdField_a_of_type_AndroidContentBroadcastReceiver	Landroid/content/BroadcastReceiver;
    //   1181: aload_1
    //   1182: invokevirtual 362	android/content/Context:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    //   1185: pop
    //   1186: aload_0
    //   1187: getfield 10	uzt:a	Lcom/tencent/mobileqq/theme/ThemeSwitchManager;
    //   1190: getfield 324	com/tencent/mobileqq/theme/ThemeSwitchManager:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   1193: aload_0
    //   1194: getfield 10	uzt:a	Lcom/tencent/mobileqq/theme/ThemeSwitchManager;
    //   1197: getfield 334	com/tencent/mobileqq/theme/ThemeSwitchManager:jdField_a_of_type_JavaLangRunnable	Ljava/lang/Runnable;
    //   1200: ldc2_w 363
    //   1203: invokevirtual 370	mqq/os/MqqHandler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   1206: pop
    //   1207: aload_3
    //   1208: ldc_w 262
    //   1211: ldc_w 372
    //   1214: invokevirtual 153	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1217: pop
    //   1218: aload_0
    //   1219: getfield 10	uzt:a	Lcom/tencent/mobileqq/theme/ThemeSwitchManager;
    //   1222: getfield 156	com/tencent/mobileqq/theme/ThemeSwitchManager:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   1225: invokestatic 269	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   1228: getstatic 212	com/tencent/common/app/BaseApplicationImpl:a	Lcom/tencent/common/app/BaseApplicationImpl;
    //   1231: invokevirtual 215	com/tencent/common/app/BaseApplicationImpl:a	()Lmqq/app/AppRuntime;
    //   1234: checkcast 217	com/tencent/mobileqq/app/QQAppInterface
    //   1237: invokevirtual 272	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   1240: ldc_w 274
    //   1243: iconst_1
    //   1244: lconst_1
    //   1245: lconst_0
    //   1246: aload_3
    //   1247: ldc -18
    //   1249: iconst_0
    //   1250: invokevirtual 277	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   1253: goto -258 -> 995
    //   1256: astore_1
    //   1257: goto -262 -> 995
    //   1260: aload_0
    //   1261: getfield 10	uzt:a	Lcom/tencent/mobileqq/theme/ThemeSwitchManager;
    //   1264: invokevirtual 305	com/tencent/mobileqq/theme/ThemeSwitchManager:a	()Z
    //   1267: ifeq -60 -> 1207
    //   1270: new 374	android/content/Intent
    //   1273: dup
    //   1274: invokespecial 375	android/content/Intent:<init>	()V
    //   1277: astore_1
    //   1278: aload_1
    //   1279: ldc_w 377
    //   1282: iconst_1
    //   1283: invokevirtual 381	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   1286: pop
    //   1287: aload_1
    //   1288: ldc_w 383
    //   1291: aload 4
    //   1293: getfield 246	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:themeId	Ljava/lang/String;
    //   1296: invokevirtual 386	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1299: pop
    //   1300: aload_1
    //   1301: aload_0
    //   1302: getfield 10	uzt:a	Lcom/tencent/mobileqq/theme/ThemeSwitchManager;
    //   1305: getfield 156	com/tencent/mobileqq/theme/ThemeSwitchManager:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   1308: ldc_w 388
    //   1311: invokevirtual 392	android/content/Intent:setClass	(Landroid/content/Context;Ljava/lang/Class;)Landroid/content/Intent;
    //   1314: pop
    //   1315: getstatic 398	com/tencent/mobileqq/app/BaseActivity:sTopActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   1318: ifnull +59 -> 1377
    //   1321: getstatic 398	com/tencent/mobileqq/app/BaseActivity:sTopActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   1324: aload_1
    //   1325: invokevirtual 402	com/tencent/mobileqq/app/BaseActivity:startActivity	(Landroid/content/Intent;)V
    //   1328: aload_3
    //   1329: ldc_w 262
    //   1332: ldc_w 404
    //   1335: invokevirtual 153	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1338: pop
    //   1339: aload_0
    //   1340: getfield 10	uzt:a	Lcom/tencent/mobileqq/theme/ThemeSwitchManager;
    //   1343: getfield 156	com/tencent/mobileqq/theme/ThemeSwitchManager:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   1346: invokestatic 269	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   1349: getstatic 212	com/tencent/common/app/BaseApplicationImpl:a	Lcom/tencent/common/app/BaseApplicationImpl;
    //   1352: invokevirtual 215	com/tencent/common/app/BaseApplicationImpl:a	()Lmqq/app/AppRuntime;
    //   1355: checkcast 217	com/tencent/mobileqq/app/QQAppInterface
    //   1358: invokevirtual 272	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   1361: ldc_w 274
    //   1364: iconst_1
    //   1365: lconst_1
    //   1366: lconst_0
    //   1367: aload_3
    //   1368: ldc -18
    //   1370: iconst_0
    //   1371: invokevirtual 277	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   1374: return
    //   1375: astore_1
    //   1376: return
    //   1377: aload_1
    //   1378: ldc_w 405
    //   1381: invokevirtual 409	android/content/Intent:setFlags	(I)Landroid/content/Intent;
    //   1384: pop
    //   1385: aload_0
    //   1386: getfield 10	uzt:a	Lcom/tencent/mobileqq/theme/ThemeSwitchManager;
    //   1389: getfield 156	com/tencent/mobileqq/theme/ThemeSwitchManager:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   1392: aload_1
    //   1393: invokevirtual 410	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   1396: goto -68 -> 1328
    //   1399: astore_1
    //   1400: iconst_0
    //   1401: putstatic 192	com/tencent/mobileqq/theme/ThemeSwitchManager:b	Z
    //   1404: aload_1
    //   1405: invokevirtual 413	java/lang/Exception:printStackTrace	()V
    //   1408: aload_2
    //   1409: ldc -92
    //   1411: sipush 256
    //   1414: invokevirtual 168	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1417: aload_2
    //   1418: ldc -60
    //   1420: new 57	java/lang/StringBuilder
    //   1423: dup
    //   1424: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   1427: ldc_w 415
    //   1430: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1433: aload_1
    //   1434: invokevirtual 418	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1437: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1440: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1443: invokevirtual 200	android/os/Bundle:putCharSequence	(Ljava/lang/String;Ljava/lang/CharSequence;)V
    //   1446: iconst_1
    //   1447: istore 7
    //   1449: aload_2
    //   1450: ldc -54
    //   1452: ldc_w 420
    //   1455: invokevirtual 200	android/os/Bundle:putCharSequence	(Ljava/lang/String;Ljava/lang/CharSequence;)V
    //   1458: goto -1073 -> 385
    //   1461: getstatic 192	com/tencent/mobileqq/theme/ThemeSwitchManager:b	Z
    //   1464: ifeq +398 -> 1862
    //   1467: invokestatic 53	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1470: ifeq +34 -> 1504
    //   1473: ldc 55
    //   1475: iconst_2
    //   1476: new 57	java/lang/StringBuilder
    //   1479: dup
    //   1480: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   1483: ldc -62
    //   1485: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1488: aload_0
    //   1489: getfield 10	uzt:a	Lcom/tencent/mobileqq/theme/ThemeSwitchManager;
    //   1492: getfield 109	com/tencent/mobileqq/theme/ThemeSwitchManager:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   1495: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1498: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1501: invokestatic 102	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1504: iconst_0
    //   1505: putstatic 192	com/tencent/mobileqq/theme/ThemeSwitchManager:b	Z
    //   1508: aload_2
    //   1509: ldc -92
    //   1511: sipush 256
    //   1514: invokevirtual 168	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1517: aload_2
    //   1518: ldc -60
    //   1520: new 57	java/lang/StringBuilder
    //   1523: dup
    //   1524: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   1527: ldc -62
    //   1529: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1532: aload_0
    //   1533: getfield 10	uzt:a	Lcom/tencent/mobileqq/theme/ThemeSwitchManager;
    //   1536: getfield 109	com/tencent/mobileqq/theme/ThemeSwitchManager:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   1539: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1542: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1545: invokevirtual 200	android/os/Bundle:putCharSequence	(Ljava/lang/String;Ljava/lang/CharSequence;)V
    //   1548: iconst_1
    //   1549: istore 7
    //   1551: aload_2
    //   1552: ldc -54
    //   1554: ldc_w 422
    //   1557: invokevirtual 200	android/os/Bundle:putCharSequence	(Ljava/lang/String;Ljava/lang/CharSequence;)V
    //   1560: goto -562 -> 998
    //   1563: iload 9
    //   1565: sipush 2005
    //   1568: if_icmpne +246 -> 1814
    //   1571: aload_0
    //   1572: getfield 10	uzt:a	Lcom/tencent/mobileqq/theme/ThemeSwitchManager;
    //   1575: getfield 107	com/tencent/mobileqq/theme/ThemeSwitchManager:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1578: aload_0
    //   1579: getfield 10	uzt:a	Lcom/tencent/mobileqq/theme/ThemeSwitchManager;
    //   1582: getfield 109	com/tencent/mobileqq/theme/ThemeSwitchManager:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   1585: invokevirtual 115	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1588: checkcast 117	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo
    //   1591: astore_1
    //   1592: aload_1
    //   1593: ifnull +77 -> 1670
    //   1596: aload_1
    //   1597: lload 10
    //   1599: putfield 144	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:downsize	J
    //   1602: aload_1
    //   1603: ldc_w 424
    //   1606: putfield 149	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:status	Ljava/lang/String;
    //   1609: aload_0
    //   1610: getfield 10	uzt:a	Lcom/tencent/mobileqq/theme/ThemeSwitchManager;
    //   1613: getfield 156	com/tencent/mobileqq/theme/ThemeSwitchManager:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   1616: aload_1
    //   1617: invokestatic 162	com/tencent/mobileqq/theme/ThemeUtil:setThemeInfo	(Landroid/content/Context;Lcom/tencent/mobileqq/theme/ThemeUtil$ThemeInfo;)Ljava/lang/Boolean;
    //   1620: pop
    //   1621: aload_0
    //   1622: getfield 10	uzt:a	Lcom/tencent/mobileqq/theme/ThemeSwitchManager;
    //   1625: getfield 107	com/tencent/mobileqq/theme/ThemeSwitchManager:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1628: aload_0
    //   1629: getfield 10	uzt:a	Lcom/tencent/mobileqq/theme/ThemeSwitchManager;
    //   1632: getfield 109	com/tencent/mobileqq/theme/ThemeSwitchManager:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   1635: invokevirtual 255	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1638: pop
    //   1639: aload_2
    //   1640: ldc_w 426
    //   1643: aload_1
    //   1644: getfield 246	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:themeId	Ljava/lang/String;
    //   1647: invokevirtual 200	android/os/Bundle:putCharSequence	(Ljava/lang/String;Ljava/lang/CharSequence;)V
    //   1650: aload_2
    //   1651: ldc_w 428
    //   1654: aload_1
    //   1655: getfield 225	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:version	Ljava/lang/String;
    //   1658: invokevirtual 200	android/os/Bundle:putCharSequence	(Ljava/lang/String;Ljava/lang/CharSequence;)V
    //   1661: aload_2
    //   1662: ldc -54
    //   1664: ldc_w 430
    //   1667: invokevirtual 200	android/os/Bundle:putCharSequence	(Ljava/lang/String;Ljava/lang/CharSequence;)V
    //   1670: aload_2
    //   1671: ldc -92
    //   1673: sipush 256
    //   1676: invokevirtual 168	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1679: aload_2
    //   1680: ldc -60
    //   1682: ldc_w 432
    //   1685: invokevirtual 200	android/os/Bundle:putCharSequence	(Ljava/lang/String;Ljava/lang/CharSequence;)V
    //   1688: iconst_1
    //   1689: istore 7
    //   1691: iconst_0
    //   1692: putstatic 192	com/tencent/mobileqq/theme/ThemeSwitchManager:b	Z
    //   1695: getstatic 212	com/tencent/common/app/BaseApplicationImpl:a	Lcom/tencent/common/app/BaseApplicationImpl;
    //   1698: invokevirtual 215	com/tencent/common/app/BaseApplicationImpl:a	()Lmqq/app/AppRuntime;
    //   1701: checkcast 217	com/tencent/mobileqq/app/QQAppInterface
    //   1704: astore_3
    //   1705: aconst_null
    //   1706: invokestatic 222	com/tencent/mobileqq/utils/NetworkUtil:a	(Landroid/content/Context;)I
    //   1709: istore 8
    //   1711: aload_1
    //   1712: ifnull +96 -> 1808
    //   1715: aload_1
    //   1716: getfield 225	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:version	Ljava/lang/String;
    //   1719: astore_1
    //   1720: aload_3
    //   1721: ldc -29
    //   1723: ldc -27
    //   1725: sipush 153
    //   1728: iload 8
    //   1730: bipush -14
    //   1732: ldc -25
    //   1734: aload_1
    //   1735: getstatic 236	com/tencent/mobileqq/theme/ThemeReporter:t	Ljava/lang/String;
    //   1738: ldc -18
    //   1740: invokestatic 241	com/tencent/mobileqq/theme/ThemeReporter:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1743: goto -1358 -> 385
    //   1746: astore_1
    //   1747: aload_1
    //   1748: invokevirtual 413	java/lang/Exception:printStackTrace	()V
    //   1751: iconst_0
    //   1752: putstatic 192	com/tencent/mobileqq/theme/ThemeSwitchManager:b	Z
    //   1755: aload_2
    //   1756: ldc -92
    //   1758: sipush 256
    //   1761: invokevirtual 168	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1764: aload_2
    //   1765: ldc -60
    //   1767: new 57	java/lang/StringBuilder
    //   1770: dup
    //   1771: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   1774: ldc_w 434
    //   1777: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1780: aload_1
    //   1781: invokevirtual 418	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1784: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1787: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1790: invokevirtual 200	android/os/Bundle:putCharSequence	(Ljava/lang/String;Ljava/lang/CharSequence;)V
    //   1793: iconst_1
    //   1794: istore 7
    //   1796: aload_2
    //   1797: ldc -54
    //   1799: ldc_w 436
    //   1802: invokevirtual 200	android/os/Bundle:putCharSequence	(Ljava/lang/String;Ljava/lang/CharSequence;)V
    //   1805: goto -1420 -> 385
    //   1808: ldc -18
    //   1810: astore_1
    //   1811: goto -91 -> 1720
    //   1814: iload 8
    //   1816: istore 7
    //   1818: invokestatic 53	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1821: ifeq -1436 -> 385
    //   1824: ldc 55
    //   1826: iconst_2
    //   1827: new 57	java/lang/StringBuilder
    //   1830: dup
    //   1831: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   1834: ldc_w 438
    //   1837: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1840: iload 9
    //   1842: invokevirtual 67	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1845: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1848: invokestatic 102	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1851: iload 8
    //   1853: istore 7
    //   1855: goto -1470 -> 385
    //   1858: astore_1
    //   1859: goto -864 -> 995
    //   1862: iconst_0
    //   1863: istore 7
    //   1865: goto -867 -> 998
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1868	0	this	uzt
    //   0	1868	1	paramMessage	android.os.Message
    //   222	1575	2	localBundle	android.os.Bundle
    //   7	1714	3	localObject	Object
    //   576	716	4	localThemeInfo	com.tencent.mobileqq.theme.ThemeUtil.ThemeInfo
    //   595	454	5	localQQAppInterface	com.tencent.mobileqq.app.QQAppInterface
    //   859	251	6	localActivity	android.app.Activity
    //   362	1502	7	i	int
    //   224	1628	8	j	int
    //   16	1825	9	k	int
    //   27	1571	10	l	long
    // Exception table:
    //   from	to	target	type
    //   786	832	833	java/lang/Exception
    //   1207	1253	1256	java/lang/Exception
    //   1328	1374	1375	java/lang/Exception
    //   556	603	1399	java/lang/Exception
    //   608	614	1399	java/lang/Exception
    //   614	638	1399	java/lang/Exception
    //   643	678	1399	java/lang/Exception
    //   678	782	1399	java/lang/Exception
    //   846	861	1399	java/lang/Exception
    //   871	934	1399	java/lang/Exception
    //   934	949	1399	java/lang/Exception
    //   1001	1062	1399	java/lang/Exception
    //   1062	1082	1399	java/lang/Exception
    //   1082	1120	1399	java/lang/Exception
    //   1120	1167	1399	java/lang/Exception
    //   1167	1207	1399	java/lang/Exception
    //   1260	1328	1399	java/lang/Exception
    //   1377	1396	1399	java/lang/Exception
    //   1461	1504	1399	java/lang/Exception
    //   1504	1548	1399	java/lang/Exception
    //   1551	1560	1399	java/lang/Exception
    //   1571	1592	1746	java/lang/Exception
    //   1596	1670	1746	java/lang/Exception
    //   1670	1688	1746	java/lang/Exception
    //   1691	1711	1746	java/lang/Exception
    //   1715	1720	1746	java/lang/Exception
    //   1720	1743	1746	java/lang/Exception
    //   949	995	1858	java/lang/Exception
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\uzt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
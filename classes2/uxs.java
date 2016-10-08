import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.surfaceviewaction.SpriteSurfaceView;

public class uxs
  implements Runnable
{
  public volatile boolean a;
  
  private uxs(SpriteSurfaceView paramSpriteSurfaceView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: invokestatic 36	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +11 -> 14
    //   6: ldc 38
    //   8: iconst_2
    //   9: ldc 40
    //   11: invokestatic 44	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   14: new 46	android/graphics/Paint
    //   17: dup
    //   18: invokespecial 47	android/graphics/Paint:<init>	()V
    //   21: astore 6
    //   23: aload 6
    //   25: aload_0
    //   26: getfield 13	uxs:jdField_a_of_type_ComTencentMobileqqSurfaceviewactionSpriteSurfaceView	Lcom/tencent/mobileqq/surfaceviewaction/SpriteSurfaceView;
    //   29: invokevirtual 53	com/tencent/mobileqq/surfaceviewaction/SpriteSurfaceView:getContext	()Landroid/content/Context;
    //   32: ldc 54
    //   34: invokestatic 59	com/tencent/mobileqq/util/DisplayUtil:a	(Landroid/content/Context;F)I
    //   37: i2f
    //   38: invokevirtual 63	android/graphics/Paint:setTextSize	(F)V
    //   41: invokestatic 69	java/lang/System:currentTimeMillis	()J
    //   44: lstore 12
    //   46: ldc 71
    //   48: astore_2
    //   49: iconst_0
    //   50: istore 9
    //   52: aload_0
    //   53: getfield 73	uxs:jdField_a_of_type_Boolean	Z
    //   56: ifne +1228 -> 1284
    //   59: aconst_null
    //   60: astore 4
    //   62: aconst_null
    //   63: astore_3
    //   64: iload 9
    //   66: istore 10
    //   68: invokestatic 69	java/lang/System:currentTimeMillis	()J
    //   71: lstore 14
    //   73: iload 9
    //   75: istore 10
    //   77: aload_0
    //   78: getfield 13	uxs:jdField_a_of_type_ComTencentMobileqqSurfaceviewactionSpriteSurfaceView	Lcom/tencent/mobileqq/surfaceviewaction/SpriteSurfaceView;
    //   81: invokestatic 76	com/tencent/mobileqq/surfaceviewaction/SpriteSurfaceView:a	(Lcom/tencent/mobileqq/surfaceviewaction/SpriteSurfaceView;)Ljava/util/List;
    //   84: invokeinterface 82 1 0
    //   89: istore 11
    //   91: iload 11
    //   93: ifle +197 -> 290
    //   96: aload_0
    //   97: getfield 13	uxs:jdField_a_of_type_ComTencentMobileqqSurfaceviewactionSpriteSurfaceView	Lcom/tencent/mobileqq/surfaceviewaction/SpriteSurfaceView;
    //   100: invokestatic 85	com/tencent/mobileqq/surfaceviewaction/SpriteSurfaceView:a	(Lcom/tencent/mobileqq/surfaceviewaction/SpriteSurfaceView;)Landroid/view/SurfaceHolder;
    //   103: invokeinterface 91 1 0
    //   108: astore 5
    //   110: aload 5
    //   112: ifnull +164 -> 276
    //   115: aload 5
    //   117: astore_3
    //   118: aload 5
    //   120: astore 4
    //   122: aload 5
    //   124: iconst_0
    //   125: getstatic 97	android/graphics/PorterDuff$Mode:CLEAR	Landroid/graphics/PorterDuff$Mode;
    //   128: invokevirtual 103	android/graphics/Canvas:drawColor	(ILandroid/graphics/PorterDuff$Mode;)V
    //   131: aload 5
    //   133: astore_3
    //   134: aload 5
    //   136: astore 4
    //   138: aload_0
    //   139: getfield 13	uxs:jdField_a_of_type_ComTencentMobileqqSurfaceviewactionSpriteSurfaceView	Lcom/tencent/mobileqq/surfaceviewaction/SpriteSurfaceView;
    //   142: invokestatic 106	com/tencent/mobileqq/surfaceviewaction/SpriteSurfaceView:a	(Lcom/tencent/mobileqq/surfaceviewaction/SpriteSurfaceView;)Ljava/lang/Object;
    //   145: astore 7
    //   147: aload 5
    //   149: astore_3
    //   150: aload 5
    //   152: astore 4
    //   154: aload 7
    //   156: monitorenter
    //   157: iconst_0
    //   158: istore 10
    //   160: iload 10
    //   162: aload_0
    //   163: getfield 13	uxs:jdField_a_of_type_ComTencentMobileqqSurfaceviewactionSpriteSurfaceView	Lcom/tencent/mobileqq/surfaceviewaction/SpriteSurfaceView;
    //   166: invokestatic 76	com/tencent/mobileqq/surfaceviewaction/SpriteSurfaceView:a	(Lcom/tencent/mobileqq/surfaceviewaction/SpriteSurfaceView;)Ljava/util/List;
    //   169: invokeinterface 82 1 0
    //   174: if_icmpge +41 -> 215
    //   177: aload_0
    //   178: getfield 73	uxs:jdField_a_of_type_Boolean	Z
    //   181: ifne +34 -> 215
    //   184: aload_0
    //   185: getfield 13	uxs:jdField_a_of_type_ComTencentMobileqqSurfaceviewactionSpriteSurfaceView	Lcom/tencent/mobileqq/surfaceviewaction/SpriteSurfaceView;
    //   188: invokestatic 76	com/tencent/mobileqq/surfaceviewaction/SpriteSurfaceView:a	(Lcom/tencent/mobileqq/surfaceviewaction/SpriteSurfaceView;)Ljava/util/List;
    //   191: iload 10
    //   193: invokeinterface 110 2 0
    //   198: checkcast 112	com/tencent/mobileqq/surfaceviewaction/Sprite
    //   201: aload 5
    //   203: invokevirtual 115	com/tencent/mobileqq/surfaceviewaction/Sprite:a	(Landroid/graphics/Canvas;)V
    //   206: iload 10
    //   208: iconst_1
    //   209: iadd
    //   210: istore 10
    //   212: goto -52 -> 160
    //   215: aload_0
    //   216: getfield 13	uxs:jdField_a_of_type_ComTencentMobileqqSurfaceviewactionSpriteSurfaceView	Lcom/tencent/mobileqq/surfaceviewaction/SpriteSurfaceView;
    //   219: getfield 116	com/tencent/mobileqq/surfaceviewaction/SpriteSurfaceView:jdField_a_of_type_Boolean	Z
    //   222: ifeq +15 -> 237
    //   225: aload 5
    //   227: aload_2
    //   228: ldc 117
    //   230: ldc 117
    //   232: aload 6
    //   234: invokevirtual 121	android/graphics/Canvas:drawText	(Ljava/lang/String;FFLandroid/graphics/Paint;)V
    //   237: aload 7
    //   239: monitorexit
    //   240: aload 5
    //   242: astore_3
    //   243: aload 5
    //   245: astore 4
    //   247: aload_0
    //   248: getfield 13	uxs:jdField_a_of_type_ComTencentMobileqqSurfaceviewactionSpriteSurfaceView	Lcom/tencent/mobileqq/surfaceviewaction/SpriteSurfaceView;
    //   251: getfield 116	com/tencent/mobileqq/surfaceviewaction/SpriteSurfaceView:jdField_a_of_type_Boolean	Z
    //   254: ifeq +22 -> 276
    //   257: aload 5
    //   259: astore_3
    //   260: aload 5
    //   262: astore 4
    //   264: aload 5
    //   266: aload_2
    //   267: ldc 117
    //   269: ldc 117
    //   271: aload 6
    //   273: invokevirtual 121	android/graphics/Canvas:drawText	(Ljava/lang/String;FFLandroid/graphics/Paint;)V
    //   276: aload_0
    //   277: getfield 13	uxs:jdField_a_of_type_ComTencentMobileqqSurfaceviewactionSpriteSurfaceView	Lcom/tencent/mobileqq/surfaceviewaction/SpriteSurfaceView;
    //   280: invokestatic 85	com/tencent/mobileqq/surfaceviewaction/SpriteSurfaceView:a	(Lcom/tencent/mobileqq/surfaceviewaction/SpriteSurfaceView;)Landroid/view/SurfaceHolder;
    //   283: aload 5
    //   285: invokeinterface 124 2 0
    //   290: iload 9
    //   292: istore 10
    //   294: aload_0
    //   295: getfield 13	uxs:jdField_a_of_type_ComTencentMobileqqSurfaceviewactionSpriteSurfaceView	Lcom/tencent/mobileqq/surfaceviewaction/SpriteSurfaceView;
    //   298: invokestatic 127	com/tencent/mobileqq/surfaceviewaction/SpriteSurfaceView:b	(Lcom/tencent/mobileqq/surfaceviewaction/SpriteSurfaceView;)Ljava/lang/Object;
    //   301: astore_3
    //   302: iload 9
    //   304: istore 10
    //   306: aload_3
    //   307: monitorenter
    //   308: aload_0
    //   309: getfield 13	uxs:jdField_a_of_type_ComTencentMobileqqSurfaceviewactionSpriteSurfaceView	Lcom/tencent/mobileqq/surfaceviewaction/SpriteSurfaceView;
    //   312: invokestatic 129	com/tencent/mobileqq/surfaceviewaction/SpriteSurfaceView:b	(Lcom/tencent/mobileqq/surfaceviewaction/SpriteSurfaceView;)Ljava/util/List;
    //   315: invokeinterface 133 1 0
    //   320: astore 4
    //   322: aload 4
    //   324: invokeinterface 138 1 0
    //   329: ifeq +765 -> 1094
    //   332: aload 4
    //   334: invokeinterface 142 1 0
    //   339: checkcast 6	java/lang/Runnable
    //   342: invokeinterface 144 1 0
    //   347: goto -25 -> 322
    //   350: astore 4
    //   352: aload_3
    //   353: monitorexit
    //   354: iload 9
    //   356: istore 10
    //   358: aload 4
    //   360: athrow
    //   361: astore_3
    //   362: iload 10
    //   364: istore 9
    //   366: invokestatic 36	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   369: ifeq +14 -> 383
    //   372: ldc 38
    //   374: iconst_2
    //   375: aload_3
    //   376: invokevirtual 148	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   379: aload_3
    //   380: invokestatic 151	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   383: goto -331 -> 52
    //   386: astore 8
    //   388: aload 7
    //   390: monitorexit
    //   391: aload 5
    //   393: astore_3
    //   394: aload 5
    //   396: astore 4
    //   398: aload 8
    //   400: athrow
    //   401: astore 5
    //   403: aload_3
    //   404: astore 4
    //   406: invokestatic 36	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   409: ifeq +19 -> 428
    //   412: aload_3
    //   413: astore 4
    //   415: ldc 38
    //   417: iconst_2
    //   418: aload 5
    //   420: invokevirtual 148	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   423: aload 5
    //   425: invokestatic 151	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   428: aload_0
    //   429: getfield 13	uxs:jdField_a_of_type_ComTencentMobileqqSurfaceviewactionSpriteSurfaceView	Lcom/tencent/mobileqq/surfaceviewaction/SpriteSurfaceView;
    //   432: invokestatic 85	com/tencent/mobileqq/surfaceviewaction/SpriteSurfaceView:a	(Lcom/tencent/mobileqq/surfaceviewaction/SpriteSurfaceView;)Landroid/view/SurfaceHolder;
    //   435: aload_3
    //   436: invokeinterface 124 2 0
    //   441: goto -151 -> 290
    //   444: astore_3
    //   445: iload 9
    //   447: istore 10
    //   449: invokestatic 36	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   452: ifeq +18 -> 470
    //   455: iload 9
    //   457: istore 10
    //   459: ldc 38
    //   461: iconst_2
    //   462: aload_3
    //   463: invokevirtual 148	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   466: aload_3
    //   467: invokestatic 151	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   470: iload 9
    //   472: istore 10
    //   474: getstatic 157	android/os/Build$VERSION:SDK_INT	I
    //   477: bipush 18
    //   479: if_icmpne +832 -> 1311
    //   482: iload 9
    //   484: istore 10
    //   486: aload_0
    //   487: getfield 13	uxs:jdField_a_of_type_ComTencentMobileqqSurfaceviewactionSpriteSurfaceView	Lcom/tencent/mobileqq/surfaceviewaction/SpriteSurfaceView;
    //   490: invokevirtual 160	com/tencent/mobileqq/surfaceviewaction/SpriteSurfaceView:a	()Ljava/util/concurrent/locks/ReentrantLock;
    //   493: astore_3
    //   494: iload 9
    //   496: istore 10
    //   498: invokestatic 36	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   501: ifeq +73 -> 574
    //   504: iload 9
    //   506: istore 10
    //   508: new 162	java/lang/StringBuilder
    //   511: dup
    //   512: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   515: ldc -91
    //   517: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   520: astore 4
    //   522: aload_3
    //   523: ifnonnull +804 -> 1327
    //   526: iconst_1
    //   527: istore 18
    //   529: iload 9
    //   531: istore 10
    //   533: aload 4
    //   535: iload 18
    //   537: invokevirtual 172	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   540: ldc -82
    //   542: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   545: astore 4
    //   547: aload_3
    //   548: ifnonnull +301 -> 849
    //   551: iconst_m1
    //   552: istore 11
    //   554: iload 9
    //   556: istore 10
    //   558: ldc 38
    //   560: iconst_2
    //   561: aload 4
    //   563: iload 11
    //   565: invokevirtual 177	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   568: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   571: invokestatic 183	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   574: aload_3
    //   575: ifnull -285 -> 290
    //   578: iload 9
    //   580: istore 10
    //   582: aload_3
    //   583: invokevirtual 188	java/util/concurrent/locks/ReentrantLock:getHoldCount	()I
    //   586: ifle -296 -> 290
    //   589: iload 9
    //   591: istore 10
    //   593: aload_3
    //   594: invokevirtual 191	java/util/concurrent/locks/ReentrantLock:isHeldByCurrentThread	()Z
    //   597: istore 18
    //   599: iload 18
    //   601: ifeq -311 -> 290
    //   604: aload_3
    //   605: invokevirtual 194	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   608: goto -318 -> 290
    //   611: astore_3
    //   612: iload 9
    //   614: istore 10
    //   616: invokestatic 36	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   619: ifeq -329 -> 290
    //   622: iload 9
    //   624: istore 10
    //   626: ldc 38
    //   628: iconst_2
    //   629: aload_3
    //   630: invokevirtual 148	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   633: aload_3
    //   634: invokestatic 196	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   637: goto -347 -> 290
    //   640: astore_3
    //   641: iload 9
    //   643: istore 10
    //   645: invokestatic 36	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   648: ifeq +18 -> 666
    //   651: iload 9
    //   653: istore 10
    //   655: ldc 38
    //   657: iconst_2
    //   658: aload_3
    //   659: invokevirtual 148	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   662: aload_3
    //   663: invokestatic 151	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   666: iload 9
    //   668: istore 10
    //   670: getstatic 157	android/os/Build$VERSION:SDK_INT	I
    //   673: bipush 18
    //   675: if_icmpne +641 -> 1316
    //   678: iload 9
    //   680: istore 10
    //   682: aload_0
    //   683: getfield 13	uxs:jdField_a_of_type_ComTencentMobileqqSurfaceviewactionSpriteSurfaceView	Lcom/tencent/mobileqq/surfaceviewaction/SpriteSurfaceView;
    //   686: invokevirtual 160	com/tencent/mobileqq/surfaceviewaction/SpriteSurfaceView:a	()Ljava/util/concurrent/locks/ReentrantLock;
    //   689: astore_3
    //   690: iload 9
    //   692: istore 10
    //   694: invokestatic 36	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   697: ifeq +73 -> 770
    //   700: iload 9
    //   702: istore 10
    //   704: new 162	java/lang/StringBuilder
    //   707: dup
    //   708: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   711: ldc -91
    //   713: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   716: astore 4
    //   718: aload_3
    //   719: ifnonnull +602 -> 1321
    //   722: iconst_1
    //   723: istore 18
    //   725: iload 9
    //   727: istore 10
    //   729: aload 4
    //   731: iload 18
    //   733: invokevirtual 172	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   736: ldc -82
    //   738: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   741: astore 4
    //   743: aload_3
    //   744: ifnonnull +92 -> 836
    //   747: iconst_m1
    //   748: istore 11
    //   750: iload 9
    //   752: istore 10
    //   754: ldc 38
    //   756: iconst_2
    //   757: aload 4
    //   759: iload 11
    //   761: invokevirtual 177	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   764: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   767: invokestatic 183	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   770: aload_3
    //   771: ifnull -481 -> 290
    //   774: iload 9
    //   776: istore 10
    //   778: aload_3
    //   779: invokevirtual 188	java/util/concurrent/locks/ReentrantLock:getHoldCount	()I
    //   782: ifle -492 -> 290
    //   785: iload 9
    //   787: istore 10
    //   789: aload_3
    //   790: invokevirtual 191	java/util/concurrent/locks/ReentrantLock:isHeldByCurrentThread	()Z
    //   793: istore 18
    //   795: iload 18
    //   797: ifeq -507 -> 290
    //   800: aload_3
    //   801: invokevirtual 194	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   804: goto -514 -> 290
    //   807: astore_3
    //   808: iload 9
    //   810: istore 10
    //   812: invokestatic 36	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   815: ifeq -525 -> 290
    //   818: iload 9
    //   820: istore 10
    //   822: ldc 38
    //   824: iconst_2
    //   825: aload_3
    //   826: invokevirtual 148	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   829: aload_3
    //   830: invokestatic 196	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   833: goto -543 -> 290
    //   836: iload 9
    //   838: istore 10
    //   840: aload_3
    //   841: invokevirtual 188	java/util/concurrent/locks/ReentrantLock:getHoldCount	()I
    //   844: istore 11
    //   846: goto -96 -> 750
    //   849: iload 9
    //   851: istore 10
    //   853: aload_3
    //   854: invokevirtual 188	java/util/concurrent/locks/ReentrantLock:getHoldCount	()I
    //   857: istore 11
    //   859: goto -305 -> 554
    //   862: astore 5
    //   864: aload_0
    //   865: getfield 13	uxs:jdField_a_of_type_ComTencentMobileqqSurfaceviewactionSpriteSurfaceView	Lcom/tencent/mobileqq/surfaceviewaction/SpriteSurfaceView;
    //   868: invokestatic 85	com/tencent/mobileqq/surfaceviewaction/SpriteSurfaceView:a	(Lcom/tencent/mobileqq/surfaceviewaction/SpriteSurfaceView;)Landroid/view/SurfaceHolder;
    //   871: aload 4
    //   873: invokeinterface 124 2 0
    //   878: iload 9
    //   880: istore 10
    //   882: aload 5
    //   884: athrow
    //   885: astore_3
    //   886: iload 9
    //   888: istore 10
    //   890: invokestatic 36	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   893: ifeq +18 -> 911
    //   896: iload 9
    //   898: istore 10
    //   900: ldc 38
    //   902: iconst_2
    //   903: aload_3
    //   904: invokevirtual 148	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   907: aload_3
    //   908: invokestatic 151	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   911: iload 9
    //   913: istore 10
    //   915: getstatic 157	android/os/Build$VERSION:SDK_INT	I
    //   918: bipush 18
    //   920: if_icmpne +386 -> 1306
    //   923: iload 9
    //   925: istore 10
    //   927: aload_0
    //   928: getfield 13	uxs:jdField_a_of_type_ComTencentMobileqqSurfaceviewactionSpriteSurfaceView	Lcom/tencent/mobileqq/surfaceviewaction/SpriteSurfaceView;
    //   931: invokevirtual 160	com/tencent/mobileqq/surfaceviewaction/SpriteSurfaceView:a	()Ljava/util/concurrent/locks/ReentrantLock;
    //   934: astore_3
    //   935: iload 9
    //   937: istore 10
    //   939: invokestatic 36	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   942: ifeq +73 -> 1015
    //   945: iload 9
    //   947: istore 10
    //   949: new 162	java/lang/StringBuilder
    //   952: dup
    //   953: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   956: ldc -91
    //   958: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   961: astore 4
    //   963: aload_3
    //   964: ifnonnull +369 -> 1333
    //   967: iconst_1
    //   968: istore 18
    //   970: iload 9
    //   972: istore 10
    //   974: aload 4
    //   976: iload 18
    //   978: invokevirtual 172	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   981: ldc -82
    //   983: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   986: astore 4
    //   988: aload_3
    //   989: ifnonnull +92 -> 1081
    //   992: iconst_m1
    //   993: istore 11
    //   995: iload 9
    //   997: istore 10
    //   999: ldc 38
    //   1001: iconst_2
    //   1002: aload 4
    //   1004: iload 11
    //   1006: invokevirtual 177	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1009: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1012: invokestatic 183	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1015: aload_3
    //   1016: ifnull -138 -> 878
    //   1019: iload 9
    //   1021: istore 10
    //   1023: aload_3
    //   1024: invokevirtual 188	java/util/concurrent/locks/ReentrantLock:getHoldCount	()I
    //   1027: ifle -149 -> 878
    //   1030: iload 9
    //   1032: istore 10
    //   1034: aload_3
    //   1035: invokevirtual 191	java/util/concurrent/locks/ReentrantLock:isHeldByCurrentThread	()Z
    //   1038: istore 18
    //   1040: iload 18
    //   1042: ifeq -164 -> 878
    //   1045: aload_3
    //   1046: invokevirtual 194	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1049: goto -171 -> 878
    //   1052: astore_3
    //   1053: iload 9
    //   1055: istore 10
    //   1057: invokestatic 36	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1060: ifeq -182 -> 878
    //   1063: iload 9
    //   1065: istore 10
    //   1067: ldc 38
    //   1069: iconst_2
    //   1070: aload_3
    //   1071: invokevirtual 148	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1074: aload_3
    //   1075: invokestatic 196	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1078: goto -200 -> 878
    //   1081: iload 9
    //   1083: istore 10
    //   1085: aload_3
    //   1086: invokevirtual 188	java/util/concurrent/locks/ReentrantLock:getHoldCount	()I
    //   1089: istore 11
    //   1091: goto -96 -> 995
    //   1094: aload_0
    //   1095: getfield 13	uxs:jdField_a_of_type_ComTencentMobileqqSurfaceviewactionSpriteSurfaceView	Lcom/tencent/mobileqq/surfaceviewaction/SpriteSurfaceView;
    //   1098: invokestatic 129	com/tencent/mobileqq/surfaceviewaction/SpriteSurfaceView:b	(Lcom/tencent/mobileqq/surfaceviewaction/SpriteSurfaceView;)Ljava/util/List;
    //   1101: invokeinterface 199 1 0
    //   1106: aload_3
    //   1107: monitorexit
    //   1108: iload 9
    //   1110: iconst_1
    //   1111: iadd
    //   1112: istore 9
    //   1114: iload 9
    //   1116: istore 10
    //   1118: invokestatic 69	java/lang/System:currentTimeMillis	()J
    //   1121: lstore 16
    //   1123: iload 9
    //   1125: istore 10
    //   1127: aload_0
    //   1128: getfield 13	uxs:jdField_a_of_type_ComTencentMobileqqSurfaceviewactionSpriteSurfaceView	Lcom/tencent/mobileqq/surfaceviewaction/SpriteSurfaceView;
    //   1131: invokestatic 202	com/tencent/mobileqq/surfaceviewaction/SpriteSurfaceView:a	(Lcom/tencent/mobileqq/surfaceviewaction/SpriteSurfaceView;)I
    //   1134: istore 11
    //   1136: lload 16
    //   1138: lload 14
    //   1140: lsub
    //   1141: iload 11
    //   1143: i2l
    //   1144: lcmp
    //   1145: ifge +24 -> 1169
    //   1148: iload 9
    //   1150: istore 10
    //   1152: aload_0
    //   1153: getfield 13	uxs:jdField_a_of_type_ComTencentMobileqqSurfaceviewactionSpriteSurfaceView	Lcom/tencent/mobileqq/surfaceviewaction/SpriteSurfaceView;
    //   1156: invokestatic 202	com/tencent/mobileqq/surfaceviewaction/SpriteSurfaceView:a	(Lcom/tencent/mobileqq/surfaceviewaction/SpriteSurfaceView;)I
    //   1159: i2l
    //   1160: lload 16
    //   1162: lload 14
    //   1164: lsub
    //   1165: lsub
    //   1166: invokestatic 208	java/lang/Thread:sleep	(J)V
    //   1169: iload 9
    //   1171: iconst_5
    //   1172: if_icmplt +131 -> 1303
    //   1175: iload 9
    //   1177: i2f
    //   1178: fstore_1
    //   1179: iload 9
    //   1181: istore 10
    //   1183: fload_1
    //   1184: ldc -47
    //   1186: fmul
    //   1187: invokestatic 69	java/lang/System:currentTimeMillis	()J
    //   1190: lload 12
    //   1192: lsub
    //   1193: l2f
    //   1194: fdiv
    //   1195: ldc -46
    //   1197: fmul
    //   1198: invokestatic 216	java/lang/Math:round	(F)I
    //   1201: i2f
    //   1202: ldc -46
    //   1204: fdiv
    //   1205: fstore_1
    //   1206: iload 9
    //   1208: istore 10
    //   1210: ldc -38
    //   1212: iconst_1
    //   1213: anewarray 4	java/lang/Object
    //   1216: dup
    //   1217: iconst_0
    //   1218: fload_1
    //   1219: invokestatic 224	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   1222: aastore
    //   1223: invokestatic 230	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1226: astore_3
    //   1227: aload_3
    //   1228: astore_2
    //   1229: aload_0
    //   1230: getfield 13	uxs:jdField_a_of_type_ComTencentMobileqqSurfaceviewactionSpriteSurfaceView	Lcom/tencent/mobileqq/surfaceviewaction/SpriteSurfaceView;
    //   1233: getfield 233	com/tencent/mobileqq/surfaceviewaction/SpriteSurfaceView:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   1236: astore_3
    //   1237: aload_3
    //   1238: monitorenter
    //   1239: aload_0
    //   1240: getfield 13	uxs:jdField_a_of_type_ComTencentMobileqqSurfaceviewactionSpriteSurfaceView	Lcom/tencent/mobileqq/surfaceviewaction/SpriteSurfaceView;
    //   1243: getfield 233	com/tencent/mobileqq/surfaceviewaction/SpriteSurfaceView:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   1246: fload_1
    //   1247: invokestatic 224	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   1250: invokeinterface 237 2 0
    //   1255: pop
    //   1256: aload_3
    //   1257: monitorexit
    //   1258: invokestatic 69	java/lang/System:currentTimeMillis	()J
    //   1261: lstore 14
    //   1263: lload 14
    //   1265: lstore 12
    //   1267: iconst_0
    //   1268: istore 9
    //   1270: goto -1218 -> 52
    //   1273: astore 4
    //   1275: aload_3
    //   1276: monitorexit
    //   1277: aload 4
    //   1279: athrow
    //   1280: astore_3
    //   1281: goto -915 -> 366
    //   1284: invokestatic 36	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1287: ifeq +11 -> 1298
    //   1290: ldc 38
    //   1292: iconst_2
    //   1293: ldc -17
    //   1295: invokestatic 44	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1298: return
    //   1299: astore_3
    //   1300: goto -131 -> 1169
    //   1303: goto -33 -> 1270
    //   1306: aconst_null
    //   1307: astore_3
    //   1308: goto -373 -> 935
    //   1311: aconst_null
    //   1312: astore_3
    //   1313: goto -819 -> 494
    //   1316: aconst_null
    //   1317: astore_3
    //   1318: goto -628 -> 690
    //   1321: iconst_0
    //   1322: istore 18
    //   1324: goto -599 -> 725
    //   1327: iconst_0
    //   1328: istore 18
    //   1330: goto -801 -> 529
    //   1333: iconst_0
    //   1334: istore 18
    //   1336: goto -366 -> 970
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1339	0	this	uxs
    //   1178	69	1	f	float
    //   48	1181	2	localObject1	Object
    //   63	290	3	localObject2	Object
    //   361	19	3	localException1	Exception
    //   393	43	3	localObject3	Object
    //   444	23	3	localException2	Exception
    //   493	112	3	localReentrantLock1	java.util.concurrent.locks.ReentrantLock
    //   611	23	3	localException3	Exception
    //   640	23	3	localException4	Exception
    //   689	112	3	localReentrantLock2	java.util.concurrent.locks.ReentrantLock
    //   807	47	3	localException5	Exception
    //   885	23	3	localException6	Exception
    //   934	112	3	localReentrantLock3	java.util.concurrent.locks.ReentrantLock
    //   1052	55	3	localException7	Exception
    //   1280	1	3	localException8	Exception
    //   1299	1	3	localInterruptedException	InterruptedException
    //   1307	11	3	localObject5	Object
    //   60	273	4	localObject6	Object
    //   350	9	4	localObject7	Object
    //   396	607	4	localObject8	Object
    //   1273	5	4	localObject9	Object
    //   108	287	5	localCanvas	android.graphics.Canvas
    //   401	23	5	localException9	Exception
    //   862	21	5	localObject10	Object
    //   21	251	6	localPaint	android.graphics.Paint
    //   145	244	7	localObject11	Object
    //   386	13	8	localObject12	Object
    //   50	1219	9	i	int
    //   66	1143	10	j	int
    //   89	1053	11	k	int
    //   44	1222	12	l1	long
    //   71	1193	14	l2	long
    //   1121	40	16	l3	long
    //   527	808	18	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   308	322	350	finally
    //   322	347	350	finally
    //   352	354	350	finally
    //   1094	1108	350	finally
    //   68	73	361	java/lang/Exception
    //   77	91	361	java/lang/Exception
    //   294	302	361	java/lang/Exception
    //   306	308	361	java/lang/Exception
    //   358	361	361	java/lang/Exception
    //   449	455	361	java/lang/Exception
    //   459	470	361	java/lang/Exception
    //   474	482	361	java/lang/Exception
    //   486	494	361	java/lang/Exception
    //   498	504	361	java/lang/Exception
    //   508	522	361	java/lang/Exception
    //   533	547	361	java/lang/Exception
    //   558	574	361	java/lang/Exception
    //   582	589	361	java/lang/Exception
    //   593	599	361	java/lang/Exception
    //   616	622	361	java/lang/Exception
    //   626	637	361	java/lang/Exception
    //   645	651	361	java/lang/Exception
    //   655	666	361	java/lang/Exception
    //   670	678	361	java/lang/Exception
    //   682	690	361	java/lang/Exception
    //   694	700	361	java/lang/Exception
    //   704	718	361	java/lang/Exception
    //   729	743	361	java/lang/Exception
    //   754	770	361	java/lang/Exception
    //   778	785	361	java/lang/Exception
    //   789	795	361	java/lang/Exception
    //   812	818	361	java/lang/Exception
    //   822	833	361	java/lang/Exception
    //   840	846	361	java/lang/Exception
    //   853	859	361	java/lang/Exception
    //   882	885	361	java/lang/Exception
    //   890	896	361	java/lang/Exception
    //   900	911	361	java/lang/Exception
    //   915	923	361	java/lang/Exception
    //   927	935	361	java/lang/Exception
    //   939	945	361	java/lang/Exception
    //   949	963	361	java/lang/Exception
    //   974	988	361	java/lang/Exception
    //   999	1015	361	java/lang/Exception
    //   1023	1030	361	java/lang/Exception
    //   1034	1040	361	java/lang/Exception
    //   1057	1063	361	java/lang/Exception
    //   1067	1078	361	java/lang/Exception
    //   1085	1091	361	java/lang/Exception
    //   1118	1123	361	java/lang/Exception
    //   1127	1136	361	java/lang/Exception
    //   1152	1169	361	java/lang/Exception
    //   1183	1206	361	java/lang/Exception
    //   1210	1227	361	java/lang/Exception
    //   160	206	386	finally
    //   215	237	386	finally
    //   237	240	386	finally
    //   388	391	386	finally
    //   96	110	401	java/lang/Exception
    //   122	131	401	java/lang/Exception
    //   138	147	401	java/lang/Exception
    //   154	157	401	java/lang/Exception
    //   247	257	401	java/lang/Exception
    //   264	276	401	java/lang/Exception
    //   398	401	401	java/lang/Exception
    //   428	441	444	java/lang/Exception
    //   604	608	611	java/lang/Exception
    //   276	290	640	java/lang/Exception
    //   800	804	807	java/lang/Exception
    //   96	110	862	finally
    //   122	131	862	finally
    //   138	147	862	finally
    //   154	157	862	finally
    //   247	257	862	finally
    //   264	276	862	finally
    //   398	401	862	finally
    //   406	412	862	finally
    //   415	428	862	finally
    //   864	878	885	java/lang/Exception
    //   1045	1049	1052	java/lang/Exception
    //   1239	1258	1273	finally
    //   1275	1277	1273	finally
    //   1229	1239	1280	java/lang/Exception
    //   1258	1263	1280	java/lang/Exception
    //   1277	1280	1280	java/lang/Exception
    //   1152	1169	1299	java/lang/InterruptedException
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\uxs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
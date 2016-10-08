import android.graphics.Bitmap;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class vvk
  implements Runnable
{
  vvk(vvf paramvvf, String paramString, Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 16	vvk:jdField_a_of_type_Vvf	Lvvf;
    //   4: getfield 44	vvf:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   7: getfield 49	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:jdField_a_of_type_ComTencentMobileqqSurfaceviewactionSpriteSurfaceView	Lcom/tencent/mobileqq/surfaceviewaction/SpriteSurfaceView;
    //   10: ifnull +21 -> 31
    //   13: aload_0
    //   14: getfield 16	vvk:jdField_a_of_type_Vvf	Lvvf;
    //   17: getfield 44	vvf:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   20: getfield 49	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:jdField_a_of_type_ComTencentMobileqqSurfaceviewactionSpriteSurfaceView	Lcom/tencent/mobileqq/surfaceviewaction/SpriteSurfaceView;
    //   23: invokevirtual 55	com/tencent/mobileqq/surfaceviewaction/SpriteSurfaceView:getVisibility	()I
    //   26: bipush 8
    //   28: if_icmpne +19 -> 47
    //   31: invokestatic 61	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   34: ifeq +12 -> 46
    //   37: getstatic 63	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   40: iconst_2
    //   41: ldc 65
    //   43: invokestatic 69	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   46: return
    //   47: aload_0
    //   48: getfield 16	vvk:jdField_a_of_type_Vvf	Lvvf;
    //   51: getfield 44	vvf:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   54: invokestatic 72	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:a	(Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;)Landroid/app/Activity;
    //   57: invokevirtual 78	android/app/Activity:getApplicationContext	()Landroid/content/Context;
    //   60: invokevirtual 84	android/content/Context:getPackageName	()Ljava/lang/String;
    //   63: astore_1
    //   64: aload_0
    //   65: getfield 16	vvk:jdField_a_of_type_Vvf	Lvvf;
    //   68: getfield 44	vvf:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   71: invokestatic 72	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:a	(Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;)Landroid/app/Activity;
    //   74: instanceof 86
    //   77: ifeq +66 -> 143
    //   80: aload_0
    //   81: getfield 16	vvk:jdField_a_of_type_Vvf	Lvvf;
    //   84: getfield 44	vvf:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   87: invokestatic 72	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:a	(Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;)Landroid/app/Activity;
    //   90: astore_2
    //   91: aload_2
    //   92: ifnull +21 -> 113
    //   95: aload_0
    //   96: getfield 16	vvk:jdField_a_of_type_Vvf	Lvvf;
    //   99: getfield 44	vvf:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   102: invokestatic 89	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:a	(Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;)Lcom/tencent/common/app/AppInterface;
    //   105: aload_2
    //   106: aload_1
    //   107: invokevirtual 94	com/tencent/common/app/AppInterface:a	(Landroid/content/Context;Ljava/lang/String;)Z
    //   110: ifeq +17 -> 127
    //   113: aload_2
    //   114: instanceof 86
    //   117: ifeq +82 -> 199
    //   120: getstatic 97	com/tencent/mobileqq/activity/SplashActivity:c	I
    //   123: iconst_2
    //   124: if_icmpeq +75 -> 199
    //   127: invokestatic 61	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   130: ifeq -84 -> 46
    //   133: getstatic 63	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   136: iconst_2
    //   137: ldc 99
    //   139: invokestatic 69	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   142: return
    //   143: aload_0
    //   144: getfield 16	vvk:jdField_a_of_type_Vvf	Lvvf;
    //   147: getfield 44	vvf:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   150: invokestatic 72	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:a	(Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;)Landroid/app/Activity;
    //   153: instanceof 101
    //   156: ifeq +1355 -> 1511
    //   159: aload_0
    //   160: getfield 16	vvk:jdField_a_of_type_Vvf	Lvvf;
    //   163: getfield 44	vvf:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   166: invokestatic 72	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:a	(Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;)Landroid/app/Activity;
    //   169: checkcast 101	com/tencent/mobileqq/pluginsdk/BasePluginActivity
    //   172: invokevirtual 105	com/tencent/mobileqq/pluginsdk/BasePluginActivity:getOutActivity	()Landroid/app/Activity;
    //   175: astore_2
    //   176: new 107	java/lang/StringBuilder
    //   179: dup
    //   180: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   183: aload_1
    //   184: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: ldc 114
    //   189: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   195: astore_1
    //   196: goto -105 -> 91
    //   199: aload_0
    //   200: getfield 16	vvk:jdField_a_of_type_Vvf	Lvvf;
    //   203: getfield 44	vvf:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   206: invokestatic 120	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:a	(Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;)Lcom/tencent/mobileqq/data/MessageForDeliverGiftTips;
    //   209: invokevirtual 125	com/tencent/mobileqq/data/MessageForDeliverGiftTips:isToAll	()Z
    //   212: ifne +16 -> 228
    //   215: aload_0
    //   216: getfield 16	vvk:jdField_a_of_type_Vvf	Lvvf;
    //   219: getfield 44	vvf:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   222: getfield 128	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:jdField_a_of_type_ComTencentMobileqqTroopgiftGiftBitmapAnimaionCache	Lcom/tencent/mobileqq/troopgift/GiftBitmapAnimaionCache;
    //   225: invokevirtual 132	com/tencent/mobileqq/troopgift/GiftBitmapAnimaionCache:b	()V
    //   228: getstatic 137	android/os/Build$VERSION:SDK_INT	I
    //   231: bipush 21
    //   233: if_icmplt +16 -> 249
    //   236: aload_0
    //   237: getfield 16	vvk:jdField_a_of_type_Vvf	Lvvf;
    //   240: getfield 140	vvf:jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips	Lcom/tencent/mobileqq/data/MessageForDeliverGiftTips;
    //   243: invokevirtual 125	com/tencent/mobileqq/data/MessageForDeliverGiftTips:isToAll	()Z
    //   246: ifne +533 -> 779
    //   249: aload_0
    //   250: getfield 16	vvk:jdField_a_of_type_Vvf	Lvvf;
    //   253: getfield 44	vvf:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   256: invokestatic 72	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:a	(Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;)Landroid/app/Activity;
    //   259: invokestatic 145	cooperation/qwallet/plugin/PropertyUtils:b	(Landroid/app/Activity;)I
    //   262: istore 6
    //   264: aload_0
    //   265: getfield 16	vvk:jdField_a_of_type_Vvf	Lvvf;
    //   268: getfield 44	vvf:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   271: invokestatic 72	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:a	(Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;)Landroid/app/Activity;
    //   274: invokevirtual 149	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   277: ldc -106
    //   279: invokevirtual 156	android/content/res/Resources:getDimension	(I)F
    //   282: f2i
    //   283: istore 13
    //   285: aload_0
    //   286: getfield 16	vvk:jdField_a_of_type_Vvf	Lvvf;
    //   289: getfield 44	vvf:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   292: invokestatic 72	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:a	(Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;)Landroid/app/Activity;
    //   295: invokevirtual 160	android/app/Activity:getWindowManager	()Landroid/view/WindowManager;
    //   298: invokeinterface 166 1 0
    //   303: invokevirtual 171	android/view/Display:getWidth	()I
    //   306: istore 11
    //   308: aload_0
    //   309: getfield 16	vvk:jdField_a_of_type_Vvf	Lvvf;
    //   312: getfield 44	vvf:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   315: invokestatic 72	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:a	(Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;)Landroid/app/Activity;
    //   318: invokevirtual 160	android/app/Activity:getWindowManager	()Landroid/view/WindowManager;
    //   321: invokeinterface 166 1 0
    //   326: invokevirtual 174	android/view/Display:getHeight	()I
    //   329: iload 6
    //   331: isub
    //   332: istore 10
    //   334: aload_0
    //   335: getfield 16	vvk:jdField_a_of_type_Vvf	Lvvf;
    //   338: getfield 44	vvf:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   341: getfield 128	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:jdField_a_of_type_ComTencentMobileqqTroopgiftGiftBitmapAnimaionCache	Lcom/tencent/mobileqq/troopgift/GiftBitmapAnimaionCache;
    //   344: invokevirtual 177	com/tencent/mobileqq/troopgift/GiftBitmapAnimaionCache:a	()[I
    //   347: astore_1
    //   348: aload_1
    //   349: iconst_0
    //   350: iaload
    //   351: istore 12
    //   353: aload_1
    //   354: iconst_1
    //   355: iaload
    //   356: istore 4
    //   358: getstatic 137	android/os/Build$VERSION:SDK_INT	I
    //   361: bipush 21
    //   363: if_icmplt +422 -> 785
    //   366: sipush 2005
    //   369: istore 7
    //   371: getstatic 137	android/os/Build$VERSION:SDK_INT	I
    //   374: bipush 21
    //   376: if_icmplt +415 -> 791
    //   379: aload_0
    //   380: getfield 16	vvk:jdField_a_of_type_Vvf	Lvvf;
    //   383: getfield 140	vvf:jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips	Lcom/tencent/mobileqq/data/MessageForDeliverGiftTips;
    //   386: invokevirtual 125	com/tencent/mobileqq/data/MessageForDeliverGiftTips:isToAll	()Z
    //   389: ifeq +402 -> 791
    //   392: ldc -78
    //   394: istore 8
    //   396: aload_0
    //   397: getfield 16	vvk:jdField_a_of_type_Vvf	Lvvf;
    //   400: getfield 140	vvf:jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips	Lcom/tencent/mobileqq/data/MessageForDeliverGiftTips;
    //   403: invokevirtual 125	com/tencent/mobileqq/data/MessageForDeliverGiftTips:isToAll	()Z
    //   406: ifeq +440 -> 846
    //   409: aconst_null
    //   410: astore_2
    //   411: new 107	java/lang/StringBuilder
    //   414: dup
    //   415: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   418: aload_0
    //   419: getfield 18	vvk:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   422: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   425: ldc -76
    //   427: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   430: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   433: invokestatic 186	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   436: astore_1
    //   437: aconst_null
    //   438: astore_3
    //   439: new 107	java/lang/StringBuilder
    //   442: dup
    //   443: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   446: aload_0
    //   447: getfield 18	vvk:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   450: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   453: ldc -68
    //   455: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   458: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   461: invokestatic 186	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   464: astore_2
    //   465: new 190	com/tencent/mobileqq/troopgift/TroopGiftToAllSurfaceView$Options
    //   468: dup
    //   469: invokespecial 191	com/tencent/mobileqq/troopgift/TroopGiftToAllSurfaceView$Options:<init>	()V
    //   472: astore_3
    //   473: aload_3
    //   474: iload 11
    //   476: putfield 193	com/tencent/mobileqq/troopgift/TroopGiftToAllSurfaceView$Options:jdField_a_of_type_Int	I
    //   479: aload_3
    //   480: iload 10
    //   482: putfield 195	com/tencent/mobileqq/troopgift/TroopGiftToAllSurfaceView$Options:jdField_b_of_type_Int	I
    //   485: aload_3
    //   486: iload 11
    //   488: i2f
    //   489: iload 12
    //   491: i2f
    //   492: fdiv
    //   493: putfield 198	com/tencent/mobileqq/troopgift/TroopGiftToAllSurfaceView$Options:jdField_a_of_type_Float	F
    //   496: aload_3
    //   497: aload_0
    //   498: getfield 16	vvk:jdField_a_of_type_Vvf	Lvvf;
    //   501: getfield 44	vvf:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   504: invokestatic 201	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:a	(Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;)Lcom/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData;
    //   507: getfield 206	com/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData:h	I
    //   510: putfield 207	com/tencent/mobileqq/troopgift/TroopGiftToAllSurfaceView$Options:c	I
    //   513: aload_3
    //   514: aload_0
    //   515: getfield 16	vvk:jdField_a_of_type_Vvf	Lvvf;
    //   518: getfield 44	vvf:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   521: invokestatic 201	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:a	(Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;)Lcom/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData;
    //   524: getfield 210	com/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData:j	I
    //   527: putfield 213	com/tencent/mobileqq/troopgift/TroopGiftToAllSurfaceView$Options:jdField_f_of_type_Int	I
    //   530: aload_3
    //   531: aload_0
    //   532: getfield 16	vvk:jdField_a_of_type_Vvf	Lvvf;
    //   535: getfield 44	vvf:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   538: invokestatic 201	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:a	(Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;)Lcom/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData;
    //   541: getfield 216	com/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData:i	I
    //   544: putfield 218	com/tencent/mobileqq/troopgift/TroopGiftToAllSurfaceView$Options:d	I
    //   547: aload_3
    //   548: aload_0
    //   549: getfield 16	vvk:jdField_a_of_type_Vvf	Lvvf;
    //   552: getfield 44	vvf:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   555: invokestatic 201	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:a	(Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;)Lcom/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData;
    //   558: getfield 219	com/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData:jdField_f_of_type_Int	I
    //   561: putfield 222	com/tencent/mobileqq/troopgift/TroopGiftToAllSurfaceView$Options:e	I
    //   564: aload_3
    //   565: aload_0
    //   566: getfield 16	vvk:jdField_a_of_type_Vvf	Lvvf;
    //   569: getfield 44	vvf:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   572: invokestatic 201	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:a	(Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;)Lcom/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData;
    //   575: getfield 225	com/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData:k	I
    //   578: putfield 228	com/tencent/mobileqq/troopgift/TroopGiftToAllSurfaceView$Options:g	I
    //   581: aload_3
    //   582: aload_0
    //   583: getfield 16	vvk:jdField_a_of_type_Vvf	Lvvf;
    //   586: getfield 140	vvf:jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips	Lcom/tencent/mobileqq/data/MessageForDeliverGiftTips;
    //   589: getfield 231	com/tencent/mobileqq/data/MessageForDeliverGiftTips:senderName	Ljava/lang/String;
    //   592: putfield 232	com/tencent/mobileqq/troopgift/TroopGiftToAllSurfaceView$Options:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   595: aload_3
    //   596: aload_0
    //   597: getfield 16	vvk:jdField_a_of_type_Vvf	Lvvf;
    //   600: getfield 44	vvf:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   603: invokestatic 201	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:a	(Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;)Lcom/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData;
    //   606: getfield 235	com/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData:p	Ljava/lang/String;
    //   609: putfield 236	com/tencent/mobileqq/troopgift/TroopGiftToAllSurfaceView$Options:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   612: aload_3
    //   613: aload_0
    //   614: getfield 16	vvk:jdField_a_of_type_Vvf	Lvvf;
    //   617: getfield 44	vvf:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   620: invokestatic 201	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:a	(Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;)Lcom/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData;
    //   623: getfield 238	com/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData:jdField_f_of_type_Boolean	Z
    //   626: putfield 240	com/tencent/mobileqq/troopgift/TroopGiftToAllSurfaceView$Options:jdField_a_of_type_Boolean	Z
    //   629: aload_0
    //   630: getfield 16	vvk:jdField_a_of_type_Vvf	Lvvf;
    //   633: getfield 44	vvf:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   636: getfield 49	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:jdField_a_of_type_ComTencentMobileqqSurfaceviewactionSpriteSurfaceView	Lcom/tencent/mobileqq/surfaceviewaction/SpriteSurfaceView;
    //   639: checkcast 242	com/tencent/mobileqq/troopgift/TroopGiftToAllSurfaceView
    //   642: aload_2
    //   643: aload_0
    //   644: getfield 20	vvk:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   647: aload_1
    //   648: aload_0
    //   649: getfield 16	vvk:jdField_a_of_type_Vvf	Lvvf;
    //   652: getfield 44	vvf:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   655: getfield 128	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:jdField_a_of_type_ComTencentMobileqqTroopgiftGiftBitmapAnimaionCache	Lcom/tencent/mobileqq/troopgift/GiftBitmapAnimaionCache;
    //   658: new 244	vvl
    //   661: dup
    //   662: aload_0
    //   663: invokespecial 247	vvl:<init>	(Lvvk;)V
    //   666: aload_3
    //   667: invokevirtual 250	com/tencent/mobileqq/troopgift/TroopGiftToAllSurfaceView:a	(Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;Lcom/tencent/mobileqq/troopgift/GiftBitmapAnimaionCache;Lcom/tencent/mobileqq/surfaceviewaction/ImageButton$OnClickListener;Lcom/tencent/mobileqq/troopgift/TroopGiftToAllSurfaceView$Options;)V
    //   670: new 252	android/view/WindowManager$LayoutParams
    //   673: dup
    //   674: iconst_m1
    //   675: iconst_m1
    //   676: iload 7
    //   678: iload 8
    //   680: bipush -2
    //   682: invokespecial 255	android/view/WindowManager$LayoutParams:<init>	(IIIII)V
    //   685: astore_1
    //   686: aload_1
    //   687: bipush 51
    //   689: putfield 258	android/view/WindowManager$LayoutParams:gravity	I
    //   692: aload_0
    //   693: getfield 16	vvk:jdField_a_of_type_Vvf	Lvvf;
    //   696: getfield 44	vvf:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   699: invokestatic 261	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:a	(Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;)Landroid/view/WindowManager;
    //   702: aload_0
    //   703: getfield 16	vvk:jdField_a_of_type_Vvf	Lvvf;
    //   706: getfield 44	vvf:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   709: getfield 264	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout	Lcom/tencent/mobileqq/activity/fling/TopGestureLayout;
    //   712: invokeinterface 268 2 0
    //   717: aload_0
    //   718: getfield 16	vvk:jdField_a_of_type_Vvf	Lvvf;
    //   721: getfield 44	vvf:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   724: invokestatic 261	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:a	(Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;)Landroid/view/WindowManager;
    //   727: aload_0
    //   728: getfield 16	vvk:jdField_a_of_type_Vvf	Lvvf;
    //   731: getfield 44	vvf:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   734: getfield 264	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout	Lcom/tencent/mobileqq/activity/fling/TopGestureLayout;
    //   737: aload_1
    //   738: invokeinterface 272 3 0
    //   743: aload_0
    //   744: getfield 16	vvk:jdField_a_of_type_Vvf	Lvvf;
    //   747: getfield 44	vvf:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   750: getfield 49	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:jdField_a_of_type_ComTencentMobileqqSurfaceviewactionSpriteSurfaceView	Lcom/tencent/mobileqq/surfaceviewaction/SpriteSurfaceView;
    //   753: iconst_0
    //   754: invokevirtual 276	com/tencent/mobileqq/surfaceviewaction/SpriteSurfaceView:setVisibility	(I)V
    //   757: aload_0
    //   758: getfield 16	vvk:jdField_a_of_type_Vvf	Lvvf;
    //   761: getfield 44	vvf:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   764: iconst_0
    //   765: aload_0
    //   766: getfield 16	vvk:jdField_a_of_type_Vvf	Lvvf;
    //   769: getfield 44	vvf:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   772: invokestatic 201	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:a	(Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;)Lcom/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData;
    //   775: invokevirtual 279	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:a	(ILcom/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData;)V
    //   778: return
    //   779: iconst_0
    //   780: istore 6
    //   782: goto -518 -> 264
    //   785: iconst_2
    //   786: istore 7
    //   788: goto -417 -> 371
    //   791: bipush 8
    //   793: istore 8
    //   795: goto -399 -> 396
    //   798: astore_1
    //   799: aload_2
    //   800: astore_1
    //   801: invokestatic 61	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   804: ifeq -367 -> 437
    //   807: getstatic 63	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   810: iconst_2
    //   811: ldc_w 281
    //   814: invokestatic 69	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   817: aload_2
    //   818: astore_1
    //   819: goto -382 -> 437
    //   822: astore_2
    //   823: aload_3
    //   824: astore_2
    //   825: invokestatic 61	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   828: ifeq -363 -> 465
    //   831: getstatic 63	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   834: iconst_2
    //   835: ldc_w 283
    //   838: invokestatic 69	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   841: aload_3
    //   842: astore_2
    //   843: goto -378 -> 465
    //   846: aload_0
    //   847: getfield 16	vvk:jdField_a_of_type_Vvf	Lvvf;
    //   850: getfield 44	vvf:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   853: getfield 49	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:jdField_a_of_type_ComTencentMobileqqSurfaceviewactionSpriteSurfaceView	Lcom/tencent/mobileqq/surfaceviewaction/SpriteSurfaceView;
    //   856: checkcast 285	com/tencent/mobileqq/troopgift/SendFlowerSurfaceView
    //   859: astore_1
    //   860: aload_1
    //   861: aload_0
    //   862: getfield 20	vvk:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   865: aload_0
    //   866: getfield 22	vvk:b	Landroid/graphics/Bitmap;
    //   869: aload_0
    //   870: getfield 24	vvk:c	Landroid/graphics/Bitmap;
    //   873: aload_0
    //   874: getfield 16	vvk:jdField_a_of_type_Vvf	Lvvf;
    //   877: getfield 44	vvf:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   880: getfield 128	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:jdField_a_of_type_ComTencentMobileqqTroopgiftGiftBitmapAnimaionCache	Lcom/tencent/mobileqq/troopgift/GiftBitmapAnimaionCache;
    //   883: invokevirtual 289	com/tencent/mobileqq/troopgift/SendFlowerSurfaceView:setResource	(Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;Lcom/tencent/mobileqq/troopgift/GiftBitmapAnimaionCache;)V
    //   886: iload 12
    //   888: ifeq +8 -> 896
    //   891: iload 4
    //   893: ifne +60 -> 953
    //   896: invokestatic 61	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   899: ifeq +13 -> 912
    //   902: getstatic 63	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   905: iconst_2
    //   906: ldc_w 291
    //   909: invokestatic 69	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   912: aload_0
    //   913: getfield 16	vvk:jdField_a_of_type_Vvf	Lvvf;
    //   916: getfield 44	vvf:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   919: invokestatic 294	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:a	(Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;)Lcom/tencent/mobileqq/surfaceviewaction/FrameSprite$OnFrameEndListener;
    //   922: ifnull -876 -> 46
    //   925: aload_0
    //   926: getfield 16	vvk:jdField_a_of_type_Vvf	Lvvf;
    //   929: getfield 44	vvf:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   932: invokestatic 294	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:a	(Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;)Lcom/tencent/mobileqq/surfaceviewaction/FrameSprite$OnFrameEndListener;
    //   935: invokeinterface 298 1 0
    //   940: aload_0
    //   941: getfield 16	vvk:jdField_a_of_type_Vvf	Lvvf;
    //   944: getfield 44	vvf:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   947: aconst_null
    //   948: invokestatic 301	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:a	(Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;Lcom/tencent/mobileqq/surfaceviewaction/FrameSprite$OnFrameEndListener;)Lcom/tencent/mobileqq/surfaceviewaction/FrameSprite$OnFrameEndListener;
    //   951: pop
    //   952: return
    //   953: aload_0
    //   954: getfield 16	vvk:jdField_a_of_type_Vvf	Lvvf;
    //   957: getfield 44	vvf:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   960: invokestatic 201	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:a	(Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;)Lcom/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData;
    //   963: getfield 302	com/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData:d	I
    //   966: ifeq +19 -> 985
    //   969: aload_0
    //   970: getfield 16	vvk:jdField_a_of_type_Vvf	Lvvf;
    //   973: getfield 44	vvf:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   976: invokestatic 201	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:a	(Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;)Lcom/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData;
    //   979: getfield 303	com/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData:e	I
    //   982: ifne +36 -> 1018
    //   985: aload_0
    //   986: getfield 16	vvk:jdField_a_of_type_Vvf	Lvvf;
    //   989: getfield 44	vvf:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   992: invokestatic 201	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:a	(Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;)Lcom/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData;
    //   995: iload 11
    //   997: putfield 302	com/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData:d	I
    //   1000: aload_0
    //   1001: getfield 16	vvk:jdField_a_of_type_Vvf	Lvvf;
    //   1004: getfield 44	vvf:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   1007: invokestatic 201	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:a	(Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;)Lcom/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData;
    //   1010: iload 10
    //   1012: iload 13
    //   1014: isub
    //   1015: putfield 303	com/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData:e	I
    //   1018: iload 4
    //   1020: iload 11
    //   1022: imul
    //   1023: iload 12
    //   1025: idiv
    //   1026: istore 4
    //   1028: iload 4
    //   1030: iload 10
    //   1032: if_icmple +472 -> 1504
    //   1035: iload 11
    //   1037: iload 10
    //   1039: imul
    //   1040: iload 4
    //   1042: idiv
    //   1043: istore 9
    //   1045: iload 10
    //   1047: istore 4
    //   1049: aload_0
    //   1050: getfield 16	vvk:jdField_a_of_type_Vvf	Lvvf;
    //   1053: getfield 44	vvf:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   1056: invokestatic 201	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:a	(Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;)Lcom/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData;
    //   1059: getfield 304	com/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData:g	I
    //   1062: iload 10
    //   1064: imul
    //   1065: bipush 100
    //   1067: idiv
    //   1068: iload 4
    //   1070: iconst_2
    //   1071: idiv
    //   1072: isub
    //   1073: istore 5
    //   1075: iload 5
    //   1077: ifge +393 -> 1470
    //   1080: iconst_0
    //   1081: istore 5
    //   1083: iload 11
    //   1085: iload 9
    //   1087: isub
    //   1088: iconst_2
    //   1089: idiv
    //   1090: istore 15
    //   1092: aload_0
    //   1093: getfield 16	vvk:jdField_a_of_type_Vvf	Lvvf;
    //   1096: getfield 44	vvf:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   1099: invokestatic 201	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:a	(Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;)Lcom/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData;
    //   1102: getfield 219	com/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData:jdField_f_of_type_Int	I
    //   1105: iload 4
    //   1107: imul
    //   1108: bipush 100
    //   1110: idiv
    //   1111: istore 11
    //   1113: aload_0
    //   1114: getfield 16	vvk:jdField_a_of_type_Vvf	Lvvf;
    //   1117: getfield 44	vvf:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   1120: invokestatic 72	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:a	(Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;)Landroid/app/Activity;
    //   1123: ldc_w 305
    //   1126: invokestatic 310	com/tencent/mobileqq/util/DisplayUtil:a	(Landroid/content/Context;F)I
    //   1129: iload 11
    //   1131: iadd
    //   1132: aload_0
    //   1133: getfield 16	vvk:jdField_a_of_type_Vvf	Lvvf;
    //   1136: getfield 44	vvf:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   1139: invokestatic 72	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:a	(Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;)Landroid/app/Activity;
    //   1142: ldc_w 311
    //   1145: invokestatic 310	com/tencent/mobileqq/util/DisplayUtil:a	(Landroid/content/Context;F)I
    //   1148: iadd
    //   1149: istore 14
    //   1151: iload 14
    //   1153: iload 13
    //   1155: iadd
    //   1156: iload 4
    //   1158: if_icmple +340 -> 1498
    //   1161: iload 14
    //   1163: iload 13
    //   1165: iadd
    //   1166: iload 10
    //   1168: if_icmpge +330 -> 1498
    //   1171: iload 14
    //   1173: iload 13
    //   1175: iadd
    //   1176: istore 4
    //   1178: aload_0
    //   1179: getfield 16	vvk:jdField_a_of_type_Vvf	Lvvf;
    //   1182: getfield 44	vvf:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   1185: getfield 49	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:jdField_a_of_type_ComTencentMobileqqSurfaceviewactionSpriteSurfaceView	Lcom/tencent/mobileqq/surfaceviewaction/SpriteSurfaceView;
    //   1188: invokevirtual 315	com/tencent/mobileqq/surfaceviewaction/SpriteSurfaceView:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   1191: checkcast 317	android/widget/RelativeLayout$LayoutParams
    //   1194: astore_2
    //   1195: aload_2
    //   1196: iload 9
    //   1198: putfield 320	android/widget/RelativeLayout$LayoutParams:width	I
    //   1201: aload_2
    //   1202: iload 4
    //   1204: putfield 323	android/widget/RelativeLayout$LayoutParams:height	I
    //   1207: aload_2
    //   1208: iload 15
    //   1210: putfield 326	android/widget/RelativeLayout$LayoutParams:leftMargin	I
    //   1213: aload_0
    //   1214: getfield 16	vvk:jdField_a_of_type_Vvf	Lvvf;
    //   1217: getfield 44	vvf:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   1220: getfield 49	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:jdField_a_of_type_ComTencentMobileqqSurfaceviewactionSpriteSurfaceView	Lcom/tencent/mobileqq/surfaceviewaction/SpriteSurfaceView;
    //   1223: aload_2
    //   1224: invokevirtual 330	com/tencent/mobileqq/surfaceviewaction/SpriteSurfaceView:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   1227: new 252	android/view/WindowManager$LayoutParams
    //   1230: dup
    //   1231: iconst_m1
    //   1232: iload 4
    //   1234: iload 7
    //   1236: iload 8
    //   1238: bipush -2
    //   1240: invokespecial 255	android/view/WindowManager$LayoutParams:<init>	(IIIII)V
    //   1243: astore_2
    //   1244: aload_2
    //   1245: bipush 51
    //   1247: putfield 258	android/view/WindowManager$LayoutParams:gravity	I
    //   1250: aload_2
    //   1251: iconst_0
    //   1252: putfield 333	android/view/WindowManager$LayoutParams:x	I
    //   1255: aload_2
    //   1256: iload 5
    //   1258: iload 6
    //   1260: iadd
    //   1261: putfield 336	android/view/WindowManager$LayoutParams:y	I
    //   1264: iload 10
    //   1266: iconst_4
    //   1267: idiv
    //   1268: istore 6
    //   1270: aload_0
    //   1271: getfield 16	vvk:jdField_a_of_type_Vvf	Lvvf;
    //   1274: getfield 44	vvf:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   1277: invokestatic 72	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:a	(Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;)Landroid/app/Activity;
    //   1280: ldc_w 337
    //   1283: invokestatic 310	com/tencent/mobileqq/util/DisplayUtil:a	(Landroid/content/Context;F)I
    //   1286: istore 7
    //   1288: aload_0
    //   1289: getfield 16	vvk:jdField_a_of_type_Vvf	Lvvf;
    //   1292: getfield 44	vvf:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   1295: getfield 340	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   1298: invokevirtual 343	android/widget/ImageView:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   1301: checkcast 317	android/widget/RelativeLayout$LayoutParams
    //   1304: astore_3
    //   1305: aload_3
    //   1306: iload 6
    //   1308: iload 5
    //   1310: isub
    //   1311: iload 7
    //   1313: isub
    //   1314: putfield 346	android/widget/RelativeLayout$LayoutParams:topMargin	I
    //   1317: aload_0
    //   1318: getfield 16	vvk:jdField_a_of_type_Vvf	Lvvf;
    //   1321: getfield 44	vvf:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   1324: getfield 340	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   1327: aload_3
    //   1328: invokevirtual 347	android/widget/ImageView:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   1331: aload_0
    //   1332: getfield 16	vvk:jdField_a_of_type_Vvf	Lvvf;
    //   1335: getfield 44	vvf:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   1338: invokestatic 261	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:a	(Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;)Landroid/view/WindowManager;
    //   1341: aload_0
    //   1342: getfield 16	vvk:jdField_a_of_type_Vvf	Lvvf;
    //   1345: getfield 44	vvf:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   1348: getfield 264	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout	Lcom/tencent/mobileqq/activity/fling/TopGestureLayout;
    //   1351: invokeinterface 268 2 0
    //   1356: aload_0
    //   1357: getfield 16	vvk:jdField_a_of_type_Vvf	Lvvf;
    //   1360: getfield 44	vvf:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   1363: invokestatic 261	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:a	(Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;)Landroid/view/WindowManager;
    //   1366: aload_0
    //   1367: getfield 16	vvk:jdField_a_of_type_Vvf	Lvvf;
    //   1370: getfield 44	vvf:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   1373: getfield 264	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout	Lcom/tencent/mobileqq/activity/fling/TopGestureLayout;
    //   1376: aload_2
    //   1377: invokeinterface 272 3 0
    //   1382: aload_1
    //   1383: iload 9
    //   1385: iload 4
    //   1387: iload 9
    //   1389: i2d
    //   1390: dconst_1
    //   1391: dmul
    //   1392: iload 12
    //   1394: i2d
    //   1395: ddiv
    //   1396: d2f
    //   1397: iload 11
    //   1399: invokevirtual 351	com/tencent/mobileqq/troopgift/SendFlowerSurfaceView:setHeadPositionY	(IIFI)V
    //   1402: invokestatic 61	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1405: ifeq +42 -> 1447
    //   1408: getstatic 63	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1411: iconst_2
    //   1412: new 107	java/lang/StringBuilder
    //   1415: dup
    //   1416: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   1419: ldc_w 353
    //   1422: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1425: iload 9
    //   1427: invokevirtual 356	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1430: ldc_w 358
    //   1433: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1436: iload 4
    //   1438: invokevirtual 356	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1441: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1444: invokestatic 69	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1447: aload_0
    //   1448: getfield 16	vvk:jdField_a_of_type_Vvf	Lvvf;
    //   1451: getfield 44	vvf:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   1454: iload 14
    //   1456: aload_0
    //   1457: getfield 16	vvk:jdField_a_of_type_Vvf	Lvvf;
    //   1460: getfield 44	vvf:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   1463: invokestatic 201	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:a	(Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;)Lcom/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData;
    //   1466: invokevirtual 279	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:a	(ILcom/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData;)V
    //   1469: return
    //   1470: iload 5
    //   1472: iload 4
    //   1474: iadd
    //   1475: iload 10
    //   1477: if_icmple +24 -> 1501
    //   1480: iload 10
    //   1482: iload 4
    //   1484: isub
    //   1485: istore 5
    //   1487: goto -404 -> 1083
    //   1490: astore_3
    //   1491: goto -135 -> 1356
    //   1494: astore_2
    //   1495: goto -778 -> 717
    //   1498: goto -320 -> 1178
    //   1501: goto -418 -> 1083
    //   1504: iload 11
    //   1506: istore 9
    //   1508: goto -459 -> 1049
    //   1511: aconst_null
    //   1512: astore_2
    //   1513: goto -1422 -> 91
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1516	0	this	vvk
    //   63	675	1	localObject1	Object
    //   798	1	1	localOutOfMemoryError1	OutOfMemoryError
    //   800	583	1	localObject2	Object
    //   90	728	2	localObject3	Object
    //   822	1	2	localOutOfMemoryError2	OutOfMemoryError
    //   824	553	2	localObject4	Object
    //   1494	1	2	localException1	Exception
    //   1512	1	2	localObject5	Object
    //   438	890	3	localObject6	Object
    //   1490	1	3	localException2	Exception
    //   356	1129	4	i	int
    //   1073	413	5	j	int
    //   262	1049	6	k	int
    //   369	945	7	m	int
    //   394	843	8	n	int
    //   1043	464	9	i1	int
    //   332	1153	10	i2	int
    //   306	1199	11	i3	int
    //   351	1042	12	i4	int
    //   283	893	13	i5	int
    //   1149	306	14	i6	int
    //   1090	119	15	i7	int
    // Exception table:
    //   from	to	target	type
    //   411	437	798	java/lang/OutOfMemoryError
    //   439	465	822	java/lang/OutOfMemoryError
    //   1331	1356	1490	java/lang/Exception
    //   692	717	1494	java/lang/Exception
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vvk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
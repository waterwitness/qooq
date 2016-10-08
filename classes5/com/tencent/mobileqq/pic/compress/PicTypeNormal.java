package com.tencent.mobileqq.pic.compress;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.Logger;

public class PicTypeNormal
  extends PicType
{
  PicTypeNormal(CompressInfo paramCompressInfo)
  {
    super(paramCompressInfo);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected int a(CompressInfo paramCompressInfo)
  {
    switch (paramCompressInfo.jdField_g_of_type_Int)
    {
    default: 
      return -1;
    case 0: 
    case 1: 
      return 0;
    }
    return 2;
  }
  
  protected final int[] a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_g_of_type_Int == 2) {
      return null;
    }
    int[] arrayOfInt = new int[2];
    PicType.i = Utils.a(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.c, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.j);
    arrayOfInt[0] = PicType.i;
    arrayOfInt[1] = (arrayOfInt[0] * 2);
    Logger.a("PicTypeNormal", "getScaleLargerSide", "PicType.SendPhotoMaxLongSide = " + PicType.i);
    return arrayOfInt;
  }
  
  /* Error */
  protected boolean d()
  {
    // Byte code:
    //   0: fconst_1
    //   1: fstore_1
    //   2: iconst_0
    //   3: istore 9
    //   5: aload_0
    //   6: getfield 80	com/tencent/mobileqq/pic/compress/PicTypeNormal:t	I
    //   9: ifne +891 -> 900
    //   12: aload_0
    //   13: getfield 27	com/tencent/mobileqq/pic/compress/PicTypeNormal:jdField_a_of_type_ComTencentMobileqqPicCompressInfo	Lcom/tencent/mobileqq/pic/CompressInfo;
    //   16: getfield 82	com/tencent/mobileqq/pic/CompressInfo:jdField_g_of_type_Boolean	Z
    //   19: ifeq +105 -> 124
    //   22: aload_0
    //   23: getfield 27	com/tencent/mobileqq/pic/compress/PicTypeNormal:jdField_a_of_type_ComTencentMobileqqPicCompressInfo	Lcom/tencent/mobileqq/pic/CompressInfo;
    //   26: getfield 31	com/tencent/mobileqq/pic/CompressInfo:c	Ljava/lang/String;
    //   29: invokestatic 86	com/tencent/mobileqq/pic/compress/Utils:b	(Ljava/lang/String;)Z
    //   32: ifeq +92 -> 124
    //   35: aload_0
    //   36: getfield 27	com/tencent/mobileqq/pic/compress/PicTypeNormal:jdField_a_of_type_ComTencentMobileqqPicCompressInfo	Lcom/tencent/mobileqq/pic/CompressInfo;
    //   39: aload_0
    //   40: getfield 27	com/tencent/mobileqq/pic/compress/PicTypeNormal:jdField_a_of_type_ComTencentMobileqqPicCompressInfo	Lcom/tencent/mobileqq/pic/CompressInfo;
    //   43: getfield 31	com/tencent/mobileqq/pic/CompressInfo:c	Ljava/lang/String;
    //   46: putfield 89	com/tencent/mobileqq/pic/CompressInfo:e	Ljava/lang/String;
    //   49: aload_0
    //   50: getfield 27	com/tencent/mobileqq/pic/compress/PicTypeNormal:jdField_a_of_type_ComTencentMobileqqPicCompressInfo	Lcom/tencent/mobileqq/pic/CompressInfo;
    //   53: new 48	java/lang/StringBuilder
    //   56: dup
    //   57: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   60: aload_0
    //   61: getfield 91	com/tencent/mobileqq/pic/compress/PicTypeNormal:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   64: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: aload_0
    //   68: getfield 27	com/tencent/mobileqq/pic/compress/PicTypeNormal:jdField_a_of_type_ComTencentMobileqqPicCompressInfo	Lcom/tencent/mobileqq/pic/CompressInfo;
    //   71: getfield 92	com/tencent/mobileqq/pic/CompressInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   74: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: ldc 94
    //   79: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   85: putfield 97	com/tencent/mobileqq/pic/CompressInfo:f	Ljava/lang/String;
    //   88: aload_0
    //   89: getfield 91	com/tencent/mobileqq/pic/compress/PicTypeNormal:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   92: new 48	java/lang/StringBuilder
    //   95: dup
    //   96: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   99: aload_0
    //   100: getfield 27	com/tencent/mobileqq/pic/compress/PicTypeNormal:jdField_a_of_type_ComTencentMobileqqPicCompressInfo	Lcom/tencent/mobileqq/pic/CompressInfo;
    //   103: getfield 92	com/tencent/mobileqq/pic/CompressInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   106: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: ldc 99
    //   111: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   117: ldc 101
    //   119: invokestatic 69	com/tencent/mobileqq/pic/Logger:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   122: iconst_1
    //   123: ireturn
    //   124: aload_0
    //   125: invokevirtual 103	com/tencent/mobileqq/pic/compress/PicTypeNormal:a	()[I
    //   128: astore_2
    //   129: aload_2
    //   130: ifnonnull +39 -> 169
    //   133: aload_0
    //   134: getfield 91	com/tencent/mobileqq/pic/compress/PicTypeNormal:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   137: ldc 105
    //   139: new 48	java/lang/StringBuilder
    //   142: dup
    //   143: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   146: aload_0
    //   147: getfield 27	com/tencent/mobileqq/pic/compress/PicTypeNormal:jdField_a_of_type_ComTencentMobileqqPicCompressInfo	Lcom/tencent/mobileqq/pic/CompressInfo;
    //   150: getfield 92	com/tencent/mobileqq/pic/CompressInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   153: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: ldc 107
    //   158: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   164: invokestatic 109	com/tencent/mobileqq/pic/Logger:b	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   167: iconst_0
    //   168: ireturn
    //   169: aload_2
    //   170: iconst_0
    //   171: iaload
    //   172: istore 10
    //   174: aload_2
    //   175: iconst_1
    //   176: iaload
    //   177: istore 5
    //   179: aload_0
    //   180: getfield 27	com/tencent/mobileqq/pic/compress/PicTypeNormal:jdField_a_of_type_ComTencentMobileqqPicCompressInfo	Lcom/tencent/mobileqq/pic/CompressInfo;
    //   183: aload_0
    //   184: getfield 27	com/tencent/mobileqq/pic/compress/PicTypeNormal:jdField_a_of_type_ComTencentMobileqqPicCompressInfo	Lcom/tencent/mobileqq/pic/CompressInfo;
    //   187: getfield 31	com/tencent/mobileqq/pic/CompressInfo:c	Ljava/lang/String;
    //   190: aload_0
    //   191: getfield 27	com/tencent/mobileqq/pic/compress/PicTypeNormal:jdField_a_of_type_ComTencentMobileqqPicCompressInfo	Lcom/tencent/mobileqq/pic/CompressInfo;
    //   194: getfield 23	com/tencent/mobileqq/pic/CompressInfo:jdField_g_of_type_Int	I
    //   197: invokestatic 112	com/tencent/mobileqq/pic/compress/Utils:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   200: putfield 89	com/tencent/mobileqq/pic/CompressInfo:e	Ljava/lang/String;
    //   203: aload_0
    //   204: getfield 27	com/tencent/mobileqq/pic/compress/PicTypeNormal:jdField_a_of_type_ComTencentMobileqqPicCompressInfo	Lcom/tencent/mobileqq/pic/CompressInfo;
    //   207: getfield 89	com/tencent/mobileqq/pic/CompressInfo:e	Ljava/lang/String;
    //   210: invokestatic 118	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   213: ifeq +39 -> 252
    //   216: aload_0
    //   217: getfield 91	com/tencent/mobileqq/pic/compress/PicTypeNormal:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   220: ldc 105
    //   222: new 48	java/lang/StringBuilder
    //   225: dup
    //   226: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   229: aload_0
    //   230: getfield 27	com/tencent/mobileqq/pic/compress/PicTypeNormal:jdField_a_of_type_ComTencentMobileqqPicCompressInfo	Lcom/tencent/mobileqq/pic/CompressInfo;
    //   233: getfield 92	com/tencent/mobileqq/pic/CompressInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   236: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: ldc 120
    //   241: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   247: invokestatic 109	com/tencent/mobileqq/pic/Logger:b	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   250: iconst_0
    //   251: ireturn
    //   252: aload_0
    //   253: getfield 27	com/tencent/mobileqq/pic/compress/PicTypeNormal:jdField_a_of_type_ComTencentMobileqqPicCompressInfo	Lcom/tencent/mobileqq/pic/CompressInfo;
    //   256: getfield 89	com/tencent/mobileqq/pic/CompressInfo:e	Ljava/lang/String;
    //   259: invokestatic 123	com/tencent/mobileqq/utils/FileUtils:b	(Ljava/lang/String;)Z
    //   262: ifeq +39 -> 301
    //   265: aload_0
    //   266: getfield 91	com/tencent/mobileqq/pic/compress/PicTypeNormal:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   269: ldc 105
    //   271: new 48	java/lang/StringBuilder
    //   274: dup
    //   275: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   278: aload_0
    //   279: getfield 27	com/tencent/mobileqq/pic/compress/PicTypeNormal:jdField_a_of_type_ComTencentMobileqqPicCompressInfo	Lcom/tencent/mobileqq/pic/CompressInfo;
    //   282: getfield 92	com/tencent/mobileqq/pic/CompressInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   285: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: ldc 125
    //   290: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   296: invokestatic 109	com/tencent/mobileqq/pic/Logger:b	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   299: iconst_1
    //   300: ireturn
    //   301: new 127	android/graphics/BitmapFactory$Options
    //   304: dup
    //   305: invokespecial 128	android/graphics/BitmapFactory$Options:<init>	()V
    //   308: astore_2
    //   309: aload_2
    //   310: aload_0
    //   311: getfield 27	com/tencent/mobileqq/pic/compress/PicTypeNormal:jdField_a_of_type_ComTencentMobileqqPicCompressInfo	Lcom/tencent/mobileqq/pic/CompressInfo;
    //   314: getfield 31	com/tencent/mobileqq/pic/CompressInfo:c	Ljava/lang/String;
    //   317: iload 5
    //   319: iload 10
    //   321: invokestatic 131	com/tencent/mobileqq/pic/compress/Utils:a	(Landroid/graphics/BitmapFactory$Options;Ljava/lang/String;II)Z
    //   324: ifne +39 -> 363
    //   327: aload_0
    //   328: getfield 91	com/tencent/mobileqq/pic/compress/PicTypeNormal:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   331: ldc 105
    //   333: new 48	java/lang/StringBuilder
    //   336: dup
    //   337: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   340: aload_0
    //   341: getfield 27	com/tencent/mobileqq/pic/compress/PicTypeNormal:jdField_a_of_type_ComTencentMobileqqPicCompressInfo	Lcom/tencent/mobileqq/pic/CompressInfo;
    //   344: getfield 92	com/tencent/mobileqq/pic/CompressInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   347: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   350: ldc -123
    //   352: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   358: invokestatic 109	com/tencent/mobileqq/pic/Logger:b	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   361: iconst_0
    //   362: ireturn
    //   363: aload_0
    //   364: getfield 27	com/tencent/mobileqq/pic/compress/PicTypeNormal:jdField_a_of_type_ComTencentMobileqqPicCompressInfo	Lcom/tencent/mobileqq/pic/CompressInfo;
    //   367: getfield 31	com/tencent/mobileqq/pic/CompressInfo:c	Ljava/lang/String;
    //   370: aload_2
    //   371: invokestatic 139	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   374: astore_3
    //   375: aload_3
    //   376: ifnonnull +100 -> 476
    //   379: aload_0
    //   380: getfield 91	com/tencent/mobileqq/pic/compress/PicTypeNormal:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   383: ldc 105
    //   385: new 48	java/lang/StringBuilder
    //   388: dup
    //   389: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   392: aload_0
    //   393: getfield 27	com/tencent/mobileqq/pic/compress/PicTypeNormal:jdField_a_of_type_ComTencentMobileqqPicCompressInfo	Lcom/tencent/mobileqq/pic/CompressInfo;
    //   396: getfield 92	com/tencent/mobileqq/pic/CompressInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   399: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   402: ldc -115
    //   404: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   407: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   410: invokestatic 109	com/tencent/mobileqq/pic/Logger:b	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   413: iconst_0
    //   414: ireturn
    //   415: astore_2
    //   416: aload_0
    //   417: getfield 27	com/tencent/mobileqq/pic/compress/PicTypeNormal:jdField_a_of_type_ComTencentMobileqqPicCompressInfo	Lcom/tencent/mobileqq/pic/CompressInfo;
    //   420: iconst_1
    //   421: invokevirtual 144	com/tencent/mobileqq/pic/CompressInfo:a	(Z)V
    //   424: aload_2
    //   425: invokevirtual 147	java/lang/OutOfMemoryError:printStackTrace	()V
    //   428: aload_0
    //   429: getfield 91	com/tencent/mobileqq/pic/compress/PicTypeNormal:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   432: ldc 105
    //   434: new 48	java/lang/StringBuilder
    //   437: dup
    //   438: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   441: aload_0
    //   442: getfield 27	com/tencent/mobileqq/pic/compress/PicTypeNormal:jdField_a_of_type_ComTencentMobileqqPicCompressInfo	Lcom/tencent/mobileqq/pic/CompressInfo;
    //   445: getfield 92	com/tencent/mobileqq/pic/CompressInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   448: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   451: ldc -107
    //   453: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   456: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   459: invokestatic 109	com/tencent/mobileqq/pic/Logger:b	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   462: aload_0
    //   463: getfield 27	com/tencent/mobileqq/pic/compress/PicTypeNormal:jdField_a_of_type_ComTencentMobileqqPicCompressInfo	Lcom/tencent/mobileqq/pic/CompressInfo;
    //   466: ldc -105
    //   468: putfield 89	com/tencent/mobileqq/pic/CompressInfo:e	Ljava/lang/String;
    //   471: aload_0
    //   472: invokevirtual 153	com/tencent/mobileqq/pic/compress/PicTypeNormal:c	()Z
    //   475: ireturn
    //   476: aload_3
    //   477: invokevirtual 159	android/graphics/Bitmap:getWidth	()I
    //   480: istore 5
    //   482: aload_3
    //   483: invokevirtual 162	android/graphics/Bitmap:getHeight	()I
    //   486: istore 6
    //   488: new 164	android/graphics/Matrix
    //   491: dup
    //   492: invokespecial 165	android/graphics/Matrix:<init>	()V
    //   495: astore 4
    //   497: iload 5
    //   499: iload 6
    //   501: if_icmple +259 -> 760
    //   504: iload 5
    //   506: istore 7
    //   508: iload 6
    //   510: istore 8
    //   512: iload 7
    //   514: iload 10
    //   516: if_icmple +386 -> 902
    //   519: iload 10
    //   521: i2f
    //   522: fconst_1
    //   523: iload 7
    //   525: i2f
    //   526: fmul
    //   527: fdiv
    //   528: fstore_1
    //   529: iload 8
    //   531: i2f
    //   532: fload_1
    //   533: fmul
    //   534: f2i
    //   535: istore 8
    //   537: iload 7
    //   539: i2f
    //   540: fload_1
    //   541: fmul
    //   542: f2i
    //   543: istore 7
    //   545: iconst_1
    //   546: istore 7
    //   548: iload 5
    //   550: iload 6
    //   552: if_icmple +3 -> 555
    //   555: aload_0
    //   556: getfield 27	com/tencent/mobileqq/pic/compress/PicTypeNormal:jdField_a_of_type_ComTencentMobileqqPicCompressInfo	Lcom/tencent/mobileqq/pic/CompressInfo;
    //   559: getfield 31	com/tencent/mobileqq/pic/CompressInfo:c	Ljava/lang/String;
    //   562: invokestatic 171	com/tencent/image/JpegExifReader:getRotationDegree	(Ljava/lang/String;)I
    //   565: istore 10
    //   567: iload 9
    //   569: istore 8
    //   571: aload_0
    //   572: getfield 27	com/tencent/mobileqq/pic/compress/PicTypeNormal:jdField_a_of_type_ComTencentMobileqqPicCompressInfo	Lcom/tencent/mobileqq/pic/CompressInfo;
    //   575: getfield 173	com/tencent/mobileqq/pic/CompressInfo:d	Z
    //   578: ifeq +46 -> 624
    //   581: iload 9
    //   583: istore 8
    //   585: iload 10
    //   587: ifeq +37 -> 624
    //   590: iload 9
    //   592: istore 8
    //   594: iload 10
    //   596: bipush 90
    //   598: irem
    //   599: ifne +25 -> 624
    //   602: aload 4
    //   604: iload 10
    //   606: i2f
    //   607: iload 5
    //   609: iconst_1
    //   610: ishr
    //   611: i2f
    //   612: iload 6
    //   614: iconst_1
    //   615: ishr
    //   616: i2f
    //   617: invokevirtual 177	android/graphics/Matrix:postRotate	(FFF)Z
    //   620: pop
    //   621: iconst_1
    //   622: istore 8
    //   624: iload 7
    //   626: ifeq +11 -> 637
    //   629: aload 4
    //   631: fload_1
    //   632: fload_1
    //   633: invokevirtual 181	android/graphics/Matrix:postScale	(FF)Z
    //   636: pop
    //   637: iload 8
    //   639: ifne +10 -> 649
    //   642: aload_3
    //   643: astore_2
    //   644: iload 7
    //   646: ifeq +17 -> 663
    //   649: aload_3
    //   650: iconst_0
    //   651: iconst_0
    //   652: iload 5
    //   654: iload 6
    //   656: aload 4
    //   658: iconst_1
    //   659: invokestatic 185	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   662: astore_2
    //   663: aload_0
    //   664: getfield 27	com/tencent/mobileqq/pic/compress/PicTypeNormal:jdField_a_of_type_ComTencentMobileqqPicCompressInfo	Lcom/tencent/mobileqq/pic/CompressInfo;
    //   667: getfield 89	com/tencent/mobileqq/pic/CompressInfo:e	Ljava/lang/String;
    //   670: aload_2
    //   671: aload_0
    //   672: invokevirtual 187	com/tencent/mobileqq/pic/compress/PicTypeNormal:a	()I
    //   675: aload_0
    //   676: getfield 27	com/tencent/mobileqq/pic/compress/PicTypeNormal:jdField_a_of_type_ComTencentMobileqqPicCompressInfo	Lcom/tencent/mobileqq/pic/CompressInfo;
    //   679: getfield 92	com/tencent/mobileqq/pic/CompressInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   682: aload_0
    //   683: getfield 27	com/tencent/mobileqq/pic/compress/PicTypeNormal:jdField_a_of_type_ComTencentMobileqqPicCompressInfo	Lcom/tencent/mobileqq/pic/CompressInfo;
    //   686: invokestatic 190	com/tencent/mobileqq/pic/compress/Utils:a	(Ljava/lang/String;Landroid/graphics/Bitmap;ILjava/lang/String;Lcom/tencent/mobileqq/pic/CompressInfo;)Z
    //   689: istore 11
    //   691: aload_0
    //   692: getfield 27	com/tencent/mobileqq/pic/compress/PicTypeNormal:jdField_a_of_type_ComTencentMobileqqPicCompressInfo	Lcom/tencent/mobileqq/pic/CompressInfo;
    //   695: getfield 31	com/tencent/mobileqq/pic/CompressInfo:c	Ljava/lang/String;
    //   698: invokestatic 193	com/tencent/image/JpegExifReader:isCrashJpeg	(Ljava/lang/String;)Z
    //   701: ifne +185 -> 886
    //   704: new 195	android/media/ExifInterface
    //   707: dup
    //   708: aload_0
    //   709: getfield 27	com/tencent/mobileqq/pic/compress/PicTypeNormal:jdField_a_of_type_ComTencentMobileqqPicCompressInfo	Lcom/tencent/mobileqq/pic/CompressInfo;
    //   712: getfield 31	com/tencent/mobileqq/pic/CompressInfo:c	Ljava/lang/String;
    //   715: invokespecial 198	android/media/ExifInterface:<init>	(Ljava/lang/String;)V
    //   718: new 195	android/media/ExifInterface
    //   721: dup
    //   722: aload_0
    //   723: getfield 27	com/tencent/mobileqq/pic/compress/PicTypeNormal:jdField_a_of_type_ComTencentMobileqqPicCompressInfo	Lcom/tencent/mobileqq/pic/CompressInfo;
    //   726: getfield 89	com/tencent/mobileqq/pic/CompressInfo:e	Ljava/lang/String;
    //   729: invokespecial 198	android/media/ExifInterface:<init>	(Ljava/lang/String;)V
    //   732: invokestatic 203	com/tencent/mobileqq/utils/ImageUtil:a	(Landroid/media/ExifInterface;Landroid/media/ExifInterface;)Z
    //   735: ifne +14 -> 749
    //   738: aload_0
    //   739: getfield 91	com/tencent/mobileqq/pic/compress/PicTypeNormal:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   742: ldc 105
    //   744: ldc -51
    //   746: invokestatic 109	com/tencent/mobileqq/pic/Logger:b	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   749: aload_2
    //   750: ifnull +7 -> 757
    //   753: aload_2
    //   754: invokevirtual 208	android/graphics/Bitmap:recycle	()V
    //   757: iload 11
    //   759: ireturn
    //   760: iload 6
    //   762: istore 7
    //   764: iload 5
    //   766: istore 8
    //   768: goto -256 -> 512
    //   771: astore_2
    //   772: aload_0
    //   773: getfield 91	com/tencent/mobileqq/pic/compress/PicTypeNormal:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   776: ldc 105
    //   778: new 48	java/lang/StringBuilder
    //   781: dup
    //   782: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   785: aload_0
    //   786: getfield 27	com/tencent/mobileqq/pic/compress/PicTypeNormal:jdField_a_of_type_ComTencentMobileqqPicCompressInfo	Lcom/tencent/mobileqq/pic/CompressInfo;
    //   789: getfield 92	com/tencent/mobileqq/pic/CompressInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   792: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   795: ldc -46
    //   797: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   800: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   803: invokestatic 109	com/tencent/mobileqq/pic/Logger:b	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   806: aload_3
    //   807: astore_2
    //   808: goto -145 -> 663
    //   811: astore_2
    //   812: aload_0
    //   813: getfield 91	com/tencent/mobileqq/pic/compress/PicTypeNormal:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   816: ldc 105
    //   818: new 48	java/lang/StringBuilder
    //   821: dup
    //   822: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   825: aload_0
    //   826: getfield 27	com/tencent/mobileqq/pic/compress/PicTypeNormal:jdField_a_of_type_ComTencentMobileqqPicCompressInfo	Lcom/tencent/mobileqq/pic/CompressInfo;
    //   829: getfield 92	com/tencent/mobileqq/pic/CompressInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   832: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   835: ldc -44
    //   837: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   840: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   843: invokestatic 109	com/tencent/mobileqq/pic/Logger:b	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   846: aload_3
    //   847: astore_2
    //   848: goto -185 -> 663
    //   851: astore_3
    //   852: aload_0
    //   853: getfield 91	com/tencent/mobileqq/pic/compress/PicTypeNormal:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   856: ldc 105
    //   858: new 48	java/lang/StringBuilder
    //   861: dup
    //   862: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   865: ldc -42
    //   867: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   870: aload_3
    //   871: invokevirtual 217	java/io/IOException:getMessage	()Ljava/lang/String;
    //   874: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   877: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   880: invokestatic 109	com/tencent/mobileqq/pic/Logger:b	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   883: goto -134 -> 749
    //   886: aload_0
    //   887: getfield 91	com/tencent/mobileqq/pic/compress/PicTypeNormal:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   890: ldc 105
    //   892: ldc -37
    //   894: invokestatic 109	com/tencent/mobileqq/pic/Logger:b	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   897: goto -148 -> 749
    //   900: iconst_0
    //   901: ireturn
    //   902: iconst_0
    //   903: istore 7
    //   905: goto -357 -> 548
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	908	0	this	PicTypeNormal
    //   1	632	1	f	float
    //   128	243	2	localObject1	Object
    //   415	10	2	localOutOfMemoryError1	OutOfMemoryError
    //   643	111	2	localObject2	Object
    //   771	1	2	localOutOfMemoryError2	OutOfMemoryError
    //   807	1	2	localObject3	Object
    //   811	1	2	localNullPointerException	NullPointerException
    //   847	1	2	localObject4	Object
    //   374	473	3	localBitmap	android.graphics.Bitmap
    //   851	20	3	localIOException	java.io.IOException
    //   495	162	4	localMatrix	android.graphics.Matrix
    //   177	588	5	i	int
    //   486	275	6	j	int
    //   506	398	7	k	int
    //   510	257	8	m	int
    //   3	588	9	n	int
    //   172	433	10	i1	int
    //   689	69	11	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   363	375	415	java/lang/OutOfMemoryError
    //   379	413	415	java/lang/OutOfMemoryError
    //   649	663	771	java/lang/OutOfMemoryError
    //   649	663	811	java/lang/NullPointerException
    //   704	749	851	java/io/IOException
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\pic\compress\PicTypeNormal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
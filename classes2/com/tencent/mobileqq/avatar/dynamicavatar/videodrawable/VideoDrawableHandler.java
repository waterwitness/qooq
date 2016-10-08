package com.tencent.mobileqq.avatar.dynamicavatar.videodrawable;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.StatisticConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Vector;

public class VideoDrawableHandler
  implements Handler.Callback
{
  public static final int a = 2;
  static VideoDrawableHandler jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableVideoDrawableHandler;
  public static final String a;
  public static final int b = 0;
  public static final int c = 1;
  public static final int d = 2;
  public static int e = 1;
  public static int f = 2;
  public static int g = 4;
  long jdField_a_of_type_Long = 0L;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  MediaMetadataRetriever jdField_a_of_type_AndroidMediaMediaMetadataRetriever;
  Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  VideoDrawableHandler.OnGetFrameListener jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableVideoDrawableHandler$OnGetFrameListener;
  final Object jdField_a_of_type_JavaLangObject = new Object();
  LinkedList jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  Vector jdField_a_of_type_JavaUtilVector = new Vector();
  boolean jdField_a_of_type_Boolean = true;
  Bitmap jdField_b_of_type_AndroidGraphicsBitmap;
  private String jdField_b_of_type_JavaLangString;
  private Bitmap c;
  private int h;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = VideoDrawableHandler.class.getSimpleName();
  }
  
  public VideoDrawableHandler(AppInterface paramAppInterface, VideoDrawableHandler.OnGetFrameListener paramOnGetFrameListener)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableVideoDrawableHandler$OnGetFrameListener = paramOnGetFrameListener;
  }
  
  /* Error */
  public static Bitmap a(String paramString)
  {
    // Byte code:
    //   0: ldc 113
    //   2: invokestatic 117	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   5: astore_1
    //   6: aload_1
    //   7: invokevirtual 121	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   10: astore_2
    //   11: aload_2
    //   12: astore 4
    //   14: aload_1
    //   15: astore_3
    //   16: aload_1
    //   17: ldc 123
    //   19: iconst_1
    //   20: anewarray 39	java/lang/Class
    //   23: dup
    //   24: iconst_0
    //   25: ldc 125
    //   27: aastore
    //   28: invokevirtual 129	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   31: aload_2
    //   32: iconst_1
    //   33: anewarray 4	java/lang/Object
    //   36: dup
    //   37: iconst_0
    //   38: aload_0
    //   39: aastore
    //   40: invokevirtual 135	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   43: pop
    //   44: aload_2
    //   45: astore 4
    //   47: aload_1
    //   48: astore_3
    //   49: getstatic 140	android/os/Build$VERSION:SDK_INT	I
    //   52: bipush 9
    //   54: if_icmpgt +62 -> 116
    //   57: aload_2
    //   58: astore 4
    //   60: aload_1
    //   61: astore_3
    //   62: aload_1
    //   63: ldc -114
    //   65: iconst_0
    //   66: anewarray 39	java/lang/Class
    //   69: invokevirtual 129	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   72: aload_2
    //   73: iconst_0
    //   74: anewarray 4	java/lang/Object
    //   77: invokevirtual 135	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   80: checkcast 144	android/graphics/Bitmap
    //   83: astore 5
    //   85: aload 5
    //   87: astore_0
    //   88: aload_2
    //   89: ifnull +25 -> 114
    //   92: aload_1
    //   93: ldc -110
    //   95: iconst_0
    //   96: anewarray 39	java/lang/Class
    //   99: invokevirtual 129	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   102: aload_2
    //   103: iconst_0
    //   104: anewarray 4	java/lang/Object
    //   107: invokevirtual 135	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   110: pop
    //   111: aload 5
    //   113: astore_0
    //   114: aload_0
    //   115: areturn
    //   116: aload_2
    //   117: astore 4
    //   119: aload_1
    //   120: astore_3
    //   121: aload_1
    //   122: ldc -108
    //   124: iconst_0
    //   125: anewarray 39	java/lang/Class
    //   128: invokevirtual 129	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   131: aload_2
    //   132: iconst_0
    //   133: anewarray 4	java/lang/Object
    //   136: invokevirtual 135	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   139: checkcast 150	[B
    //   142: checkcast 150	[B
    //   145: astore 5
    //   147: aload 5
    //   149: ifnull +91 -> 240
    //   152: aload_2
    //   153: astore 4
    //   155: aload_1
    //   156: astore_3
    //   157: aload 5
    //   159: iconst_0
    //   160: aload 5
    //   162: arraylength
    //   163: invokestatic 156	android/graphics/BitmapFactory:decodeByteArray	([BII)Landroid/graphics/Bitmap;
    //   166: astore 5
    //   168: aload 5
    //   170: astore_3
    //   171: aload_3
    //   172: ifnull +68 -> 240
    //   175: aload_3
    //   176: astore_0
    //   177: aload_2
    //   178: ifnull -64 -> 114
    //   181: aload_1
    //   182: ldc -110
    //   184: iconst_0
    //   185: anewarray 39	java/lang/Class
    //   188: invokevirtual 129	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   191: aload_2
    //   192: iconst_0
    //   193: anewarray 4	java/lang/Object
    //   196: invokevirtual 135	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   199: pop
    //   200: aload_3
    //   201: areturn
    //   202: astore_0
    //   203: aload_3
    //   204: areturn
    //   205: astore 5
    //   207: aload_2
    //   208: astore 4
    //   210: aload_1
    //   211: astore_3
    //   212: invokestatic 162	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   215: ifeq +578 -> 793
    //   218: aload_2
    //   219: astore 4
    //   221: aload_1
    //   222: astore_3
    //   223: getstatic 45	com/tencent/mobileqq/avatar/dynamicavatar/videodrawable/VideoDrawableHandler:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   226: iconst_2
    //   227: aload 5
    //   229: invokevirtual 165	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   232: aload 5
    //   234: invokestatic 169	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   237: goto +556 -> 793
    //   240: aload_2
    //   241: astore 4
    //   243: aload_1
    //   244: astore_3
    //   245: aload_0
    //   246: iconst_1
    //   247: invokestatic 175	android/media/ThumbnailUtils:createVideoThumbnail	(Ljava/lang/String;I)Landroid/graphics/Bitmap;
    //   250: astore_0
    //   251: aload_0
    //   252: astore_3
    //   253: aload_3
    //   254: ifnull +33 -> 287
    //   257: aload_3
    //   258: astore_0
    //   259: aload_2
    //   260: ifnull -146 -> 114
    //   263: aload_1
    //   264: ldc -110
    //   266: iconst_0
    //   267: anewarray 39	java/lang/Class
    //   270: invokevirtual 129	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   273: aload_2
    //   274: iconst_0
    //   275: anewarray 4	java/lang/Object
    //   278: invokevirtual 135	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   281: pop
    //   282: aload_3
    //   283: areturn
    //   284: astore_0
    //   285: aload_3
    //   286: areturn
    //   287: aload_2
    //   288: astore 4
    //   290: aload_1
    //   291: astore_3
    //   292: aload_1
    //   293: ldc -79
    //   295: iconst_0
    //   296: anewarray 39	java/lang/Class
    //   299: invokevirtual 129	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   302: aload_2
    //   303: iconst_0
    //   304: anewarray 4	java/lang/Object
    //   307: invokevirtual 135	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   310: checkcast 144	android/graphics/Bitmap
    //   313: astore 5
    //   315: aload 5
    //   317: astore_0
    //   318: aload_2
    //   319: ifnull -205 -> 114
    //   322: aload_1
    //   323: ldc -110
    //   325: iconst_0
    //   326: anewarray 39	java/lang/Class
    //   329: invokevirtual 129	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   332: aload_2
    //   333: iconst_0
    //   334: anewarray 4	java/lang/Object
    //   337: invokevirtual 135	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   340: pop
    //   341: aload 5
    //   343: areturn
    //   344: astore_0
    //   345: aload 5
    //   347: areturn
    //   348: astore_0
    //   349: aconst_null
    //   350: astore_0
    //   351: aconst_null
    //   352: astore_1
    //   353: aload_0
    //   354: ifnull +22 -> 376
    //   357: aload_1
    //   358: ldc -110
    //   360: iconst_0
    //   361: anewarray 39	java/lang/Class
    //   364: invokevirtual 129	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   367: aload_0
    //   368: iconst_0
    //   369: anewarray 4	java/lang/Object
    //   372: invokevirtual 135	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   375: pop
    //   376: aconst_null
    //   377: areturn
    //   378: astore_0
    //   379: aconst_null
    //   380: astore_2
    //   381: aconst_null
    //   382: astore_1
    //   383: aload_2
    //   384: ifnull -8 -> 376
    //   387: aload_1
    //   388: ldc -110
    //   390: iconst_0
    //   391: anewarray 39	java/lang/Class
    //   394: invokevirtual 129	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   397: aload_2
    //   398: iconst_0
    //   399: anewarray 4	java/lang/Object
    //   402: invokevirtual 135	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   405: pop
    //   406: goto -30 -> 376
    //   409: astore_0
    //   410: goto -34 -> 376
    //   413: astore_0
    //   414: aconst_null
    //   415: astore_2
    //   416: aconst_null
    //   417: astore_1
    //   418: aload_2
    //   419: astore 4
    //   421: aload_1
    //   422: astore_3
    //   423: getstatic 45	com/tencent/mobileqq/avatar/dynamicavatar/videodrawable/VideoDrawableHandler:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   426: ldc -78
    //   428: aload_0
    //   429: invokestatic 183	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   432: pop
    //   433: aload_2
    //   434: ifnull -58 -> 376
    //   437: aload_1
    //   438: ldc -110
    //   440: iconst_0
    //   441: anewarray 39	java/lang/Class
    //   444: invokevirtual 129	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   447: aload_2
    //   448: iconst_0
    //   449: anewarray 4	java/lang/Object
    //   452: invokevirtual 135	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   455: pop
    //   456: goto -80 -> 376
    //   459: astore_0
    //   460: goto -84 -> 376
    //   463: astore_0
    //   464: aconst_null
    //   465: astore_2
    //   466: aconst_null
    //   467: astore_1
    //   468: aload_2
    //   469: astore 4
    //   471: aload_1
    //   472: astore_3
    //   473: getstatic 45	com/tencent/mobileqq/avatar/dynamicavatar/videodrawable/VideoDrawableHandler:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   476: ldc -78
    //   478: aload_0
    //   479: invokestatic 183	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   482: pop
    //   483: aload_2
    //   484: ifnull -108 -> 376
    //   487: aload_1
    //   488: ldc -110
    //   490: iconst_0
    //   491: anewarray 39	java/lang/Class
    //   494: invokevirtual 129	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   497: aload_2
    //   498: iconst_0
    //   499: anewarray 4	java/lang/Object
    //   502: invokevirtual 135	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   505: pop
    //   506: goto -130 -> 376
    //   509: astore_0
    //   510: goto -134 -> 376
    //   513: astore_0
    //   514: aconst_null
    //   515: astore_2
    //   516: aconst_null
    //   517: astore_1
    //   518: aload_2
    //   519: astore 4
    //   521: aload_1
    //   522: astore_3
    //   523: getstatic 45	com/tencent/mobileqq/avatar/dynamicavatar/videodrawable/VideoDrawableHandler:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   526: ldc -78
    //   528: aload_0
    //   529: invokestatic 183	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   532: pop
    //   533: aload_2
    //   534: ifnull -158 -> 376
    //   537: aload_1
    //   538: ldc -110
    //   540: iconst_0
    //   541: anewarray 39	java/lang/Class
    //   544: invokevirtual 129	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   547: aload_2
    //   548: iconst_0
    //   549: anewarray 4	java/lang/Object
    //   552: invokevirtual 135	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   555: pop
    //   556: goto -180 -> 376
    //   559: astore_0
    //   560: goto -184 -> 376
    //   563: astore_0
    //   564: aconst_null
    //   565: astore_2
    //   566: aconst_null
    //   567: astore_1
    //   568: aload_2
    //   569: astore 4
    //   571: aload_1
    //   572: astore_3
    //   573: getstatic 45	com/tencent/mobileqq/avatar/dynamicavatar/videodrawable/VideoDrawableHandler:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   576: ldc -78
    //   578: aload_0
    //   579: invokestatic 183	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   582: pop
    //   583: aload_2
    //   584: ifnull -208 -> 376
    //   587: aload_1
    //   588: ldc -110
    //   590: iconst_0
    //   591: anewarray 39	java/lang/Class
    //   594: invokevirtual 129	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   597: aload_2
    //   598: iconst_0
    //   599: anewarray 4	java/lang/Object
    //   602: invokevirtual 135	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   605: pop
    //   606: goto -230 -> 376
    //   609: astore_0
    //   610: goto -234 -> 376
    //   613: astore_0
    //   614: aconst_null
    //   615: astore_2
    //   616: aconst_null
    //   617: astore_1
    //   618: aload_2
    //   619: astore 4
    //   621: aload_1
    //   622: astore_3
    //   623: getstatic 45	com/tencent/mobileqq/avatar/dynamicavatar/videodrawable/VideoDrawableHandler:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   626: ldc -78
    //   628: aload_0
    //   629: invokestatic 183	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   632: pop
    //   633: aload_2
    //   634: ifnull -258 -> 376
    //   637: aload_1
    //   638: ldc -110
    //   640: iconst_0
    //   641: anewarray 39	java/lang/Class
    //   644: invokevirtual 129	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   647: aload_2
    //   648: iconst_0
    //   649: anewarray 4	java/lang/Object
    //   652: invokevirtual 135	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   655: pop
    //   656: goto -280 -> 376
    //   659: astore_0
    //   660: goto -284 -> 376
    //   663: astore_0
    //   664: aconst_null
    //   665: astore 4
    //   667: aconst_null
    //   668: astore_1
    //   669: aload 4
    //   671: ifnull +23 -> 694
    //   674: aload_1
    //   675: ldc -110
    //   677: iconst_0
    //   678: anewarray 39	java/lang/Class
    //   681: invokevirtual 129	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   684: aload 4
    //   686: iconst_0
    //   687: anewarray 4	java/lang/Object
    //   690: invokevirtual 135	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   693: pop
    //   694: aload_0
    //   695: athrow
    //   696: astore_1
    //   697: goto -3 -> 694
    //   700: astore_0
    //   701: aconst_null
    //   702: astore 4
    //   704: goto -35 -> 669
    //   707: astore_0
    //   708: aload_3
    //   709: astore_1
    //   710: goto -41 -> 669
    //   713: astore_0
    //   714: aconst_null
    //   715: astore_2
    //   716: goto -98 -> 618
    //   719: astore_0
    //   720: goto -102 -> 618
    //   723: astore_0
    //   724: aconst_null
    //   725: astore_2
    //   726: goto -158 -> 568
    //   729: astore_0
    //   730: goto -162 -> 568
    //   733: astore_0
    //   734: aconst_null
    //   735: astore_2
    //   736: goto -218 -> 518
    //   739: astore_0
    //   740: goto -222 -> 518
    //   743: astore_0
    //   744: aconst_null
    //   745: astore_2
    //   746: goto -278 -> 468
    //   749: astore_0
    //   750: goto -282 -> 468
    //   753: astore_0
    //   754: aconst_null
    //   755: astore_2
    //   756: goto -338 -> 418
    //   759: astore_0
    //   760: goto -342 -> 418
    //   763: astore_0
    //   764: aconst_null
    //   765: astore_2
    //   766: goto -383 -> 383
    //   769: astore_0
    //   770: goto -387 -> 383
    //   773: astore_0
    //   774: goto -398 -> 376
    //   777: astore_0
    //   778: aconst_null
    //   779: astore_0
    //   780: goto -427 -> 353
    //   783: astore_0
    //   784: aload_2
    //   785: astore_0
    //   786: goto -433 -> 353
    //   789: astore_0
    //   790: aload 5
    //   792: areturn
    //   793: aconst_null
    //   794: astore_3
    //   795: goto -624 -> 171
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	798	0	paramString	String
    //   5	670	1	localClass	Class
    //   696	1	1	localException	Exception
    //   709	1	1	localObject1	Object
    //   10	775	2	localObject2	Object
    //   15	780	3	localObject3	Object
    //   12	691	4	localObject4	Object
    //   83	86	5	localObject5	Object
    //   205	28	5	localOutOfMemoryError	OutOfMemoryError
    //   313	478	5	localBitmap	Bitmap
    // Exception table:
    //   from	to	target	type
    //   181	200	202	java/lang/Exception
    //   157	168	205	java/lang/OutOfMemoryError
    //   263	282	284	java/lang/Exception
    //   322	341	344	java/lang/Exception
    //   0	6	348	java/lang/IllegalArgumentException
    //   0	6	378	java/lang/RuntimeException
    //   387	406	409	java/lang/Exception
    //   0	6	413	java/lang/InstantiationException
    //   437	456	459	java/lang/Exception
    //   0	6	463	java/lang/reflect/InvocationTargetException
    //   487	506	509	java/lang/Exception
    //   0	6	513	java/lang/ClassNotFoundException
    //   537	556	559	java/lang/Exception
    //   0	6	563	java/lang/NoSuchMethodException
    //   587	606	609	java/lang/Exception
    //   0	6	613	java/lang/IllegalAccessException
    //   637	656	659	java/lang/Exception
    //   0	6	663	finally
    //   674	694	696	java/lang/Exception
    //   6	11	700	finally
    //   16	44	707	finally
    //   49	57	707	finally
    //   62	85	707	finally
    //   121	147	707	finally
    //   157	168	707	finally
    //   212	218	707	finally
    //   223	237	707	finally
    //   245	251	707	finally
    //   292	315	707	finally
    //   423	433	707	finally
    //   473	483	707	finally
    //   523	533	707	finally
    //   573	583	707	finally
    //   623	633	707	finally
    //   6	11	713	java/lang/IllegalAccessException
    //   16	44	719	java/lang/IllegalAccessException
    //   49	57	719	java/lang/IllegalAccessException
    //   62	85	719	java/lang/IllegalAccessException
    //   121	147	719	java/lang/IllegalAccessException
    //   157	168	719	java/lang/IllegalAccessException
    //   212	218	719	java/lang/IllegalAccessException
    //   223	237	719	java/lang/IllegalAccessException
    //   245	251	719	java/lang/IllegalAccessException
    //   292	315	719	java/lang/IllegalAccessException
    //   6	11	723	java/lang/NoSuchMethodException
    //   16	44	729	java/lang/NoSuchMethodException
    //   49	57	729	java/lang/NoSuchMethodException
    //   62	85	729	java/lang/NoSuchMethodException
    //   121	147	729	java/lang/NoSuchMethodException
    //   157	168	729	java/lang/NoSuchMethodException
    //   212	218	729	java/lang/NoSuchMethodException
    //   223	237	729	java/lang/NoSuchMethodException
    //   245	251	729	java/lang/NoSuchMethodException
    //   292	315	729	java/lang/NoSuchMethodException
    //   6	11	733	java/lang/ClassNotFoundException
    //   16	44	739	java/lang/ClassNotFoundException
    //   49	57	739	java/lang/ClassNotFoundException
    //   62	85	739	java/lang/ClassNotFoundException
    //   121	147	739	java/lang/ClassNotFoundException
    //   157	168	739	java/lang/ClassNotFoundException
    //   212	218	739	java/lang/ClassNotFoundException
    //   223	237	739	java/lang/ClassNotFoundException
    //   245	251	739	java/lang/ClassNotFoundException
    //   292	315	739	java/lang/ClassNotFoundException
    //   6	11	743	java/lang/reflect/InvocationTargetException
    //   16	44	749	java/lang/reflect/InvocationTargetException
    //   49	57	749	java/lang/reflect/InvocationTargetException
    //   62	85	749	java/lang/reflect/InvocationTargetException
    //   121	147	749	java/lang/reflect/InvocationTargetException
    //   157	168	749	java/lang/reflect/InvocationTargetException
    //   212	218	749	java/lang/reflect/InvocationTargetException
    //   223	237	749	java/lang/reflect/InvocationTargetException
    //   245	251	749	java/lang/reflect/InvocationTargetException
    //   292	315	749	java/lang/reflect/InvocationTargetException
    //   6	11	753	java/lang/InstantiationException
    //   16	44	759	java/lang/InstantiationException
    //   49	57	759	java/lang/InstantiationException
    //   62	85	759	java/lang/InstantiationException
    //   121	147	759	java/lang/InstantiationException
    //   157	168	759	java/lang/InstantiationException
    //   212	218	759	java/lang/InstantiationException
    //   223	237	759	java/lang/InstantiationException
    //   245	251	759	java/lang/InstantiationException
    //   292	315	759	java/lang/InstantiationException
    //   6	11	763	java/lang/RuntimeException
    //   16	44	769	java/lang/RuntimeException
    //   49	57	769	java/lang/RuntimeException
    //   62	85	769	java/lang/RuntimeException
    //   121	147	769	java/lang/RuntimeException
    //   157	168	769	java/lang/RuntimeException
    //   212	218	769	java/lang/RuntimeException
    //   223	237	769	java/lang/RuntimeException
    //   245	251	769	java/lang/RuntimeException
    //   292	315	769	java/lang/RuntimeException
    //   357	376	773	java/lang/Exception
    //   6	11	777	java/lang/IllegalArgumentException
    //   16	44	783	java/lang/IllegalArgumentException
    //   49	57	783	java/lang/IllegalArgumentException
    //   62	85	783	java/lang/IllegalArgumentException
    //   121	147	783	java/lang/IllegalArgumentException
    //   157	168	783	java/lang/IllegalArgumentException
    //   212	218	783	java/lang/IllegalArgumentException
    //   223	237	783	java/lang/IllegalArgumentException
    //   245	251	783	java/lang/IllegalArgumentException
    //   292	315	783	java/lang/IllegalArgumentException
    //   92	111	789	java/lang/Exception
  }
  
  private void d()
  {
    if (!this.jdField_a_of_type_Boolean) {}
    VideoDrawableHandler.DecodeFrameTask localDecodeFrameTask;
    do
    {
      return;
      localDecodeFrameTask = (VideoDrawableHandler.DecodeFrameTask)this.jdField_a_of_type_JavaUtilLinkedList.poll();
    } while (localDecodeFrameTask == null);
    this.jdField_a_of_type_Boolean = false;
    ThreadManager.a(localDecodeFrameTask, null, true);
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public Bitmap a()
  {
    return this.c;
  }
  
  public Bitmap a(int paramInt)
  {
    boolean bool2 = false;
    if (this.jdField_a_of_type_AndroidMediaMediaMetadataRetriever == null) {
      return null;
    }
    if (this.c != null) {}
    for (int j = g | 0x0;; j = 0)
    {
      int k;
      if (this.h < 3)
      {
        try
        {
          localObject1 = this.jdField_a_of_type_AndroidMediaMediaMetadataRetriever.getFrameAtTime(paramInt * 1000, 3);
          if (localObject1 != null) {
            break label597;
          }
          i = 1;
        }
        catch (OutOfMemoryError localOutOfMemoryError1)
        {
          for (;;)
          {
            Object localObject1;
            if (QLog.isColorLevel()) {
              QLog.i(jdField_a_of_type_JavaLangString, 2, localOutOfMemoryError1.getMessage(), localOutOfMemoryError1);
            }
            localObject2 = null;
            i = 3;
          }
        }
        catch (Throwable localThrowable1)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.i(jdField_a_of_type_JavaLangString, 2, localThrowable1.getMessage(), localThrowable1);
            }
            localObject3 = null;
            i = 2;
            continue;
            j = i;
            i = 0;
            continue;
            k = i;
            i = j;
            continue;
            i = 0;
          }
        }
        if (localObject1 != null)
        {
          k = e;
          j |= k;
          k = i;
        }
      }
      for (int i = j;; i = j)
      {
        if ((k == 1) || (k == 2)) {
          this.h += 1;
        }
        if ((localObject1 == null) && (k != 3))
        {
          try
          {
            localObject4 = this.jdField_a_of_type_AndroidMediaMediaMetadataRetriever.getFrameAtTime(paramInt * 1000, 2);
            localObject1 = localObject4;
            if (localObject1 != null) {
              break label570;
            }
            j = 1;
          }
          catch (OutOfMemoryError localOutOfMemoryError2)
          {
            for (;;)
            {
              Object localObject4;
              Object localObject5;
              String str;
              Object localObject2;
              if (QLog.isColorLevel()) {
                QLog.i(jdField_a_of_type_JavaLangString, 2, localOutOfMemoryError2.getMessage(), localOutOfMemoryError2);
              }
              j = 3;
            }
          }
          catch (Throwable localThrowable2)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.i(jdField_a_of_type_JavaLangString, 2, localThrowable2.getMessage(), localThrowable2);
              }
              j = 2;
              continue;
              boolean bool1 = false;
              continue;
              int m = i;
              i = j;
              j = m;
              continue;
              j = 0;
            }
          }
          if (localObject1 != null)
          {
            m = f | i;
            i = j;
            j = m;
            m = i << 2 | k;
            if (localObject1 == null) {
              QLog.i(jdField_a_of_type_JavaLangString, 1, "getBitmapAt at:" + paramInt + " status:" + j + " errorReason:" + m);
            }
            if (QLog.isColorLevel())
            {
              localObject4 = jdField_a_of_type_JavaLangString;
              localObject5 = new StringBuilder().append("getBitmapAt ").append(paramInt).append(" failCount:").append(this.h).append(" bmp!=null:");
              if (localObject1 != null)
              {
                bool1 = true;
                QLog.i((String)localObject4, 2, bool1 + " status:" + j + " errorReason:" + m);
              }
            }
            else
            {
              localObject4 = new HashMap();
              ((HashMap)localObject4).put("param_DeviceType", StatisticConstants.a() + "");
              ((HashMap)localObject4).put("param_ErrorArbitary", k + "");
              ((HashMap)localObject4).put("param_ErrorKey", i + "");
              localObject5 = StatisticCollector.a(BaseApplicationImpl.getContext());
              str = this.jdField_a_of_type_ComTencentCommonAppAppInterface.a();
              bool1 = bool2;
              if (localObject1 != null) {
                bool1 = true;
              }
              ((StatisticCollector)localObject5).a(str, "CMD_EXTRACT_FRAME", bool1, j, m, (HashMap)localObject4, "");
              return (Bitmap)localObject1;
            }
          }
        }
        label570:
        label597:
        k = 0;
        Object localObject3 = null;
      }
    }
  }
  
  public void a()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilVector.size())
    {
      WeakReference localWeakReference = (WeakReference)this.jdField_a_of_type_JavaUtilVector.get(i);
      if ((localWeakReference != null) && (localWeakReference.get() != null)) {
        ((VideoDrawable)localWeakReference.get()).a(this.jdField_a_of_type_AndroidGraphicsBitmap);
      }
      i += 1;
    }
  }
  
  public void a(int paramInt)
  {
    VideoDrawableHandler.DecodeFrameTask localDecodeFrameTask = new VideoDrawableHandler.DecodeFrameTask(this, paramInt);
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilLinkedList.add(localDecodeFrameTask);
      if (this.jdField_a_of_type_JavaUtilLinkedList.size() > 2) {
        this.jdField_a_of_type_JavaUtilLinkedList.removeFirst();
      }
      d();
      return;
    }
  }
  
  public void a(VideoDrawable paramVideoDrawable)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (!this.jdField_a_of_type_JavaUtilVector.contains(paramVideoDrawable)) {
        this.jdField_a_of_type_JavaUtilVector.add(new WeakReference(paramVideoDrawable));
      }
      return;
    }
  }
  
  public boolean a(String paramString)
  {
    boolean bool2 = false;
    try
    {
      if (this.jdField_a_of_type_AndroidMediaMediaMetadataRetriever != null) {
        this.jdField_a_of_type_AndroidMediaMediaMetadataRetriever.release();
      }
      this.jdField_a_of_type_AndroidMediaMediaMetadataRetriever = new MediaMetadataRetriever();
      this.jdField_a_of_type_AndroidMediaMediaMetadataRetriever.setDataSource(paramString);
      this.jdField_a_of_type_Long = Long.valueOf(this.jdField_a_of_type_AndroidMediaMediaMetadataRetriever.extractMetadata(9)).longValue();
      long l = this.jdField_a_of_type_Long;
      if (l <= 0L) {
        break label221;
      }
      bool1 = true;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        String str;
        StringBuilder localStringBuilder;
        if (QLog.isColorLevel()) {
          QLog.i(jdField_a_of_type_JavaLangString, 2, localException.getMessage(), localException);
        }
        boolean bool1 = false;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "init suc:" + bool1 + " path:" + paramString);
    }
    if (bool1)
    {
      this.jdField_b_of_type_JavaLangString = paramString;
      this.c = a(this.jdField_b_of_type_JavaLangString);
    }
    str = jdField_a_of_type_JavaLangString;
    localStringBuilder = new StringBuilder().append("init suc:").append(bool1).append(" thumb!=Null:");
    if (this.c != null) {
      bool2 = true;
    }
    QLog.i(str, 1, bool2 + " path:" + paramString);
    return bool1;
  }
  
  public void b()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilLinkedList.clear();
      return;
    }
  }
  
  public void b(VideoDrawable paramVideoDrawable)
  {
    Object localObject1 = this.jdField_a_of_type_JavaLangObject;
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < this.jdField_a_of_type_JavaUtilVector.size())
        {
          Object localObject2 = (WeakReference)this.jdField_a_of_type_JavaUtilVector.get(i);
          if ((localObject2 == null) || (((WeakReference)localObject2).get() == paramVideoDrawable))
          {
            localObject2 = this.jdField_a_of_type_JavaUtilVector;
            int j = i - 1;
            ((Vector)localObject2).remove(i);
            i = j;
          }
          else if (((WeakReference)localObject2).get() == paramVideoDrawable)
          {
            this.jdField_a_of_type_JavaUtilVector.remove(i);
          }
        }
        else
        {
          return;
        }
      }
      finally {}
      i += 1;
    }
  }
  
  public void c()
  {
    b();
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    if (this.jdField_a_of_type_AndroidMediaMediaMetadataRetriever != null)
    {
      this.jdField_a_of_type_AndroidMediaMediaMetadataRetriever.release();
      this.jdField_a_of_type_AndroidMediaMediaMetadataRetriever = null;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      int i = paramMessage.arg1;
      paramMessage = this.jdField_a_of_type_JavaLangObject;
      if (i == 0) {}
      try
      {
        a();
        if ((this.jdField_b_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_b_of_type_AndroidGraphicsBitmap.isRecycled()) && (this.jdField_b_of_type_AndroidGraphicsBitmap != this.jdField_a_of_type_AndroidGraphicsBitmap) && (this.jdField_b_of_type_AndroidGraphicsBitmap != this.c)) {
          this.jdField_b_of_type_AndroidGraphicsBitmap.recycle();
        }
        if (QLog.isColorLevel()) {
          QLog.i(jdField_a_of_type_JavaLangString, 2, "refresh. pending task size:" + this.jdField_a_of_type_JavaUtilLinkedList.size());
        }
        this.jdField_a_of_type_Boolean = true;
        d();
      }
      finally {}
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\avatar\dynamicavatar\videodrawable\VideoDrawableHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
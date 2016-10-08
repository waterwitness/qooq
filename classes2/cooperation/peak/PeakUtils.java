package cooperation.peak;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryActivity;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaData;
import com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tencent.mobileqq.hitrate.PreloadProcHitSession;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.BinderWarpper;

public final class PeakUtils
{
  public static final int a = 5000;
  public static final SparseBooleanArray a;
  public static PreloadProcHitSession a;
  public static final String a = "PEAK";
  public static final int[] a;
  public static final String b = "extra.CAN_FORWARD_TO_GROUP_ALBUM";
  public static final String c = "extra.EXTRA_FORWARD_TO_QZONE_SRC";
  public static final String d = "extra.GROUP_UIN";
  public static final String e = "extra.GROUP_CODE";
  public static final String f = "KEY_THUMBNAL_BOUND";
  public static final String g = "extra_is_image_center_crop";
  public static final String h = "extra.IS_APOLLO";
  public static final String i = "extra.IS_FROM_CHAT_FILE_HISTORY";
  public static final String j = "extra.IS_FROM_CHAT_AIO_GALLERY";
  public static final String k = "extra.IS_STARTING_CHAT_FILE_HISTORY";
  public static final String l = "PhotoConst.MAXUM_SELECTED_NUM";
  public static final String m = "PhotoConst.IS_SINGLE_MODE";
  public static final String n = "PhotoConst.IS_CONTAIN_GIF";
  public static final String o = "extra.IS_FROM_MULTI_MSG";
  public static final String p = "extra.AIO_CURRENT_PANEL_STATE";
  public static final String q = "extra.MOBILE_QQ_PROCESS_ID";
  public static final String r = "extra.IMAGE_PROVIDER";
  public static final String s = "extra.EXTRA_CURRENT_IMAGE";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_AndroidUtilSparseBooleanArray = new SparseBooleanArray();
    jdField_a_of_type_ArrayOfInt = new int[] { 5, 7, 9 };
    int i1 = 0;
    if (i1 < 10)
    {
      int[] arrayOfInt = jdField_a_of_type_ArrayOfInt;
      int i3 = arrayOfInt.length;
      i2 = 0;
      label52:
      if (i2 >= i3) {
        break label103;
      }
      if (i1 == arrayOfInt[i2] - 1) {
        jdField_a_of_type_AndroidUtilSparseBooleanArray.put(i1, true);
      }
    }
    label103:
    for (int i2 = 1;; i2 = 0)
    {
      if (i2 == 0) {
        jdField_a_of_type_AndroidUtilSparseBooleanArray.put(i1, false);
      }
      i1 += 1;
      break;
      i2 += 1;
      break label52;
      return;
    }
  }
  
  public static int a(String paramString)
  {
    paramString = FileUtils.a(paramString);
    int i1 = 0;
    if ("jpg".equals(paramString)) {
      i1 = 1000;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ImgType", 2, "sender imgType is " + i1);
      }
      return i1;
      if ("png".equals(paramString)) {
        i1 = 1001;
      } else if ("bmp".equals(paramString)) {
        i1 = 1005;
      } else if ("gif".equals(paramString)) {
        i1 = 2000;
      } else if ("apng".equals(paramString)) {
        i1 = 2001;
      } else if ("sharpp".equals(paramString)) {
        i1 = 1004;
      } else if ("webp".equals(paramString)) {
        i1 = 1002;
      }
    }
  }
  
  /* Error */
  public static java.util.ArrayList a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_0
    //   3: ifnonnull +5 -> 8
    //   6: aconst_null
    //   7: areturn
    //   8: new 148	java/io/File
    //   11: dup
    //   12: aload_0
    //   13: invokespecial 151	java/io/File:<init>	(Ljava/lang/String;)V
    //   16: astore_0
    //   17: aload_0
    //   18: invokevirtual 154	java/io/File:exists	()Z
    //   21: ifeq -15 -> 6
    //   24: invokestatic 158	com/tencent/mobileqq/utils/LogTag:a	()V
    //   27: new 160	java/io/ByteArrayOutputStream
    //   30: dup
    //   31: aload_0
    //   32: invokevirtual 164	java/io/File:length	()J
    //   35: l2i
    //   36: invokespecial 167	java/io/ByteArrayOutputStream:<init>	(I)V
    //   39: astore 4
    //   41: new 169	java/io/BufferedInputStream
    //   44: dup
    //   45: new 171	java/io/FileInputStream
    //   48: dup
    //   49: aload_0
    //   50: invokespecial 174	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   53: invokespecial 177	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   56: astore_1
    //   57: aload_1
    //   58: astore_0
    //   59: sipush 1024
    //   62: newarray <illegal type>
    //   64: astore_2
    //   65: aload_1
    //   66: astore_0
    //   67: aload_1
    //   68: aload_2
    //   69: iconst_0
    //   70: sipush 1024
    //   73: invokevirtual 181	java/io/BufferedInputStream:read	([BII)I
    //   76: istore 5
    //   78: iconst_m1
    //   79: iload 5
    //   81: if_icmpeq +113 -> 194
    //   84: aload_1
    //   85: astore_0
    //   86: aload 4
    //   88: aload_2
    //   89: iconst_0
    //   90: iload 5
    //   92: invokevirtual 185	java/io/ByteArrayOutputStream:write	([BII)V
    //   95: goto -30 -> 65
    //   98: astore_2
    //   99: aload_1
    //   100: astore_0
    //   101: aload_2
    //   102: invokevirtual 188	java/io/IOException:printStackTrace	()V
    //   105: aload_1
    //   106: ifnull +209 -> 315
    //   109: aload_1
    //   110: invokevirtual 191	java/io/BufferedInputStream:close	()V
    //   113: iconst_0
    //   114: istore 5
    //   116: aload_3
    //   117: astore_0
    //   118: iload 5
    //   120: ifeq +60 -> 180
    //   123: new 193	java/util/ArrayList
    //   126: dup
    //   127: bipush 10
    //   129: invokespecial 194	java/util/ArrayList:<init>	(I)V
    //   132: astore_1
    //   133: aload 4
    //   135: invokevirtual 198	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   138: astore_2
    //   139: aload_2
    //   140: arraylength
    //   141: istore 7
    //   143: iconst_0
    //   144: istore 5
    //   146: aload_1
    //   147: astore_0
    //   148: iload 5
    //   150: iload 7
    //   152: if_icmpge +28 -> 180
    //   155: iload 5
    //   157: iconst_1
    //   158: iadd
    //   159: istore 6
    //   161: aload_2
    //   162: iload 5
    //   164: baload
    //   165: iconst_m1
    //   166: if_icmpne +142 -> 308
    //   169: aload_2
    //   170: iload 6
    //   172: baload
    //   173: bipush -39
    //   175: if_icmpne +85 -> 260
    //   178: aload_1
    //   179: astore_0
    //   180: aload 4
    //   182: invokevirtual 199	java/io/ByteArrayOutputStream:close	()V
    //   185: ldc -55
    //   187: ldc -53
    //   189: invokestatic 206	com/tencent/mobileqq/utils/LogTag:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   192: aload_0
    //   193: areturn
    //   194: iconst_1
    //   195: istore 6
    //   197: iload 6
    //   199: istore 5
    //   201: aload_1
    //   202: ifnull -86 -> 116
    //   205: aload_1
    //   206: invokevirtual 191	java/io/BufferedInputStream:close	()V
    //   209: iload 6
    //   211: istore 5
    //   213: goto -97 -> 116
    //   216: astore_0
    //   217: aload_0
    //   218: invokevirtual 188	java/io/IOException:printStackTrace	()V
    //   221: iload 6
    //   223: istore 5
    //   225: goto -109 -> 116
    //   228: astore_0
    //   229: aload_0
    //   230: invokevirtual 188	java/io/IOException:printStackTrace	()V
    //   233: iconst_0
    //   234: istore 5
    //   236: goto -120 -> 116
    //   239: astore_1
    //   240: aconst_null
    //   241: astore_0
    //   242: aload_0
    //   243: ifnull +7 -> 250
    //   246: aload_0
    //   247: invokevirtual 191	java/io/BufferedInputStream:close	()V
    //   250: aload_1
    //   251: athrow
    //   252: astore_0
    //   253: aload_0
    //   254: invokevirtual 188	java/io/IOException:printStackTrace	()V
    //   257: goto -7 -> 250
    //   260: aload_2
    //   261: iload 6
    //   263: baload
    //   264: bipush -38
    //   266: if_icmpne +42 -> 308
    //   269: aload_1
    //   270: iload 6
    //   272: iconst_1
    //   273: isub
    //   274: invokestatic 212	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   277: invokevirtual 215	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   280: pop
    //   281: iload 6
    //   283: iconst_1
    //   284: iadd
    //   285: istore 5
    //   287: goto -141 -> 146
    //   290: astore_1
    //   291: aload_1
    //   292: invokevirtual 188	java/io/IOException:printStackTrace	()V
    //   295: goto -110 -> 185
    //   298: astore_1
    //   299: goto -57 -> 242
    //   302: astore_2
    //   303: aconst_null
    //   304: astore_1
    //   305: goto -206 -> 99
    //   308: iload 6
    //   310: istore 5
    //   312: goto -166 -> 146
    //   315: iconst_0
    //   316: istore 5
    //   318: goto -202 -> 116
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	321	0	paramString	String
    //   56	150	1	localObject1	Object
    //   239	31	1	localObject2	Object
    //   290	2	1	localIOException1	java.io.IOException
    //   298	1	1	localObject3	Object
    //   304	1	1	localObject4	Object
    //   64	25	2	arrayOfByte1	byte[]
    //   98	4	2	localIOException2	java.io.IOException
    //   138	123	2	arrayOfByte2	byte[]
    //   302	1	2	localIOException3	java.io.IOException
    //   1	116	3	localObject5	Object
    //   39	142	4	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   76	241	5	i1	int
    //   159	150	6	i2	int
    //   141	12	7	i3	int
    // Exception table:
    //   from	to	target	type
    //   59	65	98	java/io/IOException
    //   67	78	98	java/io/IOException
    //   86	95	98	java/io/IOException
    //   205	209	216	java/io/IOException
    //   109	113	228	java/io/IOException
    //   41	57	239	finally
    //   246	250	252	java/io/IOException
    //   180	185	290	java/io/IOException
    //   59	65	298	finally
    //   67	78	298	finally
    //   86	95	298	finally
    //   101	105	298	finally
    //   41	57	302	java/io/IOException
  }
  
  public static void a(Activity paramActivity, Bundle paramBundle, int paramInt)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    paramBundle = new Intent(BaseApplicationImpl.a, PhotoListActivity.class);
    paramBundle.putExtras(localBundle);
    paramActivity.startActivityForResult(paramBundle, paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("PEAK", 2, "enterPhotoPicker");
    }
    AlbumUtil.a(paramActivity, false, true);
  }
  
  public static void a(Context paramContext, Bundle paramBundle, IAIOImageProvider paramIAIOImageProvider, AIORichMediaData paramAIORichMediaData, int paramInt)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    paramBundle = new Intent(paramContext, AIOGalleryActivity.class);
    paramBundle.addFlags(603979776);
    localBundle.putParcelable("extra.IMAGE_PROVIDER", new BinderWarpper(paramIAIOImageProvider.asBinder()));
    localBundle.putParcelable("extra.EXTRA_CURRENT_IMAGE", paramAIORichMediaData);
    paramBundle.putExtras(localBundle);
    if (paramInt < 0) {
      paramContext.startActivity(paramBundle);
    }
    for (;;)
    {
      if (jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitSession != null) {
        jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitSession.b();
      }
      return;
      if ((paramContext instanceof Activity)) {
        ((Activity)paramContext).startActivityForResult(paramBundle, paramInt);
      }
    }
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt >= 2000) || (paramInt == 3);
  }
  
  /* Error */
  public static boolean a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_2
    //   4: aconst_null
    //   5: astore 7
    //   7: aconst_null
    //   8: astore 6
    //   10: aconst_null
    //   11: astore 5
    //   13: aconst_null
    //   14: astore 4
    //   16: aload_0
    //   17: ifnonnull +5 -> 22
    //   20: iconst_0
    //   21: ireturn
    //   22: new 148	java/io/File
    //   25: dup
    //   26: aload_0
    //   27: invokespecial 151	java/io/File:<init>	(Ljava/lang/String;)V
    //   30: astore_1
    //   31: aload_1
    //   32: invokevirtual 154	java/io/File:exists	()Z
    //   35: ifeq -15 -> 20
    //   38: aload_0
    //   39: invokestatic 295	com/tencent/mobileqq/utils/ImageUtil:b	(Ljava/lang/String;)Z
    //   42: ifeq -22 -> 20
    //   45: invokestatic 158	com/tencent/mobileqq/utils/LogTag:a	()V
    //   48: new 171	java/io/FileInputStream
    //   51: dup
    //   52: aload_1
    //   53: invokespecial 174	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   56: astore_1
    //   57: aload 7
    //   59: astore_2
    //   60: aload 6
    //   62: astore_3
    //   63: aload 5
    //   65: astore 4
    //   67: aload_1
    //   68: invokevirtual 299	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   71: astore_0
    //   72: aload_0
    //   73: astore_2
    //   74: aload_0
    //   75: astore_3
    //   76: aload_0
    //   77: astore 4
    //   79: aload_0
    //   80: getstatic 305	java/nio/channels/FileChannel$MapMode:READ_ONLY	Ljava/nio/channels/FileChannel$MapMode;
    //   83: lconst_0
    //   84: aload_0
    //   85: invokevirtual 310	java/nio/channels/FileChannel:size	()J
    //   88: invokevirtual 314	java/nio/channels/FileChannel:map	(Ljava/nio/channels/FileChannel$MapMode;JJ)Ljava/nio/MappedByteBuffer;
    //   91: astore 5
    //   93: aload_0
    //   94: astore_2
    //   95: aload_0
    //   96: astore_3
    //   97: aload_0
    //   98: astore 4
    //   100: aload_0
    //   101: invokevirtual 310	java/nio/channels/FileChannel:size	()J
    //   104: l2i
    //   105: istore 10
    //   107: iconst_0
    //   108: istore 8
    //   110: iload 8
    //   112: iload 10
    //   114: if_icmpge +347 -> 461
    //   117: iload 8
    //   119: iconst_1
    //   120: iadd
    //   121: istore 9
    //   123: aload_0
    //   124: astore_2
    //   125: aload_0
    //   126: astore_3
    //   127: aload_0
    //   128: astore 4
    //   130: aload 5
    //   132: iload 8
    //   134: invokevirtual 320	java/nio/MappedByteBuffer:get	(I)B
    //   137: iconst_m1
    //   138: if_icmpne +316 -> 454
    //   141: iload 9
    //   143: iload 10
    //   145: if_icmpge +309 -> 454
    //   148: iload 9
    //   150: iconst_1
    //   151: iadd
    //   152: istore 8
    //   154: aload_0
    //   155: astore_2
    //   156: aload_0
    //   157: astore_3
    //   158: aload_0
    //   159: astore 4
    //   161: aload 5
    //   163: iload 9
    //   165: invokevirtual 320	java/nio/MappedByteBuffer:get	(I)B
    //   168: istore 9
    //   170: iload 9
    //   172: bipush -62
    //   174: if_icmpeq +24 -> 198
    //   177: iload 9
    //   179: bipush -58
    //   181: if_icmpeq +17 -> 198
    //   184: iload 9
    //   186: bipush -54
    //   188: if_icmpeq +10 -> 198
    //   191: iload 9
    //   193: bipush -50
    //   195: if_icmpne -85 -> 110
    //   198: iconst_1
    //   199: istore 11
    //   201: aload_0
    //   202: ifnull +7 -> 209
    //   205: aload_0
    //   206: invokevirtual 321	java/nio/channels/FileChannel:close	()V
    //   209: aload_1
    //   210: ifnull +241 -> 451
    //   213: aload_1
    //   214: invokevirtual 322	java/io/FileInputStream:close	()V
    //   217: ldc -55
    //   219: ldc_w 324
    //   222: invokestatic 206	com/tencent/mobileqq/utils/LogTag:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   225: iload 11
    //   227: ireturn
    //   228: astore_0
    //   229: aload_0
    //   230: invokevirtual 188	java/io/IOException:printStackTrace	()V
    //   233: goto -24 -> 209
    //   236: astore_0
    //   237: aload_0
    //   238: invokevirtual 188	java/io/IOException:printStackTrace	()V
    //   241: goto -24 -> 217
    //   244: astore_0
    //   245: aconst_null
    //   246: astore_0
    //   247: aload 4
    //   249: ifnull +8 -> 257
    //   252: aload 4
    //   254: invokevirtual 321	java/nio/channels/FileChannel:close	()V
    //   257: aload_0
    //   258: ifnull +187 -> 445
    //   261: aload_0
    //   262: invokevirtual 322	java/io/FileInputStream:close	()V
    //   265: iconst_0
    //   266: istore 11
    //   268: goto -51 -> 217
    //   271: astore_1
    //   272: aload_1
    //   273: invokevirtual 188	java/io/IOException:printStackTrace	()V
    //   276: goto -19 -> 257
    //   279: astore_0
    //   280: aload_0
    //   281: invokevirtual 188	java/io/IOException:printStackTrace	()V
    //   284: iconst_0
    //   285: istore 11
    //   287: goto -70 -> 217
    //   290: astore_0
    //   291: aconst_null
    //   292: astore_1
    //   293: aload_3
    //   294: ifnull +7 -> 301
    //   297: aload_3
    //   298: invokevirtual 321	java/nio/channels/FileChannel:close	()V
    //   301: aload_1
    //   302: ifnull +143 -> 445
    //   305: aload_1
    //   306: invokevirtual 322	java/io/FileInputStream:close	()V
    //   309: iconst_0
    //   310: istore 11
    //   312: goto -95 -> 217
    //   315: astore_0
    //   316: aload_0
    //   317: invokevirtual 188	java/io/IOException:printStackTrace	()V
    //   320: goto -19 -> 301
    //   323: astore_0
    //   324: aload_0
    //   325: invokevirtual 188	java/io/IOException:printStackTrace	()V
    //   328: iconst_0
    //   329: istore 11
    //   331: goto -114 -> 217
    //   334: astore_0
    //   335: aconst_null
    //   336: astore_1
    //   337: aload_2
    //   338: ifnull +7 -> 345
    //   341: aload_2
    //   342: invokevirtual 321	java/nio/channels/FileChannel:close	()V
    //   345: aload_1
    //   346: ifnull +99 -> 445
    //   349: aload_1
    //   350: invokevirtual 322	java/io/FileInputStream:close	()V
    //   353: iconst_0
    //   354: istore 11
    //   356: goto -139 -> 217
    //   359: astore_0
    //   360: aload_0
    //   361: invokevirtual 188	java/io/IOException:printStackTrace	()V
    //   364: goto -19 -> 345
    //   367: astore_0
    //   368: aload_0
    //   369: invokevirtual 188	java/io/IOException:printStackTrace	()V
    //   372: iconst_0
    //   373: istore 11
    //   375: goto -158 -> 217
    //   378: astore_0
    //   379: aconst_null
    //   380: astore_1
    //   381: aconst_null
    //   382: astore_2
    //   383: aload_2
    //   384: ifnull +7 -> 391
    //   387: aload_2
    //   388: invokevirtual 321	java/nio/channels/FileChannel:close	()V
    //   391: aload_1
    //   392: ifnull +7 -> 399
    //   395: aload_1
    //   396: invokevirtual 322	java/io/FileInputStream:close	()V
    //   399: aload_0
    //   400: athrow
    //   401: astore_2
    //   402: aload_2
    //   403: invokevirtual 188	java/io/IOException:printStackTrace	()V
    //   406: goto -15 -> 391
    //   409: astore_1
    //   410: aload_1
    //   411: invokevirtual 188	java/io/IOException:printStackTrace	()V
    //   414: goto -15 -> 399
    //   417: astore_0
    //   418: aconst_null
    //   419: astore_2
    //   420: goto -37 -> 383
    //   423: astore_3
    //   424: aload_0
    //   425: astore_2
    //   426: aload_3
    //   427: astore_0
    //   428: goto -45 -> 383
    //   431: astore_0
    //   432: goto -95 -> 337
    //   435: astore_0
    //   436: goto -143 -> 293
    //   439: astore_0
    //   440: aload_1
    //   441: astore_0
    //   442: goto -195 -> 247
    //   445: iconst_0
    //   446: istore 11
    //   448: goto -231 -> 217
    //   451: goto -234 -> 217
    //   454: iload 9
    //   456: istore 8
    //   458: goto -348 -> 110
    //   461: iconst_0
    //   462: istore 11
    //   464: goto -263 -> 201
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	467	0	paramString	String
    //   30	184	1	localObject1	Object
    //   271	2	1	localIOException1	java.io.IOException
    //   292	104	1	localObject2	Object
    //   409	32	1	localIOException2	java.io.IOException
    //   3	385	2	localObject3	Object
    //   401	2	2	localIOException3	java.io.IOException
    //   419	7	2	str	String
    //   1	297	3	localObject4	Object
    //   423	4	3	localObject5	Object
    //   14	239	4	localObject6	Object
    //   11	151	5	localMappedByteBuffer	java.nio.MappedByteBuffer
    //   8	53	6	localObject7	Object
    //   5	53	7	localObject8	Object
    //   108	349	8	i1	int
    //   121	334	9	i2	int
    //   105	41	10	i3	int
    //   199	264	11	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   205	209	228	java/io/IOException
    //   213	217	236	java/io/IOException
    //   48	57	244	java/io/FileNotFoundException
    //   252	257	271	java/io/IOException
    //   261	265	279	java/io/IOException
    //   48	57	290	java/io/IOException
    //   297	301	315	java/io/IOException
    //   305	309	323	java/io/IOException
    //   48	57	334	java/lang/IndexOutOfBoundsException
    //   341	345	359	java/io/IOException
    //   349	353	367	java/io/IOException
    //   48	57	378	finally
    //   387	391	401	java/io/IOException
    //   395	399	409	java/io/IOException
    //   67	72	417	finally
    //   79	93	423	finally
    //   100	107	423	finally
    //   130	141	423	finally
    //   161	170	423	finally
    //   67	72	431	java/lang/IndexOutOfBoundsException
    //   79	93	431	java/lang/IndexOutOfBoundsException
    //   100	107	431	java/lang/IndexOutOfBoundsException
    //   130	141	431	java/lang/IndexOutOfBoundsException
    //   161	170	431	java/lang/IndexOutOfBoundsException
    //   67	72	435	java/io/IOException
    //   79	93	435	java/io/IOException
    //   100	107	435	java/io/IOException
    //   130	141	435	java/io/IOException
    //   161	170	435	java/io/IOException
    //   67	72	439	java/io/FileNotFoundException
    //   79	93	439	java/io/FileNotFoundException
    //   100	107	439	java/io/FileNotFoundException
    //   130	141	439	java/io/FileNotFoundException
    //   161	170	439	java/io/FileNotFoundException
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\peak\PeakUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
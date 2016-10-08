package cooperation.troop_homework.jsp;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.av.camera.QavCameraUsage;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.biz.troop.TroopMemberApiClient.Callback;
import com.tencent.biz.webviewbase.AbsBaseWebViewActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.TroopFileDetailBrowserActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.troop.utils.HWTroopUtils;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import cooperation.troop_homework.outer.TroopHWRecordArrangeActivity;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import ytv;
import ytw;
import ytx;
import yty;
import ytz;
import yua;

public class TroopHWJsPlugin
  extends WebViewPlugin
  implements TroopMemberApiClient.Callback, TroopHWFileDownloadManager.OnDownloadStateListener, TroopHWVoiceController.RecordCallback
{
  static final byte jdField_a_of_type_Byte = 1;
  protected static final String a = "TroopHWJsPlugin";
  static final byte jdField_b_of_type_Byte = 2;
  public static final String b = "homework";
  static final byte jdField_c_of_type_Byte = 3;
  static final String jdField_c_of_type_JavaLangString = "http://s.p.qq.com/cgi-bin/homework/upload/media.fcg";
  static final byte jdField_d_of_type_Byte = 4;
  static final String jdField_d_of_type_JavaLangString = "http://s.p.qq.com/cgi-bin/homework/upload/picture.fcg";
  public static final String e = AppConstants.bC + "homeworkTmp/";
  static final int k = 0;
  static final int jdField_l_of_type_Int = 1;
  static final int m = 3;
  static final int n = 0;
  static final int o = 1;
  private Handler jdField_a_of_type_AndroidOsHandler = new ytx(this);
  TroopMemberApiClient jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = null;
  ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet = null;
  private TroopHWFileDownloadManager jdField_a_of_type_CooperationTroop_homeworkJspTroopHWFileDownloadManager;
  TroopHWVoiceController jdField_a_of_type_CooperationTroop_homeworkJspTroopHWVoiceController = null;
  public HashMap a;
  boolean jdField_a_of_type_Boolean = false;
  boolean jdField_b_of_type_Boolean;
  public String f;
  String g;
  String h;
  String i = null;
  String j = null;
  public String k = null;
  private String jdField_l_of_type_JavaLangString;
  public int p = 0;
  public int q = 1;
  int r = -1;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public TroopHWJsPlugin()
  {
    this.b = false;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.mPluginNameSpace = "homework";
  }
  
  private int a(Bitmap paramBitmap)
  {
    int i2 = 100;
    int i1;
    if (Build.VERSION.SDK_INT >= 12)
    {
      i1 = paramBitmap.getByteCount();
      if (i1 <= 6291456) {
        break label48;
      }
      i2 = 0;
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
    }
    label48:
    do
    {
      return i2;
      i1 = paramBitmap.getRowBytes() * paramBitmap.getHeight();
      break;
      if (i1 > 1048576) {
        return 80;
      }
    } while (i1 <= 102400);
    return 90;
  }
  
  private String a(int paramInt, String paramString)
  {
    localStringBuilder = null;
    for (;;)
    {
      try
      {
        localObject1 = new FileInputStream(paramString);
        try
        {
          localStringBuilder = new StringBuilder();
          localObject2 = new byte['砀'];
          int i1 = ((FileInputStream)localObject1).read((byte[])localObject2);
          if (i1 == -1) {
            continue;
          }
          if (i1 >= 30720) {
            continue;
          }
          byte[] arrayOfByte = new byte[i1];
          System.arraycopy(localObject2, 0, arrayOfByte, 0, i1);
          localStringBuilder.append(Base64Util.encodeToString(arrayOfByte, 2));
          continue;
          if (localObject1 == null) {
            continue;
          }
        }
        finally {}
      }
      finally
      {
        Object localObject2;
        Object localObject1 = localStringBuilder;
        continue;
      }
      ((FileInputStream)localObject1).close();
      throw paramString;
      localStringBuilder.append(Base64Util.encodeToString((byte[])localObject2, 2));
    }
    localObject2 = a(paramInt, 1, "stop", null, -1);
    if (!TextUtils.isEmpty(localStringBuilder.toString())) {
      ((JSONObject)localObject2).put("imgstr", localStringBuilder);
    }
    callJs(this.f, new String[] { ((JSONObject)localObject2).toString() });
    if (localObject1 != null) {
      ((FileInputStream)localObject1).close();
    }
    return paramString;
  }
  
  private void b(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentWidgetActionSheet != null) && (this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing())) {
      return;
    }
    ActionSheet localActionSheet = ActionSheet.a(this.mRuntime.a());
    localActionSheet.a(2131370357, 1);
    localActionSheet.a(2131370359, 1);
    localActionSheet.d(2131367262);
    localActionSheet.a(new ytw(this, paramInt, localActionSheet));
    localActionSheet.show();
    this.jdField_a_of_type_ComTencentWidgetActionSheet = localActionSheet;
  }
  
  /* Error */
  public String a(int paramInt1, String paramString, int paramInt2)
  {
    // Byte code:
    //   0: new 245	java/io/File
    //   3: dup
    //   4: aload_2
    //   5: invokespecial 246	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: invokevirtual 250	java/io/File:length	()J
    //   11: ldc2_w 251
    //   14: lcmp
    //   15: ifle +272 -> 287
    //   18: aconst_null
    //   19: astore 8
    //   21: new 60	java/lang/StringBuilder
    //   24: dup
    //   25: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   28: astore 11
    //   30: new 254	android/graphics/BitmapFactory$Options
    //   33: dup
    //   34: invokespecial 255	android/graphics/BitmapFactory$Options:<init>	()V
    //   37: astore 13
    //   39: aload 13
    //   41: iconst_1
    //   42: putfield 258	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   45: aload 13
    //   47: getstatic 264	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   50: putfield 267	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   53: aload 13
    //   55: iconst_1
    //   56: putfield 270	android/graphics/BitmapFactory$Options:inPurgeable	Z
    //   59: aload_2
    //   60: aload 13
    //   62: invokestatic 276	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   65: pop
    //   66: aload 13
    //   68: getfield 279	android/graphics/BitmapFactory$Options:outWidth	I
    //   71: istore 15
    //   73: aload 13
    //   75: getfield 282	android/graphics/BitmapFactory$Options:outHeight	I
    //   78: istore 17
    //   80: iload 15
    //   82: ifle +1026 -> 1108
    //   85: iload 17
    //   87: ifgt +6 -> 93
    //   90: goto +1018 -> 1108
    //   93: iload 15
    //   95: iload_3
    //   96: if_icmpgt +10 -> 106
    //   99: aload_0
    //   100: iload_1
    //   101: aload_2
    //   102: invokespecial 284	cooperation/troop_homework/jsp/TroopHWJsPlugin:a	(ILjava/lang/String;)Ljava/lang/String;
    //   105: areturn
    //   106: aconst_null
    //   107: astore 7
    //   109: aconst_null
    //   110: astore 10
    //   112: new 286	android/graphics/Matrix
    //   115: dup
    //   116: invokespecial 287	android/graphics/Matrix:<init>	()V
    //   119: astore 12
    //   121: fconst_1
    //   122: fstore 5
    //   124: aload_2
    //   125: invokestatic 293	com/tencent/image/JpegExifReader:readOrientation	(Ljava/lang/String;)I
    //   128: istore 16
    //   130: iload 16
    //   132: iconst_5
    //   133: if_icmpeq +981 -> 1114
    //   136: iload 16
    //   138: bipush 6
    //   140: if_icmpeq +974 -> 1114
    //   143: iload 16
    //   145: bipush 7
    //   147: if_icmpeq +967 -> 1114
    //   150: iload 16
    //   152: bipush 8
    //   154: if_icmpne +948 -> 1102
    //   157: goto +957 -> 1114
    //   160: iload 14
    //   162: ifeq +127 -> 289
    //   165: iload 17
    //   167: iload_3
    //   168: idiv
    //   169: istore 15
    //   171: aload 13
    //   173: iconst_0
    //   174: putfield 258	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   177: iload 15
    //   179: iload 15
    //   181: iconst_1
    //   182: iushr
    //   183: ior
    //   184: istore 15
    //   186: iload 15
    //   188: iload 15
    //   190: iconst_2
    //   191: iushr
    //   192: ior
    //   193: istore 15
    //   195: iload 15
    //   197: iload 15
    //   199: iconst_4
    //   200: iushr
    //   201: ior
    //   202: istore 15
    //   204: iload 15
    //   206: iload 15
    //   208: bipush 8
    //   210: iushr
    //   211: ior
    //   212: istore 15
    //   214: aload 13
    //   216: iload 15
    //   218: iload 15
    //   220: bipush 16
    //   222: iushr
    //   223: ior
    //   224: iconst_1
    //   225: iadd
    //   226: iconst_1
    //   227: iushr
    //   228: putfield 296	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   231: new 150	java/io/FileInputStream
    //   234: dup
    //   235: aload_2
    //   236: invokespecial 153	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   239: astore 9
    //   241: fload 5
    //   243: fstore 4
    //   245: aload 10
    //   247: astore 8
    //   249: aload 9
    //   251: aconst_null
    //   252: aload 13
    //   254: invokestatic 300	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   257: astore 7
    //   259: aload 7
    //   261: ifnonnull +37 -> 298
    //   264: aconst_null
    //   265: astore 7
    //   267: aload 9
    //   269: ifnull +842 -> 1111
    //   272: aload 9
    //   274: invokevirtual 172	java/io/FileInputStream:close	()V
    //   277: aconst_null
    //   278: areturn
    //   279: astore_2
    //   280: aload_2
    //   281: invokevirtual 303	java/lang/OutOfMemoryError:printStackTrace	()V
    //   284: invokestatic 306	java/lang/System:gc	()V
    //   287: aconst_null
    //   288: areturn
    //   289: iload 15
    //   291: iload_3
    //   292: idiv
    //   293: istore 15
    //   295: goto -124 -> 171
    //   298: iload 14
    //   300: ifeq +318 -> 618
    //   303: iload_3
    //   304: i2f
    //   305: fstore 6
    //   307: fload 5
    //   309: fstore 4
    //   311: aload 7
    //   313: astore 8
    //   315: aload 7
    //   317: invokevirtual 144	android/graphics/Bitmap:getHeight	()I
    //   320: i2f
    //   321: fstore 5
    //   323: fload 5
    //   325: fstore 4
    //   327: aload 7
    //   329: astore 8
    //   331: fload 6
    //   333: fload 5
    //   335: fdiv
    //   336: fstore 5
    //   338: fload 5
    //   340: fstore 4
    //   342: goto +778 -> 1120
    //   345: fload 5
    //   347: fstore 4
    //   349: aload 7
    //   351: astore 8
    //   353: aload 12
    //   355: fload 5
    //   357: fload 5
    //   359: invokevirtual 310	android/graphics/Matrix:setScale	(FF)V
    //   362: aload 7
    //   364: astore 8
    //   366: aload 9
    //   368: ifnull +727 -> 1095
    //   371: aload 9
    //   373: invokevirtual 172	java/io/FileInputStream:close	()V
    //   376: aload 7
    //   378: iconst_0
    //   379: iconst_0
    //   380: aload 7
    //   382: invokevirtual 313	android/graphics/Bitmap:getWidth	()I
    //   385: aload 7
    //   387: invokevirtual 144	android/graphics/Bitmap:getHeight	()I
    //   390: aload 12
    //   392: iconst_1
    //   393: invokestatic 317	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   396: astore 10
    //   398: aload 7
    //   400: aload 10
    //   402: if_acmpeq +8 -> 410
    //   405: aload 7
    //   407: invokevirtual 320	android/graphics/Bitmap:recycle	()V
    //   410: aconst_null
    //   411: astore 9
    //   413: aconst_null
    //   414: astore 8
    //   416: aload_0
    //   417: aload 10
    //   419: invokespecial 322	cooperation/troop_homework/jsp/TroopHWJsPlugin:a	(Landroid/graphics/Bitmap;)I
    //   422: istore_3
    //   423: iload_3
    //   424: ifle +665 -> 1089
    //   427: new 324	java/io/ByteArrayOutputStream
    //   430: dup
    //   431: sipush 1024
    //   434: invokespecial 326	java/io/ByteArrayOutputStream:<init>	(I)V
    //   437: astore 7
    //   439: aload 10
    //   441: getstatic 332	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   444: iload_3
    //   445: aload 7
    //   447: invokevirtual 336	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   450: pop
    //   451: aload 11
    //   453: aload 7
    //   455: invokevirtual 340	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   458: iconst_2
    //   459: invokestatic 169	com/tencent/mobileqq/utils/Base64Util:encodeToString	([BI)Ljava/lang/String;
    //   462: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   465: pop
    //   466: aload 10
    //   468: ifnull +8 -> 476
    //   471: aload 10
    //   473: invokevirtual 320	android/graphics/Bitmap:recycle	()V
    //   476: aload_0
    //   477: iload_1
    //   478: iconst_1
    //   479: ldc -82
    //   481: aconst_null
    //   482: iconst_m1
    //   483: invokevirtual 177	cooperation/troop_homework/jsp/TroopHWJsPlugin:a	(IILjava/lang/String;Ljava/lang/String;I)Lorg/json/JSONObject;
    //   486: astore 9
    //   488: aload 11
    //   490: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   493: invokestatic 183	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   496: ifne +13 -> 509
    //   499: aload 9
    //   501: ldc -71
    //   503: aload 11
    //   505: invokevirtual 191	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   508: pop
    //   509: aload_0
    //   510: aload_0
    //   511: getfield 193	cooperation/troop_homework/jsp/TroopHWJsPlugin:f	Ljava/lang/String;
    //   514: iconst_1
    //   515: anewarray 195	java/lang/String
    //   518: dup
    //   519: iconst_0
    //   520: aload 9
    //   522: invokevirtual 196	org/json/JSONObject:toString	()Ljava/lang/String;
    //   525: aastore
    //   526: invokevirtual 200	cooperation/troop_homework/jsp/TroopHWJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   529: aload 7
    //   531: ifnull +550 -> 1081
    //   534: new 60	java/lang/StringBuilder
    //   537: dup
    //   538: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   541: getstatic 80	cooperation/troop_homework/jsp/TroopHWJsPlugin:e	Ljava/lang/String;
    //   544: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   547: aload_2
    //   548: aload_2
    //   549: ldc_w 342
    //   552: invokevirtual 345	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   555: iconst_1
    //   556: iadd
    //   557: invokevirtual 349	java/lang/String:substring	(I)Ljava/lang/String;
    //   560: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   563: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   566: astore 9
    //   568: new 351	java/io/FileOutputStream
    //   571: dup
    //   572: aload 9
    //   574: invokespecial 352	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   577: astore_2
    //   578: aload_2
    //   579: aload 7
    //   581: invokevirtual 340	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   584: invokevirtual 356	java/io/FileOutputStream:write	([B)V
    //   587: aload_2
    //   588: astore 8
    //   590: aload 9
    //   592: astore_2
    //   593: aload 7
    //   595: ifnull +8 -> 603
    //   598: aload 7
    //   600: invokevirtual 357	java/io/ByteArrayOutputStream:close	()V
    //   603: aload_2
    //   604: astore 7
    //   606: aload 8
    //   608: ifnull +503 -> 1111
    //   611: aload 8
    //   613: invokevirtual 358	java/io/FileOutputStream:close	()V
    //   616: aload_2
    //   617: areturn
    //   618: iload_3
    //   619: i2f
    //   620: fstore 6
    //   622: fload 5
    //   624: fstore 4
    //   626: aload 7
    //   628: astore 8
    //   630: aload 7
    //   632: invokevirtual 313	android/graphics/Bitmap:getWidth	()I
    //   635: i2f
    //   636: fstore 5
    //   638: fload 5
    //   640: fstore 4
    //   642: aload 7
    //   644: astore 8
    //   646: fload 6
    //   648: fload 5
    //   650: fdiv
    //   651: fstore 5
    //   653: fload 5
    //   655: fstore 4
    //   657: goto +463 -> 1120
    //   660: fload 5
    //   662: fstore 4
    //   664: aload 7
    //   666: astore 8
    //   668: aload 12
    //   670: fload 5
    //   672: fneg
    //   673: fload 5
    //   675: invokevirtual 310	android/graphics/Matrix:setScale	(FF)V
    //   678: goto -316 -> 362
    //   681: astore 7
    //   683: aload 8
    //   685: astore 7
    //   687: aload 12
    //   689: fload 4
    //   691: fload 4
    //   693: invokevirtual 310	android/graphics/Matrix:setScale	(FF)V
    //   696: aload 7
    //   698: astore 8
    //   700: aload 9
    //   702: ifnull +393 -> 1095
    //   705: aload 9
    //   707: invokevirtual 172	java/io/FileInputStream:close	()V
    //   710: goto -334 -> 376
    //   713: fload 5
    //   715: fstore 4
    //   717: aload 7
    //   719: astore 8
    //   721: aload 12
    //   723: fload 5
    //   725: fload 5
    //   727: invokevirtual 310	android/graphics/Matrix:setScale	(FF)V
    //   730: fload 5
    //   732: fstore 4
    //   734: aload 7
    //   736: astore 8
    //   738: aload 12
    //   740: ldc_w 359
    //   743: invokevirtual 363	android/graphics/Matrix:postRotate	(F)Z
    //   746: pop
    //   747: goto -385 -> 362
    //   750: astore_2
    //   751: aload 9
    //   753: astore 7
    //   755: aload 7
    //   757: ifnull +8 -> 765
    //   760: aload 7
    //   762: invokevirtual 172	java/io/FileInputStream:close	()V
    //   765: aload_2
    //   766: athrow
    //   767: fload 5
    //   769: fneg
    //   770: fstore 6
    //   772: fload 5
    //   774: fstore 4
    //   776: aload 7
    //   778: astore 8
    //   780: aload 12
    //   782: fload 5
    //   784: fload 6
    //   786: invokevirtual 310	android/graphics/Matrix:setScale	(FF)V
    //   789: goto -427 -> 362
    //   792: fload 5
    //   794: fstore 4
    //   796: aload 7
    //   798: astore 8
    //   800: aload 12
    //   802: fload 5
    //   804: fload 5
    //   806: fneg
    //   807: invokevirtual 310	android/graphics/Matrix:setScale	(FF)V
    //   810: fload 5
    //   812: fstore 4
    //   814: aload 7
    //   816: astore 8
    //   818: aload 12
    //   820: ldc_w 364
    //   823: invokevirtual 363	android/graphics/Matrix:postRotate	(F)Z
    //   826: pop
    //   827: goto -465 -> 362
    //   830: fload 5
    //   832: fstore 4
    //   834: aload 7
    //   836: astore 8
    //   838: aload 12
    //   840: fload 5
    //   842: fload 5
    //   844: invokevirtual 310	android/graphics/Matrix:setScale	(FF)V
    //   847: fload 5
    //   849: fstore 4
    //   851: aload 7
    //   853: astore 8
    //   855: aload 12
    //   857: ldc_w 364
    //   860: invokevirtual 363	android/graphics/Matrix:postRotate	(F)Z
    //   863: pop
    //   864: goto -502 -> 362
    //   867: fload 5
    //   869: fstore 4
    //   871: aload 7
    //   873: astore 8
    //   875: aload 12
    //   877: fload 5
    //   879: fneg
    //   880: fload 5
    //   882: invokevirtual 310	android/graphics/Matrix:setScale	(FF)V
    //   885: fload 5
    //   887: fstore 4
    //   889: aload 7
    //   891: astore 8
    //   893: aload 12
    //   895: ldc_w 364
    //   898: invokevirtual 363	android/graphics/Matrix:postRotate	(F)Z
    //   901: pop
    //   902: goto -540 -> 362
    //   905: fload 5
    //   907: fstore 4
    //   909: aload 7
    //   911: astore 8
    //   913: aload 12
    //   915: fload 5
    //   917: fload 5
    //   919: invokevirtual 310	android/graphics/Matrix:setScale	(FF)V
    //   922: fload 5
    //   924: fstore 4
    //   926: aload 7
    //   928: astore 8
    //   930: aload 12
    //   932: ldc_w 365
    //   935: invokevirtual 363	android/graphics/Matrix:postRotate	(F)Z
    //   938: pop
    //   939: goto -577 -> 362
    //   942: astore 8
    //   944: aconst_null
    //   945: astore_2
    //   946: aload 9
    //   948: astore 7
    //   950: aload 8
    //   952: invokevirtual 366	java/io/IOException:printStackTrace	()V
    //   955: aconst_null
    //   956: astore 8
    //   958: aload 7
    //   960: ifnull +8 -> 968
    //   963: aload 7
    //   965: invokevirtual 357	java/io/ByteArrayOutputStream:close	()V
    //   968: aload 8
    //   970: astore 7
    //   972: aload_2
    //   973: ifnull +138 -> 1111
    //   976: aload_2
    //   977: invokevirtual 358	java/io/FileOutputStream:close	()V
    //   980: aconst_null
    //   981: areturn
    //   982: aload 7
    //   984: ifnull +8 -> 992
    //   987: aload 7
    //   989: invokevirtual 357	java/io/ByteArrayOutputStream:close	()V
    //   992: aload 8
    //   994: ifnull +8 -> 1002
    //   997: aload 8
    //   999: invokevirtual 358	java/io/FileOutputStream:close	()V
    //   1002: aload_2
    //   1003: athrow
    //   1004: astore_2
    //   1005: goto -23 -> 982
    //   1008: astore_2
    //   1009: goto -27 -> 982
    //   1012: astore 9
    //   1014: aload_2
    //   1015: astore 8
    //   1017: aload 9
    //   1019: astore_2
    //   1020: goto -38 -> 982
    //   1023: astore 9
    //   1025: aload_2
    //   1026: astore 8
    //   1028: aload 9
    //   1030: astore_2
    //   1031: goto -49 -> 982
    //   1034: astore 8
    //   1036: aconst_null
    //   1037: astore_2
    //   1038: goto -88 -> 950
    //   1041: astore 8
    //   1043: aconst_null
    //   1044: astore_2
    //   1045: goto -95 -> 950
    //   1048: astore 8
    //   1050: goto -100 -> 950
    //   1053: astore_2
    //   1054: aconst_null
    //   1055: astore 7
    //   1057: goto -302 -> 755
    //   1060: astore_2
    //   1061: aload 9
    //   1063: astore 7
    //   1065: goto -310 -> 755
    //   1068: astore 9
    //   1070: fload 5
    //   1072: fstore 4
    //   1074: aload 8
    //   1076: astore 9
    //   1078: goto -391 -> 687
    //   1081: aconst_null
    //   1082: astore 8
    //   1084: aconst_null
    //   1085: astore_2
    //   1086: goto -493 -> 593
    //   1089: aconst_null
    //   1090: astore 7
    //   1092: goto -626 -> 466
    //   1095: aload 8
    //   1097: astore 7
    //   1099: goto -723 -> 376
    //   1102: iconst_0
    //   1103: istore 14
    //   1105: goto -945 -> 160
    //   1108: aconst_null
    //   1109: astore 7
    //   1111: aload 7
    //   1113: areturn
    //   1114: iconst_1
    //   1115: istore 14
    //   1117: goto -957 -> 160
    //   1120: fload 4
    //   1122: f2d
    //   1123: ldc2_w 367
    //   1126: dcmpg
    //   1127: ifge +56 -> 1183
    //   1130: ldc_w 369
    //   1133: fstore 5
    //   1135: iload 16
    //   1137: tableswitch	default:+43->1180, 2:+-477->660, 3:+-424->713, 4:+-370->767, 5:+-345->792, 6:+-307->830, 7:+-270->867, 8:+-232->905
    //   1180: goto -835 -> 345
    //   1183: fconst_1
    //   1184: fstore 5
    //   1186: goto -51 -> 1135
    //   1189: astore_2
    //   1190: aconst_null
    //   1191: astore 7
    //   1193: goto -211 -> 982
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1196	0	this	TroopHWJsPlugin
    //   0	1196	1	paramInt1	int
    //   0	1196	2	paramString	String
    //   0	1196	3	paramInt2	int
    //   243	878	4	f1	float
    //   122	1063	5	f2	float
    //   305	480	6	f3	float
    //   107	558	7	localObject1	Object
    //   681	1	7	localIOException1	java.io.IOException
    //   685	507	7	localObject2	Object
    //   19	910	8	localObject3	Object
    //   942	9	8	localIOException2	java.io.IOException
    //   956	71	8	str	String
    //   1034	1	8	localIOException3	java.io.IOException
    //   1041	1	8	localIOException4	java.io.IOException
    //   1048	27	8	localIOException5	java.io.IOException
    //   1082	14	8	localObject4	Object
    //   239	708	9	localObject5	Object
    //   1012	6	9	localObject6	Object
    //   1023	39	9	localObject7	Object
    //   1068	1	9	localIOException6	java.io.IOException
    //   1076	1	9	localIOException7	java.io.IOException
    //   110	362	10	localBitmap	Bitmap
    //   28	476	11	localStringBuilder	StringBuilder
    //   119	812	12	localMatrix	android.graphics.Matrix
    //   37	216	13	localOptions	android.graphics.BitmapFactory.Options
    //   160	956	14	i1	int
    //   71	223	15	i2	int
    //   128	1008	16	i3	int
    //   78	91	17	i4	int
    // Exception table:
    //   from	to	target	type
    //   30	80	279	java/lang/OutOfMemoryError
    //   99	106	279	java/lang/OutOfMemoryError
    //   112	121	279	java/lang/OutOfMemoryError
    //   272	277	279	java/lang/OutOfMemoryError
    //   371	376	279	java/lang/OutOfMemoryError
    //   376	398	279	java/lang/OutOfMemoryError
    //   405	410	279	java/lang/OutOfMemoryError
    //   598	603	279	java/lang/OutOfMemoryError
    //   611	616	279	java/lang/OutOfMemoryError
    //   705	710	279	java/lang/OutOfMemoryError
    //   760	765	279	java/lang/OutOfMemoryError
    //   765	767	279	java/lang/OutOfMemoryError
    //   963	968	279	java/lang/OutOfMemoryError
    //   976	980	279	java/lang/OutOfMemoryError
    //   987	992	279	java/lang/OutOfMemoryError
    //   997	1002	279	java/lang/OutOfMemoryError
    //   1002	1004	279	java/lang/OutOfMemoryError
    //   249	259	681	java/io/IOException
    //   315	323	681	java/io/IOException
    //   331	338	681	java/io/IOException
    //   353	362	681	java/io/IOException
    //   630	638	681	java/io/IOException
    //   646	653	681	java/io/IOException
    //   668	678	681	java/io/IOException
    //   721	730	681	java/io/IOException
    //   738	747	681	java/io/IOException
    //   780	789	681	java/io/IOException
    //   800	810	681	java/io/IOException
    //   818	827	681	java/io/IOException
    //   838	847	681	java/io/IOException
    //   855	864	681	java/io/IOException
    //   875	885	681	java/io/IOException
    //   893	902	681	java/io/IOException
    //   913	922	681	java/io/IOException
    //   930	939	681	java/io/IOException
    //   249	259	750	finally
    //   315	323	750	finally
    //   331	338	750	finally
    //   353	362	750	finally
    //   630	638	750	finally
    //   646	653	750	finally
    //   668	678	750	finally
    //   721	730	750	finally
    //   738	747	750	finally
    //   780	789	750	finally
    //   800	810	750	finally
    //   818	827	750	finally
    //   838	847	750	finally
    //   855	864	750	finally
    //   875	885	750	finally
    //   893	902	750	finally
    //   913	922	750	finally
    //   930	939	750	finally
    //   416	423	942	java/io/IOException
    //   427	439	942	java/io/IOException
    //   439	466	1004	finally
    //   471	476	1008	finally
    //   476	509	1008	finally
    //   509	529	1008	finally
    //   534	578	1008	finally
    //   578	587	1012	finally
    //   950	955	1023	finally
    //   439	466	1034	java/io/IOException
    //   471	476	1041	java/io/IOException
    //   476	509	1041	java/io/IOException
    //   509	529	1041	java/io/IOException
    //   534	578	1041	java/io/IOException
    //   578	587	1048	java/io/IOException
    //   124	130	1053	finally
    //   165	171	1053	finally
    //   171	177	1053	finally
    //   214	241	1053	finally
    //   289	295	1053	finally
    //   687	696	1060	finally
    //   124	130	1068	java/io/IOException
    //   165	171	1068	java/io/IOException
    //   171	177	1068	java/io/IOException
    //   214	241	1068	java/io/IOException
    //   289	295	1068	java/io/IOException
    //   416	423	1189	finally
    //   427	439	1189	finally
  }
  
  public String a(String paramString1, String paramString2)
  {
    paramString2 = MD5Utils.d(paramString2) + HWTroopUtils.a(paramString2);
    paramString1 = AppConstants.bD + paramString1 + File.separator;
    File localFile = new File(paramString1);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return paramString1 + paramString2;
  }
  
  public JSONObject a(int paramInt1, int paramInt2, String paramString1, String paramString2, int paramInt3)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("id", paramInt1);
      localJSONObject.put("webid", this.h);
      localJSONObject.put("state", paramString1);
      localJSONObject.put("path", "");
      if (!TextUtils.isEmpty(paramString2)) {
        localJSONObject.put("url", paramString2);
      }
      if (paramInt2 == 0)
      {
        localJSONObject.put("type", "record");
        localJSONObject.put("time", paramInt3);
        return localJSONObject;
      }
      localJSONObject.put("type", "image");
      return localJSONObject;
    }
    catch (JSONException paramString1)
    {
      paramString1.printStackTrace();
    }
    return localJSONObject;
  }
  
  public final void a()
  {
    if (QavCameraUsage.b(BaseApplicationImpl.getContext())) {
      return;
    }
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    Object localObject = new File(AppConstants.bo);
    if ((!((File)localObject).exists()) && (!((File)localObject).mkdirs())) {
      QQToast.a(localBaseApplication, 2131368967, 0).a();
    }
    this.g = (AppConstants.bo + System.currentTimeMillis() + ".jpg");
    localObject = Uri.fromFile(new File(this.g));
    Intent localIntent = new Intent("android.media.action.IMAGE_CAPTURE");
    localIntent.putExtra("output", (Parcelable)localObject);
    localIntent.putExtra("android.intent.extra.videoQuality", 100);
    try
    {
      startActivityForResult(localIntent, (byte)2);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      QQToast.a(localBaseApplication, 2131368990, 0).a();
    }
  }
  
  public void a(int paramInt)
  {
    Activity localActivity = this.mRuntime.a();
    if ((localActivity instanceof AbsBaseWebViewActivity))
    {
      Intent localIntent = new Intent();
      localIntent.setClass(localActivity, PhotoListActivity.class);
      localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", localActivity.getClass().getName());
      localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
      localIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", paramInt);
      if (paramInt == 1) {
        localIntent.putExtra("PhotoConst.IS_SINGLE_MODE", true);
      }
      ((AbsBaseWebViewActivity)localActivity).a(this, localIntent, (byte)3);
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
  }
  
  public void a(int paramInt, String paramString)
  {
    switch (paramInt)
    {
    }
    do
    {
      return;
      paramString = "{'webid':'" + this.h + "', 'type':'record', 'state':'downloaded', 'url':'" + paramString + "'}";
      callJs(this.f, new String[] { paramString });
      return;
      String str = "{'webid':'" + this.h + "', 'type':'record', 'state':'stopPlay', 'url':'" + paramString + "'}";
      callJs(this.f, new String[] { str });
    } while ((this.i == null) || (!this.i.equals(paramString)));
    this.i = null;
  }
  
  public void a(Bundle paramBundle)
  {
    if (paramBundle == null) {}
    while (!"getFileInfo".equals(paramBundle.getString("method"))) {
      return;
    }
    ForwardFileInfo localForwardFileInfo = new ForwardFileInfo();
    localForwardFileInfo.b(paramBundle.getLong("sessionId"));
    localForwardFileInfo.d(paramBundle.getInt("cloudType"));
    localForwardFileInfo.b(paramBundle.getInt("type"));
    localForwardFileInfo.a(paramBundle.getString("filePath"));
    localForwardFileInfo.d(paramBundle.getString("fileName"));
    localForwardFileInfo.d(paramBundle.getLong("fileSize"));
    localForwardFileInfo.a(paramBundle.getLong("troopCode"));
    paramBundle = new Intent();
    paramBundle.setClass(this.mRuntime.a(), TroopFileDetailBrowserActivity.class);
    paramBundle.putExtra("fileinfo", localForwardFileInfo);
    paramBundle.putExtra("removemementity", true);
    paramBundle.putExtra("forward_from_troop_file", true);
    paramBundle.putExtra("not_forward", true);
    paramBundle.putExtra("last_time", 0);
    this.mRuntime.a().startActivityForResult(paramBundle, 102);
  }
  
  public void a(String paramString, double paramDouble)
  {
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(this.q), paramString);
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("id", this.q);
      localJSONObject.put("state", "stop");
      localJSONObject.put("path", paramString);
      localJSONObject.put("time", Math.round(paramDouble / 1000.0D));
      callJs(this.f, new String[] { localJSONObject.toString() });
      this.q += 1;
      if (this.b) {
        ThreadManager.a(new yty(this, paramString), 2, null, false);
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void a(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3)
  {
    try
    {
      paramString2 = new JSONObject();
      paramString2.put("url", paramString1);
      paramString2.put("state", paramInt1);
      paramString2.put("finishLen", 0);
      paramString2.put("fileLen", 0);
      if (paramInt1 == 3) {
        paramString2.put("filePath", paramString3);
      }
      callJs(this.l, new String[] { paramString2.toString() });
      return;
    }
    catch (Exception paramString1) {}
  }
  
  public void a(String paramString, long paramLong1, long paramLong2)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("url", paramString);
      localJSONObject.put("state", 2);
      localJSONObject.put("finishLen", paramLong1);
      localJSONObject.put("fileLen", paramLong2);
      callJs(this.l, new String[] { localJSONObject.toString() });
      return;
    }
    catch (Exception paramString) {}
  }
  
  public String b(String paramString1, String paramString2)
  {
    paramString1 = a(paramString1, paramString2);
    if (new File(paramString1).exists()) {
      return paramString1;
    }
    return "";
  }
  
  public void b() {}
  
  public void b(int paramInt, String paramString)
  {
    callJs(this.f, new String[] { a(paramInt, 0, "stopPlay", null, -1).toString() });
    if ((this.r != -1) && (paramInt == this.r)) {
      this.r = -1;
    }
  }
  
  public void c() {}
  
  public void callJs(String paramString, String... paramVarArgs)
  {
    if (!TextUtils.isEmpty(paramString)) {
      super.callJs(paramString, paramVarArgs);
    }
  }
  
  protected boolean handleEvent(String paramString, long paramLong, Map paramMap)
  {
    if (paramLong == 8589934597L) {
      this.jdField_a_of_type_Boolean = this.jdField_a_of_type_CooperationTroop_homeworkJspTroopHWVoiceController.a();
    }
    while ((paramLong != 2L) || (!this.jdField_a_of_type_Boolean)) {
      return false;
    }
    paramString = "{'webid':" + this.h + ", 'type':'home', 'state':'click'}";
    callJs(this.f, new String[] { paramString });
    this.jdField_a_of_type_Boolean = false;
    return false;
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((paramString1 == null) || (!"homework".equals(paramString2)) || (paramString3 == null)) {
      return false;
    }
    paramJsBridgeListener = null;
    try
    {
      paramVarArgs = new JSONObject(paramVarArgs[0]);
      paramJsBridgeListener = paramVarArgs;
    }
    catch (JSONException paramVarArgs)
    {
      Object localObject;
      for (;;) {}
    }
    if (paramJsBridgeListener != null)
    {
      paramVarArgs = paramJsBridgeListener.optString("cb");
      localObject = paramJsBridgeListener.optString("webid");
      this.f = paramVarArgs;
      this.h = ((String)localObject);
      this.j = paramString2;
    }
    if ("openRecord".equals(paramString3))
    {
      paramJsBridgeListener = this.mRuntime.a();
      paramString1 = new Intent();
      paramString1.setComponent(new ComponentName(paramJsBridgeListener, TroopHWRecordArrangeActivity.class));
      paramString1.putExtra("webid", this.h);
      if (TextUtils.isEmpty(this.f)) {
        paramJsBridgeListener.startActivity(paramString1);
      }
    }
    for (;;)
    {
      return true;
      startActivityForResult(paramString1, (byte)1);
      continue;
      int i1;
      if ("playRecord".equals(paramString3))
      {
        i1 = paramJsBridgeListener.optInt("id");
        if (this.r == -1)
        {
          this.jdField_a_of_type_CooperationTroop_homeworkJspTroopHWVoiceController.a(i1, (String)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(i1)));
          this.r = i1;
        }
        else if (i1 != this.r)
        {
          this.jdField_a_of_type_CooperationTroop_homeworkJspTroopHWVoiceController.a();
          this.jdField_a_of_type_CooperationTroop_homeworkJspTroopHWVoiceController.a(i1, (String)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(i1)));
          this.r = i1;
        }
      }
      else if ("stopPlayRecord".equals(paramString3))
      {
        i1 = paramJsBridgeListener.optInt("id");
        if ((this.r != -1) && (i1 == this.r))
        {
          this.jdField_a_of_type_CooperationTroop_homeworkJspTroopHWVoiceController.a();
          this.r = -1;
        }
      }
      else
      {
        int i2;
        if ("openUploadImage".equals(paramString3))
        {
          i2 = paramJsBridgeListener.optInt("num", 10);
          i1 = i2;
          if (i2 > 5) {
            i1 = 5;
          }
          this.p = paramJsBridgeListener.optInt("outMaxWidth");
          i2 = paramJsBridgeListener.optInt("sourcetype");
          if (i2 == 1) {
            a();
          } else if (i2 == 2) {
            a(i1);
          } else {
            b(i1);
          }
        }
        else if ("ShowGroupFile".equals(paramString3))
        {
          long l1 = 0L;
          i1 = 102;
          paramString1 = paramJsBridgeListener.optString("filename");
          paramString2 = paramJsBridgeListener.optString("filepath");
          paramString3 = paramJsBridgeListener.optString("groupcode");
          paramVarArgs = paramJsBridgeListener.optString("filesize");
          paramJsBridgeListener = paramJsBridgeListener.optString("filebusinesstype");
          if (!TextUtils.isEmpty(paramVarArgs)) {
            l1 = Long.valueOf(paramVarArgs).longValue();
          }
          if (!TextUtils.isEmpty(paramJsBridgeListener)) {
            i1 = Integer.valueOf(paramJsBridgeListener).intValue();
          }
          this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a(Long.valueOf(paramString3).longValue(), paramString2, paramString1, l1, i1, this);
        }
        else if ("PlayOnlineRecord".equals(paramString3))
        {
          paramJsBridgeListener = paramJsBridgeListener.optString("url");
          if (this.i == null)
          {
            this.jdField_a_of_type_CooperationTroop_homeworkJspTroopHWVoiceController.b(paramJsBridgeListener);
            this.i = paramJsBridgeListener;
          }
          else if (!this.i.equals(paramJsBridgeListener))
          {
            this.jdField_a_of_type_CooperationTroop_homeworkJspTroopHWVoiceController.a();
            this.jdField_a_of_type_CooperationTroop_homeworkJspTroopHWVoiceController.b(paramJsBridgeListener);
            this.i = paramJsBridgeListener;
          }
        }
        else if ("StopOnlineRecord".equals(paramString3))
        {
          paramJsBridgeListener = paramJsBridgeListener.optString("url");
          if ((this.i != null) && (this.i.equals(paramJsBridgeListener)))
          {
            this.jdField_a_of_type_CooperationTroop_homeworkJspTroopHWVoiceController.a();
            this.i = null;
          }
        }
        else if ("startRecord".equals(paramString3))
        {
          this.jdField_a_of_type_CooperationTroop_homeworkJspTroopHWVoiceController.d(this.mRuntime.a().getAccount());
        }
        else if ("endRecord".equals(paramString3))
        {
          this.b = paramJsBridgeListener.optBoolean("isValid");
          this.k = paramJsBridgeListener.optString("cgiUrl");
          this.jdField_a_of_type_CooperationTroop_homeworkJspTroopHWVoiceController.b();
        }
        else if ("getWeatherBackground".equals(paramString3))
        {
          ThreadManager.a(new ytv(this, AbsDownloader.d(paramString1)), 8, null, false);
        }
        else if ("startDownloadFile".equals(paramString3))
        {
          paramString1 = paramJsBridgeListener.optString("url");
          paramString2 = paramJsBridgeListener.optString("troopUin");
          this.l = paramJsBridgeListener.optString("cb");
          paramJsBridgeListener = a(paramString2, paramString1);
          this.jdField_a_of_type_CooperationTroop_homeworkJspTroopHWFileDownloadManager.a(paramString1, paramJsBridgeListener, this);
        }
        else if ("stopDownloadFile".equals(paramString3))
        {
          paramJsBridgeListener = paramJsBridgeListener.optString("url");
          this.jdField_a_of_type_CooperationTroop_homeworkJspTroopHWFileDownloadManager.a(paramJsBridgeListener);
        }
        else if ("isLocalFileExists".equals(paramString3))
        {
          if (paramJsBridgeListener != null)
          {
            paramString3 = paramJsBridgeListener.optString("troopUin");
            paramVarArgs = paramJsBridgeListener.optJSONArray("fileUrls");
            paramString1 = paramJsBridgeListener.optString("cb");
            paramString2 = new JSONObject();
            try
            {
              localObject = new JSONArray();
              i2 = paramVarArgs.length();
              i1 = 0;
              while (i1 < i2)
              {
                ((JSONArray)localObject).put(i1, b(paramString3, paramVarArgs.getString(i1)));
                i1 += 1;
              }
              paramString2.put("localFilePaths", localObject);
            }
            catch (Exception paramString3)
            {
              for (;;)
              {
                if (QLog.isColorLevel()) {
                  QLog.e("TroopHWJsPlugin", 2, "isLocalFileExists:", paramString3);
                }
              }
            }
            paramString2 = paramString2.toString();
            callJs(paramString1, new String[] { paramString2 });
            if (QLog.isColorLevel()) {
              QLog.d("TroopHWJsPlugin", 2, "isLocalFileExists:" + paramJsBridgeListener + ", result:" + paramString2);
            }
          }
        }
        else if (("openLocalFilePreview".equals(paramString3)) && (paramJsBridgeListener != null))
        {
          if (QLog.isColorLevel()) {
            QLog.d("TroopHWJsPlugin", 2, "openLocalFilePreview:" + paramJsBridgeListener);
          }
          paramString1 = paramJsBridgeListener.optString("localFilePath");
          paramJsBridgeListener = paramJsBridgeListener.optString("fileDisPlayName");
          this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.d(paramString1, paramJsBridgeListener);
        }
      }
    }
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    super.onActivityResult(paramIntent, paramByte, paramInt);
    switch (paramByte)
    {
    }
    do
    {
      do
      {
        return;
      } while (paramInt != -1);
      if (paramIntent == null) {
        localObject = "";
      }
      for (;;)
      {
        try
        {
          localObject = new JSONObject((String)localObject);
        }
        catch (JSONException localJSONException1)
        {
          localObject = null;
        }
        try
        {
          ((JSONObject)localObject).put("id", this.q);
          if (localObject != null) {
            break;
          }
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(0);
          return;
        }
        catch (JSONException localJSONException2)
        {
          for (;;) {}
        }
        localObject = paramIntent.getStringExtra("jscallback");
        continue;
        localJSONException1.printStackTrace();
      }
      callJs(this.f, new String[] { ((JSONObject)localObject).toString() });
      if (paramIntent == null) {}
      for (paramIntent = "";; paramIntent = paramIntent.getStringExtra("localPath"))
      {
        localObject = new HashMap();
        ((HashMap)localObject).put(Integer.valueOf(this.q), paramIntent);
        this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(this.q), paramIntent);
        this.q += 1;
        ThreadManager.a(new yua(this, 0, (HashMap)localObject), 8, null, false);
        ((HashMap)localObject).clear();
        return;
      }
    } while (paramInt != -1);
    Object localObject = new HashMap();
    if ((paramByte == 2) && (!TextUtils.isEmpty(this.g)))
    {
      ImageUtil.a(this.mRuntime.a(), this.g);
      ((HashMap)localObject).put(Integer.valueOf(this.q), this.g);
      this.q += 1;
    }
    for (;;)
    {
      ThreadManager.a(new ytz(this, (HashMap)localObject), null, false);
      ((HashMap)localObject).clear();
      return;
      if (paramIntent != null) {}
      for (paramIntent = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS"); (paramIntent == null) || (paramIntent.size() == 0); paramIntent = null)
      {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(0);
        return;
      }
      paramIntent = paramIntent.iterator();
      while (paramIntent.hasNext())
      {
        String str = (String)paramIntent.next();
        ((HashMap)localObject).put(Integer.valueOf(this.q), str);
        this.q += 1;
      }
    }
  }
  
  protected void onCreate()
  {
    super.onCreate();
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = TroopMemberApiClient.a();
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a();
    this.jdField_a_of_type_CooperationTroop_homeworkJspTroopHWVoiceController = new TroopHWVoiceController(this.mRuntime.a(), this);
    this.jdField_a_of_type_CooperationTroop_homeworkJspTroopHWFileDownloadManager = new TroopHWFileDownloadManager(this.mRuntime.a());
  }
  
  protected void onDestroy()
  {
    int i2 = 0;
    if (this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient != null) {
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.b();
    }
    super.onDestroy();
    if ("homework".equals(this.j))
    {
      Object localObject1 = new File(e);
      int i1;
      if (((File)localObject1).exists())
      {
        localObject1 = ((File)localObject1).listFiles();
        i1 = 0;
        while (i1 < localObject1.length)
        {
          localObject1[i1].delete();
          i1 += 1;
        }
      }
      localObject1 = new File(AppConstants.bC);
      if (((File)localObject1).exists())
      {
        localObject1 = ((File)localObject1).listFiles();
        i1 = i2;
        while (i1 < localObject1.length)
        {
          localObject1[i1].delete();
          i1 += 1;
        }
      }
      localObject1 = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (String)((Map.Entry)((Iterator)localObject1).next()).getValue();
        if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (((String)localObject2).contains("stream")))
        {
          localObject2 = new File((String)localObject2);
          if (((File)localObject2).exists()) {
            ((File)localObject2).delete();
          }
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\troop_homework\jsp\TroopHWJsPlugin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.tencent.theme;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.AssetManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.DrawableContainer;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Process;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.LongSparseArray;
import android.util.SparseArray;
import android.util.TypedValue;
import android.util.Xml;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.RejectedExecutionException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class SkinEngine
{
  public static final String ACTION_THEME_INVALIDATE = "com.tencent.qplus.THEME_INVALIDATE";
  public static final String ACTION_THEME_UPDATE = "com.tencent.qplus.THEME_UPDATE";
  public static final String ASSET_PATH = "/asset/";
  public static boolean DEBUG = false;
  public static boolean IS_PROBLEM_CM11 = false;
  public static boolean IS_PROBLEM_MIUI = false;
  public static final String KEY_PENDING_THEME = "pending_theme_root";
  public static final String KEY_PENDING_THEME_RESOURCES_IS_COMPLIED = "pending_theme_resources_complied";
  public static final String KEY_RESOURCES_IS_COMPLIED = "complied";
  public static final String KEY_THEME = "theme_root";
  public static final String PREFERENCE_NAME = "theme";
  public static boolean SWITCH_DEBUG = false;
  public static final String TAG = "SkinEngine";
  public static final String TAG_SWITCH = "SkinEngine.switch";
  public static final int TYPE_FILE = 16777215;
  public static final int TYPE_RESOURCES = 3;
  static boolean a;
  static boolean b;
  static final String[][] d;
  static final int[][] e;
  static int f;
  static int g;
  static int h;
  static int i;
  static int j;
  private static SkinEngine m;
  public static Field mComposedIconInfoOfCM;
  public static Integer mIconResourceID;
  public static Field mIconsOfCM;
  public HashMap<Integer, BackupForOOMData> backupForOOMData;
  final TypedValue c = new TypedValue();
  SkinEngineHandler k;
  BroadcastReceiver l = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      if (SkinEngine.SWITCH_DEBUG) {
        Log.d("SkinEngine.switch", "UpdateReceiver.onReceive ACTION_THEME_UPDATE");
      }
      try
      {
        new SkinEngine.a(SkinEngine.this, null).execute(new Context[] { paramAnonymousContext });
        return;
      }
      catch (RejectedExecutionException paramAnonymousContext) {}
    }
  };
  public Resources mResources;
  private boolean n = false;
  private boolean o = true;
  private final LongSparseArray<WeakReference<b>> p = new LongSparseArray();
  private final LongSparseArray<WeakReference<SkinnableColorStateList>> q = new LongSparseArray();
  private final LongSparseArray<WeakReference<b>> r = new LongSparseArray();
  private String s;
  private String t;
  private int u = h;
  private g v;
  private d w;
  private e x;
  private HashMap<String, Object> y;
  private HashMap<String, Object> z;
  
  static
  {
    if (("MNC".equals(Build.VERSION.CODENAME)) || (Build.VERSION.SDK_INT >= 23))
    {
      bool = true;
      a = bool;
      if (Build.VERSION.SDK_INT < 24) {
        break label421;
      }
    }
    label421:
    for (boolean bool = true;; bool = false)
    {
      b = bool;
      IS_PROBLEM_MIUI = false;
      mIconsOfCM = null;
      mComposedIconInfoOfCM = null;
      IS_PROBLEM_CM11 = false;
      mIconResourceID = null;
      Object localObject = { "drawable-ldpi/", "drawable-mdpi/", "drawable-hdpi/", "drawable-xhdpi/", "drawable/" };
      d = new String[][] { { "drawable-xhdpi/", "drawable-hdpi/", "drawable-mdpi/", "drawable/" }, { "drawable-hdpi/", "drawable-xhdpi/", "drawable-mdpi/", "drawable/" }, { "drawable-mdpi/", "drawable/", "drawable-hdpi/", "drawable-xhdpi/" }, localObject, { "drawable-xxhdpi", "drawable-xhdpi/", "drawable-hdpi/", "drawable-mdpi/", "drawable/" } };
      localObject = new int[] { 320, 240, 160, 160 };
      int[] arrayOfInt1 = { 160, 160, 240, 320 };
      int[] arrayOfInt2 = { 120, 160, 240, 320, 160 };
      e = new int[][] { localObject, { 240, 320, 160, 160 }, arrayOfInt1, arrayOfInt2, { 480, 320, 240, 160, 160 } };
      f = 0;
      g = 1;
      h = 2;
      i = 3;
      j = 4;
      return;
      bool = false;
      break;
    }
  }
  
  private static int a(Resources paramResources)
  {
    switch (paramResources.getDisplayMetrics().densityDpi)
    {
    default: 
      return h;
    case 320: 
      return f;
    case 240: 
      return g;
    case 120: 
      return i;
    }
    return j;
  }
  
  private static int a(Bitmap paramBitmap)
  {
    if (Build.VERSION.SDK_INT > 11) {
      return paramBitmap.getByteCount();
    }
    return paramBitmap.getRowBytes() * paramBitmap.getHeight();
  }
  
  private XmlResourceParser a(int paramInt, TypedValue paramTypedValue)
    throws IOException
  {
    this.mResources.getValue(paramInt, paramTypedValue, true);
    if (paramTypedValue.type == 3) {
      return this.mResources.getAssets().openXmlResourceParser(paramTypedValue.assetCookie, paramTypedValue.string.toString());
    }
    throw new Resources.NotFoundException("Resource ID #0x" + Integer.toHexString(paramInt) + " type #0x" + Integer.toHexString(paramTypedValue.type) + " is not valid");
  }
  
  /* Error */
  private b a(int paramInt, Resources paramResources, k paramk)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 180	com/tencent/theme/SkinEngine:c	Landroid/util/TypedValue;
    //   4: astore 9
    //   6: aload 9
    //   8: monitorenter
    //   9: new 294	android/graphics/Rect
    //   12: dup
    //   13: invokespecial 295	android/graphics/Rect:<init>	()V
    //   16: astore 10
    //   18: aload_3
    //   19: getfield 299	com/tencent/theme/k:b	Ljava/lang/String;
    //   22: astore 11
    //   24: aload 11
    //   26: ifnull +497 -> 523
    //   29: aload 11
    //   31: ldc_w 301
    //   34: invokevirtual 305	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   37: istore 15
    //   39: iload 15
    //   41: ifne +482 -> 523
    //   44: aload_0
    //   45: aload_2
    //   46: aload 11
    //   48: invokespecial 308	com/tencent/theme/SkinEngine:b	(Landroid/content/res/Resources;Ljava/lang/String;)Ljava/io/InputStream;
    //   51: astore 6
    //   53: new 310	android/graphics/BitmapFactory$Options
    //   56: dup
    //   57: invokespecial 311	android/graphics/BitmapFactory$Options:<init>	()V
    //   60: astore 12
    //   62: aload 12
    //   64: aload_3
    //   65: getfield 313	com/tencent/theme/k:c	I
    //   68: putfield 316	android/graphics/BitmapFactory$Options:inDensity	I
    //   71: aload_2
    //   72: aconst_null
    //   73: aload 6
    //   75: aload_3
    //   76: getfield 318	com/tencent/theme/k:d	Ljava/lang/String;
    //   79: aload 12
    //   81: aload 10
    //   83: aload_0
    //   84: getfield 184	com/tencent/theme/SkinEngine:o	Z
    //   87: invokestatic 323	com/tencent/theme/i:a	(Landroid/content/res/Resources;Landroid/util/TypedValue;Ljava/io/InputStream;Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;Landroid/graphics/Rect;Z)Lcom/tencent/theme/b;
    //   90: astore 4
    //   92: aload 6
    //   94: invokevirtual 328	java/io/InputStream:close	()V
    //   97: aload 4
    //   99: ifnull +424 -> 523
    //   102: aload 9
    //   104: monitorexit
    //   105: aload 4
    //   107: areturn
    //   108: astore 5
    //   110: ldc 46
    //   112: iconst_1
    //   113: new 265	java/lang/StringBuilder
    //   116: dup
    //   117: invokespecial 266	java/lang/StringBuilder:<init>	()V
    //   120: ldc_w 330
    //   123: invokevirtual 272	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: aload 11
    //   128: invokevirtual 272	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: invokevirtual 283	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   134: aload 5
    //   136: invokestatic 335	com/tencent/theme/j:a	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   139: aload_0
    //   140: getfield 337	com/tencent/theme/SkinEngine:k	Lcom/tencent/theme/SkinEngineHandler;
    //   143: ifnull +1216 -> 1359
    //   146: aload_0
    //   147: getfield 337	com/tencent/theme/SkinEngine:k	Lcom/tencent/theme/SkinEngineHandler;
    //   150: aload 5
    //   152: aload_3
    //   153: getfield 318	com/tencent/theme/k:d	Ljava/lang/String;
    //   156: iconst_1
    //   157: invokeinterface 343 4 0
    //   162: ifeq +1197 -> 1359
    //   165: aload 6
    //   167: invokevirtual 328	java/io/InputStream:close	()V
    //   170: aload_0
    //   171: aload_2
    //   172: aload 11
    //   174: invokespecial 308	com/tencent/theme/SkinEngine:b	(Landroid/content/res/Resources;Ljava/lang/String;)Ljava/io/InputStream;
    //   177: astore 6
    //   179: aload_2
    //   180: aconst_null
    //   181: aload 6
    //   183: aload_3
    //   184: getfield 318	com/tencent/theme/k:d	Ljava/lang/String;
    //   187: aload 12
    //   189: aload 10
    //   191: aload_0
    //   192: getfield 184	com/tencent/theme/SkinEngine:o	Z
    //   195: invokestatic 323	com/tencent/theme/i:a	(Landroid/content/res/Resources;Landroid/util/TypedValue;Ljava/io/InputStream;Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;Landroid/graphics/Rect;Z)Lcom/tencent/theme/b;
    //   198: astore 4
    //   200: goto -108 -> 92
    //   203: astore 4
    //   205: ldc 46
    //   207: iconst_1
    //   208: new 265	java/lang/StringBuilder
    //   211: dup
    //   212: invokespecial 266	java/lang/StringBuilder:<init>	()V
    //   215: ldc_w 345
    //   218: invokevirtual 272	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: aload 11
    //   223: invokevirtual 272	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: invokevirtual 283	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   229: aload 5
    //   231: invokestatic 335	com/tencent/theme/j:a	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   234: aload_0
    //   235: getfield 337	com/tencent/theme/SkinEngine:k	Lcom/tencent/theme/SkinEngineHandler;
    //   238: aload 4
    //   240: aload_3
    //   241: getfield 318	com/tencent/theme/k:d	Ljava/lang/String;
    //   244: iconst_1
    //   245: invokeinterface 348 4 0
    //   250: ifeq +200 -> 450
    //   253: aload 12
    //   255: iconst_1
    //   256: putfield 351	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   259: aload 6
    //   261: invokevirtual 328	java/io/InputStream:close	()V
    //   264: aload_0
    //   265: aload_2
    //   266: aload 11
    //   268: invokespecial 308	com/tencent/theme/SkinEngine:b	(Landroid/content/res/Resources;Ljava/lang/String;)Ljava/io/InputStream;
    //   271: astore 7
    //   273: aload_2
    //   274: aconst_null
    //   275: aload 7
    //   277: aload_3
    //   278: getfield 318	com/tencent/theme/k:d	Ljava/lang/String;
    //   281: aload 12
    //   283: aload 10
    //   285: aload_0
    //   286: getfield 184	com/tencent/theme/SkinEngine:o	Z
    //   289: invokestatic 323	com/tencent/theme/i:a	(Landroid/content/res/Resources;Landroid/util/TypedValue;Ljava/io/InputStream;Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;Landroid/graphics/Rect;Z)Lcom/tencent/theme/b;
    //   292: astore 8
    //   294: aload_0
    //   295: getfield 353	com/tencent/theme/SkinEngine:backupForOOMData	Ljava/util/HashMap;
    //   298: ifnull +1091 -> 1389
    //   301: aload_0
    //   302: getfield 353	com/tencent/theme/SkinEngine:backupForOOMData	Ljava/util/HashMap;
    //   305: iload_1
    //   306: invokestatic 357	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   309: invokevirtual 362	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   312: ifeq +1077 -> 1389
    //   315: aload_0
    //   316: getfield 353	com/tencent/theme/SkinEngine:backupForOOMData	Ljava/util/HashMap;
    //   319: iload_1
    //   320: invokestatic 357	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   323: invokevirtual 366	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   326: ifnull +1063 -> 1389
    //   329: iconst_1
    //   330: istore 13
    //   332: iload 13
    //   334: ifeq +1044 -> 1378
    //   337: aconst_null
    //   338: astore 4
    //   340: aload_0
    //   341: getfield 353	com/tencent/theme/SkinEngine:backupForOOMData	Ljava/util/HashMap;
    //   344: iload_1
    //   345: invokestatic 357	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   348: invokevirtual 366	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   351: checkcast 8	com/tencent/theme/SkinEngine$BackupForOOMData
    //   354: astore 6
    //   356: aload 12
    //   358: getfield 369	android/graphics/BitmapFactory$Options:outWidth	I
    //   361: bipush 8
    //   363: idiv
    //   364: aload 12
    //   366: getfield 372	android/graphics/BitmapFactory$Options:outHeight	I
    //   369: bipush 8
    //   371: idiv
    //   372: invokestatic 378	java/lang/Math:min	(II)I
    //   375: bipush 8
    //   377: invokestatic 381	java/lang/Math:max	(II)I
    //   380: istore 14
    //   382: iconst_2
    //   383: istore 13
    //   385: iload 13
    //   387: iload 14
    //   389: if_icmpgt +29 -> 418
    //   392: aload_0
    //   393: aload_2
    //   394: aload_3
    //   395: aload 12
    //   397: aload 10
    //   399: aload_0
    //   400: getfield 184	com/tencent/theme/SkinEngine:o	Z
    //   403: aload 6
    //   405: iload 13
    //   407: iconst_0
    //   408: invokevirtual 384	com/tencent/theme/SkinEngine:a	(Landroid/content/res/Resources;Lcom/tencent/theme/k;Landroid/graphics/BitmapFactory$Options;Landroid/graphics/Rect;ZLcom/tencent/theme/SkinEngine$BackupForOOMData;IZ)Lcom/tencent/theme/b;
    //   411: astore 4
    //   413: aload 4
    //   415: ifnull +980 -> 1395
    //   418: aload 4
    //   420: astore 5
    //   422: aload 4
    //   424: ifnonnull +941 -> 1365
    //   427: aload_0
    //   428: aload_2
    //   429: aload_3
    //   430: aload 12
    //   432: aload 10
    //   434: aload_0
    //   435: getfield 184	com/tencent/theme/SkinEngine:o	Z
    //   438: aload 6
    //   440: iconst_1
    //   441: iconst_1
    //   442: invokevirtual 384	com/tencent/theme/SkinEngine:a	(Landroid/content/res/Resources;Lcom/tencent/theme/k;Landroid/graphics/BitmapFactory$Options;Landroid/graphics/Rect;ZLcom/tencent/theme/SkinEngine$BackupForOOMData;IZ)Lcom/tencent/theme/b;
    //   445: astore 5
    //   447: goto +918 -> 1365
    //   450: aload 4
    //   452: athrow
    //   453: astore 4
    //   455: getstatic 106	com/tencent/theme/SkinEngine:DEBUG	Z
    //   458: ifeq +36 -> 494
    //   461: ldc 46
    //   463: new 265	java/lang/StringBuilder
    //   466: dup
    //   467: invokespecial 266	java/lang/StringBuilder:<init>	()V
    //   470: ldc_w 386
    //   473: invokevirtual 272	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   476: aload 11
    //   478: invokevirtual 272	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   481: ldc_w 388
    //   484: invokevirtual 272	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   487: invokevirtual 283	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   490: invokestatic 393	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   493: pop
    //   494: ldc 46
    //   496: iconst_1
    //   497: new 265	java/lang/StringBuilder
    //   500: dup
    //   501: invokespecial 266	java/lang/StringBuilder:<init>	()V
    //   504: ldc_w 395
    //   507: invokevirtual 272	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   510: aload 11
    //   512: invokevirtual 272	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   515: invokevirtual 283	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   518: aload 4
    //   520: invokestatic 335	com/tencent/theme/j:a	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   523: aload_3
    //   524: getfield 318	com/tencent/theme/k:d	Ljava/lang/String;
    //   527: ldc_w 301
    //   530: invokevirtual 305	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   533: istore 15
    //   535: iload 15
    //   537: ifeq +218 -> 755
    //   540: aload_0
    //   541: iload_1
    //   542: aload_0
    //   543: getfield 180	com/tencent/theme/SkinEngine:c	Landroid/util/TypedValue;
    //   546: invokespecial 397	com/tencent/theme/SkinEngine:a	(ILandroid/util/TypedValue;)Landroid/content/res/XmlResourceParser;
    //   549: astore 5
    //   551: aload 11
    //   553: ifnull +86 -> 639
    //   556: aload_0
    //   557: getfield 184	com/tencent/theme/SkinEngine:o	Z
    //   560: ifeq +71 -> 631
    //   563: new 399	com/tencent/theme/a
    //   566: dup
    //   567: invokespecial 400	com/tencent/theme/a:<init>	()V
    //   570: astore 4
    //   572: new 402	java/io/FileInputStream
    //   575: dup
    //   576: aload 11
    //   578: invokespecial 403	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   581: astore 6
    //   583: aload 4
    //   585: aload 6
    //   587: ldc_w 405
    //   590: invokeinterface 411 3 0
    //   595: aload_2
    //   596: aload 5
    //   598: aload 4
    //   600: aload_0
    //   601: getfield 184	com/tencent/theme/SkinEngine:o	Z
    //   604: invokestatic 414	com/tencent/theme/i:a	(Landroid/content/res/Resources;Lorg/xmlpull/v1/XmlPullParser;Lorg/xmlpull/v1/XmlPullParser;Z)Lcom/tencent/theme/b;
    //   607: astore_2
    //   608: aload 6
    //   610: invokevirtual 415	java/io/FileInputStream:close	()V
    //   613: aload 5
    //   615: invokeinterface 418 1 0
    //   620: aload 9
    //   622: monitorexit
    //   623: aload_2
    //   624: areturn
    //   625: astore_2
    //   626: aload 9
    //   628: monitorexit
    //   629: aload_2
    //   630: athrow
    //   631: invokestatic 424	android/util/Xml:newPullParser	()Lorg/xmlpull/v1/XmlPullParser;
    //   634: astore 4
    //   636: goto -64 -> 572
    //   639: aload_2
    //   640: aload 5
    //   642: aconst_null
    //   643: aload_0
    //   644: getfield 184	com/tencent/theme/SkinEngine:o	Z
    //   647: invokestatic 414	com/tencent/theme/i:a	(Landroid/content/res/Resources;Lorg/xmlpull/v1/XmlPullParser;Lorg/xmlpull/v1/XmlPullParser;Z)Lcom/tencent/theme/b;
    //   650: astore_2
    //   651: aload 5
    //   653: invokeinterface 418 1 0
    //   658: aload 9
    //   660: monitorexit
    //   661: aload_2
    //   662: areturn
    //   663: astore_2
    //   664: ldc 46
    //   666: iconst_1
    //   667: new 265	java/lang/StringBuilder
    //   670: dup
    //   671: invokespecial 266	java/lang/StringBuilder:<init>	()V
    //   674: ldc_w 426
    //   677: invokevirtual 272	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   680: aload 11
    //   682: invokevirtual 272	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   685: invokevirtual 283	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   688: aload_2
    //   689: invokestatic 335	com/tencent/theme/j:a	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   692: getstatic 106	com/tencent/theme/SkinEngine:DEBUG	Z
    //   695: ifeq +55 -> 750
    //   698: new 263	android/content/res/Resources$NotFoundException
    //   701: dup
    //   702: new 265	java/lang/StringBuilder
    //   705: dup
    //   706: invokespecial 266	java/lang/StringBuilder:<init>	()V
    //   709: ldc_w 428
    //   712: invokevirtual 272	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   715: aload_3
    //   716: getfield 318	com/tencent/theme/k:d	Ljava/lang/String;
    //   719: invokevirtual 272	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   722: ldc_w 430
    //   725: invokevirtual 272	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   728: iload_1
    //   729: invokestatic 278	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   732: invokevirtual 272	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   735: invokevirtual 283	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   738: invokespecial 286	android/content/res/Resources$NotFoundException:<init>	(Ljava/lang/String;)V
    //   741: astore_3
    //   742: aload_3
    //   743: aload_2
    //   744: invokevirtual 434	android/content/res/Resources$NotFoundException:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   747: pop
    //   748: aload_3
    //   749: athrow
    //   750: aload 9
    //   752: monitorexit
    //   753: aconst_null
    //   754: areturn
    //   755: getstatic 136	com/tencent/theme/SkinEngine:IS_PROBLEM_CM11	Z
    //   758: istore 15
    //   760: iload 15
    //   762: ifeq +100 -> 862
    //   765: getstatic 132	com/tencent/theme/SkinEngine:mIconsOfCM	Ljava/lang/reflect/Field;
    //   768: iconst_1
    //   769: invokevirtual 440	java/lang/reflect/Field:setAccessible	(Z)V
    //   772: getstatic 132	com/tencent/theme/SkinEngine:mIconsOfCM	Ljava/lang/reflect/Field;
    //   775: aload_0
    //   776: getfield 231	com/tencent/theme/SkinEngine:mResources	Landroid/content/res/Resources;
    //   779: aconst_null
    //   780: invokevirtual 444	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   783: getstatic 134	com/tencent/theme/SkinEngine:mComposedIconInfoOfCM	Ljava/lang/reflect/Field;
    //   786: iconst_1
    //   787: invokevirtual 440	java/lang/reflect/Field:setAccessible	(Z)V
    //   790: getstatic 134	com/tencent/theme/SkinEngine:mComposedIconInfoOfCM	Ljava/lang/reflect/Field;
    //   793: aload_0
    //   794: getfield 231	com/tencent/theme/SkinEngine:mResources	Landroid/content/res/Resources;
    //   797: aconst_null
    //   798: invokevirtual 444	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   801: getstatic 132	com/tencent/theme/SkinEngine:mIconsOfCM	Ljava/lang/reflect/Field;
    //   804: iconst_1
    //   805: invokevirtual 440	java/lang/reflect/Field:setAccessible	(Z)V
    //   808: getstatic 134	com/tencent/theme/SkinEngine:mComposedIconInfoOfCM	Ljava/lang/reflect/Field;
    //   811: iconst_1
    //   812: invokevirtual 440	java/lang/reflect/Field:setAccessible	(Z)V
    //   815: getstatic 132	com/tencent/theme/SkinEngine:mIconsOfCM	Ljava/lang/reflect/Field;
    //   818: aload_0
    //   819: getfield 231	com/tencent/theme/SkinEngine:mResources	Landroid/content/res/Resources;
    //   822: invokevirtual 445	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   825: ifnull +37 -> 862
    //   828: getstatic 134	com/tencent/theme/SkinEngine:mComposedIconInfoOfCM	Ljava/lang/reflect/Field;
    //   831: aload_0
    //   832: getfield 231	com/tencent/theme/SkinEngine:mResources	Landroid/content/res/Resources;
    //   835: invokevirtual 445	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   838: astore 4
    //   840: aload 4
    //   842: ifnull +20 -> 862
    //   845: aload 9
    //   847: monitorexit
    //   848: aconst_null
    //   849: areturn
    //   850: astore_2
    //   851: aload 9
    //   853: monitorexit
    //   854: aconst_null
    //   855: areturn
    //   856: astore_2
    //   857: aload 9
    //   859: monitorexit
    //   860: aconst_null
    //   861: areturn
    //   862: aload_0
    //   863: getfield 180	com/tencent/theme/SkinEngine:c	Landroid/util/TypedValue;
    //   866: astore 7
    //   868: aload_2
    //   869: iload_1
    //   870: aload 7
    //   872: invokevirtual 449	android/content/res/Resources:openRawResource	(ILandroid/util/TypedValue;)Ljava/io/InputStream;
    //   875: astore 5
    //   877: aload 7
    //   879: getfield 249	android/util/TypedValue:string	Ljava/lang/CharSequence;
    //   882: invokeinterface 255 1 0
    //   887: astore 8
    //   889: aload 5
    //   891: astore 4
    //   893: new 310	android/graphics/BitmapFactory$Options
    //   896: dup
    //   897: invokespecial 311	android/graphics/BitmapFactory$Options:<init>	()V
    //   900: astore 11
    //   902: aload 5
    //   904: astore 4
    //   906: aload_2
    //   907: aload 7
    //   909: aload 5
    //   911: aload 8
    //   913: aload 11
    //   915: aload 10
    //   917: iconst_1
    //   918: invokestatic 323	com/tencent/theme/i:a	(Landroid/content/res/Resources;Landroid/util/TypedValue;Ljava/io/InputStream;Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;Landroid/graphics/Rect;Z)Lcom/tencent/theme/b;
    //   921: astore 6
    //   923: aload 6
    //   925: astore_2
    //   926: aload 5
    //   928: astore 4
    //   930: aload 5
    //   932: invokevirtual 328	java/io/InputStream:close	()V
    //   935: aload_2
    //   936: ifnonnull +33 -> 969
    //   939: aload 5
    //   941: astore 4
    //   943: aload_0
    //   944: getfield 337	com/tencent/theme/SkinEngine:k	Lcom/tencent/theme/SkinEngineHandler;
    //   947: ifnull +22 -> 969
    //   950: aload 5
    //   952: astore 4
    //   954: aload_0
    //   955: getfield 337	com/tencent/theme/SkinEngine:k	Lcom/tencent/theme/SkinEngineHandler;
    //   958: aload_3
    //   959: getfield 318	com/tencent/theme/k:d	Ljava/lang/String;
    //   962: iconst_0
    //   963: invokeinterface 453 3 0
    //   968: pop
    //   969: aload 9
    //   971: monitorexit
    //   972: aload_2
    //   973: areturn
    //   974: astore_2
    //   975: ldc 46
    //   977: iconst_1
    //   978: new 265	java/lang/StringBuilder
    //   981: dup
    //   982: invokespecial 266	java/lang/StringBuilder:<init>	()V
    //   985: ldc_w 455
    //   988: invokevirtual 272	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   991: aload_3
    //   992: getfield 318	com/tencent/theme/k:d	Ljava/lang/String;
    //   995: invokevirtual 272	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   998: invokevirtual 283	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1001: aload_2
    //   1002: invokestatic 335	com/tencent/theme/j:a	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1005: aload 9
    //   1007: monitorexit
    //   1008: aconst_null
    //   1009: areturn
    //   1010: astore 12
    //   1012: aload 5
    //   1014: astore 4
    //   1016: ldc 46
    //   1018: iconst_1
    //   1019: new 265	java/lang/StringBuilder
    //   1022: dup
    //   1023: invokespecial 266	java/lang/StringBuilder:<init>	()V
    //   1026: ldc_w 457
    //   1029: invokevirtual 272	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1032: aload_3
    //   1033: getfield 318	com/tencent/theme/k:d	Ljava/lang/String;
    //   1036: invokevirtual 272	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1039: invokevirtual 283	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1042: aload 12
    //   1044: invokestatic 335	com/tencent/theme/j:a	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1047: aload 5
    //   1049: astore 4
    //   1051: aload_0
    //   1052: getfield 337	com/tencent/theme/SkinEngine:k	Lcom/tencent/theme/SkinEngineHandler;
    //   1055: ifnull +299 -> 1354
    //   1058: aload 5
    //   1060: astore 4
    //   1062: aload_0
    //   1063: getfield 337	com/tencent/theme/SkinEngine:k	Lcom/tencent/theme/SkinEngineHandler;
    //   1066: aload 12
    //   1068: aload_3
    //   1069: getfield 318	com/tencent/theme/k:d	Ljava/lang/String;
    //   1072: iconst_0
    //   1073: invokeinterface 343 4 0
    //   1078: ifeq +276 -> 1354
    //   1081: aload 5
    //   1083: astore 4
    //   1085: aload 5
    //   1087: invokevirtual 328	java/io/InputStream:close	()V
    //   1090: aload 5
    //   1092: astore 4
    //   1094: aload_2
    //   1095: iload_1
    //   1096: aload 7
    //   1098: invokevirtual 449	android/content/res/Resources:openRawResource	(ILandroid/util/TypedValue;)Ljava/io/InputStream;
    //   1101: astore 5
    //   1103: aload 5
    //   1105: astore 4
    //   1107: aload_2
    //   1108: aload 7
    //   1110: aload 5
    //   1112: aload 8
    //   1114: aload 11
    //   1116: aload 10
    //   1118: iconst_1
    //   1119: invokestatic 323	com/tencent/theme/i:a	(Landroid/content/res/Resources;Landroid/util/TypedValue;Ljava/io/InputStream;Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;Landroid/graphics/Rect;Z)Lcom/tencent/theme/b;
    //   1122: astore 6
    //   1124: aload 6
    //   1126: astore_2
    //   1127: goto -201 -> 926
    //   1130: astore 6
    //   1132: aload 5
    //   1134: astore 4
    //   1136: ldc 46
    //   1138: iconst_1
    //   1139: new 265	java/lang/StringBuilder
    //   1142: dup
    //   1143: invokespecial 266	java/lang/StringBuilder:<init>	()V
    //   1146: ldc_w 457
    //   1149: invokevirtual 272	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1152: aload_3
    //   1153: getfield 318	com/tencent/theme/k:d	Ljava/lang/String;
    //   1156: invokevirtual 272	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1159: invokevirtual 283	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1162: aload 12
    //   1164: invokestatic 335	com/tencent/theme/j:a	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1167: aload 5
    //   1169: astore 4
    //   1171: aload_0
    //   1172: getfield 337	com/tencent/theme/SkinEngine:k	Lcom/tencent/theme/SkinEngineHandler;
    //   1175: aload 6
    //   1177: aload_3
    //   1178: getfield 318	com/tencent/theme/k:d	Ljava/lang/String;
    //   1181: iconst_0
    //   1182: invokeinterface 348 4 0
    //   1187: ifeq +49 -> 1236
    //   1190: aload 5
    //   1192: astore 4
    //   1194: aload 11
    //   1196: iconst_1
    //   1197: putfield 351	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   1200: aload 5
    //   1202: astore 4
    //   1204: aload_2
    //   1205: iload_1
    //   1206: aload 7
    //   1208: invokevirtual 449	android/content/res/Resources:openRawResource	(ILandroid/util/TypedValue;)Ljava/io/InputStream;
    //   1211: astore 5
    //   1213: aload 5
    //   1215: astore 4
    //   1217: aload_2
    //   1218: aload 7
    //   1220: aload 5
    //   1222: aload 8
    //   1224: aload 11
    //   1226: aload 10
    //   1228: iconst_1
    //   1229: invokestatic 323	com/tencent/theme/i:a	(Landroid/content/res/Resources;Landroid/util/TypedValue;Ljava/io/InputStream;Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;Landroid/graphics/Rect;Z)Lcom/tencent/theme/b;
    //   1232: astore_2
    //   1233: goto -307 -> 926
    //   1236: aload 5
    //   1238: astore 4
    //   1240: aload 6
    //   1242: athrow
    //   1243: astore_2
    //   1244: ldc 46
    //   1246: iconst_1
    //   1247: new 265	java/lang/StringBuilder
    //   1250: dup
    //   1251: invokespecial 266	java/lang/StringBuilder:<init>	()V
    //   1254: ldc_w 459
    //   1257: invokevirtual 272	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1260: aload_3
    //   1261: getfield 318	com/tencent/theme/k:d	Ljava/lang/String;
    //   1264: invokevirtual 272	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1267: invokevirtual 283	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1270: aload_2
    //   1271: invokestatic 335	com/tencent/theme/j:a	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1274: getstatic 106	com/tencent/theme/SkinEngine:DEBUG	Z
    //   1277: ifeq +72 -> 1349
    //   1280: new 263	android/content/res/Resources$NotFoundException
    //   1283: dup
    //   1284: new 265	java/lang/StringBuilder
    //   1287: dup
    //   1288: invokespecial 266	java/lang/StringBuilder:<init>	()V
    //   1291: ldc_w 428
    //   1294: invokevirtual 272	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1297: aload_3
    //   1298: getfield 318	com/tencent/theme/k:d	Ljava/lang/String;
    //   1301: invokevirtual 272	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1304: ldc_w 430
    //   1307: invokevirtual 272	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1310: iload_1
    //   1311: invokestatic 278	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   1314: invokevirtual 272	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1317: ldc_w 461
    //   1320: invokevirtual 272	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1323: aload 4
    //   1325: invokevirtual 465	java/lang/Object:getClass	()Ljava/lang/Class;
    //   1328: invokevirtual 470	java/lang/Class:getName	()Ljava/lang/String;
    //   1331: invokevirtual 272	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1334: invokevirtual 283	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1337: invokespecial 286	android/content/res/Resources$NotFoundException:<init>	(Ljava/lang/String;)V
    //   1340: astore_3
    //   1341: aload_3
    //   1342: aload_2
    //   1343: invokevirtual 434	android/content/res/Resources$NotFoundException:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   1346: pop
    //   1347: aload_3
    //   1348: athrow
    //   1349: aload 9
    //   1351: monitorexit
    //   1352: aconst_null
    //   1353: areturn
    //   1354: aconst_null
    //   1355: astore_2
    //   1356: goto -430 -> 926
    //   1359: aconst_null
    //   1360: astore 4
    //   1362: goto -1270 -> 92
    //   1365: aload 5
    //   1367: astore 4
    //   1369: aload 7
    //   1371: astore 6
    //   1373: aload 5
    //   1375: ifnonnull -1283 -> 92
    //   1378: aload 8
    //   1380: astore 4
    //   1382: aload 7
    //   1384: astore 6
    //   1386: goto -1294 -> 92
    //   1389: iconst_0
    //   1390: istore 13
    //   1392: goto -1060 -> 332
    //   1395: iload 13
    //   1397: iconst_2
    //   1398: imul
    //   1399: istore 13
    //   1401: goto -1016 -> 385
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1404	0	this	SkinEngine
    //   0	1404	1	paramInt	int
    //   0	1404	2	paramResources	Resources
    //   0	1404	3	paramk	k
    //   90	109	4	localb1	b
    //   203	36	4	localOutOfMemoryError1	OutOfMemoryError
    //   338	113	4	localb2	b
    //   453	66	4	localIOException	IOException
    //   570	811	4	localObject1	Object
    //   108	122	5	localOutOfMemoryError2	OutOfMemoryError
    //   420	954	5	localObject2	Object
    //   51	1074	6	localObject3	Object
    //   1130	111	6	localOutOfMemoryError3	OutOfMemoryError
    //   1371	14	6	localObject4	Object
    //   271	1112	7	localObject5	Object
    //   292	1087	8	localObject6	Object
    //   4	1346	9	localTypedValue	TypedValue
    //   16	1211	10	localRect	Rect
    //   22	1203	11	localObject7	Object
    //   60	371	12	localOptions	android.graphics.BitmapFactory.Options
    //   1010	153	12	localOutOfMemoryError4	OutOfMemoryError
    //   330	1070	13	i1	int
    //   380	10	14	i2	int
    //   37	724	15	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   71	92	108	java/lang/OutOfMemoryError
    //   179	200	203	java/lang/OutOfMemoryError
    //   44	71	453	java/io/IOException
    //   71	92	453	java/io/IOException
    //   92	97	453	java/io/IOException
    //   110	179	453	java/io/IOException
    //   179	200	453	java/io/IOException
    //   205	329	453	java/io/IOException
    //   340	382	453	java/io/IOException
    //   392	413	453	java/io/IOException
    //   427	447	453	java/io/IOException
    //   450	453	453	java/io/IOException
    //   9	24	625	finally
    //   29	39	625	finally
    //   44	71	625	finally
    //   71	92	625	finally
    //   92	97	625	finally
    //   102	105	625	finally
    //   110	179	625	finally
    //   179	200	625	finally
    //   205	329	625	finally
    //   340	382	625	finally
    //   392	413	625	finally
    //   427	447	625	finally
    //   450	453	625	finally
    //   455	494	625	finally
    //   494	523	625	finally
    //   523	535	625	finally
    //   540	551	625	finally
    //   556	572	625	finally
    //   572	620	625	finally
    //   620	623	625	finally
    //   626	629	625	finally
    //   631	636	625	finally
    //   639	658	625	finally
    //   658	661	625	finally
    //   664	750	625	finally
    //   750	753	625	finally
    //   755	760	625	finally
    //   765	801	625	finally
    //   801	840	625	finally
    //   845	848	625	finally
    //   851	854	625	finally
    //   857	860	625	finally
    //   862	868	625	finally
    //   868	877	625	finally
    //   877	889	625	finally
    //   893	902	625	finally
    //   906	923	625	finally
    //   930	935	625	finally
    //   943	950	625	finally
    //   954	969	625	finally
    //   969	972	625	finally
    //   975	1008	625	finally
    //   1016	1047	625	finally
    //   1051	1058	625	finally
    //   1062	1081	625	finally
    //   1085	1090	625	finally
    //   1094	1103	625	finally
    //   1107	1124	625	finally
    //   1136	1167	625	finally
    //   1171	1190	625	finally
    //   1194	1200	625	finally
    //   1204	1213	625	finally
    //   1217	1233	625	finally
    //   1240	1243	625	finally
    //   1244	1349	625	finally
    //   1349	1352	625	finally
    //   540	551	663	java/lang/Exception
    //   556	572	663	java/lang/Exception
    //   572	620	663	java/lang/Exception
    //   631	636	663	java/lang/Exception
    //   639	658	663	java/lang/Exception
    //   765	801	850	java/lang/Exception
    //   801	840	856	java/lang/Exception
    //   868	877	974	java/lang/Exception
    //   906	923	1010	java/lang/OutOfMemoryError
    //   1107	1124	1130	java/lang/OutOfMemoryError
    //   893	902	1243	java/io/IOException
    //   906	923	1243	java/io/IOException
    //   930	935	1243	java/io/IOException
    //   943	950	1243	java/io/IOException
    //   954	969	1243	java/io/IOException
    //   1016	1047	1243	java/io/IOException
    //   1051	1058	1243	java/io/IOException
    //   1062	1081	1243	java/io/IOException
    //   1085	1090	1243	java/io/IOException
    //   1094	1103	1243	java/io/IOException
    //   1107	1124	1243	java/io/IOException
    //   1136	1167	1243	java/io/IOException
    //   1171	1190	1243	java/io/IOException
    //   1194	1200	1243	java/io/IOException
    //   1204	1213	1243	java/io/IOException
    //   1217	1233	1243	java/io/IOException
    //   1240	1243	1243	java/io/IOException
  }
  
  private String a(Resources paramResources, String paramString)
  {
    paramString = this.s + "color/" + paramString;
    try
    {
      if (paramString.startsWith("/asset/"))
      {
        paramResources.getAssets().open(paramString.substring("/asset/".length())).close();
        return paramString;
      }
      boolean bool = new File(paramString).exists();
      if (bool) {
        return paramString;
      }
    }
    catch (IOException paramResources)
    {
      for (;;)
      {
        if (DEBUG) {
          Log.w("SkinEngine", paramResources);
        }
      }
    }
    return null;
    return paramString;
  }
  
  private HashMap<String, Object> a(XmlPullParser paramXmlPullParser)
    throws XmlPullParserException, IOException
  {
    int i1;
    do
    {
      i1 = paramXmlPullParser.next();
    } while ((i1 != 2) && (i1 != 1));
    if (i1 != 2) {
      throw new XmlPullParserException("No start tag found");
    }
    String str1 = paramXmlPullParser.getName();
    HashMap localHashMap = new HashMap();
    if (str1.equals("resources"))
    {
      i1 = paramXmlPullParser.getDepth();
      for (;;)
      {
        int i2 = paramXmlPullParser.next();
        if ((i2 == 1) || ((paramXmlPullParser.getDepth() < i1 + 1) && (i2 == 3))) {
          break;
        }
        if (i2 == 2)
        {
          String str2 = paramXmlPullParser.getName();
          str1 = paramXmlPullParser.getAttributeValue(null, "name");
          if ("color".equals(str2))
          {
            localHashMap.put(str1, Integer.valueOf(Color.parseColor(paramXmlPullParser.nextText())));
          }
          else if ("dimen".equals(str2))
          {
            str2 = paramXmlPullParser.nextText();
            if (str2.endsWith("dp")) {
              localHashMap.put(str1, Float.valueOf(TypedValue.applyDimension(1, Integer.parseInt(str2.substring(0, str2.length() - 2)), this.mResources.getDisplayMetrics())));
            } else if (str2.endsWith("dip")) {
              localHashMap.put(str1, Float.valueOf(TypedValue.applyDimension(1, Integer.parseInt(str2.substring(0, str2.length() - 3)), this.mResources.getDisplayMetrics())));
            } else if (str2.endsWith("sp")) {
              localHashMap.put(str1, Float.valueOf(TypedValue.applyDimension(2, Integer.parseInt(str2.substring(0, str2.length() - 2)), this.mResources.getDisplayMetrics())));
            } else if (str2.endsWith("px")) {
              localHashMap.put(str1, Float.valueOf(TypedValue.applyDimension(0, Integer.parseInt(str2.substring(0, str2.length() - 2)), this.mResources.getDisplayMetrics())));
            }
          }
          else if ("bool".equals(str2))
          {
            localHashMap.put(str1, Boolean.valueOf("true".equalsIgnoreCase(paramXmlPullParser.nextText())));
          }
          else if ("integer".equals(str2))
          {
            localHashMap.put(str1, Integer.valueOf(Integer.parseInt(paramXmlPullParser.nextText())));
          }
        }
      }
    }
    return localHashMap;
  }
  
  private void a(Resources paramResources, TypedValue paramTypedValue, String paramString, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    int i1 = 0;
    while (i1 < paramArrayOfInt.length) {
      try
      {
        String str = this.s + paramArrayOfString[i1] + paramString;
        if (str.startsWith("/asset/"))
        {
          paramResources.getAssets().open(str.substring("/asset/".length())).close();
          paramTypedValue.string = str;
          paramTypedValue.density = paramArrayOfInt[i1];
          return;
        }
        if (new File(str).exists())
        {
          paramTypedValue.string = str;
          paramTypedValue.density = paramArrayOfInt[i1];
          return;
        }
      }
      catch (IOException localIOException)
      {
        if (DEBUG) {
          Log.w("SkinEngine", localIOException);
        }
        i1 += 1;
      }
    }
    paramTypedValue.string = null;
    paramTypedValue.density = 0;
  }
  
  /* Error */
  private void a(Resources paramResources, Class paramClass1, int[] paramArrayOfInt, int paramInt1, Class paramClass2, int paramInt2, File paramFile)
    throws UnSupportPlatformException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 9
    //   3: aload_3
    //   4: ifnonnull +20 -> 24
    //   7: aload 9
    //   9: astore 8
    //   11: aload_2
    //   12: ifnull +140 -> 152
    //   15: aload 9
    //   17: astore 8
    //   19: iload 4
    //   21: ifeq +131 -> 152
    //   24: getstatic 128	com/tencent/theme/SkinEngine:b	Z
    //   27: ifeq +470 -> 497
    //   30: ldc -52
    //   32: ldc_w 596
    //   35: invokevirtual 600	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   38: astore 8
    //   40: aload 8
    //   42: iconst_1
    //   43: invokevirtual 440	java/lang/reflect/Field:setAccessible	(Z)V
    //   46: aload 8
    //   48: aload_1
    //   49: invokevirtual 445	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   52: astore 8
    //   54: aload 8
    //   56: invokevirtual 465	java/lang/Object:getClass	()Ljava/lang/Class;
    //   59: ldc_w 602
    //   62: invokevirtual 600	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   65: astore 10
    //   67: aload 10
    //   69: iconst_1
    //   70: invokevirtual 440	java/lang/reflect/Field:setAccessible	(Z)V
    //   73: aload 10
    //   75: aload 8
    //   77: invokevirtual 445	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   80: astore 9
    //   82: aload 9
    //   84: instanceof 193
    //   87: ifeq +504 -> 591
    //   90: aload_3
    //   91: ifnull +436 -> 527
    //   94: aload_0
    //   95: new 604	com/tencent/theme/g
    //   98: dup
    //   99: aload_0
    //   100: aload_1
    //   101: aload_3
    //   102: aload 7
    //   104: iconst_1
    //   105: anewarray 193	android/util/LongSparseArray
    //   108: dup
    //   109: iconst_0
    //   110: aload 9
    //   112: checkcast 193	android/util/LongSparseArray
    //   115: aastore
    //   116: invokespecial 607	com/tencent/theme/g:<init>	(Lcom/tencent/theme/SkinEngine;Landroid/content/res/Resources;[ILjava/io/File;[Landroid/util/LongSparseArray;)V
    //   119: putfield 609	com/tencent/theme/SkinEngine:v	Lcom/tencent/theme/g;
    //   122: getstatic 128	com/tencent/theme/SkinEngine:b	Z
    //   125: ifeq +445 -> 570
    //   128: aload 8
    //   130: ifnull +440 -> 570
    //   133: aload 10
    //   135: aload 8
    //   137: new 611	com/tencent/theme/h
    //   140: dup
    //   141: iconst_0
    //   142: aload_0
    //   143: getfield 609	com/tencent/theme/SkinEngine:v	Lcom/tencent/theme/g;
    //   146: invokespecial 614	com/tencent/theme/h:<init>	(ILcom/tencent/theme/g;)V
    //   149: invokevirtual 444	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   152: getstatic 124	android/os/Build$VERSION:SDK_INT	I
    //   155: bipush 23
    //   157: if_icmplt +76 -> 233
    //   160: ldc_w 616
    //   163: getstatic 621	android/os/Build:BRAND	Ljava/lang/String;
    //   166: invokevirtual 570	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   169: istore 11
    //   171: iload 11
    //   173: ifeq +60 -> 233
    //   176: ldc -52
    //   178: ldc_w 623
    //   181: invokevirtual 600	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   184: astore_2
    //   185: aload_2
    //   186: ifnull +570 -> 756
    //   189: aload_2
    //   190: iconst_1
    //   191: invokevirtual 440	java/lang/reflect/Field:setAccessible	(Z)V
    //   194: aload_2
    //   195: aload_0
    //   196: getfield 231	com/tencent/theme/SkinEngine:mResources	Landroid/content/res/Resources;
    //   199: invokevirtual 445	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   202: astore_2
    //   203: aload_2
    //   204: ifnull +498 -> 702
    //   207: aload_2
    //   208: instanceof 625
    //   211: ifeq +491 -> 702
    //   214: aload_2
    //   215: checkcast 625	java/util/Map
    //   218: invokeinterface 628 1 0
    //   223: ldc 46
    //   225: iconst_2
    //   226: ldc_w 630
    //   229: aconst_null
    //   230: invokestatic 632	com/tencent/theme/j:c	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   233: ldc 46
    //   235: iconst_2
    //   236: ldc_w 634
    //   239: aconst_null
    //   240: invokestatic 632	com/tencent/theme/j:c	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   243: aload 5
    //   245: ifnull +112 -> 357
    //   248: iload 6
    //   250: ifeq +107 -> 357
    //   253: getstatic 128	com/tencent/theme/SkinEngine:b	Z
    //   256: ifeq +513 -> 769
    //   259: ldc -52
    //   261: ldc_w 596
    //   264: invokevirtual 600	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   267: astore_2
    //   268: aload_2
    //   269: iconst_1
    //   270: invokevirtual 440	java/lang/reflect/Field:setAccessible	(Z)V
    //   273: aload_2
    //   274: aload_1
    //   275: invokevirtual 445	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   278: astore_2
    //   279: aload_2
    //   280: invokevirtual 465	java/lang/Object:getClass	()Ljava/lang/Class;
    //   283: ldc_w 636
    //   286: invokevirtual 600	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   289: astore 7
    //   291: aload 7
    //   293: iconst_1
    //   294: invokevirtual 440	java/lang/reflect/Field:setAccessible	(Z)V
    //   297: aload 7
    //   299: aload_2
    //   300: invokevirtual 445	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   303: checkcast 193	android/util/LongSparseArray
    //   306: astore 8
    //   308: aload_2
    //   309: astore_3
    //   310: aload 8
    //   312: astore_2
    //   313: getstatic 126	com/tencent/theme/SkinEngine:a	Z
    //   316: ifeq +485 -> 801
    //   319: aload_0
    //   320: new 638	com/tencent/theme/f
    //   323: dup
    //   324: aload_0
    //   325: aload_1
    //   326: aload_2
    //   327: aload 5
    //   329: iload 6
    //   331: invokespecial 641	com/tencent/theme/f:<init>	(Lcom/tencent/theme/SkinEngine;Landroid/content/res/Resources;Landroid/util/LongSparseArray;Ljava/lang/Class;I)V
    //   334: putfield 643	com/tencent/theme/SkinEngine:w	Lcom/tencent/theme/d;
    //   337: getstatic 128	com/tencent/theme/SkinEngine:b	Z
    //   340: ifeq +546 -> 886
    //   343: aload_3
    //   344: ifnull +542 -> 886
    //   347: aload 7
    //   349: aload_3
    //   350: aload_0
    //   351: getfield 643	com/tencent/theme/SkinEngine:w	Lcom/tencent/theme/d;
    //   354: invokevirtual 444	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   357: ldc 46
    //   359: iconst_2
    //   360: ldc_w 645
    //   363: aconst_null
    //   364: invokestatic 632	com/tencent/theme/j:c	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   367: aload_1
    //   368: invokevirtual 465	java/lang/Object:getClass	()Ljava/lang/Class;
    //   371: astore_2
    //   372: aload_2
    //   373: invokevirtual 470	java/lang/Class:getName	()Ljava/lang/String;
    //   376: ldc_w 647
    //   379: invokevirtual 121	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   382: ifeq +40 -> 422
    //   385: aload_2
    //   386: ldc_w 649
    //   389: invokevirtual 600	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   392: astore_2
    //   393: aload_2
    //   394: iconst_1
    //   395: invokevirtual 440	java/lang/reflect/Field:setAccessible	(Z)V
    //   398: aload_2
    //   399: aload_1
    //   400: invokevirtual 445	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   403: ifnonnull +19 -> 422
    //   406: aload_2
    //   407: aload_1
    //   408: new 651	android/util/SparseArray
    //   411: dup
    //   412: invokespecial 652	android/util/SparseArray:<init>	()V
    //   415: invokevirtual 444	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   418: iconst_1
    //   419: putstatic 130	com/tencent/theme/SkinEngine:IS_PROBLEM_MIUI	Z
    //   422: aload_1
    //   423: invokevirtual 465	java/lang/Object:getClass	()Ljava/lang/Class;
    //   426: ldc_w 654
    //   429: invokevirtual 600	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   432: putstatic 132	com/tencent/theme/SkinEngine:mIconsOfCM	Ljava/lang/reflect/Field;
    //   435: getstatic 132	com/tencent/theme/SkinEngine:mIconsOfCM	Ljava/lang/reflect/Field;
    //   438: iconst_1
    //   439: invokevirtual 440	java/lang/reflect/Field:setAccessible	(Z)V
    //   442: getstatic 132	com/tencent/theme/SkinEngine:mIconsOfCM	Ljava/lang/reflect/Field;
    //   445: aload_1
    //   446: aconst_null
    //   447: invokevirtual 444	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   450: getstatic 132	com/tencent/theme/SkinEngine:mIconsOfCM	Ljava/lang/reflect/Field;
    //   453: iconst_0
    //   454: invokevirtual 440	java/lang/reflect/Field:setAccessible	(Z)V
    //   457: aload_1
    //   458: invokevirtual 465	java/lang/Object:getClass	()Ljava/lang/Class;
    //   461: ldc_w 656
    //   464: invokevirtual 600	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   467: putstatic 134	com/tencent/theme/SkinEngine:mComposedIconInfoOfCM	Ljava/lang/reflect/Field;
    //   470: getstatic 134	com/tencent/theme/SkinEngine:mComposedIconInfoOfCM	Ljava/lang/reflect/Field;
    //   473: iconst_1
    //   474: invokevirtual 440	java/lang/reflect/Field:setAccessible	(Z)V
    //   477: getstatic 134	com/tencent/theme/SkinEngine:mComposedIconInfoOfCM	Ljava/lang/reflect/Field;
    //   480: aload_1
    //   481: aconst_null
    //   482: invokevirtual 444	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   485: getstatic 134	com/tencent/theme/SkinEngine:mComposedIconInfoOfCM	Ljava/lang/reflect/Field;
    //   488: iconst_0
    //   489: invokevirtual 440	java/lang/reflect/Field:setAccessible	(Z)V
    //   492: iconst_1
    //   493: putstatic 136	com/tencent/theme/SkinEngine:IS_PROBLEM_CM11	Z
    //   496: return
    //   497: ldc -52
    //   499: ldc_w 602
    //   502: invokevirtual 600	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   505: astore 10
    //   507: aload 10
    //   509: iconst_1
    //   510: invokevirtual 440	java/lang/reflect/Field:setAccessible	(Z)V
    //   513: aload 10
    //   515: aload_1
    //   516: invokevirtual 445	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   519: astore 9
    //   521: aconst_null
    //   522: astore 8
    //   524: goto -442 -> 82
    //   527: aload_0
    //   528: new 604	com/tencent/theme/g
    //   531: dup
    //   532: aload_0
    //   533: aload_1
    //   534: aload_2
    //   535: iload 4
    //   537: aload 7
    //   539: iconst_1
    //   540: anewarray 193	android/util/LongSparseArray
    //   543: dup
    //   544: iconst_0
    //   545: aload 9
    //   547: checkcast 193	android/util/LongSparseArray
    //   550: aastore
    //   551: invokespecial 659	com/tencent/theme/g:<init>	(Lcom/tencent/theme/SkinEngine;Landroid/content/res/Resources;Ljava/lang/Class;ILjava/io/File;[Landroid/util/LongSparseArray;)V
    //   554: putfield 609	com/tencent/theme/SkinEngine:v	Lcom/tencent/theme/g;
    //   557: goto -435 -> 122
    //   560: astore_1
    //   561: new 586	com/tencent/theme/UnSupportPlatformException
    //   564: dup
    //   565: aload_1
    //   566: invokespecial 662	com/tencent/theme/UnSupportPlatformException:<init>	(Ljava/lang/Throwable;)V
    //   569: athrow
    //   570: aload 10
    //   572: aload_1
    //   573: new 611	com/tencent/theme/h
    //   576: dup
    //   577: iconst_0
    //   578: aload_0
    //   579: getfield 609	com/tencent/theme/SkinEngine:v	Lcom/tencent/theme/g;
    //   582: invokespecial 614	com/tencent/theme/h:<init>	(ILcom/tencent/theme/g;)V
    //   585: invokevirtual 444	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   588: goto -436 -> 152
    //   591: aload 9
    //   593: instanceof 664
    //   596: ifeq +388 -> 984
    //   599: aload 9
    //   601: checkcast 664	[Landroid/util/LongSparseArray;
    //   604: checkcast 664	[Landroid/util/LongSparseArray;
    //   607: astore 9
    //   609: aload_3
    //   610: ifnull +59 -> 669
    //   613: aload_0
    //   614: new 604	com/tencent/theme/g
    //   617: dup
    //   618: aload_0
    //   619: aload_1
    //   620: aload_3
    //   621: aload 7
    //   623: aload 9
    //   625: invokespecial 607	com/tencent/theme/g:<init>	(Lcom/tencent/theme/SkinEngine;Landroid/content/res/Resources;[ILjava/io/File;[Landroid/util/LongSparseArray;)V
    //   628: putfield 609	com/tencent/theme/SkinEngine:v	Lcom/tencent/theme/g;
    //   631: goto +356 -> 987
    //   634: iload 4
    //   636: aload 9
    //   638: arraylength
    //   639: if_icmpge +345 -> 984
    //   642: aload 9
    //   644: iload 4
    //   646: new 611	com/tencent/theme/h
    //   649: dup
    //   650: iload 4
    //   652: aload_0
    //   653: getfield 609	com/tencent/theme/SkinEngine:v	Lcom/tencent/theme/g;
    //   656: invokespecial 614	com/tencent/theme/h:<init>	(ILcom/tencent/theme/g;)V
    //   659: aastore
    //   660: iload 4
    //   662: iconst_1
    //   663: iadd
    //   664: istore 4
    //   666: goto -32 -> 634
    //   669: aload_0
    //   670: new 604	com/tencent/theme/g
    //   673: dup
    //   674: aload_0
    //   675: aload_1
    //   676: aload_2
    //   677: iload 4
    //   679: aload 7
    //   681: aload 9
    //   683: invokespecial 659	com/tencent/theme/g:<init>	(Lcom/tencent/theme/SkinEngine;Landroid/content/res/Resources;Ljava/lang/Class;ILjava/io/File;[Landroid/util/LongSparseArray;)V
    //   686: putfield 609	com/tencent/theme/SkinEngine:v	Lcom/tencent/theme/g;
    //   689: goto +298 -> 987
    //   692: astore_1
    //   693: new 586	com/tencent/theme/UnSupportPlatformException
    //   696: dup
    //   697: aload_1
    //   698: invokespecial 662	com/tencent/theme/UnSupportPlatformException:<init>	(Ljava/lang/Throwable;)V
    //   701: athrow
    //   702: ldc 46
    //   704: iconst_1
    //   705: new 265	java/lang/StringBuilder
    //   708: dup
    //   709: invokespecial 266	java/lang/StringBuilder:<init>	()V
    //   712: ldc_w 666
    //   715: invokevirtual 272	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   718: aload_2
    //   719: invokevirtual 669	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   722: invokevirtual 283	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   725: aconst_null
    //   726: invokestatic 632	com/tencent/theme/j:c	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   729: goto -496 -> 233
    //   732: astore_2
    //   733: ldc 46
    //   735: iconst_1
    //   736: ldc_w 671
    //   739: aload_2
    //   740: invokestatic 335	com/tencent/theme/j:a	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   743: goto -510 -> 233
    //   746: astore_1
    //   747: new 586	com/tencent/theme/UnSupportPlatformException
    //   750: dup
    //   751: aload_1
    //   752: invokespecial 662	com/tencent/theme/UnSupportPlatformException:<init>	(Ljava/lang/Throwable;)V
    //   755: athrow
    //   756: ldc 46
    //   758: iconst_1
    //   759: ldc_w 673
    //   762: aconst_null
    //   763: invokestatic 632	com/tencent/theme/j:c	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   766: goto -533 -> 233
    //   769: ldc -52
    //   771: ldc_w 675
    //   774: invokevirtual 600	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   777: astore 7
    //   779: aload 7
    //   781: iconst_1
    //   782: invokevirtual 440	java/lang/reflect/Field:setAccessible	(Z)V
    //   785: aload 7
    //   787: aload_1
    //   788: invokevirtual 445	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   791: checkcast 193	android/util/LongSparseArray
    //   794: astore_2
    //   795: aload 8
    //   797: astore_3
    //   798: goto -485 -> 313
    //   801: aload_0
    //   802: new 677	com/tencent/theme/d
    //   805: dup
    //   806: aload_0
    //   807: aload_1
    //   808: aload_2
    //   809: aload 5
    //   811: iload 6
    //   813: invokespecial 678	com/tencent/theme/d:<init>	(Lcom/tencent/theme/SkinEngine;Landroid/content/res/Resources;Landroid/util/LongSparseArray;Ljava/lang/Class;I)V
    //   816: putfield 643	com/tencent/theme/SkinEngine:w	Lcom/tencent/theme/d;
    //   819: goto -482 -> 337
    //   822: astore_2
    //   823: ldc -52
    //   825: ldc_w 680
    //   828: invokevirtual 600	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   831: astore_3
    //   832: aload_3
    //   833: iconst_1
    //   834: invokevirtual 440	java/lang/reflect/Field:setAccessible	(Z)V
    //   837: aload_3
    //   838: aload_1
    //   839: invokevirtual 445	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   842: astore 7
    //   844: aload 7
    //   846: instanceof 651
    //   849: ifeq +50 -> 899
    //   852: aload_0
    //   853: new 682	com/tencent/theme/e
    //   856: dup
    //   857: aload_0
    //   858: aload_1
    //   859: aload 7
    //   861: checkcast 651	android/util/SparseArray
    //   864: aload 5
    //   866: iload 6
    //   868: invokespecial 685	com/tencent/theme/e:<init>	(Lcom/tencent/theme/SkinEngine;Landroid/content/res/Resources;Landroid/util/SparseArray;Ljava/lang/Class;I)V
    //   871: putfield 687	com/tencent/theme/SkinEngine:x	Lcom/tencent/theme/e;
    //   874: aload_3
    //   875: aload_1
    //   876: aload_0
    //   877: getfield 687	com/tencent/theme/SkinEngine:x	Lcom/tencent/theme/e;
    //   880: invokevirtual 444	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   883: goto -526 -> 357
    //   886: aload 7
    //   888: aload_1
    //   889: aload_0
    //   890: getfield 643	com/tencent/theme/SkinEngine:w	Lcom/tencent/theme/d;
    //   893: invokevirtual 444	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   896: goto -539 -> 357
    //   899: aload 7
    //   901: instanceof 193
    //   904: ifeq +37 -> 941
    //   907: aload_0
    //   908: new 677	com/tencent/theme/d
    //   911: dup
    //   912: aload_0
    //   913: aload_1
    //   914: aload 7
    //   916: checkcast 193	android/util/LongSparseArray
    //   919: aload 5
    //   921: iload 6
    //   923: invokespecial 678	com/tencent/theme/d:<init>	(Lcom/tencent/theme/SkinEngine;Landroid/content/res/Resources;Landroid/util/LongSparseArray;Ljava/lang/Class;I)V
    //   926: putfield 643	com/tencent/theme/SkinEngine:w	Lcom/tencent/theme/d;
    //   929: aload_3
    //   930: aload_1
    //   931: aload_0
    //   932: getfield 643	com/tencent/theme/SkinEngine:w	Lcom/tencent/theme/d;
    //   935: invokevirtual 444	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   938: goto -581 -> 357
    //   941: new 586	com/tencent/theme/UnSupportPlatformException
    //   944: dup
    //   945: aload_2
    //   946: invokespecial 662	com/tencent/theme/UnSupportPlatformException:<init>	(Ljava/lang/Throwable;)V
    //   949: athrow
    //   950: astore_2
    //   951: getstatic 106	com/tencent/theme/SkinEngine:DEBUG	Z
    //   954: ifeq +13 -> 967
    //   957: ldc 46
    //   959: ldc_w 689
    //   962: aload_2
    //   963: invokestatic 692	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   966: pop
    //   967: iconst_0
    //   968: putstatic 130	com/tencent/theme/SkinEngine:IS_PROBLEM_MIUI	Z
    //   971: goto -549 -> 422
    //   974: astore_1
    //   975: aconst_null
    //   976: putstatic 132	com/tencent/theme/SkinEngine:mIconsOfCM	Ljava/lang/reflect/Field;
    //   979: aconst_null
    //   980: putstatic 134	com/tencent/theme/SkinEngine:mComposedIconInfoOfCM	Ljava/lang/reflect/Field;
    //   983: return
    //   984: goto -832 -> 152
    //   987: iconst_0
    //   988: istore 4
    //   990: goto -356 -> 634
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	993	0	this	SkinEngine
    //   0	993	1	paramResources	Resources
    //   0	993	2	paramClass1	Class
    //   0	993	3	paramArrayOfInt	int[]
    //   0	993	4	paramInt1	int
    //   0	993	5	paramClass2	Class
    //   0	993	6	paramInt2	int
    //   0	993	7	paramFile	File
    //   9	787	8	localObject1	Object
    //   1	681	9	localObject2	Object
    //   65	506	10	localField	Field
    //   169	3	11	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   24	82	560	java/lang/IllegalArgumentException
    //   82	90	560	java/lang/IllegalArgumentException
    //   94	122	560	java/lang/IllegalArgumentException
    //   122	128	560	java/lang/IllegalArgumentException
    //   133	152	560	java/lang/IllegalArgumentException
    //   152	171	560	java/lang/IllegalArgumentException
    //   176	185	560	java/lang/IllegalArgumentException
    //   189	203	560	java/lang/IllegalArgumentException
    //   207	233	560	java/lang/IllegalArgumentException
    //   233	243	560	java/lang/IllegalArgumentException
    //   253	308	560	java/lang/IllegalArgumentException
    //   313	337	560	java/lang/IllegalArgumentException
    //   337	343	560	java/lang/IllegalArgumentException
    //   347	357	560	java/lang/IllegalArgumentException
    //   357	367	560	java/lang/IllegalArgumentException
    //   497	521	560	java/lang/IllegalArgumentException
    //   527	557	560	java/lang/IllegalArgumentException
    //   570	588	560	java/lang/IllegalArgumentException
    //   591	609	560	java/lang/IllegalArgumentException
    //   613	631	560	java/lang/IllegalArgumentException
    //   634	660	560	java/lang/IllegalArgumentException
    //   669	689	560	java/lang/IllegalArgumentException
    //   702	729	560	java/lang/IllegalArgumentException
    //   733	743	560	java/lang/IllegalArgumentException
    //   756	766	560	java/lang/IllegalArgumentException
    //   769	795	560	java/lang/IllegalArgumentException
    //   801	819	560	java/lang/IllegalArgumentException
    //   823	883	560	java/lang/IllegalArgumentException
    //   886	896	560	java/lang/IllegalArgumentException
    //   899	938	560	java/lang/IllegalArgumentException
    //   941	950	560	java/lang/IllegalArgumentException
    //   24	82	692	java/lang/NoSuchFieldException
    //   82	90	692	java/lang/NoSuchFieldException
    //   94	122	692	java/lang/NoSuchFieldException
    //   122	128	692	java/lang/NoSuchFieldException
    //   133	152	692	java/lang/NoSuchFieldException
    //   152	171	692	java/lang/NoSuchFieldException
    //   176	185	692	java/lang/NoSuchFieldException
    //   189	203	692	java/lang/NoSuchFieldException
    //   207	233	692	java/lang/NoSuchFieldException
    //   233	243	692	java/lang/NoSuchFieldException
    //   253	308	692	java/lang/NoSuchFieldException
    //   313	337	692	java/lang/NoSuchFieldException
    //   337	343	692	java/lang/NoSuchFieldException
    //   347	357	692	java/lang/NoSuchFieldException
    //   357	367	692	java/lang/NoSuchFieldException
    //   497	521	692	java/lang/NoSuchFieldException
    //   527	557	692	java/lang/NoSuchFieldException
    //   570	588	692	java/lang/NoSuchFieldException
    //   591	609	692	java/lang/NoSuchFieldException
    //   613	631	692	java/lang/NoSuchFieldException
    //   634	660	692	java/lang/NoSuchFieldException
    //   669	689	692	java/lang/NoSuchFieldException
    //   702	729	692	java/lang/NoSuchFieldException
    //   733	743	692	java/lang/NoSuchFieldException
    //   756	766	692	java/lang/NoSuchFieldException
    //   769	795	692	java/lang/NoSuchFieldException
    //   801	819	692	java/lang/NoSuchFieldException
    //   823	883	692	java/lang/NoSuchFieldException
    //   886	896	692	java/lang/NoSuchFieldException
    //   899	938	692	java/lang/NoSuchFieldException
    //   941	950	692	java/lang/NoSuchFieldException
    //   176	185	732	java/lang/Throwable
    //   189	203	732	java/lang/Throwable
    //   207	233	732	java/lang/Throwable
    //   702	729	732	java/lang/Throwable
    //   756	766	732	java/lang/Throwable
    //   24	82	746	java/lang/IllegalAccessException
    //   82	90	746	java/lang/IllegalAccessException
    //   94	122	746	java/lang/IllegalAccessException
    //   122	128	746	java/lang/IllegalAccessException
    //   133	152	746	java/lang/IllegalAccessException
    //   152	171	746	java/lang/IllegalAccessException
    //   176	185	746	java/lang/IllegalAccessException
    //   189	203	746	java/lang/IllegalAccessException
    //   207	233	746	java/lang/IllegalAccessException
    //   233	243	746	java/lang/IllegalAccessException
    //   253	308	746	java/lang/IllegalAccessException
    //   313	337	746	java/lang/IllegalAccessException
    //   337	343	746	java/lang/IllegalAccessException
    //   347	357	746	java/lang/IllegalAccessException
    //   357	367	746	java/lang/IllegalAccessException
    //   497	521	746	java/lang/IllegalAccessException
    //   527	557	746	java/lang/IllegalAccessException
    //   570	588	746	java/lang/IllegalAccessException
    //   591	609	746	java/lang/IllegalAccessException
    //   613	631	746	java/lang/IllegalAccessException
    //   634	660	746	java/lang/IllegalAccessException
    //   669	689	746	java/lang/IllegalAccessException
    //   702	729	746	java/lang/IllegalAccessException
    //   733	743	746	java/lang/IllegalAccessException
    //   756	766	746	java/lang/IllegalAccessException
    //   769	795	746	java/lang/IllegalAccessException
    //   801	819	746	java/lang/IllegalAccessException
    //   823	883	746	java/lang/IllegalAccessException
    //   886	896	746	java/lang/IllegalAccessException
    //   899	938	746	java/lang/IllegalAccessException
    //   941	950	746	java/lang/IllegalAccessException
    //   253	308	822	java/lang/Exception
    //   313	337	822	java/lang/Exception
    //   337	343	822	java/lang/Exception
    //   347	357	822	java/lang/Exception
    //   769	795	822	java/lang/Exception
    //   801	819	822	java/lang/Exception
    //   886	896	822	java/lang/Exception
    //   367	422	950	java/lang/Exception
    //   422	496	974	java/lang/Exception
  }
  
  private void a(b paramb)
  {
    Object localObject1 = paramb.i;
    Object localObject2 = ((k)localObject1).b;
    if (this.s != null)
    {
      a(this.mResources, this.c, ((k)localObject1).d, d[this.u], e[this.u]);
      if (this.c.string != null)
      {
        ((k)localObject1).b = this.c.string.toString();
        ((k)localObject1).c = this.c.density;
        if ((localObject2 != null) || (((k)localObject1).b != null) || (((k)localObject1).d.endsWith(".xml"))) {
          break label127;
        }
      }
    }
    label127:
    label207:
    label353:
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            ((k)localObject1).b = null;
            break;
            ((k)localObject1).b = null;
            break;
            if (!(paramb instanceof SkinnableBitmapDrawable.a)) {
              break label353;
            }
            paramb = (SkinnableBitmapDrawable.a)paramb;
            localObject2 = a(((k)localObject1).a, this.mResources, (k)localObject1);
            if (localObject2 != null) {
              break label207;
            }
          } while (!DEBUG);
          throw new NullPointerException("loadImage failed, file path: " + ((k)localObject1).b + " , resource name:" + ((k)localObject1).d);
          if ((DEBUG) && ((localObject2 instanceof SkinnableNinePatchDrawable.a))) {
            throw new IllegalArgumentException("error image, the resource Image is Bitmap, but the skin Image is 9-path, file path: " + ((k)localObject1).b + " , resource name:" + ((k)localObject1).d);
          }
          localObject1 = (SkinnableBitmapDrawable.a)localObject2;
          paramb.l = ((SkinnableBitmapDrawable.a)localObject1).l;
          paramb.e = ((SkinnableBitmapDrawable.a)localObject1).e;
          paramb.j = ((SkinnableBitmapDrawable.a)localObject1).j;
          paramb.k = ((SkinnableBitmapDrawable.a)localObject1).k;
        } while ((!paramb.s) && (!((SkinnableBitmapDrawable.a)localObject1).s));
        paramb.n = ((SkinnableBitmapDrawable.a)localObject1).n;
        paramb.o = ((SkinnableBitmapDrawable.a)localObject1).o;
        paramb.p = ((SkinnableBitmapDrawable.a)localObject1).p;
        paramb.q = ((SkinnableBitmapDrawable.a)localObject1).q;
        paramb.s = true;
        return;
      } while (!(paramb instanceof SkinnableNinePatchDrawable.a));
      paramb = (SkinnableNinePatchDrawable.a)paramb;
      localObject2 = a(((k)localObject1).a, this.mResources, (k)localObject1);
      if (localObject2 != null) {
        break label433;
      }
    } while (!DEBUG);
    throw new NullPointerException("loadImage failed, file path: " + ((k)localObject1).b + " , resource name:" + ((k)localObject1).d);
    label433:
    if ((DEBUG) && ((localObject2 instanceof SkinnableBitmapDrawable.a))) {
      throw new IllegalArgumentException("error image, the resource Image is 9-path, but the skin Image is Bitmap, did you compiled the 9-pathflie to apk and un-zip it? file path: " + ((k)localObject1).b + " , resource name:" + ((k)localObject1).d);
    }
    localObject1 = (SkinnableNinePatchDrawable.a)localObject2;
    paramb.k = ((SkinnableNinePatchDrawable.a)localObject1).k;
    paramb.l = ((SkinnableNinePatchDrawable.a)localObject1).l;
    paramb.n = paramb.m;
    paramb.m = ((SkinnableNinePatchDrawable.a)localObject1).m;
    paramb.r = ((SkinnableNinePatchDrawable.a)localObject1).r;
    paramb.j = ((SkinnableNinePatchDrawable.a)localObject1).j;
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.y == null) {}
    try
    {
      XmlResourceParser localXmlResourceParser = this.mResources.getAssets().openXmlResourceParser("res/xml/theme_config.xml");
      this.y = a(localXmlResourceParser);
      localXmlResourceParser.close();
      if (this.z == null)
      {
        if (this.s == null) {
          this.z = new HashMap();
        }
      }
      else {
        return;
      }
    }
    catch (XmlPullParserException localXmlPullParserException1)
    {
      localObject = new Resources.NotFoundException("wrong xml config file: res/xml/theme_config.xml");
      ((Resources.NotFoundException)localObject).initCause(localXmlPullParserException1);
      throw ((Throwable)localObject);
    }
    catch (IOException localIOException1)
    {
      Object localObject;
      for (;;)
      {
        this.y = new HashMap();
      }
      if (paramBoolean) {}
      try
      {
        a locala = new a();
        localObject = new FileInputStream(new File(this.s, "xml/theme_config.xml"));
        locala.setInput((InputStream)localObject, "UTF-8");
        this.z = a(locala);
        ((FileInputStream)localObject).close();
        return;
      }
      catch (XmlPullParserException localXmlPullParserException2)
      {
        for (;;)
        {
          localObject = new Resources.NotFoundException("wrong theme xml config file: xml/theme_config.xml");
          ((Resources.NotFoundException)localObject).initCause(localXmlPullParserException2);
          throw ((Throwable)localObject);
          XmlPullParser localXmlPullParser = Xml.newPullParser();
        }
      }
      catch (IOException localIOException2)
      {
        this.z = new HashMap();
      }
    }
  }
  
  private SkinnableColorStateList b(int paramInt, Resources paramResources, k paramk)
  {
    Object localObject;
    synchronized (this.c)
    {
      localObject = paramk.b;
      if (localObject != null)
      {
        bool = ((String)localObject).endsWith(".xml");
        if (bool)
        {
          try
          {
            SkinnableColorStateList localSkinnableColorStateList = i.a(this, paramResources, new File((String)localObject), this.o);
            return localSkinnableColorStateList;
          }
          catch (Exception localException)
          {
            if (!DEBUG) {
              break label126;
            }
          }
          paramResources = new Resources.NotFoundException("File " + (String)localObject + " from Skin ColorState resource ID #0x" + Integer.toHexString(paramInt));
          paramResources.initCause(localException);
          throw paramResources;
        }
      }
    }
    label126:
    paramk = paramk.d;
    boolean bool = paramk.endsWith(".xml");
    if (bool) {
      try
      {
        localObject = a(paramInt, this.c);
        paramResources = SkinnableColorStateList.createFromXml(this, paramResources, (XmlPullParser)localObject, true);
        ((XmlResourceParser)localObject).close();
        return paramResources;
      }
      catch (Exception paramResources)
      {
        paramk = new Resources.NotFoundException("File " + paramk + " from Skin ColorList list resource ID #0x" + Integer.toHexString(paramInt));
        paramk.initCause(paramResources);
        throw paramk;
      }
    }
    throw new Resources.NotFoundException("File " + paramk + " from Skin ColorList resource ID #0x" + Integer.toHexString(paramInt) + ": .xml extension required");
  }
  
  private InputStream b(Resources paramResources, String paramString)
    throws IOException, FileNotFoundException
  {
    if (paramString.startsWith("/asset/"))
    {
      paramString = paramString.substring("/asset/".length());
      return paramResources.getAssets().open(paramString);
    }
    return new FileInputStream(new File(paramString));
  }
  
  @TargetApi(16)
  private void b(Context paramContext)
  {
    paramContext = this.c;
    int i1 = 0;
    for (;;)
    {
      k localk;
      try
      {
        if (i1 >= this.q.size()) {
          break label144;
        }
        SkinnableColorStateList localSkinnableColorStateList = (SkinnableColorStateList)((WeakReference)this.q.valueAt(i1)).get();
        if (localSkinnableColorStateList == null) {
          break label147;
        }
        localk = localSkinnableColorStateList.skinData;
        String str1 = localk.b;
        if (this.s != null)
        {
          String str2 = a(this.mResources, localk.d);
          if (str2 != null)
          {
            localk.b = str2;
            if ((str1 != null) || (localk.b != null)) {
              break label124;
            }
            break label147;
          }
          localk.b = null;
          continue;
        }
        localk.b = null;
      }
      finally {}
      continue;
      label124:
      ((SkinnableColorStateList)localObject).a(b(localk.a, this.mResources, localk));
      break label147;
      label144:
      return;
      label147:
      i1 += 1;
    }
  }
  
  @TargetApi(16)
  private void c(Context arg1)
  {
    for (;;)
    {
      int i1;
      synchronized (this.c)
      {
        ArrayList localArrayList = new ArrayList();
        i1 = 0;
        if (i1 < this.p.size())
        {
          b localb = (b)((WeakReference)this.p.valueAt(i1)).get();
          if (localb == null) {
            break label124;
          }
          if (localb.i.d.endsWith(".xml")) {
            localArrayList.add(localb);
          } else {
            a(localb);
          }
        }
      }
      Iterator localIterator = ((ArrayList)localObject).iterator();
      while (localIterator.hasNext()) {
        a((b)localIterator.next());
      }
      return;
      label124:
      i1 += 1;
    }
  }
  
  public static long dumpDrawableCacheMemSize()
  {
    SkinEngine localSkinEngine = getInstances();
    TypedValue localTypedValue = new TypedValue();
    long l2 = 0L;
    int i2 = 0;
    Object localObject;
    long l3;
    long l1;
    int i1;
    if (i2 < localSkinEngine.p.size())
    {
      localObject = (WeakReference)localSkinEngine.p.valueAt(i2);
      l3 = localSkinEngine.p.keyAt(i2);
      l1 = l2;
      if (localObject != null)
      {
        localObject = (Drawable.ConstantState)((WeakReference)localObject).get();
        l1 = l2;
        if (localObject != null)
        {
          if (!(localObject instanceof SkinnableBitmapDrawable.a)) {
            break label188;
          }
          i1 = a(((SkinnableBitmapDrawable.a)localObject).l);
        }
      }
    }
    for (;;)
    {
      l2 += i1;
      localSkinEngine.mResources.getValue((int)l3, localTypedValue, true);
      l1 = l2;
      if (localTypedValue.string != null)
      {
        j.d("SkinEngine", 4, "res:" + localTypedValue.string.toString() + ",size=" + i1, null);
        l1 = l2;
      }
      i2 += 1;
      l2 = l1;
      break;
      label188:
      if ((localObject instanceof SkinnableNinePatchDrawable.a))
      {
        i1 = a(((SkinnableNinePatchDrawable.a)localObject).r);
        continue;
        j.c("SkinEngine", 4, "Total DrawableNum=" + localSkinEngine.p.size() + ",MemSize=" + l2, null);
        return l2;
      }
      else
      {
        i1 = 0;
      }
    }
  }
  
  public static SkinEngine getInstances()
  {
    try
    {
      if (m == null) {
        m = new SkinEngine();
      }
      SkinEngine localSkinEngine = m;
      return localSkinEngine;
    }
    finally {}
  }
  
  public static void init(Context paramContext, Class paramClass1, int paramInt1, Class paramClass2, int paramInt2, File paramFile)
    throws UnSupportPlatformException
  {
    Object localObject = new StringBuilder().append("init cacheFile:");
    if (paramFile == null) {}
    for (boolean bool = true;; bool = false)
    {
      j.c("SkinEngine", 2, bool, null);
      localObject = getInstances();
      Resources localResources = paramContext.getResources();
      ((SkinEngine)localObject).mResources = localResources;
      isSupportPlatform(paramContext, localResources);
      ((SkinEngine)localObject).u = a(((SkinEngine)localObject).mResources);
      paramContext.getApplicationContext().registerReceiver(((SkinEngine)localObject).l, new IntentFilter("com.tencent.qplus.THEME_UPDATE"), "com.tencent.msg.permission.pushnotify", null);
      ((SkinEngine)localObject).a(localResources, paramClass1, null, paramInt1, paramClass2, paramInt2, paramFile);
      paramContext = paramContext.getSharedPreferences("theme", 4);
      ((SkinEngine)localObject).s = paramContext.getString("theme_root", null);
      ((SkinEngine)localObject).o = paramContext.getBoolean("complied", true);
      return;
    }
  }
  
  public static void init(Context paramContext, int[] paramArrayOfInt, Class paramClass, int paramInt, File paramFile)
    throws UnSupportPlatformException
  {
    SkinEngine localSkinEngine = getInstances();
    Resources localResources = paramContext.getResources();
    localSkinEngine.mResources = localResources;
    isSupportPlatform(paramContext, localResources);
    localSkinEngine.u = a(localSkinEngine.mResources);
    paramContext.getApplicationContext().registerReceiver(localSkinEngine.l, new IntentFilter("com.tencent.qplus.THEME_UPDATE"), "com.tencent.msg.permission.pushnotify", null);
    localSkinEngine.a(localResources, null, paramArrayOfInt, 0, paramClass, paramInt, paramFile);
    paramContext = paramContext.getSharedPreferences("theme", 4);
    localSkinEngine.s = paramContext.getString("theme_root", null);
    localSkinEngine.o = paramContext.getBoolean("complied", true);
  }
  
  public static void invalidateAll(View paramView)
  {
    if (paramView == null) {
      return;
    }
    int i2;
    int i1;
    if ((paramView instanceof ViewGroup))
    {
      localObject = (ViewGroup)paramView;
      i2 = ((ViewGroup)localObject).getChildCount();
      i1 = 0;
      while (i1 < i2)
      {
        invalidateAll(((ViewGroup)localObject).getChildAt(i1));
        i1 += 1;
      }
    }
    Object localObject = paramView.getBackground();
    Rect localRect;
    if (localObject != null)
    {
      if (!(localObject instanceof DrawableContainer)) {
        break label256;
      }
      localRect = new Rect();
      ((Drawable)localObject).getPadding(localRect);
      if ((localRect.left == paramView.getPaddingLeft()) && (localRect.right == paramView.getPaddingRight()) && (localRect.top == paramView.getPaddingTop()) && (localRect.bottom == paramView.getPaddingBottom()))
      {
        SkinnableActivityProcesser.a((Drawable)localObject);
        paramView.setBackgroundDrawable(null);
        paramView.setBackgroundDrawable((Drawable)localObject);
      }
    }
    else
    {
      if ((paramView instanceof SkinnableView)) {
        ((SkinnableView)paramView).onThemeChanged();
      }
      if (!(paramView instanceof ImageView)) {
        break label406;
      }
      localObject = ((ImageView)paramView).getDrawable();
      SkinnableActivityProcesser.a((Drawable)localObject);
      ((ImageView)paramView).setImageDrawable(null);
      ((ImageView)paramView).setImageDrawable((Drawable)localObject);
    }
    for (;;)
    {
      paramView.destroyDrawingCache();
      paramView.refreshDrawableState();
      paramView.invalidate();
      paramView.requestLayout();
      return;
      i1 = paramView.getPaddingTop();
      i2 = paramView.getPaddingBottom();
      int i3 = paramView.getPaddingLeft();
      int i4 = paramView.getPaddingRight();
      SkinnableActivityProcesser.a((Drawable)localObject);
      paramView.setBackgroundDrawable(null);
      paramView.setBackgroundDrawable((Drawable)localObject);
      paramView.setPadding(i3, i1, i4, i2);
      break;
      label256:
      if ((localObject instanceof SkinnableNinePatchDrawable))
      {
        localRect = new Rect();
        if ((((SkinnableNinePatchDrawable)localObject).a(localRect)) && (localRect.left == paramView.getPaddingLeft()) && (localRect.right == paramView.getPaddingRight()) && (localRect.top == paramView.getPaddingTop()) && (localRect.bottom == paramView.getPaddingBottom()))
        {
          paramView.setBackgroundDrawable(null);
          paramView.setBackgroundDrawable((Drawable)localObject);
          break;
        }
        i1 = paramView.getPaddingTop();
        i2 = paramView.getPaddingBottom();
        i3 = paramView.getPaddingLeft();
        i4 = paramView.getPaddingRight();
        paramView.setBackgroundDrawable(null);
        paramView.setBackgroundDrawable((Drawable)localObject);
        paramView.setPadding(i3, i1, i4, i2);
        break;
      }
      if (!(localObject instanceof SkinnableBitmapDrawable)) {
        break;
      }
      paramView.setBackgroundDrawable(null);
      paramView.setBackgroundDrawable((Drawable)localObject);
      break;
      label406:
      if ((paramView instanceof TextView))
      {
        localObject = ((TextView)paramView).getCompoundDrawables();
        if ((localObject[0] != null) || (localObject[1] != null) || (localObject[2] != null) || (localObject[3] != null))
        {
          ((TextView)paramView).setCompoundDrawables(null, null, null, null);
          ((TextView)paramView).setCompoundDrawablesWithIntrinsicBounds(localObject[0], localObject[1], localObject[2], localObject[3]);
        }
      }
    }
  }
  
  public static void isSupportPlatform(Context paramContext, Resources paramResources)
    throws UnSupportPlatformException
  {
    try
    {
      if (b)
      {
        localObject1 = Resources.class.getDeclaredField("mResourcesImpl");
        ((Field)localObject1).setAccessible(true);
        localObject1 = ((Field)localObject1).get(paramResources);
        localField = localObject1.getClass().getDeclaredField("sPreloadedDrawables");
        localField.setAccessible(true);
        localObject1 = localField.get(localObject1);
        if (((localObject1 instanceof LongSparseArray)) || ((localObject1 instanceof LongSparseArray[]))) {
          break label106;
        }
        throw new UnSupportPlatformException("sPreloadedDrawables is not LongSparseArray");
      }
    }
    catch (IllegalArgumentException paramContext)
    {
      Object localObject1;
      Field localField;
      for (;;)
      {
        throw new UnSupportPlatformException(paramContext);
        localObject1 = Resources.class.getDeclaredField("sPreloadedDrawables");
        ((Field)localObject1).setAccessible(true);
        localObject1 = ((Field)localObject1).get(paramResources);
      }
      try
      {
        if (b)
        {
          localObject1 = Resources.class.getDeclaredField("mResourcesImpl");
          ((Field)localObject1).setAccessible(true);
          localObject1 = ((Field)localObject1).get(paramResources);
          localField = localObject1.getClass().getDeclaredField("sPreloadedComplexColors");
          localField.setAccessible(true);
          localObject1 = localField.get(localObject1);
          if (!(localObject1 instanceof LongSparseArray)) {
            throw new UnSupportPlatformException("sPreloadedColorStateLists is not LongSparseArray");
          }
        }
      }
      catch (Exception localException)
      {
        localField = Resources.class.getDeclaredField("mPreloadedColorStateLists");
        localField.setAccessible(true);
        paramResources = localField.get(paramResources);
        boolean bool = paramResources instanceof SparseArray;
        if (bool) {}
        for (;;)
        {
          if (m.a(paramContext, "ro.lewa.version").equalsIgnoreCase("LeWa_OS6.0_14.10.22"))
          {
            throw new UnSupportPlatformException("lewa is not supported");
            Object localObject2 = Resources.class.getDeclaredField("sPreloadedColorStateLists");
            ((Field)localObject2).setAccessible(true);
            localObject2 = ((Field)localObject2).get(paramResources);
            break;
            if (!(paramResources instanceof LongSparseArray)) {
              throw new UnSupportPlatformException((Throwable)localObject2);
            }
          }
        }
      }
    }
    catch (NoSuchFieldException paramContext)
    {
      throw new UnSupportPlatformException(paramContext);
    }
    catch (IllegalAccessException paramContext)
    {
      label106:
      throw new UnSupportPlatformException(paramContext);
    }
  }
  
  public static void setSKLog(ISkinEngineLog paramISkinEngineLog)
  {
    j.a = paramISkinEngineLog;
    j.c("SkinEngine", 2, "set ISkinEngineLog ok", null);
  }
  
  @TargetApi(16)
  Drawable.ConstantState a(int paramInt)
  {
    synchronized (this.c)
    {
      Object localObject1 = (WeakReference)this.p.get(paramInt);
      if (localObject1 != null)
      {
        localObject1 = (Drawable.ConstantState)((WeakReference)localObject1).get();
        if (localObject1 != null) {
          return (Drawable.ConstantState)localObject1;
        }
        this.p.delete(paramInt);
      }
      boolean bool = IS_PROBLEM_CM11;
      if (bool) {
        try
        {
          mIconsOfCM.setAccessible(true);
          mIconsOfCM.set(this.mResources, null);
          mComposedIconInfoOfCM.setAccessible(true);
          mComposedIconInfoOfCM.set(this.mResources, null);
          this.mResources.getValue(paramInt, this.c, true);
        }
        catch (Exception localException1)
        {
          try
          {
            mIconsOfCM.setAccessible(true);
            mComposedIconInfoOfCM.setAccessible(true);
            if (mIconsOfCM.get(this.mResources) == null) {
              break label151;
            }
            localObject1 = mComposedIconInfoOfCM.get(this.mResources);
            if (localObject1 == null) {
              break label151;
            }
            return null;
          }
          catch (Exception localException2)
          {
            return null;
          }
          localException1 = localException1;
          return null;
        }
      }
      label151:
      Object localObject3 = this.c.string.toString();
      k localk = new k();
      localk.a = paramInt;
      localk.d = ((String)localObject3).substring(((String)localObject3).lastIndexOf("/") + 1);
      if (this.s != null)
      {
        a(this.mResources, this.c, localk.d, d[this.u], e[this.u]);
        if (this.c.string != null)
        {
          localk.b = this.c.string.toString();
          localk.c = this.c.density;
        }
      }
      localObject3 = a(paramInt, this.mResources, localk);
      if (localObject3 != null)
      {
        ((b)localObject3).i = localk;
        this.p.put(paramInt, new WeakReference(localObject3));
      }
      return (Drawable.ConstantState)localObject3;
    }
  }
  
  /* Error */
  b a(Resources paramResources, k paramk, android.graphics.BitmapFactory.Options paramOptions, Rect paramRect, boolean paramBoolean1, BackupForOOMData paramBackupForOOMData, int paramInt, boolean paramBoolean2)
  {
    // Byte code:
    //   0: iload 8
    //   2: ifeq +411 -> 413
    //   5: aload 6
    //   7: ifnull +406 -> 413
    //   10: new 177	android/util/TypedValue
    //   13: dup
    //   14: invokespecial 178	android/util/TypedValue:<init>	()V
    //   17: astore_2
    //   18: aload_0
    //   19: getfield 231	com/tencent/theme/SkinEngine:mResources	Landroid/content/res/Resources;
    //   22: aload 6
    //   24: getfield 1074	com/tencent/theme/SkinEngine$BackupForOOMData:backFileResId	I
    //   27: aload_2
    //   28: iconst_1
    //   29: invokevirtual 235	android/content/res/Resources:getValue	(ILandroid/util/TypedValue;Z)V
    //   32: aload_2
    //   33: getfield 249	android/util/TypedValue:string	Ljava/lang/CharSequence;
    //   36: invokeinterface 255 1 0
    //   41: astore 9
    //   43: new 297	com/tencent/theme/k
    //   46: dup
    //   47: invokespecial 1060	com/tencent/theme/k:<init>	()V
    //   50: astore_3
    //   51: aload_3
    //   52: aload 6
    //   54: getfield 1074	com/tencent/theme/SkinEngine$BackupForOOMData:backFileResId	I
    //   57: putfield 707	com/tencent/theme/k:a	I
    //   60: aload_3
    //   61: aload 9
    //   63: aload 9
    //   65: ldc_w 1062
    //   68: invokevirtual 1065	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   71: iconst_1
    //   72: iadd
    //   73: invokevirtual 484	java/lang/String:substring	(I)Ljava/lang/String;
    //   76: putfield 318	com/tencent/theme/k:d	Ljava/lang/String;
    //   79: aload_0
    //   80: getfield 473	com/tencent/theme/SkinEngine:s	Ljava/lang/String;
    //   83: ifnull +60 -> 143
    //   86: aload_0
    //   87: aload_0
    //   88: getfield 231	com/tencent/theme/SkinEngine:mResources	Landroid/content/res/Resources;
    //   91: aload_2
    //   92: aload_3
    //   93: getfield 318	com/tencent/theme/k:d	Ljava/lang/String;
    //   96: getstatic 154	com/tencent/theme/SkinEngine:d	[[Ljava/lang/String;
    //   99: aload_0
    //   100: getfield 186	com/tencent/theme/SkinEngine:u	I
    //   103: aaload
    //   104: getstatic 158	com/tencent/theme/SkinEngine:e	[[I
    //   107: aload_0
    //   108: getfield 186	com/tencent/theme/SkinEngine:u	I
    //   111: aaload
    //   112: invokespecial 703	com/tencent/theme/SkinEngine:a	(Landroid/content/res/Resources;Landroid/util/TypedValue;Ljava/lang/String;[Ljava/lang/String;[I)V
    //   115: aload_2
    //   116: getfield 249	android/util/TypedValue:string	Ljava/lang/CharSequence;
    //   119: ifnull +24 -> 143
    //   122: aload_3
    //   123: aload_2
    //   124: getfield 249	android/util/TypedValue:string	Ljava/lang/CharSequence;
    //   127: invokeinterface 255 1 0
    //   132: putfield 299	com/tencent/theme/k:b	Ljava/lang/String;
    //   135: aload_3
    //   136: aload_2
    //   137: getfield 583	android/util/TypedValue:density	I
    //   140: putfield 313	com/tencent/theme/k:c	I
    //   143: aload_3
    //   144: getfield 299	com/tencent/theme/k:b	Ljava/lang/String;
    //   147: ifnull +114 -> 261
    //   150: new 294	android/graphics/Rect
    //   153: dup
    //   154: invokespecial 295	android/graphics/Rect:<init>	()V
    //   157: astore_2
    //   158: new 310	android/graphics/BitmapFactory$Options
    //   161: dup
    //   162: invokespecial 311	android/graphics/BitmapFactory$Options:<init>	()V
    //   165: astore 9
    //   167: aload 9
    //   169: aload_3
    //   170: getfield 313	com/tencent/theme/k:c	I
    //   173: putfield 316	android/graphics/BitmapFactory$Options:inDensity	I
    //   176: aload 9
    //   178: aload 6
    //   180: getfield 1078	com/tencent/theme/SkinEngine$BackupForOOMData:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   183: putfield 1079	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   186: aload_0
    //   187: aload_1
    //   188: aload_3
    //   189: getfield 299	com/tencent/theme/k:b	Ljava/lang/String;
    //   192: invokespecial 308	com/tencent/theme/SkinEngine:b	(Landroid/content/res/Resources;Ljava/lang/String;)Ljava/io/InputStream;
    //   195: astore 4
    //   197: aload_1
    //   198: aconst_null
    //   199: aload 4
    //   201: aload_3
    //   202: getfield 318	com/tencent/theme/k:d	Ljava/lang/String;
    //   205: aload 9
    //   207: aload_2
    //   208: aload_0
    //   209: getfield 184	com/tencent/theme/SkinEngine:o	Z
    //   212: invokestatic 323	com/tencent/theme/i:a	(Landroid/content/res/Resources;Landroid/util/TypedValue;Ljava/io/InputStream;Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;Landroid/graphics/Rect;Z)Lcom/tencent/theme/b;
    //   215: astore_2
    //   216: aload_2
    //   217: astore_1
    //   218: aload 4
    //   220: invokevirtual 328	java/io/InputStream:close	()V
    //   223: aload_2
    //   224: areturn
    //   225: astore_1
    //   226: ldc 46
    //   228: iconst_1
    //   229: new 265	java/lang/StringBuilder
    //   232: dup
    //   233: invokespecial 266	java/lang/StringBuilder:<init>	()V
    //   236: ldc_w 1081
    //   239: invokevirtual 272	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: aload_3
    //   243: getfield 299	com/tencent/theme/k:b	Ljava/lang/String;
    //   246: invokevirtual 272	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: invokevirtual 283	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   252: aload_1
    //   253: invokestatic 335	com/tencent/theme/j:a	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   256: aconst_null
    //   257: astore_2
    //   258: goto -42 -> 216
    //   261: aload_1
    //   262: aload 6
    //   264: getfield 1074	com/tencent/theme/SkinEngine$BackupForOOMData:backFileResId	I
    //   267: aload_2
    //   268: invokevirtual 449	android/content/res/Resources:openRawResource	(ILandroid/util/TypedValue;)Ljava/io/InputStream;
    //   271: astore_3
    //   272: aload_2
    //   273: getfield 249	android/util/TypedValue:string	Ljava/lang/CharSequence;
    //   276: invokeinterface 255 1 0
    //   281: astore 9
    //   283: new 310	android/graphics/BitmapFactory$Options
    //   286: dup
    //   287: invokespecial 311	android/graphics/BitmapFactory$Options:<init>	()V
    //   290: astore 10
    //   292: aload_1
    //   293: aload_2
    //   294: aload_3
    //   295: aload 9
    //   297: aload 10
    //   299: aload 4
    //   301: iconst_1
    //   302: invokestatic 323	com/tencent/theme/i:a	(Landroid/content/res/Resources;Landroid/util/TypedValue;Ljava/io/InputStream;Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;Landroid/graphics/Rect;Z)Lcom/tencent/theme/b;
    //   305: astore_2
    //   306: aload_2
    //   307: astore_1
    //   308: aload_3
    //   309: invokevirtual 328	java/io/InputStream:close	()V
    //   312: aload_2
    //   313: areturn
    //   314: astore_3
    //   315: aload_2
    //   316: astore_1
    //   317: ldc 46
    //   319: iconst_1
    //   320: ldc_w 1083
    //   323: aload_3
    //   324: invokestatic 335	com/tencent/theme/j:a	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   327: aload_2
    //   328: areturn
    //   329: astore_2
    //   330: ldc 46
    //   332: iconst_1
    //   333: ldc_w 1085
    //   336: aload_2
    //   337: invokestatic 335	com/tencent/theme/j:a	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   340: aload_1
    //   341: areturn
    //   342: astore_1
    //   343: ldc 46
    //   345: iconst_1
    //   346: new 265	java/lang/StringBuilder
    //   349: dup
    //   350: invokespecial 266	java/lang/StringBuilder:<init>	()V
    //   353: ldc_w 1087
    //   356: invokevirtual 272	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   359: aload 6
    //   361: getfield 1074	com/tencent/theme/SkinEngine$BackupForOOMData:backFileResId	I
    //   364: invokevirtual 861	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   367: invokevirtual 283	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   370: aload_1
    //   371: invokestatic 335	com/tencent/theme/j:a	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   374: aconst_null
    //   375: areturn
    //   376: astore_1
    //   377: ldc 46
    //   379: iconst_1
    //   380: new 265	java/lang/StringBuilder
    //   383: dup
    //   384: invokespecial 266	java/lang/StringBuilder:<init>	()V
    //   387: ldc_w 1089
    //   390: invokevirtual 272	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   393: aload 6
    //   395: getfield 1074	com/tencent/theme/SkinEngine$BackupForOOMData:backFileResId	I
    //   398: invokevirtual 861	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   401: invokevirtual 283	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   404: aload_1
    //   405: invokestatic 335	com/tencent/theme/j:a	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   408: aconst_null
    //   409: astore_2
    //   410: goto -104 -> 306
    //   413: aload_0
    //   414: aload_1
    //   415: aload_2
    //   416: getfield 299	com/tencent/theme/k:b	Ljava/lang/String;
    //   419: invokespecial 308	com/tencent/theme/SkinEngine:b	(Landroid/content/res/Resources;Ljava/lang/String;)Ljava/io/InputStream;
    //   422: astore 9
    //   424: aload_3
    //   425: iconst_0
    //   426: putfield 351	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   429: aload_3
    //   430: aload 6
    //   432: getfield 1078	com/tencent/theme/SkinEngine$BackupForOOMData:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   435: putfield 1079	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   438: aload_3
    //   439: iload 7
    //   441: putfield 1092	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   444: aload_1
    //   445: aconst_null
    //   446: aload 9
    //   448: aload_2
    //   449: getfield 318	com/tencent/theme/k:d	Ljava/lang/String;
    //   452: aload_3
    //   453: aload 4
    //   455: aload_0
    //   456: getfield 184	com/tencent/theme/SkinEngine:o	Z
    //   459: invokestatic 323	com/tencent/theme/i:a	(Landroid/content/res/Resources;Landroid/util/TypedValue;Ljava/io/InputStream;Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;Landroid/graphics/Rect;Z)Lcom/tencent/theme/b;
    //   462: astore_1
    //   463: aload_1
    //   464: astore_2
    //   465: aload_2
    //   466: astore_1
    //   467: aload 9
    //   469: invokevirtual 328	java/io/InputStream:close	()V
    //   472: aload_2
    //   473: areturn
    //   474: astore_1
    //   475: getstatic 106	com/tencent/theme/SkinEngine:DEBUG	Z
    //   478: ifeq +38 -> 516
    //   481: ldc 46
    //   483: new 265	java/lang/StringBuilder
    //   486: dup
    //   487: invokespecial 266	java/lang/StringBuilder:<init>	()V
    //   490: ldc_w 1094
    //   493: invokevirtual 272	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   496: aload_2
    //   497: getfield 299	com/tencent/theme/k:b	Ljava/lang/String;
    //   500: invokevirtual 272	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   503: ldc_w 1096
    //   506: invokevirtual 272	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   509: invokevirtual 283	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   512: invokestatic 393	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   515: pop
    //   516: aconst_null
    //   517: astore_2
    //   518: goto -53 -> 465
    //   521: astore_2
    //   522: aconst_null
    //   523: astore_1
    //   524: goto -194 -> 330
    //   527: astore_3
    //   528: aconst_null
    //   529: astore_2
    //   530: goto -215 -> 315
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	533	0	this	SkinEngine
    //   0	533	1	paramResources	Resources
    //   0	533	2	paramk	k
    //   0	533	3	paramOptions	android.graphics.BitmapFactory.Options
    //   0	533	4	paramRect	Rect
    //   0	533	5	paramBoolean1	boolean
    //   0	533	6	paramBackupForOOMData	BackupForOOMData
    //   0	533	7	paramInt	int
    //   0	533	8	paramBoolean2	boolean
    //   41	427	9	localObject	Object
    //   290	8	10	localOptions	android.graphics.BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   197	216	225	java/lang/OutOfMemoryError
    //   308	312	314	java/io/IOException
    //   218	223	329	java/lang/Throwable
    //   308	312	329	java/lang/Throwable
    //   317	327	329	java/lang/Throwable
    //   467	472	329	java/lang/Throwable
    //   261	272	342	java/lang/Exception
    //   292	306	376	java/lang/OutOfMemoryError
    //   444	463	474	java/lang/OutOfMemoryError
    //   10	143	521	java/lang/Throwable
    //   143	197	521	java/lang/Throwable
    //   197	216	521	java/lang/Throwable
    //   226	256	521	java/lang/Throwable
    //   261	272	521	java/lang/Throwable
    //   272	283	521	java/lang/Throwable
    //   283	292	521	java/lang/Throwable
    //   292	306	521	java/lang/Throwable
    //   343	374	521	java/lang/Throwable
    //   377	408	521	java/lang/Throwable
    //   413	444	521	java/lang/Throwable
    //   444	463	521	java/lang/Throwable
    //   475	516	521	java/lang/Throwable
    //   283	292	527	java/io/IOException
    //   292	306	527	java/io/IOException
    //   377	408	527	java/io/IOException
  }
  
  void a(Context paramContext)
  {
    boolean bool = true;
    if (SWITCH_DEBUG) {
      Log.d("SkinEngine.switch", "update start");
    }
    j.d("SkinEngine.switch", 2, "skinEngine update start", null);
    this.n = true;
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("theme", 4);
    String str = localSharedPreferences.getString("pending_theme_root", null);
    if (str != null) {
      bool = localSharedPreferences.getBoolean("pending_theme_resources_complied", true);
    }
    synchronized (this.c)
    {
      this.t = this.s;
      this.s = str;
      this.o = bool;
      c(paramContext);
      b(paramContext);
      localSharedPreferences.edit().putString("theme_root", str).putBoolean("complied", this.o).commit();
      this.n = false;
      this.t = null;
      if (SWITCH_DEBUG) {
        Log.d("SkinEngine.switch", "update done");
      }
      j.d("SkinEngine.switch", 2, "skinEngine update done", null);
      return;
    }
  }
  
  public void addBackupForOOMData(Integer paramInteger, BackupForOOMData paramBackupForOOMData)
  {
    if (this.backupForOOMData == null) {
      this.backupForOOMData = new HashMap();
    }
    this.backupForOOMData.put(paramInteger, paramBackupForOOMData);
  }
  
  public final void addDrawableResource(int paramInt)
  {
    this.v.a(this.mResources, paramInt);
  }
  
  @TargetApi(16)
  SkinnableColorStateList b(int paramInt)
  {
    synchronized (this.c)
    {
      Object localObject1 = (WeakReference)this.q.get(paramInt);
      if (localObject1 != null)
      {
        localObject1 = (SkinnableColorStateList)((WeakReference)localObject1).get();
        if (localObject1 != null) {
          return (SkinnableColorStateList)localObject1;
        }
        this.q.delete(paramInt);
      }
      this.mResources.getValue(paramInt, this.c, true);
      Object localObject3 = this.c.string.toString();
      if (((String)localObject3).endsWith(".xml"))
      {
        localObject1 = new k();
        ((k)localObject1).a = paramInt;
        ((k)localObject1).d = ((String)localObject3).substring(((String)localObject3).lastIndexOf("/") + 1);
        if (this.s != null) {
          ((k)localObject1).b = a(this.mResources, ((k)localObject1).d);
        }
        localObject3 = b(paramInt, this.mResources, (k)localObject1);
        ((SkinnableColorStateList)localObject3).skinData = ((k)localObject1);
        this.q.put(paramInt, new WeakReference(localObject3));
        return (SkinnableColorStateList)localObject3;
      }
    }
    return null;
  }
  
  public int getColor(int paramInt)
  {
    synchronized (this.c)
    {
      TypedValue localTypedValue2 = this.c;
      this.mResources.getValue(paramInt, localTypedValue2, true);
      if ((localTypedValue2.type >= 16) && (localTypedValue2.type <= 31))
      {
        paramInt = localTypedValue2.data;
        return paramInt;
      }
      if (localTypedValue2.type == 3)
      {
        paramInt = b(paramInt).getDefaultColor();
        return paramInt;
      }
    }
    throw new Resources.NotFoundException("Resource ID #0x" + Integer.toHexString(paramInt) + " type #0x" + Integer.toHexString(((TypedValue)localObject).type) + " is not valid");
  }
  
  public Drawable getDefaultThemeDrawable(int paramInt)
  {
    for (;;)
    {
      synchronized (this.c)
      {
        Object localObject1 = (WeakReference)this.r.get(paramInt);
        if (localObject1 == null) {
          break label299;
        }
        Object localObject5 = (b)((WeakReference)localObject1).get();
        localObject1 = localObject5;
        if (localObject5 == null)
        {
          this.r.delete(paramInt);
          localObject1 = localObject5;
        }
        localObject5 = localObject1;
        Object localObject2;
        if (localObject1 == null)
        {
          boolean bool = IS_PROBLEM_CM11;
          if (bool) {
            try
            {
              mIconsOfCM.setAccessible(true);
              mIconsOfCM.set(this.mResources, null);
              mComposedIconInfoOfCM.setAccessible(true);
              mComposedIconInfoOfCM.set(this.mResources, null);
              this.mResources.getValue(paramInt, this.c, true);
            }
            catch (Exception localException1)
            {
              try
              {
                mIconsOfCM.setAccessible(true);
                mComposedIconInfoOfCM.setAccessible(true);
                if (mIconsOfCM.get(this.mResources) == null) {
                  continue;
                }
                localObject1 = mComposedIconInfoOfCM.get(this.mResources);
                if (localObject1 == null) {
                  continue;
                }
                return null;
              }
              catch (Exception localException2)
              {
                return null;
              }
              localException1 = localException1;
              return null;
            }
          }
          localObject2 = this.c.string.toString();
          k localk = new k();
          localk.a = paramInt;
          localk.d = ((String)localObject2).substring(((String)localObject2).lastIndexOf("/") + 1);
          localk.b = null;
          localObject2 = a(paramInt, this.mResources, localk);
          localObject5 = localObject2;
          if (localObject2 != null)
          {
            ((b)localObject2).i = localk;
            this.r.put(paramInt, new WeakReference(localObject2));
            localObject5 = localObject2;
          }
        }
        if (localObject5 != null)
        {
          localObject2 = ((b)localObject5).newDrawable(this.mResources);
          return (Drawable)localObject2;
        }
      }
      Object localObject4 = null;
      continue;
      label299:
      localObject4 = null;
    }
  }
  
  public String getSkinRootPath()
  {
    if (this.n) {
      return this.t;
    }
    return this.s;
  }
  
  public Object getThemeConfig(String paramString, Object paramObject)
  {
    for (;;)
    {
      Object localObject1;
      synchronized (this.c)
      {
        a(this.o);
        Object localObject2 = this.z.get(paramString);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = this.y.get(paramString);
          break label63;
          return paramObject;
        }
      }
      label63:
      while (localObject1 != null)
      {
        paramObject = localObject1;
        break;
      }
    }
  }
  
  @TargetApi(16)
  public void getValue(int paramInt, TypedValue paramTypedValue)
  {
    this.mResources.getValue(paramInt, paramTypedValue, true);
    Object localObject;
    if (this.s != null)
    {
      localObject = (WeakReference)this.p.get(paramInt);
      if (localObject == null) {
        break label83;
      }
      localObject = (b)((WeakReference)localObject).get();
      if (localObject == null) {
        break label74;
      }
      if (((b)localObject).i.b == null) {
        break label83;
      }
      paramTypedValue.type = 16777215;
      paramTypedValue.string = ((b)localObject).i.b;
    }
    label74:
    label83:
    TypedValue localTypedValue;
    do
    {
      return;
      this.p.delete(paramInt);
      localObject = paramTypedValue.string.toString();
      localObject = ((String)localObject).substring(((String)localObject).lastIndexOf("/") + 1);
      localTypedValue = new TypedValue();
      a(this.mResources, localTypedValue, (String)localObject, d[this.u], e[this.u]);
    } while (localTypedValue.string == null);
    paramTypedValue.type = 16777215;
    paramTypedValue.string = localTypedValue.string;
  }
  
  public void setSkinEngineHandler(SkinEngineHandler paramSkinEngineHandler)
  {
    this.k = paramSkinEngineHandler;
  }
  
  public boolean setSkinRootPath(Context paramContext, String paramString)
  {
    return setSkinRootPath(paramContext, paramString, true);
  }
  
  public boolean setSkinRootPath(Context paramContext, String paramString, boolean paramBoolean)
  {
    if (this.n)
    {
      if (SWITCH_DEBUG) {
        Log.d("SkinEngine.switch", "[setSkinRootPath] mSkinUpdating is true");
      }
      return false;
    }
    if (SWITCH_DEBUG) {
      Log.d("SkinEngine.switch", "[setSkinRootPath] start");
    }
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("theme", 4);
    if (paramString == null) {
      localSharedPreferences.edit().remove("pending_theme_root").remove("pending_theme_resources_complied").commit();
    }
    for (;;)
    {
      paramContext.sendBroadcast(new Intent("com.tencent.qplus.THEME_UPDATE"), "com.tencent.msg.permission.pushnotify");
      if (SWITCH_DEBUG)
      {
        Log.d("SkinEngine.switch", "[setSkinRootPath] sendBroadcast(ACTION_THEME_UPDATE)");
        Log.d("SkinEngine.switch", "[setSkinRootPath] done");
      }
      return true;
      String str = paramString;
      if (!paramString.endsWith("/")) {
        str = paramString + "/";
      }
      if (str.startsWith("/asset/"))
      {
        localSharedPreferences.edit().putString("pending_theme_root", str).putBoolean("pending_theme_resources_complied", paramBoolean).commit();
      }
      else
      {
        paramString = new File(str);
        if ((paramString.exists()) && (paramString.isDirectory()))
        {
          localSharedPreferences.edit().putString("pending_theme_root", str).putBoolean("pending_theme_resources_complied", paramBoolean).commit();
        }
        else
        {
          if (DEBUG) {
            Log.w("SkinEngine", "[setSkinRootPath] wrong skinPath: " + str);
          }
          localSharedPreferences.edit().remove("pending_theme_root").putBoolean("pending_theme_resources_complied", paramBoolean).commit();
        }
      }
    }
  }
  
  /* Error */
  public void unInit()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 609	com/tencent/theme/SkinEngine:v	Lcom/tencent/theme/g;
    //   4: ifnull +39 -> 43
    //   7: ldc -52
    //   9: ldc_w 602
    //   12: invokevirtual 600	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   15: astore_1
    //   16: aload_1
    //   17: iconst_1
    //   18: invokevirtual 440	java/lang/reflect/Field:setAccessible	(Z)V
    //   21: aload_1
    //   22: invokevirtual 1194	java/lang/reflect/Field:getDeclaringClass	()Ljava/lang/Class;
    //   25: invokevirtual 1197	java/lang/Class:isArray	()Z
    //   28: ifeq +54 -> 82
    //   31: aload_1
    //   32: aconst_null
    //   33: aload_0
    //   34: getfield 609	com/tencent/theme/SkinEngine:v	Lcom/tencent/theme/g;
    //   37: getfield 1199	com/tencent/theme/g:b	[Landroid/util/LongSparseArray;
    //   40: invokevirtual 444	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   43: ldc -52
    //   45: ldc_w 675
    //   48: invokevirtual 600	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   51: astore_1
    //   52: aload_1
    //   53: iconst_1
    //   54: invokevirtual 440	java/lang/reflect/Field:setAccessible	(Z)V
    //   57: aload_1
    //   58: aload_0
    //   59: getfield 231	com/tencent/theme/SkinEngine:mResources	Landroid/content/res/Resources;
    //   62: invokevirtual 445	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   65: checkcast 193	android/util/LongSparseArray
    //   68: astore_2
    //   69: aload_1
    //   70: aconst_null
    //   71: aload_0
    //   72: getfield 643	com/tencent/theme/SkinEngine:w	Lcom/tencent/theme/d;
    //   75: getfield 1201	com/tencent/theme/d:b	Landroid/util/LongSparseArray;
    //   78: invokevirtual 444	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   81: return
    //   82: aload_1
    //   83: aconst_null
    //   84: aload_0
    //   85: getfield 609	com/tencent/theme/SkinEngine:v	Lcom/tencent/theme/g;
    //   88: getfield 1199	com/tencent/theme/g:b	[Landroid/util/LongSparseArray;
    //   91: iconst_0
    //   92: aaload
    //   93: invokevirtual 444	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   96: goto -53 -> 43
    //   99: astore_1
    //   100: getstatic 106	com/tencent/theme/SkinEngine:DEBUG	Z
    //   103: ifeq -22 -> 81
    //   106: ldc 46
    //   108: ldc_w 1203
    //   111: aload_1
    //   112: invokestatic 692	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   115: pop
    //   116: return
    //   117: astore_1
    //   118: ldc -52
    //   120: ldc_w 680
    //   123: invokevirtual 600	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   126: astore_1
    //   127: aload_1
    //   128: iconst_1
    //   129: invokevirtual 440	java/lang/reflect/Field:setAccessible	(Z)V
    //   132: aload_1
    //   133: aload_0
    //   134: getfield 231	com/tencent/theme/SkinEngine:mResources	Landroid/content/res/Resources;
    //   137: invokevirtual 445	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   140: astore_2
    //   141: aload_2
    //   142: instanceof 651
    //   145: ifeq +16 -> 161
    //   148: aload_1
    //   149: aconst_null
    //   150: aload_0
    //   151: getfield 687	com/tencent/theme/SkinEngine:x	Lcom/tencent/theme/e;
    //   154: getfield 1206	com/tencent/theme/e:b	Landroid/util/SparseArray;
    //   157: invokevirtual 444	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   160: return
    //   161: aload_2
    //   162: instanceof 193
    //   165: ifeq -84 -> 81
    //   168: aload_1
    //   169: aconst_null
    //   170: aload_0
    //   171: getfield 643	com/tencent/theme/SkinEngine:w	Lcom/tencent/theme/d;
    //   174: getfield 1201	com/tencent/theme/d:b	Landroid/util/LongSparseArray;
    //   177: invokevirtual 444	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   180: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	181	0	this	SkinEngine
    //   15	68	1	localField1	Field
    //   99	13	1	localException1	Exception
    //   117	1	1	localException2	Exception
    //   126	43	1	localField2	Field
    //   68	94	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   0	43	99	java/lang/Exception
    //   82	96	99	java/lang/Exception
    //   118	160	99	java/lang/Exception
    //   161	180	99	java/lang/Exception
    //   43	81	117	java/lang/Exception
  }
  
  public void writeCacheFile(File paramFile)
    throws IOException
  {
    this.v.a(paramFile);
  }
  
  public static class BackupForOOMData
  {
    public int backFileResId;
    public Bitmap.Config inPreferredConfig;
    public int orgkFileResId;
    
    public BackupForOOMData(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
    {
      this.orgkFileResId = paramInt1;
      this.backFileResId = paramInt2;
      this.inPreferredConfig = paramConfig;
    }
  }
  
  private class a
    extends AsyncTask<Context, Void, Context>
  {
    private a() {}
    
    protected Context a(Context... paramVarArgs)
    {
      if (SkinEngine.SWITCH_DEBUG) {
        Log.d("SkinEngine.switch", "UpdateTask.doInBackground start");
      }
      SkinEngine.this.a(paramVarArgs[0]);
      System.gc();
      Thread.yield();
      System.gc();
      if (SkinEngine.SWITCH_DEBUG) {
        Log.d("SkinEngine.switch", "UpdateTask.doInBackground done");
      }
      return paramVarArgs[0];
    }
    
    protected void a(Context paramContext)
    {
      if (SkinEngine.SWITCH_DEBUG) {
        Log.d("SkinEngine.switch", "UpdateTask.onPostExecute start");
      }
      SkinEngine.a(SkinEngine.this, null);
      SkinEngine.a(SkinEngine.this, SkinEngine.a(SkinEngine.this));
      Intent localIntent = new Intent("com.tencent.qplus.THEME_INVALIDATE");
      localIntent.putExtra("pid", Process.myPid());
      paramContext.sendBroadcast(localIntent, "com.tencent.msg.permission.pushnotify");
      if (SkinEngine.SWITCH_DEBUG)
      {
        Log.d("SkinEngine.switch", "UpdateTask.onPostExecute sendBroadcast(ACTION_THEME_INVALIDATE)");
        Log.d("SkinEngine.switch", "UpdateTask.onPostExecute done");
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\theme\SkinEngine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
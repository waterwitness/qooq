package com.tencent.mobileqq.app;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.kapalaiadapter.KapalaiAdapterUtil;
import com.tencent.mobileqq.utils.kapalaiadapter.MobileIssueSettings;
import com.tencent.qphone.base.util.QLog;
import mqq.util.NativeUtil;
import qfz;

public class ScreenShot
  implements Handler.Callback, View.OnClickListener
{
  static final int jdField_a_of_type_Int = -16847;
  public static final String a;
  static final int jdField_b_of_type_Int = 100001;
  static final int c = 100002;
  static final int d = 100003;
  static final int e = 100004;
  static final int f = 100005;
  private static final int g = 1;
  private static final int h = 2;
  private static final int i = 3;
  public final Context a;
  public Bitmap a;
  public Drawable a;
  private final Handler jdField_a_of_type_AndroidOsHandler;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  public Window a;
  public Button a;
  final qfz jdField_a_of_type_Qfz;
  public Bitmap b;
  public Drawable b;
  private final Handler jdField_b_of_type_AndroidOsHandler;
  public Button b;
  public Bitmap c;
  public Button c;
  public Button d;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = AppConstants.bh + "/QQ_Screenshot/";
  }
  
  public ScreenShot(Context paramContext, Window paramWindow)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity)) {
      for (paramWindow = (Activity)this.jdField_a_of_type_AndroidContentContext; paramWindow.getParent() != null; paramWindow = paramWindow.getParent()) {}
    }
    for (this.jdField_a_of_type_AndroidViewWindow = paramWindow.getWindow();; this.jdField_a_of_type_AndroidViewWindow = paramWindow)
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130842893);
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130842892);
      this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)((LayoutInflater)this.jdField_a_of_type_AndroidContentContext.getSystemService("layout_inflater")).inflate(2130904931, null));
      this.jdField_a_of_type_Qfz = new qfz(this, this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_Qfz, 0);
      this.jdField_c_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131304826));
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131304827));
      this.d = ((Button)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131297867));
      this.jdField_b_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131304825));
      this.d.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
      this.jdField_b_of_type_AndroidOsHandler = new Handler(ThreadManager.a(), this);
      return;
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetButton.setVisibility(0);
      this.d.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
    this.jdField_c_of_type_AndroidWidgetButton.setVisibility(8);
    this.d.setVisibility(8);
  }
  
  private boolean a(Bitmap paramBitmap)
  {
    int m = paramBitmap.getWidth();
    int k = paramBitmap.getHeight();
    Object localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics();
    int j = ((DisplayMetrics)localObject).widthPixels;
    int n = ((DisplayMetrics)localObject).heightPixels;
    if (((m == j) && (k == n)) || ((m == n) && (k == j)))
    {
      localObject = new int[m];
      paramBitmap.getPixels((int[])localObject, 0, m, 0, k / 2, m, 1);
      j = 0;
      while (j < m)
      {
        if (localObject[j] != -16777216) {
          return true;
        }
        j += 1;
      }
      localObject = new int[k];
      paramBitmap.getPixels((int[])localObject, 0, 1, m / 2, 0, 1, k);
      j = 0;
      for (;;)
      {
        if (j >= k) {
          break label149;
        }
        if (localObject[j] != -16777216) {
          break;
        }
        j += 1;
      }
    }
    label149:
    return false;
  }
  
  private void b()
  {
    WindowManager localWindowManager;
    WindowManager.LayoutParams localLayoutParams;
    if (!a())
    {
      localWindowManager = (WindowManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("window");
      localLayoutParams = new WindowManager.LayoutParams();
      localLayoutParams.type = 2003;
      localLayoutParams.format = 1;
      localLayoutParams.flags |= 0x100;
    }
    try
    {
      localWindowManager.addView(this.jdField_a_of_type_AndroidViewViewGroup, localLayoutParams);
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("qqBaseActivity", 2, "", localThrowable);
    }
  }
  
  private void c()
  {
    if (a()) {
      ((WindowManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("window")).removeView(this.jdField_a_of_type_AndroidViewViewGroup);
    }
    this.jdField_c_of_type_AndroidGraphicsBitmap = null;
    this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    this.jdField_b_of_type_AndroidGraphicsBitmap = null;
  }
  
  private boolean c()
  {
    return (!Build.MODEL.contains("Galaxy Nexus")) && (!Build.MODEL.contains("HTC S720")) && (!Build.MODEL.contains("SM-N9006")) && ((!Build.MODEL.contains("ZTE U930")) || (Build.VERSION.SDK_INT != 16)) && ((!Build.MODEL.contains("HTC One X")) || (Build.VERSION.SDK_INT != 16)) && ((!Build.MODEL.contains("GT-I9260")) || (Build.VERSION.SDK_INT != 16)) && (!Build.MODEL.contains("vivo Y18L")) && (!Build.MODEL.contains("HM 1SW")) && (!Build.MODEL.contains("DOOV S2y")) && (!Build.MODEL.contains("H30-T10")) && (!Build.MODEL.contains("vivo Y17T")) && (!d());
  }
  
  private boolean d()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (Build.MANUFACTURER.contains("Meizu")) {
      if ((!Build.MODEL.contains("M351")) && (!Build.MODEL.contains("M353")) && (!Build.MODEL.contains("M355")) && (!Build.MODEL.contains("M356")) && (!Build.MODEL.contains("MX4")))
      {
        bool1 = bool2;
        if (!Build.MODEL.contains("MX4 Pro")) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static native int snapScreen(int paramInt1, int paramInt2);
  
  public Bitmap a()
  {
    View localView = this.jdField_a_of_type_AndroidViewWindow.getDecorView();
    localView.setDrawingCacheEnabled(true);
    localView.buildDrawingCache();
    Object localObject = localView.getDrawingCache();
    Rect localRect = new Rect();
    this.jdField_a_of_type_AndroidViewWindow.getDecorView().getWindowVisibleDisplayFrame(localRect);
    int j = localRect.top;
    int k = ((Activity)this.jdField_a_of_type_AndroidContentContext).getWindowManager().getDefaultDisplay().getWidth();
    int m = ((Activity)this.jdField_a_of_type_AndroidContentContext).getWindowManager().getDefaultDisplay().getHeight();
    localRect = null;
    try
    {
      localObject = Bitmap.createBitmap((Bitmap)localObject, 0, j, k, m - j);
      localView.destroyDrawingCache();
      return (Bitmap)localObject;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        localObject = localRect;
        if (QLog.isColorLevel())
        {
          QLog.d("ScreenShot", 2, localOutOfMemoryError, new Object[0]);
          localObject = localRect;
        }
      }
    }
  }
  
  public void a()
  {
    c();
    ReportController.b(null, "CliOper", "", "", "0X8005008", "0X8005008", 0, 0, "0", "", "", "");
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_AndroidViewViewGroup.getParent() != null;
  }
  
  public boolean b()
  {
    this.jdField_a_of_type_Qfz.f = 0;
    this.jdField_a_of_type_Qfz.jdField_a_of_type_AndroidGraphicsRect.setEmpty();
    this.jdField_b_of_type_AndroidGraphicsBitmap = null;
    a(false);
    if (c()) {}
    try
    {
      Bitmap localBitmap = NativeUtil.screenshot(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_AndroidGraphicsBitmap = localBitmap;
      this.jdField_c_of_type_AndroidGraphicsBitmap = localBitmap;
      if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!a(this.jdField_a_of_type_AndroidGraphicsBitmap)))
      {
        this.jdField_a_of_type_AndroidGraphicsBitmap = null;
        this.jdField_c_of_type_AndroidGraphicsBitmap = null;
      }
      bool = this.jdField_a_of_type_AndroidContentContext instanceof Activity;
      if ((!bool) && (this.jdField_a_of_type_AndroidGraphicsBitmap == null)) {
        return false;
      }
    }
    catch (Throwable localThrowable)
    {
      boolean bool;
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("mqq", 2, "", localThrowable);
        }
      }
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
      if (!bool) {}
    }
    for (String str = "1";; str = "0")
    {
      ReportController.b(null, "CliOper", "", "", "0X8005006", "0X8005006", 0, 0, str, "", "", "");
      return true;
    }
  }
  
  /* Error */
  public boolean handleMessage(android.os.Message paramMessage)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_1
    //   3: getfield 425	android/os/Message:what	I
    //   6: tableswitch	default:+26->32, 1:+34->40, 2:+140->146, 3:+28->34
    //   32: iconst_1
    //   33: ireturn
    //   34: aload_0
    //   35: invokespecial 427	com/tencent/mobileqq/app/ScreenShot:b	()V
    //   38: iconst_1
    //   39: ireturn
    //   40: aload_1
    //   41: getfield 430	android/os/Message:arg1	I
    //   44: iconst_1
    //   45: if_icmpne +82 -> 127
    //   48: aload_1
    //   49: getfield 434	android/os/Message:obj	Ljava/lang/Object;
    //   52: checkcast 120	qfz
    //   55: astore_1
    //   56: aload_1
    //   57: ldc 14
    //   59: putfield 384	qfz:f	I
    //   62: aload_0
    //   63: iconst_0
    //   64: invokespecial 178	com/tencent/mobileqq/app/ScreenShot:a	(Z)V
    //   67: aload_1
    //   68: invokevirtual 437	qfz:invalidate	()V
    //   71: aload_1
    //   72: aconst_null
    //   73: new 439	qfy
    //   76: dup
    //   77: aload_0
    //   78: aload_1
    //   79: invokespecial 442	qfy:<init>	(Lcom/tencent/mobileqq/app/ScreenShot;Lqfz;)V
    //   82: invokestatic 448	android/os/SystemClock:uptimeMillis	()J
    //   85: ldc2_w 449
    //   88: ladd
    //   89: invokevirtual 454	qfz:scheduleDrawable	(Landroid/graphics/drawable/Drawable;Ljava/lang/Runnable;J)V
    //   92: aload_0
    //   93: getfield 71	com/tencent/mobileqq/app/ScreenShot:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   96: invokevirtual 458	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   99: aload_0
    //   100: getfield 71	com/tencent/mobileqq/app/ScreenShot:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   103: ldc_w 459
    //   106: invokevirtual 463	android/content/Context:getString	(I)Ljava/lang/String;
    //   109: ldc_w 465
    //   112: getstatic 66	com/tencent/mobileqq/app/ScreenShot:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   115: invokevirtual 469	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   118: iconst_1
    //   119: invokestatic 475	android/widget/Toast:makeText	(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;
    //   122: invokevirtual 478	android/widget/Toast:show	()V
    //   125: iconst_1
    //   126: ireturn
    //   127: aload_0
    //   128: getfield 71	com/tencent/mobileqq/app/ScreenShot:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   131: invokevirtual 458	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   134: ldc_w 479
    //   137: iconst_1
    //   138: invokestatic 482	android/widget/Toast:makeText	(Landroid/content/Context;II)Landroid/widget/Toast;
    //   141: invokevirtual 478	android/widget/Toast:show	()V
    //   144: iconst_1
    //   145: ireturn
    //   146: aload_1
    //   147: getfield 434	android/os/Message:obj	Ljava/lang/Object;
    //   150: checkcast 120	qfz
    //   153: astore 4
    //   155: new 484	java/io/File
    //   158: dup
    //   159: getstatic 66	com/tencent/mobileqq/app/ScreenShot:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   162: invokespecial 487	java/io/File:<init>	(Ljava/lang/String;)V
    //   165: astore_1
    //   166: aload_1
    //   167: invokevirtual 490	java/io/File:exists	()Z
    //   170: ifne +8 -> 178
    //   173: aload_1
    //   174: invokevirtual 493	java/io/File:mkdirs	()Z
    //   177: pop
    //   178: new 484	java/io/File
    //   181: dup
    //   182: new 46	java/lang/StringBuilder
    //   185: dup
    //   186: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   189: getstatic 66	com/tencent/mobileqq/app/ScreenShot:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   192: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: invokestatic 498	java/lang/System:currentTimeMillis	()J
    //   198: invokevirtual 501	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   201: ldc_w 503
    //   204: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   210: invokespecial 487	java/io/File:<init>	(Ljava/lang/String;)V
    //   213: astore_3
    //   214: aload_3
    //   215: ifnull +194 -> 409
    //   218: new 505	java/io/FileOutputStream
    //   221: dup
    //   222: aload_3
    //   223: invokespecial 508	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   226: astore_1
    //   227: aload 4
    //   229: getfield 509	qfz:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   232: getstatic 515	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   235: bipush 80
    //   237: aload_1
    //   238: invokevirtual 519	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   241: istore 6
    //   243: aload 4
    //   245: aconst_null
    //   246: putfield 509	qfz:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   249: aload_1
    //   250: ifnull +165 -> 415
    //   253: aload_1
    //   254: invokevirtual 522	java/io/FileOutputStream:close	()V
    //   257: aload_0
    //   258: getfield 71	com/tencent/mobileqq/app/ScreenShot:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   261: invokestatic 528	android/preference/PreferenceManager:getDefaultSharedPreferences	(Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   264: invokeinterface 534 1 0
    //   269: astore_1
    //   270: aload_1
    //   271: ldc_w 536
    //   274: aload_3
    //   275: invokestatic 542	android/net/Uri:fromFile	(Ljava/io/File;)Landroid/net/Uri;
    //   278: invokevirtual 543	android/net/Uri:toString	()Ljava/lang/String;
    //   281: invokeinterface 549 3 0
    //   286: pop
    //   287: aload_1
    //   288: invokeinterface 552 1 0
    //   293: pop
    //   294: aload_0
    //   295: getfield 71	com/tencent/mobileqq/app/ScreenShot:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   298: new 554	android/content/Intent
    //   301: dup
    //   302: ldc_w 556
    //   305: aload_3
    //   306: invokestatic 542	android/net/Uri:fromFile	(Ljava/io/File;)Landroid/net/Uri;
    //   309: invokespecial 559	android/content/Intent:<init>	(Ljava/lang/String;Landroid/net/Uri;)V
    //   312: invokevirtual 563	android/content/Context:sendBroadcast	(Landroid/content/Intent;)V
    //   315: aload_0
    //   316: getfield 164	com/tencent/mobileqq/app/ScreenShot:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   319: astore_1
    //   320: iload 6
    //   322: ifeq +65 -> 387
    //   325: iconst_1
    //   326: istore 5
    //   328: aload_1
    //   329: iconst_1
    //   330: iload 5
    //   332: iconst_0
    //   333: aload 4
    //   335: invokevirtual 567	android/os/Handler:obtainMessage	(IIILjava/lang/Object;)Landroid/os/Message;
    //   338: invokevirtual 570	android/os/Message:sendToTarget	()V
    //   341: iconst_1
    //   342: ireturn
    //   343: aload 4
    //   345: aconst_null
    //   346: putfield 509	qfz:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   349: aload_1
    //   350: ifnull +59 -> 409
    //   353: aload_1
    //   354: invokevirtual 522	java/io/FileOutputStream:close	()V
    //   357: iconst_0
    //   358: istore 6
    //   360: goto -103 -> 257
    //   363: astore_1
    //   364: iconst_0
    //   365: istore 6
    //   367: goto -110 -> 257
    //   370: astore_1
    //   371: aload 4
    //   373: aconst_null
    //   374: putfield 509	qfz:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   377: aload_2
    //   378: ifnull +7 -> 385
    //   381: aload_2
    //   382: invokevirtual 522	java/io/FileOutputStream:close	()V
    //   385: aload_1
    //   386: athrow
    //   387: iconst_0
    //   388: istore 5
    //   390: goto -62 -> 328
    //   393: astore_2
    //   394: goto -9 -> 385
    //   397: astore_3
    //   398: aload_1
    //   399: astore_2
    //   400: aload_3
    //   401: astore_1
    //   402: goto -31 -> 371
    //   405: astore_2
    //   406: goto -63 -> 343
    //   409: iconst_0
    //   410: istore 6
    //   412: goto -155 -> 257
    //   415: goto -158 -> 257
    //   418: astore_1
    //   419: iconst_1
    //   420: ireturn
    //   421: astore_1
    //   422: goto -165 -> 257
    //   425: astore_1
    //   426: aconst_null
    //   427: astore_1
    //   428: goto -85 -> 343
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	431	0	this	ScreenShot
    //   0	431	1	paramMessage	android.os.Message
    //   1	381	2	localObject1	Object
    //   393	1	2	localIOException	java.io.IOException
    //   399	1	2	localMessage	android.os.Message
    //   405	1	2	localFileNotFoundException	java.io.FileNotFoundException
    //   213	93	3	localFile	java.io.File
    //   397	4	3	localObject2	Object
    //   153	219	4	localqfz	qfz
    //   326	63	5	j	int
    //   241	170	6	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   353	357	363	java/io/IOException
    //   218	227	370	finally
    //   381	385	393	java/io/IOException
    //   227	243	397	finally
    //   227	243	405	java/io/FileNotFoundException
    //   146	178	418	java/lang/Exception
    //   178	214	418	java/lang/Exception
    //   243	249	418	java/lang/Exception
    //   253	257	418	java/lang/Exception
    //   257	320	418	java/lang/Exception
    //   328	341	418	java/lang/Exception
    //   343	349	418	java/lang/Exception
    //   353	357	418	java/lang/Exception
    //   371	377	418	java/lang/Exception
    //   381	385	418	java/lang/Exception
    //   385	387	418	java/lang/Exception
    //   253	257	421	java/io/IOException
    //   218	227	425	java/io/FileNotFoundException
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            this.jdField_a_of_type_Qfz.a(true);
          } while ((MobileIssueSettings.g) || (Build.VERSION.SDK_INT >= 11));
          KapalaiAdapterUtil.a().b(this.jdField_a_of_type_AndroidViewWindow);
          return;
          this.jdField_a_of_type_Qfz.a(false);
        } while ((MobileIssueSettings.g) || (Build.VERSION.SDK_INT >= 11));
        KapalaiAdapterUtil.a().b(this.jdField_a_of_type_AndroidViewWindow);
        return;
        c();
        ReportController.b(null, "CliOper", "", "", "0X8005008", "0X8005008", 0, 0, "1", "", "", "");
      } while ((MobileIssueSettings.g) || (Build.VERSION.SDK_INT >= 11));
      KapalaiAdapterUtil.a().b(this.jdField_a_of_type_AndroidViewWindow);
      return;
      c();
      ReportController.b(null, "CliOper", "", "", "0X8005008", "0X8005008", 0, 0, "2", "", "", "");
    } while ((MobileIssueSettings.g) || (Build.VERSION.SDK_INT >= 11));
    KapalaiAdapterUtil.a().b(this.jdField_a_of_type_AndroidViewWindow);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\ScreenShot.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
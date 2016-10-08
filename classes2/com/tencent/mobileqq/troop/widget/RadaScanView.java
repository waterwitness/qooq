package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.HandlerThread;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.widget.Scroller;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Map;

public class RadaScanView
  extends SurfaceView
  implements SurfaceHolder.Callback
{
  protected static final String a = "RadaScanView";
  protected static final long b = 15L;
  protected static final int d = 1;
  protected float a;
  protected int a;
  protected long a;
  protected Context a;
  protected Bitmap a;
  protected Paint a;
  protected Point a;
  protected Rect a;
  protected HandlerThread a;
  protected SurfaceHolder a;
  protected Scroller a;
  protected QQAppInterface a;
  protected RadaScanView.OnScanDegreeChangeListener a;
  protected RadaScanView.WorkHandler a;
  protected Object a;
  protected volatile boolean a;
  protected Bitmap[] a;
  protected int b;
  protected Bitmap b;
  protected Paint b;
  protected Point b;
  protected Rect b;
  protected String b;
  protected volatile boolean b;
  protected int c;
  protected long c;
  protected Bitmap c;
  protected Paint c;
  protected Rect c;
  protected boolean c;
  protected long d;
  protected Bitmap d;
  protected Paint d;
  protected Rect d;
  protected int e;
  protected long e;
  protected Bitmap e;
  protected Paint e;
  protected int f;
  protected int g;
  protected int h;
  protected int i;
  protected int j;
  protected int k;
  protected int l;
  protected int m;
  protected final int n;
  protected int o;
  protected final int p;
  protected int q;
  
  public RadaScanView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.n = 10;
    this.p = 140;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewSurfaceHolder = getHolder();
    this.jdField_a_of_type_AndroidViewSurfaceHolder.addCallback(this);
    setZOrderOnTop(true);
    this.jdField_a_of_type_AndroidViewSurfaceHolder.setFormat(-2);
    this.jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("RadaScanView");
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRadaScanView$WorkHandler = new RadaScanView.WorkHandler(this, this.jdField_a_of_type_AndroidOsHandlerThread.getLooper());
    e();
    a(paramContext);
    g();
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidWidgetScroller = new Scroller(paramContext);
    this.m = DisplayUtil.a(paramContext, 15.0F);
    this.jdField_a_of_type_AndroidGraphicsPoint = new Point();
    this.jdField_b_of_type_AndroidGraphicsPoint = new Point();
    this.jdField_c_of_type_AndroidGraphicsRect = new Rect();
    this.jdField_d_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_d_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_d_of_type_AndroidGraphicsPaint.setFilterBitmap(true);
    this.jdField_c_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_c_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_c_of_type_AndroidGraphicsPaint.setColor(Color.parseColor("#5affffff"));
    this.jdField_c_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_c_of_type_AndroidGraphicsPaint.setStrokeWidth(DisplayUtil.a(paramContext, 1.0F));
    this.jdField_e_of_type_AndroidGraphicsBitmap = ImageUtil.a();
  }
  
  /* Error */
  protected void a()
  {
    // Byte code:
    //   0: invokestatic 198	java/lang/System:currentTimeMillis	()J
    //   3: lstore 5
    //   5: aload_0
    //   6: getfield 74	com/tencent/mobileqq/troop/widget/RadaScanView:jdField_a_of_type_AndroidViewSurfaceHolder	Landroid/view/SurfaceHolder;
    //   9: invokeinterface 202 1 0
    //   14: astore_3
    //   15: aload_0
    //   16: getfield 204	com/tencent/mobileqq/troop/widget/RadaScanView:jdField_a_of_type_Boolean	Z
    //   19: ifne +37 -> 56
    //   22: aload_3
    //   23: ifnull +33 -> 56
    //   26: aload_3
    //   27: invokevirtual 210	android/view/Surface:isValid	()Z
    //   30: ifeq +26 -> 56
    //   33: aconst_null
    //   34: astore_1
    //   35: aload_0
    //   36: getfield 74	com/tencent/mobileqq/troop/widget/RadaScanView:jdField_a_of_type_AndroidViewSurfaceHolder	Landroid/view/SurfaceHolder;
    //   39: aconst_null
    //   40: invokeinterface 214 2 0
    //   45: astore_2
    //   46: aload_2
    //   47: astore_1
    //   48: aload_1
    //   49: ifnonnull +309 -> 358
    //   52: aload_1
    //   53: ifnonnull +4 -> 57
    //   56: return
    //   57: iconst_1
    //   58: istore 11
    //   60: getstatic 219	android/os/Build$VERSION:SDK_INT	I
    //   63: bipush 17
    //   65: if_icmpeq +9 -> 74
    //   68: aload_3
    //   69: invokevirtual 210	android/view/Surface:isValid	()Z
    //   72: istore 11
    //   74: iload 11
    //   76: ifeq -20 -> 56
    //   79: aload_0
    //   80: getfield 74	com/tencent/mobileqq/troop/widget/RadaScanView:jdField_a_of_type_AndroidViewSurfaceHolder	Landroid/view/SurfaceHolder;
    //   83: aload_1
    //   84: invokeinterface 223 2 0
    //   89: invokestatic 198	java/lang/System:currentTimeMillis	()J
    //   92: lstore 7
    //   94: lload 7
    //   96: lload 5
    //   98: lsub
    //   99: lstore 7
    //   101: lload 7
    //   103: ldc2_w 13
    //   106: lcmp
    //   107: ifge +12 -> 119
    //   110: ldc2_w 13
    //   113: lload 7
    //   115: lsub
    //   116: invokestatic 229	java/lang/Thread:sleep	(J)V
    //   119: aload_0
    //   120: aload_0
    //   121: getfield 231	com/tencent/mobileqq/troop/widget/RadaScanView:jdField_a_of_type_Long	J
    //   124: lconst_1
    //   125: ladd
    //   126: putfield 231	com/tencent/mobileqq/troop/widget/RadaScanView:jdField_a_of_type_Long	J
    //   129: invokestatic 236	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   132: ifeq +60 -> 192
    //   135: invokestatic 198	java/lang/System:currentTimeMillis	()J
    //   138: lstore 9
    //   140: aload_0
    //   141: getfield 231	com/tencent/mobileqq/troop/widget/RadaScanView:jdField_a_of_type_Long	J
    //   144: ldc2_w 237
    //   147: lrem
    //   148: lconst_0
    //   149: lcmp
    //   150: ifne +42 -> 192
    //   153: ldc -16
    //   155: iconst_2
    //   156: new 242	java/lang/StringBuilder
    //   159: dup
    //   160: invokespecial 243	java/lang/StringBuilder:<init>	()V
    //   163: ldc -11
    //   165: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: lload 7
    //   170: invokevirtual 252	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   173: ldc -2
    //   175: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: lload 9
    //   180: lload 5
    //   182: lsub
    //   183: invokevirtual 252	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   186: invokevirtual 258	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   189: invokestatic 261	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   192: aload_0
    //   193: getfield 204	com/tencent/mobileqq/troop/widget/RadaScanView:jdField_a_of_type_Boolean	Z
    //   196: ifne -140 -> 56
    //   199: aload_0
    //   200: getfield 109	com/tencent/mobileqq/troop/widget/RadaScanView:jdField_a_of_type_ComTencentMobileqqTroopWidgetRadaScanView$WorkHandler	Lcom/tencent/mobileqq/troop/widget/RadaScanView$WorkHandler;
    //   203: iconst_1
    //   204: invokevirtual 264	com/tencent/mobileqq/troop/widget/RadaScanView$WorkHandler:removeMessages	(I)V
    //   207: aload_0
    //   208: getfield 109	com/tencent/mobileqq/troop/widget/RadaScanView:jdField_a_of_type_ComTencentMobileqqTroopWidgetRadaScanView$WorkHandler	Lcom/tencent/mobileqq/troop/widget/RadaScanView$WorkHandler;
    //   211: iconst_1
    //   212: invokevirtual 268	com/tencent/mobileqq/troop/widget/RadaScanView$WorkHandler:sendEmptyMessage	(I)Z
    //   215: pop
    //   216: return
    //   217: astore_2
    //   218: aload_2
    //   219: invokevirtual 271	java/lang/Exception:printStackTrace	()V
    //   222: invokestatic 236	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   225: ifeq +32 -> 257
    //   228: ldc 10
    //   230: iconst_2
    //   231: new 242	java/lang/StringBuilder
    //   234: dup
    //   235: invokespecial 243	java/lang/StringBuilder:<init>	()V
    //   238: ldc_w 273
    //   241: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: aload_2
    //   245: invokevirtual 274	java/lang/Exception:toString	()Ljava/lang/String;
    //   248: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: invokevirtual 258	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   254: invokestatic 276	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   257: aload_1
    //   258: ifnull +94 -> 352
    //   261: iconst_1
    //   262: istore 11
    //   264: iload 11
    //   266: istore 12
    //   268: iload 11
    //   270: ifeq +21 -> 291
    //   273: iload 11
    //   275: istore 12
    //   277: getstatic 219	android/os/Build$VERSION:SDK_INT	I
    //   280: bipush 17
    //   282: if_icmpeq +9 -> 291
    //   285: aload_3
    //   286: invokevirtual 210	android/view/Surface:isValid	()Z
    //   289: istore 12
    //   291: aload_0
    //   292: ldc_w 278
    //   295: aload_2
    //   296: invokevirtual 274	java/lang/Exception:toString	()Ljava/lang/String;
    //   299: new 242	java/lang/StringBuilder
    //   302: dup
    //   303: invokespecial 243	java/lang/StringBuilder:<init>	()V
    //   306: aload_0
    //   307: getfield 204	com/tencent/mobileqq/troop/widget/RadaScanView:jdField_a_of_type_Boolean	Z
    //   310: invokevirtual 281	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   313: ldc_w 283
    //   316: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   319: aload_0
    //   320: getfield 231	com/tencent/mobileqq/troop/widget/RadaScanView:jdField_a_of_type_Long	J
    //   323: invokevirtual 252	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   326: ldc_w 283
    //   329: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   332: iload 12
    //   334: invokevirtual 281	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   337: invokevirtual 258	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   340: invokevirtual 286	com/tencent/mobileqq/troop/widget/RadaScanView:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   343: return
    //   344: astore_2
    //   345: aload_2
    //   346: invokevirtual 287	java/lang/InterruptedException:printStackTrace	()V
    //   349: goto -230 -> 119
    //   352: iconst_0
    //   353: istore 11
    //   355: goto -91 -> 264
    //   358: aload_1
    //   359: iconst_0
    //   360: getstatic 293	android/graphics/PorterDuff$Mode:CLEAR	Landroid/graphics/PorterDuff$Mode;
    //   363: invokevirtual 299	android/graphics/Canvas:drawColor	(ILandroid/graphics/PorterDuff$Mode;)V
    //   366: aload_0
    //   367: aload_1
    //   368: invokevirtual 301	com/tencent/mobileqq/troop/widget/RadaScanView:a	(Landroid/graphics/Canvas;)V
    //   371: aload_0
    //   372: aload_1
    //   373: invokevirtual 303	com/tencent/mobileqq/troop/widget/RadaScanView:b	(Landroid/graphics/Canvas;)V
    //   376: aload_0
    //   377: aload_1
    //   378: invokevirtual 305	com/tencent/mobileqq/troop/widget/RadaScanView:c	(Landroid/graphics/Canvas;)V
    //   381: aload_0
    //   382: aload_1
    //   383: invokevirtual 307	com/tencent/mobileqq/troop/widget/RadaScanView:d	(Landroid/graphics/Canvas;)V
    //   386: aload_1
    //   387: ifnull -331 -> 56
    //   390: iconst_1
    //   391: istore 11
    //   393: getstatic 219	android/os/Build$VERSION:SDK_INT	I
    //   396: bipush 17
    //   398: if_icmpeq +9 -> 407
    //   401: aload_3
    //   402: invokevirtual 210	android/view/Surface:isValid	()Z
    //   405: istore 11
    //   407: iload 11
    //   409: ifeq -353 -> 56
    //   412: aload_0
    //   413: getfield 74	com/tencent/mobileqq/troop/widget/RadaScanView:jdField_a_of_type_AndroidViewSurfaceHolder	Landroid/view/SurfaceHolder;
    //   416: aload_1
    //   417: invokeinterface 223 2 0
    //   422: invokestatic 198	java/lang/System:currentTimeMillis	()J
    //   425: lstore 7
    //   427: lload 7
    //   429: lload 5
    //   431: lsub
    //   432: lstore 7
    //   434: lload 7
    //   436: ldc2_w 13
    //   439: lcmp
    //   440: ifge +12 -> 452
    //   443: ldc2_w 13
    //   446: lload 7
    //   448: lsub
    //   449: invokestatic 229	java/lang/Thread:sleep	(J)V
    //   452: aload_0
    //   453: aload_0
    //   454: getfield 231	com/tencent/mobileqq/troop/widget/RadaScanView:jdField_a_of_type_Long	J
    //   457: lconst_1
    //   458: ladd
    //   459: putfield 231	com/tencent/mobileqq/troop/widget/RadaScanView:jdField_a_of_type_Long	J
    //   462: invokestatic 236	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   465: ifeq +60 -> 525
    //   468: invokestatic 198	java/lang/System:currentTimeMillis	()J
    //   471: lstore 9
    //   473: aload_0
    //   474: getfield 231	com/tencent/mobileqq/troop/widget/RadaScanView:jdField_a_of_type_Long	J
    //   477: ldc2_w 237
    //   480: lrem
    //   481: lconst_0
    //   482: lcmp
    //   483: ifne +42 -> 525
    //   486: ldc -16
    //   488: iconst_2
    //   489: new 242	java/lang/StringBuilder
    //   492: dup
    //   493: invokespecial 243	java/lang/StringBuilder:<init>	()V
    //   496: ldc -11
    //   498: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   501: lload 7
    //   503: invokevirtual 252	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   506: ldc -2
    //   508: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   511: lload 9
    //   513: lload 5
    //   515: lsub
    //   516: invokevirtual 252	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   519: invokevirtual 258	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   522: invokestatic 261	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   525: aload_0
    //   526: getfield 204	com/tencent/mobileqq/troop/widget/RadaScanView:jdField_a_of_type_Boolean	Z
    //   529: ifne -473 -> 56
    //   532: aload_0
    //   533: getfield 109	com/tencent/mobileqq/troop/widget/RadaScanView:jdField_a_of_type_ComTencentMobileqqTroopWidgetRadaScanView$WorkHandler	Lcom/tencent/mobileqq/troop/widget/RadaScanView$WorkHandler;
    //   536: iconst_1
    //   537: invokevirtual 264	com/tencent/mobileqq/troop/widget/RadaScanView$WorkHandler:removeMessages	(I)V
    //   540: aload_0
    //   541: getfield 109	com/tencent/mobileqq/troop/widget/RadaScanView:jdField_a_of_type_ComTencentMobileqqTroopWidgetRadaScanView$WorkHandler	Lcom/tencent/mobileqq/troop/widget/RadaScanView$WorkHandler;
    //   544: iconst_1
    //   545: invokevirtual 268	com/tencent/mobileqq/troop/widget/RadaScanView$WorkHandler:sendEmptyMessage	(I)Z
    //   548: pop
    //   549: return
    //   550: astore_2
    //   551: aload_2
    //   552: invokevirtual 271	java/lang/Exception:printStackTrace	()V
    //   555: invokestatic 236	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   558: ifeq +32 -> 590
    //   561: ldc 10
    //   563: iconst_2
    //   564: new 242	java/lang/StringBuilder
    //   567: dup
    //   568: invokespecial 243	java/lang/StringBuilder:<init>	()V
    //   571: ldc_w 273
    //   574: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   577: aload_2
    //   578: invokevirtual 274	java/lang/Exception:toString	()Ljava/lang/String;
    //   581: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   584: invokevirtual 258	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   587: invokestatic 276	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   590: aload_1
    //   591: ifnull +94 -> 685
    //   594: iconst_1
    //   595: istore 11
    //   597: iload 11
    //   599: istore 12
    //   601: iload 11
    //   603: ifeq +21 -> 624
    //   606: iload 11
    //   608: istore 12
    //   610: getstatic 219	android/os/Build$VERSION:SDK_INT	I
    //   613: bipush 17
    //   615: if_icmpeq +9 -> 624
    //   618: aload_3
    //   619: invokevirtual 210	android/view/Surface:isValid	()Z
    //   622: istore 12
    //   624: aload_0
    //   625: ldc_w 278
    //   628: aload_2
    //   629: invokevirtual 274	java/lang/Exception:toString	()Ljava/lang/String;
    //   632: new 242	java/lang/StringBuilder
    //   635: dup
    //   636: invokespecial 243	java/lang/StringBuilder:<init>	()V
    //   639: aload_0
    //   640: getfield 204	com/tencent/mobileqq/troop/widget/RadaScanView:jdField_a_of_type_Boolean	Z
    //   643: invokevirtual 281	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   646: ldc_w 283
    //   649: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   652: aload_0
    //   653: getfield 231	com/tencent/mobileqq/troop/widget/RadaScanView:jdField_a_of_type_Long	J
    //   656: invokevirtual 252	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   659: ldc_w 283
    //   662: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   665: iload 12
    //   667: invokevirtual 281	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   670: invokevirtual 258	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   673: invokevirtual 286	com/tencent/mobileqq/troop/widget/RadaScanView:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   676: return
    //   677: astore_2
    //   678: aload_2
    //   679: invokevirtual 287	java/lang/InterruptedException:printStackTrace	()V
    //   682: goto -230 -> 452
    //   685: iconst_0
    //   686: istore 11
    //   688: goto -91 -> 597
    //   691: astore_2
    //   692: aload_2
    //   693: invokevirtual 271	java/lang/Exception:printStackTrace	()V
    //   696: invokestatic 236	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   699: ifeq +32 -> 731
    //   702: ldc 10
    //   704: iconst_2
    //   705: new 242	java/lang/StringBuilder
    //   708: dup
    //   709: invokespecial 243	java/lang/StringBuilder:<init>	()V
    //   712: ldc_w 309
    //   715: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   718: aload_2
    //   719: invokevirtual 274	java/lang/Exception:toString	()Ljava/lang/String;
    //   722: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   725: invokevirtual 258	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   728: invokestatic 276	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   731: aload_0
    //   732: ldc_w 311
    //   735: aload_2
    //   736: invokevirtual 274	java/lang/Exception:toString	()Ljava/lang/String;
    //   739: new 242	java/lang/StringBuilder
    //   742: dup
    //   743: invokespecial 243	java/lang/StringBuilder:<init>	()V
    //   746: aload_0
    //   747: getfield 204	com/tencent/mobileqq/troop/widget/RadaScanView:jdField_a_of_type_Boolean	Z
    //   750: invokevirtual 281	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   753: ldc_w 283
    //   756: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   759: aload_0
    //   760: getfield 231	com/tencent/mobileqq/troop/widget/RadaScanView:jdField_a_of_type_Long	J
    //   763: invokevirtual 252	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   766: invokevirtual 258	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   769: invokevirtual 286	com/tencent/mobileqq/troop/widget/RadaScanView:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   772: aload_1
    //   773: ifnull -717 -> 56
    //   776: iconst_1
    //   777: istore 11
    //   779: getstatic 219	android/os/Build$VERSION:SDK_INT	I
    //   782: bipush 17
    //   784: if_icmpeq +9 -> 793
    //   787: aload_3
    //   788: invokevirtual 210	android/view/Surface:isValid	()Z
    //   791: istore 11
    //   793: iload 11
    //   795: ifeq -739 -> 56
    //   798: aload_0
    //   799: getfield 74	com/tencent/mobileqq/troop/widget/RadaScanView:jdField_a_of_type_AndroidViewSurfaceHolder	Landroid/view/SurfaceHolder;
    //   802: aload_1
    //   803: invokeinterface 223 2 0
    //   808: invokestatic 198	java/lang/System:currentTimeMillis	()J
    //   811: lstore 7
    //   813: lload 7
    //   815: lload 5
    //   817: lsub
    //   818: lstore 7
    //   820: lload 7
    //   822: ldc2_w 13
    //   825: lcmp
    //   826: ifge +12 -> 838
    //   829: ldc2_w 13
    //   832: lload 7
    //   834: lsub
    //   835: invokestatic 229	java/lang/Thread:sleep	(J)V
    //   838: aload_0
    //   839: aload_0
    //   840: getfield 231	com/tencent/mobileqq/troop/widget/RadaScanView:jdField_a_of_type_Long	J
    //   843: lconst_1
    //   844: ladd
    //   845: putfield 231	com/tencent/mobileqq/troop/widget/RadaScanView:jdField_a_of_type_Long	J
    //   848: invokestatic 236	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   851: ifeq +60 -> 911
    //   854: invokestatic 198	java/lang/System:currentTimeMillis	()J
    //   857: lstore 9
    //   859: aload_0
    //   860: getfield 231	com/tencent/mobileqq/troop/widget/RadaScanView:jdField_a_of_type_Long	J
    //   863: ldc2_w 237
    //   866: lrem
    //   867: lconst_0
    //   868: lcmp
    //   869: ifne +42 -> 911
    //   872: ldc -16
    //   874: iconst_2
    //   875: new 242	java/lang/StringBuilder
    //   878: dup
    //   879: invokespecial 243	java/lang/StringBuilder:<init>	()V
    //   882: ldc -11
    //   884: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   887: lload 7
    //   889: invokevirtual 252	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   892: ldc -2
    //   894: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   897: lload 9
    //   899: lload 5
    //   901: lsub
    //   902: invokevirtual 252	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   905: invokevirtual 258	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   908: invokestatic 261	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   911: aload_0
    //   912: getfield 204	com/tencent/mobileqq/troop/widget/RadaScanView:jdField_a_of_type_Boolean	Z
    //   915: ifne -859 -> 56
    //   918: aload_0
    //   919: getfield 109	com/tencent/mobileqq/troop/widget/RadaScanView:jdField_a_of_type_ComTencentMobileqqTroopWidgetRadaScanView$WorkHandler	Lcom/tencent/mobileqq/troop/widget/RadaScanView$WorkHandler;
    //   922: iconst_1
    //   923: invokevirtual 264	com/tencent/mobileqq/troop/widget/RadaScanView$WorkHandler:removeMessages	(I)V
    //   926: aload_0
    //   927: getfield 109	com/tencent/mobileqq/troop/widget/RadaScanView:jdField_a_of_type_ComTencentMobileqqTroopWidgetRadaScanView$WorkHandler	Lcom/tencent/mobileqq/troop/widget/RadaScanView$WorkHandler;
    //   930: iconst_1
    //   931: invokevirtual 268	com/tencent/mobileqq/troop/widget/RadaScanView$WorkHandler:sendEmptyMessage	(I)Z
    //   934: pop
    //   935: return
    //   936: astore_2
    //   937: aload_2
    //   938: invokevirtual 271	java/lang/Exception:printStackTrace	()V
    //   941: invokestatic 236	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   944: ifeq +32 -> 976
    //   947: ldc 10
    //   949: iconst_2
    //   950: new 242	java/lang/StringBuilder
    //   953: dup
    //   954: invokespecial 243	java/lang/StringBuilder:<init>	()V
    //   957: ldc_w 273
    //   960: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   963: aload_2
    //   964: invokevirtual 274	java/lang/Exception:toString	()Ljava/lang/String;
    //   967: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   970: invokevirtual 258	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   973: invokestatic 276	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   976: aload_1
    //   977: ifnull +94 -> 1071
    //   980: iconst_1
    //   981: istore 11
    //   983: iload 11
    //   985: istore 12
    //   987: iload 11
    //   989: ifeq +21 -> 1010
    //   992: iload 11
    //   994: istore 12
    //   996: getstatic 219	android/os/Build$VERSION:SDK_INT	I
    //   999: bipush 17
    //   1001: if_icmpeq +9 -> 1010
    //   1004: aload_3
    //   1005: invokevirtual 210	android/view/Surface:isValid	()Z
    //   1008: istore 12
    //   1010: aload_0
    //   1011: ldc_w 278
    //   1014: aload_2
    //   1015: invokevirtual 274	java/lang/Exception:toString	()Ljava/lang/String;
    //   1018: new 242	java/lang/StringBuilder
    //   1021: dup
    //   1022: invokespecial 243	java/lang/StringBuilder:<init>	()V
    //   1025: aload_0
    //   1026: getfield 204	com/tencent/mobileqq/troop/widget/RadaScanView:jdField_a_of_type_Boolean	Z
    //   1029: invokevirtual 281	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1032: ldc_w 283
    //   1035: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1038: aload_0
    //   1039: getfield 231	com/tencent/mobileqq/troop/widget/RadaScanView:jdField_a_of_type_Long	J
    //   1042: invokevirtual 252	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1045: ldc_w 283
    //   1048: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1051: iload 12
    //   1053: invokevirtual 281	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1056: invokevirtual 258	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1059: invokevirtual 286	com/tencent/mobileqq/troop/widget/RadaScanView:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1062: return
    //   1063: astore_2
    //   1064: aload_2
    //   1065: invokevirtual 287	java/lang/InterruptedException:printStackTrace	()V
    //   1068: goto -230 -> 838
    //   1071: iconst_0
    //   1072: istore 11
    //   1074: goto -91 -> 983
    //   1077: astore_2
    //   1078: aconst_null
    //   1079: astore_1
    //   1080: aload_1
    //   1081: ifnull -1025 -> 56
    //   1084: iconst_1
    //   1085: istore 11
    //   1087: getstatic 219	android/os/Build$VERSION:SDK_INT	I
    //   1090: bipush 17
    //   1092: if_icmpeq +9 -> 1101
    //   1095: aload_3
    //   1096: invokevirtual 210	android/view/Surface:isValid	()Z
    //   1099: istore 11
    //   1101: iload 11
    //   1103: ifeq +140 -> 1243
    //   1106: aload_0
    //   1107: getfield 74	com/tencent/mobileqq/troop/widget/RadaScanView:jdField_a_of_type_AndroidViewSurfaceHolder	Landroid/view/SurfaceHolder;
    //   1110: aload_1
    //   1111: invokeinterface 223 2 0
    //   1116: invokestatic 198	java/lang/System:currentTimeMillis	()J
    //   1119: lstore 7
    //   1121: lload 7
    //   1123: lload 5
    //   1125: lsub
    //   1126: lstore 7
    //   1128: lload 7
    //   1130: ldc2_w 13
    //   1133: lcmp
    //   1134: ifge +12 -> 1146
    //   1137: ldc2_w 13
    //   1140: lload 7
    //   1142: lsub
    //   1143: invokestatic 229	java/lang/Thread:sleep	(J)V
    //   1146: aload_0
    //   1147: aload_0
    //   1148: getfield 231	com/tencent/mobileqq/troop/widget/RadaScanView:jdField_a_of_type_Long	J
    //   1151: lconst_1
    //   1152: ladd
    //   1153: putfield 231	com/tencent/mobileqq/troop/widget/RadaScanView:jdField_a_of_type_Long	J
    //   1156: invokestatic 236	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1159: ifeq +60 -> 1219
    //   1162: invokestatic 198	java/lang/System:currentTimeMillis	()J
    //   1165: lstore 9
    //   1167: aload_0
    //   1168: getfield 231	com/tencent/mobileqq/troop/widget/RadaScanView:jdField_a_of_type_Long	J
    //   1171: ldc2_w 237
    //   1174: lrem
    //   1175: lconst_0
    //   1176: lcmp
    //   1177: ifne +42 -> 1219
    //   1180: ldc -16
    //   1182: iconst_2
    //   1183: new 242	java/lang/StringBuilder
    //   1186: dup
    //   1187: invokespecial 243	java/lang/StringBuilder:<init>	()V
    //   1190: ldc -11
    //   1192: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1195: lload 7
    //   1197: invokevirtual 252	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1200: ldc -2
    //   1202: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1205: lload 9
    //   1207: lload 5
    //   1209: lsub
    //   1210: invokevirtual 252	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1213: invokevirtual 258	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1216: invokestatic 261	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1219: aload_0
    //   1220: getfield 204	com/tencent/mobileqq/troop/widget/RadaScanView:jdField_a_of_type_Boolean	Z
    //   1223: ifne +20 -> 1243
    //   1226: aload_0
    //   1227: getfield 109	com/tencent/mobileqq/troop/widget/RadaScanView:jdField_a_of_type_ComTencentMobileqqTroopWidgetRadaScanView$WorkHandler	Lcom/tencent/mobileqq/troop/widget/RadaScanView$WorkHandler;
    //   1230: iconst_1
    //   1231: invokevirtual 264	com/tencent/mobileqq/troop/widget/RadaScanView$WorkHandler:removeMessages	(I)V
    //   1234: aload_0
    //   1235: getfield 109	com/tencent/mobileqq/troop/widget/RadaScanView:jdField_a_of_type_ComTencentMobileqqTroopWidgetRadaScanView$WorkHandler	Lcom/tencent/mobileqq/troop/widget/RadaScanView$WorkHandler;
    //   1238: iconst_1
    //   1239: invokevirtual 268	com/tencent/mobileqq/troop/widget/RadaScanView$WorkHandler:sendEmptyMessage	(I)Z
    //   1242: pop
    //   1243: aload_2
    //   1244: athrow
    //   1245: astore 4
    //   1247: aload 4
    //   1249: invokevirtual 287	java/lang/InterruptedException:printStackTrace	()V
    //   1252: goto -106 -> 1146
    //   1255: astore 4
    //   1257: aload 4
    //   1259: invokevirtual 271	java/lang/Exception:printStackTrace	()V
    //   1262: invokestatic 236	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1265: ifeq +33 -> 1298
    //   1268: ldc 10
    //   1270: iconst_2
    //   1271: new 242	java/lang/StringBuilder
    //   1274: dup
    //   1275: invokespecial 243	java/lang/StringBuilder:<init>	()V
    //   1278: ldc_w 273
    //   1281: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1284: aload 4
    //   1286: invokevirtual 274	java/lang/Exception:toString	()Ljava/lang/String;
    //   1289: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1292: invokevirtual 258	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1295: invokestatic 276	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1298: aload_1
    //   1299: ifnull +89 -> 1388
    //   1302: iconst_1
    //   1303: istore 11
    //   1305: iload 11
    //   1307: istore 12
    //   1309: iload 11
    //   1311: ifeq +21 -> 1332
    //   1314: iload 11
    //   1316: istore 12
    //   1318: getstatic 219	android/os/Build$VERSION:SDK_INT	I
    //   1321: bipush 17
    //   1323: if_icmpeq +9 -> 1332
    //   1326: aload_3
    //   1327: invokevirtual 210	android/view/Surface:isValid	()Z
    //   1330: istore 12
    //   1332: aload_0
    //   1333: ldc_w 278
    //   1336: aload 4
    //   1338: invokevirtual 274	java/lang/Exception:toString	()Ljava/lang/String;
    //   1341: new 242	java/lang/StringBuilder
    //   1344: dup
    //   1345: invokespecial 243	java/lang/StringBuilder:<init>	()V
    //   1348: aload_0
    //   1349: getfield 204	com/tencent/mobileqq/troop/widget/RadaScanView:jdField_a_of_type_Boolean	Z
    //   1352: invokevirtual 281	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1355: ldc_w 283
    //   1358: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1361: aload_0
    //   1362: getfield 231	com/tencent/mobileqq/troop/widget/RadaScanView:jdField_a_of_type_Long	J
    //   1365: invokevirtual 252	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1368: ldc_w 283
    //   1371: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1374: iload 12
    //   1376: invokevirtual 281	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1379: invokevirtual 258	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1382: invokevirtual 286	com/tencent/mobileqq/troop/widget/RadaScanView:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1385: goto -142 -> 1243
    //   1388: iconst_0
    //   1389: istore 11
    //   1391: goto -86 -> 1305
    //   1394: astore_2
    //   1395: goto -315 -> 1080
    //   1398: astore_2
    //   1399: goto -319 -> 1080
    //   1402: astore_2
    //   1403: goto -711 -> 692
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1406	0	this	RadaScanView
    //   34	1265	1	localObject1	Object
    //   45	2	2	localCanvas	Canvas
    //   217	79	2	localException1	Exception
    //   344	2	2	localInterruptedException1	InterruptedException
    //   550	79	2	localException2	Exception
    //   677	2	2	localInterruptedException2	InterruptedException
    //   691	45	2	localException3	Exception
    //   936	79	2	localException4	Exception
    //   1063	2	2	localInterruptedException3	InterruptedException
    //   1077	167	2	localObject2	Object
    //   1394	1	2	localObject3	Object
    //   1398	1	2	localObject4	Object
    //   1402	1	2	localException5	Exception
    //   14	1313	3	localSurface	android.view.Surface
    //   1245	3	4	localInterruptedException4	InterruptedException
    //   1255	82	4	localException6	Exception
    //   3	1205	5	l1	long
    //   92	1104	7	l2	long
    //   138	1068	9	l3	long
    //   58	1332	11	bool1	boolean
    //   266	1109	12	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   60	74	217	java/lang/Exception
    //   79	94	217	java/lang/Exception
    //   110	119	217	java/lang/Exception
    //   119	192	217	java/lang/Exception
    //   192	216	217	java/lang/Exception
    //   345	349	217	java/lang/Exception
    //   110	119	344	java/lang/InterruptedException
    //   393	407	550	java/lang/Exception
    //   412	427	550	java/lang/Exception
    //   443	452	550	java/lang/Exception
    //   452	525	550	java/lang/Exception
    //   525	549	550	java/lang/Exception
    //   678	682	550	java/lang/Exception
    //   443	452	677	java/lang/InterruptedException
    //   35	46	691	java/lang/Exception
    //   779	793	936	java/lang/Exception
    //   798	813	936	java/lang/Exception
    //   829	838	936	java/lang/Exception
    //   838	911	936	java/lang/Exception
    //   911	935	936	java/lang/Exception
    //   1064	1068	936	java/lang/Exception
    //   829	838	1063	java/lang/InterruptedException
    //   35	46	1077	finally
    //   1137	1146	1245	java/lang/InterruptedException
    //   1087	1101	1255	java/lang/Exception
    //   1106	1121	1255	java/lang/Exception
    //   1137	1146	1255	java/lang/Exception
    //   1146	1219	1255	java/lang/Exception
    //   1219	1243	1255	java/lang/Exception
    //   1247	1252	1255	java/lang/Exception
    //   358	386	1394	finally
    //   692	731	1398	finally
    //   731	772	1398	finally
    //   358	386	1402	java/lang/Exception
  }
  
  protected void a(Canvas paramCanvas)
  {
    long l1;
    if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
      l1 = System.currentTimeMillis();
    }
    try
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeResource(getResources(), 2130840183);
      if (QLog.isColorLevel()) {
        QLog.d("RadaScanView", 2, "drawRadaScan->initBmp:" + (System.currentTimeMillis() - l1));
      }
      if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
      {
        paramCanvas.save();
        paramCanvas.rotate(this.jdField_a_of_type_Float, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
        this.jdField_a_of_type_Float = ((float)(this.jdField_a_of_type_Float + 1.8D));
        paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, null, this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
        paramCanvas.restore();
        if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRadaScanView$OnScanDegreeChangeListener != null) {
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRadaScanView$OnScanDegreeChangeListener.a(this.jdField_a_of_type_Float);
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        this.jdField_a_of_type_AndroidGraphicsBitmap = null;
        if (QLog.isColorLevel()) {
          QLog.e("RadaScanView", 2, "drawRadaScan->initBmp:" + localThrowable.toString());
        }
      }
    }
  }
  
  protected void a(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      paramString3 = new StringBuilder(paramString3);
      paramString3.append("_");
      paramString3.append(this.i);
      paramString3.append("_");
      paramString3.append(this.h);
      paramString3.append("_");
      paramString3.append(this.j);
      paramString3 = paramString3.toString();
      String str1 = Build.MODEL + "_" + Build.VERSION.SDK_INT + "_" + "6.5.5.2880";
      String str2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().substring(0, 5);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "BizTechReport", "", "RadarScanView", paramString1, 0, 0, str1, str2, paramString2, paramString3);
      if (QLog.isColorLevel()) {
        QLog.e("RadaScanView", 2, "reportException:" + paramString1 + "," + str1 + "," + paramString2 + "," + paramString3);
      }
      return;
    }
    catch (Exception paramString1)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("RadaScanView", 2, "reportException:" + paramString1.toString());
    }
  }
  
  public void a(boolean paramBoolean, HashSet paramHashSet, Map paramMap)
  {
    boolean bool = true;
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        this.jdField_c_of_type_Boolean = paramBoolean;
        if (this.jdField_c_of_type_Boolean) {
          this.jdField_a_of_type_AndroidWidgetScroller.abortAnimation();
        }
        this.jdField_b_of_type_Boolean = paramHashSet.contains(Long.valueOf(this.jdField_c_of_type_Long));
        this.jdField_a_of_type_AndroidGraphicsPoint = ((Point)paramMap.get(Long.valueOf(this.jdField_c_of_type_Long)));
        if (paramHashSet.contains(Long.valueOf(this.jdField_d_of_type_Long)))
        {
          this.jdField_b_of_type_AndroidGraphicsPoint = ((Point)paramMap.get(Long.valueOf(this.jdField_d_of_type_Long)));
          if (QLog.isColorLevel())
          {
            paramHashSet = new StringBuilder().append("onScaleChange:").append(paramBoolean).append(",");
            if (this.jdField_a_of_type_AndroidGraphicsPoint == null) {
              break label193;
            }
            paramBoolean = true;
            paramHashSet = paramHashSet.append(paramBoolean).append(",");
            if (this.jdField_b_of_type_AndroidGraphicsPoint == null) {
              break label198;
            }
            paramBoolean = bool;
            QLog.d("RadaScanView", 2, paramBoolean);
          }
        }
        else
        {
          this.jdField_b_of_type_AndroidGraphicsPoint = null;
        }
      }
      label193:
      paramBoolean = false;
      continue;
      label198:
      paramBoolean = false;
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRadaScanView$WorkHandler.removeMessages(1);
    if (Build.VERSION.SDK_INT == 18) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRadaScanView$WorkHandler.sendEmptyMessageDelayed(1, 450L);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("RadaScanView", 2, "startDraw");
      }
      return;
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRadaScanView$WorkHandler.sendEmptyMessageDelayed(1, 150L);
    }
  }
  
  protected void b(Canvas paramCanvas)
  {
    if (this.jdField_b_of_type_AndroidGraphicsBitmap != null)
    {
      paramCanvas.drawBitmap(this.jdField_b_of_type_AndroidGraphicsBitmap, null, this.jdField_b_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-16777216);
      paramCanvas.drawCircle(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 21.0F), this.jdField_b_of_type_AndroidGraphicsPaint);
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRadaScanView$WorkHandler.removeMessages(1);
    if (QLog.isColorLevel()) {
      QLog.i("RadaScanView", 2, "stopDraw");
    }
  }
  
  public void c(Canvas paramCanvas)
  {
    boolean bool2 = false;
    float f2 = 0.0F;
    label539:
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (this.jdField_a_of_type_AndroidWidgetScroller.computeScrollOffset())
        {
          this.k = this.jdField_a_of_type_AndroidWidgetScroller.getCurrX();
          this.l = (this.m - this.jdField_a_of_type_AndroidWidgetScroller.getCurrX());
        }
        if ((this.jdField_c_of_type_AndroidGraphicsBitmap != null) && (this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_AndroidGraphicsPoint != null))
        {
          this.jdField_c_of_type_AndroidGraphicsRect.set(this.jdField_a_of_type_AndroidGraphicsPoint.x - this.k, this.jdField_a_of_type_AndroidGraphicsPoint.y - this.k, this.jdField_a_of_type_AndroidGraphicsPoint.x + this.k, this.jdField_a_of_type_AndroidGraphicsPoint.y + this.k);
          float f3 = this.k * 1.0F / this.m;
          float f1 = f3;
          if (f3 < 0.2F) {
            f1 = 0.0F;
          }
          this.jdField_d_of_type_AndroidGraphicsPaint.setAlpha((int)(f1 * 255.0F));
          this.jdField_c_of_type_AndroidGraphicsPaint.setAlpha((int)(f1 * 90.0F));
          paramCanvas.drawBitmap(this.jdField_c_of_type_AndroidGraphicsBitmap, null, this.jdField_c_of_type_AndroidGraphicsRect, this.jdField_d_of_type_AndroidGraphicsPaint);
          paramCanvas.drawCircle(this.jdField_a_of_type_AndroidGraphicsPoint.x, this.jdField_a_of_type_AndroidGraphicsPoint.y, this.k, this.jdField_c_of_type_AndroidGraphicsPaint);
          if ((this.l > 0) && (this.jdField_b_of_type_AndroidGraphicsPoint != null) && (this.jdField_d_of_type_AndroidGraphicsBitmap != null) && (this.jdField_b_of_type_Boolean))
          {
            this.jdField_c_of_type_AndroidGraphicsRect.set(this.jdField_b_of_type_AndroidGraphicsPoint.x - this.l, this.jdField_b_of_type_AndroidGraphicsPoint.y - this.l, this.jdField_b_of_type_AndroidGraphicsPoint.x + this.l, this.jdField_b_of_type_AndroidGraphicsPoint.y + this.l);
            f1 = this.l * 1.0F / this.m;
            if (f1 >= 0.2F) {
              break label539;
            }
            f1 = f2;
            this.jdField_d_of_type_AndroidGraphicsPaint.setAlpha((int)(f1 * 255.0F));
            this.jdField_c_of_type_AndroidGraphicsPaint.setAlpha((int)(f1 * 90.0F));
            paramCanvas.drawBitmap(this.jdField_d_of_type_AndroidGraphicsBitmap, null, this.jdField_c_of_type_AndroidGraphicsRect, this.jdField_d_of_type_AndroidGraphicsPaint);
            paramCanvas.drawCircle(this.jdField_b_of_type_AndroidGraphicsPoint.x, this.jdField_b_of_type_AndroidGraphicsPoint.y, this.l, this.jdField_c_of_type_AndroidGraphicsPaint);
          }
          return;
        }
        if ((!QLog.isColorLevel()) || (this.jdField_c_of_type_Long == 0L)) {
          continue;
        }
        StringBuilder localStringBuilder = new StringBuilder().append("drawSelectionFace:");
        if (this.jdField_c_of_type_AndroidGraphicsBitmap != null)
        {
          bool1 = true;
          localStringBuilder = localStringBuilder.append(bool1).append(",").append(this.jdField_b_of_type_Boolean).append(",").append(this.jdField_a_of_type_AndroidWidgetScroller.isFinished()).append(", ");
          bool1 = bool2;
          if (this.jdField_a_of_type_AndroidGraphicsPoint != null) {
            bool1 = true;
          }
          QLog.d("RadaScanView", 2, bool1);
        }
      }
      boolean bool1 = false;
    }
  }
  
  protected void d()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRadaScanView$WorkHandler.removeMessages(1);
    this.jdField_a_of_type_AndroidOsHandlerThread.quit();
    if (QLog.isColorLevel()) {
      QLog.i("RadaScanView", 2, "destroy");
    }
  }
  
  /* Error */
  protected void d(Canvas paramCanvas)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 508	com/tencent/mobileqq/troop/widget/RadaScanView:jdField_a_of_type_ArrayOfAndroidGraphicsBitmap	[Landroid/graphics/Bitmap;
    //   4: ifnonnull +218 -> 222
    //   7: invokestatic 198	java/lang/System:currentTimeMillis	()J
    //   10: lstore 4
    //   12: aload_0
    //   13: bipush 10
    //   15: anewarray 510	android/graphics/Bitmap
    //   18: putfield 508	com/tencent/mobileqq/troop/widget/RadaScanView:jdField_a_of_type_ArrayOfAndroidGraphicsBitmap	[Landroid/graphics/Bitmap;
    //   21: aload_0
    //   22: getfield 508	com/tencent/mobileqq/troop/widget/RadaScanView:jdField_a_of_type_ArrayOfAndroidGraphicsBitmap	[Landroid/graphics/Bitmap;
    //   25: iconst_0
    //   26: aload_0
    //   27: invokevirtual 319	com/tencent/mobileqq/troop/widget/RadaScanView:getResources	()Landroid/content/res/Resources;
    //   30: ldc_w 511
    //   33: invokestatic 326	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   36: aastore
    //   37: aload_0
    //   38: getfield 508	com/tencent/mobileqq/troop/widget/RadaScanView:jdField_a_of_type_ArrayOfAndroidGraphicsBitmap	[Landroid/graphics/Bitmap;
    //   41: iconst_1
    //   42: aload_0
    //   43: invokevirtual 319	com/tencent/mobileqq/troop/widget/RadaScanView:getResources	()Landroid/content/res/Resources;
    //   46: ldc_w 512
    //   49: invokestatic 326	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   52: aastore
    //   53: aload_0
    //   54: getfield 508	com/tencent/mobileqq/troop/widget/RadaScanView:jdField_a_of_type_ArrayOfAndroidGraphicsBitmap	[Landroid/graphics/Bitmap;
    //   57: iconst_2
    //   58: aload_0
    //   59: invokevirtual 319	com/tencent/mobileqq/troop/widget/RadaScanView:getResources	()Landroid/content/res/Resources;
    //   62: ldc_w 513
    //   65: invokestatic 326	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   68: aastore
    //   69: aload_0
    //   70: getfield 508	com/tencent/mobileqq/troop/widget/RadaScanView:jdField_a_of_type_ArrayOfAndroidGraphicsBitmap	[Landroid/graphics/Bitmap;
    //   73: iconst_3
    //   74: aload_0
    //   75: invokevirtual 319	com/tencent/mobileqq/troop/widget/RadaScanView:getResources	()Landroid/content/res/Resources;
    //   78: ldc_w 514
    //   81: invokestatic 326	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   84: aastore
    //   85: aload_0
    //   86: getfield 508	com/tencent/mobileqq/troop/widget/RadaScanView:jdField_a_of_type_ArrayOfAndroidGraphicsBitmap	[Landroid/graphics/Bitmap;
    //   89: iconst_4
    //   90: aload_0
    //   91: invokevirtual 319	com/tencent/mobileqq/troop/widget/RadaScanView:getResources	()Landroid/content/res/Resources;
    //   94: ldc_w 515
    //   97: invokestatic 326	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   100: aastore
    //   101: aload_0
    //   102: getfield 508	com/tencent/mobileqq/troop/widget/RadaScanView:jdField_a_of_type_ArrayOfAndroidGraphicsBitmap	[Landroid/graphics/Bitmap;
    //   105: iconst_5
    //   106: aload_0
    //   107: invokevirtual 319	com/tencent/mobileqq/troop/widget/RadaScanView:getResources	()Landroid/content/res/Resources;
    //   110: ldc_w 516
    //   113: invokestatic 326	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   116: aastore
    //   117: aload_0
    //   118: getfield 508	com/tencent/mobileqq/troop/widget/RadaScanView:jdField_a_of_type_ArrayOfAndroidGraphicsBitmap	[Landroid/graphics/Bitmap;
    //   121: bipush 6
    //   123: aload_0
    //   124: invokevirtual 319	com/tencent/mobileqq/troop/widget/RadaScanView:getResources	()Landroid/content/res/Resources;
    //   127: ldc_w 517
    //   130: invokestatic 326	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   133: aastore
    //   134: aload_0
    //   135: getfield 508	com/tencent/mobileqq/troop/widget/RadaScanView:jdField_a_of_type_ArrayOfAndroidGraphicsBitmap	[Landroid/graphics/Bitmap;
    //   138: bipush 7
    //   140: aload_0
    //   141: invokevirtual 319	com/tencent/mobileqq/troop/widget/RadaScanView:getResources	()Landroid/content/res/Resources;
    //   144: ldc_w 518
    //   147: invokestatic 326	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   150: aastore
    //   151: aload_0
    //   152: getfield 508	com/tencent/mobileqq/troop/widget/RadaScanView:jdField_a_of_type_ArrayOfAndroidGraphicsBitmap	[Landroid/graphics/Bitmap;
    //   155: bipush 8
    //   157: aload_0
    //   158: invokevirtual 319	com/tencent/mobileqq/troop/widget/RadaScanView:getResources	()Landroid/content/res/Resources;
    //   161: ldc_w 519
    //   164: invokestatic 326	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   167: aastore
    //   168: aload_0
    //   169: getfield 508	com/tencent/mobileqq/troop/widget/RadaScanView:jdField_a_of_type_ArrayOfAndroidGraphicsBitmap	[Landroid/graphics/Bitmap;
    //   172: bipush 9
    //   174: aload_0
    //   175: invokevirtual 319	com/tencent/mobileqq/troop/widget/RadaScanView:getResources	()Landroid/content/res/Resources;
    //   178: ldc_w 520
    //   181: invokestatic 326	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   184: aastore
    //   185: invokestatic 236	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   188: ifeq +34 -> 222
    //   191: ldc 10
    //   193: iconst_2
    //   194: new 242	java/lang/StringBuilder
    //   197: dup
    //   198: invokespecial 243	java/lang/StringBuilder:<init>	()V
    //   201: ldc_w 522
    //   204: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: invokestatic 198	java/lang/System:currentTimeMillis	()J
    //   210: lload 4
    //   212: lsub
    //   213: invokevirtual 252	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   216: invokevirtual 258	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   219: invokestatic 330	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   222: aload_0
    //   223: getfield 62	com/tencent/mobileqq/troop/widget/RadaScanView:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   226: astore_3
    //   227: aload_3
    //   228: monitorenter
    //   229: aload_0
    //   230: getfield 418	com/tencent/mobileqq/troop/widget/RadaScanView:jdField_c_of_type_Long	J
    //   233: lconst_0
    //   234: lcmp
    //   235: ifeq +310 -> 545
    //   238: aload_0
    //   239: getfield 432	com/tencent/mobileqq/troop/widget/RadaScanView:jdField_b_of_type_Boolean	Z
    //   242: ifne +303 -> 545
    //   245: aload_0
    //   246: getfield 524	com/tencent/mobileqq/troop/widget/RadaScanView:jdField_d_of_type_AndroidGraphicsRect	Landroid/graphics/Rect;
    //   249: ifnonnull +93 -> 342
    //   252: aload_0
    //   253: getfield 508	com/tencent/mobileqq/troop/widget/RadaScanView:jdField_a_of_type_ArrayOfAndroidGraphicsBitmap	[Landroid/graphics/Bitmap;
    //   256: iconst_0
    //   257: aaload
    //   258: ifnull +84 -> 342
    //   261: aload_0
    //   262: new 140	android/graphics/Rect
    //   265: dup
    //   266: aload_0
    //   267: getfield 338	com/tencent/mobileqq/troop/widget/RadaScanView:jdField_a_of_type_Int	I
    //   270: aload_0
    //   271: getfield 526	com/tencent/mobileqq/troop/widget/RadaScanView:g	I
    //   274: iadd
    //   275: aload_0
    //   276: getfield 528	com/tencent/mobileqq/troop/widget/RadaScanView:q	I
    //   279: iadd
    //   280: aload_0
    //   281: getfield 340	com/tencent/mobileqq/troop/widget/RadaScanView:jdField_b_of_type_Int	I
    //   284: aload_0
    //   285: getfield 508	com/tencent/mobileqq/troop/widget/RadaScanView:jdField_a_of_type_ArrayOfAndroidGraphicsBitmap	[Landroid/graphics/Bitmap;
    //   288: iconst_0
    //   289: aaload
    //   290: invokevirtual 531	android/graphics/Bitmap:getHeight	()I
    //   293: iconst_2
    //   294: idiv
    //   295: isub
    //   296: aload_0
    //   297: getfield 338	com/tencent/mobileqq/troop/widget/RadaScanView:jdField_a_of_type_Int	I
    //   300: aload_0
    //   301: getfield 526	com/tencent/mobileqq/troop/widget/RadaScanView:g	I
    //   304: iadd
    //   305: aload_0
    //   306: getfield 528	com/tencent/mobileqq/troop/widget/RadaScanView:q	I
    //   309: iadd
    //   310: aload_0
    //   311: getfield 508	com/tencent/mobileqq/troop/widget/RadaScanView:jdField_a_of_type_ArrayOfAndroidGraphicsBitmap	[Landroid/graphics/Bitmap;
    //   314: iconst_0
    //   315: aaload
    //   316: invokevirtual 534	android/graphics/Bitmap:getWidth	()I
    //   319: iadd
    //   320: aload_0
    //   321: getfield 340	com/tencent/mobileqq/troop/widget/RadaScanView:jdField_b_of_type_Int	I
    //   324: aload_0
    //   325: getfield 508	com/tencent/mobileqq/troop/widget/RadaScanView:jdField_a_of_type_ArrayOfAndroidGraphicsBitmap	[Landroid/graphics/Bitmap;
    //   328: iconst_0
    //   329: aaload
    //   330: invokevirtual 531	android/graphics/Bitmap:getHeight	()I
    //   333: iconst_2
    //   334: idiv
    //   335: iadd
    //   336: invokespecial 536	android/graphics/Rect:<init>	(IIII)V
    //   339: putfield 524	com/tencent/mobileqq/troop/widget/RadaScanView:jdField_d_of_type_AndroidGraphicsRect	Landroid/graphics/Rect;
    //   342: aload_0
    //   343: getfield 524	com/tencent/mobileqq/troop/widget/RadaScanView:jdField_d_of_type_AndroidGraphicsRect	Landroid/graphics/Rect;
    //   346: ifnonnull +50 -> 396
    //   349: aload_3
    //   350: monitorexit
    //   351: return
    //   352: astore_3
    //   353: aload_0
    //   354: aconst_null
    //   355: putfield 508	com/tencent/mobileqq/troop/widget/RadaScanView:jdField_a_of_type_ArrayOfAndroidGraphicsBitmap	[Landroid/graphics/Bitmap;
    //   358: invokestatic 236	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   361: ifeq -139 -> 222
    //   364: ldc 10
    //   366: iconst_2
    //   367: new 242	java/lang/StringBuilder
    //   370: dup
    //   371: invokespecial 243	java/lang/StringBuilder:<init>	()V
    //   374: ldc_w 522
    //   377: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   380: aload_3
    //   381: invokevirtual 364	java/lang/Throwable:toString	()Ljava/lang/String;
    //   384: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   387: invokevirtual 258	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   390: invokestatic 276	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   393: goto -171 -> 222
    //   396: aload_0
    //   397: getfield 508	com/tencent/mobileqq/troop/widget/RadaScanView:jdField_a_of_type_ArrayOfAndroidGraphicsBitmap	[Landroid/graphics/Bitmap;
    //   400: aload_0
    //   401: getfield 538	com/tencent/mobileqq/troop/widget/RadaScanView:o	I
    //   404: aaload
    //   405: ifnull +85 -> 490
    //   408: aload_0
    //   409: getfield 136	com/tencent/mobileqq/troop/widget/RadaScanView:jdField_a_of_type_AndroidGraphicsPoint	Landroid/graphics/Point;
    //   412: ifnull +78 -> 490
    //   415: aload_0
    //   416: getfield 136	com/tencent/mobileqq/troop/widget/RadaScanView:jdField_a_of_type_AndroidGraphicsPoint	Landroid/graphics/Point;
    //   419: getfield 481	android/graphics/Point:x	I
    //   422: aload_0
    //   423: getfield 338	com/tencent/mobileqq/troop/widget/RadaScanView:jdField_a_of_type_Int	I
    //   426: isub
    //   427: aload_0
    //   428: getfield 136	com/tencent/mobileqq/troop/widget/RadaScanView:jdField_a_of_type_AndroidGraphicsPoint	Landroid/graphics/Point;
    //   431: getfield 484	android/graphics/Point:y	I
    //   434: aload_0
    //   435: getfield 340	com/tencent/mobileqq/troop/widget/RadaScanView:jdField_b_of_type_Int	I
    //   438: isub
    //   439: invokestatic 543	com/tencent/mobileqq/troop/widget/RadarMembersView:a	(II)D
    //   442: d2f
    //   443: fstore_2
    //   444: aload_1
    //   445: invokevirtual 334	android/graphics/Canvas:save	()I
    //   448: pop
    //   449: aload_1
    //   450: fload_2
    //   451: aload_0
    //   452: getfield 338	com/tencent/mobileqq/troop/widget/RadaScanView:jdField_a_of_type_Int	I
    //   455: i2f
    //   456: aload_0
    //   457: getfield 340	com/tencent/mobileqq/troop/widget/RadaScanView:jdField_b_of_type_Int	I
    //   460: i2f
    //   461: invokevirtual 344	android/graphics/Canvas:rotate	(FFF)V
    //   464: aload_1
    //   465: aload_0
    //   466: getfield 508	com/tencent/mobileqq/troop/widget/RadaScanView:jdField_a_of_type_ArrayOfAndroidGraphicsBitmap	[Landroid/graphics/Bitmap;
    //   469: aload_0
    //   470: getfield 538	com/tencent/mobileqq/troop/widget/RadaScanView:o	I
    //   473: aaload
    //   474: aconst_null
    //   475: aload_0
    //   476: getfield 524	com/tencent/mobileqq/troop/widget/RadaScanView:jdField_d_of_type_AndroidGraphicsRect	Landroid/graphics/Rect;
    //   479: aload_0
    //   480: getfield 545	com/tencent/mobileqq/troop/widget/RadaScanView:jdField_e_of_type_AndroidGraphicsPaint	Landroid/graphics/Paint;
    //   483: invokevirtual 354	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    //   486: aload_1
    //   487: invokevirtual 357	android/graphics/Canvas:restore	()V
    //   490: invokestatic 198	java/lang/System:currentTimeMillis	()J
    //   493: lstore 4
    //   495: lload 4
    //   497: aload_0
    //   498: getfield 547	com/tencent/mobileqq/troop/widget/RadaScanView:jdField_e_of_type_Long	J
    //   501: lsub
    //   502: ldc2_w 548
    //   505: lcmp
    //   506: ifle +39 -> 545
    //   509: aload_0
    //   510: aload_0
    //   511: getfield 538	com/tencent/mobileqq/troop/widget/RadaScanView:o	I
    //   514: iconst_1
    //   515: iadd
    //   516: putfield 538	com/tencent/mobileqq/troop/widget/RadaScanView:o	I
    //   519: aload_0
    //   520: getfield 538	com/tencent/mobileqq/troop/widget/RadaScanView:o	I
    //   523: bipush 10
    //   525: if_icmplt +14 -> 539
    //   528: aload_0
    //   529: aload_0
    //   530: getfield 538	com/tencent/mobileqq/troop/widget/RadaScanView:o	I
    //   533: bipush 10
    //   535: irem
    //   536: putfield 538	com/tencent/mobileqq/troop/widget/RadaScanView:o	I
    //   539: aload_0
    //   540: lload 4
    //   542: putfield 547	com/tencent/mobileqq/troop/widget/RadaScanView:jdField_e_of_type_Long	J
    //   545: aload_3
    //   546: monitorexit
    //   547: return
    //   548: astore_1
    //   549: aload_3
    //   550: monitorexit
    //   551: aload_1
    //   552: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	553	0	this	RadaScanView
    //   0	553	1	paramCanvas	Canvas
    //   443	8	2	f1	float
    //   352	198	3	localThrowable	Throwable
    //   10	531	4	l1	long
    // Exception table:
    //   from	to	target	type
    //   12	222	352	java/lang/Throwable
    //   229	342	548	finally
    //   342	351	548	finally
    //   396	490	548	finally
    //   490	539	548	finally
    //   539	545	548	finally
    //   545	547	548	finally
    //   549	551	548	finally
  }
  
  protected void e()
  {
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setFilterBitmap(true);
    this.jdField_b_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(-1);
    this.jdField_b_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_b_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_b_of_type_AndroidGraphicsPaint.setStrokeWidth(DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 1.0F));
    this.jdField_b_of_type_AndroidGraphicsRect = new Rect();
    this.jdField_c_of_type_Int = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 20.0F);
  }
  
  public void f()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_c_of_type_AndroidGraphicsBitmap = null;
      this.jdField_d_of_type_AndroidGraphicsBitmap = null;
      this.jdField_c_of_type_Long = 0L;
      this.jdField_b_of_type_Boolean = false;
      this.o = 0;
      this.jdField_e_of_type_Long = 0L;
      return;
    }
  }
  
  protected void g()
  {
    this.jdField_e_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_e_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_e_of_type_AndroidGraphicsPaint.setFilterBitmap(true);
    this.q = (DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 7.0F) * 2);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt1);
  }
  
  public void setApp(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    if (paramQQAppInterface != null) {
      this.jdField_b_of_type_AndroidGraphicsBitmap = paramQQAppInterface.a(paramQQAppInterface.a(), (byte)3, true);
    }
    if (this.jdField_b_of_type_AndroidGraphicsBitmap == null) {
      this.jdField_b_of_type_AndroidGraphicsBitmap = ImageUtil.a();
    }
  }
  
  public void setOnScanDegreeChangeListener(RadaScanView.OnScanDegreeChangeListener paramOnScanDegreeChangeListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRadaScanView$OnScanDegreeChangeListener = paramOnScanDegreeChangeListener;
  }
  
  public void setSelection(long paramLong, HashSet paramHashSet, Map paramMap)
  {
    boolean bool2 = true;
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (paramLong == this.jdField_c_of_type_Long) {
          return;
        }
        this.jdField_d_of_type_Long = this.jdField_c_of_type_Long;
        this.jdField_c_of_type_Long = paramLong;
        this.jdField_b_of_type_Boolean = paramHashSet.contains(Long.valueOf(this.jdField_c_of_type_Long));
        this.jdField_a_of_type_AndroidGraphicsPoint = ((Point)paramMap.get(Long.valueOf(this.jdField_c_of_type_Long)));
        if (paramHashSet.contains(Long.valueOf(this.jdField_d_of_type_Long)))
        {
          this.jdField_b_of_type_AndroidGraphicsPoint = ((Point)paramMap.get(Long.valueOf(this.jdField_d_of_type_Long)));
          this.jdField_d_of_type_AndroidGraphicsBitmap = this.jdField_c_of_type_AndroidGraphicsBitmap;
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
            this.jdField_c_of_type_AndroidGraphicsBitmap = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_c_of_type_Long + "", (byte)3, false);
          }
          if (this.jdField_c_of_type_AndroidGraphicsBitmap == null) {
            this.jdField_c_of_type_AndroidGraphicsBitmap = this.jdField_e_of_type_AndroidGraphicsBitmap;
          }
          this.jdField_a_of_type_AndroidWidgetScroller.abortAnimation();
          this.jdField_a_of_type_AndroidWidgetScroller.startScroll(0, 0, this.m, 0, 400);
          if (!QLog.isColorLevel()) {
            break;
          }
          paramHashSet = new StringBuilder().append("setSelection:").append(paramLong).append(",");
          if (this.jdField_a_of_type_AndroidGraphicsPoint != null)
          {
            bool1 = true;
            paramHashSet = paramHashSet.append(bool1).append(",");
            if (this.jdField_b_of_type_AndroidGraphicsPoint == null) {
              break label325;
            }
            bool1 = true;
            paramHashSet = paramHashSet.append(bool1).append(",");
            if (this.jdField_c_of_type_AndroidGraphicsBitmap == null) {
              break label331;
            }
            bool1 = bool2;
            QLog.d("RadaScanView", 2, bool1);
          }
        }
        else
        {
          this.jdField_b_of_type_AndroidGraphicsPoint = null;
        }
      }
      boolean bool1 = false;
      continue;
      label325:
      bool1 = false;
      continue;
      label331:
      bool1 = false;
    }
  }
  
  public void setSpace(int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_e_of_type_Int = paramInt2;
    this.f = paramInt1;
    this.g = paramInt3;
    this.jdField_a_of_type_AndroidGraphicsRect.set(this.jdField_a_of_type_Int, this.f + this.jdField_e_of_type_Int, getWidth() - this.f - this.jdField_e_of_type_Int, this.jdField_b_of_type_Int);
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_Int = (paramInt2 / 2);
    this.jdField_b_of_type_Int = (paramInt3 / 2);
    this.jdField_a_of_type_AndroidGraphicsRect.set(this.jdField_a_of_type_Int, this.f + this.jdField_e_of_type_Int, paramInt2 - this.f - this.jdField_e_of_type_Int, this.jdField_b_of_type_Int);
    this.jdField_b_of_type_AndroidGraphicsRect.set(this.jdField_a_of_type_Int - this.jdField_c_of_type_Int, this.jdField_b_of_type_Int - this.jdField_c_of_type_Int, this.jdField_a_of_type_Int + this.jdField_c_of_type_Int, this.jdField_b_of_type_Int + this.jdField_c_of_type_Int);
    this.h += 1;
    if (QLog.isColorLevel()) {
      QLog.i("RadaScanView", 2, "surfaceChanged:" + paramInt2 + "," + paramInt3 + "," + this.h);
    }
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    b();
    this.i += 1;
    if (QLog.isColorLevel()) {
      QLog.i("RadaScanView", 2, "surfaceCreated:" + this.i);
    }
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    c();
    this.j += 1;
    if (QLog.isColorLevel()) {
      QLog.i("RadaScanView", 2, "surfaceDestroyed:" + this.j);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\widget\RadaScanView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
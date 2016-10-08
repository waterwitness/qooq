package com.tencent.mobileqq.activity.aio.anim;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.widget.ListView;

public class MoveToBottomScroller
  implements Runnable
{
  public static int b = 0;
  private static final int j = 1000;
  private static final int p = 0;
  private static final int q = 1;
  private static final int r = 2;
  private static final int s = 3;
  float jdField_a_of_type_Float = 1.0F;
  public int a;
  private long jdField_a_of_type_Long;
  ListView jdField_a_of_type_ComTencentWidgetListView;
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private boolean jdField_b_of_type_Boolean = true;
  private float jdField_c_of_type_Float;
  int jdField_c_of_type_Int;
  private float jdField_d_of_type_Float;
  int jdField_d_of_type_Int = 0;
  int e = 0;
  int f = 0;
  int g = 0;
  int h = 0;
  int i = 0;
  private int k;
  private int l;
  private int m;
  private int n;
  private int o;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_b_of_type_Int = 50;
  }
  
  public MoveToBottomScroller(ListView paramListView)
  {
    this.jdField_a_of_type_ComTencentWidgetListView = paramListView;
    this.jdField_c_of_type_Int = ViewConfiguration.get(this.jdField_a_of_type_ComTencentWidgetListView.getContext()).getScaledMinimumFlingVelocity();
    if (DeviceInfoUtil.c() / 1048576L > 512L) {}
    for (;;)
    {
      this.jdField_b_of_type_Boolean = bool;
      this.jdField_a_of_type_Float = this.jdField_a_of_type_ComTencentWidgetListView.getResources().getDisplayMetrics().density;
      return;
      bool = false;
    }
  }
  
  public void a()
  {
    boolean bool = true;
    this.jdField_a_of_type_Int = 0;
    this.i = 0;
    if (!this.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentWidgetListView.setSelection(this.jdField_a_of_type_ComTencentWidgetListView.d_() - 1);
    }
    while (this.jdField_a_of_type_ComTencentWidgetListView == null) {
      return;
    }
    this.h = this.jdField_a_of_type_ComTencentWidgetListView.getResources().getDisplayMetrics().heightPixels;
    this.e = this.jdField_a_of_type_ComTencentWidgetListView.au;
    this.f = (this.e + this.jdField_a_of_type_ComTencentWidgetListView.getChildCount() - 1);
    this.jdField_d_of_type_Int = (this.jdField_a_of_type_ComTencentWidgetListView.d_() - this.f - 1);
    if (this.jdField_d_of_type_Int == 0)
    {
      if (this.jdField_a_of_type_ComTencentWidgetListView.getChildCount() < 1)
      {
        this.jdField_a_of_type_ComTencentWidgetListView.setSelection(this.jdField_a_of_type_ComTencentWidgetListView.d_() - 1);
        return;
      }
      this.o = this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(this.jdField_a_of_type_ComTencentWidgetListView.getChildCount() - 1).getBottom();
      if (this.o == 0)
      {
        b();
        return;
      }
      this.n = 1000;
      this.jdField_a_of_type_Long = AnimationUtils.currentAnimationTimeMillis();
      this.k = 0;
      this.l = 3;
      this.jdField_a_of_type_ComTencentWidgetListView.post(this);
      return;
    }
    int i1 = this.jdField_a_of_type_ComTencentWidgetListView.getChildCount();
    if (this.jdField_a_of_type_ComTencentWidgetListView.getChildCount() == 0) {
      i1 = 1;
    }
    this.o = (this.jdField_d_of_type_Int * this.jdField_a_of_type_ComTencentWidgetListView.getHeight() / i1);
    this.jdField_d_of_type_Float = (this.o / 750.0F);
    this.jdField_b_of_type_Float = (this.jdField_d_of_type_Float / 250.0F);
    this.jdField_c_of_type_Float = 0.0F;
    this.jdField_a_of_type_Long = AnimationUtils.currentAnimationTimeMillis();
    this.l = 0;
    this.k = 0;
    this.m = (this.jdField_a_of_type_ComTencentWidgetListView.d_() - 1);
    if (this.jdField_d_of_type_Int == 1) {}
    for (;;)
    {
      this.jdField_a_of_type_Boolean = bool;
      this.jdField_a_of_type_ComTencentWidgetListView.post(this);
      return;
      bool = false;
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentWidgetListView.removeCallbacks(this);
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_0
    //   3: aload_0
    //   4: getfield 111	com/tencent/mobileqq/activity/aio/anim/MoveToBottomScroller:jdField_a_of_type_Int	I
    //   7: iconst_1
    //   8: iadd
    //   9: putfield 111	com/tencent/mobileqq/activity/aio/anim/MoveToBottomScroller:jdField_a_of_type_Int	I
    //   12: aload_0
    //   13: getfield 111	com/tencent/mobileqq/activity/aio/anim/MoveToBottomScroller:jdField_a_of_type_Int	I
    //   16: getstatic 44	com/tencent/mobileqq/activity/aio/anim/MoveToBottomScroller:jdField_b_of_type_Int	I
    //   19: if_icmplt +21 -> 40
    //   22: aload_0
    //   23: getfield 67	com/tencent/mobileqq/activity/aio/anim/MoveToBottomScroller:jdField_a_of_type_ComTencentWidgetListView	Lcom/tencent/widget/ListView;
    //   26: aload_0
    //   27: getfield 67	com/tencent/mobileqq/activity/aio/anim/MoveToBottomScroller:jdField_a_of_type_ComTencentWidgetListView	Lcom/tencent/widget/ListView;
    //   30: invokevirtual 114	com/tencent/widget/ListView:d_	()I
    //   33: iconst_1
    //   34: isub
    //   35: iconst_0
    //   36: invokevirtual 182	com/tencent/widget/ListView:setSelectionFromBottom	(II)V
    //   39: return
    //   40: invokestatic 147	android/view/animation/AnimationUtils:currentAnimationTimeMillis	()J
    //   43: aload_0
    //   44: getfield 149	com/tencent/mobileqq/activity/aio/anim/MoveToBottomScroller:jdField_a_of_type_Long	J
    //   47: lsub
    //   48: l2i
    //   49: istore 4
    //   51: aload_0
    //   52: getfield 153	com/tencent/mobileqq/activity/aio/anim/MoveToBottomScroller:l	I
    //   55: tableswitch	default:+601->656, 0:+356->411, 1:+407->462, 2:+383->438, 3:+487->542
    //   84: iload_2
    //   85: aload_0
    //   86: getfield 151	com/tencent/mobileqq/activity/aio/anim/MoveToBottomScroller:k	I
    //   89: isub
    //   90: istore_2
    //   91: iload_2
    //   92: ifge +561 -> 653
    //   95: iload_3
    //   96: istore_2
    //   97: aload_0
    //   98: getfield 67	com/tencent/mobileqq/activity/aio/anim/MoveToBottomScroller:jdField_a_of_type_ComTencentWidgetListView	Lcom/tencent/widget/ListView;
    //   101: invokevirtual 127	com/tencent/widget/ListView:getChildCount	()I
    //   104: iconst_1
    //   105: isub
    //   106: ifle +26 -> 132
    //   109: aload_0
    //   110: aload_0
    //   111: getfield 67	com/tencent/mobileqq/activity/aio/anim/MoveToBottomScroller:jdField_a_of_type_ComTencentWidgetListView	Lcom/tencent/widget/ListView;
    //   114: aload_0
    //   115: getfield 67	com/tencent/mobileqq/activity/aio/anim/MoveToBottomScroller:jdField_a_of_type_ComTencentWidgetListView	Lcom/tencent/widget/ListView;
    //   118: invokevirtual 127	com/tencent/widget/ListView:getChildCount	()I
    //   121: iconst_1
    //   122: isub
    //   123: invokevirtual 131	com/tencent/widget/ListView:getChildAt	(I)Landroid/view/View;
    //   126: invokevirtual 183	android/view/View:getHeight	()I
    //   129: putfield 61	com/tencent/mobileqq/activity/aio/anim/MoveToBottomScroller:g	I
    //   132: iload_2
    //   133: istore_3
    //   134: aload_0
    //   135: getfield 53	com/tencent/mobileqq/activity/aio/anim/MoveToBottomScroller:jdField_d_of_type_Int	I
    //   138: iconst_2
    //   139: if_icmpge +65 -> 204
    //   142: aload_0
    //   143: getfield 61	com/tencent/mobileqq/activity/aio/anim/MoveToBottomScroller:g	I
    //   146: aload_0
    //   147: getfield 63	com/tencent/mobileqq/activity/aio/anim/MoveToBottomScroller:h	I
    //   150: if_icmpgt +415 -> 565
    //   153: iload_2
    //   154: istore_3
    //   155: iload_2
    //   156: i2f
    //   157: aload_0
    //   158: getfield 59	com/tencent/mobileqq/activity/aio/anim/MoveToBottomScroller:jdField_a_of_type_Float	F
    //   161: ldc -72
    //   163: fmul
    //   164: fcmpl
    //   165: ifle +17 -> 182
    //   168: aload_0
    //   169: getfield 59	com/tencent/mobileqq/activity/aio/anim/MoveToBottomScroller:jdField_a_of_type_Float	F
    //   172: ldc -72
    //   174: fmul
    //   175: f2d
    //   176: ldc2_w 185
    //   179: dadd
    //   180: d2i
    //   181: istore_3
    //   182: iload_3
    //   183: istore_2
    //   184: iload_3
    //   185: aload_0
    //   186: getfield 65	com/tencent/mobileqq/activity/aio/anim/MoveToBottomScroller:i	I
    //   189: if_icmpge +8 -> 197
    //   192: aload_0
    //   193: getfield 65	com/tencent/mobileqq/activity/aio/anim/MoveToBottomScroller:i	I
    //   196: istore_2
    //   197: aload_0
    //   198: iload_2
    //   199: putfield 65	com/tencent/mobileqq/activity/aio/anim/MoveToBottomScroller:i	I
    //   202: iload_2
    //   203: istore_3
    //   204: aload_0
    //   205: getfield 67	com/tencent/mobileqq/activity/aio/anim/MoveToBottomScroller:jdField_a_of_type_ComTencentWidgetListView	Lcom/tencent/widget/ListView;
    //   208: iload_3
    //   209: ineg
    //   210: iload_3
    //   211: ineg
    //   212: invokevirtual 189	com/tencent/widget/ListView:a	(II)Z
    //   215: istore 5
    //   217: iload 5
    //   219: ifne +429 -> 648
    //   222: aload_0
    //   223: getfield 67	com/tencent/mobileqq/activity/aio/anim/MoveToBottomScroller:jdField_a_of_type_ComTencentWidgetListView	Lcom/tencent/widget/ListView;
    //   226: invokevirtual 127	com/tencent/widget/ListView:getChildCount	()I
    //   229: istore_2
    //   230: aload_0
    //   231: getfield 67	com/tencent/mobileqq/activity/aio/anim/MoveToBottomScroller:jdField_a_of_type_ComTencentWidgetListView	Lcom/tencent/widget/ListView;
    //   234: getfield 124	com/tencent/widget/ListView:au	I
    //   237: istore_3
    //   238: aload_0
    //   239: getfield 153	com/tencent/mobileqq/activity/aio/anim/MoveToBottomScroller:l	I
    //   242: iconst_3
    //   243: if_icmpeq +155 -> 398
    //   246: aload_0
    //   247: getfield 153	com/tencent/mobileqq/activity/aio/anim/MoveToBottomScroller:l	I
    //   250: iconst_1
    //   251: if_icmpeq +147 -> 398
    //   254: iload_3
    //   255: iload_2
    //   256: iadd
    //   257: iconst_1
    //   258: isub
    //   259: aload_0
    //   260: getfield 170	com/tencent/mobileqq/activity/aio/anim/MoveToBottomScroller:m	I
    //   263: if_icmplt +135 -> 398
    //   266: iload_2
    //   267: iconst_2
    //   268: if_icmplt +347 -> 615
    //   271: aload_0
    //   272: aload_0
    //   273: getfield 67	com/tencent/mobileqq/activity/aio/anim/MoveToBottomScroller:jdField_a_of_type_ComTencentWidgetListView	Lcom/tencent/widget/ListView;
    //   276: iload_2
    //   277: iconst_1
    //   278: isub
    //   279: invokevirtual 131	com/tencent/widget/ListView:getChildAt	(I)Landroid/view/View;
    //   282: invokevirtual 136	android/view/View:getBottom	()I
    //   285: aload_0
    //   286: getfield 67	com/tencent/mobileqq/activity/aio/anim/MoveToBottomScroller:jdField_a_of_type_ComTencentWidgetListView	Lcom/tencent/widget/ListView;
    //   289: iload_2
    //   290: iconst_2
    //   291: isub
    //   292: invokevirtual 131	com/tencent/widget/ListView:getChildAt	(I)Landroid/view/View;
    //   295: invokevirtual 136	android/view/View:getBottom	()I
    //   298: isub
    //   299: putfield 138	com/tencent/mobileqq/activity/aio/anim/MoveToBottomScroller:o	I
    //   302: aload_0
    //   303: sipush 1000
    //   306: iload 4
    //   308: isub
    //   309: putfield 142	com/tencent/mobileqq/activity/aio/anim/MoveToBottomScroller:n	I
    //   312: aload_0
    //   313: getfield 142	com/tencent/mobileqq/activity/aio/anim/MoveToBottomScroller:n	I
    //   316: bipush 100
    //   318: if_icmpge +9 -> 327
    //   321: aload_0
    //   322: bipush 100
    //   324: putfield 142	com/tencent/mobileqq/activity/aio/anim/MoveToBottomScroller:n	I
    //   327: aload_0
    //   328: invokestatic 147	android/view/animation/AnimationUtils:currentAnimationTimeMillis	()J
    //   331: putfield 149	com/tencent/mobileqq/activity/aio/anim/MoveToBottomScroller:jdField_a_of_type_Long	J
    //   334: aload_0
    //   335: iconst_0
    //   336: putfield 151	com/tencent/mobileqq/activity/aio/anim/MoveToBottomScroller:k	I
    //   339: aload_0
    //   340: getfield 168	com/tencent/mobileqq/activity/aio/anim/MoveToBottomScroller:jdField_c_of_type_Float	F
    //   343: ldc -66
    //   345: fmul
    //   346: aload_0
    //   347: getfield 85	com/tencent/mobileqq/activity/aio/anim/MoveToBottomScroller:jdField_c_of_type_Int	I
    //   350: i2f
    //   351: fcmpl
    //   352: ifle +288 -> 640
    //   355: aload_0
    //   356: getfield 172	com/tencent/mobileqq/activity/aio/anim/MoveToBottomScroller:jdField_a_of_type_Boolean	Z
    //   359: ifne +281 -> 640
    //   362: aload_0
    //   363: iconst_1
    //   364: putfield 153	com/tencent/mobileqq/activity/aio/anim/MoveToBottomScroller:l	I
    //   367: aload_0
    //   368: aload_0
    //   369: getfield 138	com/tencent/mobileqq/activity/aio/anim/MoveToBottomScroller:o	I
    //   372: i2f
    //   373: fconst_2
    //   374: fmul
    //   375: aload_0
    //   376: getfield 142	com/tencent/mobileqq/activity/aio/anim/MoveToBottomScroller:n	I
    //   379: i2f
    //   380: fdiv
    //   381: putfield 168	com/tencent/mobileqq/activity/aio/anim/MoveToBottomScroller:jdField_c_of_type_Float	F
    //   384: aload_0
    //   385: aload_0
    //   386: getfield 168	com/tencent/mobileqq/activity/aio/anim/MoveToBottomScroller:jdField_c_of_type_Float	F
    //   389: aload_0
    //   390: getfield 142	com/tencent/mobileqq/activity/aio/anim/MoveToBottomScroller:n	I
    //   393: i2f
    //   394: fdiv
    //   395: putfield 166	com/tencent/mobileqq/activity/aio/anim/MoveToBottomScroller:jdField_b_of_type_Float	F
    //   398: aload_0
    //   399: getfield 67	com/tencent/mobileqq/activity/aio/anim/MoveToBottomScroller:jdField_a_of_type_ComTencentWidgetListView	Lcom/tencent/widget/ListView;
    //   402: aload_0
    //   403: invokevirtual 157	com/tencent/widget/ListView:post	(Ljava/lang/Runnable;)Z
    //   406: pop
    //   407: return
    //   408: astore_1
    //   409: aload_1
    //   410: athrow
    //   411: aload_0
    //   412: aload_0
    //   413: getfield 166	com/tencent/mobileqq/activity/aio/anim/MoveToBottomScroller:jdField_b_of_type_Float	F
    //   416: iload 4
    //   418: i2f
    //   419: fmul
    //   420: putfield 168	com/tencent/mobileqq/activity/aio/anim/MoveToBottomScroller:jdField_c_of_type_Float	F
    //   423: aload_0
    //   424: getfield 168	com/tencent/mobileqq/activity/aio/anim/MoveToBottomScroller:jdField_c_of_type_Float	F
    //   427: iload 4
    //   429: i2f
    //   430: fmul
    //   431: fconst_2
    //   432: fdiv
    //   433: f2i
    //   434: istore_2
    //   435: goto -351 -> 84
    //   438: aload_0
    //   439: getfield 163	com/tencent/mobileqq/activity/aio/anim/MoveToBottomScroller:jdField_d_of_type_Float	F
    //   442: iload 4
    //   444: i2f
    //   445: fmul
    //   446: aload_0
    //   447: getfield 163	com/tencent/mobileqq/activity/aio/anim/MoveToBottomScroller:jdField_d_of_type_Float	F
    //   450: ldc -66
    //   452: fmul
    //   453: ldc -65
    //   455: fdiv
    //   456: fsub
    //   457: f2i
    //   458: istore_2
    //   459: goto -375 -> 84
    //   462: iload 4
    //   464: aload_0
    //   465: getfield 142	com/tencent/mobileqq/activity/aio/anim/MoveToBottomScroller:n	I
    //   468: if_icmple +31 -> 499
    //   471: aload_0
    //   472: getfield 138	com/tencent/mobileqq/activity/aio/anim/MoveToBottomScroller:o	I
    //   475: istore_2
    //   476: aload_0
    //   477: getfield 151	com/tencent/mobileqq/activity/aio/anim/MoveToBottomScroller:k	I
    //   480: istore_2
    //   481: aload_0
    //   482: getfield 67	com/tencent/mobileqq/activity/aio/anim/MoveToBottomScroller:jdField_a_of_type_ComTencentWidgetListView	Lcom/tencent/widget/ListView;
    //   485: aload_0
    //   486: getfield 67	com/tencent/mobileqq/activity/aio/anim/MoveToBottomScroller:jdField_a_of_type_ComTencentWidgetListView	Lcom/tencent/widget/ListView;
    //   489: invokevirtual 114	com/tencent/widget/ListView:d_	()I
    //   492: iconst_1
    //   493: isub
    //   494: iconst_0
    //   495: invokevirtual 182	com/tencent/widget/ListView:setSelectionFromBottom	(II)V
    //   498: return
    //   499: aload_0
    //   500: aload_0
    //   501: getfield 168	com/tencent/mobileqq/activity/aio/anim/MoveToBottomScroller:jdField_c_of_type_Float	F
    //   504: aload_0
    //   505: getfield 166	com/tencent/mobileqq/activity/aio/anim/MoveToBottomScroller:jdField_b_of_type_Float	F
    //   508: iload 4
    //   510: i2f
    //   511: fmul
    //   512: fsub
    //   513: putfield 168	com/tencent/mobileqq/activity/aio/anim/MoveToBottomScroller:jdField_c_of_type_Float	F
    //   516: aload_0
    //   517: getfield 138	com/tencent/mobileqq/activity/aio/anim/MoveToBottomScroller:o	I
    //   520: i2f
    //   521: aload_0
    //   522: getfield 168	com/tencent/mobileqq/activity/aio/anim/MoveToBottomScroller:jdField_c_of_type_Float	F
    //   525: aload_0
    //   526: getfield 142	com/tencent/mobileqq/activity/aio/anim/MoveToBottomScroller:n	I
    //   529: iload 4
    //   531: isub
    //   532: i2f
    //   533: fmul
    //   534: fconst_2
    //   535: fdiv
    //   536: fsub
    //   537: f2i
    //   538: istore_2
    //   539: goto -455 -> 84
    //   542: iload 4
    //   544: i2f
    //   545: aload_0
    //   546: getfield 142	com/tencent/mobileqq/activity/aio/anim/MoveToBottomScroller:n	I
    //   549: i2f
    //   550: fdiv
    //   551: invokestatic 196	com/tencent/util/AnimateUtils:a	(F)F
    //   554: aload_0
    //   555: getfield 138	com/tencent/mobileqq/activity/aio/anim/MoveToBottomScroller:o	I
    //   558: i2f
    //   559: fmul
    //   560: f2i
    //   561: istore_2
    //   562: goto -478 -> 84
    //   565: iload_2
    //   566: istore_3
    //   567: iload_2
    //   568: i2f
    //   569: aload_0
    //   570: getfield 59	com/tencent/mobileqq/activity/aio/anim/MoveToBottomScroller:jdField_a_of_type_Float	F
    //   573: ldc -59
    //   575: fmul
    //   576: fcmpl
    //   577: ifle -395 -> 182
    //   580: aload_0
    //   581: getfield 59	com/tencent/mobileqq/activity/aio/anim/MoveToBottomScroller:jdField_a_of_type_Float	F
    //   584: ldc -59
    //   586: fmul
    //   587: f2d
    //   588: ldc2_w 185
    //   591: dadd
    //   592: d2i
    //   593: istore_3
    //   594: goto -412 -> 182
    //   597: astore_1
    //   598: ldc -57
    //   600: iconst_2
    //   601: aload_1
    //   602: iconst_0
    //   603: anewarray 4	java/lang/Object
    //   606: invokestatic 204	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   609: iconst_1
    //   610: istore 5
    //   612: goto -395 -> 217
    //   615: iload_2
    //   616: iconst_1
    //   617: if_icmpne -315 -> 302
    //   620: aload_0
    //   621: aload_0
    //   622: getfield 67	com/tencent/mobileqq/activity/aio/anim/MoveToBottomScroller:jdField_a_of_type_ComTencentWidgetListView	Lcom/tencent/widget/ListView;
    //   625: iload_2
    //   626: iconst_1
    //   627: isub
    //   628: invokevirtual 131	com/tencent/widget/ListView:getChildAt	(I)Landroid/view/View;
    //   631: invokevirtual 136	android/view/View:getBottom	()I
    //   634: putfield 138	com/tencent/mobileqq/activity/aio/anim/MoveToBottomScroller:o	I
    //   637: goto -335 -> 302
    //   640: aload_0
    //   641: iconst_3
    //   642: putfield 153	com/tencent/mobileqq/activity/aio/anim/MoveToBottomScroller:l	I
    //   645: goto -247 -> 398
    //   648: aload_0
    //   649: invokevirtual 140	com/tencent/mobileqq/activity/aio/anim/MoveToBottomScroller:b	()V
    //   652: return
    //   653: goto -556 -> 97
    //   656: iconst_0
    //   657: istore_2
    //   658: goto -574 -> 84
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	661	0	this	MoveToBottomScroller
    //   408	2	1	localObject	Object
    //   597	5	1	localException	Exception
    //   84	574	2	i1	int
    //   1	593	3	i2	int
    //   49	494	4	i3	int
    //   215	396	5	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	39	408	finally
    //   40	84	408	finally
    //   84	91	408	finally
    //   97	132	408	finally
    //   134	153	408	finally
    //   155	182	408	finally
    //   184	197	408	finally
    //   197	202	408	finally
    //   204	217	408	finally
    //   222	266	408	finally
    //   271	302	408	finally
    //   302	327	408	finally
    //   327	398	408	finally
    //   398	407	408	finally
    //   411	435	408	finally
    //   438	459	408	finally
    //   462	498	408	finally
    //   499	539	408	finally
    //   542	562	408	finally
    //   567	594	408	finally
    //   598	609	408	finally
    //   620	637	408	finally
    //   640	645	408	finally
    //   648	652	408	finally
    //   204	217	597	java/lang/Exception
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\aio\anim\MoveToBottomScroller.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
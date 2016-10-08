package com.tencent.mobileqq.bubble;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.NinePatch;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.StateListDrawable;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.SkinUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class BubbleInfo
{
  public static final int a = 65;
  public static final int b = 57;
  private static final boolean jdField_b_of_type_Boolean = true;
  private static final String g;
  public static final int i = 0;
  public static final int j = 1;
  public static final int k = 2;
  public static final int l = 3;
  public static final int m = 4;
  public static final int n = 5;
  public static final int o = 6;
  public static final int p = 7;
  public static final int q = 0;
  public static final int r = 1;
  public static final int s = 2;
  public static final int t = 3;
  public static final int u = 4;
  public static final int v = 5;
  public static int w;
  public NinePatch a;
  public BubbleConfig.Chartlet a;
  public BubbleConfig.DiyTextConfig a;
  public BubbleInfo.CommonAttrs a;
  public String a;
  public HashMap a;
  public List a;
  public boolean a;
  public String[] a;
  public NinePatch b;
  public BubbleInfo.CommonAttrs b;
  public String b;
  List jdField_b_of_type_JavaUtilList = new ArrayList();
  public int c;
  public String c;
  List jdField_c_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_c_of_type_Boolean;
  public int d;
  public String d;
  private boolean d;
  public int e;
  public String e;
  public int f;
  public String f;
  public int g;
  public int h;
  private int x;
  private int y;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_g_of_type_JavaLangString = BubbleInfo.class.getSimpleName();
  }
  
  public BubbleInfo(int paramInt)
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_e_of_type_JavaLangString = "";
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public BubbleInfo(int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_e_of_type_JavaLangString = "";
    this.jdField_c_of_type_Int = paramInt1;
    this.x = paramInt2;
    this.y = paramInt3;
  }
  
  public BubbleInfo(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, BubbleConfig.Chartlet paramChartlet, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, String[] paramArrayOfString, BubbleInfo.CommonAttrs paramCommonAttrs1, int paramInt5, int paramInt6, BubbleInfo.CommonAttrs paramCommonAttrs2, List paramList, HashMap paramHashMap, BubbleConfig.DiyTextConfig paramDiyTextConfig)
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_e_of_type_JavaLangString = "";
    this.jdField_c_of_type_Int = paramInt1;
    this.jdField_d_of_type_JavaLangString = paramString3;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_e_of_type_JavaLangString = paramString4;
    this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleConfig$Chartlet = paramChartlet;
    this.jdField_d_of_type_Int = paramInt2;
    this.jdField_e_of_type_Int = paramInt3;
    this.jdField_f_of_type_Int = paramInt4;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_g_of_type_Int = paramInt5;
    this.h = paramInt6;
    this.jdField_a_of_type_ArrayOfJavaLangString = paramArrayOfString;
    paramString1 = paramList;
    if (paramList == null) {
      paramString1 = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilList = paramString1;
    this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs = paramCommonAttrs1;
    this.jdField_b_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs = paramCommonAttrs2;
    paramString1 = paramHashMap;
    if (paramHashMap == null) {
      paramString1 = new HashMap();
    }
    this.jdField_a_of_type_JavaUtilHashMap = paramString1;
    this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleConfig$DiyTextConfig = paramDiyTextConfig;
  }
  
  private Drawable a(Context paramContext, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2, int paramInt3)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("bubbleinfo_").append(paramInt1).append("_bg_").append(paramBoolean1).append("_").append(paramBoolean2);
    Object localObject = (Pair)BaseApplicationImpl.a.get(localStringBuffer.toString());
    if ((localObject != null) && (((Pair)localObject).first != null)) {
      paramContext = ((Drawable.ConstantState)((Pair)localObject).first).newDrawable(paramContext.getResources());
    }
    do
    {
      return paramContext;
      Drawable localDrawable = paramContext.getResources().getDrawable(paramInt2);
      paramContext = paramContext.getResources().getDrawable(paramInt3);
      localObject = new StateListDrawable();
      if (localDrawable != null) {
        ((StateListDrawable)localObject).addState(new int[] { 16842919, 16842910 }, localDrawable);
      }
      if (paramContext != null)
      {
        ((StateListDrawable)localObject).addState(new int[] { 16842910 }, paramContext);
        ((StateListDrawable)localObject).addState(new int[] { -16842910 }, paramContext);
      }
      paramInt1 = SkinUtils.a(localDrawable) + SkinUtils.a(paramContext);
      paramContext = (Context)localObject;
    } while (paramInt1 <= 0);
    BaseApplicationImpl.a.put(localStringBuffer.toString(), new Pair(((StateListDrawable)localObject).getConstantState(), Integer.valueOf(paramInt1)));
    return (Drawable)localObject;
  }
  
  /* Error */
  public static Pair a(com.tencent.common.app.AppInterface paramAppInterface, String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 10
    //   3: iconst_0
    //   4: istore 9
    //   6: iconst_0
    //   7: istore 8
    //   9: aload_1
    //   10: invokestatic 226	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   13: ifne +359 -> 372
    //   16: aload_1
    //   17: ldc -28
    //   19: invokevirtual 234	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   22: ifeq +196 -> 218
    //   25: iconst_1
    //   26: istore 7
    //   28: aconst_null
    //   29: astore_2
    //   30: aload_2
    //   31: ifnull +10 -> 41
    //   34: aload_2
    //   35: invokevirtual 240	java/io/File:exists	()Z
    //   38: ifne +8 -> 46
    //   41: iload 7
    //   43: ifeq +173 -> 216
    //   46: new 242	android/graphics/Rect
    //   49: dup
    //   50: invokespecial 243	android/graphics/Rect:<init>	()V
    //   53: astore 5
    //   55: new 245	android/graphics/BitmapFactory$Options
    //   58: dup
    //   59: invokespecial 246	android/graphics/BitmapFactory$Options:<init>	()V
    //   62: astore 6
    //   64: aload 6
    //   66: sipush 320
    //   69: putfield 249	android/graphics/BitmapFactory$Options:inDensity	I
    //   72: aload 6
    //   74: aload_0
    //   75: invokevirtual 254	com/tencent/common/app/AppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   78: invokevirtual 257	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   81: invokevirtual 261	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   84: getfield 266	android/util/DisplayMetrics:densityDpi	I
    //   87: putfield 269	android/graphics/BitmapFactory$Options:inTargetDensity	I
    //   90: iload 7
    //   92: ifeq +141 -> 233
    //   95: aload_1
    //   96: astore_2
    //   97: aload_1
    //   98: astore_3
    //   99: aload_1
    //   100: ldc_w 271
    //   103: invokevirtual 275	java/lang/String:length	()I
    //   106: invokevirtual 279	java/lang/String:substring	(I)Ljava/lang/String;
    //   109: astore_1
    //   110: aload_1
    //   111: astore_2
    //   112: aload_1
    //   113: astore_3
    //   114: aload_0
    //   115: invokevirtual 254	com/tencent/common/app/AppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   118: invokevirtual 283	com/tencent/qphone/base/util/BaseApplication:getApplicationContext	()Landroid/content/Context;
    //   121: invokevirtual 287	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   124: aload_1
    //   125: invokevirtual 293	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   128: astore 4
    //   130: aload_1
    //   131: astore_2
    //   132: aload_1
    //   133: astore_3
    //   134: aload 4
    //   136: aload 5
    //   138: aload 6
    //   140: invokestatic 299	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   143: astore 5
    //   145: aload 5
    //   147: astore_2
    //   148: iload 10
    //   150: istore 7
    //   152: aload_2
    //   153: invokestatic 305	com/tencent/image/Utils:getBitmapSize	(Landroid/graphics/Bitmap;)I
    //   156: istore 8
    //   158: iload 8
    //   160: istore 7
    //   162: iload 8
    //   164: istore 9
    //   166: aload 4
    //   168: invokevirtual 310	java/io/InputStream:close	()V
    //   171: iload 8
    //   173: istore 7
    //   175: aload_2
    //   176: astore 4
    //   178: aload 4
    //   180: ifnonnull +70 -> 250
    //   183: invokestatic 315	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   186: ifeq +30 -> 216
    //   189: getstatic 64	com/tencent/mobileqq/bubble/BubbleInfo:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   192: iconst_2
    //   193: new 317	java/lang/StringBuilder
    //   196: dup
    //   197: invokespecial 318	java/lang/StringBuilder:<init>	()V
    //   200: ldc_w 320
    //   203: invokevirtual 323	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: aload_1
    //   207: invokevirtual 323	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: invokevirtual 324	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   213: invokestatic 327	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   216: aconst_null
    //   217: areturn
    //   218: new 236	java/io/File
    //   221: dup
    //   222: aload_1
    //   223: invokespecial 330	java/io/File:<init>	(Ljava/lang/String;)V
    //   226: astore_2
    //   227: iconst_0
    //   228: istore 7
    //   230: goto -200 -> 30
    //   233: aload_1
    //   234: astore_2
    //   235: aload_1
    //   236: astore_3
    //   237: new 332	java/io/FileInputStream
    //   240: dup
    //   241: aload_1
    //   242: invokespecial 333	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   245: astore 4
    //   247: goto -117 -> 130
    //   250: invokestatic 315	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   253: ifeq +30 -> 283
    //   256: getstatic 64	com/tencent/mobileqq/bubble/BubbleInfo:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   259: iconst_2
    //   260: new 317	java/lang/StringBuilder
    //   263: dup
    //   264: invokespecial 318	java/lang/StringBuilder:<init>	()V
    //   267: ldc_w 335
    //   270: invokevirtual 323	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: aload_1
    //   274: invokevirtual 323	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: invokevirtual 324	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   280: invokestatic 327	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   283: new 337	android/graphics/drawable/BitmapDrawable
    //   286: dup
    //   287: aload_0
    //   288: invokevirtual 254	com/tencent/common/app/AppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   291: invokevirtual 257	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   294: aload 4
    //   296: invokespecial 340	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V
    //   299: astore_1
    //   300: aload_1
    //   301: aload_0
    //   302: invokevirtual 254	com/tencent/common/app/AppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   305: invokevirtual 257	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   308: invokevirtual 261	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   311: invokevirtual 344	android/graphics/drawable/BitmapDrawable:setTargetDensity	(Landroid/util/DisplayMetrics;)V
    //   314: new 161	com/tencent/util/Pair
    //   317: dup
    //   318: aload_1
    //   319: iload 7
    //   321: invokestatic 208	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   324: invokespecial 211	com/tencent/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   327: areturn
    //   328: astore_1
    //   329: aconst_null
    //   330: astore 4
    //   332: iload 8
    //   334: istore 7
    //   336: aload_2
    //   337: astore_1
    //   338: goto -160 -> 178
    //   341: astore_3
    //   342: aload_2
    //   343: astore 4
    //   345: goto -167 -> 178
    //   348: astore_1
    //   349: aconst_null
    //   350: astore 4
    //   352: iload 8
    //   354: istore 7
    //   356: aload_3
    //   357: astore_1
    //   358: goto -180 -> 178
    //   361: astore_3
    //   362: aload_2
    //   363: astore 4
    //   365: iload 9
    //   367: istore 7
    //   369: goto -191 -> 178
    //   372: iconst_0
    //   373: istore 7
    //   375: aconst_null
    //   376: astore_2
    //   377: goto -347 -> 30
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	380	0	paramAppInterface	com.tencent.common.app.AppInterface
    //   0	380	1	paramString	String
    //   29	348	2	localObject1	Object
    //   98	139	3	str	String
    //   341	16	3	localOutOfMemoryError	OutOfMemoryError
    //   361	1	3	localException	Exception
    //   128	236	4	localObject2	Object
    //   53	93	5	localObject3	Object
    //   62	77	6	localOptions	android.graphics.BitmapFactory.Options
    //   26	348	7	i1	int
    //   7	346	8	i2	int
    //   4	362	9	i3	int
    //   1	148	10	i4	int
    // Exception table:
    //   from	to	target	type
    //   99	110	328	java/lang/OutOfMemoryError
    //   114	130	328	java/lang/OutOfMemoryError
    //   134	145	328	java/lang/OutOfMemoryError
    //   237	247	328	java/lang/OutOfMemoryError
    //   152	158	341	java/lang/OutOfMemoryError
    //   166	171	341	java/lang/OutOfMemoryError
    //   99	110	348	java/lang/Exception
    //   114	130	348	java/lang/Exception
    //   134	145	348	java/lang/Exception
    //   237	247	348	java/lang/Exception
    //   152	158	361	java/lang/Exception
    //   166	171	361	java/lang/Exception
  }
  
  private Pair a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Pair localPair;
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localPair = (Pair)localIterator.next();
      } while (!paramString.equals(((BubbleInfo.CommonAttrs)localPair.first).jdField_b_of_type_JavaLangString));
    }
    for (paramString = localPair;; paramString = null) {
      return paramString;
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, View paramView, Drawable paramDrawable)
  {
    if ((paramDrawable == null) || (paramView == null)) {
      return;
    }
    paramQQAppInterface = new Rect();
    paramDrawable.getPadding(paramQQAppInterface);
    int i1 = paramView.getPaddingTop();
    int i2 = paramQQAppInterface.top;
    int i3 = paramView.getPaddingLeft();
    int i4 = paramQQAppInterface.left;
    int i5 = paramView.getPaddingRight();
    int i6 = paramQQAppInterface.right;
    int i7 = paramView.getPaddingBottom();
    int i8 = paramQQAppInterface.bottom;
    paramView.setBackgroundDrawable(paramDrawable);
    paramView.setPadding(i3 + i4, i1 + i2, i5 + i6, i8 + i7);
  }
  
  public Drawable a(QQAppInterface paramQQAppInterface, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, View paramView, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_g_of_type_JavaLangString, 2, "getBubbleDrawable, bubbleId=" + this.jdField_c_of_type_Int + ", isUser=" + paramBoolean1 + ", needVipBubble=" + paramBoolean2 + ", useAnimationBg=" + paramBoolean3 + ", senderUin=" + paramString);
    }
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramBoolean2)
    {
      if ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))) {
        break label616;
      }
      localObject2 = new VipBubbleDrawable(paramQQAppInterface.a().getResources(), this.jdField_a_of_type_AndroidGraphicsNinePatch, this.jdField_b_of_type_AndroidGraphicsNinePatch, this.jdField_c_of_type_Int);
      if (paramBoolean1) {
        break label611;
      }
      paramBoolean2 = true;
      ((VipBubbleDrawable)localObject2).a(paramBoolean2, paramBoolean3);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_g_of_type_JavaLangString, 2, "getBubbleDrawable, bubbleId=" + this.jdField_c_of_type_Int + ", vipBubbleDrawable=" + localObject2);
      }
      localObject1 = localObject2;
      if (!BubbleManager.jdField_a_of_type_Boolean)
      {
        localObject1 = localObject2;
        if (this.jdField_c_of_type_Int != 0)
        {
          BubbleManager.jdField_a_of_type_Boolean = true;
          localObject1 = localObject2;
        }
      }
    }
    label227:
    label241:
    Object localObject3;
    if (localObject1 == null) {
      if (paramBoolean1)
      {
        localObject2 = "bubblebg://default_mine";
        if (BaseApplicationImpl.a == null) {
          break label837;
        }
        localObject3 = (Drawable.ConstantState)BaseApplicationImpl.a.get(localObject2);
        if (localObject3 == null) {
          break label837;
        }
        if (QLog.isColorLevel()) {
          QLog.d(jdField_g_of_type_JavaLangString, 2, "getBubbleDrawable, get Default from imageCache, key=" + (String)localObject2 + ", bubbleId=" + this.jdField_c_of_type_Int);
        }
        localObject1 = ((Drawable.ConstantState)localObject3).newDrawable();
      }
    }
    label346:
    label364:
    label431:
    label575:
    label611:
    label616:
    label686:
    label694:
    label702:
    label710:
    label798:
    label814:
    label837:
    for (;;)
    {
      localObject2 = localObject1;
      int i1;
      if (localObject1 == null)
      {
        localObject2 = paramQQAppInterface.a().getResources();
        if (!paramBoolean1) {
          break label686;
        }
        i1 = 2130843068;
        localObject1 = ((Resources)localObject2).getDrawable(i1);
        if (!paramBoolean1) {
          break label694;
        }
        i1 = 2130843067;
        localObject2 = ((Resources)localObject2).getDrawable(i1);
        localObject3 = new StateListDrawable();
        ((StateListDrawable)localObject3).addState(new int[] { 16842919 }, (Drawable)localObject1);
        ((StateListDrawable)localObject3).addState(new int[] { 16842910 }, (Drawable)localObject2);
        localObject2 = localObject3;
        if (BaseApplicationImpl.a != null)
        {
          if (!paramBoolean1) {
            break label702;
          }
          localObject1 = "bubblebg://default_mine";
          if (QLog.isColorLevel()) {
            QLog.d(jdField_g_of_type_JavaLangString, 2, "getBubbleDrawable, put default bubble to imageCache, key=" + (String)localObject1 + ", bubbleId=" + this.jdField_c_of_type_Int);
          }
          BaseApplicationImpl.a.put(localObject1, ((StateListDrawable)localObject3).getConstantState());
          localObject2 = localObject3;
        }
      }
      int i2;
      if ((localObject2 != null) && ((localObject2 instanceof VipBubbleDrawable)) && (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)))
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleConfig$Chartlet == null) || (paramView == null)) {
          break label814;
        }
        i2 = paramView.getWidth();
        if (this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleConfig$Chartlet.jdField_a_of_type_Int != 0) {
          break label710;
        }
        ((VipBubbleDrawable)localObject2).a(true, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleConfig$Chartlet.jdField_a_of_type_ArrayOfInt, this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleConfig$Chartlet.jdField_a_of_type_JavaLangString);
        if (this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleConfig$DiyTextConfig == null) {
          break label798;
        }
        ((VipBubbleDrawable)localObject2).a(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleConfig$DiyTextConfig, paramString, paramInt);
      }
      for (;;)
      {
        a(paramQQAppInterface, paramView, (Drawable)localObject2);
        return (Drawable)localObject2;
        paramBoolean2 = false;
        break;
        if (this.jdField_c_of_type_Int != 100000)
        {
          localObject1 = localObject2;
          if (this.jdField_c_of_type_Int != 100001) {
            break label227;
          }
        }
        if (paramBoolean1) {}
        for (localObject1 = null;; localObject1 = a(paramQQAppInterface.a(), this.jdField_c_of_type_Int, paramBoolean1, paramBoolean3, this.x, this.y)) {
          break;
        }
        localObject2 = "bubblebg://default_friend";
        break label241;
        i1 = 2130843000;
        break label346;
        i1 = 2130842999;
        break label364;
        localObject1 = "bubblebg://default_friend";
        break label431;
        i1 = i2;
        if (i2 == 0)
        {
          paramView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
          i1 = paramView.getMeasuredWidth();
        }
        if (i1 > this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleConfig$Chartlet.jdField_a_of_type_Int)
        {
          ((VipBubbleDrawable)localObject2).a(true, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleConfig$Chartlet.jdField_a_of_type_ArrayOfInt, this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleConfig$Chartlet.jdField_a_of_type_JavaLangString);
          break label575;
        }
        ((VipBubbleDrawable)localObject2).a(false, null, null, null);
        break label575;
        ((VipBubbleDrawable)localObject2).a(paramQQAppInterface, null, "", 0);
        continue;
        if ((localObject2 instanceof VipBubbleDrawable)) {
          ((VipBubbleDrawable)localObject2).a(false, null, null, null);
        }
      }
    }
  }
  
  public Drawable a(QQAppInterface paramQQAppInterface, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, View paramView, boolean paramBoolean4)
  {
    BubbleConfig.Chartlet localChartlet = this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleConfig$Chartlet;
    if (!paramBoolean4) {
      this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleConfig$Chartlet = null;
    }
    paramQQAppInterface = a(paramQQAppInterface, paramBoolean1, paramBoolean2, paramBoolean3, paramView, "", 0);
    this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleConfig$Chartlet = localChartlet;
    return paramQQAppInterface;
  }
  
  public Pair a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    StringBuilder localStringBuilder = null;
    Object localObject1;
    if (paramQQAppInterface != null)
    {
      localObject1 = (BubbleManager)paramQQAppInterface.getManager(43);
      localObject2 = localStringBuilder;
      if (localObject1 != null)
      {
        localObject2 = ((BubbleManager)localObject1).a(this.jdField_c_of_type_Int, true);
        if (localObject2 != null) {
          break label53;
        }
        localObject2 = localStringBuilder;
      }
    }
    label53:
    label86:
    do
    {
      do
      {
        return (Pair)localObject2;
        localObject1 = null;
        break;
        switch (paramInt)
        {
        default: 
          paramQQAppInterface = null;
          localObject2 = localStringBuilder;
        }
      } while (TextUtils.isEmpty(paramQQAppInterface));
      localObject2 = a(paramQQAppInterface);
      localObject1 = ((BubbleManager)localObject1).a(this.jdField_c_of_type_Int, paramQQAppInterface, (Pair)localObject2);
      localObject2 = localObject1;
    } while (!QLog.isDevelopLevel());
    Object localObject2 = jdField_g_of_type_JavaLangString;
    localStringBuilder = new StringBuilder().append("getAttrs|key=").append(paramQQAppInterface).append(", animAttrs=");
    if (localObject1 == null) {}
    for (paramQQAppInterface = "null";; paramQQAppInterface = "first:" + ((Pair)localObject1).first + ",second:" + ((Pair)localObject1).second)
    {
      QLog.w((String)localObject2, 4, paramQQAppInterface);
      return (Pair)localObject1;
      if (((BubbleConfig)localObject2).a == null) {
        break;
      }
      paramQQAppInterface = ((BubbleConfig)localObject2).a.jdField_b_of_type_JavaLangString;
      break label86;
      if (((BubbleConfig)localObject2).b == null) {
        break;
      }
      paramQQAppInterface = ((BubbleConfig)localObject2).b.jdField_b_of_type_JavaLangString;
      break label86;
      paramQQAppInterface = "width";
      if (((BubbleConfig)localObject2).c == null) {
        break label86;
      }
      paramQQAppInterface = ((BubbleConfig)localObject2).c.jdField_b_of_type_JavaLangString;
      break label86;
      if ((this.jdField_a_of_type_JavaUtilHashMap == null) || (this.jdField_a_of_type_JavaUtilHashMap.size() <= 0) || (this.jdField_f_of_type_JavaLangString == null)) {
        break;
      }
      paramQQAppInterface = (String)this.jdField_a_of_type_JavaUtilHashMap.get(this.jdField_f_of_type_JavaLangString);
      break label86;
    }
  }
  
  public String a(String paramString)
  {
    if ((this.jdField_a_of_type_ArrayOfJavaLangString != null) && (!TextUtils.isEmpty(paramString)))
    {
      String[] arrayOfString = this.jdField_a_of_type_ArrayOfJavaLangString;
      int i2 = arrayOfString.length;
      int i1 = 0;
      while (i1 < i2)
      {
        String str = arrayOfString[i1];
        if (paramString.indexOf(str.toLowerCase()) != -1)
        {
          this.jdField_f_of_type_JavaLangString = str;
          return str;
        }
        i1 += 1;
      }
    }
    return null;
  }
  
  public void a()
  {
    synchronized (this.jdField_b_of_type_JavaUtilList)
    {
      this.jdField_b_of_type_JavaUtilList.clear();
    }
    synchronized (this.jdField_c_of_type_JavaUtilList)
    {
      this.jdField_c_of_type_JavaUtilList.clear();
      return;
      localObject1 = finally;
      throw ((Throwable)localObject1);
    }
  }
  
  public void a(View paramView, Drawable paramDrawable)
  {
    if ((paramDrawable == null) || (paramView == null)) {
      return;
    }
    Rect localRect = new Rect();
    paramDrawable.getPadding(localRect);
    int i1 = paramView.getPaddingTop();
    int i2 = localRect.top;
    int i3 = paramView.getPaddingLeft();
    int i4 = localRect.left;
    int i5 = paramView.getPaddingRight();
    int i6 = localRect.right;
    int i7 = paramView.getPaddingBottom();
    int i8 = localRect.bottom;
    paramView.setBackgroundDrawable(paramDrawable);
    paramView.setPadding(i3 + i4, i1 + i2, i5 + i6, i8 + i7);
  }
  
  public void a(View arg1, View paramView2)
  {
    synchronized (this.jdField_b_of_type_JavaUtilList)
    {
      this.jdField_b_of_type_JavaUtilList.remove(???);
    }
    synchronized (this.jdField_c_of_type_JavaUtilList)
    {
      this.jdField_c_of_type_JavaUtilList.remove(paramView2);
      return;
      ??? = finally;
      throw ???;
    }
  }
  
  public boolean a()
  {
    return (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString));
  }
  
  public boolean a(int paramInt)
  {
    return (this.jdField_g_of_type_Int > 0) && (this.h > this.jdField_g_of_type_Int) && (paramInt >= this.jdField_g_of_type_Int) && (paramInt <= this.h);
  }
  
  public String toString()
  {
    return "BubbleInfo [bubbleId=" + this.jdField_c_of_type_Int + ",aioUserBgNorResPath=" + this.jdField_a_of_type_JavaLangString + ",aioUserPicNorResPath=" + this.jdField_b_of_type_JavaLangString + ",bubbleThumbnailResPath=" + this.jdField_d_of_type_JavaLangString + ",bubbleChartletResPath=" + this.jdField_e_of_type_JavaLangString + ", mTextColor=" + this.jdField_d_of_type_Int + ", mKeyWords=" + Arrays.toString(this.jdField_a_of_type_ArrayOfJavaLangString) + ", currKeyWord=" + this.jdField_f_of_type_JavaLangString + ", mBubbleHeightBegin=" + this.jdField_g_of_type_Int + ", mBubbleHeightEnd=" + this.h + ", pttAttrs=" + this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs + ", heightAttrs=" + this.jdField_b_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs + ", keywordAttrs=" + this.jdField_a_of_type_JavaUtilList + ", keyWorsAnimMap=" + this.jdField_a_of_type_JavaUtilHashMap + "]";
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\bubble\BubbleInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
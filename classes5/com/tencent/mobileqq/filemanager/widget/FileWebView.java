package com.tencent.mobileqq.filemanager.widget;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ZoomButtonsController;
import com.tencent.mobileqq.filemanager.data.FMConfig;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Calendar;
import java.util.Timer;
import skb;

public class FileWebView
  extends WebView
{
  private static final String jdField_a_of_type_JavaLangString = "FileWebView";
  private static final String jdField_b_of_type_JavaLangString = "FileWebView";
  float jdField_a_of_type_Float = 1.0F;
  final int jdField_a_of_type_Int = 80;
  long jdField_a_of_type_Long = 0L;
  public FileWebView.TitilebarEventInterface a;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private Timer jdField_a_of_type_JavaUtilTimer;
  boolean jdField_a_of_type_Boolean = false;
  float jdField_b_of_type_Float = 0.0F;
  private boolean jdField_b_of_type_Boolean = true;
  float jdField_c_of_type_Float = 0.0F;
  private boolean jdField_c_of_type_Boolean = true;
  
  public FileWebView(Context paramContext)
  {
    this(paramContext, null);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    if (Build.VERSION.SDK_INT >= 11) {
      removeJavascriptInterface("searchBoxJavaBridge_");
    }
  }
  
  public FileWebView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    if (Build.VERSION.SDK_INT >= 11) {
      removeJavascriptInterface("searchBoxJavaBridge_");
    }
  }
  
  public FileWebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    if (Build.VERSION.SDK_INT >= 11) {
      removeJavascriptInterface("searchBoxJavaBridge_");
    }
    if (Integer.valueOf(Build.VERSION.SDK).intValue() < 11) {
      setZoomControlGone(this);
    }
    for (;;)
    {
      paramAttributeSet = FMConfig.b(paramContext, "FirstPreloadSwitch");
      paramContext = FMConfig.b(paramContext, "MorePreloadSwitch");
      try
      {
        this.jdField_c_of_type_Boolean = Boolean.parseBoolean(paramContext);
        this.jdField_b_of_type_Boolean = Boolean.parseBoolean(paramAttributeSet);
        return;
      }
      catch (Exception paramContext)
      {
        QLog.e("FileWebView", 1, "getPreloadPreviewConfig error!!!");
      }
      getSettings().setDisplayZoomControls(false);
    }
  }
  
  private Class a(ParameterizedType paramParameterizedType, int paramInt)
  {
    paramParameterizedType = paramParameterizedType.getActualTypeArguments()[paramInt];
    if ((paramParameterizedType instanceof ParameterizedType)) {
      return (Class)((ParameterizedType)paramParameterizedType).getRawType();
    }
    if ((paramParameterizedType instanceof GenericArrayType)) {
      return (Class)((GenericArrayType)paramParameterizedType).getGenericComponentType();
    }
    if ((paramParameterizedType instanceof TypeVariable)) {
      return a(((TypeVariable)paramParameterizedType).getBounds()[0], 0);
    }
    return (Class)paramParameterizedType;
  }
  
  private Class a(Type paramType, int paramInt)
  {
    if ((paramType instanceof ParameterizedType)) {
      return a((ParameterizedType)paramType, paramInt);
    }
    if ((paramType instanceof TypeVariable)) {
      return a(((TypeVariable)paramType).getBounds()[0], 0);
    }
    return (Class)paramType;
  }
  
  public void a()
  {
    if (!this.jdField_b_of_type_Boolean) {
      return;
    }
    new Handler().postDelayed(new skb(this), 500L);
  }
  
  public boolean a()
  {
    float f = getScale();
    return Math.abs(this.jdField_a_of_type_Float - f) < 0.1D;
  }
  
  /* Error */
  public boolean a(WebView paramWebView, String paramString, FileWebView.JSInterface paramJSInterface)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnonnull +5 -> 6
    //   4: iconst_0
    //   5: ireturn
    //   6: aload_2
    //   7: ldc -74
    //   9: invokevirtual 187	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   12: ifne +5 -> 17
    //   15: iconst_0
    //   16: ireturn
    //   17: aload_2
    //   18: ldc -67
    //   20: invokevirtual 193	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   23: astore 4
    //   25: aload_2
    //   26: invokevirtual 196	java/lang/String:length	()I
    //   29: iconst_1
    //   30: if_icmple +542 -> 572
    //   33: aload 4
    //   35: arraylength
    //   36: iconst_1
    //   37: if_icmple +535 -> 572
    //   40: aload 4
    //   42: iconst_0
    //   43: aaload
    //   44: astore_1
    //   45: aload 4
    //   47: iconst_1
    //   48: aaload
    //   49: ldc -58
    //   51: ldc -56
    //   53: invokevirtual 204	java/lang/String:replaceFirst	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   56: astore_2
    //   57: new 206	java/lang/StringBuilder
    //   60: dup
    //   61: invokespecial 207	java/lang/StringBuilder:<init>	()V
    //   64: aload_1
    //   65: invokevirtual 211	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: ldc -43
    //   70: invokevirtual 211	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: invokevirtual 217	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   76: ldc -37
    //   78: invokevirtual 193	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   81: invokestatic 225	java/util/Arrays:asList	([Ljava/lang/Object;)Ljava/util/List;
    //   84: astore_1
    //   85: aload_1
    //   86: invokeinterface 230 1 0
    //   91: iconst_5
    //   92: if_icmpge +5 -> 97
    //   95: iconst_0
    //   96: ireturn
    //   97: aload_1
    //   98: iconst_2
    //   99: invokeinterface 234 2 0
    //   104: checkcast 184	java/lang/String
    //   107: ldc -20
    //   109: invokevirtual 239	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   112: ifne +5 -> 117
    //   115: iconst_0
    //   116: ireturn
    //   117: aload_1
    //   118: iconst_3
    //   119: invokeinterface 234 2 0
    //   124: checkcast 184	java/lang/String
    //   127: astore 7
    //   129: aconst_null
    //   130: astore 4
    //   132: aload_2
    //   133: invokestatic 244	com/tencent/mobileqq/filemanager/util/FileManagerUtil:a	(Ljava/lang/String;)Ljava/util/LinkedHashMap;
    //   136: astore_1
    //   137: aload_1
    //   138: astore 4
    //   140: aload_3
    //   141: invokevirtual 248	java/lang/Object:getClass	()Ljava/lang/Class;
    //   144: invokevirtual 252	java/lang/Class:getMethods	()[Ljava/lang/reflect/Method;
    //   147: astore 8
    //   149: aload 8
    //   151: arraylength
    //   152: istore 10
    //   154: iconst_0
    //   155: istore 9
    //   157: aconst_null
    //   158: astore_1
    //   159: iload 9
    //   161: iload 10
    //   163: if_icmpge +401 -> 564
    //   166: aload 8
    //   168: iload 9
    //   170: aaload
    //   171: astore 6
    //   173: aload_1
    //   174: astore 5
    //   176: aload 6
    //   178: invokevirtual 257	java/lang/reflect/Method:getName	()Ljava/lang/String;
    //   181: aload 7
    //   183: invokevirtual 261	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   186: ifeq +92 -> 278
    //   189: aload 6
    //   191: invokevirtual 265	java/lang/reflect/Method:getParameterTypes	()[Ljava/lang/Class;
    //   194: astore_1
    //   195: aload_1
    //   196: astore 5
    //   198: aload_1
    //   199: arraylength
    //   200: aload 4
    //   202: invokevirtual 268	java/util/LinkedHashMap:size	()I
    //   205: if_icmpne +73 -> 278
    //   208: aload_1
    //   209: astore 5
    //   211: aload 6
    //   213: astore_1
    //   214: aload_1
    //   215: ifnull +339 -> 554
    //   218: aload 4
    //   220: invokevirtual 268	java/util/LinkedHashMap:size	()I
    //   223: ifne +67 -> 290
    //   226: aload_1
    //   227: aload_3
    //   228: iconst_0
    //   229: anewarray 49	java/lang/Object
    //   232: invokevirtual 272	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   235: pop
    //   236: iconst_1
    //   237: ireturn
    //   238: astore_1
    //   239: invokestatic 275	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   242: ifeq +29 -> 271
    //   245: ldc 8
    //   247: iconst_1
    //   248: new 206	java/lang/StringBuilder
    //   251: dup
    //   252: invokespecial 207	java/lang/StringBuilder:<init>	()V
    //   255: ldc_w 277
    //   258: invokevirtual 211	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: aload_2
    //   262: invokevirtual 211	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: invokevirtual 217	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   268: invokestatic 118	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   271: aload_1
    //   272: invokevirtual 280	java/lang/Exception:printStackTrace	()V
    //   275: goto -135 -> 140
    //   278: iload 9
    //   280: iconst_1
    //   281: iadd
    //   282: istore 9
    //   284: aload 5
    //   286: astore_1
    //   287: goto -128 -> 159
    //   290: aload 4
    //   292: invokevirtual 284	java/util/LinkedHashMap:values	()Ljava/util/Collection;
    //   295: invokeinterface 290 1 0
    //   300: astore_2
    //   301: aload 5
    //   303: arraylength
    //   304: anewarray 49	java/lang/Object
    //   307: astore 4
    //   309: iconst_0
    //   310: istore 9
    //   312: iload 9
    //   314: aload 5
    //   316: arraylength
    //   317: if_icmpge +209 -> 526
    //   320: aload_0
    //   321: aload 5
    //   323: iload 9
    //   325: aaload
    //   326: iload 9
    //   328: invokespecial 144	com/tencent/mobileqq/filemanager/widget/FileWebView:a	(Ljava/lang/reflect/Type;I)Ljava/lang/Class;
    //   331: invokevirtual 291	java/lang/Class:toString	()Ljava/lang/String;
    //   334: invokevirtual 294	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   337: astore 6
    //   339: aload 6
    //   341: ldc_w 296
    //   344: invokevirtual 300	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   347: ifne +14 -> 361
    //   350: aload 6
    //   352: ldc_w 302
    //   355: invokevirtual 300	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   358: ifeq +24 -> 382
    //   361: aload 4
    //   363: iload 9
    //   365: aload_2
    //   366: iload 9
    //   368: aaload
    //   369: checkcast 184	java/lang/String
    //   372: invokestatic 306	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   375: invokestatic 309	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   378: aastore
    //   379: goto +202 -> 581
    //   382: aload 6
    //   384: ldc_w 311
    //   387: invokevirtual 300	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   390: ifeq +42 -> 432
    //   393: aload 4
    //   395: iload 9
    //   397: aload_2
    //   398: iload 9
    //   400: aaload
    //   401: checkcast 184	java/lang/String
    //   404: invokestatic 317	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   407: invokestatic 320	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   410: aastore
    //   411: goto +170 -> 581
    //   414: astore_1
    //   415: invokestatic 275	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   418: ifeq +12 -> 430
    //   421: ldc 8
    //   423: iconst_2
    //   424: ldc_w 322
    //   427: invokestatic 118	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   430: iconst_0
    //   431: ireturn
    //   432: aload 6
    //   434: ldc_w 324
    //   437: invokevirtual 300	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   440: ifeq +36 -> 476
    //   443: aload 4
    //   445: iload 9
    //   447: aload_2
    //   448: iload 9
    //   450: aaload
    //   451: checkcast 184	java/lang/String
    //   454: aastore
    //   455: goto +126 -> 581
    //   458: astore_1
    //   459: invokestatic 275	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   462: ifeq +12 -> 474
    //   465: ldc 8
    //   467: iconst_2
    //   468: ldc_w 326
    //   471: invokestatic 118	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   474: iconst_0
    //   475: ireturn
    //   476: aload 6
    //   478: ldc_w 328
    //   481: invokevirtual 300	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   484: ifeq +97 -> 581
    //   487: aload 4
    //   489: iload 9
    //   491: aload_2
    //   492: iload 9
    //   494: aaload
    //   495: checkcast 184	java/lang/String
    //   498: invokestatic 100	java/lang/Boolean:parseBoolean	(Ljava/lang/String;)Z
    //   501: invokestatic 331	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   504: aastore
    //   505: goto +76 -> 581
    //   508: astore_1
    //   509: invokestatic 275	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   512: ifeq +12 -> 524
    //   515: ldc 8
    //   517: iconst_2
    //   518: ldc_w 333
    //   521: invokestatic 118	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   524: iconst_0
    //   525: ireturn
    //   526: aload_1
    //   527: aload_3
    //   528: aload 4
    //   530: invokevirtual 272	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   533: pop
    //   534: iconst_1
    //   535: ireturn
    //   536: astore_1
    //   537: invokestatic 275	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   540: ifeq +12 -> 552
    //   543: ldc 8
    //   545: iconst_2
    //   546: ldc_w 335
    //   549: invokestatic 118	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   552: iconst_0
    //   553: ireturn
    //   554: aload_3
    //   555: aload_2
    //   556: invokeinterface 340 2 0
    //   561: goto -325 -> 236
    //   564: aload_1
    //   565: astore 5
    //   567: aconst_null
    //   568: astore_1
    //   569: goto -355 -> 214
    //   572: ldc -56
    //   574: astore_1
    //   575: ldc -56
    //   577: astore_2
    //   578: goto -521 -> 57
    //   581: iload 9
    //   583: iconst_1
    //   584: iadd
    //   585: istore 9
    //   587: goto -275 -> 312
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	590	0	this	FileWebView
    //   0	590	1	paramWebView	WebView
    //   0	590	2	paramString	String
    //   0	590	3	paramJSInterface	FileWebView.JSInterface
    //   23	506	4	localObject1	Object
    //   174	392	5	localWebView	WebView
    //   171	306	6	localObject2	Object
    //   127	55	7	str	String
    //   147	20	8	arrayOfMethod	java.lang.reflect.Method[]
    //   155	431	9	i	int
    //   152	12	10	j	int
    // Exception table:
    //   from	to	target	type
    //   132	137	238	java/lang/Exception
    //   218	236	414	java/lang/IllegalAccessException
    //   290	309	414	java/lang/IllegalAccessException
    //   312	361	414	java/lang/IllegalAccessException
    //   361	379	414	java/lang/IllegalAccessException
    //   382	411	414	java/lang/IllegalAccessException
    //   432	455	414	java/lang/IllegalAccessException
    //   476	505	414	java/lang/IllegalAccessException
    //   526	534	414	java/lang/IllegalAccessException
    //   218	236	458	java/lang/IllegalArgumentException
    //   290	309	458	java/lang/IllegalArgumentException
    //   312	361	458	java/lang/IllegalArgumentException
    //   361	379	458	java/lang/IllegalArgumentException
    //   382	411	458	java/lang/IllegalArgumentException
    //   432	455	458	java/lang/IllegalArgumentException
    //   476	505	458	java/lang/IllegalArgumentException
    //   526	534	458	java/lang/IllegalArgumentException
    //   218	236	508	java/lang/reflect/InvocationTargetException
    //   290	309	508	java/lang/reflect/InvocationTargetException
    //   312	361	508	java/lang/reflect/InvocationTargetException
    //   361	379	508	java/lang/reflect/InvocationTargetException
    //   382	411	508	java/lang/reflect/InvocationTargetException
    //   432	455	508	java/lang/reflect/InvocationTargetException
    //   476	505	508	java/lang/reflect/InvocationTargetException
    //   526	534	508	java/lang/reflect/InvocationTargetException
    //   218	236	536	java/lang/Exception
    //   290	309	536	java/lang/Exception
    //   312	361	536	java/lang/Exception
    //   361	379	536	java/lang/Exception
    //   382	411	536	java/lang/Exception
    //   432	455	536	java/lang/Exception
    //   476	505	536	java/lang/Exception
    //   526	534	536	java/lang/Exception
  }
  
  public void destroy()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_JavaUtilTimer != null)
      {
        QLog.d("FileWebView", 4, "memoryleaktest webview timer " + this.jdField_a_of_type_JavaUtilTimer + " this " + this + "is cancel");
        this.jdField_a_of_type_JavaUtilTimer.cancel();
        this.jdField_a_of_type_JavaUtilTimer = null;
      }
      super.destroy();
      return;
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView$TitilebarEventInterface == null) {
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.dispatchTouchEvent(paramMotionEvent);
      this.jdField_a_of_type_Long = Calendar.getInstance().getTimeInMillis();
      this.jdField_b_of_type_Float = paramMotionEvent.getY();
      continue;
      if (Calendar.getInstance().getTimeInMillis() - this.jdField_a_of_type_Long < 80L)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView$TitilebarEventInterface.f();
        return super.dispatchTouchEvent(paramMotionEvent);
      }
      this.jdField_c_of_type_Float = paramMotionEvent.getY();
      if (this.jdField_b_of_type_Float > this.jdField_c_of_type_Float)
      {
        getContentHeight();
        getHeight();
        getWebScrollY();
        getScale();
        if (getContentHeight() * getScale() - (getView().getHeight() + getWebScrollY()) < 1.0D)
        {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView$TitilebarEventInterface.b();
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView$TitilebarEventInterface.d();
          return super.dispatchTouchEvent(paramMotionEvent);
        }
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView$TitilebarEventInterface.a();
      }
      do
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView$TitilebarEventInterface.d();
        break;
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView$TitilebarEventInterface.c();
      } while (getScrollY() >= 1.0F);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView$TitilebarEventInterface.a(false);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView$TitilebarEventInterface.d();
      return super.dispatchTouchEvent(paramMotionEvent);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView$TitilebarEventInterface.e();
    }
  }
  
  public boolean onCheckIsTextEditor()
  {
    if (this.jdField_a_of_type_Boolean) {
      return true;
    }
    return super.onCheckIsTextEditor();
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView$TitilebarEventInterface == null) {}
    do
    {
      return;
      paramInt1 = getContentHeight();
      paramInt3 = getView().getHeight();
      int i = getWebScrollY();
      float f = getScale();
      if (QLog.isDevelopLevel()) {
        QLog.d("FileWebView", 4, "contentHeight[" + paramInt1 + "],height[" + paramInt3 + "],scroolY[" + i + "],scale[" + f + "]");
      }
      f = getContentHeight() * getScale() - (getView().getHeight() + getWebScrollY());
      if ((f < paramInt3 * 2) && (!FileManagerUtil.a()) && (this.jdField_c_of_type_Boolean)) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView$TitilebarEventInterface.g();
      }
      if (f < 2.5D) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView$TitilebarEventInterface.b();
      }
    } while ((paramInt2 != 0) || (paramInt4 == 0));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView$TitilebarEventInterface.a(false);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramInt2 != 0) {
      super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void setOnCustomScroolChangeListener(FileWebView.TitilebarEventInterface paramTitilebarEventInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView$TitilebarEventInterface = paramTitilebarEventInterface;
  }
  
  public void setOverrideOnCheckIsTextEditor(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setZoomControlGone(View paramView)
  {
    try
    {
      Field localField = WebView.class.getDeclaredField("mZoomButtonsController");
      localField.setAccessible(true);
      ZoomButtonsController localZoomButtonsController = new ZoomButtonsController(paramView);
      localZoomButtonsController.getZoomControls().setVisibility(8);
      return;
    }
    catch (SecurityException paramView)
    {
      try
      {
        localField.set(paramView, localZoomButtonsController);
        return;
      }
      catch (IllegalArgumentException paramView)
      {
        paramView.printStackTrace();
        return;
        paramView = paramView;
        paramView.printStackTrace();
        return;
      }
      catch (IllegalAccessException paramView)
      {
        paramView.printStackTrace();
        return;
      }
    }
    catch (NoSuchFieldException paramView)
    {
      paramView.printStackTrace();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\filemanager\widget\FileWebView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
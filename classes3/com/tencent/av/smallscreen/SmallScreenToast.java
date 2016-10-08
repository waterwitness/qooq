package com.tencent.av.smallscreen;

import android.content.Context;
import android.view.View;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;

public class SmallScreenToast
{
  static final String jdField_a_of_type_JavaLangString = "SmallScreenToast";
  Context jdField_a_of_type_AndroidContentContext;
  View jdField_a_of_type_AndroidViewView;
  WindowManager.LayoutParams jdField_a_of_type_AndroidViewWindowManager$LayoutParams;
  WindowManager jdField_a_of_type_AndroidViewWindowManager;
  boolean jdField_a_of_type_Boolean;
  
  public SmallScreenToast(Context paramContext, View paramView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams = new WindowManager.LayoutParams();
    this.jdField_a_of_type_AndroidViewView = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewWindowManager = ((WindowManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("window"));
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.height = -2;
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.width = -2;
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.flags = 776;
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.format = -3;
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.windowAnimations = 0;
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.type = 2010;
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.gravity = 51;
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.setTitle("Toast");
    this.jdField_a_of_type_AndroidViewView = paramView;
    a();
  }
  
  public WindowManager.LayoutParams a()
  {
    return this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams;
  }
  
  void a()
  {
    try
    {
      int i = ((Integer)this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.getClass().getField("privateFlags").get(this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams)).intValue();
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.getClass().getField("privateFlags").set(this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams, Integer.valueOf(i | 0x40));
      return;
    }
    catch (Exception localException) {}
  }
  
  /* Error */
  public boolean a()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: iload_3
    //   5: istore_2
    //   6: aload_0
    //   7: getfield 32	com/tencent/av/smallscreen/SmallScreenToast:jdField_a_of_type_Boolean	Z
    //   10: ifne +57 -> 67
    //   13: aload_0
    //   14: iconst_1
    //   15: putfield 32	com/tencent/av/smallscreen/SmallScreenToast:jdField_a_of_type_Boolean	Z
    //   18: invokestatic 124	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   21: ifeq +11 -> 32
    //   24: ldc 8
    //   26: iconst_2
    //   27: ldc 126
    //   29: invokestatic 130	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   32: aload_0
    //   33: getfield 46	com/tencent/av/smallscreen/SmallScreenToast:jdField_a_of_type_AndroidViewWindowManager	Landroid/view/WindowManager;
    //   36: aload_0
    //   37: getfield 30	com/tencent/av/smallscreen/SmallScreenToast:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   40: aload_0
    //   41: getfield 28	com/tencent/av/smallscreen/SmallScreenToast:jdField_a_of_type_AndroidViewWindowManager$LayoutParams	Landroid/view/WindowManager$LayoutParams;
    //   44: invokeinterface 134 3 0
    //   49: iload_3
    //   50: istore_2
    //   51: invokestatic 124	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   54: ifeq +13 -> 67
    //   57: ldc 8
    //   59: iconst_2
    //   60: ldc -120
    //   62: invokestatic 130	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   65: iload_3
    //   66: istore_2
    //   67: aload_0
    //   68: getfield 30	com/tencent/av/smallscreen/SmallScreenToast:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   71: invokevirtual 142	android/view/View:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   74: checkcast 25	android/view/WindowManager$LayoutParams
    //   77: ifnull +221 -> 298
    //   80: iload_2
    //   81: ifeq +217 -> 298
    //   84: aload_0
    //   85: getfield 34	com/tencent/av/smallscreen/SmallScreenToast:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   88: invokestatic 148	com/tencent/av/smallscreen/SmallScreenUtils:c	(Landroid/content/Context;)Z
    //   91: istore_2
    //   92: invokestatic 124	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   95: ifeq +56 -> 151
    //   98: ldc 8
    //   100: iconst_2
    //   101: new 150	java/lang/StringBuilder
    //   104: dup
    //   105: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   108: ldc -103
    //   110: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: aload_0
    //   114: getfield 32	com/tencent/av/smallscreen/SmallScreenToast:jdField_a_of_type_Boolean	Z
    //   117: invokevirtual 160	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   120: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   123: invokestatic 130	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   126: ldc 8
    //   128: iconst_2
    //   129: new 150	java/lang/StringBuilder
    //   132: dup
    //   133: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   136: ldc -90
    //   138: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: iload_2
    //   142: invokevirtual 160	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   145: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   148: invokestatic 130	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   151: aload_0
    //   152: monitorexit
    //   153: iload_2
    //   154: ireturn
    //   155: astore_1
    //   156: aload_0
    //   157: getfield 46	com/tencent/av/smallscreen/SmallScreenToast:jdField_a_of_type_AndroidViewWindowManager	Landroid/view/WindowManager;
    //   160: aload_0
    //   161: getfield 30	com/tencent/av/smallscreen/SmallScreenToast:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   164: aload_0
    //   165: getfield 28	com/tencent/av/smallscreen/SmallScreenToast:jdField_a_of_type_AndroidViewWindowManager$LayoutParams	Landroid/view/WindowManager$LayoutParams;
    //   168: invokeinterface 169 3 0
    //   173: iload_3
    //   174: istore_2
    //   175: invokestatic 124	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   178: ifeq -111 -> 67
    //   181: ldc 8
    //   183: iconst_2
    //   184: new 150	java/lang/StringBuilder
    //   187: dup
    //   188: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   191: ldc -85
    //   193: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: aload_1
    //   197: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   200: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   203: invokestatic 130	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   206: iload_3
    //   207: istore_2
    //   208: goto -141 -> 67
    //   211: astore_1
    //   212: aload_0
    //   213: monitorexit
    //   214: aload_1
    //   215: athrow
    //   216: astore_1
    //   217: aload_0
    //   218: iconst_0
    //   219: putfield 32	com/tencent/av/smallscreen/SmallScreenToast:jdField_a_of_type_Boolean	Z
    //   222: invokestatic 124	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   225: ifeq +76 -> 301
    //   228: ldc 8
    //   230: iconst_2
    //   231: new 150	java/lang/StringBuilder
    //   234: dup
    //   235: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   238: ldc -85
    //   240: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: aload_1
    //   244: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   247: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   250: invokestatic 130	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   253: goto +48 -> 301
    //   256: astore_1
    //   257: aload_0
    //   258: iconst_0
    //   259: putfield 32	com/tencent/av/smallscreen/SmallScreenToast:jdField_a_of_type_Boolean	Z
    //   262: invokestatic 124	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   265: ifeq +28 -> 293
    //   268: ldc 8
    //   270: iconst_2
    //   271: new 150	java/lang/StringBuilder
    //   274: dup
    //   275: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   278: ldc -85
    //   280: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: aload_1
    //   284: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   287: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   290: invokestatic 130	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   293: iconst_0
    //   294: istore_2
    //   295: goto -228 -> 67
    //   298: goto -206 -> 92
    //   301: iconst_0
    //   302: istore_2
    //   303: goto -236 -> 67
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	306	0	this	SmallScreenToast
    //   155	42	1	localIllegalStateException	IllegalStateException
    //   211	4	1	localObject	Object
    //   216	28	1	localBadTokenException	android.view.WindowManager.BadTokenException
    //   256	28	1	localSecurityException	SecurityException
    //   5	298	2	bool1	boolean
    //   1	206	3	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   18	32	155	java/lang/IllegalStateException
    //   32	49	155	java/lang/IllegalStateException
    //   51	65	155	java/lang/IllegalStateException
    //   6	18	211	finally
    //   18	32	211	finally
    //   32	49	211	finally
    //   51	65	211	finally
    //   67	80	211	finally
    //   84	92	211	finally
    //   92	151	211	finally
    //   151	153	211	finally
    //   156	173	211	finally
    //   175	206	211	finally
    //   212	214	211	finally
    //   217	253	211	finally
    //   257	293	211	finally
    //   18	32	216	android/view/WindowManager$BadTokenException
    //   32	49	216	android/view/WindowManager$BadTokenException
    //   51	65	216	android/view/WindowManager$BadTokenException
    //   18	32	256	java/lang/SecurityException
    //   32	49	256	java/lang/SecurityException
    //   51	65	256	java/lang/SecurityException
  }
  
  public void b()
  {
    try
    {
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_Boolean = false;
      }
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("SmallScreenToast", 2, "WL_DEBUG stopHandler removeView start");
        }
        this.jdField_a_of_type_AndroidViewWindowManager.removeView(this.jdField_a_of_type_AndroidViewView);
        if (QLog.isColorLevel()) {
          QLog.d("SmallScreenToast", 2, "WL_DEBUG stopHandler removeView end");
        }
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("SmallScreenToast", 2, "WL_DEBUG stopHandler error : " + localIllegalArgumentException);
          }
        }
      }
      return;
    }
    finally {}
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Boolean) {}
    try
    {
      this.jdField_a_of_type_AndroidViewWindowManager.updateViewLayout(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("SmallScreenToast", 2, "WL_DEBUG layout error : " + localIllegalArgumentException);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\smallscreen\SmallScreenToast.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
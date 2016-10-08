package com.tencent.biz.widgets;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.hardware.Camera.Size;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.ViewGroup;
import com.tencent.mobileqq.R.styleable;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.kapalaiadapter.KapalaiAdapterUtil;
import com.tencent.mobileqq.utils.kapalaiadapter.MobileIssueSettings;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.CameraUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import jiz;
import jja;
import jjc;
import jjd;
import jjf;
import jjg;
import jjh;
import jjj;
import jjk;
import jjl;
import jjr;

public class ScannerView
  extends ViewGroup
  implements Camera.PreviewCallback, SurfaceHolder.Callback, Comparator
{
  static final int jdField_a_of_type_Int = 1;
  public static final String a;
  static final int jdField_b_of_type_Int = 2;
  static final int jdField_c_of_type_Int = 3;
  static final int jdField_d_of_type_Int = 4;
  static final int jdField_e_of_type_Int = 5;
  static final int jdField_f_of_type_Int = 6;
  static final int jdField_g_of_type_Int = 7;
  static final int jdField_h_of_type_Int = 8;
  static final int jdField_i_of_type_Int = 9;
  static final int j = 10;
  static final int k = 76800;
  static final int l = 921600;
  static final int m = 250;
  static final int n = 1024;
  private int A = -1;
  private int B = -1;
  private int C = 17;
  private float jdField_a_of_type_Float;
  public long a;
  public Rect a;
  public Camera a;
  private SensorManager jdField_a_of_type_AndroidHardwareSensorManager;
  Handler jdField_a_of_type_AndroidOsHandler;
  private SurfaceView jdField_a_of_type_AndroidViewSurfaceView;
  private ScannerView.FileDecodeListener jdField_a_of_type_ComTencentBizWidgetsScannerView$FileDecodeListener;
  private ScannerView.FlashLightListener jdField_a_of_type_ComTencentBizWidgetsScannerView$FlashLightListener;
  private ScannerView.ScannerListener jdField_a_of_type_ComTencentBizWidgetsScannerView$ScannerListener;
  public StringBuilder a;
  ReentrantLock jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock = new ReentrantLock();
  private jjh jdField_a_of_type_Jjh;
  jjk jdField_a_of_type_Jjk;
  private jjl jdField_a_of_type_Jjl;
  private jjr jdField_a_of_type_Jjr;
  public boolean a;
  private float jdField_b_of_type_Float;
  public long b;
  public Rect b;
  public Handler b;
  String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private float jdField_c_of_type_Float;
  Rect jdField_c_of_type_AndroidGraphicsRect = new Rect();
  private boolean jdField_c_of_type_Boolean;
  private boolean jdField_d_of_type_Boolean;
  private boolean jdField_e_of_type_Boolean;
  private boolean jdField_f_of_type_Boolean;
  private boolean jdField_g_of_type_Boolean;
  private boolean jdField_h_of_type_Boolean;
  private boolean jdField_i_of_type_Boolean;
  public int o;
  public int p;
  int q;
  int r;
  public int s;
  public int t;
  public int u;
  public int v = 0;
  private int w;
  private int x;
  private int y;
  private int z;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = ScannerView.class.getSimpleName();
  }
  
  public ScannerView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidGraphicsRect = null;
    this.jdField_b_of_type_AndroidGraphicsRect = null;
    this.f = true;
    this.h = true;
    this.jdField_b_of_type_AndroidOsHandler = new jiz(this);
    a(paramContext, null);
  }
  
  public ScannerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidGraphicsRect = null;
    this.jdField_b_of_type_AndroidGraphicsRect = null;
    this.f = true;
    this.h = true;
    this.jdField_b_of_type_AndroidOsHandler = new jiz(this);
    a(paramContext, paramAttributeSet);
  }
  
  private Point a(Camera paramCamera, int paramInt1, int paramInt2)
  {
    paramCamera = paramCamera.getParameters();
    Camera.Size localSize1 = paramCamera.getPreviewSize();
    if (("samsung".equalsIgnoreCase(Build.MANUFACTURER)) && ("GT-I9008L".equalsIgnoreCase(Build.MODEL)))
    {
      localObject1 = new Point(localSize1.width, localSize1.height);
      return (Point)localObject1;
    }
    paramCamera = paramCamera.getSupportedPreviewSizes();
    if (paramCamera == null) {
      return new Point(localSize1.width, localSize1.height);
    }
    Object localObject1 = new ArrayList(paramCamera);
    Collections.sort((List)localObject1, this);
    Object localObject2;
    if (QLog.isDevelopLevel())
    {
      paramCamera = new StringBuilder("manufacturer:").append(Build.MANUFACTURER).append(" model:").append(Build.MODEL).append("\ndefault size:").append(localSize1.width).append(" x ").append(localSize1.height).append("\nsizes:");
      localObject2 = ((List)localObject1).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Camera.Size localSize2 = (Camera.Size)((Iterator)localObject2).next();
        paramCamera.append(localSize2.width).append(" x ").append(localSize2.height).append(" | ");
      }
      QLog.d(jdField_a_of_type_JavaLangString, 4, paramCamera.toString());
    }
    paramCamera = null;
    float f3 = paramInt1 / paramInt2;
    float f1 = Float.POSITIVE_INFINITY;
    localObject1 = ((List)localObject1).iterator();
    label257:
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Camera.Size)((Iterator)localObject1).next();
      int i1 = ((Camera.Size)localObject2).width;
      int i2 = ((Camera.Size)localObject2).height;
      int i3 = i1 * i2;
      if ((i3 >= 76800) && (i3 <= 921600) && ((i1 != 980) || (i2 != 800) || (!"samsung".equalsIgnoreCase(Build.MANUFACTURER)) || ((!"GT-I9220".equalsIgnoreCase(Build.MODEL)) && (!"GT-N7000".equalsIgnoreCase(Build.MODEL)))) && (((i1 == 1184) && (i2 == 666)) || ((i1 != 704) || (i2 != 576) || (!"samsung".equalsIgnoreCase(Build.MANUFACTURER)) || (!"GT-I9300".equalsIgnoreCase(Build.MODEL)))))
      {
        if (paramInt1 > paramInt2)
        {
          i3 = 1;
          if (i1 >= i2) {
            break label480;
          }
          i4 = 1;
          label435:
          if (i3 != i4) {
            break label486;
          }
          i3 = i1;
        }
        for (int i4 = i2;; i4 = i1)
        {
          if ((i4 != paramInt1) || (i3 != paramInt2)) {
            break label497;
          }
          return new Point(i1, i2);
          i3 = 0;
          break;
          label480:
          i4 = 0;
          break label435;
          label486:
          i3 = i2;
        }
        label497:
        if ((i4 >= paramInt1 >> 1) && (i4 >> 1 <= paramInt1) && (i3 >= paramInt2 >> 1) && (i3 >> 1 <= paramInt2))
        {
          float f2 = Math.abs(i4 / i3 - f3);
          if (f2 >= f1) {
            break label596;
          }
          paramCamera = new Point(i1, i2);
          f1 = f2;
        }
      }
    }
    label596:
    for (;;)
    {
      break label257;
      localObject1 = paramCamera;
      if (paramCamera != null) {
        break;
      }
      return new Point(localSize1.width, localSize1.height);
    }
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    int i1 = 0;
    setKeepScreenOn(true);
    a(paramContext);
    this.jdField_a_of_type_AndroidViewSurfaceView = new SurfaceView(paramContext, paramAttributeSet);
    addView(this.jdField_a_of_type_AndroidViewSurfaceView);
    Object localObject = this.jdField_a_of_type_AndroidViewSurfaceView.getHolder();
    ((SurfaceHolder)localObject).addCallback(this);
    if (Build.VERSION.SDK_INT < 11) {
      ((SurfaceHolder)localObject).setType(3);
    }
    if ((paramAttributeSet != null) && (paramAttributeSet.getAttributeBooleanValue(0, true)))
    {
      localObject = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.aj);
      int i2 = ((TypedArray)localObject).getIndexCount();
      if (i1 < i2)
      {
        int i3 = ((TypedArray)localObject).getIndex(i1);
        switch (i3)
        {
        }
        for (;;)
        {
          i1 += 1;
          break;
          this.z = ((TypedArray)localObject).getDimensionPixelOffset(i3, this.z);
          continue;
          this.x = ((TypedArray)localObject).getDimensionPixelOffset(i3, this.x);
          continue;
          this.y = ((TypedArray)localObject).getDimensionPixelOffset(i3, this.y);
          continue;
          this.w = ((TypedArray)localObject).getDimensionPixelOffset(i3, this.w);
          continue;
          this.A = ((TypedArray)localObject).getLayoutDimension(i3, this.A);
          continue;
          this.B = ((TypedArray)localObject).getLayoutDimension(i3, this.B);
          continue;
          this.C = ((TypedArray)localObject).getInt(i3, this.C);
        }
      }
      ((TypedArray)localObject).recycle();
      this.jdField_a_of_type_Jjr = new jjr(paramContext);
      addView(this.jdField_a_of_type_Jjr);
    }
    if (paramAttributeSet != null) {
      this.jdField_b_of_type_Boolean = paramAttributeSet.getAttributeBooleanValue(8, true);
    }
  }
  
  private void a(Camera paramCamera, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        localParameters = paramCamera.getParameters();
        localObject = "torch";
        if (MobileIssueSettings.j) {
          continue;
        }
        localObject = KapalaiAdapterUtil.a().a(localParameters);
      }
      catch (RuntimeException paramCamera)
      {
        Camera.Parameters localParameters;
        Object localObject;
        paramBoolean = false;
        continue;
        paramCamera = Boolean.FALSE;
        continue;
        if (!paramBoolean) {
          continue;
        }
        continue;
      }
      localParameters.setFlashMode((String)localObject);
      paramCamera.setParameters(localParameters);
      if ((this.d) && (("auto".equals(this.jdField_b_of_type_JavaLangString)) || ("macro".equals(this.jdField_b_of_type_JavaLangString))))
      {
        this.jdField_a_of_type_Jjh = new jjh(this, this.jdField_a_of_type_AndroidHardwareCamera);
        this.jdField_a_of_type_Jjh.start();
      }
      this.e = paramBoolean;
      localObject = this.jdField_b_of_type_AndroidOsHandler;
      if (!paramBoolean) {
        continue;
      }
      paramCamera = Boolean.TRUE;
      ((Handler)localObject).obtainMessage(10, paramCamera).sendToTarget();
      return;
      localObject = "off";
    }
  }
  
  private boolean c()
  {
    boolean bool2 = false;
    this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
    label337:
    label345:
    label351:
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_AndroidHardwareCamera != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "camera already opened");
          }
          return true;
        }
        if (Build.VERSION.SDK_INT >= 9)
        {
          i2 = Camera.getNumberOfCameras();
          if (i2 <= 0) {
            break label345;
          }
          Object localObject1 = new Camera.CameraInfo();
          i1 = 0;
          if (i1 < i2)
          {
            Camera.getCameraInfo(i1, (Camera.CameraInfo)localObject1);
            if (((Camera.CameraInfo)localObject1).facing != 0) {}
          }
          else
          {
            if (i1 < i2) {
              break label337;
            }
            Camera.getCameraInfo(0, (Camera.CameraInfo)localObject1);
            i2 = 0;
            i1 = 1;
            this.jdField_a_of_type_AndroidHardwareCamera = CameraUtil.a(i2);
            i3 = ((Camera.CameraInfo)localObject1).orientation;
            i2 = i1;
            i1 = i3;
            break label351;
            if (MobileIssueSettings.a <= 0) {
              continue;
            }
            i3 = MobileIssueSettings.a;
            this.q = i3;
            this.r = i2;
            if (QLog.isColorLevel())
            {
              localObject1 = jdField_a_of_type_JavaLangString;
              StringBuilder localStringBuilder = new StringBuilder().append("camera open:");
              if (this.jdField_a_of_type_AndroidHardwareCamera == null) {
                continue;
              }
              bool1 = true;
              QLog.d((String)localObject1, 2, bool1 + " orientation:" + i1 + " facing:" + i2);
            }
            localObject1 = this.jdField_a_of_type_AndroidHardwareCamera;
            bool1 = bool2;
            if (localObject1 != null) {
              bool1 = true;
            }
            return bool1;
          }
          i1 += 1;
          continue;
        }
        else
        {
          this.jdField_a_of_type_AndroidHardwareCamera = CameraUtil.a();
          i2 = 0;
          i1 = 90;
          continue;
        }
        int i3 = i1;
        continue;
        boolean bool1 = false;
        continue;
        i2 = i1;
      }
      catch (RuntimeException localRuntimeException)
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "camera open failed:" + localRuntimeException.getMessage());
        }
        return false;
      }
      finally
      {
        this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
      }
      int i1 = 0;
      continue;
      i1 = 90;
      int i2 = 0;
    }
  }
  
  /* Error */
  private boolean d()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 98	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   4: invokevirtual 442	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   7: aload_0
    //   8: getfield 394	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   11: astore_1
    //   12: aload_1
    //   13: ifnonnull +12 -> 25
    //   16: aload_0
    //   17: getfield 98	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   20: invokevirtual 450	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   23: iconst_0
    //   24: ireturn
    //   25: aload_0
    //   26: getfield 380	com/tencent/biz/widgets/ScannerView:d	Z
    //   29: ifeq +34 -> 63
    //   32: aload_0
    //   33: getfield 399	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_Jjh	Ljjh;
    //   36: ifnull +20 -> 56
    //   39: aload_0
    //   40: getfield 399	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_Jjh	Ljjh;
    //   43: invokevirtual 500	jjh:isAlive	()Z
    //   46: ifeq +10 -> 56
    //   49: aload_0
    //   50: getfield 399	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_Jjh	Ljjh;
    //   53: invokevirtual 503	jjh:interrupt	()V
    //   56: aload_0
    //   57: getfield 394	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   60: invokevirtual 506	android/hardware/Camera:stopPreview	()V
    //   63: aload_0
    //   64: invokevirtual 510	com/tencent/biz/widgets/ScannerView:getContext	()Landroid/content/Context;
    //   67: ldc_w 512
    //   70: invokevirtual 516	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   73: checkcast 518	android/view/WindowManager
    //   76: invokeinterface 522 1 0
    //   81: invokevirtual 527	android/view/Display:getOrientation	()I
    //   84: bipush 90
    //   86: imul
    //   87: istore 7
    //   89: aload_0
    //   90: getfield 477	com/tencent/biz/widgets/ScannerView:r	I
    //   93: ifne +366 -> 459
    //   96: aload_0
    //   97: getfield 475	com/tencent/biz/widgets/ScannerView:q	I
    //   100: iload 7
    //   102: isub
    //   103: sipush 360
    //   106: iadd
    //   107: sipush 360
    //   110: irem
    //   111: istore 6
    //   113: aload_0
    //   114: iload 6
    //   116: putfield 529	com/tencent/biz/widgets/ScannerView:u	I
    //   119: invokestatic 445	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   122: ifeq +42 -> 164
    //   125: getstatic 87	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   128: iconst_2
    //   129: new 198	java/lang/StringBuilder
    //   132: dup
    //   133: invokespecial 478	java/lang/StringBuilder:<init>	()V
    //   136: ldc_w 531
    //   139: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: iload 7
    //   144: invokevirtual 214	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   147: ldc_w 533
    //   150: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: iload 6
    //   155: invokevirtual 214	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   158: invokevirtual 238	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   161: invokestatic 241	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   164: aload_0
    //   165: getfield 394	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   168: invokevirtual 138	android/hardware/Camera:getParameters	()Landroid/hardware/Camera$Parameters;
    //   171: astore_1
    //   172: getstatic 296	android/os/Build$VERSION:SDK_INT	I
    //   175: bipush 8
    //   177: if_icmplt +298 -> 475
    //   180: aload_0
    //   181: getfield 394	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   184: iload 6
    //   186: invokevirtual 536	android/hardware/Camera:setDisplayOrientation	(I)V
    //   189: aload_1
    //   190: invokevirtual 539	android/hardware/Camera$Parameters:isZoomSupported	()Z
    //   193: ifeq +15 -> 208
    //   196: aload_1
    //   197: iconst_2
    //   198: aload_1
    //   199: invokevirtual 542	android/hardware/Camera$Parameters:getMaxZoom	()I
    //   202: invokestatic 545	java/lang/Math:min	(II)I
    //   205: invokevirtual 548	android/hardware/Camera$Parameters:setZoom	(I)V
    //   208: aload_0
    //   209: getfield 394	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   212: aload_1
    //   213: invokevirtual 378	android/hardware/Camera:setParameters	(Landroid/hardware/Camera$Parameters;)V
    //   216: aload_0
    //   217: aload_0
    //   218: getfield 394	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   221: aload_0
    //   222: getfield 550	com/tencent/biz/widgets/ScannerView:s	I
    //   225: aload_0
    //   226: getfield 552	com/tencent/biz/widgets/ScannerView:t	I
    //   229: invokespecial 554	com/tencent/biz/widgets/ScannerView:a	(Landroid/hardware/Camera;II)Landroid/graphics/Point;
    //   232: astore_1
    //   233: aload_0
    //   234: aload_1
    //   235: getfield 555	android/graphics/Point:x	I
    //   238: putfield 557	com/tencent/biz/widgets/ScannerView:o	I
    //   241: aload_0
    //   242: aload_1
    //   243: getfield 558	android/graphics/Point:y	I
    //   246: putfield 560	com/tencent/biz/widgets/ScannerView:p	I
    //   249: invokestatic 445	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   252: ifeq +45 -> 297
    //   255: getstatic 87	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   258: iconst_2
    //   259: new 198	java/lang/StringBuilder
    //   262: dup
    //   263: invokespecial 478	java/lang/StringBuilder:<init>	()V
    //   266: ldc_w 562
    //   269: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: aload_1
    //   273: getfield 555	android/graphics/Point:x	I
    //   276: invokevirtual 214	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   279: ldc -40
    //   281: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: aload_1
    //   285: getfield 558	android/graphics/Point:y	I
    //   288: invokevirtual 214	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   291: invokevirtual 238	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   294: invokestatic 241	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   297: aload_0
    //   298: getfield 394	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   301: invokevirtual 138	android/hardware/Camera:getParameters	()Landroid/hardware/Camera$Parameters;
    //   304: astore_2
    //   305: aload_2
    //   306: aload_1
    //   307: getfield 555	android/graphics/Point:x	I
    //   310: aload_1
    //   311: getfield 558	android/graphics/Point:y	I
    //   314: invokevirtual 565	android/hardware/Camera$Parameters:setPreviewSize	(II)V
    //   317: aload_0
    //   318: getfield 394	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   321: aload_2
    //   322: invokevirtual 378	android/hardware/Camera:setParameters	(Landroid/hardware/Camera$Parameters;)V
    //   325: aload_0
    //   326: getfield 384	com/tencent/biz/widgets/ScannerView:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   329: astore_3
    //   330: aload_3
    //   331: astore_1
    //   332: aload_3
    //   333: ifnonnull +48 -> 381
    //   336: aload_0
    //   337: getfield 394	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   340: invokevirtual 138	android/hardware/Camera:getParameters	()Landroid/hardware/Camera$Parameters;
    //   343: astore 4
    //   345: aload 4
    //   347: invokevirtual 568	android/hardware/Camera$Parameters:getSupportedFocusModes	()Ljava/util/List;
    //   350: astore 5
    //   352: aload 5
    //   354: ifnonnull +222 -> 576
    //   357: aload_3
    //   358: astore_1
    //   359: aload_1
    //   360: ifnull +284 -> 644
    //   363: aload_1
    //   364: astore_2
    //   365: aload_0
    //   366: getfield 394	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   369: aload 4
    //   371: invokevirtual 378	android/hardware/Camera:setParameters	(Landroid/hardware/Camera$Parameters;)V
    //   374: aload_1
    //   375: astore_2
    //   376: aload_0
    //   377: aload_1
    //   378: putfield 384	com/tencent/biz/widgets/ScannerView:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   381: aload_0
    //   382: getfield 394	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   385: aload_0
    //   386: getfield 277	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_AndroidViewSurfaceView	Landroid/view/SurfaceView;
    //   389: invokevirtual 285	android/view/SurfaceView:getHolder	()Landroid/view/SurfaceHolder;
    //   392: invokevirtual 572	android/hardware/Camera:setPreviewDisplay	(Landroid/view/SurfaceHolder;)V
    //   395: aload_0
    //   396: getfield 394	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   399: invokevirtual 575	android/hardware/Camera:startPreview	()V
    //   402: aload_0
    //   403: iconst_1
    //   404: putfield 380	com/tencent/biz/widgets/ScannerView:d	Z
    //   407: ldc_w 382
    //   410: aload_1
    //   411: invokevirtual 388	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   414: ifne +13 -> 427
    //   417: ldc_w 390
    //   420: aload_1
    //   421: invokevirtual 388	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   424: ifeq +26 -> 450
    //   427: aload_0
    //   428: new 392	jjh
    //   431: dup
    //   432: aload_0
    //   433: aload_0
    //   434: getfield 394	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   437: invokespecial 397	jjh:<init>	(Lcom/tencent/biz/widgets/ScannerView;Landroid/hardware/Camera;)V
    //   440: putfield 399	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_Jjh	Ljjh;
    //   443: aload_0
    //   444: getfield 399	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_Jjh	Ljjh;
    //   447: invokevirtual 402	jjh:start	()V
    //   450: aload_0
    //   451: getfield 98	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   454: invokevirtual 450	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   457: iconst_1
    //   458: ireturn
    //   459: aload_0
    //   460: getfield 475	com/tencent/biz/widgets/ScannerView:q	I
    //   463: iload 7
    //   465: iadd
    //   466: sipush 360
    //   469: irem
    //   470: istore 6
    //   472: goto -359 -> 113
    //   475: iload 7
    //   477: sipush 180
    //   480: irem
    //   481: ifne +13 -> 494
    //   484: aload_1
    //   485: ldc_w 576
    //   488: ldc_w 578
    //   491: invokevirtual 582	android/hardware/Camera$Parameters:set	(Ljava/lang/String;Ljava/lang/String;)V
    //   494: aload_1
    //   495: iload 6
    //   497: invokevirtual 585	android/hardware/Camera$Parameters:setRotation	(I)V
    //   500: goto -292 -> 208
    //   503: astore_1
    //   504: invokestatic 445	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   507: ifeq +13 -> 520
    //   510: getstatic 87	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   513: iconst_2
    //   514: ldc_w 587
    //   517: invokestatic 241	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   520: aload_0
    //   521: getfield 98	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   524: invokevirtual 450	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   527: iconst_0
    //   528: ireturn
    //   529: astore_1
    //   530: invokestatic 445	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   533: ifeq -208 -> 325
    //   536: getstatic 87	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   539: iconst_2
    //   540: ldc_w 589
    //   543: invokestatic 241	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   546: goto -221 -> 325
    //   549: astore_1
    //   550: invokestatic 445	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   553: ifeq +13 -> 566
    //   556: getstatic 87	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   559: iconst_2
    //   560: ldc_w 587
    //   563: invokestatic 241	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   566: aload_0
    //   567: getfield 98	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   570: invokevirtual 450	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   573: goto -46 -> 527
    //   576: aload_3
    //   577: astore_2
    //   578: aload 5
    //   580: ldc_w 382
    //   583: invokeinterface 592 2 0
    //   588: ifeq +10 -> 598
    //   591: ldc_w 382
    //   594: astore_1
    //   595: goto -236 -> 359
    //   598: aload_3
    //   599: astore_2
    //   600: aload 5
    //   602: ldc_w 390
    //   605: invokeinterface 592 2 0
    //   610: ifeq +10 -> 620
    //   613: ldc_w 390
    //   616: astore_1
    //   617: goto -258 -> 359
    //   620: aload_3
    //   621: astore_1
    //   622: aload_3
    //   623: astore_2
    //   624: aload 5
    //   626: ldc_w 594
    //   629: invokeinterface 592 2 0
    //   634: ifeq -275 -> 359
    //   637: ldc_w 594
    //   640: astore_1
    //   641: goto -282 -> 359
    //   644: aload_1
    //   645: astore_2
    //   646: aload_0
    //   647: ldc_w 596
    //   650: putfield 384	com/tencent/biz/widgets/ScannerView:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   653: goto -272 -> 381
    //   656: astore_1
    //   657: aload_2
    //   658: astore_1
    //   659: invokestatic 445	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   662: ifeq -281 -> 381
    //   665: getstatic 87	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   668: iconst_2
    //   669: new 198	java/lang/StringBuilder
    //   672: dup
    //   673: invokespecial 478	java/lang/StringBuilder:<init>	()V
    //   676: ldc_w 598
    //   679: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   682: aload_2
    //   683: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   686: ldc_w 600
    //   689: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   692: invokevirtual 238	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   695: invokestatic 241	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   698: aload_2
    //   699: astore_1
    //   700: goto -319 -> 381
    //   703: astore_1
    //   704: aload_0
    //   705: getfield 98	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   708: invokevirtual 450	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   711: aload_1
    //   712: athrow
    //   713: astore_1
    //   714: goto -498 -> 216
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	717	0	this	ScannerView
    //   11	484	1	localObject1	Object
    //   503	1	1	localIOException	java.io.IOException
    //   529	1	1	localRuntimeException1	RuntimeException
    //   549	1	1	localRuntimeException2	RuntimeException
    //   594	51	1	localObject2	Object
    //   656	1	1	localRuntimeException3	RuntimeException
    //   658	42	1	localObject3	Object
    //   703	9	1	localObject4	Object
    //   713	1	1	localRuntimeException4	RuntimeException
    //   304	395	2	localObject5	Object
    //   329	294	3	str	String
    //   343	27	4	localParameters	Camera.Parameters
    //   350	275	5	localList	List
    //   111	385	6	i1	int
    //   87	394	7	i2	int
    // Exception table:
    //   from	to	target	type
    //   7	12	503	java/io/IOException
    //   25	56	503	java/io/IOException
    //   56	63	503	java/io/IOException
    //   63	113	503	java/io/IOException
    //   113	164	503	java/io/IOException
    //   164	208	503	java/io/IOException
    //   208	216	503	java/io/IOException
    //   216	297	503	java/io/IOException
    //   297	325	503	java/io/IOException
    //   325	330	503	java/io/IOException
    //   336	352	503	java/io/IOException
    //   365	374	503	java/io/IOException
    //   376	381	503	java/io/IOException
    //   381	427	503	java/io/IOException
    //   427	450	503	java/io/IOException
    //   459	472	503	java/io/IOException
    //   484	494	503	java/io/IOException
    //   494	500	503	java/io/IOException
    //   530	546	503	java/io/IOException
    //   578	591	503	java/io/IOException
    //   600	613	503	java/io/IOException
    //   624	637	503	java/io/IOException
    //   646	653	503	java/io/IOException
    //   659	698	503	java/io/IOException
    //   297	325	529	java/lang/RuntimeException
    //   7	12	549	java/lang/RuntimeException
    //   25	56	549	java/lang/RuntimeException
    //   56	63	549	java/lang/RuntimeException
    //   63	113	549	java/lang/RuntimeException
    //   113	164	549	java/lang/RuntimeException
    //   164	208	549	java/lang/RuntimeException
    //   216	297	549	java/lang/RuntimeException
    //   325	330	549	java/lang/RuntimeException
    //   336	352	549	java/lang/RuntimeException
    //   381	427	549	java/lang/RuntimeException
    //   427	450	549	java/lang/RuntimeException
    //   459	472	549	java/lang/RuntimeException
    //   484	494	549	java/lang/RuntimeException
    //   494	500	549	java/lang/RuntimeException
    //   530	546	549	java/lang/RuntimeException
    //   659	698	549	java/lang/RuntimeException
    //   365	374	656	java/lang/RuntimeException
    //   376	381	656	java/lang/RuntimeException
    //   578	591	656	java/lang/RuntimeException
    //   600	613	656	java/lang/RuntimeException
    //   624	637	656	java/lang/RuntimeException
    //   646	653	656	java/lang/RuntimeException
    //   7	12	703	finally
    //   25	56	703	finally
    //   56	63	703	finally
    //   63	113	703	finally
    //   113	164	703	finally
    //   164	208	703	finally
    //   208	216	703	finally
    //   216	297	703	finally
    //   297	325	703	finally
    //   325	330	703	finally
    //   336	352	703	finally
    //   365	374	703	finally
    //   376	381	703	finally
    //   381	427	703	finally
    //   427	450	703	finally
    //   459	472	703	finally
    //   484	494	703	finally
    //   494	500	703	finally
    //   504	520	703	finally
    //   530	546	703	finally
    //   550	566	703	finally
    //   578	591	703	finally
    //   600	613	703	finally
    //   624	637	703	finally
    //   646	653	703	finally
    //   659	698	703	finally
    //   208	216	713	java/lang/RuntimeException
  }
  
  private void e()
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {
      throw new RuntimeException("This method must be called on UI thread");
    }
  }
  
  private static boolean e()
  {
    if (("Lenovo K50-t5".equalsIgnoreCase(Build.MODEL)) && ("LENOVO".equalsIgnoreCase(Build.MANUFACTURER))) {}
    while (("Redmi Note 3".equalsIgnoreCase(Build.MODEL)) && ("Xiaomi".equalsIgnoreCase(Build.MANUFACTURER))) {
      return true;
    }
    return false;
  }
  
  /* Error */
  private void f()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 98	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   4: invokevirtual 442	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   7: aload_0
    //   8: getfield 394	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   11: astore_1
    //   12: aload_1
    //   13: ifnonnull +11 -> 24
    //   16: aload_0
    //   17: getfield 98	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   20: invokevirtual 450	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   23: return
    //   24: aload_0
    //   25: getfield 399	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_Jjh	Ljjh;
    //   28: ifnull +25 -> 53
    //   31: aload_0
    //   32: getfield 399	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_Jjh	Ljjh;
    //   35: invokevirtual 500	jjh:isAlive	()Z
    //   38: ifeq +15 -> 53
    //   41: aload_0
    //   42: getfield 399	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_Jjh	Ljjh;
    //   45: invokevirtual 503	jjh:interrupt	()V
    //   48: aload_0
    //   49: aconst_null
    //   50: putfield 399	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_Jjh	Ljjh;
    //   53: aload_0
    //   54: getfield 394	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   57: invokevirtual 138	android/hardware/Camera:getParameters	()Landroid/hardware/Camera$Parameters;
    //   60: astore_1
    //   61: aload_1
    //   62: ldc_w 423
    //   65: invokevirtual 374	android/hardware/Camera$Parameters:setFlashMode	(Ljava/lang/String;)V
    //   68: aload_0
    //   69: getfield 394	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   72: aload_1
    //   73: invokevirtual 378	android/hardware/Camera:setParameters	(Landroid/hardware/Camera$Parameters;)V
    //   76: aload_0
    //   77: iconst_0
    //   78: putfield 404	com/tencent/biz/widgets/ScannerView:e	Z
    //   81: aload_0
    //   82: getfield 380	com/tencent/biz/widgets/ScannerView:d	Z
    //   85: ifeq +15 -> 100
    //   88: aload_0
    //   89: iconst_0
    //   90: putfield 380	com/tencent/biz/widgets/ScannerView:d	Z
    //   93: aload_0
    //   94: getfield 394	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   97: invokevirtual 506	android/hardware/Camera:stopPreview	()V
    //   100: aload_0
    //   101: getfield 394	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   104: invokevirtual 623	android/hardware/Camera:release	()V
    //   107: aload_0
    //   108: aconst_null
    //   109: putfield 394	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   112: aload_0
    //   113: getfield 98	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   116: invokevirtual 450	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   119: return
    //   120: astore_1
    //   121: aload_0
    //   122: getfield 98	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   125: invokevirtual 450	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   128: aload_1
    //   129: athrow
    //   130: astore_1
    //   131: goto -50 -> 81
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	134	0	this	ScannerView
    //   11	62	1	localObject1	Object
    //   120	9	1	localObject2	Object
    //   130	1	1	localRuntimeException	RuntimeException
    // Exception table:
    //   from	to	target	type
    //   7	12	120	finally
    //   24	53	120	finally
    //   53	81	120	finally
    //   81	100	120	finally
    //   100	112	120	finally
    //   53	81	130	java/lang/RuntimeException
  }
  
  public int a(Camera.Size paramSize1, Camera.Size paramSize2)
  {
    int i1 = paramSize1.height * paramSize1.width;
    int i2 = paramSize2.height * paramSize2.width;
    if (i2 < i1) {
      return 1;
    }
    if (i2 > i1) {
      return -1;
    }
    return 0;
  }
  
  public SurfaceView a()
  {
    return this.jdField_a_of_type_AndroidViewSurfaceView;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidHardwareSensorManager != null)
    {
      this.jdField_a_of_type_AndroidHardwareSensorManager.unregisterListener(this.jdField_a_of_type_Jjl);
      this.jdField_a_of_type_AndroidHardwareSensorManager = null;
      this.jdField_a_of_type_Jjl = null;
    }
  }
  
  public void a(Context paramContext)
  {
    if (e()) {}
    do
    {
      return;
      this.jdField_a_of_type_AndroidHardwareSensorManager = ((SensorManager)paramContext.getSystemService("sensor"));
    } while (this.jdField_a_of_type_AndroidHardwareSensorManager == null);
    if (this.jdField_a_of_type_Jjl == null) {
      this.jdField_a_of_type_Jjl = new jjl(this);
    }
    paramContext = this.jdField_a_of_type_AndroidHardwareSensorManager.getDefaultSensor(1);
    this.jdField_a_of_type_AndroidHardwareSensorManager.registerListener(this.jdField_a_of_type_Jjl, paramContext, 2);
  }
  
  public void a(SensorEvent paramSensorEvent)
  {
    if ((this.jdField_a_of_type_AndroidHardwareCamera == null) || (!this.jdField_c_of_type_Boolean) || (this.jdField_a_of_type_Jjh == null) || (this.f)) {
      return;
    }
    float f1 = paramSensorEvent.values[0];
    float f2 = paramSensorEvent.values[1];
    float f3 = paramSensorEvent.values[2];
    if (!this.g)
    {
      this.jdField_a_of_type_Float = f1;
      this.jdField_b_of_type_Float = f2;
      this.jdField_c_of_type_Float = f3;
      this.g = true;
    }
    float f4 = Math.abs(this.jdField_a_of_type_Float - f1);
    float f5 = Math.abs(this.jdField_b_of_type_Float - f2);
    float f6 = Math.abs(this.jdField_c_of_type_Float - f3);
    if (((f4 > 0.5D) || (f5 > 0.5D) || (f6 > 0.5D)) && (this.h)) {}
    try
    {
      this.jdField_a_of_type_Jjh.a();
      this.jdField_a_of_type_Float = f1;
      this.jdField_b_of_type_Float = f2;
      this.jdField_c_of_type_Float = f3;
      return;
    }
    catch (RuntimeException paramSensorEvent)
    {
      for (;;) {}
    }
  }
  
  public void a(String paramString)
  {
    paramString = Uri.parse("file://" + paramString);
    if (this.jdField_a_of_type_Jjk == null) {}
    try
    {
      if (this.jdField_a_of_type_Jjk == null)
      {
        this.jdField_a_of_type_Jjk = new jjk("ScannerDecodeThread");
        this.jdField_a_of_type_Jjk.start();
        this.jdField_a_of_type_AndroidOsHandler = new jjj(this, this.jdField_a_of_type_Jjk.getLooper());
      }
      if (this.jdField_a_of_type_Jjk.a) {
        return;
      }
    }
    finally {}
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(6, paramString).sendToTarget();
  }
  
  public void a(boolean paramBoolean)
  {
    if ((this.i) && (d()))
    {
      if (this.jdField_a_of_type_Jjr != null) {
        this.jdField_a_of_type_Jjr.a();
      }
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      this.jdField_b_of_type_Long = 0L;
      this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessage(7);
      return;
    }
    this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessage(8);
  }
  
  public boolean a()
  {
    Object localObject = this.jdField_a_of_type_AndroidHardwareCamera;
    if (localObject != null) {
      try
      {
        localObject = ((Camera)localObject).getParameters();
        if (MobileIssueSettings.i)
        {
          if (!MobileIssueSettings.k) {
            return false;
          }
          if ((((Camera.Parameters)localObject).getSupportedFlashModes() == null) || (!getContext().getPackageManager().hasSystemFeature("android.hardware.camera.flash")))
          {
            boolean bool = MobileIssueSettings.l;
            if (!bool) {}
          }
          else
          {
            return true;
          }
        }
      }
      catch (RuntimeException localRuntimeException) {}
    }
    return false;
  }
  
  public void b()
  {
    this.jdField_b_of_type_Boolean = true;
    if (this.jdField_c_of_type_Boolean) {
      ThreadManager.a(new jjd(this), 8, null, false);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_AndroidHardwareCamera;
    if (localObject == null)
    {
      this.jdField_b_of_type_AndroidOsHandler.obtainMessage(10, Boolean.FALSE).sendToTarget();
      return;
    }
    if (this.e == paramBoolean)
    {
      Handler localHandler = this.jdField_b_of_type_AndroidOsHandler;
      if (paramBoolean) {}
      for (localObject = Boolean.TRUE;; localObject = Boolean.FALSE)
      {
        localHandler.obtainMessage(10, localObject).sendToTarget();
        return;
      }
    }
    if ((this.jdField_a_of_type_Jjh != null) && (this.jdField_a_of_type_Jjh.isAlive())) {
      this.jdField_a_of_type_Jjh.interrupt();
    }
    if (e())
    {
      ThreadManager.a(new jjg(this, paramBoolean), 8, null, false);
      return;
    }
    a((Camera)localObject, paramBoolean);
  }
  
  public boolean b()
  {
    return this.i;
  }
  
  public void c()
  {
    this.jdField_b_of_type_Boolean = false;
    if (this.jdField_a_of_type_Jjr != null) {
      this.jdField_a_of_type_Jjr.b();
    }
    ThreadManager.a(new jjf(this), 8, null, false);
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Jjk == null) {}
    do
    {
      try
      {
        if (this.jdField_a_of_type_Jjk == null)
        {
          this.jdField_a_of_type_Jjk = new jjk("ScannerDecodeThread");
          this.jdField_a_of_type_Jjk.start();
          this.jdField_a_of_type_AndroidOsHandler = new jjj(this, this.jdField_a_of_type_Jjk.getLooper());
        }
        if (this.jdField_a_of_type_Jjk.a) {
          return;
        }
      }
      finally {}
    } while (!this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.tryLock());
    try
    {
      Camera localCamera = this.jdField_a_of_type_AndroidHardwareCamera;
      if (localCamera == null) {
        return;
      }
      this.jdField_a_of_type_AndroidHardwareCamera.setOneShotPreviewCallback(this);
      return;
    }
    finally
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    a();
    try
    {
      if ((this.jdField_a_of_type_Jjk != null) && (!this.jdField_a_of_type_Jjk.a))
      {
        this.jdField_a_of_type_Jjk.quit();
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
        this.jdField_a_of_type_AndroidOsHandler = null;
      }
      this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      return;
    }
    finally {}
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_a_of_type_AndroidViewSurfaceView.layout(0, 0, paramInt3 - paramInt1, paramInt4 - paramInt2);
    if (this.jdField_a_of_type_Jjr != null)
    {
      this.jdField_a_of_type_Jjr.layout(0, 0, paramInt3 - paramInt1, paramInt4 - paramInt2);
      if (this.A != -1) {
        break label167;
      }
      int i1 = this.x;
      paramInt1 = paramInt3 - paramInt1 - this.y;
      paramInt3 = i1;
      if (this.B != -1) {
        break label249;
      }
      i1 = this.w;
      paramInt2 = paramInt4 - paramInt2 - this.z;
      paramInt4 = i1;
    }
    for (;;)
    {
      Rect localRect = this.jdField_a_of_type_AndroidGraphicsRect;
      if (this.jdField_c_of_type_AndroidGraphicsRect == null) {
        this.jdField_c_of_type_AndroidGraphicsRect = new Rect();
      }
      this.jdField_c_of_type_AndroidGraphicsRect.set(paramInt3, paramInt4, paramInt1, paramInt2);
      this.jdField_a_of_type_AndroidGraphicsRect = this.jdField_c_of_type_AndroidGraphicsRect;
      this.jdField_c_of_type_AndroidGraphicsRect = localRect;
      this.jdField_b_of_type_AndroidGraphicsRect = null;
      this.jdField_a_of_type_Jjr.a(paramInt3, paramInt4, paramInt1, paramInt2);
      return;
      label167:
      if ((this.C & 0x3) == 3)
      {
        paramInt3 = this.x;
        paramInt1 = this.A + paramInt3;
        break;
      }
      if ((this.C & 0x5) == 5)
      {
        paramInt1 = paramInt3 - paramInt1 - this.y;
        paramInt3 = paramInt1 - this.A;
        break;
      }
      paramInt3 = paramInt3 - paramInt1 - this.A >> 1;
      paramInt1 = this.A + paramInt3;
      break;
      label249:
      if ((this.C & 0x30) == 48)
      {
        paramInt4 = this.w;
        paramInt2 = this.B + paramInt4;
      }
      else if ((this.C & 0x50) == 80)
      {
        paramInt2 = paramInt4 - paramInt2 - this.z;
        paramInt4 = paramInt2 - this.B;
      }
      else
      {
        paramInt4 = paramInt4 - paramInt2 - this.B >> 1;
        paramInt2 = this.B + paramInt4;
      }
    }
  }
  
  public void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.obtainMessage(5, this.o, this.p, paramArrayOfByte).sendToTarget();
    }
  }
  
  public void setFileDecodeListener(ScannerView.FileDecodeListener paramFileDecodeListener)
  {
    e();
    this.jdField_a_of_type_ComTencentBizWidgetsScannerView$FileDecodeListener = paramFileDecodeListener;
  }
  
  public void setFlashLightListener(ScannerView.FlashLightListener paramFlashLightListener)
  {
    e();
    this.jdField_a_of_type_ComTencentBizWidgetsScannerView$FlashLightListener = paramFlashLightListener;
  }
  
  public void setScanListener(ScannerView.ScannerListener paramScannerListener)
  {
    e();
    this.jdField_a_of_type_ComTencentBizWidgetsScannerView$ScannerListener = paramScannerListener;
  }
  
  public void setViewFinder(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    e();
    this.C = 51;
    this.x = paramInt1;
    this.w = paramInt2;
    this.A = (paramInt3 - paramInt1);
    this.B = (paramInt4 - paramInt2);
    this.y = 0;
    this.z = 0;
    if (this.jdField_a_of_type_Jjr == null)
    {
      this.jdField_a_of_type_Jjr = new jjr(getContext());
      addView(this.jdField_a_of_type_Jjr);
      return;
    }
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect(paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_b_of_type_AndroidGraphicsRect = null;
    this.jdField_a_of_type_Jjr.a(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    this.s = paramInt2;
    this.t = paramInt3;
    if (this.jdField_b_of_type_Boolean)
    {
      if (this.d) {
        break label41;
      }
      ThreadManager.a(new jja(this), 8, null, false);
    }
    label41:
    while (d()) {
      return;
    }
    this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessage(8);
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    this.jdField_c_of_type_Boolean = true;
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    this.jdField_c_of_type_Boolean = false;
    ThreadManager.a(new jjc(this), 8, null, false);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\widgets\ScannerView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
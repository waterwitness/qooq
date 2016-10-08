package com.tencent.mobileqq.shortvideo.mediadevice;

import android.content.Context;
import android.graphics.ImageFormat;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.hardware.Camera.Size;
import android.text.TextUtils;
import android.view.SurfaceHolder;
import android.view.WindowManager;
import com.tencent.av.config.ConfigSystemImpl;
import com.tencent.mobileqq.activity.richmedia.FlowCameraConstant;
import com.tencent.mobileqq.activity.richmedia.FlowCameraMqqAction;
import com.tencent.mobileqq.activity.richmedia.view.CameraCover.PictureCallback;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.common.GloableValue;
import com.tencent.mobileqq.shortvideo.common.Observable;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import uqv;

public class CameraControl
  extends Observable
{
  public static final int a = 1;
  static CameraControl jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl;
  private static ArrayList jdField_a_of_type_JavaUtilArrayList;
  public static final int b = 2;
  public static String b;
  private static ArrayList jdField_b_of_type_JavaUtilArrayList;
  private static final boolean jdField_d_of_type_Boolean = false;
  private static boolean jdField_e_of_type_Boolean = false;
  private static boolean f = false;
  public static final int g = 0;
  public static final int h = 1;
  public static final int i = 2;
  public static final int j = 3;
  public static final int k = 4;
  public static final int l = 5;
  private static final int m = 15000;
  public Camera a;
  CameraControl.CameraInformation jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$CameraInformation = new CameraControl.CameraInformation(this);
  CameraControl.CustomSize jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$CustomSize;
  public boolean a;
  private byte[] jdField_a_of_type_ArrayOfByte;
  int[] jdField_a_of_type_ArrayOfInt;
  CameraControl.CustomSize jdField_b_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$CustomSize;
  boolean jdField_b_of_type_Boolean;
  private byte[] jdField_b_of_type_ArrayOfByte;
  public int c;
  int jdField_d_of_type_Int;
  int jdField_e_of_type_Int;
  public int f;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    if (!CameraControl.class.desiredAssertionStatus()) {}
    for (bool = true;; bool = false)
    {
      jdField_c_of_type_Boolean = bool;
      jdField_b_of_type_JavaLangString = CameraControl.class.getSimpleName();
      jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      jdField_b_of_type_JavaUtilArrayList = new ArrayList();
      return;
    }
  }
  
  public CameraControl()
  {
    this.jdField_c_of_type_Int = -1;
  }
  
  private CameraControl.CustomSize a(List paramList, int paramInt1, int paramInt2)
  {
    int i1 = -1;
    if (QLog.isColorLevel()) {
      QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] getHighVersionPreviewSize[wantedPreviewSize]: width=" + paramInt1 + "  height=" + paramInt2);
    }
    CameraControl.CustomSize localCustomSize = new CameraControl.CustomSize();
    int n = i1;
    if (paramList != null)
    {
      n = i1;
      if (!paramList.isEmpty())
      {
        paramList = paramList.iterator();
        n = -1;
        if (paramList.hasNext())
        {
          Camera.Size localSize = (Camera.Size)paramList.next();
          if ((localSize == null) || (localSize.height != paramInt2) || (localSize.width < paramInt1) || ((n >= 0) && (localSize.width > n))) {
            break label225;
          }
          n = localSize.width;
        }
      }
    }
    label225:
    for (;;)
    {
      break;
      if (n > 0)
      {
        localCustomSize.jdField_b_of_type_Int = paramInt2;
        localCustomSize.jdField_a_of_type_Int = n;
        if (localCustomSize.jdField_a_of_type_Int / 4 == localCustomSize.jdField_b_of_type_Int / 3)
        {
          if (QLog.isColorLevel()) {
            QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] getHighVersionPreviewSize[4:3]...");
          }
          return localCustomSize;
        }
        if (QLog.isColorLevel()) {
          QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] getHighVersionPreviewSize: RATIO_MUST_EQUAL=false");
        }
        return localCustomSize;
      }
      return null;
    }
  }
  
  private CameraControl.CustomSize a(List paramList, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    double d1 = paramInt4 / paramInt3;
    if (QLog.isColorLevel()) {
      QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] getPreviewSize[self-adaption] physicRatio=" + d1);
    }
    CameraControl.CustomSize localCustomSize = new CameraControl.CustomSize();
    Object localObject;
    long l1;
    long l2;
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      localObject = paramList.iterator();
      l1 = Long.MAX_VALUE;
      if (((Iterator)localObject).hasNext())
      {
        Camera.Size localSize = (Camera.Size)((Iterator)localObject).next();
        if ((localSize != null) && (localSize.width >= paramInt1) && (localSize.height >= paramInt2) && (localSize.width / localSize.height >= d1))
        {
          l2 = localSize.width * localSize.height;
          if (l2 < l1)
          {
            localCustomSize.jdField_a_of_type_Int = localSize.width;
            localCustomSize.jdField_b_of_type_Int = localSize.height;
            l1 = l2;
          }
        }
        for (;;)
        {
          break;
          if ((l2 == l1) && (localSize.width < localCustomSize.jdField_a_of_type_Int))
          {
            localCustomSize.jdField_a_of_type_Int = localSize.width;
            localCustomSize.jdField_b_of_type_Int = localSize.height;
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] getPreviewSize[self-adaption] have no resolution >= (w*h)");
    }
    if (((localCustomSize.jdField_a_of_type_Int <= 0) || (localCustomSize.jdField_b_of_type_Int <= 0)) && (paramList != null) && (!paramList.isEmpty()))
    {
      paramList = paramList.iterator();
      l1 = 0L;
      if (paramList.hasNext())
      {
        localObject = (Camera.Size)paramList.next();
        if ((localObject != null) && (((Camera.Size)localObject).width / ((Camera.Size)localObject).height >= d1))
        {
          l2 = ((Camera.Size)localObject).width * ((Camera.Size)localObject).height;
          if (l2 > l1)
          {
            localCustomSize.jdField_a_of_type_Int = ((Camera.Size)localObject).width;
            localCustomSize.jdField_b_of_type_Int = ((Camera.Size)localObject).height;
            l1 = l2;
          }
        }
        for (;;)
        {
          break;
          if ((l2 == l1) && (((Camera.Size)localObject).width < localCustomSize.jdField_a_of_type_Int))
          {
            localCustomSize.jdField_a_of_type_Int = ((Camera.Size)localObject).width;
            localCustomSize.jdField_b_of_type_Int = ((Camera.Size)localObject).height;
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] getPreviewSize[self-adaption] cSize.width=" + localCustomSize.jdField_a_of_type_Int + "  cSize.height=" + localCustomSize.jdField_b_of_type_Int);
    }
    if ((localCustomSize.jdField_a_of_type_Int > 0) && (localCustomSize.jdField_b_of_type_Int > 0)) {
      return localCustomSize;
    }
    return null;
  }
  
  public static CameraControl a()
  {
    if (jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl == null) {
        jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl = new CameraControl();
      }
      return jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl;
    }
    finally {}
  }
  
  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "unknown";
    case 0: 
      return "RM_CAMERA_OPEN_SUCCESS";
    case 1: 
      return "RM_CAMERA_USED_AV";
    case 2: 
      return "RM_CAMERA_COUNT_ZERO";
    case 3: 
      return "RM_CAMERA_OPEN_FAILED";
    }
    return "RM_CAMERA_GET_PARAM";
  }
  
  private static void a(ArrayList paramArrayList)
  {
    Object localObject = CameraAbility.a().b();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Camera.Size localSize = (Camera.Size)((Iterator)localObject).next();
        float f1 = localSize.width / localSize.height;
        if (!paramArrayList.contains(Float.valueOf(f1))) {
          paramArrayList.add(Float.valueOf(f1));
        }
      }
    }
  }
  
  private void a(List paramList)
  {
    if ((paramList == null) || (paramList.size() <= 0))
    {
      if (QLog.isColorLevel()) {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "printFpsRange[listFpsRange=null]");
      }
      return;
    }
    int n = 0;
    label31:
    if (n < paramList.size())
    {
      int[] arrayOfInt = (int[])paramList.get(n);
      if ((arrayOfInt == null) || (arrayOfInt.length < 2)) {
        break label128;
      }
      if (QLog.isColorLevel()) {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "printFpsRange[i=" + n + " fps[low]=" + arrayOfInt[0] + " fps[high]=" + arrayOfInt[1] + "]");
      }
    }
    for (;;)
    {
      n += 1;
      break label31;
      break;
      label128:
      if (QLog.isColorLevel()) {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "printFpsRange[i=" + n + " ele=null" + "]");
      }
    }
  }
  
  private boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (paramInt4 / paramInt5 <= 1.0D) {}
    while (paramInt2 * paramInt5 / (paramInt5 * paramInt3 / paramInt4) < paramInt1) {
      return false;
    }
    return true;
  }
  
  private boolean a(ArrayList paramArrayList, int paramInt1, int paramInt2)
  {
    if ((paramArrayList == null) || (paramArrayList.size() <= 0)) {}
    for (;;)
    {
      return false;
      int n = 0;
      while (n < paramArrayList.size())
      {
        Camera.Size localSize = (Camera.Size)paramArrayList.get(n);
        if ((localSize.width == paramInt1) && (localSize.height == paramInt2)) {
          return true;
        }
        n += 1;
      }
    }
  }
  
  private int[] a(List paramList)
  {
    int[] arrayOfInt1 = new int[2];
    int[] tmp5_4 = arrayOfInt1;
    tmp5_4[0] = 0;
    int[] tmp9_5 = tmp5_4;
    tmp9_5[1] = 0;
    tmp9_5;
    Object localObject1 = new ArrayList();
    Object localObject2 = paramList.iterator();
    int n = 0;
    if (((Iterator)localObject2).hasNext())
    {
      int[] arrayOfInt2 = (int[])((Iterator)localObject2).next();
      if ((arrayOfInt2 == null) || (arrayOfInt2.length < 2) || (arrayOfInt2[1] < n)) {
        break label312;
      }
      n = arrayOfInt2[1];
    }
    label208:
    label297:
    label312:
    for (;;)
    {
      break;
      if (n <= 0) {
        return null;
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject2 = (int[])paramList.next();
        if ((localObject2 != null) && (localObject2.length >= 2) && (localObject2[1] == n)) {
          ((ArrayList)localObject1).add(localObject2);
        }
      }
      if (((ArrayList)localObject1).size() <= 0) {
        return null;
      }
      paramList = ((ArrayList)localObject1).iterator();
      int i2 = 0;
      int i1 = Integer.MAX_VALUE;
      int i3;
      if (paramList.hasNext())
      {
        localObject1 = (int[])paramList.next();
        if (localObject1[0] >= 15000)
        {
          i3 = localObject1[0] - 15000;
          if (i3 >= i1) {
            break label297;
          }
          i1 = localObject1[0];
        }
      }
      for (i2 = i3;; i2 = i3)
      {
        i3 = i2;
        i2 = i1;
        i1 = i3;
        break;
        i3 = 15000 - localObject1[0];
        break label208;
        if (i1 != Integer.MAX_VALUE)
        {
          arrayOfInt1[0] = i2;
          arrayOfInt1[1] = n;
        }
        while ((arrayOfInt1[0] <= 0) || (arrayOfInt1[1] <= 0))
        {
          return null;
          arrayOfInt1[0] = n;
          arrayOfInt1[1] = n;
        }
        return arrayOfInt1;
        i3 = i1;
        i1 = i2;
      }
    }
  }
  
  private int[] a(List paramList, int paramInt)
  {
    int[] arrayOfInt2 = a(paramList);
    int[] arrayOfInt1 = arrayOfInt2;
    if (arrayOfInt2 == null) {
      arrayOfInt1 = b(paramList, paramInt);
    }
    return arrayOfInt1;
  }
  
  private int b(int paramInt)
  {
    int n = -1;
    switch (paramInt)
    {
    default: 
      paramInt = CameraAbility.b();
    }
    do
    {
      do
      {
        return paramInt;
        paramInt = n;
      } while (!CameraAbility.c());
      return CameraAbility.a();
      paramInt = n;
    } while (!CameraAbility.b());
    return CameraAbility.b();
  }
  
  private int[] b(List paramList, int paramInt)
  {
    int[] arrayOfInt1 = new int[2];
    int[] tmp5_4 = arrayOfInt1;
    tmp5_4[0] = Integer.MAX_VALUE;
    int[] tmp10_5 = tmp5_4;
    tmp10_5[1] = Integer.MAX_VALUE;
    tmp10_5;
    Object localObject = paramList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      int[] arrayOfInt2 = (int[])((Iterator)localObject).next();
      if ((arrayOfInt2 != null) && (arrayOfInt2.length >= 2) && (arrayOfInt2[0] >= paramInt) && (arrayOfInt2[1] < arrayOfInt1[1]))
      {
        arrayOfInt1[0] = arrayOfInt2[0];
        arrayOfInt1[1] = arrayOfInt2[1];
      }
    }
    if ((arrayOfInt1[0] == Integer.MAX_VALUE) || (arrayOfInt1[1] == Integer.MAX_VALUE))
    {
      arrayOfInt1[1] = 0;
      arrayOfInt1[0] = 0;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject = (int[])paramList.next();
        if ((localObject != null) && (localObject.length >= 2) && (localObject[0] <= paramInt) && (localObject[1] > arrayOfInt1[1]))
        {
          arrayOfInt1[0] = localObject[0];
          arrayOfInt1[1] = localObject[1];
        }
      }
    }
    if ((arrayOfInt1[0] != Integer.MAX_VALUE) && (arrayOfInt1[1] != Integer.MAX_VALUE)) {
      return arrayOfInt1;
    }
    return null;
  }
  
  private int c()
  {
    int n = ImageFormat.getBitsPerPixel(this.d);
    float f1 = n * 1.0F / 8.0F;
    int i1 = (int)(this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$CustomSize.jdField_b_of_type_Int * this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$CustomSize.jdField_a_of_type_Int * f1);
    if (QLog.isColorLevel()) {
      QLog.i(jdField_b_of_type_JavaLangString, 2, "startPreview getPreviewBufferSize:bitpixel=" + n + " byteNum=" + f1 + " bufSize=" + i1);
    }
    return i1;
  }
  
  private boolean e()
  {
    return !CameraCompatibleList.d(CameraCompatibleList.a);
  }
  
  private boolean e(int paramInt)
  {
    if (paramInt <= 0) {
      return false;
    }
    if ((this.jdField_a_of_type_ArrayOfByte == null) || (this.jdField_a_of_type_ArrayOfByte.length != paramInt)) {
      this.jdField_a_of_type_ArrayOfByte = new byte[paramInt];
    }
    if ((this.jdField_b_of_type_ArrayOfByte == null) || (this.jdField_b_of_type_ArrayOfByte.length != paramInt)) {
      this.jdField_b_of_type_ArrayOfByte = new byte[paramInt];
    }
    return true;
  }
  
  public int a()
  {
    return this.d;
  }
  
  public int a(int paramInt)
  {
    if (FlowCameraMqqAction.a()) {
      n = 1;
    }
    for (;;)
    {
      return n;
      if (!CameraAbility.a())
      {
        if (QLog.isColorLevel()) {
          QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] openCamera[failed]hasCameras=false");
        }
        return 2;
      }
      if (this.jdField_b_of_type_Boolean)
      {
        if (QLog.isColorLevel()) {
          QLog.i(jdField_b_of_type_JavaLangString, 2, "[openCamera]Camera is opened, Camera object " + this.jdField_a_of_type_AndroidHardwareCamera);
        }
        return 5;
      }
      int i1 = 0;
      n = 0;
      label84:
      if (i1 < 2) {}
      try
      {
        this.jdField_c_of_type_Int = b(paramInt);
        if (VersionUtils.c()) {}
        for (this.jdField_a_of_type_AndroidHardwareCamera = Camera.open(this.jdField_c_of_type_Int);; this.jdField_a_of_type_AndroidHardwareCamera = Camera.open())
        {
          n = 0;
          if (this.jdField_a_of_type_AndroidHardwareCamera == null) {
            break;
          }
          if (CameraAbility.a().a(this.jdField_a_of_type_AndroidHardwareCamera)) {
            break label234;
          }
          if (QLog.isColorLevel()) {
            QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] openCamera[failed]bindCamera=false");
          }
          return 4;
        }
        try
        {
          Thread.sleep(100L);
          n = 3;
          break label84;
          this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$CameraInformation = new CameraControl.CameraInformation(this);
          this.jdField_b_of_type_Boolean = true;
          return 0;
        }
        catch (InterruptedException localInterruptedException)
        {
          for (;;) {}
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        this.jdField_a_of_type_AndroidHardwareCamera = null;
        i1 += 1;
        if (QLog.isColorLevel()) {
          QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] openCamera[failed][RM_CAMERA_OPEN_FAILED]currentCount=" + i1, localException);
        }
        if (i1 >= 2) {}
      }
    }
  }
  
  public Camera.Parameters a()
  {
    try
    {
      Camera.Parameters localParameters = this.jdField_a_of_type_AndroidHardwareCamera.getParameters();
      return localParameters;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
  
  protected CameraControl.CameraInformation a(Context paramContext, int paramInt, Camera paramCamera)
  {
    paramCamera = new CameraControl.CameraInformation(this);
    try
    {
      paramContext = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
      Object localObject2 = Class.forName("android.hardware.Camera");
      Class localClass = Class.forName("android.hardware.Camera$CameraInfo");
      if (localClass == null)
      {
        paramCamera.jdField_c_of_type_Int = -1;
        paramCamera.jdField_b_of_type_Int = -1;
        return paramCamera;
      }
      Object localObject1 = localClass.newInstance();
      if (localObject1 == null)
      {
        paramCamera.jdField_c_of_type_Int = -1;
        paramCamera.jdField_b_of_type_Int = -1;
        return paramCamera;
      }
      Field localField1 = localObject1.getClass().getField("facing");
      Field localField2 = localObject1.getClass().getField("orientation");
      if ((localField1 == null) || (localField2 == null))
      {
        paramCamera.jdField_c_of_type_Int = -1;
        paramCamera.jdField_b_of_type_Int = -1;
        return paramCamera;
      }
      localObject2 = ((Class)localObject2).getMethod("getCameraInfo", new Class[] { Integer.TYPE, localClass });
      if (localObject2 == null)
      {
        paramCamera.jdField_c_of_type_Int = -1;
        paramCamera.jdField_b_of_type_Int = -1;
        return paramCamera;
      }
      ((Method)localObject2).invoke(null, new Object[] { Integer.valueOf(paramInt), localObject1 });
      paramCamera.jdField_a_of_type_Int = localField1.getInt(localObject1);
      paramCamera.jdField_b_of_type_Int = localField2.getInt(localObject1);
      if (paramContext == null)
      {
        paramCamera.jdField_c_of_type_Int = -1;
        return paramCamera;
      }
      localObject1 = paramContext.getClass().getMethod("getRotation", new Class[0]);
      if (localObject1 == null)
      {
        paramCamera.jdField_c_of_type_Int = -1;
        return paramCamera;
      }
      switch (Integer.parseInt(((Method)localObject1).invoke(paramContext, (Object[])null).toString()))
      {
      case 0: 
        paramCamera.jdField_c_of_type_Int = 0;
      }
    }
    catch (Exception paramContext)
    {
      paramCamera.jdField_c_of_type_Int = 0;
      return paramCamera;
    }
    paramCamera.jdField_c_of_type_Int = 90;
    return paramCamera;
    paramCamera.jdField_c_of_type_Int = 180;
    return paramCamera;
    paramCamera.jdField_c_of_type_Int = 270;
    return paramCamera;
  }
  
  public CameraControl.CustomSize a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$CustomSize;
  }
  
  public CameraControl.CustomSize a(int paramInt1, int paramInt2)
  {
    Object localObject2 = CameraAbility.a().a();
    Object localObject1 = new ArrayList();
    CameraControl.CustomSize localCustomSize = new CameraControl.CustomSize();
    if ((localObject2 != null) && (((List)localObject2).size() > 0))
    {
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Camera.Size localSize = (Camera.Size)((Iterator)localObject2).next();
        if ((localSize != null) && (localSize.height >= paramInt2) && (localSize.width >= paramInt1)) {
          ((List)localObject1).add(localSize);
        }
      }
    }
    if (((List)localObject1).size() > 0)
    {
      localObject1 = ((List)localObject1).iterator();
      paramInt1 = Integer.MAX_VALUE;
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Camera.Size)((Iterator)localObject1).next();
        paramInt2 = ((Camera.Size)localObject2).height * ((Camera.Size)localObject2).width;
        if (paramInt2 >= paramInt1) {
          break label202;
        }
        localCustomSize.jdField_b_of_type_Int = ((Camera.Size)localObject2).height;
        localCustomSize.jdField_a_of_type_Int = ((Camera.Size)localObject2).width;
        paramInt1 = paramInt2;
      }
    }
    label202:
    for (;;)
    {
      break;
      if (localCustomSize.jdField_a_of_type_Int > 0) {
        return localCustomSize;
      }
      return null;
    }
  }
  
  public CameraControl.CustomSize a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] getPreviewSizeGuaranteeOK: dstwidth=" + paramInt1 + "  dstheight=" + paramInt2);
    }
    Object localObject = CameraAbility.a().a();
    if ((QLog.isColorLevel()) && (localObject != null))
    {
      int n = 0;
      while (n < ((List)localObject).size())
      {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] getPreviewSizeGuaranteeOK[list]: width=" + ((Camera.Size)((List)localObject).get(n)).width + " height=" + ((Camera.Size)((List)localObject).get(n)).height + " w/h=" + ((Camera.Size)((List)localObject).get(n)).width / ((Camera.Size)((List)localObject).get(n)).height);
        n += 1;
      }
    }
    CameraControl.CustomSize localCustomSize = a((List)localObject, GloableValue.jdField_e_of_type_Int, GloableValue.jdField_f_of_type_Int);
    if (localCustomSize != null)
    {
      localObject = localCustomSize;
      if (QLog.isColorLevel())
      {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] getPreviewSizeGuaranteeOK: DEFAULT resolution os OK.");
        localObject = localCustomSize;
      }
    }
    do
    {
      return (CameraControl.CustomSize)localObject;
      if (QLog.isColorLevel()) {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] getPreviewSizeGuaranteeOK: Degeneration to 640*480...");
      }
      localCustomSize = a((List)localObject, GloableValue.jdField_a_of_type_ArrayOfInt[1], GloableValue.b[1]);
      if (localCustomSize == null) {
        break;
      }
      localObject = localCustomSize;
    } while (!QLog.isColorLevel());
    QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] getPreviewSizeGuaranteeOK: 640*480 resolution os OK.");
    return localCustomSize;
    return a((List)localObject, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_b_of_type_JavaLangString, 2, "release camera");
    }
    if (!this.jdField_b_of_type_Boolean) {}
    do
    {
      return;
      CameraAbility.a().a();
    } while (this.jdField_a_of_type_AndroidHardwareCamera == null);
    try
    {
      this.jdField_a_of_type_AndroidHardwareCamera.release();
      this.jdField_a_of_type_AndroidHardwareCamera = null;
      this.d = -1;
      this.jdField_a_of_type_ArrayOfInt = null;
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$CustomSize = null;
      this.jdField_b_of_type_Boolean = false;
      return;
    }
    catch (Exception localException) {}
  }
  
  public void a(File paramFile, Rect paramRect, CameraCover.PictureCallback paramPictureCallback, int paramInt)
  {
    if (this.jdField_a_of_type_AndroidHardwareCamera == null) {
      if (QLog.isColorLevel()) {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "[takePicture]mCamera " + null);
      }
    }
    do
    {
      return;
      try
      {
        this.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_AndroidHardwareCamera.takePicture(null, null, null, new uqv(this, paramFile, paramRect, paramPictureCallback, paramInt));
        return;
      }
      catch (RuntimeException paramFile) {}
    } while (!QLog.isColorLevel());
    QLog.i(jdField_b_of_type_JavaLangString, 2, null, paramFile);
  }
  
  public void a(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.jdField_a_of_type_AndroidHardwareCamera != null))
    {
      this.jdField_a_of_type_AndroidHardwareCamera.addCallbackBuffer(this.jdField_a_of_type_ArrayOfByte);
      this.jdField_a_of_type_AndroidHardwareCamera.addCallbackBuffer(this.jdField_b_of_type_ArrayOfByte);
    }
  }
  
  public void a(boolean paramBoolean, byte[] paramArrayOfByte)
  {
    if ((paramBoolean) && (this.jdField_a_of_type_AndroidHardwareCamera != null) && (paramArrayOfByte != null)) {
      this.jdField_a_of_type_AndroidHardwareCamera.addCallbackBuffer(paramArrayOfByte);
    }
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_AndroidHardwareCamera == null) {
      return false;
    }
    if (this.jdField_a_of_type_Boolean) {
      return true;
    }
    try
    {
      this.jdField_a_of_type_AndroidHardwareCamera.startPreview();
      this.jdField_a_of_type_Boolean = true;
      return true;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return false;
  }
  
  public boolean a(int paramInt)
  {
    if ((!jdField_c_of_type_Boolean) && (this.jdField_a_of_type_AndroidHardwareCamera == null)) {
      throw new AssertionError();
    }
    for (;;)
    {
      boolean bool3;
      boolean bool4;
      try
      {
        if (FlowCameraConstant.d == 1)
        {
          bool3 = CameraCompatibleList.d(CameraCompatibleList.e);
          bool4 = CameraCompatibleList.b(CameraCompatibleList.f);
          if (bool3) {
            break label185;
          }
          bool1 = bool4;
          bool2 = bool3;
          n = paramInt;
          if (bool4) {
            break label185;
          }
          this.jdField_a_of_type_AndroidHardwareCamera.setDisplayOrientation(n);
          this.jdField_e_of_type_Int = n;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i(jdField_b_of_type_JavaLangString, 2, "setDisplayOrientation degrees=" + n + " blackPhone=" + bool2 + " camera=" + FlowCameraConstant.d + " rom_black=" + bool1);
          return true;
        }
        bool2 = CameraCompatibleList.d(CameraCompatibleList.g);
        if (bool2)
        {
          n = paramInt + 180;
          bool1 = false;
          continue;
        }
        bool1 = false;
      }
      catch (Exception localException)
      {
        return false;
      }
      int n = paramInt;
      continue;
      label185:
      n = paramInt + 180;
      boolean bool1 = bool4;
      boolean bool2 = bool3;
    }
    return true;
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    if ((!jdField_c_of_type_Boolean) && (this.jdField_a_of_type_AndroidHardwareCamera == null)) {
      throw new AssertionError();
    }
    if ((!jdField_c_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$CustomSize == null)) {
      throw new AssertionError();
    }
    Camera.Parameters localParameters = a();
    boolean bool1;
    if (localParameters == null) {
      bool1 = false;
    }
    for (;;)
    {
      return bool1;
      float f1 = paramInt1 / paramInt2;
      CameraControl.CustomSize localCustomSize = new CameraControl.CustomSize();
      Object localObject2 = CameraAbility.a().b();
      if ((localObject2 == null) || (((List)localObject2).isEmpty())) {
        return false;
      }
      Object localObject1 = new ArrayList();
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Camera.Size localSize = (Camera.Size)((Iterator)localObject2).next();
        if (localSize != null)
        {
          if (QLog.isColorLevel()) {
            QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] setPictureSize[list]: width=" + localSize.width + " height=" + localSize.height + " w/h=" + localSize.width / localSize.height);
          }
          if (Math.abs(localSize.width / localSize.height - f1) <= 0.01F) {
            ((List)localObject1).add(localSize);
          }
        }
      }
      if (((List)localObject1).isEmpty()) {
        return false;
      }
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Camera.Size)((Iterator)localObject1).next();
        if (localCustomSize.jdField_a_of_type_Int < ((Camera.Size)localObject2).width)
        {
          localCustomSize.jdField_a_of_type_Int = ((Camera.Size)localObject2).width;
          localCustomSize.jdField_b_of_type_Int = ((Camera.Size)localObject2).height;
        }
      }
      if (localCustomSize.jdField_a_of_type_Int == 0) {
        return false;
      }
      try
      {
        localParameters.setPictureSize(localCustomSize.jdField_a_of_type_Int, localCustomSize.jdField_b_of_type_Int);
        this.jdField_b_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$CustomSize = localCustomSize;
        boolean bool2 = a(localParameters);
        bool1 = bool2;
        if (QLog.isColorLevel())
        {
          QLog.i(jdField_b_of_type_JavaLangString, 2, "setParamsPictureSize w " + localCustomSize.jdField_a_of_type_Int + ", h " + localCustomSize.jdField_b_of_type_Int + ", success=" + bool2);
          return bool2;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.i(jdField_b_of_type_JavaLangString, 2, "setParamsPictureSize", localException);
        }
      }
    }
    return false;
  }
  
  public boolean a(int paramInt, boolean paramBoolean)
  {
    if ((!jdField_c_of_type_Boolean) && (this.jdField_a_of_type_AndroidHardwareCamera == null)) {
      throw new AssertionError();
    }
    Camera.Parameters localParameters = a();
    if (localParameters == null) {
      if (QLog.isColorLevel()) {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] setPreviewFps[failed]getCameraParameters=null");
      }
    }
    int[] arrayOfInt;
    do
    {
      return false;
      arrayOfInt = a(paramInt, paramBoolean);
      if ((arrayOfInt != null) && (arrayOfInt.length >= 2)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i(jdField_b_of_type_JavaLangString, 2, "setPreviewFps[getFpsRange=null]");
    return false;
    if (QLog.isColorLevel()) {
      QLog.i(jdField_b_of_type_JavaLangString, 2, "setPreviewFps[ fps[low]=" + arrayOfInt[0] + " fps[high]=" + arrayOfInt[1] + "]");
    }
    try
    {
      localParameters.setPreviewFpsRange(arrayOfInt[0], arrayOfInt[1]);
      this.jdField_a_of_type_ArrayOfInt = arrayOfInt;
      paramBoolean = a(localParameters);
      return paramBoolean;
    }
    catch (Exception localException) {}
    return false;
  }
  
  public boolean a(Context paramContext)
  {
    if ((!jdField_c_of_type_Boolean) && (this.jdField_a_of_type_AndroidHardwareCamera == null)) {
      throw new AssertionError();
    }
    for (;;)
    {
      int i1;
      try
      {
        CameraControl.CameraInformation localCameraInformation = a(paramContext, this.jdField_c_of_type_Int, this.jdField_a_of_type_AndroidHardwareCamera);
        if (QLog.isColorLevel()) {
          QLog.i(jdField_b_of_type_JavaLangString, 2, "getCameraDisplayOrientation orientation:" + localCameraInformation.jdField_b_of_type_Int + ",rotation:" + localCameraInformation.jdField_c_of_type_Int);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$CameraInformation.jdField_b_of_type_Int == -1)
        {
          if (FlowCameraConstant.d != 1) {
            break label304;
          }
          n = 270;
          if (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$CameraInformation.jdField_c_of_type_Int == -1)
          {
            i1 = 0;
            if (localCameraInformation.jdField_a_of_type_Int != 1) {
              break label310;
            }
            n = (360 - (i1 + n) % 360) % 360;
            if (localCameraInformation.jdField_a_of_type_Int != 1) {
              continue;
            }
            n = (n + (360 - ConfigSystemImpl.b(paramContext, true, true, (byte)0, false) * 90)) % 360;
            this.jdField_a_of_type_AndroidHardwareCamera.setDisplayOrientation(n);
            this.jdField_e_of_type_Int = n;
            if (QLog.isColorLevel()) {
              QLog.i(jdField_b_of_type_JavaLangString, 2, "setDisplayOrientation degrees=" + n + " camera=" + FlowCameraConstant.d);
            }
            this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$CameraInformation.jdField_a_of_type_Int = localCameraInformation.jdField_a_of_type_Int;
            this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$CameraInformation.jdField_b_of_type_Int = localCameraInformation.jdField_b_of_type_Int;
            return true;
          }
        }
        else
        {
          n = this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$CameraInformation.jdField_b_of_type_Int;
          continue;
        }
        i1 = this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$CameraInformation.jdField_c_of_type_Int;
        continue;
        n = (n + ConfigSystemImpl.b(paramContext, false, true, (byte)0, false) * 90) % 360;
        continue;
        n = 90;
      }
      catch (Exception paramContext)
      {
        return false;
      }
      label304:
      continue;
      label310:
      int n = (n - i1 + 360) % 360;
    }
  }
  
  public boolean a(SurfaceTexture paramSurfaceTexture)
  {
    boolean bool = true;
    if ((this.jdField_a_of_type_AndroidHardwareCamera == null) || (paramSurfaceTexture == null)) {
      bool = false;
    }
    do
    {
      return bool;
      if (!this.jdField_a_of_type_Boolean) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i(jdField_b_of_type_JavaLangString, 2, "@$[setPreviewTexture] mIsPreviewing=" + this.jdField_a_of_type_Boolean);
    return true;
    try
    {
      this.jdField_a_of_type_AndroidHardwareCamera.setPreviewTexture(paramSurfaceTexture);
      return true;
    }
    catch (Exception paramSurfaceTexture)
    {
      paramSurfaceTexture.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "@$[setPreviewTexture] exp=", paramSurfaceTexture);
      }
    }
    return false;
  }
  
  public boolean a(Camera.AutoFocusCallback paramAutoFocusCallback)
  {
    if ((this.jdField_a_of_type_AndroidHardwareCamera == null) || (!this.jdField_a_of_type_Boolean) || (!e())) {
      return false;
    }
    try
    {
      this.jdField_a_of_type_AndroidHardwareCamera.cancelAutoFocus();
      this.jdField_a_of_type_AndroidHardwareCamera.autoFocus(paramAutoFocusCallback);
      return true;
    }
    catch (Exception paramAutoFocusCallback) {}
    return false;
  }
  
  public boolean a(Camera.Parameters paramParameters)
  {
    if ((!jdField_c_of_type_Boolean) && (this.jdField_a_of_type_AndroidHardwareCamera == null)) {
      throw new AssertionError();
    }
    if (paramParameters == null) {
      return false;
    }
    try
    {
      this.jdField_a_of_type_AndroidHardwareCamera.setParameters(paramParameters);
      return true;
    }
    catch (Exception paramParameters) {}
    return false;
  }
  
  public boolean a(Camera.PreviewCallback paramPreviewCallback, SurfaceHolder paramSurfaceHolder)
  {
    if ((this.jdField_a_of_type_AndroidHardwareCamera == null) || (paramPreviewCallback == null) || (paramSurfaceHolder == null))
    {
      if (QLog.isColorLevel()) {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] startPreview[failed] mCamera=" + this.jdField_a_of_type_AndroidHardwareCamera + " holder=" + paramSurfaceHolder + " callback=" + paramPreviewCallback);
      }
      return false;
    }
    try
    {
      this.jdField_a_of_type_AndroidHardwareCamera.setPreviewDisplay(paramSurfaceHolder);
      this.jdField_a_of_type_AndroidHardwareCamera.setPreviewCallback(paramPreviewCallback);
      this.jdField_a_of_type_AndroidHardwareCamera.startPreview();
      this.jdField_a_of_type_Boolean = true;
      return true;
    }
    catch (Exception paramPreviewCallback)
    {
      paramPreviewCallback.printStackTrace();
      if (QLog.isColorLevel())
      {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] startPreview[failed] Exception Occured... ep=" + paramPreviewCallback.getMessage());
        QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] startPreview[failed] Exception Occured... ep=" + paramPreviewCallback);
      }
    }
    return false;
  }
  
  public boolean a(Camera.PreviewCallback paramPreviewCallback, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_AndroidHardwareCamera == null) || (paramPreviewCallback == null)) {
      return false;
    }
    if (paramBoolean) {
      try
      {
        if (e(c()))
        {
          this.jdField_a_of_type_AndroidHardwareCamera.addCallbackBuffer(this.jdField_a_of_type_ArrayOfByte);
          this.jdField_a_of_type_AndroidHardwareCamera.addCallbackBuffer(this.jdField_b_of_type_ArrayOfByte);
          this.jdField_a_of_type_AndroidHardwareCamera.setPreviewCallbackWithBuffer(paramPreviewCallback);
        }
        else
        {
          this.jdField_a_of_type_AndroidHardwareCamera.setPreviewCallback(paramPreviewCallback);
        }
      }
      catch (Exception paramPreviewCallback)
      {
        paramPreviewCallback.printStackTrace();
        return false;
      }
    }
    this.jdField_a_of_type_AndroidHardwareCamera.setPreviewCallback(paramPreviewCallback);
    return true;
  }
  
  public boolean a(SurfaceHolder paramSurfaceHolder)
  {
    boolean bool = true;
    if ((this.jdField_a_of_type_AndroidHardwareCamera == null) || (paramSurfaceHolder == null)) {
      bool = false;
    }
    do
    {
      return bool;
      if (!this.jdField_a_of_type_Boolean) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i(jdField_b_of_type_JavaLangString, 2, "@$[setSurfaceHolder] mIsPreviewing=" + this.jdField_a_of_type_Boolean);
    return true;
    try
    {
      this.jdField_a_of_type_AndroidHardwareCamera.setPreviewDisplay(paramSurfaceHolder);
      return true;
    }
    catch (Exception paramSurfaceHolder)
    {
      paramSurfaceHolder.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "@$[setSurfaceHolder] exp=", paramSurfaceHolder);
      }
    }
    return false;
  }
  
  public boolean a(CameraControl.CustomSize paramCustomSize)
  {
    if ((!jdField_c_of_type_Boolean) && (this.jdField_a_of_type_AndroidHardwareCamera == null)) {
      throw new AssertionError();
    }
    Camera.Parameters localParameters = a();
    if (localParameters == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] setParamsPreviewSize[failed]getCameraParameters=null");
      }
      return false;
    }
    try
    {
      localParameters.setPreviewSize(paramCustomSize.jdField_a_of_type_Int, paramCustomSize.jdField_b_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$CustomSize = paramCustomSize;
      boolean bool = a(localParameters);
      if (QLog.isColorLevel()) {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] setParamsPreviewSize, result = " + bool + ",size.width = " + paramCustomSize.jdField_a_of_type_Int + ",size.height = " + paramCustomSize.jdField_b_of_type_Int);
      }
      return bool;
    }
    catch (Exception paramCustomSize)
    {
      paramCustomSize.printStackTrace();
    }
    return false;
  }
  
  public boolean a(CameraProxy.ParamCache paramParamCache)
  {
    Camera.Parameters localParameters = a();
    if (localParameters == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] setParamsPreviewFormat[failed]getCameraParameters=null");
      }
      return false;
    }
    localParameters.setPreviewFormat(paramParamCache.jdField_a_of_type_Int);
    localParameters.setPreviewSize(paramParamCache.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$CustomSize.jdField_a_of_type_Int, paramParamCache.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$CustomSize.jdField_b_of_type_Int);
    localParameters.setPreviewFpsRange(paramParamCache.jdField_b_of_type_Int, paramParamCache.jdField_c_of_type_Int);
    if (paramParamCache.jdField_a_of_type_Boolean) {
      localParameters.setPictureSize(paramParamCache.jdField_b_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$CustomSize.jdField_a_of_type_Int, paramParamCache.jdField_b_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$CustomSize.jdField_b_of_type_Int);
    }
    boolean bool = a(localParameters);
    if (bool)
    {
      this.d = paramParamCache.jdField_a_of_type_Int;
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$CustomSize = paramParamCache.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$CustomSize;
      this.jdField_a_of_type_ArrayOfInt = new int[] { paramParamCache.jdField_b_of_type_Int, paramParamCache.jdField_c_of_type_Int };
      this.jdField_b_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$CustomSize = paramParamCache.jdField_b_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$CustomSize;
    }
    return bool;
  }
  
  public boolean a(String paramString)
  {
    boolean bool2 = false;
    if ((!jdField_c_of_type_Boolean) && (this.jdField_a_of_type_AndroidHardwareCamera == null)) {
      throw new AssertionError();
    }
    boolean bool1;
    if (!e()) {
      bool1 = bool2;
    }
    do
    {
      do
      {
        for (;;)
        {
          return bool1;
          try
          {
            this.jdField_a_of_type_AndroidHardwareCamera.cancelAutoFocus();
            Camera.Parameters localParameters = a();
            bool1 = bool2;
            if (localParameters != null)
            {
              String str = localParameters.getFocusMode();
              if (QLog.isColorLevel()) {
                QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] setParamsFocusMode getFocusMode=" + str);
              }
              if ((str != null) && (str.equals(paramString))) {
                return true;
              }
            }
          }
          catch (RuntimeException localRuntimeException)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.i(jdField_b_of_type_JavaLangString, 2, "", localRuntimeException);
              }
            }
            bool1 = bool2;
          }
        }
      } while (!CameraAbility.a().a(paramString));
      localRuntimeException.setFocusMode(paramString);
      bool2 = a(localRuntimeException);
      bool1 = bool2;
    } while (!QLog.isColorLevel());
    QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] setParamsFocusMode isSupportFocus=true  success=" + bool2);
    return bool2;
  }
  
  public boolean a(boolean paramBoolean)
  {
    if ((!jdField_c_of_type_Boolean) && (this.jdField_a_of_type_AndroidHardwareCamera == null)) {
      throw new AssertionError();
    }
    if (CameraAbility.a().e())
    {
      Camera.Parameters localParameters = a();
      if (paramBoolean) {}
      for (String str = "torch";; str = "off")
      {
        localParameters.setFlashMode(str);
        return a(localParameters);
      }
    }
    return false;
  }
  
  public int[] a()
  {
    return this.jdField_a_of_type_ArrayOfInt;
  }
  
  public int[] a(int paramInt, boolean paramBoolean)
  {
    int[] arrayOfInt1 = new int[2];
    int[] tmp5_4 = arrayOfInt1;
    tmp5_4[0] = Integer.MAX_VALUE;
    int[] tmp10_5 = tmp5_4;
    tmp10_5[1] = Integer.MAX_VALUE;
    tmp10_5;
    int n = paramInt * 1000;
    List localList = CameraAbility.a().c();
    if (localList == null)
    {
      arrayOfInt1[0] = n;
      arrayOfInt1[1] = n;
      return arrayOfInt1;
    }
    a(localList);
    if (!paramBoolean) {
      return a(localList, paramInt);
    }
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      int[] arrayOfInt2 = (int[])localIterator.next();
      if ((arrayOfInt2 != null) && (arrayOfInt2.length >= 2) && (n >= arrayOfInt2[0]) && (n <= arrayOfInt2[1]))
      {
        arrayOfInt1[0] = n;
        arrayOfInt1[1] = arrayOfInt2[1];
        return arrayOfInt1;
      }
    }
    return a(localList, paramInt);
  }
  
  public int b()
  {
    int i1 = this.jdField_e_of_type_Int;
    if (FlowCameraConstant.d == 1) {
      if (this.jdField_e_of_type_Int != 270) {
        break label70;
      }
    }
    label70:
    for (int n = this.jdField_e_of_type_Int - 180;; n = this.jdField_e_of_type_Int + 180)
    {
      i1 = n;
      if (QLog.isColorLevel())
      {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "getPreviewOrientation:blackPhone= orientation=" + n);
        i1 = n;
      }
      return i1;
    }
  }
  
  public CameraControl.CustomSize b()
  {
    return this.jdField_b_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$CustomSize;
  }
  
  public CameraControl.CustomSize b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Object localObject2 = CameraAbility.a().a();
    if ((localObject2 == null) || (((List)localObject2).isEmpty())) {
      return null;
    }
    if (QLog.isColorLevel())
    {
      paramInt2 = 0;
      while (paramInt2 < ((List)localObject2).size())
      {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] getFullVideoPreviewSize[list]: width=" + ((Camera.Size)((List)localObject2).get(paramInt2)).width + " height=" + ((Camera.Size)((List)localObject2).get(paramInt2)).height + " w/h=" + ((Camera.Size)((List)localObject2).get(paramInt2)).width / ((Camera.Size)((List)localObject2).get(paramInt2)).height);
        paramInt2 += 1;
      }
    }
    double d1;
    Object localObject4;
    Object localObject3;
    CameraControl.CustomSize localCustomSize;
    Object localObject5;
    label261:
    if (FlowCameraConstant.d == 1)
    {
      if (!jdField_f_of_type_Boolean)
      {
        a(jdField_b_of_type_JavaUtilArrayList);
        jdField_f_of_type_Boolean = true;
      }
      localObject1 = jdField_b_of_type_JavaUtilArrayList;
      d1 = paramInt4 / paramInt3;
      if (QLog.isColorLevel()) {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] getFullVideoPreviewSize[self-adaption] physicRatio=" + d1);
      }
      localObject4 = new ArrayList(3);
      localObject3 = new ArrayList(3);
      localCustomSize = new CameraControl.CustomSize();
      localObject5 = ((List)localObject2).iterator();
    }
    for (;;)
    {
      if (!((Iterator)localObject5).hasNext()) {
        break label402;
      }
      Camera.Size localSize = (Camera.Size)((Iterator)localObject5).next();
      if (localSize != null)
      {
        double d2 = localSize.width / localSize.height;
        Iterator localIterator = ((ArrayList)localObject1).iterator();
        if (localIterator.hasNext())
        {
          if (Math.abs(((Float)localIterator.next()).floatValue() - d2) > 0.009999999776482582D) {
            break label261;
          }
          if (d2 >= d1)
          {
            ((ArrayList)localObject4).add(localSize);
            continue;
            if (!jdField_e_of_type_Boolean)
            {
              a(jdField_a_of_type_JavaUtilArrayList);
              jdField_e_of_type_Boolean = true;
            }
            localObject1 = jdField_a_of_type_JavaUtilArrayList;
            break;
          }
          ((ArrayList)localObject3).add(localSize);
        }
      }
    }
    label402:
    int n = GloableValue.jdField_e_of_type_Int;
    int i1 = GloableValue.jdField_f_of_type_Int;
    if (QLog.isColorLevel()) {
      QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] getFullVideoPreviewSize[self-adaption] previewWidth=" + n + "previewHeight=" + i1);
    }
    Object localObject1 = ((ArrayList)localObject4).iterator();
    paramInt2 = -1;
    if (((Iterator)localObject1).hasNext())
    {
      localObject5 = (Camera.Size)((Iterator)localObject1).next();
      if ((localObject5 == null) || (((Camera.Size)localObject5).height != i1) || (((Camera.Size)localObject5).width < n) || ((paramInt2 >= 0) && (((Camera.Size)localObject5).width > paramInt2))) {
        break label1404;
      }
      paramInt2 = ((Camera.Size)localObject5).width;
    }
    label1401:
    label1404:
    for (;;)
    {
      break;
      if (paramInt2 > 0)
      {
        localCustomSize.jdField_b_of_type_Int = i1;
        localCustomSize.jdField_a_of_type_Int = paramInt2;
        if ((CameraCompatibleList.a()) && (a((ArrayList)localObject3, n, i1))) {
          localCustomSize.jdField_a_of_type_Int = n;
        }
        return localCustomSize;
      }
      localObject1 = ((ArrayList)localObject3).iterator();
      long l1 = Long.MAX_VALUE;
      long l2;
      if (((Iterator)localObject1).hasNext())
      {
        localObject5 = (Camera.Size)((Iterator)localObject1).next();
        if ((localObject5 != null) && (a(paramInt1, paramInt3, paramInt4, ((Camera.Size)localObject5).width, ((Camera.Size)localObject5).height)))
        {
          l2 = ((Camera.Size)localObject5).width * ((Camera.Size)localObject5).height;
          if (l2 < l1)
          {
            localCustomSize.jdField_a_of_type_Int = ((Camera.Size)localObject5).width;
            localCustomSize.jdField_b_of_type_Int = ((Camera.Size)localObject5).height;
            l1 = l2;
          }
        }
        for (;;)
        {
          break;
          if ((l2 == l1) && (((Camera.Size)localObject5).width < localCustomSize.jdField_a_of_type_Int))
          {
            localCustomSize.jdField_a_of_type_Int = ((Camera.Size)localObject5).width;
            localCustomSize.jdField_b_of_type_Int = ((Camera.Size)localObject5).height;
          }
        }
      }
      if ((localCustomSize.jdField_a_of_type_Int > 0) || (localCustomSize.jdField_b_of_type_Int > 0)) {
        return localCustomSize;
      }
      paramInt2 = GloableValue.g[1];
      n = GloableValue.h[1];
      localObject1 = ((ArrayList)localObject4).iterator();
      paramInt1 = -1;
      if (((Iterator)localObject1).hasNext())
      {
        localObject5 = (Camera.Size)((Iterator)localObject1).next();
        if ((localObject5 == null) || (((Camera.Size)localObject5).height != n) || (((Camera.Size)localObject5).width < paramInt2) || ((paramInt1 >= 0) && (((Camera.Size)localObject5).width > paramInt1))) {
          break label1401;
        }
        paramInt1 = ((Camera.Size)localObject5).width;
      }
      for (;;)
      {
        break;
        if (paramInt1 > 0)
        {
          localCustomSize.jdField_b_of_type_Int = n;
          localCustomSize.jdField_a_of_type_Int = paramInt1;
          return localCustomSize;
        }
        if ((localCustomSize.jdField_a_of_type_Int <= 0) || (localCustomSize.jdField_b_of_type_Int <= 0))
        {
          localObject1 = ((ArrayList)localObject4).iterator();
          l1 = Long.MAX_VALUE;
          if (((Iterator)localObject1).hasNext())
          {
            localObject4 = (Camera.Size)((Iterator)localObject1).next();
            if (localObject4 != null)
            {
              l2 = ((Camera.Size)localObject4).width * ((Camera.Size)localObject4).height;
              if (l2 < l1)
              {
                localCustomSize.jdField_a_of_type_Int = ((Camera.Size)localObject4).width;
                localCustomSize.jdField_b_of_type_Int = ((Camera.Size)localObject4).height;
                l1 = l2;
              }
            }
            for (;;)
            {
              break;
              if ((l2 == l1) && (((Camera.Size)localObject4).width < localCustomSize.jdField_a_of_type_Int))
              {
                localCustomSize.jdField_a_of_type_Int = ((Camera.Size)localObject4).width;
                localCustomSize.jdField_b_of_type_Int = ((Camera.Size)localObject4).height;
              }
            }
          }
        }
        if ((localCustomSize.jdField_a_of_type_Int <= 0) || (localCustomSize.jdField_b_of_type_Int <= 0))
        {
          localObject1 = ((ArrayList)localObject3).iterator();
          l1 = Long.MAX_VALUE;
          if (((Iterator)localObject1).hasNext())
          {
            localObject3 = (Camera.Size)((Iterator)localObject1).next();
            if ((localObject3 != null) && (a(320, paramInt3, paramInt4, ((Camera.Size)localObject3).width, ((Camera.Size)localObject3).height)))
            {
              l2 = ((Camera.Size)localObject3).width * ((Camera.Size)localObject3).height;
              if (l2 < l1)
              {
                localCustomSize.jdField_a_of_type_Int = ((Camera.Size)localObject3).width;
                localCustomSize.jdField_b_of_type_Int = ((Camera.Size)localObject3).height;
                l1 = l2;
              }
            }
            for (;;)
            {
              break;
              if ((l2 == l1) && (((Camera.Size)localObject3).width < localCustomSize.jdField_a_of_type_Int))
              {
                localCustomSize.jdField_a_of_type_Int = ((Camera.Size)localObject3).width;
                localCustomSize.jdField_b_of_type_Int = ((Camera.Size)localObject3).height;
              }
            }
          }
        }
        if ((localCustomSize.jdField_a_of_type_Int <= 0) || (localCustomSize.jdField_b_of_type_Int <= 0))
        {
          localObject1 = ((List)localObject2).iterator();
          l1 = 0L;
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = (Camera.Size)((Iterator)localObject1).next();
            if (localObject2 != null)
            {
              l2 = ((Camera.Size)localObject2).width * ((Camera.Size)localObject2).height;
              if (l2 > l1)
              {
                localCustomSize.jdField_a_of_type_Int = ((Camera.Size)localObject2).width;
                localCustomSize.jdField_b_of_type_Int = ((Camera.Size)localObject2).height;
                l1 = l2;
              }
            }
            for (;;)
            {
              break;
              if ((l2 == l1) && (((Camera.Size)localObject2).width < localCustomSize.jdField_a_of_type_Int))
              {
                localCustomSize.jdField_a_of_type_Int = ((Camera.Size)localObject2).width;
                localCustomSize.jdField_b_of_type_Int = ((Camera.Size)localObject2).height;
              }
            }
          }
        }
        if (QLog.isColorLevel()) {
          QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] getFullVideoPreviewSize[self-adaption] cSize.width=" + localCustomSize.jdField_a_of_type_Int + "  cSize.height=" + localCustomSize.jdField_b_of_type_Int);
        }
        if ((localCustomSize.jdField_a_of_type_Int > 0) && (localCustomSize.jdField_b_of_type_Int > 0)) {
          return localCustomSize;
        }
        return null;
      }
    }
  }
  
  /* Error */
  public boolean b()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 282	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   4: ifnonnull +5 -> 9
    //   7: iconst_0
    //   8: ireturn
    //   9: aload_0
    //   10: getfield 454	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:jdField_a_of_type_Boolean	Z
    //   13: ifne +5 -> 18
    //   16: iconst_1
    //   17: ireturn
    //   18: aload_0
    //   19: iconst_0
    //   20: putfield 454	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:jdField_a_of_type_Boolean	Z
    //   23: aload_0
    //   24: invokespecial 570	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:e	()Z
    //   27: istore_2
    //   28: iload_2
    //   29: ifeq +10 -> 39
    //   32: aload_0
    //   33: getfield 282	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   36: invokevirtual 573	android/hardware/Camera:cancelAutoFocus	()V
    //   39: aload_0
    //   40: getfield 282	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   43: invokevirtual 719	android/hardware/Camera:stopPreview	()V
    //   46: aload_0
    //   47: getfield 282	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   50: aconst_null
    //   51: invokevirtual 596	android/hardware/Camera:setPreviewCallback	(Landroid/hardware/Camera$PreviewCallback;)V
    //   54: aload_0
    //   55: getfield 282	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   58: aconst_null
    //   59: invokevirtual 592	android/hardware/Camera:setPreviewDisplay	(Landroid/view/SurfaceHolder;)V
    //   62: iconst_1
    //   63: ireturn
    //   64: astore_1
    //   65: iconst_0
    //   66: ireturn
    //   67: astore_1
    //   68: goto -29 -> 39
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	71	0	this	CameraControl
    //   64	1	1	localIOException	java.io.IOException
    //   67	1	1	localRuntimeException	RuntimeException
    //   27	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   18	28	64	java/io/IOException
    //   32	39	64	java/io/IOException
    //   39	62	64	java/io/IOException
    //   32	39	67	java/lang/RuntimeException
  }
  
  public boolean b(int paramInt)
  {
    if ((!jdField_c_of_type_Boolean) && (this.jdField_a_of_type_AndroidHardwareCamera == null)) {
      throw new AssertionError();
    }
    if (QLog.isColorLevel()) {
      QLog.i(jdField_b_of_type_JavaLangString, 2, "setParamsPreviewFps[fps_wanted=" + paramInt + "]");
    }
    boolean bool2 = a(paramInt, false);
    if (QLog.isColorLevel()) {
      QLog.i(jdField_b_of_type_JavaLangString, 2, "setParamsPreviewFps[fps_wanted=" + paramInt + " force=false" + " success=" + bool2 + "]");
    }
    boolean bool1 = bool2;
    if (!bool2)
    {
      bool2 = a(paramInt, true);
      bool1 = bool2;
      if (QLog.isColorLevel())
      {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "setParamsPreviewFps[fps_wanted=" + paramInt + " force=true" + " success=" + bool2 + "]");
        bool1 = bool2;
      }
    }
    return bool1;
  }
  
  public boolean b(int paramInt1, int paramInt2)
  {
    if ((!jdField_c_of_type_Boolean) && (this.jdField_a_of_type_AndroidHardwareCamera == null)) {
      throw new AssertionError();
    }
    Camera.Parameters localParameters = a();
    boolean bool1;
    if (localParameters == null) {
      bool1 = false;
    }
    for (;;)
    {
      return bool1;
      Object localObject1 = CameraAbility.a().a();
      if (localObject1 == null) {
        return false;
      }
      Object localObject2 = ((List)localObject1).iterator();
      Camera.Size localSize;
      while (((Iterator)localObject2).hasNext())
      {
        localSize = (Camera.Size)((Iterator)localObject2).next();
        if ((localSize != null) && (QLog.isColorLevel())) {
          QLog.i(jdField_b_of_type_JavaLangString, 2, "PreviewSize w " + localSize.width + ", h " + localSize.height + ", h/w " + localSize.height / localSize.width + ", w/h " + localSize.width / localSize.height);
        }
      }
      localObject2 = new CameraControl.CustomSize();
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localSize = (Camera.Size)((Iterator)localObject1).next();
        if ((localSize != null) && (Float.compare(localSize.height / localSize.width, FlowCameraConstant.a) == 0)) {
          if (localSize.height >= paramInt1)
          {
            ((CameraControl.CustomSize)localObject2).jdField_b_of_type_Int = localSize.height;
            ((CameraControl.CustomSize)localObject2).jdField_a_of_type_Int = localSize.width;
          }
          else if ((((CameraControl.CustomSize)localObject2).jdField_b_of_type_Int <= 0) || (((CameraControl.CustomSize)localObject2).jdField_a_of_type_Int <= 0))
          {
            ((CameraControl.CustomSize)localObject2).jdField_b_of_type_Int = localSize.height;
            ((CameraControl.CustomSize)localObject2).jdField_a_of_type_Int = localSize.width;
          }
        }
      }
      try
      {
        localParameters.setPreviewSize(((CameraControl.CustomSize)localObject2).jdField_a_of_type_Int, ((CameraControl.CustomSize)localObject2).jdField_b_of_type_Int);
        this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$CustomSize = ((CameraControl.CustomSize)localObject2);
        boolean bool2 = a(localParameters);
        bool1 = bool2;
        if (QLog.isColorLevel())
        {
          QLog.i(jdField_b_of_type_JavaLangString, 2, "setParamsPreviewSize w " + ((CameraControl.CustomSize)localObject2).jdField_a_of_type_Int + ", h " + ((CameraControl.CustomSize)localObject2).jdField_b_of_type_Int);
          return bool2;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    return false;
  }
  
  public boolean c()
  {
    if ((!jdField_c_of_type_Boolean) && (this.jdField_a_of_type_AndroidHardwareCamera == null)) {
      throw new AssertionError();
    }
    Camera.Parameters localParameters = a();
    boolean bool1;
    if (localParameters == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] setParamsPreviewFormat[failed]getCameraParameters=null");
      }
      bool1 = false;
    }
    boolean bool2;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return bool1;
                if (!CameraAbility.a().a(17)) {
                  break;
                }
                localParameters.setPreviewFormat(17);
                this.d = 17;
                bool2 = a(localParameters);
                bool1 = bool2;
              } while (!QLog.isColorLevel());
              QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] setParamsPreviewFormat:success=" + bool2 + ", isSupportPreviewFormat=NV21 ok");
              return bool2;
              if (!CameraAbility.a().a(842094169)) {
                break;
              }
              localParameters.setPreviewFormat(842094169);
              this.d = 842094169;
              bool2 = a(localParameters);
              bool1 = bool2;
            } while (!QLog.isColorLevel());
            QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] setParamsPreviewFormat:success=" + bool2 + "isSupportPreviewFormat=YV12 OK");
            return bool2;
            if (!CameraAbility.a().a(20)) {
              break;
            }
            localParameters.setPreviewFormat(20);
            this.d = 20;
            bool2 = a(localParameters);
            bool1 = bool2;
          } while (!QLog.isColorLevel());
          QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] setParamsPreviewFormat:success=" + bool2 + "isSupportPreviewFormat=YUY2 OK");
          return bool2;
          if (!CameraAbility.a().a(4)) {
            break;
          }
          localParameters.setPreviewFormat(4);
          this.d = 4;
          bool2 = a(localParameters);
          bool1 = bool2;
        } while (!QLog.isColorLevel());
        QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] setParamsPreviewFormat:success=" + bool2 + "isSupportPreviewFormat=RGB_565 OK");
        return bool2;
        if (!CameraAbility.a().a(256)) {
          break;
        }
        localParameters.setPreviewFormat(256);
        this.d = 256;
        bool2 = a(localParameters);
        bool1 = bool2;
      } while (!QLog.isColorLevel());
      QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] setParamsPreviewFormat:success=" + bool2 + "isSupportPreviewFormat=JPEG OK");
      return bool2;
      if (!CameraAbility.a().a(16)) {
        break;
      }
      localParameters.setPreviewFormat(16);
      this.d = 16;
      bool2 = a(localParameters);
      bool1 = bool2;
    } while (!QLog.isColorLevel());
    QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] setParamsPreviewFormat:success=" + bool2 + "isSupportPreviewFormat=NV16 OK");
    return bool2;
    return false;
  }
  
  public boolean c(int paramInt)
  {
    int i1 = 0;
    if ((!jdField_c_of_type_Boolean) && (this.jdField_a_of_type_AndroidHardwareCamera == null)) {
      throw new AssertionError();
    }
    Camera.Parameters localParameters;
    int n;
    if (CameraAbility.a().d())
    {
      localParameters = a();
      if (localParameters == null) {
        return false;
      }
      n = localParameters.getMaxZoom();
      paramInt = localParameters.getZoom() + paramInt;
      if (paramInt >= 0) {
        break label86;
      }
      paramInt = i1;
    }
    label86:
    for (;;)
    {
      if (paramInt > n) {
        paramInt = n;
      }
      for (;;)
      {
        localParameters.setZoom(paramInt);
        return a(localParameters);
        return false;
      }
    }
  }
  
  public boolean d()
  {
    if ((!jdField_c_of_type_Boolean) && (this.jdField_a_of_type_AndroidHardwareCamera == null)) {
      throw new AssertionError();
    }
    if (CameraAbility.a().e())
    {
      Camera.Parameters localParameters = a();
      if (TextUtils.equals(localParameters.getFlashMode(), "torch")) {
        localParameters.setFlashMode("off");
      }
      for (;;)
      {
        return a(localParameters);
        localParameters.setFlashMode("torch");
      }
    }
    return false;
  }
  
  public boolean d(int paramInt)
  {
    if ((!jdField_c_of_type_Boolean) && (this.jdField_a_of_type_AndroidHardwareCamera == null)) {
      throw new AssertionError();
    }
    Camera.Parameters localParameters = a();
    if (localParameters == null) {
      return false;
    }
    try
    {
      localParameters.setRotation(paramInt);
      boolean bool2 = a(localParameters);
      this.jdField_f_of_type_Int = paramInt;
      bool1 = bool2;
      if (QLog.isColorLevel())
      {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "setRotation rotation=" + paramInt + ", success=" + bool2);
        bool1 = bool2;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i(jdField_b_of_type_JavaLangString, 2, "setRotation", localException);
        }
        boolean bool1 = false;
      }
    }
    return bool1;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\shortvideo\mediadevice\CameraControl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
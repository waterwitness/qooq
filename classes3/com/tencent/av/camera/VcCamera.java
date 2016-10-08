package com.tencent.av.camera;

import android.content.Context;
import android.content.res.Resources;
import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.Parameters;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import com.tencent.av.core.VcControllerImpl;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.av.gaudio.QQGAudioCtrl;
import com.tencent.av.opengl.GraphicRenderMgr;
import com.tencent.av.opengl.GraphicRenderMgr.FocusDetectCallback;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import ggl;
import ggw;
import java.util.List;

public class VcCamera
  extends AndroidCamera
  implements GraphicRenderMgr.FocusDetectCallback
{
  private Camera.AutoFocusCallback a;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    if (Build.VERSION.SDK_INT < 16)
    {
      l = 320;
      m = 240;
    }
    DisplayMetrics localDisplayMetrics = BaseApplicationImpl.a.getResources().getDisplayMetrics();
    if (Math.max(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels) <= 1280)
    {
      l = 320;
      m = 240;
    }
  }
  
  public VcCamera(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidHardwareCamera$AutoFocusCallback = new ggw(this);
  }
  
  private void a(Camera.Parameters paramParameters, boolean paramBoolean)
  {
    if (paramParameters == null) {
      if (QLog.isColorLevel()) {
        QLog.d("AndroidCamera", 2, "parameters null, do nothing about focus config");
      }
    }
    do
    {
      List localList;
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              localList = paramParameters.getSupportedFocusModes();
              if ((localList != null) && (!"".equals(localList))) {
                break;
              }
            } while (!QLog.isColorLevel());
            QLog.d("AndroidCamera", 2, "getSupportedFocusModes empty");
            return;
            if (!VcSystemInfo.a("neon")) {
              break;
            }
          } while (!localList.contains("auto"));
          if (paramBoolean)
          {
            if (QLog.isColorLevel()) {
              QLog.d("AndroidCamera", 2, "set auto focus config, currFocusMode:" + paramParameters.getFocusMode());
            }
            GraphicRenderMgr.getInstance().setFocusDetectCallback(this);
            GraphicRenderMgr.getInstance().setFocusConfig(true, SystemClock.elapsedRealtime(), 111, 3000);
            return;
          }
          if (QLog.isColorLevel()) {
            QLog.d("AndroidCamera", 2, "clear auto focus config");
          }
          GraphicRenderMgr.getInstance().setFocusDetectCallback(null);
          GraphicRenderMgr.getInstance().setFocusConfig(false, SystemClock.elapsedRealtime(), 111, 3000);
          return;
        } while (!paramBoolean);
        if (this.f < 9) {
          break;
        }
      } while (!localList.contains("continuous-video"));
      if (QLog.isColorLevel()) {
        QLog.d("AndroidCamera", 2, "set focus mode to continuous-video");
      }
      paramParameters.setFocusMode("continuous-video");
      return;
    } while (!QLog.isColorLevel());
    QLog.d("AndroidCamera", 2, "both neon and continuous-video not support");
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    super.a(paramInt1, paramInt2);
    String str;
    if (this.jdField_a_of_type_AndroidHardwareCamera != null) {
      str = null;
    }
    try
    {
      localObject = this.jdField_a_of_type_AndroidHardwareCamera.getParameters();
      if (localObject != null)
      {
        bool = VcControllerImpl.setCameraParameters(((Camera.Parameters)localObject).flatten());
        str = ((Camera.Parameters)localObject).flatten();
        if (!bool)
        {
          bool = true;
          QQGAudioCtrl.setCameraParameters(str, bool);
          a((Camera.Parameters)localObject, true);
        }
      }
      else
      {
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        boolean bool;
        Object localObject = str;
        if (QLog.isColorLevel())
        {
          QLog.d("AndroidCamera", 2, "getParameters exception", localException);
          localObject = str;
          continue;
          bool = false;
        }
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AndroidCamera", 2, "focus detect result:" + paramBoolean);
    }
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_AndroidHardwareCamera != null) {
        break label57;
      }
      if (QLog.isColorLevel()) {
        QLog.d("AndroidCamera", 2, "camera null, return");
      }
    }
    return;
    label57:
    GraphicRenderMgr.getInstance().setIsFocusing(true);
    this.jdField_a_of_type_AndroidHardwareCamera.autoFocus(this.jdField_a_of_type_AndroidHardwareCamera$AutoFocusCallback);
  }
  
  /* Error */
  public boolean d()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 219	com/tencent/av/camera/VcCamera:jdField_a_of_type_Boolean	Z
    //   5: istore_2
    //   6: iload_2
    //   7: ifeq +17 -> 24
    //   10: aload_0
    //   11: getfield 176	com/tencent/av/camera/VcCamera:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   14: invokevirtual 182	android/hardware/Camera:getParameters	()Landroid/hardware/Camera$Parameters;
    //   17: astore_1
    //   18: aload_0
    //   19: aload_1
    //   20: iconst_0
    //   21: invokespecial 197	com/tencent/av/camera/VcCamera:a	(Landroid/hardware/Camera$Parameters;Z)V
    //   24: aload_0
    //   25: invokespecial 221	com/tencent/av/camera/AndroidCamera:d	()Z
    //   28: istore_2
    //   29: aload_0
    //   30: monitorexit
    //   31: iload_2
    //   32: ireturn
    //   33: astore_1
    //   34: invokestatic 78	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   37: ifeq +28 -> 65
    //   40: ldc 80
    //   42: iconst_2
    //   43: new 118	java/lang/StringBuilder
    //   46: dup
    //   47: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   50: ldc -33
    //   52: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: aload_1
    //   56: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   59: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   62: invokestatic 229	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   65: aconst_null
    //   66: astore_1
    //   67: goto -49 -> 18
    //   70: astore_1
    //   71: aload_0
    //   72: monitorexit
    //   73: aload_1
    //   74: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	75	0	this	VcCamera
    //   17	3	1	localParameters	Camera.Parameters
    //   33	23	1	localException	Exception
    //   66	1	1	localObject1	Object
    //   70	4	1	localObject2	Object
    //   5	27	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   10	18	33	java/lang/Exception
    //   2	6	70	finally
    //   10	18	70	finally
    //   18	24	70	finally
    //   24	29	70	finally
    //   34	65	70	finally
  }
  
  public int j()
  {
    return a(this.g, this.jdField_a_of_type_AndroidHardwareCamera).c;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\camera\VcCamera.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
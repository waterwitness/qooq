package cooperation.qzone.video.interact;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Region.Op;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.hardware.Camera;
import android.hardware.Camera.PreviewCallback;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.Renderer;
import android.view.SurfaceHolder;
import com.tencent.mobileqq.activity.richmedia.FlowCameraConstant;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraCompatibleList;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraProxy;
import com.tencent.mobileqq.shortvideo.mediadevice.PreviewContext;
import com.tencent.qphone.base.util.QLog;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class CircularCameraSurfaceView
  extends GLSurfaceView
  implements SurfaceTexture.OnFrameAvailableListener, Camera.PreviewCallback, GLSurfaceView.Renderer
{
  public static final byte a = 1;
  private static String jdField_a_of_type_JavaLangString;
  public static final byte b = 2;
  public static final byte c = 4;
  private int jdField_a_of_type_Int;
  private SurfaceTexture jdField_a_of_type_AndroidGraphicsSurfaceTexture;
  public PreviewContext a;
  private DirectDrawer jdField_a_of_type_CooperationQzoneVideoInteractDirectDrawer;
  
  public CircularCameraSurfaceView(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = -1;
    jdField_a_of_type_JavaLangString = getClass().getSimpleName();
    setId(2131296496);
    setEGLContextClientVersion(2);
    setEGLConfigChooser(8, 8, 8, 8, 16, 0);
    getHolder().setFormat(-3);
    setRenderer(this);
    setRenderMode(0);
  }
  
  private int a()
  {
    int[] arrayOfInt = new int[1];
    GLES20.glGenTextures(1, arrayOfInt, 0);
    GLES20.glBindTexture(36197, arrayOfInt[0]);
    GLES20.glTexParameterf(36197, 10241, 9729.0F);
    GLES20.glTexParameterf(36197, 10240, 9729.0F);
    GLES20.glTexParameteri(36197, 10242, 33071);
    GLES20.glTexParameteri(36197, 10243, 33071);
    return arrayOfInt[0];
  }
  
  public SurfaceTexture a()
  {
    return this.jdField_a_of_type_AndroidGraphicsSurfaceTexture;
  }
  
  public void draw(Canvas paramCanvas)
  {
    Path localPath = new Path();
    int i = getWidth() / 2;
    localPath.addCircle(i, i, i, Path.Direction.CCW);
    paramCanvas.clipPath(localPath, Region.Op.REPLACE);
    super.draw(paramCanvas);
  }
  
  public void onDrawFrame(GL10 paramGL10)
  {
    GLES20.glClear(16640);
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.updateTexImage();
    paramGL10 = new float[16];
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.getTransformMatrix(paramGL10);
    this.jdField_a_of_type_CooperationQzoneVideoInteractDirectDrawer.a(paramGL10);
  }
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    requestRender();
  }
  
  public void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.getPreviewFrame(paramArrayOfByte, paramCamera);
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "--onSurfaceChanged-width:" + paramInt1 + ",height" + paramInt2);
    }
    GLES20.glViewport(0, paramInt2 - paramInt1, paramInt1, paramInt1);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.mCamera.a();
    this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.mCamera.a(0, paramInt1, paramInt2);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.mCamera.a(this.jdField_a_of_type_AndroidGraphicsSurfaceTexture, null, this, false);
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    byte b1 = 0;
    int j = 1;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "--onSurfaceCreated-");
    }
    this.jdField_a_of_type_Int = a();
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture = new SurfaceTexture(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.setOnFrameAvailableListener(this);
    boolean bool1;
    int i;
    if (FlowCameraConstant.d == 1)
    {
      bool1 = CameraCompatibleList.d(CameraCompatibleList.e);
      boolean bool2 = CameraCompatibleList.b(CameraCompatibleList.f);
      i = j;
      if (!bool1)
      {
        if (bool2) {
          i = j;
        }
      }
      else if (i != 0) {
        b1 = (byte)((byte)2 | 0x4);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_CooperationQzoneVideoInteractDirectDrawer = new DirectDrawer(this.jdField_a_of_type_Int, b1);
      return;
      i = 0;
      break;
      bool1 = CameraCompatibleList.d(CameraCompatibleList.g);
      byte b2 = (byte)1;
      b1 = b2;
      if (bool1) {
        b1 = (byte)((byte)(b2 | 0x4) | 0x2);
      }
    }
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "--surfaceDestroyed-");
    }
    super.surfaceDestroyed(paramSurfaceHolder);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.mCamera.b();
    this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.mCamera.a(true);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\video\interact\CircularCameraSurfaceView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
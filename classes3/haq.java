import android.os.Handler;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.opengl.gesturedetectors.MoveGestureDetector;
import com.tencent.av.opengl.ui.GLView;
import com.tencent.av.opengl.ui.GLView.OnTouchListener;
import com.tencent.av.ui.GLVideoView;
import com.tencent.av.ui.VideoLayerUI;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class haq
  implements GLView.OnTouchListener
{
  float jdField_a_of_type_Float;
  final int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  Runnable jdField_a_of_type_JavaLangRunnable;
  boolean jdField_a_of_type_Boolean;
  float b;
  
  public haq(VideoLayerUI paramVideoLayerUI)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Float = 0.0F;
    this.b = 0.0F;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Int = 1000;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangRunnable = new har(this);
  }
  
  public boolean a(GLView paramGLView, MotionEvent paramMotionEvent)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((paramGLView == null) || (paramMotionEvent == null) || (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ComTencentAvVideoController == null)) {
      bool1 = false;
    }
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
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        return bool1;
                        if (paramMotionEvent.getAction() == 0)
                        {
                          this.jdField_a_of_type_Float = 0.0F;
                          this.b = 0.0F;
                          this.jdField_a_of_type_Long = System.currentTimeMillis();
                          this.jdField_a_of_type_Boolean = false;
                          this.jdField_a_of_type_Float = paramMotionEvent.getX();
                          this.b = paramMotionEvent.getY();
                          if (QLog.isColorLevel()) {
                            QLog.e("VideoLayerUI", 2, "[childLock] touch onDown: " + this.jdField_a_of_type_Float + " x " + this.b + " ==========");
                          }
                          this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
                          this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 1000L);
                        }
                        if ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getPointerCount() > 1) || ((paramMotionEvent.getAction() == 2) && ((Math.abs(paramMotionEvent.getX() - this.jdField_a_of_type_Float) > 70.0F) || (Math.abs(paramMotionEvent.getY() - this.b) > 70.0F))))
                        {
                          this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
                          if (this.jdField_a_of_type_Boolean)
                          {
                            this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(120), Integer.valueOf(0) });
                            if (QLog.isColorLevel()) {
                              QLog.e("VideoLayerUI", 2, "[childLock] cancel animation");
                            }
                          }
                          if (QLog.isColorLevel()) {
                            QLog.e("VideoLayerUI", 2, "[childLock] touch end ==========");
                          }
                        }
                        if (!this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ComTencentAvVideoController.a().w) {
                          break;
                        }
                        bool1 = bool2;
                      } while (paramMotionEvent.getAction() != 1);
                      bool1 = bool2;
                    } while (System.currentTimeMillis() - this.jdField_a_of_type_Long >= 200L);
                    this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(120), Integer.valueOf(2) });
                    return true;
                    if (paramGLView == this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0]) {
                      this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.d = 0;
                    }
                    for (;;)
                    {
                      if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_AndroidViewGestureDetector != null) {
                        this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent);
                      }
                      if ((this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) && (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ComTencentAvVideoController != null)) {
                        break;
                      }
                      return false;
                      if (paramGLView == this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[1]) {
                        this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.d = 1;
                      } else if (paramGLView == this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[2]) {
                        this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.d = 2;
                      } else if (paramGLView == this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[3]) {
                        this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.d = 3;
                      } else if (paramGLView == this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[4]) {
                        this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.d = 4;
                      } else {
                        this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.d = -1;
                      }
                    }
                    if ((this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ComTencentAvVideoController.a().f != 1) && (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ComTencentAvVideoController.a().f != 2)) {
                      break;
                    }
                    bool1 = bool2;
                  } while (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.d != 1);
                  bool1 = bool2;
                } while (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ComTencentAvOpenglGesturedetectorsMoveGestureDetector == null);
                if ((!this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ComTencentAvOpenglGesturedetectorsMoveGestureDetector.a()) && (paramMotionEvent.getAction() != 0))
                {
                  paramGLView = MotionEvent.obtain(paramMotionEvent);
                  paramGLView.setAction(0);
                  this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ComTencentAvOpenglGesturedetectorsMoveGestureDetector.a(paramGLView);
                  paramGLView.recycle();
                }
                this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ComTencentAvOpenglGesturedetectorsMoveGestureDetector.a(paramMotionEvent);
                return true;
                bool1 = bool2;
              } while (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.d != 0);
              if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.b == 0) {
                break;
              }
              bool1 = bool2;
            } while (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_Int != 0);
            bool1 = bool2;
          } while (!Integer.valueOf(2).equals(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].a(1)));
          bool1 = bool2;
        } while (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_AndroidViewScaleGestureDetector == null);
        this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_AndroidViewScaleGestureDetector.onTouchEvent(paramMotionEvent);
        bool1 = bool2;
      } while (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_AndroidViewScaleGestureDetector.isInProgress());
      bool1 = bool2;
    } while (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ComTencentAvOpenglGesturedetectorsMoveGestureDetector == null);
    this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ComTencentAvOpenglGesturedetectorsMoveGestureDetector.a(paramMotionEvent);
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\haq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
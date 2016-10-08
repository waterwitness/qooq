import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.opengl.ui.GLView;
import com.tencent.av.ui.GLVideoView;
import com.tencent.av.ui.VideoLayerUI;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class hah
  extends GestureDetector.SimpleOnGestureListener
{
  public hah(VideoLayerUI paramVideoLayerUI)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    if ((this.a.d == 0) && ((this.a.b == 0) || (this.a.jdField_a_of_type_Int == 0)) && (Integer.valueOf(2).equals(this.a.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].a(1))))
    {
      int i = (int)paramMotionEvent.getX();
      int j = (int)paramMotionEvent.getY();
      float f = this.a.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].c();
      paramMotionEvent = this.a;
      paramMotionEvent.c += 1;
      if (this.a.c % 2 == 1)
      {
        f = this.a.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].b() / f;
        this.a.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].a(f, i, j);
        return true;
      }
      f = this.a.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].a() / f;
      i = this.a.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].g() / 2;
      j = this.a.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].h() / 2;
      this.a.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].a(f, i, j);
      this.a.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].a(i, j, true);
      return true;
    }
    return super.onDoubleTap(paramMotionEvent);
  }
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    if ((this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) || (this.a.jdField_a_of_type_ComTencentAvVideoController == null)) {
      return false;
    }
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoLayerUI", 2, "GestureListener-->mTargetIndex=" + this.a.d);
      }
      if ((this.a.d <= 0) || ((this.a.b != 0) && (this.a.jdField_a_of_type_Int != 0) && (this.a.jdField_a_of_type_ComTencentAvVideoController.a().D != 2))) {
        this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(110) });
      } else if ((this.a.b == 0) || (this.a.jdField_a_of_type_Int == 0) || (this.a.jdField_a_of_type_ComTencentAvVideoController.a().D == 2)) {
        if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().f == 2) {
          this.a.a(0, this.a.d);
        }
      }
    }
    catch (Exception paramMotionEvent)
    {
      if (QLog.isColorLevel()) {
        QLog.e("VideoLayerUI", 2, "onSingleTapConfirmed --> Exception = " + paramMotionEvent);
      }
      return true;
    }
    if ((this.a.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView != null) && (this.a.d > 0) && (this.a.d < this.a.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView.length))
    {
      Object localObject = this.a.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0];
      paramMotionEvent = this.a.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[this.a.d];
      if ((localObject != null) && (paramMotionEvent != null))
      {
        String str = (String)((GLView)localObject).a(0);
        int i = ((Integer)((GLView)localObject).a(1)).intValue();
        localObject = (String)paramMotionEvent.a(0);
        int j = ((Integer)paramMotionEvent.a(1)).intValue();
        this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(115), str, Integer.valueOf(i), localObject, Integer.valueOf(j) });
        return true;
      }
    }
    else
    {
      return true;
    }
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\hah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
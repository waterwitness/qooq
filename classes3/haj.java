import android.graphics.PointF;
import com.tencent.av.opengl.gesturedetectors.MoveGestureDetector;
import com.tencent.av.opengl.gesturedetectors.MoveGestureDetector.OnMoveGestureListener;
import com.tencent.av.ui.GLVideoView;
import com.tencent.av.ui.VideoLayerUI;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class haj
  implements MoveGestureDetector.OnMoveGestureListener
{
  int jdField_a_of_type_Int;
  int b;
  int c;
  int d;
  int e;
  
  public haj(VideoLayerUI paramVideoLayerUI)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = 0;
    this.b = 0;
    this.c = 0;
    this.d = 0;
    this.e = 0;
  }
  
  public void a(MoveGestureDetector paramMoveGestureDetector)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoLayerUI", 2, "onMoveEnd");
    }
    PointF localPointF = paramMoveGestureDetector.a();
    int i = (int)localPointF.x;
    int j = (int)localPointF.y;
    if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.d == 0) {
      this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].a(i, j, true);
    }
    while ((this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.d != 1) || ((this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.b != 0) && (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_Int != 0))) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.c(i, j);
    this.c = ((int)paramMoveGestureDetector.a());
    this.d = ((int)paramMoveGestureDetector.b());
    this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.i = this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(this.e, this.jdField_a_of_type_Int, this.b, this.c, this.d);
    this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.d(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.i);
  }
  
  public boolean a(MoveGestureDetector paramMoveGestureDetector)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoLayerUI", 2, "onMoveBegin");
    }
    if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.d == 0)
    {
      paramMoveGestureDetector = paramMoveGestureDetector.a();
      i = (int)paramMoveGestureDetector.x;
      j = (int)paramMoveGestureDetector.y;
      this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].a(i, j, false);
    }
    while ((this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.d != 1) || ((this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.b != 0) && (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_Int != 0)))
    {
      int i;
      int j;
      return true;
    }
    this.jdField_a_of_type_Int = ((int)paramMoveGestureDetector.a());
    this.b = ((int)paramMoveGestureDetector.b());
    this.e = this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.d();
    return true;
  }
  
  public boolean b(MoveGestureDetector paramMoveGestureDetector)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoLayerUI", 2, "onMove");
    }
    paramMoveGestureDetector = paramMoveGestureDetector.a();
    int i = (int)paramMoveGestureDetector.x;
    int j = (int)paramMoveGestureDetector.y;
    if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.d == 0) {
      this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].a(i, j, false);
    }
    while ((this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.d != 1) || ((this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.b != 0) && (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_Int != 0))) {
      return true;
    }
    if ((Math.abs(i) > 5) || (Math.abs(j) > 5)) {
      this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.f = true;
    }
    this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.c(i, j);
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\haj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
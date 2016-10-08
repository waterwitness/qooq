import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo.doodle.compat.ViewCompat;
import com.tencent.biz.qqstory.takevideo.doodle.layer.FaceLayer;
import com.tencent.biz.qqstory.takevideo.doodle.layer.base.BaseLayer.OnLayerTouchListener;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import com.tencent.biz.qqstory.takevideo.doodle.ui.widget.ElasticImageView;
import com.tencent.biz.qqstory.takevideo.doodle.util.DisplayUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ixv
  implements BaseLayer.OnLayerTouchListener
{
  private final float jdField_a_of_type_Float;
  private final int jdField_a_of_type_Int;
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  private boolean jdField_a_of_type_Boolean;
  
  private ixv(DoodleLayout paramDoodleLayout)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = DisplayUtil.b(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.getContext(), 20.0F);
    this.jdField_a_of_type_Float = 1.5F;
  }
  
  public boolean a(FaceLayer paramFaceLayer, MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    switch (paramMotionEvent.getAction())
    {
    default: 
    case 0: 
    case 2: 
      do
      {
        return false;
        this.jdField_a_of_type_AndroidGraphicsRect = new Rect(DoodleLayout.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout).getLeft() - this.jdField_a_of_type_Int, DoodleLayout.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout).getTop() - this.jdField_a_of_type_Int, DoodleLayout.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout).getRight() + this.jdField_a_of_type_Int, DoodleLayout.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout).getBottom() + this.jdField_a_of_type_Int);
        ViewCompat.a(DoodleLayout.e(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout), 1.0F);
        DoodleLayout.b(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout, new View[] { DoodleLayout.d(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout), DoodleLayout.f(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout), DoodleLayout.g(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout), DoodleLayout.e(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout), DoodleLayout.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout) });
        DoodleLayout.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout, new View[] { DoodleLayout.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout) });
        DoodleLayout.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout, 4);
        return false;
        if (this.jdField_a_of_type_AndroidGraphicsRect.contains((int)f1, (int)f2))
        {
          SLog.b("DoodleLayout", "the face enter rubbish area.");
          this.jdField_a_of_type_Boolean = true;
          DoodleLayout.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout).a(1.5F);
          return false;
        }
      } while (!this.jdField_a_of_type_Boolean);
      SLog.b("DoodleLayout", "the face leave rubbish area.");
      this.jdField_a_of_type_Boolean = false;
      DoodleLayout.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout).a(1.0F);
      return false;
    }
    if ((this.jdField_a_of_type_AndroidGraphicsRect != null) && (this.jdField_a_of_type_AndroidGraphicsRect.contains((int)f1, (int)f2)))
    {
      SLog.b("DoodleLayout", "remove face.");
      DoodleLayout.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout).b();
      DoodleLayout.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout).a(1.0F);
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a();
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ixv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
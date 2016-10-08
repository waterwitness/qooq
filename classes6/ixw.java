import android.view.View;
import android.widget.ImageView;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo.doodle.layer.FaceLayer;
import com.tencent.biz.qqstory.takevideo.doodle.layer.FaceLayer.LayerParams;
import com.tencent.biz.qqstory.takevideo.doodle.layer.model.SelectedItem;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import com.tencent.biz.qqstory.takevideo.doodle.ui.face.FacePanel;
import com.tencent.biz.qqstory.takevideo.doodle.ui.face.FacePanel.OnFaceSelectedListener;
import com.tencent.biz.qqstory.takevideo.doodle.ui.face.LocationFacePackage.Item;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ixw
  implements FacePanel.OnFaceSelectedListener
{
  private ixw(DoodleLayout paramDoodleLayout)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private void a()
  {
    DoodleLayout.a(this.a).setVisibility(8);
    this.a.setViewActive(DoodleLayout.f(this.a), true);
    this.a.setViewActive(DoodleLayout.g(this.a), true);
    this.a.setViewActive(DoodleLayout.e(this.a), true);
    DoodleLayout.b(this.a, new View[] { DoodleLayout.a(this.a) });
    DoodleLayout.a(this.a, false);
    DoodleLayout.a(this.a, new View[] { DoodleLayout.a(this.a) });
    DoodleLayout.d(this.a).setImageResource(2130841378);
    DoodleLayout.b(this.a, 0);
  }
  
  public void a(SelectedItem paramSelectedItem, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    SLog.b("DoodleLayout", "onNormalFaceSelected,name:" + paramSelectedItem.b + ",drawable:" + paramSelectedItem.jdField_a_of_type_AndroidGraphicsDrawableDrawable + ",x:" + paramFloat1 + ",y:" + paramFloat2 + ",scale:" + paramFloat3);
    a();
    FaceLayer.LayerParams localLayerParams = new FaceLayer.LayerParams();
    localLayerParams.jdField_a_of_type_AndroidGraphicsPointF.x = paramFloat1;
    localLayerParams.jdField_a_of_type_AndroidGraphicsPointF.y = (DoodleLayout.a(this.a) + paramFloat2);
    localLayerParams.jdField_a_of_type_Float = paramFloat3;
    if (DoodleLayout.a(this.a).a(paramSelectedItem.jdField_a_of_type_JavaLangString, paramSelectedItem.b, paramSelectedItem.jdField_a_of_type_AndroidGraphicsDrawableDrawable, localLayerParams)) {
      DoodleLayout.a("clk_oneface");
    }
  }
  
  public void a(LocationFacePackage.Item paramItem)
  {
    SLog.b("DoodleLayout", "onLocationFaceSelected, pictureUrl:" + paramItem.d);
    a();
    this.a.a(paramItem);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ixw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
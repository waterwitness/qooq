import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo.doodle.layer.FaceLayer.FaceAndTextItem;
import com.tencent.biz.qqstory.takevideo.doodle.layer.FaceLayer.LayerEventListener;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout.DoodleEventListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ixs
  implements FaceLayer.LayerEventListener
{
  public ixs(DoodleLayout paramDoodleLayout)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt)
  {
    if (DoodleLayout.a(this.a) != null) {
      DoodleLayout.a(this.a).a(1, paramInt);
    }
  }
  
  public void a(FaceLayer.FaceAndTextItem paramFaceAndTextItem)
  {
    DoodleLayout.a(this.a, paramFaceAndTextItem);
    if (DoodleLayout.a(this.a) != null)
    {
      SLog.b("DoodleLayout", "selectLocation: clickItem-->" + paramFaceAndTextItem.toString());
      DoodleLayout.a(this.a).a(DoodleLayout.a(this.a).a());
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ixs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
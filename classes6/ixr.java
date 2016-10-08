import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo.doodle.layer.LineLayer.LayerEventListener;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout.DoodleEventListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ixr
  implements LineLayer.LayerEventListener
{
  public ixr(DoodleLayout paramDoodleLayout)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt)
  {
    if (DoodleLayout.a(this.a) != null) {
      DoodleLayout.a(this.a).a(2, paramInt);
    }
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (DoodleLayout.a(this.a) != null)
    {
      SLog.b("DoodleLayout", "notify outside onDrawMosaic. width:" + paramInt1 + ",height:" + paramInt2);
      DoodleLayout.a(this.a).a(paramArrayOfByte);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ixr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
import com.tencent.av.opengl.effects.EffectsRenderController;
import com.tencent.av.opengl.effects.FilterProcessRender;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.util.youtu.VideoPreviewFaceOutlineDetector;

public class gjp
  implements Runnable
{
  public gjp(FilterProcessRender paramFilterProcessRender)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    long l = System.currentTimeMillis();
    VideoPreviewFaceOutlineDetector.getInstance().doFaceDetect();
    l = (System.currentTimeMillis() - l) / 1L;
    if (QLog.isColorLevel()) {
      QLog.d(EffectsRenderController.a, 2, "FilterProcessRender_doFaceDetect [steptimeDetect= " + l + " ms]");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gjp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
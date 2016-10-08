import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.hwcodec.SVHwEncoder;

public class iwq
  implements Runnable
{
  private SVHwEncoder a;
  
  public iwq(SVHwEncoder paramSVHwEncoder)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = paramSVHwEncoder;
  }
  
  public void run()
  {
    SLog.b("Q.qqstory.record.NewStoryTakeVideoActivity", "handleQQVideo(): onSendVideoClick mEncoderCache=" + this.a);
    if (this.a != null) {
      this.a.b();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\iwq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
import com.tencent.biz.qqstory.takevideo.QQStoryPreTakeVideo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.CircleProgress;
import com.tencent.qphone.base.util.QLog;

public class iwu
  implements Runnable
{
  public iwu(QQStoryPreTakeVideo paramQQStoryPreTakeVideo)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.a.a.setProgress((QQStoryPreTakeVideo.a(this.a) + QQStoryPreTakeVideo.b(this.a)) / 2);
    if (QLog.isColorLevel()) {
      QLog.d("QQStoryPreTakeVideo", 2, "onProgress setProgress=" + (QQStoryPreTakeVideo.a(this.a) + QQStoryPreTakeVideo.b(this.a)) / 2);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\iwu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
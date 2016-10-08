import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.tips.VideoStatusTipsBar;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ofe
  implements Runnable
{
  public ofe(VideoStatusTipsBar paramVideoStatusTipsBar)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    VideoStatusTipsBar.a(this.a).a().e(true);
    this.a.a(VideoStatusTipsBar.a(this.a).jdField_a_of_type_Int, VideoStatusTipsBar.a(this.a).jdField_a_of_type_JavaLangString, 0, 0L);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\ofe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
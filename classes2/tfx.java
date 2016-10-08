import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.qphone.base.util.QLog;

public class tfx
  implements Runnable
{
  public tfx(QQPlayerService paramQQPlayerService)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (QQPlayerService.h() == 5) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QQPlayerService", 2, "===========> timeout retry to check playState:" + QQPlayerService.b(QQPlayerService.h()) + ",needRetryPlay:" + bool);
      }
      if ((bool) && (QQPlayerService.b() != null)) {
        QQPlayerService.a(this.a, QQPlayerService.b().a);
      }
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tfx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
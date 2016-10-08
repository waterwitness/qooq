import android.os.Handler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.logic.VideoPlayLogic;

public class vob
  implements Runnable
{
  public vob(VideoPlayLogic paramVideoPlayLogic)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.a.b != null) {
      VideoPlayLogic.c(this.a);
    }
    this.a.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.a.jdField_a_of_type_JavaLangRunnable);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vob.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
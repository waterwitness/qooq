import android.os.Handler;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.QavPanelSoundWaveView;
import com.tencent.av.ui.QavPanelWave;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.Iterator;
import java.util.List;
import mqq.app.BaseActivity;

public class gym
  implements Runnable
{
  public gym(QavPanelSoundWaveView paramQavPanelSoundWaveView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    float f3 = 0.0F;
    if (this.a.getVisibility() != 0)
    {
      this.a.jdField_a_of_type_AndroidOsHandler.postDelayed(this.a.jdField_a_of_type_JavaLangRunnable, 200L);
      return;
    }
    Object localObject;
    int i;
    float f1;
    if (!this.a.jdField_a_of_type_Boolean)
    {
      localObject = this.a;
      ((QavPanelSoundWaveView)localObject).c += -this.a.jdField_a_of_type_Float * 4.8E-4F;
      float f2 = 1.0F;
      localObject = this.a.getContext();
      i = 0;
      f1 = f2;
      if (!(localObject instanceof BaseActivity)) {
        break label301;
      }
      localObject = ((BaseActivity)localObject).getAppRuntime();
      f1 = f2;
      if (!(localObject instanceof VideoAppInterface)) {
        break label301;
      }
      localObject = ((VideoAppInterface)localObject).a();
      f2 = ((VideoController)localObject).a() * 0.05F;
      if (((VideoController)localObject).a().f != 3)
      {
        f1 = f2;
        if (!((VideoController)localObject).a().f()) {
          break label301;
        }
      }
      i = 1;
      f1 = f2;
    }
    label301:
    for (;;)
    {
      if ((i != 0) && (!this.a.jdField_a_of_type_Boolean))
      {
        this.a.c = 0.0F;
        f1 = f3;
      }
      for (;;)
      {
        localObject = this.a.jdField_a_of_type_JavaUtilList.iterator();
        for (;;)
        {
          if (((Iterator)localObject).hasNext())
          {
            ((QavPanelWave)((Iterator)localObject).next()).a(this.a.c, f1);
            continue;
            localObject = this.a;
            ((QavPanelSoundWaveView)localObject).c += -this.a.jdField_a_of_type_Float * 6.7E-4F;
            break;
          }
        }
        this.a.jdField_a_of_type_AndroidOsHandler.postDelayed(this.a.jdField_a_of_type_JavaLangRunnable, 66L);
        this.a.invalidate();
        return;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gym.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
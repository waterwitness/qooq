import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.tencent.biz.qqstory.pgc.QQStoryContentActivity;
import com.tencent.biz.qqstory.pgc.model.Story;
import com.tencent.biz.qqstory.pgc.model.StoryCoverInfo;
import com.tencent.biz.qqstory.pgc.view.VideoContentView;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ind
  implements SensorEventListener
{
  public ind(VideoContentView paramVideoContentView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    paramSensorEvent = paramSensorEvent.values;
    float f1 = -paramSensorEvent[0];
    float f2 = -paramSensorEvent[1];
    float f3 = -paramSensorEvent[2];
    if ((f1 * f1 + f2 * f2) * 4.0F >= f3 * f3)
    {
      j = 90 - Math.round(57.29578F * (float)Math.atan2(-f2, f1));
      for (;;)
      {
        i = j;
        if (j < 360) {
          break;
        }
        j -= 360;
      }
      for (;;)
      {
        j = i;
        if (i >= 0) {
          break;
        }
        i += 360;
      }
    }
    int j = 0;
    int i = this.a.e;
    if (((j < 30) || (j > 330)) && (f2 < -6.0F)) {
      i = 0;
    }
    label322:
    label363:
    for (;;)
    {
      if ((i != this.a.e) && (!this.a.c))
      {
        this.a.e = i;
        if (this.a.e != 1) {
          break label322;
        }
        this.a.m();
      }
      for (;;)
      {
        if (this.a.e != 0) {
          StoryReportor.a("play_page_video", "rotator", ((QQStoryContentActivity)this.a.getContext()).g, 0, new String[] { this.a.a.getUnionId(), this.a.a.storyId, StoryReportor.a(this.a.getContext()), this.a.a.coverInfo.vid });
        }
        return;
        if ((j > 60) && (j < 120))
        {
          i = 2;
          break;
        }
        if ((j <= 240) || (j >= 300)) {
          break label363;
        }
        i = 1;
        break;
        if (this.a.e == 2) {
          this.a.l();
        } else if (this.a.e == 0) {
          this.a.k();
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ind.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
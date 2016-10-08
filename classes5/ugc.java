import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.richmedia.VideoSendTaskManager;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

public class ugc
  implements Runnable
{
  public ugc(VideoSendTaskManager paramVideoSendTaskManager, HashMap paramHashMap)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    StatisticCollector.a(BaseApplication.getContext()).a(null, "actPreUploadVideoCancel", true, 0L, -1L, this.jdField_a_of_type_JavaUtilHashMap, "");
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\ugc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
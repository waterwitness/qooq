import android.os.SystemClock;
import com.tencent.biz.qqstory.model.pendant.NewStoryPendantItem;
import com.tencent.biz.qqstory.model.pendant.PendantManager;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ijv
  extends ijx
{
  public ijv(PendantManager paramPendantManager, NewStoryPendantItem paramNewStoryPendantItem, long paramLong)
  {
    super(paramNewStoryPendantItem);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(NewStoryPendantItem arg1)
  {
    super.onResult(???);
    if (??? != null)
    {
      long l1 = SystemClock.uptimeMillis();
      long l2 = this.jdField_a_of_type_Long;
      StoryReportor.b("edit_video", "download_pendant_pack_result", 0, ???.a(), new String[0]);
      if (???.a() == 0) {
        StoryReportor.b("edit_video", "download_pendant_pack_time", 0, 0, new String[] { "" + (l1 - l2) });
      }
    }
    SLog.b("PendantManager", "startDownload again");
    synchronized (this.jdField_a_of_type_ComTencentBizQqstoryModelPendantPendantManager.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryModelPendantPendantManager.jdField_a_of_type_ComTencentBizQqstoryModelPendantNewStoryPendantItem = null;
      PendantManager.a(this.jdField_a_of_type_ComTencentBizQqstoryModelPendantPendantManager);
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ijv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
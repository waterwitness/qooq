import android.os.SystemClock;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.download.Downloader;
import com.tencent.biz.qqstory.model.pendant.FileDownloadTask;
import com.tencent.biz.qqstory.model.pendant.FileDownloadTask.Output;
import com.tencent.biz.qqstory.model.pendant.NewStoryPendantUpdateEvent;
import com.tencent.biz.qqstory.model.pendant.PendantManager;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;

public class ijw
  extends FileDownloadTask
{
  public ijw(PendantManager paramPendantManager, Downloader paramDownloader, long paramLong)
  {
    super(paramDownloader);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(FileDownloadTask.Output paramOutput)
  {
    SLog.a("FileDownloadTask", "downloadConfigFile onPostExecute : %s", paramOutput);
    StoryReportor.b("edit_video", "download_pendant_config", 0, paramOutput.jdField_a_of_type_Int, new String[0]);
    if (paramOutput.jdField_a_of_type_Int == 0)
    {
      long l1 = SystemClock.uptimeMillis();
      long l2 = this.jdField_a_of_type_Long;
      StoryReportor.b("edit_video", "download_pendant_config_time", 0, 0, new String[] { "" + (l1 - l2) });
      PendantManager.b(this.jdField_a_of_type_ComTencentBizQqstoryModelPendantPendantManager);
      return;
    }
    Dispatchers.get().dispatch(new NewStoryPendantUpdateEvent(new ErrorMessage(paramOutput.jdField_a_of_type_Int, paramOutput.jdField_a_of_type_JavaLangString)));
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ijw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
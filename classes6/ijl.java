import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.biz.qqstory.base.download.DownloadProgressListener;
import com.tencent.biz.qqstory.base.download.Downloader;
import com.tencent.biz.qqstory.base.download.DownloaderImp;
import com.tencent.biz.qqstory.model.DoodleEmojiManager;
import com.tencent.biz.qqstory.model.DoodleEmojiManager.DoodleEmojiDownloadEvent;
import com.tencent.biz.qqstory.model.item.DoodleEmojiItem;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;
import java.io.File;

public class ijl
  extends SimpleJob
  implements DownloadProgressListener
{
  protected long a;
  private final Downloader jdField_a_of_type_ComTencentBizQqstoryBaseDownloadDownloader;
  private final DoodleEmojiItem jdField_a_of_type_ComTencentBizQqstoryModelItemDoodleEmojiItem;
  
  public ijl(DoodleEmojiItem paramDoodleEmojiItem)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    if (paramDoodleEmojiItem == null) {
      throw new IllegalArgumentException("doodleEmojiItem should not be null");
    }
    this.jdField_a_of_type_ComTencentBizQqstoryBaseDownloadDownloader = new DownloaderImp();
    this.jdField_a_of_type_ComTencentBizQqstoryBaseDownloadDownloader.a(this);
    this.jdField_a_of_type_ComTencentBizQqstoryModelItemDoodleEmojiItem = paramDoodleEmojiItem;
  }
  
  protected DoodleEmojiItem a(JobContext paramJobContext, Void... paramVarArgs)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryBaseDownloadDownloader.a(this.jdField_a_of_type_ComTencentBizQqstoryModelItemDoodleEmojiItem.e, DoodleEmojiManager.a(this.jdField_a_of_type_ComTencentBizQqstoryModelItemDoodleEmojiItem.a), 0L);
    return this.jdField_a_of_type_ComTencentBizQqstoryModelItemDoodleEmojiItem;
  }
  
  public void a(String paramString, int paramInt)
  {
    DoodleEmojiItem localDoodleEmojiItem1 = this.jdField_a_of_type_ComTencentBizQqstoryModelItemDoodleEmojiItem;
    if (paramInt == 0)
    {
      paramString = DoodleEmojiManager.a(localDoodleEmojiItem1.a);
      String str = DoodleEmojiManager.b(localDoodleEmojiItem1.a);
      SLog.b("DoodleEmojiManager", "DownloadListener onDownloadFinish zip = " + paramString);
      SLog.b("DoodleEmojiManager", "DownloadListener onDownloadFinish folder = " + str);
      try
      {
        int i = ZipUtils.a(paramString, str);
        if (i == 0)
        {
          long l1 = SystemClock.uptimeMillis();
          long l2 = this.jdField_a_of_type_Long;
          StoryReportor.b("edit_video", "face_download_timecost", 0, 0, new String[] { localDoodleEmojiItem1.a, l1 - l2 + "" });
          StoryReportor.b("edit_video", "face_download_success", 0, 0, new String[] { localDoodleEmojiItem1.a });
          SLog.c("DoodleEmojiManager", "DownloadListener onDownloadFinish success, unZip success");
          localDoodleEmojiItem1.a(str);
          new File(str).setLastModified(System.currentTimeMillis());
          Dispatchers.get().dispatch(new DoodleEmojiManager.DoodleEmojiDownloadEvent(localDoodleEmojiItem1, paramInt, true, 0L, 0L));
        }
        for (;;)
        {
          return;
          SLog.d("DoodleEmojiManager", "DownloadListener onDownloadFinish unZip failed, treat it as download failed");
          Dispatchers.get().dispatch(new DoodleEmojiManager.DoodleEmojiDownloadEvent(localDoodleEmojiItem1, i, false, 0L, 0L));
          StoryReportor.b("edit_video", "face_download_success", 0, i, new String[] { localDoodleEmojiItem1.a });
        }
        SLog.e("DoodleEmojiManager", "DownloadListener onDownloadFinish error = " + paramInt + ", url = " + paramString);
      }
      finally
      {
        new File(paramString).delete();
      }
    }
    Dispatchers.get().dispatch(new DoodleEmojiManager.DoodleEmojiDownloadEvent(localDoodleEmojiItem2, paramInt, true, 0L, 0L));
    StoryReportor.b("edit_video", "face_download_success", 0, paramInt, new String[] { localDoodleEmojiItem2.a });
  }
  
  public void a(String paramString, long paramLong1, long paramLong2)
  {
    DoodleEmojiItem localDoodleEmojiItem = this.jdField_a_of_type_ComTencentBizQqstoryModelItemDoodleEmojiItem;
    if (!TextUtils.equals(localDoodleEmojiItem.e, paramString))
    {
      SLog.d("DoodleEmojiManager", "DownloadListener onProgress error : " + localDoodleEmojiItem);
      SLog.d("DoodleEmojiManager", "DownloadListener onProgress error : call back url = " + paramString);
      return;
    }
    SLog.a("DoodleEmojiManager", "DownloadListener onProgress " + paramLong1 + " / " + paramLong2);
    Dispatchers.get().dispatch(new DoodleEmojiManager.DoodleEmojiDownloadEvent(localDoodleEmojiItem, 0, false, paramLong2, paramLong1));
  }
  
  public void a(String paramString1, String paramString2)
  {
    SLog.b("DoodleEmojiManager", "onDownloadStart : url = " + paramString1 + ", path = " + paramString2);
    this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ijl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
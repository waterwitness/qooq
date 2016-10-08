import com.tencent.biz.qqstory.base.download.DownloadProgressListener;
import com.tencent.biz.qqstory.model.pendant.FileDownloadTask;
import com.tencent.biz.qqstory.model.pendant.FileDownloadTask.Input;
import com.tencent.biz.qqstory.model.pendant.FileDownloadTask.Progress;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ijr
  implements DownloadProgressListener
{
  public ijr(FileDownloadTask paramFileDownloadTask, FileDownloadTask.Input paramInput)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(String paramString, int paramInt) {}
  
  public void a(String paramString, long paramLong1, long paramLong2)
  {
    FileDownloadTask.a(this.jdField_a_of_type_ComTencentBizQqstoryModelPendantFileDownloadTask, new FileDownloadTask.Progress[] { new FileDownloadTask.Progress(this.jdField_a_of_type_ComTencentBizQqstoryModelPendantFileDownloadTask$Input, paramLong1, paramLong2) });
  }
  
  public void a(String paramString1, String paramString2) {}
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ijr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
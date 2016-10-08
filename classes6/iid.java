import com.tencent.biz.qqstory.app.QQStoryConstant;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.videoupload.meta.GenerateVideoSegment;
import com.tencent.biz.qqstory.base.videoupload.meta.GenerateVideoSegment.CallBack;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.ffmpeg.FFmpegUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;

public class iid
  extends SimpleJob
{
  public iid(GenerateVideoSegment paramGenerateVideoSegment, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected Object a(JobContext paramJobContext, Void... paramVarArgs)
  {
    GenerateVideoSegment.a(this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadMetaGenerateVideoSegment, System.currentTimeMillis());
    try
    {
      paramJobContext = QQStoryConstant.n + System.currentTimeMillis() + ".mp4";
      this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadMetaGenerateVideoSegment.c = paramJobContext;
      FFmpegUtils.a(QQStoryContext.a().a(), this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadMetaGenerateVideoSegment.d, this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadMetaGenerateVideoSegment.b, (int)this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadMetaGenerateVideoSegment.a, paramJobContext, new GenerateVideoSegment.CallBack(this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadMetaGenerateVideoSegment));
      return null;
    }
    catch (Exception paramJobContext)
    {
      for (;;)
      {
        SLog.b("Q.qqstory.publish:GenerateVideoSegment", "combine audio fail", paramJobContext);
        GenerateVideoSegment.a(this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadMetaGenerateVideoSegment, new ErrorMessage(941000, paramJobContext.getMessage()));
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\iid.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
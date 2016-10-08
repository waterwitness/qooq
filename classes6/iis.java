import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;

class iis
  extends SimpleJob
{
  iis(iir paramiir, CmdTaskManger.CommandCallback paramCommandCallback, BaseResponse paramBaseResponse, int paramInt, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected Object doInBackground(JobContext paramJobContext, Object[] paramArrayOfObject)
  {
    SLog.a("Q.qqstory:CmdTaskManager", "do callback %s", this.jdField_a_of_type_Iir.a.a());
    this.jdField_a_of_type_ComTencentBizQqstoryChannelCmdTaskManger$CommandCallback.a(this.jdField_a_of_type_Iir.a, this.jdField_a_of_type_ComTencentBizQqstoryChannelBaseResponse, new ErrorMessage(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString));
    return null;
  }
  
  public int getJobType()
  {
    return 2;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\iis.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
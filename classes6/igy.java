import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.VideoServerInfoManager;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.network.request.RefreshVideoFileKeyRequest;
import com.tencent.biz.qqstory.network.response.RefreshVideoFileKeyResponse;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.concurrent.atomic.AtomicBoolean;

public class igy
  implements CmdTaskManger.CommandCallback
{
  public igy(VideoServerInfoManager paramVideoServerInfoManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(RefreshVideoFileKeyRequest arg1, RefreshVideoFileKeyResponse paramRefreshVideoFileKeyResponse, ErrorMessage paramErrorMessage)
  {
    this.a.jdField_a_of_type_Long = System.currentTimeMillis();
    if (paramErrorMessage.isSuccess())
    {
      this.a.jdField_a_of_type_ComTencentBizQqstoryBaseVideoServerInfoManager$ServerInfo = paramRefreshVideoFileKeyResponse.jdField_a_of_type_ComTencentBizQqstoryBaseVideoServerInfoManager$ServerInfo;
      SLog.b("Q.qqstory.publish:VideoServerInfoManager", "get server inf %s", this.a.jdField_a_of_type_ComTencentBizQqstoryBaseVideoServerInfoManager$ServerInfo);
    }
    for (;;)
    {
      this.a.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      synchronized (this.a.jdField_a_of_type_JavaLangObject)
      {
        this.a.jdField_a_of_type_JavaLangObject.notifyAll();
        return;
        SLog.b("Q.qqstory.publish:VideoServerInfoManager", "get server info:%s", paramErrorMessage);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\igy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
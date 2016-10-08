import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.channel.IProtocolListener;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;

public class iir
  implements IProtocolListener
{
  protected final long a;
  public CmdTaskManger.CommandCallback a;
  public NetworkRequest a;
  
  public iir(NetworkRequest paramNetworkRequest)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentBizQqstoryChannelNetworkRequest = paramNetworkRequest;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  private long a()
  {
    long l = 0L;
    if (this.jdField_a_of_type_Long != 0L) {
      l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
    }
    return l;
  }
  
  private void b(int paramInt, String paramString, BaseResponse paramBaseResponse)
  {
    CmdTaskManger.CommandCallback localCommandCallback = this.jdField_a_of_type_ComTencentBizQqstoryChannelCmdTaskManger$CommandCallback;
    if (localCommandCallback != null)
    {
      paramString = new iis(this, localCommandCallback, paramBaseResponse, paramInt, paramString);
      paramBaseResponse = Bosses.get();
      if (paramInt == 0) {}
      for (paramInt = 0;; paramInt = 500)
      {
        paramBaseResponse.scheduleJobDelayed(paramString, paramInt);
        return;
      }
    }
    SLog.d("Q.qqstory:CmdTaskManager", "cmd callback is null");
  }
  
  public void a(int paramInt, String paramString, BaseResponse paramBaseResponse)
  {
    b(paramInt, paramString, paramBaseResponse);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\iir.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
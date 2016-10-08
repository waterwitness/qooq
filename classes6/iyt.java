import com.tencent.av.core.VcSystemInfo;
import com.tencent.biz.qqstory.model.DoodleEmojiManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.takevideo.NewStoryTakeVideoActivity;
import com.tencent.biz.qqstory.takevideo.rmw.RMWLog;
import com.tencent.biz.qqstory.takevideo.rmw.RMWService;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.hwcodec.HwEnvData;
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad;

public class iyt
  extends Thread
{
  public iyt(RMWService paramRMWService)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    RMWLog.b("RMWService", "preload AVCodec - start -");
    VideoEnvironment.a("AVCodec", null, true);
    RMWLog.b("RMWService", "preload AVCodec - end -");
    RMWLog.b("RMWService", "preload PtvFilterSoLoad - start -");
    PtvFilterSoLoad.a(VideoEnvironment.a(), false);
    RMWLog.b("RMWService", "preload PtvFilterSoLoad - end -");
    RMWLog.b("RMWService", "preInit DoodleEmojiManager - start -");
    ((DoodleEmojiManager)SuperManager.a(8)).a(this.a);
    RMWLog.b("RMWService", "preInit DoodleEmojiManager - end -");
    RMWLog.b("RMWService", "preInit PendantManager - start -");
    SuperManager.a(11);
    RMWLog.b("RMWService", "preInit PendantManager - end -");
    RMWLog.b("RMWService", "preInit class - " + NewStoryTakeVideoActivity.class.getSimpleName());
    RMWLog.b("RMWService", "preInit HwEnvData.supportHardWareCodec - start -");
    HwEnvData.a();
    RMWLog.b("RMWService", "preInit HwEnvData.supportHardWareCodec - end -");
    RMWLog.b("RMWService", "preInit VcSystemInfo.getCpuInfo - start -");
    VcSystemInfo.a();
    RMWLog.b("RMWService", "preInit VcSystemInfo.getCpuInfo - end -");
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\iyt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
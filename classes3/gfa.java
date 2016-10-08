import com.tencent.av.SessionMgr;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.core.VcControllerImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class gfa
  implements Runnable
{
  public gfa(VideoController paramVideoController)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if ((this.a.jdField_a_of_type_ComTencentAvSessionMgr.a().a) && (this.a.jdField_a_of_type_ComTencentAvSessionMgr.a().i) && (this.a.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_f_of_type_Int == 2))
    {
      this.a.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_f_of_type_Boolean = false;
      this.a.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.pauseVideo(this.a.jdField_a_of_type_ComTencentAvSessionMgr.a().c);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gfa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
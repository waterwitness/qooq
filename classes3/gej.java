import android.content.Context;
import com.tencent.av.SessionMgr;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.utils.PopupDialog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class gej
  implements Runnable
{
  public gej(VideoController paramVideoController)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d(VideoController.jdField_a_of_type_JavaLangString, 2, "networkBrokenRunnable");
    }
    if (this.a.n())
    {
      Context localContext = this.a.a();
      PopupDialog.b(localContext, 230, null, localContext.getString(2131363173), 0, 2131363160, new gek(this), null);
    }
    for (;;)
    {
      VideoController.a(this.a, false);
      return;
      if ((this.a.jdField_a_of_type_ComTencentAvSessionMgr.a().j > 0) && (this.a.jdField_a_of_type_ComTencentAvSessionMgr.a().j <= 4))
      {
        this.a.a(this.a.jdField_a_of_type_ComTencentAvSessionMgr.a().c, 0);
        this.a.c(this.a.jdField_a_of_type_ComTencentAvSessionMgr.a().c, 9);
      }
      else
      {
        this.a.a(this.a.E, this.a.jdField_a_of_type_Long, 15, 0);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gej.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
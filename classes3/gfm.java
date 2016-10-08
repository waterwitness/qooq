import android.content.Intent;
import com.tencent.av.SessionMgr;
import com.tencent.av.VideoController;
import com.tencent.av.VideoController.GAudioFriends;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.core.VcControllerImpl;
import com.tencent.av.ui.MultiPstnCallbackFinishDialogActivity;
import com.tencent.av.utils.PhoneStatusMonitor.PhoneStatusListener;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class gfm
  implements PhoneStatusMonitor.PhoneStatusListener
{
  gfm(VideoController paramVideoController)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(VideoController.jdField_a_of_type_JavaLangString, 2, "onCallStateChanged isCalling: " + paramBoolean);
    }
    if (paramBoolean) {
      switch (this.a.jdField_a_of_type_ComTencentAvSessionMgr.a().j)
      {
      }
    }
    for (;;)
    {
      if ((this.a.a() != null) && (this.a.a().n()) && (this.a.a().x == 1))
      {
        if (!paramBoolean) {
          break;
        }
        this.a.a().F = false;
        this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(705), Boolean.valueOf(false) });
      }
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(22), Boolean.valueOf(paramBoolean) });
      return;
      this.a.a(this.a.jdField_a_of_type_ComTencentAvSessionMgr.a().c, 0);
      this.a.c(this.a.jdField_a_of_type_ComTencentAvSessionMgr.a().c, 0);
      continue;
      this.a.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.rejectVideo(this.a.jdField_a_of_type_ComTencentAvSessionMgr.a().c, this.a.d(), 3);
      this.a.a(this.a.jdField_a_of_type_ComTencentAvSessionMgr.a().c, 0);
      this.a.c(this.a.jdField_a_of_type_ComTencentAvSessionMgr.a().c, 1);
      continue;
      this.a.b(3, Long.valueOf(this.a.jdField_a_of_type_ComTencentAvSessionMgr.a().c).longValue());
      if (QLog.isColorLevel())
      {
        QLog.e(VideoController.jdField_a_of_type_JavaLangString, 2, "Reject Video Request when chating");
        continue;
        this.a.b(true);
        continue;
        this.a.b(this.a.an, this.a.e);
        this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(67), Long.valueOf(this.a.e), Integer.valueOf(3) });
        continue;
        this.a.a(UITools.a(this.a.jdField_a_of_type_ComTencentAvSessionMgr.a().l), this.a.jdField_a_of_type_ComTencentAvSessionMgr.a().e, 0, new int[0]);
        this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(66), Long.valueOf(this.a.jdField_a_of_type_ComTencentAvSessionMgr.a().e) });
        continue;
        switch (this.a.jdField_a_of_type_ComTencentAvSessionMgr.a().j)
        {
        case 2: 
        case 5: 
        case 6: 
        case 7: 
        case 8: 
        default: 
          break;
        case 3: 
        case 4: 
        case 9: 
        case 10: 
          this.a.b(false);
        }
      }
    }
    Object localObject = this.a.b().iterator();
    do
    {
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
    } while (((VideoController.GAudioFriends)((Iterator)localObject).next()).c == 0);
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        localObject = new Intent(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getApplicationContext(), MultiPstnCallbackFinishDialogActivity.class);
        ((Intent)localObject).addFlags(268435456);
        this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().startActivity((Intent)localObject);
        break;
      }
      this.a.a(UITools.a(this.a.jdField_a_of_type_ComTencentAvSessionMgr.a().l), this.a.jdField_a_of_type_ComTencentAvSessionMgr.a().e, 0, new int[0]);
      this.a.L();
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(66), Long.valueOf(this.a.jdField_a_of_type_ComTencentAvSessionMgr.a().e) });
      break;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gfm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
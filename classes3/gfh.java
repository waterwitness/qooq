import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.SessionMgr;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.SessionInfo.Anychat_Info;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class gfh
  implements DialogInterface.OnClickListener
{
  gfh(gfg paramgfg)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.a.a.jdField_a_of_type_ComTencentAvSessionMgr.a().c == null) {
      this.a.a.jdField_a_of_type_ComTencentAvSessionMgr.a().c = this.a.a.jdField_a_of_type_ComTencentAvSessionMgr.a().a.c;
    }
    this.a.a.a(2131165198, 1, this.a.a.b);
    this.a.a.jdField_a_of_type_ComTencentAvSessionMgr.a().j = 6;
    this.a.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(14), Integer.valueOf(9), this.a.a.jdField_a_of_type_ComTencentAvSessionMgr.a().c });
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gfh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
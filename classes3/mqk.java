import android.os.Handler;
import com.tencent.mobileqq.activity.TroopGagActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import java.util.ArrayList;

class mqk
  implements Runnable
{
  mqk(mqj parammqj, Handler paramHandler)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    ArrayList localArrayList = ((TroopGagMgr)this.jdField_a_of_type_Mqj.a.app.getManager(47)).a(this.jdField_a_of_type_Mqj.a.b, false);
    this.jdField_a_of_type_AndroidOsHandler.post(new mql(this, localArrayList));
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mqk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
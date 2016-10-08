import android.content.SharedPreferences;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.mybusiness.MyBusinessManager;

class qch
  implements Runnable
{
  qch(qcf paramqcf)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    ((MyBusinessManager)PhoneContactManagerImp.a(this.a.a).getManager(48)).a(this.a.a.a.getString("contact_bind_info_mobile", ""), this.a.a.a.getInt("contact_bind_type", 0), "");
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\qch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
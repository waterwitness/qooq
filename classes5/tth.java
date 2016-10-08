import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.pic.PresendPicMgr;

public class tth
  implements Runnable
{
  private ttg jdField_a_of_type_Ttg;
  
  public tth(PresendPicMgr paramPresendPicMgr, ttg paramttg)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Ttg = paramttg;
  }
  
  public void run()
  {
    Logger.a("PresendPicMgr", "PresendRunnable.run", "PresendReq is " + this.jdField_a_of_type_Ttg);
    this.jdField_a_of_type_Ttg.a();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tth.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
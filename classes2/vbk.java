import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.transfile.FMTSrvAddrProvider;
import com.tencent.mobileqq.transfile.ServerAddr;

public class vbk
  extends ServerAddr
{
  public int a;
  
  public vbk()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a() {}
  
  public void b()
  {
    FMTSrvAddrProvider.a().a(this.jdField_a_of_type_Int, "http://" + this.jdField_a_of_type_JavaLangString + ":" + this.b);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vbk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
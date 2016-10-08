import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.qipc.QIPCServerModuleFactory;
import eipc.EIPCModule;
import eipc.EIPCModuleFactory;

public final class uak
  implements EIPCModuleFactory
{
  public uak()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public EIPCModule onCreateModule(String paramString)
  {
    return QIPCServerModuleFactory.a(paramString);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\uak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
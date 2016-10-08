package cooperation.weiyun;

import android.os.Bundle;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand.OnInvokeFinishLinstener;
import java.util.concurrent.atomic.AtomicInteger;

public class WeiyunRemoteCommand
  extends RemoteCommand
{
  private static WeiyunRemoteCommand.OnStateChangeListener jdField_a_of_type_CooperationWeiyunWeiyunRemoteCommand$OnStateChangeListener;
  public static final String a = "weiyun.notify_state";
  private static final AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger();
  public static final String b = "param_state";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public WeiyunRemoteCommand()
  {
    super("weiyun.notify_state");
  }
  
  public int a()
  {
    return jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
  }
  
  public void a(WeiyunRemoteCommand.OnStateChangeListener paramOnStateChangeListener)
  {
    jdField_a_of_type_CooperationWeiyunWeiyunRemoteCommand$OnStateChangeListener = paramOnStateChangeListener;
  }
  
  public Bundle invoke(Bundle paramBundle, RemoteCommand.OnInvokeFinishLinstener paramOnInvokeFinishLinstener)
  {
    paramOnInvokeFinishLinstener = new Bundle();
    int i = paramBundle.getInt("param_state", jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
    if (i != jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get())
    {
      jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(i);
      if (jdField_a_of_type_CooperationWeiyunWeiyunRemoteCommand$OnStateChangeListener != null) {
        jdField_a_of_type_CooperationWeiyunWeiyunRemoteCommand$OnStateChangeListener.a(jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
      }
    }
    return paramOnInvokeFinishLinstener;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\weiyun\WeiyunRemoteCommand.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
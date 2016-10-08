import com.tencent.mobileqq.app.PluginConfigProxy;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import mqq.observer.ServerConfigObserver;
import protocol.KQQConfig.GetResourceRespV2;

public class qcx
  implements Runnable
{
  private int jdField_a_of_type_Int;
  private ServerConfigObserver jdField_a_of_type_MqqObserverServerConfigObserver;
  private GetResourceRespV2 jdField_a_of_type_ProtocolKQQConfigGetResourceRespV2;
  private boolean jdField_a_of_type_Boolean;
  
  public qcx(PluginConfigProxy paramPluginConfigProxy, ServerConfigObserver paramServerConfigObserver, boolean paramBoolean, int paramInt, GetResourceRespV2 paramGetResourceRespV2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_MqqObserverServerConfigObserver = paramServerConfigObserver;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ProtocolKQQConfigGetResourceRespV2 = paramGetResourceRespV2;
  }
  
  public void run()
  {
    this.jdField_a_of_type_MqqObserverServerConfigObserver.onGetPluginConfig(this.jdField_a_of_type_Boolean, this.jdField_a_of_type_Int, this.jdField_a_of_type_ProtocolKQQConfigGetResourceRespV2);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\qcx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
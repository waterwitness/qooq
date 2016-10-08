import com.tencent.mobileqq.apollo.ApolloRenderDriver;
import com.tencent.mobileqq.apollo.ITriggerRenderCallback;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.util.WeakReferenceHandler;
import java.lang.ref.WeakReference;

public class pqk
  implements Runnable
{
  int jdField_a_of_type_Int;
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  
  public pqk(ApolloRenderDriver paramApolloRenderDriver)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = 50;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramApolloRenderDriver);
  }
  
  public void run()
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null))
    {
      ApolloRenderDriver localApolloRenderDriver = (ApolloRenderDriver)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if ((localApolloRenderDriver != null) && (localApolloRenderDriver.jdField_a_of_type_ComTencentMobileqqApolloITriggerRenderCallback != null) && (localApolloRenderDriver.jdField_a_of_type_ComTencentUtilWeakReferenceHandler != null))
      {
        localApolloRenderDriver.jdField_a_of_type_ComTencentMobileqqApolloITriggerRenderCallback.c();
        localApolloRenderDriver.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.postDelayed(this, this.jdField_a_of_type_Int);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\pqk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
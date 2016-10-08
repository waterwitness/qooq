import com.tencent.mobileqq.apollo.ApolloRenderInterfaceImpl;
import com.tencent.mobileqq.apollo.ApolloSurfaceView;
import com.tencent.mobileqq.apollo.OnApolloViewListener;
import com.tencent.mobileqq.apollo.store.ApolloGuestsStateActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.SoftReference;

public class prs
  implements OnApolloViewListener
{
  private SoftReference a;
  
  public prs(ApolloGuestsStateActivity paramApolloGuestsStateActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = new SoftReference(paramApolloGuestsStateActivity);
  }
  
  public void a(int paramInt) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloGuestsStateActivity", 2, "apollo view is Ready.");
    }
    ApolloGuestsStateActivity localApolloGuestsStateActivity = (ApolloGuestsStateActivity)this.a.get();
    if (localApolloGuestsStateActivity == null) {
      return;
    }
    float f = localApolloGuestsStateActivity.c;
    localApolloGuestsStateActivity.jdField_a_of_type_Float = (paramInt1 / 2 / f);
    if (localApolloGuestsStateActivity.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.a() != null) {
      localApolloGuestsStateActivity.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.a().g();
    }
    localApolloGuestsStateActivity.b();
    localApolloGuestsStateActivity.j = paramInt1;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\prs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.apollo.ApolloManager;
import com.tencent.mobileqq.apollo.ApolloSurfaceView;
import com.tencent.mobileqq.apollo.data.ApolloDress;
import com.tencent.mobileqq.apollo.store.ApolloGuestsStateActivity;
import com.tencent.mobileqq.apollo.task.OnDressDoneListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloBaseInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class prp
  implements OnDressDoneListener
{
  public prp(ApolloGuestsStateActivity paramApolloGuestsStateActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a()
  {
    if (this.a.d) {}
    do
    {
      do
      {
        return;
        localObject = ((ApolloManager)this.a.app.getManager(152)).b(this.a.g);
      } while (localObject == null);
      Object localObject = ((ApolloBaseInfo)localObject).getApolloDress();
      this.a.a((ApolloDress)localObject);
    } while (this.a.jdField_a_of_type_AndroidOsHandler == null);
    if (this.a.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView != null) {
      this.a.k = ((int)this.a.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.a());
    }
    this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(3).sendToTarget();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\prp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
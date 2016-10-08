import com.tencent.mobileqq.apollo.ApolloManager;
import com.tencent.mobileqq.apollo.utils.ApolloDaoManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class pqd
  implements Runnable
{
  public pqd(ApolloManager paramApolloManager, boolean paramBoolean, int paramInt)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Object localObject2;
    Object localObject1;
    if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloManager.a != null)
    {
      localObject2 = (ApolloDaoManager)this.jdField_a_of_type_ComTencentMobileqqApolloApolloManager.a.getManager(154);
      localObject1 = new ArrayList();
      if (localObject2 == null) {
        break label178;
      }
      if (!this.jdField_a_of_type_Boolean) {
        break label65;
      }
      localObject1 = ((ApolloDaoManager)localObject2).c();
    }
    label65:
    label178:
    for (;;)
    {
      if ((localObject1 == null) || (((List)localObject1).size() == 0)) {}
      do
      {
        return;
        localObject1 = ((ApolloDaoManager)localObject2).b(this.jdField_a_of_type_Int);
        break;
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloManager.a((List)localObject1);
      } while (!QLog.isColorLevel());
      localObject2 = new StringBuilder("update action[");
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((StringBuilder)localObject2).append(((ApolloActionData)((Iterator)localObject1).next()).actionId).append(",");
      }
      ((StringBuilder)localObject2).append("]");
      QLog.d("ApolloManager", 2, "checkPanelActionRes... action: " + ((StringBuilder)localObject2).toString());
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\pqd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
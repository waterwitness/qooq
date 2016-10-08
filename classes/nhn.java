import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.ApolloItemBuilder;
import com.tencent.mobileqq.apollo.ApolloManager;
import com.tencent.mobileqq.apollo.utils.ApolloDaoManager;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.apollo.view.ApolloInfo;
import com.tencent.mobileqq.apollo.view.ApolloMainInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.data.ApolloFavActionData;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public final class nhn
  implements Runnable
{
  public nhn(QQAppInterface paramQQAppInterface, Context paramContext, ApolloFavActionData paramApolloFavActionData, SessionInfo paramSessionInfo)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    Object localObject2;
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            localObject2 = (ApolloDaoManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(154);
          } while (localObject2 == null);
          localObject1 = ((ApolloDaoManager)localObject2).d();
          if ((localObject1 == null) || (((List)localObject1).size() < 143)) {
            break;
          }
          ApolloItemBuilder.a(this.jdField_a_of_type_AndroidContentContext.getString(2131372318), 1, this.jdField_a_of_type_AndroidContentContext);
        } while (!QLog.isColorLevel());
        QLog.d("ApolloItemBuilder", 2, "fav number is 144");
        return;
        if (((ApolloDaoManager)localObject2).a(this.jdField_a_of_type_ComTencentMobileqqDataApolloFavActionData.acitonId) != null) {
          break;
        }
        ApolloItemBuilder.a(this.jdField_a_of_type_AndroidContentContext.getString(2131372319), 1, this.jdField_a_of_type_AndroidContentContext);
      } while (!QLog.isColorLevel());
      QLog.d("ApolloItemBuilder", 2, "cant find the add aciton id=" + this.jdField_a_of_type_ComTencentMobileqqDataApolloFavActionData.acitonId);
      return;
      if (!((List)localObject1).contains(this.jdField_a_of_type_ComTencentMobileqqDataApolloFavActionData)) {
        break;
      }
      ApolloItemBuilder.a(this.jdField_a_of_type_AndroidContentContext.getString(2131372320), 1, this.jdField_a_of_type_AndroidContentContext);
    } while (!QLog.isColorLevel());
    QLog.d("ApolloItemBuilder", 2, "the add aciton is exist id=" + this.jdField_a_of_type_ComTencentMobileqqDataApolloFavActionData.acitonId);
    return;
    long l = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentMobileqqDataApolloFavActionData.favId = l;
    ((ApolloDaoManager)localObject2).a(this.jdField_a_of_type_ComTencentMobileqqDataApolloFavActionData);
    ApolloItemBuilder.a(this.jdField_a_of_type_AndroidContentContext.getString(2131372317), 2, this.jdField_a_of_type_AndroidContentContext);
    Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    int i = ApolloUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    String str = "" + this.jdField_a_of_type_ComTencentMobileqqDataApolloFavActionData.acitonId;
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataApolloFavActionData.text)) {}
    for (Object localObject1 = "0";; localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataApolloFavActionData.text)
    {
      VipUtils.a((AppInterface)localObject3, "cmshow", "Apollo", "add_action", i, 0, new String[] { str, "", localObject1 });
      if (QLog.isColorLevel()) {
        QLog.d("ApolloItemBuilder", 2, " add aciton success id=" + this.jdField_a_of_type_ComTencentMobileqqDataApolloFavActionData.acitonId);
      }
      localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(ChatActivity.class);
      if (localObject3 == null) {
        break;
      }
      localObject1 = new ApolloMainInfo(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.f());
      ((ApolloInfo)localObject1).a = ((ApolloDaoManager)localObject2).a(this.jdField_a_of_type_ComTencentMobileqqDataApolloFavActionData.acitonId);
      ((ApolloInfo)localObject1).b = this.jdField_a_of_type_ComTencentMobileqqDataApolloFavActionData.text;
      ((ApolloInfo)localObject1).d = this.jdField_a_of_type_ComTencentMobileqqDataApolloFavActionData.textType;
      localObject2 = ((MqqHandler)localObject3).obtainMessage(66);
      ((Message)localObject2).obj = localObject1;
      ((Message)localObject2).sendToTarget();
      if (((ApolloInfo)localObject1).a.status != 0) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ApolloItemBuilder", 2, "add action download res " + ((ApolloInfo)localObject1).toString());
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
        break;
      }
      localObject2 = (ApolloManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(152);
      localObject3 = new ArrayList();
      ((List)localObject3).add(((ApolloInfo)localObject1).a);
      ((ApolloManager)localObject2).a((List)localObject3);
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nhn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
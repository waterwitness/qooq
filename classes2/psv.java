import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.utils.ApolloDaoManager;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.apollo.view.ApolloInfo;
import com.tencent.mobileqq.apollo.view.ApolloLinearLayout;
import com.tencent.mobileqq.apollo.view.ApolloLinearLayout.ViewHolder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.VasExtensionObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.os.MqqHandler;

public class psv
  extends VasExtensionObserver
{
  public psv(ApolloLinearLayout paramApolloLinearLayout)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a == null) || (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null)) {}
    label604:
    for (;;)
    {
      return;
      Object localObject1 = new ApolloActionData();
      paramObject = (HashMap)paramObject;
      Object localObject2 = (String)((Map)paramObject).get("optFrom");
      if ((!TextUtils.isEmpty((CharSequence)localObject2)) && ("actionPanel".equals(localObject2)))
      {
        int i = Integer.parseInt((String)((Map)paramObject).get("id"));
        ((ApolloActionData)localObject1).actionId = i;
        localObject1 = this.a.a((ApolloActionData)localObject1);
        if (localObject1 != null)
        {
          ((ImageView)((View)localObject1).findViewById(2131297058)).setVisibility(8);
          ((View)localObject1).setClickable(true);
          if (this.a.b.incrementAndGet() == this.a.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get())
          {
            this.a.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
            this.a.b.set(0);
            this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.b(this.a.jdField_a_of_type_ComTencentMobileqqVasVasExtensionObserver);
          }
          if (paramBoolean)
          {
            if (QLog.isColorLevel()) {
              QLog.d("ApolloLinearLayout", 2, "action auth success actionid=" + i);
            }
            ((Map)paramObject).put("isSuccess", "success");
            localObject1 = (ApolloLinearLayout.ViewHolder)((View)localObject1).getTag();
            if ((localObject1 == null) || (((ApolloLinearLayout.ViewHolder)localObject1).a == null) || (((ApolloLinearLayout.ViewHolder)localObject1).a.a == null)) {
              continue;
            }
            ((ApolloLinearLayout.ViewHolder)localObject1).a.a.limitFree = 1;
            if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a != null))
            {
              localObject2 = (ApolloDaoManager)this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.getManager(154);
              if (localObject2 != null) {
                ((ApolloDaoManager)localObject2).b(((ApolloLinearLayout.ViewHolder)localObject1).a.a);
              }
            }
          }
          for (;;)
          {
            if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a == null)) {
              break label604;
            }
            localObject1 = this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.a(ChatActivity.class);
            if (localObject1 == null) {
              break;
            }
            VipUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a, "cmshow", "Apollo", "activity_alert_show", ApolloUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a), 0, new String[] { "" + i, "0" });
            localObject1 = ((MqqHandler)localObject1).obtainMessage(45);
            ((Message)localObject1).obj = paramObject;
            ((Message)localObject1).sendToTarget();
            return;
            if (QLog.isColorLevel()) {
              QLog.d("ApolloLinearLayout", 2, "action auth fail actionid=" + i);
            }
            ((Map)paramObject).put("isSuccess", "fail");
            ((Map)paramObject).put("title", "参加活动");
            if (TextUtils.isEmpty((String)((Map)paramObject).get("content"))) {
              ((Map)paramObject).put("content", "赶快去参加活动");
            }
            ((Map)paramObject).put("rightString", "参加活动");
            ((Map)paramObject).put("isActionBack", "true");
            ((Map)paramObject).put("actionId", "" + i);
          }
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\psv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
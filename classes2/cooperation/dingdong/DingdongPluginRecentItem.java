package cooperation.dingdong;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.activity.recent.data.RecentUserBaseData;
import com.tencent.mobileqq.activity.recent.msg.DingdongPluginRecentUserMsg;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class DingdongPluginRecentItem
  extends RecentUserBaseData
{
  public DingdongPluginRecentItem(RecentUser paramRecentUser)
  {
    super(paramRecentUser);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((paramQQAppInterface == null) || (paramContext == null)) {}
    Object localObject3;
    Object localObject1;
    do
    {
      return;
      super.a(paramQQAppInterface, paramContext);
      this.jdField_b_of_type_Long = this.a.lastmsgtime;
      this.jdField_b_of_type_JavaLangString = paramContext.getString(2131362474);
      this.H = paramQQAppInterface.a().a(AppConstants.aT, 9999);
      localObject3 = "";
      String str = "";
      if ((this.a.msg == null) && (this.a.msgData != null) && (this.a.msgData.length > 0))
      {
        localObject1 = new DingdongPluginRecentUserMsg();
        ((DingdongPluginRecentUserMsg)localObject1).a(this.a.msgData);
        this.a.msg = localObject1;
      }
      localObject1 = str;
      Object localObject2 = localObject3;
      if (this.a.msg != null)
      {
        localObject1 = str;
        localObject2 = localObject3;
        if ((this.a.msg instanceof DingdongPluginRecentUserMsg))
        {
          localObject2 = (DingdongPluginRecentUserMsg)this.a.msg;
          localObject1 = localObject3;
          if (!paramQQAppInterface.a().equals(((DingdongPluginRecentUserMsg)localObject2).jdField_c_of_type_JavaLangString)) {
            localObject1 = DingdongPluginHelper.a(((DingdongPluginRecentUserMsg)localObject2).a, ((DingdongPluginRecentUserMsg)localObject2).jdField_b_of_type_JavaLangString, ((DingdongPluginRecentUserMsg)localObject2).jdField_c_of_type_JavaLangString);
          }
          localObject3 = ((DingdongPluginRecentUserMsg)localObject2).d;
          localObject2 = localObject1;
          localObject1 = localObject3;
        }
      }
      localObject3 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject3 = paramContext.getString(2131362476);
      }
      localObject1 = super.a();
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        break;
      }
      ((MsgSummary)localObject1).jdField_b_of_type_JavaLangCharSequence = ((String)localObject2 + ":" + (String)localObject3);
      super.a(paramQQAppInterface);
      super.a(paramQQAppInterface, paramContext, (MsgSummary)localObject1);
    } while (!AppSetting.j);
    paramQQAppInterface = new StringBuilder();
    paramQQAppInterface.append(this.jdField_b_of_type_JavaLangString).append(",");
    if (this.H == 0) {}
    for (;;)
    {
      if (this.jdField_c_of_type_JavaLangCharSequence != null) {
        paramQQAppInterface.append(this.jdField_c_of_type_JavaLangCharSequence + ",");
      }
      paramQQAppInterface.append(this.jdField_b_of_type_JavaLangCharSequence).append(",").append(this.jdField_c_of_type_JavaLangString);
      this.d = paramQQAppInterface.toString();
      return;
      ((MsgSummary)localObject1).jdField_b_of_type_JavaLangCharSequence = ((CharSequence)localObject3);
      break;
      if (this.H == 1) {
        paramQQAppInterface.append("有一条未读");
      } else if (this.H == 2) {
        paramQQAppInterface.append("有两条未读");
      } else if (this.H > 0) {
        paramQQAppInterface.append("有").append(this.H).append("条未读,");
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\dingdong\DingdongPluginRecentItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
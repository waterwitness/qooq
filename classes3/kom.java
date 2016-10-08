import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.ApolloItemBuilder;
import com.tencent.mobileqq.apollo.ApolloManager;
import com.tencent.mobileqq.apollo.utils.ApolloDaoManager;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.data.ApolloFavActionData;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.VasExtensionObserver;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

public class kom
  extends VasExtensionObserver
{
  public kom(BaseChatPie paramBaseChatPie)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    if ((this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.a.jdField_a_of_type_AndroidContentContext == null) || (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null)) {}
    Object localObject4;
    Object localObject1;
    do
    {
      return;
      if ((this.a.b != null) && (this.a.b.isShowing())) {
        this.a.b.dismiss();
      }
      localObject4 = new ApolloFavActionData();
      localObject1 = (HashMap)paramObject;
      paramObject = (String)((Map)localObject1).get("optFrom");
    } while ((TextUtils.isEmpty((CharSequence)paramObject)) || (!"actionAdd".equals(paramObject)));
    int j = Integer.parseInt((String)((Map)localObject1).get("id"));
    String str = (String)((Map)localObject1).get("actionText");
    if (!TextUtils.isEmpty((String)((Map)localObject1).get("textType"))) {}
    for (int i = Integer.parseInt((String)((Map)localObject1).get("textType"));; i = 0)
    {
      paramObject = (ApolloDaoManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(154);
      boolean bool = ((ApolloManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(152)).a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.f());
      ((ApolloFavActionData)localObject4).textType = i;
      ((ApolloFavActionData)localObject4).text = str;
      ((ApolloFavActionData)localObject4).acitonId = j;
      if (paramBoolean)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.aio.BaseChatPie", 2, "action auth success from add fav action=" + ((ApolloFavActionData)localObject4).toString());
        }
        ApolloItemBuilder.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidContentContext, (ApolloFavActionData)localObject4, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
        return;
      }
      i = Integer.parseInt((String)((Map)localObject1).get("ret"));
      Object localObject2 = "";
      Object localObject3 = null;
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.BaseChatPie", 2, "action auth fail from fav add action=" + ((ApolloFavActionData)localObject4).toString() + " errcode = " + i);
      }
      ApolloActionData localApolloActionData = ((ApolloDaoManager)paramObject).a(j);
      switch (i)
      {
      default: 
        paramObject = this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.getResources().getString(2131372339);
        localObject1 = this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.getResources().getString(2131372339);
        if (QLog.isColorLevel()) {
          QLog.d("Q.aio.BaseChatPie", 2, "unknown action auth errcode");
        }
        paramObject = DialogUtil.a(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 0, (String)paramObject, (String)localObject1, this.a.jdField_a_of_type_AndroidContentContext.getResources().getString(2131370884), (String)localObject2, (DialogInterface.OnClickListener)localObject3, new koq(this));
        if (!this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing()) {
          ((QQCustomDialog)paramObject).show();
        }
        localObject1 = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        i = ApolloUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
        localObject2 = "" + j;
        paramObject = str;
        if (TextUtils.isEmpty(str)) {
          paramObject = "0";
        }
        VipUtils.a((AppInterface)localObject1, "cmshow", "Apollo", "add_action", i, 0, new String[] { localObject2, "", paramObject });
        return;
      case 31004: 
        label470:
        paramObject = this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.getResources().getString(2131372325);
        localObject4 = this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.getResources().getString(2131372326);
        if (localApolloActionData != null) {
          paramObject = String.format((String)paramObject, new Object[] { localApolloActionData.actionName });
        }
        break;
      }
      for (;;)
      {
        localObject2 = this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.getResources().getString(2131372328);
        localObject3 = new kon(this, j);
        VipUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "vip_alert_show", ApolloUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a), 0, new String[] { "" + j, "1" });
        localObject1 = paramObject;
        paramObject = localObject4;
        break label470;
        localObject2 = this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.getResources().getString(2131372331);
        paramObject = this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.getResources().getString(2131372326);
        localObject1 = this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.getResources().getString(2131372328);
        if (bool)
        {
          localObject2 = this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.getResources().getString(2131372332);
          paramObject = this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.getResources().getString(2131372327);
          localObject1 = this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.getResources().getString(2131372329);
        }
        if (localApolloActionData != null) {
          localObject2 = String.format((String)localObject2, new Object[] { Integer.valueOf(localApolloActionData.vipLevel), localApolloActionData.actionName });
        }
        for (;;)
        {
          localObject3 = new koo(this, j, bool);
          localObject4 = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          int k = ApolloUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
          if (bool) {}
          for (i = 0;; i = 1)
          {
            VipUtils.a((AppInterface)localObject4, "cmshow", "Apollo", "level_alert_show", k, i, new String[] { "" + j, "1" });
            localObject4 = localObject1;
            localObject1 = localObject2;
            localObject2 = localObject4;
            break;
          }
          paramObject = (String)((Map)localObject1).get("content");
          if (TextUtils.isEmpty((CharSequence)paramObject)) {
            paramObject = this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.getResources().getString(2131372335);
          }
          for (;;)
          {
            localObject1 = (String)((Map)localObject1).get("url");
            localObject1 = (String)localObject1 + "&actionid=" + j;
            localObject4 = this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.getResources().getString(2131372336);
            localObject2 = this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.getResources().getString(2131372336);
            localObject3 = new kop(this, (String)localObject1, j);
            VipUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "activity_alert_show", ApolloUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a), 0, new String[] { "" + j, "1" });
            localObject1 = paramObject;
            paramObject = localObject4;
            break label470;
            QQToast.a(this.a.jdField_a_of_type_AndroidContentContext.getApplicationContext(), 1, this.a.jdField_a_of_type_AndroidContentContext.getResources().getString(2131372324), 0).b(this.a.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131492908));
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("Q.aio.BaseChatPie", 2, "fav action network error");
            return;
          }
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kom.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
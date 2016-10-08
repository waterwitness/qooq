import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForQQWalletTips;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.ContactUtils;
import org.json.JSONObject;

public class rbx
  extends ClickableSpan
{
  public rbx(MessageForQQWalletTips paramMessageForQQWalletTips, QQAppInterface paramQQAppInterface, String paramString, Context paramContext, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    int j = 0;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletTips.frienduin;
    int i;
    switch (this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletTips.istroop)
    {
    default: 
      paramView = "";
      i = 0;
      j = -1;
    }
    for (;;)
    {
      if ((i != 0) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().equals(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletTips.reciverUin))) {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      }
      for (;;)
      {
        JSONObject localJSONObject2 = new JSONObject();
        JSONObject localJSONObject1 = new JSONObject();
        try
        {
          localJSONObject2.put("listid", this.jdField_a_of_type_JavaLangString);
          localJSONObject2.put("name", paramView);
          localJSONObject2.put("grouptype", j + "");
          localJSONObject2.put("groupid", localObject);
          if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletTips.authKey != null) {
            localJSONObject2.put("authkey", this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletTips.authKey);
          }
          localJSONObject1.put("userId", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
          localJSONObject1.put("viewTag", "redgiftDetail");
          localJSONObject1.put("app_info", "appid#1344242394|bargainor_id#1000030201|channel#graytips");
          localJSONObject1.put("come_from", 2);
          localJSONObject1.put("extra_data", localJSONObject2);
        }
        catch (Exception paramView)
        {
          for (;;) {}
        }
        paramView = new Bundle();
        paramView.putString("json", localJSONObject1.toString());
        paramView.putString("callbackSn", "0");
        localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, PayBridgeActivity.class);
        ((Intent)localObject).putExtras(paramView);
        ((Intent)localObject).putExtra("pay_requestcode", 5);
        this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
        return;
        paramView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b();
        i = 1;
        break;
        paramView = (HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(59);
        if ((paramView != null) && (paramView.b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletTips.frienduin)))
        {
          paramView = ContactUtils.o(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b());
          if (!TextUtils.isEmpty(paramView)) {
            break label549;
          }
          paramView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b();
          i = 0;
          j = 5;
          break;
        }
        paramView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b();
        j = 1;
        i = 0;
        break;
        paramView = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletTips.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletTips.memberUin);
        i = 0;
        j = 2;
        break;
        j = 3;
        paramView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b();
        i = 1;
        break;
        j = 4;
        paramView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b();
        i = 1;
        break;
        j = 6;
        paramView = ContactUtils.o(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b());
        if (!TextUtils.isEmpty(paramView)) {
          break label543;
        }
        paramView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b();
        i = 1;
        break;
      }
      label543:
      i = 1;
      continue;
      label549:
      i = 0;
      j = 5;
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setColor(this.jdField_a_of_type_Int);
    paramTextPaint.setUnderlineText(false);
    paramTextPaint.clearShadowLayer();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\rbx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
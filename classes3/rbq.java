import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.activity.qwallet.PasswdRedBagManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForFoldMsgGrayTips;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.HashMap;
import org.json.JSONObject;

public class rbq
  extends ClickableSpan
{
  public rbq(MessageForFoldMsgGrayTips paramMessageForFoldMsgGrayTips, QQAppInterface paramQQAppInterface, Context paramContext, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b();
    String str = this.jdField_a_of_type_ComTencentMobileqqDataMessageForFoldMsgGrayTips.frienduin;
    Object localObject1 = new JSONObject();
    paramView = new JSONObject();
    try
    {
      ((JSONObject)localObject1).put("listid", this.jdField_a_of_type_ComTencentMobileqqDataMessageForFoldMsgGrayTips.redBagId);
      ((JSONObject)localObject1).put("name", localObject2);
      ((JSONObject)localObject1).put("grouptype", 1 + "");
      ((JSONObject)localObject1).put("groupid", str);
      localObject2 = (PasswdRedBagManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(124);
      localObject2 = (String)((PasswdRedBagManager)localObject2).c.get(((PasswdRedBagManager)localObject2).a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForFoldMsgGrayTips.istroop) + "_" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForFoldMsgGrayTips.frienduin + "_" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForFoldMsgGrayTips.redBagId);
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        return;
      }
      ((JSONObject)localObject1).put("authkey", localObject2);
      paramView.put("userId", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
      paramView.put("viewTag", "redgiftDetail");
      paramView.put("app_info", "appid#1344242394|bargainor_id#1000030201|channel#graytips");
      paramView.put("come_from", 2);
      paramView.put("extra_data", localObject1);
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    localObject1 = new Bundle();
    ((Bundle)localObject1).putString("json", paramView.toString());
    ((Bundle)localObject1).putString("callbackSn", "0");
    paramView = new Intent(this.jdField_a_of_type_AndroidContentContext, PayBridgeActivity.class);
    paramView.putExtras((Bundle)localObject1);
    paramView.putExtra("pay_requestcode", 5);
    this.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setColor(this.jdField_a_of_type_Int);
    paramTextPaint.setUnderlineText(false);
    paramTextPaint.clearShadowLayer();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\rbq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
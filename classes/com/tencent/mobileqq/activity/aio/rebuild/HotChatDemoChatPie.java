package com.tencent.mobileqq.activity.aio.rebuild;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.SimpleTextView;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import mqq.os.MqqHandler;
import nyf;

public class HotChatDemoChatPie
  extends HotChatPie
{
  protected static final String am = "http://play.mobile.qq.com/play/mqqplay/hotchat/jump.html?_bid=2152&hotnamecode=%s";
  protected String an;
  protected LinearLayout c;
  protected int dV;
  protected int dW;
  protected int dX;
  protected ImageView j;
  
  public HotChatDemoChatPie(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramFragmentActivity, paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.dW = ((int)(15.0F * DeviceInfoUtil.a()));
    this.dV = ((int)(165.0F * DeviceInfoUtil.a()));
    this.dX = ((int)(35.0F * DeviceInfoUtil.a()));
  }
  
  private String a(String paramString1, String paramString2)
  {
    String str = paramString1;
    if (TextUtils.isEmpty(paramString1))
    {
      paramString2 = ((HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(59)).a(paramString2);
      str = paramString1;
      if (paramString2 != null) {
        str = paramString2.name;
      }
    }
    if (!TextUtils.isEmpty(str)) {}
    for (;;)
    {
      try
      {
        paramString1 = URLEncoder.encode(str, "UTF-8");
        paramString1 = String.format("http://play.mobile.qq.com/play/mqqplay/hotchat/jump.html?_bid=2152&hotnamecode=%s", new Object[] { paramString1 });
        if (QLog.isDevelopLevel()) {
          QLog.i("HotChatDemoChatPie", 4, "makeUrl: " + paramString1);
        }
        return paramString1;
      }
      catch (UnsupportedEncodingException paramString1)
      {
        paramString1.printStackTrace();
        paramString1 = str;
        continue;
      }
      paramString1 = null;
    }
  }
  
  private void a(Drawable paramDrawable)
  {
    if (paramDrawable == null) {}
    do
    {
      do
      {
        return;
        if (this.c != null) {
          break;
        }
        this.j = new ImageView(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
        this.j.setScaleType(ImageView.ScaleType.CENTER_CROP);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(this.dV, this.dV);
        int i = this.dW;
        localLayoutParams.rightMargin = i;
        localLayoutParams.leftMargin = i;
        localLayoutParams.bottomMargin = i;
        localLayoutParams.topMargin = i;
        this.j.setLayoutParams(localLayoutParams);
        this.j.setImageDrawable(paramDrawable);
        paramDrawable = new SimpleTextView(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
        paramDrawable.setText(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getText(2131372213));
        localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
        localLayoutParams.bottomMargin = this.dW;
        localLayoutParams.gravity = 1;
        paramDrawable.setLayoutParams(localLayoutParams);
        paramDrawable.setTextColor(Color.rgb(119, 119, 119));
        paramDrawable.setTextSize(1, 14.0F);
        paramDrawable.setGravity(1);
        this.c = new LinearLayout(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
        this.c.setOrientation(1);
        this.c.addView(this.j);
        this.c.addView(paramDrawable);
        paramDrawable = new RelativeLayout.LayoutParams(-2, -2);
        paramDrawable.addRule(11);
        paramDrawable.addRule(15);
        paramDrawable.rightMargin = this.dX;
        this.c.setLayoutParams(paramDrawable);
        this.c.setBackgroundResource(2130840919);
      } while (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.c);
      return;
    } while (this.j == null);
    this.j.setImageDrawable(paramDrawable);
  }
  
  protected void N()
  {
    super.N();
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.finish();
  }
  
  protected void W()
  {
    super.W();
    if (this.c == null)
    {
      if (TextUtils.isEmpty(this.an)) {
        this.an = a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b);
      }
      ThreadManager.a().post(new nyf(this.an, this.jdField_a_of_type_MqqOsMqqHandler, this.dV));
    }
  }
  
  protected void d(Intent paramIntent)
  {
    this.r = true;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b.length() == 0))
    {
      paramIntent = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
      if (paramIntent != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b = paramIntent.troopcode;
      }
    }
    this.an = a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b);
  }
  
  protected void e()
  {
    super.e();
    if (this.b != null) {
      this.b.setVisibility(8);
    }
  }
  
  protected void e(Intent paramIntent)
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131372211);
      this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131372211));
      this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(null);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 34)
    {
      Drawable localDrawable = null;
      if ((paramMessage.obj instanceof Drawable)) {
        localDrawable = (Drawable)paramMessage.obj;
      }
      if (paramMessage.arg1 == 2) {
        a(localDrawable);
      }
      return true;
    }
    return super.handleMessage(paramMessage);
  }
  
  public int i()
  {
    return this.dV + this.dW * 2 + this.dX;
  }
  
  protected void r()
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\aio\rebuild\HotChatDemoChatPie.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
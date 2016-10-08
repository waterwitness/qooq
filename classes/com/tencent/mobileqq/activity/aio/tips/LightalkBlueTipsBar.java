package com.tencent.mobileqq.activity.aio.tips;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.os.MqqHandler;
import oer;
import oes;
import oet;

public class LightalkBlueTipsBar
  implements View.OnClickListener, TipsBarTask
{
  public static final String a = "LightalkBlueTipsBar";
  private long jdField_a_of_type_Long;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private BitmapDrawable jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable;
  private View jdField_a_of_type_AndroidViewView;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private TipsManager jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private boolean jdField_a_of_type_Boolean;
  public String b;
  public String c;
  
  public LightalkBlueTipsBar(QQAppInterface paramQQAppInterface, TipsManager paramTipsManager, SessionInfo paramSessionInfo, Activity paramActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager = paramTipsManager;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    ThreadManager.a(new oer(this), 5, null, true);
  }
  
  public static boolean a()
  {
    boolean bool = false;
    if (LightalkBlueTipsBarData.a() != null) {
      bool = true;
    }
    return bool;
  }
  
  public int a()
  {
    return 45;
  }
  
  public View a(Object... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LightalkBlueTipsBar", 2, "getBarView()");
    }
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2130903079, null);
      paramVarArgs = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131296976);
      if (this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable != null)
      {
        paramVarArgs.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable);
        paramVarArgs = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131296977);
        if (this.b == null) {
          break label316;
        }
        if (QLog.isColorLevel()) {
          QLog.d("LightalkBlueTipsBar", 2, "getBarView() mTextWording =" + this.b);
        }
        paramVarArgs.setText(this.b);
        paramVarArgs.setContentDescription(this.b + "点击进入");
        paramVarArgs.setOnClickListener(this);
        paramVarArgs = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131296978);
        if (AppSetting.j) {
          paramVarArgs.setContentDescription("关闭");
        }
        paramVarArgs.setOnClickListener(this);
      }
    }
    for (;;)
    {
      return this.jdField_a_of_type_AndroidViewView;
      File localFile = new File(LightalkBlueTipsBarData.d);
      if ((localFile != null) && (localFile.exists())) {}
      try
      {
        this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable = new BitmapDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources(), BitmapManager.a(LightalkBlueTipsBarData.d));
        if (QLog.isDevelopLevel()) {
          QLog.i("LightalkBlueTipsBar", 4, "load icon to bitmap ");
        }
        if (this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable != null) {
          paramVarArgs.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable);
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("LightalkBlueTipsBar", 2, "decodeFile Failed!", localThrowable);
          }
          this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable = ((BitmapDrawable)this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130840542));
          localThrowable.printStackTrace();
        }
      }
      return null;
      label316:
      return null;
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt != 1000) {}
    label7:
    do
    {
      do
      {
        do
        {
          String str;
          do
          {
            do
            {
              break label7;
              break label7;
              break label7;
              do
              {
                return;
              } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 0);
              if (QLog.isColorLevel()) {
                QLog.d("LightalkBlueTipsBar", 2, "onAIOEvent() : TYPE_ON_SHOW");
              }
              paramVarArgs = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
            } while (!paramVarArgs.getBoolean("lightalk_tip_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), false));
            str = paramVarArgs.getString("Lightalk_tips_frdUin", null);
          } while ((str == null) || (!str.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)));
          paramInt = paramVarArgs.getInt("LT_tip_show_times" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0);
          if (QLog.isColorLevel()) {
            QLog.d("LightalkBlueTipsBar", 2, "onAIOEvent() : TYPE_ON_SHOW =====> tipsum = " + paramInt);
          }
          if (paramInt < 3) {
            break;
          }
        } while (!(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a() instanceof LightalkBlueTipsBar));
        this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a();
        return;
      } while (!this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(this, new Object[0]));
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800510F", "0X800510F", 0, 0, "" + (paramInt + 1), "", "", "");
    } while (!this.jdField_a_of_type_Boolean);
    ThreadManager.b().post(new oes(this));
  }
  
  public int[] a()
  {
    return null;
  }
  
  public int b()
  {
    return 12;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a();
      ThreadManager.b().post(new oet(this));
      long l;
      do
      {
        return;
        l = System.currentTimeMillis();
      } while (l - this.jdField_a_of_type_Long < 200L);
      this.jdField_a_of_type_Long = l;
      paramView = new Intent(this.jdField_a_of_type_AndroidAppActivity, QQBrowserActivity.class);
      paramView.putExtra("hide_more_button", true);
      paramView.putExtra("url", this.c);
      this.jdField_a_of_type_AndroidAppActivity.startActivity(paramView);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005111", "0X8005111", 0, 0, "", "", "", "");
      continue;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005110", "0X8005110", 0, 0, "", "", "", "");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\aio\tips\LightalkBlueTipsBar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
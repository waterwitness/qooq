package com.tencent.mobileqq.search.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import ukk;

public class ContactSearchComponentActivity
  extends ContactSearchActivity
{
  private static long jdField_a_of_type_Long = 0L;
  private static final String jdField_a_of_type_JavaLangString = "ContactSearchComponentActivity";
  
  public ContactSearchComponentActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static void a(Activity paramActivity, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    long l = System.currentTimeMillis();
    if (l - jdField_a_of_type_Long < 1500L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ContactSearchComponentActivity", 2, "ContactSearchComponentActivity launch failed! Too frequently.");
      }
      return;
    }
    jdField_a_of_type_Long = l;
    Intent localIntent = new Intent(paramActivity, ContactSearchComponentActivity.class);
    localIntent.putExtra("keyword", paramString);
    localIntent.putExtra("fromType", paramInt1);
    localIntent.putExtra("contactSearchSource", paramInt2);
    paramActivity.startActivityForResult(localIntent, paramInt3);
    paramActivity.overridePendingTransition(0, 0);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    findViewById(2131298333).setOnTouchListener(new ukk(this));
    return true;
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(0, 0);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\search\activity\ContactSearchComponentActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
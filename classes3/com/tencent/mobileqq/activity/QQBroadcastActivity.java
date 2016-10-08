package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.widget.CursorAdapter;
import android.widget.TextView;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.MsgProxy;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.Observer;
import mbx;
import mby;

public class QQBroadcastActivity
  extends BaseSystemActivity
  implements Observer
{
  static final int jdField_a_of_type_Int = 1010;
  static final long jdField_a_of_type_Long = 1000L;
  public Handler a;
  public mby a;
  
  public QQBroadcastActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidOsHandler = new mbx(this);
  }
  
  private void c()
  {
    int i = 999;
    QQMessageFacade localQQMessageFacade = this.app.a();
    int j;
    if (localQQMessageFacade != null)
    {
      j = localQQMessageFacade.e();
      if (j <= 0) {
        break label79;
      }
      if (j <= 999) {
        break label99;
      }
    }
    for (;;)
    {
      setLeftViewName(getIntent().putExtra("leftViewText", getString(2131367566) + "(" + i + ")"));
      return;
      label79:
      setLeftViewName(getIntent().putExtra("leftViewText", getString(2131367566)));
      return;
      label99:
      i = j;
    }
  }
  
  public Cursor a()
  {
    return this.app.a(0).a(a(), 0);
  }
  
  protected CursorAdapter a()
  {
    if (this.jdField_a_of_type_Mby == null) {
      this.jdField_a_of_type_Mby = new mby(this, this, this.app.a(0).a(a(), 0));
    }
    return this.jdField_a_of_type_Mby;
  }
  
  protected CharSequence a()
  {
    return getString(2131369138);
  }
  
  public String a()
  {
    return String.valueOf(AppConstants.as);
  }
  
  protected void a()
  {
    c();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.app.a().c(a(), 0);
    c();
    this.rightViewText.setVisibility(8);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_Mby != null) {
      this.jdField_a_of_type_Mby.changeCursor(null);
    }
  }
  
  protected void onResume()
  {
    super.onResume();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\QQBroadcastActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
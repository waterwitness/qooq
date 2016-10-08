package com.tencent.mobileqq.troop.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.data.TroopCreateLogic;
import com.tencent.qphone.base.util.QLog;

public class TroopCreateEnterActivity
  extends BaseActivity
{
  protected static final String a = "TroopCreateEnterActivity";
  TroopCreateLogic a;
  
  public TroopCreateEnterActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = null;
  }
  
  public static void a(Activity paramActivity, int paramInt1, int paramInt2)
  {
    Intent localIntent = new Intent(paramActivity, TroopCreateEnterActivity.class);
    localIntent.putExtra("from", paramInt1);
    paramActivity.startActivityForResult(localIntent, paramInt2);
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopCreateEnterActivity", 2, "doOnActivityResult: " + paramInt1 + " " + paramInt2);
    }
    setResult(paramInt2, paramIntent);
    finish();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    paramBundle = "DEFAULT";
    Object localObject = getIntent();
    int j;
    if (localObject != null)
    {
      j = ((Intent)localObject).getIntExtra("from", 0);
      localObject = ((Intent)localObject).getStringExtra("troopType");
      i = j;
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        paramBundle = (Bundle)localObject;
      }
    }
    for (int i = j;; i = 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopCreateEnterActivity", 2, "doOnCreate, from:" + i + ", type:" + paramBundle);
      }
      this.a = ((TroopCreateLogic)this.app.getManager(31));
      if (this.a != null) {
        this.a.a(this, i, paramBundle);
      }
      for (;;)
      {
        return true;
        finish();
      }
    }
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (QLog.isColorLevel()) {
      QLog.d("TroopCreateEnterActivity", 2, "doOnDestroy");
    }
    this.a = null;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = false;
    if (this.a != null) {
      bool = this.a.a();
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopCreateEnterActivity", 2, "onTouchEvent, isDialogShowing:" + bool);
    }
    if (!bool) {
      finish();
    }
    return super.onTouchEvent(paramMotionEvent);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\activity\TroopCreateEnterActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
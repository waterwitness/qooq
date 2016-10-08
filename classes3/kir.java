import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.mobileqq.activity.AddFriendVerifyActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;

public class kir
  extends TroopObserver
{
  public kir(AddFriendVerifyActivity paramAddFriendVerifyActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(int paramInt, byte paramByte)
  {
    if (paramInt == 1)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      QQToast.a(this.a, 1, 2131368654, 1).b(this.a.getTitleBarHeight());
    }
  }
  
  protected void a(int paramInt, byte paramByte, String paramString)
  {
    if (1 == paramInt) {}
    switch (paramByte)
    {
    default: 
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      QQToast.a(this.a, 1, 2131368654, 1).b(this.a.getTitleBarHeight());
      return;
    case 0: 
    case 1: 
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      Object localObject = this.a.getIntent().getStringExtra("param_return_addr");
      if (localObject != null)
      {
        QQToast.a(this.a, 2, 2131368653, 1).b(this.a.getTitleBarHeight());
        try
        {
          paramString = Class.forName((String)localObject);
          localObject = new Intent();
          ((Intent)localObject).setComponent(new ComponentName("com.tencent.mobileqq", paramString.getName()));
          ((Intent)localObject).setFlags(67108864);
          this.a.startActivity((Intent)localObject);
          return;
        }
        catch (ClassNotFoundException paramString)
        {
          paramString.printStackTrace();
          this.a.setResult(-1);
          this.a.finish();
          return;
        }
      }
      if (this.a.getIntent().getBooleanExtra("from_newer_guide", false))
      {
        localObject = new Intent();
        ((Intent)localObject).putExtra("has_operation", true);
        ((Intent)localObject).putExtra("uin", paramString);
        this.a.setResult(-1, (Intent)localObject);
        this.a.finish();
        return;
      }
      paramInt = this.a.getIntent().getExtras().getShort("group_option", (short)2);
      paramString = (TroopHandler)this.a.app.a(20);
      if ((paramInt == 1) || (paramInt == 4))
      {
        paramString.b(this.a.c, false);
        return;
      }
      paramString.b(Long.parseLong(this.a.c), Long.parseLong(this.a.app.getAccount()));
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    QQToast.a(this.a, 1, 2131368626, 1).b(this.a.getTitleBarHeight());
  }
  
  protected void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QQToast.a(this.a, 2, 2131368653, 1).b(this.a.getTitleBarHeight());
      this.a.setResult(-1);
      if (this.a.jdField_a_of_type_AndroidViewInputmethodInputMethodManager != null)
      {
        this.a.getWindow().setSoftInputMode(2);
        this.a.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(AddFriendVerifyActivity.a(this.a).getWindowToken(), 0);
        AddFriendVerifyActivity.a(this.a).clearFocus();
      }
      this.a.finish();
      return;
    }
    paramString = new kji(this.a, paramString);
    this.a.jdField_a_of_type_AndroidOsHandler.post(paramString);
  }
  
  protected void a(boolean paramBoolean, TroopInfo paramTroopInfo)
  {
    if (paramBoolean)
    {
      int i = this.a.getIntent().getExtras().getShort("group_option", (short)2);
      if (i == 4)
      {
        localObject = AIOUtils.a(new Intent(this.a, SplashActivity.class), null);
        ((Intent)localObject).putExtra("uin", paramTroopInfo.troopuin);
        ((Intent)localObject).putExtra("uintype", 1);
        ((Intent)localObject).putExtra("uinname", paramTroopInfo.troopname);
        this.a.startActivity((Intent)localObject);
      }
      while ((TextUtils.isEmpty(this.a.c)) || (TextUtils.isEmpty(this.a.app.getAccount())) || (i != 1)) {
        return;
      }
      Object localObject = this.a.app.a();
      RecentUser localRecentUser = ((ProxyManager)localObject).a().a(paramTroopInfo.troopuin, 1);
      localRecentUser.displayName = paramTroopInfo.troopname;
      localRecentUser.msgData = null;
      localRecentUser.msg = null;
      localRecentUser.msgType = 0;
      long l = NetConnInfoCenter.getServerTime();
      if (localRecentUser.lastmsgtime < l) {
        localRecentUser.lastmsgtime = l;
      }
      ((ProxyManager)localObject).a().a(localRecentUser);
      this.a.setResult(-1);
      this.a.finish();
      return;
    }
    this.a.setResult(-1);
    if (this.a.jdField_a_of_type_AndroidViewInputmethodInputMethodManager != null)
    {
      this.a.getWindow().setSoftInputMode(2);
      this.a.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(AddFriendVerifyActivity.a(this.a).getWindowToken(), 0);
      AddFriendVerifyActivity.a(this.a).clearFocus();
    }
    this.a.finish();
  }
  
  protected void a(boolean paramBoolean, String paramString, int paramInt1, int paramInt2) {}
  
  protected void a(boolean paramBoolean, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool = true;
    if ((this.a.c == null) || (!this.a.c.equals(paramString))) {
      return;
    }
    if (!paramBoolean)
    {
      QQToast.a(this.a, this.a.getString(2131364854), 0).b(this.a.getTitleBarHeight());
      AddFriendVerifyActivity.b(this.a);
    }
    paramString = this.a;
    if (paramInt3 == 1) {}
    for (paramBoolean = bool;; paramBoolean = false)
    {
      paramString.d = paramBoolean;
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kir.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
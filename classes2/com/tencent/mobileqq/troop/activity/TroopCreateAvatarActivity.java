package com.tencent.mobileqq.troop.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.data.TroopCreateAdvanceData;
import com.tencent.mobileqq.troop.data.TroopCreateLogic;
import com.tencent.mobileqq.troop.data.TroopCreateLogic.TroopCreateInfo;
import com.tencent.mobileqq.troop.utils.AvatarTroopUtil;
import com.tencent.mobileqq.troop.utils.TroopAvatarManger;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troop.widget.AvatarWallAdapter;
import com.tencent.mobileqq.troop.widget.AvatarWallAdapter.AddButtonStatusListener;
import com.tencent.mobileqq.troop.widget.AvatarWallAdapter.AvatarInfo;
import com.tencent.mobileqq.troop.widget.AvatarWallView;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.manager.AccountManager;
import mqq.observer.AccountObserver;
import mqq.util.WeakReference;
import viw;
import vix;
import viy;
import viz;
import vja;

public class TroopCreateAvatarActivity
  extends IphoneTitleBarActivity
  implements AvatarWallAdapter.AddButtonStatusListener
{
  public static final int a = 10;
  public static final String a = "TroopCreateAvatarActivity";
  public Intent a;
  public Handler a;
  protected TextView a;
  TroopObserver jdField_a_of_type_ComTencentMobileqqAppTroopObserver;
  public AvatarWallAdapter a;
  public AvatarWallView a;
  public ArrayList a;
  AccountObserver jdField_a_of_type_MqqObserverAccountObserver;
  public boolean a;
  public String b;
  public boolean b;
  public String c;
  protected boolean c;
  public String d;
  
  public TroopCreateAvatarActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_AndroidOsHandler = new viw(this);
    this.jdField_a_of_type_MqqObserverAccountObserver = new viz(this);
    this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new vja(this);
  }
  
  public void a()
  {
    Object localObject = getIntent();
    boolean bool = ((Intent)localObject).getBooleanExtra("isShowCommit", false);
    this.jdField_a_of_type_Boolean = ((Intent)localObject).getBooleanExtra("isAstrict", false);
    if (bool == true) {}
    for (int i = 2131364295;; i = 2131364293)
    {
      setContentView(2130903705);
      setTitle(2131364291);
      setRightButton(i, new vix(this));
      localObject = (TroopCreateLogic)this.app.getManager(31);
      if (localObject == null) {
        break label157;
      }
      localObject = ((TroopCreateLogic)localObject).a().a;
      if (localObject != null) {
        break;
      }
      finish();
      return;
    }
    this.d = ("" + ((TroopCreateAdvanceData)localObject).jdField_a_of_type_Long);
    this.jdField_b_of_type_JavaLangString = ("" + ((TroopCreateAdvanceData)localObject).b);
    this.jdField_c_of_type_JavaLangString = ((TroopCreateAdvanceData)localObject).jdField_a_of_type_JavaLangString;
    label157:
    if (this.jdField_a_of_type_Boolean) {
      this.rightViewText.setEnabled(false);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallView = ((AvatarWallView)findViewById(2131296687));
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter = new AvatarWallAdapter(new WeakReference(this), this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallView, this.app, this.jdField_b_of_type_JavaLangString, true, this.jdField_a_of_type_AndroidOsHandler, true, "Grp_Admin_data");
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallView);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.a(this);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.a();
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131299787));
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new viy(this));
      this.leftView.setText(getString(2131367975));
      return;
      this.rightViewText.setEnabled(true);
    }
  }
  
  protected void a(int paramInt, Intent paramIntent)
  {
    if (paramInt == -1)
    {
      ArrayList localArrayList = paramIntent.getStringArrayListExtra("del_list");
      if (localArrayList != null)
      {
        paramIntent = new ArrayList();
        Iterator localIterator = localArrayList.iterator();
        while (localIterator.hasNext())
        {
          Object localObject = (String)localIterator.next();
          if ((localObject != null) && (AvatarTroopUtil.b((String)localObject)))
          {
            paramInt = Integer.parseInt((String)localObject);
            localObject = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.a(paramInt);
            if ((localObject != null) && (((AvatarWallAdapter.AvatarInfo)localObject).jdField_c_of_type_JavaLangString != null) && (AvatarTroopUtil.b(((AvatarWallAdapter.AvatarInfo)localObject).jdField_c_of_type_JavaLangString))) {
              paramIntent.add(Integer.valueOf(Integer.parseInt(((AvatarWallAdapter.AvatarInfo)localObject).jdField_c_of_type_JavaLangString)));
            }
          }
        }
        if (paramIntent.size() > 0) {
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopAvatarManger.a(this.jdField_b_of_type_JavaLangString, 2, paramIntent);
        }
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.a(localArrayList);
      }
    }
    else
    {
      return;
    }
    paramInt = paramIntent.getIntExtra("default_avator_index", -1);
    if ((paramInt > 0) && (paramInt < this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.getCount())) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.c(paramInt);
    }
    QQToast.a(this, getString(2131369191), 1).b(getTitleBarHeight());
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView == null) {
      return;
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
  }
  
  protected void b()
  {
    ArrayList localArrayList = new ArrayList();
    AvatarWallAdapter.AvatarInfo localAvatarInfo = new AvatarWallAdapter.AvatarInfo();
    localAvatarInfo.jdField_c_of_type_JavaLangString = AvatarWallAdapter.AvatarInfo.jdField_a_of_type_JavaLangString;
    localAvatarInfo.d = "SYSTEM_PHOTO";
    localArrayList.add(localAvatarInfo);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.a(localArrayList, false);
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopCreateAvatarActivity", 2, "onActivityResult, requestCode = " + paramInt1 + ", resultCode = " + paramInt2 + ", data = " + paramIntent);
    }
    if (-1 == paramInt2) {
      switch (paramInt1)
      {
      }
    }
    do
    {
      return;
      a(paramInt2, paramIntent);
      return;
    } while (AvatarWallAdapter.jdField_a_of_type_AndroidNetUri == null);
    paramIntent = ImageUtil.c(this, AvatarWallAdapter.jdField_a_of_type_AndroidNetUri);
    paramInt1 = ProfileCardUtil.a(this);
    PhotoUtils.a(new Intent(), this, TroopCreateAvatarActivity.class.getName(), paramInt1, paramInt1, 640, 640, paramIntent, ProfileCardUtil.a());
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    a();
    this.jdField_a_of_type_AndroidContentIntent = new Intent();
    this.jdField_a_of_type_AndroidContentIntent.putExtra("isBack", 0);
    setResult(-1, this.jdField_a_of_type_AndroidContentIntent);
    return true;
  }
  
  protected void doOnDestroy()
  {
    this.jdField_b_of_type_Boolean = true;
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    setResult(-1, this.jdField_a_of_type_AndroidContentIntent);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.d();
    }
    super.doOnDestroy();
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    paramIntent = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
    if (paramIntent == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilArrayList = paramIntent;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter != null)
    {
      localObject1 = paramIntent.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.b((String)localObject2);
        if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
          ReportController.b(this.app, "P_CliOper", "Grp_set", "", "Grp_moredata", "upload_head", 0, 0, this.jdField_b_of_type_JavaLangString, "", "", "");
        }
      }
    }
    this.jdField_c_of_type_Boolean = true;
    Object localObject2 = (AccountManager)getAppRuntime().getManager(0);
    Object localObject1 = TroopUtils.a(this.app);
    if (localObject1 == null)
    {
      ((AccountManager)localObject2).updateSKey(this.jdField_a_of_type_MqqObserverAccountObserver);
      return;
    }
    localObject2 = new HashMap();
    ((HashMap)localObject2).put("groupsig", this.jdField_c_of_type_JavaLangString);
    TroopUtils.a((String)localObject1, this.app.a(), this.d, paramIntent, (HashMap)localObject2, this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter);
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    if (this.jdField_c_of_type_Boolean)
    {
      this.jdField_c_of_type_Boolean = false;
      return;
    }
    TroopAvatarManger.a = 0;
    b();
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopAvatarManger.b(this.jdField_b_of_type_JavaLangString);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\activity\TroopCreateAvatarActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
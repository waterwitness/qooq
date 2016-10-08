package com.tencent.mobileqq.troop.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.troop.data.TroopCreateLogic;
import com.tencent.mobileqq.troop.data.TroopCreateLogic.TroopCreateCallback;
import com.tencent.mobileqq.troop.data.TroopCreateLogic.TroopCreateInfo;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.troopshare.TroopShareUtility;
import com.tencent.mobileqq.utils.ShareMsgHelper;
import com.tencent.mobileqq.widget.QQToast;
import org.json.JSONException;
import org.json.JSONObject;
import vjd;

public class TroopCreateLogicActivity
  extends BaseActivity
  implements TroopCreateLogic.TroopCreateCallback
{
  public static final int a = 1;
  public static final int b = 2;
  public static final String b = "type";
  public static final int c = 3;
  public static final String c = "cfg";
  public static final int d = 4;
  public static final String d = "troop_uin";
  public static final int e = 5;
  public static final String e = "troop_location";
  public static final int f = 6;
  public static final String f = "has_head";
  public static final int g = 7;
  public TroopObserver a;
  TroopCreateLogic jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic;
  TroopInfoData jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData;
  TroopShareUtility jdField_a_of_type_ComTencentMobileqqTroopshareTroopShareUtility;
  String jdField_a_of_type_JavaLangString;
  public boolean a;
  
  public TroopCreateLogicActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic = null;
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData = new TroopInfoData();
    this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new vjd(this);
  }
  
  public void a(int paramInt, String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("retCode", paramInt);
    localIntent.putExtra("troopUin", paramString);
    setResult(-1, localIntent);
    finish();
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      finish();
      return;
    }
    Object localObject = (TroopManager)this.app.getManager(51);
    if (localObject == null)
    {
      finish();
      return;
    }
    TroopInfo localTroopInfo = ((TroopManager)localObject).a(paramString);
    if (localTroopInfo == null)
    {
      finish();
      return;
    }
    localObject = new JSONObject();
    paramString = "";
    try
    {
      if (!TextUtils.isEmpty(localTroopInfo.mRichFingerMemo)) {
        paramString = new QQText(localTroopInfo.mRichFingerMemo, 11).a();
      }
      ((JSONObject)localObject).put("classify", localTroopInfo.dwGroupClassExt);
      ((JSONObject)localObject).put("name", localTroopInfo.troopname);
      ((JSONObject)localObject).put("introduction", paramString);
      ((JSONObject)localObject).put("location", localTroopInfo.strLocation);
      ((JSONObject)localObject).put("percentage", "1.0");
      paramString = new Intent();
      paramString.putExtra("modifiedInfo", ((JSONObject)localObject).toString());
      setResult(-1, paramString);
      finish();
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
      finish();
    }
  }
  
  public void b(String paramString)
  {
    if ((this.app == null) || (this.jdField_a_of_type_ComTencentMobileqqTroopshareTroopShareUtility == null) || (TextUtils.isEmpty(paramString))) {
      finish();
    }
    label75:
    do
    {
      return;
      try
      {
        paramString = new JSONObject(paramString).getString("troopUin");
        try
        {
          if (Long.parseLong(paramString) > 0L) {
            break label75;
          }
          finish();
          return;
        }
        catch (JSONException localJSONException1) {}
      }
      catch (JSONException localJSONException2)
      {
        for (;;)
        {
          TroopManager localTroopManager;
          paramString = "";
        }
      }
      finish();
      localJSONException1.printStackTrace();
      while (TextUtils.isEmpty(paramString))
      {
        finish();
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin = paramString;
      localTroopManager = (TroopManager)this.app.getManager(51);
    } while (localTroopManager == null);
    paramString = localTroopManager.a(paramString);
    if (paramString != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.updateForTroopChatSetting(paramString, getResources(), this.app.a());
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember = true;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopshareTroopShareUtility.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData);
  }
  
  public void c(String paramString)
  {
    j = 0;
    String str4 = "";
    String str2 = "";
    i = j;
    localObject1 = str2;
    localObject2 = str4;
    if (this.app != null)
    {
      i = j;
      localObject1 = str2;
      localObject2 = str4;
      if (!TextUtils.isEmpty(paramString))
      {
        localObject1 = str2;
        localObject2 = str4;
        str3 = str2;
        str1 = str4;
      }
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      localObject1 = str2;
      localObject2 = str4;
      str3 = str2;
      str1 = str4;
      paramString = localJSONObject.getString("troopUin");
      localObject1 = str2;
      localObject2 = paramString;
      str3 = str2;
      str1 = paramString;
      str2 = localJSONObject.getString("groupName");
      localObject1 = str2;
      localObject2 = paramString;
      str3 = str2;
      str1 = paramString;
      long l = Long.parseLong(paramString);
      i = j;
      localObject1 = str2;
      localObject2 = paramString;
      if (l > 0L)
      {
        i = 1;
        localObject2 = paramString;
        localObject1 = str2;
      }
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        i = j;
      }
    }
    catch (NumberFormatException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        i = j;
        localObject1 = str3;
        localObject2 = str1;
      }
    }
    if (i != 0)
    {
      paramString = new TroopInfo();
      paramString.troopuin = ((String)localObject2);
      paramString.troopname = ((String)localObject1);
      paramString.Administrator = this.app.a();
      localObject1 = (TroopManager)this.app.getManager(51);
      if (localObject1 != null) {
        ((TroopManager)localObject1).b(paramString);
      }
    }
    finish();
  }
  
  public void d(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic.a(paramString);
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic.a(this);
    }
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    default: 
      super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    }
    int i;
    Object localObject;
    do
    {
      return;
      if (paramInt2 != -1) {
        break;
      }
      i = getResources().getDimensionPixelSize(2131492908);
      QQToast.a(this, 2, getString(2131364931), 0).b(i);
      localObject = StructMsgFactory.a(paramIntent.getByteArrayExtra("stuctmsg_bytes"));
    } while (localObject == null);
    if ((localObject instanceof StructMsgForImageShare)) {}
    for (;;)
    {
      if (TextUtils.isEmpty(paramIntent.getExtras().getString("share_comment_message"))) {
        localObject = ((AbsStructMsg)localObject).mCommentText;
      }
      this.jdField_a_of_type_Boolean = false;
      finish();
      break;
      String str = paramIntent.getStringExtra("uin");
      i = paramIntent.getIntExtra("uintype", -1);
      ShareMsgHelper.a(this.app, str, i, (AbsStructMsg)localObject, null);
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic = ((TroopCreateLogic)this.app.getManager(31));
    this.jdField_a_of_type_ComTencentMobileqqTroopshareTroopShareUtility = new TroopShareUtility(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData);
    paramBundle = getIntent();
    int i = paramBundle.getIntExtra("type", -1);
    if (i == 1)
    {
      d(paramBundle.getStringExtra("cfg"));
      return true;
    }
    if (i == 2)
    {
      e(paramBundle.getStringExtra("troop_uin"));
      return true;
    }
    if (i == 3)
    {
      b(paramBundle.getStringExtra("cfg"));
      return true;
    }
    if (i == 4)
    {
      a(paramBundle.getStringExtra("troop_uin"));
      return true;
    }
    if (i == 5)
    {
      String str = paramBundle.getStringExtra("troop_location");
      long l = paramBundle.getLongExtra("troop_uin", 0L);
      this.app.a(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
      ((TroopHandler)this.app.a(20)).a(l, TextUtils.isEmpty(str), str);
      return true;
    }
    if (i == 6)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic == null)
      {
        finish();
        return true;
      }
      paramBundle = new Intent();
      paramBundle.putExtra("has_head", this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic.a().jdField_a_of_type_Boolean);
      setResult(-1, paramBundle);
      finish();
      return true;
    }
    if (i == 7)
    {
      c(paramBundle.getStringExtra("cfg"));
      return true;
    }
    finish();
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic = null;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopshareTroopShareUtility != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopshareTroopShareUtility.g();
      this.jdField_a_of_type_ComTencentMobileqqTroopshareTroopShareUtility = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver != null)
    {
      this.app.b(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver = null;
    }
  }
  
  public void e(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic.a();
    }
    if (TextUtils.isEmpty(paramString))
    {
      finish();
      return;
    }
    finish();
  }
  
  public void finish()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    super.finish();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\activity\TroopCreateLogicActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
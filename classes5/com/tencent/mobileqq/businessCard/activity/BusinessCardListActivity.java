package com.tencent.mobileqq.businessCard.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.businessCard.BusinessCardManager;
import com.tencent.mobileqq.businessCard.BusinessCardObserver;
import com.tencent.mobileqq.businessCard.BusinessCardServlet;
import com.tencent.mobileqq.businessCard.data.BusinessCard;
import com.tencent.mobileqq.businessCard.utilities.BusinessCardGroupLogic;
import com.tencent.mobileqq.businessCard.views.BusinessCardChildView;
import com.tencent.mobileqq.businessCard.views.BusinessCardView;
import com.tencent.mobileqq.businessCard.views.BusinessCardView.Callback;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.forward.ForwardOptionBuilder;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.widget.IndexView;
import com.tencent.mobileqq.widget.IndexView.OnIndexChangedListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import qvx;
import qvy;
import qvz;

public class BusinessCardListActivity
  extends BaseActivity
  implements View.OnClickListener, BusinessCardView.Callback, IndexView.OnIndexChangedListener
{
  public static final int a = 1;
  public static final String a = "BusinessCardListActivity";
  public static final int b = 2;
  public static final String b = "Extra_Entrance";
  public static final int c = 3;
  public static final String c = "Extra_Result_Data";
  public static final int d = 0;
  public static final int e = 1;
  private Handler jdField_a_of_type_AndroidOsHandler;
  public BusinessCardManager a;
  BusinessCardObserver jdField_a_of_type_ComTencentMobileqqBusinessCardBusinessCardObserver;
  BusinessCardGroupLogic jdField_a_of_type_ComTencentMobileqqBusinessCardUtilitiesBusinessCardGroupLogic;
  public BusinessCardView a;
  ForwardBaseOption jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption;
  public IndexView a;
  public ArrayList a;
  public HashMap a;
  public int f;
  int g;
  
  public BusinessCardListActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.f = 0;
    this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption = null;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.g = 1;
    this.jdField_a_of_type_AndroidOsHandler = new qvx(this);
    this.jdField_a_of_type_ComTencentMobileqqBusinessCardBusinessCardObserver = new qvz(this);
  }
  
  public String a(long paramLong, Calendar paramCalendar)
  {
    Calendar localCalendar = Calendar.getInstance();
    if (paramLong > 0L) {
      localCalendar.setTimeInMillis(paramLong);
    }
    while (paramCalendar.get(1) - localCalendar.get(1) > 0)
    {
      return localCalendar.get(1) + "年";
      localCalendar.set(1, 2012);
      localCalendar.set(2, 5);
      localCalendar.set(5, 1);
    }
    if (paramCalendar.get(2) != localCalendar.get(2)) {
      return localCalendar.get(2) + 1 + "月";
    }
    if (paramCalendar.get(3) != localCalendar.get(3)) {
      return "一周前";
    }
    if (paramCalendar.get(6) != localCalendar.get(6)) {
      return "本周";
    }
    return "今天";
  }
  
  public String a(BusinessCard paramBusinessCard)
  {
    return paramBusinessCard.picUrl;
  }
  
  public ArrayList a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  HashMap a(ArrayList paramArrayList)
  {
    long l1 = System.currentTimeMillis();
    HashMap localHashMap = new HashMap();
    int j;
    int i;
    label85:
    Object localObject3;
    int k;
    try
    {
      if (this.f == 1)
      {
        Collections.sort(paramArrayList, new BusinessCardListActivity.MyComparator(1));
        j = paramArrayList.size();
        i = 0;
        if (i >= j) {
          break label300;
        }
        BusinessCard localBusinessCard = (BusinessCard)paramArrayList.get(i);
        if (localBusinessCard.firstPinyin == null) {
          break label357;
        }
        if (localBusinessCard.firstPinyin.length() == 0) {
          break label357;
        }
        for (;;)
        {
          localObject3 = str;
          if (str.length() == 1)
          {
            k = str.charAt(0);
            if ((65 > k) || (k > 90)) {
              break label363;
            }
            label119:
            localObject3 = str.toUpperCase();
          }
          label124:
          localBusinessCard.sortDesc = ((String)localObject3);
          if (localHashMap.get(localObject3) != null) {
            break;
          }
          localHashMap.put(localObject3, Integer.valueOf(i));
          break label380;
          String str = localBusinessCard.firstPinyin.substring(0, 1);
        }
        localBusinessCard.sortDesc = null;
      }
    }
    finally {}
    Object localObject2;
    if (this.f == 0)
    {
      Collections.sort(paramArrayList, new BusinessCardListActivity.MyComparator(0));
      localObject2 = Calendar.getInstance();
      ((Calendar)localObject2).setTimeInMillis(NetConnInfoCenter.getServerTime() * 1000L);
      j = paramArrayList.size();
      i = 0;
    }
    for (;;)
    {
      if (i < j)
      {
        localObject3 = (BusinessCard)paramArrayList.get(i);
        ((BusinessCard)localObject3).sortDesc = a(((BusinessCard)localObject3).lastUpdateTime * 1000L, (Calendar)localObject2);
        if (localHashMap.get(((BusinessCard)localObject3).sortDesc) == null) {
          localHashMap.put(((BusinessCard)localObject3).sortDesc, Integer.valueOf(i + 1));
        } else {
          ((BusinessCard)localObject3).sortDesc = null;
        }
      }
      else
      {
        label300:
        long l2 = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
          QLog.d("BusinessCardListActivity", 2, "constructHashStruct, time:" + (l2 - l1) + ", sortType:" + this.f);
        }
        return localHashMap;
        label357:
        localObject2 = "#";
        break label85;
        label363:
        if ((97 <= k) && (k <= 122))
        {
          break label119;
          label380:
          i += 1;
          break;
        }
        localObject3 = "#";
        break label124;
      }
      i += 1;
    }
  }
  
  protected void a()
  {
    super.setContentView(2130904095);
    Object localObject = findViewById(2131299491);
    ((View)localObject).setBackgroundColor(super.getResources().getColor(2131428277));
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      ((View)localObject).setFitsSystemWindows(true);
      if (this.mSystemBarComp != null) {
        this.mSystemBarComp.a(super.getResources().getColor(2131428277));
      }
    }
    ((LinearLayout)findViewById(2131300540)).setBackgroundColor(super.getResources().getColor(2131428277));
    localObject = (TextView)findViewById(2131297183);
    TextView localTextView1 = (TextView)findViewById(2131297083);
    TextView localTextView2 = (TextView)findViewById(2131297139);
    ((TextView)localObject).setVisibility(0);
    ((TextView)localObject).setOnClickListener(this);
    localTextView1.setOnClickListener(this);
    if (this.g == 1)
    {
      ((TextView)localObject).setText(2131368603);
      this.jdField_a_of_type_ComTencentMobileqqBusinessCardUtilitiesBusinessCardGroupLogic = new BusinessCardGroupLogic(this, localTextView2);
    }
    for (this.f = this.jdField_a_of_type_ComTencentMobileqqBusinessCardBusinessCardManager.b();; this.f = 1)
    {
      this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardView = ((BusinessCardView)findViewById(2131301379));
      this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardView.a(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView = ((IndexView)findViewById(2131298104));
      this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setIndex(new String[] { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#" });
      this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setOnIndexChangedListener(this);
      return;
      ((TextView)localObject).setText(2131367262);
      localTextView1.setVisibility(8);
      localTextView2.setText(2131369171);
    }
  }
  
  public void a(int paramInt)
  {
    this.f = paramInt;
    if (this.f == 1) {
      ReportController.b(this.app, "CliOper", "", "", "0X80064D9", "0X80064D9", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqBusinessCardBusinessCardManager.b(paramInt);
      a(this.jdField_a_of_type_JavaUtilArrayList, 0L);
      return;
      ReportController.b(this.app, "CliOper", "", "", "0X80064D8", "0X80064D8", 0, 0, "", "", "", "");
    }
  }
  
  public void a(BusinessCard paramBusinessCard)
  {
    if (this.g == 2)
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("Extra_Result_Data", paramBusinessCard);
      setResult(-1, (Intent)localObject);
      if (!isFinishing()) {
        finish();
      }
    }
    while ((this.g != 3) || (paramBusinessCard.OCRInfo == null))
    {
      localObject = new Intent(this, BusinessCardEditActivity.class);
      if (QLog.isColorLevel()) {
        QLog.d("BusinessCardListActivity", 2, "cardType= " + paramBusinessCard.cardType + "id=" + paramBusinessCard.cardId);
      }
      if (paramBusinessCard.cardType != 2) {
        break;
      }
      b();
      return;
    }
    Object localObject = new Bundle();
    ((Bundle)localObject).putInt("uintype", 30);
    ((Bundle)localObject).putParcelable("business_card_ocr", paramBusinessCard.OCRInfo);
    this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a(0, (Bundle)localObject);
    return;
    if (paramBusinessCard.cardType == 3)
    {
      ((Intent)localObject).putExtra("mode_type", 3);
      ((Intent)localObject).putExtra("cur_card_body", new BusinessCard());
      ((Intent)localObject).putExtra("is_edit_mode", true);
      ((Intent)localObject).putExtra("finish_immedia", true);
      ReportController.b(this.app, "CliOper", "", "", "0X80064DC", "0X80064DC", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      startActivity((Intent)localObject);
      return;
      if (paramBusinessCard.cardType == 1)
      {
        ((Intent)localObject).putExtra("mode_type", 3);
        ((Intent)localObject).putExtra("cur_card_id", paramBusinessCard.cardId);
      }
      else
      {
        ((Intent)localObject).putExtra("mode_type", 0);
        ((Intent)localObject).putExtra("cur_card_id", paramBusinessCard.cardId);
      }
    }
  }
  
  public void a(WeakReference paramWeakReference, BusinessCard paramBusinessCard)
  {
    if (paramWeakReference.get() != null) {
      if (paramBusinessCard.cardType == 1) {
        ((BusinessCardChildView)paramWeakReference.get()).a(paramBusinessCard, getString(2131368167), null, null, null, true);
      }
    }
    while (!QLog.isColorLevel())
    {
      return;
      if ((paramBusinessCard.cardType == 3) || (paramBusinessCard.cardType == 2))
      {
        ((BusinessCardChildView)paramWeakReference.get()).a(paramBusinessCard, paramBusinessCard.cardName, null, null, null, true);
        return;
      }
      String str2 = "";
      String str1 = str2;
      if (paramBusinessCard.mobilesNum != null)
      {
        str1 = str2;
        if (paramBusinessCard.mobilesNum.size() > 0) {
          str1 = (String)paramBusinessCard.mobilesNum.get(0);
        }
      }
      ((BusinessCardChildView)paramWeakReference.get()).a(paramBusinessCard, paramBusinessCard.cardName, str1, paramBusinessCard.company, paramBusinessCard.sortDesc, false);
      return;
    }
    QLog.e("BusinessCardListActivity", 2, "weakView is null");
  }
  
  public void a(ArrayList paramArrayList, long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject2 = null;
    Object localObject1 = null;
    int k;
    int j;
    int i;
    if (paramArrayList != null)
    {
      k = paramArrayList.size();
      j = 0;
      i = 0;
      if (j < k)
      {
        localObject2 = (BusinessCard)paramArrayList.get(j);
        if (((BusinessCard)localObject2).cardType == 1) {
          localObject1 = localObject2;
        }
        for (;;)
        {
          j += 1;
          break;
          if (TextUtils.isEmpty(((BusinessCard)localObject2).picUrl)) {
            i += 1;
          } else if (((BusinessCard)localObject2).cardType == 0) {
            localArrayList.add(localObject2);
          }
        }
      }
      localObject2 = localObject1;
      if (QLog.isColorLevel())
      {
        localObject2 = localObject1;
        if (i > 0)
        {
          QLog.d("BusinessCardListActivity", 2, "initData emptyUrlCnt:" + i);
          localObject2 = localObject1;
        }
      }
    }
    if (this.f == 1)
    {
      j = localArrayList.size();
      i = 0;
      while (i < j)
      {
        paramArrayList = (BusinessCard)localArrayList.get(i);
        paramArrayList.allPinyin = ChnToSpell.a(paramArrayList.cardName, 1);
        paramArrayList.firstPinyin = ChnToSpell.a(paramArrayList.cardName, 2);
        if (!TextUtils.isEmpty(paramArrayList.firstPinyin))
        {
          k = paramArrayList.firstPinyin.charAt(0);
          if (((65 > k) || (k > 90)) && ((97 > k) || (k > 122))) {
            paramArrayList.firstPinyin = "#";
          }
        }
        i += 1;
      }
    }
    paramArrayList = a(localArrayList);
    if (this.g == 1)
    {
      if (localArrayList.size() == 0)
      {
        localObject1 = new BusinessCard();
        ((BusinessCard)localObject1).cardName = getString(2131371226);
        ((BusinessCard)localObject1).cardType = 2;
        localArrayList.add(localObject1);
      }
      if (localObject2 != null) {
        localArrayList.add(0, localObject2);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BusinessCardListActivity", 2, "init data success listsize: \t" + localArrayList.size());
      }
      paramArrayList = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(0, new Object[] { localArrayList, paramArrayList, Long.valueOf(paramLong) });
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramArrayList, paramLong);
      return;
      localObject1 = new BusinessCard();
      ((BusinessCard)localObject1).cardName = getString(2131371265);
      ((BusinessCard)localObject1).cardType = 3;
      localArrayList.add(0, localObject1);
      continue;
      localObject1 = (TextView)findViewById(2131299796);
      if (localArrayList.size() == 0) {
        ((TextView)localObject1).setVisibility(0);
      } else {
        ((TextView)localObject1).setVisibility(8);
      }
    }
  }
  
  void b()
  {
    ReportController.b(this.app, "CliOper", "", "", "0X80064DD", "0X80064DD", 0, 0, "", "", "", "");
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
    localActionSheet.c(2131371230);
    localActionSheet.c(2131371233);
    localActionSheet.a(new qvy(this, localActionSheet));
    localActionSheet.d(2131367262);
    localActionSheet.show();
  }
  
  public void b(String paramString)
  {
    paramString = (Integer)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if ((paramString != null) && (paramString.intValue() != -1)) {
      this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardView.a(paramString.intValue());
    }
  }
  
  public void c() {}
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqBusinessCardBusinessCardManager = ((BusinessCardManager)this.app.getManager(111));
    this.app.registObserver(this.jdField_a_of_type_ComTencentMobileqqBusinessCardBusinessCardObserver);
    paramBundle = getIntent();
    if (paramBundle != null)
    {
      this.g = paramBundle.getIntExtra("Extra_Entrance", 1);
      this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption = ForwardOptionBuilder.a(paramBundle, this.app, this);
      if ((this.g != 3) || (this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption != null)) {
        break label129;
      }
      finish();
    }
    for (;;)
    {
      a();
      a(this.jdField_a_of_type_ComTencentMobileqqBusinessCardBusinessCardManager.a(), 0L);
      int i = this.jdField_a_of_type_ComTencentMobileqqBusinessCardBusinessCardManager.a();
      BusinessCardServlet.a(this.app, i, 0, true);
      this.jdField_a_of_type_ComTencentMobileqqBusinessCardBusinessCardManager.a(true);
      return true;
      label129:
      this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.c();
    }
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption != null) {
      this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.q();
    }
    this.app.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqBusinessCardBusinessCardObserver);
    this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardView.a();
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    ArrayList localArrayList = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
    boolean bool = paramIntent.getBooleanExtra("is_upload_photo", false);
    if (QLog.isColorLevel()) {
      QLog.i("BusinessCardListActivity", 2, "initData isUploadPhoto: " + bool);
    }
    if ((localArrayList != null) && (localArrayList.size() > 0)) {
      if (bool)
      {
        paramIntent = new Intent(this, FlowCameraPhotoActivity.class);
        paramIntent.putExtra("is_upload_photo", true);
        paramIntent.putExtra("PhotoConst.PHOTO_PATHS", localArrayList);
        startActivity(paramIntent);
      }
    }
    while (!bool) {
      return;
    }
    ReportController.b(this.app, "CliOper", "", "", "0X80064E1", "0X80064E1", 0, 0, "", "", "", "");
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131300895: 
    case 2131297183: 
      do
      {
        return;
        c();
        return;
        if (this.g == 1)
        {
          b();
          return;
        }
        setResult(0);
      } while (isFinishing());
      finish();
      return;
    }
    super.finish();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\businessCard\activity\BusinessCardListActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
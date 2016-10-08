package com.tencent.av.ui;

import SecurityAccountServer.RespondQueryQQBindingStat;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.av.app.PstnSessionInfo;
import com.tencent.av.utils.InviteBaseData;
import com.tencent.av.utils.PstnUtils;
import com.tencent.biz.widgets.GridViewForScrollView;
import com.tencent.mobileqq.activity.C2CCallToGroupCall;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.selectmember.PhoneContactSelectActivity;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import guo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class InviteStartAudioDialog
  extends Dialog
  implements View.OnClickListener, AdapterView.OnItemClickListener
{
  public static final int a = 0;
  private static final String jdField_a_of_type_JavaLangString = "InviteStartAudioDialog";
  public static final int b = 1;
  public static final int c = 2;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private ScrollView jdField_a_of_type_AndroidWidgetScrollView;
  private GridViewForScrollView jdField_a_of_type_ComTencentBizWidgetsGridViewForScrollView;
  private C2CCallToGroupCall jdField_a_of_type_ComTencentMobileqqActivityC2CCallToGroupCall;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private FaceDecoder jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder;
  private guo jdField_a_of_type_Guo;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  private List jdField_a_of_type_JavaUtilList;
  private String jdField_b_of_type_JavaLangString;
  private ArrayList jdField_b_of_type_JavaUtilArrayList;
  private ArrayList c;
  private int jdField_d_of_type_Int;
  private ArrayList jdField_d_of_type_JavaUtilArrayList;
  private int e;
  
  public InviteStartAudioDialog(Context paramContext, QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, ArrayList paramArrayList, int paramInt)
  {
    super(paramContext, 2131559144);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.c = new ArrayList();
    this.e = 0;
    setCanceledOnTouchOutside(true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_d_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = new FaceDecoder(paramContext, paramQQAppInterface);
    if (paramArrayList != null)
    {
      paramContext = "InviteStartAudioDialog, InviteBaseData, \n";
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        InviteBaseData localInviteBaseData = (InviteBaseData)paramArrayList.next();
        paramBaseActivity = paramContext;
        if (QLog.isColorLevel()) {
          paramBaseActivity = paramContext + String.format("%s\n", new Object[] { localInviteBaseData });
        }
        this.c.add(localInviteBaseData.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_JavaUtilList.add(localInviteBaseData);
        this.jdField_b_of_type_JavaUtilArrayList.add(localInviteBaseData.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_JavaUtilArrayList.add(a(localInviteBaseData));
        paramContext = paramBaseActivity;
      }
      if (QLog.isColorLevel()) {
        QLog.i("InviteStartAudioDialog", 2, paramContext);
      }
    }
    if (this.jdField_d_of_type_Int == 1) {
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X80063F3", "0X80063F3", 1, 0, "", "", "", "");
    }
    while (this.jdField_d_of_type_Int != 2) {
      return;
    }
    ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X80063F3", "0X80063F3", 2, 0, "", "", "", "");
  }
  
  public InviteStartAudioDialog(Context paramContext, QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, ArrayList paramArrayList1, ArrayList paramArrayList2, String paramString, int paramInt)
  {
    this(paramContext, paramQQAppInterface, paramBaseActivity, paramArrayList1, -1);
    this.jdField_d_of_type_JavaUtilArrayList = paramArrayList2;
    this.jdField_b_of_type_JavaLangString = paramString;
    this.e = paramInt;
    if (this.e == 2) {
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X80063F3", "0X80063F3", 3, 0, "", "", "", "");
    }
    while (this.e != 1) {
      return;
    }
    ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X80063F3", "0X80063F3", 4, 0, "", "", "", "");
  }
  
  private Bitmap a(InviteBaseData paramInviteBaseData)
  {
    Object localObject2 = null;
    Object localObject1;
    if ((paramInviteBaseData.jdField_c_of_type_Int == 0) || (paramInviteBaseData.jdField_c_of_type_Int == 1) || (paramInviteBaseData.jdField_c_of_type_Int == 2) || (paramInviteBaseData.jdField_c_of_type_Int == 1000)) {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(1, paramInviteBaseData.jdField_a_of_type_JavaLangString);
    }
    do
    {
      do
      {
        do
        {
          return (Bitmap)localObject1;
          localObject1 = localObject2;
        } while (paramInviteBaseData.jdField_c_of_type_Int != 1006);
        localObject1 = localObject2;
      } while (TextUtils.isEmpty(paramInviteBaseData.jdField_c_of_type_JavaLangString));
      localObject1 = localObject2;
    } while (!paramInviteBaseData.jdField_c_of_type_JavaLangString.startsWith("+"));
    return this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(11, paramInviteBaseData.jdField_c_of_type_JavaLangString);
  }
  
  private ResultRecord a(InviteBaseData paramInviteBaseData)
  {
    ResultRecord localResultRecord = new ResultRecord();
    if (paramInviteBaseData.jdField_c_of_type_Int == 56938)
    {
      localResultRecord.jdField_a_of_type_Int = 5;
      localResultRecord.jdField_a_of_type_JavaLangString = ("pstn" + paramInviteBaseData.jdField_a_of_type_JavaLangString);
      if ((localResultRecord.jdField_a_of_type_Int == 5) && (!TextUtils.isEmpty(localResultRecord.jdField_a_of_type_JavaLangString))) {
        break label191;
      }
    }
    for (;;)
    {
      localResultRecord.jdField_b_of_type_JavaLangString = paramInviteBaseData.jdField_b_of_type_JavaLangString;
      localResultRecord.jdField_d_of_type_JavaLangString = paramInviteBaseData.jdField_c_of_type_JavaLangString;
      localResultRecord.jdField_c_of_type_JavaLangString = paramInviteBaseData.jdField_d_of_type_JavaLangString;
      if (QLog.isColorLevel()) {
        QLog.d("InviteStartAudioDialog", 2, "convert-" + localResultRecord + "\n");
      }
      return localResultRecord;
      if ((paramInviteBaseData.jdField_c_of_type_Int == 3) || (paramInviteBaseData.jdField_c_of_type_Int == 2016) || (paramInviteBaseData.jdField_c_of_type_Int == 1006))
      {
        localResultRecord.jdField_a_of_type_Int = 5;
        localResultRecord.jdField_a_of_type_JavaLangString = paramInviteBaseData.jdField_c_of_type_JavaLangString;
        break;
      }
      localResultRecord.jdField_a_of_type_Int = paramInviteBaseData.jdField_c_of_type_Int;
      localResultRecord.jdField_a_of_type_JavaLangString = paramInviteBaseData.jdField_a_of_type_JavaLangString;
      break;
      label191:
      if (localResultRecord.jdField_a_of_type_JavaLangString.startsWith("+")) {
        localResultRecord.jdField_a_of_type_Int = 4;
      }
    }
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131299296));
    this.jdField_a_of_type_ComTencentBizWidgetsGridViewForScrollView = ((GridViewForScrollView)findViewById(2131299295));
    this.jdField_a_of_type_AndroidWidgetScrollView = ((ScrollView)findViewById(2131296689));
    this.jdField_a_of_type_Guo = new guo(this, null);
    this.jdField_a_of_type_ComTencentBizWidgetsGridViewForScrollView.setAdapter(this.jdField_a_of_type_Guo);
    this.jdField_a_of_type_ComTencentBizWidgetsGridViewForScrollView.setOnItemClickListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
  }
  
  private void a(int paramInt)
  {
    ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_AndroidWidgetScrollView.getLayoutParams();
    float f = DeviceInfoUtil.a();
    if (QLog.isColorLevel()) {
      QLog.i("InviteStartAudioDialog", 2, "setLayoutHeight.desity:" + f + ", num:" + paramInt);
    }
    int i = (int)f * 84;
    int j = (int)f * 20;
    if (paramInt <= 3) {
      localLayoutParams.height = i;
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetScrollView.setLayoutParams(localLayoutParams);
      return;
      if (paramInt <= 6) {
        localLayoutParams.height = (j + i * 2);
      } else {
        localLayoutParams.height = (j * 2 + i * 3);
      }
    }
  }
  
  private void a(InviteStartAudioDialog.ViewHolder paramViewHolder)
  {
    paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838582);
    paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    paramViewHolder.b.setText("");
    paramViewHolder.b.setTextColor(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131427355));
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
    {
      InviteBaseData localInviteBaseData = (InviteBaseData)this.jdField_a_of_type_JavaUtilList.get(0);
      if (QLog.isColorLevel()) {
        QLog.d("InviteStartAudioDialog", 2, "onClick data:" + localInviteBaseData + "callType:" + this.jdField_d_of_type_Int);
      }
      if (this.jdField_d_of_type_Int == 1)
      {
        ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localInviteBaseData.jdField_c_of_type_Int, localInviteBaseData.jdField_a_of_type_JavaLangString, localInviteBaseData.jdField_b_of_type_JavaLangString, localInviteBaseData.jdField_c_of_type_JavaLangString, true, null, true, true, null, "from_internal");
        dismiss();
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80063F5", "0X80063F5", 1, 0, "", "", "", "");
        return;
      }
      if (this.jdField_d_of_type_Int == 2)
      {
        PstnSessionInfo localPstnSessionInfo;
        if (localInviteBaseData.jdField_c_of_type_Int == 2016) {
          if ((localInviteBaseData.jdField_a_of_type_JavaLangString == null) || (localInviteBaseData.jdField_a_of_type_JavaLangString.length() == 0))
          {
            paramView = localInviteBaseData.jdField_c_of_type_JavaLangString;
            RespondQueryQQBindingStat localRespondQueryQQBindingStat = ((PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10)).a();
            localPstnSessionInfo = new PstnSessionInfo();
            localPstnSessionInfo.jdField_c_of_type_JavaLangString = (localRespondQueryQQBindingStat.nationCode + localRespondQueryQQBindingStat.mobileNo);
            localPstnSessionInfo.jdField_b_of_type_JavaLangString = paramView;
            localPstnSessionInfo.jdField_d_of_type_JavaLangString = localInviteBaseData.jdField_b_of_type_JavaLangString;
            if (TextUtils.isEmpty(localInviteBaseData.jdField_a_of_type_JavaLangString)) {
              break label479;
            }
            localPstnSessionInfo.jdField_a_of_type_JavaLangString = localInviteBaseData.jdField_a_of_type_JavaLangString;
            label302:
            localPstnSessionInfo.jdField_a_of_type_Int = localInviteBaseData.jdField_c_of_type_Int;
            if ((PstnUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1)) || (!PstnUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2))) {
              break label488;
            }
            this.jdField_a_of_type_ComTencentMobileqqActivityC2CCallToGroupCall = new C2CCallToGroupCall();
            this.jdField_a_of_type_ComTencentMobileqqActivityC2CCallToGroupCall.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent(), this.jdField_a_of_type_ComTencentMobileqqActivityC2CCallToGroupCall.getActivity(), localPstnSessionInfo.jdField_c_of_type_JavaLangString, localPstnSessionInfo.jdField_a_of_type_JavaLangString, localPstnSessionInfo.jdField_d_of_type_JavaLangString, localPstnSessionInfo.jdField_a_of_type_Int, localPstnSessionInfo.jdField_b_of_type_JavaLangString, 3);
            this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDimensionPixelSize(2131492908);
            this.jdField_a_of_type_ComTencentMobileqqActivityC2CCallToGroupCall.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getBaseContext(), false);
          }
        }
        for (;;)
        {
          dismiss();
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80063F5", "0X80063F5", 2, 0, "", "", "", "");
          return;
          paramView = localInviteBaseData.jdField_a_of_type_JavaLangString;
          break;
          paramView = localInviteBaseData.jdField_c_of_type_JavaLangString;
          break;
          label479:
          localPstnSessionInfo.jdField_a_of_type_JavaLangString = paramView;
          break label302;
          label488:
          ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localPstnSessionInfo, 5);
        }
      }
      ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localInviteBaseData.jdField_c_of_type_Int, localInviteBaseData.jdField_a_of_type_JavaLangString, localInviteBaseData.jdField_b_of_type_JavaLangString, localInviteBaseData.jdField_c_of_type_JavaLangString, true, null, true, true, null, null, 3, true);
      dismiss();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("InviteStartAudioDialog", 2, "onClick group call, groupUin:" + this.jdField_b_of_type_JavaLangString);
    }
    if (this.e == 1)
    {
      ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 3000, this.jdField_b_of_type_JavaLangString, true, true, true, null, this.jdField_d_of_type_JavaUtilArrayList, 2, 3);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006407", "0X8006407", 5, 0, "", "", "", "");
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80063F5", "0X80063F5", 4, 0, "", "", "", "");
    }
    for (;;)
    {
      dismiss();
      return;
      if (this.e == 2)
      {
        ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 3000, this.jdField_b_of_type_JavaLangString, true, true, true, null, this.jdField_d_of_type_JavaUtilArrayList, 3, 3);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006407", "0X8006407", 6, 0, "", "", "", "");
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80063F5", "0X80063F5", 3, 0, "", "", "", "");
      }
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903570);
    a();
    this.jdField_a_of_type_Guo.a(this.jdField_a_of_type_JavaUtilList);
    a(this.jdField_a_of_type_Guo.getCount());
  }
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (InviteBaseData)paramAdapterView.getItemAtPosition(paramInt);
    if ((paramAdapterView != null) && (paramAdapterView.jdField_d_of_type_Int == 1))
    {
      PhoneContactSelectActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_b_of_type_JavaLangString, this.jdField_d_of_type_JavaUtilArrayList, this.jdField_a_of_type_JavaUtilArrayList, this.e);
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.overridePendingTransition(2130968592, 2130968593);
      dismiss();
      if (this.jdField_d_of_type_Int != 1) {
        break label136;
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80063F4", "0X80063F4", 1, 0, "", "", "", "");
    }
    label136:
    do
    {
      while (this.e == 1)
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80063F4", "0X80063F4", 4, 0, "", "", "", "");
        return;
        if (this.jdField_d_of_type_Int == 2) {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80063F4", "0X80063F4", 2, 0, "", "", "", "");
        }
      }
    } while (this.e != 2);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80063F4", "0X80063F4", 3, 0, "", "", "", "");
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\ui\InviteStartAudioDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
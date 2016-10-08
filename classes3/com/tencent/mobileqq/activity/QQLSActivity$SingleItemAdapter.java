package com.tencent.mobileqq.activity;

import android.content.res.Resources;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.biz.pubaccount.util.PublicAccountConfigUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.device.utils.SmartDeviceUtil;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.FileTransferManager;
import com.tencent.mobileqq.activity.aio.item.BreathAnimationLayout;
import com.tencent.mobileqq.activity.aio.item.PttItemBuilder;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.ptt.preop.PTTPreDownloader;
import com.tencent.mobileqq.subaccount.datamanager.SubAccountManager;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.transfile.PttInfoCollector;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XBaseAdapter;
import java.util.ArrayList;
import java.util.List;
import mdq;
import mdr;

public class QQLSActivity$SingleItemAdapter
  extends XBaseAdapter
{
  public List a;
  
  public QQLSActivity$SingleItemAdapter(QQLSActivity paramQQLSActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  private View b(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView != null)
    {
      paramViewGroup = paramView.getTag();
      if (!(paramViewGroup instanceof mdr)) {}
    }
    for (paramViewGroup = (mdr)paramViewGroup;; paramViewGroup = null)
    {
      if (paramViewGroup == null)
      {
        paramView = this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.getLayoutInflater().inflate(2130904218, null);
        paramViewGroup = new mdr();
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131301859));
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setMaxLines(10);
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-4210755);
        paramView.setTag(paramViewGroup);
      }
      for (;;)
      {
        Object localObject = (ImageView)paramView.findViewById(2131301862);
        if (localObject != null)
        {
          if (QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).a() != 7432) {
            break label146;
          }
          ((ImageView)localObject).setVisibility(4);
        }
        while (paramInt >= this.jdField_a_of_type_JavaUtilList.size())
        {
          return paramView;
          label146:
          ((ImageView)localObject).setVisibility(0);
        }
        localObject = QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).b;
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        return paramView;
      }
    }
  }
  
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    MessageRecord localMessageRecord = (MessageRecord)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    Object localObject = new BaseChatItemLayout(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity);
    ((BaseChatItemLayout)localObject).setId(2131296417);
    ((BaseChatItemLayout)localObject).setFocusableInTouchMode(true);
    ((BaseChatItemLayout)localObject).setPadding(BaseChatItemLayout.w, BaseChatItemLayout.y, BaseChatItemLayout.x, 0);
    if ((paramView == null) || (!(paramView.getTag() instanceof QQLSActivity.SinglePttHolder)))
    {
      paramViewGroup = new QQLSActivity.SinglePttHolder();
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.getLayoutInflater().inflate(2130904213, null);
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131296418));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131296419));
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout = ((BreathAnimationLayout)paramView.findViewById(2131296420));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout = ((BaseChatItemLayout)localObject);
      MessageForPtt localMessageForPtt;
      ViewGroup.MarginLayoutParams localMarginLayoutParams;
      if ((localMessageRecord instanceof MessageForPtt))
      {
        localMessageForPtt = (MessageForPtt)localMessageRecord;
        localObject = QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity, localMessageRecord);
        ((TextView)paramView.findViewById(2131301857)).setText((CharSequence)localObject);
        localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.getLayoutParams();
        if (((String)localObject).equals("")) {
          break label556;
        }
        localMarginLayoutParams.setMargins(AIOUtils.a(5.0F, this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.getResources()), AIOUtils.a(7.0F, this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.getResources()), 0, 0);
        int j = PttItemBuilder.a(QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity), localMessageForPtt);
        int i = j;
        if (j == -1)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.a(paramViewGroup, localMessageForPtt, false);
          i = 2001;
        }
        if (QLog.isColorLevel()) {
          QLog.d("PTTItem->getBubbleView", 2, "fileStatus = " + i + " url " + localMessageForPtt.url + " uniseq " + localMessageForPtt.uniseq);
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.a(paramViewGroup, localMessageForPtt, i, this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.a(localMessageForPtt));
        PttInfoCollector.a(QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity), i, localMessageRecord);
        FileTransferManager.a(QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity)).a(paramView, this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity);
        if ((QQLSActivity.b()) && (paramViewGroup.jdField_a_of_type_JavaLangStringBuilder == null)) {
          paramViewGroup.jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
        }
        paramViewGroup.b = paramInt;
        paramViewGroup.jdField_c_of_type_Int = paramInt;
        if (QQLSActivity.b())
        {
          paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setContentDescription(null);
          if (!TextUtils.isEmpty(paramViewGroup.jdField_a_of_type_JavaLangStringBuilder)) {
            paramViewGroup.jdField_a_of_type_JavaLangStringBuilder.replace(0, paramViewGroup.jdField_a_of_type_JavaLangStringBuilder.length(), "");
          }
          if ((!((ChatMessage)localMessageRecord).mNeedTimeStamp) || (localMessageRecord.time <= 0L)) {}
        }
      }
      try
      {
        localObject = TimeFormatterUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity, 3, localMessageRecord.time * 1000L);
        paramViewGroup.jdField_a_of_type_JavaLangStringBuilder.append((CharSequence)localObject).append(" ");
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqDataChatMessage = ((ChatMessage)localMessageRecord);
        PTTPreDownloader.a(QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity)).b(localMessageForPtt);
        return paramView;
        paramViewGroup = (QQLSActivity.SinglePttHolder)paramView.getTag();
        continue;
        label556:
        localMarginLayoutParams.setMargins(0, AIOUtils.a(7.0F, this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.getResources()), 0, 0);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          String str = "";
        }
      }
    }
  }
  
  public void a(List paramList)
  {
    if (paramList != null)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList.addAll((List)((ArrayList)paramList).clone());
      notifyDataSetChanged();
    }
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size()))
    {
      MessageRecord localMessageRecord = (MessageRecord)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      if ((QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).a() == 1012) || (QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).a() == 7432)) {
        return 1;
      }
      if ((localMessageRecord != null) && ((localMessageRecord.msgtype == 63534) || (localMessageRecord.msgtype == 64505))) {
        return 2;
      }
      if (QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).a() == 9653) {
        return 4;
      }
    }
    return 0;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = getItemViewType(paramInt);
    if ((i == 1) || (i == 4)) {
      paramView = b(paramInt, paramView, paramViewGroup);
    }
    Object localObject1;
    do
    {
      return paramView;
      if (i == 2) {
        return a(paramInt, paramView, paramViewGroup);
      }
      if (paramView != null)
      {
        paramViewGroup = paramView;
        if ((paramView.getTag() instanceof mdq)) {}
      }
      else
      {
        paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.getLayoutInflater().inflate(2130904217, null);
        paramView = new mdq();
        localObject1 = (TextView)paramViewGroup.findViewById(2131301859);
        localObject2 = (ImageView)paramViewGroup.findViewById(2131301858);
        ((TextView)localObject1).setEllipsize(TextUtils.TruncateAt.END);
        ((TextView)localObject1).setMaxLines(10);
        paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject1);
        paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localObject2);
        paramViewGroup.setTag(paramView);
      }
      paramView = paramViewGroup;
    } while (paramInt >= this.jdField_a_of_type_JavaUtilList.size());
    MessageRecord localMessageRecord = (MessageRecord)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    Object localObject2 = (mdq)paramViewGroup.getTag();
    if (localMessageRecord.istroop == 7000)
    {
      paramView = null;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountManager != null) {
        paramView = this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountManager.c(localMessageRecord.frienduin);
      }
      localObject1 = paramView;
      if (paramView == null) {
        localObject1 = localMessageRecord.frienduin;
      }
      paramView = (String)localObject1 + ": " + QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).a().a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity, localMessageRecord, false);
    }
    label371:
    label1223:
    label1229:
    for (;;)
    {
      localObject1 = paramView;
      if (TextUtils.isEmpty(paramView)) {
        localObject1 = "";
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.jdField_a_of_type_JavaUtilArrayList.size() > 0) && (((String)localObject1).equals("")) && ((localMessageRecord.msgtype == 63520) || (localMessageRecord.msgtype == 63527) || (localMessageRecord.msgtype == 63510)))
      {
        localObject1 = localMessageRecord.msg;
        ((mdq)localObject2).jdField_a_of_type_AndroidWidgetTextView.setTextColor(-570319);
        ((mdq)localObject2).jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        ((mdq)localObject2).jdField_a_of_type_AndroidWidgetTextView.setText(new QQText((CharSequence)localObject1, 5, 16, QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).a()));
        return paramViewGroup;
        if ((localMessageRecord.istroop == 1001) || (localMessageRecord.istroop == 1010))
        {
          localObject1 = ContactUtils.o(QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity), localMessageRecord.senderuin);
          paramView = (View)localObject1;
          if (localObject1 == null) {
            paramView = "";
          }
          Object localObject3;
          if (localMessageRecord.frienduin.equals(AppConstants.aN))
          {
            ((TextView)QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).findViewById(2131301840)).setText(BaseApplicationImpl.a().getString(2131372122));
            localObject1 = BaseApplicationImpl.a().getString(2131372123);
            ((DragTextView)QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).findViewById(2131301844)).setVisibility(8);
            localObject3 = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.OneyWayDateMsgNotifyCfg.name());
            paramView = (View)localObject1;
            if (((String)localObject3).length() <= 0) {
              break label1229;
            }
            localObject3 = ((String)localObject3).split("\\|");
            paramView = (View)localObject1;
            if (localObject3.length < 6) {
              break label1229;
            }
            ((TextView)QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).findViewById(2131301840)).setText(localObject3[4]);
            paramView = localObject3[5];
            continue;
          }
          if (localMessageRecord.frienduin.equals(AppConstants.aM))
          {
            ((TextView)QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).findViewById(2131301840)).setText(BaseApplicationImpl.a().getString(2131372124));
            localObject1 = BaseApplicationImpl.a().getString(2131372125);
            ((DragTextView)QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).findViewById(2131301844)).setVisibility(8);
            localObject3 = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.OneyWayLBSFriendMsgNotifyCfg.name());
            paramView = (View)localObject1;
            if (((String)localObject3).length() <= 0) {
              break label1229;
            }
            localObject3 = ((String)localObject3).split("\\|");
            paramView = (View)localObject1;
            if (localObject3.length < 6) {
              break label1229;
            }
            ((TextView)QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).findViewById(2131301840)).setText(localObject3[4]);
            paramView = localObject3[5];
            continue;
          }
          paramView = paramView + ": " + QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).a().a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity, localMessageRecord, false);
          continue;
        }
        if ((localMessageRecord.istroop == 9501) && ("device_groupchat".equals(localMessageRecord.extStr)))
        {
          if ((localMessageRecord.msgtype == 61035) || (localMessageRecord.msgtype == 61028))
          {
            localObject1 = ContactUtils.b(QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity), localMessageRecord.senderuin, true);
            paramView = (View)localObject1;
            if (!TextUtils.isEmpty(localMessageRecord.senderuin))
            {
              paramView = (View)localObject1;
              if (localMessageRecord.senderuin.equals(localMessageRecord.frienduin)) {
                paramView = SmartDeviceUtil.a(((SmartDeviceProxyMgr)QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).a(51)).a(Long.parseLong(localMessageRecord.senderuin)));
              }
            }
            localObject1 = paramView;
            if (paramView == null) {
              localObject1 = "";
            }
            paramView = (String)localObject1 + ": " + QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).a().a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity, localMessageRecord, false);
            continue;
          }
          paramView = QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).a().a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity, localMessageRecord, false);
          continue;
        }
        if (AnonymousChatHelper.a(localMessageRecord))
        {
          paramView = this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.getResources().getString(2131364731) + QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).a().a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity, localMessageRecord, false);
          continue;
        }
        if ((localMessageRecord.istroop == 1) && ((localMessageRecord instanceof MessageForPubAccount))) {
          if (((MessageForPubAccount)localMessageRecord).isTextMsg()) {
            break label1223;
          }
        }
      }
      for (paramView = PublicAccountConfigUtil.a(QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity), BaseApplicationImpl.getContext()) + ":";; paramView = "")
      {
        paramView = paramView + QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).a().a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity, localMessageRecord, false);
        break;
        paramView = QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).a().a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity, localMessageRecord, false);
        break;
        ((mdq)localObject2).jdField_a_of_type_AndroidWidgetTextView.setTextColor(-4210755);
        ((mdq)localObject2).jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        break label371;
      }
    }
  }
  
  public int getViewTypeCount()
  {
    return 5;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\QQLSActivity$SingleItemAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
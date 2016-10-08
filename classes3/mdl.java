import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.util.PublicAccountConfigUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQLSActivity;
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
import com.tencent.mobileqq.app.NewFriendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.ptt.preop.PTTPreDownloader;
import com.tencent.mobileqq.qcall.QCallCardInfo;
import com.tencent.mobileqq.qcall.QCallCardManager;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.transfile.PttInfoCollector;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.CustomWidgetUtil;
import com.tencent.widget.XBaseAdapter;
import java.util.ArrayList;
import java.util.List;

public class mdl
  extends XBaseAdapter
{
  CharSequence jdField_a_of_type_JavaLangCharSequence;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  
  public mdl(QQLSActivity paramQQLSActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaLangCharSequence = "";
  }
  
  private View b(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView != null)
    {
      paramViewGroup = paramView.getTag();
      if (!(paramViewGroup instanceof mdp)) {}
    }
    for (paramViewGroup = (mdp)paramViewGroup;; paramViewGroup = null)
    {
      RecentBaseData localRecentBaseData = (RecentBaseData)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      Object localObject = paramViewGroup;
      if (paramViewGroup == null)
      {
        paramView = this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.getLayoutInflater().inflate(2130904215, null);
        localObject = new mdp();
        ((mdp)localObject).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131301840));
        ((mdp)localObject).jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)paramView.findViewById(2131301844));
        ((mdp)localObject).jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setOnModeChangeListener(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout);
        ((mdp)localObject).jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(0);
        paramView.setTag(localObject);
      }
      ((mdp)localObject).jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTag(Integer.valueOf(paramInt));
      ((mdp)localObject).jdField_a_of_type_AndroidWidgetTextView.setText(localRecentBaseData.jdField_b_of_type_JavaLangString);
      ((mdp)localObject).jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setVisibility(0);
      CustomWidgetUtil.a(((mdp)localObject).jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, 3, 1, 0);
      return paramView;
    }
  }
  
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject2 = (RecentBaseData)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    paramViewGroup = QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).a().a(((RecentBaseData)localObject2).a(), ((RecentBaseData)localObject2).a());
    MessageRecord localMessageRecord = QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).a().a(((RecentBaseData)localObject2).a(), ((RecentBaseData)localObject2).a(), paramViewGroup.uniseq);
    if (paramView != null)
    {
      paramViewGroup = paramView;
      if ((paramView.getTag() instanceof mdm)) {}
    }
    else
    {
      paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.getLayoutInflater().inflate(2130904216, null);
      paramView = new mdm();
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131301840));
      paramView.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131301841));
      paramView.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)paramViewGroup.findViewById(2131301844));
      paramViewGroup.setTag(paramView);
      paramView.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setOnModeChangeListener(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout);
      paramView.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(0);
      paramView.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131296418));
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131296419));
      paramView.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout = ((BreathAnimationLayout)paramViewGroup.findViewById(2131296420));
    }
    mdm localmdm = (mdm)paramViewGroup.getTag();
    localmdm.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTag(Integer.valueOf(paramInt));
    int i = 0;
    if ((((RecentBaseData)localObject2).a().equals(AppConstants.aM)) || (((RecentBaseData)localObject2).a().equals(AppConstants.aN))) {
      i = 1;
    }
    int j;
    if (i != 0)
    {
      i = 0;
      j = 0;
    }
    for (;;)
    {
      label363:
      label429:
      Object localObject1;
      if ((((RecentBaseData)localObject2).a() == 0) || (((RecentBaseData)localObject2).a() == 3000) || (((RecentBaseData)localObject2).a() == 8)) {
        if (j > 0)
        {
          paramView = this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.a(((RecentBaseData)localObject2).a(), ((RecentBaseData)localObject2).a());
          if ((paramView == null) || (paramView.size() <= 0))
          {
            this.jdField_a_of_type_JavaLangCharSequence = ((RecentBaseData)localObject2).jdField_b_of_type_JavaLangCharSequence;
            if (QLog.isColorLevel()) {
              QLog.d("QQLSActivity", 2, "recentList misscallMsg size = 0");
            }
            localmdm.jdField_a_of_type_AndroidWidgetTextView.setText(((RecentBaseData)localObject2).jdField_b_of_type_JavaLangString);
            localmdm.jdField_b_of_type_AndroidWidgetTextView.setText(((RecentBaseData)localObject2).jdField_c_of_type_JavaLangString);
            if (((RecentBaseData)localObject2).a() == 4000) {
              i = this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.jdField_a_of_type_ComTencentMobileqqAppNewFriendManager.c();
            }
            if (i + j != 0) {
              break label1494;
            }
            localmdm.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setVisibility(4);
            if ((((RecentBaseData)localObject2).a().equals(AppConstants.aN)) || (((RecentBaseData)localObject2).a().equals(AppConstants.aM))) {
              localmdm.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setVisibility(8);
            }
            paramView = new BaseChatItemLayout(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity);
            paramView.setId(2131296417);
            paramView.setFocusableInTouchMode(true);
            paramView.setPadding(BaseChatItemLayout.w, BaseChatItemLayout.y, BaseChatItemLayout.x, 0);
            localmdm.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout = paramView;
            if ((localMessageRecord instanceof MessageForPtt))
            {
              localObject1 = (MessageForPtt)localMessageRecord;
              paramView = QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity, localMessageRecord);
              ((TextView)paramViewGroup.findViewById(2131301857)).setText(paramView);
              localObject2 = (ViewGroup.MarginLayoutParams)localmdm.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.getLayoutParams();
              if (paramView.equals("")) {
                break label1521;
              }
              ((ViewGroup.MarginLayoutParams)localObject2).setMargins(AIOUtils.a(5.0F, this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.getResources()), AIOUtils.a(7.0F, this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.getResources()), 0, 0);
              j = PttItemBuilder.a(QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity), (MessageForPtt)localObject1);
              i = j;
              if (j == -1)
              {
                this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.a(localmdm, (MessageForPtt)localObject1, false);
                i = 2001;
              }
              if (QLog.isColorLevel()) {
                QLog.d("PTTItem->getBubbleView", 2, "fileStatus = " + i + " url " + ((MessageForPtt)localObject1).url + " uniseq " + ((MessageForPtt)localObject1).uniseq);
              }
              this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.a(localmdm, (MessageForPtt)localObject1, i, this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.a((ChatMessage)localObject1));
              PttInfoCollector.a(QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity), i, localMessageRecord);
              FileTransferManager.a(QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity)).a(paramViewGroup, this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity);
              if ((QQLSActivity.b()) && (localmdm.jdField_a_of_type_JavaLangStringBuilder == null)) {
                localmdm.jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
              }
              localmdm.jdField_b_of_type_Int = paramInt;
              localmdm.jdField_c_of_type_Int = paramInt;
              if (QQLSActivity.b())
              {
                localmdm.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setContentDescription(null);
                if (!TextUtils.isEmpty(localmdm.jdField_a_of_type_JavaLangStringBuilder)) {
                  localmdm.jdField_a_of_type_JavaLangStringBuilder.replace(0, localmdm.jdField_a_of_type_JavaLangStringBuilder.length(), "");
                }
                if ((!((ChatMessage)localMessageRecord).mNeedTimeStamp) || (localMessageRecord.time <= 0L)) {}
              }
            }
          }
        }
      }
      try
      {
        paramView = TimeFormatterUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity, 3, localMessageRecord.time * 1000L);
        localmdm.jdField_a_of_type_JavaLangStringBuilder.append(paramView).append(" ");
        localmdm.jdField_a_of_type_ComTencentMobileqqDataChatMessage = ((ChatMessage)localMessageRecord);
        PTTPreDownloader.a(QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity)).b((MessageForPtt)localObject1);
        return paramViewGroup;
        i = QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).a().a(((RecentBaseData)localObject2).a(), ((RecentBaseData)localObject2).a());
        j = this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.a(((RecentBaseData)localObject2).a(), ((RecentBaseData)localObject2).a());
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("QQLSActivity", 2, "recentList misscallMsg size " + paramView.size());
        }
        localObject1 = QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).a().a(((RecentBaseData)localObject2).a(), ((RecentBaseData)localObject2).a());
        long l1 = ((RecentBaseData)localObject2).a();
        long l2 = ((MessageRecord)paramView.get(paramView.size() - 1)).time;
        if ((Long.valueOf(l1).longValue() >= Long.valueOf(l2).longValue()) && (((MessageRecord)localObject1).msgtype != 63520) && (((MessageRecord)localObject1).msgtype != 63527) && (((MessageRecord)localObject1).msgtype != 63510))
        {
          this.jdField_a_of_type_JavaLangCharSequence = ((RecentBaseData)localObject2).jdField_b_of_type_JavaLangCharSequence;
          break label363;
        }
        this.jdField_a_of_type_JavaLangCharSequence = ((MessageRecord)paramView.get(paramView.size() - 1)).msg;
        break label363;
        this.jdField_a_of_type_JavaLangCharSequence = ((RecentBaseData)localObject2).jdField_b_of_type_JavaLangCharSequence;
        break label363;
        if ((((RecentBaseData)localObject2).a() == 1001) || (((RecentBaseData)localObject2).a() == 1010))
        {
          if (((RecentBaseData)localObject2).a().equals(AppConstants.aN))
          {
            ((RecentBaseData)localObject2).jdField_b_of_type_JavaLangString = BaseApplicationImpl.a().getString(2131372122);
            this.jdField_a_of_type_JavaLangCharSequence = BaseApplicationImpl.a().getString(2131372123);
            paramView = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.OneyWayDateMsgNotifyCfg.name());
            if (paramView.length() <= 0) {
              break label363;
            }
            paramView = paramView.split("\\|");
            if (paramView.length < 6) {
              break label363;
            }
            ((RecentBaseData)localObject2).jdField_b_of_type_JavaLangString = paramView[4];
            this.jdField_a_of_type_JavaLangCharSequence = paramView[5];
            break label363;
          }
          if (((RecentBaseData)localObject2).a().equals(AppConstants.aM))
          {
            ((RecentBaseData)localObject2).jdField_b_of_type_JavaLangString = BaseApplicationImpl.a().getString(2131372124);
            this.jdField_a_of_type_JavaLangCharSequence = BaseApplicationImpl.a().getString(2131372125);
            paramView = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.OneyWayLBSFriendMsgNotifyCfg.name());
            if (paramView.length() <= 0) {
              break label363;
            }
            paramView = paramView.split("\\|");
            if (paramView.length < 6) {
              break label363;
            }
            ((RecentBaseData)localObject2).jdField_b_of_type_JavaLangString = paramView[4];
            this.jdField_a_of_type_JavaLangCharSequence = paramView[5];
            break label363;
          }
          QQMessageFacade.Message localMessage = QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).a().a(((RecentBaseData)localObject2).a(), ((RecentBaseData)localObject2).a());
          localObject1 = ContactUtils.o(QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity), localMessage.senderuin);
          paramView = (View)localObject1;
          if (localObject1 == null) {
            paramView = "";
          }
          this.jdField_a_of_type_JavaLangCharSequence = (paramView + ": " + QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).a().a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity, localMessage, false));
          break label363;
        }
        this.jdField_a_of_type_JavaLangCharSequence = ((RecentBaseData)localObject2).jdField_b_of_type_JavaLangCharSequence;
        break label363;
        label1494:
        localmdm.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setVisibility(0);
        CustomWidgetUtil.a(localmdm.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, 3, j + i, 0);
        break label429;
        label1521:
        ((ViewGroup.MarginLayoutParams)localObject2).setMargins(0, AIOUtils.a(7.0F, this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.getResources()), 0, 0);
      }
      catch (Exception paramView)
      {
        for (;;)
        {
          paramView = "";
        }
      }
    }
  }
  
  public void a(ArrayList paramArrayList)
  {
    if (paramArrayList != null)
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_JavaUtilArrayList.addAll((List)paramArrayList.clone());
      notifyDataSetChanged();
    }
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size()))
    {
      RecentBaseData localRecentBaseData = (RecentBaseData)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      QQMessageFacade.Message localMessage = QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).a().a(localRecentBaseData.a(), localRecentBaseData.a());
      if ((localRecentBaseData.a() == 1012) || (localRecentBaseData.a() == 7432)) {
        return 1;
      }
      if ((localMessage != null) && ((localMessage.msgtype == 63534) || (localMessage.msgtype == 64505))) {
        return 2;
      }
      if ((localMessage != null) && (localMessage.msgtype == 63511)) {
        return 3;
      }
      if (localRecentBaseData.a() == 9653) {
        return 4;
      }
    }
    return 0;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    System.currentTimeMillis();
    int k = getItemViewType(paramInt);
    if ((k == 1) || (k == 4))
    {
      paramView = b(paramInt, paramView, paramViewGroup);
      return paramView;
    }
    if (k == 2) {
      return a(paramInt, paramView, paramViewGroup);
    }
    if (paramView != null)
    {
      paramViewGroup = paramView;
      if ((paramView.getTag() instanceof mdo)) {}
    }
    else
    {
      paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.getLayoutInflater().inflate(2130904214, null);
      paramView = new mdo();
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131301840));
      paramView.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131301859));
      paramView.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131301841));
      paramView.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)paramViewGroup.findViewById(2131301844));
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131301858));
      paramViewGroup.setTag(paramView);
      paramView.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setOnModeChangeListener(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout);
      paramView.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(0);
    }
    RecentBaseData localRecentBaseData = (RecentBaseData)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    mdo localmdo = (mdo)paramViewGroup.getTag();
    localmdo.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTag(Integer.valueOf(paramInt));
    paramInt = 0;
    int j = 0;
    if ((localRecentBaseData.a().equals(AppConstants.aM)) || (localRecentBaseData.a().equals(AppConstants.aN))) {
      paramInt = 1;
    }
    int i;
    if (paramInt != 0)
    {
      i = 0;
      paramInt = j;
      label259:
      if (k == 3)
      {
        paramView = QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).a().a(localRecentBaseData.a(), localRecentBaseData.a());
        if (paramView != null) {
          localRecentBaseData.jdField_b_of_type_JavaLangCharSequence = QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).a().a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity, paramView, false);
        }
      }
      if ((localRecentBaseData.a() != 0) && (localRecentBaseData.a() != 3000) && (localRecentBaseData.a() != 8)) {
        break label1076;
      }
      if (i <= 0) {
        break label1019;
      }
      localmdo.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.a(localRecentBaseData.a(), localRecentBaseData.a());
      if ((paramView != null) && (paramView.size() > 0)) {
        break label804;
      }
      this.jdField_a_of_type_JavaLangCharSequence = localRecentBaseData.jdField_b_of_type_JavaLangCharSequence;
      localmdo.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-4210755);
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "recentList misscallMsg size = 0");
      }
      label425:
      localmdo.jdField_c_of_type_AndroidWidgetTextView.setText(localRecentBaseData.jdField_c_of_type_JavaLangString);
    }
    label490:
    label503:
    label640:
    label716:
    label804:
    Object localObject;
    for (;;)
    {
      if ((localRecentBaseData.a() == 8) && (localRecentBaseData.L == 25))
      {
        paramView = (PhoneContactManager)QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).getManager(10);
        if (paramView == null) {
          break label1694;
        }
        paramView = paramView.c(localRecentBaseData.g);
        if (paramView == null) {
          break label1623;
        }
        localRecentBaseData.jdField_b_of_type_JavaLangString = paramView.name;
        if (localRecentBaseData.jdField_b_of_type_JavaLangString.equals(localRecentBaseData.a())) {
          localRecentBaseData.jdField_b_of_type_JavaLangString = localRecentBaseData.g;
        }
        if (QLog.isDevelopLevel()) {
          QLog.d("QQLSActivity", 4, "getView mTitleName = " + localRecentBaseData.jdField_b_of_type_JavaLangString);
        }
      }
      localmdo.jdField_a_of_type_AndroidWidgetTextView.setText(localRecentBaseData.jdField_b_of_type_JavaLangString);
      localmdo.jdField_b_of_type_AndroidWidgetTextView.setText(new QQText(this.jdField_a_of_type_JavaLangCharSequence, 5, 16, localRecentBaseData.a()));
      localmdo.jdField_c_of_type_AndroidWidgetTextView.setText(localRecentBaseData.jdField_c_of_type_JavaLangString);
      if (localRecentBaseData.a() != 4000) {
        break label1691;
      }
      paramInt = this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.jdField_a_of_type_ComTencentMobileqqAppNewFriendManager.c();
      if ((!TextUtils.equals(localRecentBaseData.a(), AppConstants.ba)) || (localRecentBaseData.a() != 7220))
      {
        j = paramInt;
        if (TextUtils.equals(localRecentBaseData.a(), AppConstants.aZ))
        {
          j = paramInt;
          if (localRecentBaseData.a() != 1008) {}
        }
      }
      else
      {
        j = 1;
      }
      if (j + i != 0) {
        break label1664;
      }
      localmdo.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setVisibility(4);
      if (!localRecentBaseData.a().equals(AppConstants.aN))
      {
        paramView = paramViewGroup;
        if (!localRecentBaseData.a().equals(AppConstants.aM)) {
          break;
        }
      }
      localmdo.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setVisibility(8);
      return paramViewGroup;
      paramInt = QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).a().a(localRecentBaseData.a(), localRecentBaseData.a());
      i = this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.a(localRecentBaseData.a(), localRecentBaseData.a());
      break label259;
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "recentList misscallMsg size " + paramView.size());
      }
      localObject = QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).a().a(localRecentBaseData.a(), localRecentBaseData.a());
      long l1 = localRecentBaseData.a();
      long l2 = ((MessageRecord)paramView.get(paramView.size() - 1)).time;
      if ((Long.valueOf(l1).longValue() >= Long.valueOf(l2).longValue()) && (((MessageRecord)localObject).msgtype != 63520) && (((MessageRecord)localObject).msgtype != 63527) && (((MessageRecord)localObject).msgtype != 63510) && (localRecentBaseData.a() != 8))
      {
        this.jdField_a_of_type_JavaLangCharSequence = localRecentBaseData.jdField_b_of_type_JavaLangCharSequence;
        localmdo.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-4210755);
        break label425;
      }
      this.jdField_a_of_type_JavaLangCharSequence = ((MessageRecord)paramView.get(paramView.size() - 1)).msg;
      localmdo.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-570319);
      break label425;
      label1019:
      localmdo.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_JavaLangCharSequence = ((String)localRecentBaseData.jdField_c_of_type_JavaLangCharSequence + localRecentBaseData.jdField_b_of_type_JavaLangCharSequence);
      localmdo.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-4210755);
    }
    label1076:
    if ((localRecentBaseData.a() == 1001) || (localRecentBaseData.a() == 1010))
    {
      if (localRecentBaseData.a().equals(AppConstants.aN))
      {
        localRecentBaseData.jdField_b_of_type_JavaLangString = BaseApplicationImpl.a().getString(2131372122);
        this.jdField_a_of_type_JavaLangCharSequence = BaseApplicationImpl.a().getString(2131372123);
        paramView = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.OneyWayDateMsgNotifyCfg.name());
        if (paramView.length() > 0)
        {
          paramView = paramView.split("\\|");
          if (paramView.length >= 6)
          {
            localRecentBaseData.jdField_b_of_type_JavaLangString = paramView[4];
            this.jdField_a_of_type_JavaLangCharSequence = paramView[5];
          }
        }
      }
      for (;;)
      {
        localmdo.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-4210755);
        localmdo.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        break;
        if (localRecentBaseData.a().equals(AppConstants.aM))
        {
          localRecentBaseData.jdField_b_of_type_JavaLangString = BaseApplicationImpl.a().getString(2131372124);
          this.jdField_a_of_type_JavaLangCharSequence = BaseApplicationImpl.a().getString(2131372125);
          paramView = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.OneyWayLBSFriendMsgNotifyCfg.name());
          if (paramView.length() > 0)
          {
            paramView = paramView.split("\\|");
            if (paramView.length >= 6)
            {
              localRecentBaseData.jdField_b_of_type_JavaLangString = paramView[4];
              this.jdField_a_of_type_JavaLangCharSequence = paramView[5];
            }
          }
        }
        else
        {
          QQMessageFacade.Message localMessage = QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).a().a(localRecentBaseData.a(), localRecentBaseData.a());
          localObject = ContactUtils.o(QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity), localMessage.senderuin);
          paramView = (View)localObject;
          if (localObject == null) {
            paramView = "";
          }
          this.jdField_a_of_type_JavaLangCharSequence = (paramView + ": " + QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).a().a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity, localMessage, false));
        }
      }
    }
    if (localRecentBaseData.a() == 1)
    {
      paramView = QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).a().a(localRecentBaseData.a(), localRecentBaseData.a());
      paramView = QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).a().b(paramView.frienduin, paramView.istroop, paramView.uniseq);
      if ((!(paramView instanceof MessageForPubAccount)) || (((MessageForPubAccount)paramView).isTextMsg())) {}
    }
    for (paramView = PublicAccountConfigUtil.a(QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity), BaseApplicationImpl.getContext()) + ":";; paramView = "")
    {
      this.jdField_a_of_type_JavaLangCharSequence = (paramView + localRecentBaseData.jdField_b_of_type_JavaLangCharSequence);
      if (localRecentBaseData.a() == 7220)
      {
        paramView = ((KandianMergeManager)QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).getManager(161)).b();
        this.jdField_a_of_type_JavaLangCharSequence = QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).a().a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity, paramView, false);
      }
      localmdo.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-4210755);
      localmdo.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      break;
      label1623:
      paramView = ((QCallCardManager)QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).getManager(139)).a(localRecentBaseData.a());
      if (paramView == null) {
        break label503;
      }
      localRecentBaseData.jdField_b_of_type_JavaLangString = paramView.nickname;
      break label503;
      label1664:
      localmdo.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setVisibility(0);
      CustomWidgetUtil.a(localmdo.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, 3, j + i, 0);
      break label716;
      label1691:
      break label640;
      label1694:
      paramView = null;
      break label490;
    }
  }
  
  public int getViewTypeCount()
  {
    return 5;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mdl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
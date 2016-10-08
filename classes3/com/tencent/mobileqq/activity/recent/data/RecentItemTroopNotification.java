package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.contact.troop.TroopNotificationUtils;
import com.tencent.mobileqq.activity.recent.TimeManager;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RecommendTroopManagerImp;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.systemmsg.GroupSystemMsgController;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import java.util.List;
import tencent.mobileim.structmsg.structmsg.StructMsg;

public class RecentItemTroopNotification
  extends RecentUserBaseData
{
  public RecentItemTroopNotification(RecentUser paramRecentUser)
  {
    super(paramRecentUser);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private boolean a(QQAppInterface paramQQAppInterface, Context paramContext, RecommendTroopManagerImp paramRecommendTroopManagerImp, MessageRecord paramMessageRecord)
  {
    if ((paramQQAppInterface == null) || (paramContext == null) || (paramRecommendTroopManagerImp == null) || (paramMessageRecord == null)) {
      return false;
    }
    this.jdField_b_of_type_Long = paramMessageRecord.time;
    if (paramMessageRecord.msgtype == 64497)
    {
      if (paramRecommendTroopManagerImp != null)
      {
        this.jdField_b_of_type_JavaLangCharSequence = (paramContext.getResources().getString(2131364620) + paramRecommendTroopManagerImp.a());
        return true;
      }
    }
    else if ((paramMessageRecord.msgtype == 64496) && (paramRecommendTroopManagerImp != null))
    {
      this.jdField_b_of_type_JavaLangCharSequence = paramRecommendTroopManagerImp.a();
      return true;
    }
    return false;
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((paramQQAppInterface == null) || (paramContext == null)) {}
    RecommendTroopManagerImp localRecommendTroopManagerImp;
    MessageRecord localMessageRecord;
    label65:
    Object localObject;
    do
    {
      return;
      super.a(paramQQAppInterface, paramContext);
      if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
        this.jdField_b_of_type_JavaLangString = paramContext.getString(2131367545);
      }
      localRecommendTroopManagerImp = (RecommendTroopManagerImp)paramQQAppInterface.getManager(21);
      this.H = TroopNotificationUtils.a(paramQQAppInterface);
      if (localRecommendTroopManagerImp == null) {
        break;
      }
      localMessageRecord = localRecommendTroopManagerImp.a();
      localObject = paramQQAppInterface.a().b(AppConstants.aw, 0);
    } while ((localObject == null) && (localMessageRecord == null));
    label126:
    int i;
    int j;
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = ((MessageForSystemMsg)((List)localObject).get(((List)localObject).size() - 1)).getSystemMsg();
      i = GroupSystemMsgController.a().a(paramQQAppInterface);
      j = RecommendTroopManagerImp.b(paramQQAppInterface);
      if ((localObject == null) || (i <= 0)) {
        break label340;
      }
      this.jdField_b_of_type_Long = ((structmsg.StructMsg)localObject).msg_time.get();
      this.jdField_b_of_type_JavaLangCharSequence = GroupSystemMsgController.a().a(paramQQAppInterface);
      i = 1;
    }
    for (;;)
    {
      label177:
      if ((this.jdField_b_of_type_Long > 0L) && (this.jdField_b_of_type_Long != 9223372036854775806L)) {
        this.jdField_c_of_type_JavaLangString = TimeManager.a().a(a(), this.jdField_b_of_type_Long);
      }
      if (i != 0)
      {
        this.a.jumpTabMode = 0;
        label228:
        if (!AppSetting.j) {
          break label494;
        }
        paramQQAppInterface = new StringBuilder(24);
        paramQQAppInterface.append(this.jdField_b_of_type_JavaLangString);
        if (this.H != 0) {
          break label496;
        }
      }
      for (;;)
      {
        if (this.jdField_c_of_type_JavaLangCharSequence != null) {
          paramQQAppInterface.append(this.jdField_c_of_type_JavaLangCharSequence + ",");
        }
        paramQQAppInterface.append(this.jdField_b_of_type_JavaLangCharSequence).append(',').append(this.jdField_c_of_type_JavaLangString);
        this.d = paramQQAppInterface.toString();
        return;
        localMessageRecord = null;
        break label65;
        localObject = GroupSystemMsgController.a().a();
        break label126;
        label340:
        if (j > 0)
        {
          if (!a(paramQQAppInterface, paramContext, localRecommendTroopManagerImp, localMessageRecord)) {
            break label561;
          }
          i = 0;
          break label177;
        }
        if ((localObject != null) && (localMessageRecord != null))
        {
          if (((structmsg.StructMsg)localObject).msg_time.get() > localMessageRecord.time)
          {
            this.jdField_b_of_type_Long = ((structmsg.StructMsg)localObject).msg_time.get();
            this.jdField_b_of_type_JavaLangCharSequence = GroupSystemMsgController.a().a(paramQQAppInterface);
            i = 1;
            break label177;
          }
          if (!a(paramQQAppInterface, paramContext, localRecommendTroopManagerImp, localMessageRecord)) {
            break label561;
          }
          i = 0;
          break label177;
        }
        if (localObject != null)
        {
          this.jdField_b_of_type_Long = ((structmsg.StructMsg)localObject).msg_time.get();
          this.jdField_b_of_type_JavaLangCharSequence = GroupSystemMsgController.a().a(paramQQAppInterface);
        }
        if ((localMessageRecord == null) || (!a(paramQQAppInterface, paramContext, localRecommendTroopManagerImp, localMessageRecord))) {
          break label561;
        }
        i = 0;
        break label177;
        this.a.jumpTabMode = 1;
        break label228;
        label494:
        break;
        label496:
        if (this.H == 1) {
          paramQQAppInterface.append("有一条未读");
        } else if (this.H == 2) {
          paramQQAppInterface.append("有两条未读");
        } else if (this.H > 0) {
          paramQQAppInterface.append("有").append(this.H).append("条未读");
        }
      }
      label561:
      i = 1;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\recent\data\RecentItemTroopNotification.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
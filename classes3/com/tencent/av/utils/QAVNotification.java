package com.tencent.av.utils;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.tencent.av.SessionMgr;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.SessionInfo.Anychat_Info;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.gaudio.GaInviteDialogActivity;
import com.tencent.av.guild.GuildMultiActivity;
import com.tencent.av.random.ui.RandomDoubleActivity;
import com.tencent.av.random.ui.RandomMultiActivity;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.MultiIncomingCallsActivity;
import com.tencent.av.ui.VideoInviteFull;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import hbm;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import mqq.app.MobileQQ;

public class QAVNotification
{
  public static final int a = 2130839263;
  static QAVNotification jdField_a_of_type_ComTencentAvUtilsQAVNotification;
  static final String jdField_a_of_type_JavaLangString = "QAVNotification";
  Notification jdField_a_of_type_AndroidAppNotification;
  NotificationManager jdField_a_of_type_AndroidAppNotificationManager;
  Context jdField_a_of_type_AndroidContentContext;
  RemoteViews jdField_a_of_type_AndroidWidgetRemoteViews;
  VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  NotificationStyleDiscover jdField_a_of_type_ComTencentAvUtilsNotificationStyleDiscover;
  hbm jdField_a_of_type_Hbm;
  Map jdField_a_of_type_JavaUtilMap;
  boolean jdField_a_of_type_Boolean;
  
  private QAVNotification(VideoAppInterface paramVideoAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidAppNotification = null;
    this.jdField_a_of_type_AndroidAppNotificationManager = null;
    this.jdField_a_of_type_AndroidWidgetRemoteViews = null;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Hbm = null;
    this.jdField_a_of_type_JavaUtilMap = new LinkedHashMap();
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      this.jdField_a_of_type_AndroidContentContext = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().getApplicationContext();
    }
    this.jdField_a_of_type_ComTencentAvUtilsNotificationStyleDiscover = new NotificationStyleDiscover(this.jdField_a_of_type_AndroidContentContext);
  }
  
  public static QAVNotification a(VideoAppInterface paramVideoAppInterface)
  {
    if ((jdField_a_of_type_ComTencentAvUtilsQAVNotification == null) && (paramVideoAppInterface != null)) {}
    try
    {
      if (jdField_a_of_type_ComTencentAvUtilsQAVNotification == null) {
        jdField_a_of_type_ComTencentAvUtilsQAVNotification = new QAVNotification(paramVideoAppInterface);
      }
      return jdField_a_of_type_ComTencentAvUtilsQAVNotification;
    }
    finally {}
  }
  
  public static void a(Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QAVNotification", 2, "cancelNotificationForce");
    }
    ((NotificationManager)paramContext.getSystemService("notification")).cancel(2130839263);
  }
  
  private void a(hbm paramhbm, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QAVNotification", 2, "addNotification " + paramhbm.jdField_a_of_type_Int + " " + paramhbm.jdField_b_of_type_JavaLangString);
    }
    if (this.jdField_a_of_type_AndroidAppNotification == null) {
      this.jdField_a_of_type_AndroidAppNotification = new Notification();
    }
    if (this.jdField_a_of_type_AndroidAppNotificationManager == null) {
      this.jdField_a_of_type_AndroidAppNotificationManager = ((NotificationManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("notification"));
    }
    if (this.jdField_a_of_type_AndroidWidgetRemoteViews == null) {
      this.jdField_a_of_type_AndroidWidgetRemoteViews = new RemoteViews(this.jdField_a_of_type_AndroidContentContext.getPackageName(), 2130903624);
    }
    if ((paramhbm.jdField_b_of_type_JavaLangString == null) || (this.jdField_a_of_type_AndroidAppNotificationManager == null) || (this.jdField_a_of_type_AndroidAppNotification == null) || (this.jdField_a_of_type_AndroidWidgetRemoteViews == null)) {
      return;
    }
    Object localObject1 = paramhbm.jdField_b_of_type_JavaLangString;
    int j = ((String)localObject1).length();
    int i;
    if (j >= 7)
    {
      localObject2 = paramhbm.jdField_b_of_type_JavaLangString.toCharArray();
      localObject1 = String.valueOf(localObject2[0]);
      i = 1;
      while (i < 5)
      {
        localObject1 = (String)localObject1 + String.valueOf(localObject2[i]);
        i += 1;
      }
      localObject1 = (String)localObject1 + "...";
    }
    Object localObject3 = "";
    switch (paramhbm.jdField_a_of_type_Int)
    {
    case 49: 
    case 50: 
    default: 
      label348:
      localObject1 = "";
      localObject2 = null;
      label354:
      i = SessionInfo.L;
      if ((localObject2 != null) && (paramBoolean))
      {
        ((Intent)localObject2).putExtra("MultiAVType", i);
        ((Intent)localObject2).putExtra("Fromwhere", "AVNotification");
        ((Intent)localObject2).addFlags(4194304);
        ((Intent)localObject2).addFlags(262144);
        if ((paramhbm.jdField_a_of_type_Int != 40) && (paramhbm.jdField_a_of_type_Int != 45) && (paramhbm.jdField_a_of_type_Int != 43)) {
          ((Intent)localObject2).addFlags(268435456);
        }
      }
      break;
    }
    for (Object localObject2 = PendingIntent.getActivity(this.jdField_a_of_type_AndroidContentContext, 0, (Intent)localObject2, 134217728);; localObject2 = null)
    {
      if (this.jdField_a_of_type_ComTencentAvUtilsNotificationStyleDiscover.b() > 0.0F) {
        this.jdField_a_of_type_AndroidWidgetRemoteViews.setFloat(2131299483, "setTextSize", this.jdField_a_of_type_ComTencentAvUtilsNotificationStyleDiscover.b());
      }
      if (this.jdField_a_of_type_ComTencentAvUtilsNotificationStyleDiscover.a() > 0.0F) {
        this.jdField_a_of_type_AndroidWidgetRemoteViews.setFloat(2131299484, "setTextSize", this.jdField_a_of_type_ComTencentAvUtilsNotificationStyleDiscover.a());
      }
      Object localObject4 = localObject3;
      if (localObject3 != null)
      {
        localObject4 = localObject3;
        if (i == 2)
        {
          localObject3 = ((String)localObject3).replace(this.jdField_a_of_type_AndroidContentContext.getString(2131368098), this.jdField_a_of_type_AndroidContentContext.getString(2131368099));
          localObject4 = localObject3;
          if (this.jdField_a_of_type_AndroidAppNotification.tickerText != null)
          {
            this.jdField_a_of_type_AndroidAppNotification.tickerText = this.jdField_a_of_type_AndroidAppNotification.tickerText.toString().replace(this.jdField_a_of_type_AndroidContentContext.getString(2131368098), this.jdField_a_of_type_AndroidContentContext.getString(2131368099));
            localObject4 = localObject3;
          }
        }
      }
      localObject3 = localObject1;
      if (localObject1 != null)
      {
        localObject3 = localObject1;
        if (i == 2) {
          localObject3 = ((String)localObject1).replace(this.jdField_a_of_type_AndroidContentContext.getString(2131368098), this.jdField_a_of_type_AndroidContentContext.getString(2131368099));
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("QAVNotification", 2, "addNotification() title: " + (String)localObject4 + ", state:" + (String)localObject3 + ", data.id:" + paramhbm.jdField_c_of_type_JavaLangString + ", data.name:" + paramhbm.jdField_b_of_type_JavaLangString + ", data.type: " + paramhbm.jdField_a_of_type_Int);
      }
      this.jdField_a_of_type_AndroidWidgetRemoteViews.setTextViewText(2131299483, (CharSequence)localObject4);
      this.jdField_a_of_type_AndroidWidgetRemoteViews.setTextViewText(2131299484, (CharSequence)localObject3);
      if (paramBoolean) {}
      try
      {
        if (paramhbm.jdField_a_of_type_AndroidGraphicsBitmap != null) {
          this.jdField_a_of_type_AndroidWidgetRemoteViews.setImageViewBitmap(2131299482, paramhbm.jdField_a_of_type_AndroidGraphicsBitmap);
        }
        this.jdField_a_of_type_AndroidAppNotification.flags = 2;
        this.jdField_a_of_type_AndroidAppNotification.contentView = this.jdField_a_of_type_AndroidWidgetRemoteViews;
        this.jdField_a_of_type_AndroidAppNotification.contentIntent = ((PendingIntent)localObject2);
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(true, this.jdField_a_of_type_AndroidAppNotification);
        this.jdField_a_of_type_AndroidAppNotificationManager.notify(2130839263, this.jdField_a_of_type_AndroidAppNotification);
        this.jdField_a_of_type_Hbm = paramhbm;
        paramhbm.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_Boolean = true;
        return;
      }
      catch (Exception paramhbm) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("QAVNotification", 2, "updateNotification", paramhbm);
      return;
      localObject2 = new Intent(this.jdField_a_of_type_AndroidContentContext, AVActivity.class);
      ((Intent)localObject2).putExtra("isDoubleVideoMeeting", true);
      ((Intent)localObject2).putExtra("sessionType", paramhbm.jdField_c_of_type_Int);
      ((Intent)localObject2).putExtra("GroupId", paramhbm.jdField_c_of_type_JavaLangString);
      localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131363508);
      this.jdField_a_of_type_AndroidAppNotification.tickerText = ((CharSequence)localObject1);
      this.jdField_a_of_type_AndroidWidgetRemoteViews.setImageViewResource(2131299485, 2130839263);
      this.jdField_a_of_type_AndroidAppNotification.icon = 2130839263;
      localObject3 = localObject1;
      break label354;
      localObject2 = new Intent(this.jdField_a_of_type_AndroidContentContext, VideoInviteFull.class);
      localObject3 = this.jdField_a_of_type_AndroidContentContext.getString(2131363319);
      localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131363433);
      this.jdField_a_of_type_AndroidAppNotification.tickerText = ((CharSequence)localObject1);
      this.jdField_a_of_type_AndroidWidgetRemoteViews.setImageViewResource(2131299485, 2130839263);
      this.jdField_a_of_type_AndroidAppNotification.icon = 2130839263;
      break label354;
      localObject2 = new Intent(this.jdField_a_of_type_AndroidContentContext, AVActivity.class);
      ((Intent)localObject2).putExtra("sessionType", paramhbm.jdField_c_of_type_Int);
      ((Intent)localObject2).putExtra("uin", paramhbm.jdField_c_of_type_JavaLangString);
      localObject3 = this.jdField_a_of_type_AndroidContentContext.getString(2131363319);
      localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131363507);
      this.jdField_a_of_type_AndroidAppNotification.tickerText = ((CharSequence)localObject1);
      this.jdField_a_of_type_AndroidWidgetRemoteViews.setImageViewResource(2131299485, 2130839263);
      this.jdField_a_of_type_AndroidAppNotification.icon = 2130839263;
      break label354;
      localObject2 = new Intent(this.jdField_a_of_type_AndroidContentContext, AVActivity.class);
      ((Intent)localObject2).putExtra("sessionType", paramhbm.jdField_c_of_type_Int);
      ((Intent)localObject2).putExtra("uin", paramhbm.jdField_c_of_type_JavaLangString);
      localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131363508);
      this.jdField_a_of_type_AndroidAppNotification.tickerText = ((CharSequence)localObject1);
      this.jdField_a_of_type_AndroidWidgetRemoteViews.setImageViewResource(2131299485, 2130839263);
      this.jdField_a_of_type_AndroidAppNotification.icon = 2130839263;
      localObject3 = localObject1;
      break label354;
      localObject2 = new Intent(this.jdField_a_of_type_AndroidContentContext, VideoInviteFull.class);
      ((Intent)localObject2).addFlags(4194304);
      ((Intent)localObject2).addFlags(262144);
      localObject3 = this.jdField_a_of_type_AndroidContentContext.getString(2131363549);
      localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131363367);
      this.jdField_a_of_type_AndroidAppNotification.tickerText = ((CharSequence)localObject1);
      this.jdField_a_of_type_AndroidWidgetRemoteViews.setImageViewResource(2131299485, 2130839140);
      this.jdField_a_of_type_AndroidAppNotification.icon = 2130839140;
      break label354;
      localObject2 = new Intent(this.jdField_a_of_type_AndroidContentContext, AVActivity.class);
      ((Intent)localObject2).putExtra("sessionType", paramhbm.jdField_c_of_type_Int);
      ((Intent)localObject2).putExtra("GroupId", paramhbm.jdField_c_of_type_JavaLangString);
      localObject3 = this.jdField_a_of_type_AndroidContentContext.getString(2131363549);
      localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131363507);
      this.jdField_a_of_type_AndroidAppNotification.tickerText = ((CharSequence)localObject1);
      this.jdField_a_of_type_AndroidWidgetRemoteViews.setImageViewResource(2131299485, 2130839140);
      this.jdField_a_of_type_AndroidAppNotification.icon = 2130839140;
      break label354;
      localObject2 = new Intent(this.jdField_a_of_type_AndroidContentContext, AVActivity.class);
      ((Intent)localObject2).putExtra("sessionType", paramhbm.jdField_c_of_type_Int);
      ((Intent)localObject2).putExtra("GroupId", paramhbm.jdField_c_of_type_JavaLangString);
      localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131363509);
      this.jdField_a_of_type_AndroidAppNotification.tickerText = ((CharSequence)localObject1);
      this.jdField_a_of_type_AndroidWidgetRemoteViews.setImageViewResource(2131299485, 2130839140);
      this.jdField_a_of_type_AndroidAppNotification.icon = 2130839140;
      localObject3 = localObject1;
      break label354;
      localObject2 = new Intent(this.jdField_a_of_type_AndroidContentContext, GaInviteDialogActivity.class);
      if (paramhbm.jdField_b_of_type_Int == 3000)
      {
        localObject3 = this.jdField_a_of_type_AndroidContentContext.getString(2131363439);
        label1536:
        ((Intent)localObject2).putExtra("sessionType", paramhbm.jdField_c_of_type_Int);
        localObject4 = this.jdField_a_of_type_AndroidContentContext.getString(2131363387);
        if (j < 7) {
          break label1663;
        }
        this.jdField_a_of_type_AndroidAppNotification.tickerText = ((String)localObject1 + (String)localObject4);
      }
      for (localObject1 = (String)localObject1 + (String)localObject4;; localObject1 = paramhbm.jdField_b_of_type_JavaLangString + (String)localObject4)
      {
        this.jdField_a_of_type_AndroidWidgetRemoteViews.setImageViewResource(2131299485, 2130839140);
        this.jdField_a_of_type_AndroidAppNotification.icon = 2130839140;
        break;
        if (paramhbm.jdField_b_of_type_Int != 1) {
          break label1536;
        }
        localObject3 = this.jdField_a_of_type_AndroidContentContext.getString(2131363440);
        break label1536;
        label1663:
        this.jdField_a_of_type_AndroidAppNotification.tickerText = (paramhbm.jdField_b_of_type_JavaLangString + (String)localObject4);
      }
      localObject2 = new Intent(this.jdField_a_of_type_AndroidContentContext, AVActivity.class);
      ((Intent)localObject2).putExtra("GroupId", paramhbm.jdField_c_of_type_JavaLangString);
      ((Intent)localObject2).putExtra("Type", 2);
      ((Intent)localObject2).putExtra("sessionType", 3);
      ((Intent)localObject2).putExtra("uinType", paramhbm.jdField_b_of_type_Int);
      ((Intent)localObject2).putExtra("sessionType", paramhbm.jdField_c_of_type_Int);
      if (paramhbm.jdField_b_of_type_Int == 3000) {
        localObject3 = this.jdField_a_of_type_AndroidContentContext.getString(2131363513);
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidAppNotification.tickerText = ((CharSequence)localObject3);
        this.jdField_a_of_type_AndroidWidgetRemoteViews.setImageViewResource(2131299485, 2130839140);
        this.jdField_a_of_type_AndroidAppNotification.icon = 2130839140;
        localObject1 = localObject3;
        break;
        if (paramhbm.jdField_b_of_type_Int == 1) {
          localObject3 = this.jdField_a_of_type_AndroidContentContext.getString(2131363514);
        }
      }
      if (paramhbm.jdField_c_of_type_Int == 1) {}
      for (localObject1 = new Intent(this.jdField_a_of_type_AndroidContentContext, RandomDoubleActivity.class);; localObject1 = new Intent(this.jdField_a_of_type_AndroidContentContext, RandomMultiActivity.class))
      {
        ((Intent)localObject1).putExtra("sessionType", paramhbm.jdField_c_of_type_Int);
        ((Intent)localObject1).putExtra("GroupId", paramhbm.jdField_c_of_type_JavaLangString);
        ((Intent)localObject1).putExtra("uinType", paramhbm.jdField_b_of_type_Int);
        this.jdField_a_of_type_AndroidWidgetRemoteViews.setImageViewResource(2131299482, 2130839235);
        localObject3 = this.jdField_a_of_type_AndroidContentContext.getString(2131363813);
        localObject4 = this.jdField_a_of_type_AndroidContentContext.getString(2131363814);
        this.jdField_a_of_type_AndroidAppNotification.tickerText = this.jdField_a_of_type_AndroidContentContext.getString(2131363817);
        this.jdField_a_of_type_AndroidWidgetRemoteViews.setImageViewResource(2131299485, 2130839140);
        this.jdField_a_of_type_AndroidAppNotification.icon = 2130839140;
        localObject2 = localObject1;
        localObject1 = localObject4;
        break;
        if (paramhbm.jdField_c_of_type_Int != 3) {
          break label2046;
        }
      }
      label2046:
      if (!QLog.isColorLevel()) {
        break label348;
      }
      QLog.e("QAVNotification", 2, "FLAG_RANDOM_MATCHING with wrong notifaction argument");
      localObject1 = "";
      localObject2 = null;
      break label354;
      if (paramhbm.jdField_c_of_type_Int == 1) {}
      for (localObject1 = new Intent(this.jdField_a_of_type_AndroidContentContext, RandomDoubleActivity.class);; localObject1 = new Intent(this.jdField_a_of_type_AndroidContentContext, RandomMultiActivity.class))
      {
        ((Intent)localObject1).putExtra("sessionType", paramhbm.jdField_c_of_type_Int);
        ((Intent)localObject1).putExtra("GroupId", paramhbm.jdField_c_of_type_JavaLangString);
        ((Intent)localObject1).putExtra("uinType", paramhbm.jdField_b_of_type_Int);
        this.jdField_a_of_type_AndroidWidgetRemoteViews.setImageViewResource(2131299482, 2130839235);
        localObject3 = this.jdField_a_of_type_AndroidContentContext.getString(2131363811);
        this.jdField_a_of_type_AndroidAppNotification.tickerText = ((CharSequence)localObject3);
        this.jdField_a_of_type_AndroidWidgetRemoteViews.setImageViewResource(2131299485, 2130839140);
        this.jdField_a_of_type_AndroidAppNotification.icon = 2130839140;
        localObject2 = localObject1;
        localObject1 = "";
        break;
        if (paramhbm.jdField_c_of_type_Int != 3) {
          break label2220;
        }
      }
      label2220:
      if (!QLog.isColorLevel()) {
        break label348;
      }
      QLog.e("QAVNotification", 2, "FLAG_RANDOM_CHATTING with wrong notifaction argument");
      localObject1 = "";
      localObject2 = null;
      break label354;
      if (paramhbm.jdField_c_of_type_Int == 1)
      {
        localObject2 = new Intent(this.jdField_a_of_type_AndroidContentContext, RandomDoubleActivity.class);
        ((Intent)localObject2).putExtra("sessionType", paramhbm.jdField_c_of_type_Int);
        ((Intent)localObject2).putExtra("uinType", paramhbm.jdField_b_of_type_Int);
        this.jdField_a_of_type_AndroidWidgetRemoteViews.setImageViewResource(2131299482, 2130839235);
        localObject3 = this.jdField_a_of_type_AndroidContentContext.getString(2131363813);
        localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131363812);
        this.jdField_a_of_type_AndroidAppNotification.tickerText = ((CharSequence)localObject3);
        this.jdField_a_of_type_AndroidWidgetRemoteViews.setImageViewResource(2131299485, 2130839140);
        this.jdField_a_of_type_AndroidWidgetRemoteViews.setTextViewText(2131299484, (CharSequence)localObject1);
        this.jdField_a_of_type_AndroidAppNotification.icon = 2130839140;
        break label354;
      }
      if (!QLog.isColorLevel()) {
        break label348;
      }
      QLog.e("QAVNotification", 2, "FLAG_RANDOM_CLOSE_BY_FRIEND with wrong notifaction argument");
      localObject1 = "";
      localObject2 = null;
      break label354;
      if (paramhbm.jdField_c_of_type_Int == 3)
      {
        localObject2 = new Intent(this.jdField_a_of_type_AndroidContentContext, GuildMultiActivity.class);
        ((Intent)localObject2).putExtra("sessionType", paramhbm.jdField_c_of_type_Int);
        ((Intent)localObject2).putExtra("GroupId", paramhbm.jdField_c_of_type_JavaLangString);
        ((Intent)localObject2).putExtra("uinType", paramhbm.jdField_b_of_type_Int);
        this.jdField_a_of_type_AndroidWidgetRemoteViews.setImageViewResource(2131299482, 2130839165);
        if ((paramhbm.jdField_a_of_type_Int != 58) && (paramhbm.jdField_a_of_type_Int != 59)) {
          break label2575;
        }
        i = 1;
        label2494:
        if (i == 0) {
          break label2581;
        }
      }
      label2575:
      label2581:
      for (i = 2131363815;; i = 2131363811)
      {
        localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(i);
        this.jdField_a_of_type_AndroidAppNotification.tickerText = ((CharSequence)localObject1);
        this.jdField_a_of_type_AndroidWidgetRemoteViews.setImageViewResource(2131299485, 2130839140);
        this.jdField_a_of_type_AndroidAppNotification.icon = 2130839140;
        localObject3 = localObject1;
        break label354;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("QAVNotification", 2, "FLAG_GUILD_CHATTING with wrong notifaction argument");
        localObject1 = "";
        localObject2 = null;
        break label354;
        i = 0;
        break label2494;
      }
      localObject2 = new Intent(this.jdField_a_of_type_AndroidContentContext, MultiIncomingCallsActivity.class);
      localObject3 = this.jdField_a_of_type_AndroidContentContext.getString(2131363549);
      localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131363367);
      this.jdField_a_of_type_AndroidAppNotification.tickerText = ((CharSequence)localObject1);
      this.jdField_a_of_type_AndroidWidgetRemoteViews.setImageViewResource(2131299485, 2130839140);
      this.jdField_a_of_type_AndroidAppNotification.icon = 2130839140;
      break label354;
      localObject2 = new Intent(this.jdField_a_of_type_AndroidContentContext, MultiIncomingCallsActivity.class);
      localObject3 = this.jdField_a_of_type_AndroidContentContext.getString(2131363319);
      localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131363433);
      this.jdField_a_of_type_AndroidAppNotification.tickerText = ((CharSequence)localObject1);
      this.jdField_a_of_type_AndroidWidgetRemoteViews.setImageViewResource(2131299485, 2130839263);
      this.jdField_a_of_type_AndroidAppNotification.icon = 2130839263;
      break label354;
      localObject2 = new Intent(this.jdField_a_of_type_AndroidContentContext, MultiIncomingCallsActivity.class);
      if (paramhbm.jdField_b_of_type_Int == 3000)
      {
        localObject3 = this.jdField_a_of_type_AndroidContentContext.getString(2131363439);
        label2771:
        ((Intent)localObject2).putExtra("sessionType", paramhbm.jdField_c_of_type_Int);
        localObject4 = this.jdField_a_of_type_AndroidContentContext.getString(2131363387);
        if (j < 7) {
          break label2898;
        }
        this.jdField_a_of_type_AndroidAppNotification.tickerText = ((String)localObject1 + (String)localObject4);
      }
      for (localObject1 = (String)localObject1 + (String)localObject4;; localObject1 = paramhbm.jdField_b_of_type_JavaLangString + (String)localObject4)
      {
        this.jdField_a_of_type_AndroidWidgetRemoteViews.setImageViewResource(2131299485, 2130839140);
        this.jdField_a_of_type_AndroidAppNotification.icon = 2130839140;
        break;
        if (paramhbm.jdField_b_of_type_Int != 1) {
          break label2771;
        }
        localObject3 = this.jdField_a_of_type_AndroidContentContext.getString(2131363440);
        break label2771;
        label2898:
        this.jdField_a_of_type_AndroidAppNotification.tickerText = (paramhbm.jdField_b_of_type_JavaLangString + (String)localObject4);
      }
    }
  }
  
  private boolean c(String paramString)
  {
    if ((this.jdField_a_of_type_Hbm == null) || (!this.jdField_a_of_type_Boolean)) {}
    while (!TextUtils.equals(paramString, this.jdField_a_of_type_Hbm.jdField_a_of_type_JavaLangString)) {
      return false;
    }
    return true;
  }
  
  public void a()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("QAVNotification", 2, "cancelNotificationEx mIsActive: " + this.jdField_a_of_type_Boolean);
      }
      if (this.jdField_a_of_type_Boolean)
      {
        if (this.jdField_a_of_type_AndroidAppNotificationManager != null) {
          this.jdField_a_of_type_AndroidAppNotificationManager.cancel(2130839263);
        }
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(false, null);
        this.jdField_a_of_type_Hbm = null;
        this.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_JavaUtilMap.clear();
        this.jdField_a_of_type_AndroidAppNotificationManager = null;
        this.jdField_a_of_type_AndroidAppNotification = null;
        this.jdField_a_of_type_AndroidWidgetRemoteViews = null;
      }
      return;
    }
    finally {}
  }
  
  public void a(String paramString)
  {
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("QAVNotification", 2, "cancelNotification mIsActive: " + this.jdField_a_of_type_Boolean + ", sessionId:" + paramString);
        }
        if (c(paramString))
        {
          this.jdField_a_of_type_AndroidAppNotificationManager.cancel(2130839263);
          this.jdField_a_of_type_JavaUtilMap.remove(paramString);
          this.jdField_a_of_type_Hbm = null;
          this.jdField_a_of_type_Boolean = false;
          if (!this.jdField_a_of_type_JavaUtilMap.isEmpty())
          {
            paramString = this.jdField_a_of_type_JavaUtilMap.values().iterator();
            if (paramString.hasNext()) {
              a((hbm)paramString.next(), true);
            }
            return;
          }
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(false, null);
          continue;
        }
        this.jdField_a_of_type_JavaUtilMap.remove(paramString);
      }
      finally {}
    }
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("QAVNotification", 2, "updateNotification mIsActive: " + this.jdField_a_of_type_Boolean + ", SessionType: " + paramInt + ", time: " + paramString2);
      }
      if (!c(paramString1)) {
        if (QLog.isColorLevel()) {
          QLog.d("QAVNotification", 2, "session : " + paramString1 + " is not active");
        }
      }
      for (;;)
      {
        return;
        paramString1 = SessionMgr.a().a(paramString1);
        if (((paramString1 == null) || (paramString1.a.jdField_b_of_type_Int != 4)) && (this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidAppNotification != null))
        {
          if (this.jdField_a_of_type_Hbm.jdField_b_of_type_Int != 1011) {
            break;
          }
          this.jdField_a_of_type_AndroidWidgetRemoteViews.setTextViewText(2131299484, paramString2);
          try
          {
            this.jdField_a_of_type_AndroidAppNotificationManager.notify(2130839263, this.jdField_a_of_type_AndroidAppNotification);
          }
          catch (Exception paramString1) {}
          if (QLog.isColorLevel()) {
            QLog.d("QAVNotification", 2, "notify Notification ", paramString1);
          }
        }
      }
      switch (paramInt)
      {
      }
    }
    finally {}
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetRemoteViews.setTextViewText(2131299484, paramString2);
      try
      {
        this.jdField_a_of_type_AndroidAppNotificationManager.notify(2130839263, this.jdField_a_of_type_AndroidAppNotification);
      }
      catch (Exception paramString1) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("QAVNotification", 2, "notify Notification", paramString1);
      break;
      paramString1 = this.jdField_a_of_type_AndroidContentContext.getString(2131363509);
      this.jdField_a_of_type_AndroidAppNotification.tickerText = paramString1;
      this.jdField_a_of_type_AndroidWidgetRemoteViews.setTextViewText(2131299483, paramString1);
      continue;
      paramString1 = this.jdField_a_of_type_AndroidContentContext.getString(2131363508);
      this.jdField_a_of_type_AndroidAppNotification.tickerText = paramString1;
      this.jdField_a_of_type_AndroidWidgetRemoteViews.setTextViewText(2131299483, paramString1);
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("QAVNotification", 2, "changeNotificationSessionId " + paramString1 + " to " + paramString2);
      }
      hbm localhbm = (hbm)this.jdField_a_of_type_JavaUtilMap.get(paramString1);
      if (localhbm != null)
      {
        this.jdField_a_of_type_JavaUtilMap.remove(paramString1);
        this.jdField_a_of_type_JavaUtilMap.put(paramString2, localhbm);
      }
      return;
    }
    finally {}
  }
  
  /* Error */
  public void a(String paramString1, String paramString2, android.graphics.Bitmap paramBitmap, String paramString3, int paramInt1, int paramInt2, int paramInt3)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 80	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +83 -> 88
    //   8: ldc 11
    //   10: iconst_2
    //   11: new 105	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   18: ldc_w 443
    //   21: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: aload_1
    //   25: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: ldc_w 445
    //   31: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: aload_2
    //   35: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: ldc_w 447
    //   41: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: aload 4
    //   46: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: ldc_w 449
    //   52: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: iload 5
    //   57: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   60: ldc_w 451
    //   63: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: iload 6
    //   68: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   71: ldc_w 453
    //   74: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: iload 7
    //   79: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   82: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   85: invokestatic 86	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   88: aload_1
    //   89: invokestatic 456	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   92: ifne +56 -> 148
    //   95: aload_0
    //   96: aload_1
    //   97: invokespecial 372	com/tencent/av/utils/QAVNotification:c	(Ljava/lang/String;)Z
    //   100: ifeq +51 -> 151
    //   103: aload_0
    //   104: getfield 44	com/tencent/av/utils/QAVNotification:jdField_a_of_type_Hbm	Lhbm;
    //   107: astore_2
    //   108: aload_2
    //   109: aload_1
    //   110: putfield 349	hbm:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   113: aload_2
    //   114: aload_3
    //   115: putfield 242	hbm:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   118: aload_2
    //   119: iload 5
    //   121: putfield 116	hbm:jdField_a_of_type_Int	I
    //   124: aload_2
    //   125: aload 4
    //   127: putfield 231	hbm:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   130: aload_2
    //   131: iload 6
    //   133: putfield 310	hbm:jdField_b_of_type_Int	I
    //   136: aload_2
    //   137: iload 7
    //   139: putfield 284	hbm:jdField_c_of_type_Int	I
    //   142: aload_0
    //   143: aload_2
    //   144: iconst_0
    //   145: invokespecial 400	com/tencent/av/utils/QAVNotification:a	(Lhbm;Z)V
    //   148: aload_0
    //   149: monitorexit
    //   150: return
    //   151: new 114	hbm
    //   154: dup
    //   155: aload_0
    //   156: aload_1
    //   157: aload_2
    //   158: aload_3
    //   159: aload 4
    //   161: iload 5
    //   163: iload 6
    //   165: iload 7
    //   167: invokespecial 459	hbm:<init>	(Lcom/tencent/av/utils/QAVNotification;Ljava/lang/String;Ljava/lang/String;Landroid/graphics/Bitmap;Ljava/lang/String;III)V
    //   170: astore_2
    //   171: aload_0
    //   172: getfield 49	com/tencent/av/utils/QAVNotification:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   175: aload_1
    //   176: aload_2
    //   177: invokeinterface 440 3 0
    //   182: pop
    //   183: aload_0
    //   184: aload_2
    //   185: iconst_1
    //   186: invokespecial 400	com/tencent/av/utils/QAVNotification:a	(Lhbm;Z)V
    //   189: goto -41 -> 148
    //   192: astore_1
    //   193: aload_0
    //   194: monitorexit
    //   195: aload_1
    //   196: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	197	0	this	QAVNotification
    //   0	197	1	paramString1	String
    //   0	197	2	paramString2	String
    //   0	197	3	paramBitmap	android.graphics.Bitmap
    //   0	197	4	paramString3	String
    //   0	197	5	paramInt1	int
    //   0	197	6	paramInt2	int
    //   0	197	7	paramInt3	int
    // Exception table:
    //   from	to	target	type
    //   2	88	192	finally
    //   88	148	192	finally
    //   151	189	192	finally
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  /* Error */
  public boolean a(String paramString)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: invokestatic 80	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7: ifeq +42 -> 49
    //   10: ldc 11
    //   12: iconst_2
    //   13: new 105	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   20: ldc_w 461
    //   23: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: aload_0
    //   27: getfield 42	com/tencent/av/utils/QAVNotification:jdField_a_of_type_Boolean	Z
    //   30: invokevirtual 360	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   33: ldc_w 370
    //   36: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: aload_1
    //   40: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   46: invokestatic 86	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   49: aload_0
    //   50: aload_1
    //   51: invokespecial 372	com/tencent/av/utils/QAVNotification:c	(Ljava/lang/String;)Z
    //   54: ifeq +34 -> 88
    //   57: aload_0
    //   58: getfield 44	com/tencent/av/utils/QAVNotification:jdField_a_of_type_Hbm	Lhbm;
    //   61: iconst_1
    //   62: putfield 265	hbm:jdField_a_of_type_Boolean	Z
    //   65: aload_0
    //   66: getfield 34	com/tencent/av/utils/QAVNotification:jdField_a_of_type_AndroidAppNotificationManager	Landroid/app/NotificationManager;
    //   69: ldc 7
    //   71: invokevirtual 100	android/app/NotificationManager:cancel	(I)V
    //   74: aload_0
    //   75: aconst_null
    //   76: putfield 44	com/tencent/av/utils/QAVNotification:jdField_a_of_type_Hbm	Lhbm;
    //   79: aload_0
    //   80: iconst_0
    //   81: putfield 42	com/tencent/av/utils/QAVNotification:jdField_a_of_type_Boolean	Z
    //   84: aload_0
    //   85: monitorexit
    //   86: iload_2
    //   87: ireturn
    //   88: iconst_0
    //   89: istore_2
    //   90: goto -6 -> 84
    //   93: astore_1
    //   94: aload_0
    //   95: monitorexit
    //   96: aload_1
    //   97: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	98	0	this	QAVNotification
    //   0	98	1	paramString	String
    //   1	89	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   4	49	93	finally
    //   49	84	93	finally
  }
  
  /* Error */
  public boolean b(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 80	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +29 -> 34
    //   8: ldc 11
    //   10: iconst_2
    //   11: new 105	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   18: ldc_w 463
    //   21: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: aload_1
    //   25: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   31: invokestatic 86	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   34: aload_0
    //   35: getfield 49	com/tencent/av/utils/QAVNotification:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   38: aload_1
    //   39: invokeinterface 436 2 0
    //   44: checkcast 114	hbm
    //   47: astore_1
    //   48: aload_1
    //   49: ifnull +29 -> 78
    //   52: aload_1
    //   53: getfield 265	hbm:jdField_a_of_type_Boolean	Z
    //   56: ifeq +22 -> 78
    //   59: aload_0
    //   60: getfield 42	com/tencent/av/utils/QAVNotification:jdField_a_of_type_Boolean	Z
    //   63: ifne +15 -> 78
    //   66: aload_0
    //   67: aload_1
    //   68: iconst_1
    //   69: invokespecial 400	com/tencent/av/utils/QAVNotification:a	(Lhbm;Z)V
    //   72: iconst_1
    //   73: istore_2
    //   74: aload_0
    //   75: monitorexit
    //   76: iload_2
    //   77: ireturn
    //   78: iconst_0
    //   79: istore_2
    //   80: goto -6 -> 74
    //   83: astore_1
    //   84: aload_0
    //   85: monitorexit
    //   86: aload_1
    //   87: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	88	0	this	QAVNotification
    //   0	88	1	paramString	String
    //   73	7	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	34	83	finally
    //   34	48	83	finally
    //   52	72	83	finally
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\utils\QAVNotification.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.tencent.mobileqq.activity.aio.tips;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.FragmentActivity;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.arrange.op.MeetingInfo;
import com.tencent.av.app.PstnSessionInfo;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.gaudio.AVNotifyCenter.UserInfo;
import com.tencent.av.gaudio.AVNotifyCenter.VideoRoomInfo;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.av.ui.CallbackWaitingActivityExt;
import com.tencent.av.ui.MultiVideoEnterPageActivity;
import com.tencent.av.utils.GVideoUpdateUtil;
import com.tencent.av.utils.PstnUtils;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import mqq.os.MqqHandler;
import ofc;
import ofd;
import ofe;

public class VideoStatusTipsBar
  implements View.OnClickListener, TipsBarTask
{
  public static final int a = 0;
  private static final String jdField_a_of_type_JavaLangString = VideoStatusTipsBar.class.getSimpleName();
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 3;
  public static final int e = 4;
  protected float a;
  Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private TipsManager jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  private ofe jdField_a_of_type_Ofe;
  private ImageView[] jdField_a_of_type_ArrayOfAndroidWidgetImageView = new ImageView[3];
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public VideoStatusTipsBar(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, TipsManager paramTipsManager, Context paramContext, MqqHandler paramMqqHandler)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager = paramTipsManager;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_MqqOsMqqHandler = paramMqqHandler;
    this.jdField_a_of_type_Float = paramContext.getResources().getDisplayMetrics().density;
  }
  
  private int a(int paramInt)
  {
    int i = 0;
    switch (paramInt)
    {
    case 22: 
    default: 
      i = 3;
    case 20: 
    case 21: 
      return i;
    }
    return 2;
  }
  
  private void a(int paramInt1, String paramString, int paramInt2)
  {
    Object localObject1 = null;
    int i = 0;
    if (!NetworkUtil.e(this.jdField_a_of_type_AndroidContentContext.getApplicationContext())) {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 2131367256, 0).b(this.jdField_a_of_type_AndroidContentContext.getApplicationContext().getResources().getDimensionPixelSize(2131492908));
    }
    while (paramString == null) {
      return;
    }
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString);
    if ((paramInt2 == 2) && (!bool))
    {
      paramString = new HashMap();
      paramString.put("MultiAVType", String.valueOf(2));
      ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true, true, null, paramString);
      return;
    }
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, MultiVideoEnterPageActivity.class);
    localIntent.addFlags(262144);
    localIntent.addFlags(268435456);
    Object localObject2;
    if (paramInt1 == 3000)
    {
      ArrayList localArrayList = ((DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).a(paramString);
      if (localArrayList != null)
      {
        int j = localArrayList.size();
        localObject2 = new long[j];
        for (;;)
        {
          localObject1 = localObject2;
          if (i >= j) {
            break;
          }
          localObject1 = (DiscussionMemberInfo)localArrayList.get(i);
          if (localObject1 != null) {
            localObject2[i] = Long.valueOf(((DiscussionMemberInfo)localObject1).memberUin).longValue();
          }
          i += 1;
        }
      }
      localIntent.putExtra("DiscussUinList", (long[])localObject1);
    }
    localIntent.putExtra("sessionType", 3);
    localIntent.putExtra("uin", paramString);
    localIntent.putExtra("uinType", paramInt1);
    localIntent.putExtra("Type", 3);
    localIntent.putExtra("GroupId", paramString);
    Long.valueOf(paramString).longValue();
    localIntent.putExtra("MultiAVType", paramInt2);
    localIntent.putExtra("flag", bool);
    ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localIntent);
    paramInt1 = UITools.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramInt1, paramString);
    if (localObject1 != null)
    {
      localObject2 = new Bundle();
      ((Bundle)localObject2).putParcelable("meetingInfo", (Parcelable)localObject1);
      localIntent.putExtras((Bundle)localObject2);
      localIntent.putExtra("creator_nick", ContactUtils.i(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((MeetingInfo)localObject1).getCreator_uin()));
    }
    GVideoUpdateUtil.a(this.jdField_a_of_type_AndroidContentContext, paramString, paramInt2, new ofd(this, localIntent));
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_AndroidViewView = ((LayoutInflater)this.jdField_a_of_type_AndroidContentContext.getSystemService("layout_inflater")).inflate(2130903080, null);
      this.jdField_a_of_type_AndroidViewView.setId(2131296344);
      this.jdField_a_of_type_AndroidViewView.setPadding(0, (int)(this.jdField_a_of_type_Float * 2.0F), 0, (int)(this.jdField_a_of_type_Float * 2.0F));
      this.jdField_a_of_type_AndroidViewView.setClickable(true);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130838362);
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131296983));
      this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[0] = ((ImageView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131296984));
      this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[1] = ((ImageView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131296985));
      this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[2] = ((ImageView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131296986));
    }
  }
  
  public int a()
  {
    return 60;
  }
  
  protected Bitmap a(String paramString)
  {
    Bitmap localBitmap = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1, paramString, (byte)2, true, 0);
    paramString = localBitmap;
    if (localBitmap == null) {
      paramString = ImageUtil.a();
    }
    return paramString;
  }
  
  public View a(Object... paramVarArgs)
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  String a(Context paramContext, String paramString, TextView paramTextView, float paramFloat)
  {
    TextPaint localTextPaint = paramTextView.getPaint();
    paramTextView = paramString;
    if (paramFloat > 0.0F)
    {
      float f1 = localTextPaint.measureText(paramString);
      paramTextView = paramString;
      if (f1 > paramFloat)
      {
        float f2 = paramFloat - localTextPaint.measureText("...");
        paramFloat = f1;
        paramContext = paramString;
        while ((f2 > 0.0F) && (paramFloat > f2) && (paramContext.length() > 0))
        {
          paramTextView = paramContext.substring(0, paramContext.length() - 1);
          f1 = localTextPaint.measureText(paramTextView);
          paramContext = paramTextView;
          paramFloat = f1;
          if (f1 == 0.0F)
          {
            paramContext = paramTextView;
            paramFloat = f1;
            if (paramTextView.length() > 0)
            {
              paramFloat = 1.0F + f2;
              paramContext = paramTextView;
            }
          }
        }
        paramTextView = paramString;
        if (f2 > 0.0F)
        {
          paramTextView = paramString;
          if (paramContext.length() > 0) {
            paramTextView = paramContext + "...";
          }
        }
      }
    }
    return paramTextView;
  }
  
  public void a()
  {
    a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 4, 0L);
  }
  
  public void a(int paramInt1, String paramString, int paramInt2, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "refreshMultiVideoStatus():  uinType:" + paramInt1 + ", uin:" + paramString + ", type:" + paramInt2 + ",memberUin:" + paramLong);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 3000) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1)) {}
    for (;;)
    {
      if (b() == this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a()) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a();
      }
      return;
      try
      {
        l3 = Long.parseLong(paramString);
        k = UITools.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        l1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(k, l3);
        localVector = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(l3);
        paramInt1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(l3);
        if ((k == 1) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(k, l3)) && (paramString != null) && (TextUtils.isDigitsOnly(paramString)))
        {
          l2 = l1;
          i = paramInt2;
          try
          {
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(Long.parseLong(paramString));
            int j = paramInt1;
            l2 = l1;
            i = paramInt2;
            if (localObject1 != null)
            {
              l2 = l1;
              i = paramInt2;
              paramInt2 = a(((AVNotifyCenter.VideoRoomInfo)localObject1).c);
              l2 = l1;
              i = paramInt2;
              l1 = ((AVNotifyCenter.VideoRoomInfo)localObject1).jdField_a_of_type_Int;
              l2 = l1;
              i = paramInt2;
              j = ((AVNotifyCenter.VideoRoomInfo)localObject1).jdField_b_of_type_Int;
              i = paramInt2;
              l2 = l1;
            }
            l1 = l2;
            paramInt1 = j;
            paramInt2 = i;
          }
          catch (NumberFormatException localNumberFormatException2)
          {
            for (;;)
            {
              Object localObject1;
              MeetingInfo localMeetingInfo;
              TextView localTextView;
              ImageView localImageView1;
              ImageView localImageView2;
              Object localObject7;
              Object localObject5;
              Object localObject6;
              Object localObject3;
              Object localObject4;
              String str;
              if (QLog.isColorLevel()) {
                QLog.e(jdField_a_of_type_JavaLangString, 2, "refreshMultiVideoStatus error : " + localNumberFormatException2);
              }
              l1 = l2;
              paramInt2 = i;
              continue;
              this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_a_of_type_Ofe);
              continue;
              if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)
              {
                localObject2 = this.jdField_a_of_type_AndroidContentContext.getString(2131368022);
                continue;
                if (paramInt2 == 2)
                {
                  if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000)
                  {
                    localObject2 = this.jdField_a_of_type_AndroidContentContext.getString(2131368021);
                    continue;
                  }
                  if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)
                  {
                    localObject2 = this.jdField_a_of_type_AndroidContentContext.getString(2131368023);
                    continue;
                    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().e())
                    {
                      localObject4 = this.jdField_a_of_type_AndroidContentContext.getString(2131368028);
                      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().e(false);
                      localObject3 = str;
                      localObject2 = localObject4;
                      if (paramInt1 != 2) {
                        continue;
                      }
                      localTextView.setVisibility(8);
                      localObject3 = str;
                      localObject2 = localObject4;
                      continue;
                    }
                    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) {
                      localObject2 = this.jdField_a_of_type_AndroidContentContext.getString(2131368026);
                    }
                    for (;;)
                    {
                      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().e(true);
                      localObject2 = String.format((String)localObject2, new Object[] { Long.valueOf(l1) });
                      localTextView.setVisibility(0);
                      localObject3 = str;
                      break;
                      localObject2 = localObject3;
                      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) {
                        localObject2 = this.jdField_a_of_type_AndroidContentContext.getString(2131368027);
                      }
                    }
                    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) {
                      continue;
                    }
                    UITools.a(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_AndroidContentContext.getString(2131363386), paramInt1);
                    continue;
                    if (localMeetingInfo != null)
                    {
                      localObject3 = this.jdField_a_of_type_AndroidContentContext.getString(2131368016);
                      paramInt2 = 2;
                      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) {
                        paramInt2 = 1;
                      }
                      localObject2 = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMeetingInfo.getCreator_uin(), localMeetingInfo.getDiscuss_uin(), paramInt2, 0);
                      continue;
                    }
                    localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(k, l3);
                    if (localObject3 == null) {
                      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000)
                      {
                        localObject2 = this.jdField_a_of_type_AndroidContentContext.getString(2131368014);
                        str = String.format((String)localObject2, new Object[] { Long.valueOf(l1) });
                        localObject3 = localObject4;
                        localObject2 = str;
                        if (paramInt1 == 2)
                        {
                          localObject3 = localObject4;
                          localObject2 = str;
                          if (l1 >= 99L)
                          {
                            localObject2 = this.jdField_a_of_type_AndroidContentContext.getString(2131363961);
                            localObject3 = localObject4;
                          }
                        }
                      }
                    }
                    for (;;)
                    {
                      localTextView.setVisibility(8);
                      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000)
                      {
                        UITools.a(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_AndroidContentContext.getString(2131363577));
                        localObject4 = localObject2;
                        localObject2 = localObject3;
                        localObject3 = localObject4;
                        break;
                        localObject2 = localObject7;
                        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) {
                          break label1361;
                        }
                        localObject2 = this.jdField_a_of_type_AndroidContentContext.getString(2131368019);
                        break label1361;
                        if (((AVNotifyCenter.UserInfo)localObject3).jdField_a_of_type_Boolean)
                        {
                          localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((AVNotifyCenter.UserInfo)localObject3).jdField_a_of_type_Long);
                          if (localObject2 == null)
                          {
                            if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) {
                              localObject2 = this.jdField_a_of_type_AndroidContentContext.getString(2131368014);
                            }
                            for (;;)
                            {
                              str = String.format((String)localObject2, new Object[] { Long.valueOf(l1) });
                              localObject3 = localObject4;
                              localObject2 = str;
                              if (paramInt1 != 2) {
                                break;
                              }
                              localObject3 = localObject4;
                              localObject2 = str;
                              if (l1 < 99L) {
                                break;
                              }
                              localObject2 = this.jdField_a_of_type_AndroidContentContext.getString(2131363961);
                              localObject3 = localObject4;
                              break;
                              localObject2 = localObject5;
                              if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) {
                                localObject2 = this.jdField_a_of_type_AndroidContentContext.getString(2131368019);
                              }
                            }
                          }
                          if (l1 == 1L)
                          {
                            localObject4 = this.jdField_a_of_type_AndroidContentContext.getString(2131368015);
                            localObject3 = localObject2;
                            localObject2 = localObject4;
                            continue;
                          }
                          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) {
                            localObject3 = this.jdField_a_of_type_AndroidContentContext.getString(2131368013);
                          }
                          for (;;)
                          {
                            localObject4 = String.format((String)localObject3, new Object[] { Long.valueOf(l1) });
                            if ((paramInt1 != 2) || (l1 < 99L)) {
                              break label2359;
                            }
                            localObject4 = this.jdField_a_of_type_AndroidContentContext.getString(2131363962);
                            localObject3 = localObject2;
                            localObject2 = localObject4;
                            break;
                            localObject3 = localObject6;
                            if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) {
                              localObject3 = this.jdField_a_of_type_AndroidContentContext.getString(2131368018);
                            }
                          }
                        }
                        localObject3 = Long.toString(((AVNotifyCenter.UserInfo)localObject3).jdField_a_of_type_Long);
                        localObject4 = Long.toString(l3);
                        paramInt2 = 2;
                        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) {
                          paramInt2 = 1;
                        }
                        localObject4 = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject3, (String)localObject4, paramInt2, 0);
                        if (l1 == 1L)
                        {
                          localObject2 = this.jdField_a_of_type_AndroidContentContext.getString(2131368015);
                          localObject3 = localObject4;
                          continue;
                        }
                        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) {
                          localObject2 = this.jdField_a_of_type_AndroidContentContext.getString(2131368013);
                        }
                        for (;;)
                        {
                          str = String.format((String)localObject2, new Object[] { Long.valueOf(l1) });
                          localObject3 = localObject4;
                          localObject2 = str;
                          if (paramInt1 != 2) {
                            break;
                          }
                          localObject3 = localObject4;
                          localObject2 = str;
                          if (l1 < 99L) {
                            break;
                          }
                          localObject2 = this.jdField_a_of_type_AndroidContentContext.getString(2131363962);
                          localObject3 = localObject4;
                          break;
                          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) {
                            localObject2 = this.jdField_a_of_type_AndroidContentContext.getString(2131368018);
                          }
                        }
                      }
                      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) {
                        UITools.a(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_AndroidContentContext.getString(2131363578), paramInt1);
                      }
                      localObject4 = localObject2;
                      localObject2 = localObject3;
                      localObject3 = localObject4;
                      break;
                      if (localVector.size() == 1)
                      {
                        this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[0].setVisibility(0);
                        this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[1].setVisibility(8);
                        this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[2].setVisibility(8);
                        this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[0].setImageBitmap(a(String.valueOf(((AVNotifyCenter.UserInfo)localVector.get(0)).jdField_a_of_type_Long)));
                        localImageView1.setImageResource(2130838359);
                        if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.d()) {
                          break label2353;
                        }
                        if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(k, l3)) {
                          break label2347;
                        }
                        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().i() != 2) {
                          break label2341;
                        }
                      }
                      for (boolean bool = true;; bool = false)
                      {
                        a(bool);
                        return;
                        if (localVector.size() == 2)
                        {
                          this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[0].setVisibility(0);
                          this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[1].setVisibility(0);
                          this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[2].setVisibility(8);
                          this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[0].setImageBitmap(a(String.valueOf(((AVNotifyCenter.UserInfo)localVector.get(0)).jdField_a_of_type_Long)));
                          this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[1].setImageBitmap(a(String.valueOf(((AVNotifyCenter.UserInfo)localVector.get(1)).jdField_a_of_type_Long)));
                          break;
                        }
                        paramInt1 = 0;
                        while (paramInt1 < this.jdField_a_of_type_ArrayOfAndroidWidgetImageView.length)
                        {
                          this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[paramInt1].setVisibility(0);
                          this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[paramInt1].setImageBitmap(a(String.valueOf(((AVNotifyCenter.UserInfo)localVector.get(paramInt1)).jdField_a_of_type_Long)));
                          paramInt1 += 1;
                        }
                        break;
                        localImageView2.setImageResource(2130843019);
                        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
                        break;
                      }
                      a(true);
                      return;
                      a(true);
                      return;
                      localObject3 = localObject2;
                      localObject2 = localObject4;
                    }
                  }
                }
              }
              Object localObject2 = null;
            }
          }
          if ((paramInt1 == 10) || (paramInt1 == 2))
          {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(l3, paramInt1, (int)l1);
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(l3, paramInt1);
            i = 21;
            if (localObject1 != null)
            {
              if (((AVNotifyCenter.VideoRoomInfo)localObject1).jdField_a_of_type_Int <= 0) {
                i = 23;
              }
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(l3, paramInt1, i, ((AVNotifyCenter.VideoRoomInfo)localObject1).jdField_a_of_type_Int);
            }
          }
          localMeetingInfo = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(k, paramString);
          if ((localMeetingInfo == null) && (l1 <= 0L)) {
            continue;
          }
          c();
          localTextView = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131296981);
          localImageView1 = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131296982);
          localImageView2 = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131296979);
          localObject7 = null;
          localObject5 = null;
          localObject6 = null;
          localObject1 = null;
          localObject3 = null;
          localObject4 = null;
          str = null;
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(k, l3))
          {
            localObject4 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
            localObject1 = Long.toString(paramLong);
            if ((paramLong != 0L) && (!((String)localObject4).equals(Long.valueOf(paramLong))) && (paramInt1 != 2))
            {
              localObject3 = Long.toString(l3);
              i = 2;
              if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) {
                i = 1;
              }
              localObject3 = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject1, (String)localObject3, i, 0);
              if ((paramInt2 == 1) || (paramInt2 == 2))
              {
                if (this.jdField_a_of_type_Ofe != null) {
                  break label963;
                }
                this.jdField_a_of_type_Ofe = new ofe(this);
                if (this.jdField_a_of_type_MqqOsMqqHandler != null)
                {
                  this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(this.jdField_a_of_type_Ofe, 3000L);
                  this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().e(false);
                }
              }
              if (paramInt2 == 1) {
                if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000)
                {
                  localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131368020);
                  localTextView.setVisibility(8);
                  if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 3000) {
                    break label1227;
                  }
                  UITools.a(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_AndroidContentContext.getString(2131363385));
                  localImageView1.setVisibility(0);
                  localObject4 = localObject3;
                  localObject3 = localObject1;
                  localObject1 = localObject4;
                  paramInt2 = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131428268);
                  a((String)localObject1, (String)localObject3, paramInt2, String.valueOf(l3), paramInt1);
                  localTextView.setTextColor(paramInt2);
                  if ((paramInt1 != 2) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString))) {
                    break label2321;
                  }
                  localImageView2.setImageDrawable(null);
                  ReportController.b(null, "dc00899", "Grp_video", "", "notice", "exp_aio", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "" + TroopUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString), "", "");
                  this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
                  if ((localVector != null) && (localVector.size() != 0)) {
                    break label2038;
                  }
                  paramString = this.jdField_a_of_type_ArrayOfAndroidWidgetImageView;
                  paramInt2 = paramString.length;
                  paramInt1 = 0;
                  while (paramInt1 < paramInt2)
                  {
                    paramString[paramInt1].setVisibility(8);
                    paramInt1 += 1;
                  }
                }
              }
            }
          }
        }
      }
      catch (NumberFormatException localNumberFormatException1)
      {
        long l3;
        int k;
        long l1;
        Vector localVector;
        long l2;
        int i;
        label963:
        label1227:
        label1361:
        label2038:
        label2321:
        label2341:
        label2347:
        label2353:
        label2359:
        for (;;)
        {
          l3 = 0L;
        }
      }
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "refreshVideoStatus(): uinType:" + paramInt + ", peerUin:" + paramString1 + ",extraUin:" + paramString2);
    }
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(paramString1)) {
      i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramString1);
    }
    for (;;)
    {
      ImageView localImageView;
      TextView localTextView;
      if (((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.d()) && ((i == 1) || (i == 2) || (i == 5)) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == paramInt) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramString1)) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramString2)))) || ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(paramString1)) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramString1)))) {
        if (this.jdField_a_of_type_AndroidViewView == null)
        {
          this.jdField_a_of_type_AndroidViewView = ((LayoutInflater)this.jdField_a_of_type_AndroidContentContext.getSystemService("layout_inflater")).inflate(2130903080, null);
          this.jdField_a_of_type_AndroidViewView.setId(2131296344);
          this.jdField_a_of_type_AndroidViewView.setPadding(0, (int)(2.0F * this.jdField_a_of_type_Float), 0, (int)(2.0F * this.jdField_a_of_type_Float));
          this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130838362);
          this.jdField_a_of_type_AndroidViewView.setClickable(true);
          this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131296983));
          localImageView = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131296982);
          localTextView = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131296981);
          label304:
          this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().f() == null) {}
        }
      }
      try
      {
        Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().f());
        label371:
        String str;
        label433:
        boolean bool;
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(paramString1))
        {
          UITools.a(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_AndroidContentContext.getString(2131363665));
          str = "";
          if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(paramString1)) {
            break label696;
          }
          paramString2 = str;
          if (i == 1) {
            paramString2 = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131363665);
          }
          if (i != 2) {
            break label829;
          }
          paramString2 = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131363666);
          a(null, paramString2, this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131428268), paramString1, 0);
          this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
          this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130838362);
          localImageView.setImageResource(2130838359);
          localImageView.setVisibility(0);
          if ((!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.d()) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(paramString1))) {
            break label787;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().i() != 2) {
            break label781;
          }
          bool = true;
          label527:
          a(bool);
          label533:
          if ((!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.d()) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().e())) {
            break label795;
          }
          localTextView.setVisibility(0);
        }
        label696:
        label781:
        label787:
        label795:
        do
        {
          return;
          if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.d()) {
            break label832;
          }
          i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().g();
          break;
          localImageView = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131296982);
          localTextView = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131296981);
          break label304;
          if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.d()) {
            break label371;
          }
          if (paramInt == 1)
          {
            UITools.a(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_AndroidContentContext.getString(2131363373), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a()));
            break label371;
          }
          UITools.a(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_AndroidContentContext.getString(2131363373));
          break label371;
          paramString2 = str;
          if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.d()) {
            break label829;
          }
          if (i == 1)
          {
            paramString2 = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131363572);
            break label433;
          }
          if (i == 5)
          {
            paramString2 = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131364002);
            break label433;
          }
          paramString2 = str;
          if (i != 2) {
            break label829;
          }
          paramString2 = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131363573);
          break label433;
          bool = false;
          break label527;
          a(true);
          break label533;
          localTextView.setVisibility(8);
          return;
        } while (b() != this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a());
        this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a();
        return;
      }
      catch (Exception paramString2)
      {
        label829:
        for (;;) {}
        label832:
        i = 0;
      }
    }
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt != 1000) {}
    for (;;)
    {
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1))
      {
        a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 0, 0L);
        return;
      }
      paramInt = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().g();
      if (paramInt == 3)
      {
        if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
          a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 0, 0L);
        }
      }
      else {
        while ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
        {
          paramVarArgs = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(paramVarArgs))
          {
            paramInt = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramVarArgs);
            if (paramInt == 1) {
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800478C", "0X800478C", 0, 0, "", "", "", "");
            }
            if (paramInt == 2) {
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004788", "0X8004788", 0, 0, "", "", "", "");
            }
          }
          a(0, paramVarArgs, "");
          return;
          if ((paramInt == 1) || (paramInt == 2)) {
            a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().h(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().f(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().g());
          } else if (paramInt == 5) {
            a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().jdField_a_of_type_JavaLangString);
          }
        }
      }
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, String paramString3, int paramInt2)
  {
    LinearLayout localLinearLayout = (LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131296980);
    localLinearLayout.removeAllViews();
    if (paramString1 != null)
    {
      localTextView = new TextView(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
      localTextView.setId(2131296352);
      float f = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131493964);
      paramString1 = a(this.jdField_a_of_type_AndroidContentContext, paramString1, localTextView, f);
      localTextView.setTextSize(14.0F);
      localTextView.setTextColor(paramInt1);
      localTextView.setSingleLine();
      localTextView.setGravity(5);
      localTextView.setMaxWidth(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131493966));
      localTextView.setEllipsize(TextUtils.TruncateAt.END);
      localTextView.setText(paramString1);
      localLinearLayout.addView(localTextView);
    }
    TextView localTextView = new TextView(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
    localTextView.setTextSize(14.0F);
    localTextView.setTextColor(paramInt1);
    paramInt1 = paramInt2;
    if (paramInt2 == 0) {}
    try
    {
      paramInt1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(Long.valueOf(paramString3).longValue());
      paramString1 = paramString2;
      if (paramString2 != null)
      {
        paramString1 = (String)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c.get(paramString3);
        if (paramString1 == null) {
          break label392;
        }
        i = Integer.valueOf(paramString1.split(";")[0]).intValue();
        paramInt2 = Integer.valueOf(paramString1.split(";")[1]).intValue();
        if (i != 1) {
          break label351;
        }
        if (paramInt2 >= 99) {
          paramString1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131363960);
        }
      }
      else
      {
        localTextView.setText(paramString1);
        localTextView.setId(2131296479);
        localLinearLayout.addView(localTextView);
        return;
      }
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        int i;
        paramInt1 = 0;
        continue;
        paramString1 = String.format(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131363959), new Object[] { Integer.valueOf(paramInt2) });
        continue;
        label351:
        paramString1 = paramString2;
        if (paramInt1 == 2)
        {
          paramString1 = paramString2.replace(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131368098), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131368099));
          continue;
          label392:
          paramInt2 = 0;
          i = 0;
        }
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_AndroidContentContext != null) && ((this.jdField_a_of_type_AndroidContentContext instanceof FragmentActivity))) {}
    for (boolean bool = ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).isResume();; bool = false)
    {
      if ((paramBoolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager != null)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(this, new Object[0]);
      }
      SmallScreenUtils.a(this.jdField_a_of_type_AndroidViewView, paramBoolean, bool);
      return;
    }
  }
  
  public int[] a()
  {
    return null;
  }
  
  public int b()
  {
    return 2;
  }
  
  public void b()
  {
    a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 4, 0L);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    Object localObject;
    label373:
    label458:
    label577:
    label582:
    for (;;)
    {
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a()) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.d()))
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "startGroupAudio phone is calling!");
        }
        paramView = this.jdField_a_of_type_AndroidContentContext.getString(2131363529);
        localObject = this.jdField_a_of_type_AndroidContentContext.getString(2131363525);
        DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230, (String)localObject, paramView, 2131367262, 2131367263, new ofc(this), null).show();
        return;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 3000) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1)) {
        break;
      }
      int j = UITools.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      paramView = new HashMap();
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(l);
      int i;
      if (localObject != null)
      {
        i = ((AVNotifyCenter.VideoRoomInfo)localObject).jdField_b_of_type_Int;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(l, i);
        paramView.put("MultiAVType", String.valueOf(i));
        if (i == 2)
        {
          paramView.put("Fromwhere", "SmallScreen");
          if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
            ReportController.b(null, "dc00899", "Grp_video", "", "notice", "Clk_video", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "" + TroopUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString), "2", "");
          }
        }
        if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(j, l)) {
          break label458;
        }
        ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true, true, null, paramView);
        if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(j, l)) {
          break label577;
        }
      }
      for (paramView = "Cover_back";; paramView = "Clk_discuss_floating")
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 3000) {
          break label582;
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Multi_call", paramView, 0, 0, "", "", "", "");
        return;
        i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(l);
        break;
        a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, i);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) {
          break label373;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(l) == 10)
        {
          ReportController.b(null, "CliOper", "", "", "0X8005933", "0X8005933", 0, 0, "", "", "", "");
          break label373;
        }
        ReportController.b(null, "CliOper", "", "", "0X80046DA", "0X80046DA", 0, 0, "", "", "", "");
        break label373;
      }
    }
    boolean bool = false;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().g() == 5)
    {
      paramView = new Intent(this.jdField_a_of_type_AndroidContentContext, CallbackWaitingActivityExt.class);
      localObject = new PstnSessionInfo();
      ((PstnSessionInfo)localObject).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().jdField_a_of_type_JavaLangString;
      ((PstnSessionInfo)localObject).d = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().d;
      ((PstnSessionInfo)localObject).jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().jdField_b_of_type_JavaLangString;
      ((PstnSessionInfo)localObject).c = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().c;
      ((PstnSessionInfo)localObject).jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().jdField_a_of_type_Int;
      ((PstnSessionInfo)localObject).jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().jdField_b_of_type_Int;
      paramView.putExtra("pstn_session_info", (Parcelable)localObject);
      this.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
      PstnUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().g() == 1) {
      bool = true;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString) == 1)
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800478D", "0X800478D", 0, 0, "", "", "", "");
        bool = true;
      }
    }
    for (;;)
    {
      ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, null, bool, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString, false, true, null, "from_internal");
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Two_call", "Two_call_full", 0, 0, "2", "", "", "");
      return;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004789", "0X8004789", 0, 0, "", "", "", "");
      bool = false;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\aio\tips\VideoStatusTipsBar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
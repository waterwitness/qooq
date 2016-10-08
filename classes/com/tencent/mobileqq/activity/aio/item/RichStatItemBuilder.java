package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.Layout;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.ChatBackground;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SignatureManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForRichState;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.richstatus.IIconListener;
import com.tencent.mobileqq.richstatus.IImageListener;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.mobileqq.vas.SignatureTemplateInfo;
import com.tencent.mobileqq.vas.SignatureTemplateInfo.DynamicItem;
import com.tencent.mobileqq.vas.SignatureTemplateInfo.ImageItem;
import com.tencent.mobileqq.widget.ClickableColorSpanTextView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.MobileQQ;
import noe;
import nof;
import nog;
import noh;
import noi;
import org.json.JSONArray;

public class RichStatItemBuilder
  extends AbstractChatItemBuilder
  implements IIconListener, IImageListener
{
  public static final int a = 1;
  public static long a;
  private static RichStatus jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus;
  protected Handler a;
  DisplayMetrics jdField_a_of_type_AndroidUtilDisplayMetrics;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private AIOAnimationConatiner jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner;
  private SignatureManager jdField_a_of_type_ComTencentMobileqqAppSignatureManager;
  private MessageForRichState jdField_a_of_type_ComTencentMobileqqDataMessageForRichState;
  private StatusManager jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager;
  private StringBuilder jdField_a_of_type_JavaLangStringBuilder;
  private int jdField_b_of_type_Int;
  View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener;
  
  RichStatItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_AndroidUtilDisplayMetrics = new DisplayMetrics();
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new nof(this);
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new nog(this);
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState = null;
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager = ((StatusManager)paramQQAppInterface.getManager(14));
    this.jdField_a_of_type_ComTencentMobileqqAppSignatureManager = ((SignatureManager)paramQQAppInterface.getManager(57));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner = paramAIOAnimationConatiner;
    paramQQAppInterface = BaseApplicationImpl.a();
    BaseApplication.getContext();
    ((WindowManager)paramQQAppInterface.getSystemService("window")).getDefaultDisplay().getMetrics(this.jdField_a_of_type_AndroidUtilDisplayMetrics);
  }
  
  private CharSequence a(String paramString1, String paramString2, String paramString3, String paramString4, JSONArray paramJSONArray, int paramInt)
  {
    paramString3 = this.jdField_a_of_type_JavaLangStringBuilder;
    paramString3.setLength(0);
    if ((paramString1 != null) && (paramString1.length() > 0)) {
      paramString3.append(paramString1);
    }
    if ((paramString2 != null) && (paramString2.length() > 0)) {
      paramString3.append(paramString2);
    }
    int j = Integer.parseInt(paramString4);
    int i;
    if ((paramJSONArray != null) && (paramJSONArray.length() > 0))
    {
      i = 0;
      while (i < j)
      {
        paramString4 = paramJSONArray.optString(i);
        if ((paramString4 != null) && (paramString4.length() > 0)) {
          paramString3.append(paramString4);
        }
        i += 1;
      }
    }
    if ((paramJSONArray != null) && (paramJSONArray.length() > 0))
    {
      int k = paramJSONArray.length();
      i = j;
      while (i < k)
      {
        paramString4 = paramJSONArray.optString(i);
        if ((paramString4 != null) && (paramString4.length() > 0)) {
          paramString3.append(paramString4);
        }
        i += 1;
      }
    }
    paramString4 = new SpannableString(paramString3.toString());
    if ((paramString2 != null) && (paramString2.length() > 0)) {
      if ((paramString1 != null) && (paramString1.length() > 0))
      {
        paramInt = paramString1.length() + paramString2.length();
        paramString4.setSpan(new ForegroundColorSpan(-16754769), 0, paramInt, 33);
      }
    }
    for (;;)
    {
      paramString3.setLength(0);
      return paramString4;
      paramInt = paramString2.length();
      break;
      if ((paramString1 != null) && (paramString1.length() > 0)) {
        paramString4.setSpan(new ForegroundColorSpan(paramInt), 0, paramString1.length(), 33);
      }
    }
  }
  
  public static String a(String paramString, int paramInt)
  {
    return paramString + "icon" + paramInt;
  }
  
  public static String a(String paramString1, String paramString2)
  {
    return paramString1 + "cover" + paramString2;
  }
  
  private void a(View paramView, RichStatItemBuilder.Holder paramHolder, MessageForRichState paramMessageForRichState)
  {
    if (jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus == null) {
      jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus = new RichStatus(null);
    }
    jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.feedsId = paramMessageForRichState.feedId;
    jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.tplId = paramMessageForRichState.tplId;
    paramView = jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus;
    if (TextUtils.isEmpty(paramMessageForRichState.actionId))
    {
      i = jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.actionId;
      paramView.actionId = i;
      jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.actionText = paramMessageForRichState.actionText;
      paramView = jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus;
      if (!TextUtils.isEmpty(paramMessageForRichState.dataId)) {
        break label260;
      }
      i = jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.dataId;
      label97:
      paramView.dataId = i;
      jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.dataText = paramMessageForRichState.dataText;
      jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.locationText = paramMessageForRichState.locText;
      paramView = jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus;
      if (!TextUtils.isEmpty(paramMessageForRichState.locPos)) {
        break label272;
      }
    }
    label260:
    label272:
    for (int i = jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.locationPosition;; i = Integer.parseInt(paramMessageForRichState.locPos))
    {
      paramView.locationPosition = i;
      jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.time = paramMessageForRichState.time;
      jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.plainText = null;
      if ((paramMessageForRichState.plainText == null) || (paramMessageForRichState.plainText.length() <= 0)) {
        break label284;
      }
      jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.plainText = new ArrayList(paramMessageForRichState.plainText.length());
      i = 0;
      while (i < paramMessageForRichState.plainText.length())
      {
        jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.plainText.add(paramMessageForRichState.plainText.optString(i));
        i += 1;
      }
      i = Integer.parseInt(paramMessageForRichState.actionId);
      break;
      i = Integer.parseInt(paramMessageForRichState.dataId);
      break label97;
    }
    label284:
    paramHolder.jdField_c_of_type_JavaLangString = jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.feedsId;
    paramHolder.jdField_c_of_type_Int = jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.tplId;
    paramHolder.e = paramMessageForRichState.count;
    paramHolder.jdField_d_of_type_Int = paramMessageForRichState.zanFlag;
    paramHolder.jdField_c_of_type_AndroidWidgetTextView.setText(jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.getLocSS(paramHolder.jdField_c_of_type_AndroidWidgetTextView, TimeFormatterUtils.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext(), jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.time * 1000L) + "    "));
    a(paramHolder);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().e(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.time);
    if (!TextUtils.isEmpty(jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.feedsId))
    {
      paramHolder.jdField_d_of_type_AndroidWidgetTextView.setClickable(true);
      paramHolder.jdField_d_of_type_AndroidWidgetTextView.setText(String.valueOf(paramMessageForRichState.count));
      i = 8;
      if (paramMessageForRichState.zanFlag == 0) {
        i = 7;
      }
      paramView = this.jdField_a_of_type_ComTencentMobileqqAppSignatureManager.a(paramHolder.jdField_c_of_type_Int, i, DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 14.0F), DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 19.0F));
      if (paramView != null) {
        paramHolder.jdField_d_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(paramView, null, null, null);
      }
      paramHolder.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    for (;;)
    {
      ThreadManager.a(new noe(this, paramMessageForRichState), 8, null, true);
      return;
      paramHolder.jdField_d_of_type_AndroidWidgetTextView.setText("0");
      paramHolder.jdField_d_of_type_AndroidWidgetTextView.setClickable(false);
    }
  }
  
  private void a(RichStatItemBuilder.Holder paramHolder)
  {
    Object localObject1 = (SignatureManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(57);
    Object localObject2 = paramHolder.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
    SignatureManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources(), paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetClickableColorSpanTextView, this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager, jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true);
    paramHolder.jdField_c_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#ffa8a8a8"));
    label250:
    Layout localLayout;
    if ((paramHolder.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo != null) && (paramHolder.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo$ImageItem != null))
    {
      ((ViewGroup.LayoutParams)localObject2).height = ((int)(this.jdField_b_of_type_Int / paramHolder.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo$ImageItem.a * paramHolder.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo$ImageItem.jdField_b_of_type_Int));
      paramHolder.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      i = 17;
      localObject1 = ((SignatureManager)localObject1).a(jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.tplId, i, this.jdField_b_of_type_Int, ((ViewGroup.LayoutParams)localObject2).height);
      if (localObject1 != null)
      {
        if (!(localObject1 instanceof URLDrawable)) {
          break label543;
        }
        localObject2 = (URLDrawable)localObject1;
        if (((URLDrawable)localObject2).getStatus() == 1)
        {
          SignatureManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources(), paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetClickableColorSpanTextView, this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager, jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false);
          if (!TextUtils.isEmpty(paramHolder.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo.p)) {
            paramHolder.jdField_c_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor(paramHolder.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo.p));
          }
        }
        ((URLDrawable)localObject2).setURLDrawableListener(new noh(this, paramHolder));
        paramHolder.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable((Drawable)localObject1);
        if ((SignatureManager.y != null) && (SignatureManager.a != null))
        {
          localObject1 = SignatureManager.y;
          localObject2 = SignatureManager.a;
          this.jdField_a_of_type_AndroidOsHandler.postDelayed(new noi(this, paramHolder, (String)localObject1, (SignatureTemplateInfo.DynamicItem)localObject2), 500L);
        }
      }
    }
    else
    {
      localLayout = SignatureManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources(), paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetClickableColorSpanTextView, this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager, jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, this.jdField_b_of_type_Int);
      if (localLayout == null) {
        break label605;
      }
    }
    label363:
    label513:
    label543:
    label605:
    for (int i = localLayout.getLineCount();; i = 1)
    {
      float f;
      if (i < 3)
      {
        i = 2;
        f = 0.35F;
        if ((localLayout != null) && (!TextUtils.isEmpty(paramHolder.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo.s))) {
          break label513;
        }
      }
      for (((ViewGroup.LayoutParams)localObject2).height = ((int)(f * this.jdField_b_of_type_Int));; ((ViewGroup.LayoutParams)localObject2).height = (localLayout.getHeight() + DisplayUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext(), 75.0F)))
      {
        if (paramHolder.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo.jdField_a_of_type_JavaLangString.equals("0")) {
          ((ViewGroup.LayoutParams)localObject2).height = (localLayout.getHeight() + DisplayUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext(), 75.0F));
        }
        int j = localLayout.getHeight() + DisplayUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 84.0F);
        if (j > ((ViewGroup.LayoutParams)localObject2).height) {
          ((ViewGroup.LayoutParams)localObject2).height = j;
        }
        paramHolder.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        break;
        if (i < 5)
        {
          f = 0.46F;
          i = 3;
          break label363;
        }
        i = 4;
        f = 0.577F;
        break label363;
      }
      SignatureManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources(), paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetClickableColorSpanTextView, this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager, jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false);
      if (TextUtils.isEmpty(paramHolder.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo.p)) {
        break label250;
      }
      paramHolder.jdField_c_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor(paramHolder.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo.p));
      break label250;
    }
  }
  
  protected View a(MessageRecord paramMessageRecord, AbstractChatItemBuilder.ViewHolder paramViewHolder, View paramView, LinearLayout paramLinearLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    b();
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState = ((MessageForRichState)paramMessageRecord);
    jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.uniseq;
    paramOnLongClickAndTouchListener = (RichStatItemBuilder.Holder)paramViewHolder;
    paramMessageRecord = paramView;
    int i;
    int j;
    int k;
    if (paramView == null)
    {
      i = this.jdField_a_of_type_AndroidUtilDisplayMetrics.widthPixels;
      j = Math.min(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getDisplayMetrics().widthPixels, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getDisplayMetrics().heightPixels);
      k = DisplayUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext(), 38.0F);
      int m = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 260.0F);
      paramViewHolder = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130903182, paramLinearLayout, false);
      paramOnLongClickAndTouchListener.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramViewHolder.findViewById(2131297550));
      paramOnLongClickAndTouchListener.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramViewHolder.findViewById(2131297554));
      paramOnLongClickAndTouchListener.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramViewHolder.findViewById(2131297555));
      paramOnLongClickAndTouchListener.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramViewHolder.findViewById(2131297556));
      paramOnLongClickAndTouchListener.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramViewHolder.findViewById(2131297551));
      paramMessageRecord = (RelativeLayout.LayoutParams)paramOnLongClickAndTouchListener.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams();
      if (i < m) {
        break label939;
      }
      this.jdField_b_of_type_Int = m;
      paramMessageRecord.width = this.jdField_b_of_type_Int;
      paramOnLongClickAndTouchListener.jdField_a_of_type_AndroidViewViewGroup.setLayoutParams(paramMessageRecord);
      paramOnLongClickAndTouchListener.jdField_a_of_type_ComTencentMobileqqWidgetClickableColorSpanTextView = ((ClickableColorSpanTextView)paramViewHolder.findViewById(2131297553));
      paramOnLongClickAndTouchListener.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewHolder.findViewById(2131297552));
      paramMessageRecord = paramViewHolder;
      if (jdField_b_of_type_Boolean)
      {
        paramOnLongClickAndTouchListener.jdField_b_of_type_JavaLangStringBuilder = new StringBuilder();
        paramMessageRecord = paramViewHolder;
      }
    }
    if (jdField_b_of_type_Boolean)
    {
      paramMessageRecord.setContentDescription(null);
      paramOnLongClickAndTouchListener.jdField_b_of_type_JavaLangStringBuilder.replace(0, paramOnLongClickAndTouchListener.jdField_b_of_type_JavaLangStringBuilder.length(), "");
    }
    paramViewHolder = ((SignatureManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(57)).a(Integer.toString(this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.tplId));
    paramOnLongClickAndTouchListener.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo = paramViewHolder;
    if ((paramViewHolder != null) && (paramViewHolder.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo$ImageItem != null))
    {
      paramOnLongClickAndTouchListener.jdField_a_of_type_ComTencentMobileqqWidgetClickableColorSpanTextView.setVisibility(4);
      label380:
      paramOnLongClickAndTouchListener.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramOnLongClickAndTouchListener.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.uniseq;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.a != null) {
        paramOnLongClickAndTouchListener.jdField_b_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.a);
      }
      paramOnLongClickAndTouchListener.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.frienduin;
      paramOnLongClickAndTouchListener.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.istroop;
      paramOnLongClickAndTouchListener.jdField_b_of_type_JavaLangString = null;
      paramViewHolder = this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.ver;
      if ((paramViewHolder != null) && (paramViewHolder.equals("1.0"))) {
        if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.time <= 0L) {
          break label1125;
        }
      }
    }
    label560:
    label578:
    label939:
    label977:
    label988:
    label1125:
    for (paramViewHolder = TimeFormatterUtils.a(this.jdField_a_of_type_AndroidContentContext, 3, this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.time * 1000L);; paramViewHolder = null)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.feedNum != null) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.feedNum.trim().length() > 0))
      {
        paramOnLongClickAndTouchListener.jdField_d_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.feedNum);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d == null) {
          break label977;
        }
        paramView = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d;
        paramView = Utils.b(paramView, 10);
        paramOnLongClickAndTouchListener.jdField_b_of_type_AndroidWidgetTextView.setText(paramView + "更新了签名");
        i = Color.parseColor(this.jdField_a_of_type_ComTencentMobileqqAppSignatureManager.a(Integer.toString(paramOnLongClickAndTouchListener.jdField_c_of_type_Int)).e);
        paramLinearLayout = a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.actionText, this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.dataText, this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.locText, this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.locPos, this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.plainText, i);
        if (jdField_b_of_type_Boolean)
        {
          paramOnLongClickAndTouchListener.jdField_b_of_type_JavaLangStringBuilder.append(paramView);
          if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.time > 0L) {
            paramOnLongClickAndTouchListener.jdField_b_of_type_JavaLangStringBuilder.append("于").append(paramViewHolder);
          }
          paramOnLongClickAndTouchListener.jdField_b_of_type_JavaLangStringBuilder.append("更新了签名，内容是：").append(paramLinearLayout);
          paramMessageRecord.setContentDescription(paramOnLongClickAndTouchListener.jdField_b_of_type_JavaLangStringBuilder.toString());
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.dataText == null) || (this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.dataText.length() <= 0)) {
          break label988;
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.actionId == null) || (this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.actionId.trim().length() == 0)) {
          this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.actionId = "0";
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.dataId == null) || (this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.dataId.trim().length() == 0)) {
          this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.dataId = "0";
        }
        paramViewHolder = a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.actionId, this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.dataId);
        if (QLog.isColorLevel()) {
          QLog.d("AIOSign", 2, "taskKey is:" + paramViewHolder);
        }
        paramOnLongClickAndTouchListener.jdField_b_of_type_JavaLangString = paramViewHolder;
      }
      for (;;)
      {
        a(paramMessageRecord, paramOnLongClickAndTouchListener, this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState);
        paramOnLongClickAndTouchListener.jdField_d_of_type_AndroidWidgetTextView.setTag(paramOnLongClickAndTouchListener);
        paramOnLongClickAndTouchListener.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
        return paramMessageRecord;
        this.jdField_b_of_type_Int = (j - k);
        break;
        paramOnLongClickAndTouchListener.jdField_a_of_type_ComTencentMobileqqWidgetClickableColorSpanTextView.setVisibility(0);
        break label380;
        paramOnLongClickAndTouchListener.jdField_d_of_type_AndroidWidgetTextView.setText("0");
        break label560;
        paramView = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
        break label578;
        if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.actionText != null) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.actionText.length() > 0))
        {
          paramViewHolder = a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.actionId, 201);
          if (QLog.isColorLevel()) {
            QLog.d("AIOSign", 2, "taskKey is:" + paramViewHolder);
          }
          paramOnLongClickAndTouchListener.jdField_b_of_type_JavaLangString = paramViewHolder;
        }
        else if (QLog.isColorLevel())
        {
          QLog.e("AIOSign", 2, "bindViewForRichSignature(),dataText is:" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.dataText + ",actionText is:" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.actionText);
        }
      }
    }
  }
  
  protected AbstractChatItemBuilder.ViewHolder a()
  {
    return new RichStatItemBuilder.Holder(this);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.b(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager = null;
    this.jdField_a_of_type_ComTencentMobileqqAppSignatureManager = null;
  }
  
  public void a(int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    if (paramBitmap != null) {
      this.jdField_a_of_type_AndroidWidgetBaseAdapter.notifyDataSetChanged();
    }
  }
  
  public void a(int paramInt1, int paramInt2, Bitmap paramBitmap, int paramInt3)
  {
    if (paramBitmap != null) {
      this.jdField_a_of_type_AndroidWidgetBaseAdapter.notifyDataSetChanged();
    }
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  public void a(MessageRecord paramMessageRecord, int paramInt, String paramString, SignatureTemplateInfo.DynamicItem paramDynamicItem, View paramView)
  {
    if ((paramString == null) || (SignatureManager.a == null)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.a(0, 100, new Object[] { Integer.valueOf(4), Long.valueOf(paramMessageRecord.uniseq), Integer.valueOf(paramInt), paramString, Boolean.valueOf(true), paramView, paramDynamicItem });
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    return null;
  }
  
  protected void b()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.a(0);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\aio\item\RichStatItemBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
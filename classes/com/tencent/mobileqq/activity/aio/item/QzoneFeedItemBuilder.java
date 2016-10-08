package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForQzoneFeed;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.util.URLUtil;
import cooperation.qzone.QZoneClickReport;
import cooperation.qzone.QZoneClickReport.ReportInfo;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import nnw;
import nnx;

public class QzoneFeedItemBuilder
  extends AbstractChatItemBuilder
{
  private static int a;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_Int = -1;
  }
  
  public QzoneFeedItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
  }
  
  public static int a()
  {
    if (jdField_a_of_type_Int < 0) {
      if (BaseApplication.getContext().getResources().getConfiguration().orientation != 2) {
        break label41;
      }
    }
    label41:
    for (jdField_a_of_type_Int = BaseApplication.getContext().getResources().getDisplayMetrics().heightPixels;; jdField_a_of_type_Int = BaseApplication.getContext().getResources().getDisplayMetrics().widthPixels) {
      return jdField_a_of_type_Int;
    }
  }
  
  private View a(View paramView, nnx paramnnx)
  {
    View localView = paramView;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130903180, null);
      paramnnx.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131297543));
      paramnnx.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131297542));
      paramnnx.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131296359));
      paramnnx.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131296360));
      paramnnx.d = ((TextView)paramView.findViewById(2131296365));
      paramnnx.e = ((TextView)paramView.findViewById(2131297548));
      paramnnx.f = ((TextView)paramView.findViewById(2131297549));
      paramnnx.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131297547));
      paramnnx.g = ((TextView)paramView.findViewById(2131297544));
      paramnnx.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131297546));
      paramnnx.jdField_c_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131297545));
      localView = paramView;
      if (b)
      {
        paramnnx.jdField_b_of_type_JavaLangStringBuilder = new StringBuilder();
        localView = paramView;
      }
    }
    if (b)
    {
      localView.setContentDescription(null);
      paramnnx.jdField_b_of_type_JavaLangStringBuilder.replace(0, paramnnx.jdField_b_of_type_JavaLangStringBuilder.length(), "");
    }
    return localView;
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    int i;
    do
    {
      return null;
      i = paramString.indexOf("http");
    } while (i < 0);
    paramString = paramString.substring(i);
    try
    {
      new URL(paramString);
      return paramString;
    }
    catch (MalformedURLException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  protected View a(MessageRecord paramMessageRecord, AbstractChatItemBuilder.ViewHolder paramViewHolder, View paramView, LinearLayout paramLinearLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramLinearLayout = (MessageForQzoneFeed)paramMessageRecord;
    paramOnLongClickAndTouchListener = (nnx)paramViewHolder;
    paramView = a(paramView, paramOnLongClickAndTouchListener);
    paramOnLongClickAndTouchListener.jdField_a_of_type_Long = paramLinearLayout.uniseq;
    paramOnLongClickAndTouchListener.jdField_a_of_type_JavaLangString = paramLinearLayout.frienduin;
    paramOnLongClickAndTouchListener.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(null);
    paramOnLongClickAndTouchListener.jdField_b_of_type_JavaLangString = null;
    paramMessageRecord = paramLinearLayout.title;
    paramViewHolder = paramLinearLayout.content;
    if ((!TextUtils.isEmpty(paramMessageRecord)) && (!TextUtils.isEmpty(paramViewHolder)))
    {
      i = 1;
      paramLinearLayout.coverImageUrl = a(paramLinearLayout.coverImageUrl);
      if (TextUtils.isEmpty(paramLinearLayout.coverImageUrl)) {
        break label672;
      }
    }
    label198:
    label207:
    label259:
    label306:
    label372:
    Object localObject;
    label626:
    label672:
    for (int j = 1;; j = 0)
    {
      if (j != 0) {
        break label678;
      }
      i = AIOUtils.a(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      paramOnLongClickAndTouchListener.jdField_a_of_type_AndroidViewViewGroup.setPadding(i, i, i, i);
      paramOnLongClickAndTouchListener.g.setVisibility(8);
      paramOnLongClickAndTouchListener.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      paramOnLongClickAndTouchListener.jdField_b_of_type_AndroidViewViewGroup.setPadding(0, AIOUtils.a(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, 0);
      if (paramMessageRecord == null) {
        break label1132;
      }
      paramMessageRecord = paramMessageRecord.trim();
      if (paramViewHolder == null) {
        break label1129;
      }
      paramViewHolder = paramViewHolder.trim();
      paramOnLongClickAndTouchListener.jdField_c_of_type_AndroidWidgetTextView.setText(paramMessageRecord);
      paramOnLongClickAndTouchListener.d.setText(paramViewHolder);
      if ((!TextUtils.isEmpty(paramMessageRecord)) || (!TextUtils.isEmpty(paramViewHolder))) {
        break label874;
      }
      paramOnLongClickAndTouchListener.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      paramOnLongClickAndTouchListener.d.setVisibility(8);
      paramMessageRecord = TimeFormatterUtils.a(this.jdField_a_of_type_AndroidContentContext, 7, paramLinearLayout.feedTime * 1000L);
      if (paramLinearLayout.feedTime <= 0L) {
        break label1037;
      }
      paramOnLongClickAndTouchListener.f.setVisibility(0);
      paramOnLongClickAndTouchListener.f.setText(paramMessageRecord);
      paramViewHolder = new RelativeLayout.LayoutParams(-2, -2);
      paramViewHolder.addRule(12);
      if (TextUtils.isEmpty(paramLinearLayout.lbsInfo)) {
        break label1059;
      }
      paramOnLongClickAndTouchListener.e.setVisibility(0);
      paramOnLongClickAndTouchListener.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      paramOnLongClickAndTouchListener.e.setText(paramLinearLayout.lbsInfo);
      paramViewHolder.addRule(11);
      paramOnLongClickAndTouchListener.f.setLayoutParams(paramViewHolder);
      paramViewHolder = Utils.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, 10);
      localObject = paramViewHolder + paramLinearLayout.summery;
      paramOnLongClickAndTouchListener.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      paramOnLongClickAndTouchListener.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(new nnw(this, paramLinearLayout));
      if (b)
      {
        paramOnLongClickAndTouchListener.jdField_b_of_type_JavaLangStringBuilder.append(paramViewHolder);
        if (paramLinearLayout.feedTime > 0L) {
          paramOnLongClickAndTouchListener.jdField_b_of_type_JavaLangStringBuilder.append("于").append(paramMessageRecord);
        }
        paramOnLongClickAndTouchListener.jdField_b_of_type_JavaLangStringBuilder.append(paramLinearLayout.summery).append("内容是：").append(paramLinearLayout.title).append(paramLinearLayout.content);
        paramView.setContentDescription(paramOnLongClickAndTouchListener.jdField_b_of_type_JavaLangStringBuilder.toString());
      }
      if (!paramLinearLayout.hasExposed)
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005FFF", "0X8005FFF", 0, 0, "", "", "", "");
        paramLinearLayout.hasExposed = true;
      }
      paramViewHolder = URLUtil.a(paramLinearLayout.actionUrl);
      paramMessageRecord = null;
      if (paramViewHolder != null) {
        paramMessageRecord = (String)paramViewHolder.get("a");
      }
      if (paramMessageRecord != null)
      {
        if (!paramMessageRecord.equals("4")) {
          break label1088;
        }
        paramMessageRecord = "1";
        paramViewHolder = new QZoneClickReport.ReportInfo();
        paramViewHolder.c = "330";
        paramViewHolder.d = "1";
        paramViewHolder.e = paramMessageRecord;
        QZoneClickReport.startReportImediately(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), paramViewHolder);
      }
      return paramView;
      i = 0;
      break;
    }
    label678:
    j = AIOUtils.a(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    paramOnLongClickAndTouchListener.jdField_a_of_type_AndroidViewViewGroup.setPadding(j, j, j, j);
    if (paramLinearLayout.imageCount > 1)
    {
      paramOnLongClickAndTouchListener.g.setVisibility(0);
      paramOnLongClickAndTouchListener.g.setText(String.valueOf(paramLinearLayout.imageCount));
      label742:
      j = AIOUtils.a(55.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      paramOnLongClickAndTouchListener.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
      if (i == 0) {
        break label1135;
      }
    }
    label874:
    label1037:
    label1059:
    label1088:
    label1129:
    label1132:
    label1135:
    for (int i = AIOUtils.a(60.0F, this.jdField_a_of_type_AndroidContentContext.getResources());; i = j)
    {
      localObject = URLDrawable.getDrawable(paramLinearLayout.coverImageUrl, i, i);
      ((URLDrawable)localObject).setTag(URLDrawableDecodeHandler.a(i, i, (int)(2.0F * DeviceInfoUtil.a())));
      ((URLDrawable)localObject).setDecodeHandler(URLDrawableDecodeHandler.b);
      paramOnLongClickAndTouchListener.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
      paramOnLongClickAndTouchListener.jdField_b_of_type_AndroidViewViewGroup.setPadding(0, 0, 0, AIOUtils.a(1.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      break;
      paramOnLongClickAndTouchListener.g.setVisibility(8);
      break label742;
      if ((!TextUtils.isEmpty(paramMessageRecord)) && (TextUtils.isEmpty(paramViewHolder)))
      {
        paramOnLongClickAndTouchListener.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        paramOnLongClickAndTouchListener.jdField_c_of_type_AndroidWidgetTextView.setPadding(0, 0, 0, 0);
        paramOnLongClickAndTouchListener.d.setVisibility(8);
        paramOnLongClickAndTouchListener.jdField_c_of_type_AndroidWidgetTextView.setMaxLines(2);
        break label259;
      }
      if ((TextUtils.isEmpty(paramMessageRecord)) && (!TextUtils.isEmpty(paramViewHolder)))
      {
        paramOnLongClickAndTouchListener.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
        paramOnLongClickAndTouchListener.d.setVisibility(0);
        paramOnLongClickAndTouchListener.d.setMaxLines(2);
        break label259;
      }
      paramOnLongClickAndTouchListener.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      paramOnLongClickAndTouchListener.d.setVisibility(0);
      paramOnLongClickAndTouchListener.jdField_c_of_type_AndroidWidgetTextView.setPadding(0, 0, 0, AIOUtils.a(2.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      paramOnLongClickAndTouchListener.jdField_c_of_type_AndroidWidgetTextView.setMaxLines(1);
      paramOnLongClickAndTouchListener.d.setMaxLines(1);
      break label259;
      paramOnLongClickAndTouchListener.f.setVisibility(8);
      paramOnLongClickAndTouchListener.f.setText(paramMessageRecord);
      break label306;
      paramOnLongClickAndTouchListener.e.setVisibility(8);
      paramOnLongClickAndTouchListener.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      paramViewHolder.addRule(9);
      break label372;
      if (paramMessageRecord.equals("311"))
      {
        paramMessageRecord = "2";
        break label626;
      }
      if (paramMessageRecord.equals("2"))
      {
        paramMessageRecord = "3";
        break label626;
      }
      paramMessageRecord = "4";
      break label626;
      break label207;
      break label198;
    }
  }
  
  protected AbstractChatItemBuilder.ViewHolder a()
  {
    return new nnx(this);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  public boolean a(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || ((!paramString.startsWith("http://")) && (!paramString.startsWith("https://")))) {
      return false;
    }
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
    localIntent.putExtra("url", paramString);
    localIntent.putExtra("fromAio", true);
    PublicAccountUtil.a(localIntent, paramString);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    return true;
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    return null;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\aio\item\QzoneFeedItemBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
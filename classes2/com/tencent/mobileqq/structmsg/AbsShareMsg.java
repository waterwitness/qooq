package com.tencent.mobileqq.structmsg;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout1;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout2;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayoutDefault;
import com.tencent.mobileqq.structmsg.view.StructMsgItemSummary;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.mobileqq.structmsg.widget.HeightLimitedLinearLayout;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import uuw;
import uuy;

public abstract class AbsShareMsg
  extends AbsStructMsg
  implements Iterable
{
  protected static final int PACKAGE_NAME_INDEX = 0;
  protected static final int URL_DATA_INDEX = 1;
  private static final int a = 13;
  public String mContentCover;
  public int mContentLayout;
  public String mContentSrc;
  public String mContentSummary;
  public String mContentTitle;
  boolean mHasSource;
  public boolean mMsgException;
  public String mSourceAction;
  public String mSourceActionData;
  public long mSourceAppid;
  public String mSourceIcon;
  public String mSourceName;
  protected View.OnClickListener mSourceOnClickListener;
  public String mSourceUrl;
  public String mSource_A_ActionData;
  public String mSource_I_ActionData;
  public List mStructMsgItemLists;
  
  AbsShareMsg()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.mStructMsgItemLists = new ArrayList();
    this.mContentLayout = -1;
    this.mSourceAppid = -1L;
    this.mSourceOnClickListener = new uuw(this);
    this.mVersion = 13;
  }
  
  AbsShareMsg(Bundle paramBundle)
  {
    super(paramBundle);
    this.mStructMsgItemLists = new ArrayList();
    this.mContentLayout = -1;
    this.mSourceAppid = -1L;
    this.mSourceOnClickListener = new uuw(this);
    this.mVersion = 13;
    this.mContentCover = paramBundle.getString("image_url_remote");
    this.mContentTitle = paramBundle.getString("title");
    this.mContentSummary = paramBundle.getString("desc");
    if (this.mContentTitle != null) {
      this.mContentTitle = MessageUtils.a(this.mContentTitle, false);
    }
    if (this.mContentSummary != null) {
      this.mContentSummary = MessageUtils.a(this.mContentSummary, false);
    }
    this.mMsgAction = paramBundle.getString("struct_share_key_content_action");
    this.mMsgActionData = paramBundle.getString("struct_share_key_content_action_DATA");
    this.mMsg_A_ActionData = paramBundle.getString("struct_share_key_content_a_action_DATA");
    this.mMsg_I_ActionData = paramBundle.getString("struct_share_key_content_i_action_DATA");
    this.mSourceAppid = paramBundle.getLong("req_share_id", -1L);
    this.mSourceUrl = paramBundle.getString("struct_share_key_source_url");
    this.mSourceAction = paramBundle.getString("struct_share_key_source_action");
    if (TextUtils.isEmpty(this.mSourceAction)) {
      this.mSourceAction = "app";
    }
    this.mSourceActionData = paramBundle.getString("struct_share_key_source_action_data");
    this.mSource_A_ActionData = paramBundle.getString("struct_share_key_source_a_action_data");
    this.mSource_I_ActionData = paramBundle.getString("struct_share_key_source_i_action_data");
    if ((TextUtils.isEmpty(this.mSource_I_ActionData)) && (this.mSourceAppid > 0L) && (!"plugin".equals(this.mSourceAction))) {
      this.mSource_I_ActionData = String.format("tencent%d://", new Object[] { Long.valueOf(this.mSourceAppid) });
    }
    this.mSourceIcon = paramBundle.getString("struct_share_key_source_icon");
    this.mSourceName = paramBundle.getString("struct_share_key_source_name");
    if (TextUtils.isEmpty(this.mSourceName)) {
      this.mSourceName = paramBundle.getString("app_name");
    }
    this.mMsgBrief = paramBundle.getString("brief_key");
    if (TextUtils.isEmpty(this.mMsgBrief))
    {
      if (!TextUtils.isEmpty(this.mSourceName)) {
        this.mMsgBrief = String.format("%s 的分享", new Object[] { this.mSourceName });
      }
    }
    else
    {
      this.mResid = paramBundle.getString("mm_resid");
      this.mFileName = paramBundle.getString("mm_file_name");
      this.mFileSize = paramBundle.getLong("mm_file_size");
      this.mCompatibleText = paramBundle.getString("compatible_text");
      this.fwFlag = paramBundle.getInt("is_share_flag", 0);
      if ((!this.mHasSource) && ((!TextUtils.isEmpty(this.mSourceName)) || (!TextUtils.isEmpty(this.mSourceIcon)))) {
        this.mHasSource = true;
      }
      if ((TextUtils.isEmpty(this.mContentTitle)) && (TextUtils.isEmpty(this.mContentSummary))) {
        if (!TextUtils.isEmpty(this.mSourceName)) {
          break label896;
        }
      }
    }
    label896:
    for (this.mContentTitle = "这个不错, 分享之";; this.mContentTitle = String.format("刚在%s看到, 分享之", new Object[] { this.mSourceName }))
    {
      this.mNeedRound = paramBundle.getString("icon_need_round");
      this.mFlag = paramBundle.getInt("flag");
      if (QLog.isColorLevel()) {
        QLog.d("StructMsg", 2, new StringBuilder().append("msgUrl = ").append(this.mMsgUrl).toString() + new StringBuilder().append(", mVersion = ").append(this.mVersion).toString() + ", mContentCover = " + this.mContentCover + ", mContentTitle = " + this.mContentTitle + ", mContentSummary = " + this.mContentSummary + ", mMsgAction = " + this.mMsgAction + ", mMsgActionData = " + this.mMsgActionData + ", mMsg_A_ActionData = " + this.mMsg_A_ActionData + ", mMsg_I_ActionData = " + this.mMsg_I_ActionData + ", mSourceAppid = " + this.mSourceAppid + ", mSourceUrl = " + this.mSourceUrl + ", mSourceAction = " + this.mSourceAction + ", mSourceActionData = " + this.mSourceActionData + ", mSource_A_ActionData = " + this.mSource_A_ActionData + ", mSource_I_ActionData = " + this.mSource_I_ActionData + ", mSourceIcon = " + this.mSourceIcon + ", mSourceName = " + this.mSourceName + ", mMsgBrief = " + this.mMsgBrief + ", mResid = " + this.mResid + ", mFileName = " + this.mFileName + ", mFileSize = " + this.mFileSize + ", mCompatibleText = " + this.mCompatibleText + ", fwFlag = " + this.fwFlag + ", mHasSource = " + this.mHasSource + ", mSType = " + this.mSType);
      }
      return;
      this.mMsgBrief = "应用分享";
      break;
    }
  }
  
  AbsShareMsg(StructMsgNode paramStructMsgNode)
  {
    super(paramStructMsgNode);
    this.mStructMsgItemLists = new ArrayList();
    this.mContentLayout = -1;
    this.mSourceAppid = -1L;
    this.mSourceOnClickListener = new uuw(this);
    this.mVersion = 13;
    int m = paramStructMsgNode.a();
    int i = 0;
    if (i < m)
    {
      StructMsgNode localStructMsgNode = paramStructMsgNode.a(i);
      int k;
      if (localStructMsgNode == null) {
        k = j;
      }
      for (;;)
      {
        i += 1;
        j = k;
        break;
        if (localStructMsgNode.b.equals("source"))
        {
          parseSourceNode(localStructMsgNode);
          k = j;
          if (j != 0)
          {
            parseDefaultContentNode();
            k = j;
          }
        }
        else
        {
          k = j;
          if (j == 0)
          {
            k = j;
            if (!parseContentNode(localStructMsgNode))
            {
              this.mStructMsgItemLists.clear();
              k = 1;
            }
          }
        }
      }
    }
  }
  
  public static final void doReport(QQAppInterface paramQQAppInterface, AbsShareMsg paramAbsShareMsg)
  {
    StatisticCollector.a(BaseApplication.getContext()).a(paramQQAppInterface, paramAbsShareMsg.uin, "Structured_msg", "Clk_smsg", 0, 1, null, String.valueOf(paramAbsShareMsg.mSourceAppid), String.valueOf(paramAbsShareMsg.mMsgServiceID), paramAbsShareMsg.mMsgAction, null);
    if (QLog.isColorLevel()) {
      QLog.d("StructMsg", 2, "doReport msg:" + paramAbsShareMsg);
    }
  }
  
  public static final String[] parsePackageNameAndData(String paramString1, String paramString2)
  {
    String[] arrayOfString = new String[2];
    arrayOfString[0] = "";
    arrayOfString[1] = "";
    if (TextUtils.isEmpty(paramString2)) {
      if (!TextUtils.isEmpty(paramString1)) {
        break label49;
      }
    }
    label49:
    for (int i = -1;; i = paramString1.indexOf("://"))
    {
      if (i != -1) {
        break label60;
      }
      arrayOfString[0] = paramString1;
      return arrayOfString;
      paramString1 = paramString2;
      break;
    }
    label60:
    arrayOfString[0] = paramString1.substring(0, i);
    arrayOfString[1] = paramString1.substring(i + 3);
    return arrayOfString;
  }
  
  public void addItem(AbsStructMsgElement paramAbsStructMsgElement)
  {
    this.mStructMsgItemLists.add(paramAbsStructMsgElement);
  }
  
  public void addItems(List paramList)
  {
    this.mStructMsgItemLists.addAll(paramList);
  }
  
  public void clearItems()
  {
    this.mStructMsgItemLists.clear();
  }
  
  public AbsStructMsgElement findXmlNode(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    int j = getItemCount();
    int i = 0;
    if (i < j)
    {
      Object localObject = getItemByIndex(i);
      if (localObject == null) {
        label35:
        break label63;
      }
      label63:
      label95:
      do
      {
        do
        {
          i += 1;
          break;
          if (!(localObject instanceof AbsStructMsgItem)) {
            break label95;
          }
          localObject = ((AbsStructMsgItem)localObject).a.iterator();
        } while (!((Iterator)localObject).hasNext());
        AbsStructMsgElement localAbsStructMsgElement = (AbsStructMsgElement)((Iterator)localObject).next();
        if (!paramString.equals(localAbsStructMsgElement.a)) {
          break label35;
        }
        return localAbsStructMsgElement;
      } while (!paramString.equals(((AbsStructMsgElement)localObject).a));
      return (AbsStructMsgElement)localObject;
    }
    return null;
  }
  
  public byte[] getBytes()
  {
    try
    {
      Object localObject = new ByteArrayOutputStream();
      ObjectOutputStream localObjectOutputStream = new ObjectOutputStream((OutputStream)localObject);
      writeExternal(localObjectOutputStream);
      localObjectOutputStream.flush();
      localObjectOutputStream.close();
      localObject = ((ByteArrayOutputStream)localObject).toByteArray();
      return (byte[])localObject;
    }
    catch (IOException localIOException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("StructMsg", 2, localIOException.getMessage());
      }
    }
    return null;
  }
  
  public AbsStructMsgElement getItemByIndex(int paramInt)
  {
    return (AbsStructMsgElement)this.mStructMsgItemLists.get(paramInt);
  }
  
  public int getItemCount()
  {
    return this.mStructMsgItemLists.size();
  }
  
  public abstract View.OnClickListener getOnClickListener();
  
  public View getPreDialogView(Context paramContext, View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[@]", 2, "AbsShareMsg getPreDialogView start!");
    }
    HeightLimitedLinearLayout localHeightLimitedLinearLayout = new HeightLimitedLinearLayout(paramContext);
    Object localObject1 = new LinearLayout.LayoutParams(-1, -2);
    localHeightLimitedLinearLayout.setOrientation(1);
    try
    {
      localHeightLimitedLinearLayout.setMaxHeight(paramContext.getResources().getDisplayMetrics().heightPixels >> 1);
      ((LinearLayout.LayoutParams)localObject1).gravity = 1;
      localHeightLimitedLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localObject1 = new Bundle();
      ((Bundle)localObject1).putBoolean("pre_dialog", true);
      Iterator localIterator = this.mStructMsgItemLists.iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = (AbsStructMsgElement)localIterator.next();
        View localView = ((AbsStructMsgElement)localObject2).a(paramContext, paramView, (Bundle)localObject1);
        if ((localView != null) && ((!(localObject2 instanceof StructMsgItemLayoutDefault)) || (((StructMsgItemLayoutDefault)localObject2).k != 1)))
        {
          if ((localObject2 instanceof StructMsgItemLayout2))
          {
            localObject2 = (TextView)localView.findViewById(2131296360);
            if (localObject2 != null) {
              ((TextView)localObject2).setTextColor(-8355712);
            }
          }
          localHeightLimitedLinearLayout.addView(localView);
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("StructMsg", 2, "shareMsg preDialogView setMaxHeight error!");
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("[@]", 2, "AbsShareMsg getPreDialogView end!");
      }
    }
    return localHeightLimitedLinearLayout;
  }
  
  public String getSourceName()
  {
    return this.mSourceName;
  }
  
  public View getSourceView(Context paramContext, View paramView)
  {
    if (!this.mHasSource) {
      return null;
    }
    Resources localResources = paramContext.getResources();
    if (paramView == null)
    {
      paramView = new TextView(paramContext);
      paramView.setSingleLine(true);
      paramView.setGravity(16);
      paramView.setEllipsize(TextUtils.TruncateAt.END);
      paramView.setTextColor(-1);
      paramView.setTextSize(2, 12.0F);
      paramView.setBackgroundResource(2130839487);
    }
    for (;;)
    {
      TextView localTextView = (TextView)paramView;
      localTextView.setText(this.mSourceName);
      ColorDrawable localColorDrawable;
      if (!TextUtils.isEmpty(this.mSourceIcon))
      {
        Object localObject = this.mSourceIcon;
        Drawable localDrawable = localResources.getDrawable(2130843355);
        localDrawable.setBounds(0, 0, AIOUtils.a(12.0F, localResources), AIOUtils.a(12.0F, localResources));
        localColorDrawable = new ColorDrawable(15790320);
        localColorDrawable.setBounds(0, 0, AIOUtils.a(12.0F, localResources), AIOUtils.a(12.0F, localResources));
        try
        {
          localObject = URLDrawable.getDrawable((String)localObject, localDrawable, localColorDrawable);
          if (URLDrawableHelper.a(paramContext)) {
            break label278;
          }
          bool = true;
          ((URLDrawable)localObject).setAutoDownload(bool);
          paramContext = (Context)localObject;
        }
        catch (Exception paramContext)
        {
          for (;;)
          {
            boolean bool;
            QLog.e("StructMsg", 1, paramContext.getMessage(), paramContext);
            paramContext = localColorDrawable;
          }
        }
        paramContext.setBounds(0, 0, AIOUtils.a(12.0F, localResources), AIOUtils.a(12.0F, localResources));
        localTextView.setCompoundDrawablePadding(AIOUtils.a(3.0F, localResources));
        localTextView.setCompoundDrawables(paramContext, null, null, null);
      }
      for (;;)
      {
        localTextView.setPadding(AIOUtils.a(5.0F, localResources), 0, AIOUtils.a(5.0F, localResources), 0);
        paramView.setTag(this);
        paramView.setOnClickListener(this.mSourceOnClickListener);
        return paramView;
        label278:
        bool = false;
        break;
        localTextView.setCompoundDrawables(null, null, null, null);
      }
    }
  }
  
  public List getStructMsgItemLists()
  {
    return this.mStructMsgItemLists;
  }
  
  public String getTalkBackStr()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    for (;;)
    {
      Object localObject;
      AbsStructMsgElement localAbsStructMsgElement;
      try
      {
        if (this.mStructMsgItemLists != null)
        {
          Iterator localIterator = this.mStructMsgItemLists.iterator();
          if (localIterator.hasNext())
          {
            localObject = (AbsStructMsgElement)localIterator.next();
            if (!(localObject instanceof StructMsgItemLayout1)) {
              break label112;
            }
            localObject = ((StructMsgItemLayout1)localObject).a.iterator();
            if (((Iterator)localObject).hasNext())
            {
              localAbsStructMsgElement = (AbsStructMsgElement)((Iterator)localObject).next();
              if (!(localAbsStructMsgElement instanceof StructMsgItemTitle)) {
                continue;
              }
              localStringBuffer.append(((StructMsgItemTitle)localAbsStructMsgElement).u);
              continue;
            }
            continue;
          }
        }
        return localStringBuffer.toString();
      }
      catch (Exception localException) {}
      label112:
      if ((localObject instanceof StructMsgItemLayout2))
      {
        localObject = (StructMsgItemLayout2)localObject;
        localStringBuffer.append("链接");
        localObject = ((StructMsgItemLayout2)localObject).a.iterator();
        while (((Iterator)localObject).hasNext())
        {
          localAbsStructMsgElement = (AbsStructMsgElement)((Iterator)localObject).next();
          if ((localAbsStructMsgElement instanceof StructMsgItemTitle)) {
            localStringBuffer.append(((StructMsgItemTitle)localAbsStructMsgElement).u);
          } else if ((localAbsStructMsgElement instanceof StructMsgItemSummary)) {
            localStringBuffer.append(((StructMsgItemSummary)localAbsStructMsgElement).u);
          }
        }
      }
    }
  }
  
  public Iterator iterator()
  {
    return this.mStructMsgItemLists.iterator();
  }
  
  protected abstract boolean parseContentNode(StructMsgNode paramStructMsgNode);
  
  protected void parseDefaultContentNode()
  {
    AbsStructMsgItem localAbsStructMsgItem = StructMsgElementFactory.a(2);
    localAbsStructMsgItem.a("", this.mMsgBrief, "出错了");
    addItem(localAbsStructMsgItem);
  }
  
  protected void parseSourceNode(StructMsgNode paramStructMsgNode)
  {
    if (paramStructMsgNode == null) {
      return;
    }
    this.mSourceAppid = StructMsgUtils.a(paramStructMsgNode.a("appid"));
    this.mSourceName = paramStructMsgNode.a("name");
    if (TextUtils.isEmpty(this.mMsgBrief))
    {
      this.mEmptyMsgBriefModified = true;
      if (TextUtils.isEmpty(this.mSourceName)) {
        break label174;
      }
    }
    label174:
    for (this.mMsgBrief = String.format("%s 的分享", new Object[] { this.mSourceName });; this.mMsgBrief = "应用分享")
    {
      this.mSourceIcon = paramStructMsgNode.a("icon");
      this.mSourceUrl = paramStructMsgNode.a("url");
      this.mSourceAction = paramStructMsgNode.a("action");
      this.mSourceActionData = paramStructMsgNode.a("actionData");
      this.mSource_A_ActionData = paramStructMsgNode.a("a_actionData");
      this.mSource_I_ActionData = paramStructMsgNode.a("i_actionData");
      if ((this.mHasSource) || ((TextUtils.isEmpty(this.mSourceName)) && (TextUtils.isEmpty(this.mSourceIcon)))) {
        break;
      }
      this.mHasSource = true;
      return;
    }
  }
  
  public void setStructMsgItemLists(List paramList)
  {
    this.mStructMsgItemLists = paramList;
  }
  
  protected abstract void toContentXml(uuy paramuuy);
  
  protected void toXml(ByteArrayOutputStream paramByteArrayOutputStream, String paramString)
  {
    uuy localuuy = new uuy(this, new QQXmlSerializer());
    try
    {
      localuuy.setOutput(paramByteArrayOutputStream, paramString);
      localuuy.startDocument(paramString, Boolean.valueOf(true));
      localuuy.startTag(null, "msg");
      localuuy.attribute(null, "serviceID", String.valueOf(this.mMsgServiceID));
      localuuy.attribute(null, "templateID", String.valueOf(this.mMsgTemplateID));
      if (this.mMsgAction == null)
      {
        paramByteArrayOutputStream = "";
        localuuy.attribute(null, "action", paramByteArrayOutputStream);
        if (!TextUtils.isEmpty(this.mMsgActionData)) {
          localuuy.attribute(null, "actionData", this.mMsgActionData);
        }
        if (!TextUtils.isEmpty(this.mMsg_A_ActionData)) {
          localuuy.attribute(null, "a_actionData", this.mMsg_A_ActionData);
        }
        if (!TextUtils.isEmpty(this.mMsg_I_ActionData)) {
          localuuy.attribute(null, "i_actionData", this.mMsg_I_ActionData);
        }
        if (this.mMsgBrief != null) {
          break label823;
        }
        paramByteArrayOutputStream = "";
        label173:
        localuuy.attribute(null, "brief", paramByteArrayOutputStream);
        if (!TextUtils.isEmpty(this.mResid)) {
          localuuy.attribute(null, "m_resid", this.mResid);
        }
        if (!TextUtils.isEmpty(this.mFileName)) {
          localuuy.attribute(null, "m_fileName", this.mFileName);
        }
        if (this.mFileSize > 0L) {
          localuuy.attribute(null, "m_fileSize", String.valueOf(this.mFileSize));
        }
        if (!TextUtils.isEmpty(this.source_puin)) {
          localuuy.attribute(null, "sourcePublicUin", this.source_puin);
        }
        localuuy.attribute(null, "sourceMsgId", String.valueOf(this.msgId));
        if (this.fwFlag == 1) {
          localuuy.attribute(null, "fwflag", String.valueOf(this.fwFlag));
        }
        if (this.mMsgUrl != null) {
          break label831;
        }
        paramByteArrayOutputStream = "";
        label328:
        localuuy.attribute(null, "url", paramByteArrayOutputStream);
        localuuy.attribute(null, "flag", String.valueOf(this.mFlag));
        if (!TextUtils.isEmpty(this.mSType)) {
          localuuy.attribute(null, "sType", this.mSType);
        }
        if (this.sourceAccoutType == SOURCE_ACCOUNT_TYPE_PA) {
          localuuy.attribute(null, "accostType", String.valueOf(SOURCE_ACCOUNT_TYPE_PA));
        }
        paramByteArrayOutputStream = String.valueOf(this.adverSign);
        if (!TextUtils.isEmpty(paramByteArrayOutputStream)) {
          localuuy.attribute(null, "adverSign", paramByteArrayOutputStream);
        }
        if (!TextUtils.isEmpty(this.adverKey)) {
          localuuy.attribute(null, "adverKey", this.adverKey);
        }
        if (!TextUtils.isEmpty(this.mExtraData)) {
          localuuy.attribute(null, "extraData", this.mExtraData);
        }
        if (!TextUtils.isEmpty(this.mCreateTime)) {
          localuuy.attribute(null, "createTime", this.mCreateTime);
        }
        if (!TextUtils.isEmpty(this.mTagName)) {
          localuuy.attribute(null, "tagName", this.mTagName);
        }
        if (!TextUtils.isEmpty(this.mSourceThirdName)) {
          localuuy.attribute(null, "sourceName", this.mSourceThirdName);
        }
        if (!TextUtils.isEmpty(this.mQQStoryExtra)) {
          localuuy.attribute(null, "qqstoryExtra", this.mQQStoryExtra);
        }
        if (!TextUtils.isEmpty(this.mNeedRound)) {
          localuuy.attribute(null, "needRoundView", this.mNeedRound);
        }
        localuuy.attribute(null, "multiMsgFlag", String.valueOf(this.multiMsgFlag));
        toContentXml(localuuy);
        localuuy.startTag(null, "source");
        if (this.mSourceName != null) {
          break label839;
        }
        paramByteArrayOutputStream = "";
        label628:
        localuuy.attribute(null, "name", paramByteArrayOutputStream);
        if (this.mSourceIcon != null) {
          break label847;
        }
        paramByteArrayOutputStream = "";
        label649:
        localuuy.attribute(null, "icon", paramByteArrayOutputStream);
        if (!TextUtils.isEmpty(this.mSourceUrl)) {
          localuuy.attribute(null, "url", this.mSourceUrl);
        }
        if (this.mSourceAction != null) {
          break label855;
        }
      }
      label823:
      label831:
      label839:
      label847:
      label855:
      for (paramByteArrayOutputStream = "";; paramByteArrayOutputStream = this.mSourceAction)
      {
        localuuy.attribute(null, "action", paramByteArrayOutputStream);
        if (!TextUtils.isEmpty(this.mSourceActionData)) {
          localuuy.attribute(null, "actionData", this.mSourceActionData);
        }
        if (!TextUtils.isEmpty(this.mSource_A_ActionData)) {
          localuuy.attribute(null, "a_actionData", this.mSource_A_ActionData);
        }
        if (!TextUtils.isEmpty(this.mSource_I_ActionData)) {
          localuuy.attribute(null, "i_actionData", this.mSource_I_ActionData);
        }
        localuuy.attribute(null, "appid", String.valueOf(this.mSourceAppid));
        localuuy.endTag(null, "source");
        localuuy.endTag(null, "msg");
        localuuy.endDocument();
        localuuy.flush();
        return;
        paramByteArrayOutputStream = this.mMsgAction;
        break;
        paramByteArrayOutputStream = this.mMsgBrief;
        break label173;
        paramByteArrayOutputStream = this.mMsgUrl;
        break label328;
        paramByteArrayOutputStream = this.mSourceName;
        break label628;
        paramByteArrayOutputStream = this.mSourceIcon;
        break label649;
      }
      return;
    }
    catch (Exception paramByteArrayOutputStream)
    {
      if (QLog.isColorLevel()) {
        QLog.d("StructMsg", 2, paramByteArrayOutputStream.getMessage(), paramByteArrayOutputStream);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\structmsg\AbsShareMsg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
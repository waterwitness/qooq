package com.tencent.mobileqq.structmsg;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;
import com.qq.taf.jce.HexUtil;
import com.tencent.image.GifDrawable;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.ChatActivityConstants;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.photo.ImageInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.service.MobileQQService;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.structmsg.view.StructMsgItemCover;
import com.tencent.mobileqq.structmsg.view.StructMsgItemImage;
import com.tencent.mobileqq.structmsg.view.StructMsgItemSummary;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import uuy;
import uvq;

public class StructMsgForImageShare
  extends AbsShareMsg
{
  public static final int SHARE_IMAGE_FREVIEW_MAX_SZIE = 288;
  private static View.OnClickListener a = new uvq();
  public int mIsSend = 1;
  public int mMsgType;
  public long mUniseq;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  StructMsgForImageShare()
  {
    this.mMsgServiceID = 5;
  }
  
  StructMsgForImageShare(Bundle paramBundle)
  {
    super(paramBundle);
    if (paramBundle.getInt("req_type", 1) != 5) {
      return;
    }
    this.mMsgServiceID = 5;
    AbsStructMsgItem localAbsStructMsgItem = StructMsgElementFactory.a(0);
    localAbsStructMsgItem.d(paramBundle.getString("image_url"));
    this.mStructMsgItemLists.add(localAbsStructMsgItem);
  }
  
  StructMsgForImageShare(StructMsgNode paramStructMsgNode)
  {
    super(paramStructMsgNode);
  }
  
  public static boolean resendAndUploadImageShare(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, StructMsgForImageShare paramStructMsgForImageShare)
  {
    if (paramStructMsgForImageShare == null) {}
    do
    {
      return false;
      paramStructMsgForImageShare = paramStructMsgForImageShare.getFirstImageElement();
      if (paramStructMsgForImageShare != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("StructMsg", 2, "handleAppShareAction firstImageElement NULL!!!");
    return false;
    String str = paramQQAppInterface.a();
    MessageRecord localMessageRecord = MessageRecordFactory.a(paramMessageRecord);
    paramQQAppInterface.a().a(localMessageRecord, str);
    TransferRequest localTransferRequest = new TransferRequest();
    localTransferRequest.jdField_b_of_type_JavaLangString = str;
    localTransferRequest.c = paramMessageRecord.frienduin;
    localTransferRequest.jdField_a_of_type_Int = paramMessageRecord.istroop;
    localTransferRequest.jdField_b_of_type_Int = 1;
    localTransferRequest.jdField_a_of_type_Long = localMessageRecord.uniseq;
    localTransferRequest.jdField_a_of_type_Boolean = true;
    localTransferRequest.e = 1030;
    localTransferRequest.i = paramStructMsgForImageShare.o;
    paramQQAppInterface.a().a(localTransferRequest);
    return true;
  }
  
  public static final String scaleLocalImage(Context paramContext, ImageInfo paramImageInfo, String paramString, int paramInt)
  {
    if ((paramContext == null) || (paramImageInfo == null) || (paramString == null)) {
      paramImageInfo = null;
    }
    String str1;
    long l1;
    do
    {
      return paramImageInfo;
      File localFile = new File(paramString);
      if (!localFile.exists())
      {
        if (QLog.isColorLevel()) {
          QLog.d("StructMsg", 2, "handleAppShareAction mShareImageUrl NULL!!!");
        }
        return null;
      }
      String str2 = null;
      str1 = str2;
      for (;;)
      {
        try
        {
          if (!GifDrawable.isGifFile(localFile)) {
            continue;
          }
          str1 = str2;
          l1 = localFile.length();
          if (l1 >= 12582912L) {
            continue;
          }
          paramContext = paramString;
        }
        catch (Exception paramImageInfo)
        {
          boolean bool;
          paramContext = str1;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("StructMsg", 2, paramImageInfo.getMessage());
          paramContext = str1;
          continue;
          paramImageInfo = paramContext;
        }
        if (!TextUtils.isEmpty(paramContext)) {
          continue;
        }
        return null;
        str1 = str2;
        localFile = new File(AbsStructMsg.cG);
        str1 = str2;
        if (!localFile.exists())
        {
          str1 = str2;
          localFile.mkdirs();
        }
        str1 = str2;
        str2 = AbsStructMsg.cG + System.currentTimeMillis() + ".jpg";
        str1 = str2;
        bool = com.tencent.mobileqq.utils.ImageUtil.a(4, paramContext, paramString, str2, true, paramImageInfo, paramInt);
        paramContext = str2;
        if (!bool) {
          paramContext = paramString;
        }
      }
    } while (!QLog.isColorLevel());
    try
    {
      paramImageInfo = new BitmapFactory.Options();
      paramImageInfo.inJustDecodeBounds = true;
      SafeBitmapFactory.decodeFile(paramString, paramImageInfo);
      paramInt = paramImageInfo.outWidth;
      int i = paramImageInfo.outHeight;
      SafeBitmapFactory.decodeFile(paramContext, paramImageInfo);
      int j = paramImageInfo.outWidth;
      int k = paramImageInfo.outHeight;
      l1 = new File(paramString).length();
      long l2 = new File(paramContext).length();
      QLog.d("StructMsg", 2, "srcBmp = " + paramString + ", length = " + l1 + ", srcWidth = " + paramInt + ", srcHeight = " + i + ", destBmp = " + paramContext + ", length = " + l2 + ", destWidth = " + j + ", distHeight = " + k);
      return paramContext;
    }
    catch (Exception paramImageInfo)
    {
      QLog.d("StructMsg", 2, paramImageInfo.getMessage());
    }
    return paramContext;
  }
  
  public static boolean sendAndUploadImageShare(QQAppInterface paramQQAppInterface, StructMsgForImageShare paramStructMsgForImageShare, String paramString1, int paramInt, String paramString2)
  {
    if (paramStructMsgForImageShare == null) {
      return false;
    }
    if ((paramString1 == null) || (paramInt < 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("StructMsg", 2, "handleAppShareAction toUin is NULL!!!");
      }
      return false;
    }
    StructMsgItemImage localStructMsgItemImage = paramStructMsgForImageShare.getFirstImageElement();
    if (localStructMsgItemImage == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("StructMsg", 2, "handleAppShareAction firstImageElement NULL!!!");
      }
      return false;
    }
    int i = MobileQQService.c;
    MobileQQService.c = i + 1;
    long l = i;
    String str = paramQQAppInterface.a();
    if (((paramInt != 1000) && (paramInt != 1020) && (paramInt != 1004)) || (TextUtils.isEmpty(paramString2))) {
      paramString2 = str;
    }
    for (;;)
    {
      localStructMsgItemImage.d = 0L;
      paramStructMsgForImageShare = MessageRecordFactory.a(paramQQAppInterface, str, paramString1, paramString2, paramInt, l, paramStructMsgForImageShare);
      paramQQAppInterface.a().a(paramStructMsgForImageShare, str);
      if (FileUtils.c(localStructMsgItemImage.o))
      {
        paramString2 = HexUtil.bytes2HexStr(MD5.getFileMd5(localStructMsgItemImage.o));
        if (paramString2 == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("StructMsg", 2, "handleAppShareAction MD5 NULL!!!");
          }
          return false;
        }
        paramString2 = URLDrawableHelper.a(paramString2, 1).toString();
        if (!AbsDownloader.a(paramString2))
        {
          paramString2 = AbsDownloader.d(paramString2);
          FileUtils.d(localStructMsgItemImage.o, paramString2);
        }
      }
      paramString2 = new TransferRequest();
      paramString2.jdField_b_of_type_JavaLangString = str;
      paramString2.c = paramString1;
      paramString2.jdField_a_of_type_Int = paramInt;
      paramString2.jdField_b_of_type_Int = 1;
      paramString2.jdField_a_of_type_Long = paramStructMsgForImageShare.uniseq;
      paramString2.jdField_a_of_type_Boolean = true;
      paramString2.e = 1030;
      paramString2.i = localStructMsgItemImage.o;
      paramQQAppInterface.a().a(paramString2);
      return true;
    }
  }
  
  public StructMsgItemImage getFirstImageElement()
  {
    if (this.mStructMsgItemLists != null)
    {
      int i = 0;
      while (i < this.mStructMsgItemLists.size())
      {
        Object localObject = (AbsStructMsgElement)this.mStructMsgItemLists.get(i);
        if ((localObject instanceof AbsStructMsgItem))
        {
          localObject = (AbsStructMsgItem)localObject;
          if (((AbsStructMsgItem)localObject).a != null)
          {
            int j = 0;
            while (j < ((AbsStructMsgItem)localObject).a.size())
            {
              AbsStructMsgElement localAbsStructMsgElement = (AbsStructMsgElement)((AbsStructMsgItem)localObject).a.get(j);
              if ((localAbsStructMsgElement != null) && ((localAbsStructMsgElement instanceof StructMsgItemImage))) {
                return (StructMsgItemImage)localAbsStructMsgElement;
              }
              j += 1;
            }
          }
        }
        i += 1;
      }
    }
    return null;
  }
  
  public View.OnClickListener getOnClickListener()
  {
    return a;
  }
  
  public View getPreDialogView(Context paramContext, View paramView)
  {
    Object localObject1 = paramContext.getResources();
    int i = (int)((Resources)localObject1).getDisplayMetrics().density;
    paramView = new ImageView(paramContext);
    paramView.setScaleType(ImageView.ScaleType.FIT_CENTER);
    paramView.setMaxHeight(i * 288);
    paramView.setAdjustViewBounds(true);
    paramView.setPadding(0, 10, 0, 10);
    Object localObject2 = new LinearLayout.LayoutParams(-1, -2);
    ((LinearLayout.LayoutParams)localObject2).gravity = 17;
    paramView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    paramView.setMinimumHeight(i * 120);
    if (ChatActivityConstants.I) {
      paramView.setContentDescription(paramContext.getString(2131367039));
    }
    paramContext = ((Resources)localObject1).getDrawable(2130843354);
    localObject1 = getFirstImageElement();
    if ((localObject1 != null) && (((StructMsgItemImage)localObject1).o != null))
    {
      localObject2 = ((StructMsgItemImage)localObject1).o;
      if ((!((String)localObject2).startsWith("http://")) && (!((String)localObject2).startsWith("https://")))
      {
        localObject2 = com.tencent.biz.common.util.ImageUtil.a(((StructMsgItemImage)localObject1).o, i * 288);
        if (localObject2 != null)
        {
          paramView.setImageBitmap(com.tencent.mobileqq.utils.ImageUtil.a((Bitmap)localObject2, new File(((StructMsgItemImage)localObject1).o)));
          return paramView;
        }
        paramView.setImageDrawable(paramContext);
        return paramView;
      }
      paramView.setImageDrawable(URLDrawable.getDrawable((String)localObject2, paramContext, paramContext));
      return paramView;
    }
    paramView.setImageDrawable(paramContext);
    return paramView;
  }
  
  public View getView(Context paramContext, View paramView, OnLongClickAndTouchListener paramOnLongClickAndTouchListener, Bundle paramBundle)
  {
    if (this.mMsgException)
    {
      paramContext = getVersionExceptionView(paramContext, paramView, paramOnLongClickAndTouchListener, paramBundle);
      paramContext.setId(2131296312);
      paramContext.setTag(2131296312, this);
      return paramContext;
    }
    paramOnLongClickAndTouchListener = (ViewGroup)super.getView(paramContext, paramView, paramOnLongClickAndTouchListener, paramBundle);
    StructMsgItemImage localStructMsgItemImage = getFirstImageElement();
    if (localStructMsgItemImage != null)
    {
      localStructMsgItemImage.a = this;
      paramOnLongClickAndTouchListener.addView(localStructMsgItemImage.a(paramContext, paramView, paramBundle));
    }
    paramContext = paramOnLongClickAndTouchListener.getLayoutParams();
    if (paramContext == null) {
      paramContext = new LinearLayout.LayoutParams(-2, -2);
    }
    for (;;)
    {
      paramOnLongClickAndTouchListener.setLayoutParams(paramContext);
      paramOnLongClickAndTouchListener.setBackgroundDrawable(null);
      paramOnLongClickAndTouchListener.setId(2131296312);
      paramOnLongClickAndTouchListener.setTag(2131296312, this);
      return paramOnLongClickAndTouchListener;
      paramContext.height = -2;
      paramContext.width = -2;
    }
  }
  
  protected boolean parseContentNode(StructMsgNode paramStructMsgNode)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramStructMsgNode == null)
    {
      bool1 = true;
      return bool1;
    }
    if ("item".equals(paramStructMsgNode.jdField_b_of_type_JavaLangString)) {}
    for (Object localObject = paramStructMsgNode.a("layout");; localObject = StructMsgElementFactory.a(paramStructMsgNode.jdField_b_of_type_JavaLangString))
    {
      try
      {
        if (!TextUtils.isEmpty((CharSequence)localObject)) {}
        for (int i = Integer.parseInt((String)localObject);; i = 0)
        {
          localObject = StructMsgElementFactory.a(i);
          bool1 = bool2;
          if (localObject == null) {
            break;
          }
          bool1 = bool2;
          if (!((AbsStructMsgElement)localObject).a(paramStructMsgNode)) {
            break;
          }
          addItem((AbsStructMsgElement)localObject);
          return true;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
      }
      catch (NumberFormatException paramStructMsgNode)
      {
        bool1 = bool2;
      }
      QLog.d("StructMsg", 2, "Item layout value is " + 0);
      return false;
    }
  }
  
  public void readExternal(ObjectInput paramObjectInput)
  {
    int m = 0;
    for (;;)
    {
      int k;
      int j;
      try
      {
        int n = paramObjectInput.readInt();
        this.mVersion = n;
        Object localObject;
        if (n == 1)
        {
          this.mMsgTemplateID = paramObjectInput.readInt();
          this.mMsgAction = paramObjectInput.readUTF();
          this.mMsgActionData = paramObjectInput.readUTF();
          this.mMsg_A_ActionData = paramObjectInput.readUTF();
          this.mMsg_I_ActionData = paramObjectInput.readUTF();
          this.mMsgUrl = paramObjectInput.readUTF();
          this.mMsgBrief = paramObjectInput.readUTF();
          this.mContentLayout = paramObjectInput.readInt();
          this.mContentCover = paramObjectInput.readUTF();
          this.mContentTitle = paramObjectInput.readUTF();
          this.mContentSummary = paramObjectInput.readUTF();
          localObject = StructMsgElementFactory.a(this.mContentLayout);
          ((AbsStructMsgItem)localObject).a(new StructMsgItemCover(this.mContentCover));
          ((AbsStructMsgItem)localObject).a(new StructMsgItemTitle(this.mContentTitle));
          ((AbsStructMsgItem)localObject).a(new StructMsgItemSummary(this.mContentSummary));
          addItem((AbsStructMsgElement)localObject);
          this.mSourceAppid = paramObjectInput.readLong();
          this.mSourceIcon = paramObjectInput.readUTF();
          this.mSourceName = paramObjectInput.readUTF();
          this.mSourceUrl = paramObjectInput.readUTF();
          this.mSourceAction = paramObjectInput.readUTF();
          this.mSourceActionData = paramObjectInput.readUTF();
          this.mSource_A_ActionData = paramObjectInput.readUTF();
          this.mSource_I_ActionData = paramObjectInput.readUTF();
          this.fwFlag = paramObjectInput.readInt();
          if ((!TextUtils.isEmpty(this.mSourceName)) || (!TextUtils.isEmpty(this.mSourceIcon))) {
            this.mHasSource = true;
          }
        }
        else if (n >= 2)
        {
          this.mMsgTemplateID = paramObjectInput.readInt();
          this.mMsgAction = paramObjectInput.readUTF();
          this.mMsgActionData = paramObjectInput.readUTF();
          this.mMsg_A_ActionData = paramObjectInput.readUTF();
          this.mMsg_I_ActionData = paramObjectInput.readUTF();
          this.mMsgUrl = paramObjectInput.readUTF();
          this.mMsgBrief = paramObjectInput.readUTF();
          int i1 = paramObjectInput.readInt();
          k = 0;
          i = 1;
          if (k < i1)
          {
            localObject = paramObjectInput.readUTF();
            if ("item".equals(localObject))
            {
              localObject = StructMsgElementFactory.a(paramObjectInput.readInt());
              j = i;
              if (localObject == null) {
                break label874;
              }
              ((AbsStructMsgElement)localObject).a(paramObjectInput);
              j = i;
              if (!TextUtils.isEmpty(((AbsStructMsgElement)localObject).c))
              {
                ((AbsStructMsgElement)localObject).m = String.valueOf(i);
                j = i + 1;
              }
              ((AbsStructMsgElement)localObject).n = this.uin;
              addItem((AbsStructMsgElement)localObject);
              break label874;
            }
            AbsStructMsgElement localAbsStructMsgElement = StructMsgElementFactory.a((String)localObject);
            localObject = localAbsStructMsgElement;
            if (localAbsStructMsgElement == null) {
              continue;
            }
            localObject = localAbsStructMsgElement;
            if (!AbsStructMsgItem.class.isInstance(localAbsStructMsgElement)) {
              continue;
            }
            paramObjectInput.readInt();
            localObject = localAbsStructMsgElement;
            continue;
          }
        }
        return;
      }
      catch (IOException paramObjectInput)
      {
        if ((paramObjectInput.getMessage() != null) && (paramObjectInput.getMessage().equals("structmsg_version_error")))
        {
          this.mMsgException = true;
          return;
          this.mSourceAppid = paramObjectInput.readLong();
          this.mSourceIcon = paramObjectInput.readUTF();
          this.mSourceName = paramObjectInput.readUTF();
          this.mSourceUrl = paramObjectInput.readUTF();
          this.mSourceAction = paramObjectInput.readUTF();
          this.mSourceActionData = paramObjectInput.readUTF();
          this.mSource_A_ActionData = paramObjectInput.readUTF();
          this.mSource_I_ActionData = paramObjectInput.readUTF();
          this.fwFlag = paramObjectInput.readInt();
          this.mFlag = paramObjectInput.readInt();
          this.mHasSource = paramObjectInput.readBoolean();
          this.mCommentText = paramObjectInput.readUTF();
          if (n >= 3)
          {
            this.mCompatibleText = paramObjectInput.readUTF();
            this.msgId = paramObjectInput.readLong();
            this.mPromotionType = paramObjectInput.readInt();
            this.mPromotionMsg = paramObjectInput.readUTF();
            this.mPromotionMenus = paramObjectInput.readUTF();
            this.mPromotionMenuDestructiveIndex = paramObjectInput.readInt();
            i = m;
            if (i < this.mStructMsgItemLists.size())
            {
              localObject = (AbsStructMsgElement)this.mStructMsgItemLists.get(i);
              ((AbsStructMsgElement)localObject).jdField_a_of_type_Long = this.msgId;
              ((AbsStructMsgElement)localObject).h = this.mPromotionType;
              i += 1;
              continue;
            }
            if (n >= 5)
            {
              this.source_puin = paramObjectInput.readUTF();
              if (n >= 7)
              {
                this.adverSign = paramObjectInput.readInt();
                this.adverKey = paramObjectInput.readUTF();
                this.index = paramObjectInput.readUTF();
                this.index_name = paramObjectInput.readUTF();
                this.index_type = paramObjectInput.readUTF();
                return;
                this.mMsgException = true;
              }
            }
          }
        }
      }
      label874:
      k += 1;
      int i = j;
    }
  }
  
  protected void toContentXml(uuy paramuuy)
  {
    Iterator localIterator = iterator();
    while (localIterator.hasNext()) {
      ((AbsStructMsgElement)localIterator.next()).a(paramuuy);
    }
  }
  
  public void writeExternal(ObjectOutput paramObjectOutput)
  {
    paramObjectOutput.writeInt(this.mMsgServiceID);
    paramObjectOutput.writeInt(this.mVersion);
    paramObjectOutput.writeInt(this.mMsgTemplateID);
    if (this.mMsgAction == null)
    {
      localObject = "";
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mMsgActionData != null) {
        break label186;
      }
      localObject = "";
      label59:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mMsg_A_ActionData != null) {
        break label194;
      }
      localObject = "";
      label77:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mMsg_I_ActionData != null) {
        break label202;
      }
      localObject = "";
      label95:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mMsgUrl != null) {
        break label210;
      }
      localObject = "";
      label113:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mMsgBrief != null) {
        break label218;
      }
    }
    label186:
    label194:
    label202:
    label210:
    label218:
    for (Object localObject = "";; localObject = this.mMsgBrief)
    {
      paramObjectOutput.writeUTF((String)localObject);
      paramObjectOutput.writeInt(getItemCount());
      localObject = iterator();
      while (((Iterator)localObject).hasNext()) {
        ((AbsStructMsgElement)((Iterator)localObject).next()).a(paramObjectOutput);
      }
      localObject = this.mMsgAction;
      break;
      localObject = this.mMsgActionData;
      break label59;
      localObject = this.mMsg_A_ActionData;
      break label77;
      localObject = this.mMsg_I_ActionData;
      break label95;
      localObject = this.mMsgUrl;
      break label113;
    }
    paramObjectOutput.writeLong(this.mSourceAppid);
    if (this.mSourceIcon == null)
    {
      localObject = "";
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mSourceName != null) {
        break label585;
      }
      localObject = "";
      label265:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mSourceUrl != null) {
        break label593;
      }
      localObject = "";
      label283:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mSourceAction != null) {
        break label601;
      }
      localObject = "";
      label301:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mSourceActionData != null) {
        break label609;
      }
      localObject = "";
      label319:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mSource_A_ActionData != null) {
        break label617;
      }
      localObject = "";
      label337:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mSource_I_ActionData != null) {
        break label625;
      }
      localObject = "";
      label355:
      paramObjectOutput.writeUTF((String)localObject);
      paramObjectOutput.writeInt(this.fwFlag);
      paramObjectOutput.writeInt(this.mFlag);
      paramObjectOutput.writeBoolean(this.mHasSource);
      if (this.mCommentText != null) {
        break label633;
      }
      localObject = "";
      label403:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mCompatibleText != null) {
        break label641;
      }
      localObject = "";
      label421:
      paramObjectOutput.writeUTF((String)localObject);
      paramObjectOutput.writeLong(this.msgId);
      paramObjectOutput.writeInt(this.mPromotionType);
      if (this.mPromotionMsg != null) {
        break label649;
      }
      localObject = "";
      label459:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mPromotionMenus != null) {
        break label657;
      }
      localObject = "";
      label477:
      paramObjectOutput.writeUTF((String)localObject);
      paramObjectOutput.writeInt(this.mPromotionMenuDestructiveIndex);
      paramObjectOutput.writeInt(this.adverSign);
      if (this.adverKey != null) {
        break label665;
      }
      localObject = "";
      label515:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.index != null) {
        break label673;
      }
      localObject = "";
      label533:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.index_name != null) {
        break label681;
      }
      localObject = "";
      label551:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.index_type != null) {
        break label689;
      }
    }
    label585:
    label593:
    label601:
    label609:
    label617:
    label625:
    label633:
    label641:
    label649:
    label657:
    label665:
    label673:
    label681:
    label689:
    for (localObject = "";; localObject = this.index_type)
    {
      paramObjectOutput.writeUTF((String)localObject);
      return;
      localObject = this.mSourceIcon;
      break;
      localObject = this.mSourceName;
      break label265;
      localObject = this.mSourceUrl;
      break label283;
      localObject = this.mSourceAction;
      break label301;
      localObject = this.mSourceActionData;
      break label319;
      localObject = this.mSource_A_ActionData;
      break label337;
      localObject = this.mSource_I_ActionData;
      break label355;
      localObject = this.mCommentText;
      break label403;
      localObject = this.mCompatibleText;
      break label421;
      localObject = this.mPromotionMsg;
      break label459;
      localObject = this.mPromotionMenus;
      break label477;
      localObject = this.adverKey;
      break label515;
      localObject = this.index;
      break label533;
      localObject = this.index_name;
      break label551;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\structmsg\StructMsgForImageShare.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import com.tencent.image.GifDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.item.ChatThumbView;
import com.tencent.mobileqq.activity.aio.item.PicItemBuilder;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.structmsg.StructMsgNode;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.qphone.base.util.QLog;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.net.URL;
import org.xmlpull.v1.XmlSerializer;

public class StructMsgItemImage
  extends AbsStructMsgElement
{
  public MessageForPic a;
  public StructMsgForImageShare a;
  public URL a;
  public long c;
  public long d;
  public long e;
  public String o;
  public String p;
  public String q;
  
  public StructMsgItemImage()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangString = "image";
  }
  
  public StructMsgItemImage(String paramString)
  {
    this();
    this.o = paramString;
  }
  
  public View a(Context paramContext, View paramView, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null)
    {
      paramBundle = URLDrawableHelper.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic, 65537);
      if ((this.jdField_a_of_type_JavaNetURL != null) && (this.jdField_a_of_type_JavaNetURL.equals(paramBundle))) {}
    }
    for (paramBundle = PicItemBuilder.a(paramContext, this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic);; paramBundle = null)
    {
      Object localObject = paramBundle;
      if (paramBundle == null)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("StructMsg", 2, "StructMsgItemImage.createView.mImageShareMsg == null nudnik trick");
          }
          return new View(paramContext);
        }
        MessageForPic localMessageForPic = new MessageForPic();
        localMessageForPic.path = this.o;
        localMessageForPic.uuid = this.p;
        localMessageForPic.md5 = this.q;
        localMessageForPic.istroop = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.uinType;
        localMessageForPic.msgtype = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.mMsgType;
        localMessageForPic.versionCode = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.messageVersion;
        localMessageForPic.uniseq = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.mUniseq;
        localMessageForPic.issend = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.mIsSend;
        localMessageForPic.selfuin = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.currentAccountUin;
        localMessageForPic.frienduin = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.uin;
        localMessageForPic.groupFileID = this.c;
        localMessageForPic.busiType = 1030;
        if (this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.mIsSend == 1)
        {
          paramBundle = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.currentAccountUin;
          localMessageForPic.senderuin = paramBundle;
          localMessageForPic.size = this.d;
          localMessageForPic.time = this.e;
          localMessageForPic.subVersion = 5;
          localMessageForPic.fileSizeFlag = 0;
          paramBundle = AbsDownloader.a(URLDrawableHelper.a(localMessageForPic, 1, null).toString());
          if ((paramBundle != null) && (GifDrawable.isGifFile(paramBundle))) {
            localMessageForPic.imageType = 2000;
          }
          localObject = PicItemBuilder.a(paramContext, localMessageForPic);
          this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic = localMessageForPic;
          this.jdField_a_of_type_JavaNetURL = ((URLDrawable)localObject).getURL();
        }
      }
      else
      {
        if ((paramView == null) || (!(paramView instanceof ChatThumbView))) {
          break label364;
        }
        paramContext = (ChatThumbView)paramView;
      }
      for (;;)
      {
        paramContext.setImageDrawable((Drawable)localObject);
        return paramContext;
        paramBundle = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.uin;
        break;
        label364:
        paramContext = new ChatThumbView(paramContext);
        paramContext.setAdjustViewBounds(true);
        paramContext.setMaxWidth(URLDrawableHelper.a(false));
        paramContext.setMaxHeight(URLDrawableHelper.a(false));
      }
    }
  }
  
  public MessageForPic a()
  {
    MessageForPic localMessageForPic = new MessageForPic();
    if (this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("StructMsg", 2, "StructMsgItemImage.generateMessageForPic.mImageShareMsg == null nudnik trick");
      }
      return localMessageForPic;
    }
    localMessageForPic.path = this.o;
    localMessageForPic.uuid = this.p;
    localMessageForPic.md5 = this.q;
    localMessageForPic.istroop = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.uinType;
    localMessageForPic.msgtype = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.mMsgType;
    localMessageForPic.versionCode = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.messageVersion;
    localMessageForPic.uniseq = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.mUniseq;
    localMessageForPic.issend = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.mIsSend;
    localMessageForPic.selfuin = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.currentAccountUin;
    localMessageForPic.frienduin = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.uin;
    localMessageForPic.groupFileID = this.c;
    localMessageForPic.busiType = 1030;
    if (this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.mIsSend == 1) {}
    for (String str = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.currentAccountUin;; str = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.uin)
    {
      localMessageForPic.senderuin = str;
      localMessageForPic.size = this.d;
      localMessageForPic.time = this.e;
      localMessageForPic.subVersion = 5;
      localMessageForPic.fileSizeFlag = 0;
      return localMessageForPic;
    }
  }
  
  public String a()
  {
    return "Image";
  }
  
  public void a(ObjectInput paramObjectInput)
  {
    super.a(paramObjectInput);
    this.o = paramObjectInput.readUTF();
    this.p = paramObjectInput.readUTF();
    this.q = paramObjectInput.readUTF();
    this.c = paramObjectInput.readLong();
    this.d = paramObjectInput.readLong();
    this.e = paramObjectInput.readLong();
  }
  
  public void a(ObjectOutput paramObjectOutput)
  {
    super.a(paramObjectOutput);
    if (this.o == null)
    {
      str = "";
      paramObjectOutput.writeUTF(str);
      if (this.p != null) {
        break label95;
      }
      str = "";
      label32:
      paramObjectOutput.writeUTF(str);
      if (this.q != null) {
        break label103;
      }
    }
    label95:
    label103:
    for (String str = "";; str = this.q)
    {
      paramObjectOutput.writeUTF(str);
      paramObjectOutput.writeLong(this.c);
      paramObjectOutput.writeLong(this.d);
      paramObjectOutput.writeLong(this.e);
      return;
      str = this.o;
      break;
      str = this.p;
      break label32;
    }
  }
  
  public void a(XmlSerializer paramXmlSerializer)
  {
    paramXmlSerializer.startTag(null, "image");
    if (this.p == null)
    {
      str = "";
      paramXmlSerializer.attribute(null, "uuid", str);
      if (this.q != null) {
        break label130;
      }
      str = "";
      label41:
      paramXmlSerializer.attribute(null, "md5", str);
      paramXmlSerializer.attribute(null, "GroupFiledid", String.valueOf(this.c));
      paramXmlSerializer.attribute(null, "filesize", String.valueOf(this.d));
      if (this.o != null) {
        break label138;
      }
    }
    label130:
    label138:
    for (String str = "";; str = this.o)
    {
      paramXmlSerializer.attribute(null, "local_path", str);
      paramXmlSerializer.endTag(null, "image");
      return;
      str = this.p;
      break;
      str = this.q;
      break label41;
    }
  }
  
  public boolean a(StructMsgNode paramStructMsgNode)
  {
    if (paramStructMsgNode == null) {}
    for (;;)
    {
      return true;
      String str3 = paramStructMsgNode.a("uuid");
      String str2 = paramStructMsgNode.a("md5");
      String str5 = paramStructMsgNode.a("md5");
      String str4 = paramStructMsgNode.a("filesize");
      String str1 = paramStructMsgNode.a("local_path");
      paramStructMsgNode = str3;
      if (str3 == null) {
        paramStructMsgNode = "";
      }
      this.p = paramStructMsgNode;
      if (str2 == null)
      {
        paramStructMsgNode = "";
        label71:
        this.q = paramStructMsgNode;
        if (str1 != null) {
          break label142;
        }
        paramStructMsgNode = "";
        this.o = paramStructMsgNode;
        if (str5 == null) {}
      }
      try
      {
        this.c = Long.parseLong(str5);
        if (str4 == null) {
          continue;
        }
        try
        {
          this.d = Long.parseLong(str4);
          return true;
        }
        catch (NumberFormatException paramStructMsgNode) {}
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("StructMsg", 2, paramStructMsgNode.getMessage());
        return true;
        paramStructMsgNode = str2;
        break label71;
        label142:
        paramStructMsgNode = str1;
      }
      catch (NumberFormatException paramStructMsgNode)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("StructMsg", 2, paramStructMsgNode.getMessage());
          }
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\structmsg\view\StructMsgItemImage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
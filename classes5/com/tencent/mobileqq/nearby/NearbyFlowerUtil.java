package com.tencent.mobileqq.nearby;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.magicface.magicfaceaction.ActionGlobalData;
import com.tencent.mobileqq.magicface.magicfaceaction.MagicfaceActionDecoder;
import com.tencent.mobileqq.magicface.model.MagicfaceResLoader;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout12;
import com.tencent.mobileqq.troop.utils.TroopGiftUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class NearbyFlowerUtil
{
  public static int a = 0;
  public static final String a;
  public static final String b = "nearby_flower_task_id";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = NearbyFlowerUtil.class.getSimpleName();
  }
  
  public static int a(Context paramContext)
  {
    if (jdField_a_of_type_Int > 0) {
      return jdField_a_of_type_Int;
    }
    jdField_a_of_type_Int = paramContext.getResources().getDimensionPixelSize(2131492908);
    return jdField_a_of_type_Int;
  }
  
  public static int a(MessageForStructing paramMessageForStructing)
  {
    paramMessageForStructing = (AbsShareMsg)paramMessageForStructing.structingMsg;
    if (paramMessageForStructing.getItemCount() > 0)
    {
      paramMessageForStructing = paramMessageForStructing.getItemByIndex(0);
      if ((paramMessageForStructing instanceof StructMsgItemLayout12))
      {
        paramMessageForStructing = (StructMsgItemLayout12)paramMessageForStructing;
        if (paramMessageForStructing.a.size() > 0)
        {
          paramMessageForStructing = paramMessageForStructing.a.getString("fCount");
          if (!TextUtils.isEmpty(paramMessageForStructing)) {
            return Integer.valueOf(paramMessageForStructing).intValue();
          }
        }
      }
    }
    return 0;
  }
  
  public static ActionGlobalData a(String paramString)
  {
    paramString = new MagicfaceResLoader(a(paramString), 2).a("receive.xml");
    if (paramString == null) {
      return null;
    }
    return new MagicfaceActionDecoder().a(paramString);
  }
  
  public static DownloaderInterface a(QQAppInterface paramQQAppInterface)
  {
    return ((DownloaderFactory)paramQQAppInterface.getManager(46)).a(1);
  }
  
  public static String a(MessageForStructing paramMessageForStructing)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramMessageForStructing = (AbsShareMsg)paramMessageForStructing.structingMsg;
    if (paramMessageForStructing.getItemCount() > 0)
    {
      paramMessageForStructing = paramMessageForStructing.getItemByIndex(0);
      if ((paramMessageForStructing instanceof StructMsgItemLayout12))
      {
        Object localObject = (StructMsgItemLayout12)paramMessageForStructing;
        if (((StructMsgItemLayout12)localObject).a.size() > 0)
        {
          paramMessageForStructing = ((StructMsgItemLayout12)localObject).a.getString("sNick");
          String str = ((StructMsgItemLayout12)localObject).a.getString("rNick");
          localObject = ((StructMsgItemLayout12)localObject).a.getString("cMean");
          localStringBuilder.append(paramMessageForStructing).append("送给").append(str).append((String)localObject);
        }
      }
    }
    return localStringBuilder.toString();
  }
  
  public static String a(NearbyFlowerMessage paramNearbyFlowerMessage)
  {
    return "http://sqimg.qq.com/qq_product_operations/flower/animation/android/" + paramNearbyFlowerMessage.pURL;
  }
  
  public static String a(String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(AppConstants.cY).append(paramString).append(File.separator);
    return localStringBuffer.toString();
  }
  
  public static List a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    paramString = new File(a(paramString));
    if (paramString.exists())
    {
      paramString = paramString.listFiles();
      if (paramString == null) {
        return localArrayList;
      }
      int i = 0;
      while (i < paramString.length)
      {
        if (paramString[i].getAbsolutePath().endsWith(".png")) {
          localArrayList.add(paramString[i].getAbsolutePath());
        }
        i += 1;
      }
    }
    return localArrayList;
  }
  
  public static void a(HashMap paramHashMap)
  {
    HashMap localHashMap = new HashMap();
    Object localObject = new File(AppConstants.cY);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    localObject = ((File)localObject).listFiles();
    if (localObject != null)
    {
      int i = 0;
      if (i < localObject.length)
      {
        if ((localObject[i].exists()) && (localObject[i].isDirectory()))
        {
          if (!a(localObject[i].getName())) {
            break label137;
          }
          localHashMap.put(localObject[i].getName(), Integer.valueOf(3));
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "Package Downloaded:" + localObject[i].getName());
          }
        }
        for (;;)
        {
          i += 1;
          break;
          label137:
          FileUtils.a(localObject[i].getAbsolutePath());
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "Package deleted:" + localObject[i].getName());
          }
        }
      }
    }
    paramHashMap.putAll(localHashMap);
  }
  
  public static boolean a(MessageRecord paramMessageRecord)
  {
    if (!(paramMessageRecord instanceof ChatMessage)) {
      return false;
    }
    paramMessageRecord = (ChatMessage)paramMessageRecord;
    if ((paramMessageRecord instanceof MessageForStructing))
    {
      paramMessageRecord = (MessageForStructing)paramMessageRecord;
      if ((paramMessageRecord.structingMsg != null) && ((paramMessageRecord.structingMsg instanceof AbsShareMsg)) && (paramMessageRecord.structingMsg.mMsgServiceID == 52))
      {
        paramMessageRecord = (AbsShareMsg)paramMessageRecord.structingMsg;
        if ((paramMessageRecord.getItemCount() <= 0) || (!(paramMessageRecord.getItemByIndex(0) instanceof StructMsgItemLayout12))) {}
      }
    }
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static boolean a(String paramString)
  {
    return !TroopGiftUtil.a(a(paramString));
  }
  
  public static String b(String paramString)
  {
    return a(paramString) + paramString + ".zip";
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\nearby\NearbyFlowerUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
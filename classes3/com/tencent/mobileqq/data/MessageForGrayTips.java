package com.tencent.mobileqq.data;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;
import rbr;
import rby;

public class MessageForGrayTips
  extends ChatMessage
{
  public static final int ABILITY_SUPPORT_COLOR = 2;
  public static final int ABILITY_SUPPORT_IMAGE = 1;
  private static final String KEY_NEW_HIGHTLIGHT_ITEM_TAG = "new_item_tag";
  private static final String TAG = MessageForGrayTips.class.getSimpleName();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static void decodeImageSpan(Context paramContext, SpannableStringBuilder paramSpannableStringBuilder, MessageForGrayTips.HightlightItem paramHightlightItem)
  {
    if ((paramHightlightItem.icon.startsWith("http://")) || (paramHightlightItem.icon.startsWith("https://")))
    {
      paramSpannableStringBuilder.setSpan(new rbr(paramContext, 0, paramHightlightItem.icon), paramHightlightItem.start, paramHightlightItem.end, 33);
      if (QLog.isColorLevel()) {
        QLog.i(TAG, 2, "MessageForGrayTips.getHightlightMsgText Url Image=" + paramHightlightItem.icon);
      }
      return;
    }
    int i = paramHightlightItem.icon.indexOf('.');
    if (i != -1) {}
    for (String str = paramHightlightItem.icon.substring(0, i);; str = paramHightlightItem.icon)
    {
      i = paramContext.getResources().getIdentifier(str, "drawable", paramContext.getPackageName());
      if (i != 0) {
        paramSpannableStringBuilder.setSpan(new rby(paramContext, i), paramHightlightItem.start, paramHightlightItem.end, 33);
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i(TAG, 2, "MessageForGrayTips.getHightlightMsgText Image=" + str + " resourceId:" + i);
      return;
    }
  }
  
  public static String getOrginMsg(String paramString)
  {
    String str;
    if (paramString == null) {
      str = null;
    }
    int i;
    do
    {
      return str;
      i = paramString.indexOf("                    ##**##");
      str = paramString;
    } while (i == -1);
    return paramString.substring(0, i);
  }
  
  public void addHightlightItem(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    int j = 1;
    if (paramInt1 >= paramInt2) {
      return;
    }
    String str2;
    String str1;
    String str4;
    label164:
    label215:
    label245:
    label295:
    Object localObject2;
    try
    {
      Object localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("new_item_tag", true);
      this.extStr = ((JSONObject)localObject1).toString();
      if (paramBundle == null)
      {
        str2 = null;
        str3 = null;
        str1 = null;
        i = -1;
        try
        {
          if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "addHightlightItem ==>actionType:" + i);
          }
          str4 = "," + i + "," + paramInt1 + "," + paramInt2;
          localObject1 = str4;
          switch (i)
          {
          case 4: 
            paramBundle = (String)localObject1 + ",icon";
            if (str3 != null)
            {
              paramBundle = paramBundle + ",1," + str3;
              if (str2 == null) {
                break label543;
              }
              paramBundle = paramBundle + ",1," + str2;
              paramBundle = paramBundle + ",color";
              if (str1 == null) {
                break label566;
              }
              paramBundle = paramBundle + ",1," + str1;
              paramInt1 = this.msg.indexOf("                    ##**##");
              if (paramInt1 != -1) {
                break label589;
              }
              this.msg = (this.msg + "                    ##**##" + "1" + paramBundle);
            }
            break;
          }
        }
        catch (Exception paramBundle)
        {
          paramBundle.printStackTrace();
          return;
        }
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        String str3;
        int i;
        if (QLog.isColorLevel())
        {
          QLog.e(TAG, 2, "addHightlightItem JSONException");
          continue;
          i = paramBundle.getInt("key_action");
          str1 = paramBundle.getString("textColor");
          str3 = paramBundle.getString("image_resource");
          str2 = paramBundle.getString("image_alt");
        }
      }
      localObject2 = paramBundle.getString("troop_mem_uin");
      if (!paramBundle.getBoolean("need_update_nick")) {}
    }
    for (paramInt1 = j;; paramInt1 = 0)
    {
      localObject2 = str4 + "," + paramInt1 + "," + (String)localObject2;
      break label164;
      localObject2 = paramBundle.getString("key_action_DATA");
      paramBundle = paramBundle.getString("key_a_action_DATA");
      localObject2 = str4 + "," + (String)localObject2 + "," + paramBundle;
      break label164;
      paramBundle = paramBundle + ",0";
      break label215;
      label543:
      paramBundle = paramBundle + ",0";
      break label245;
      label566:
      paramBundle = paramBundle + ",0";
      break label295;
      label589:
      localObject2 = this.msg.substring(0, paramInt1);
      str2 = this.msg.substring(paramInt1 + "                    ##**##".length(), this.msg.length());
      paramInt1 = str2.indexOf(',');
      str1 = str2.substring(0, paramInt1);
      str2 = str2.substring(paramInt1, str2.length());
      paramInt1 = Integer.parseInt(str1);
      paramBundle = paramInt1 + 1 + str2 + paramBundle;
      this.msg = ((String)localObject2 + "                    ##**##" + paramBundle);
      if ((!QLog.isColorLevel()) || (!(this instanceof MessageForDeliverGiftTips))) {
        break;
      }
      QLog.i(".troop.send_gift", 2, "MessageForGrayTips.addHightlightItem:" + this.msg);
      return;
      localObject2 = str4;
      break label164;
    }
  }
  
  public boolean checkAbillity(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      return isSupportImage();
    }
    return isSupportColor();
  }
  
  protected void doParse() {}
  
  public SpannableStringBuilder getHightlightMsgText(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    boolean bool = false;
    int i;
    String str2;
    Object localObject6;
    Object localObject1;
    int i4;
    ArrayList localArrayList;
    int n;
    try
    {
      if (this.extStr != null) {
        bool = new JSONObject(this.extStr).getBoolean("new_item_tag");
      }
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "getHightlightMsgText==> isNewHighlitItem:" + bool);
      }
      String str1 = this.msg;
      i = -1;
      if (!TextUtils.isEmpty(str1)) {
        i = str1.indexOf("                    ##**##");
      }
      if (i == -1) {
        return new SpannableStringBuilder(str1);
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e(TAG, 2, "getHightlightMsgText JSONException");
        }
        bool = false;
      }
      str2 = this.msg.substring(0, i);
      localObject6 = this.msg.substring(i + "                    ##**##".length(), this.msg.length());
      i = ((String)localObject6).indexOf(',');
      localObject1 = ((String)localObject6).substring(0, i);
      localObject6 = ((String)localObject6).substring(i + 1, ((String)localObject6).length());
      i4 = Integer.parseInt((String)localObject1);
      new LinkedList();
      localArrayList = new ArrayList(i4);
      n = 0;
    }
    int i1;
    int j;
    int k;
    label244:
    Object localObject7;
    Object localObject9;
    Object localObject8;
    Object localObject10;
    int m;
    if (n < i4)
    {
      i1 = -1;
      i = 0;
      j = 0;
      if (bool)
      {
        k = 0;
        localObject7 = null;
        localObject9 = null;
        localObject8 = null;
        localObject10 = null;
        m = Color.parseColor("#FF00a5e0");
        localObject1 = localObject6;
        if (!bool) {}
      }
    }
    for (;;)
    {
      Object localObject11;
      try
      {
        i = ((String)localObject6).indexOf(',');
        localObject1 = ((String)localObject6).substring(0, i);
        localObject6 = ((String)localObject6).substring(i + 1, ((String)localObject6).length());
        i1 = Integer.parseInt((String)localObject1);
        i = ((String)localObject6).indexOf(',');
        localObject11 = ((String)localObject6).substring(0, i);
        localObject1 = ((String)localObject6).substring(i + 1, ((String)localObject6).length());
        i = Integer.parseInt((String)localObject11);
        j = ((String)localObject1).indexOf(',');
        if (j != -1)
        {
          localObject6 = ((String)localObject1).substring(0, j);
          localObject1 = ((String)localObject1).substring(j + 1, ((String)localObject1).length());
          j = Integer.parseInt((String)localObject6);
          if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "getHightlightMsgText==> actionType:" + i1);
          }
          switch (i1)
          {
          case 0: 
          case 8: 
          case 9: 
          case 10: 
          default: 
            if (bool)
            {
              localObject6 = "";
              l = 0L;
              if (TextUtils.isEmpty((CharSequence)localObject6)) {}
            }
            break;
          }
        }
      }
      catch (NumberFormatException localNumberFormatException1)
      {
        long l;
        int i3;
        int i5;
        QLog.d(TAG, 2, "getHightlightMsgText==> decodeMagicString error.msg:" + this.msg, localNumberFormatException1);
      }
      try
      {
        l = Long.parseLong((String)localObject6);
        i3 = 0;
        i5 = ((String)localObject1).indexOf(',');
        i2 = i3;
        localObject6 = localObject1;
        if (i5 != -1)
        {
          i2 = i3;
          localObject6 = localObject1;
          if ("icon".equals(((String)localObject1).substring(0, i5)))
          {
            i2 = 1;
            localObject6 = ((String)localObject1).substring(i5 + 1, ((String)localObject1).length());
          }
        }
        if (!checkAbillity(1)) {
          if (i2 == 0) {
            break label2172;
          }
        }
      }
      catch (NumberFormatException localNumberFormatException3)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e(TAG, 2, "getHightlightMsgText ==>NumberFormatException");
          }
        }
        i2 = Integer.parseInt((String)localObject6);
        Object localObject3 = localObject6;
        continue;
        i2 = Integer.parseInt((String)localObject6);
        continue;
        localObject7 = localObject6;
        continue;
        localObject7 = null;
        continue;
      }
      try
      {
        i2 = ((String)localObject6).indexOf(',');
        if (i2 != -1)
        {
          localObject7 = ((String)localObject6).substring(0, i2);
          localObject1 = ((String)localObject6).substring(i2 + 1, ((String)localObject6).length());
          i2 = Integer.parseInt((String)localObject7);
          if (i2 == 0) {
            break label2224;
          }
          i2 = ((String)localObject1).indexOf(',');
          if (i2 == -1) {
            break label2212;
          }
          localObject6 = ((String)localObject1).substring(0, i2);
          localObject7 = ((String)localObject1).substring(i2 + 1, ((String)localObject1).length());
          localObject1 = localObject6;
          localObject6 = localObject7;
          i2 = ((String)localObject6).indexOf(',');
          if (i2 == -1) {
            break label1549;
          }
          localObject7 = ((String)localObject6).substring(0, i2);
          localObject6 = ((String)localObject6).substring(i2 + 1, ((String)localObject6).length());
          i2 = Integer.parseInt((String)localObject7);
          if (i2 == 0) {
            break label1566;
          }
          i2 = ((String)localObject6).indexOf(',');
          if (i2 == -1) {
            break label1559;
          }
          localObject7 = ((String)localObject6).substring(0, i2);
          localObject6 = ((String)localObject6).substring(i2 + 1, ((String)localObject6).length());
          localObject10 = localObject6;
          localObject6 = localObject1;
          localObject1 = localObject10;
          i2 = ((String)localObject1).indexOf(',');
          if ((i2 == -1) || (!"color".equals(((String)localObject1).substring(0, i2)))) {
            break label2166;
          }
          localObject1 = ((String)localObject1).substring(i2 + 1, ((String)localObject1).length());
          i2 = 1;
          if (!checkAbillity(2)) {
            if (i2 == 0) {
              break label2163;
            }
          }
        }
      }
      catch (NumberFormatException localNumberFormatException4)
      {
        if (!QLog.isColorLevel()) {
          break label1047;
        }
        QLog.e(TAG, 2, "parse gray tips image resource or alt failed. msg:" + this.msg + "exception:" + localNumberFormatException4.getStackTrace());
        break label1047;
        i2 = Integer.parseInt(localNumberFormatException4);
        continue;
        localObject11 = localNumberFormatException4;
        localObject10 = localNumberFormatException4;
        Object localObject4 = localObject11;
        continue;
      }
      try
      {
        i2 = ((String)localObject1).indexOf(',');
        if (i2 == -1) {
          break label1625;
        }
        localObject10 = ((String)localObject1).substring(0, i2);
        localObject1 = ((String)localObject1).substring(i2 + 1, ((String)localObject1).length());
        i2 = Integer.parseInt((String)localObject10);
        if (i2 == 0) {
          break label2160;
        }
        m = ((String)localObject1).indexOf(',');
        if (m == -1) {
          break label1634;
        }
        localObject10 = ((String)localObject1).substring(0, m);
        localObject1 = ((String)localObject1).substring(m + 1, ((String)localObject1).length());
        m = Color.parseColor((String)localObject10);
        localArrayList.add(new MessageForGrayTips.HightlightItem(i, j, l, k, i1, (String)localObject9, (String)localObject8, (String)localObject6, (String)localObject7, m));
        n += 1;
        localObject6 = localObject1;
      }
      catch (NumberFormatException localNumberFormatException5)
      {
        if (!QLog.isColorLevel()) {
          break label1047;
        }
        QLog.e(TAG, 2, "parse gray tips hasColor failed. msg:" + this.msg + "exception:" + localNumberFormatException5.getStackTrace());
        break label1047;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        if (!QLog.isColorLevel()) {
          break label1047;
        }
        QLog.e(TAG, 2, "parse gray tips text color failed. msg:" + this.msg + "exception:" + localIllegalArgumentException.getStackTrace());
        break label1047;
        i += 1;
        break label1050;
        localObject8 = (TroopManager)paramQQAppInterface.getManager(51);
        localObject9 = localArrayList.iterator();
        localObject5 = str2;
        localObject6 = "";
        i = 0;
        if (!((Iterator)localObject9).hasNext()) {
          break label2008;
        }
        localObject7 = (MessageForGrayTips.HightlightItem)((Iterator)localObject9).next();
        localObject10 = (String)localObject6 + ((String)localObject5).substring(0, ((MessageForGrayTips.HightlightItem)localObject7).start - i);
        localObject11 = ((String)localObject5).substring(((MessageForGrayTips.HightlightItem)localObject7).start - i, ((MessageForGrayTips.HightlightItem)localObject7).end - i);
        localObject6 = ((String)localObject5).substring(((MessageForGrayTips.HightlightItem)localObject7).end - i, ((String)localObject5).length());
        i = ((MessageForGrayTips.HightlightItem)localObject7).end;
        ((MessageForGrayTips.HightlightItem)localObject7).start = ((String)localObject10).length();
        if (!((MessageForGrayTips.HightlightItem)localObject7).needUpdateNick) {
          break label1984;
        }
        for (localObject5 = (String)localObject10 + ((TroopManager)localObject8).a(this.frienduin, new StringBuilder().append("").append(((MessageForGrayTips.HightlightItem)localObject7).uin).toString());; localObject5 = (String)localObject10 + (String)localObject11)
        {
          ((MessageForGrayTips.HightlightItem)localObject7).end = ((String)localObject5).length();
          localObject7 = localObject5;
          localObject5 = localObject6;
          localObject6 = localObject7;
          break;
        }
        localObject5 = new SpannableStringBuilder((String)localObject6 + (String)localObject5);
        localObject6 = localArrayList.iterator();
        while (((Iterator)localObject6).hasNext())
        {
          localObject7 = (MessageForGrayTips.HightlightItem)((Iterator)localObject6).next();
          if (localObject7 != null) {
            if (TextUtils.isEmpty(((MessageForGrayTips.HightlightItem)localObject7).icon)) {
              ((SpannableStringBuilder)localObject5).setSpan(new MessageForGrayTips.HightlightClickableSpan(paramQQAppInterface, ((MessageForGrayTips.HightlightItem)localObject7).textColor, paramContext, (MessageForGrayTips.HightlightItem)localObject7, this), ((MessageForGrayTips.HightlightItem)localObject7).start, ((MessageForGrayTips.HightlightItem)localObject7).end, 33);
            } else {
              decodeImageSpan(paramContext, (SpannableStringBuilder)localObject5, (MessageForGrayTips.HightlightItem)localObject7);
            }
          }
        }
        if (!QLog.isColorLevel()) {
          break label2158;
        }
        QLog.i(".troop.send_gift", 2, "MessageForGrayTips.getHightlightMsgText:" + localObject5);
        return (SpannableStringBuilder)localObject5;
      }
      k = 1;
      break label244;
      j = Integer.parseInt((String)localObject1);
      continue;
      for (;;)
      {
        label1047:
        i = 0;
        label1050:
        if (i >= localArrayList.size() - 1) {
          break label1761;
        }
        j = i + 1;
        while (j < localArrayList.size())
        {
          if (((MessageForGrayTips.HightlightItem)localArrayList.get(i)).start > ((MessageForGrayTips.HightlightItem)localArrayList.get(j)).start)
          {
            localObject2 = (MessageForGrayTips.HightlightItem)localArrayList.get(i);
            localArrayList.add(i, localArrayList.get(j));
            localArrayList.add(j, localObject2);
          }
          j += 1;
        }
        localObject6 = "";
        break;
        try
        {
          k = ((String)localObject2).indexOf(',');
          localObject6 = ((String)localObject2).substring(0, k);
          localObject2 = ((String)localObject2).substring(k + 1, ((String)localObject2).length());
          k = Integer.parseInt((String)localObject6);
          i2 = ((String)localObject2).indexOf(',');
          if (i2 == -1) {
            break label2187;
          }
          localObject6 = ((String)localObject2).substring(0, i2);
          localObject2 = ((String)localObject2).substring(i2 + 1, ((String)localObject2).length());
        }
        catch (NumberFormatException localNumberFormatException2)
        {
          QLog.d(TAG, 2, "getHightlightMsgText==> decodeMagicString error.msg:" + this.msg, localNumberFormatException2);
        }
        i2 = ((String)localObject2).indexOf(',');
        localObject6 = localObject2;
        if (i2 != -1)
        {
          localObject7 = ((String)localObject2).substring(0, i2);
          localObject6 = ((String)localObject2).substring(i2 + 1, ((String)localObject2).length());
        }
        i2 = ((String)localObject6).indexOf(',');
        if (i2 == -1) {
          break label2193;
        }
        localObject8 = ((String)localObject6).substring(0, i2);
        Object localObject2 = ((String)localObject6).substring(i2 + 1, ((String)localObject6).length());
        localObject6 = "";
        localObject9 = localObject7;
        break;
        i = ((String)localObject2).indexOf(',');
        localObject6 = ((String)localObject2).substring(0, i);
        localObject2 = ((String)localObject2).substring(i + 1, ((String)localObject2).length());
        i = Integer.parseInt((String)localObject6);
        j = ((String)localObject2).indexOf(',');
        localObject6 = ((String)localObject2).substring(0, j);
        localObject2 = ((String)localObject2).substring(j + 1, ((String)localObject2).length());
        j = Integer.parseInt((String)localObject6);
        k = ((String)localObject2).indexOf(',');
        localObject6 = ((String)localObject2).substring(0, k);
        localObject2 = ((String)localObject2).substring(k + 1, ((String)localObject2).length());
        k = Integer.parseInt((String)localObject6);
        i2 = ((String)localObject2).indexOf(',');
        if (i2 != -1)
        {
          localObject6 = ((String)localObject2).substring(0, i2);
          localObject2 = ((String)localObject2).substring(i2 + 1, ((String)localObject2).length());
          break;
        }
        localObject6 = localObject2;
        break;
      }
      label1549:
      label1559:
      label1566:
      label1625:
      label1634:
      label1761:
      label1984:
      label2008:
      label2158:
      label2160:
      continue;
      label2163:
      continue;
      label2166:
      int i2 = 0;
      continue;
      label2172:
      Object localObject5 = localObject6;
      localObject6 = "";
      localObject7 = localObject10;
      continue;
      label2187:
      localObject6 = localObject5;
      continue;
      label2193:
      localObject8 = localObject6;
      localObject5 = localObject6;
      localObject6 = "";
      localObject9 = localObject7;
      continue;
      label2212:
      localObject7 = localObject5;
      localObject6 = localObject5;
      localObject5 = localObject7;
      continue;
      label2224:
      localObject7 = null;
      localObject6 = localObject5;
      localObject5 = localObject7;
    }
  }
  
  public boolean isSupportColor()
  {
    return false;
  }
  
  public boolean isSupportImage()
  {
    return false;
  }
  
  public void switch2HightlightMsg() {}
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\data\MessageForGrayTips.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.tencent.mobileqq.app.message;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout12;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class GiftMessageUtils
{
  public static final int a = 1;
  public static final String a = "http://imgcache.qq.com/club/client/flower/release/html/received_list.html?_wv=2147347&visit=owner&sourceType=%d&ADTAG=%s&totalFlower=%d&_bid=2050&isfresh=%d";
  public static final int b = 52;
  public static final String b = "http://imgcache.qq.com/club/client/flower/release/html/received_list.html?_wv=2147347&visit=guest&strangerUin=%s&sourceType=%d&ADTAG=%s&sign=%s&totalFlower=%d&_bid=2050";
  public static final String c = "http://imgcache.qq.com/club/client/flower/release/html/index.html?strangerUin=%s&sign=%s&sourceType=%d&ADTAG=%s&groupCode=%s&_wv=2147347&_bid=2050";
  public static final String d = "http://imgcache.qq.com/club/client/flower/release/html/gift_mall.html?ADTAG=%s&_bid=2050&sourceType=%d&_handle=1&_wv=2147347&platId=1&qqVersion=%s";
  public static final String e = "http://sqimg.qq.com/qq_product_operations/flower/images/f/%s";
  public static final String f = "http://sqimg.qq.com/qq_product_operations/flower/images/aio-msg/android/%s";
  public static final String g = "http://sqimg.qq.com/qq_product_operations/flower/images/aio-bg/%s";
  public static final String h = "http://sqimg.qq.com/qq_product_operations/flower/animation/android/";
  public static final String i = "aio.plus.s";
  public static final String j = "aio.m.s";
  public static final String k = "rank.s";
  public static final String l = "near.card.ro";
  public static final String m = "near.more.r";
  public static final String n = "aio.m.r";
  public static final String o = "near.card.rg";
  public static final String p = "near.card.s";
  public static final String q = "aio.m.xiaohuitiao";
  public static final String r = "aio.m.mall";
  public static final String s = "aio.hotchat.plus.s";
  public static final String t = "aio.hotchat.name.s";
  public static final String u = "aio.hotchat.m.s";
  public static final String v = "aio.hotchat.m_other.s";
  public static final String w = "ran.select.s";
  public static final String x = "ran.card.s";
  
  public GiftMessageUtils()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static int a(MessageRecord paramMessageRecord, int paramInt)
  {
    paramMessageRecord = a(paramMessageRecord);
    int i2;
    if (paramMessageRecord != null)
    {
      paramMessageRecord = paramMessageRecord.iterator();
      int i1 = 0;
      i2 = i1;
      if (!paramMessageRecord.hasNext()) {
        break label61;
      }
      GiftMessageUtils.GiftInfo localGiftInfo = (GiftMessageUtils.GiftInfo)paramMessageRecord.next();
      if (localGiftInfo.a != paramInt) {
        break label64;
      }
      i1 = localGiftInfo.b + i1;
    }
    label61:
    label64:
    for (;;)
    {
      break;
      i2 = 0;
      return i2;
    }
  }
  
  public static Drawable a(Drawable paramDrawable, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramDrawable == null) {
      return null;
    }
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setShape(paramInt3);
    localGradientDrawable.setStroke(paramInt1, paramInt2);
    paramDrawable = new LayerDrawable(new Drawable[] { localGradientDrawable, paramDrawable });
    paramDrawable.setLayerInset(1, paramInt1, paramInt1, paramInt1, paramInt1);
    return paramDrawable;
  }
  
  public static List a(MessageRecord paramMessageRecord)
  {
    ArrayList localArrayList;
    String str;
    int i2;
    int i1;
    if (((paramMessageRecord instanceof MessageForStructing)) && ((((MessageForStructing)paramMessageRecord).structingMsg instanceof AbsShareMsg)) && (((MessageForStructing)paramMessageRecord).structingMsg.mMsgServiceID == 52))
    {
      paramMessageRecord = (AbsShareMsg)((MessageForStructing)paramMessageRecord).structingMsg;
      localArrayList = new ArrayList();
      Iterator localIterator = paramMessageRecord.iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          paramMessageRecord = (AbsStructMsgElement)localIterator.next();
          if (paramMessageRecord != null)
          {
            str = "礼物";
            i2 = 1;
            if ((paramMessageRecord instanceof StructMsgItemLayout12))
            {
              i1 = ((StructMsgItemLayout12)paramMessageRecord).a.getInt("count");
              i2 = 1;
              paramMessageRecord = "礼物";
            }
          }
        }
      }
    }
    for (;;)
    {
      localArrayList.add(new GiftMessageUtils.GiftInfo(paramMessageRecord, i2, i1));
      break;
      Object localObject = paramMessageRecord.h;
      if (localObject != null)
      {
        i1 = i2;
        paramMessageRecord = str;
        try
        {
          localObject = new JSONObject((String)localObject);
          i1 = i2;
          paramMessageRecord = str;
          str = ((JSONObject)localObject).getString("giftName");
          i1 = i2;
          paramMessageRecord = str;
          i2 = ((JSONObject)localObject).getInt("giftType");
          i1 = i2;
          paramMessageRecord = str;
          int i3 = ((JSONObject)localObject).getInt("giftCount");
          i1 = i3;
          paramMessageRecord = str;
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
          i2 = i1;
          i1 = 0;
        }
        continue;
        return localArrayList;
        return null;
      }
      else
      {
        i1 = 0;
        i2 = 1;
        paramMessageRecord = "礼物";
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\message\GiftMessageUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
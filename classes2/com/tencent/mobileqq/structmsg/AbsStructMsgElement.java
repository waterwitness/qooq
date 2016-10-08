package com.tencent.mobileqq.structmsg;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager;
import com.tencent.biz.pubaccount.ecshopassit.EcshopReportHandler;
import com.tencent.biz.pubaccount.util.PAReportUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;
import org.xmlpull.v1.XmlSerializer;
import uuz;

public abstract class AbsStructMsgElement
  implements View.OnClickListener, StructMsgConstants
{
  public static final int a = 0;
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 8;
  public long a;
  public AbsStructMsg a;
  public String a;
  public WeakReference a;
  long b;
  public String b;
  public String c;
  public String d;
  public int e;
  public String e;
  int f;
  public String f;
  int g;
  public String g;
  public int h;
  public String h;
  public String i;
  public String j;
  public String k;
  public String l;
  public String m;
  public String n;
  
  public AbsStructMsgElement()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_e_of_type_Int = 8;
    this.l = "";
    this.h = -1;
    this.jdField_b_of_type_Long = -1L;
  }
  
  public static String a(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    String str = paramString;
    if (!paramString.startsWith("http"))
    {
      str = paramString;
      if (!paramString.startsWith("https")) {
        str = "http://" + paramString;
      }
    }
    try
    {
      paramString = new URL(str).getHost();
      return paramString;
    }
    catch (MalformedURLException paramString) {}
    return "";
  }
  
  public int a()
  {
    return this.f;
  }
  
  public abstract View a(Context paramContext, View paramView, Bundle paramBundle);
  
  public abstract String a();
  
  public void a(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void a(ObjectInput paramObjectInput)
  {
    this.jdField_e_of_type_Int = paramObjectInput.readInt();
  }
  
  public void a(ObjectOutput paramObjectOutput)
  {
    paramObjectOutput.writeUTF(this.jdField_a_of_type_JavaLangString);
    paramObjectOutput.writeInt(this.jdField_e_of_type_Int);
  }
  
  public abstract void a(XmlSerializer paramXmlSerializer);
  
  public boolean a(int paramInt)
  {
    return (this.f & paramInt) == paramInt;
  }
  
  public abstract boolean a(StructMsgNode paramStructMsgNode);
  
  public void b(int paramInt)
  {
    if ((this.f & paramInt) == 0) {
      this.f |= paramInt;
    }
  }
  
  public void c(int paramInt)
  {
    this.f &= (paramInt ^ 0xFFFFFFFF);
  }
  
  public void onClick(View paramView)
  {
    if (SystemClock.uptimeMillis() - this.jdField_b_of_type_Long < 1000L) {}
    for (;;)
    {
      return;
      this.jdField_b_of_type_Long = SystemClock.uptimeMillis();
      Object localObject1 = paramView.getTag();
      if (!getClass().isInstance(localObject1)) {
        continue;
      }
      AbsStructMsgElement localAbsStructMsgElement = (AbsStructMsgElement)localObject1;
      localObject4 = paramView.getContext();
      if ((!SplashActivity.class.isInstance(localObject4)) && (!ChatActivity.class.isInstance(localObject4))) {
        continue;
      }
      localObject1 = (FragmentActivity)localObject4;
      if (((FragmentActivity)localObject1).getChatFragment() == null) {
        continue;
      }
      Object localObject3 = ((FragmentActivity)localObject1).getChatFragment().a();
      if ((localAbsStructMsgElement.jdField_a_of_type_Long > 0L) && (!TextUtils.isEmpty(localAbsStructMsgElement.m))) {
        ReportController.b((QQAppInterface)localObject3, "P_CliOper", "Pb_account_lifeservice", localAbsStructMsgElement.n, "mp_msg_msgpic_click", "aio_morpic_click", Integer.parseInt(this.m), 0, "", "", Long.toString(localAbsStructMsgElement.jdField_a_of_type_Long), "");
      }
      if (localAbsStructMsgElement.jdField_a_of_type_Long > 0L) {
        ThreadManager.b().postDelayed(new uuz(this, localAbsStructMsgElement, (QQAppInterface)localObject3), 0L);
      }
      try
      {
        localObject1 = AIOUtils.a(paramView);
        if ((localObject1 == null) || (localAbsStructMsgElement.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg == null) || (!"1".equals(((ChatMessage)localObject1).getExtInfoFromExtStr("is_AdArrive_Msg")))) {}
      }
      catch (ClassCastException localClassCastException)
      {
        try
        {
          Object localObject5 = new JSONObject();
          ((JSONObject)localObject5).put("puin", ((ChatMessage)localObject1).frienduin);
          ((JSONObject)localObject5).put("type", localAbsStructMsgElement.k);
          ((JSONObject)localObject5).put("index", localAbsStructMsgElement.i);
          ((JSONObject)localObject5).put("name", localAbsStructMsgElement.j);
          ((JSONObject)localObject5).put("net", String.valueOf(HttpUtil.a()));
          ((JSONObject)localObject5).put("mobile_imei", DeviceInfoUtil.a());
          ((JSONObject)localObject5).put("obj", "");
          ((JSONObject)localObject5).put("gdt_cli_data", ((ChatMessage)localObject1).getExtInfoFromExtStr("gdt_msgClick"));
          ((JSONObject)localObject5).put("view_id", ((ChatMessage)localObject1).getExtInfoFromExtStr("gdt_view_id"));
          PAReportUtil.a((AppInterface)localObject3, ((ChatMessage)localObject1).selfuin, ((JSONObject)localObject5).toString(), "" + localAbsStructMsgElement.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.msgId);
          paramView = new StructMsgClickHandler((QQAppInterface)localObject3, paramView, (MessageRecord)localObject1);
          localObject4 = ((FragmentActivity)localObject4).getChatFragment();
          if (localObject4 != null)
          {
            localObject4 = ((ChatFragment)localObject4).a();
            if ((localObject4 instanceof PublicAccountChatPie))
            {
              localObject5 = (PublicAccountChatPie)localObject4;
              ((PublicAccountChatPie)localObject5).ea += 1;
              if ("web".equals(localAbsStructMsgElement.c))
              {
                localObject4 = (PublicAccountChatPie)localObject4;
                ((PublicAccountChatPie)localObject4).ec += 1;
              }
            }
          }
          if (localObject1 != null) {
            localAbsStructMsgElement.jdField_b_of_type_JavaLangString = EcShopAssistantManager.a(((ChatMessage)localObject1).frienduin, localAbsStructMsgElement.jdField_b_of_type_JavaLangString, (QQAppInterface)localObject3);
          }
          int i1;
          int i2;
          if (localAbsStructMsgElement.jdField_a_of_type_Long > 0L)
          {
            bool = paramView.a(localAbsStructMsgElement.c, localAbsStructMsgElement.jdField_b_of_type_JavaLangString, localAbsStructMsgElement.d, localAbsStructMsgElement.jdField_e_of_type_JavaLangString, localAbsStructMsgElement.jdField_a_of_type_Long);
            i1 = 0;
            if (bool) {
              i1 = 1;
            }
            i2 = -1;
          }
          try
          {
            int i3 = Integer.parseInt(localAbsStructMsgElement.m);
            i2 = i3;
          }
          catch (Exception paramView)
          {
            for (;;) {}
          }
          ReportController.b((QQAppInterface)localObject3, "P_CliOper", "Pb_account_lifeservice", localAbsStructMsgElement.n, "0X80055C7", "0X80055C7", i2, i1, "" + localAbsStructMsgElement.jdField_a_of_type_Long, localAbsStructMsgElement.l, "", localAbsStructMsgElement.jdField_b_of_type_JavaLangString);
          paramView = new StringBuilder().append("MSGID=").append(Long.toString(localAbsStructMsgElement.jdField_a_of_type_Long)).append(";TEPLATEID=").append(localAbsStructMsgElement.l).append(";ARTICALID=").append("").append(";REFERRER=").append(a(localAbsStructMsgElement.jdField_b_of_type_JavaLangString));
          ReportController.b((QQAppInterface)localObject3, "P_CliOper", "Pb_account_lifeservice", localAbsStructMsgElement.n, "0X8005D49", "0X8005D49", i2, i1, paramView.toString(), "", "", "");
          if (localObject1 == null) {
            continue;
          }
          paramView = ((ChatMessage)localObject1).getExtInfoFromExtStr("gdt_msgClick");
          if (!TextUtils.isEmpty(paramView)) {
            localObject4 = new JSONObject();
          }
          try
          {
            if (TextUtils.isEmpty(localAbsStructMsgElement.n)) {
              break label933;
            }
            ((JSONObject)localObject4).put("puin", localAbsStructMsgElement.n);
            ((JSONObject)localObject4).put("index", Long.toString(i2));
            ((JSONObject)localObject4).put("gdt_cli_data", paramView);
          }
          catch (JSONException paramView)
          {
            for (;;)
            {
              Object localObject2;
              paramView.printStackTrace();
              continue;
              if ((((String)localObject4).equals("1")) || (!localJSONException.equals("1"))) {}
            }
          }
          new ArrayList().add(String.valueOf(localAbsStructMsgElement.jdField_a_of_type_Long));
          paramView = ((ChatMessage)localObject1).getExtInfoFromExtStr("gdt_singleAd");
          localObject4 = ((ChatMessage)localObject1).getExtInfoFromExtStr("gdt_mulAd");
          localObject5 = ((ChatMessage)localObject1).getExtInfoFromExtStr("gdt_followAd");
          if (paramView.equals("1"))
          {
            paramView = (EcShopAssistantManager)((QQAppInterface)localObject3).getManager(87);
            localObject3 = (EcshopReportHandler)((QQAppInterface)localObject3).a(88);
            if ((localObject1 == null) || (paramView == null) || (localObject3 == null) || (!paramView.a(((ChatMessage)localObject1).senderuin))) {
              continue;
            }
            ((EcshopReportHandler)localObject3).a(false, (MessageRecord)localObject1, i2, localAbsStructMsgElement.jdField_b_of_type_JavaLangString);
            return;
            localClassCastException = localClassCastException;
            localObject2 = null;
          }
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            localJSONException.printStackTrace();
            continue;
            boolean bool = paramView.a(localAbsStructMsgElement.c, localAbsStructMsgElement.jdField_b_of_type_JavaLangString, localAbsStructMsgElement.d, localAbsStructMsgElement.jdField_e_of_type_JavaLangString);
            continue;
            label933:
            ((JSONObject)localObject4).put("puin", ((ChatMessage)localObject2).frienduin);
          }
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\structmsg\AbsStructMsgElement.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
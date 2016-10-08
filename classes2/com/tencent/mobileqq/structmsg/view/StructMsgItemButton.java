package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.structmsg.AbsStructMsgTextElement;
import com.tencent.mobileqq.structmsg.StructMsgNode;
import com.tencent.qphone.base.util.QLog;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.json.JSONObject;
import org.xmlpull.v1.XmlSerializer;
import uvv;
import uvw;
import uvx;

public class StructMsgItemButton
  extends AbsStructMsgTextElement
{
  public static final String cK = "struct_log_tag";
  public static final String cL = "#ff777777";
  View.OnClickListener a;
  public long c;
  public String cM;
  public String cN;
  public String cO;
  public String cP;
  public boolean d;
  
  public StructMsgItemButton()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_c_of_type_Long = -1L;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new uvx(this);
    this.jdField_a_of_type_JavaLangString = "button";
  }
  
  public static void a(StructMsgItemButton paramStructMsgItemButton, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      paramStructMsgItemButton.jdField_d_of_type_Boolean = false;
      paramStructMsgItemButton.b("#ff777777");
      return;
    }
    paramStructMsgItemButton.jdField_d_of_type_Boolean = true;
    paramStructMsgItemButton.b(paramStructMsgItemButton.o);
  }
  
  private void b()
  {
    if ((!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) && (this.jdField_c_of_type_JavaLangString.equals("pay"))) {
      if (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) {
        break label130;
      }
    }
    for (Object localObject = this.jdField_d_of_type_JavaLangString;; localObject = this.jdField_e_of_type_JavaLangString)
    {
      if (!TextUtils.isEmpty((CharSequence)localObject)) {}
      try
      {
        localObject = new JSONObject((String)localObject);
        if (((JSONObject)localObject).has("appId")) {
          this.cM = ((JSONObject)localObject).getString("appId");
        }
        if (((JSONObject)localObject).has("orderId")) {
          this.cN = ((JSONObject)localObject).getString("orderId");
        }
        if (((JSONObject)localObject).has("package")) {
          this.cP = ((JSONObject)localObject).getString("package");
        }
        if (((JSONObject)localObject).has("expireTime")) {
          this.cO = ((JSONObject)localObject).getString("expireTime");
        }
        return;
      }
      catch (Exception localException)
      {
        label130:
        while (!QLog.isColorLevel()) {}
        QLog.e("StructMsgItemButton", 2, "read msg=" + localException.getMessage());
      }
    }
  }
  
  public View a(Context paramContext, View paramView, Bundle paramBundle)
  {
    int i = paramBundle.getInt("Layout3ButtonCount", 0);
    int j = paramBundle.getInt("Layout3ButtonIndex", -1);
    paramContext = (TextView)super.a(paramContext, paramView, paramBundle);
    paramContext.setBackgroundResource(2130837657);
    if (i > 1) {
      if (j == 0)
      {
        paramContext.setBackgroundResource(2130837650);
        i = 0;
      }
    }
    for (;;)
    {
      paramContext.setTag(2131296587, Integer.valueOf(i));
      paramContext.setGravity(17);
      paramContext.setSingleLine();
      paramContext.setEllipsize(null);
      if ((!a()) || ((a()) && (this.jdField_d_of_type_Boolean)))
      {
        paramContext.setClickable(true);
        paramContext.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        paramContext.setOnLongClickListener(new uvv(this));
        paramContext.setOnTouchListener(new uvw(this));
        return paramContext;
        if (j == i - 1)
        {
          paramContext.setBackgroundResource(2130837654);
          i = 2;
        }
        else
        {
          paramContext.setBackgroundResource(2130837652);
          i = 1;
        }
      }
      else
      {
        paramContext.setClickable(false);
        paramContext.setOnClickListener(null);
        paramContext.setOnTouchListener(null);
        paramContext.setOnLongClickListener(null);
        return paramContext;
        i = 0;
      }
    }
  }
  
  public String a()
  {
    return "Confirm";
  }
  
  public void a(ObjectInput paramObjectInput)
  {
    super.a(paramObjectInput);
    this.b = paramObjectInput.readUTF();
    this.jdField_c_of_type_JavaLangString = paramObjectInput.readUTF();
    this.jdField_d_of_type_JavaLangString = paramObjectInput.readUTF();
    this.jdField_e_of_type_JavaLangString = paramObjectInput.readUTF();
    this.f = paramObjectInput.readUTF();
    if (this.jdField_e_of_type_Int > 5)
    {
      this.i = paramObjectInput.readUTF();
      this.j = paramObjectInput.readUTF();
      this.k = paramObjectInput.readUTF();
    }
    b();
  }
  
  public void a(ObjectOutput paramObjectOutput)
  {
    super.a(paramObjectOutput);
    if (this.b == null)
    {
      str = "";
      paramObjectOutput.writeUTF(str);
      if (this.jdField_c_of_type_JavaLangString != null) {
        break label158;
      }
      str = "";
      label32:
      paramObjectOutput.writeUTF(str);
      if (this.jdField_d_of_type_JavaLangString != null) {
        break label166;
      }
      str = "";
      label49:
      paramObjectOutput.writeUTF(str);
      if (this.jdField_e_of_type_JavaLangString != null) {
        break label174;
      }
      str = "";
      label66:
      paramObjectOutput.writeUTF(str);
      if (this.f != null) {
        break label182;
      }
      str = "";
      label83:
      paramObjectOutput.writeUTF(str);
      if (this.jdField_e_of_type_Int > 5)
      {
        if (this.i != null) {
          break label190;
        }
        str = "";
        label108:
        paramObjectOutput.writeUTF(str);
        if (this.j != null) {
          break label198;
        }
        str = "";
        label125:
        paramObjectOutput.writeUTF(str);
        if (this.k != null) {
          break label206;
        }
      }
    }
    label158:
    label166:
    label174:
    label182:
    label190:
    label198:
    label206:
    for (String str = "";; str = this.k)
    {
      paramObjectOutput.writeUTF(str);
      return;
      str = this.b;
      break;
      str = this.jdField_c_of_type_JavaLangString;
      break label32;
      str = this.jdField_d_of_type_JavaLangString;
      break label49;
      str = this.jdField_e_of_type_JavaLangString;
      break label66;
      str = this.f;
      break label83;
      str = this.i;
      break label108;
      str = this.j;
      break label125;
    }
  }
  
  public void a(XmlSerializer paramXmlSerializer)
  {
    super.a(paramXmlSerializer);
    paramXmlSerializer.startTag(null, "button");
    if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
      paramXmlSerializer.attribute(null, "action", this.jdField_c_of_type_JavaLangString);
    }
    if (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) {
      paramXmlSerializer.attribute(null, "actionData", this.jdField_d_of_type_JavaLangString);
    }
    if (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) {
      paramXmlSerializer.attribute(null, "a_actionData", this.jdField_e_of_type_JavaLangString);
    }
    if (!TextUtils.isEmpty(this.f)) {
      paramXmlSerializer.attribute(null, "i_actionData", this.f);
    }
    if (!TextUtils.isEmpty(this.b)) {
      paramXmlSerializer.attribute(null, "url", this.b);
    }
    if (!TextUtils.isEmpty(this.i)) {
      paramXmlSerializer.attribute(null, "index", this.i);
    }
    if (!TextUtils.isEmpty(this.j)) {
      paramXmlSerializer.attribute(null, "index_name", this.j);
    }
    if (!TextUtils.isEmpty(this.k)) {
      paramXmlSerializer.attribute(null, "index_type", this.k);
    }
    paramXmlSerializer.endTag(null, "button");
  }
  
  public boolean a()
  {
    if ((TextUtils.isEmpty(this.cP)) || (TextUtils.isEmpty(this.cM)) || (TextUtils.isEmpty(this.cO)) || (TextUtils.isEmpty(this.cN))) {}
    while ((TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) || (!this.jdField_c_of_type_JavaLangString.equals("pay"))) {
      return false;
    }
    return true;
  }
  
  public boolean a(StructMsgNode paramStructMsgNode)
  {
    super.a(paramStructMsgNode);
    this.jdField_c_of_type_JavaLangString = paramStructMsgNode.a("action");
    this.jdField_d_of_type_JavaLangString = paramStructMsgNode.a("actionData");
    this.jdField_e_of_type_JavaLangString = paramStructMsgNode.a("a_actionData");
    this.f = paramStructMsgNode.a("i_actionData");
    this.b = paramStructMsgNode.a("url");
    this.i = paramStructMsgNode.a("index");
    this.j = paramStructMsgNode.a("index_name");
    this.k = paramStructMsgNode.a("index_type");
    b();
    return true;
  }
  
  public boolean b()
  {
    long l1 = NetConnInfoCenter.getServerTime();
    try
    {
      long l2 = Long.parseLong(this.cO);
      if (l2 > l1) {
        return false;
      }
    }
    catch (Exception localException) {}
    return true;
  }
  
  protected int c()
  {
    return 2131296383;
  }
  
  public int d()
  {
    return -16734752;
  }
  
  public int e()
  {
    return 32;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\structmsg\view\StructMsgItemButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
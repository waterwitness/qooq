package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.StructMsgNode;
import com.tencent.mobileqq.utils.StringUtil;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.xmlpull.v1.XmlSerializer;
import uws;

public class StructMsgItemTextButton
  extends AbsStructMsgElement
  implements View.OnClickListener
{
  public static final int i = 32;
  public static final String o = "left";
  public static final String p = "right";
  public static final String q = "right";
  public int j;
  public int k;
  public String r;
  public String s;
  public String t;
  
  public StructMsgItemTextButton()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = "textButton";
    d(32);
    e(32);
  }
  
  public StructMsgItemTextButton(String paramString1, String paramString2)
  {
    this.a = paramString2;
    this.r = paramString1;
    d(32);
    e(32);
  }
  
  private LinearLayout a(Context paramContext)
  {
    paramContext = new LinearLayout(paramContext);
    paramContext.setOrientation(0);
    paramContext.setGravity(16);
    paramContext.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
    paramContext.setId(2131296364);
    return paramContext;
  }
  
  protected TextUtils.TruncateAt a()
  {
    return TextUtils.TruncateAt.END;
  }
  
  public View a(Context paramContext, View paramView, Bundle paramBundle)
  {
    if (paramView != null) {
      paramContext = (uws)paramView.getTag();
    }
    for (;;)
    {
      paramContext.jdField_a_of_type_AndroidWidgetTextView.setTag(this);
      paramContext.jdField_a_of_type_AndroidWidgetTextView.setTextColor(c());
      paramContext.jdField_a_of_type_AndroidWidgetTextView.requestLayout();
      paramContext.jdField_a_of_type_AndroidWidgetTextView.setTypeface(Typeface.DEFAULT, d());
      paramContext.jdField_a_of_type_AndroidWidgetTextView.setTextSize(b() / 2);
      if (!TextUtils.isEmpty(this.r)) {
        paramContext.jdField_a_of_type_AndroidWidgetTextView.setText(this.r);
      }
      if (!TextUtils.isEmpty(this.s))
      {
        paramBundle = URLDrawable.getDrawable(this.s, this.j, this.j, null, null);
        paramBundle.setAutoDownload(true);
        paramContext.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramBundle);
      }
      if (!TextUtils.isEmpty(this.t))
      {
        paramBundle = URLDrawable.getDrawable(this.t, this.k, this.k, null, null);
        paramBundle.setAutoDownload(true);
        paramContext.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramBundle);
      }
      if ((this.c != null) && (!this.c.equals("")))
      {
        paramView.setClickable(true);
        paramView.setOnClickListener(this);
      }
      return paramView;
      paramView = new uws(this);
      paramView.jdField_a_of_type_AndroidWidgetLinearLayout = a(paramContext);
      paramView.jdField_a_of_type_AndroidWidgetImageView = new ImageView(paramContext);
      paramView.b = new ImageView(paramContext);
      paramView.jdField_a_of_type_AndroidWidgetTextView = new TextView(paramContext);
      paramContext = new LinearLayout.LayoutParams(-2, -2);
      paramContext.gravity = 16;
      paramView.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramView.jdField_a_of_type_AndroidWidgetImageView, paramContext);
      paramView.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramView.jdField_a_of_type_AndroidWidgetTextView, paramContext);
      paramView.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramView.b, paramContext);
      paramView.jdField_a_of_type_AndroidWidgetLinearLayout.setTag(paramView);
      paramBundle = paramView.jdField_a_of_type_AndroidWidgetLinearLayout;
      paramContext = paramView;
      paramView = paramBundle;
    }
  }
  
  public String a()
  {
    return "TextButton";
  }
  
  public void a(ObjectInput paramObjectInput)
  {
    super.a(paramObjectInput);
    this.r = MessageUtils.a(paramObjectInput.readUTF(), false);
    this.s = MessageUtils.a(paramObjectInput.readUTF(), false);
    this.t = MessageUtils.a(paramObjectInput.readUTF(), false);
    this.b = MessageUtils.a(paramObjectInput.readUTF(), false);
  }
  
  public void a(ObjectOutput paramObjectOutput)
  {
    super.a(paramObjectOutput);
    if (this.r == null)
    {
      str = "";
      paramObjectOutput.writeUTF(str);
      if (this.s != null) {
        break label86;
      }
      str = "";
      label32:
      paramObjectOutput.writeUTF(str);
      if (this.t != null) {
        break label94;
      }
      str = "";
      label49:
      paramObjectOutput.writeUTF(str);
      if (this.b != null) {
        break label102;
      }
    }
    label86:
    label94:
    label102:
    for (String str = "";; str = this.b)
    {
      paramObjectOutput.writeUTF(str);
      return;
      str = MessageUtils.a(this.r, false);
      break;
      str = this.s;
      break label32;
      str = this.t;
      break label49;
    }
  }
  
  public void a(String paramString)
  {
    if ((paramString == null) || (paramString.equals("")))
    {
      this.r = paramString;
      return;
    }
    this.r = StringUtil.h(paramString);
  }
  
  public void a(XmlSerializer paramXmlSerializer)
  {
    paramXmlSerializer.startTag(null, this.a);
    if (!TextUtils.isEmpty(this.r)) {
      paramXmlSerializer.attribute(null, "text", this.r);
    }
    if (!TextUtils.isEmpty(this.s)) {
      paramXmlSerializer.attribute(null, "leftImage", this.s);
    }
    if (!TextUtils.isEmpty(this.t)) {
      paramXmlSerializer.attribute(null, "rightImage", this.t);
    }
    if (!TextUtils.isEmpty(this.b)) {
      paramXmlSerializer.attribute(null, "url", this.b);
    }
    paramXmlSerializer.endTag(null, this.a);
  }
  
  public boolean a(StructMsgNode paramStructMsgNode)
  {
    if (paramStructMsgNode == null) {
      return true;
    }
    this.b = paramStructMsgNode.a("url");
    this.s = paramStructMsgNode.a("leftImage");
    this.t = paramStructMsgNode.a("rightImage");
    this.r = MessageUtils.a(paramStructMsgNode.a("text"), false);
    return true;
  }
  
  public int b()
  {
    return 26;
  }
  
  public String b()
  {
    if (this.r == null) {}
    for (String str = "";; str = this.r)
    {
      this.r = str;
      return this.r;
    }
  }
  
  public int c()
  {
    return -16777216;
  }
  
  public int d()
  {
    return 0;
  }
  
  public void d(int paramInt)
  {
    this.j = paramInt;
  }
  
  public void e(int paramInt)
  {
    this.k = paramInt;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\structmsg\view\StructMsgItemTextButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
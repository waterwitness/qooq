package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.structmsg.StructMsgNode;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.xmlpull.v1.XmlSerializer;

public class StructMsgItemMore
  extends AbsStructMsgElement
{
  String o;
  
  public StructMsgItemMore()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.o = "";
    this.a = "more";
  }
  
  public StructMsgItemMore(String paramString)
  {
    this();
    this.o = paramString;
  }
  
  public View a(Context paramContext, View paramView, Bundle paramBundle)
  {
    paramBundle = paramView;
    if (paramView == null) {
      paramBundle = LayoutInflater.from(paramContext).inflate(2130905010, null);
    }
    paramContext = (TextView)paramBundle.findViewById(2131305038);
    if (TextUtils.isEmpty(this.o)) {
      this.o = "阅读全文";
    }
    paramContext.setText(this.o);
    return paramBundle;
  }
  
  public String a()
  {
    return "More";
  }
  
  public void a(ObjectInput paramObjectInput)
  {
    super.a(paramObjectInput);
    this.o = paramObjectInput.readUTF();
  }
  
  public void a(ObjectOutput paramObjectOutput)
  {
    super.a(paramObjectOutput);
    if (this.o == null) {}
    for (String str = "";; str = MessageUtils.a(this.o, false))
    {
      paramObjectOutput.writeUTF(str);
      return;
    }
  }
  
  public void a(XmlSerializer paramXmlSerializer)
  {
    paramXmlSerializer.startTag(null, "title");
    paramXmlSerializer.text(this.o);
    paramXmlSerializer.endTag(null, "title");
  }
  
  public boolean a(StructMsgNode paramStructMsgNode)
  {
    this.o = MessageUtils.a(StructMsgFactory.a(paramStructMsgNode), false);
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\structmsg\view\StructMsgItemMore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
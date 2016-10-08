package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.StructMsgNode;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.xmlpull.v1.XmlSerializer;

public class StructMsgItemHr
  extends AbsStructMsgElement
{
  public boolean a;
  
  public StructMsgItemHr()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangString = "hr";
  }
  
  public View a(Context paramContext, View paramView, Bundle paramBundle)
  {
    paramBundle = paramView;
    if (paramView == null)
    {
      paramBundle = new View(paramContext);
      paramBundle.setBackgroundColor(-2170912);
    }
    return paramBundle;
  }
  
  public String a()
  {
    return "Hr";
  }
  
  public void a(ObjectInput paramObjectInput)
  {
    super.a(paramObjectInput);
    if (this.e > 4)
    {
      paramObjectInput = paramObjectInput.readUTF();
      if ((paramObjectInput != null) && (paramObjectInput.toLowerCase().equals("true"))) {
        this.jdField_a_of_type_Boolean = true;
      }
    }
  }
  
  public void a(ObjectOutput paramObjectOutput)
  {
    super.a(paramObjectOutput);
    if (this.jdField_a_of_type_Boolean) {}
    for (String str = "true";; str = "false")
    {
      paramObjectOutput.writeUTF(str);
      return;
    }
  }
  
  public void a(XmlSerializer paramXmlSerializer)
  {
    paramXmlSerializer.startTag(null, "hr");
    if (this.e > 4) {
      if (!this.jdField_a_of_type_Boolean) {
        break label50;
      }
    }
    label50:
    for (String str = "true";; str = "false")
    {
      paramXmlSerializer.attribute(null, "hidden", str);
      paramXmlSerializer.endTag(null, "hr");
      return;
    }
  }
  
  public boolean a(StructMsgNode paramStructMsgNode)
  {
    if (paramStructMsgNode == null) {}
    do
    {
      do
      {
        return true;
      } while (this.e <= 4);
      paramStructMsgNode = paramStructMsgNode.a("hidden");
    } while ((paramStructMsgNode == null) || (!paramStructMsgNode.toLowerCase().equals("true")));
    this.jdField_a_of_type_Boolean = true;
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\structmsg\view\StructMsgItemHr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
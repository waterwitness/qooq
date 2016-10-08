package com.tencent.mobileqq.structmsg.view;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.structmsg.StructMsgNode;
import org.xmlpull.v1.XmlSerializer;

public class StructMsgItemVoteCover
  extends StructMsgItemCover
{
  public StructMsgItemVoteCover()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = "vote";
  }
  
  public String a()
  {
    return "VoteCover";
  }
  
  public void a(XmlSerializer paramXmlSerializer)
  {
    paramXmlSerializer.startTag(null, "vote");
    if (this.o == null) {}
    for (String str = "";; str = this.o)
    {
      paramXmlSerializer.attribute(null, "cover", str);
      paramXmlSerializer.endTag(null, "vote");
      return;
    }
  }
  
  public boolean a(StructMsgNode paramStructMsgNode)
  {
    if (paramStructMsgNode == null) {
      return true;
    }
    paramStructMsgNode = paramStructMsgNode.a("cover");
    if (paramStructMsgNode != null) {}
    for (;;)
    {
      this.o = paramStructMsgNode;
      return true;
      paramStructMsgNode = "";
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\structmsg\view\StructMsgItemVoteCover.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
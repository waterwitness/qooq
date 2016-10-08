package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.StructMsgNode;
import com.tencent.mobileqq.utils.ContactUtils;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.xmlpull.v1.XmlSerializer;

public class StructMsgItemAsyncMsg
  extends AbsStructMsgElement
{
  public String o;
  public String p;
  public String q;
  public String r;
  public String s;
  public String t;
  
  public StructMsgItemAsyncMsg()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.o = "";
    this.p = "";
    this.q = "";
    this.r = "";
    this.s = "";
    this.t = "";
    this.a = "asyncmsg";
  }
  
  public StructMsgItemAsyncMsg(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    this();
    this.o = paramString1;
    this.p = paramString2;
    this.q = paramString3;
    this.r = paramString4;
    this.s = paramString5;
    this.t = paramString6;
  }
  
  public View a(Context paramContext, View paramView, Bundle paramBundle)
  {
    StructMsgItemAsyncMsg.ItemHolder localItemHolder;
    View localView;
    int i;
    if (paramView == null)
    {
      localItemHolder = new StructMsgItemAsyncMsg.ItemHolder(this);
      localView = LayoutInflater.from(paramContext).inflate(2130903297, null, false);
      localItemHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131298020));
      localItemHolder.b = ((TextView)localView.findViewById(2131298021));
      localItemHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131298022));
      paramView = new DisplayMetrics();
      ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getMetrics(paramView);
      i = (int)(paramView.widthPixels * 0.05D);
      localItemHolder.jdField_a_of_type_AndroidWidgetTextView.setMaxWidth(i + 180);
      localView.setTag(localItemHolder);
    }
    String[] arrayOfString;
    for (;;)
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.a().a();
      String str = localQQAppInterface.a();
      arrayOfString = this.r.split("\\|");
      if (arrayOfString == null) {
        break;
      }
      paramView = "";
      i = 0;
      int j = 0;
      for (;;)
      {
        k = i;
        if (j >= arrayOfString.length) {
          break;
        }
        paramBundle = paramView;
        if (!this.q.equals(""))
        {
          paramBundle = null;
          Object localObject = null;
          if (0 == 0)
          {
            paramBundle = (Bundle)localObject;
            if (Integer.parseInt(this.q) == 1) {
              paramBundle = ContactUtils.f(localQQAppInterface, this.p, arrayOfString[j]);
            }
            if (Integer.parseInt(this.q) == 2) {
              paramBundle = ContactUtils.c(localQQAppInterface, this.p, arrayOfString[j]);
            }
          }
          paramBundle = paramView + paramBundle;
        }
        paramView = paramBundle;
        if (j != arrayOfString.length - 1) {
          paramView = paramBundle + paramContext.getResources().getString(2131362551);
        }
        if (str.equals(arrayOfString[j])) {
          i = 1;
        }
        j += 1;
      }
      localItemHolder = (StructMsgItemAsyncMsg.ItemHolder)paramView.getTag();
      localView = paramView;
    }
    int k = 0;
    if ((!this.s.equals("")) && (Integer.parseInt(this.s) != 0)) {
      localItemHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    while (k != 0)
    {
      localItemHolder.jdField_a_of_type_AndroidWidgetTextView.setText(2131362550);
      localItemHolder.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(paramContext.getResources().getString(2131362550));
      localItemHolder.b.setText(null);
      return localView;
      localItemHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    paramContext = arrayOfString.length + paramContext.getResources().getString(2131362559);
    localItemHolder.b.setText(paramContext);
    localItemHolder.b.setContentDescription(paramContext);
    localItemHolder.jdField_a_of_type_AndroidWidgetTextView.setText("");
    localItemHolder.jdField_a_of_type_AndroidWidgetTextView.setContentDescription("");
    return localView;
  }
  
  public String a()
  {
    return "AsyncMsg";
  }
  
  public void a(ObjectInput paramObjectInput)
  {
    super.a(paramObjectInput);
    this.o = paramObjectInput.readUTF();
    this.p = paramObjectInput.readUTF();
    this.q = paramObjectInput.readUTF();
    this.r = paramObjectInput.readUTF();
    this.s = paramObjectInput.readUTF();
    this.t = paramObjectInput.readUTF();
  }
  
  public void a(ObjectOutput paramObjectOutput)
  {
    super.a(paramObjectOutput);
    if (this.o == null)
    {
      str = "";
      paramObjectOutput.writeUTF(str);
      if (this.p != null) {
        break label116;
      }
      str = "";
      label32:
      paramObjectOutput.writeUTF(str);
      if (this.q != null) {
        break label124;
      }
      str = "";
      label49:
      paramObjectOutput.writeUTF(str);
      if (this.r != null) {
        break label132;
      }
      str = "";
      label66:
      paramObjectOutput.writeUTF(str);
      if (this.s != null) {
        break label140;
      }
      str = "";
      label83:
      paramObjectOutput.writeUTF(str);
      if (this.t != null) {
        break label148;
      }
    }
    label116:
    label124:
    label132:
    label140:
    label148:
    for (String str = "";; str = this.t)
    {
      paramObjectOutput.writeUTF(str);
      return;
      str = this.o;
      break;
      str = this.p;
      break label32;
      str = this.q;
      break label49;
      str = this.r;
      break label66;
      str = this.s;
      break label83;
    }
  }
  
  public void a(XmlSerializer paramXmlSerializer)
  {
    paramXmlSerializer.startTag(null, "asyncmsg");
    paramXmlSerializer.attribute(null, "fu", this.o);
    paramXmlSerializer.attribute(null, "fsc", this.p);
    paramXmlSerializer.attribute(null, "fst", this.q);
    paramXmlSerializer.attribute(null, "atuins", this.r);
    paramXmlSerializer.attribute(null, "attachcount", this.s);
    paramXmlSerializer.attribute(null, "fid", this.t);
    paramXmlSerializer.endTag(null, "asyncmsg");
  }
  
  public boolean a(StructMsgNode paramStructMsgNode)
  {
    if (paramStructMsgNode == null) {
      return true;
    }
    this.o = paramStructMsgNode.a("fu");
    this.p = paramStructMsgNode.a("fsc");
    this.q = paramStructMsgNode.a("fst");
    this.r = paramStructMsgNode.a("atuins");
    this.s = paramStructMsgNode.a("attachcount");
    this.t = paramStructMsgNode.a("fid");
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\structmsg\view\StructMsgItemAsyncMsg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.tencent.mobileqq.structmsg;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.now.NowVideoLayout;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.xmlpull.v1.XmlSerializer;
import uvs;
import uvt;

public class StructMsgItemLive
  extends AbsStructMsgElement
{
  public static final int l = 1;
  private static final String u = "story:";
  public View.OnClickListener a;
  public int i;
  public int j;
  public int k;
  public String o;
  public String p;
  public String q;
  public String r;
  public String s;
  public String t;
  
  public StructMsgItemLive()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.k = 1;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new uvt(this);
    this.jdField_a_of_type_JavaLangString = "live";
  }
  
  public View a(Context paramContext, View paramView, Bundle paramBundle)
  {
    LinearLayout localLinearLayout = null;
    Resources localResources = paramContext.getResources();
    if ((paramView != null) && ((paramView instanceof LinearLayout)))
    {
      paramView = paramView.getTag();
      if ((paramView != null) && ((paramView instanceof StructMsgItemLive.ViewHolder)))
      {
        paramView = (StructMsgItemLive.ViewHolder)paramView;
        paramBundle = paramView.jdField_a_of_type_ComTencentBizNowNowVideoLayout;
        paramBundle = paramView.jdField_a_of_type_AndroidWidgetTextView;
      }
    }
    for (;;)
    {
      paramBundle = paramView;
      if (paramView == null)
      {
        paramBundle = new StructMsgItemLive.ViewHolder();
        localLinearLayout = new LinearLayout(paramContext);
        localLinearLayout.setOrientation(1);
        paramView = new LinearLayout.LayoutParams(-2, -2);
        paramView.gravity = 1;
        paramView.setMargins(0, 0, 0, AIOUtils.a(20.0F, localResources));
        localLinearLayout.setLayoutParams(paramView);
        paramView = new NowVideoLayout(paramContext);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
        paramView.setId(2131296580);
        paramBundle.jdField_a_of_type_ComTencentBizNowNowVideoLayout = paramView;
        localLinearLayout.addView(paramView, localLayoutParams);
        paramContext = new TextView(paramContext);
        paramView = new LinearLayout.LayoutParams(AIOUtils.a(211.0F, localResources), AIOUtils.a(30.0F, localResources));
        paramContext.setGravity(16);
        paramContext.setBackgroundResource(2130840078);
        paramContext.setPadding(AIOUtils.a(8.0F, localResources), 0, AIOUtils.a(8.0F, localResources), 0);
        paramContext.setTextColor(-16777216);
        paramContext.setEllipsize(TextUtils.TruncateAt.END);
        paramContext.setTextSize(0, AIOUtils.a(14.0F, localResources));
        paramContext.setSingleLine();
        paramView.setMargins(0, 0, 0, 0);
        paramBundle.jdField_a_of_type_AndroidWidgetTextView = paramContext;
        paramContext.setId(2131296362);
        localLinearLayout.addView(paramContext, paramView);
      }
      localLinearLayout.setTag(paramBundle);
      paramBundle.jdField_a_of_type_ComTencentBizNowNowVideoLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramBundle.jdField_a_of_type_ComTencentBizNowNowVideoLayout.setOnLongClickListener(new uvs(this));
      return localLinearLayout;
      paramView = null;
    }
  }
  
  public String a()
  {
    return "live";
  }
  
  public void a(ObjectInput paramObjectInput)
  {
    super.a(paramObjectInput);
    this.p = paramObjectInput.readUTF();
    this.q = paramObjectInput.readUTF();
    this.r = paramObjectInput.readUTF();
    this.i = paramObjectInput.readInt();
    this.j = paramObjectInput.readInt();
    this.k = paramObjectInput.readInt();
    this.s = paramObjectInput.readUTF();
    this.o = paramObjectInput.readUTF();
    this.t = paramObjectInput.readUTF();
  }
  
  public void a(ObjectOutput paramObjectOutput)
  {
    super.a(paramObjectOutput);
    if (this.p != null)
    {
      str = this.p;
      paramObjectOutput.writeUTF(str);
      if (this.q == null) {
        break label156;
      }
      str = this.q;
      label36:
      paramObjectOutput.writeUTF(str);
      if (this.r == null) {
        break label162;
      }
      str = this.r;
      label55:
      paramObjectOutput.writeUTF(str);
      paramObjectOutput.writeInt(this.i);
      paramObjectOutput.writeInt(this.j);
      paramObjectOutput.writeInt(this.k);
      if (this.s == null) {
        break label168;
      }
      str = this.s;
      label104:
      paramObjectOutput.writeUTF(str);
      if (this.o == null) {
        break label174;
      }
      str = this.o;
      label123:
      paramObjectOutput.writeUTF(str);
      if (this.t == null) {
        break label180;
      }
    }
    label156:
    label162:
    label168:
    label174:
    label180:
    for (String str = this.t;; str = "")
    {
      paramObjectOutput.writeUTF(str);
      return;
      str = "";
      break;
      str = "";
      break label36;
      str = "";
      break label55;
      str = "";
      break label104;
      str = "";
      break label123;
    }
  }
  
  public void a(XmlSerializer paramXmlSerializer)
  {
    paramXmlSerializer.startTag(null, "live");
    paramXmlSerializer.attribute(null, "cover", this.p);
    paramXmlSerializer.attribute(null, "src", this.q);
    paramXmlSerializer.attribute(null, "video_info", this.r);
    paramXmlSerializer.attribute(null, "preWidth", String.valueOf(this.i));
    paramXmlSerializer.attribute(null, "preHeight", String.valueOf(this.j));
    paramXmlSerializer.attribute(null, "busiType", String.valueOf(this.k));
    paramXmlSerializer.attribute(null, "recordID", String.valueOf(this.s));
    paramXmlSerializer.attribute(null, "roomID", String.valueOf(this.o));
    paramXmlSerializer.attribute(null, "title", String.valueOf(this.t));
    paramXmlSerializer.endTag(null, "live");
  }
  
  public boolean a(StructMsgNode paramStructMsgNode)
  {
    if (paramStructMsgNode == null) {
      return true;
    }
    this.p = paramStructMsgNode.a("cover");
    this.q = paramStructMsgNode.a("src");
    this.r = paramStructMsgNode.a("video_info");
    this.s = paramStructMsgNode.a("recordID");
    this.o = paramStructMsgNode.a("roomID");
    this.t = paramStructMsgNode.a("title");
    for (;;)
    {
      try
      {
        str = paramStructMsgNode.a("preWidth");
        if (str != null) {
          continue;
        }
        m = 0;
        this.i = m;
      }
      catch (NumberFormatException localNumberFormatException1)
      {
        String str;
        label115:
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.", 2, "try to parse video width in StructMsgItemLive error", localNumberFormatException1);
        continue;
        m = Integer.valueOf(localNumberFormatException1).intValue();
        continue;
      }
      for (;;)
      {
        try
        {
          str = paramStructMsgNode.a("preHeight");
          if (str != null) {
            break label174;
          }
          m = 0;
          this.j = m;
        }
        catch (NumberFormatException localNumberFormatException2)
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("Q.", 2, "try to parse video heiht in StructMsgItemLive error", localNumberFormatException2);
          break;
          m = Integer.valueOf(paramStructMsgNode).intValue();
          break label115;
        }
        try
        {
          paramStructMsgNode = paramStructMsgNode.a("busiType");
          if (paramStructMsgNode != null) {
            continue;
          }
          m = 0;
          this.k = m;
          return true;
        }
        catch (NumberFormatException paramStructMsgNode) {}
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.", 2, "try to parse video sourceType in StructMsgItemLive error", paramStructMsgNode);
      return true;
      m = Integer.valueOf(str).intValue();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\structmsg\StructMsgItemLive.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
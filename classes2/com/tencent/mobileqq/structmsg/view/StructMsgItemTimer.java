package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.structmsg.StructMsgNode;
import com.tencent.mobileqq.structmsg.StructMsgUtils;
import com.tencent.mobileqq.structmsg.widget.CountdownTextView;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.xmlpull.v1.XmlSerializer;
import uwt;
import uwu;

public class StructMsgItemTimer
  extends StructMsgItemSummary
{
  protected long c;
  private String cK;
  private String cL;
  public long d;
  protected long e;
  public boolean e;
  protected int k;
  protected int l;
  
  public StructMsgItemTimer()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = "timer";
  }
  
  public StructMsgItemTimer(String paramString)
  {
    this();
    this.u = paramString;
  }
  
  public StructMsgItemTimer(String paramString1, String paramString2, String paramString3, long paramLong, int paramInt1, int paramInt2)
  {
    this(paramString1);
    a(paramString2, paramString3, paramLong, paramInt1, paramInt2);
  }
  
  private long a()
  {
    if (!this.jdField_e_of_type_Boolean)
    {
      long l1 = MessageCache.a();
      long l2 = this.c + this.k - l1;
      if (l2 < 0L)
      {
        this.jdField_e_of_type_Boolean = true;
        l1 = 0L;
      }
      do
      {
        return l1;
        if (l2 <= 0L) {
          break;
        }
        l1 = l2;
      } while (l2 < this.k);
      return this.k;
      this.jdField_e_of_type_Boolean = true;
      return l2;
    }
    return 0L;
  }
  
  private SpannableStringBuilder a(long paramLong)
  {
    ForegroundColorSpan localForegroundColorSpan = new ForegroundColorSpan(-91585);
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(this.cK);
    localSpannableStringBuilder.append('\n');
    if (paramLong > 0L)
    {
      int i = localSpannableStringBuilder.length();
      String str = String.valueOf(paramLong) + "秒";
      localSpannableStringBuilder.append(str);
      localSpannableStringBuilder.append(this.u);
      localSpannableStringBuilder.setSpan(localForegroundColorSpan, i, str.length() + i, 33);
      return localSpannableStringBuilder;
    }
    localSpannableStringBuilder.append(this.cL);
    return localSpannableStringBuilder;
  }
  
  private void a(String paramString1, String paramString2, long paramLong, int paramInt1, int paramInt2)
  {
    this.cK = paramString1;
    this.cL = paramString2;
    this.c = paramLong;
    this.k = paramInt1;
    this.l = paramInt2;
  }
  
  public View a(Context paramContext, View paramView, Bundle paramBundle)
  {
    if ((paramView != null) && ((paramView instanceof CountdownTextView)))
    {
      paramContext = (CountdownTextView)paramView;
      paramContext.a(a(), new uwt(this, paramContext));
      paramContext.setTag(this);
      return paramContext;
    }
    paramContext = new CountdownTextView(paramContext);
    paramContext.setId(2131296367);
    paramContext.setTag(this);
    paramContext.setMaxLines(3);
    paramContext.setTextColor(-10987432);
    paramContext.setTextSize(2, 12.0F);
    long l1 = a();
    if (this.u != null) {
      paramContext.setText(a(l1));
    }
    paramContext.a(l1, new uwu(this, paramContext));
    return paramContext;
  }
  
  public String a()
  {
    return "Timer";
  }
  
  public void a(ObjectInput paramObjectInput)
  {
    super.a(paramObjectInput);
    this.cK = MessageUtils.a(paramObjectInput.readUTF(), false);
    this.cL = MessageUtils.a(paramObjectInput.readUTF(), false);
    this.c = paramObjectInput.readLong();
    this.k = paramObjectInput.readInt();
    this.l = paramObjectInput.readInt();
    this.d = paramObjectInput.readLong();
    this.jdField_e_of_type_Long = paramObjectInput.readLong();
    this.jdField_e_of_type_Boolean = paramObjectInput.readBoolean();
  }
  
  public void a(ObjectOutput paramObjectOutput)
  {
    super.a(paramObjectOutput);
    if (this.cK == null)
    {
      str = "";
      paramObjectOutput.writeUTF(str);
      if (this.cL != null) {
        break label108;
      }
    }
    label108:
    for (String str = "";; str = this.cL)
    {
      paramObjectOutput.writeUTF(str);
      paramObjectOutput.writeLong(this.c);
      paramObjectOutput.writeInt(this.k);
      paramObjectOutput.writeInt(this.l);
      paramObjectOutput.writeLong(this.d);
      paramObjectOutput.writeLong(this.jdField_e_of_type_Long);
      paramObjectOutput.writeBoolean(this.jdField_e_of_type_Boolean);
      return;
      str = this.cK;
      break;
    }
  }
  
  public void a(XmlSerializer paramXmlSerializer)
  {
    paramXmlSerializer.startTag(null, "timer");
    paramXmlSerializer.attribute(null, "st", String.valueOf(this.c));
    paramXmlSerializer.attribute(null, "dr", String.valueOf(this.k));
    paramXmlSerializer.attribute(null, "index", String.valueOf(this.l));
    if (!TextUtils.isEmpty(this.cK)) {
      paramXmlSerializer.attribute(null, "summary", this.cK);
    }
    if (!TextUtils.isEmpty(this.cL)) {
      paramXmlSerializer.attribute(null, "ending", this.cL);
    }
    paramXmlSerializer.text(this.u);
    paramXmlSerializer.endTag(null, "timer");
  }
  
  public boolean a(StructMsgNode paramStructMsgNode)
  {
    if (paramStructMsgNode == null) {
      return true;
    }
    this.c = StructMsgUtils.a(paramStructMsgNode.a("st"));
    this.k = StructMsgUtils.a(paramStructMsgNode.a("dr"));
    this.l = StructMsgUtils.a(paramStructMsgNode.a("index"));
    this.cK = MessageUtils.a(paramStructMsgNode.a("summary"), false);
    this.cL = MessageUtils.a(paramStructMsgNode.a("st"), false);
    this.u = MessageUtils.a(StructMsgFactory.a(paramStructMsgNode), false);
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\structmsg\view\StructMsgItemTimer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */